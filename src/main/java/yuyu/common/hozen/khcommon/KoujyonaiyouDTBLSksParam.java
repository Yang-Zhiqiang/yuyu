package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 控除証明内容Dテーブル作成パラメータ
 */
public class KoujyonaiyouDTBLSksParam {

    private C_UmuKbn zeiseiTkkktkykhukaUmu;

    private IT_KhHaitouKanri khHaitouKanri;

    private IT_KykSyouhn kykSyouhn;

    public C_UmuKbn getZeiseiTkkktkykhukaUmu() {
        return zeiseiTkkktkykhukaUmu;
    }

    public void setZeiseiTkkktkykhukaUmu(C_UmuKbn pZeiseiTkkktkykhukaUmu) {
        zeiseiTkkktkykhukaUmu = pZeiseiTkkktkykhukaUmu;
    }

    public IT_KhHaitouKanri getKhHaitouKanri() {
        return khHaitouKanri;
    }

    public void setKhHaitouKanri(IT_KhHaitouKanri pKhHaitouKanri) {
        khHaitouKanri = pKhHaitouKanri;
    }

    public IT_KykSyouhn getKykSyouhn() {
        return kykSyouhn;
    }

    public void setKykSyouhn(IT_KykSyouhn pKykSyouhn) {
        kykSyouhn = pKykSyouhn;
    }
}
