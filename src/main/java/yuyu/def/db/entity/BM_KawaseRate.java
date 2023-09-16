package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenBM_KawaseRate;


/**
 * 為替レートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KawaseRate} の JavaDoc を参照してください。<br />
 * @see     GenBM_KawaseRate<br />
 * @see     PKBM_KawaseRate<br />
 * @see     QBM_KawaseRate<br />
 * @see     GenQBM_KawaseRate<br />
 */
@Entity
public class BM_KawaseRate extends GenBM_KawaseRate {

    private static final long serialVersionUID = 1L;

    public BM_KawaseRate() {
    }

    public BM_KawaseRate(BizDate pKwsratekjymd,C_KwsrendouKbn pKwsrendoukbn,C_Tuukasyu pMototuuka,C_Tuukasyu pKanzantuuka,C_KawasetekiyoKbn pKawasetekiyokbn,C_KawasetsryKbn pKawasetsrykbn) {
        super(pKwsratekjymd,pKwsrendoukbn,pMototuuka,pKanzantuuka,pKawasetekiyokbn,pKawasetsrykbn);
    }



}

