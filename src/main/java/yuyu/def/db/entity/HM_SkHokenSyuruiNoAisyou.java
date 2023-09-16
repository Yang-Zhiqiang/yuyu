package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.mapping.GenHM_SkHokenSyuruiNoAisyou;

/**
 * 保険種類番号愛称マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkHokenSyuruiNoAisyou} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkHokenSyuruiNoAisyou<br />
 * @see     PKHM_SkHokenSyuruiNoAisyou<br />
 * @see     QHM_SkHokenSyuruiNoAisyou<br />
 * @see     GenQHM_SkHokenSyuruiNoAisyou<br />
 */
@Entity
public class HM_SkHokenSyuruiNoAisyou extends GenHM_SkHokenSyuruiNoAisyou {

    private static final long serialVersionUID = 1L;

    public HM_SkHokenSyuruiNoAisyou() {
    }

    public HM_SkHokenSyuruiNoAisyou(
        C_HknsyuruiNo pHknsyuruino,
        Integer pHknsyuruinosdfrom,
        Integer pHknsyuruinosdto,
        String pHknsyuruinobetukey1,
        C_AisyoumeiChannelKbn pAisyoumeichannelkbn
    ) {
        super(
            pHknsyuruino,
            pHknsyuruinosdfrom,
            pHknsyuruinosdto,
            pHknsyuruinobetukey1,
            pAisyoumeichannelkbn
        );
    }



}

