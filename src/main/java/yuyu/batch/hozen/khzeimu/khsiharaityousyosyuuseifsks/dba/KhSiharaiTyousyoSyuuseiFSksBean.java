package yuyu.batch.hozen.khzeimu.khsiharaityousyosyuuseifsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 新契約 Ｄ精算支払調書修正対象Beanクラスです。
 */
public class KhSiharaiTyousyoSyuuseiFSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private BizDate seisandshrymd;

    @Getter @Setter
    private BizCurrency seisand;

    @Getter @Setter
    private BizCurrency tyouseid;

    public KhSiharaiTyousyoSyuuseiFSksBean(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd,
        BizDate pSeisandshrymd,
        String pSeisandkgk ,
        BigDecimal pSeisandType,
        String pTyouseidkgk,
        BigDecimal pTyouseidType) {

        kbnkey = pKbnkey;
        syono = pSyono;
        syoriYmd = pSyoriYmd;
        seisandshrymd = pSeisandshrymd;
        seisand = new BizCurrencySum(pSeisandkgk, pSeisandType).toBizCurrency();
        tyouseid = new BizCurrencySum(pTyouseidkgk, pTyouseidType).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}