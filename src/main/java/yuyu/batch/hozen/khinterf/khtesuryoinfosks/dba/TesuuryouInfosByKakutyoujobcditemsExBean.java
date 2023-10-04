package yuyu.batch.hozen.khinterf.khtesuryoinfosks.dba;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcditemsBean;

/**
 * 契約保全 インターフェイス 手数料情報Bean
 */
public class TesuuryouInfosByKakutyoujobcditemsExBean extends TesuuryouInfosByKakutyoujobcditemsBean {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    IT_KykSonotaTkyk kykSonotaTkyk;

    public TesuuryouInfosByKakutyoujobcditemsExBean(IT_Tesuuryou pTesuuryou, IT_TesuuryouSyouhn pTesuuryouSyouhn,
        IT_KykKihon pKykKihon, IT_KykSya pKykSya, IT_HhknSya pHhknSya, IT_KykDairiten pKykDairiten,
        IT_KykSonotaTkyk pKykSonotaTkyk) {
        super(pTesuuryou, pTesuuryouSyouhn, pKykKihon, pKykSya, pHhknSya, pKykDairiten);

        kykSonotaTkyk = pKykSonotaTkyk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}