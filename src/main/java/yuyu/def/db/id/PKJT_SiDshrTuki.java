package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.mapping.GenJT_SiDshrTuki;
import yuyu.def.db.meta.GenQJT_SiDshrTuki;
import yuyu.def.db.meta.QJT_SiDshrTuki;

/**
 * 保険金給付金Ｄ支払統計テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiDshrTuki}</td><td colspan="3">保険金給付金Ｄ支払統計テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDshrtoukeisikibetukey dshrtoukeisikibetukey}</td><td>Ｄ支払統計識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renno</td><td>連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>skno</td><td>請求番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuurirekino</td><td>請求履歴番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorikbn</td><td>処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoriKbn C_SyoriKbn}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykjyoutai</td><td>契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykjyoutai C_Kykjyoutai}</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yendthnkymd</td><td>円建変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>siharaid</td><td>支払Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoriymd2</td><td>処理年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kinoubetukijyunymd</td><td>機能別基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gengkwari</td><td>減額割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>itibushrgk</td><td>一部支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>haitoushrkin</td><td>配当支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedruigk</td><td>仮割当Ｄ累計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedgngkkngk</td><td>仮割当Ｄ減額金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedshrgk</td><td>仮割当Ｄ支払額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dkeisanhaitoukin</td><td>配当金計算配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dkeisannaiteikakuteikbn</td><td>配当金計算内定確定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaiteiKakuteiKbn C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>haitounendo</td><td>配当年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>haitoushrkingk</td><td>配当支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedganrikindshr</td><td>仮割当Ｄ元利金（配当支払金用）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitated</td><td>積立Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitatedmodosimae</td><td>積立Ｄ（割戻し前）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitatedmodosigo</td><td>積立Ｄ（割戻し後）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkbthaitou</td><td>特別配当</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>haitounendo2</td><td>配当年度２</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>haitoukinskskbn</td><td>配当金作成区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinsksKbn C_HaitoukinsksKbn}</td></tr>
 *  <tr><td>haitoumeisaikbn</td><td>配当明細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoumeisaiKbn C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>fstkariwariatednendo</td><td>初回仮割当Ｄ年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>tounendod</td><td>当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>naiteikakuteikbn</td><td>内定確定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaiteiKakuteiKbn C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>kariwariatedshrymd</td><td>仮割当Ｄ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kariwariatedruigk2</td><td>仮割当Ｄ累計額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedgngkkngk2</td><td>仮割当Ｄ減額金額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedshrgk2</td><td>仮割当Ｄ支払額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitatedtumitateymd</td><td>積立Ｄ積立年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tumitatedskskbn</td><td>積立Ｄ作成区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumitateDSakuseiKbn C_TumitateDSakuseiKbn}</td></tr>
 *  <tr><td>tumitated2</td><td>積立Ｄ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitatedshrkrkymd</td><td>積立Ｄ支払効力日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>naiteikakuteikbn2</td><td>内定確定区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaiteiKakuteiKbn C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>haitouganrikincalckari</td><td>配当元利金計算（仮割当Ｄ元利金）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedriritu1</td><td>仮割当Ｄ利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kariwariatedriritu2</td><td>仮割当Ｄ利率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>haitouganrikincalctumi</td><td>配当元利金計算（積立Ｄ元利金）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitatedriritu1</td><td>積立Ｄ利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitatedriritu2</td><td>積立Ｄ利率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiDshrTuki
 * @see     GenJT_SiDshrTuki
 * @see     QJT_SiDshrTuki
 * @see     GenQJT_SiDshrTuki
 */
public class PKJT_SiDshrTuki extends AbstractExDBPrimaryKey<JT_SiDshrTuki, PKJT_SiDshrTuki> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiDshrTuki() {
    }

    public PKJT_SiDshrTuki(String pDshrtoukeisikibetukey) {
        dshrtoukeisikibetukey = pDshrtoukeisikibetukey;
    }

    @Transient
    @Override
    public Class<JT_SiDshrTuki> getEntityClass() {
        return JT_SiDshrTuki.class;
    }

    private String dshrtoukeisikibetukey;

    public String getDshrtoukeisikibetukey() {
        return dshrtoukeisikibetukey;
    }

    public void setDshrtoukeisikibetukey(String pDshrtoukeisikibetukey) {
        dshrtoukeisikibetukey = pDshrtoukeisikibetukey;
    }

}