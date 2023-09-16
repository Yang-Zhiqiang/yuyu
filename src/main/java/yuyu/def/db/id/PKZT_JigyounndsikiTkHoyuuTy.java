package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.mapping.GenZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.GenQZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuTy;

/**
 * 事業年度式特約保有Fテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JigyounndsikiTkHoyuuTy}</td><td colspan="3">事業年度式特約保有Fテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv12</td><td>（中継用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyoutokuyakukbn</td><td>（中継用）数理用特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakugatakbn</td><td>（中継用）特約型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukisi</td><td>（中継用）特約期始</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisyacd</td><td>（中継用）支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibucd</td><td>（中継用）支部コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknhnsktodouhukencd</td><td>（中継用）被保険者本籍都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakus</td><td>（中継用）特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysinkeityuutokbn</td><td>（中継用）新契中途区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakusrank</td><td>（中継用）主契約Ｓランク</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakuprank</td><td>（中継用）主契約Ｐランク</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakukykjigyouy</td><td>（中継用）主契約契約事業年</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryouritukbn</td><td>（中継用）料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyuannaikykkbn</td><td>（中継用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaruteiskeijihukahyj</td><td>（中継用）マル定新契約時付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkankaisuu</td><td>（中継用）転換回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakutokujyoukbn</td><td>（中継用）特約特条区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2maruhihyj</td><td>（中継用）第２マル被表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteijyuusitusetkbn</td><td>（中継用）特定重疾セット区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydugktnknsntkhuhukbn</td><td>（中継用）同額転換選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygengakutenkankykhyj</td><td>（中継用）減額転換契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitoukbn</td><td>（中継用）配当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykusnmesyokaipjyuutouym</td><td>（中継用）更新前初回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaigaitkyksyokusyucd</td><td>（中継用）災害特約職種コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeiyousinsakbn</td><td>（中継用）統計用診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygassansrank</td><td>（中継用）合算Ｓランク</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoliplhyj</td><td>（中継用）ＴＯＬＩＰＬ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhukakbn</td><td>（中継用）Ｐ免付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenkbnv2</td><td>（中継用）Ｐ免区分Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketteikijyunkanwakbn</td><td>（中継用）決定基準緩和区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakusedaikbn</td><td>（中継用）特約世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharainissuukbn</td><td>（中継用）支払日数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuseikatakbn</td><td>（中継用）カク成型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeirokbn</td><td>（中継用）募集経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaicd</td><td>（中継用）団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhutanpohyj</td><td>（中継用）Ｐ免不担保表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanhosyouminaosikbn</td><td>（中継用）転換保障見直区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouminaosikaisuu</td><td>（中継用）保障見直回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyqpackhyj</td><td>（中継用）Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybunkatukbn</td><td>（中継用）分割区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssnskbn</td><td>（中継用）外出診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssytikbn</td><td>（中継用）外出集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyoukikankbn</td><td>（中継用）保障期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikettisyacd</td><td>（中継用）諾否決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukikan</td><td>（中継用）特約期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymannenreihyj</td><td>（中継用）満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinkbn</td><td>（中継用）更新区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokenhoutekiyouhyouji</td><td>（中継用）保険法適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasiphkbnmnoshyouji</td><td>（中継用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteijyoutaihushrhyj</td><td>（中継用）特定状態不支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrendouyousntkjyubbnhyj</td><td>（中継用）連動用新特条部分表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusentakukeiyakukbn</td><td>（中継用）無選択契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrttekitkarihyj</td><td>（中継用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybluekeizokuhyouji</td><td>（中継用）Ｂｌｕｅ継続表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbn</td><td>（中継用）乗率判定用ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx2</td><td>（中継用）乗率判定用ステータス区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx3</td><td>（中継用）乗率判定用ステータス区分＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx4</td><td>（中継用）乗率判定用ステータス区分＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx5</td><td>（中継用）乗率判定用ステータス区分＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrt</td><td>（中継用）健康増進乗率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrtx2</td><td>（中継用）健康増進乗率＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwrbksidhitekiyouhyj</td><td>（中継用）保険料割引制度非適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino2</td><td>（中継用）データ管理番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino3</td><td>（中継用）データ管理番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkeiyakujivithkhyouji</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin4</td><td>（中継用）数理用予備項目Ｎ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaserate</td><td>（中継用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseratetekiyouymd</td><td>（中継用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakujiyoteiriritu</td><td>（中継用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygaikadatetokuyakus</td><td>（中継用）外貨建特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesyukeiyakus</td><td>（中継用）外貨建主契約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesyukeiyakup</td><td>（中継用）外貨建主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyenkdtsbujsitihsyukngk</td><td>（中継用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysuuriyouyobin10x2</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x3</td><td>（中継用）予備項目Ｖ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymvatyouseigow</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymvakeisanjisknnjynbkn</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_JigyounndsikiTkHoyuuTy
 * @see     GenZT_JigyounndsikiTkHoyuuTy
 * @see     QZT_JigyounndsikiTkHoyuuTy
 * @see     GenQZT_JigyounndsikiTkHoyuuTy
 */
public class PKZT_JigyounndsikiTkHoyuuTy extends AbstractExDBPrimaryKey<ZT_JigyounndsikiTkHoyuuTy, PKZT_JigyounndsikiTkHoyuuTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_JigyounndsikiTkHoyuuTy() {
    }

    public PKZT_JigyounndsikiTkHoyuuTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_JigyounndsikiTkHoyuuTy> getEntityClass() {
        return ZT_JigyounndsikiTkHoyuuTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}