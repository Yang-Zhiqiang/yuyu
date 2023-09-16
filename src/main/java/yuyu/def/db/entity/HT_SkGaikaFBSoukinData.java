package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.Transient;

import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.db.mapping.GenHT_SkGaikaFBSoukinData;


/**
 * 新契約外貨ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkGaikaFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkGaikaFBSoukinData<br />
 * @see     PKHT_SkGaikaFBSoukinData<br />
 * @see     QHT_SkGaikaFBSoukinData<br />
 * @see     GenQHT_SkGaikaFBSoukinData<br />
 */
@Entity
public class HT_SkGaikaFBSoukinData extends GenHT_SkGaikaFBSoukinData implements GkFBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public HT_SkGaikaFBSoukinData() {
    }

    public HT_SkGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        super(pFbsoukindatasikibetukey);
    }

    @Override
    @Transient
    public String getSyono() {
        return getMosno();
    }

    @Override
    @Transient
    public void setSyono(String pSyono) {
        setMosno(pSyono);
    }

}

