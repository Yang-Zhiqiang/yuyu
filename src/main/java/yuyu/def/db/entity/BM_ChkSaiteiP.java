package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.id.PKBM_ChkSaiteiP;
import yuyu.def.db.mapping.GenBM_ChkSaiteiP;
import yuyu.def.db.meta.GenQBM_ChkSaiteiP;
import yuyu.def.db.meta.QBM_ChkSaiteiP;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 最低Ｐチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSaiteiP} の JavaDoc を参照してください。
 * @see     GenBM_ChkSaiteiP
 * @see     PKBM_ChkSaiteiP
 * @see     QBM_ChkSaiteiP
 * @see     GenQBM_ChkSaiteiP
 */
@Entity
public class BM_ChkSaiteiP extends GenBM_ChkSaiteiP {

    private static final long serialVersionUID = 1L;

    public BM_ChkSaiteiP() {
    }

    public BM_ChkSaiteiP(
        String pSyouhncd,
        C_Hrkkaisuu pHrkkaisuu,
        BizNumber pHrkkknfrom,
        BizNumber pHrkkknto,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        C_Tuukasyu pTuukasyu,
        String pSyouhinbetukey1
    ) {
        super(
            pSyouhncd,
            pHrkkaisuu,
            pHrkkknfrom,
            pHrkkknto,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pTuukasyu,
            pSyouhinbetukey1
        );
    }

}
