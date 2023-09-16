package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.id.PKBM_ChkJhSaiteiP;
import yuyu.def.db.mapping.GenBM_ChkJhSaiteiP;
import yuyu.def.db.meta.GenQBM_ChkJhSaiteiP;
import yuyu.def.db.meta.QBM_ChkJhSaiteiP;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 最低Ｐ事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhSaiteiP} の JavaDoc を参照してください。
 * @see     GenBM_ChkJhSaiteiP
 * @see     PKBM_ChkJhSaiteiP
 * @see     QBM_ChkJhSaiteiP
 * @see     GenQBM_ChkJhSaiteiP
 */
@Entity
public class BM_ChkJhSaiteiP extends GenBM_ChkJhSaiteiP {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhSaiteiP() {
    }

    public BM_ChkJhSaiteiP(
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
