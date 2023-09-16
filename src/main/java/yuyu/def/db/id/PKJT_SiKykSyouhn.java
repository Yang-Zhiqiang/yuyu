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
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.mapping.GenJT_SiKykSyouhn;
import yuyu.def.db.meta.GenQJT_SiKykSyouhn;
import yuyu.def.db.meta.QJT_SiKykSyouhn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払契約商品テーブル（物理テーブルなし） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiKykSyouhn}</td><td colspan="3">支払契約商品テーブル（物理テーブルなし）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnnm</td><td>商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmgm</td><td>商品名（画面用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmtyhy</td><td>商品名（帳票用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyhkinkatakbn</td><td>手術給付金型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>khnkyhkgbairitukbn</td><td>基本給付金額倍率区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KhnkyhkgbairituKbn C_KhnkyhkgbairituKbn}</td></tr>
 *  <tr><td>rokudaildkbn</td><td>６大生活習慣病追加給付型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>pmnjtkkbn</td><td>保険料免除特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmnjtkKbn C_PmnjtkKbn}</td></tr>
 *  <tr><td>yuukoukikanfrom</td><td>有効期間（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yuukoukikanto</td><td>有効期間（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gansknnkaisiymd</td><td>がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hkgansknnkaisiymd</td><td>復活がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yendthnkymd</td><td>円建変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykage</td><td>加入年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkknsmnkbn</td><td>保険期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkknmanryouymd</td><td>保険期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkkknsmnkbn</td><td>払込期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkknmnryymd</td><td>払込期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kihonsntgkumu</td><td>基本Ｓ日額有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>katakbn</td><td>型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>tkjyhyouten</td><td>特条標点</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkjyhyouten C_Tkjyhyouten}</td></tr>
 *  <tr><td>tkjyp</td><td>特条保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkjyskgnkkn</td><td>特条削減期間</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkjyskgnkkn C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>htnpbuicd1</td><td>不担保部位コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn1</td><td>不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd2</td><td>不担保部位コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn2</td><td>不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd3</td><td>不担保部位コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn3</td><td>不担保期間３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd4</td><td>不担保部位コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn4</td><td>不担保期間４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>tokkoudosghtnpkbn</td><td>特定高度障害不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokkoudosghtnpKbn C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>kyksjkkktyouseiriritu</td><td>契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yoteirrthendohosyurrt</td><td>予定利率変動時保証利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitateriritu</td><td>積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknitenymd</td><td>積立金移転日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiKykSyouhn
 * @see     GenJT_SiKykSyouhn
 * @see     QJT_SiKykSyouhn
 * @see     GenQJT_SiKykSyouhn
 */
public class PKJT_SiKykSyouhn extends AbstractExDBPrimaryKey<JT_SiKykSyouhn, PKJT_SiKykSyouhn> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiKykSyouhn() {
    }

    public PKJT_SiKykSyouhn(
        String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        syono = pSyono;
        syutkkbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        kyhgndkatakbn = pKyhgndkatakbn;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Transient
    @Override
    public Class<JT_SiKykSyouhn> getEntityClass() {
        return JT_SiKykSyouhn.class;
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
    private C_KyhgndkataKbn kyhgndkatakbn;

    @org.hibernate.annotations.Type(type="UserType_C_KyhgndkataKbn")
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return kyhgndkatakbn;
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        kyhgndkatakbn = pKyhgndkatakbn;
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