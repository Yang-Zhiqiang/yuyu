package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIT_BAK_KhGaikaFBSoukinData;


/**
 * 契約保全外貨ＦＢ送金データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhGaikaFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhGaikaFBSoukinData<br />
 * @see     PKIT_BAK_KhGaikaFBSoukinData<br />
 * @see     QIT_BAK_KhGaikaFBSoukinData<br />
 * @see     GenQIT_BAK_KhGaikaFBSoukinData<br />
 */
@Entity
public class IT_BAK_KhGaikaFBSoukinData extends GenIT_BAK_KhGaikaFBSoukinData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhGaikaFBSoukinData() {
    }

    public IT_BAK_KhGaikaFBSoukinData(String pFbsoukindatasikibetukey,String pTrkssikibetukey) {
        super(pFbsoukindatasikibetukey,pTrkssikibetukey);
    }



}

