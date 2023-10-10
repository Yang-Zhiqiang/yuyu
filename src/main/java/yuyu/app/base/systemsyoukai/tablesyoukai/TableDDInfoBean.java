package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.io.Serializable;

import lombok.Data;

@Data
public class TableDDInfoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    public TableDDInfoBean(String pDdNm, Class<?> pType){
        this.ddNm = pDdNm;
        this.type = pType;
    }

    private String ddNm;
    private Class<?> type;
}
