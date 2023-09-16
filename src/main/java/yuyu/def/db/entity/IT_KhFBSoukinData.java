package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.db.mapping.GenIT_KhFBSoukinData;


/**
 * 契約保全ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhFBSoukinData<br />
 * @see     PKIT_KhFBSoukinData<br />
 * @see     QIT_KhFBSoukinData<br />
 * @see     GenQIT_KhFBSoukinData<br />
 */
@Entity
public class IT_KhFBSoukinData extends GenIT_KhFBSoukinData implements FBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public IT_KhFBSoukinData() {
    }

    public IT_KhFBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



}

