package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.mapping.GenSV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.meta.GenQSV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.meta.QSV_RisanomiTuujyuHitusyyugk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 利差のみ通常配当所要額情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_RisanomiTuujyuHitusyyugk}</td><td colspan="3">利差のみ通常配当所要額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>kbnkey</td><td>区分キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>skeikeijyouym</td><td>新契約計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>fstpnyknymd</td><td>初回保険料入金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yendthnkymd</td><td>円建変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>syuusinhknumu</td><td>終身保険有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mvatekikkn</td><td>ＭＶＡ適用期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teikishrtkykhukaumu</td><td>定期支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 * </table>
 * @see     SV_RisanomiTuujyuHitusyyugk
 * @see     GenSV_RisanomiTuujyuHitusyyugk
 * @see     QSV_RisanomiTuujyuHitusyyugk
 * @see     GenQSV_RisanomiTuujyuHitusyyugk
 */
public class PKSV_RisanomiTuujyuHitusyyugk extends AbstractExDBPrimaryKey<SV_RisanomiTuujyuHitusyyugk, PKSV_RisanomiTuujyuHitusyyugk> {

    private static final long serialVersionUID = 1L;

    public PKSV_RisanomiTuujyuHitusyyugk() {
    }

    public PKSV_RisanomiTuujyuHitusyyugk(
        String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        syono = pSyono;
        syutkkbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Transient
    @Override
    public Class<SV_RisanomiTuujyuHitusyyugk> getEntityClass() {
        return SV_RisanomiTuujyuHitusyyugk.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private C_SyutkKbn syutkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SyutkKbn")
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }
    private Integer kyksyouhnrenno;

    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

}