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
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.mapping.GenIT_KoujyoSym;
import yuyu.def.db.meta.GenQIT_KoujyoSym;
import yuyu.def.db.meta.QIT_KoujyoSym;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明書テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KoujyoSym}</td><td colspan="3">控除証明書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNendo nendo}</td><td>年度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjsmsakuseisyorikbn</td><td>控除証明作成処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn C_KoujyosyoumeisakuseisyoriKbn}</td></tr>
 *  <tr><td>tekiyouseidokbn</td><td>適用制度区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TekiyouseidoKbn C_TekiyouseidoKbn}</td></tr>
 *  <tr><td>syoumeiymd</td><td>証明日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoumeistartym</td><td>証明開始年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoumeiendym</td><td>証明終了年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoumeikkntukisuu</td><td>証明期間月数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoumeikknnensuu</td><td>証明期間年数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkjaddsama</td><td>受取人名（漢字／様付加）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinuktseiymd</td><td>年金受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknsyuruinmrykkj</td><td>保険種類略称（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknkknsmnkbnsyu</td><td>保険期間歳満期区分（主契約）</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsyu</td><td>保険期間（主契約）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>nenkanhrkkaisuu</td><td>年間払込回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>phrkkkn</td><td>保険料払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nkshrstartymd</td><td>年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nknshry</td><td>年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykjyoutai</td><td>契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykjyoutai C_Kykjyoutai}</td></tr>
 *  <tr><td>yuukousyoumetukbn</td><td>有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukousyoumetuKbn C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>haitoukinuketorihoukbn</td><td>配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinuketorihouKbn C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>oldippanjissekip</td><td>旧制度一般実績保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldippannenkanp</td><td>旧制度一般年間保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldippanjissekihaitoukin</td><td>旧制度一般実績配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldippannenkanhaitoukin</td><td>旧制度一般年間配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldippanjissekisyoumeigk</td><td>旧制度一般実績証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldippannenkansyoumeigk</td><td>旧制度一般年間証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newippanjissekip</td><td>新制度一般実績保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newippannenkanp</td><td>新制度一般年間保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newippanjissekihaitoukin</td><td>新制度一般実績配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newippannenkanhaitoukin</td><td>新制度一般年間配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newippanjissekisyoumeigk</td><td>新制度一般実績証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newippannenkansyoumeigk</td><td>新制度一般年間証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newiryoujissekip</td><td>新制度介護医療実績保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newiryounenkanp</td><td>新制度介護医療年間保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newiryoujissekihaitoukin</td><td>新制度介護医療実績配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newiryounenkanhaitoukin</td><td>新制度介護医療年間配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newiryoujissekisyoumeigk</td><td>新制度介護医療実績証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newiryounenkansyoumeigk</td><td>新制度介護医療年間証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newnkjissekip</td><td>新制度年金実績保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newnknenkanp</td><td>新制度年金年間保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newnkjissekihaitoukin</td><td>新制度年金実績配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newnknenkanhaitoukin</td><td>新制度年金年間配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newnkjissekisyoumeigk</td><td>新制度年金実績証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newnknenkansyoumeigk</td><td>新制度年金年間証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kjnnkkoujyum</td><td>個人年金控除有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj</td><td>問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseyno</td><td>問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr1kj</td><td>問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr2kj</td><td>問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr3kj</td><td>問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno</td><td>問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou1</td><td>問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou2</td><td>問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj2</td><td>第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno2</td><td>第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtennmkj</td><td>代理店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hengakuumu</td><td>変額保険有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>newsyoumeigkumukbn</td><td>新制度証明額有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>koujyosyoumeisentakukbn</td><td>控除証明選択区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoujyosyoumeisentakuKbn C_KoujyosyoumeisentakuKbn}</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkn</td><td>受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saihkhyjkbn</td><td>再発行表示区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaihkHyjKbn C_SaihkHyjKbn}</td></tr>
 *  <tr><td>koujyosyoumeimsgkbn</td><td>控除証明メッセージ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoujyosyoumeimsgKbn C_KoujyosyoumeimsgKbn}</td></tr>
 * </table>
 * @see     IT_KoujyoSym
 * @see     GenIT_KoujyoSym
 * @see     QIT_KoujyoSym
 * @see     GenQIT_KoujyoSym
 */
public class PKIT_KoujyoSym extends AbstractExDBPrimaryKey<IT_KoujyoSym, PKIT_KoujyoSym> {

    private static final long serialVersionUID = 1L;

    public PKIT_KoujyoSym() {
    }

    public PKIT_KoujyoSym(
        String pKbnkey,
        String pSyono,
        String pNendo,
        BizDate pTyouhyouymd,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        nendo = pNendo;
        tyouhyouymd = pTyouhyouymd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_KoujyoSym> getEntityClass() {
        return IT_KoujyoSym.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String nendo;

    public String getNendo() {
        return nendo;
    }

    public void setNendo(String pNendo) {
        nendo = pNendo;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}