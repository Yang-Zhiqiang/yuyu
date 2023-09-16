package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIT_BAK_KhFBSoukinData;


/**
 * 契約保全ＦＢ送金データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhFBSoukinData<br />
 * @see     PKIT_BAK_KhFBSoukinData<br />
 * @see     QIT_BAK_KhFBSoukinData<br />
 * @see     GenQIT_BAK_KhFBSoukinData<br />
 */
@Entity
public class IT_BAK_KhFBSoukinData extends GenIT_BAK_KhFBSoukinData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhFBSoukinData() {
    }

    public IT_BAK_KhFBSoukinData(String pFbsoukindatasikibetukey,String pTrkssikibetukey) {
        super(pFbsoukindatasikibetukey,pTrkssikibetukey);
    }



}

