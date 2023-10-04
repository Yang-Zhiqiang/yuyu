package yuyu.batch.hozen.khinterf.khginkoumdhnmisyuuinfofilesks.dba;

import java.io.Serializable;

import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 銀行窓販未収情報Beanクラス
 */
@AllArgsConstructor
public class KhGinkouMdhnMisyuuInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate datarenymd;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private String gwbsydrtencd;

    @Getter @Setter
    private String gwdatakbn;

    @Getter @Setter
    private String gwdatasakuseiymd;

    @Getter @Setter
    private String gwhknkaisyacd;

    @Getter @Setter
    private String gwhknsyuruicd;

    @Getter @Setter
    private String gwsyonosyuban;

    @Getter @Setter
    private String gwmisyuutatekaekbn;

    @Getter @Setter
    private String gwmisyuutatekaeym;

    @Getter @Setter
    private String gwmisyuukg;

    @Getter @Setter
    private String gwbnkaisuu;

    @Getter @Setter
    private String gwmisyuujiyuu;

    @Getter @Setter
    private String gwjikaidatakousinymd;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Getter @Setter
    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuukbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
