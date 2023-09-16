package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.Transient;

import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.db.mapping.GenHT_SkFBSoukinData;


/**
 * 新契約ＦＢ送金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkFBSoukinData} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkFBSoukinData<br />
 * @see     PKHT_SkFBSoukinData<br />
 * @see     QHT_SkFBSoukinData<br />
 * @see     GenQHT_SkFBSoukinData<br />
 */
@Entity
public class HT_SkFBSoukinData extends GenHT_SkFBSoukinData implements FBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public HT_SkFBSoukinData() {
    }

    public HT_SkFBSoukinData(String pFbsoukindatasikibetukey) {
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

