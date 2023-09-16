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
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.mapping.GenJT_SiKekka;
import yuyu.def.db.meta.GenQJT_SiKekka;
import yuyu.def.db.meta.QJT_SiKekka;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払処理結果テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiKekka}</td><td colspan="3">支払処理結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getShiharaikekkadatakbn shiharaikekkadatakbn}</td><td>支払結果データ区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_ShiharaikekkadataKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>nexthrkym</td><td>次回払込年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>gansindankakuteiymd</td><td>がん診断確定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>krkgk</td><td>仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>misyuumikeikakbn</td><td>未収未経過区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MisyuumikeikaKbn C_MisyuumikeikaKbn}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>seisanpgoukei</td><td>精算保険料合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hushrgeninkbn</td><td>不支払原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HushrGeninKbn C_HushrGeninKbn}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennouseisankgk</td><td>前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouseisankgkshrtk</td><td>前納精算金額（支払通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingksiteituuka</td><td>税適預り金額（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingkyen</td><td>税適預り金額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrkwsratekjnymd</td><td>支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zeimukwsrate</td><td>税務用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiKekka
 * @see     GenJT_SiKekka
 * @see     QJT_SiKekka
 * @see     GenQJT_SiKekka
 */
public class PKJT_SiKekka extends AbstractExDBPrimaryKey<JT_SiKekka, PKJT_SiKekka> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiKekka() {
    }

    public PKJT_SiKekka(
        C_ShiharaikekkadataKbn pShiharaikekkadatakbn,
        String pSyono,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        C_SyutkKbn pSyutkkbn
    ) {
        shiharaikekkadatakbn = pShiharaikekkadatakbn;
        syono = pSyono;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
        syutkkbn = pSyutkkbn;
    }

    @Transient
    @Override
    public Class<JT_SiKekka> getEntityClass() {
        return JT_SiKekka.class;
    }

    private C_ShiharaikekkadataKbn shiharaikekkadatakbn;

    @org.hibernate.annotations.Type(type="UserType_C_ShiharaikekkadataKbn")
    public C_ShiharaikekkadataKbn getShiharaikekkadatakbn() {
        return shiharaikekkadatakbn;
    }

    public void setShiharaikekkadatakbn(C_ShiharaikekkadataKbn pShiharaikekkadatakbn) {
        shiharaikekkadatakbn = pShiharaikekkadatakbn;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
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
    private C_SyutkKbn syutkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SyutkKbn")
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

}