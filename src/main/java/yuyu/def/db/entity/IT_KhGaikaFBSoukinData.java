package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.db.mapping.GenIT_KhGaikaFBSoukinData;


/**
 * 契約保全外貨ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhGaikaFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhGaikaFBSoukinData<br />
 * @see     PKIT_KhGaikaFBSoukinData<br />
 * @see     QIT_KhGaikaFBSoukinData<br />
 * @see     GenQIT_KhGaikaFBSoukinData<br />
 */
@Entity
public class IT_KhGaikaFBSoukinData extends GenIT_KhGaikaFBSoukinData implements GkFBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public IT_KhGaikaFBSoukinData() {
    }

    public IT_KhGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



}

