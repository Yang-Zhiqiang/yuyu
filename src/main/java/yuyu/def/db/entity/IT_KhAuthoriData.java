package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_KhAuthoriData;


/**
 * オーソリデータテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhAuthoriData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhAuthoriData<br />
 * @see     PKIT_KhAuthoriData<br />
 * @see     QIT_KhAuthoriData<br />
 * @see     GenQIT_KhAuthoriData<br />
 */
@Entity
public class IT_KhAuthoriData extends GenIT_KhAuthoriData {

    private static final long serialVersionUID = 1L;

    public IT_KhAuthoriData() {
    }

    public IT_KhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono,Integer pAuthorikaisuu) {
        super(pAnsyuusyskbn,pSyoriYmd,pSyono,pAuthorikaisuu);
    }



}

