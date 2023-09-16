package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル３（中） テーブルのマッピング情報クラスで、 {@link ZT_Skeiksnbsgetujisr3Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Skeiksnbsgetujisr3Ty}</td><td colspan="3">新契約決算ベース月次成立Ｆテーブル３（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyktgysyrymd ztyktgysyrymd}</td><td>（中継用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">{@link PKZT_Skeiksnbsgetujisr3Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgyfilerenno ztyktgyfilerenno}</td><td>（中継用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeirokbn ztybosyuukeirokbn}</td><td>（中継用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipcashlessnyukinhyj ztysyokaipcashlessnyukinhyj}</td><td>（中継用）初回Ｐキャッシュレス入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigkyhsitihsyutkykarihyj ztykigkyhsitihsyutkykarihyj}</td><td>（中継用）介護給付最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipswingriyoukbn ztysyokaipswingriyoukbn}</td><td>（中継用）初回Ｐスイング利用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysknjyututkykkykkbn ztysknjyututkykkykkbn}</td><td>（中継用）資金充当特約契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuudairitengyousyukbn ztybosyuudairitengyousyukbn}</td><td>（中継用）募集代理店業種区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyujimutoriatukaikbn ztytokusyujimutoriatukaikbn}</td><td>（中継用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentkykyutktbicdx1 ztypmentkykyutktbicdx1}</td><td>（中継用）Ｐ免特約用特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentkykyuhtnpkknx1 ztypmentkykyuhtnpkknx1}</td><td>（中継用）Ｐ免特約用不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentkykyutktbicdx2 ztypmentkykyutktbicdx2}</td><td>（中継用）Ｐ免特約用特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentkykyuhtnpkknx2 ztypmentkykyuhtnpkknx2}</td><td>（中継用）Ｐ免特約用不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouikkatumnoshyouji ztyhosyouikkatumnoshyouji}</td><td>（中継用）保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhsyuikktminaosikaisu ztyhsyuikktminaosikaisu}</td><td>（中継用）保障一括見直回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhsyuikktmnosdfnyuknhyj ztyhsyuikktmnosdfnyuknhyj}</td><td>（中継用）保障一括見直ＤＦ入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikktmnoskikiyutkykp ztyikktmnoskikiyutkykp}</td><td>（中継用）一括見直会計用特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyikktmnoskikiyufndsistp ztyikktmnoskikiyufndsistp}</td><td>（中継用）一括見直会計用ファンド災疾Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysknnjynbknsisnrt ztysknnjynbknsisnrt}</td><td>（中継用）責任準備金精算率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykanyujisyono ztykanyujisyono}</td><td>（中継用）加入時証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyujikykymd ztykanyujikykymd}</td><td>（中継用）加入時契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyuujihihokensyaage ztykanyuujihihokensyaage}</td><td>（中継用）加入時被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyuujitenkanhyouji ztykanyuujitenkanhyouji}</td><td>（中継用）加入時転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyksnyuhsyuikktminosnnskbn ztyksnyuhsyuikktminosnnskbn}</td><td>（中継用）加算用保障一括見直年数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyadirtnbsynnhyj ztyaatukaisyadirtnbsynnhyj}</td><td>（中継用）Ａ扱者代理店募集人表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkisyadirtnbosyuninhyj ztybatkisyadirtnbosyuninhyj}</td><td>（中継用）Ｂ扱者代理店募集人表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydirtnaatukaisyakojincd ztydirtnaatukaisyakojincd}</td><td>（中継用）代理店Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydirtnbatukaisyakojincd ztydirtnbatukaisyakojincd}</td><td>（中継用）代理店Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuuseisyoukeikanensuu ztysyuuseisyoukeikanensuu}</td><td>（中継用）修正Ｓ用経過年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruihnkutkbttrtkhyj ztysyuruihnkutkbttrtkhyj}</td><td>（中継用）種類変更特別取扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktmekyktkykhkjyutikbn ztybnktmekyktkykhkjyutikbn}</td><td>（中継用）分割前契約特約付加状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknsyokaipclessriyouhyj ztytnknsyokaipclessriyouhyj}</td><td>（中継用）転換初回ＰＣレス利用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkteisikibouhyouji ztyhrkteisikibouhyouji}</td><td>（中継用）払込停止希望表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybunkatugosonzokukeiyakus ztybunkatugosonzokukeiyakus}</td><td>（中継用）分割後存続契約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymoskizkphrkekngk ztymoskizkphrkekngk}</td><td>（中継用）申込継続Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeizokuphurikaejijikaip ztykeizokuphurikaejijikaip}</td><td>（中継用）継続Ｐ振替時次回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnktmekyksyono ztybnktmekyksyono}</td><td>（中継用）分割前契約証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybunkatumaekeiyakukihons ztybunkatumaekeiyakukihons}</td><td>（中継用）分割前契約基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybunkatumaekeiyakusibous ztybunkatumaekeiyakusibous}</td><td>（中継用）分割前契約死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnktmekykmods ztybnktmekykmods}</td><td>（中継用）分割前契約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnktmekyksigiwrmstkyks ztybnktmekyksigiwrmstkyks}</td><td>（中継用）分割前契約災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnktmekyksyugitkyks ztybnktmekyksyugitkyks}</td><td>（中継用）分割前契約傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnktmkyksiginyintkykntgk ztybnktmkyksiginyintkykntgk}</td><td>（中継用）分割前契約災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtybnktmekykknkutkykntgk ztybnktmekykknkutkykntgk}</td><td>（中継用）分割前契約健康特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtybnktmekykhntiyunbriknsnp ztybnktmekykhntiyunbriknsnp}</td><td>（中継用）分割前契約判定用年払換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2naibuwarimodosigaku ztydai2naibuwarimodosigaku}</td><td>（中継用）第２内部割戻額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnkngkykkstkgk ztytnkngkykkstkgk}</td><td>（中継用）転換後契約貸付額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybnktmekykkstkgk ztybnktmekykkstkgk}</td><td>（中継用）分割前契約貸付額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonzokukykkasitukegk ztysonzokukykkasitukegk}</td><td>（中継用）存続契約貸付額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhngkmnryoujsitihsyukngk ztyhngkmnryoujsitihsyukngk}</td><td>（中継用）変額満了時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhngksitihsyuyusykykp ztyhngksitihsyuyusykykp}</td><td>（中継用）変額最低保証用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx1x1 ztyhtnknkigmrsyukguybx1x1}</td><td>（中継用）被転換介護マル終記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx2x1 ztyhtnknkigmrsyukguybx2x1}</td><td>（中継用）被転換介護マル終記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx3x1 ztyhtnknkigmrsyukguybx3x1}</td><td>（中継用）被転換介護マル終記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx4x1 ztyhtnknkigmrsyukguybx4x1}</td><td>（中継用）被転換介護マル終記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx5x1 ztyhtnknkigmrsyukguybx5x1}</td><td>（中継用）被転換介護マル終記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx1x2 ztyhtnknkigmrsyukguybx1x2}</td><td>（中継用）被転換介護マル終記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx2x2 ztyhtnknkigmrsyukguybx2x2}</td><td>（中継用）被転換介護マル終記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx3x2 ztyhtnknkigmrsyukguybx3x2}</td><td>（中継用）被転換介護マル終記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx4x2 ztyhtnknkigmrsyukguybx4x2}</td><td>（中継用）被転換介護マル終記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx5x2 ztyhtnknkigmrsyukguybx5x2}</td><td>（中継用）被転換介護マル終記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx1x3 ztyhtnknkigmrsyukguybx1x3}</td><td>（中継用）被転換介護マル終記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx2x3 ztyhtnknkigmrsyukguybx2x3}</td><td>（中継用）被転換介護マル終記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx3x3 ztyhtnknkigmrsyukguybx3x3}</td><td>（中継用）被転換介護マル終記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx4x3 ztyhtnknkigmrsyukguybx4x3}</td><td>（中継用）被転換介護マル終記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx5x3 ztyhtnknkigmrsyukguybx5x3}</td><td>（中継用）被転換介護マル終記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx1x4 ztyhtnknkigmrsyukguybx1x4}</td><td>（中継用）被転換介護マル終記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx2x4 ztyhtnknkigmrsyukguybx2x4}</td><td>（中継用）被転換介護マル終記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx3x4 ztyhtnknkigmrsyukguybx3x4}</td><td>（中継用）被転換介護マル終記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx4x4 ztyhtnknkigmrsyukguybx4x4}</td><td>（中継用）被転換介護マル終記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx5x4 ztyhtnknkigmrsyukguybx5x4}</td><td>（中継用）被転換介護マル終記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx1x5 ztyhtnknkigmrsyukguybx1x5}</td><td>（中継用）被転換介護マル終記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx2x5 ztyhtnknkigmrsyukguybx2x5}</td><td>（中継用）被転換介護マル終記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx3x5 ztyhtnknkigmrsyukguybx3x5}</td><td>（中継用）被転換介護マル終記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx4x5 ztyhtnknkigmrsyukguybx4x5}</td><td>（中継用）被転換介護マル終記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx5x5 ztyhtnknkigmrsyukguybx5x5}</td><td>（中継用）被転換介護マル終記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx1x6 ztyhtnknkigmrsyukguybx1x6}</td><td>（中継用）被転換介護マル終記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx2x6 ztyhtnknkigmrsyukguybx2x6}</td><td>（中継用）被転換介護マル終記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx3x6 ztyhtnknkigmrsyukguybx3x6}</td><td>（中継用）被転換介護マル終記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx4x6 ztyhtnknkigmrsyukguybx4x6}</td><td>（中継用）被転換介護マル終記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrsyukguybx5x6 ztyhtnknkigmrsyukguybx5x6}</td><td>（中継用）被転換介護マル終記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x3 ztyyobiv1x3}</td><td>（中継用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix1 ztymaruteikigouyobix1}</td><td>（中継用）マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix2 ztymaruteikigouyobix2}</td><td>（中継用）マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix3 ztymaruteikigouyobix3}</td><td>（中継用）マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix4 ztymaruteikigouyobix4}</td><td>（中継用）マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix5 ztymaruteikigouyobix5}</td><td>（中継用）マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukigouyobix1 ztymaruyoukigouyobix1}</td><td>（中継用）マル養記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukigouyobix2 ztymaruyoukigouyobix2}</td><td>（中継用）マル養記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukigouyobix3 ztymaruyoukigouyobix3}</td><td>（中継用）マル養記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukigouyobix4 ztymaruyoukigouyobix4}</td><td>（中継用）マル養記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukigouyobix5 ztymaruyoukigouyobix5}</td><td>（中継用）マル養記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukigouyobix1 ztymarusyuukigouyobix1}</td><td>（中継用）マル終記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukigouyobix2 ztymarusyuukigouyobix2}</td><td>（中継用）マル終記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukigouyobix3 ztymarusyuukigouyobix3}</td><td>（中継用）マル終記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukigouyobix4 ztymarusyuukigouyobix4}</td><td>（中継用）マル終記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukigouyobix5 ztymarusyuukigouyobix5}</td><td>（中継用）マル終記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikigouyobix1 ztytokuteikigouyobix1}</td><td>（中継用）トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikigouyobix2 ztytokuteikigouyobix2}</td><td>（中継用）トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikigouyobix3 ztytokuteikigouyobix3}</td><td>（中継用）トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikigouyobix4 ztytokuteikigouyobix4}</td><td>（中継用）トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikigouyobix5 ztytokuteikigouyobix5}</td><td>（中継用）トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x1 ztykzkmrtikguybx1x1}</td><td>（中継用）家族マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x1 ztykzkmrtikguybx2x1}</td><td>（中継用）家族マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x1 ztykzkmrtikguybx3x1}</td><td>（中継用）家族マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x1 ztykzkmrtikguybx4x1}</td><td>（中継用）家族マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x1 ztykzkmrtikguybx5x1}</td><td>（中継用）家族マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x2 ztykzkmrtikguybx1x2}</td><td>（中継用）家族マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x2 ztykzkmrtikguybx2x2}</td><td>（中継用）家族マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x2 ztykzkmrtikguybx3x2}</td><td>（中継用）家族マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x2 ztykzkmrtikguybx4x2}</td><td>（中継用）家族マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x2 ztykzkmrtikguybx5x2}</td><td>（中継用）家族マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x3 ztykzkmrtikguybx1x3}</td><td>（中継用）家族マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x3 ztykzkmrtikguybx2x3}</td><td>（中継用）家族マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x3 ztykzkmrtikguybx3x3}</td><td>（中継用）家族マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x3 ztykzkmrtikguybx4x3}</td><td>（中継用）家族マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x3 ztykzkmrtikguybx5x3}</td><td>（中継用）家族マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x4 ztykzkmrtikguybx1x4}</td><td>（中継用）家族マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x4 ztykzkmrtikguybx2x4}</td><td>（中継用）家族マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x4 ztykzkmrtikguybx3x4}</td><td>（中継用）家族マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x4 ztykzkmrtikguybx4x4}</td><td>（中継用）家族マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x4 ztykzkmrtikguybx5x4}</td><td>（中継用）家族マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x5 ztykzkmrtikguybx1x5}</td><td>（中継用）家族マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x5 ztykzkmrtikguybx2x5}</td><td>（中継用）家族マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x5 ztykzkmrtikguybx3x5}</td><td>（中継用）家族マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x5 ztykzkmrtikguybx4x5}</td><td>（中継用）家族マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x5 ztykzkmrtikguybx5x5}</td><td>（中継用）家族マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x6 ztykzkmrtikguybx1x6}</td><td>（中継用）家族マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x6 ztykzkmrtikguybx2x6}</td><td>（中継用）家族マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x6 ztykzkmrtikguybx3x6}</td><td>（中継用）家族マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x6 ztykzkmrtikguybx4x6}</td><td>（中継用）家族マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x6 ztykzkmrtikguybx5x6}</td><td>（中継用）家族マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x7 ztykzkmrtikguybx1x7}</td><td>（中継用）家族マル定記号予備＿１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x7 ztykzkmrtikguybx2x7}</td><td>（中継用）家族マル定記号予備＿２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x7 ztykzkmrtikguybx3x7}</td><td>（中継用）家族マル定記号予備＿３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x7 ztykzkmrtikguybx4x7}</td><td>（中継用）家族マル定記号予備＿４＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x7 ztykzkmrtikguybx5x7}</td><td>（中継用）家族マル定記号予備＿５＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x8 ztykzkmrtikguybx1x8}</td><td>（中継用）家族マル定記号予備＿１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x8 ztykzkmrtikguybx2x8}</td><td>（中継用）家族マル定記号予備＿２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x8 ztykzkmrtikguybx3x8}</td><td>（中継用）家族マル定記号予備＿３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x8 ztykzkmrtikguybx4x8}</td><td>（中継用）家族マル定記号予備＿４＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x8 ztykzkmrtikguybx5x8}</td><td>（中継用）家族マル定記号予備＿５＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x9 ztykzkmrtikguybx1x9}</td><td>（中継用）家族マル定記号予備＿１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x9 ztykzkmrtikguybx2x9}</td><td>（中継用）家族マル定記号予備＿２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x9 ztykzkmrtikguybx3x9}</td><td>（中継用）家族マル定記号予備＿３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x9 ztykzkmrtikguybx4x9}</td><td>（中継用）家族マル定記号予備＿４＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x9 ztykzkmrtikguybx5x9}</td><td>（中継用）家族マル定記号予備＿５＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx1x10 ztykzkmrtikguybx1x10}</td><td>（中継用）家族マル定記号予備＿１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx2x10 ztykzkmrtikguybx2x10}</td><td>（中継用）家族マル定記号予備＿２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx3x10 ztykzkmrtikguybx3x10}</td><td>（中継用）家族マル定記号予備＿３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx4x10 ztykzkmrtikguybx4x10}</td><td>（中継用）家族マル定記号予備＿４＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikguybx5x10 ztykzkmrtikguybx5x10}</td><td>（中継用）家族マル定記号予備＿５＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyugittkykkguybx1 ztysyugittkykkguybx1}</td><td>（中継用）傷害特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyugittkykkguybx2 ztysyugittkykkguybx2}</td><td>（中継用）傷害特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyugittkykkguybx3 ztysyugittkykkguybx3}</td><td>（中継用）傷害特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyugittkykkguybx4 ztysyugittkykkguybx4}</td><td>（中継用）傷害特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyugittkykkguybx5 ztysyugittkykkguybx5}</td><td>（中継用）傷害特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkguybx1 ztysigiwrmstkykkguybx1}</td><td>（中継用）災害割増特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkguybx2 ztysigiwrmstkykkguybx2}</td><td>（中継用）災害割増特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkguybx3 ztysigiwrmstkykkguybx3}</td><td>（中継用）災害割増特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkguybx4 ztysigiwrmstkykkguybx4}</td><td>（中継用）災害割増特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkguybx5 ztysigiwrmstkykkguybx5}</td><td>（中継用）災害割増特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykkguybx1 ztysiginyuintkykkguybx1}</td><td>（中継用）災害入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykkguybx2 ztysiginyuintkykkguybx2}</td><td>（中継用）災害入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykkguybx3 ztysiginyuintkykkguybx3}</td><td>（中継用）災害入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykkguybx4 ztysiginyuintkykkguybx4}</td><td>（中継用）災害入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykkguybx5 ztysiginyuintkykkguybx5}</td><td>（中継用）災害入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykkguybx1 ztysppinyuintkykkguybx1}</td><td>（中継用）疾病入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykkguybx2 ztysppinyuintkykkguybx2}</td><td>（中継用）疾病入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykkguybx3 ztysppinyuintkykkguybx3}</td><td>（中継用）疾病入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykkguybx4 ztysppinyuintkykkguybx4}</td><td>（中継用）疾病入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykkguybx5 ztysppinyuintkykkguybx5}</td><td>（中継用）疾病入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykkguybx1 ztysijnbyutkykkguybx1}</td><td>（中継用）成人病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykkguybx2 ztysijnbyutkykkguybx2}</td><td>（中継用）成人病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykkguybx3 ztysijnbyutkykkguybx3}</td><td>（中継用）成人病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykkguybx4 ztysijnbyutkykkguybx4}</td><td>（中継用）成人病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykkguybx5 ztysijnbyutkykkguybx5}</td><td>（中継用）成人病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykkguybx1 ztykzkiryoutkykkguybx1}</td><td>（中継用）家族医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykkguybx2 ztykzkiryoutkykkguybx2}</td><td>（中継用）家族医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykkguybx3 ztykzkiryoutkykkguybx3}</td><td>（中継用）家族医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykkguybx4 ztykzkiryoutkykkguybx4}</td><td>（中継用）家族医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykkguybx5 ztykzkiryoutkykkguybx5}</td><td>（中継用）家族医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykkguybx1 ztysykkyuhtkykkguybx1}</td><td>（中継用）初期給付特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykkguybx2 ztysykkyuhtkykkguybx2}</td><td>（中継用）初期給付特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykkguybx3 ztysykkyuhtkykkguybx3}</td><td>（中継用）初期給付特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykkguybx4 ztysykkyuhtkykkguybx4}</td><td>（中継用）初期給付特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykkguybx5 ztysykkyuhtkykkguybx5}</td><td>（中継用）初期給付特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikguyobix1 ztynkdtmrtikguyobix1}</td><td>（中継用）年金建マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikguyobix2 ztynkdtmrtikguyobix2}</td><td>（中継用）年金建マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikguyobix3 ztynkdtmrtikguyobix3}</td><td>（中継用）年金建マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikguyobix4 ztynkdtmrtikguyobix4}</td><td>（中継用）年金建マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikguyobix5 ztynkdtmrtikguyobix5}</td><td>（中継用）年金建マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteikguyobix1 ztynkdatetokuteikguyobix1}</td><td>（中継用）年金建トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteikguyobix2 ztynkdatetokuteikguyobix2}</td><td>（中継用）年金建トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteikguyobix3 ztynkdatetokuteikguyobix3}</td><td>（中継用）年金建トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteikguyobix4 ztynkdatetokuteikguyobix4}</td><td>（中継用）年金建トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteikguyobix5 ztynkdatetokuteikguyobix5}</td><td>（中継用）年金建トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikguyobix1 ztykaigonkdtmrtikguyobix1}</td><td>（中継用）介護年金建マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikguyobix2 ztykaigonkdtmrtikguyobix2}</td><td>（中継用）介護年金建マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikguyobix3 ztykaigonkdtmrtikguyobix3}</td><td>（中継用）介護年金建マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikguyobix4 ztykaigonkdtmrtikguyobix4}</td><td>（中継用）介護年金建マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikguyobix5 ztykaigonkdtmrtikguyobix5}</td><td>（中継用）介護年金建マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikguyobix1 ztykaigonkdttktikguyobix1}</td><td>（中継用）介護年金建トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikguyobix2 ztykaigonkdttktikguyobix2}</td><td>（中継用）介護年金建トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikguyobix3 ztykaigonkdttktikguyobix3}</td><td>（中継用）介護年金建トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikguyobix4 ztykaigonkdttktikguyobix4}</td><td>（中継用）介護年金建トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikguyobix5 ztykaigonkdttktikguyobix5}</td><td>（中継用）介護年金建トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikigouyobix1 ztykaigomaruteikigouyobix1}</td><td>（中継用）介護マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikigouyobix2 ztykaigomaruteikigouyobix2}</td><td>（中継用）介護マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikigouyobix3 ztykaigomaruteikigouyobix3}</td><td>（中継用）介護マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikigouyobix4 ztykaigomaruteikigouyobix4}</td><td>（中継用）介護マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikigouyobix5 ztykaigomaruteikigouyobix5}</td><td>（中継用）介護マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteikigouyobix1 ztykaigotokuteikigouyobix1}</td><td>（中継用）介護トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteikigouyobix2 ztykaigotokuteikigouyobix2}</td><td>（中継用）介護トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteikigouyobix3 ztykaigotokuteikigouyobix3}</td><td>（中継用）介護トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteikigouyobix4 ztykaigotokuteikigouyobix4}</td><td>（中継用）介護トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteikigouyobix5 ztykaigotokuteikigouyobix5}</td><td>（中継用）介護トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx1 ztysiznmrtikguybx1}</td><td>（中継用）生存マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx2 ztysiznmrtikguybx2}</td><td>（中継用）生存マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx3 ztysiznmrtikguybx3}</td><td>（中継用）生存マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx4 ztysiznmrtikguybx4}</td><td>（中継用）生存マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx5 ztysiznmrtikguybx5}</td><td>（中継用）生存マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix1 ztyteigenmaruteikigouyobix1}</td><td>（中継用）逓減マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix2 ztyteigenmaruteikigouyobix2}</td><td>（中継用）逓減マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix3 ztyteigenmaruteikigouyobix3}</td><td>（中継用）逓減マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix4 ztyteigenmaruteikigouyobix4}</td><td>（中継用）逓減マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix5 ztyteigenmaruteikigouyobix5}</td><td>（中継用）逓減マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteikigouyobix1 ztyteigentokuteikigouyobix1}</td><td>（中継用）逓減トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteikigouyobix2 ztyteigentokuteikigouyobix2}</td><td>（中継用）逓減トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteikigouyobix3 ztyteigentokuteikigouyobix3}</td><td>（中継用）逓減トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteikigouyobix4 ztyteigentokuteikigouyobix4}</td><td>（中継用）逓減トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteikigouyobix5 ztyteigentokuteikigouyobix5}</td><td>（中継用）逓減トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtikguybx1 ztykigtignmrtikguybx1}</td><td>（中継用）介護逓減マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtikguybx2 ztykigtignmrtikguybx2}</td><td>（中継用）介護逓減マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtikguybx3 ztykigtignmrtikguybx3}</td><td>（中継用）介護逓減マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtikguybx4 ztykigtignmrtikguybx4}</td><td>（中継用）介護逓減マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtikguybx5 ztykigtignmrtikguybx5}</td><td>（中継用）介護逓減マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktikguybx1 ztykigtigntktikguybx1}</td><td>（中継用）介護逓減トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktikguybx2 ztykigtigntktikguybx2}</td><td>（中継用）介護逓減トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktikguybx3 ztykigtigntktikguybx3}</td><td>（中継用）介護逓減トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktikguybx4 ztykigtigntktikguybx4}</td><td>（中継用）介護逓減トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktikguybx5 ztykigtigntktikguybx5}</td><td>（中継用）介護逓減トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakukigouyobix1 ztytuuintokuyakukigouyobix1}</td><td>（中継用）通院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakukigouyobix2 ztytuuintokuyakukigouyobix2}</td><td>（中継用）通院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakukigouyobix3 ztytuuintokuyakukigouyobix3}</td><td>（中継用）通院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakukigouyobix4 ztytuuintokuyakukigouyobix4}</td><td>（中継用）通院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakukigouyobix5 ztytuuintokuyakukigouyobix5}</td><td>（中継用）通院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkguyobix1 ztyjysisppitkykkguyobix1}</td><td>（中継用）女性疾病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkguyobix2 ztyjysisppitkykkguyobix2}</td><td>（中継用）女性疾病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkguyobix3 ztyjysisppitkykkguyobix3}</td><td>（中継用）女性疾病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkguyobix4 ztyjysisppitkykkguyobix4}</td><td>（中継用）女性疾病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkguyobix5 ztyjysisppitkykkguyobix5}</td><td>（中継用）女性疾病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykkguybx1 ztytksttkykkguybx1}</td><td>（中継用）特疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykkguybx2 ztytksttkykkguybx2}</td><td>（中継用）特疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykkguybx3 ztytksttkykkguybx3}</td><td>（中継用）特疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykkguybx4 ztytksttkykkguybx4}</td><td>（中継用）特疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykkguybx5 ztytksttkykkguybx5}</td><td>（中継用）特疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykkguybx1 ztydi2tksttkykkguybx1}</td><td>（中継用）第２特疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykkguybx2 ztydi2tksttkykkguybx2}</td><td>（中継用）第２特疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykkguybx3 ztydi2tksttkykkguybx3}</td><td>（中継用）第２特疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykkguybx4 ztydi2tksttkykkguybx4}</td><td>（中継用）第２特疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykkguybx5 ztydi2tksttkykkguybx5}</td><td>（中継用）第２特疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsttkykkguybx1 ztymnsttkykkguybx1}</td><td>（中継用）慢疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsttkykkguybx2 ztymnsttkykkguybx2}</td><td>（中継用）慢疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsttkykkguybx3 ztymnsttkykkguybx3}</td><td>（中継用）慢疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsttkykkguybx4 ztymnsttkykkguybx4}</td><td>（中継用）慢疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsttkykkguybx5 ztymnsttkykkguybx5}</td><td>（中継用）慢疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2mnsttkykkguybx1 ztydi2mnsttkykkguybx1}</td><td>（中継用）第２慢疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2mnsttkykkguybx2 ztydi2mnsttkykkguybx2}</td><td>（中継用）第２慢疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2mnsttkykkguybx3 ztydi2mnsttkykkguybx3}</td><td>（中継用）第２慢疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2mnsttkykkguybx4 ztydi2mnsttkykkguybx4}</td><td>（中継用）第２慢疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2mnsttkykkguybx5 ztydi2mnsttkykkguybx5}</td><td>（中継用）第２慢疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkguybx1 ztysugusnsyutkykkguybx1}</td><td>（中継用）総合損傷特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkguybx2 ztysugusnsyutkykkguybx2}</td><td>（中継用）総合損傷特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkguybx3 ztysugusnsyutkykkguybx3}</td><td>（中継用）総合損傷特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkguybx4 ztysugusnsyutkykkguybx4}</td><td>（中継用）総合損傷特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkguybx5 ztysugusnsyutkykkguybx5}</td><td>（中継用）総合損傷特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykkguyobix1 ztykaigonktkykkguyobix1}</td><td>（中継用）介護年金特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykkguyobix2 ztykaigonktkykkguyobix2}</td><td>（中継用）介護年金特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykkguyobix3 ztykaigonktkykkguyobix3}</td><td>（中継用）介護年金特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykkguyobix4 ztykaigonktkykkguyobix4}</td><td>（中継用）介護年金特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykkguyobix5 ztykaigonktkykkguyobix5}</td><td>（中継用）介護年金特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykkguybx1 ztyitjbrkignktkykkguybx1}</td><td>（中継用）一時払介護年金特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykkguybx2 ztyitjbrkignktkykkguybx2}</td><td>（中継用）一時払介護年金特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykkguybx3 ztyitjbrkignktkykkguybx3}</td><td>（中継用）一時払介護年金特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykkguybx4 ztyitjbrkignktkykkguybx4}</td><td>（中継用）一時払介護年金特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykkguybx5 ztyitjbrkignktkykkguybx5}</td><td>（中継用）一時払介護年金特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykkguybx1 ztydi2syugitkykkguybx1}</td><td>（中継用）第２傷害特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykkguybx2 ztydi2syugitkykkguybx2}</td><td>（中継用）第２傷害特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykkguybx3 ztydi2syugitkykkguybx3}</td><td>（中継用）第２傷害特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykkguybx4 ztydi2syugitkykkguybx4}</td><td>（中継用）第２傷害特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykkguybx5 ztydi2syugitkykkguybx5}</td><td>（中継用）第２傷害特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkguybx1 ztydi2sigiwrmstkykkguybx1}</td><td>（中継用）第２災害割増特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkguybx2 ztydi2sigiwrmstkykkguybx2}</td><td>（中継用）第２災害割増特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkguybx3 ztydi2sigiwrmstkykkguybx3}</td><td>（中継用）第２災害割増特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkguybx4 ztydi2sigiwrmstkykkguybx4}</td><td>（中継用）第２災害割増特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkguybx5 ztydi2sigiwrmstkykkguybx5}</td><td>（中継用）第２災害割増特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykkguybx1 ztydi2siginyuintkykkguybx1}</td><td>（中継用）第２災害入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykkguybx2 ztydi2siginyuintkykkguybx2}</td><td>（中継用）第２災害入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykkguybx3 ztydi2siginyuintkykkguybx3}</td><td>（中継用）第２災害入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykkguybx4 ztydi2siginyuintkykkguybx4}</td><td>（中継用）第２災害入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykkguybx5 ztydi2siginyuintkykkguybx5}</td><td>（中継用）第２災害入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykkguybx1 ztydi2sppinyuintkykkguybx1}</td><td>（中継用）第２疾病入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykkguybx2 ztydi2sppinyuintkykkguybx2}</td><td>（中継用）第２疾病入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykkguybx3 ztydi2sppinyuintkykkguybx3}</td><td>（中継用）第２疾病入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykkguybx4 ztydi2sppinyuintkykkguybx4}</td><td>（中継用）第２疾病入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykkguybx5 ztydi2sppinyuintkykkguybx5}</td><td>（中継用）第２疾病入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkguybx1 ztydi2sijnbyutkykkguybx1}</td><td>（中継用）第２成人病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkguybx2 ztydi2sijnbyutkykkguybx2}</td><td>（中継用）第２成人病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkguybx3 ztydi2sijnbyutkykkguybx3}</td><td>（中継用）第２成人病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkguybx4 ztydi2sijnbyutkykkguybx4}</td><td>（中継用）第２成人病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkguybx5 ztydi2sijnbyutkykkguybx5}</td><td>（中継用）第２成人病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuintkykkguyobix1 ztydai2tuintkykkguyobix1}</td><td>（中継用）第２通院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuintkykkguyobix2 ztydai2tuintkykkguyobix2}</td><td>（中継用）第２通院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuintkykkguyobix3 ztydai2tuintkykkguyobix3}</td><td>（中継用）第２通院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuintkykkguyobix4 ztydai2tuintkykkguyobix4}</td><td>（中継用）第２通院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuintkykkguyobix5 ztydai2tuintkykkguyobix5}</td><td>（中継用）第２通院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkguybx1 ztydi2jysisppitkykkguybx1}</td><td>（中継用）第２女性疾病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkguybx2 ztydi2jysisppitkykkguybx2}</td><td>（中継用）第２女性疾病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkguybx3 ztydi2jysisppitkykkguybx3}</td><td>（中継用）第２女性疾病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkguybx4 ztydi2jysisppitkykkguybx4}</td><td>（中継用）第２女性疾病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkguybx5 ztydi2jysisppitkykkguybx5}</td><td>（中継用）第２女性疾病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykkguybx1 ztydi2sugusnsyutkykkguybx1}</td><td>（中継用）第２総合損傷特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykkguybx2 ztydi2sugusnsyutkykkguybx2}</td><td>（中継用）第２総合損傷特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykkguybx3 ztydi2sugusnsyutkykkguybx3}</td><td>（中継用）第２総合損傷特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykkguybx4 ztydi2sugusnsyutkykkguybx4}</td><td>（中継用）第２総合損傷特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykkguybx5 ztydi2sugusnsyutkykkguybx5}</td><td>（中継用）第２総合損傷特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkguybx1 ztydi2sykkyuhtkykkguybx1}</td><td>（中継用）第２初期給付特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkguybx2 ztydi2sykkyuhtkykkguybx2}</td><td>（中継用）第２初期給付特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkguybx3 ztydi2sykkyuhtkykkguybx3}</td><td>（中継用）第２初期給付特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkguybx4 ztydi2sykkyuhtkykkguybx4}</td><td>（中継用）第２初期給付特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkguybx5 ztydi2sykkyuhtkykkguybx5}</td><td>（中継用）第２初期給付特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x1 ztysetaitehknsyuruiyobi1x1}</td><td>（中継用）セット相手保険種類予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x2 ztysetaitehknsyuruiyobi1x2}</td><td>（中継用）セット相手保険種類予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x3 ztysetaitehknsyuruiyobi1x3}</td><td>（中継用）セット相手保険種類予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x4 ztysetaitehknsyuruiyobi1x4}</td><td>（中継用）セット相手保険種類予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x5 ztysetaitehknsyuruiyobi1x5}</td><td>（中継用）セット相手保険種類予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x6 ztysetaitehknsyuruiyobi1x6}</td><td>（中継用）セット相手保険種類予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x7 ztysetaitehknsyuruiyobi1x7}</td><td>（中継用）セット相手保険種類予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x8 ztysetaitehknsyuruiyobi1x8}</td><td>（中継用）セット相手保険種類予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x9 ztysetaitehknsyuruiyobi1x9}</td><td>（中継用）セット相手保険種類予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x10 ztysetaitehknsyuruiyobi1x10}</td><td>（中継用）セット相手保険種類予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x11 ztysetaitehknsyuruiyobi1x11}</td><td>（中継用）セット相手保険種類予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x12 ztysetaitehknsyuruiyobi1x12}</td><td>（中継用）セット相手保険種類予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x13 ztysetaitehknsyuruiyobi1x13}</td><td>（中継用）セット相手保険種類予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x14 ztysetaitehknsyuruiyobi1x14}</td><td>（中継用）セット相手保険種類予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi1x15 ztysetaitehknsyuruiyobi1x15}</td><td>（中継用）セット相手保険種類予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x1 ztysetaitehknsyuruiyobi2x1}</td><td>（中継用）セット相手保険種類予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x2 ztysetaitehknsyuruiyobi2x2}</td><td>（中継用）セット相手保険種類予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x3 ztysetaitehknsyuruiyobi2x3}</td><td>（中継用）セット相手保険種類予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x4 ztysetaitehknsyuruiyobi2x4}</td><td>（中継用）セット相手保険種類予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x5 ztysetaitehknsyuruiyobi2x5}</td><td>（中継用）セット相手保険種類予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x6 ztysetaitehknsyuruiyobi2x6}</td><td>（中継用）セット相手保険種類予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x7 ztysetaitehknsyuruiyobi2x7}</td><td>（中継用）セット相手保険種類予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x8 ztysetaitehknsyuruiyobi2x8}</td><td>（中継用）セット相手保険種類予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x9 ztysetaitehknsyuruiyobi2x9}</td><td>（中継用）セット相手保険種類予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi2x10 ztysetaitehknsyuruiyobi2x10}</td><td>（中継用）セット相手保険種類予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x1 ztysetaitehknsyuruiyobi3x1}</td><td>（中継用）セット相手保険種類予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x2 ztysetaitehknsyuruiyobi3x2}</td><td>（中継用）セット相手保険種類予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x3 ztysetaitehknsyuruiyobi3x3}</td><td>（中継用）セット相手保険種類予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x4 ztysetaitehknsyuruiyobi3x4}</td><td>（中継用）セット相手保険種類予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x5 ztysetaitehknsyuruiyobi3x5}</td><td>（中継用）セット相手保険種類予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x6 ztysetaitehknsyuruiyobi3x6}</td><td>（中継用）セット相手保険種類予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x7 ztysetaitehknsyuruiyobi3x7}</td><td>（中継用）セット相手保険種類予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x8 ztysetaitehknsyuruiyobi3x8}</td><td>（中継用）セット相手保険種類予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x9 ztysetaitehknsyuruiyobi3x9}</td><td>（中継用）セット相手保険種類予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknsyuruiyobi3x10 ztysetaitehknsyuruiyobi3x10}</td><td>（中継用）セット相手保険種類予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Skeiksnbsgetujisr3Ty
 * @see     PKZT_Skeiksnbsgetujisr3Ty
 * @see     QZT_Skeiksnbsgetujisr3Ty
 * @see     GenQZT_Skeiksnbsgetujisr3Ty
 */
