package view;

import java.util.ArrayList;
import java.util.HashMap;

import dbmanager.AccessManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.SyuukanModel;

public  class HistoryView extends BaseView{
	public HistoryView() {
		super("History.fxml");

	}
	@Override
	public void Init() {

		AccessManager dbm = new AccessManager("db.accdb");
        String sql = "SELECT * FROM HistoryTable";
        String[] columns = { "ID","aim","enthusiasm", "kaisuu" };
        ArrayList<HashMap<String, String>> result = dbm.select(sql, columns);
        TableView tv = (TableView) getPane().lookup("#tvspotlist");
        ObservableList<SyuukanModel> data;
        data = FXCollections.observableArrayList();
        for (HashMap<String, String> record : result) {
        	SyuukanModel recordData = new SyuukanModel();
            int i = Integer.parseInt(record.get("ID"));
            System.out.println("ID"+record.get("ID"));
			int a;
			if(record.get("kaisuu") == null ) {
				a = 0;
			}else {
				a =  Integer.parseInt(record.get("kaisuu"));
			}
            recordData.setID(i);
            recordData.setTarget(record.get("aim"));
            recordData.setEnthusiasm(record.get("enthusiasm"));
            recordData.setKaisuu(a);

            data.add(recordData);

        }
        ObservableList<TableColumn> Column = tv.getColumns();
        TableColumn IDCol = Column.get(0);
        IDCol.setCellValueFactory(new PropertyValueFactory<SyuukanModel, String>("ID"));
        TableColumn aimCol = Column.get(1);
        aimCol.setCellValueFactory(new PropertyValueFactory<SyuukanModel, String>("Target"));
        TableColumn  enthusiasmCol=Column.get(2);
        enthusiasmCol.setCellValueFactory(new PropertyValueFactory<SyuukanModel, String>("Enthusiasm"));
        TableColumn kaisuuCol = Column.get(3);
        kaisuuCol.setCellValueFactory(new PropertyValueFactory<SyuukanModel, String>("Kaisuu"));

        for (SyuukanModel model : data) {
            tv.getItems().add(model);
        }




	}


}
