package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_KhUriageData;


/**
 * 売上データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhUriageData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhUriageData<br />
 * @see     PKIT_KhUriageData<br />
 * @see     QIT_KhUriageData<br />
 * @see     GenQIT_KhUriageData<br />
 */
@Entity
public class IT_KhUriageData extends GenIT_KhUriageData {

    private static final long serialVersionUID = 1L;

    public IT_KhUriageData() {
    }

    public IT_KhUriageData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono,Integer pAuthorikaisuu) {
        super(pAnsyuusyskbn,pSyoriYmd,pSyono,pAuthorikaisuu);
    }



}

