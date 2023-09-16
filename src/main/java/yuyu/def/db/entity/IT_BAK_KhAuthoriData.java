package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_BAK_KhAuthoriData;


/**
 * オーソリデータバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhAuthoriData} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhAuthoriData<br />
 * @see     PKIT_BAK_KhAuthoriData<br />
 * @see     QIT_BAK_KhAuthoriData<br />
 * @see     GenQIT_BAK_KhAuthoriData<br />
 */
@Entity
public class IT_BAK_KhAuthoriData extends GenIT_BAK_KhAuthoriData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhAuthoriData() {
    }

    public IT_BAK_KhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn,String pTrkssikibetukey,BizDate pSyoriYmd,String pSyono,Integer pAuthorikaisuu) {
        super(pAnsyuusyskbn,pTrkssikibetukey,pSyoriYmd,pSyono,pAuthorikaisuu);
    }



}

