package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.mapping.GenSV_KiykHnriknSutugk;
import yuyu.def.db.meta.GenQSV_KiykHnriknSutugk;
import yuyu.def.db.meta.QSV_KiykHnriknSutugk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 解約返戻金相当額情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_KiykHnriknSutugk}</td><td colspan="3">解約返戻金相当額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>kbnkey</td><td>区分キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>fstpnyknymd</td><td>初回保険料入金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>skeikeijyouym</td><td>新契約計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyksei</td><td>契約者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kyksei C_Kyksei}</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>teikishrtkykhukaumu</td><td>定期支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     SV_KiykHnriknSutugk
 * @see     GenSV_KiykHnriknSutugk
 * @see     QSV_KiykHnriknSutugk
 * @see     GenQSV_KiykHnriknSutugk
 */
public class PKSV_KiykHnriknSutugk extends AbstractExDBPrimaryKey<SV_KiykHnriknSutugk, PKSV_KiykHnriknSutugk> {

    private static final long serialVersionUID = 1L;

    public PKSV_KiykHnriknSutugk() {
    }

    public PKSV_KiykHnriknSutugk(String pSyono) {
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<SV_KiykHnriknSutugk> getEntityClass() {
        return SV_KiykHnriknSutugk.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}