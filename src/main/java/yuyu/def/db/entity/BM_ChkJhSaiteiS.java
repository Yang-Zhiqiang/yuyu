package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.ChkSaiteiSParam;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.id.PKBM_ChkJhSaiteiS;
import yuyu.def.db.mapping.GenBM_ChkJhSaiteiS;
import yuyu.def.db.meta.GenQBM_ChkJhSaiteiS;
import yuyu.def.db.meta.QBM_ChkJhSaiteiS;

/**
 * 最低Ｓ事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhSaiteiS} の JavaDoc を参照してください。
 * @see     GenBM_ChkJhSaiteiS
 * @see     PKBM_ChkJhSaiteiS
 * @see     QBM_ChkJhSaiteiS
 * @see     GenQBM_ChkJhSaiteiS
 */
@Entity
public class BM_ChkJhSaiteiS extends GenBM_ChkJhSaiteiS implements ChkSaiteiSParam {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhSaiteiS() {
    }

    public BM_ChkJhSaiteiS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pDntsdnumufrom,
        Integer pDntsdnumuto,
        Integer pHrkkknsmnkbnfrom,
        Integer pHrkkknsmnkbnto,
        BizNumber pHknkknfrom,
        BizNumber pHknkknto,
        Integer pSaiteisknwtkumufrom,
        Integer pSaiteisknwtkumuto,
        C_Tuukasyu pTuukasyu
        ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pDntsdnumufrom,
            pDntsdnumuto,
            pHrkkknsmnkbnfrom,
            pHrkkknsmnkbnto,
            pHknkknfrom,
            pHknkknto,
            pSaiteisknwtkumufrom,
            pSaiteisknwtkumuto,
            pTuukasyu
            );
    }

}
