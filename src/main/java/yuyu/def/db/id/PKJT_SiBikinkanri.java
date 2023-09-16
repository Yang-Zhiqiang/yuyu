package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.mapping.GenJT_SiBikinkanri;
import yuyu.def.db.meta.GenQJT_SiBikinkanri;
import yuyu.def.db.meta.QJT_SiBikinkanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金備金管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiBikinkanri}</td><td colspan="3">保険金給付金備金管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bknrigikbn</td><td>備金例外区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknrigiKbn C_BknrigiKbn}</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hubikanryouymd</td><td>不備完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouhnsyuruikbn</td><td>商品種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyouhnsyuruiKbn C_SyouhnsyuruiKbn}</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>sisyacd</td><td>支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeirisegcd</td><td>区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyuuhuname</td><td>給付名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bkngk</td><td>備金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrumu</td><td>支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sinsaumukbn</td><td>診査有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>soukiumukbn</td><td>早期有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syoumetuumukbn</td><td>消滅有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hubijyoukyoukbn</td><td>不備状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HubiJyoukyouKbn C_HubiJyoukyouKbn}</td></tr>
 *  <tr><td>bknjkukbn</td><td>備金時効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknJkuKbn C_BknJkuKbn}</td></tr>
 *  <tr><td>shrsyoriymd</td><td>支払処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrgk</td><td>支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrkwsratekjnymd</td><td>支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sitihsyutkyumaeyenhknkngk</td><td>最低保証適用前円換算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>siboukaritrkymd</td><td>死亡仮受付登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>hushrgeninkbn</td><td>不支払原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HushrGeninKbn C_HushrGeninKbn}</td></tr>
 *  <tr><td>siinkbn</td><td>死因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiinKbn C_SiinKbn}</td></tr>
 *  <tr><td>kinoussnm</td><td>機能詳細名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>suketorihouhoukbn</td><td>保険金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SUketoriHouhouKbn C_SUketoriHouhouKbn}</td></tr>
 *  <tr><td>tutakngk</td><td>積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yentutakngk</td><td>円換算積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhr</td><td>解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaiyakuhr</td><td>円換算解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gengkumukbn</td><td>減額有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>gengkymd</td><td>減額日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jisatumensekiumukbn</td><td>自殺免責有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syuukeiyoubkncdkbn</td><td>集計用備金コード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BkncdKbn C_BkncdKbn}</td></tr>
 *  <tr><td>hokenkinsyuruikbn</td><td>保険金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HokenkinsyuruiKbn C_HokenkinsyuruiKbn}</td></tr>
 *  <tr><td>bkntyousafsyorikbn</td><td>備金調査ファイル処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknTyousaFSyoriKbn C_BknTyousaFSyoriKbn}</td></tr>
 *  <tr><td>bknkktinnd</td><td>備金確定年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bknkktiym</td><td>備金確定年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennouseisankinumukbn</td><td>前納精算金有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zennouseisankgk</td><td>前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkazennouseisankgk</td><td>円貨前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mikeikapumukbn</td><td>未経過保険料有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mikeikap</td><td>未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamikeikap</td><td>円貨未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuupumukbn</td><td>未収保険料有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>misyuupjyuutouym</td><td>未収保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuup</td><td>未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamisyuup</td><td>円貨未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>syonendojikaiikoup</td><td>初年度次回以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkasyonendojikaiikoup</td><td>円貨初年度次回以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jinendoikoup</td><td>次年度以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkajinendoikoup</td><td>円貨次年度以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seisankgk</td><td>精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaseisankgk</td><td>円貨精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>msyupknrtuukakbn</td><td>未収Ｐ管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>mikeikapknrtuukakbn</td><td>未経過Ｐ管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>znnusisnkinknrtuukakbn</td><td>前納精算金管理通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisankinKanritukaKbn C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiBikinkanri
 * @see     GenJT_SiBikinkanri
 * @see     QJT_SiBikinkanri
 * @see     GenQJT_SiBikinkanri
 */
public class PKJT_SiBikinkanri extends AbstractExDBPrimaryKey<JT_SiBikinkanri, PKJT_SiBikinkanri> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiBikinkanri() {
    }

    public PKJT_SiBikinkanri(
        String pSkno,
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        String pKyuuhucd
    ) {
        skno = pSkno;
        syono = pSyono;
        kessankijyunymd = pKessankijyunymd;
        bkncdkbn = pBkncdkbn;
        bknkktymd = pBknkktymd;
        kyuuhucd = pKyuuhucd;
    }

    @Transient
    @Override
    public Class<JT_SiBikinkanri> getEntityClass() {
        return JT_SiBikinkanri.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate kessankijyunymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }
    private C_BkncdKbn bkncdkbn;

    @org.hibernate.annotations.Type(type="UserType_C_BkncdKbn")
    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }
    private BizDate bknkktymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
    }
    private String kyuuhucd;

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

}