package yuyu.batch.hozen.khinterf.khkijitutouraiannaifsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 インターフェイス 期日到来案内F作成Beanクラス
 */
@AllArgsConstructor
public class KhKijitutouraiAnnaiFSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tyouhyouymd;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private String shskyno;

    @Getter @Setter
    private String shsadr1kj;

    @Getter @Setter
    private String shsadr2kj;

    @Getter @Setter
    private String shsadr3kj;

    @Getter @Setter
    private String shsnmkj;

    @Getter @Setter
    private String toiawasesosikinmkj;

    @Getter @Setter
    private String toiawaseyno;

    @Getter @Setter
    private String toiawaseadr1kj;

    @Getter @Setter
    private String toiawaseadr2kj;

    @Getter @Setter
    private String toiawaseadr3kj;

    @Getter @Setter
    private String toiawasetelno;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmkj2;

    @Getter @Setter
    private String toiawasetelno2;

    @Getter @Setter
    private String tuutinm20keta;

    @Getter @Setter
    private String hrkykkmsg32keta1;

    @Getter @Setter
    private String hrkykkmsg32keta2;

    @Getter @Setter
    private String hrkykkmsg32keta3;

    @Getter @Setter
    private String hrkykkmsg32keta4;

    @Getter @Setter
    private String hrkykkmsg32keta5;

    @Getter @Setter
    private String hrkykkmsg32keta6;

    @Getter @Setter
    private String hrkykkmsg32keta7;

    @Getter @Setter
    private String hrkykkmsg32keta8;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro ;

    @Getter @Setter
    private String syouhnnm;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private String kjttrnnfreearea1;

    @Getter @Setter
    private String kjttrnnfreearea2;

    @Getter @Setter
    private String kjttrnnfreearea3;

    @Getter @Setter
    private String kjttrnnfreearea4;

    @Getter @Setter
    private String kjttrnnfreearea5;

    @Getter @Setter
    private String kjttrnnfreearea6;

    @Getter @Setter
    private String kjttrnnfreearea7;

    @Getter @Setter
    private BizDate hurikaeymd;

    @Getter @Setter
    private String kzinfo1;

    @Getter @Setter
    private String kzinfo2;

    @Getter @Setter
    private String kzinfo3;

    @Getter @Setter
    private String kzinfo4;

    @Getter @Setter
    private String kzinfo5;

    @Getter @Setter
    private String kzinfo6;

    @Getter @Setter
    private String kzinfo7;

    @Getter @Setter
    private String kzinfo8;

    @Getter @Setter
    private String hknjytukikan;

    @Getter @Setter
    private String hrkgk1;

    @Getter @Setter
    private String hrkgk2;

    @Getter @Setter
    private String hrkgk3;

    @Getter @Setter
    private String hrkgk4;

    @Getter @Setter
    private String kjttrnnfreearea8;

    @Getter @Setter
    private String kjttrnnfreearea9;

    @Getter @Setter
    private String kjttrnnfreearea10;

    @Getter @Setter
    private String kjttrnnfreearea11;

    @Getter @Setter
    private String kjttrnnfreearea12;

    @Getter @Setter
    private String kjttrnnfreearea13;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
