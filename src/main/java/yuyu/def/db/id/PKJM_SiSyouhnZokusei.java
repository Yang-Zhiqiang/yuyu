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
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.mapping.GenJM_SiSyouhnZokusei;
import yuyu.def.db.meta.GenQJM_SiSyouhnZokusei;
import yuyu.def.db.meta.QJM_SiSyouhnZokusei;

/**
 * 支払商品属性マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiSyouhnZokusei}</td><td colspan="3">支払商品属性マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syouhnnm</td><td>商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmgm</td><td>商品名（画面用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmtyhy</td><td>商品名（帳票用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taisyoukkngaishrkahikbn</td><td>対象期間外支払可否区分</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>byoumeisetteikbn</td><td>病名設定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>shrjiyuu</td><td>支払事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoumetuumukbn</td><td>消滅有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>taisyoukknmae</td><td>対象期間（前）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taisyoukknato</td><td>対象期間（後）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrtaisyounissuu</td><td>支払対象日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrtaisyounyuuinnissuu</td><td>支払対象入院日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hutanponissuu</td><td>不担保日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>itinyuuingendonissuu</td><td>１入院限度日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyhgendonissuu</td><td>給付限度日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tuusangendonissuu</td><td>通算限度日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tuusangendokaisuu</td><td>通算限度回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tuusangendogaku</td><td>通算限度額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>betusippeihanteinissuu</td><td>別疾病判定日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nitigakurate</td><td>日額率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>nitigakuhokenkngkkbn</td><td>日額・保険金額区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NitigakuHokenKngkKbn C_NitigakuHokenKngkKbn}</td></tr>
 *  <tr><td>kyhkintanikbn</td><td>給付金単位区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhkinTaniKbn C_KyhkinTaniKbn}</td></tr>
 *  <tr><td>shrbairitu</td><td>支払倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>jisatumensekinensuu</td><td>自殺免責年数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>manryoumaetukisuu</td><td>満了前月数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tyouhyouhyoujikbn</td><td>帳票表示区分</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nyuuinitijikinumukbn</td><td>入院一時金有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sensinitijikinumukbn</td><td>先進医療一時金有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>itijikngk</td><td>一時金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyhkintaisyouumukbn</td><td>給付金対象有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kdhokenkintaisyouumukbn</td><td>高度障害保険金対象有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pmtaisyouumukbn</td><td>Ｐ免対象有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sbjishrkbn</td><td>死亡時支払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SbjiShrKbn C_SbjiShrKbn}</td></tr>
 *  <tr><td>sbmensekitaisyouumukbn</td><td>死亡免責対象有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kyhntgkkatacalcumukbn</td><td>給付日額型計算有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>shrsakugenkknumukbn</td><td>支払削減期間有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>misyuumikeikadoujiumukbn</td><td>未収未経過同時発生有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hokenkngknitigakumsg1</td><td>保険金額日額文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokenkngknitigakumsg2</td><td>保険金額日額文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lnmaxkngk</td><td>ＬＮ上限金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lnminkngk</td><td>ＬＮ下限金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lnseikyuutanisenyen</td><td>ＬＮ請求単位（千円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>calckijyunmiraibicheck</td><td>計算基準未来日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>psoutougkhyoujiumu</td><td>保険料相当額表示有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tmttkngkhyoujiumu</td><td>積立金額表示有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kaiyakuhrhyoujiumu</td><td>解約返戻金表示有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kihonshyoujiumu</td><td>基本保険金額表示有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>saigaishyoujiumu</td><td>災害保険金額表示有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>msyupknrtuukakbn</td><td>未収Ｐ管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>mikeikapknrtuukakbn</td><td>未経過Ｐ管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>znnusisnkinknrtuukakbn</td><td>前納精算金管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>krkinknrtuukakbn</td><td>仮受金管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 * </table>
 * @see     JM_SiSyouhnZokusei
 * @see     GenJM_SiSyouhnZokusei
 * @see     QJM_SiSyouhnZokusei
 * @see     GenQJM_SiSyouhnZokusei
 */
public class PKJM_SiSyouhnZokusei extends AbstractExDBPrimaryKey<JM_SiSyouhnZokusei, PKJM_SiSyouhnZokusei> {

    private static final long serialVersionUID = 1L;

    public PKJM_SiSyouhnZokusei() {
    }

    public PKJM_SiSyouhnZokusei(
        String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        String pKyuuhucd
    ) {
        syouhncd = pSyouhncd;
        kyhgndkatakbn = pKyhgndkatakbn;
        syouhnsdno = pSyouhnsdno;
        kyuuhucd = pKyuuhucd;
    }

    @Transient
    @Override
    public Class<JM_SiSyouhnZokusei> getEntityClass() {
        return JM_SiSyouhnZokusei.class;
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
    private String kyuuhucd;

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

}