@MappedSuperclass
@Table(name=GenZT_Skeiksnbsgetujisr3Ty.TABLE_NAME)
@IdClass(value=PKZT_Skeiksnbsgetujisr3Ty.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Skeiksnbsgetujisr3Ty extends AbstractExDBEntity<ZT_Skeiksnbsgetujisr3Ty, PKZT_Skeiksnbsgetujisr3Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Skeiksnbsgetujisr3Ty";
    public static final String ZTYKTGYSYRYMD            = "ztyktgysyrymd";
    public static final String ZTYKTGYSYONO             = "ztyktgysyono";
    public static final String ZTYKTGYFILERENNO         = "ztyktgyfilerenno";
    public static final String ZTYBOSYUUKEIROKBN        = "ztybosyuukeirokbn";
    public static final String ZTYSYOKAIPCASHLESSNYUKINHYJ = "ztysyokaipcashlessnyukinhyj";
    public static final String ZTYKIGKYHSITIHSYUTKYKARIHYJ = "ztykigkyhsitihsyutkykarihyj";
    public static final String ZTYSYOKAIPSWINGRIYOUKBN  = "ztysyokaipswingriyoukbn";
    public static final String ZTYSKNJYUTUTKYKKYKKBN    = "ztysknjyututkykkykkbn";
    public static final String ZTYBOSYUUDAIRITENGYOUSYUKBN = "ztybosyuudairitengyousyukbn";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYTOKUSYUJIMUTORIATUKAIKBN = "ztytokusyujimutoriatukaikbn";
    public static final String ZTYPMENTKYKYUTKTBICDX1   = "ztypmentkykyutktbicdx1";
    public static final String ZTYPMENTKYKYUHTNPKKNX1   = "ztypmentkykyuhtnpkknx1";
    public static final String ZTYPMENTKYKYUTKTBICDX2   = "ztypmentkykyutktbicdx2";
    public static final String ZTYPMENTKYKYUHTNPKKNX2   = "ztypmentkykyuhtnpkknx2";
    public static final String ZTYHOSYOUIKKATUMNOSHYOUJI = "ztyhosyouikkatumnoshyouji";
    public static final String ZTYHSYUIKKTMINAOSIKAISU  = "ztyhsyuikktminaosikaisu";
    public static final String ZTYHSYUIKKTMNOSDFNYUKNHYJ = "ztyhsyuikktmnosdfnyuknhyj";
    public static final String ZTYIKKTMNOSKIKIYUTKYKP   = "ztyikktmnoskikiyutkykp";
    public static final String ZTYIKKTMNOSKIKIYUFNDSISTP = "ztyikktmnoskikiyufndsistp";
    public static final String ZTYSKNNJYNBKNSISNRT      = "ztysknnjynbknsisnrt";
    public static final String ZTYKANYUJISYONO          = "ztykanyujisyono";
    public static final String ZTYKANYUJIKYKYMD         = "ztykanyujikykymd";
    public static final String ZTYKANYUUJIHIHOKENSYAAGE = "ztykanyuujihihokensyaage";
    public static final String ZTYKANYUUJITENKANHYOUJI  = "ztykanyuujitenkanhyouji";
    public static final String ZTYKSNYUHSYUIKKTMINOSNNSKBN = "ztyksnyuhsyuikktminosnnskbn";
    public static final String ZTYAATUKAISYADIRTNBSYNNHYJ = "ztyaatukaisyadirtnbsynnhyj";
    public static final String ZTYBATKISYADIRTNBOSYUNINHYJ = "ztybatkisyadirtnbosyuninhyj";
    public static final String ZTYDIRTNAATUKAISYAKOJINCD = "ztydirtnaatukaisyakojincd";
    public static final String ZTYDIRTNBATUKAISYAKOJINCD = "ztydirtnbatukaisyakojincd";
    public static final String ZTYSYUUSEISYOUKEIKANENSUU = "ztysyuuseisyoukeikanensuu";
    public static final String ZTYSYURUIHNKUTKBTTRTKHYJ = "ztysyuruihnkutkbttrtkhyj";
    public static final String ZTYBNKTMEKYKTKYKHKJYUTIKBN = "ztybnktmekyktkykhkjyutikbn";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYTNKNSYOKAIPCLESSRIYOUHYJ = "ztytnknsyokaipclessriyouhyj";
    public static final String ZTYHRKTEISIKIBOUHYOUJI   = "ztyhrkteisikibouhyouji";
    public static final String ZTYBUNKATUGOSONZOKUKEIYAKUS = "ztybunkatugosonzokukeiyakus";
    public static final String ZTYMOSKIZKPHRKEKNGK      = "ztymoskizkphrkekngk";
    public static final String ZTYKEIZOKUPHURIKAEJIJIKAIP = "ztykeizokuphurikaejijikaip";
    public static final String ZTYBNKTMEKYKSYONO        = "ztybnktmekyksyono";
    public static final String ZTYBUNKATUMAEKEIYAKUKIHONS = "ztybunkatumaekeiyakukihons";
    public static final String ZTYBUNKATUMAEKEIYAKUSIBOUS = "ztybunkatumaekeiyakusibous";
    public static final String ZTYBNKTMEKYKMODS         = "ztybnktmekykmods";
    public static final String ZTYBNKTMEKYKSIGIWRMSTKYKS = "ztybnktmekyksigiwrmstkyks";
    public static final String ZTYBNKTMEKYKSYUGITKYKS   = "ztybnktmekyksyugitkyks";
    public static final String ZTYBNKTMKYKSIGINYINTKYKNTGK = "ztybnktmkyksiginyintkykntgk";
    public static final String ZTYBNKTMEKYKKNKUTKYKNTGK = "ztybnktmekykknkutkykntgk";
    public static final String ZTYBNKTMEKYKHNTIYUNBRIKNSNP = "ztybnktmekykhntiyunbriknsnp";
    public static final String ZTYDAI2NAIBUWARIMODOSIGAKU = "ztydai2naibuwarimodosigaku";
    public static final String ZTYTNKNGKYKKSTKGK        = "ztytnkngkykkstkgk";
    public static final String ZTYBNKTMEKYKKSTKGK       = "ztybnktmekykkstkgk";
    public static final String ZTYSONZOKUKYKKASITUKEGK  = "ztysonzokukykkasitukegk";
    public static final String ZTYHNGKMNRYOUJSITIHSYUKNGK = "ztyhngkmnryoujsitihsyukngk";
    public static final String ZTYHNGKSITIHSYUYUSYKYKP  = "ztyhngksitihsyuyusykykp";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX1X1 = "ztyhtnknkigmrsyukguybx1x1";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX2X1 = "ztyhtnknkigmrsyukguybx2x1";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX3X1 = "ztyhtnknkigmrsyukguybx3x1";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX4X1 = "ztyhtnknkigmrsyukguybx4x1";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX5X1 = "ztyhtnknkigmrsyukguybx5x1";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX1X2 = "ztyhtnknkigmrsyukguybx1x2";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX2X2 = "ztyhtnknkigmrsyukguybx2x2";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX3X2 = "ztyhtnknkigmrsyukguybx3x2";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX4X2 = "ztyhtnknkigmrsyukguybx4x2";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX5X2 = "ztyhtnknkigmrsyukguybx5x2";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX1X3 = "ztyhtnknkigmrsyukguybx1x3";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX2X3 = "ztyhtnknkigmrsyukguybx2x3";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX3X3 = "ztyhtnknkigmrsyukguybx3x3";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX4X3 = "ztyhtnknkigmrsyukguybx4x3";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX5X3 = "ztyhtnknkigmrsyukguybx5x3";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX1X4 = "ztyhtnknkigmrsyukguybx1x4";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX2X4 = "ztyhtnknkigmrsyukguybx2x4";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX3X4 = "ztyhtnknkigmrsyukguybx3x4";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX4X4 = "ztyhtnknkigmrsyukguybx4x4";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX5X4 = "ztyhtnknkigmrsyukguybx5x4";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX1X5 = "ztyhtnknkigmrsyukguybx1x5";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX2X5 = "ztyhtnknkigmrsyukguybx2x5";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX3X5 = "ztyhtnknkigmrsyukguybx3x5";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX4X5 = "ztyhtnknkigmrsyukguybx4x5";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX5X5 = "ztyhtnknkigmrsyukguybx5x5";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX1X6 = "ztyhtnknkigmrsyukguybx1x6";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX2X6 = "ztyhtnknkigmrsyukguybx2x6";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX3X6 = "ztyhtnknkigmrsyukguybx3x6";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX4X6 = "ztyhtnknkigmrsyukguybx4x6";
    public static final String ZTYHTNKNKIGMRSYUKGUYBX5X6 = "ztyhtnknkigmrsyukguybx5x6";
    public static final String ZTYYOBIV1X3              = "ztyyobiv1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYMARUTEIKIGOUYOBIX1    = "ztymaruteikigouyobix1";
    public static final String ZTYMARUTEIKIGOUYOBIX2    = "ztymaruteikigouyobix2";
    public static final String ZTYMARUTEIKIGOUYOBIX3    = "ztymaruteikigouyobix3";
    public static final String ZTYMARUTEIKIGOUYOBIX4    = "ztymaruteikigouyobix4";
    public static final String ZTYMARUTEIKIGOUYOBIX5    = "ztymaruteikigouyobix5";
    public static final String ZTYMARUYOUKIGOUYOBIX1    = "ztymaruyoukigouyobix1";
    public static final String ZTYMARUYOUKIGOUYOBIX2    = "ztymaruyoukigouyobix2";
    public static final String ZTYMARUYOUKIGOUYOBIX3    = "ztymaruyoukigouyobix3";
    public static final String ZTYMARUYOUKIGOUYOBIX4    = "ztymaruyoukigouyobix4";
    public static final String ZTYMARUYOUKIGOUYOBIX5    = "ztymaruyoukigouyobix5";
    public static final String ZTYMARUSYUUKIGOUYOBIX1   = "ztymarusyuukigouyobix1";
    public static final String ZTYMARUSYUUKIGOUYOBIX2   = "ztymarusyuukigouyobix2";
    public static final String ZTYMARUSYUUKIGOUYOBIX3   = "ztymarusyuukigouyobix3";
    public static final String ZTYMARUSYUUKIGOUYOBIX4   = "ztymarusyuukigouyobix4";
    public static final String ZTYMARUSYUUKIGOUYOBIX5   = "ztymarusyuukigouyobix5";
    public static final String ZTYTOKUTEIKIGOUYOBIX1    = "ztytokuteikigouyobix1";
    public static final String ZTYTOKUTEIKIGOUYOBIX2    = "ztytokuteikigouyobix2";
    public static final String ZTYTOKUTEIKIGOUYOBIX3    = "ztytokuteikigouyobix3";
    public static final String ZTYTOKUTEIKIGOUYOBIX4    = "ztytokuteikigouyobix4";
    public static final String ZTYTOKUTEIKIGOUYOBIX5    = "ztytokuteikigouyobix5";
    public static final String ZTYKZKMRTIKGUYBX1X1      = "ztykzkmrtikguybx1x1";
    public static final String ZTYKZKMRTIKGUYBX2X1      = "ztykzkmrtikguybx2x1";
    public static final String ZTYKZKMRTIKGUYBX3X1      = "ztykzkmrtikguybx3x1";
    public static final String ZTYKZKMRTIKGUYBX4X1      = "ztykzkmrtikguybx4x1";
    public static final String ZTYKZKMRTIKGUYBX5X1      = "ztykzkmrtikguybx5x1";
    public static final String ZTYKZKMRTIKGUYBX1X2      = "ztykzkmrtikguybx1x2";
    public static final String ZTYKZKMRTIKGUYBX2X2      = "ztykzkmrtikguybx2x2";
    public static final String ZTYKZKMRTIKGUYBX3X2      = "ztykzkmrtikguybx3x2";
    public static final String ZTYKZKMRTIKGUYBX4X2      = "ztykzkmrtikguybx4x2";
    public static final String ZTYKZKMRTIKGUYBX5X2      = "ztykzkmrtikguybx5x2";
    public static final String ZTYKZKMRTIKGUYBX1X3      = "ztykzkmrtikguybx1x3";
    public static final String ZTYKZKMRTIKGUYBX2X3      = "ztykzkmrtikguybx2x3";
    public static final String ZTYKZKMRTIKGUYBX3X3      = "ztykzkmrtikguybx3x3";
    public static final String ZTYKZKMRTIKGUYBX4X3      = "ztykzkmrtikguybx4x3";
    public static final String ZTYKZKMRTIKGUYBX5X3      = "ztykzkmrtikguybx5x3";
    public static final String ZTYKZKMRTIKGUYBX1X4      = "ztykzkmrtikguybx1x4";
    public static final String ZTYKZKMRTIKGUYBX2X4      = "ztykzkmrtikguybx2x4";
    public static final String ZTYKZKMRTIKGUYBX3X4      = "ztykzkmrtikguybx3x4";
    public static final String ZTYKZKMRTIKGUYBX4X4      = "ztykzkmrtikguybx4x4";
    public static final String ZTYKZKMRTIKGUYBX5X4      = "ztykzkmrtikguybx5x4";
    public static final String ZTYKZKMRTIKGUYBX1X5      = "ztykzkmrtikguybx1x5";
    public static final String ZTYKZKMRTIKGUYBX2X5      = "ztykzkmrtikguybx2x5";
    public static final String ZTYKZKMRTIKGUYBX3X5      = "ztykzkmrtikguybx3x5";
    public static final String ZTYKZKMRTIKGUYBX4X5      = "ztykzkmrtikguybx4x5";
    public static final String ZTYKZKMRTIKGUYBX5X5      = "ztykzkmrtikguybx5x5";
    public static final String ZTYKZKMRTIKGUYBX1X6      = "ztykzkmrtikguybx1x6";
    public static final String ZTYKZKMRTIKGUYBX2X6      = "ztykzkmrtikguybx2x6";
    public static final String ZTYKZKMRTIKGUYBX3X6      = "ztykzkmrtikguybx3x6";
    public static final String ZTYKZKMRTIKGUYBX4X6      = "ztykzkmrtikguybx4x6";
    public static final String ZTYKZKMRTIKGUYBX5X6      = "ztykzkmrtikguybx5x6";
    public static final String ZTYKZKMRTIKGUYBX1X7      = "ztykzkmrtikguybx1x7";
    public static final String ZTYKZKMRTIKGUYBX2X7      = "ztykzkmrtikguybx2x7";
    public static final String ZTYKZKMRTIKGUYBX3X7      = "ztykzkmrtikguybx3x7";
    public static final String ZTYKZKMRTIKGUYBX4X7      = "ztykzkmrtikguybx4x7";
    public static final String ZTYKZKMRTIKGUYBX5X7      = "ztykzkmrtikguybx5x7";
    public static final String ZTYKZKMRTIKGUYBX1X8      = "ztykzkmrtikguybx1x8";
    public static final String ZTYKZKMRTIKGUYBX2X8      = "ztykzkmrtikguybx2x8";
    public static final String ZTYKZKMRTIKGUYBX3X8      = "ztykzkmrtikguybx3x8";
    public static final String ZTYKZKMRTIKGUYBX4X8      = "ztykzkmrtikguybx4x8";
    public static final String ZTYKZKMRTIKGUYBX5X8      = "ztykzkmrtikguybx5x8";
    public static final String ZTYKZKMRTIKGUYBX1X9      = "ztykzkmrtikguybx1x9";
    public static final String ZTYKZKMRTIKGUYBX2X9      = "ztykzkmrtikguybx2x9";
    public static final String ZTYKZKMRTIKGUYBX3X9      = "ztykzkmrtikguybx3x9";
    public static final String ZTYKZKMRTIKGUYBX4X9      = "ztykzkmrtikguybx4x9";
    public static final String ZTYKZKMRTIKGUYBX5X9      = "ztykzkmrtikguybx5x9";
    public static final String ZTYKZKMRTIKGUYBX1X10     = "ztykzkmrtikguybx1x10";
    public static final String ZTYKZKMRTIKGUYBX2X10     = "ztykzkmrtikguybx2x10";
    public static final String ZTYKZKMRTIKGUYBX3X10     = "ztykzkmrtikguybx3x10";
    public static final String ZTYKZKMRTIKGUYBX4X10     = "ztykzkmrtikguybx4x10";
    public static final String ZTYKZKMRTIKGUYBX5X10     = "ztykzkmrtikguybx5x10";
    public static final String ZTYSYUGITTKYKKGUYBX1     = "ztysyugittkykkguybx1";
    public static final String ZTYSYUGITTKYKKGUYBX2     = "ztysyugittkykkguybx2";
    public static final String ZTYSYUGITTKYKKGUYBX3     = "ztysyugittkykkguybx3";
    public static final String ZTYSYUGITTKYKKGUYBX4     = "ztysyugittkykkguybx4";
    public static final String ZTYSYUGITTKYKKGUYBX5     = "ztysyugittkykkguybx5";
    public static final String ZTYSIGIWRMSTKYKKGUYBX1   = "ztysigiwrmstkykkguybx1";
    public static final String ZTYSIGIWRMSTKYKKGUYBX2   = "ztysigiwrmstkykkguybx2";
    public static final String ZTYSIGIWRMSTKYKKGUYBX3   = "ztysigiwrmstkykkguybx3";
    public static final String ZTYSIGIWRMSTKYKKGUYBX4   = "ztysigiwrmstkykkguybx4";
    public static final String ZTYSIGIWRMSTKYKKGUYBX5   = "ztysigiwrmstkykkguybx5";
    public static final String ZTYSIGINYUINTKYKKGUYBX1  = "ztysiginyuintkykkguybx1";
    public static final String ZTYSIGINYUINTKYKKGUYBX2  = "ztysiginyuintkykkguybx2";
    public static final String ZTYSIGINYUINTKYKKGUYBX3  = "ztysiginyuintkykkguybx3";
    public static final String ZTYSIGINYUINTKYKKGUYBX4  = "ztysiginyuintkykkguybx4";
    public static final String ZTYSIGINYUINTKYKKGUYBX5  = "ztysiginyuintkykkguybx5";
    public static final String ZTYSPPINYUINTKYKKGUYBX1  = "ztysppinyuintkykkguybx1";
    public static final String ZTYSPPINYUINTKYKKGUYBX2  = "ztysppinyuintkykkguybx2";
    public static final String ZTYSPPINYUINTKYKKGUYBX3  = "ztysppinyuintkykkguybx3";
    public static final String ZTYSPPINYUINTKYKKGUYBX4  = "ztysppinyuintkykkguybx4";
    public static final String ZTYSPPINYUINTKYKKGUYBX5  = "ztysppinyuintkykkguybx5";
    public static final String ZTYSIJNBYUTKYKKGUYBX1    = "ztysijnbyutkykkguybx1";
    public static final String ZTYSIJNBYUTKYKKGUYBX2    = "ztysijnbyutkykkguybx2";
    public static final String ZTYSIJNBYUTKYKKGUYBX3    = "ztysijnbyutkykkguybx3";
    public static final String ZTYSIJNBYUTKYKKGUYBX4    = "ztysijnbyutkykkguybx4";
    public static final String ZTYSIJNBYUTKYKKGUYBX5    = "ztysijnbyutkykkguybx5";
    public static final String ZTYKZKIRYOUTKYKKGUYBX1   = "ztykzkiryoutkykkguybx1";
    public static final String ZTYKZKIRYOUTKYKKGUYBX2   = "ztykzkiryoutkykkguybx2";
    public static final String ZTYKZKIRYOUTKYKKGUYBX3   = "ztykzkiryoutkykkguybx3";
    public static final String ZTYKZKIRYOUTKYKKGUYBX4   = "ztykzkiryoutkykkguybx4";
    public static final String ZTYKZKIRYOUTKYKKGUYBX5   = "ztykzkiryoutkykkguybx5";
    public static final String ZTYSYKKYUHTKYKKGUYBX1    = "ztysykkyuhtkykkguybx1";
    public static final String ZTYSYKKYUHTKYKKGUYBX2    = "ztysykkyuhtkykkguybx2";
    public static final String ZTYSYKKYUHTKYKKGUYBX3    = "ztysykkyuhtkykkguybx3";
    public static final String ZTYSYKKYUHTKYKKGUYBX4    = "ztysykkyuhtkykkguybx4";
    public static final String ZTYSYKKYUHTKYKKGUYBX5    = "ztysykkyuhtkykkguybx5";
    public static final String ZTYNKDTMRTIKGUYOBIX1     = "ztynkdtmrtikguyobix1";
    public static final String ZTYNKDTMRTIKGUYOBIX2     = "ztynkdtmrtikguyobix2";
    public static final String ZTYNKDTMRTIKGUYOBIX3     = "ztynkdtmrtikguyobix3";
    public static final String ZTYNKDTMRTIKGUYOBIX4     = "ztynkdtmrtikguyobix4";
    public static final String ZTYNKDTMRTIKGUYOBIX5     = "ztynkdtmrtikguyobix5";
    public static final String ZTYNKDATETOKUTEIKGUYOBIX1 = "ztynkdatetokuteikguyobix1";
    public static final String ZTYNKDATETOKUTEIKGUYOBIX2 = "ztynkdatetokuteikguyobix2";
    public static final String ZTYNKDATETOKUTEIKGUYOBIX3 = "ztynkdatetokuteikguyobix3";
    public static final String ZTYNKDATETOKUTEIKGUYOBIX4 = "ztynkdatetokuteikguyobix4";
    public static final String ZTYNKDATETOKUTEIKGUYOBIX5 = "ztynkdatetokuteikguyobix5";
    public static final String ZTYKAIGONKDTMRTIKGUYOBIX1 = "ztykaigonkdtmrtikguyobix1";
    public static final String ZTYKAIGONKDTMRTIKGUYOBIX2 = "ztykaigonkdtmrtikguyobix2";
    public static final String ZTYKAIGONKDTMRTIKGUYOBIX3 = "ztykaigonkdtmrtikguyobix3";
    public static final String ZTYKAIGONKDTMRTIKGUYOBIX4 = "ztykaigonkdtmrtikguyobix4";
    public static final String ZTYKAIGONKDTMRTIKGUYOBIX5 = "ztykaigonkdtmrtikguyobix5";
    public static final String ZTYKAIGONKDTTKTIKGUYOBIX1 = "ztykaigonkdttktikguyobix1";
    public static final String ZTYKAIGONKDTTKTIKGUYOBIX2 = "ztykaigonkdttktikguyobix2";
    public static final String ZTYKAIGONKDTTKTIKGUYOBIX3 = "ztykaigonkdttktikguyobix3";
    public static final String ZTYKAIGONKDTTKTIKGUYOBIX4 = "ztykaigonkdttktikguyobix4";
    public static final String ZTYKAIGONKDTTKTIKGUYOBIX5 = "ztykaigonkdttktikguyobix5";
    public static final String ZTYKAIGOMARUTEIKIGOUYOBIX1 = "ztykaigomaruteikigouyobix1";
    public static final String ZTYKAIGOMARUTEIKIGOUYOBIX2 = "ztykaigomaruteikigouyobix2";
    public static final String ZTYKAIGOMARUTEIKIGOUYOBIX3 = "ztykaigomaruteikigouyobix3";
    public static final String ZTYKAIGOMARUTEIKIGOUYOBIX4 = "ztykaigomaruteikigouyobix4";
    public static final String ZTYKAIGOMARUTEIKIGOUYOBIX5 = "ztykaigomaruteikigouyobix5";
    public static final String ZTYKAIGOTOKUTEIKIGOUYOBIX1 = "ztykaigotokuteikigouyobix1";
    public static final String ZTYKAIGOTOKUTEIKIGOUYOBIX2 = "ztykaigotokuteikigouyobix2";
    public static final String ZTYKAIGOTOKUTEIKIGOUYOBIX3 = "ztykaigotokuteikigouyobix3";
    public static final String ZTYKAIGOTOKUTEIKIGOUYOBIX4 = "ztykaigotokuteikigouyobix4";
    public static final String ZTYKAIGOTOKUTEIKIGOUYOBIX5 = "ztykaigotokuteikigouyobix5";
    public static final String ZTYSIZNMRTIKGUYBX1       = "ztysiznmrtikguybx1";
    public static final String ZTYSIZNMRTIKGUYBX2       = "ztysiznmrtikguybx2";
    public static final String ZTYSIZNMRTIKGUYBX3       = "ztysiznmrtikguybx3";
    public static final String ZTYSIZNMRTIKGUYBX4       = "ztysiznmrtikguybx4";
    public static final String ZTYSIZNMRTIKGUYBX5       = "ztysiznmrtikguybx5";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX1 = "ztyteigenmaruteikigouyobix1";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX2 = "ztyteigenmaruteikigouyobix2";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX3 = "ztyteigenmaruteikigouyobix3";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX4 = "ztyteigenmaruteikigouyobix4";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX5 = "ztyteigenmaruteikigouyobix5";
    public static final String ZTYTEIGENTOKUTEIKIGOUYOBIX1 = "ztyteigentokuteikigouyobix1";
    public static final String ZTYTEIGENTOKUTEIKIGOUYOBIX2 = "ztyteigentokuteikigouyobix2";
    public static final String ZTYTEIGENTOKUTEIKIGOUYOBIX3 = "ztyteigentokuteikigouyobix3";
    public static final String ZTYTEIGENTOKUTEIKIGOUYOBIX4 = "ztyteigentokuteikigouyobix4";
    public static final String ZTYTEIGENTOKUTEIKIGOUYOBIX5 = "ztyteigentokuteikigouyobix5";
    public static final String ZTYKIGTIGNMRTIKGUYBX1    = "ztykigtignmrtikguybx1";
    public static final String ZTYKIGTIGNMRTIKGUYBX2    = "ztykigtignmrtikguybx2";
    public static final String ZTYKIGTIGNMRTIKGUYBX3    = "ztykigtignmrtikguybx3";
    public static final String ZTYKIGTIGNMRTIKGUYBX4    = "ztykigtignmrtikguybx4";
    public static final String ZTYKIGTIGNMRTIKGUYBX5    = "ztykigtignmrtikguybx5";
    public static final String ZTYKIGTIGNTKTIKGUYBX1    = "ztykigtigntktikguybx1";
    public static final String ZTYKIGTIGNTKTIKGUYBX2    = "ztykigtigntktikguybx2";
    public static final String ZTYKIGTIGNTKTIKGUYBX3    = "ztykigtigntktikguybx3";
    public static final String ZTYKIGTIGNTKTIKGUYBX4    = "ztykigtigntktikguybx4";
    public static final String ZTYKIGTIGNTKTIKGUYBX5    = "ztykigtigntktikguybx5";
    public static final String ZTYTUUINTOKUYAKUKIGOUYOBIX1 = "ztytuuintokuyakukigouyobix1";
    public static final String ZTYTUUINTOKUYAKUKIGOUYOBIX2 = "ztytuuintokuyakukigouyobix2";
    public static final String ZTYTUUINTOKUYAKUKIGOUYOBIX3 = "ztytuuintokuyakukigouyobix3";
    public static final String ZTYTUUINTOKUYAKUKIGOUYOBIX4 = "ztytuuintokuyakukigouyobix4";
    public static final String ZTYTUUINTOKUYAKUKIGOUYOBIX5 = "ztytuuintokuyakukigouyobix5";
    public static final String ZTYJYSISPPITKYKKGUYOBIX1 = "ztyjysisppitkykkguyobix1";
    public static final String ZTYJYSISPPITKYKKGUYOBIX2 = "ztyjysisppitkykkguyobix2";
    public static final String ZTYJYSISPPITKYKKGUYOBIX3 = "ztyjysisppitkykkguyobix3";
    public static final String ZTYJYSISPPITKYKKGUYOBIX4 = "ztyjysisppitkykkguyobix4";
    public static final String ZTYJYSISPPITKYKKGUYOBIX5 = "ztyjysisppitkykkguyobix5";
    public static final String ZTYTKSTTKYKKGUYBX1       = "ztytksttkykkguybx1";
    public static final String ZTYTKSTTKYKKGUYBX2       = "ztytksttkykkguybx2";
    public static final String ZTYTKSTTKYKKGUYBX3       = "ztytksttkykkguybx3";
    public static final String ZTYTKSTTKYKKGUYBX4       = "ztytksttkykkguybx4";
    public static final String ZTYTKSTTKYKKGUYBX5       = "ztytksttkykkguybx5";
    public static final String ZTYDI2TKSTTKYKKGUYBX1    = "ztydi2tksttkykkguybx1";
    public static final String ZTYDI2TKSTTKYKKGUYBX2    = "ztydi2tksttkykkguybx2";
    public static final String ZTYDI2TKSTTKYKKGUYBX3    = "ztydi2tksttkykkguybx3";
    public static final String ZTYDI2TKSTTKYKKGUYBX4    = "ztydi2tksttkykkguybx4";
    public static final String ZTYDI2TKSTTKYKKGUYBX5    = "ztydi2tksttkykkguybx5";
    public static final String ZTYMNSTTKYKKGUYBX1       = "ztymnsttkykkguybx1";
    public static final String ZTYMNSTTKYKKGUYBX2       = "ztymnsttkykkguybx2";
    public static final String ZTYMNSTTKYKKGUYBX3       = "ztymnsttkykkguybx3";
    public static final String ZTYMNSTTKYKKGUYBX4       = "ztymnsttkykkguybx4";
    public static final String ZTYMNSTTKYKKGUYBX5       = "ztymnsttkykkguybx5";
    public static final String ZTYDI2MNSTTKYKKGUYBX1    = "ztydi2mnsttkykkguybx1";
    public static final String ZTYDI2MNSTTKYKKGUYBX2    = "ztydi2mnsttkykkguybx2";
    public static final String ZTYDI2MNSTTKYKKGUYBX3    = "ztydi2mnsttkykkguybx3";
    public static final String ZTYDI2MNSTTKYKKGUYBX4    = "ztydi2mnsttkykkguybx4";
    public static final String ZTYDI2MNSTTKYKKGUYBX5    = "ztydi2mnsttkykkguybx5";
    public static final String ZTYSUGUSNSYUTKYKKGUYBX1  = "ztysugusnsyutkykkguybx1";
    public static final String ZTYSUGUSNSYUTKYKKGUYBX2  = "ztysugusnsyutkykkguybx2";
    public static final String ZTYSUGUSNSYUTKYKKGUYBX3  = "ztysugusnsyutkykkguybx3";
    public static final String ZTYSUGUSNSYUTKYKKGUYBX4  = "ztysugusnsyutkykkguybx4";
    public static final String ZTYSUGUSNSYUTKYKKGUYBX5  = "ztysugusnsyutkykkguybx5";
    public static final String ZTYKAIGONKTKYKKGUYOBIX1  = "ztykaigonktkykkguyobix1";
    public static final String ZTYKAIGONKTKYKKGUYOBIX2  = "ztykaigonktkykkguyobix2";
    public static final String ZTYKAIGONKTKYKKGUYOBIX3  = "ztykaigonktkykkguyobix3";
    public static final String ZTYKAIGONKTKYKKGUYOBIX4  = "ztykaigonktkykkguyobix4";
    public static final String ZTYKAIGONKTKYKKGUYOBIX5  = "ztykaigonktkykkguyobix5";
    public static final String ZTYITJBRKIGNKTKYKKGUYBX1 = "ztyitjbrkignktkykkguybx1";
    public static final String ZTYITJBRKIGNKTKYKKGUYBX2 = "ztyitjbrkignktkykkguybx2";
    public static final String ZTYITJBRKIGNKTKYKKGUYBX3 = "ztyitjbrkignktkykkguybx3";
    public static final String ZTYITJBRKIGNKTKYKKGUYBX4 = "ztyitjbrkignktkykkguybx4";
    public static final String ZTYITJBRKIGNKTKYKKGUYBX5 = "ztyitjbrkignktkykkguybx5";
    public static final String ZTYDI2SYUGITKYKKGUYBX1   = "ztydi2syugitkykkguybx1";
    public static final String ZTYDI2SYUGITKYKKGUYBX2   = "ztydi2syugitkykkguybx2";
    public static final String ZTYDI2SYUGITKYKKGUYBX3   = "ztydi2syugitkykkguybx3";
    public static final String ZTYDI2SYUGITKYKKGUYBX4   = "ztydi2syugitkykkguybx4";
    public static final String ZTYDI2SYUGITKYKKGUYBX5   = "ztydi2syugitkykkguybx5";
    public static final String ZTYDI2SIGIWRMSTKYKKGUYBX1 = "ztydi2sigiwrmstkykkguybx1";
    public static final String ZTYDI2SIGIWRMSTKYKKGUYBX2 = "ztydi2sigiwrmstkykkguybx2";
    public static final String ZTYDI2SIGIWRMSTKYKKGUYBX3 = "ztydi2sigiwrmstkykkguybx3";
    public static final String ZTYDI2SIGIWRMSTKYKKGUYBX4 = "ztydi2sigiwrmstkykkguybx4";
    public static final String ZTYDI2SIGIWRMSTKYKKGUYBX5 = "ztydi2sigiwrmstkykkguybx5";
    public static final String ZTYDI2SIGINYUINTKYKKGUYBX1 = "ztydi2siginyuintkykkguybx1";
    public static final String ZTYDI2SIGINYUINTKYKKGUYBX2 = "ztydi2siginyuintkykkguybx2";
    public static final String ZTYDI2SIGINYUINTKYKKGUYBX3 = "ztydi2siginyuintkykkguybx3";
    public static final String ZTYDI2SIGINYUINTKYKKGUYBX4 = "ztydi2siginyuintkykkguybx4";
    public static final String ZTYDI2SIGINYUINTKYKKGUYBX5 = "ztydi2siginyuintkykkguybx5";
    public static final String ZTYDI2SPPINYUINTKYKKGUYBX1 = "ztydi2sppinyuintkykkguybx1";
    public static final String ZTYDI2SPPINYUINTKYKKGUYBX2 = "ztydi2sppinyuintkykkguybx2";
    public static final String ZTYDI2SPPINYUINTKYKKGUYBX3 = "ztydi2sppinyuintkykkguybx3";
    public static final String ZTYDI2SPPINYUINTKYKKGUYBX4 = "ztydi2sppinyuintkykkguybx4";
    public static final String ZTYDI2SPPINYUINTKYKKGUYBX5 = "ztydi2sppinyuintkykkguybx5";
    public static final String ZTYDI2SIJNBYUTKYKKGUYBX1 = "ztydi2sijnbyutkykkguybx1";
    public static final String ZTYDI2SIJNBYUTKYKKGUYBX2 = "ztydi2sijnbyutkykkguybx2";
    public static final String ZTYDI2SIJNBYUTKYKKGUYBX3 = "ztydi2sijnbyutkykkguybx3";
    public static final String ZTYDI2SIJNBYUTKYKKGUYBX4 = "ztydi2sijnbyutkykkguybx4";
    public static final String ZTYDI2SIJNBYUTKYKKGUYBX5 = "ztydi2sijnbyutkykkguybx5";
    public static final String ZTYDAI2TUINTKYKKGUYOBIX1 = "ztydai2tuintkykkguyobix1";
    public static final String ZTYDAI2TUINTKYKKGUYOBIX2 = "ztydai2tuintkykkguyobix2";
    public static final String ZTYDAI2TUINTKYKKGUYOBIX3 = "ztydai2tuintkykkguyobix3";
    public static final String ZTYDAI2TUINTKYKKGUYOBIX4 = "ztydai2tuintkykkguyobix4";
    public static final String ZTYDAI2TUINTKYKKGUYOBIX5 = "ztydai2tuintkykkguyobix5";
    public static final String ZTYDI2JYSISPPITKYKKGUYBX1 = "ztydi2jysisppitkykkguybx1";
    public static final String ZTYDI2JYSISPPITKYKKGUYBX2 = "ztydi2jysisppitkykkguybx2";
    public static final String ZTYDI2JYSISPPITKYKKGUYBX3 = "ztydi2jysisppitkykkguybx3";
    public static final String ZTYDI2JYSISPPITKYKKGUYBX4 = "ztydi2jysisppitkykkguybx4";
    public static final String ZTYDI2JYSISPPITKYKKGUYBX5 = "ztydi2jysisppitkykkguybx5";
    public static final String ZTYDI2SUGUSNSYUTKYKKGUYBX1 = "ztydi2sugusnsyutkykkguybx1";
    public static final String ZTYDI2SUGUSNSYUTKYKKGUYBX2 = "ztydi2sugusnsyutkykkguybx2";
    public static final String ZTYDI2SUGUSNSYUTKYKKGUYBX3 = "ztydi2sugusnsyutkykkguybx3";
    public static final String ZTYDI2SUGUSNSYUTKYKKGUYBX4 = "ztydi2sugusnsyutkykkguybx4";
    public static final String ZTYDI2SUGUSNSYUTKYKKGUYBX5 = "ztydi2sugusnsyutkykkguybx5";
    public static final String ZTYDI2SYKKYUHTKYKKGUYBX1 = "ztydi2sykkyuhtkykkguybx1";
    public static final String ZTYDI2SYKKYUHTKYKKGUYBX2 = "ztydi2sykkyuhtkykkguybx2";
    public static final String ZTYDI2SYKKYUHTKYKKGUYBX3 = "ztydi2sykkyuhtkykkguybx3";
    public static final String ZTYDI2SYKKYUHTKYKKGUYBX4 = "ztydi2sykkyuhtkykkguybx4";
    public static final String ZTYDI2SYKKYUHTKYKKGUYBX5 = "ztydi2sykkyuhtkykkguybx5";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X1 = "ztysetaitehknsyuruiyobi1x1";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X2 = "ztysetaitehknsyuruiyobi1x2";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X3 = "ztysetaitehknsyuruiyobi1x3";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X4 = "ztysetaitehknsyuruiyobi1x4";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X5 = "ztysetaitehknsyuruiyobi1x5";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X6 = "ztysetaitehknsyuruiyobi1x6";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X7 = "ztysetaitehknsyuruiyobi1x7";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X8 = "ztysetaitehknsyuruiyobi1x8";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X9 = "ztysetaitehknsyuruiyobi1x9";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X10 = "ztysetaitehknsyuruiyobi1x10";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X11 = "ztysetaitehknsyuruiyobi1x11";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X12 = "ztysetaitehknsyuruiyobi1x12";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X13 = "ztysetaitehknsyuruiyobi1x13";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X14 = "ztysetaitehknsyuruiyobi1x14";
    public static final String ZTYSETAITEHKNSYURUIYOBI1X15 = "ztysetaitehknsyuruiyobi1x15";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X1 = "ztysetaitehknsyuruiyobi2x1";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X2 = "ztysetaitehknsyuruiyobi2x2";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X3 = "ztysetaitehknsyuruiyobi2x3";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X4 = "ztysetaitehknsyuruiyobi2x4";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X5 = "ztysetaitehknsyuruiyobi2x5";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X6 = "ztysetaitehknsyuruiyobi2x6";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X7 = "ztysetaitehknsyuruiyobi2x7";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X8 = "ztysetaitehknsyuruiyobi2x8";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X9 = "ztysetaitehknsyuruiyobi2x9";
    public static final String ZTYSETAITEHKNSYURUIYOBI2X10 = "ztysetaitehknsyuruiyobi2x10";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X1 = "ztysetaitehknsyuruiyobi3x1";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X2 = "ztysetaitehknsyuruiyobi3x2";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X3 = "ztysetaitehknsyuruiyobi3x3";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X4 = "ztysetaitehknsyuruiyobi3x4";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X5 = "ztysetaitehknsyuruiyobi3x5";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X6 = "ztysetaitehknsyuruiyobi3x6";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X7 = "ztysetaitehknsyuruiyobi3x7";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X8 = "ztysetaitehknsyuruiyobi3x8";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X9 = "ztysetaitehknsyuruiyobi3x9";
    public static final String ZTYSETAITEHKNSYURUIYOBI3X10 = "ztysetaitehknsyuruiyobi3x10";

    private final PKZT_Skeiksnbsgetujisr3Ty primaryKey;

    public GenZT_Skeiksnbsgetujisr3Ty() {
        primaryKey = new PKZT_Skeiksnbsgetujisr3Ty();
    }

    public GenZT_Skeiksnbsgetujisr3Ty(String pZtyktgysyono) {
        primaryKey = new PKZT_Skeiksnbsgetujisr3Ty(pZtyktgysyono);
    }

    @Transient
    @Override
    public PKZT_Skeiksnbsgetujisr3Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Skeiksnbsgetujisr3Ty> getMetaClass() {
        return QZT_Skeiksnbsgetujisr3Ty.class;
    }

    private String ztyktgysyrymd;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKTGYSYRYMD)
    public String getZtyktgysyrymd() {
        return ztyktgysyrymd;
    }

    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        ztyktgysyrymd = pZtyktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKTGYSYONO)
    public String getZtyktgysyono() {
        return getPrimaryKey().getZtyktgysyono();
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        getPrimaryKey().setZtyktgysyono(pZtyktgysyono);
    }

    private String ztyktgyfilerenno;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKTGYFILERENNO)
    public String getZtyktgyfilerenno() {
        return ztyktgyfilerenno;
    }

    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        ztyktgyfilerenno = pZtyktgyfilerenno;
    }

    private String ztybosyuukeirokbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBOSYUUKEIROKBN)
    public String getZtybosyuukeirokbn() {
        return ztybosyuukeirokbn;
    }

    public void setZtybosyuukeirokbn(String pZtybosyuukeirokbn) {
        ztybosyuukeirokbn = pZtybosyuukeirokbn;
    }

    private String ztysyokaipcashlessnyukinhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYOKAIPCASHLESSNYUKINHYJ)
    public String getZtysyokaipcashlessnyukinhyj() {
        return ztysyokaipcashlessnyukinhyj;
    }

    public void setZtysyokaipcashlessnyukinhyj(String pZtysyokaipcashlessnyukinhyj) {
        ztysyokaipcashlessnyukinhyj = pZtysyokaipcashlessnyukinhyj;
    }

    private String ztykigkyhsitihsyutkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGKYHSITIHSYUTKYKARIHYJ)
    public String getZtykigkyhsitihsyutkykarihyj() {
        return ztykigkyhsitihsyutkykarihyj;
    }

    public void setZtykigkyhsitihsyutkykarihyj(String pZtykigkyhsitihsyutkykarihyj) {
        ztykigkyhsitihsyutkykarihyj = pZtykigkyhsitihsyutkykarihyj;
    }

    private String ztysyokaipswingriyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYOKAIPSWINGRIYOUKBN)
    public String getZtysyokaipswingriyoukbn() {
        return ztysyokaipswingriyoukbn;
    }

    public void setZtysyokaipswingriyoukbn(String pZtysyokaipswingriyoukbn) {
        ztysyokaipswingriyoukbn = pZtysyokaipswingriyoukbn;
    }

    private String ztysknjyututkykkykkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSKNJYUTUTKYKKYKKBN)
    public String getZtysknjyututkykkykkbn() {
        return ztysknjyututkykkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysknjyututkykkykkbn(String pZtysknjyututkykkykkbn) {
        ztysknjyututkykkykkbn = pZtysknjyututkykkykkbn;
    }

    private String ztybosyuudairitengyousyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBOSYUUDAIRITENGYOUSYUKBN)
    public String getZtybosyuudairitengyousyukbn() {
        return ztybosyuudairitengyousyukbn;
    }

    public void setZtybosyuudairitengyousyukbn(String pZtybosyuudairitengyousyukbn) {
        ztybosyuudairitengyousyukbn = pZtybosyuudairitengyousyukbn;
    }

    private String ztycifcd;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztytokusyujimutoriatukaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTOKUSYUJIMUTORIATUKAIKBN)
    public String getZtytokusyujimutoriatukaikbn() {
        return ztytokusyujimutoriatukaikbn;
    }

    public void setZtytokusyujimutoriatukaikbn(String pZtytokusyujimutoriatukaikbn) {
        ztytokusyujimutoriatukaikbn = pZtytokusyujimutoriatukaikbn;
    }

    private String ztypmentkykyutktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYPMENTKYKYUTKTBICDX1)
    public String getZtypmentkykyutktbicdx1() {
        return ztypmentkykyutktbicdx1;
    }

    public void setZtypmentkykyutktbicdx1(String pZtypmentkykyutktbicdx1) {
        ztypmentkykyutktbicdx1 = pZtypmentkykyutktbicdx1;
    }

    private String ztypmentkykyuhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYPMENTKYKYUHTNPKKNX1)
    public String getZtypmentkykyuhtnpkknx1() {
        return ztypmentkykyuhtnpkknx1;
    }

    public void setZtypmentkykyuhtnpkknx1(String pZtypmentkykyuhtnpkknx1) {
        ztypmentkykyuhtnpkknx1 = pZtypmentkykyuhtnpkknx1;
    }

    private String ztypmentkykyutktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYPMENTKYKYUTKTBICDX2)
    public String getZtypmentkykyutktbicdx2() {
        return ztypmentkykyutktbicdx2;
    }

    public void setZtypmentkykyutktbicdx2(String pZtypmentkykyutktbicdx2) {
        ztypmentkykyutktbicdx2 = pZtypmentkykyutktbicdx2;
    }

    private String ztypmentkykyuhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYPMENTKYKYUHTNPKKNX2)
    public String getZtypmentkykyuhtnpkknx2() {
        return ztypmentkykyuhtnpkknx2;
    }

    public void setZtypmentkykyuhtnpkknx2(String pZtypmentkykyuhtnpkknx2) {
        ztypmentkykyuhtnpkknx2 = pZtypmentkykyuhtnpkknx2;
    }

    private String ztyhosyouikkatumnoshyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOSYOUIKKATUMNOSHYOUJI)
    public String getZtyhosyouikkatumnoshyouji() {
        return ztyhosyouikkatumnoshyouji;
    }

    public void setZtyhosyouikkatumnoshyouji(String pZtyhosyouikkatumnoshyouji) {
        ztyhosyouikkatumnoshyouji = pZtyhosyouikkatumnoshyouji;
    }

    private String ztyhsyuikktminaosikaisu;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHSYUIKKTMINAOSIKAISU)
    public String getZtyhsyuikktminaosikaisu() {
        return ztyhsyuikktminaosikaisu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhsyuikktminaosikaisu(String pZtyhsyuikktminaosikaisu) {
        ztyhsyuikktminaosikaisu = pZtyhsyuikktminaosikaisu;
    }

    private String ztyhsyuikktmnosdfnyuknhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHSYUIKKTMNOSDFNYUKNHYJ)
    public String getZtyhsyuikktmnosdfnyuknhyj() {
        return ztyhsyuikktmnosdfnyuknhyj;
    }

    public void setZtyhsyuikktmnosdfnyuknhyj(String pZtyhsyuikktmnosdfnyuknhyj) {
        ztyhsyuikktmnosdfnyuknhyj = pZtyhsyuikktmnosdfnyuknhyj;
    }

    private Long ztyikktmnoskikiyutkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYIKKTMNOSKIKIYUTKYKP)
    public Long getZtyikktmnoskikiyutkykp() {
        return ztyikktmnoskikiyutkykp;
    }

    public void setZtyikktmnoskikiyutkykp(Long pZtyikktmnoskikiyutkykp) {
        ztyikktmnoskikiyutkykp = pZtyikktmnoskikiyutkykp;
    }

    private Long ztyikktmnoskikiyufndsistp;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYIKKTMNOSKIKIYUFNDSISTP)
    public Long getZtyikktmnoskikiyufndsistp() {
        return ztyikktmnoskikiyufndsistp;
    }

    public void setZtyikktmnoskikiyufndsistp(Long pZtyikktmnoskikiyufndsistp) {
        ztyikktmnoskikiyufndsistp = pZtyikktmnoskikiyufndsistp;
    }

    private BizNumber ztysknnjynbknsisnrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSKNNJYNBKNSISNRT)
    public BizNumber getZtysknnjynbknsisnrt() {
        return ztysknnjynbknsisnrt;
    }

    public void setZtysknnjynbknsisnrt(BizNumber pZtysknnjynbknsisnrt) {
        ztysknnjynbknsisnrt = pZtysknnjynbknsisnrt;
    }

    private String ztykanyujisyono;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKANYUJISYONO)
    public String getZtykanyujisyono() {
        return ztykanyujisyono;
    }

    public void setZtykanyujisyono(String pZtykanyujisyono) {
        ztykanyujisyono = pZtykanyujisyono;
    }

    private String ztykanyujikykymd;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKANYUJIKYKYMD)
    public String getZtykanyujikykymd() {
        return ztykanyujikykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtykanyujikykymd(String pZtykanyujikykymd) {
        ztykanyujikykymd = pZtykanyujikykymd;
    }

    private String ztykanyuujihihokensyaage;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKANYUUJIHIHOKENSYAAGE)
    public String getZtykanyuujihihokensyaage() {
        return ztykanyuujihihokensyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykanyuujihihokensyaage(String pZtykanyuujihihokensyaage) {
        ztykanyuujihihokensyaage = pZtykanyuujihihokensyaage;
    }

    private String ztykanyuujitenkanhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKANYUUJITENKANHYOUJI)
    public String getZtykanyuujitenkanhyouji() {
        return ztykanyuujitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykanyuujitenkanhyouji(String pZtykanyuujitenkanhyouji) {
        ztykanyuujitenkanhyouji = pZtykanyuujitenkanhyouji;
    }

    private String ztyksnyuhsyuikktminosnnskbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKSNYUHSYUIKKTMINOSNNSKBN)
    public String getZtyksnyuhsyuikktminosnnskbn() {
        return ztyksnyuhsyuikktminosnnskbn;
    }

    public void setZtyksnyuhsyuikktminosnnskbn(String pZtyksnyuhsyuikktminosnnskbn) {
        ztyksnyuhsyuikktminosnnskbn = pZtyksnyuhsyuikktminosnnskbn;
    }

    private String ztyaatukaisyadirtnbsynnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYAATUKAISYADIRTNBSYNNHYJ)
    public String getZtyaatukaisyadirtnbsynnhyj() {
        return ztyaatukaisyadirtnbsynnhyj;
    }

    public void setZtyaatukaisyadirtnbsynnhyj(String pZtyaatukaisyadirtnbsynnhyj) {
        ztyaatukaisyadirtnbsynnhyj = pZtyaatukaisyadirtnbsynnhyj;
    }

    private String ztybatkisyadirtnbosyuninhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBATKISYADIRTNBOSYUNINHYJ)
    public String getZtybatkisyadirtnbosyuninhyj() {
        return ztybatkisyadirtnbosyuninhyj;
    }

    public void setZtybatkisyadirtnbosyuninhyj(String pZtybatkisyadirtnbosyuninhyj) {
        ztybatkisyadirtnbosyuninhyj = pZtybatkisyadirtnbosyuninhyj;
    }

    private String ztydirtnaatukaisyakojincd;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDIRTNAATUKAISYAKOJINCD)
    public String getZtydirtnaatukaisyakojincd() {
        return ztydirtnaatukaisyakojincd;
    }

    public void setZtydirtnaatukaisyakojincd(String pZtydirtnaatukaisyakojincd) {
        ztydirtnaatukaisyakojincd = pZtydirtnaatukaisyakojincd;
    }

    private String ztydirtnbatukaisyakojincd;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDIRTNBATUKAISYAKOJINCD)
    public String getZtydirtnbatukaisyakojincd() {
        return ztydirtnbatukaisyakojincd;
    }

    public void setZtydirtnbatukaisyakojincd(String pZtydirtnbatukaisyakojincd) {
        ztydirtnbatukaisyakojincd = pZtydirtnbatukaisyakojincd;
    }

    private String ztysyuuseisyoukeikanensuu;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYUUSEISYOUKEIKANENSUU)
    public String getZtysyuuseisyoukeikanensuu() {
        return ztysyuuseisyoukeikanensuu;
    }

    public void setZtysyuuseisyoukeikanensuu(String pZtysyuuseisyoukeikanensuu) {
        ztysyuuseisyoukeikanensuu = pZtysyuuseisyoukeikanensuu;
    }

    private String ztysyuruihnkutkbttrtkhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYURUIHNKUTKBTTRTKHYJ)
    public String getZtysyuruihnkutkbttrtkhyj() {
        return ztysyuruihnkutkbttrtkhyj;
    }

    public void setZtysyuruihnkutkbttrtkhyj(String pZtysyuruihnkutkbttrtkhyj) {
        ztysyuruihnkutkbttrtkhyj = pZtysyuruihnkutkbttrtkhyj;
    }

    private String ztybnktmekyktkykhkjyutikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKTKYKHKJYUTIKBN)
    public String getZtybnktmekyktkykhkjyutikbn() {
        return ztybnktmekyktkykhkjyutikbn;
    }

    public void setZtybnktmekyktkykhkjyutikbn(String pZtybnktmekyktkykhkjyutikbn) {
        ztybnktmekyktkykhkjyutikbn = pZtybnktmekyktkykhkjyutikbn;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private String ztytnknsyokaipclessriyouhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTNKNSYOKAIPCLESSRIYOUHYJ)
    public String getZtytnknsyokaipclessriyouhyj() {
        return ztytnknsyokaipclessriyouhyj;
    }

    public void setZtytnknsyokaipclessriyouhyj(String pZtytnknsyokaipclessriyouhyj) {
        ztytnknsyokaipclessriyouhyj = pZtytnknsyokaipclessriyouhyj;
    }

    private String ztyhrkteisikibouhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHRKTEISIKIBOUHYOUJI)
    public String getZtyhrkteisikibouhyouji() {
        return ztyhrkteisikibouhyouji;
    }

    public void setZtyhrkteisikibouhyouji(String pZtyhrkteisikibouhyouji) {
        ztyhrkteisikibouhyouji = pZtyhrkteisikibouhyouji;
    }

    private Long ztybunkatugosonzokukeiyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBUNKATUGOSONZOKUKEIYAKUS)
    public Long getZtybunkatugosonzokukeiyakus() {
        return ztybunkatugosonzokukeiyakus;
    }

    public void setZtybunkatugosonzokukeiyakus(Long pZtybunkatugosonzokukeiyakus) {
        ztybunkatugosonzokukeiyakus = pZtybunkatugosonzokukeiyakus;
    }

    private Long ztymoskizkphrkekngk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMOSKIZKPHRKEKNGK)
    public Long getZtymoskizkphrkekngk() {
        return ztymoskizkphrkekngk;
    }

    public void setZtymoskizkphrkekngk(Long pZtymoskizkphrkekngk) {
        ztymoskizkphrkekngk = pZtymoskizkphrkekngk;
    }

    private Long ztykeizokuphurikaejijikaip;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKEIZOKUPHURIKAEJIJIKAIP)
    public Long getZtykeizokuphurikaejijikaip() {
        return ztykeizokuphurikaejijikaip;
    }

    public void setZtykeizokuphurikaejijikaip(Long pZtykeizokuphurikaejijikaip) {
        ztykeizokuphurikaejijikaip = pZtykeizokuphurikaejijikaip;
    }

    private String ztybnktmekyksyono;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKSYONO)
    public String getZtybnktmekyksyono() {
        return ztybnktmekyksyono;
    }

    public void setZtybnktmekyksyono(String pZtybnktmekyksyono) {
        ztybnktmekyksyono = pZtybnktmekyksyono;
    }

    private Long ztybunkatumaekeiyakukihons;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBUNKATUMAEKEIYAKUKIHONS)
    public Long getZtybunkatumaekeiyakukihons() {
        return ztybunkatumaekeiyakukihons;
    }

    public void setZtybunkatumaekeiyakukihons(Long pZtybunkatumaekeiyakukihons) {
        ztybunkatumaekeiyakukihons = pZtybunkatumaekeiyakukihons;
    }

    private Long ztybunkatumaekeiyakusibous;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBUNKATUMAEKEIYAKUSIBOUS)
    public Long getZtybunkatumaekeiyakusibous() {
        return ztybunkatumaekeiyakusibous;
    }

    public void setZtybunkatumaekeiyakusibous(Long pZtybunkatumaekeiyakusibous) {
        ztybunkatumaekeiyakusibous = pZtybunkatumaekeiyakusibous;
    }

    private Long ztybnktmekykmods;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKMODS)
    public Long getZtybnktmekykmods() {
        return ztybnktmekykmods;
    }

    public void setZtybnktmekykmods(Long pZtybnktmekykmods) {
        ztybnktmekykmods = pZtybnktmekykmods;
    }

    private Long ztybnktmekyksigiwrmstkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKSIGIWRMSTKYKS)
    public Long getZtybnktmekyksigiwrmstkyks() {
        return ztybnktmekyksigiwrmstkyks;
    }

    public void setZtybnktmekyksigiwrmstkyks(Long pZtybnktmekyksigiwrmstkyks) {
        ztybnktmekyksigiwrmstkyks = pZtybnktmekyksigiwrmstkyks;
    }

    private Long ztybnktmekyksyugitkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKSYUGITKYKS)
    public Long getZtybnktmekyksyugitkyks() {
        return ztybnktmekyksyugitkyks;
    }

    public void setZtybnktmekyksyugitkyks(Long pZtybnktmekyksyugitkyks) {
        ztybnktmekyksyugitkyks = pZtybnktmekyksyugitkyks;
    }

    private Integer ztybnktmkyksiginyintkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMKYKSIGINYINTKYKNTGK)
    public Integer getZtybnktmkyksiginyintkykntgk() {
        return ztybnktmkyksiginyintkykntgk;
    }

    public void setZtybnktmkyksiginyintkykntgk(Integer pZtybnktmkyksiginyintkykntgk) {
        ztybnktmkyksiginyintkykntgk = pZtybnktmkyksiginyintkykntgk;
    }

    private Integer ztybnktmekykknkutkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKKNKUTKYKNTGK)
    public Integer getZtybnktmekykknkutkykntgk() {
        return ztybnktmekykknkutkykntgk;
    }

    public void setZtybnktmekykknkutkykntgk(Integer pZtybnktmekykknkutkykntgk) {
        ztybnktmekykknkutkykntgk = pZtybnktmekykknkutkykntgk;
    }

    private Long ztybnktmekykhntiyunbriknsnp;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKHNTIYUNBRIKNSNP)
    public Long getZtybnktmekykhntiyunbriknsnp() {
        return ztybnktmekykhntiyunbriknsnp;
    }

    public void setZtybnktmekykhntiyunbriknsnp(Long pZtybnktmekykhntiyunbriknsnp) {
        ztybnktmekykhntiyunbriknsnp = pZtybnktmekykhntiyunbriknsnp;
    }

    private Long ztydai2naibuwarimodosigaku;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDAI2NAIBUWARIMODOSIGAKU)
    public Long getZtydai2naibuwarimodosigaku() {
        return ztydai2naibuwarimodosigaku;
    }

    public void setZtydai2naibuwarimodosigaku(Long pZtydai2naibuwarimodosigaku) {
        ztydai2naibuwarimodosigaku = pZtydai2naibuwarimodosigaku;
    }

    private Long ztytnkngkykkstkgk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTNKNGKYKKSTKGK)
    public Long getZtytnkngkykkstkgk() {
        return ztytnkngkykkstkgk;
    }

    public void setZtytnkngkykkstkgk(Long pZtytnkngkykkstkgk) {
        ztytnkngkykkstkgk = pZtytnkngkykkstkgk;
    }

    private Long ztybnktmekykkstkgk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYBNKTMEKYKKSTKGK)
    public Long getZtybnktmekykkstkgk() {
        return ztybnktmekykkstkgk;
    }

    public void setZtybnktmekykkstkgk(Long pZtybnktmekykkstkgk) {
        ztybnktmekykkstkgk = pZtybnktmekykkstkgk;
    }

    private Long ztysonzokukykkasitukegk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSONZOKUKYKKASITUKEGK)
    public Long getZtysonzokukykkasitukegk() {
        return ztysonzokukykkasitukegk;
    }

    public void setZtysonzokukykkasitukegk(Long pZtysonzokukykkasitukegk) {
        ztysonzokukykkasitukegk = pZtysonzokukykkasitukegk;
    }

    private Long ztyhngkmnryoujsitihsyukngk;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHNGKMNRYOUJSITIHSYUKNGK)
    public Long getZtyhngkmnryoujsitihsyukngk() {
        return ztyhngkmnryoujsitihsyukngk;
    }

    public void setZtyhngkmnryoujsitihsyukngk(Long pZtyhngkmnryoujsitihsyukngk) {
        ztyhngkmnryoujsitihsyukngk = pZtyhngkmnryoujsitihsyukngk;
    }

    private Long ztyhngksitihsyuyusykykp;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHNGKSITIHSYUYUSYKYKP)
    public Long getZtyhngksitihsyuyusykykp() {
        return ztyhngksitihsyuyusykykp;
    }

    public void setZtyhngksitihsyuyusykykp(Long pZtyhngksitihsyuyusykykp) {
        ztyhngksitihsyuyusykykp = pZtyhngksitihsyuyusykykp;
    }

    private String ztyhtnknkigmrsyukguybx1x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX1X1)
    public String getZtyhtnknkigmrsyukguybx1x1() {
        return ztyhtnknkigmrsyukguybx1x1;
    }

    public void setZtyhtnknkigmrsyukguybx1x1(String pZtyhtnknkigmrsyukguybx1x1) {
        ztyhtnknkigmrsyukguybx1x1 = pZtyhtnknkigmrsyukguybx1x1;
    }

    private String ztyhtnknkigmrsyukguybx2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX2X1)
    public String getZtyhtnknkigmrsyukguybx2x1() {
        return ztyhtnknkigmrsyukguybx2x1;
    }

    public void setZtyhtnknkigmrsyukguybx2x1(String pZtyhtnknkigmrsyukguybx2x1) {
        ztyhtnknkigmrsyukguybx2x1 = pZtyhtnknkigmrsyukguybx2x1;
    }

    private String ztyhtnknkigmrsyukguybx3x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX3X1)
    public String getZtyhtnknkigmrsyukguybx3x1() {
        return ztyhtnknkigmrsyukguybx3x1;
    }

    public void setZtyhtnknkigmrsyukguybx3x1(String pZtyhtnknkigmrsyukguybx3x1) {
        ztyhtnknkigmrsyukguybx3x1 = pZtyhtnknkigmrsyukguybx3x1;
    }

    private String ztyhtnknkigmrsyukguybx4x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX4X1)
    public String getZtyhtnknkigmrsyukguybx4x1() {
        return ztyhtnknkigmrsyukguybx4x1;
    }

    public void setZtyhtnknkigmrsyukguybx4x1(String pZtyhtnknkigmrsyukguybx4x1) {
        ztyhtnknkigmrsyukguybx4x1 = pZtyhtnknkigmrsyukguybx4x1;
    }

    private String ztyhtnknkigmrsyukguybx5x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX5X1)
    public String getZtyhtnknkigmrsyukguybx5x1() {
        return ztyhtnknkigmrsyukguybx5x1;
    }

    public void setZtyhtnknkigmrsyukguybx5x1(String pZtyhtnknkigmrsyukguybx5x1) {
        ztyhtnknkigmrsyukguybx5x1 = pZtyhtnknkigmrsyukguybx5x1;
    }

    private String ztyhtnknkigmrsyukguybx1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX1X2)
    public String getZtyhtnknkigmrsyukguybx1x2() {
        return ztyhtnknkigmrsyukguybx1x2;
    }

    public void setZtyhtnknkigmrsyukguybx1x2(String pZtyhtnknkigmrsyukguybx1x2) {
        ztyhtnknkigmrsyukguybx1x2 = pZtyhtnknkigmrsyukguybx1x2;
    }

    private String ztyhtnknkigmrsyukguybx2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX2X2)
    public String getZtyhtnknkigmrsyukguybx2x2() {
        return ztyhtnknkigmrsyukguybx2x2;
    }

    public void setZtyhtnknkigmrsyukguybx2x2(String pZtyhtnknkigmrsyukguybx2x2) {
        ztyhtnknkigmrsyukguybx2x2 = pZtyhtnknkigmrsyukguybx2x2;
    }

    private String ztyhtnknkigmrsyukguybx3x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX3X2)
    public String getZtyhtnknkigmrsyukguybx3x2() {
        return ztyhtnknkigmrsyukguybx3x2;
    }

    public void setZtyhtnknkigmrsyukguybx3x2(String pZtyhtnknkigmrsyukguybx3x2) {
        ztyhtnknkigmrsyukguybx3x2 = pZtyhtnknkigmrsyukguybx3x2;
    }

    private String ztyhtnknkigmrsyukguybx4x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX4X2)
    public String getZtyhtnknkigmrsyukguybx4x2() {
        return ztyhtnknkigmrsyukguybx4x2;
    }

    public void setZtyhtnknkigmrsyukguybx4x2(String pZtyhtnknkigmrsyukguybx4x2) {
        ztyhtnknkigmrsyukguybx4x2 = pZtyhtnknkigmrsyukguybx4x2;
    }

    private String ztyhtnknkigmrsyukguybx5x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX5X2)
    public String getZtyhtnknkigmrsyukguybx5x2() {
        return ztyhtnknkigmrsyukguybx5x2;
    }

    public void setZtyhtnknkigmrsyukguybx5x2(String pZtyhtnknkigmrsyukguybx5x2) {
        ztyhtnknkigmrsyukguybx5x2 = pZtyhtnknkigmrsyukguybx5x2;
    }

    private String ztyhtnknkigmrsyukguybx1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX1X3)
    public String getZtyhtnknkigmrsyukguybx1x3() {
        return ztyhtnknkigmrsyukguybx1x3;
    }

    public void setZtyhtnknkigmrsyukguybx1x3(String pZtyhtnknkigmrsyukguybx1x3) {
        ztyhtnknkigmrsyukguybx1x3 = pZtyhtnknkigmrsyukguybx1x3;
    }

    private String ztyhtnknkigmrsyukguybx2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX2X3)
    public String getZtyhtnknkigmrsyukguybx2x3() {
        return ztyhtnknkigmrsyukguybx2x3;
    }

    public void setZtyhtnknkigmrsyukguybx2x3(String pZtyhtnknkigmrsyukguybx2x3) {
        ztyhtnknkigmrsyukguybx2x3 = pZtyhtnknkigmrsyukguybx2x3;
    }

    private String ztyhtnknkigmrsyukguybx3x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX3X3)
    public String getZtyhtnknkigmrsyukguybx3x3() {
        return ztyhtnknkigmrsyukguybx3x3;
    }

    public void setZtyhtnknkigmrsyukguybx3x3(String pZtyhtnknkigmrsyukguybx3x3) {
        ztyhtnknkigmrsyukguybx3x3 = pZtyhtnknkigmrsyukguybx3x3;
    }

    private String ztyhtnknkigmrsyukguybx4x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX4X3)
    public String getZtyhtnknkigmrsyukguybx4x3() {
        return ztyhtnknkigmrsyukguybx4x3;
    }

    public void setZtyhtnknkigmrsyukguybx4x3(String pZtyhtnknkigmrsyukguybx4x3) {
        ztyhtnknkigmrsyukguybx4x3 = pZtyhtnknkigmrsyukguybx4x3;
    }

    private String ztyhtnknkigmrsyukguybx5x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX5X3)
    public String getZtyhtnknkigmrsyukguybx5x3() {
        return ztyhtnknkigmrsyukguybx5x3;
    }

    public void setZtyhtnknkigmrsyukguybx5x3(String pZtyhtnknkigmrsyukguybx5x3) {
        ztyhtnknkigmrsyukguybx5x3 = pZtyhtnknkigmrsyukguybx5x3;
    }

    private String ztyhtnknkigmrsyukguybx1x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX1X4)
    public String getZtyhtnknkigmrsyukguybx1x4() {
        return ztyhtnknkigmrsyukguybx1x4;
    }

    public void setZtyhtnknkigmrsyukguybx1x4(String pZtyhtnknkigmrsyukguybx1x4) {
        ztyhtnknkigmrsyukguybx1x4 = pZtyhtnknkigmrsyukguybx1x4;
    }

    private String ztyhtnknkigmrsyukguybx2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX2X4)
    public String getZtyhtnknkigmrsyukguybx2x4() {
        return ztyhtnknkigmrsyukguybx2x4;
    }

    public void setZtyhtnknkigmrsyukguybx2x4(String pZtyhtnknkigmrsyukguybx2x4) {
        ztyhtnknkigmrsyukguybx2x4 = pZtyhtnknkigmrsyukguybx2x4;
    }

    private String ztyhtnknkigmrsyukguybx3x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX3X4)
    public String getZtyhtnknkigmrsyukguybx3x4() {
        return ztyhtnknkigmrsyukguybx3x4;
    }

    public void setZtyhtnknkigmrsyukguybx3x4(String pZtyhtnknkigmrsyukguybx3x4) {
        ztyhtnknkigmrsyukguybx3x4 = pZtyhtnknkigmrsyukguybx3x4;
    }

    private String ztyhtnknkigmrsyukguybx4x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX4X4)
    public String getZtyhtnknkigmrsyukguybx4x4() {
        return ztyhtnknkigmrsyukguybx4x4;
    }

    public void setZtyhtnknkigmrsyukguybx4x4(String pZtyhtnknkigmrsyukguybx4x4) {
        ztyhtnknkigmrsyukguybx4x4 = pZtyhtnknkigmrsyukguybx4x4;
    }

    private String ztyhtnknkigmrsyukguybx5x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX5X4)
    public String getZtyhtnknkigmrsyukguybx5x4() {
        return ztyhtnknkigmrsyukguybx5x4;
    }

    public void setZtyhtnknkigmrsyukguybx5x4(String pZtyhtnknkigmrsyukguybx5x4) {
        ztyhtnknkigmrsyukguybx5x4 = pZtyhtnknkigmrsyukguybx5x4;
    }

    private String ztyhtnknkigmrsyukguybx1x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX1X5)
    public String getZtyhtnknkigmrsyukguybx1x5() {
        return ztyhtnknkigmrsyukguybx1x5;
    }

    public void setZtyhtnknkigmrsyukguybx1x5(String pZtyhtnknkigmrsyukguybx1x5) {
        ztyhtnknkigmrsyukguybx1x5 = pZtyhtnknkigmrsyukguybx1x5;
    }

    private String ztyhtnknkigmrsyukguybx2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX2X5)
    public String getZtyhtnknkigmrsyukguybx2x5() {
        return ztyhtnknkigmrsyukguybx2x5;
    }

    public void setZtyhtnknkigmrsyukguybx2x5(String pZtyhtnknkigmrsyukguybx2x5) {
        ztyhtnknkigmrsyukguybx2x5 = pZtyhtnknkigmrsyukguybx2x5;
    }

    private String ztyhtnknkigmrsyukguybx3x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX3X5)
    public String getZtyhtnknkigmrsyukguybx3x5() {
        return ztyhtnknkigmrsyukguybx3x5;
    }

    public void setZtyhtnknkigmrsyukguybx3x5(String pZtyhtnknkigmrsyukguybx3x5) {
        ztyhtnknkigmrsyukguybx3x5 = pZtyhtnknkigmrsyukguybx3x5;
    }

    private String ztyhtnknkigmrsyukguybx4x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX4X5)
    public String getZtyhtnknkigmrsyukguybx4x5() {
        return ztyhtnknkigmrsyukguybx4x5;
    }

    public void setZtyhtnknkigmrsyukguybx4x5(String pZtyhtnknkigmrsyukguybx4x5) {
        ztyhtnknkigmrsyukguybx4x5 = pZtyhtnknkigmrsyukguybx4x5;
    }

    private String ztyhtnknkigmrsyukguybx5x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX5X5)
    public String getZtyhtnknkigmrsyukguybx5x5() {
        return ztyhtnknkigmrsyukguybx5x5;
    }

    public void setZtyhtnknkigmrsyukguybx5x5(String pZtyhtnknkigmrsyukguybx5x5) {
        ztyhtnknkigmrsyukguybx5x5 = pZtyhtnknkigmrsyukguybx5x5;
    }

    private String ztyhtnknkigmrsyukguybx1x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX1X6)
    public String getZtyhtnknkigmrsyukguybx1x6() {
        return ztyhtnknkigmrsyukguybx1x6;
    }

    public void setZtyhtnknkigmrsyukguybx1x6(String pZtyhtnknkigmrsyukguybx1x6) {
        ztyhtnknkigmrsyukguybx1x6 = pZtyhtnknkigmrsyukguybx1x6;
    }

    private String ztyhtnknkigmrsyukguybx2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX2X6)
    public String getZtyhtnknkigmrsyukguybx2x6() {
        return ztyhtnknkigmrsyukguybx2x6;
    }

    public void setZtyhtnknkigmrsyukguybx2x6(String pZtyhtnknkigmrsyukguybx2x6) {
        ztyhtnknkigmrsyukguybx2x6 = pZtyhtnknkigmrsyukguybx2x6;
    }

    private String ztyhtnknkigmrsyukguybx3x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX3X6)
    public String getZtyhtnknkigmrsyukguybx3x6() {
        return ztyhtnknkigmrsyukguybx3x6;
    }

    public void setZtyhtnknkigmrsyukguybx3x6(String pZtyhtnknkigmrsyukguybx3x6) {
        ztyhtnknkigmrsyukguybx3x6 = pZtyhtnknkigmrsyukguybx3x6;
    }

    private String ztyhtnknkigmrsyukguybx4x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX4X6)
    public String getZtyhtnknkigmrsyukguybx4x6() {
        return ztyhtnknkigmrsyukguybx4x6;
    }

    public void setZtyhtnknkigmrsyukguybx4x6(String pZtyhtnknkigmrsyukguybx4x6) {
        ztyhtnknkigmrsyukguybx4x6 = pZtyhtnknkigmrsyukguybx4x6;
    }

    private String ztyhtnknkigmrsyukguybx5x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHTNKNKIGMRSYUKGUYBX5X6)
    public String getZtyhtnknkigmrsyukguybx5x6() {
        return ztyhtnknkigmrsyukguybx5x6;
    }

    public void setZtyhtnknkigmrsyukguybx5x6(String pZtyhtnknkigmrsyukguybx5x6) {
        ztyhtnknkigmrsyukguybx5x6 = pZtyhtnknkigmrsyukguybx5x6;
    }

    private String ztyyobiv1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYYOBIV1X3)
    public String getZtyyobiv1x3() {
        return ztyyobiv1x3;
    }

    public void setZtyyobiv1x3(String pZtyyobiv1x3) {
        ztyyobiv1x3 = pZtyyobiv1x3;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztymaruteikigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUTEIKIGOUYOBIX1)
    public String getZtymaruteikigouyobix1() {
        return ztymaruteikigouyobix1;
    }

    public void setZtymaruteikigouyobix1(String pZtymaruteikigouyobix1) {
        ztymaruteikigouyobix1 = pZtymaruteikigouyobix1;
    }

    private String ztymaruteikigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUTEIKIGOUYOBIX2)
    public String getZtymaruteikigouyobix2() {
        return ztymaruteikigouyobix2;
    }

    public void setZtymaruteikigouyobix2(String pZtymaruteikigouyobix2) {
        ztymaruteikigouyobix2 = pZtymaruteikigouyobix2;
    }

    private String ztymaruteikigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUTEIKIGOUYOBIX3)
    public String getZtymaruteikigouyobix3() {
        return ztymaruteikigouyobix3;
    }

    public void setZtymaruteikigouyobix3(String pZtymaruteikigouyobix3) {
        ztymaruteikigouyobix3 = pZtymaruteikigouyobix3;
    }

    private String ztymaruteikigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUTEIKIGOUYOBIX4)
    public String getZtymaruteikigouyobix4() {
        return ztymaruteikigouyobix4;
    }

    public void setZtymaruteikigouyobix4(String pZtymaruteikigouyobix4) {
        ztymaruteikigouyobix4 = pZtymaruteikigouyobix4;
    }

    private String ztymaruteikigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUTEIKIGOUYOBIX5)
    public String getZtymaruteikigouyobix5() {
        return ztymaruteikigouyobix5;
    }

    public void setZtymaruteikigouyobix5(String pZtymaruteikigouyobix5) {
        ztymaruteikigouyobix5 = pZtymaruteikigouyobix5;
    }

    private String ztymaruyoukigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUYOUKIGOUYOBIX1)
    public String getZtymaruyoukigouyobix1() {
        return ztymaruyoukigouyobix1;
    }

    public void setZtymaruyoukigouyobix1(String pZtymaruyoukigouyobix1) {
        ztymaruyoukigouyobix1 = pZtymaruyoukigouyobix1;
    }

    private String ztymaruyoukigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUYOUKIGOUYOBIX2)
    public String getZtymaruyoukigouyobix2() {
        return ztymaruyoukigouyobix2;
    }

    public void setZtymaruyoukigouyobix2(String pZtymaruyoukigouyobix2) {
        ztymaruyoukigouyobix2 = pZtymaruyoukigouyobix2;
    }

    private String ztymaruyoukigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUYOUKIGOUYOBIX3)
    public String getZtymaruyoukigouyobix3() {
        return ztymaruyoukigouyobix3;
    }

    public void setZtymaruyoukigouyobix3(String pZtymaruyoukigouyobix3) {
        ztymaruyoukigouyobix3 = pZtymaruyoukigouyobix3;
    }

    private String ztymaruyoukigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUYOUKIGOUYOBIX4)
    public String getZtymaruyoukigouyobix4() {
        return ztymaruyoukigouyobix4;
    }

    public void setZtymaruyoukigouyobix4(String pZtymaruyoukigouyobix4) {
        ztymaruyoukigouyobix4 = pZtymaruyoukigouyobix4;
    }

    private String ztymaruyoukigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUYOUKIGOUYOBIX5)
    public String getZtymaruyoukigouyobix5() {
        return ztymaruyoukigouyobix5;
    }

    public void setZtymaruyoukigouyobix5(String pZtymaruyoukigouyobix5) {
        ztymaruyoukigouyobix5 = pZtymaruyoukigouyobix5;
    }

    private String ztymarusyuukigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUSYUUKIGOUYOBIX1)
    public String getZtymarusyuukigouyobix1() {
        return ztymarusyuukigouyobix1;
    }

    public void setZtymarusyuukigouyobix1(String pZtymarusyuukigouyobix1) {
        ztymarusyuukigouyobix1 = pZtymarusyuukigouyobix1;
    }

    private String ztymarusyuukigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUSYUUKIGOUYOBIX2)
    public String getZtymarusyuukigouyobix2() {
        return ztymarusyuukigouyobix2;
    }

    public void setZtymarusyuukigouyobix2(String pZtymarusyuukigouyobix2) {
        ztymarusyuukigouyobix2 = pZtymarusyuukigouyobix2;
    }

    private String ztymarusyuukigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUSYUUKIGOUYOBIX3)
    public String getZtymarusyuukigouyobix3() {
        return ztymarusyuukigouyobix3;
    }

    public void setZtymarusyuukigouyobix3(String pZtymarusyuukigouyobix3) {
        ztymarusyuukigouyobix3 = pZtymarusyuukigouyobix3;
    }

    private String ztymarusyuukigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUSYUUKIGOUYOBIX4)
    public String getZtymarusyuukigouyobix4() {
        return ztymarusyuukigouyobix4;
    }

    public void setZtymarusyuukigouyobix4(String pZtymarusyuukigouyobix4) {
        ztymarusyuukigouyobix4 = pZtymarusyuukigouyobix4;
    }

    private String ztymarusyuukigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMARUSYUUKIGOUYOBIX5)
    public String getZtymarusyuukigouyobix5() {
        return ztymarusyuukigouyobix5;
    }

    public void setZtymarusyuukigouyobix5(String pZtymarusyuukigouyobix5) {
        ztymarusyuukigouyobix5 = pZtymarusyuukigouyobix5;
    }

    private String ztytokuteikigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTOKUTEIKIGOUYOBIX1)
    public String getZtytokuteikigouyobix1() {
        return ztytokuteikigouyobix1;
    }

    public void setZtytokuteikigouyobix1(String pZtytokuteikigouyobix1) {
        ztytokuteikigouyobix1 = pZtytokuteikigouyobix1;
    }

    private String ztytokuteikigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTOKUTEIKIGOUYOBIX2)
    public String getZtytokuteikigouyobix2() {
        return ztytokuteikigouyobix2;
    }

    public void setZtytokuteikigouyobix2(String pZtytokuteikigouyobix2) {
        ztytokuteikigouyobix2 = pZtytokuteikigouyobix2;
    }

    private String ztytokuteikigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTOKUTEIKIGOUYOBIX3)
    public String getZtytokuteikigouyobix3() {
        return ztytokuteikigouyobix3;
    }

    public void setZtytokuteikigouyobix3(String pZtytokuteikigouyobix3) {
        ztytokuteikigouyobix3 = pZtytokuteikigouyobix3;
    }

    private String ztytokuteikigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTOKUTEIKIGOUYOBIX4)
    public String getZtytokuteikigouyobix4() {
        return ztytokuteikigouyobix4;
    }

    public void setZtytokuteikigouyobix4(String pZtytokuteikigouyobix4) {
        ztytokuteikigouyobix4 = pZtytokuteikigouyobix4;
    }

    private String ztytokuteikigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTOKUTEIKIGOUYOBIX5)
    public String getZtytokuteikigouyobix5() {
        return ztytokuteikigouyobix5;
    }

    public void setZtytokuteikigouyobix5(String pZtytokuteikigouyobix5) {
        ztytokuteikigouyobix5 = pZtytokuteikigouyobix5;
    }

    private String ztykzkmrtikguybx1x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X1)
    public String getZtykzkmrtikguybx1x1() {
        return ztykzkmrtikguybx1x1;
    }

    public void setZtykzkmrtikguybx1x1(String pZtykzkmrtikguybx1x1) {
        ztykzkmrtikguybx1x1 = pZtykzkmrtikguybx1x1;
    }

    private String ztykzkmrtikguybx2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X1)
    public String getZtykzkmrtikguybx2x1() {
        return ztykzkmrtikguybx2x1;
    }

    public void setZtykzkmrtikguybx2x1(String pZtykzkmrtikguybx2x1) {
        ztykzkmrtikguybx2x1 = pZtykzkmrtikguybx2x1;
    }

    private String ztykzkmrtikguybx3x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X1)
    public String getZtykzkmrtikguybx3x1() {
        return ztykzkmrtikguybx3x1;
    }

    public void setZtykzkmrtikguybx3x1(String pZtykzkmrtikguybx3x1) {
        ztykzkmrtikguybx3x1 = pZtykzkmrtikguybx3x1;
    }

    private String ztykzkmrtikguybx4x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X1)
    public String getZtykzkmrtikguybx4x1() {
        return ztykzkmrtikguybx4x1;
    }

    public void setZtykzkmrtikguybx4x1(String pZtykzkmrtikguybx4x1) {
        ztykzkmrtikguybx4x1 = pZtykzkmrtikguybx4x1;
    }

    private String ztykzkmrtikguybx5x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X1)
    public String getZtykzkmrtikguybx5x1() {
        return ztykzkmrtikguybx5x1;
    }

    public void setZtykzkmrtikguybx5x1(String pZtykzkmrtikguybx5x1) {
        ztykzkmrtikguybx5x1 = pZtykzkmrtikguybx5x1;
    }

    private String ztykzkmrtikguybx1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X2)
    public String getZtykzkmrtikguybx1x2() {
        return ztykzkmrtikguybx1x2;
    }

    public void setZtykzkmrtikguybx1x2(String pZtykzkmrtikguybx1x2) {
        ztykzkmrtikguybx1x2 = pZtykzkmrtikguybx1x2;
    }

    private String ztykzkmrtikguybx2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X2)
    public String getZtykzkmrtikguybx2x2() {
        return ztykzkmrtikguybx2x2;
    }

    public void setZtykzkmrtikguybx2x2(String pZtykzkmrtikguybx2x2) {
        ztykzkmrtikguybx2x2 = pZtykzkmrtikguybx2x2;
    }

    private String ztykzkmrtikguybx3x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X2)
    public String getZtykzkmrtikguybx3x2() {
        return ztykzkmrtikguybx3x2;
    }

    public void setZtykzkmrtikguybx3x2(String pZtykzkmrtikguybx3x2) {
        ztykzkmrtikguybx3x2 = pZtykzkmrtikguybx3x2;
    }

    private String ztykzkmrtikguybx4x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X2)
    public String getZtykzkmrtikguybx4x2() {
        return ztykzkmrtikguybx4x2;
    }

    public void setZtykzkmrtikguybx4x2(String pZtykzkmrtikguybx4x2) {
        ztykzkmrtikguybx4x2 = pZtykzkmrtikguybx4x2;
    }

    private String ztykzkmrtikguybx5x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X2)
    public String getZtykzkmrtikguybx5x2() {
        return ztykzkmrtikguybx5x2;
    }

    public void setZtykzkmrtikguybx5x2(String pZtykzkmrtikguybx5x2) {
        ztykzkmrtikguybx5x2 = pZtykzkmrtikguybx5x2;
    }

    private String ztykzkmrtikguybx1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X3)
    public String getZtykzkmrtikguybx1x3() {
        return ztykzkmrtikguybx1x3;
    }

    public void setZtykzkmrtikguybx1x3(String pZtykzkmrtikguybx1x3) {
        ztykzkmrtikguybx1x3 = pZtykzkmrtikguybx1x3;
    }

    private String ztykzkmrtikguybx2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X3)
    public String getZtykzkmrtikguybx2x3() {
        return ztykzkmrtikguybx2x3;
    }

    public void setZtykzkmrtikguybx2x3(String pZtykzkmrtikguybx2x3) {
        ztykzkmrtikguybx2x3 = pZtykzkmrtikguybx2x3;
    }

    private String ztykzkmrtikguybx3x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X3)
    public String getZtykzkmrtikguybx3x3() {
        return ztykzkmrtikguybx3x3;
    }

    public void setZtykzkmrtikguybx3x3(String pZtykzkmrtikguybx3x3) {
        ztykzkmrtikguybx3x3 = pZtykzkmrtikguybx3x3;
    }

    private String ztykzkmrtikguybx4x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X3)
    public String getZtykzkmrtikguybx4x3() {
        return ztykzkmrtikguybx4x3;
    }

    public void setZtykzkmrtikguybx4x3(String pZtykzkmrtikguybx4x3) {
        ztykzkmrtikguybx4x3 = pZtykzkmrtikguybx4x3;
    }

    private String ztykzkmrtikguybx5x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X3)
    public String getZtykzkmrtikguybx5x3() {
        return ztykzkmrtikguybx5x3;
    }

    public void setZtykzkmrtikguybx5x3(String pZtykzkmrtikguybx5x3) {
        ztykzkmrtikguybx5x3 = pZtykzkmrtikguybx5x3;
    }

    private String ztykzkmrtikguybx1x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X4)
    public String getZtykzkmrtikguybx1x4() {
        return ztykzkmrtikguybx1x4;
    }

    public void setZtykzkmrtikguybx1x4(String pZtykzkmrtikguybx1x4) {
        ztykzkmrtikguybx1x4 = pZtykzkmrtikguybx1x4;
    }

    private String ztykzkmrtikguybx2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X4)
    public String getZtykzkmrtikguybx2x4() {
        return ztykzkmrtikguybx2x4;
    }

    public void setZtykzkmrtikguybx2x4(String pZtykzkmrtikguybx2x4) {
        ztykzkmrtikguybx2x4 = pZtykzkmrtikguybx2x4;
    }

    private String ztykzkmrtikguybx3x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X4)
    public String getZtykzkmrtikguybx3x4() {
        return ztykzkmrtikguybx3x4;
    }

    public void setZtykzkmrtikguybx3x4(String pZtykzkmrtikguybx3x4) {
        ztykzkmrtikguybx3x4 = pZtykzkmrtikguybx3x4;
    }

    private String ztykzkmrtikguybx4x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X4)
    public String getZtykzkmrtikguybx4x4() {
        return ztykzkmrtikguybx4x4;
    }

    public void setZtykzkmrtikguybx4x4(String pZtykzkmrtikguybx4x4) {
        ztykzkmrtikguybx4x4 = pZtykzkmrtikguybx4x4;
    }

    private String ztykzkmrtikguybx5x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X4)
    public String getZtykzkmrtikguybx5x4() {
        return ztykzkmrtikguybx5x4;
    }

    public void setZtykzkmrtikguybx5x4(String pZtykzkmrtikguybx5x4) {
        ztykzkmrtikguybx5x4 = pZtykzkmrtikguybx5x4;
    }

    private String ztykzkmrtikguybx1x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X5)
    public String getZtykzkmrtikguybx1x5() {
        return ztykzkmrtikguybx1x5;
    }

    public void setZtykzkmrtikguybx1x5(String pZtykzkmrtikguybx1x5) {
        ztykzkmrtikguybx1x5 = pZtykzkmrtikguybx1x5;
    }

    private String ztykzkmrtikguybx2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X5)
    public String getZtykzkmrtikguybx2x5() {
        return ztykzkmrtikguybx2x5;
    }

    public void setZtykzkmrtikguybx2x5(String pZtykzkmrtikguybx2x5) {
        ztykzkmrtikguybx2x5 = pZtykzkmrtikguybx2x5;
    }

    private String ztykzkmrtikguybx3x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X5)
    public String getZtykzkmrtikguybx3x5() {
        return ztykzkmrtikguybx3x5;
    }

    public void setZtykzkmrtikguybx3x5(String pZtykzkmrtikguybx3x5) {
        ztykzkmrtikguybx3x5 = pZtykzkmrtikguybx3x5;
    }

    private String ztykzkmrtikguybx4x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X5)
    public String getZtykzkmrtikguybx4x5() {
        return ztykzkmrtikguybx4x5;
    }

    public void setZtykzkmrtikguybx4x5(String pZtykzkmrtikguybx4x5) {
        ztykzkmrtikguybx4x5 = pZtykzkmrtikguybx4x5;
    }

    private String ztykzkmrtikguybx5x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X5)
    public String getZtykzkmrtikguybx5x5() {
        return ztykzkmrtikguybx5x5;
    }

    public void setZtykzkmrtikguybx5x5(String pZtykzkmrtikguybx5x5) {
        ztykzkmrtikguybx5x5 = pZtykzkmrtikguybx5x5;
    }

    private String ztykzkmrtikguybx1x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X6)
    public String getZtykzkmrtikguybx1x6() {
        return ztykzkmrtikguybx1x6;
    }

    public void setZtykzkmrtikguybx1x6(String pZtykzkmrtikguybx1x6) {
        ztykzkmrtikguybx1x6 = pZtykzkmrtikguybx1x6;
    }

    private String ztykzkmrtikguybx2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X6)
    public String getZtykzkmrtikguybx2x6() {
        return ztykzkmrtikguybx2x6;
    }

    public void setZtykzkmrtikguybx2x6(String pZtykzkmrtikguybx2x6) {
        ztykzkmrtikguybx2x6 = pZtykzkmrtikguybx2x6;
    }

    private String ztykzkmrtikguybx3x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X6)
    public String getZtykzkmrtikguybx3x6() {
        return ztykzkmrtikguybx3x6;
    }

    public void setZtykzkmrtikguybx3x6(String pZtykzkmrtikguybx3x6) {
        ztykzkmrtikguybx3x6 = pZtykzkmrtikguybx3x6;
    }

    private String ztykzkmrtikguybx4x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X6)
    public String getZtykzkmrtikguybx4x6() {
        return ztykzkmrtikguybx4x6;
    }

    public void setZtykzkmrtikguybx4x6(String pZtykzkmrtikguybx4x6) {
        ztykzkmrtikguybx4x6 = pZtykzkmrtikguybx4x6;
    }

    private String ztykzkmrtikguybx5x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X6)
    public String getZtykzkmrtikguybx5x6() {
        return ztykzkmrtikguybx5x6;
    }

    public void setZtykzkmrtikguybx5x6(String pZtykzkmrtikguybx5x6) {
        ztykzkmrtikguybx5x6 = pZtykzkmrtikguybx5x6;
    }

    private String ztykzkmrtikguybx1x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X7)
    public String getZtykzkmrtikguybx1x7() {
        return ztykzkmrtikguybx1x7;
    }

    public void setZtykzkmrtikguybx1x7(String pZtykzkmrtikguybx1x7) {
        ztykzkmrtikguybx1x7 = pZtykzkmrtikguybx1x7;
    }

    private String ztykzkmrtikguybx2x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X7)
    public String getZtykzkmrtikguybx2x7() {
        return ztykzkmrtikguybx2x7;
    }

    public void setZtykzkmrtikguybx2x7(String pZtykzkmrtikguybx2x7) {
        ztykzkmrtikguybx2x7 = pZtykzkmrtikguybx2x7;
    }

    private String ztykzkmrtikguybx3x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X7)
    public String getZtykzkmrtikguybx3x7() {
        return ztykzkmrtikguybx3x7;
    }

    public void setZtykzkmrtikguybx3x7(String pZtykzkmrtikguybx3x7) {
        ztykzkmrtikguybx3x7 = pZtykzkmrtikguybx3x7;
    }

    private String ztykzkmrtikguybx4x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X7)
    public String getZtykzkmrtikguybx4x7() {
        return ztykzkmrtikguybx4x7;
    }

    public void setZtykzkmrtikguybx4x7(String pZtykzkmrtikguybx4x7) {
        ztykzkmrtikguybx4x7 = pZtykzkmrtikguybx4x7;
    }

    private String ztykzkmrtikguybx5x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X7)
    public String getZtykzkmrtikguybx5x7() {
        return ztykzkmrtikguybx5x7;
    }

    public void setZtykzkmrtikguybx5x7(String pZtykzkmrtikguybx5x7) {
        ztykzkmrtikguybx5x7 = pZtykzkmrtikguybx5x7;
    }

    private String ztykzkmrtikguybx1x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X8)
    public String getZtykzkmrtikguybx1x8() {
        return ztykzkmrtikguybx1x8;
    }

    public void setZtykzkmrtikguybx1x8(String pZtykzkmrtikguybx1x8) {
        ztykzkmrtikguybx1x8 = pZtykzkmrtikguybx1x8;
    }

    private String ztykzkmrtikguybx2x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X8)
    public String getZtykzkmrtikguybx2x8() {
        return ztykzkmrtikguybx2x8;
    }

    public void setZtykzkmrtikguybx2x8(String pZtykzkmrtikguybx2x8) {
        ztykzkmrtikguybx2x8 = pZtykzkmrtikguybx2x8;
    }

    private String ztykzkmrtikguybx3x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X8)
    public String getZtykzkmrtikguybx3x8() {
        return ztykzkmrtikguybx3x8;
    }

    public void setZtykzkmrtikguybx3x8(String pZtykzkmrtikguybx3x8) {
        ztykzkmrtikguybx3x8 = pZtykzkmrtikguybx3x8;
    }

    private String ztykzkmrtikguybx4x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X8)
    public String getZtykzkmrtikguybx4x8() {
        return ztykzkmrtikguybx4x8;
    }

    public void setZtykzkmrtikguybx4x8(String pZtykzkmrtikguybx4x8) {
        ztykzkmrtikguybx4x8 = pZtykzkmrtikguybx4x8;
    }

    private String ztykzkmrtikguybx5x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X8)
    public String getZtykzkmrtikguybx5x8() {
        return ztykzkmrtikguybx5x8;
    }

    public void setZtykzkmrtikguybx5x8(String pZtykzkmrtikguybx5x8) {
        ztykzkmrtikguybx5x8 = pZtykzkmrtikguybx5x8;
    }

    private String ztykzkmrtikguybx1x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X9)
    public String getZtykzkmrtikguybx1x9() {
        return ztykzkmrtikguybx1x9;
    }

    public void setZtykzkmrtikguybx1x9(String pZtykzkmrtikguybx1x9) {
        ztykzkmrtikguybx1x9 = pZtykzkmrtikguybx1x9;
    }

    private String ztykzkmrtikguybx2x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X9)
    public String getZtykzkmrtikguybx2x9() {
        return ztykzkmrtikguybx2x9;
    }

    public void setZtykzkmrtikguybx2x9(String pZtykzkmrtikguybx2x9) {
        ztykzkmrtikguybx2x9 = pZtykzkmrtikguybx2x9;
    }

    private String ztykzkmrtikguybx3x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X9)
    public String getZtykzkmrtikguybx3x9() {
        return ztykzkmrtikguybx3x9;
    }

    public void setZtykzkmrtikguybx3x9(String pZtykzkmrtikguybx3x9) {
        ztykzkmrtikguybx3x9 = pZtykzkmrtikguybx3x9;
    }

    private String ztykzkmrtikguybx4x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X9)
    public String getZtykzkmrtikguybx4x9() {
        return ztykzkmrtikguybx4x9;
    }

    public void setZtykzkmrtikguybx4x9(String pZtykzkmrtikguybx4x9) {
        ztykzkmrtikguybx4x9 = pZtykzkmrtikguybx4x9;
    }

    private String ztykzkmrtikguybx5x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X9)
    public String getZtykzkmrtikguybx5x9() {
        return ztykzkmrtikguybx5x9;
    }

    public void setZtykzkmrtikguybx5x9(String pZtykzkmrtikguybx5x9) {
        ztykzkmrtikguybx5x9 = pZtykzkmrtikguybx5x9;
    }

    private String ztykzkmrtikguybx1x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX1X10)
    public String getZtykzkmrtikguybx1x10() {
        return ztykzkmrtikguybx1x10;
    }

    public void setZtykzkmrtikguybx1x10(String pZtykzkmrtikguybx1x10) {
        ztykzkmrtikguybx1x10 = pZtykzkmrtikguybx1x10;
    }

    private String ztykzkmrtikguybx2x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX2X10)
    public String getZtykzkmrtikguybx2x10() {
        return ztykzkmrtikguybx2x10;
    }

    public void setZtykzkmrtikguybx2x10(String pZtykzkmrtikguybx2x10) {
        ztykzkmrtikguybx2x10 = pZtykzkmrtikguybx2x10;
    }

    private String ztykzkmrtikguybx3x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX3X10)
    public String getZtykzkmrtikguybx3x10() {
        return ztykzkmrtikguybx3x10;
    }

    public void setZtykzkmrtikguybx3x10(String pZtykzkmrtikguybx3x10) {
        ztykzkmrtikguybx3x10 = pZtykzkmrtikguybx3x10;
    }

    private String ztykzkmrtikguybx4x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX4X10)
    public String getZtykzkmrtikguybx4x10() {
        return ztykzkmrtikguybx4x10;
    }

    public void setZtykzkmrtikguybx4x10(String pZtykzkmrtikguybx4x10) {
        ztykzkmrtikguybx4x10 = pZtykzkmrtikguybx4x10;
    }

    private String ztykzkmrtikguybx5x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKMRTIKGUYBX5X10)
    public String getZtykzkmrtikguybx5x10() {
        return ztykzkmrtikguybx5x10;
    }

    public void setZtykzkmrtikguybx5x10(String pZtykzkmrtikguybx5x10) {
        ztykzkmrtikguybx5x10 = pZtykzkmrtikguybx5x10;
    }

    private String ztysyugittkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYUGITTKYKKGUYBX1)
    public String getZtysyugittkykkguybx1() {
        return ztysyugittkykkguybx1;
    }

    public void setZtysyugittkykkguybx1(String pZtysyugittkykkguybx1) {
        ztysyugittkykkguybx1 = pZtysyugittkykkguybx1;
    }

    private String ztysyugittkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYUGITTKYKKGUYBX2)
    public String getZtysyugittkykkguybx2() {
        return ztysyugittkykkguybx2;
    }

    public void setZtysyugittkykkguybx2(String pZtysyugittkykkguybx2) {
        ztysyugittkykkguybx2 = pZtysyugittkykkguybx2;
    }

    private String ztysyugittkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYUGITTKYKKGUYBX3)
    public String getZtysyugittkykkguybx3() {
        return ztysyugittkykkguybx3;
    }

    public void setZtysyugittkykkguybx3(String pZtysyugittkykkguybx3) {
        ztysyugittkykkguybx3 = pZtysyugittkykkguybx3;
    }

    private String ztysyugittkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYUGITTKYKKGUYBX4)
    public String getZtysyugittkykkguybx4() {
        return ztysyugittkykkguybx4;
    }

    public void setZtysyugittkykkguybx4(String pZtysyugittkykkguybx4) {
        ztysyugittkykkguybx4 = pZtysyugittkykkguybx4;
    }

    private String ztysyugittkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYUGITTKYKKGUYBX5)
    public String getZtysyugittkykkguybx5() {
        return ztysyugittkykkguybx5;
    }

    public void setZtysyugittkykkguybx5(String pZtysyugittkykkguybx5) {
        ztysyugittkykkguybx5 = pZtysyugittkykkguybx5;
    }

    private String ztysigiwrmstkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGIWRMSTKYKKGUYBX1)
    public String getZtysigiwrmstkykkguybx1() {
        return ztysigiwrmstkykkguybx1;
    }

    public void setZtysigiwrmstkykkguybx1(String pZtysigiwrmstkykkguybx1) {
        ztysigiwrmstkykkguybx1 = pZtysigiwrmstkykkguybx1;
    }

    private String ztysigiwrmstkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGIWRMSTKYKKGUYBX2)
    public String getZtysigiwrmstkykkguybx2() {
        return ztysigiwrmstkykkguybx2;
    }

    public void setZtysigiwrmstkykkguybx2(String pZtysigiwrmstkykkguybx2) {
        ztysigiwrmstkykkguybx2 = pZtysigiwrmstkykkguybx2;
    }

    private String ztysigiwrmstkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGIWRMSTKYKKGUYBX3)
    public String getZtysigiwrmstkykkguybx3() {
        return ztysigiwrmstkykkguybx3;
    }

    public void setZtysigiwrmstkykkguybx3(String pZtysigiwrmstkykkguybx3) {
        ztysigiwrmstkykkguybx3 = pZtysigiwrmstkykkguybx3;
    }

    private String ztysigiwrmstkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGIWRMSTKYKKGUYBX4)
    public String getZtysigiwrmstkykkguybx4() {
        return ztysigiwrmstkykkguybx4;
    }

    public void setZtysigiwrmstkykkguybx4(String pZtysigiwrmstkykkguybx4) {
        ztysigiwrmstkykkguybx4 = pZtysigiwrmstkykkguybx4;
    }

    private String ztysigiwrmstkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGIWRMSTKYKKGUYBX5)
    public String getZtysigiwrmstkykkguybx5() {
        return ztysigiwrmstkykkguybx5;
    }

    public void setZtysigiwrmstkykkguybx5(String pZtysigiwrmstkykkguybx5) {
        ztysigiwrmstkykkguybx5 = pZtysigiwrmstkykkguybx5;
    }

    private String ztysiginyuintkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGINYUINTKYKKGUYBX1)
    public String getZtysiginyuintkykkguybx1() {
        return ztysiginyuintkykkguybx1;
    }

    public void setZtysiginyuintkykkguybx1(String pZtysiginyuintkykkguybx1) {
        ztysiginyuintkykkguybx1 = pZtysiginyuintkykkguybx1;
    }

    private String ztysiginyuintkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGINYUINTKYKKGUYBX2)
    public String getZtysiginyuintkykkguybx2() {
        return ztysiginyuintkykkguybx2;
    }

    public void setZtysiginyuintkykkguybx2(String pZtysiginyuintkykkguybx2) {
        ztysiginyuintkykkguybx2 = pZtysiginyuintkykkguybx2;
    }

    private String ztysiginyuintkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGINYUINTKYKKGUYBX3)
    public String getZtysiginyuintkykkguybx3() {
        return ztysiginyuintkykkguybx3;
    }

    public void setZtysiginyuintkykkguybx3(String pZtysiginyuintkykkguybx3) {
        ztysiginyuintkykkguybx3 = pZtysiginyuintkykkguybx3;
    }

    private String ztysiginyuintkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGINYUINTKYKKGUYBX4)
    public String getZtysiginyuintkykkguybx4() {
        return ztysiginyuintkykkguybx4;
    }

    public void setZtysiginyuintkykkguybx4(String pZtysiginyuintkykkguybx4) {
        ztysiginyuintkykkguybx4 = pZtysiginyuintkykkguybx4;
    }

    private String ztysiginyuintkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIGINYUINTKYKKGUYBX5)
    public String getZtysiginyuintkykkguybx5() {
        return ztysiginyuintkykkguybx5;
    }

    public void setZtysiginyuintkykkguybx5(String pZtysiginyuintkykkguybx5) {
        ztysiginyuintkykkguybx5 = pZtysiginyuintkykkguybx5;
    }

    private String ztysppinyuintkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSPPINYUINTKYKKGUYBX1)
    public String getZtysppinyuintkykkguybx1() {
        return ztysppinyuintkykkguybx1;
    }

    public void setZtysppinyuintkykkguybx1(String pZtysppinyuintkykkguybx1) {
        ztysppinyuintkykkguybx1 = pZtysppinyuintkykkguybx1;
    }

    private String ztysppinyuintkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSPPINYUINTKYKKGUYBX2)
    public String getZtysppinyuintkykkguybx2() {
        return ztysppinyuintkykkguybx2;
    }

    public void setZtysppinyuintkykkguybx2(String pZtysppinyuintkykkguybx2) {
        ztysppinyuintkykkguybx2 = pZtysppinyuintkykkguybx2;
    }

    private String ztysppinyuintkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSPPINYUINTKYKKGUYBX3)
    public String getZtysppinyuintkykkguybx3() {
        return ztysppinyuintkykkguybx3;
    }

    public void setZtysppinyuintkykkguybx3(String pZtysppinyuintkykkguybx3) {
        ztysppinyuintkykkguybx3 = pZtysppinyuintkykkguybx3;
    }

    private String ztysppinyuintkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSPPINYUINTKYKKGUYBX4)
    public String getZtysppinyuintkykkguybx4() {
        return ztysppinyuintkykkguybx4;
    }

    public void setZtysppinyuintkykkguybx4(String pZtysppinyuintkykkguybx4) {
        ztysppinyuintkykkguybx4 = pZtysppinyuintkykkguybx4;
    }

    private String ztysppinyuintkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSPPINYUINTKYKKGUYBX5)
    public String getZtysppinyuintkykkguybx5() {
        return ztysppinyuintkykkguybx5;
    }

    public void setZtysppinyuintkykkguybx5(String pZtysppinyuintkykkguybx5) {
        ztysppinyuintkykkguybx5 = pZtysppinyuintkykkguybx5;
    }

    private String ztysijnbyutkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIJNBYUTKYKKGUYBX1)
    public String getZtysijnbyutkykkguybx1() {
        return ztysijnbyutkykkguybx1;
    }

    public void setZtysijnbyutkykkguybx1(String pZtysijnbyutkykkguybx1) {
        ztysijnbyutkykkguybx1 = pZtysijnbyutkykkguybx1;
    }

    private String ztysijnbyutkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIJNBYUTKYKKGUYBX2)
    public String getZtysijnbyutkykkguybx2() {
        return ztysijnbyutkykkguybx2;
    }

    public void setZtysijnbyutkykkguybx2(String pZtysijnbyutkykkguybx2) {
        ztysijnbyutkykkguybx2 = pZtysijnbyutkykkguybx2;
    }

    private String ztysijnbyutkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIJNBYUTKYKKGUYBX3)
    public String getZtysijnbyutkykkguybx3() {
        return ztysijnbyutkykkguybx3;
    }

    public void setZtysijnbyutkykkguybx3(String pZtysijnbyutkykkguybx3) {
        ztysijnbyutkykkguybx3 = pZtysijnbyutkykkguybx3;
    }

    private String ztysijnbyutkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIJNBYUTKYKKGUYBX4)
    public String getZtysijnbyutkykkguybx4() {
        return ztysijnbyutkykkguybx4;
    }

    public void setZtysijnbyutkykkguybx4(String pZtysijnbyutkykkguybx4) {
        ztysijnbyutkykkguybx4 = pZtysijnbyutkykkguybx4;
    }

    private String ztysijnbyutkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIJNBYUTKYKKGUYBX5)
    public String getZtysijnbyutkykkguybx5() {
        return ztysijnbyutkykkguybx5;
    }

    public void setZtysijnbyutkykkguybx5(String pZtysijnbyutkykkguybx5) {
        ztysijnbyutkykkguybx5 = pZtysijnbyutkykkguybx5;
    }

    private String ztykzkiryoutkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKIRYOUTKYKKGUYBX1)
    public String getZtykzkiryoutkykkguybx1() {
        return ztykzkiryoutkykkguybx1;
    }

    public void setZtykzkiryoutkykkguybx1(String pZtykzkiryoutkykkguybx1) {
        ztykzkiryoutkykkguybx1 = pZtykzkiryoutkykkguybx1;
    }

    private String ztykzkiryoutkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKIRYOUTKYKKGUYBX2)
    public String getZtykzkiryoutkykkguybx2() {
        return ztykzkiryoutkykkguybx2;
    }

    public void setZtykzkiryoutkykkguybx2(String pZtykzkiryoutkykkguybx2) {
        ztykzkiryoutkykkguybx2 = pZtykzkiryoutkykkguybx2;
    }

    private String ztykzkiryoutkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKIRYOUTKYKKGUYBX3)
    public String getZtykzkiryoutkykkguybx3() {
        return ztykzkiryoutkykkguybx3;
    }

    public void setZtykzkiryoutkykkguybx3(String pZtykzkiryoutkykkguybx3) {
        ztykzkiryoutkykkguybx3 = pZtykzkiryoutkykkguybx3;
    }

    private String ztykzkiryoutkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKIRYOUTKYKKGUYBX4)
    public String getZtykzkiryoutkykkguybx4() {
        return ztykzkiryoutkykkguybx4;
    }

    public void setZtykzkiryoutkykkguybx4(String pZtykzkiryoutkykkguybx4) {
        ztykzkiryoutkykkguybx4 = pZtykzkiryoutkykkguybx4;
    }

    private String ztykzkiryoutkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKZKIRYOUTKYKKGUYBX5)
    public String getZtykzkiryoutkykkguybx5() {
        return ztykzkiryoutkykkguybx5;
    }

    public void setZtykzkiryoutkykkguybx5(String pZtykzkiryoutkykkguybx5) {
        ztykzkiryoutkykkguybx5 = pZtykzkiryoutkykkguybx5;
    }

    private String ztysykkyuhtkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYKKYUHTKYKKGUYBX1)
    public String getZtysykkyuhtkykkguybx1() {
        return ztysykkyuhtkykkguybx1;
    }

    public void setZtysykkyuhtkykkguybx1(String pZtysykkyuhtkykkguybx1) {
        ztysykkyuhtkykkguybx1 = pZtysykkyuhtkykkguybx1;
    }

    private String ztysykkyuhtkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYKKYUHTKYKKGUYBX2)
    public String getZtysykkyuhtkykkguybx2() {
        return ztysykkyuhtkykkguybx2;
    }

    public void setZtysykkyuhtkykkguybx2(String pZtysykkyuhtkykkguybx2) {
        ztysykkyuhtkykkguybx2 = pZtysykkyuhtkykkguybx2;
    }

    private String ztysykkyuhtkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYKKYUHTKYKKGUYBX3)
    public String getZtysykkyuhtkykkguybx3() {
        return ztysykkyuhtkykkguybx3;
    }

    public void setZtysykkyuhtkykkguybx3(String pZtysykkyuhtkykkguybx3) {
        ztysykkyuhtkykkguybx3 = pZtysykkyuhtkykkguybx3;
    }

    private String ztysykkyuhtkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYKKYUHTKYKKGUYBX4)
    public String getZtysykkyuhtkykkguybx4() {
        return ztysykkyuhtkykkguybx4;
    }

    public void setZtysykkyuhtkykkguybx4(String pZtysykkyuhtkykkguybx4) {
        ztysykkyuhtkykkguybx4 = pZtysykkyuhtkykkguybx4;
    }

    private String ztysykkyuhtkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSYKKYUHTKYKKGUYBX5)
    public String getZtysykkyuhtkykkguybx5() {
        return ztysykkyuhtkykkguybx5;
    }

    public void setZtysykkyuhtkykkguybx5(String pZtysykkyuhtkykkguybx5) {
        ztysykkyuhtkykkguybx5 = pZtysykkyuhtkykkguybx5;
    }

    private String ztynkdtmrtikguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDTMRTIKGUYOBIX1)
    public String getZtynkdtmrtikguyobix1() {
        return ztynkdtmrtikguyobix1;
    }

    public void setZtynkdtmrtikguyobix1(String pZtynkdtmrtikguyobix1) {
        ztynkdtmrtikguyobix1 = pZtynkdtmrtikguyobix1;
    }

    private String ztynkdtmrtikguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDTMRTIKGUYOBIX2)
    public String getZtynkdtmrtikguyobix2() {
        return ztynkdtmrtikguyobix2;
    }

    public void setZtynkdtmrtikguyobix2(String pZtynkdtmrtikguyobix2) {
        ztynkdtmrtikguyobix2 = pZtynkdtmrtikguyobix2;
    }

    private String ztynkdtmrtikguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDTMRTIKGUYOBIX3)
    public String getZtynkdtmrtikguyobix3() {
        return ztynkdtmrtikguyobix3;
    }

    public void setZtynkdtmrtikguyobix3(String pZtynkdtmrtikguyobix3) {
        ztynkdtmrtikguyobix3 = pZtynkdtmrtikguyobix3;
    }

    private String ztynkdtmrtikguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDTMRTIKGUYOBIX4)
    public String getZtynkdtmrtikguyobix4() {
        return ztynkdtmrtikguyobix4;
    }

    public void setZtynkdtmrtikguyobix4(String pZtynkdtmrtikguyobix4) {
        ztynkdtmrtikguyobix4 = pZtynkdtmrtikguyobix4;
    }

    private String ztynkdtmrtikguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDTMRTIKGUYOBIX5)
    public String getZtynkdtmrtikguyobix5() {
        return ztynkdtmrtikguyobix5;
    }

    public void setZtynkdtmrtikguyobix5(String pZtynkdtmrtikguyobix5) {
        ztynkdtmrtikguyobix5 = pZtynkdtmrtikguyobix5;
    }

    private String ztynkdatetokuteikguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDATETOKUTEIKGUYOBIX1)
    public String getZtynkdatetokuteikguyobix1() {
        return ztynkdatetokuteikguyobix1;
    }

    public void setZtynkdatetokuteikguyobix1(String pZtynkdatetokuteikguyobix1) {
        ztynkdatetokuteikguyobix1 = pZtynkdatetokuteikguyobix1;
    }

    private String ztynkdatetokuteikguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDATETOKUTEIKGUYOBIX2)
    public String getZtynkdatetokuteikguyobix2() {
        return ztynkdatetokuteikguyobix2;
    }

    public void setZtynkdatetokuteikguyobix2(String pZtynkdatetokuteikguyobix2) {
        ztynkdatetokuteikguyobix2 = pZtynkdatetokuteikguyobix2;
    }

    private String ztynkdatetokuteikguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDATETOKUTEIKGUYOBIX3)
    public String getZtynkdatetokuteikguyobix3() {
        return ztynkdatetokuteikguyobix3;
    }

    public void setZtynkdatetokuteikguyobix3(String pZtynkdatetokuteikguyobix3) {
        ztynkdatetokuteikguyobix3 = pZtynkdatetokuteikguyobix3;
    }

    private String ztynkdatetokuteikguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDATETOKUTEIKGUYOBIX4)
    public String getZtynkdatetokuteikguyobix4() {
        return ztynkdatetokuteikguyobix4;
    }

    public void setZtynkdatetokuteikguyobix4(String pZtynkdatetokuteikguyobix4) {
        ztynkdatetokuteikguyobix4 = pZtynkdatetokuteikguyobix4;
    }

    private String ztynkdatetokuteikguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYNKDATETOKUTEIKGUYOBIX5)
    public String getZtynkdatetokuteikguyobix5() {
        return ztynkdatetokuteikguyobix5;
    }

    public void setZtynkdatetokuteikguyobix5(String pZtynkdatetokuteikguyobix5) {
        ztynkdatetokuteikguyobix5 = pZtynkdatetokuteikguyobix5;
    }

    private String ztykaigonkdtmrtikguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTMRTIKGUYOBIX1)
    public String getZtykaigonkdtmrtikguyobix1() {
        return ztykaigonkdtmrtikguyobix1;
    }

    public void setZtykaigonkdtmrtikguyobix1(String pZtykaigonkdtmrtikguyobix1) {
        ztykaigonkdtmrtikguyobix1 = pZtykaigonkdtmrtikguyobix1;
    }

    private String ztykaigonkdtmrtikguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTMRTIKGUYOBIX2)
    public String getZtykaigonkdtmrtikguyobix2() {
        return ztykaigonkdtmrtikguyobix2;
    }

    public void setZtykaigonkdtmrtikguyobix2(String pZtykaigonkdtmrtikguyobix2) {
        ztykaigonkdtmrtikguyobix2 = pZtykaigonkdtmrtikguyobix2;
    }

    private String ztykaigonkdtmrtikguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTMRTIKGUYOBIX3)
    public String getZtykaigonkdtmrtikguyobix3() {
        return ztykaigonkdtmrtikguyobix3;
    }

    public void setZtykaigonkdtmrtikguyobix3(String pZtykaigonkdtmrtikguyobix3) {
        ztykaigonkdtmrtikguyobix3 = pZtykaigonkdtmrtikguyobix3;
    }

    private String ztykaigonkdtmrtikguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTMRTIKGUYOBIX4)
    public String getZtykaigonkdtmrtikguyobix4() {
        return ztykaigonkdtmrtikguyobix4;
    }

    public void setZtykaigonkdtmrtikguyobix4(String pZtykaigonkdtmrtikguyobix4) {
        ztykaigonkdtmrtikguyobix4 = pZtykaigonkdtmrtikguyobix4;
    }

    private String ztykaigonkdtmrtikguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTMRTIKGUYOBIX5)
    public String getZtykaigonkdtmrtikguyobix5() {
        return ztykaigonkdtmrtikguyobix5;
    }

    public void setZtykaigonkdtmrtikguyobix5(String pZtykaigonkdtmrtikguyobix5) {
        ztykaigonkdtmrtikguyobix5 = pZtykaigonkdtmrtikguyobix5;
    }

    private String ztykaigonkdttktikguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTTKTIKGUYOBIX1)
    public String getZtykaigonkdttktikguyobix1() {
        return ztykaigonkdttktikguyobix1;
    }

    public void setZtykaigonkdttktikguyobix1(String pZtykaigonkdttktikguyobix1) {
        ztykaigonkdttktikguyobix1 = pZtykaigonkdttktikguyobix1;
    }

    private String ztykaigonkdttktikguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTTKTIKGUYOBIX2)
    public String getZtykaigonkdttktikguyobix2() {
        return ztykaigonkdttktikguyobix2;
    }

    public void setZtykaigonkdttktikguyobix2(String pZtykaigonkdttktikguyobix2) {
        ztykaigonkdttktikguyobix2 = pZtykaigonkdttktikguyobix2;
    }

    private String ztykaigonkdttktikguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTTKTIKGUYOBIX3)
    public String getZtykaigonkdttktikguyobix3() {
        return ztykaigonkdttktikguyobix3;
    }

    public void setZtykaigonkdttktikguyobix3(String pZtykaigonkdttktikguyobix3) {
        ztykaigonkdttktikguyobix3 = pZtykaigonkdttktikguyobix3;
    }

    private String ztykaigonkdttktikguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTTKTIKGUYOBIX4)
    public String getZtykaigonkdttktikguyobix4() {
        return ztykaigonkdttktikguyobix4;
    }

    public void setZtykaigonkdttktikguyobix4(String pZtykaigonkdttktikguyobix4) {
        ztykaigonkdttktikguyobix4 = pZtykaigonkdttktikguyobix4;
    }

    private String ztykaigonkdttktikguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKDTTKTIKGUYOBIX5)
    public String getZtykaigonkdttktikguyobix5() {
        return ztykaigonkdttktikguyobix5;
    }

    public void setZtykaigonkdttktikguyobix5(String pZtykaigonkdttktikguyobix5) {
        ztykaigonkdttktikguyobix5 = pZtykaigonkdttktikguyobix5;
    }

    private String ztykaigomaruteikigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOMARUTEIKIGOUYOBIX1)
    public String getZtykaigomaruteikigouyobix1() {
        return ztykaigomaruteikigouyobix1;
    }

    public void setZtykaigomaruteikigouyobix1(String pZtykaigomaruteikigouyobix1) {
        ztykaigomaruteikigouyobix1 = pZtykaigomaruteikigouyobix1;
    }

    private String ztykaigomaruteikigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOMARUTEIKIGOUYOBIX2)
    public String getZtykaigomaruteikigouyobix2() {
        return ztykaigomaruteikigouyobix2;
    }

    public void setZtykaigomaruteikigouyobix2(String pZtykaigomaruteikigouyobix2) {
        ztykaigomaruteikigouyobix2 = pZtykaigomaruteikigouyobix2;
    }

    private String ztykaigomaruteikigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOMARUTEIKIGOUYOBIX3)
    public String getZtykaigomaruteikigouyobix3() {
        return ztykaigomaruteikigouyobix3;
    }

    public void setZtykaigomaruteikigouyobix3(String pZtykaigomaruteikigouyobix3) {
        ztykaigomaruteikigouyobix3 = pZtykaigomaruteikigouyobix3;
    }

    private String ztykaigomaruteikigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOMARUTEIKIGOUYOBIX4)
    public String getZtykaigomaruteikigouyobix4() {
        return ztykaigomaruteikigouyobix4;
    }

    public void setZtykaigomaruteikigouyobix4(String pZtykaigomaruteikigouyobix4) {
        ztykaigomaruteikigouyobix4 = pZtykaigomaruteikigouyobix4;
    }

    private String ztykaigomaruteikigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOMARUTEIKIGOUYOBIX5)
    public String getZtykaigomaruteikigouyobix5() {
        return ztykaigomaruteikigouyobix5;
    }

    public void setZtykaigomaruteikigouyobix5(String pZtykaigomaruteikigouyobix5) {
        ztykaigomaruteikigouyobix5 = pZtykaigomaruteikigouyobix5;
    }

    private String ztykaigotokuteikigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOTOKUTEIKIGOUYOBIX1)
    public String getZtykaigotokuteikigouyobix1() {
        return ztykaigotokuteikigouyobix1;
    }

    public void setZtykaigotokuteikigouyobix1(String pZtykaigotokuteikigouyobix1) {
        ztykaigotokuteikigouyobix1 = pZtykaigotokuteikigouyobix1;
    }

    private String ztykaigotokuteikigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOTOKUTEIKIGOUYOBIX2)
    public String getZtykaigotokuteikigouyobix2() {
        return ztykaigotokuteikigouyobix2;
    }

    public void setZtykaigotokuteikigouyobix2(String pZtykaigotokuteikigouyobix2) {
        ztykaigotokuteikigouyobix2 = pZtykaigotokuteikigouyobix2;
    }

    private String ztykaigotokuteikigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOTOKUTEIKIGOUYOBIX3)
    public String getZtykaigotokuteikigouyobix3() {
        return ztykaigotokuteikigouyobix3;
    }

    public void setZtykaigotokuteikigouyobix3(String pZtykaigotokuteikigouyobix3) {
        ztykaigotokuteikigouyobix3 = pZtykaigotokuteikigouyobix3;
    }

    private String ztykaigotokuteikigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOTOKUTEIKIGOUYOBIX4)
    public String getZtykaigotokuteikigouyobix4() {
        return ztykaigotokuteikigouyobix4;
    }

    public void setZtykaigotokuteikigouyobix4(String pZtykaigotokuteikigouyobix4) {
        ztykaigotokuteikigouyobix4 = pZtykaigotokuteikigouyobix4;
    }

    private String ztykaigotokuteikigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGOTOKUTEIKIGOUYOBIX5)
    public String getZtykaigotokuteikigouyobix5() {
        return ztykaigotokuteikigouyobix5;
    }

    public void setZtykaigotokuteikigouyobix5(String pZtykaigotokuteikigouyobix5) {
        ztykaigotokuteikigouyobix5 = pZtykaigotokuteikigouyobix5;
    }

    private String ztysiznmrtikguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIZNMRTIKGUYBX1)
    public String getZtysiznmrtikguybx1() {
        return ztysiznmrtikguybx1;
    }

    public void setZtysiznmrtikguybx1(String pZtysiznmrtikguybx1) {
        ztysiznmrtikguybx1 = pZtysiznmrtikguybx1;
    }

    private String ztysiznmrtikguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIZNMRTIKGUYBX2)
    public String getZtysiznmrtikguybx2() {
        return ztysiznmrtikguybx2;
    }

    public void setZtysiznmrtikguybx2(String pZtysiznmrtikguybx2) {
        ztysiznmrtikguybx2 = pZtysiznmrtikguybx2;
    }

    private String ztysiznmrtikguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIZNMRTIKGUYBX3)
    public String getZtysiznmrtikguybx3() {
        return ztysiznmrtikguybx3;
    }

    public void setZtysiznmrtikguybx3(String pZtysiznmrtikguybx3) {
        ztysiznmrtikguybx3 = pZtysiznmrtikguybx3;
    }

    private String ztysiznmrtikguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIZNMRTIKGUYBX4)
    public String getZtysiznmrtikguybx4() {
        return ztysiznmrtikguybx4;
    }

    public void setZtysiznmrtikguybx4(String pZtysiznmrtikguybx4) {
        ztysiznmrtikguybx4 = pZtysiznmrtikguybx4;
    }

    private String ztysiznmrtikguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSIZNMRTIKGUYBX5)
    public String getZtysiznmrtikguybx5() {
        return ztysiznmrtikguybx5;
    }

    public void setZtysiznmrtikguybx5(String pZtysiznmrtikguybx5) {
        ztysiznmrtikguybx5 = pZtysiznmrtikguybx5;
    }

    private String ztyteigenmaruteikigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENMARUTEIKIGOUYOBIX1)
    public String getZtyteigenmaruteikigouyobix1() {
        return ztyteigenmaruteikigouyobix1;
    }

    public void setZtyteigenmaruteikigouyobix1(String pZtyteigenmaruteikigouyobix1) {
        ztyteigenmaruteikigouyobix1 = pZtyteigenmaruteikigouyobix1;
    }

    private String ztyteigenmaruteikigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENMARUTEIKIGOUYOBIX2)
    public String getZtyteigenmaruteikigouyobix2() {
        return ztyteigenmaruteikigouyobix2;
    }

    public void setZtyteigenmaruteikigouyobix2(String pZtyteigenmaruteikigouyobix2) {
        ztyteigenmaruteikigouyobix2 = pZtyteigenmaruteikigouyobix2;
    }

    private String ztyteigenmaruteikigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENMARUTEIKIGOUYOBIX3)
    public String getZtyteigenmaruteikigouyobix3() {
        return ztyteigenmaruteikigouyobix3;
    }

    public void setZtyteigenmaruteikigouyobix3(String pZtyteigenmaruteikigouyobix3) {
        ztyteigenmaruteikigouyobix3 = pZtyteigenmaruteikigouyobix3;
    }

    private String ztyteigenmaruteikigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENMARUTEIKIGOUYOBIX4)
    public String getZtyteigenmaruteikigouyobix4() {
        return ztyteigenmaruteikigouyobix4;
    }

    public void setZtyteigenmaruteikigouyobix4(String pZtyteigenmaruteikigouyobix4) {
        ztyteigenmaruteikigouyobix4 = pZtyteigenmaruteikigouyobix4;
    }

    private String ztyteigenmaruteikigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENMARUTEIKIGOUYOBIX5)
    public String getZtyteigenmaruteikigouyobix5() {
        return ztyteigenmaruteikigouyobix5;
    }

    public void setZtyteigenmaruteikigouyobix5(String pZtyteigenmaruteikigouyobix5) {
        ztyteigenmaruteikigouyobix5 = pZtyteigenmaruteikigouyobix5;
    }

    private String ztyteigentokuteikigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENTOKUTEIKIGOUYOBIX1)
    public String getZtyteigentokuteikigouyobix1() {
        return ztyteigentokuteikigouyobix1;
    }

    public void setZtyteigentokuteikigouyobix1(String pZtyteigentokuteikigouyobix1) {
        ztyteigentokuteikigouyobix1 = pZtyteigentokuteikigouyobix1;
    }

    private String ztyteigentokuteikigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENTOKUTEIKIGOUYOBIX2)
    public String getZtyteigentokuteikigouyobix2() {
        return ztyteigentokuteikigouyobix2;
    }

    public void setZtyteigentokuteikigouyobix2(String pZtyteigentokuteikigouyobix2) {
        ztyteigentokuteikigouyobix2 = pZtyteigentokuteikigouyobix2;
    }

    private String ztyteigentokuteikigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENTOKUTEIKIGOUYOBIX3)
    public String getZtyteigentokuteikigouyobix3() {
        return ztyteigentokuteikigouyobix3;
    }

    public void setZtyteigentokuteikigouyobix3(String pZtyteigentokuteikigouyobix3) {
        ztyteigentokuteikigouyobix3 = pZtyteigentokuteikigouyobix3;
    }

    private String ztyteigentokuteikigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENTOKUTEIKIGOUYOBIX4)
    public String getZtyteigentokuteikigouyobix4() {
        return ztyteigentokuteikigouyobix4;
    }

    public void setZtyteigentokuteikigouyobix4(String pZtyteigentokuteikigouyobix4) {
        ztyteigentokuteikigouyobix4 = pZtyteigentokuteikigouyobix4;
    }

    private String ztyteigentokuteikigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTEIGENTOKUTEIKIGOUYOBIX5)
    public String getZtyteigentokuteikigouyobix5() {
        return ztyteigentokuteikigouyobix5;
    }

    public void setZtyteigentokuteikigouyobix5(String pZtyteigentokuteikigouyobix5) {
        ztyteigentokuteikigouyobix5 = pZtyteigentokuteikigouyobix5;
    }

    private String ztykigtignmrtikguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNMRTIKGUYBX1)
    public String getZtykigtignmrtikguybx1() {
        return ztykigtignmrtikguybx1;
    }

    public void setZtykigtignmrtikguybx1(String pZtykigtignmrtikguybx1) {
        ztykigtignmrtikguybx1 = pZtykigtignmrtikguybx1;
    }

    private String ztykigtignmrtikguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNMRTIKGUYBX2)
    public String getZtykigtignmrtikguybx2() {
        return ztykigtignmrtikguybx2;
    }

    public void setZtykigtignmrtikguybx2(String pZtykigtignmrtikguybx2) {
        ztykigtignmrtikguybx2 = pZtykigtignmrtikguybx2;
    }

    private String ztykigtignmrtikguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNMRTIKGUYBX3)
    public String getZtykigtignmrtikguybx3() {
        return ztykigtignmrtikguybx3;
    }

    public void setZtykigtignmrtikguybx3(String pZtykigtignmrtikguybx3) {
        ztykigtignmrtikguybx3 = pZtykigtignmrtikguybx3;
    }

    private String ztykigtignmrtikguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNMRTIKGUYBX4)
    public String getZtykigtignmrtikguybx4() {
        return ztykigtignmrtikguybx4;
    }

    public void setZtykigtignmrtikguybx4(String pZtykigtignmrtikguybx4) {
        ztykigtignmrtikguybx4 = pZtykigtignmrtikguybx4;
    }

    private String ztykigtignmrtikguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNMRTIKGUYBX5)
    public String getZtykigtignmrtikguybx5() {
        return ztykigtignmrtikguybx5;
    }

    public void setZtykigtignmrtikguybx5(String pZtykigtignmrtikguybx5) {
        ztykigtignmrtikguybx5 = pZtykigtignmrtikguybx5;
    }

    private String ztykigtigntktikguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNTKTIKGUYBX1)
    public String getZtykigtigntktikguybx1() {
        return ztykigtigntktikguybx1;
    }

    public void setZtykigtigntktikguybx1(String pZtykigtigntktikguybx1) {
        ztykigtigntktikguybx1 = pZtykigtigntktikguybx1;
    }

    private String ztykigtigntktikguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNTKTIKGUYBX2)
    public String getZtykigtigntktikguybx2() {
        return ztykigtigntktikguybx2;
    }

    public void setZtykigtigntktikguybx2(String pZtykigtigntktikguybx2) {
        ztykigtigntktikguybx2 = pZtykigtigntktikguybx2;
    }

    private String ztykigtigntktikguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNTKTIKGUYBX3)
    public String getZtykigtigntktikguybx3() {
        return ztykigtigntktikguybx3;
    }

    public void setZtykigtigntktikguybx3(String pZtykigtigntktikguybx3) {
        ztykigtigntktikguybx3 = pZtykigtigntktikguybx3;
    }

    private String ztykigtigntktikguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNTKTIKGUYBX4)
    public String getZtykigtigntktikguybx4() {
        return ztykigtigntktikguybx4;
    }

    public void setZtykigtigntktikguybx4(String pZtykigtigntktikguybx4) {
        ztykigtigntktikguybx4 = pZtykigtigntktikguybx4;
    }

    private String ztykigtigntktikguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKIGTIGNTKTIKGUYBX5)
    public String getZtykigtigntktikguybx5() {
        return ztykigtigntktikguybx5;
    }

    public void setZtykigtigntktikguybx5(String pZtykigtigntktikguybx5) {
        ztykigtigntktikguybx5 = pZtykigtigntktikguybx5;
    }

    private String ztytuuintokuyakukigouyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTUUINTOKUYAKUKIGOUYOBIX1)
    public String getZtytuuintokuyakukigouyobix1() {
        return ztytuuintokuyakukigouyobix1;
    }

    public void setZtytuuintokuyakukigouyobix1(String pZtytuuintokuyakukigouyobix1) {
        ztytuuintokuyakukigouyobix1 = pZtytuuintokuyakukigouyobix1;
    }

    private String ztytuuintokuyakukigouyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTUUINTOKUYAKUKIGOUYOBIX2)
    public String getZtytuuintokuyakukigouyobix2() {
        return ztytuuintokuyakukigouyobix2;
    }

    public void setZtytuuintokuyakukigouyobix2(String pZtytuuintokuyakukigouyobix2) {
        ztytuuintokuyakukigouyobix2 = pZtytuuintokuyakukigouyobix2;
    }

    private String ztytuuintokuyakukigouyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTUUINTOKUYAKUKIGOUYOBIX3)
    public String getZtytuuintokuyakukigouyobix3() {
        return ztytuuintokuyakukigouyobix3;
    }

    public void setZtytuuintokuyakukigouyobix3(String pZtytuuintokuyakukigouyobix3) {
        ztytuuintokuyakukigouyobix3 = pZtytuuintokuyakukigouyobix3;
    }

    private String ztytuuintokuyakukigouyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTUUINTOKUYAKUKIGOUYOBIX4)
    public String getZtytuuintokuyakukigouyobix4() {
        return ztytuuintokuyakukigouyobix4;
    }

    public void setZtytuuintokuyakukigouyobix4(String pZtytuuintokuyakukigouyobix4) {
        ztytuuintokuyakukigouyobix4 = pZtytuuintokuyakukigouyobix4;
    }

    private String ztytuuintokuyakukigouyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTUUINTOKUYAKUKIGOUYOBIX5)
    public String getZtytuuintokuyakukigouyobix5() {
        return ztytuuintokuyakukigouyobix5;
    }

    public void setZtytuuintokuyakukigouyobix5(String pZtytuuintokuyakukigouyobix5) {
        ztytuuintokuyakukigouyobix5 = pZtytuuintokuyakukigouyobix5;
    }

    private String ztyjysisppitkykkguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYJYSISPPITKYKKGUYOBIX1)
    public String getZtyjysisppitkykkguyobix1() {
        return ztyjysisppitkykkguyobix1;
    }

    public void setZtyjysisppitkykkguyobix1(String pZtyjysisppitkykkguyobix1) {
        ztyjysisppitkykkguyobix1 = pZtyjysisppitkykkguyobix1;
    }

    private String ztyjysisppitkykkguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYJYSISPPITKYKKGUYOBIX2)
    public String getZtyjysisppitkykkguyobix2() {
        return ztyjysisppitkykkguyobix2;
    }

    public void setZtyjysisppitkykkguyobix2(String pZtyjysisppitkykkguyobix2) {
        ztyjysisppitkykkguyobix2 = pZtyjysisppitkykkguyobix2;
    }

    private String ztyjysisppitkykkguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYJYSISPPITKYKKGUYOBIX3)
    public String getZtyjysisppitkykkguyobix3() {
        return ztyjysisppitkykkguyobix3;
    }

    public void setZtyjysisppitkykkguyobix3(String pZtyjysisppitkykkguyobix3) {
        ztyjysisppitkykkguyobix3 = pZtyjysisppitkykkguyobix3;
    }

    private String ztyjysisppitkykkguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYJYSISPPITKYKKGUYOBIX4)
    public String getZtyjysisppitkykkguyobix4() {
        return ztyjysisppitkykkguyobix4;
    }

    public void setZtyjysisppitkykkguyobix4(String pZtyjysisppitkykkguyobix4) {
        ztyjysisppitkykkguyobix4 = pZtyjysisppitkykkguyobix4;
    }

    private String ztyjysisppitkykkguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYJYSISPPITKYKKGUYOBIX5)
    public String getZtyjysisppitkykkguyobix5() {
        return ztyjysisppitkykkguyobix5;
    }

    public void setZtyjysisppitkykkguyobix5(String pZtyjysisppitkykkguyobix5) {
        ztyjysisppitkykkguyobix5 = pZtyjysisppitkykkguyobix5;
    }

    private String ztytksttkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTKSTTKYKKGUYBX1)
    public String getZtytksttkykkguybx1() {
        return ztytksttkykkguybx1;
    }

    public void setZtytksttkykkguybx1(String pZtytksttkykkguybx1) {
        ztytksttkykkguybx1 = pZtytksttkykkguybx1;
    }

    private String ztytksttkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTKSTTKYKKGUYBX2)
    public String getZtytksttkykkguybx2() {
        return ztytksttkykkguybx2;
    }

    public void setZtytksttkykkguybx2(String pZtytksttkykkguybx2) {
        ztytksttkykkguybx2 = pZtytksttkykkguybx2;
    }

    private String ztytksttkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTKSTTKYKKGUYBX3)
    public String getZtytksttkykkguybx3() {
        return ztytksttkykkguybx3;
    }

    public void setZtytksttkykkguybx3(String pZtytksttkykkguybx3) {
        ztytksttkykkguybx3 = pZtytksttkykkguybx3;
    }

    private String ztytksttkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTKSTTKYKKGUYBX4)
    public String getZtytksttkykkguybx4() {
        return ztytksttkykkguybx4;
    }

    public void setZtytksttkykkguybx4(String pZtytksttkykkguybx4) {
        ztytksttkykkguybx4 = pZtytksttkykkguybx4;
    }

    private String ztytksttkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYTKSTTKYKKGUYBX5)
    public String getZtytksttkykkguybx5() {
        return ztytksttkykkguybx5;
    }

    public void setZtytksttkykkguybx5(String pZtytksttkykkguybx5) {
        ztytksttkykkguybx5 = pZtytksttkykkguybx5;
    }

    private String ztydi2tksttkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2TKSTTKYKKGUYBX1)
    public String getZtydi2tksttkykkguybx1() {
        return ztydi2tksttkykkguybx1;
    }

    public void setZtydi2tksttkykkguybx1(String pZtydi2tksttkykkguybx1) {
        ztydi2tksttkykkguybx1 = pZtydi2tksttkykkguybx1;
    }

    private String ztydi2tksttkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2TKSTTKYKKGUYBX2)
    public String getZtydi2tksttkykkguybx2() {
        return ztydi2tksttkykkguybx2;
    }

    public void setZtydi2tksttkykkguybx2(String pZtydi2tksttkykkguybx2) {
        ztydi2tksttkykkguybx2 = pZtydi2tksttkykkguybx2;
    }

    private String ztydi2tksttkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2TKSTTKYKKGUYBX3)
    public String getZtydi2tksttkykkguybx3() {
        return ztydi2tksttkykkguybx3;
    }

    public void setZtydi2tksttkykkguybx3(String pZtydi2tksttkykkguybx3) {
        ztydi2tksttkykkguybx3 = pZtydi2tksttkykkguybx3;
    }

    private String ztydi2tksttkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2TKSTTKYKKGUYBX4)
    public String getZtydi2tksttkykkguybx4() {
        return ztydi2tksttkykkguybx4;
    }

    public void setZtydi2tksttkykkguybx4(String pZtydi2tksttkykkguybx4) {
        ztydi2tksttkykkguybx4 = pZtydi2tksttkykkguybx4;
    }

    private String ztydi2tksttkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2TKSTTKYKKGUYBX5)
    public String getZtydi2tksttkykkguybx5() {
        return ztydi2tksttkykkguybx5;
    }

    public void setZtydi2tksttkykkguybx5(String pZtydi2tksttkykkguybx5) {
        ztydi2tksttkykkguybx5 = pZtydi2tksttkykkguybx5;
    }

    private String ztymnsttkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMNSTTKYKKGUYBX1)
    public String getZtymnsttkykkguybx1() {
        return ztymnsttkykkguybx1;
    }

    public void setZtymnsttkykkguybx1(String pZtymnsttkykkguybx1) {
        ztymnsttkykkguybx1 = pZtymnsttkykkguybx1;
    }

    private String ztymnsttkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMNSTTKYKKGUYBX2)
    public String getZtymnsttkykkguybx2() {
        return ztymnsttkykkguybx2;
    }

    public void setZtymnsttkykkguybx2(String pZtymnsttkykkguybx2) {
        ztymnsttkykkguybx2 = pZtymnsttkykkguybx2;
    }

    private String ztymnsttkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMNSTTKYKKGUYBX3)
    public String getZtymnsttkykkguybx3() {
        return ztymnsttkykkguybx3;
    }

    public void setZtymnsttkykkguybx3(String pZtymnsttkykkguybx3) {
        ztymnsttkykkguybx3 = pZtymnsttkykkguybx3;
    }

    private String ztymnsttkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMNSTTKYKKGUYBX4)
    public String getZtymnsttkykkguybx4() {
        return ztymnsttkykkguybx4;
    }

    public void setZtymnsttkykkguybx4(String pZtymnsttkykkguybx4) {
        ztymnsttkykkguybx4 = pZtymnsttkykkguybx4;
    }

    private String ztymnsttkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYMNSTTKYKKGUYBX5)
    public String getZtymnsttkykkguybx5() {
        return ztymnsttkykkguybx5;
    }

    public void setZtymnsttkykkguybx5(String pZtymnsttkykkguybx5) {
        ztymnsttkykkguybx5 = pZtymnsttkykkguybx5;
    }

    private String ztydi2mnsttkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2MNSTTKYKKGUYBX1)
    public String getZtydi2mnsttkykkguybx1() {
        return ztydi2mnsttkykkguybx1;
    }

    public void setZtydi2mnsttkykkguybx1(String pZtydi2mnsttkykkguybx1) {
        ztydi2mnsttkykkguybx1 = pZtydi2mnsttkykkguybx1;
    }

    private String ztydi2mnsttkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2MNSTTKYKKGUYBX2)
    public String getZtydi2mnsttkykkguybx2() {
        return ztydi2mnsttkykkguybx2;
    }

    public void setZtydi2mnsttkykkguybx2(String pZtydi2mnsttkykkguybx2) {
        ztydi2mnsttkykkguybx2 = pZtydi2mnsttkykkguybx2;
    }

    private String ztydi2mnsttkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2MNSTTKYKKGUYBX3)
    public String getZtydi2mnsttkykkguybx3() {
        return ztydi2mnsttkykkguybx3;
    }

    public void setZtydi2mnsttkykkguybx3(String pZtydi2mnsttkykkguybx3) {
        ztydi2mnsttkykkguybx3 = pZtydi2mnsttkykkguybx3;
    }

    private String ztydi2mnsttkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2MNSTTKYKKGUYBX4)
    public String getZtydi2mnsttkykkguybx4() {
        return ztydi2mnsttkykkguybx4;
    }

    public void setZtydi2mnsttkykkguybx4(String pZtydi2mnsttkykkguybx4) {
        ztydi2mnsttkykkguybx4 = pZtydi2mnsttkykkguybx4;
    }

    private String ztydi2mnsttkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2MNSTTKYKKGUYBX5)
    public String getZtydi2mnsttkykkguybx5() {
        return ztydi2mnsttkykkguybx5;
    }

    public void setZtydi2mnsttkykkguybx5(String pZtydi2mnsttkykkguybx5) {
        ztydi2mnsttkykkguybx5 = pZtydi2mnsttkykkguybx5;
    }

    private String ztysugusnsyutkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSUGUSNSYUTKYKKGUYBX1)
    public String getZtysugusnsyutkykkguybx1() {
        return ztysugusnsyutkykkguybx1;
    }

    public void setZtysugusnsyutkykkguybx1(String pZtysugusnsyutkykkguybx1) {
        ztysugusnsyutkykkguybx1 = pZtysugusnsyutkykkguybx1;
    }

    private String ztysugusnsyutkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSUGUSNSYUTKYKKGUYBX2)
    public String getZtysugusnsyutkykkguybx2() {
        return ztysugusnsyutkykkguybx2;
    }

    public void setZtysugusnsyutkykkguybx2(String pZtysugusnsyutkykkguybx2) {
        ztysugusnsyutkykkguybx2 = pZtysugusnsyutkykkguybx2;
    }

    private String ztysugusnsyutkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSUGUSNSYUTKYKKGUYBX3)
    public String getZtysugusnsyutkykkguybx3() {
        return ztysugusnsyutkykkguybx3;
    }

    public void setZtysugusnsyutkykkguybx3(String pZtysugusnsyutkykkguybx3) {
        ztysugusnsyutkykkguybx3 = pZtysugusnsyutkykkguybx3;
    }

    private String ztysugusnsyutkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSUGUSNSYUTKYKKGUYBX4)
    public String getZtysugusnsyutkykkguybx4() {
        return ztysugusnsyutkykkguybx4;
    }

    public void setZtysugusnsyutkykkguybx4(String pZtysugusnsyutkykkguybx4) {
        ztysugusnsyutkykkguybx4 = pZtysugusnsyutkykkguybx4;
    }

    private String ztysugusnsyutkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSUGUSNSYUTKYKKGUYBX5)
    public String getZtysugusnsyutkykkguybx5() {
        return ztysugusnsyutkykkguybx5;
    }

    public void setZtysugusnsyutkykkguybx5(String pZtysugusnsyutkykkguybx5) {
        ztysugusnsyutkykkguybx5 = pZtysugusnsyutkykkguybx5;
    }

    private String ztykaigonktkykkguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKTKYKKGUYOBIX1)
    public String getZtykaigonktkykkguyobix1() {
        return ztykaigonktkykkguyobix1;
    }

    public void setZtykaigonktkykkguyobix1(String pZtykaigonktkykkguyobix1) {
        ztykaigonktkykkguyobix1 = pZtykaigonktkykkguyobix1;
    }

    private String ztykaigonktkykkguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKTKYKKGUYOBIX2)
    public String getZtykaigonktkykkguyobix2() {
        return ztykaigonktkykkguyobix2;
    }

    public void setZtykaigonktkykkguyobix2(String pZtykaigonktkykkguyobix2) {
        ztykaigonktkykkguyobix2 = pZtykaigonktkykkguyobix2;
    }

    private String ztykaigonktkykkguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKTKYKKGUYOBIX3)
    public String getZtykaigonktkykkguyobix3() {
        return ztykaigonktkykkguyobix3;
    }

    public void setZtykaigonktkykkguyobix3(String pZtykaigonktkykkguyobix3) {
        ztykaigonktkykkguyobix3 = pZtykaigonktkykkguyobix3;
    }

    private String ztykaigonktkykkguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKTKYKKGUYOBIX4)
    public String getZtykaigonktkykkguyobix4() {
        return ztykaigonktkykkguyobix4;
    }

    public void setZtykaigonktkykkguyobix4(String pZtykaigonktkykkguyobix4) {
        ztykaigonktkykkguyobix4 = pZtykaigonktkykkguyobix4;
    }

    private String ztykaigonktkykkguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYKAIGONKTKYKKGUYOBIX5)
    public String getZtykaigonktkykkguyobix5() {
        return ztykaigonktkykkguyobix5;
    }

    public void setZtykaigonktkykkguyobix5(String pZtykaigonktkykkguyobix5) {
        ztykaigonktkykkguyobix5 = pZtykaigonktkykkguyobix5;
    }

    private String ztyitjbrkignktkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYITJBRKIGNKTKYKKGUYBX1)
    public String getZtyitjbrkignktkykkguybx1() {
        return ztyitjbrkignktkykkguybx1;
    }

    public void setZtyitjbrkignktkykkguybx1(String pZtyitjbrkignktkykkguybx1) {
        ztyitjbrkignktkykkguybx1 = pZtyitjbrkignktkykkguybx1;
    }

    private String ztyitjbrkignktkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYITJBRKIGNKTKYKKGUYBX2)
    public String getZtyitjbrkignktkykkguybx2() {
        return ztyitjbrkignktkykkguybx2;
    }

    public void setZtyitjbrkignktkykkguybx2(String pZtyitjbrkignktkykkguybx2) {
        ztyitjbrkignktkykkguybx2 = pZtyitjbrkignktkykkguybx2;
    }

    private String ztyitjbrkignktkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYITJBRKIGNKTKYKKGUYBX3)
    public String getZtyitjbrkignktkykkguybx3() {
        return ztyitjbrkignktkykkguybx3;
    }

    public void setZtyitjbrkignktkykkguybx3(String pZtyitjbrkignktkykkguybx3) {
        ztyitjbrkignktkykkguybx3 = pZtyitjbrkignktkykkguybx3;
    }

    private String ztyitjbrkignktkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYITJBRKIGNKTKYKKGUYBX4)
    public String getZtyitjbrkignktkykkguybx4() {
        return ztyitjbrkignktkykkguybx4;
    }

    public void setZtyitjbrkignktkykkguybx4(String pZtyitjbrkignktkykkguybx4) {
        ztyitjbrkignktkykkguybx4 = pZtyitjbrkignktkykkguybx4;
    }

    private String ztyitjbrkignktkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYITJBRKIGNKTKYKKGUYBX5)
    public String getZtyitjbrkignktkykkguybx5() {
        return ztyitjbrkignktkykkguybx5;
    }

    public void setZtyitjbrkignktkykkguybx5(String pZtyitjbrkignktkykkguybx5) {
        ztyitjbrkignktkykkguybx5 = pZtyitjbrkignktkykkguybx5;
    }

    private String ztydi2syugitkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYUGITKYKKGUYBX1)
    public String getZtydi2syugitkykkguybx1() {
        return ztydi2syugitkykkguybx1;
    }

    public void setZtydi2syugitkykkguybx1(String pZtydi2syugitkykkguybx1) {
        ztydi2syugitkykkguybx1 = pZtydi2syugitkykkguybx1;
    }

    private String ztydi2syugitkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYUGITKYKKGUYBX2)
    public String getZtydi2syugitkykkguybx2() {
        return ztydi2syugitkykkguybx2;
    }

    public void setZtydi2syugitkykkguybx2(String pZtydi2syugitkykkguybx2) {
        ztydi2syugitkykkguybx2 = pZtydi2syugitkykkguybx2;
    }

    private String ztydi2syugitkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYUGITKYKKGUYBX3)
    public String getZtydi2syugitkykkguybx3() {
        return ztydi2syugitkykkguybx3;
    }

    public void setZtydi2syugitkykkguybx3(String pZtydi2syugitkykkguybx3) {
        ztydi2syugitkykkguybx3 = pZtydi2syugitkykkguybx3;
    }

    private String ztydi2syugitkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYUGITKYKKGUYBX4)
    public String getZtydi2syugitkykkguybx4() {
        return ztydi2syugitkykkguybx4;
    }

    public void setZtydi2syugitkykkguybx4(String pZtydi2syugitkykkguybx4) {
        ztydi2syugitkykkguybx4 = pZtydi2syugitkykkguybx4;
    }

    private String ztydi2syugitkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYUGITKYKKGUYBX5)
    public String getZtydi2syugitkykkguybx5() {
        return ztydi2syugitkykkguybx5;
    }

    public void setZtydi2syugitkykkguybx5(String pZtydi2syugitkykkguybx5) {
        ztydi2syugitkykkguybx5 = pZtydi2syugitkykkguybx5;
    }

    private String ztydi2sigiwrmstkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGIWRMSTKYKKGUYBX1)
    public String getZtydi2sigiwrmstkykkguybx1() {
        return ztydi2sigiwrmstkykkguybx1;
    }

    public void setZtydi2sigiwrmstkykkguybx1(String pZtydi2sigiwrmstkykkguybx1) {
        ztydi2sigiwrmstkykkguybx1 = pZtydi2sigiwrmstkykkguybx1;
    }

    private String ztydi2sigiwrmstkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGIWRMSTKYKKGUYBX2)
    public String getZtydi2sigiwrmstkykkguybx2() {
        return ztydi2sigiwrmstkykkguybx2;
    }

    public void setZtydi2sigiwrmstkykkguybx2(String pZtydi2sigiwrmstkykkguybx2) {
        ztydi2sigiwrmstkykkguybx2 = pZtydi2sigiwrmstkykkguybx2;
    }

    private String ztydi2sigiwrmstkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGIWRMSTKYKKGUYBX3)
    public String getZtydi2sigiwrmstkykkguybx3() {
        return ztydi2sigiwrmstkykkguybx3;
    }

    public void setZtydi2sigiwrmstkykkguybx3(String pZtydi2sigiwrmstkykkguybx3) {
        ztydi2sigiwrmstkykkguybx3 = pZtydi2sigiwrmstkykkguybx3;
    }

    private String ztydi2sigiwrmstkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGIWRMSTKYKKGUYBX4)
    public String getZtydi2sigiwrmstkykkguybx4() {
        return ztydi2sigiwrmstkykkguybx4;
    }

    public void setZtydi2sigiwrmstkykkguybx4(String pZtydi2sigiwrmstkykkguybx4) {
        ztydi2sigiwrmstkykkguybx4 = pZtydi2sigiwrmstkykkguybx4;
    }

    private String ztydi2sigiwrmstkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGIWRMSTKYKKGUYBX5)
    public String getZtydi2sigiwrmstkykkguybx5() {
        return ztydi2sigiwrmstkykkguybx5;
    }

    public void setZtydi2sigiwrmstkykkguybx5(String pZtydi2sigiwrmstkykkguybx5) {
        ztydi2sigiwrmstkykkguybx5 = pZtydi2sigiwrmstkykkguybx5;
    }

    private String ztydi2siginyuintkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGINYUINTKYKKGUYBX1)
    public String getZtydi2siginyuintkykkguybx1() {
        return ztydi2siginyuintkykkguybx1;
    }

    public void setZtydi2siginyuintkykkguybx1(String pZtydi2siginyuintkykkguybx1) {
        ztydi2siginyuintkykkguybx1 = pZtydi2siginyuintkykkguybx1;
    }

    private String ztydi2siginyuintkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGINYUINTKYKKGUYBX2)
    public String getZtydi2siginyuintkykkguybx2() {
        return ztydi2siginyuintkykkguybx2;
    }

    public void setZtydi2siginyuintkykkguybx2(String pZtydi2siginyuintkykkguybx2) {
        ztydi2siginyuintkykkguybx2 = pZtydi2siginyuintkykkguybx2;
    }

    private String ztydi2siginyuintkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGINYUINTKYKKGUYBX3)
    public String getZtydi2siginyuintkykkguybx3() {
        return ztydi2siginyuintkykkguybx3;
    }

    public void setZtydi2siginyuintkykkguybx3(String pZtydi2siginyuintkykkguybx3) {
        ztydi2siginyuintkykkguybx3 = pZtydi2siginyuintkykkguybx3;
    }

    private String ztydi2siginyuintkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGINYUINTKYKKGUYBX4)
    public String getZtydi2siginyuintkykkguybx4() {
        return ztydi2siginyuintkykkguybx4;
    }

    public void setZtydi2siginyuintkykkguybx4(String pZtydi2siginyuintkykkguybx4) {
        ztydi2siginyuintkykkguybx4 = pZtydi2siginyuintkykkguybx4;
    }

    private String ztydi2siginyuintkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIGINYUINTKYKKGUYBX5)
    public String getZtydi2siginyuintkykkguybx5() {
        return ztydi2siginyuintkykkguybx5;
    }

    public void setZtydi2siginyuintkykkguybx5(String pZtydi2siginyuintkykkguybx5) {
        ztydi2siginyuintkykkguybx5 = pZtydi2siginyuintkykkguybx5;
    }

    private String ztydi2sppinyuintkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SPPINYUINTKYKKGUYBX1)
    public String getZtydi2sppinyuintkykkguybx1() {
        return ztydi2sppinyuintkykkguybx1;
    }

    public void setZtydi2sppinyuintkykkguybx1(String pZtydi2sppinyuintkykkguybx1) {
        ztydi2sppinyuintkykkguybx1 = pZtydi2sppinyuintkykkguybx1;
    }

    private String ztydi2sppinyuintkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SPPINYUINTKYKKGUYBX2)
    public String getZtydi2sppinyuintkykkguybx2() {
        return ztydi2sppinyuintkykkguybx2;
    }

    public void setZtydi2sppinyuintkykkguybx2(String pZtydi2sppinyuintkykkguybx2) {
        ztydi2sppinyuintkykkguybx2 = pZtydi2sppinyuintkykkguybx2;
    }

    private String ztydi2sppinyuintkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SPPINYUINTKYKKGUYBX3)
    public String getZtydi2sppinyuintkykkguybx3() {
        return ztydi2sppinyuintkykkguybx3;
    }

    public void setZtydi2sppinyuintkykkguybx3(String pZtydi2sppinyuintkykkguybx3) {
        ztydi2sppinyuintkykkguybx3 = pZtydi2sppinyuintkykkguybx3;
    }

    private String ztydi2sppinyuintkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SPPINYUINTKYKKGUYBX4)
    public String getZtydi2sppinyuintkykkguybx4() {
        return ztydi2sppinyuintkykkguybx4;
    }

    public void setZtydi2sppinyuintkykkguybx4(String pZtydi2sppinyuintkykkguybx4) {
        ztydi2sppinyuintkykkguybx4 = pZtydi2sppinyuintkykkguybx4;
    }

    private String ztydi2sppinyuintkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SPPINYUINTKYKKGUYBX5)
    public String getZtydi2sppinyuintkykkguybx5() {
        return ztydi2sppinyuintkykkguybx5;
    }

    public void setZtydi2sppinyuintkykkguybx5(String pZtydi2sppinyuintkykkguybx5) {
        ztydi2sppinyuintkykkguybx5 = pZtydi2sppinyuintkykkguybx5;
    }

    private String ztydi2sijnbyutkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIJNBYUTKYKKGUYBX1)
    public String getZtydi2sijnbyutkykkguybx1() {
        return ztydi2sijnbyutkykkguybx1;
    }

    public void setZtydi2sijnbyutkykkguybx1(String pZtydi2sijnbyutkykkguybx1) {
        ztydi2sijnbyutkykkguybx1 = pZtydi2sijnbyutkykkguybx1;
    }

    private String ztydi2sijnbyutkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIJNBYUTKYKKGUYBX2)
    public String getZtydi2sijnbyutkykkguybx2() {
        return ztydi2sijnbyutkykkguybx2;
    }

    public void setZtydi2sijnbyutkykkguybx2(String pZtydi2sijnbyutkykkguybx2) {
        ztydi2sijnbyutkykkguybx2 = pZtydi2sijnbyutkykkguybx2;
    }

    private String ztydi2sijnbyutkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIJNBYUTKYKKGUYBX3)
    public String getZtydi2sijnbyutkykkguybx3() {
        return ztydi2sijnbyutkykkguybx3;
    }

    public void setZtydi2sijnbyutkykkguybx3(String pZtydi2sijnbyutkykkguybx3) {
        ztydi2sijnbyutkykkguybx3 = pZtydi2sijnbyutkykkguybx3;
    }

    private String ztydi2sijnbyutkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIJNBYUTKYKKGUYBX4)
    public String getZtydi2sijnbyutkykkguybx4() {
        return ztydi2sijnbyutkykkguybx4;
    }

    public void setZtydi2sijnbyutkykkguybx4(String pZtydi2sijnbyutkykkguybx4) {
        ztydi2sijnbyutkykkguybx4 = pZtydi2sijnbyutkykkguybx4;
    }

    private String ztydi2sijnbyutkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SIJNBYUTKYKKGUYBX5)
    public String getZtydi2sijnbyutkykkguybx5() {
        return ztydi2sijnbyutkykkguybx5;
    }

    public void setZtydi2sijnbyutkykkguybx5(String pZtydi2sijnbyutkykkguybx5) {
        ztydi2sijnbyutkykkguybx5 = pZtydi2sijnbyutkykkguybx5;
    }

    private String ztydai2tuintkykkguyobix1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDAI2TUINTKYKKGUYOBIX1)
    public String getZtydai2tuintkykkguyobix1() {
        return ztydai2tuintkykkguyobix1;
    }

    public void setZtydai2tuintkykkguyobix1(String pZtydai2tuintkykkguyobix1) {
        ztydai2tuintkykkguyobix1 = pZtydai2tuintkykkguyobix1;
    }

    private String ztydai2tuintkykkguyobix2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDAI2TUINTKYKKGUYOBIX2)
    public String getZtydai2tuintkykkguyobix2() {
        return ztydai2tuintkykkguyobix2;
    }

    public void setZtydai2tuintkykkguyobix2(String pZtydai2tuintkykkguyobix2) {
        ztydai2tuintkykkguyobix2 = pZtydai2tuintkykkguyobix2;
    }

    private String ztydai2tuintkykkguyobix3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDAI2TUINTKYKKGUYOBIX3)
    public String getZtydai2tuintkykkguyobix3() {
        return ztydai2tuintkykkguyobix3;
    }

    public void setZtydai2tuintkykkguyobix3(String pZtydai2tuintkykkguyobix3) {
        ztydai2tuintkykkguyobix3 = pZtydai2tuintkykkguyobix3;
    }

    private String ztydai2tuintkykkguyobix4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDAI2TUINTKYKKGUYOBIX4)
    public String getZtydai2tuintkykkguyobix4() {
        return ztydai2tuintkykkguyobix4;
    }

    public void setZtydai2tuintkykkguyobix4(String pZtydai2tuintkykkguyobix4) {
        ztydai2tuintkykkguyobix4 = pZtydai2tuintkykkguyobix4;
    }

    private String ztydai2tuintkykkguyobix5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDAI2TUINTKYKKGUYOBIX5)
    public String getZtydai2tuintkykkguyobix5() {
        return ztydai2tuintkykkguyobix5;
    }

    public void setZtydai2tuintkykkguyobix5(String pZtydai2tuintkykkguyobix5) {
        ztydai2tuintkykkguyobix5 = pZtydai2tuintkykkguyobix5;
    }

    private String ztydi2jysisppitkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2JYSISPPITKYKKGUYBX1)
    public String getZtydi2jysisppitkykkguybx1() {
        return ztydi2jysisppitkykkguybx1;
    }

    public void setZtydi2jysisppitkykkguybx1(String pZtydi2jysisppitkykkguybx1) {
        ztydi2jysisppitkykkguybx1 = pZtydi2jysisppitkykkguybx1;
    }

    private String ztydi2jysisppitkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2JYSISPPITKYKKGUYBX2)
    public String getZtydi2jysisppitkykkguybx2() {
        return ztydi2jysisppitkykkguybx2;
    }

    public void setZtydi2jysisppitkykkguybx2(String pZtydi2jysisppitkykkguybx2) {
        ztydi2jysisppitkykkguybx2 = pZtydi2jysisppitkykkguybx2;
    }

    private String ztydi2jysisppitkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2JYSISPPITKYKKGUYBX3)
    public String getZtydi2jysisppitkykkguybx3() {
        return ztydi2jysisppitkykkguybx3;
    }

    public void setZtydi2jysisppitkykkguybx3(String pZtydi2jysisppitkykkguybx3) {
        ztydi2jysisppitkykkguybx3 = pZtydi2jysisppitkykkguybx3;
    }

    private String ztydi2jysisppitkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2JYSISPPITKYKKGUYBX4)
    public String getZtydi2jysisppitkykkguybx4() {
        return ztydi2jysisppitkykkguybx4;
    }

    public void setZtydi2jysisppitkykkguybx4(String pZtydi2jysisppitkykkguybx4) {
        ztydi2jysisppitkykkguybx4 = pZtydi2jysisppitkykkguybx4;
    }

    private String ztydi2jysisppitkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2JYSISPPITKYKKGUYBX5)
    public String getZtydi2jysisppitkykkguybx5() {
        return ztydi2jysisppitkykkguybx5;
    }

    public void setZtydi2jysisppitkykkguybx5(String pZtydi2jysisppitkykkguybx5) {
        ztydi2jysisppitkykkguybx5 = pZtydi2jysisppitkykkguybx5;
    }

    private String ztydi2sugusnsyutkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SUGUSNSYUTKYKKGUYBX1)
    public String getZtydi2sugusnsyutkykkguybx1() {
        return ztydi2sugusnsyutkykkguybx1;
    }

    public void setZtydi2sugusnsyutkykkguybx1(String pZtydi2sugusnsyutkykkguybx1) {
        ztydi2sugusnsyutkykkguybx1 = pZtydi2sugusnsyutkykkguybx1;
    }

    private String ztydi2sugusnsyutkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SUGUSNSYUTKYKKGUYBX2)
    public String getZtydi2sugusnsyutkykkguybx2() {
        return ztydi2sugusnsyutkykkguybx2;
    }

    public void setZtydi2sugusnsyutkykkguybx2(String pZtydi2sugusnsyutkykkguybx2) {
        ztydi2sugusnsyutkykkguybx2 = pZtydi2sugusnsyutkykkguybx2;
    }

    private String ztydi2sugusnsyutkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SUGUSNSYUTKYKKGUYBX3)
    public String getZtydi2sugusnsyutkykkguybx3() {
        return ztydi2sugusnsyutkykkguybx3;
    }

    public void setZtydi2sugusnsyutkykkguybx3(String pZtydi2sugusnsyutkykkguybx3) {
        ztydi2sugusnsyutkykkguybx3 = pZtydi2sugusnsyutkykkguybx3;
    }

    private String ztydi2sugusnsyutkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SUGUSNSYUTKYKKGUYBX4)
    public String getZtydi2sugusnsyutkykkguybx4() {
        return ztydi2sugusnsyutkykkguybx4;
    }

    public void setZtydi2sugusnsyutkykkguybx4(String pZtydi2sugusnsyutkykkguybx4) {
        ztydi2sugusnsyutkykkguybx4 = pZtydi2sugusnsyutkykkguybx4;
    }

    private String ztydi2sugusnsyutkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SUGUSNSYUTKYKKGUYBX5)
    public String getZtydi2sugusnsyutkykkguybx5() {
        return ztydi2sugusnsyutkykkguybx5;
    }

    public void setZtydi2sugusnsyutkykkguybx5(String pZtydi2sugusnsyutkykkguybx5) {
        ztydi2sugusnsyutkykkguybx5 = pZtydi2sugusnsyutkykkguybx5;
    }

    private String ztydi2sykkyuhtkykkguybx1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYKKYUHTKYKKGUYBX1)
    public String getZtydi2sykkyuhtkykkguybx1() {
        return ztydi2sykkyuhtkykkguybx1;
    }

    public void setZtydi2sykkyuhtkykkguybx1(String pZtydi2sykkyuhtkykkguybx1) {
        ztydi2sykkyuhtkykkguybx1 = pZtydi2sykkyuhtkykkguybx1;
    }

    private String ztydi2sykkyuhtkykkguybx2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYKKYUHTKYKKGUYBX2)
    public String getZtydi2sykkyuhtkykkguybx2() {
        return ztydi2sykkyuhtkykkguybx2;
    }

    public void setZtydi2sykkyuhtkykkguybx2(String pZtydi2sykkyuhtkykkguybx2) {
        ztydi2sykkyuhtkykkguybx2 = pZtydi2sykkyuhtkykkguybx2;
    }

    private String ztydi2sykkyuhtkykkguybx3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYKKYUHTKYKKGUYBX3)
    public String getZtydi2sykkyuhtkykkguybx3() {
        return ztydi2sykkyuhtkykkguybx3;
    }

    public void setZtydi2sykkyuhtkykkguybx3(String pZtydi2sykkyuhtkykkguybx3) {
        ztydi2sykkyuhtkykkguybx3 = pZtydi2sykkyuhtkykkguybx3;
    }

    private String ztydi2sykkyuhtkykkguybx4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYKKYUHTKYKKGUYBX4)
    public String getZtydi2sykkyuhtkykkguybx4() {
        return ztydi2sykkyuhtkykkguybx4;
    }

    public void setZtydi2sykkyuhtkykkguybx4(String pZtydi2sykkyuhtkykkguybx4) {
        ztydi2sykkyuhtkykkguybx4 = pZtydi2sykkyuhtkykkguybx4;
    }

    private String ztydi2sykkyuhtkykkguybx5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYDI2SYKKYUHTKYKKGUYBX5)
    public String getZtydi2sykkyuhtkykkguybx5() {
        return ztydi2sykkyuhtkykkguybx5;
    }

    public void setZtydi2sykkyuhtkykkguybx5(String pZtydi2sykkyuhtkykkguybx5) {
        ztydi2sykkyuhtkykkguybx5 = pZtydi2sykkyuhtkykkguybx5;
    }

    private String ztysetaitehknsyuruiyobi1x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X1)
    public String getZtysetaitehknsyuruiyobi1x1() {
        return ztysetaitehknsyuruiyobi1x1;
    }

    public void setZtysetaitehknsyuruiyobi1x1(String pZtysetaitehknsyuruiyobi1x1) {
        ztysetaitehknsyuruiyobi1x1 = pZtysetaitehknsyuruiyobi1x1;
    }

    private String ztysetaitehknsyuruiyobi1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X2)
    public String getZtysetaitehknsyuruiyobi1x2() {
        return ztysetaitehknsyuruiyobi1x2;
    }

    public void setZtysetaitehknsyuruiyobi1x2(String pZtysetaitehknsyuruiyobi1x2) {
        ztysetaitehknsyuruiyobi1x2 = pZtysetaitehknsyuruiyobi1x2;
    }

    private String ztysetaitehknsyuruiyobi1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X3)
    public String getZtysetaitehknsyuruiyobi1x3() {
        return ztysetaitehknsyuruiyobi1x3;
    }

    public void setZtysetaitehknsyuruiyobi1x3(String pZtysetaitehknsyuruiyobi1x3) {
        ztysetaitehknsyuruiyobi1x3 = pZtysetaitehknsyuruiyobi1x3;
    }

    private String ztysetaitehknsyuruiyobi1x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X4)
    public String getZtysetaitehknsyuruiyobi1x4() {
        return ztysetaitehknsyuruiyobi1x4;
    }

    public void setZtysetaitehknsyuruiyobi1x4(String pZtysetaitehknsyuruiyobi1x4) {
        ztysetaitehknsyuruiyobi1x4 = pZtysetaitehknsyuruiyobi1x4;
    }

    private String ztysetaitehknsyuruiyobi1x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X5)
    public String getZtysetaitehknsyuruiyobi1x5() {
        return ztysetaitehknsyuruiyobi1x5;
    }

    public void setZtysetaitehknsyuruiyobi1x5(String pZtysetaitehknsyuruiyobi1x5) {
        ztysetaitehknsyuruiyobi1x5 = pZtysetaitehknsyuruiyobi1x5;
    }

    private String ztysetaitehknsyuruiyobi1x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X6)
    public String getZtysetaitehknsyuruiyobi1x6() {
        return ztysetaitehknsyuruiyobi1x6;
    }

    public void setZtysetaitehknsyuruiyobi1x6(String pZtysetaitehknsyuruiyobi1x6) {
        ztysetaitehknsyuruiyobi1x6 = pZtysetaitehknsyuruiyobi1x6;
    }

    private String ztysetaitehknsyuruiyobi1x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X7)
    public String getZtysetaitehknsyuruiyobi1x7() {
        return ztysetaitehknsyuruiyobi1x7;
    }

    public void setZtysetaitehknsyuruiyobi1x7(String pZtysetaitehknsyuruiyobi1x7) {
        ztysetaitehknsyuruiyobi1x7 = pZtysetaitehknsyuruiyobi1x7;
    }

    private String ztysetaitehknsyuruiyobi1x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X8)
    public String getZtysetaitehknsyuruiyobi1x8() {
        return ztysetaitehknsyuruiyobi1x8;
    }

    public void setZtysetaitehknsyuruiyobi1x8(String pZtysetaitehknsyuruiyobi1x8) {
        ztysetaitehknsyuruiyobi1x8 = pZtysetaitehknsyuruiyobi1x8;
    }

    private String ztysetaitehknsyuruiyobi1x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X9)
    public String getZtysetaitehknsyuruiyobi1x9() {
        return ztysetaitehknsyuruiyobi1x9;
    }

    public void setZtysetaitehknsyuruiyobi1x9(String pZtysetaitehknsyuruiyobi1x9) {
        ztysetaitehknsyuruiyobi1x9 = pZtysetaitehknsyuruiyobi1x9;
    }

    private String ztysetaitehknsyuruiyobi1x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X10)
    public String getZtysetaitehknsyuruiyobi1x10() {
        return ztysetaitehknsyuruiyobi1x10;
    }

    public void setZtysetaitehknsyuruiyobi1x10(String pZtysetaitehknsyuruiyobi1x10) {
        ztysetaitehknsyuruiyobi1x10 = pZtysetaitehknsyuruiyobi1x10;
    }

    private String ztysetaitehknsyuruiyobi1x11;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X11)
    public String getZtysetaitehknsyuruiyobi1x11() {
        return ztysetaitehknsyuruiyobi1x11;
    }

    public void setZtysetaitehknsyuruiyobi1x11(String pZtysetaitehknsyuruiyobi1x11) {
        ztysetaitehknsyuruiyobi1x11 = pZtysetaitehknsyuruiyobi1x11;
    }

    private String ztysetaitehknsyuruiyobi1x12;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X12)
    public String getZtysetaitehknsyuruiyobi1x12() {
        return ztysetaitehknsyuruiyobi1x12;
    }

    public void setZtysetaitehknsyuruiyobi1x12(String pZtysetaitehknsyuruiyobi1x12) {
        ztysetaitehknsyuruiyobi1x12 = pZtysetaitehknsyuruiyobi1x12;
    }

    private String ztysetaitehknsyuruiyobi1x13;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X13)
    public String getZtysetaitehknsyuruiyobi1x13() {
        return ztysetaitehknsyuruiyobi1x13;
    }

    public void setZtysetaitehknsyuruiyobi1x13(String pZtysetaitehknsyuruiyobi1x13) {
        ztysetaitehknsyuruiyobi1x13 = pZtysetaitehknsyuruiyobi1x13;
    }

    private String ztysetaitehknsyuruiyobi1x14;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X14)
    public String getZtysetaitehknsyuruiyobi1x14() {
        return ztysetaitehknsyuruiyobi1x14;
    }

    public void setZtysetaitehknsyuruiyobi1x14(String pZtysetaitehknsyuruiyobi1x14) {
        ztysetaitehknsyuruiyobi1x14 = pZtysetaitehknsyuruiyobi1x14;
    }

    private String ztysetaitehknsyuruiyobi1x15;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI1X15)
    public String getZtysetaitehknsyuruiyobi1x15() {
        return ztysetaitehknsyuruiyobi1x15;
    }

    public void setZtysetaitehknsyuruiyobi1x15(String pZtysetaitehknsyuruiyobi1x15) {
        ztysetaitehknsyuruiyobi1x15 = pZtysetaitehknsyuruiyobi1x15;
    }

    private String ztysetaitehknsyuruiyobi2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X1)
    public String getZtysetaitehknsyuruiyobi2x1() {
        return ztysetaitehknsyuruiyobi2x1;
    }

    public void setZtysetaitehknsyuruiyobi2x1(String pZtysetaitehknsyuruiyobi2x1) {
        ztysetaitehknsyuruiyobi2x1 = pZtysetaitehknsyuruiyobi2x1;
    }

    private String ztysetaitehknsyuruiyobi2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X2)
    public String getZtysetaitehknsyuruiyobi2x2() {
        return ztysetaitehknsyuruiyobi2x2;
    }

    public void setZtysetaitehknsyuruiyobi2x2(String pZtysetaitehknsyuruiyobi2x2) {
        ztysetaitehknsyuruiyobi2x2 = pZtysetaitehknsyuruiyobi2x2;
    }

    private String ztysetaitehknsyuruiyobi2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X3)
    public String getZtysetaitehknsyuruiyobi2x3() {
        return ztysetaitehknsyuruiyobi2x3;
    }

    public void setZtysetaitehknsyuruiyobi2x3(String pZtysetaitehknsyuruiyobi2x3) {
        ztysetaitehknsyuruiyobi2x3 = pZtysetaitehknsyuruiyobi2x3;
    }

    private String ztysetaitehknsyuruiyobi2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X4)
    public String getZtysetaitehknsyuruiyobi2x4() {
        return ztysetaitehknsyuruiyobi2x4;
    }

    public void setZtysetaitehknsyuruiyobi2x4(String pZtysetaitehknsyuruiyobi2x4) {
        ztysetaitehknsyuruiyobi2x4 = pZtysetaitehknsyuruiyobi2x4;
    }

    private String ztysetaitehknsyuruiyobi2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X5)
    public String getZtysetaitehknsyuruiyobi2x5() {
        return ztysetaitehknsyuruiyobi2x5;
    }

    public void setZtysetaitehknsyuruiyobi2x5(String pZtysetaitehknsyuruiyobi2x5) {
        ztysetaitehknsyuruiyobi2x5 = pZtysetaitehknsyuruiyobi2x5;
    }

    private String ztysetaitehknsyuruiyobi2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X6)
    public String getZtysetaitehknsyuruiyobi2x6() {
        return ztysetaitehknsyuruiyobi2x6;
    }

    public void setZtysetaitehknsyuruiyobi2x6(String pZtysetaitehknsyuruiyobi2x6) {
        ztysetaitehknsyuruiyobi2x6 = pZtysetaitehknsyuruiyobi2x6;
    }

    private String ztysetaitehknsyuruiyobi2x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X7)
    public String getZtysetaitehknsyuruiyobi2x7() {
        return ztysetaitehknsyuruiyobi2x7;
    }

    public void setZtysetaitehknsyuruiyobi2x7(String pZtysetaitehknsyuruiyobi2x7) {
        ztysetaitehknsyuruiyobi2x7 = pZtysetaitehknsyuruiyobi2x7;
    }

    private String ztysetaitehknsyuruiyobi2x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X8)
    public String getZtysetaitehknsyuruiyobi2x8() {
        return ztysetaitehknsyuruiyobi2x8;
    }

    public void setZtysetaitehknsyuruiyobi2x8(String pZtysetaitehknsyuruiyobi2x8) {
        ztysetaitehknsyuruiyobi2x8 = pZtysetaitehknsyuruiyobi2x8;
    }

    private String ztysetaitehknsyuruiyobi2x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X9)
    public String getZtysetaitehknsyuruiyobi2x9() {
        return ztysetaitehknsyuruiyobi2x9;
    }

    public void setZtysetaitehknsyuruiyobi2x9(String pZtysetaitehknsyuruiyobi2x9) {
        ztysetaitehknsyuruiyobi2x9 = pZtysetaitehknsyuruiyobi2x9;
    }

    private String ztysetaitehknsyuruiyobi2x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI2X10)
    public String getZtysetaitehknsyuruiyobi2x10() {
        return ztysetaitehknsyuruiyobi2x10;
    }

    public void setZtysetaitehknsyuruiyobi2x10(String pZtysetaitehknsyuruiyobi2x10) {
        ztysetaitehknsyuruiyobi2x10 = pZtysetaitehknsyuruiyobi2x10;
    }

    private String ztysetaitehknsyuruiyobi3x1;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X1)
    public String getZtysetaitehknsyuruiyobi3x1() {
        return ztysetaitehknsyuruiyobi3x1;
    }

    public void setZtysetaitehknsyuruiyobi3x1(String pZtysetaitehknsyuruiyobi3x1) {
        ztysetaitehknsyuruiyobi3x1 = pZtysetaitehknsyuruiyobi3x1;
    }

    private String ztysetaitehknsyuruiyobi3x2;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X2)
    public String getZtysetaitehknsyuruiyobi3x2() {
        return ztysetaitehknsyuruiyobi3x2;
    }

    public void setZtysetaitehknsyuruiyobi3x2(String pZtysetaitehknsyuruiyobi3x2) {
        ztysetaitehknsyuruiyobi3x2 = pZtysetaitehknsyuruiyobi3x2;
    }

    private String ztysetaitehknsyuruiyobi3x3;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X3)
    public String getZtysetaitehknsyuruiyobi3x3() {
        return ztysetaitehknsyuruiyobi3x3;
    }

    public void setZtysetaitehknsyuruiyobi3x3(String pZtysetaitehknsyuruiyobi3x3) {
        ztysetaitehknsyuruiyobi3x3 = pZtysetaitehknsyuruiyobi3x3;
    }

    private String ztysetaitehknsyuruiyobi3x4;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X4)
    public String getZtysetaitehknsyuruiyobi3x4() {
        return ztysetaitehknsyuruiyobi3x4;
    }

    public void setZtysetaitehknsyuruiyobi3x4(String pZtysetaitehknsyuruiyobi3x4) {
        ztysetaitehknsyuruiyobi3x4 = pZtysetaitehknsyuruiyobi3x4;
    }

    private String ztysetaitehknsyuruiyobi3x5;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X5)
    public String getZtysetaitehknsyuruiyobi3x5() {
        return ztysetaitehknsyuruiyobi3x5;
    }

    public void setZtysetaitehknsyuruiyobi3x5(String pZtysetaitehknsyuruiyobi3x5) {
        ztysetaitehknsyuruiyobi3x5 = pZtysetaitehknsyuruiyobi3x5;
    }

    private String ztysetaitehknsyuruiyobi3x6;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X6)
    public String getZtysetaitehknsyuruiyobi3x6() {
        return ztysetaitehknsyuruiyobi3x6;
    }

    public void setZtysetaitehknsyuruiyobi3x6(String pZtysetaitehknsyuruiyobi3x6) {
        ztysetaitehknsyuruiyobi3x6 = pZtysetaitehknsyuruiyobi3x6;
    }

    private String ztysetaitehknsyuruiyobi3x7;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X7)
    public String getZtysetaitehknsyuruiyobi3x7() {
        return ztysetaitehknsyuruiyobi3x7;
    }

    public void setZtysetaitehknsyuruiyobi3x7(String pZtysetaitehknsyuruiyobi3x7) {
        ztysetaitehknsyuruiyobi3x7 = pZtysetaitehknsyuruiyobi3x7;
    }

    private String ztysetaitehknsyuruiyobi3x8;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X8)
    public String getZtysetaitehknsyuruiyobi3x8() {
        return ztysetaitehknsyuruiyobi3x8;
    }

    public void setZtysetaitehknsyuruiyobi3x8(String pZtysetaitehknsyuruiyobi3x8) {
        ztysetaitehknsyuruiyobi3x8 = pZtysetaitehknsyuruiyobi3x8;
    }

    private String ztysetaitehknsyuruiyobi3x9;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X9)
    public String getZtysetaitehknsyuruiyobi3x9() {
        return ztysetaitehknsyuruiyobi3x9;
    }

    public void setZtysetaitehknsyuruiyobi3x9(String pZtysetaitehknsyuruiyobi3x9) {
        ztysetaitehknsyuruiyobi3x9 = pZtysetaitehknsyuruiyobi3x9;
    }

    private String ztysetaitehknsyuruiyobi3x10;

    @Column(name=GenZT_Skeiksnbsgetujisr3Ty.ZTYSETAITEHKNSYURUIYOBI3X10)
    public String getZtysetaitehknsyuruiyobi3x10() {
        return ztysetaitehknsyuruiyobi3x10;
    }

    public void setZtysetaitehknsyuruiyobi3x10(String pZtysetaitehknsyuruiyobi3x10) {
        ztysetaitehknsyuruiyobi3x10 = pZtysetaitehknsyuruiyobi3x10;
    }
}