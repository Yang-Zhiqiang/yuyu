package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_AlmNnknHyuTy;
import yuyu.def.db.mapping.GenZT_AlmNnknHyuTy;
import yuyu.def.db.meta.GenQZT_AlmNnknHyuTy;
import yuyu.def.db.meta.QZT_AlmNnknHyuTy;

/**
 * ＡＬＭ用年金保有明細テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AlmNnknHyuTy}</td><td colspan="3">ＡＬＭ用年金保有明細テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn</td><td>（中継用）年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkbn</td><td>（中継用）年金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsyu</td><td>（中継用）年金種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykknsetymd</td><td>（中継用）基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokainenkinsiharaiymd</td><td>（中継用）初回年金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshry</td><td>（中継用）年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinhosyoukikan</td><td>（中継用）年金保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhnnkgk</td><td>（中継用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeiyakujikihonnenkingaku</td><td>（中継用）契約時基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykasannkgk</td><td>（中継用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynewmoneynenkingaku</td><td>（中継用）ニューマネー年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanitijibarainkgk</td><td>（中継用）転換一時払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibitjbratamakinnkgk</td><td>（中継用）一部一時払頭金年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibitjbrtyuutohknkgk</td><td>（中継用）一部一時払中途付加年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkinkaisijigensi</td><td>（中継用）年金開始時原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynewmoneygaku</td><td>（中継用）ニューマネー額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynewmoneybubunnenkingensi</td><td>（中継用）ニューマネー部分年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhitenkankeiyakukykymd</td><td>（中継用）被転換契約契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitibitjbrtyuutohkymd</td><td>（中継用）一部一時払中途付加日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypitijibaraihyouji</td><td>（中継用）Ｐ一時払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakuarihyouji</td><td>（中継用）特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkaisigoyoteiriritukbn</td><td>（中継用）年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksgoyoteisibouritukbn</td><td>（中継用）年金開始後予定死亡率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinjimutesuuryoukbn</td><td>（中継用）年金事務手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatukbn</td><td>（中継用）前厚後厚区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteizounksiboujihknnendo</td><td>（中継用）逓増年金死亡時保険年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksjihihokensyaage</td><td>（中継用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyaseibetukbn</td><td>（中継用）第２被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksjidai2hhknsyaage</td><td>（中継用）年金開始時第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjgyunendosikitoutatuage</td><td>（中継用）事業年度式到達年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijikinsiharaiymd</td><td>（中継用）一時金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyasibouymd</td><td>（中継用）被保険者死亡日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyasibouymd</td><td>（中継用）第２被保険者死亡年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteii</td><td>（中継用）予定ｉ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibouhyoukbn</td><td>（中継用）死亡表区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydnendo</td><td>（中継用）Ｄ年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytounendod</td><td>（中継用）当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynktouduketorihouhoukbn</td><td>（中継用）年金当Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitated</td><td>（中継用）積立Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyouikunenkinarihyouji</td><td>（中継用）養育年金有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyalmnenkinsyoumetucd</td><td>（中継用）ＡＬＭ年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinarihyouji</td><td>（中継用）買増年金有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkkouryokusymd</td><td>（中継用）買増年金効力開始日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinkbn</td><td>（中継用）買増年金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinsyuruikigou</td><td>（中継用）買増年金種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkshrkkn</td><td>（中継用）買増年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinhosyoukikan</td><td>（中継用）買増年金保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkhhknsyaage</td><td>（中継用）買増年金被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykimsnkdai2hhknsyaage</td><td>（中継用）買増年金第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaisyuukousinymd</td><td>（中継用）最終更新日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkingaku</td><td>（中継用）買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennendokaimasinkgk</td><td>（中継用）前年度買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytounendokaimasinenkind</td><td>（中継用）当年度買増年金Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymaeatuatoatukouryokusymd</td><td>（中継用）前厚後厚効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatukikan</td><td>（中継用）前厚後厚期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatuhendougonkgk</td><td>（中継用）前厚後厚変動後年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyatoatusaisyuukaimasiymd</td><td>（中継用）後厚最終買増日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatoatukaimasinenkingaku</td><td>（中継用）後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznnndatoatukaimasinkgk</td><td>（中継用）前年度後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytounendatoatukaimasinkd</td><td>（中継用）当年度後厚買増年金Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyuwanoseatoatukaimasinkgk</td><td>（中継用）上乗せ後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynkuktorininhhknsyadouhyj</td><td>（中継用）年金受取人被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkuktrnndi2hhknsyadouhyj</td><td>（中継用）年金受取人第２被保険者同表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkuketorininsakuinnmno</td><td>（中継用）年金受取人索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtenkanritodoufukencd</td><td>（中継用）代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten1sosikicd</td><td>（中継用）代理店１組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin1cd</td><td>（中継用）募集人１コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin1keisyousisyacd</td><td>（中継用）募集人１継承支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin1zaisekihyouji</td><td>（中継用）募集人１在籍表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin1bosyuujiage</td><td>（中継用）募集人１募集時年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyunin1bosyujisikakucd</td><td>（中継用）募集人１募集時資格コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin1sikakucd</td><td>（中継用）募集人１資格コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkknmanryouymd</td><td>（中継用）年金期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykijyunym</td><td>（中継用）基準年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkigousedaikbn</td><td>（中継用）年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkkigousdkbn</td><td>（中継用）買増年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyalmrrthendounkyoteirrt</td><td>（中継用）ＡＬＭ利率変動年金予定利率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyalmrrthendounksitihsyrrt</td><td>（中継用）ＡＬＭ利率変動年金最低保証利率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkansanp</td><td>（中継用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysotodasimanagehyouji</td><td>（中継用）外出満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnentysihyj</td><td>（中継用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv30</td><td>（中継用）予備項目Ｖ３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x2</td><td>（中継用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x3</td><td>（中継用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x4</td><td>（中継用）予備項目Ｖ８＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_AlmNnknHyuTy
 * @see     GenZT_AlmNnknHyuTy
 * @see     QZT_AlmNnknHyuTy
 * @see     GenQZT_AlmNnknHyuTy
 */
public class PKZT_AlmNnknHyuTy extends AbstractExDBPrimaryKey<ZT_AlmNnknHyuTy, PKZT_AlmNnknHyuTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_AlmNnknHyuTy() {
    }

    public PKZT_AlmNnknHyuTy(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

    @Transient
    @Override
    public Class<ZT_AlmNnknHyuTy> getEntityClass() {
        return ZT_AlmNnknHyuTy.class;
    }

    private String ztynksyousyono;

    public String getZtynksyousyono() {
        return ztynksyousyono;
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

}