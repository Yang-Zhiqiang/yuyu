package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_AlmNnknHyuRn;
import yuyu.def.db.mapping.GenZT_AlmNnknHyuRn;
import yuyu.def.db.meta.GenQZT_AlmNnknHyuRn;
import yuyu.def.db.meta.QZT_AlmNnknHyuRn;

/**
 * ＡＬＭ用年金保有明細テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AlmNnknHyuRn}</td><td colspan="3">ＡＬＭ用年金保有明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn</td><td>（連携用）年金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkbn</td><td>（連携用）年金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsyu</td><td>（連携用）年金種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentkbn</td><td>（連携用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyourgnbnskkbn</td><td>（連携用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuymd</td><td>（連携用）契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkknsetymd</td><td>（連携用）基金設定日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokainenkinsiharaiymd</td><td>（連携用）初回年金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknshry</td><td>（連携用）年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinhosyoukikan</td><td>（連携用）年金保証期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhnnkgk</td><td>（連携用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkeiyakujikihonnenkingaku</td><td>（連携用）契約時基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkasannkgk</td><td>（連携用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnewmoneynenkingaku</td><td>（連携用）ニューマネー年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanitijibarainkgk</td><td>（連携用）転換一時払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibitjbratamakinnkgk</td><td>（連携用）一部一時払頭金年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibitjbrtyuutohknkgk</td><td>（連携用）一部一時払中途付加年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkinkaisijigensi</td><td>（連携用）年金開始時原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnewmoneygaku</td><td>（連携用）ニューマネー額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnewmoneybubunnenkingensi</td><td>（連携用）ニューマネー部分年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhitenkankeiyakukykymd</td><td>（連携用）被転換契約契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitibitjbrtyuutohkymd</td><td>（連携用）一部一時払中途付加日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpitijibaraihyouji</td><td>（連携用）Ｐ一時払表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakuarihyouji</td><td>（連携用）特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigoyoteiriritukbn</td><td>（連携用）年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksgoyoteisibouritukbn</td><td>（連携用）年金開始後予定死亡率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinjimutesuuryoukbn</td><td>（連携用）年金事務手数料区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmaeatuatoatukbn</td><td>（連携用）前厚後厚区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteizounksiboujihknnendo</td><td>（連携用）逓増年金死亡時保険年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjihihokensyaage</td><td>（連携用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyaseibetukbn</td><td>（連携用）第２被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjidai2hhknsyaage</td><td>（連携用）年金開始時第２被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjgyunendosikitoutatuage</td><td>（連携用）事業年度式到達年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijikinsiharaiymd</td><td>（連携用）一時金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyasibouymd</td><td>（連携用）被保険者死亡日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyasibouymd</td><td>（連携用）第２被保険者死亡年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteii</td><td>（連携用）予定ｉ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibouhyoukbn</td><td>（連携用）死亡表区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndnendo</td><td>（連携用）Ｄ年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntounendod</td><td>（連携用）当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnktouduketorihouhoukbn</td><td>（連携用）年金当Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitated</td><td>（連携用）積立Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyouikunenkinarihyouji</td><td>（連携用）養育年金有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyaagev2</td><td>（連携用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnalmnenkinsyoumetucd</td><td>（連携用）ＡＬＭ年金消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkinarihyouji</td><td>（連携用）買増年金有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinkkouryokusymd</td><td>（連携用）買増年金効力開始日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkinkbn</td><td>（連携用）買増年金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkinsyuruikigou</td><td>（連携用）買増年金種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinkshrkkn</td><td>（連携用）買増年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkinhosyoukikan</td><td>（連携用）買増年金保証期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinkhhknsyaage</td><td>（連携用）買増年金被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkimsnkdai2hhknsyaage</td><td>（連携用）買増年金第２被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisyuukousinymd</td><td>（連携用）最終更新日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkingaku</td><td>（連携用）買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennendokaimasinkgk</td><td>（連携用）前年度買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntounendokaimasinenkind</td><td>（連携用）当年度買増年金Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmaeatuatoatukouryokusymd</td><td>（連携用）前厚後厚効力開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmaeatuatoatukikan</td><td>（連携用）前厚後厚期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmaeatuatoatuhendougonkgk</td><td>（連携用）前厚後厚変動後年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnatoatusaisyuukaimasiymd</td><td>（連携用）後厚最終買増日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatoatukaimasinenkingaku</td><td>（連携用）後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnznnndatoatukaimasinkgk</td><td>（連携用）前年度後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntounendatoatukaimasinkd</td><td>（連携用）当年度後厚買増年金Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnuwanoseatoatukaimasinkgk</td><td>（連携用）上乗せ後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnkuktorininhhknsyadouhyj</td><td>（連携用）年金受取人被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuktrnndi2hhknsyadouhyj</td><td>（連携用）年金受取人第２被保険者同表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuketorininsakuinnmno</td><td>（連携用）年金受取人索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtenkanritodoufukencd</td><td>（連携用）代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten1sosikicd</td><td>（連携用）代理店１組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin1cd</td><td>（連携用）募集人１コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin1keisyousisyacd</td><td>（連携用）募集人１継承支社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin1zaisekihyouji</td><td>（連携用）募集人１在籍表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin1bosyuujiage</td><td>（連携用）募集人１募集時年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyunin1bosyujisikakucd</td><td>（連携用）募集人１募集時資格コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin1sikakucd</td><td>（連携用）募集人１資格コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkknmanryouymd</td><td>（連携用）年金期間満了日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkijyunym</td><td>（連携用）基準年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkigousedaikbn</td><td>（連携用）年金記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinkkigousdkbn</td><td>（連携用）買増年金記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnalmrrthendounkyoteirrt</td><td>（連携用）ＡＬＭ利率変動年金予定利率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnalmrrthendounksitihsyrrt</td><td>（連携用）ＡＬＭ利率変動年金最低保証利率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkansanp</td><td>（連携用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsotodasimanagehyouji</td><td>（連携用）外出満年令表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnentysihyj</td><td>（連携用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnentysihyj</td><td>（連携用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukeitaikbn</td><td>（連携用）募集形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv30</td><td>（連携用）予備項目Ｖ３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x3</td><td>（連携用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x4</td><td>（連携用）予備項目Ｖ８＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_AlmNnknHyuRn
 * @see     GenZT_AlmNnknHyuRn
 * @see     QZT_AlmNnknHyuRn
 * @see     GenQZT_AlmNnknHyuRn
 */
public class PKZT_AlmNnknHyuRn extends AbstractExDBPrimaryKey<ZT_AlmNnknHyuRn, PKZT_AlmNnknHyuRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_AlmNnknHyuRn() {
    }

    public PKZT_AlmNnknHyuRn(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

    @Transient
    @Override
    public Class<ZT_AlmNnknHyuRn> getEntityClass() {
        return ZT_AlmNnknHyuRn.class;
    }

    private String zrnnksyousyono;

    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

}