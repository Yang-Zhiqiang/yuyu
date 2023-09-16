package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.db.mapping.GenJT_SiGaikaFBSoukinData;


/**
 * 支払外貨ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiGaikaFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiGaikaFBSoukinData<br />
 * @see     PKJT_SiGaikaFBSoukinData<br />
 * @see     QJT_SiGaikaFBSoukinData<br />
 * @see     GenQJT_SiGaikaFBSoukinData<br />
 */
@Entity
public class JT_SiGaikaFBSoukinData extends GenJT_SiGaikaFBSoukinData implements GkFBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public JT_SiGaikaFBSoukinData() {
    }

    public JT_SiGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }



}

