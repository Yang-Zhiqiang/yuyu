package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.db.mapping.GenJT_SiFBSoukinData;


/**
 * 支払ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiFBSoukinData<br />
 * @see     PKJT_SiFBSoukinData<br />
 * @see     QJT_SiFBSoukinData<br />
 * @see     GenQJT_SiFBSoukinData<br />
 */
@Entity
public class JT_SiFBSoukinData extends GenJT_SiFBSoukinData implements FBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public JT_SiFBSoukinData() {
    }

    public JT_SiFBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



}

