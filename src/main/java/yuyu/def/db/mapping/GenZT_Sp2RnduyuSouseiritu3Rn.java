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
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Rn;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu3Rn;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu3Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu3Rn;

/**
 * ＳＰ２連動用総成立Fテーブル３（連） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu3Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu3Rn}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル３（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnktgysyrymd zrnktgysyrymd}</td><td>（連携用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu3Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgyfilerenno zrnktgyfilerenno}</td><td>（連携用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeirokbn zrnbosyuukeirokbn}</td><td>（連携用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipcashlessnyukinhyj zrnsyokaipcashlessnyukinhyj}</td><td>（連携用）初回Ｐキャッシュレス入金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigkyhsitihsyutkykarihyj zrnkigkyhsitihsyutkykarihyj}</td><td>（連携用）介護給付最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipswingriyoukbn zrnsyokaipswingriyoukbn}</td><td>（連携用）初回Ｐスイング利用区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsknjyututkykkykkbn zrnsknjyututkykkykkbn}</td><td>（連携用）資金充当特約契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuudairitengyousyukbn zrnbosyuudairitengyousyukbn}</td><td>（連携用）募集代理店業種区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusyujimutoriatukaikbn zrntokusyujimutoriatukaikbn}</td><td>（連携用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentkykyutktbicdx1 zrnpmentkykyutktbicdx1}</td><td>（連携用）Ｐ免特約用特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentkykyuhtnpkknx1 zrnpmentkykyuhtnpkknx1}</td><td>（連携用）Ｐ免特約用不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentkykyutktbicdx2 zrnpmentkykyutktbicdx2}</td><td>（連携用）Ｐ免特約用特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentkykyuhtnpkknx2 zrnpmentkykyuhtnpkknx2}</td><td>（連携用）Ｐ免特約用不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouikkatumnoshyouji zrnhosyouikkatumnoshyouji}</td><td>（連携用）保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhsyuikktminaosikaisu zrnhsyuikktminaosikaisu}</td><td>（連携用）保障一括見直回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhsyuikktmnosdfnyuknhyj zrnhsyuikktmnosdfnyuknhyj}</td><td>（連携用）保障一括見直ＤＦ入金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikktmnoskikiyutkykp zrnikktmnoskikiyutkykp}</td><td>（連携用）一括見直会計用特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnikktmnoskikiyufndsistp zrnikktmnoskikiyufndsistp}</td><td>（連携用）一括見直会計用ファンド災疾Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsknnjynbknsisnrt zrnsknnjynbknsisnrt}</td><td>（連携用）責任準備金精算率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkanyujisyono zrnkanyujisyono}</td><td>（連携用）加入時証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyujikykymd zrnkanyujikykymd}</td><td>（連携用）加入時契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyuujihihokensyaage zrnkanyuujihihokensyaage}</td><td>（連携用）加入時被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyuujitenkanhyouji zrnkanyuujitenkanhyouji}</td><td>（連携用）加入時転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnyuhsyuikktminosnnskbn zrnksnyuhsyuikktminosnnskbn}</td><td>（連携用）加算用保障一括見直年数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyadirtnbsynnhyj zrnaatukaisyadirtnbsynnhyj}</td><td>（連携用）Ａ扱者代理店募集人表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkisyadirtnbosyuninhyj zrnbatkisyadirtnbosyuninhyj}</td><td>（連携用）Ｂ扱者代理店募集人表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndirtnaatukaisyakojincd zrndirtnaatukaisyakojincd}</td><td>（連携用）代理店Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndirtnbatukaisyakojincd zrndirtnbatukaisyakojincd}</td><td>（連携用）代理店Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuuseisyoukeikanensuu zrnsyuuseisyoukeikanensuu}</td><td>（連携用）修正Ｓ用経過年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuruihnkutkbttrtkhyj zrnsyuruihnkutkbttrtkhyj}</td><td>（連携用）種類変更特別取扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyktkykhkjyutikbn zrnbnktmekyktkykhkjyutikbn}</td><td>（連携用）分割前契約特約付加状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknsyokaipclessriyouhyj zrntnknsyokaipclessriyouhyj}</td><td>（連携用）転換初回ＰＣレス利用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkteisikibouhyouji zrnhrkteisikibouhyouji}</td><td>（連携用）払込停止希望表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbunkatugosonzokukeiyakus zrnbunkatugosonzokukeiyakus}</td><td>（連携用）分割後存続契約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmoskizkphrkekngk zrnmoskizkphrkekngk}</td><td>（連携用）申込継続Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeizokuphurikaejijikaip zrnkeizokuphurikaejijikaip}</td><td>（連携用）継続Ｐ振替時次回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyksyono zrnbnktmekyksyono}</td><td>（連携用）分割前契約証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbunkatumaekeiyakukihons zrnbunkatumaekeiyakukihons}</td><td>（連携用）分割前契約基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbunkatumaekeiyakusibous zrnbunkatumaekeiyakusibous}</td><td>（連携用）分割前契約死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykmods zrnbnktmekykmods}</td><td>（連携用）分割前契約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyksigiwrmstkyks zrnbnktmekyksigiwrmstkyks}</td><td>（連携用）分割前契約災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnktmekyksyugitkyks zrnbnktmekyksyugitkyks}</td><td>（連携用）分割前契約傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnktmkyksiginyintkykntgk zrnbnktmkyksiginyintkykntgk}</td><td>（連携用）分割前契約災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykknkutkykntgk zrnbnktmekykknkutkykntgk}</td><td>（連携用）分割前契約健康特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykhntiyunbriknsnp zrnbnktmekykhntiyunbriknsnp}</td><td>（連携用）分割前契約判定用年払換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2naibuwarimodosigaku zrndai2naibuwarimodosigaku}</td><td>（連携用）第２内部割戻額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnkngkykkstkgk zrntnkngkykkstkgk}</td><td>（連携用）転換後契約貸付額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbnktmekykkstkgk zrnbnktmekykkstkgk}</td><td>（連携用）分割前契約貸付額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonzokukykkasitukegk zrnsonzokukykkasitukegk}</td><td>（連携用）存続契約貸付額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhngkmnryoujsitihsyukngk zrnhngkmnryoujsitihsyukngk}</td><td>（連携用）変額満了時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhngksitihsyuyusykykp zrnhngksitihsyuyusykykp}</td><td>（連携用）変額最低保証用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx1x1 zrnhtnknkigmrsyukguybx1x1}</td><td>（連携用）被転換介護マル終記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx2x1 zrnhtnknkigmrsyukguybx2x1}</td><td>（連携用）被転換介護マル終記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx3x1 zrnhtnknkigmrsyukguybx3x1}</td><td>（連携用）被転換介護マル終記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx4x1 zrnhtnknkigmrsyukguybx4x1}</td><td>（連携用）被転換介護マル終記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx5x1 zrnhtnknkigmrsyukguybx5x1}</td><td>（連携用）被転換介護マル終記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx1x2 zrnhtnknkigmrsyukguybx1x2}</td><td>（連携用）被転換介護マル終記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx2x2 zrnhtnknkigmrsyukguybx2x2}</td><td>（連携用）被転換介護マル終記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx3x2 zrnhtnknkigmrsyukguybx3x2}</td><td>（連携用）被転換介護マル終記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx4x2 zrnhtnknkigmrsyukguybx4x2}</td><td>（連携用）被転換介護マル終記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx5x2 zrnhtnknkigmrsyukguybx5x2}</td><td>（連携用）被転換介護マル終記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx1x3 zrnhtnknkigmrsyukguybx1x3}</td><td>（連携用）被転換介護マル終記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx2x3 zrnhtnknkigmrsyukguybx2x3}</td><td>（連携用）被転換介護マル終記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx3x3 zrnhtnknkigmrsyukguybx3x3}</td><td>（連携用）被転換介護マル終記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx4x3 zrnhtnknkigmrsyukguybx4x3}</td><td>（連携用）被転換介護マル終記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx5x3 zrnhtnknkigmrsyukguybx5x3}</td><td>（連携用）被転換介護マル終記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx1x4 zrnhtnknkigmrsyukguybx1x4}</td><td>（連携用）被転換介護マル終記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx2x4 zrnhtnknkigmrsyukguybx2x4}</td><td>（連携用）被転換介護マル終記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx3x4 zrnhtnknkigmrsyukguybx3x4}</td><td>（連携用）被転換介護マル終記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx4x4 zrnhtnknkigmrsyukguybx4x4}</td><td>（連携用）被転換介護マル終記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx5x4 zrnhtnknkigmrsyukguybx5x4}</td><td>（連携用）被転換介護マル終記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx1x5 zrnhtnknkigmrsyukguybx1x5}</td><td>（連携用）被転換介護マル終記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx2x5 zrnhtnknkigmrsyukguybx2x5}</td><td>（連携用）被転換介護マル終記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx3x5 zrnhtnknkigmrsyukguybx3x5}</td><td>（連携用）被転換介護マル終記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx4x5 zrnhtnknkigmrsyukguybx4x5}</td><td>（連携用）被転換介護マル終記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx5x5 zrnhtnknkigmrsyukguybx5x5}</td><td>（連携用）被転換介護マル終記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx1x6 zrnhtnknkigmrsyukguybx1x6}</td><td>（連携用）被転換介護マル終記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx2x6 zrnhtnknkigmrsyukguybx2x6}</td><td>（連携用）被転換介護マル終記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx3x6 zrnhtnknkigmrsyukguybx3x6}</td><td>（連携用）被転換介護マル終記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx4x6 zrnhtnknkigmrsyukguybx4x6}</td><td>（連携用）被転換介護マル終記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrsyukguybx5x6 zrnhtnknkigmrsyukguybx5x6}</td><td>（連携用）被転換介護マル終記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x3 zrnyobiv1x3}</td><td>（連携用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix1 zrnmaruteikigouyobix1}</td><td>（連携用）マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix2 zrnmaruteikigouyobix2}</td><td>（連携用）マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix3 zrnmaruteikigouyobix3}</td><td>（連携用）マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix4 zrnmaruteikigouyobix4}</td><td>（連携用）マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix5 zrnmaruteikigouyobix5}</td><td>（連携用）マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukigouyobix1 zrnmaruyoukigouyobix1}</td><td>（連携用）マル養記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukigouyobix2 zrnmaruyoukigouyobix2}</td><td>（連携用）マル養記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukigouyobix3 zrnmaruyoukigouyobix3}</td><td>（連携用）マル養記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukigouyobix4 zrnmaruyoukigouyobix4}</td><td>（連携用）マル養記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukigouyobix5 zrnmaruyoukigouyobix5}</td><td>（連携用）マル養記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukigouyobix1 zrnmarusyuukigouyobix1}</td><td>（連携用）マル終記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukigouyobix2 zrnmarusyuukigouyobix2}</td><td>（連携用）マル終記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukigouyobix3 zrnmarusyuukigouyobix3}</td><td>（連携用）マル終記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukigouyobix4 zrnmarusyuukigouyobix4}</td><td>（連携用）マル終記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukigouyobix5 zrnmarusyuukigouyobix5}</td><td>（連携用）マル終記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikigouyobix1 zrntokuteikigouyobix1}</td><td>（連携用）トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikigouyobix2 zrntokuteikigouyobix2}</td><td>（連携用）トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikigouyobix3 zrntokuteikigouyobix3}</td><td>（連携用）トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikigouyobix4 zrntokuteikigouyobix4}</td><td>（連携用）トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikigouyobix5 zrntokuteikigouyobix5}</td><td>（連携用）トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x1 zrnkzkmrtikguybx1x1}</td><td>（連携用）家族マル定記号予備＿１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x1 zrnkzkmrtikguybx2x1}</td><td>（連携用）家族マル定記号予備＿２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x1 zrnkzkmrtikguybx3x1}</td><td>（連携用）家族マル定記号予備＿３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x1 zrnkzkmrtikguybx4x1}</td><td>（連携用）家族マル定記号予備＿４＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x1 zrnkzkmrtikguybx5x1}</td><td>（連携用）家族マル定記号予備＿５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x2 zrnkzkmrtikguybx1x2}</td><td>（連携用）家族マル定記号予備＿１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x2 zrnkzkmrtikguybx2x2}</td><td>（連携用）家族マル定記号予備＿２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x2 zrnkzkmrtikguybx3x2}</td><td>（連携用）家族マル定記号予備＿３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x2 zrnkzkmrtikguybx4x2}</td><td>（連携用）家族マル定記号予備＿４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x2 zrnkzkmrtikguybx5x2}</td><td>（連携用）家族マル定記号予備＿５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x3 zrnkzkmrtikguybx1x3}</td><td>（連携用）家族マル定記号予備＿１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x3 zrnkzkmrtikguybx2x3}</td><td>（連携用）家族マル定記号予備＿２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x3 zrnkzkmrtikguybx3x3}</td><td>（連携用）家族マル定記号予備＿３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x3 zrnkzkmrtikguybx4x3}</td><td>（連携用）家族マル定記号予備＿４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x3 zrnkzkmrtikguybx5x3}</td><td>（連携用）家族マル定記号予備＿５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x4 zrnkzkmrtikguybx1x4}</td><td>（連携用）家族マル定記号予備＿１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x4 zrnkzkmrtikguybx2x4}</td><td>（連携用）家族マル定記号予備＿２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x4 zrnkzkmrtikguybx3x4}</td><td>（連携用）家族マル定記号予備＿３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x4 zrnkzkmrtikguybx4x4}</td><td>（連携用）家族マル定記号予備＿４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x4 zrnkzkmrtikguybx5x4}</td><td>（連携用）家族マル定記号予備＿５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x5 zrnkzkmrtikguybx1x5}</td><td>（連携用）家族マル定記号予備＿１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x5 zrnkzkmrtikguybx2x5}</td><td>（連携用）家族マル定記号予備＿２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x5 zrnkzkmrtikguybx3x5}</td><td>（連携用）家族マル定記号予備＿３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x5 zrnkzkmrtikguybx4x5}</td><td>（連携用）家族マル定記号予備＿４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x5 zrnkzkmrtikguybx5x5}</td><td>（連携用）家族マル定記号予備＿５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x6 zrnkzkmrtikguybx1x6}</td><td>（連携用）家族マル定記号予備＿１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x6 zrnkzkmrtikguybx2x6}</td><td>（連携用）家族マル定記号予備＿２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x6 zrnkzkmrtikguybx3x6}</td><td>（連携用）家族マル定記号予備＿３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x6 zrnkzkmrtikguybx4x6}</td><td>（連携用）家族マル定記号予備＿４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x6 zrnkzkmrtikguybx5x6}</td><td>（連携用）家族マル定記号予備＿５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x7 zrnkzkmrtikguybx1x7}</td><td>（連携用）家族マル定記号予備＿１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x7 zrnkzkmrtikguybx2x7}</td><td>（連携用）家族マル定記号予備＿２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x7 zrnkzkmrtikguybx3x7}</td><td>（連携用）家族マル定記号予備＿３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x7 zrnkzkmrtikguybx4x7}</td><td>（連携用）家族マル定記号予備＿４＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x7 zrnkzkmrtikguybx5x7}</td><td>（連携用）家族マル定記号予備＿５＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x8 zrnkzkmrtikguybx1x8}</td><td>（連携用）家族マル定記号予備＿１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x8 zrnkzkmrtikguybx2x8}</td><td>（連携用）家族マル定記号予備＿２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x8 zrnkzkmrtikguybx3x8}</td><td>（連携用）家族マル定記号予備＿３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x8 zrnkzkmrtikguybx4x8}</td><td>（連携用）家族マル定記号予備＿４＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x8 zrnkzkmrtikguybx5x8}</td><td>（連携用）家族マル定記号予備＿５＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x9 zrnkzkmrtikguybx1x9}</td><td>（連携用）家族マル定記号予備＿１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x9 zrnkzkmrtikguybx2x9}</td><td>（連携用）家族マル定記号予備＿２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x9 zrnkzkmrtikguybx3x9}</td><td>（連携用）家族マル定記号予備＿３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x9 zrnkzkmrtikguybx4x9}</td><td>（連携用）家族マル定記号予備＿４＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x9 zrnkzkmrtikguybx5x9}</td><td>（連携用）家族マル定記号予備＿５＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx1x10 zrnkzkmrtikguybx1x10}</td><td>（連携用）家族マル定記号予備＿１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx2x10 zrnkzkmrtikguybx2x10}</td><td>（連携用）家族マル定記号予備＿２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx3x10 zrnkzkmrtikguybx3x10}</td><td>（連携用）家族マル定記号予備＿３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx4x10 zrnkzkmrtikguybx4x10}</td><td>（連携用）家族マル定記号予備＿４＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikguybx5x10 zrnkzkmrtikguybx5x10}</td><td>（連携用）家族マル定記号予備＿５＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyugittkykkguybx1 zrnsyugittkykkguybx1}</td><td>（連携用）傷害特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyugittkykkguybx2 zrnsyugittkykkguybx2}</td><td>（連携用）傷害特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyugittkykkguybx3 zrnsyugittkykkguybx3}</td><td>（連携用）傷害特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyugittkykkguybx4 zrnsyugittkykkguybx4}</td><td>（連携用）傷害特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyugittkykkguybx5 zrnsyugittkykkguybx5}</td><td>（連携用）傷害特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkguybx1 zrnsigiwrmstkykkguybx1}</td><td>（連携用）災害割増特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkguybx2 zrnsigiwrmstkykkguybx2}</td><td>（連携用）災害割増特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkguybx3 zrnsigiwrmstkykkguybx3}</td><td>（連携用）災害割増特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkguybx4 zrnsigiwrmstkykkguybx4}</td><td>（連携用）災害割増特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkguybx5 zrnsigiwrmstkykkguybx5}</td><td>（連携用）災害割増特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykkguybx1 zrnsiginyuintkykkguybx1}</td><td>（連携用）災害入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykkguybx2 zrnsiginyuintkykkguybx2}</td><td>（連携用）災害入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykkguybx3 zrnsiginyuintkykkguybx3}</td><td>（連携用）災害入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykkguybx4 zrnsiginyuintkykkguybx4}</td><td>（連携用）災害入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykkguybx5 zrnsiginyuintkykkguybx5}</td><td>（連携用）災害入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykkguybx1 zrnsppinyuintkykkguybx1}</td><td>（連携用）疾病入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykkguybx2 zrnsppinyuintkykkguybx2}</td><td>（連携用）疾病入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykkguybx3 zrnsppinyuintkykkguybx3}</td><td>（連携用）疾病入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykkguybx4 zrnsppinyuintkykkguybx4}</td><td>（連携用）疾病入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykkguybx5 zrnsppinyuintkykkguybx5}</td><td>（連携用）疾病入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykkguybx1 zrnsijnbyutkykkguybx1}</td><td>（連携用）成人病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykkguybx2 zrnsijnbyutkykkguybx2}</td><td>（連携用）成人病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykkguybx3 zrnsijnbyutkykkguybx3}</td><td>（連携用）成人病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykkguybx4 zrnsijnbyutkykkguybx4}</td><td>（連携用）成人病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykkguybx5 zrnsijnbyutkykkguybx5}</td><td>（連携用）成人病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykkguybx1 zrnkzkiryoutkykkguybx1}</td><td>（連携用）家族医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykkguybx2 zrnkzkiryoutkykkguybx2}</td><td>（連携用）家族医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykkguybx3 zrnkzkiryoutkykkguybx3}</td><td>（連携用）家族医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykkguybx4 zrnkzkiryoutkykkguybx4}</td><td>（連携用）家族医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykkguybx5 zrnkzkiryoutkykkguybx5}</td><td>（連携用）家族医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykkguybx1 zrnsykkyuhtkykkguybx1}</td><td>（連携用）初期給付特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykkguybx2 zrnsykkyuhtkykkguybx2}</td><td>（連携用）初期給付特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykkguybx3 zrnsykkyuhtkykkguybx3}</td><td>（連携用）初期給付特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykkguybx4 zrnsykkyuhtkykkguybx4}</td><td>（連携用）初期給付特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykkguybx5 zrnsykkyuhtkykkguybx5}</td><td>（連携用）初期給付特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikguyobix1 zrnnkdtmrtikguyobix1}</td><td>（連携用）年金建マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikguyobix2 zrnnkdtmrtikguyobix2}</td><td>（連携用）年金建マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikguyobix3 zrnnkdtmrtikguyobix3}</td><td>（連携用）年金建マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikguyobix4 zrnnkdtmrtikguyobix4}</td><td>（連携用）年金建マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikguyobix5 zrnnkdtmrtikguyobix5}</td><td>（連携用）年金建マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteikguyobix1 zrnnkdatetokuteikguyobix1}</td><td>（連携用）年金建トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteikguyobix2 zrnnkdatetokuteikguyobix2}</td><td>（連携用）年金建トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteikguyobix3 zrnnkdatetokuteikguyobix3}</td><td>（連携用）年金建トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteikguyobix4 zrnnkdatetokuteikguyobix4}</td><td>（連携用）年金建トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteikguyobix5 zrnnkdatetokuteikguyobix5}</td><td>（連携用）年金建トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikguyobix1 zrnkaigonkdtmrtikguyobix1}</td><td>（連携用）介護年金建マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikguyobix2 zrnkaigonkdtmrtikguyobix2}</td><td>（連携用）介護年金建マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikguyobix3 zrnkaigonkdtmrtikguyobix3}</td><td>（連携用）介護年金建マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikguyobix4 zrnkaigonkdtmrtikguyobix4}</td><td>（連携用）介護年金建マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikguyobix5 zrnkaigonkdtmrtikguyobix5}</td><td>（連携用）介護年金建マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikguyobix1 zrnkaigonkdttktikguyobix1}</td><td>（連携用）介護年金建トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikguyobix2 zrnkaigonkdttktikguyobix2}</td><td>（連携用）介護年金建トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikguyobix3 zrnkaigonkdttktikguyobix3}</td><td>（連携用）介護年金建トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikguyobix4 zrnkaigonkdttktikguyobix4}</td><td>（連携用）介護年金建トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikguyobix5 zrnkaigonkdttktikguyobix5}</td><td>（連携用）介護年金建トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikigouyobix1 zrnkaigomaruteikigouyobix1}</td><td>（連携用）介護マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikigouyobix2 zrnkaigomaruteikigouyobix2}</td><td>（連携用）介護マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikigouyobix3 zrnkaigomaruteikigouyobix3}</td><td>（連携用）介護マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikigouyobix4 zrnkaigomaruteikigouyobix4}</td><td>（連携用）介護マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikigouyobix5 zrnkaigomaruteikigouyobix5}</td><td>（連携用）介護マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteikigouyobix1 zrnkaigotokuteikigouyobix1}</td><td>（連携用）介護トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteikigouyobix2 zrnkaigotokuteikigouyobix2}</td><td>（連携用）介護トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteikigouyobix3 zrnkaigotokuteikigouyobix3}</td><td>（連携用）介護トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteikigouyobix4 zrnkaigotokuteikigouyobix4}</td><td>（連携用）介護トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteikigouyobix5 zrnkaigotokuteikigouyobix5}</td><td>（連携用）介護トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx1 zrnsiznmrtikguybx1}</td><td>（連携用）生存マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx2 zrnsiznmrtikguybx2}</td><td>（連携用）生存マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx3 zrnsiznmrtikguybx3}</td><td>（連携用）生存マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx4 zrnsiznmrtikguybx4}</td><td>（連携用）生存マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx5 zrnsiznmrtikguybx5}</td><td>（連携用）生存マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix1 zrnteigenmaruteikigouyobix1}</td><td>（連携用）逓減マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix2 zrnteigenmaruteikigouyobix2}</td><td>（連携用）逓減マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix3 zrnteigenmaruteikigouyobix3}</td><td>（連携用）逓減マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix4 zrnteigenmaruteikigouyobix4}</td><td>（連携用）逓減マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix5 zrnteigenmaruteikigouyobix5}</td><td>（連携用）逓減マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteikigouyobix1 zrnteigentokuteikigouyobix1}</td><td>（連携用）逓減トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteikigouyobix2 zrnteigentokuteikigouyobix2}</td><td>（連携用）逓減トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteikigouyobix3 zrnteigentokuteikigouyobix3}</td><td>（連携用）逓減トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteikigouyobix4 zrnteigentokuteikigouyobix4}</td><td>（連携用）逓減トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteikigouyobix5 zrnteigentokuteikigouyobix5}</td><td>（連携用）逓減トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtikguybx1 zrnkigtignmrtikguybx1}</td><td>（連携用）介護逓減マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtikguybx2 zrnkigtignmrtikguybx2}</td><td>（連携用）介護逓減マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtikguybx3 zrnkigtignmrtikguybx3}</td><td>（連携用）介護逓減マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtikguybx4 zrnkigtignmrtikguybx4}</td><td>（連携用）介護逓減マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtikguybx5 zrnkigtignmrtikguybx5}</td><td>（連携用）介護逓減マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktikguybx1 zrnkigtigntktikguybx1}</td><td>（連携用）介護逓減トク定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktikguybx2 zrnkigtigntktikguybx2}</td><td>（連携用）介護逓減トク定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktikguybx3 zrnkigtigntktikguybx3}</td><td>（連携用）介護逓減トク定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktikguybx4 zrnkigtigntktikguybx4}</td><td>（連携用）介護逓減トク定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktikguybx5 zrnkigtigntktikguybx5}</td><td>（連携用）介護逓減トク定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakukigouyobix1 zrntuuintokuyakukigouyobix1}</td><td>（連携用）通院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakukigouyobix2 zrntuuintokuyakukigouyobix2}</td><td>（連携用）通院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakukigouyobix3 zrntuuintokuyakukigouyobix3}</td><td>（連携用）通院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakukigouyobix4 zrntuuintokuyakukigouyobix4}</td><td>（連携用）通院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakukigouyobix5 zrntuuintokuyakukigouyobix5}</td><td>（連携用）通院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkguyobix1 zrnjysisppitkykkguyobix1}</td><td>（連携用）女性疾病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkguyobix2 zrnjysisppitkykkguyobix2}</td><td>（連携用）女性疾病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkguyobix3 zrnjysisppitkykkguyobix3}</td><td>（連携用）女性疾病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkguyobix4 zrnjysisppitkykkguyobix4}</td><td>（連携用）女性疾病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkguyobix5 zrnjysisppitkykkguyobix5}</td><td>（連携用）女性疾病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykkguybx1 zrntksttkykkguybx1}</td><td>（連携用）特疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykkguybx2 zrntksttkykkguybx2}</td><td>（連携用）特疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykkguybx3 zrntksttkykkguybx3}</td><td>（連携用）特疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykkguybx4 zrntksttkykkguybx4}</td><td>（連携用）特疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykkguybx5 zrntksttkykkguybx5}</td><td>（連携用）特疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykkguybx1 zrndi2tksttkykkguybx1}</td><td>（連携用）第２特疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykkguybx2 zrndi2tksttkykkguybx2}</td><td>（連携用）第２特疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykkguybx3 zrndi2tksttkykkguybx3}</td><td>（連携用）第２特疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykkguybx4 zrndi2tksttkykkguybx4}</td><td>（連携用）第２特疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykkguybx5 zrndi2tksttkykkguybx5}</td><td>（連携用）第２特疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsttkykkguybx1 zrnmnsttkykkguybx1}</td><td>（連携用）慢疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsttkykkguybx2 zrnmnsttkykkguybx2}</td><td>（連携用）慢疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsttkykkguybx3 zrnmnsttkykkguybx3}</td><td>（連携用）慢疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsttkykkguybx4 zrnmnsttkykkguybx4}</td><td>（連携用）慢疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsttkykkguybx5 zrnmnsttkykkguybx5}</td><td>（連携用）慢疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2mnsttkykkguybx1 zrndi2mnsttkykkguybx1}</td><td>（連携用）第２慢疾特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2mnsttkykkguybx2 zrndi2mnsttkykkguybx2}</td><td>（連携用）第２慢疾特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2mnsttkykkguybx3 zrndi2mnsttkykkguybx3}</td><td>（連携用）第２慢疾特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2mnsttkykkguybx4 zrndi2mnsttkykkguybx4}</td><td>（連携用）第２慢疾特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2mnsttkykkguybx5 zrndi2mnsttkykkguybx5}</td><td>（連携用）第２慢疾特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkguybx1 zrnsugusnsyutkykkguybx1}</td><td>（連携用）総合損傷特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkguybx2 zrnsugusnsyutkykkguybx2}</td><td>（連携用）総合損傷特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkguybx3 zrnsugusnsyutkykkguybx3}</td><td>（連携用）総合損傷特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkguybx4 zrnsugusnsyutkykkguybx4}</td><td>（連携用）総合損傷特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkguybx5 zrnsugusnsyutkykkguybx5}</td><td>（連携用）総合損傷特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykkguyobix1 zrnkaigonktkykkguyobix1}</td><td>（連携用）介護年金特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykkguyobix2 zrnkaigonktkykkguyobix2}</td><td>（連携用）介護年金特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykkguyobix3 zrnkaigonktkykkguyobix3}</td><td>（連携用）介護年金特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykkguyobix4 zrnkaigonktkykkguyobix4}</td><td>（連携用）介護年金特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykkguyobix5 zrnkaigonktkykkguyobix5}</td><td>（連携用）介護年金特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykkguybx1 zrnitjbrkignktkykkguybx1}</td><td>（連携用）一時払介護年金特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykkguybx2 zrnitjbrkignktkykkguybx2}</td><td>（連携用）一時払介護年金特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykkguybx3 zrnitjbrkignktkykkguybx3}</td><td>（連携用）一時払介護年金特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykkguybx4 zrnitjbrkignktkykkguybx4}</td><td>（連携用）一時払介護年金特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykkguybx5 zrnitjbrkignktkykkguybx5}</td><td>（連携用）一時払介護年金特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykkguybx1 zrndi2syugitkykkguybx1}</td><td>（連携用）第２傷害特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykkguybx2 zrndi2syugitkykkguybx2}</td><td>（連携用）第２傷害特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykkguybx3 zrndi2syugitkykkguybx3}</td><td>（連携用）第２傷害特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykkguybx4 zrndi2syugitkykkguybx4}</td><td>（連携用）第２傷害特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykkguybx5 zrndi2syugitkykkguybx5}</td><td>（連携用）第２傷害特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkguybx1 zrndi2sigiwrmstkykkguybx1}</td><td>（連携用）第２災害割増特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkguybx2 zrndi2sigiwrmstkykkguybx2}</td><td>（連携用）第２災害割増特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkguybx3 zrndi2sigiwrmstkykkguybx3}</td><td>（連携用）第２災害割増特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkguybx4 zrndi2sigiwrmstkykkguybx4}</td><td>（連携用）第２災害割増特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkguybx5 zrndi2sigiwrmstkykkguybx5}</td><td>（連携用）第２災害割増特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykkguybx1 zrndi2siginyuintkykkguybx1}</td><td>（連携用）第２災害入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykkguybx2 zrndi2siginyuintkykkguybx2}</td><td>（連携用）第２災害入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykkguybx3 zrndi2siginyuintkykkguybx3}</td><td>（連携用）第２災害入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykkguybx4 zrndi2siginyuintkykkguybx4}</td><td>（連携用）第２災害入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykkguybx5 zrndi2siginyuintkykkguybx5}</td><td>（連携用）第２災害入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykkguybx1 zrndi2sppinyuintkykkguybx1}</td><td>（連携用）第２疾病入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykkguybx2 zrndi2sppinyuintkykkguybx2}</td><td>（連携用）第２疾病入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykkguybx3 zrndi2sppinyuintkykkguybx3}</td><td>（連携用）第２疾病入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykkguybx4 zrndi2sppinyuintkykkguybx4}</td><td>（連携用）第２疾病入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykkguybx5 zrndi2sppinyuintkykkguybx5}</td><td>（連携用）第２疾病入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkguybx1 zrndi2sijnbyutkykkguybx1}</td><td>（連携用）第２成人病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkguybx2 zrndi2sijnbyutkykkguybx2}</td><td>（連携用）第２成人病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkguybx3 zrndi2sijnbyutkykkguybx3}</td><td>（連携用）第２成人病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkguybx4 zrndi2sijnbyutkykkguybx4}</td><td>（連携用）第２成人病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkguybx5 zrndi2sijnbyutkykkguybx5}</td><td>（連携用）第２成人病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuintkykkguyobix1 zrndai2tuintkykkguyobix1}</td><td>（連携用）第２通院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuintkykkguyobix2 zrndai2tuintkykkguyobix2}</td><td>（連携用）第２通院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuintkykkguyobix3 zrndai2tuintkykkguyobix3}</td><td>（連携用）第２通院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuintkykkguyobix4 zrndai2tuintkykkguyobix4}</td><td>（連携用）第２通院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuintkykkguyobix5 zrndai2tuintkykkguyobix5}</td><td>（連携用）第２通院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkguybx1 zrndi2jysisppitkykkguybx1}</td><td>（連携用）第２女性疾病特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkguybx2 zrndi2jysisppitkykkguybx2}</td><td>（連携用）第２女性疾病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkguybx3 zrndi2jysisppitkykkguybx3}</td><td>（連携用）第２女性疾病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkguybx4 zrndi2jysisppitkykkguybx4}</td><td>（連携用）第２女性疾病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkguybx5 zrndi2jysisppitkykkguybx5}</td><td>（連携用）第２女性疾病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykkguybx1 zrndi2sugusnsyutkykkguybx1}</td><td>（連携用）第２総合損傷特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykkguybx2 zrndi2sugusnsyutkykkguybx2}</td><td>（連携用）第２総合損傷特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykkguybx3 zrndi2sugusnsyutkykkguybx3}</td><td>（連携用）第２総合損傷特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykkguybx4 zrndi2sugusnsyutkykkguybx4}</td><td>（連携用）第２総合損傷特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykkguybx5 zrndi2sugusnsyutkykkguybx5}</td><td>（連携用）第２総合損傷特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkguybx1 zrndi2sykkyuhtkykkguybx1}</td><td>（連携用）第２初期給付特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkguybx2 zrndi2sykkyuhtkykkguybx2}</td><td>（連携用）第２初期給付特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkguybx3 zrndi2sykkyuhtkykkguybx3}</td><td>（連携用）第２初期給付特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkguybx4 zrndi2sykkyuhtkykkguybx4}</td><td>（連携用）第２初期給付特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkguybx5 zrndi2sykkyuhtkykkguybx5}</td><td>（連携用）第２初期給付特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x1 zrnsetaitehknsyuruiyobi1x1}</td><td>（連携用）セット相手保険種類予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x2 zrnsetaitehknsyuruiyobi1x2}</td><td>（連携用）セット相手保険種類予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x3 zrnsetaitehknsyuruiyobi1x3}</td><td>（連携用）セット相手保険種類予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x4 zrnsetaitehknsyuruiyobi1x4}</td><td>（連携用）セット相手保険種類予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x5 zrnsetaitehknsyuruiyobi1x5}</td><td>（連携用）セット相手保険種類予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x6 zrnsetaitehknsyuruiyobi1x6}</td><td>（連携用）セット相手保険種類予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x7 zrnsetaitehknsyuruiyobi1x7}</td><td>（連携用）セット相手保険種類予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x8 zrnsetaitehknsyuruiyobi1x8}</td><td>（連携用）セット相手保険種類予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x9 zrnsetaitehknsyuruiyobi1x9}</td><td>（連携用）セット相手保険種類予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x10 zrnsetaitehknsyuruiyobi1x10}</td><td>（連携用）セット相手保険種類予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x11 zrnsetaitehknsyuruiyobi1x11}</td><td>（連携用）セット相手保険種類予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x12 zrnsetaitehknsyuruiyobi1x12}</td><td>（連携用）セット相手保険種類予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x13 zrnsetaitehknsyuruiyobi1x13}</td><td>（連携用）セット相手保険種類予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x14 zrnsetaitehknsyuruiyobi1x14}</td><td>（連携用）セット相手保険種類予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi1x15 zrnsetaitehknsyuruiyobi1x15}</td><td>（連携用）セット相手保険種類予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x1 zrnsetaitehknsyuruiyobi2x1}</td><td>（連携用）セット相手保険種類予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x2 zrnsetaitehknsyuruiyobi2x2}</td><td>（連携用）セット相手保険種類予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x3 zrnsetaitehknsyuruiyobi2x3}</td><td>（連携用）セット相手保険種類予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x4 zrnsetaitehknsyuruiyobi2x4}</td><td>（連携用）セット相手保険種類予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x5 zrnsetaitehknsyuruiyobi2x5}</td><td>（連携用）セット相手保険種類予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x6 zrnsetaitehknsyuruiyobi2x6}</td><td>（連携用）セット相手保険種類予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x7 zrnsetaitehknsyuruiyobi2x7}</td><td>（連携用）セット相手保険種類予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x8 zrnsetaitehknsyuruiyobi2x8}</td><td>（連携用）セット相手保険種類予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x9 zrnsetaitehknsyuruiyobi2x9}</td><td>（連携用）セット相手保険種類予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi2x10 zrnsetaitehknsyuruiyobi2x10}</td><td>（連携用）セット相手保険種類予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x1 zrnsetaitehknsyuruiyobi3x1}</td><td>（連携用）セット相手保険種類予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x2 zrnsetaitehknsyuruiyobi3x2}</td><td>（連携用）セット相手保険種類予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x3 zrnsetaitehknsyuruiyobi3x3}</td><td>（連携用）セット相手保険種類予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x4 zrnsetaitehknsyuruiyobi3x4}</td><td>（連携用）セット相手保険種類予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x5 zrnsetaitehknsyuruiyobi3x5}</td><td>（連携用）セット相手保険種類予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x6 zrnsetaitehknsyuruiyobi3x6}</td><td>（連携用）セット相手保険種類予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x7 zrnsetaitehknsyuruiyobi3x7}</td><td>（連携用）セット相手保険種類予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x8 zrnsetaitehknsyuruiyobi3x8}</td><td>（連携用）セット相手保険種類予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x9 zrnsetaitehknsyuruiyobi3x9}</td><td>（連携用）セット相手保険種類予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknsyuruiyobi3x10 zrnsetaitehknsyuruiyobi3x10}</td><td>（連携用）セット相手保険種類予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu3Rn
 * @see     PKZT_Sp2RnduyuSouseiritu3Rn
 * @see     QZT_Sp2RnduyuSouseiritu3Rn
 * @see     GenQZT_Sp2RnduyuSouseiritu3Rn
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu3Rn.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu3Rn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu3Rn extends AbstractExDBEntityForZDB<ZT_Sp2RnduyuSouseiritu3Rn, PKZT_Sp2RnduyuSouseiritu3Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu3Rn";
    public static final String ZRNKTGYSYRYMD            = "zrnktgysyrymd";
    public static final String ZRNKTGYSYONO             = "zrnktgysyono";
    public static final String ZRNKTGYFILERENNO         = "zrnktgyfilerenno";
    public static final String ZRNBOSYUUKEIROKBN        = "zrnbosyuukeirokbn";
    public static final String ZRNSYOKAIPCASHLESSNYUKINHYJ = "zrnsyokaipcashlessnyukinhyj";
    public static final String ZRNKIGKYHSITIHSYUTKYKARIHYJ = "zrnkigkyhsitihsyutkykarihyj";
    public static final String ZRNSYOKAIPSWINGRIYOUKBN  = "zrnsyokaipswingriyoukbn";
    public static final String ZRNSKNJYUTUTKYKKYKKBN    = "zrnsknjyututkykkykkbn";
    public static final String ZRNBOSYUUDAIRITENGYOUSYUKBN = "zrnbosyuudairitengyousyukbn";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNTOKUSYUJIMUTORIATUKAIKBN = "zrntokusyujimutoriatukaikbn";
    public static final String ZRNPMENTKYKYUTKTBICDX1   = "zrnpmentkykyutktbicdx1";
    public static final String ZRNPMENTKYKYUHTNPKKNX1   = "zrnpmentkykyuhtnpkknx1";
    public static final String ZRNPMENTKYKYUTKTBICDX2   = "zrnpmentkykyutktbicdx2";
    public static final String ZRNPMENTKYKYUHTNPKKNX2   = "zrnpmentkykyuhtnpkknx2";
    public static final String ZRNHOSYOUIKKATUMNOSHYOUJI = "zrnhosyouikkatumnoshyouji";
    public static final String ZRNHSYUIKKTMINAOSIKAISU  = "zrnhsyuikktminaosikaisu";
    public static final String ZRNHSYUIKKTMNOSDFNYUKNHYJ = "zrnhsyuikktmnosdfnyuknhyj";
    public static final String ZRNIKKTMNOSKIKIYUTKYKP   = "zrnikktmnoskikiyutkykp";
    public static final String ZRNIKKTMNOSKIKIYUFNDSISTP = "zrnikktmnoskikiyufndsistp";
    public static final String ZRNSKNNJYNBKNSISNRT      = "zrnsknnjynbknsisnrt";
    public static final String ZRNKANYUJISYONO          = "zrnkanyujisyono";
    public static final String ZRNKANYUJIKYKYMD         = "zrnkanyujikykymd";
    public static final String ZRNKANYUUJIHIHOKENSYAAGE = "zrnkanyuujihihokensyaage";
    public static final String ZRNKANYUUJITENKANHYOUJI  = "zrnkanyuujitenkanhyouji";
    public static final String ZRNKSNYUHSYUIKKTMINOSNNSKBN = "zrnksnyuhsyuikktminosnnskbn";
    public static final String ZRNAATUKAISYADIRTNBSYNNHYJ = "zrnaatukaisyadirtnbsynnhyj";
    public static final String ZRNBATKISYADIRTNBOSYUNINHYJ = "zrnbatkisyadirtnbosyuninhyj";
    public static final String ZRNDIRTNAATUKAISYAKOJINCD = "zrndirtnaatukaisyakojincd";
    public static final String ZRNDIRTNBATUKAISYAKOJINCD = "zrndirtnbatukaisyakojincd";
    public static final String ZRNSYUUSEISYOUKEIKANENSUU = "zrnsyuuseisyoukeikanensuu";
    public static final String ZRNSYURUIHNKUTKBTTRTKHYJ = "zrnsyuruihnkutkbttrtkhyj";
    public static final String ZRNBNKTMEKYKTKYKHKJYUTIKBN = "zrnbnktmekyktkykhkjyutikbn";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNTNKNSYOKAIPCLESSRIYOUHYJ = "zrntnknsyokaipclessriyouhyj";
    public static final String ZRNHRKTEISIKIBOUHYOUJI   = "zrnhrkteisikibouhyouji";
    public static final String ZRNBUNKATUGOSONZOKUKEIYAKUS = "zrnbunkatugosonzokukeiyakus";
    public static final String ZRNMOSKIZKPHRKEKNGK      = "zrnmoskizkphrkekngk";
    public static final String ZRNKEIZOKUPHURIKAEJIJIKAIP = "zrnkeizokuphurikaejijikaip";
    public static final String ZRNBNKTMEKYKSYONO        = "zrnbnktmekyksyono";
    public static final String ZRNBUNKATUMAEKEIYAKUKIHONS = "zrnbunkatumaekeiyakukihons";
    public static final String ZRNBUNKATUMAEKEIYAKUSIBOUS = "zrnbunkatumaekeiyakusibous";
    public static final String ZRNBNKTMEKYKMODS         = "zrnbnktmekykmods";
    public static final String ZRNBNKTMEKYKSIGIWRMSTKYKS = "zrnbnktmekyksigiwrmstkyks";
    public static final String ZRNBNKTMEKYKSYUGITKYKS   = "zrnbnktmekyksyugitkyks";
    public static final String ZRNBNKTMKYKSIGINYINTKYKNTGK = "zrnbnktmkyksiginyintkykntgk";
    public static final String ZRNBNKTMEKYKKNKUTKYKNTGK = "zrnbnktmekykknkutkykntgk";
    public static final String ZRNBNKTMEKYKHNTIYUNBRIKNSNP = "zrnbnktmekykhntiyunbriknsnp";
    public static final String ZRNDAI2NAIBUWARIMODOSIGAKU = "zrndai2naibuwarimodosigaku";
    public static final String ZRNTNKNGKYKKSTKGK        = "zrntnkngkykkstkgk";
    public static final String ZRNBNKTMEKYKKSTKGK       = "zrnbnktmekykkstkgk";
    public static final String ZRNSONZOKUKYKKASITUKEGK  = "zrnsonzokukykkasitukegk";
    public static final String ZRNHNGKMNRYOUJSITIHSYUKNGK = "zrnhngkmnryoujsitihsyukngk";
    public static final String ZRNHNGKSITIHSYUYUSYKYKP  = "zrnhngksitihsyuyusykykp";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX1X1 = "zrnhtnknkigmrsyukguybx1x1";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX2X1 = "zrnhtnknkigmrsyukguybx2x1";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX3X1 = "zrnhtnknkigmrsyukguybx3x1";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX4X1 = "zrnhtnknkigmrsyukguybx4x1";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX5X1 = "zrnhtnknkigmrsyukguybx5x1";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX1X2 = "zrnhtnknkigmrsyukguybx1x2";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX2X2 = "zrnhtnknkigmrsyukguybx2x2";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX3X2 = "zrnhtnknkigmrsyukguybx3x2";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX4X2 = "zrnhtnknkigmrsyukguybx4x2";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX5X2 = "zrnhtnknkigmrsyukguybx5x2";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX1X3 = "zrnhtnknkigmrsyukguybx1x3";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX2X3 = "zrnhtnknkigmrsyukguybx2x3";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX3X3 = "zrnhtnknkigmrsyukguybx3x3";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX4X3 = "zrnhtnknkigmrsyukguybx4x3";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX5X3 = "zrnhtnknkigmrsyukguybx5x3";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX1X4 = "zrnhtnknkigmrsyukguybx1x4";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX2X4 = "zrnhtnknkigmrsyukguybx2x4";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX3X4 = "zrnhtnknkigmrsyukguybx3x4";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX4X4 = "zrnhtnknkigmrsyukguybx4x4";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX5X4 = "zrnhtnknkigmrsyukguybx5x4";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX1X5 = "zrnhtnknkigmrsyukguybx1x5";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX2X5 = "zrnhtnknkigmrsyukguybx2x5";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX3X5 = "zrnhtnknkigmrsyukguybx3x5";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX4X5 = "zrnhtnknkigmrsyukguybx4x5";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX5X5 = "zrnhtnknkigmrsyukguybx5x5";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX1X6 = "zrnhtnknkigmrsyukguybx1x6";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX2X6 = "zrnhtnknkigmrsyukguybx2x6";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX3X6 = "zrnhtnknkigmrsyukguybx3x6";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX4X6 = "zrnhtnknkigmrsyukguybx4x6";
    public static final String ZRNHTNKNKIGMRSYUKGUYBX5X6 = "zrnhtnknkigmrsyukguybx5x6";
    public static final String ZRNYOBIV1X3              = "zrnyobiv1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNMARUTEIKIGOUYOBIX1    = "zrnmaruteikigouyobix1";
    public static final String ZRNMARUTEIKIGOUYOBIX2    = "zrnmaruteikigouyobix2";
    public static final String ZRNMARUTEIKIGOUYOBIX3    = "zrnmaruteikigouyobix3";
    public static final String ZRNMARUTEIKIGOUYOBIX4    = "zrnmaruteikigouyobix4";
    public static final String ZRNMARUTEIKIGOUYOBIX5    = "zrnmaruteikigouyobix5";
    public static final String ZRNMARUYOUKIGOUYOBIX1    = "zrnmaruyoukigouyobix1";
    public static final String ZRNMARUYOUKIGOUYOBIX2    = "zrnmaruyoukigouyobix2";
    public static final String ZRNMARUYOUKIGOUYOBIX3    = "zrnmaruyoukigouyobix3";
    public static final String ZRNMARUYOUKIGOUYOBIX4    = "zrnmaruyoukigouyobix4";
    public static final String ZRNMARUYOUKIGOUYOBIX5    = "zrnmaruyoukigouyobix5";
    public static final String ZRNMARUSYUUKIGOUYOBIX1   = "zrnmarusyuukigouyobix1";
    public static final String ZRNMARUSYUUKIGOUYOBIX2   = "zrnmarusyuukigouyobix2";
    public static final String ZRNMARUSYUUKIGOUYOBIX3   = "zrnmarusyuukigouyobix3";
    public static final String ZRNMARUSYUUKIGOUYOBIX4   = "zrnmarusyuukigouyobix4";
    public static final String ZRNMARUSYUUKIGOUYOBIX5   = "zrnmarusyuukigouyobix5";
    public static final String ZRNTOKUTEIKIGOUYOBIX1    = "zrntokuteikigouyobix1";
    public static final String ZRNTOKUTEIKIGOUYOBIX2    = "zrntokuteikigouyobix2";
    public static final String ZRNTOKUTEIKIGOUYOBIX3    = "zrntokuteikigouyobix3";
    public static final String ZRNTOKUTEIKIGOUYOBIX4    = "zrntokuteikigouyobix4";
    public static final String ZRNTOKUTEIKIGOUYOBIX5    = "zrntokuteikigouyobix5";
    public static final String ZRNKZKMRTIKGUYBX1X1      = "zrnkzkmrtikguybx1x1";
    public static final String ZRNKZKMRTIKGUYBX2X1      = "zrnkzkmrtikguybx2x1";
    public static final String ZRNKZKMRTIKGUYBX3X1      = "zrnkzkmrtikguybx3x1";
    public static final String ZRNKZKMRTIKGUYBX4X1      = "zrnkzkmrtikguybx4x1";
    public static final String ZRNKZKMRTIKGUYBX5X1      = "zrnkzkmrtikguybx5x1";
    public static final String ZRNKZKMRTIKGUYBX1X2      = "zrnkzkmrtikguybx1x2";
    public static final String ZRNKZKMRTIKGUYBX2X2      = "zrnkzkmrtikguybx2x2";
    public static final String ZRNKZKMRTIKGUYBX3X2      = "zrnkzkmrtikguybx3x2";
    public static final String ZRNKZKMRTIKGUYBX4X2      = "zrnkzkmrtikguybx4x2";
    public static final String ZRNKZKMRTIKGUYBX5X2      = "zrnkzkmrtikguybx5x2";
    public static final String ZRNKZKMRTIKGUYBX1X3      = "zrnkzkmrtikguybx1x3";
    public static final String ZRNKZKMRTIKGUYBX2X3      = "zrnkzkmrtikguybx2x3";
    public static final String ZRNKZKMRTIKGUYBX3X3      = "zrnkzkmrtikguybx3x3";
    public static final String ZRNKZKMRTIKGUYBX4X3      = "zrnkzkmrtikguybx4x3";
    public static final String ZRNKZKMRTIKGUYBX5X3      = "zrnkzkmrtikguybx5x3";
    public static final String ZRNKZKMRTIKGUYBX1X4      = "zrnkzkmrtikguybx1x4";
    public static final String ZRNKZKMRTIKGUYBX2X4      = "zrnkzkmrtikguybx2x4";
    public static final String ZRNKZKMRTIKGUYBX3X4      = "zrnkzkmrtikguybx3x4";
    public static final String ZRNKZKMRTIKGUYBX4X4      = "zrnkzkmrtikguybx4x4";
    public static final String ZRNKZKMRTIKGUYBX5X4      = "zrnkzkmrtikguybx5x4";
    public static final String ZRNKZKMRTIKGUYBX1X5      = "zrnkzkmrtikguybx1x5";
    public static final String ZRNKZKMRTIKGUYBX2X5      = "zrnkzkmrtikguybx2x5";
    public static final String ZRNKZKMRTIKGUYBX3X5      = "zrnkzkmrtikguybx3x5";
    public static final String ZRNKZKMRTIKGUYBX4X5      = "zrnkzkmrtikguybx4x5";
    public static final String ZRNKZKMRTIKGUYBX5X5      = "zrnkzkmrtikguybx5x5";
    public static final String ZRNKZKMRTIKGUYBX1X6      = "zrnkzkmrtikguybx1x6";
    public static final String ZRNKZKMRTIKGUYBX2X6      = "zrnkzkmrtikguybx2x6";
    public static final String ZRNKZKMRTIKGUYBX3X6      = "zrnkzkmrtikguybx3x6";
    public static final String ZRNKZKMRTIKGUYBX4X6      = "zrnkzkmrtikguybx4x6";
    public static final String ZRNKZKMRTIKGUYBX5X6      = "zrnkzkmrtikguybx5x6";
    public static final String ZRNKZKMRTIKGUYBX1X7      = "zrnkzkmrtikguybx1x7";
    public static final String ZRNKZKMRTIKGUYBX2X7      = "zrnkzkmrtikguybx2x7";
    public static final String ZRNKZKMRTIKGUYBX3X7      = "zrnkzkmrtikguybx3x7";
    public static final String ZRNKZKMRTIKGUYBX4X7      = "zrnkzkmrtikguybx4x7";
    public static final String ZRNKZKMRTIKGUYBX5X7      = "zrnkzkmrtikguybx5x7";
    public static final String ZRNKZKMRTIKGUYBX1X8      = "zrnkzkmrtikguybx1x8";
    public static final String ZRNKZKMRTIKGUYBX2X8      = "zrnkzkmrtikguybx2x8";
    public static final String ZRNKZKMRTIKGUYBX3X8      = "zrnkzkmrtikguybx3x8";
    public static final String ZRNKZKMRTIKGUYBX4X8      = "zrnkzkmrtikguybx4x8";
    public static final String ZRNKZKMRTIKGUYBX5X8      = "zrnkzkmrtikguybx5x8";
    public static final String ZRNKZKMRTIKGUYBX1X9      = "zrnkzkmrtikguybx1x9";
    public static final String ZRNKZKMRTIKGUYBX2X9      = "zrnkzkmrtikguybx2x9";
    public static final String ZRNKZKMRTIKGUYBX3X9      = "zrnkzkmrtikguybx3x9";
    public static final String ZRNKZKMRTIKGUYBX4X9      = "zrnkzkmrtikguybx4x9";
    public static final String ZRNKZKMRTIKGUYBX5X9      = "zrnkzkmrtikguybx5x9";
    public static final String ZRNKZKMRTIKGUYBX1X10     = "zrnkzkmrtikguybx1x10";
    public static final String ZRNKZKMRTIKGUYBX2X10     = "zrnkzkmrtikguybx2x10";
    public static final String ZRNKZKMRTIKGUYBX3X10     = "zrnkzkmrtikguybx3x10";
    public static final String ZRNKZKMRTIKGUYBX4X10     = "zrnkzkmrtikguybx4x10";
    public static final String ZRNKZKMRTIKGUYBX5X10     = "zrnkzkmrtikguybx5x10";
    public static final String ZRNSYUGITTKYKKGUYBX1     = "zrnsyugittkykkguybx1";
    public static final String ZRNSYUGITTKYKKGUYBX2     = "zrnsyugittkykkguybx2";
    public static final String ZRNSYUGITTKYKKGUYBX3     = "zrnsyugittkykkguybx3";
    public static final String ZRNSYUGITTKYKKGUYBX4     = "zrnsyugittkykkguybx4";
    public static final String ZRNSYUGITTKYKKGUYBX5     = "zrnsyugittkykkguybx5";
    public static final String ZRNSIGIWRMSTKYKKGUYBX1   = "zrnsigiwrmstkykkguybx1";
    public static final String ZRNSIGIWRMSTKYKKGUYBX2   = "zrnsigiwrmstkykkguybx2";
    public static final String ZRNSIGIWRMSTKYKKGUYBX3   = "zrnsigiwrmstkykkguybx3";
    public static final String ZRNSIGIWRMSTKYKKGUYBX4   = "zrnsigiwrmstkykkguybx4";
    public static final String ZRNSIGIWRMSTKYKKGUYBX5   = "zrnsigiwrmstkykkguybx5";
    public static final String ZRNSIGINYUINTKYKKGUYBX1  = "zrnsiginyuintkykkguybx1";
    public static final String ZRNSIGINYUINTKYKKGUYBX2  = "zrnsiginyuintkykkguybx2";
    public static final String ZRNSIGINYUINTKYKKGUYBX3  = "zrnsiginyuintkykkguybx3";
    public static final String ZRNSIGINYUINTKYKKGUYBX4  = "zrnsiginyuintkykkguybx4";
    public static final String ZRNSIGINYUINTKYKKGUYBX5  = "zrnsiginyuintkykkguybx5";
    public static final String ZRNSPPINYUINTKYKKGUYBX1  = "zrnsppinyuintkykkguybx1";
    public static final String ZRNSPPINYUINTKYKKGUYBX2  = "zrnsppinyuintkykkguybx2";
    public static final String ZRNSPPINYUINTKYKKGUYBX3  = "zrnsppinyuintkykkguybx3";
    public static final String ZRNSPPINYUINTKYKKGUYBX4  = "zrnsppinyuintkykkguybx4";
    public static final String ZRNSPPINYUINTKYKKGUYBX5  = "zrnsppinyuintkykkguybx5";
    public static final String ZRNSIJNBYUTKYKKGUYBX1    = "zrnsijnbyutkykkguybx1";
    public static final String ZRNSIJNBYUTKYKKGUYBX2    = "zrnsijnbyutkykkguybx2";
    public static final String ZRNSIJNBYUTKYKKGUYBX3    = "zrnsijnbyutkykkguybx3";
    public static final String ZRNSIJNBYUTKYKKGUYBX4    = "zrnsijnbyutkykkguybx4";
    public static final String ZRNSIJNBYUTKYKKGUYBX5    = "zrnsijnbyutkykkguybx5";
    public static final String ZRNKZKIRYOUTKYKKGUYBX1   = "zrnkzkiryoutkykkguybx1";
    public static final String ZRNKZKIRYOUTKYKKGUYBX2   = "zrnkzkiryoutkykkguybx2";
    public static final String ZRNKZKIRYOUTKYKKGUYBX3   = "zrnkzkiryoutkykkguybx3";
    public static final String ZRNKZKIRYOUTKYKKGUYBX4   = "zrnkzkiryoutkykkguybx4";
    public static final String ZRNKZKIRYOUTKYKKGUYBX5   = "zrnkzkiryoutkykkguybx5";
    public static final String ZRNSYKKYUHTKYKKGUYBX1    = "zrnsykkyuhtkykkguybx1";
    public static final String ZRNSYKKYUHTKYKKGUYBX2    = "zrnsykkyuhtkykkguybx2";
    public static final String ZRNSYKKYUHTKYKKGUYBX3    = "zrnsykkyuhtkykkguybx3";
    public static final String ZRNSYKKYUHTKYKKGUYBX4    = "zrnsykkyuhtkykkguybx4";
    public static final String ZRNSYKKYUHTKYKKGUYBX5    = "zrnsykkyuhtkykkguybx5";
    public static final String ZRNNKDTMRTIKGUYOBIX1     = "zrnnkdtmrtikguyobix1";
    public static final String ZRNNKDTMRTIKGUYOBIX2     = "zrnnkdtmrtikguyobix2";
    public static final String ZRNNKDTMRTIKGUYOBIX3     = "zrnnkdtmrtikguyobix3";
    public static final String ZRNNKDTMRTIKGUYOBIX4     = "zrnnkdtmrtikguyobix4";
    public static final String ZRNNKDTMRTIKGUYOBIX5     = "zrnnkdtmrtikguyobix5";
    public static final String ZRNNKDATETOKUTEIKGUYOBIX1 = "zrnnkdatetokuteikguyobix1";
    public static final String ZRNNKDATETOKUTEIKGUYOBIX2 = "zrnnkdatetokuteikguyobix2";
    public static final String ZRNNKDATETOKUTEIKGUYOBIX3 = "zrnnkdatetokuteikguyobix3";
    public static final String ZRNNKDATETOKUTEIKGUYOBIX4 = "zrnnkdatetokuteikguyobix4";
    public static final String ZRNNKDATETOKUTEIKGUYOBIX5 = "zrnnkdatetokuteikguyobix5";
    public static final String ZRNKAIGONKDTMRTIKGUYOBIX1 = "zrnkaigonkdtmrtikguyobix1";
    public static final String ZRNKAIGONKDTMRTIKGUYOBIX2 = "zrnkaigonkdtmrtikguyobix2";
    public static final String ZRNKAIGONKDTMRTIKGUYOBIX3 = "zrnkaigonkdtmrtikguyobix3";
    public static final String ZRNKAIGONKDTMRTIKGUYOBIX4 = "zrnkaigonkdtmrtikguyobix4";
    public static final String ZRNKAIGONKDTMRTIKGUYOBIX5 = "zrnkaigonkdtmrtikguyobix5";
    public static final String ZRNKAIGONKDTTKTIKGUYOBIX1 = "zrnkaigonkdttktikguyobix1";
    public static final String ZRNKAIGONKDTTKTIKGUYOBIX2 = "zrnkaigonkdttktikguyobix2";
    public static final String ZRNKAIGONKDTTKTIKGUYOBIX3 = "zrnkaigonkdttktikguyobix3";
    public static final String ZRNKAIGONKDTTKTIKGUYOBIX4 = "zrnkaigonkdttktikguyobix4";
    public static final String ZRNKAIGONKDTTKTIKGUYOBIX5 = "zrnkaigonkdttktikguyobix5";
    public static final String ZRNKAIGOMARUTEIKIGOUYOBIX1 = "zrnkaigomaruteikigouyobix1";
    public static final String ZRNKAIGOMARUTEIKIGOUYOBIX2 = "zrnkaigomaruteikigouyobix2";
    public static final String ZRNKAIGOMARUTEIKIGOUYOBIX3 = "zrnkaigomaruteikigouyobix3";
    public static final String ZRNKAIGOMARUTEIKIGOUYOBIX4 = "zrnkaigomaruteikigouyobix4";
    public static final String ZRNKAIGOMARUTEIKIGOUYOBIX5 = "zrnkaigomaruteikigouyobix5";
    public static final String ZRNKAIGOTOKUTEIKIGOUYOBIX1 = "zrnkaigotokuteikigouyobix1";
    public static final String ZRNKAIGOTOKUTEIKIGOUYOBIX2 = "zrnkaigotokuteikigouyobix2";
    public static final String ZRNKAIGOTOKUTEIKIGOUYOBIX3 = "zrnkaigotokuteikigouyobix3";
    public static final String ZRNKAIGOTOKUTEIKIGOUYOBIX4 = "zrnkaigotokuteikigouyobix4";
    public static final String ZRNKAIGOTOKUTEIKIGOUYOBIX5 = "zrnkaigotokuteikigouyobix5";
    public static final String ZRNSIZNMRTIKGUYBX1       = "zrnsiznmrtikguybx1";
    public static final String ZRNSIZNMRTIKGUYBX2       = "zrnsiznmrtikguybx2";
    public static final String ZRNSIZNMRTIKGUYBX3       = "zrnsiznmrtikguybx3";
    public static final String ZRNSIZNMRTIKGUYBX4       = "zrnsiznmrtikguybx4";
    public static final String ZRNSIZNMRTIKGUYBX5       = "zrnsiznmrtikguybx5";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX1 = "zrnteigenmaruteikigouyobix1";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX2 = "zrnteigenmaruteikigouyobix2";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX3 = "zrnteigenmaruteikigouyobix3";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX4 = "zrnteigenmaruteikigouyobix4";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX5 = "zrnteigenmaruteikigouyobix5";
    public static final String ZRNTEIGENTOKUTEIKIGOUYOBIX1 = "zrnteigentokuteikigouyobix1";
    public static final String ZRNTEIGENTOKUTEIKIGOUYOBIX2 = "zrnteigentokuteikigouyobix2";
    public static final String ZRNTEIGENTOKUTEIKIGOUYOBIX3 = "zrnteigentokuteikigouyobix3";
    public static final String ZRNTEIGENTOKUTEIKIGOUYOBIX4 = "zrnteigentokuteikigouyobix4";
    public static final String ZRNTEIGENTOKUTEIKIGOUYOBIX5 = "zrnteigentokuteikigouyobix5";
    public static final String ZRNKIGTIGNMRTIKGUYBX1    = "zrnkigtignmrtikguybx1";
    public static final String ZRNKIGTIGNMRTIKGUYBX2    = "zrnkigtignmrtikguybx2";
    public static final String ZRNKIGTIGNMRTIKGUYBX3    = "zrnkigtignmrtikguybx3";
    public static final String ZRNKIGTIGNMRTIKGUYBX4    = "zrnkigtignmrtikguybx4";
    public static final String ZRNKIGTIGNMRTIKGUYBX5    = "zrnkigtignmrtikguybx5";
    public static final String ZRNKIGTIGNTKTIKGUYBX1    = "zrnkigtigntktikguybx1";
    public static final String ZRNKIGTIGNTKTIKGUYBX2    = "zrnkigtigntktikguybx2";
    public static final String ZRNKIGTIGNTKTIKGUYBX3    = "zrnkigtigntktikguybx3";
    public static final String ZRNKIGTIGNTKTIKGUYBX4    = "zrnkigtigntktikguybx4";
    public static final String ZRNKIGTIGNTKTIKGUYBX5    = "zrnkigtigntktikguybx5";
    public static final String ZRNTUUINTOKUYAKUKIGOUYOBIX1 = "zrntuuintokuyakukigouyobix1";
    public static final String ZRNTUUINTOKUYAKUKIGOUYOBIX2 = "zrntuuintokuyakukigouyobix2";
    public static final String ZRNTUUINTOKUYAKUKIGOUYOBIX3 = "zrntuuintokuyakukigouyobix3";
    public static final String ZRNTUUINTOKUYAKUKIGOUYOBIX4 = "zrntuuintokuyakukigouyobix4";
    public static final String ZRNTUUINTOKUYAKUKIGOUYOBIX5 = "zrntuuintokuyakukigouyobix5";
    public static final String ZRNJYSISPPITKYKKGUYOBIX1 = "zrnjysisppitkykkguyobix1";
    public static final String ZRNJYSISPPITKYKKGUYOBIX2 = "zrnjysisppitkykkguyobix2";
    public static final String ZRNJYSISPPITKYKKGUYOBIX3 = "zrnjysisppitkykkguyobix3";
    public static final String ZRNJYSISPPITKYKKGUYOBIX4 = "zrnjysisppitkykkguyobix4";
    public static final String ZRNJYSISPPITKYKKGUYOBIX5 = "zrnjysisppitkykkguyobix5";
    public static final String ZRNTKSTTKYKKGUYBX1       = "zrntksttkykkguybx1";
    public static final String ZRNTKSTTKYKKGUYBX2       = "zrntksttkykkguybx2";
    public static final String ZRNTKSTTKYKKGUYBX3       = "zrntksttkykkguybx3";
    public static final String ZRNTKSTTKYKKGUYBX4       = "zrntksttkykkguybx4";
    public static final String ZRNTKSTTKYKKGUYBX5       = "zrntksttkykkguybx5";
    public static final String ZRNDI2TKSTTKYKKGUYBX1    = "zrndi2tksttkykkguybx1";
    public static final String ZRNDI2TKSTTKYKKGUYBX2    = "zrndi2tksttkykkguybx2";
    public static final String ZRNDI2TKSTTKYKKGUYBX3    = "zrndi2tksttkykkguybx3";
    public static final String ZRNDI2TKSTTKYKKGUYBX4    = "zrndi2tksttkykkguybx4";
    public static final String ZRNDI2TKSTTKYKKGUYBX5    = "zrndi2tksttkykkguybx5";
    public static final String ZRNMNSTTKYKKGUYBX1       = "zrnmnsttkykkguybx1";
    public static final String ZRNMNSTTKYKKGUYBX2       = "zrnmnsttkykkguybx2";
    public static final String ZRNMNSTTKYKKGUYBX3       = "zrnmnsttkykkguybx3";
    public static final String ZRNMNSTTKYKKGUYBX4       = "zrnmnsttkykkguybx4";
    public static final String ZRNMNSTTKYKKGUYBX5       = "zrnmnsttkykkguybx5";
    public static final String ZRNDI2MNSTTKYKKGUYBX1    = "zrndi2mnsttkykkguybx1";
    public static final String ZRNDI2MNSTTKYKKGUYBX2    = "zrndi2mnsttkykkguybx2";
    public static final String ZRNDI2MNSTTKYKKGUYBX3    = "zrndi2mnsttkykkguybx3";
    public static final String ZRNDI2MNSTTKYKKGUYBX4    = "zrndi2mnsttkykkguybx4";
    public static final String ZRNDI2MNSTTKYKKGUYBX5    = "zrndi2mnsttkykkguybx5";
    public static final String ZRNSUGUSNSYUTKYKKGUYBX1  = "zrnsugusnsyutkykkguybx1";
    public static final String ZRNSUGUSNSYUTKYKKGUYBX2  = "zrnsugusnsyutkykkguybx2";
    public static final String ZRNSUGUSNSYUTKYKKGUYBX3  = "zrnsugusnsyutkykkguybx3";
    public static final String ZRNSUGUSNSYUTKYKKGUYBX4  = "zrnsugusnsyutkykkguybx4";
    public static final String ZRNSUGUSNSYUTKYKKGUYBX5  = "zrnsugusnsyutkykkguybx5";
    public static final String ZRNKAIGONKTKYKKGUYOBIX1  = "zrnkaigonktkykkguyobix1";
    public static final String ZRNKAIGONKTKYKKGUYOBIX2  = "zrnkaigonktkykkguyobix2";
    public static final String ZRNKAIGONKTKYKKGUYOBIX3  = "zrnkaigonktkykkguyobix3";
    public static final String ZRNKAIGONKTKYKKGUYOBIX4  = "zrnkaigonktkykkguyobix4";
    public static final String ZRNKAIGONKTKYKKGUYOBIX5  = "zrnkaigonktkykkguyobix5";
    public static final String ZRNITJBRKIGNKTKYKKGUYBX1 = "zrnitjbrkignktkykkguybx1";
    public static final String ZRNITJBRKIGNKTKYKKGUYBX2 = "zrnitjbrkignktkykkguybx2";
    public static final String ZRNITJBRKIGNKTKYKKGUYBX3 = "zrnitjbrkignktkykkguybx3";
    public static final String ZRNITJBRKIGNKTKYKKGUYBX4 = "zrnitjbrkignktkykkguybx4";
    public static final String ZRNITJBRKIGNKTKYKKGUYBX5 = "zrnitjbrkignktkykkguybx5";
    public static final String ZRNDI2SYUGITKYKKGUYBX1   = "zrndi2syugitkykkguybx1";
    public static final String ZRNDI2SYUGITKYKKGUYBX2   = "zrndi2syugitkykkguybx2";
    public static final String ZRNDI2SYUGITKYKKGUYBX3   = "zrndi2syugitkykkguybx3";
    public static final String ZRNDI2SYUGITKYKKGUYBX4   = "zrndi2syugitkykkguybx4";
    public static final String ZRNDI2SYUGITKYKKGUYBX5   = "zrndi2syugitkykkguybx5";
    public static final String ZRNDI2SIGIWRMSTKYKKGUYBX1 = "zrndi2sigiwrmstkykkguybx1";
    public static final String ZRNDI2SIGIWRMSTKYKKGUYBX2 = "zrndi2sigiwrmstkykkguybx2";
    public static final String ZRNDI2SIGIWRMSTKYKKGUYBX3 = "zrndi2sigiwrmstkykkguybx3";
    public static final String ZRNDI2SIGIWRMSTKYKKGUYBX4 = "zrndi2sigiwrmstkykkguybx4";
    public static final String ZRNDI2SIGIWRMSTKYKKGUYBX5 = "zrndi2sigiwrmstkykkguybx5";
    public static final String ZRNDI2SIGINYUINTKYKKGUYBX1 = "zrndi2siginyuintkykkguybx1";
    public static final String ZRNDI2SIGINYUINTKYKKGUYBX2 = "zrndi2siginyuintkykkguybx2";
    public static final String ZRNDI2SIGINYUINTKYKKGUYBX3 = "zrndi2siginyuintkykkguybx3";
    public static final String ZRNDI2SIGINYUINTKYKKGUYBX4 = "zrndi2siginyuintkykkguybx4";
    public static final String ZRNDI2SIGINYUINTKYKKGUYBX5 = "zrndi2siginyuintkykkguybx5";
    public static final String ZRNDI2SPPINYUINTKYKKGUYBX1 = "zrndi2sppinyuintkykkguybx1";
    public static final String ZRNDI2SPPINYUINTKYKKGUYBX2 = "zrndi2sppinyuintkykkguybx2";
    public static final String ZRNDI2SPPINYUINTKYKKGUYBX3 = "zrndi2sppinyuintkykkguybx3";
    public static final String ZRNDI2SPPINYUINTKYKKGUYBX4 = "zrndi2sppinyuintkykkguybx4";
    public static final String ZRNDI2SPPINYUINTKYKKGUYBX5 = "zrndi2sppinyuintkykkguybx5";
    public static final String ZRNDI2SIJNBYUTKYKKGUYBX1 = "zrndi2sijnbyutkykkguybx1";
    public static final String ZRNDI2SIJNBYUTKYKKGUYBX2 = "zrndi2sijnbyutkykkguybx2";
    public static final String ZRNDI2SIJNBYUTKYKKGUYBX3 = "zrndi2sijnbyutkykkguybx3";
    public static final String ZRNDI2SIJNBYUTKYKKGUYBX4 = "zrndi2sijnbyutkykkguybx4";
    public static final String ZRNDI2SIJNBYUTKYKKGUYBX5 = "zrndi2sijnbyutkykkguybx5";
    public static final String ZRNDAI2TUINTKYKKGUYOBIX1 = "zrndai2tuintkykkguyobix1";
    public static final String ZRNDAI2TUINTKYKKGUYOBIX2 = "zrndai2tuintkykkguyobix2";
    public static final String ZRNDAI2TUINTKYKKGUYOBIX3 = "zrndai2tuintkykkguyobix3";
    public static final String ZRNDAI2TUINTKYKKGUYOBIX4 = "zrndai2tuintkykkguyobix4";
    public static final String ZRNDAI2TUINTKYKKGUYOBIX5 = "zrndai2tuintkykkguyobix5";
    public static final String ZRNDI2JYSISPPITKYKKGUYBX1 = "zrndi2jysisppitkykkguybx1";
    public static final String ZRNDI2JYSISPPITKYKKGUYBX2 = "zrndi2jysisppitkykkguybx2";
    public static final String ZRNDI2JYSISPPITKYKKGUYBX3 = "zrndi2jysisppitkykkguybx3";
    public static final String ZRNDI2JYSISPPITKYKKGUYBX4 = "zrndi2jysisppitkykkguybx4";
    public static final String ZRNDI2JYSISPPITKYKKGUYBX5 = "zrndi2jysisppitkykkguybx5";
    public static final String ZRNDI2SUGUSNSYUTKYKKGUYBX1 = "zrndi2sugusnsyutkykkguybx1";
    public static final String ZRNDI2SUGUSNSYUTKYKKGUYBX2 = "zrndi2sugusnsyutkykkguybx2";
    public static final String ZRNDI2SUGUSNSYUTKYKKGUYBX3 = "zrndi2sugusnsyutkykkguybx3";
    public static final String ZRNDI2SUGUSNSYUTKYKKGUYBX4 = "zrndi2sugusnsyutkykkguybx4";
    public static final String ZRNDI2SUGUSNSYUTKYKKGUYBX5 = "zrndi2sugusnsyutkykkguybx5";
    public static final String ZRNDI2SYKKYUHTKYKKGUYBX1 = "zrndi2sykkyuhtkykkguybx1";
    public static final String ZRNDI2SYKKYUHTKYKKGUYBX2 = "zrndi2sykkyuhtkykkguybx2";
    public static final String ZRNDI2SYKKYUHTKYKKGUYBX3 = "zrndi2sykkyuhtkykkguybx3";
    public static final String ZRNDI2SYKKYUHTKYKKGUYBX4 = "zrndi2sykkyuhtkykkguybx4";
    public static final String ZRNDI2SYKKYUHTKYKKGUYBX5 = "zrndi2sykkyuhtkykkguybx5";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X1 = "zrnsetaitehknsyuruiyobi1x1";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X2 = "zrnsetaitehknsyuruiyobi1x2";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X3 = "zrnsetaitehknsyuruiyobi1x3";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X4 = "zrnsetaitehknsyuruiyobi1x4";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X5 = "zrnsetaitehknsyuruiyobi1x5";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X6 = "zrnsetaitehknsyuruiyobi1x6";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X7 = "zrnsetaitehknsyuruiyobi1x7";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X8 = "zrnsetaitehknsyuruiyobi1x8";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X9 = "zrnsetaitehknsyuruiyobi1x9";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X10 = "zrnsetaitehknsyuruiyobi1x10";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X11 = "zrnsetaitehknsyuruiyobi1x11";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X12 = "zrnsetaitehknsyuruiyobi1x12";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X13 = "zrnsetaitehknsyuruiyobi1x13";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X14 = "zrnsetaitehknsyuruiyobi1x14";
    public static final String ZRNSETAITEHKNSYURUIYOBI1X15 = "zrnsetaitehknsyuruiyobi1x15";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X1 = "zrnsetaitehknsyuruiyobi2x1";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X2 = "zrnsetaitehknsyuruiyobi2x2";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X3 = "zrnsetaitehknsyuruiyobi2x3";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X4 = "zrnsetaitehknsyuruiyobi2x4";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X5 = "zrnsetaitehknsyuruiyobi2x5";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X6 = "zrnsetaitehknsyuruiyobi2x6";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X7 = "zrnsetaitehknsyuruiyobi2x7";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X8 = "zrnsetaitehknsyuruiyobi2x8";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X9 = "zrnsetaitehknsyuruiyobi2x9";
    public static final String ZRNSETAITEHKNSYURUIYOBI2X10 = "zrnsetaitehknsyuruiyobi2x10";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X1 = "zrnsetaitehknsyuruiyobi3x1";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X2 = "zrnsetaitehknsyuruiyobi3x2";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X3 = "zrnsetaitehknsyuruiyobi3x3";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X4 = "zrnsetaitehknsyuruiyobi3x4";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X5 = "zrnsetaitehknsyuruiyobi3x5";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X6 = "zrnsetaitehknsyuruiyobi3x6";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X7 = "zrnsetaitehknsyuruiyobi3x7";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X8 = "zrnsetaitehknsyuruiyobi3x8";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X9 = "zrnsetaitehknsyuruiyobi3x9";
    public static final String ZRNSETAITEHKNSYURUIYOBI3X10 = "zrnsetaitehknsyuruiyobi3x10";

    private final PKZT_Sp2RnduyuSouseiritu3Rn primaryKey;

    public GenZT_Sp2RnduyuSouseiritu3Rn() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu3Rn();
    }

    public GenZT_Sp2RnduyuSouseiritu3Rn(String pZrnktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu3Rn(pZrnktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu3Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu3Rn> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu3Rn.class;
    }

    private String zrnktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKTGYSYRYMD)
    public String getZrnktgysyrymd() {
        return zrnktgysyrymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnktgysyrymd(String pZrnktgysyrymd) {
        zrnktgysyrymd = pZrnktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKTGYSYONO)
    public String getZrnktgysyono() {
        return getPrimaryKey().getZrnktgysyono();
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnktgysyono(String pZrnktgysyono) {
        getPrimaryKey().setZrnktgysyono(pZrnktgysyono);
    }

    private String zrnktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKTGYFILERENNO)
    public String getZrnktgyfilerenno() {
        return zrnktgyfilerenno;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnktgyfilerenno(String pZrnktgyfilerenno) {
        zrnktgyfilerenno = pZrnktgyfilerenno;
    }

    private String zrnbosyuukeirokbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBOSYUUKEIROKBN)
    public String getZrnbosyuukeirokbn() {
        return zrnbosyuukeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbosyuukeirokbn(String pZrnbosyuukeirokbn) {
        zrnbosyuukeirokbn = pZrnbosyuukeirokbn;
    }

    private String zrnsyokaipcashlessnyukinhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYOKAIPCASHLESSNYUKINHYJ)
    public String getZrnsyokaipcashlessnyukinhyj() {
        return zrnsyokaipcashlessnyukinhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyokaipcashlessnyukinhyj(String pZrnsyokaipcashlessnyukinhyj) {
        zrnsyokaipcashlessnyukinhyj = pZrnsyokaipcashlessnyukinhyj;
    }

    private String zrnkigkyhsitihsyutkykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGKYHSITIHSYUTKYKARIHYJ)
    public String getZrnkigkyhsitihsyutkykarihyj() {
        return zrnkigkyhsitihsyutkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigkyhsitihsyutkykarihyj(String pZrnkigkyhsitihsyutkykarihyj) {
        zrnkigkyhsitihsyutkykarihyj = pZrnkigkyhsitihsyutkykarihyj;
    }

    private String zrnsyokaipswingriyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYOKAIPSWINGRIYOUKBN)
    public String getZrnsyokaipswingriyoukbn() {
        return zrnsyokaipswingriyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyokaipswingriyoukbn(String pZrnsyokaipswingriyoukbn) {
        zrnsyokaipswingriyoukbn = pZrnsyokaipswingriyoukbn;
    }

    private String zrnsknjyututkykkykkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSKNJYUTUTKYKKYKKBN)
    public String getZrnsknjyututkykkykkbn() {
        return zrnsknjyututkykkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsknjyututkykkykkbn(String pZrnsknjyututkykkykkbn) {
        zrnsknjyututkykkykkbn = pZrnsknjyututkykkykkbn;
    }

    private String zrnbosyuudairitengyousyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBOSYUUDAIRITENGYOUSYUKBN)
    public String getZrnbosyuudairitengyousyukbn() {
        return zrnbosyuudairitengyousyukbn;
    }

    public void setZrnbosyuudairitengyousyukbn(String pZrnbosyuudairitengyousyukbn) {
        zrnbosyuudairitengyousyukbn = pZrnbosyuudairitengyousyukbn;
    }

    private String zrncifcd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrntokusyujimutoriatukaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTOKUSYUJIMUTORIATUKAIKBN)
    public String getZrntokusyujimutoriatukaikbn() {
        return zrntokusyujimutoriatukaikbn;
    }

    public void setZrntokusyujimutoriatukaikbn(String pZrntokusyujimutoriatukaikbn) {
        zrntokusyujimutoriatukaikbn = pZrntokusyujimutoriatukaikbn;
    }

    private String zrnpmentkykyutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNPMENTKYKYUTKTBICDX1)
    public String getZrnpmentkykyutktbicdx1() {
        return zrnpmentkykyutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmentkykyutktbicdx1(String pZrnpmentkykyutktbicdx1) {
        zrnpmentkykyutktbicdx1 = pZrnpmentkykyutktbicdx1;
    }

    private String zrnpmentkykyuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNPMENTKYKYUHTNPKKNX1)
    public String getZrnpmentkykyuhtnpkknx1() {
        return zrnpmentkykyuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmentkykyuhtnpkknx1(String pZrnpmentkykyuhtnpkknx1) {
        zrnpmentkykyuhtnpkknx1 = pZrnpmentkykyuhtnpkknx1;
    }

    private String zrnpmentkykyutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNPMENTKYKYUTKTBICDX2)
    public String getZrnpmentkykyutktbicdx2() {
        return zrnpmentkykyutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmentkykyutktbicdx2(String pZrnpmentkykyutktbicdx2) {
        zrnpmentkykyutktbicdx2 = pZrnpmentkykyutktbicdx2;
    }

    private String zrnpmentkykyuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNPMENTKYKYUHTNPKKNX2)
    public String getZrnpmentkykyuhtnpkknx2() {
        return zrnpmentkykyuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmentkykyuhtnpkknx2(String pZrnpmentkykyuhtnpkknx2) {
        zrnpmentkykyuhtnpkknx2 = pZrnpmentkykyuhtnpkknx2;
    }

    private String zrnhosyouikkatumnoshyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOSYOUIKKATUMNOSHYOUJI)
    public String getZrnhosyouikkatumnoshyouji() {
        return zrnhosyouikkatumnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyouikkatumnoshyouji(String pZrnhosyouikkatumnoshyouji) {
        zrnhosyouikkatumnoshyouji = pZrnhosyouikkatumnoshyouji;
    }

    private String zrnhsyuikktminaosikaisu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHSYUIKKTMINAOSIKAISU)
    public String getZrnhsyuikktminaosikaisu() {
        return zrnhsyuikktminaosikaisu;
    }

    public void setZrnhsyuikktminaosikaisu(String pZrnhsyuikktminaosikaisu) {
        zrnhsyuikktminaosikaisu = pZrnhsyuikktminaosikaisu;
    }

    private String zrnhsyuikktmnosdfnyuknhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHSYUIKKTMNOSDFNYUKNHYJ)
    public String getZrnhsyuikktmnosdfnyuknhyj() {
        return zrnhsyuikktmnosdfnyuknhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhsyuikktmnosdfnyuknhyj(String pZrnhsyuikktmnosdfnyuknhyj) {
        zrnhsyuikktmnosdfnyuknhyj = pZrnhsyuikktmnosdfnyuknhyj;
    }

    private Long zrnikktmnoskikiyutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNIKKTMNOSKIKIYUTKYKP)
    public Long getZrnikktmnoskikiyutkykp() {
        return zrnikktmnoskikiyutkykp;
    }

    public void setZrnikktmnoskikiyutkykp(Long pZrnikktmnoskikiyutkykp) {
        zrnikktmnoskikiyutkykp = pZrnikktmnoskikiyutkykp;
    }

    private Long zrnikktmnoskikiyufndsistp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNIKKTMNOSKIKIYUFNDSISTP)
    public Long getZrnikktmnoskikiyufndsistp() {
        return zrnikktmnoskikiyufndsistp;
    }

    public void setZrnikktmnoskikiyufndsistp(Long pZrnikktmnoskikiyufndsistp) {
        zrnikktmnoskikiyufndsistp = pZrnikktmnoskikiyufndsistp;
    }

    private BizNumber zrnsknnjynbknsisnrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSKNNJYNBKNSISNRT)
    public BizNumber getZrnsknnjynbknsisnrt() {
        return zrnsknnjynbknsisnrt;
    }

    public void setZrnsknnjynbknsisnrt(BizNumber pZrnsknnjynbknsisnrt) {
        zrnsknnjynbknsisnrt = pZrnsknnjynbknsisnrt;
    }

    private String zrnkanyujisyono;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKANYUJISYONO)
    public String getZrnkanyujisyono() {
        return zrnkanyujisyono;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnkanyujisyono(String pZrnkanyujisyono) {
        zrnkanyujisyono = pZrnkanyujisyono;
    }

    private String zrnkanyujikykymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKANYUJIKYKYMD)
    public String getZrnkanyujikykymd() {
        return zrnkanyujikykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkanyujikykymd(String pZrnkanyujikykymd) {
        zrnkanyujikykymd = pZrnkanyujikykymd;
    }

    private String zrnkanyuujihihokensyaage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKANYUUJIHIHOKENSYAAGE)
    public String getZrnkanyuujihihokensyaage() {
        return zrnkanyuujihihokensyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkanyuujihihokensyaage(String pZrnkanyuujihihokensyaage) {
        zrnkanyuujihihokensyaage = pZrnkanyuujihihokensyaage;
    }

    private String zrnkanyuujitenkanhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKANYUUJITENKANHYOUJI)
    public String getZrnkanyuujitenkanhyouji() {
        return zrnkanyuujitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkanyuujitenkanhyouji(String pZrnkanyuujitenkanhyouji) {
        zrnkanyuujitenkanhyouji = pZrnkanyuujitenkanhyouji;
    }

    private String zrnksnyuhsyuikktminosnnskbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKSNYUHSYUIKKTMINOSNNSKBN)
    public String getZrnksnyuhsyuikktminosnnskbn() {
        return zrnksnyuhsyuikktminosnnskbn;
    }

    public void setZrnksnyuhsyuikktminosnnskbn(String pZrnksnyuhsyuikktminosnnskbn) {
        zrnksnyuhsyuikktminosnnskbn = pZrnksnyuhsyuikktminosnnskbn;
    }

    private String zrnaatukaisyadirtnbsynnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNAATUKAISYADIRTNBSYNNHYJ)
    public String getZrnaatukaisyadirtnbsynnhyj() {
        return zrnaatukaisyadirtnbsynnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnaatukaisyadirtnbsynnhyj(String pZrnaatukaisyadirtnbsynnhyj) {
        zrnaatukaisyadirtnbsynnhyj = pZrnaatukaisyadirtnbsynnhyj;
    }

    private String zrnbatkisyadirtnbosyuninhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBATKISYADIRTNBOSYUNINHYJ)
    public String getZrnbatkisyadirtnbosyuninhyj() {
        return zrnbatkisyadirtnbosyuninhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbatkisyadirtnbosyuninhyj(String pZrnbatkisyadirtnbosyuninhyj) {
        zrnbatkisyadirtnbosyuninhyj = pZrnbatkisyadirtnbosyuninhyj;
    }

    private String zrndirtnaatukaisyakojincd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDIRTNAATUKAISYAKOJINCD)
    public String getZrndirtnaatukaisyakojincd() {
        return zrndirtnaatukaisyakojincd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndirtnaatukaisyakojincd(String pZrndirtnaatukaisyakojincd) {
        zrndirtnaatukaisyakojincd = pZrndirtnaatukaisyakojincd;
    }

    private String zrndirtnbatukaisyakojincd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDIRTNBATUKAISYAKOJINCD)
    public String getZrndirtnbatukaisyakojincd() {
        return zrndirtnbatukaisyakojincd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndirtnbatukaisyakojincd(String pZrndirtnbatukaisyakojincd) {
        zrndirtnbatukaisyakojincd = pZrndirtnbatukaisyakojincd;
    }

    private String zrnsyuuseisyoukeikanensuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYUUSEISYOUKEIKANENSUU)
    public String getZrnsyuuseisyoukeikanensuu() {
        return zrnsyuuseisyoukeikanensuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuuseisyoukeikanensuu(String pZrnsyuuseisyoukeikanensuu) {
        zrnsyuuseisyoukeikanensuu = pZrnsyuuseisyoukeikanensuu;
    }

    private String zrnsyuruihnkutkbttrtkhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYURUIHNKUTKBTTRTKHYJ)
    public String getZrnsyuruihnkutkbttrtkhyj() {
        return zrnsyuruihnkutkbttrtkhyj;
    }

    public void setZrnsyuruihnkutkbttrtkhyj(String pZrnsyuruihnkutkbttrtkhyj) {
        zrnsyuruihnkutkbttrtkhyj = pZrnsyuruihnkutkbttrtkhyj;
    }

    private String zrnbnktmekyktkykhkjyutikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKTKYKHKJYUTIKBN)
    public String getZrnbnktmekyktkykhkjyutikbn() {
        return zrnbnktmekyktkykhkjyutikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbnktmekyktkykhkjyutikbn(String pZrnbnktmekyktkykhkjyutikbn) {
        zrnbnktmekyktkykhkjyutikbn = pZrnbnktmekyktkykhkjyutikbn;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrntnknsyokaipclessriyouhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTNKNSYOKAIPCLESSRIYOUHYJ)
    public String getZrntnknsyokaipclessriyouhyj() {
        return zrntnknsyokaipclessriyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknsyokaipclessriyouhyj(String pZrntnknsyokaipclessriyouhyj) {
        zrntnknsyokaipclessriyouhyj = pZrntnknsyokaipclessriyouhyj;
    }

    private String zrnhrkteisikibouhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHRKTEISIKIBOUHYOUJI)
    public String getZrnhrkteisikibouhyouji() {
        return zrnhrkteisikibouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhrkteisikibouhyouji(String pZrnhrkteisikibouhyouji) {
        zrnhrkteisikibouhyouji = pZrnhrkteisikibouhyouji;
    }

    private Long zrnbunkatugosonzokukeiyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBUNKATUGOSONZOKUKEIYAKUS)
    public Long getZrnbunkatugosonzokukeiyakus() {
        return zrnbunkatugosonzokukeiyakus;
    }

    public void setZrnbunkatugosonzokukeiyakus(Long pZrnbunkatugosonzokukeiyakus) {
        zrnbunkatugosonzokukeiyakus = pZrnbunkatugosonzokukeiyakus;
    }

    private Long zrnmoskizkphrkekngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMOSKIZKPHRKEKNGK)
    public Long getZrnmoskizkphrkekngk() {
        return zrnmoskizkphrkekngk;
    }

    public void setZrnmoskizkphrkekngk(Long pZrnmoskizkphrkekngk) {
        zrnmoskizkphrkekngk = pZrnmoskizkphrkekngk;
    }

    private Long zrnkeizokuphurikaejijikaip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKEIZOKUPHURIKAEJIJIKAIP)
    public Long getZrnkeizokuphurikaejijikaip() {
        return zrnkeizokuphurikaejijikaip;
    }

    public void setZrnkeizokuphurikaejijikaip(Long pZrnkeizokuphurikaejijikaip) {
        zrnkeizokuphurikaejijikaip = pZrnkeizokuphurikaejijikaip;
    }

    private String zrnbnktmekyksyono;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKSYONO)
    public String getZrnbnktmekyksyono() {
        return zrnbnktmekyksyono;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnbnktmekyksyono(String pZrnbnktmekyksyono) {
        zrnbnktmekyksyono = pZrnbnktmekyksyono;
    }

    private Long zrnbunkatumaekeiyakukihons;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBUNKATUMAEKEIYAKUKIHONS)
    public Long getZrnbunkatumaekeiyakukihons() {
        return zrnbunkatumaekeiyakukihons;
    }

    public void setZrnbunkatumaekeiyakukihons(Long pZrnbunkatumaekeiyakukihons) {
        zrnbunkatumaekeiyakukihons = pZrnbunkatumaekeiyakukihons;
    }

    private Long zrnbunkatumaekeiyakusibous;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBUNKATUMAEKEIYAKUSIBOUS)
    public Long getZrnbunkatumaekeiyakusibous() {
        return zrnbunkatumaekeiyakusibous;
    }

    public void setZrnbunkatumaekeiyakusibous(Long pZrnbunkatumaekeiyakusibous) {
        zrnbunkatumaekeiyakusibous = pZrnbunkatumaekeiyakusibous;
    }

    private Long zrnbnktmekykmods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKMODS)
    public Long getZrnbnktmekykmods() {
        return zrnbnktmekykmods;
    }

    public void setZrnbnktmekykmods(Long pZrnbnktmekykmods) {
        zrnbnktmekykmods = pZrnbnktmekykmods;
    }

    private Long zrnbnktmekyksigiwrmstkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKSIGIWRMSTKYKS)
    public Long getZrnbnktmekyksigiwrmstkyks() {
        return zrnbnktmekyksigiwrmstkyks;
    }

    public void setZrnbnktmekyksigiwrmstkyks(Long pZrnbnktmekyksigiwrmstkyks) {
        zrnbnktmekyksigiwrmstkyks = pZrnbnktmekyksigiwrmstkyks;
    }

    private Long zrnbnktmekyksyugitkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKSYUGITKYKS)
    public Long getZrnbnktmekyksyugitkyks() {
        return zrnbnktmekyksyugitkyks;
    }

    public void setZrnbnktmekyksyugitkyks(Long pZrnbnktmekyksyugitkyks) {
        zrnbnktmekyksyugitkyks = pZrnbnktmekyksyugitkyks;
    }

    private Integer zrnbnktmkyksiginyintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMKYKSIGINYINTKYKNTGK)
    public Integer getZrnbnktmkyksiginyintkykntgk() {
        return zrnbnktmkyksiginyintkykntgk;
    }

    public void setZrnbnktmkyksiginyintkykntgk(Integer pZrnbnktmkyksiginyintkykntgk) {
        zrnbnktmkyksiginyintkykntgk = pZrnbnktmkyksiginyintkykntgk;
    }

    private Integer zrnbnktmekykknkutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKKNKUTKYKNTGK)
    public Integer getZrnbnktmekykknkutkykntgk() {
        return zrnbnktmekykknkutkykntgk;
    }

    public void setZrnbnktmekykknkutkykntgk(Integer pZrnbnktmekykknkutkykntgk) {
        zrnbnktmekykknkutkykntgk = pZrnbnktmekykknkutkykntgk;
    }

    private Long zrnbnktmekykhntiyunbriknsnp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKHNTIYUNBRIKNSNP)
    public Long getZrnbnktmekykhntiyunbriknsnp() {
        return zrnbnktmekykhntiyunbriknsnp;
    }

    public void setZrnbnktmekykhntiyunbriknsnp(Long pZrnbnktmekykhntiyunbriknsnp) {
        zrnbnktmekykhntiyunbriknsnp = pZrnbnktmekykhntiyunbriknsnp;
    }

    private Long zrndai2naibuwarimodosigaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDAI2NAIBUWARIMODOSIGAKU)
    public Long getZrndai2naibuwarimodosigaku() {
        return zrndai2naibuwarimodosigaku;
    }

    public void setZrndai2naibuwarimodosigaku(Long pZrndai2naibuwarimodosigaku) {
        zrndai2naibuwarimodosigaku = pZrndai2naibuwarimodosigaku;
    }

    private Long zrntnkngkykkstkgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTNKNGKYKKSTKGK)
    public Long getZrntnkngkykkstkgk() {
        return zrntnkngkykkstkgk;
    }

    public void setZrntnkngkykkstkgk(Long pZrntnkngkykkstkgk) {
        zrntnkngkykkstkgk = pZrntnkngkykkstkgk;
    }

    private Long zrnbnktmekykkstkgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNBNKTMEKYKKSTKGK)
    public Long getZrnbnktmekykkstkgk() {
        return zrnbnktmekykkstkgk;
    }

    public void setZrnbnktmekykkstkgk(Long pZrnbnktmekykkstkgk) {
        zrnbnktmekykkstkgk = pZrnbnktmekykkstkgk;
    }

    private Long zrnsonzokukykkasitukegk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSONZOKUKYKKASITUKEGK)
    public Long getZrnsonzokukykkasitukegk() {
        return zrnsonzokukykkasitukegk;
    }

    public void setZrnsonzokukykkasitukegk(Long pZrnsonzokukykkasitukegk) {
        zrnsonzokukykkasitukegk = pZrnsonzokukykkasitukegk;
    }

    private Long zrnhngkmnryoujsitihsyukngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHNGKMNRYOUJSITIHSYUKNGK)
    public Long getZrnhngkmnryoujsitihsyukngk() {
        return zrnhngkmnryoujsitihsyukngk;
    }

    public void setZrnhngkmnryoujsitihsyukngk(Long pZrnhngkmnryoujsitihsyukngk) {
        zrnhngkmnryoujsitihsyukngk = pZrnhngkmnryoujsitihsyukngk;
    }

    private Long zrnhngksitihsyuyusykykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHNGKSITIHSYUYUSYKYKP)
    public Long getZrnhngksitihsyuyusykykp() {
        return zrnhngksitihsyuyusykykp;
    }

    public void setZrnhngksitihsyuyusykykp(Long pZrnhngksitihsyuyusykykp) {
        zrnhngksitihsyuyusykykp = pZrnhngksitihsyuyusykykp;
    }

    private String zrnhtnknkigmrsyukguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX1X1)
    public String getZrnhtnknkigmrsyukguybx1x1() {
        return zrnhtnknkigmrsyukguybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx1x1(String pZrnhtnknkigmrsyukguybx1x1) {
        zrnhtnknkigmrsyukguybx1x1 = pZrnhtnknkigmrsyukguybx1x1;
    }

    private String zrnhtnknkigmrsyukguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX2X1)
    public String getZrnhtnknkigmrsyukguybx2x1() {
        return zrnhtnknkigmrsyukguybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx2x1(String pZrnhtnknkigmrsyukguybx2x1) {
        zrnhtnknkigmrsyukguybx2x1 = pZrnhtnknkigmrsyukguybx2x1;
    }

    private String zrnhtnknkigmrsyukguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX3X1)
    public String getZrnhtnknkigmrsyukguybx3x1() {
        return zrnhtnknkigmrsyukguybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx3x1(String pZrnhtnknkigmrsyukguybx3x1) {
        zrnhtnknkigmrsyukguybx3x1 = pZrnhtnknkigmrsyukguybx3x1;
    }

    private String zrnhtnknkigmrsyukguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX4X1)
    public String getZrnhtnknkigmrsyukguybx4x1() {
        return zrnhtnknkigmrsyukguybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx4x1(String pZrnhtnknkigmrsyukguybx4x1) {
        zrnhtnknkigmrsyukguybx4x1 = pZrnhtnknkigmrsyukguybx4x1;
    }

    private String zrnhtnknkigmrsyukguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX5X1)
    public String getZrnhtnknkigmrsyukguybx5x1() {
        return zrnhtnknkigmrsyukguybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx5x1(String pZrnhtnknkigmrsyukguybx5x1) {
        zrnhtnknkigmrsyukguybx5x1 = pZrnhtnknkigmrsyukguybx5x1;
    }

    private String zrnhtnknkigmrsyukguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX1X2)
    public String getZrnhtnknkigmrsyukguybx1x2() {
        return zrnhtnknkigmrsyukguybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx1x2(String pZrnhtnknkigmrsyukguybx1x2) {
        zrnhtnknkigmrsyukguybx1x2 = pZrnhtnknkigmrsyukguybx1x2;
    }

    private String zrnhtnknkigmrsyukguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX2X2)
    public String getZrnhtnknkigmrsyukguybx2x2() {
        return zrnhtnknkigmrsyukguybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx2x2(String pZrnhtnknkigmrsyukguybx2x2) {
        zrnhtnknkigmrsyukguybx2x2 = pZrnhtnknkigmrsyukguybx2x2;
    }

    private String zrnhtnknkigmrsyukguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX3X2)
    public String getZrnhtnknkigmrsyukguybx3x2() {
        return zrnhtnknkigmrsyukguybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx3x2(String pZrnhtnknkigmrsyukguybx3x2) {
        zrnhtnknkigmrsyukguybx3x2 = pZrnhtnknkigmrsyukguybx3x2;
    }

    private String zrnhtnknkigmrsyukguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX4X2)
    public String getZrnhtnknkigmrsyukguybx4x2() {
        return zrnhtnknkigmrsyukguybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx4x2(String pZrnhtnknkigmrsyukguybx4x2) {
        zrnhtnknkigmrsyukguybx4x2 = pZrnhtnknkigmrsyukguybx4x2;
    }

    private String zrnhtnknkigmrsyukguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX5X2)
    public String getZrnhtnknkigmrsyukguybx5x2() {
        return zrnhtnknkigmrsyukguybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx5x2(String pZrnhtnknkigmrsyukguybx5x2) {
        zrnhtnknkigmrsyukguybx5x2 = pZrnhtnknkigmrsyukguybx5x2;
    }

    private String zrnhtnknkigmrsyukguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX1X3)
    public String getZrnhtnknkigmrsyukguybx1x3() {
        return zrnhtnknkigmrsyukguybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx1x3(String pZrnhtnknkigmrsyukguybx1x3) {
        zrnhtnknkigmrsyukguybx1x3 = pZrnhtnknkigmrsyukguybx1x3;
    }

    private String zrnhtnknkigmrsyukguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX2X3)
    public String getZrnhtnknkigmrsyukguybx2x3() {
        return zrnhtnknkigmrsyukguybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx2x3(String pZrnhtnknkigmrsyukguybx2x3) {
        zrnhtnknkigmrsyukguybx2x3 = pZrnhtnknkigmrsyukguybx2x3;
    }

    private String zrnhtnknkigmrsyukguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX3X3)
    public String getZrnhtnknkigmrsyukguybx3x3() {
        return zrnhtnknkigmrsyukguybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx3x3(String pZrnhtnknkigmrsyukguybx3x3) {
        zrnhtnknkigmrsyukguybx3x3 = pZrnhtnknkigmrsyukguybx3x3;
    }

    private String zrnhtnknkigmrsyukguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX4X3)
    public String getZrnhtnknkigmrsyukguybx4x3() {
        return zrnhtnknkigmrsyukguybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx4x3(String pZrnhtnknkigmrsyukguybx4x3) {
        zrnhtnknkigmrsyukguybx4x3 = pZrnhtnknkigmrsyukguybx4x3;
    }

    private String zrnhtnknkigmrsyukguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX5X3)
    public String getZrnhtnknkigmrsyukguybx5x3() {
        return zrnhtnknkigmrsyukguybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx5x3(String pZrnhtnknkigmrsyukguybx5x3) {
        zrnhtnknkigmrsyukguybx5x3 = pZrnhtnknkigmrsyukguybx5x3;
    }

    private String zrnhtnknkigmrsyukguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX1X4)
    public String getZrnhtnknkigmrsyukguybx1x4() {
        return zrnhtnknkigmrsyukguybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx1x4(String pZrnhtnknkigmrsyukguybx1x4) {
        zrnhtnknkigmrsyukguybx1x4 = pZrnhtnknkigmrsyukguybx1x4;
    }

    private String zrnhtnknkigmrsyukguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX2X4)
    public String getZrnhtnknkigmrsyukguybx2x4() {
        return zrnhtnknkigmrsyukguybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx2x4(String pZrnhtnknkigmrsyukguybx2x4) {
        zrnhtnknkigmrsyukguybx2x4 = pZrnhtnknkigmrsyukguybx2x4;
    }

    private String zrnhtnknkigmrsyukguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX3X4)
    public String getZrnhtnknkigmrsyukguybx3x4() {
        return zrnhtnknkigmrsyukguybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx3x4(String pZrnhtnknkigmrsyukguybx3x4) {
        zrnhtnknkigmrsyukguybx3x4 = pZrnhtnknkigmrsyukguybx3x4;
    }

    private String zrnhtnknkigmrsyukguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX4X4)
    public String getZrnhtnknkigmrsyukguybx4x4() {
        return zrnhtnknkigmrsyukguybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx4x4(String pZrnhtnknkigmrsyukguybx4x4) {
        zrnhtnknkigmrsyukguybx4x4 = pZrnhtnknkigmrsyukguybx4x4;
    }

    private String zrnhtnknkigmrsyukguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX5X4)
    public String getZrnhtnknkigmrsyukguybx5x4() {
        return zrnhtnknkigmrsyukguybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx5x4(String pZrnhtnknkigmrsyukguybx5x4) {
        zrnhtnknkigmrsyukguybx5x4 = pZrnhtnknkigmrsyukguybx5x4;
    }

    private String zrnhtnknkigmrsyukguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX1X5)
    public String getZrnhtnknkigmrsyukguybx1x5() {
        return zrnhtnknkigmrsyukguybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx1x5(String pZrnhtnknkigmrsyukguybx1x5) {
        zrnhtnknkigmrsyukguybx1x5 = pZrnhtnknkigmrsyukguybx1x5;
    }

    private String zrnhtnknkigmrsyukguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX2X5)
    public String getZrnhtnknkigmrsyukguybx2x5() {
        return zrnhtnknkigmrsyukguybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx2x5(String pZrnhtnknkigmrsyukguybx2x5) {
        zrnhtnknkigmrsyukguybx2x5 = pZrnhtnknkigmrsyukguybx2x5;
    }

    private String zrnhtnknkigmrsyukguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX3X5)
    public String getZrnhtnknkigmrsyukguybx3x5() {
        return zrnhtnknkigmrsyukguybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx3x5(String pZrnhtnknkigmrsyukguybx3x5) {
        zrnhtnknkigmrsyukguybx3x5 = pZrnhtnknkigmrsyukguybx3x5;
    }

    private String zrnhtnknkigmrsyukguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX4X5)
    public String getZrnhtnknkigmrsyukguybx4x5() {
        return zrnhtnknkigmrsyukguybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx4x5(String pZrnhtnknkigmrsyukguybx4x5) {
        zrnhtnknkigmrsyukguybx4x5 = pZrnhtnknkigmrsyukguybx4x5;
    }

    private String zrnhtnknkigmrsyukguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX5X5)
    public String getZrnhtnknkigmrsyukguybx5x5() {
        return zrnhtnknkigmrsyukguybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx5x5(String pZrnhtnknkigmrsyukguybx5x5) {
        zrnhtnknkigmrsyukguybx5x5 = pZrnhtnknkigmrsyukguybx5x5;
    }

    private String zrnhtnknkigmrsyukguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX1X6)
    public String getZrnhtnknkigmrsyukguybx1x6() {
        return zrnhtnknkigmrsyukguybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx1x6(String pZrnhtnknkigmrsyukguybx1x6) {
        zrnhtnknkigmrsyukguybx1x6 = pZrnhtnknkigmrsyukguybx1x6;
    }

    private String zrnhtnknkigmrsyukguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX2X6)
    public String getZrnhtnknkigmrsyukguybx2x6() {
        return zrnhtnknkigmrsyukguybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx2x6(String pZrnhtnknkigmrsyukguybx2x6) {
        zrnhtnknkigmrsyukguybx2x6 = pZrnhtnknkigmrsyukguybx2x6;
    }

    private String zrnhtnknkigmrsyukguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX3X6)
    public String getZrnhtnknkigmrsyukguybx3x6() {
        return zrnhtnknkigmrsyukguybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx3x6(String pZrnhtnknkigmrsyukguybx3x6) {
        zrnhtnknkigmrsyukguybx3x6 = pZrnhtnknkigmrsyukguybx3x6;
    }

    private String zrnhtnknkigmrsyukguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX4X6)
    public String getZrnhtnknkigmrsyukguybx4x6() {
        return zrnhtnknkigmrsyukguybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx4x6(String pZrnhtnknkigmrsyukguybx4x6) {
        zrnhtnknkigmrsyukguybx4x6 = pZrnhtnknkigmrsyukguybx4x6;
    }

    private String zrnhtnknkigmrsyukguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHTNKNKIGMRSYUKGUYBX5X6)
    public String getZrnhtnknkigmrsyukguybx5x6() {
        return zrnhtnknkigmrsyukguybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkigmrsyukguybx5x6(String pZrnhtnknkigmrsyukguybx5x6) {
        zrnhtnknkigmrsyukguybx5x6 = pZrnhtnknkigmrsyukguybx5x6;
    }

    private String zrnyobiv1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNYOBIV1X3)
    public String getZrnyobiv1x3() {
        return zrnyobiv1x3;
    }

    public void setZrnyobiv1x3(String pZrnyobiv1x3) {
        zrnyobiv1x3 = pZrnyobiv1x3;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrnmaruteikigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUTEIKIGOUYOBIX1)
    public String getZrnmaruteikigouyobix1() {
        return zrnmaruteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix1(String pZrnmaruteikigouyobix1) {
        zrnmaruteikigouyobix1 = pZrnmaruteikigouyobix1;
    }

    private String zrnmaruteikigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUTEIKIGOUYOBIX2)
    public String getZrnmaruteikigouyobix2() {
        return zrnmaruteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix2(String pZrnmaruteikigouyobix2) {
        zrnmaruteikigouyobix2 = pZrnmaruteikigouyobix2;
    }

    private String zrnmaruteikigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUTEIKIGOUYOBIX3)
    public String getZrnmaruteikigouyobix3() {
        return zrnmaruteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix3(String pZrnmaruteikigouyobix3) {
        zrnmaruteikigouyobix3 = pZrnmaruteikigouyobix3;
    }

    private String zrnmaruteikigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUTEIKIGOUYOBIX4)
    public String getZrnmaruteikigouyobix4() {
        return zrnmaruteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix4(String pZrnmaruteikigouyobix4) {
        zrnmaruteikigouyobix4 = pZrnmaruteikigouyobix4;
    }

    private String zrnmaruteikigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUTEIKIGOUYOBIX5)
    public String getZrnmaruteikigouyobix5() {
        return zrnmaruteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix5(String pZrnmaruteikigouyobix5) {
        zrnmaruteikigouyobix5 = pZrnmaruteikigouyobix5;
    }

    private String zrnmaruyoukigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUYOUKIGOUYOBIX1)
    public String getZrnmaruyoukigouyobix1() {
        return zrnmaruyoukigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyoukigouyobix1(String pZrnmaruyoukigouyobix1) {
        zrnmaruyoukigouyobix1 = pZrnmaruyoukigouyobix1;
    }

    private String zrnmaruyoukigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUYOUKIGOUYOBIX2)
    public String getZrnmaruyoukigouyobix2() {
        return zrnmaruyoukigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyoukigouyobix2(String pZrnmaruyoukigouyobix2) {
        zrnmaruyoukigouyobix2 = pZrnmaruyoukigouyobix2;
    }

    private String zrnmaruyoukigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUYOUKIGOUYOBIX3)
    public String getZrnmaruyoukigouyobix3() {
        return zrnmaruyoukigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyoukigouyobix3(String pZrnmaruyoukigouyobix3) {
        zrnmaruyoukigouyobix3 = pZrnmaruyoukigouyobix3;
    }

    private String zrnmaruyoukigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUYOUKIGOUYOBIX4)
    public String getZrnmaruyoukigouyobix4() {
        return zrnmaruyoukigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyoukigouyobix4(String pZrnmaruyoukigouyobix4) {
        zrnmaruyoukigouyobix4 = pZrnmaruyoukigouyobix4;
    }

    private String zrnmaruyoukigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUYOUKIGOUYOBIX5)
    public String getZrnmaruyoukigouyobix5() {
        return zrnmaruyoukigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyoukigouyobix5(String pZrnmaruyoukigouyobix5) {
        zrnmaruyoukigouyobix5 = pZrnmaruyoukigouyobix5;
    }

    private String zrnmarusyuukigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUSYUUKIGOUYOBIX1)
    public String getZrnmarusyuukigouyobix1() {
        return zrnmarusyuukigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuukigouyobix1(String pZrnmarusyuukigouyobix1) {
        zrnmarusyuukigouyobix1 = pZrnmarusyuukigouyobix1;
    }

    private String zrnmarusyuukigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUSYUUKIGOUYOBIX2)
    public String getZrnmarusyuukigouyobix2() {
        return zrnmarusyuukigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuukigouyobix2(String pZrnmarusyuukigouyobix2) {
        zrnmarusyuukigouyobix2 = pZrnmarusyuukigouyobix2;
    }

    private String zrnmarusyuukigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUSYUUKIGOUYOBIX3)
    public String getZrnmarusyuukigouyobix3() {
        return zrnmarusyuukigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuukigouyobix3(String pZrnmarusyuukigouyobix3) {
        zrnmarusyuukigouyobix3 = pZrnmarusyuukigouyobix3;
    }

    private String zrnmarusyuukigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUSYUUKIGOUYOBIX4)
    public String getZrnmarusyuukigouyobix4() {
        return zrnmarusyuukigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuukigouyobix4(String pZrnmarusyuukigouyobix4) {
        zrnmarusyuukigouyobix4 = pZrnmarusyuukigouyobix4;
    }

    private String zrnmarusyuukigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMARUSYUUKIGOUYOBIX5)
    public String getZrnmarusyuukigouyobix5() {
        return zrnmarusyuukigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuukigouyobix5(String pZrnmarusyuukigouyobix5) {
        zrnmarusyuukigouyobix5 = pZrnmarusyuukigouyobix5;
    }

    private String zrntokuteikigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTOKUTEIKIGOUYOBIX1)
    public String getZrntokuteikigouyobix1() {
        return zrntokuteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteikigouyobix1(String pZrntokuteikigouyobix1) {
        zrntokuteikigouyobix1 = pZrntokuteikigouyobix1;
    }

    private String zrntokuteikigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTOKUTEIKIGOUYOBIX2)
    public String getZrntokuteikigouyobix2() {
        return zrntokuteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteikigouyobix2(String pZrntokuteikigouyobix2) {
        zrntokuteikigouyobix2 = pZrntokuteikigouyobix2;
    }

    private String zrntokuteikigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTOKUTEIKIGOUYOBIX3)
    public String getZrntokuteikigouyobix3() {
        return zrntokuteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteikigouyobix3(String pZrntokuteikigouyobix3) {
        zrntokuteikigouyobix3 = pZrntokuteikigouyobix3;
    }

    private String zrntokuteikigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTOKUTEIKIGOUYOBIX4)
    public String getZrntokuteikigouyobix4() {
        return zrntokuteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteikigouyobix4(String pZrntokuteikigouyobix4) {
        zrntokuteikigouyobix4 = pZrntokuteikigouyobix4;
    }

    private String zrntokuteikigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTOKUTEIKIGOUYOBIX5)
    public String getZrntokuteikigouyobix5() {
        return zrntokuteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteikigouyobix5(String pZrntokuteikigouyobix5) {
        zrntokuteikigouyobix5 = pZrntokuteikigouyobix5;
    }

    private String zrnkzkmrtikguybx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X1)
    public String getZrnkzkmrtikguybx1x1() {
        return zrnkzkmrtikguybx1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x1(String pZrnkzkmrtikguybx1x1) {
        zrnkzkmrtikguybx1x1 = pZrnkzkmrtikguybx1x1;
    }

    private String zrnkzkmrtikguybx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X1)
    public String getZrnkzkmrtikguybx2x1() {
        return zrnkzkmrtikguybx2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x1(String pZrnkzkmrtikguybx2x1) {
        zrnkzkmrtikguybx2x1 = pZrnkzkmrtikguybx2x1;
    }

    private String zrnkzkmrtikguybx3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X1)
    public String getZrnkzkmrtikguybx3x1() {
        return zrnkzkmrtikguybx3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x1(String pZrnkzkmrtikguybx3x1) {
        zrnkzkmrtikguybx3x1 = pZrnkzkmrtikguybx3x1;
    }

    private String zrnkzkmrtikguybx4x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X1)
    public String getZrnkzkmrtikguybx4x1() {
        return zrnkzkmrtikguybx4x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x1(String pZrnkzkmrtikguybx4x1) {
        zrnkzkmrtikguybx4x1 = pZrnkzkmrtikguybx4x1;
    }

    private String zrnkzkmrtikguybx5x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X1)
    public String getZrnkzkmrtikguybx5x1() {
        return zrnkzkmrtikguybx5x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x1(String pZrnkzkmrtikguybx5x1) {
        zrnkzkmrtikguybx5x1 = pZrnkzkmrtikguybx5x1;
    }

    private String zrnkzkmrtikguybx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X2)
    public String getZrnkzkmrtikguybx1x2() {
        return zrnkzkmrtikguybx1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x2(String pZrnkzkmrtikguybx1x2) {
        zrnkzkmrtikguybx1x2 = pZrnkzkmrtikguybx1x2;
    }

    private String zrnkzkmrtikguybx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X2)
    public String getZrnkzkmrtikguybx2x2() {
        return zrnkzkmrtikguybx2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x2(String pZrnkzkmrtikguybx2x2) {
        zrnkzkmrtikguybx2x2 = pZrnkzkmrtikguybx2x2;
    }

    private String zrnkzkmrtikguybx3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X2)
    public String getZrnkzkmrtikguybx3x2() {
        return zrnkzkmrtikguybx3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x2(String pZrnkzkmrtikguybx3x2) {
        zrnkzkmrtikguybx3x2 = pZrnkzkmrtikguybx3x2;
    }

    private String zrnkzkmrtikguybx4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X2)
    public String getZrnkzkmrtikguybx4x2() {
        return zrnkzkmrtikguybx4x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x2(String pZrnkzkmrtikguybx4x2) {
        zrnkzkmrtikguybx4x2 = pZrnkzkmrtikguybx4x2;
    }

    private String zrnkzkmrtikguybx5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X2)
    public String getZrnkzkmrtikguybx5x2() {
        return zrnkzkmrtikguybx5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x2(String pZrnkzkmrtikguybx5x2) {
        zrnkzkmrtikguybx5x2 = pZrnkzkmrtikguybx5x2;
    }

    private String zrnkzkmrtikguybx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X3)
    public String getZrnkzkmrtikguybx1x3() {
        return zrnkzkmrtikguybx1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x3(String pZrnkzkmrtikguybx1x3) {
        zrnkzkmrtikguybx1x3 = pZrnkzkmrtikguybx1x3;
    }

    private String zrnkzkmrtikguybx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X3)
    public String getZrnkzkmrtikguybx2x3() {
        return zrnkzkmrtikguybx2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x3(String pZrnkzkmrtikguybx2x3) {
        zrnkzkmrtikguybx2x3 = pZrnkzkmrtikguybx2x3;
    }

    private String zrnkzkmrtikguybx3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X3)
    public String getZrnkzkmrtikguybx3x3() {
        return zrnkzkmrtikguybx3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x3(String pZrnkzkmrtikguybx3x3) {
        zrnkzkmrtikguybx3x3 = pZrnkzkmrtikguybx3x3;
    }

    private String zrnkzkmrtikguybx4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X3)
    public String getZrnkzkmrtikguybx4x3() {
        return zrnkzkmrtikguybx4x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x3(String pZrnkzkmrtikguybx4x3) {
        zrnkzkmrtikguybx4x3 = pZrnkzkmrtikguybx4x3;
    }

    private String zrnkzkmrtikguybx5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X3)
    public String getZrnkzkmrtikguybx5x3() {
        return zrnkzkmrtikguybx5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x3(String pZrnkzkmrtikguybx5x3) {
        zrnkzkmrtikguybx5x3 = pZrnkzkmrtikguybx5x3;
    }

    private String zrnkzkmrtikguybx1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X4)
    public String getZrnkzkmrtikguybx1x4() {
        return zrnkzkmrtikguybx1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x4(String pZrnkzkmrtikguybx1x4) {
        zrnkzkmrtikguybx1x4 = pZrnkzkmrtikguybx1x4;
    }

    private String zrnkzkmrtikguybx2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X4)
    public String getZrnkzkmrtikguybx2x4() {
        return zrnkzkmrtikguybx2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x4(String pZrnkzkmrtikguybx2x4) {
        zrnkzkmrtikguybx2x4 = pZrnkzkmrtikguybx2x4;
    }

    private String zrnkzkmrtikguybx3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X4)
    public String getZrnkzkmrtikguybx3x4() {
        return zrnkzkmrtikguybx3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x4(String pZrnkzkmrtikguybx3x4) {
        zrnkzkmrtikguybx3x4 = pZrnkzkmrtikguybx3x4;
    }

    private String zrnkzkmrtikguybx4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X4)
    public String getZrnkzkmrtikguybx4x4() {
        return zrnkzkmrtikguybx4x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x4(String pZrnkzkmrtikguybx4x4) {
        zrnkzkmrtikguybx4x4 = pZrnkzkmrtikguybx4x4;
    }

    private String zrnkzkmrtikguybx5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X4)
    public String getZrnkzkmrtikguybx5x4() {
        return zrnkzkmrtikguybx5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x4(String pZrnkzkmrtikguybx5x4) {
        zrnkzkmrtikguybx5x4 = pZrnkzkmrtikguybx5x4;
    }

    private String zrnkzkmrtikguybx1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X5)
    public String getZrnkzkmrtikguybx1x5() {
        return zrnkzkmrtikguybx1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x5(String pZrnkzkmrtikguybx1x5) {
        zrnkzkmrtikguybx1x5 = pZrnkzkmrtikguybx1x5;
    }

    private String zrnkzkmrtikguybx2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X5)
    public String getZrnkzkmrtikguybx2x5() {
        return zrnkzkmrtikguybx2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x5(String pZrnkzkmrtikguybx2x5) {
        zrnkzkmrtikguybx2x5 = pZrnkzkmrtikguybx2x5;
    }

    private String zrnkzkmrtikguybx3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X5)
    public String getZrnkzkmrtikguybx3x5() {
        return zrnkzkmrtikguybx3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x5(String pZrnkzkmrtikguybx3x5) {
        zrnkzkmrtikguybx3x5 = pZrnkzkmrtikguybx3x5;
    }

    private String zrnkzkmrtikguybx4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X5)
    public String getZrnkzkmrtikguybx4x5() {
        return zrnkzkmrtikguybx4x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x5(String pZrnkzkmrtikguybx4x5) {
        zrnkzkmrtikguybx4x5 = pZrnkzkmrtikguybx4x5;
    }

    private String zrnkzkmrtikguybx5x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X5)
    public String getZrnkzkmrtikguybx5x5() {
        return zrnkzkmrtikguybx5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x5(String pZrnkzkmrtikguybx5x5) {
        zrnkzkmrtikguybx5x5 = pZrnkzkmrtikguybx5x5;
    }

    private String zrnkzkmrtikguybx1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X6)
    public String getZrnkzkmrtikguybx1x6() {
        return zrnkzkmrtikguybx1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x6(String pZrnkzkmrtikguybx1x6) {
        zrnkzkmrtikguybx1x6 = pZrnkzkmrtikguybx1x6;
    }

    private String zrnkzkmrtikguybx2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X6)
    public String getZrnkzkmrtikguybx2x6() {
        return zrnkzkmrtikguybx2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x6(String pZrnkzkmrtikguybx2x6) {
        zrnkzkmrtikguybx2x6 = pZrnkzkmrtikguybx2x6;
    }

    private String zrnkzkmrtikguybx3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X6)
    public String getZrnkzkmrtikguybx3x6() {
        return zrnkzkmrtikguybx3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x6(String pZrnkzkmrtikguybx3x6) {
        zrnkzkmrtikguybx3x6 = pZrnkzkmrtikguybx3x6;
    }

    private String zrnkzkmrtikguybx4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X6)
    public String getZrnkzkmrtikguybx4x6() {
        return zrnkzkmrtikguybx4x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x6(String pZrnkzkmrtikguybx4x6) {
        zrnkzkmrtikguybx4x6 = pZrnkzkmrtikguybx4x6;
    }

    private String zrnkzkmrtikguybx5x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X6)
    public String getZrnkzkmrtikguybx5x6() {
        return zrnkzkmrtikguybx5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x6(String pZrnkzkmrtikguybx5x6) {
        zrnkzkmrtikguybx5x6 = pZrnkzkmrtikguybx5x6;
    }

    private String zrnkzkmrtikguybx1x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X7)
    public String getZrnkzkmrtikguybx1x7() {
        return zrnkzkmrtikguybx1x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x7(String pZrnkzkmrtikguybx1x7) {
        zrnkzkmrtikguybx1x7 = pZrnkzkmrtikguybx1x7;
    }

    private String zrnkzkmrtikguybx2x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X7)
    public String getZrnkzkmrtikguybx2x7() {
        return zrnkzkmrtikguybx2x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x7(String pZrnkzkmrtikguybx2x7) {
        zrnkzkmrtikguybx2x7 = pZrnkzkmrtikguybx2x7;
    }

    private String zrnkzkmrtikguybx3x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X7)
    public String getZrnkzkmrtikguybx3x7() {
        return zrnkzkmrtikguybx3x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x7(String pZrnkzkmrtikguybx3x7) {
        zrnkzkmrtikguybx3x7 = pZrnkzkmrtikguybx3x7;
    }

    private String zrnkzkmrtikguybx4x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X7)
    public String getZrnkzkmrtikguybx4x7() {
        return zrnkzkmrtikguybx4x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x7(String pZrnkzkmrtikguybx4x7) {
        zrnkzkmrtikguybx4x7 = pZrnkzkmrtikguybx4x7;
    }

    private String zrnkzkmrtikguybx5x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X7)
    public String getZrnkzkmrtikguybx5x7() {
        return zrnkzkmrtikguybx5x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x7(String pZrnkzkmrtikguybx5x7) {
        zrnkzkmrtikguybx5x7 = pZrnkzkmrtikguybx5x7;
    }

    private String zrnkzkmrtikguybx1x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X8)
    public String getZrnkzkmrtikguybx1x8() {
        return zrnkzkmrtikguybx1x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x8(String pZrnkzkmrtikguybx1x8) {
        zrnkzkmrtikguybx1x8 = pZrnkzkmrtikguybx1x8;
    }

    private String zrnkzkmrtikguybx2x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X8)
    public String getZrnkzkmrtikguybx2x8() {
        return zrnkzkmrtikguybx2x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x8(String pZrnkzkmrtikguybx2x8) {
        zrnkzkmrtikguybx2x8 = pZrnkzkmrtikguybx2x8;
    }

    private String zrnkzkmrtikguybx3x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X8)
    public String getZrnkzkmrtikguybx3x8() {
        return zrnkzkmrtikguybx3x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x8(String pZrnkzkmrtikguybx3x8) {
        zrnkzkmrtikguybx3x8 = pZrnkzkmrtikguybx3x8;
    }

    private String zrnkzkmrtikguybx4x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X8)
    public String getZrnkzkmrtikguybx4x8() {
        return zrnkzkmrtikguybx4x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x8(String pZrnkzkmrtikguybx4x8) {
        zrnkzkmrtikguybx4x8 = pZrnkzkmrtikguybx4x8;
    }

    private String zrnkzkmrtikguybx5x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X8)
    public String getZrnkzkmrtikguybx5x8() {
        return zrnkzkmrtikguybx5x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x8(String pZrnkzkmrtikguybx5x8) {
        zrnkzkmrtikguybx5x8 = pZrnkzkmrtikguybx5x8;
    }

    private String zrnkzkmrtikguybx1x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X9)
    public String getZrnkzkmrtikguybx1x9() {
        return zrnkzkmrtikguybx1x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x9(String pZrnkzkmrtikguybx1x9) {
        zrnkzkmrtikguybx1x9 = pZrnkzkmrtikguybx1x9;
    }

    private String zrnkzkmrtikguybx2x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X9)
    public String getZrnkzkmrtikguybx2x9() {
        return zrnkzkmrtikguybx2x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x9(String pZrnkzkmrtikguybx2x9) {
        zrnkzkmrtikguybx2x9 = pZrnkzkmrtikguybx2x9;
    }

    private String zrnkzkmrtikguybx3x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X9)
    public String getZrnkzkmrtikguybx3x9() {
        return zrnkzkmrtikguybx3x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x9(String pZrnkzkmrtikguybx3x9) {
        zrnkzkmrtikguybx3x9 = pZrnkzkmrtikguybx3x9;
    }

    private String zrnkzkmrtikguybx4x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X9)
    public String getZrnkzkmrtikguybx4x9() {
        return zrnkzkmrtikguybx4x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x9(String pZrnkzkmrtikguybx4x9) {
        zrnkzkmrtikguybx4x9 = pZrnkzkmrtikguybx4x9;
    }

    private String zrnkzkmrtikguybx5x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X9)
    public String getZrnkzkmrtikguybx5x9() {
        return zrnkzkmrtikguybx5x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x9(String pZrnkzkmrtikguybx5x9) {
        zrnkzkmrtikguybx5x9 = pZrnkzkmrtikguybx5x9;
    }

    private String zrnkzkmrtikguybx1x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX1X10)
    public String getZrnkzkmrtikguybx1x10() {
        return zrnkzkmrtikguybx1x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx1x10(String pZrnkzkmrtikguybx1x10) {
        zrnkzkmrtikguybx1x10 = pZrnkzkmrtikguybx1x10;
    }

    private String zrnkzkmrtikguybx2x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX2X10)
    public String getZrnkzkmrtikguybx2x10() {
        return zrnkzkmrtikguybx2x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx2x10(String pZrnkzkmrtikguybx2x10) {
        zrnkzkmrtikguybx2x10 = pZrnkzkmrtikguybx2x10;
    }

    private String zrnkzkmrtikguybx3x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX3X10)
    public String getZrnkzkmrtikguybx3x10() {
        return zrnkzkmrtikguybx3x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx3x10(String pZrnkzkmrtikguybx3x10) {
        zrnkzkmrtikguybx3x10 = pZrnkzkmrtikguybx3x10;
    }

    private String zrnkzkmrtikguybx4x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX4X10)
    public String getZrnkzkmrtikguybx4x10() {
        return zrnkzkmrtikguybx4x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx4x10(String pZrnkzkmrtikguybx4x10) {
        zrnkzkmrtikguybx4x10 = pZrnkzkmrtikguybx4x10;
    }

    private String zrnkzkmrtikguybx5x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKMRTIKGUYBX5X10)
    public String getZrnkzkmrtikguybx5x10() {
        return zrnkzkmrtikguybx5x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtikguybx5x10(String pZrnkzkmrtikguybx5x10) {
        zrnkzkmrtikguybx5x10 = pZrnkzkmrtikguybx5x10;
    }

    private String zrnsyugittkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYUGITTKYKKGUYBX1)
    public String getZrnsyugittkykkguybx1() {
        return zrnsyugittkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyugittkykkguybx1(String pZrnsyugittkykkguybx1) {
        zrnsyugittkykkguybx1 = pZrnsyugittkykkguybx1;
    }

    private String zrnsyugittkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYUGITTKYKKGUYBX2)
    public String getZrnsyugittkykkguybx2() {
        return zrnsyugittkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyugittkykkguybx2(String pZrnsyugittkykkguybx2) {
        zrnsyugittkykkguybx2 = pZrnsyugittkykkguybx2;
    }

    private String zrnsyugittkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYUGITTKYKKGUYBX3)
    public String getZrnsyugittkykkguybx3() {
        return zrnsyugittkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyugittkykkguybx3(String pZrnsyugittkykkguybx3) {
        zrnsyugittkykkguybx3 = pZrnsyugittkykkguybx3;
    }

    private String zrnsyugittkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYUGITTKYKKGUYBX4)
    public String getZrnsyugittkykkguybx4() {
        return zrnsyugittkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyugittkykkguybx4(String pZrnsyugittkykkguybx4) {
        zrnsyugittkykkguybx4 = pZrnsyugittkykkguybx4;
    }

    private String zrnsyugittkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYUGITTKYKKGUYBX5)
    public String getZrnsyugittkykkguybx5() {
        return zrnsyugittkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyugittkykkguybx5(String pZrnsyugittkykkguybx5) {
        zrnsyugittkykkguybx5 = pZrnsyugittkykkguybx5;
    }

    private String zrnsigiwrmstkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGIWRMSTKYKKGUYBX1)
    public String getZrnsigiwrmstkykkguybx1() {
        return zrnsigiwrmstkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsigiwrmstkykkguybx1(String pZrnsigiwrmstkykkguybx1) {
        zrnsigiwrmstkykkguybx1 = pZrnsigiwrmstkykkguybx1;
    }

    private String zrnsigiwrmstkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGIWRMSTKYKKGUYBX2)
    public String getZrnsigiwrmstkykkguybx2() {
        return zrnsigiwrmstkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsigiwrmstkykkguybx2(String pZrnsigiwrmstkykkguybx2) {
        zrnsigiwrmstkykkguybx2 = pZrnsigiwrmstkykkguybx2;
    }

    private String zrnsigiwrmstkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGIWRMSTKYKKGUYBX3)
    public String getZrnsigiwrmstkykkguybx3() {
        return zrnsigiwrmstkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsigiwrmstkykkguybx3(String pZrnsigiwrmstkykkguybx3) {
        zrnsigiwrmstkykkguybx3 = pZrnsigiwrmstkykkguybx3;
    }

    private String zrnsigiwrmstkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGIWRMSTKYKKGUYBX4)
    public String getZrnsigiwrmstkykkguybx4() {
        return zrnsigiwrmstkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsigiwrmstkykkguybx4(String pZrnsigiwrmstkykkguybx4) {
        zrnsigiwrmstkykkguybx4 = pZrnsigiwrmstkykkguybx4;
    }

    private String zrnsigiwrmstkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGIWRMSTKYKKGUYBX5)
    public String getZrnsigiwrmstkykkguybx5() {
        return zrnsigiwrmstkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsigiwrmstkykkguybx5(String pZrnsigiwrmstkykkguybx5) {
        zrnsigiwrmstkykkguybx5 = pZrnsigiwrmstkykkguybx5;
    }

    private String zrnsiginyuintkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGINYUINTKYKKGUYBX1)
    public String getZrnsiginyuintkykkguybx1() {
        return zrnsiginyuintkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiginyuintkykkguybx1(String pZrnsiginyuintkykkguybx1) {
        zrnsiginyuintkykkguybx1 = pZrnsiginyuintkykkguybx1;
    }

    private String zrnsiginyuintkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGINYUINTKYKKGUYBX2)
    public String getZrnsiginyuintkykkguybx2() {
        return zrnsiginyuintkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiginyuintkykkguybx2(String pZrnsiginyuintkykkguybx2) {
        zrnsiginyuintkykkguybx2 = pZrnsiginyuintkykkguybx2;
    }

    private String zrnsiginyuintkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGINYUINTKYKKGUYBX3)
    public String getZrnsiginyuintkykkguybx3() {
        return zrnsiginyuintkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiginyuintkykkguybx3(String pZrnsiginyuintkykkguybx3) {
        zrnsiginyuintkykkguybx3 = pZrnsiginyuintkykkguybx3;
    }

    private String zrnsiginyuintkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGINYUINTKYKKGUYBX4)
    public String getZrnsiginyuintkykkguybx4() {
        return zrnsiginyuintkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiginyuintkykkguybx4(String pZrnsiginyuintkykkguybx4) {
        zrnsiginyuintkykkguybx4 = pZrnsiginyuintkykkguybx4;
    }

    private String zrnsiginyuintkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIGINYUINTKYKKGUYBX5)
    public String getZrnsiginyuintkykkguybx5() {
        return zrnsiginyuintkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiginyuintkykkguybx5(String pZrnsiginyuintkykkguybx5) {
        zrnsiginyuintkykkguybx5 = pZrnsiginyuintkykkguybx5;
    }

    private String zrnsppinyuintkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSPPINYUINTKYKKGUYBX1)
    public String getZrnsppinyuintkykkguybx1() {
        return zrnsppinyuintkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsppinyuintkykkguybx1(String pZrnsppinyuintkykkguybx1) {
        zrnsppinyuintkykkguybx1 = pZrnsppinyuintkykkguybx1;
    }

    private String zrnsppinyuintkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSPPINYUINTKYKKGUYBX2)
    public String getZrnsppinyuintkykkguybx2() {
        return zrnsppinyuintkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsppinyuintkykkguybx2(String pZrnsppinyuintkykkguybx2) {
        zrnsppinyuintkykkguybx2 = pZrnsppinyuintkykkguybx2;
    }

    private String zrnsppinyuintkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSPPINYUINTKYKKGUYBX3)
    public String getZrnsppinyuintkykkguybx3() {
        return zrnsppinyuintkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsppinyuintkykkguybx3(String pZrnsppinyuintkykkguybx3) {
        zrnsppinyuintkykkguybx3 = pZrnsppinyuintkykkguybx3;
    }

    private String zrnsppinyuintkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSPPINYUINTKYKKGUYBX4)
    public String getZrnsppinyuintkykkguybx4() {
        return zrnsppinyuintkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsppinyuintkykkguybx4(String pZrnsppinyuintkykkguybx4) {
        zrnsppinyuintkykkguybx4 = pZrnsppinyuintkykkguybx4;
    }

    private String zrnsppinyuintkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSPPINYUINTKYKKGUYBX5)
    public String getZrnsppinyuintkykkguybx5() {
        return zrnsppinyuintkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsppinyuintkykkguybx5(String pZrnsppinyuintkykkguybx5) {
        zrnsppinyuintkykkguybx5 = pZrnsppinyuintkykkguybx5;
    }

    private String zrnsijnbyutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIJNBYUTKYKKGUYBX1)
    public String getZrnsijnbyutkykkguybx1() {
        return zrnsijnbyutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsijnbyutkykkguybx1(String pZrnsijnbyutkykkguybx1) {
        zrnsijnbyutkykkguybx1 = pZrnsijnbyutkykkguybx1;
    }

    private String zrnsijnbyutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIJNBYUTKYKKGUYBX2)
    public String getZrnsijnbyutkykkguybx2() {
        return zrnsijnbyutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsijnbyutkykkguybx2(String pZrnsijnbyutkykkguybx2) {
        zrnsijnbyutkykkguybx2 = pZrnsijnbyutkykkguybx2;
    }

    private String zrnsijnbyutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIJNBYUTKYKKGUYBX3)
    public String getZrnsijnbyutkykkguybx3() {
        return zrnsijnbyutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsijnbyutkykkguybx3(String pZrnsijnbyutkykkguybx3) {
        zrnsijnbyutkykkguybx3 = pZrnsijnbyutkykkguybx3;
    }

    private String zrnsijnbyutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIJNBYUTKYKKGUYBX4)
    public String getZrnsijnbyutkykkguybx4() {
        return zrnsijnbyutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsijnbyutkykkguybx4(String pZrnsijnbyutkykkguybx4) {
        zrnsijnbyutkykkguybx4 = pZrnsijnbyutkykkguybx4;
    }

    private String zrnsijnbyutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIJNBYUTKYKKGUYBX5)
    public String getZrnsijnbyutkykkguybx5() {
        return zrnsijnbyutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsijnbyutkykkguybx5(String pZrnsijnbyutkykkguybx5) {
        zrnsijnbyutkykkguybx5 = pZrnsijnbyutkykkguybx5;
    }

    private String zrnkzkiryoutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKIRYOUTKYKKGUYBX1)
    public String getZrnkzkiryoutkykkguybx1() {
        return zrnkzkiryoutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkiryoutkykkguybx1(String pZrnkzkiryoutkykkguybx1) {
        zrnkzkiryoutkykkguybx1 = pZrnkzkiryoutkykkguybx1;
    }

    private String zrnkzkiryoutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKIRYOUTKYKKGUYBX2)
    public String getZrnkzkiryoutkykkguybx2() {
        return zrnkzkiryoutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkiryoutkykkguybx2(String pZrnkzkiryoutkykkguybx2) {
        zrnkzkiryoutkykkguybx2 = pZrnkzkiryoutkykkguybx2;
    }

    private String zrnkzkiryoutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKIRYOUTKYKKGUYBX3)
    public String getZrnkzkiryoutkykkguybx3() {
        return zrnkzkiryoutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkiryoutkykkguybx3(String pZrnkzkiryoutkykkguybx3) {
        zrnkzkiryoutkykkguybx3 = pZrnkzkiryoutkykkguybx3;
    }

    private String zrnkzkiryoutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKIRYOUTKYKKGUYBX4)
    public String getZrnkzkiryoutkykkguybx4() {
        return zrnkzkiryoutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkiryoutkykkguybx4(String pZrnkzkiryoutkykkguybx4) {
        zrnkzkiryoutkykkguybx4 = pZrnkzkiryoutkykkguybx4;
    }

    private String zrnkzkiryoutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKZKIRYOUTKYKKGUYBX5)
    public String getZrnkzkiryoutkykkguybx5() {
        return zrnkzkiryoutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkiryoutkykkguybx5(String pZrnkzkiryoutkykkguybx5) {
        zrnkzkiryoutkykkguybx5 = pZrnkzkiryoutkykkguybx5;
    }

    private String zrnsykkyuhtkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYKKYUHTKYKKGUYBX1)
    public String getZrnsykkyuhtkykkguybx1() {
        return zrnsykkyuhtkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykkyuhtkykkguybx1(String pZrnsykkyuhtkykkguybx1) {
        zrnsykkyuhtkykkguybx1 = pZrnsykkyuhtkykkguybx1;
    }

    private String zrnsykkyuhtkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYKKYUHTKYKKGUYBX2)
    public String getZrnsykkyuhtkykkguybx2() {
        return zrnsykkyuhtkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykkyuhtkykkguybx2(String pZrnsykkyuhtkykkguybx2) {
        zrnsykkyuhtkykkguybx2 = pZrnsykkyuhtkykkguybx2;
    }

    private String zrnsykkyuhtkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYKKYUHTKYKKGUYBX3)
    public String getZrnsykkyuhtkykkguybx3() {
        return zrnsykkyuhtkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykkyuhtkykkguybx3(String pZrnsykkyuhtkykkguybx3) {
        zrnsykkyuhtkykkguybx3 = pZrnsykkyuhtkykkguybx3;
    }

    private String zrnsykkyuhtkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYKKYUHTKYKKGUYBX4)
    public String getZrnsykkyuhtkykkguybx4() {
        return zrnsykkyuhtkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykkyuhtkykkguybx4(String pZrnsykkyuhtkykkguybx4) {
        zrnsykkyuhtkykkguybx4 = pZrnsykkyuhtkykkguybx4;
    }

    private String zrnsykkyuhtkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSYKKYUHTKYKKGUYBX5)
    public String getZrnsykkyuhtkykkguybx5() {
        return zrnsykkyuhtkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykkyuhtkykkguybx5(String pZrnsykkyuhtkykkguybx5) {
        zrnsykkyuhtkykkguybx5 = pZrnsykkyuhtkykkguybx5;
    }

    private String zrnnkdtmrtikguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDTMRTIKGUYOBIX1)
    public String getZrnnkdtmrtikguyobix1() {
        return zrnnkdtmrtikguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdtmrtikguyobix1(String pZrnnkdtmrtikguyobix1) {
        zrnnkdtmrtikguyobix1 = pZrnnkdtmrtikguyobix1;
    }

    private String zrnnkdtmrtikguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDTMRTIKGUYOBIX2)
    public String getZrnnkdtmrtikguyobix2() {
        return zrnnkdtmrtikguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdtmrtikguyobix2(String pZrnnkdtmrtikguyobix2) {
        zrnnkdtmrtikguyobix2 = pZrnnkdtmrtikguyobix2;
    }

    private String zrnnkdtmrtikguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDTMRTIKGUYOBIX3)
    public String getZrnnkdtmrtikguyobix3() {
        return zrnnkdtmrtikguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdtmrtikguyobix3(String pZrnnkdtmrtikguyobix3) {
        zrnnkdtmrtikguyobix3 = pZrnnkdtmrtikguyobix3;
    }

    private String zrnnkdtmrtikguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDTMRTIKGUYOBIX4)
    public String getZrnnkdtmrtikguyobix4() {
        return zrnnkdtmrtikguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdtmrtikguyobix4(String pZrnnkdtmrtikguyobix4) {
        zrnnkdtmrtikguyobix4 = pZrnnkdtmrtikguyobix4;
    }

    private String zrnnkdtmrtikguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDTMRTIKGUYOBIX5)
    public String getZrnnkdtmrtikguyobix5() {
        return zrnnkdtmrtikguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdtmrtikguyobix5(String pZrnnkdtmrtikguyobix5) {
        zrnnkdtmrtikguyobix5 = pZrnnkdtmrtikguyobix5;
    }

    private String zrnnkdatetokuteikguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDATETOKUTEIKGUYOBIX1)
    public String getZrnnkdatetokuteikguyobix1() {
        return zrnnkdatetokuteikguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteikguyobix1(String pZrnnkdatetokuteikguyobix1) {
        zrnnkdatetokuteikguyobix1 = pZrnnkdatetokuteikguyobix1;
    }

    private String zrnnkdatetokuteikguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDATETOKUTEIKGUYOBIX2)
    public String getZrnnkdatetokuteikguyobix2() {
        return zrnnkdatetokuteikguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteikguyobix2(String pZrnnkdatetokuteikguyobix2) {
        zrnnkdatetokuteikguyobix2 = pZrnnkdatetokuteikguyobix2;
    }

    private String zrnnkdatetokuteikguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDATETOKUTEIKGUYOBIX3)
    public String getZrnnkdatetokuteikguyobix3() {
        return zrnnkdatetokuteikguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteikguyobix3(String pZrnnkdatetokuteikguyobix3) {
        zrnnkdatetokuteikguyobix3 = pZrnnkdatetokuteikguyobix3;
    }

    private String zrnnkdatetokuteikguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDATETOKUTEIKGUYOBIX4)
    public String getZrnnkdatetokuteikguyobix4() {
        return zrnnkdatetokuteikguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteikguyobix4(String pZrnnkdatetokuteikguyobix4) {
        zrnnkdatetokuteikguyobix4 = pZrnnkdatetokuteikguyobix4;
    }

    private String zrnnkdatetokuteikguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNNKDATETOKUTEIKGUYOBIX5)
    public String getZrnnkdatetokuteikguyobix5() {
        return zrnnkdatetokuteikguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteikguyobix5(String pZrnnkdatetokuteikguyobix5) {
        zrnnkdatetokuteikguyobix5 = pZrnnkdatetokuteikguyobix5;
    }

    private String zrnkaigonkdtmrtikguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTMRTIKGUYOBIX1)
    public String getZrnkaigonkdtmrtikguyobix1() {
        return zrnkaigonkdtmrtikguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtikguyobix1(String pZrnkaigonkdtmrtikguyobix1) {
        zrnkaigonkdtmrtikguyobix1 = pZrnkaigonkdtmrtikguyobix1;
    }

    private String zrnkaigonkdtmrtikguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTMRTIKGUYOBIX2)
    public String getZrnkaigonkdtmrtikguyobix2() {
        return zrnkaigonkdtmrtikguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtikguyobix2(String pZrnkaigonkdtmrtikguyobix2) {
        zrnkaigonkdtmrtikguyobix2 = pZrnkaigonkdtmrtikguyobix2;
    }

    private String zrnkaigonkdtmrtikguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTMRTIKGUYOBIX3)
    public String getZrnkaigonkdtmrtikguyobix3() {
        return zrnkaigonkdtmrtikguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtikguyobix3(String pZrnkaigonkdtmrtikguyobix3) {
        zrnkaigonkdtmrtikguyobix3 = pZrnkaigonkdtmrtikguyobix3;
    }

    private String zrnkaigonkdtmrtikguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTMRTIKGUYOBIX4)
    public String getZrnkaigonkdtmrtikguyobix4() {
        return zrnkaigonkdtmrtikguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtikguyobix4(String pZrnkaigonkdtmrtikguyobix4) {
        zrnkaigonkdtmrtikguyobix4 = pZrnkaigonkdtmrtikguyobix4;
    }

    private String zrnkaigonkdtmrtikguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTMRTIKGUYOBIX5)
    public String getZrnkaigonkdtmrtikguyobix5() {
        return zrnkaigonkdtmrtikguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtikguyobix5(String pZrnkaigonkdtmrtikguyobix5) {
        zrnkaigonkdtmrtikguyobix5 = pZrnkaigonkdtmrtikguyobix5;
    }

    private String zrnkaigonkdttktikguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTTKTIKGUYOBIX1)
    public String getZrnkaigonkdttktikguyobix1() {
        return zrnkaigonkdttktikguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktikguyobix1(String pZrnkaigonkdttktikguyobix1) {
        zrnkaigonkdttktikguyobix1 = pZrnkaigonkdttktikguyobix1;
    }

    private String zrnkaigonkdttktikguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTTKTIKGUYOBIX2)
    public String getZrnkaigonkdttktikguyobix2() {
        return zrnkaigonkdttktikguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktikguyobix2(String pZrnkaigonkdttktikguyobix2) {
        zrnkaigonkdttktikguyobix2 = pZrnkaigonkdttktikguyobix2;
    }

    private String zrnkaigonkdttktikguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTTKTIKGUYOBIX3)
    public String getZrnkaigonkdttktikguyobix3() {
        return zrnkaigonkdttktikguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktikguyobix3(String pZrnkaigonkdttktikguyobix3) {
        zrnkaigonkdttktikguyobix3 = pZrnkaigonkdttktikguyobix3;
    }

    private String zrnkaigonkdttktikguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTTKTIKGUYOBIX4)
    public String getZrnkaigonkdttktikguyobix4() {
        return zrnkaigonkdttktikguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktikguyobix4(String pZrnkaigonkdttktikguyobix4) {
        zrnkaigonkdttktikguyobix4 = pZrnkaigonkdttktikguyobix4;
    }

    private String zrnkaigonkdttktikguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKDTTKTIKGUYOBIX5)
    public String getZrnkaigonkdttktikguyobix5() {
        return zrnkaigonkdttktikguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktikguyobix5(String pZrnkaigonkdttktikguyobix5) {
        zrnkaigonkdttktikguyobix5 = pZrnkaigonkdttktikguyobix5;
    }

    private String zrnkaigomaruteikigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOMARUTEIKIGOUYOBIX1)
    public String getZrnkaigomaruteikigouyobix1() {
        return zrnkaigomaruteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaruteikigouyobix1(String pZrnkaigomaruteikigouyobix1) {
        zrnkaigomaruteikigouyobix1 = pZrnkaigomaruteikigouyobix1;
    }

    private String zrnkaigomaruteikigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOMARUTEIKIGOUYOBIX2)
    public String getZrnkaigomaruteikigouyobix2() {
        return zrnkaigomaruteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaruteikigouyobix2(String pZrnkaigomaruteikigouyobix2) {
        zrnkaigomaruteikigouyobix2 = pZrnkaigomaruteikigouyobix2;
    }

    private String zrnkaigomaruteikigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOMARUTEIKIGOUYOBIX3)
    public String getZrnkaigomaruteikigouyobix3() {
        return zrnkaigomaruteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaruteikigouyobix3(String pZrnkaigomaruteikigouyobix3) {
        zrnkaigomaruteikigouyobix3 = pZrnkaigomaruteikigouyobix3;
    }

    private String zrnkaigomaruteikigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOMARUTEIKIGOUYOBIX4)
    public String getZrnkaigomaruteikigouyobix4() {
        return zrnkaigomaruteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaruteikigouyobix4(String pZrnkaigomaruteikigouyobix4) {
        zrnkaigomaruteikigouyobix4 = pZrnkaigomaruteikigouyobix4;
    }

    private String zrnkaigomaruteikigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOMARUTEIKIGOUYOBIX5)
    public String getZrnkaigomaruteikigouyobix5() {
        return zrnkaigomaruteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaruteikigouyobix5(String pZrnkaigomaruteikigouyobix5) {
        zrnkaigomaruteikigouyobix5 = pZrnkaigomaruteikigouyobix5;
    }

    private String zrnkaigotokuteikigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOTOKUTEIKIGOUYOBIX1)
    public String getZrnkaigotokuteikigouyobix1() {
        return zrnkaigotokuteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigotokuteikigouyobix1(String pZrnkaigotokuteikigouyobix1) {
        zrnkaigotokuteikigouyobix1 = pZrnkaigotokuteikigouyobix1;
    }

    private String zrnkaigotokuteikigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOTOKUTEIKIGOUYOBIX2)
    public String getZrnkaigotokuteikigouyobix2() {
        return zrnkaigotokuteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigotokuteikigouyobix2(String pZrnkaigotokuteikigouyobix2) {
        zrnkaigotokuteikigouyobix2 = pZrnkaigotokuteikigouyobix2;
    }

    private String zrnkaigotokuteikigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOTOKUTEIKIGOUYOBIX3)
    public String getZrnkaigotokuteikigouyobix3() {
        return zrnkaigotokuteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigotokuteikigouyobix3(String pZrnkaigotokuteikigouyobix3) {
        zrnkaigotokuteikigouyobix3 = pZrnkaigotokuteikigouyobix3;
    }

    private String zrnkaigotokuteikigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOTOKUTEIKIGOUYOBIX4)
    public String getZrnkaigotokuteikigouyobix4() {
        return zrnkaigotokuteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigotokuteikigouyobix4(String pZrnkaigotokuteikigouyobix4) {
        zrnkaigotokuteikigouyobix4 = pZrnkaigotokuteikigouyobix4;
    }

    private String zrnkaigotokuteikigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGOTOKUTEIKIGOUYOBIX5)
    public String getZrnkaigotokuteikigouyobix5() {
        return zrnkaigotokuteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigotokuteikigouyobix5(String pZrnkaigotokuteikigouyobix5) {
        zrnkaigotokuteikigouyobix5 = pZrnkaigotokuteikigouyobix5;
    }

    private String zrnsiznmrtikguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIZNMRTIKGUYBX1)
    public String getZrnsiznmrtikguybx1() {
        return zrnsiznmrtikguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx1(String pZrnsiznmrtikguybx1) {
        zrnsiznmrtikguybx1 = pZrnsiznmrtikguybx1;
    }

    private String zrnsiznmrtikguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIZNMRTIKGUYBX2)
    public String getZrnsiznmrtikguybx2() {
        return zrnsiznmrtikguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx2(String pZrnsiznmrtikguybx2) {
        zrnsiznmrtikguybx2 = pZrnsiznmrtikguybx2;
    }

    private String zrnsiznmrtikguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIZNMRTIKGUYBX3)
    public String getZrnsiznmrtikguybx3() {
        return zrnsiznmrtikguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx3(String pZrnsiznmrtikguybx3) {
        zrnsiznmrtikguybx3 = pZrnsiznmrtikguybx3;
    }

    private String zrnsiznmrtikguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIZNMRTIKGUYBX4)
    public String getZrnsiznmrtikguybx4() {
        return zrnsiznmrtikguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx4(String pZrnsiznmrtikguybx4) {
        zrnsiznmrtikguybx4 = pZrnsiznmrtikguybx4;
    }

    private String zrnsiznmrtikguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSIZNMRTIKGUYBX5)
    public String getZrnsiznmrtikguybx5() {
        return zrnsiznmrtikguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx5(String pZrnsiznmrtikguybx5) {
        zrnsiznmrtikguybx5 = pZrnsiznmrtikguybx5;
    }

    private String zrnteigenmaruteikigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENMARUTEIKIGOUYOBIX1)
    public String getZrnteigenmaruteikigouyobix1() {
        return zrnteigenmaruteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix1(String pZrnteigenmaruteikigouyobix1) {
        zrnteigenmaruteikigouyobix1 = pZrnteigenmaruteikigouyobix1;
    }

    private String zrnteigenmaruteikigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENMARUTEIKIGOUYOBIX2)
    public String getZrnteigenmaruteikigouyobix2() {
        return zrnteigenmaruteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix2(String pZrnteigenmaruteikigouyobix2) {
        zrnteigenmaruteikigouyobix2 = pZrnteigenmaruteikigouyobix2;
    }

    private String zrnteigenmaruteikigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENMARUTEIKIGOUYOBIX3)
    public String getZrnteigenmaruteikigouyobix3() {
        return zrnteigenmaruteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix3(String pZrnteigenmaruteikigouyobix3) {
        zrnteigenmaruteikigouyobix3 = pZrnteigenmaruteikigouyobix3;
    }

    private String zrnteigenmaruteikigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENMARUTEIKIGOUYOBIX4)
    public String getZrnteigenmaruteikigouyobix4() {
        return zrnteigenmaruteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix4(String pZrnteigenmaruteikigouyobix4) {
        zrnteigenmaruteikigouyobix4 = pZrnteigenmaruteikigouyobix4;
    }

    private String zrnteigenmaruteikigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENMARUTEIKIGOUYOBIX5)
    public String getZrnteigenmaruteikigouyobix5() {
        return zrnteigenmaruteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix5(String pZrnteigenmaruteikigouyobix5) {
        zrnteigenmaruteikigouyobix5 = pZrnteigenmaruteikigouyobix5;
    }

    private String zrnteigentokuteikigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENTOKUTEIKIGOUYOBIX1)
    public String getZrnteigentokuteikigouyobix1() {
        return zrnteigentokuteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigentokuteikigouyobix1(String pZrnteigentokuteikigouyobix1) {
        zrnteigentokuteikigouyobix1 = pZrnteigentokuteikigouyobix1;
    }

    private String zrnteigentokuteikigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENTOKUTEIKIGOUYOBIX2)
    public String getZrnteigentokuteikigouyobix2() {
        return zrnteigentokuteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigentokuteikigouyobix2(String pZrnteigentokuteikigouyobix2) {
        zrnteigentokuteikigouyobix2 = pZrnteigentokuteikigouyobix2;
    }

    private String zrnteigentokuteikigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENTOKUTEIKIGOUYOBIX3)
    public String getZrnteigentokuteikigouyobix3() {
        return zrnteigentokuteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigentokuteikigouyobix3(String pZrnteigentokuteikigouyobix3) {
        zrnteigentokuteikigouyobix3 = pZrnteigentokuteikigouyobix3;
    }

    private String zrnteigentokuteikigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENTOKUTEIKIGOUYOBIX4)
    public String getZrnteigentokuteikigouyobix4() {
        return zrnteigentokuteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigentokuteikigouyobix4(String pZrnteigentokuteikigouyobix4) {
        zrnteigentokuteikigouyobix4 = pZrnteigentokuteikigouyobix4;
    }

    private String zrnteigentokuteikigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTEIGENTOKUTEIKIGOUYOBIX5)
    public String getZrnteigentokuteikigouyobix5() {
        return zrnteigentokuteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigentokuteikigouyobix5(String pZrnteigentokuteikigouyobix5) {
        zrnteigentokuteikigouyobix5 = pZrnteigentokuteikigouyobix5;
    }

    private String zrnkigtignmrtikguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNMRTIKGUYBX1)
    public String getZrnkigtignmrtikguybx1() {
        return zrnkigtignmrtikguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtignmrtikguybx1(String pZrnkigtignmrtikguybx1) {
        zrnkigtignmrtikguybx1 = pZrnkigtignmrtikguybx1;
    }

    private String zrnkigtignmrtikguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNMRTIKGUYBX2)
    public String getZrnkigtignmrtikguybx2() {
        return zrnkigtignmrtikguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtignmrtikguybx2(String pZrnkigtignmrtikguybx2) {
        zrnkigtignmrtikguybx2 = pZrnkigtignmrtikguybx2;
    }

    private String zrnkigtignmrtikguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNMRTIKGUYBX3)
    public String getZrnkigtignmrtikguybx3() {
        return zrnkigtignmrtikguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtignmrtikguybx3(String pZrnkigtignmrtikguybx3) {
        zrnkigtignmrtikguybx3 = pZrnkigtignmrtikguybx3;
    }

    private String zrnkigtignmrtikguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNMRTIKGUYBX4)
    public String getZrnkigtignmrtikguybx4() {
        return zrnkigtignmrtikguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtignmrtikguybx4(String pZrnkigtignmrtikguybx4) {
        zrnkigtignmrtikguybx4 = pZrnkigtignmrtikguybx4;
    }

    private String zrnkigtignmrtikguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNMRTIKGUYBX5)
    public String getZrnkigtignmrtikguybx5() {
        return zrnkigtignmrtikguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtignmrtikguybx5(String pZrnkigtignmrtikguybx5) {
        zrnkigtignmrtikguybx5 = pZrnkigtignmrtikguybx5;
    }

    private String zrnkigtigntktikguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNTKTIKGUYBX1)
    public String getZrnkigtigntktikguybx1() {
        return zrnkigtigntktikguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtigntktikguybx1(String pZrnkigtigntktikguybx1) {
        zrnkigtigntktikguybx1 = pZrnkigtigntktikguybx1;
    }

    private String zrnkigtigntktikguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNTKTIKGUYBX2)
    public String getZrnkigtigntktikguybx2() {
        return zrnkigtigntktikguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtigntktikguybx2(String pZrnkigtigntktikguybx2) {
        zrnkigtigntktikguybx2 = pZrnkigtigntktikguybx2;
    }

    private String zrnkigtigntktikguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNTKTIKGUYBX3)
    public String getZrnkigtigntktikguybx3() {
        return zrnkigtigntktikguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtigntktikguybx3(String pZrnkigtigntktikguybx3) {
        zrnkigtigntktikguybx3 = pZrnkigtigntktikguybx3;
    }

    private String zrnkigtigntktikguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNTKTIKGUYBX4)
    public String getZrnkigtigntktikguybx4() {
        return zrnkigtigntktikguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtigntktikguybx4(String pZrnkigtigntktikguybx4) {
        zrnkigtigntktikguybx4 = pZrnkigtigntktikguybx4;
    }

    private String zrnkigtigntktikguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKIGTIGNTKTIKGUYBX5)
    public String getZrnkigtigntktikguybx5() {
        return zrnkigtigntktikguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtigntktikguybx5(String pZrnkigtigntktikguybx5) {
        zrnkigtigntktikguybx5 = pZrnkigtigntktikguybx5;
    }

    private String zrntuuintokuyakukigouyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTUUINTOKUYAKUKIGOUYOBIX1)
    public String getZrntuuintokuyakukigouyobix1() {
        return zrntuuintokuyakukigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuintokuyakukigouyobix1(String pZrntuuintokuyakukigouyobix1) {
        zrntuuintokuyakukigouyobix1 = pZrntuuintokuyakukigouyobix1;
    }

    private String zrntuuintokuyakukigouyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTUUINTOKUYAKUKIGOUYOBIX2)
    public String getZrntuuintokuyakukigouyobix2() {
        return zrntuuintokuyakukigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuintokuyakukigouyobix2(String pZrntuuintokuyakukigouyobix2) {
        zrntuuintokuyakukigouyobix2 = pZrntuuintokuyakukigouyobix2;
    }

    private String zrntuuintokuyakukigouyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTUUINTOKUYAKUKIGOUYOBIX3)
    public String getZrntuuintokuyakukigouyobix3() {
        return zrntuuintokuyakukigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuintokuyakukigouyobix3(String pZrntuuintokuyakukigouyobix3) {
        zrntuuintokuyakukigouyobix3 = pZrntuuintokuyakukigouyobix3;
    }

    private String zrntuuintokuyakukigouyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTUUINTOKUYAKUKIGOUYOBIX4)
    public String getZrntuuintokuyakukigouyobix4() {
        return zrntuuintokuyakukigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuintokuyakukigouyobix4(String pZrntuuintokuyakukigouyobix4) {
        zrntuuintokuyakukigouyobix4 = pZrntuuintokuyakukigouyobix4;
    }

    private String zrntuuintokuyakukigouyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTUUINTOKUYAKUKIGOUYOBIX5)
    public String getZrntuuintokuyakukigouyobix5() {
        return zrntuuintokuyakukigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuintokuyakukigouyobix5(String pZrntuuintokuyakukigouyobix5) {
        zrntuuintokuyakukigouyobix5 = pZrntuuintokuyakukigouyobix5;
    }

    private String zrnjysisppitkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNJYSISPPITKYKKGUYOBIX1)
    public String getZrnjysisppitkykkguyobix1() {
        return zrnjysisppitkykkguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjysisppitkykkguyobix1(String pZrnjysisppitkykkguyobix1) {
        zrnjysisppitkykkguyobix1 = pZrnjysisppitkykkguyobix1;
    }

    private String zrnjysisppitkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNJYSISPPITKYKKGUYOBIX2)
    public String getZrnjysisppitkykkguyobix2() {
        return zrnjysisppitkykkguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjysisppitkykkguyobix2(String pZrnjysisppitkykkguyobix2) {
        zrnjysisppitkykkguyobix2 = pZrnjysisppitkykkguyobix2;
    }

    private String zrnjysisppitkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNJYSISPPITKYKKGUYOBIX3)
    public String getZrnjysisppitkykkguyobix3() {
        return zrnjysisppitkykkguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjysisppitkykkguyobix3(String pZrnjysisppitkykkguyobix3) {
        zrnjysisppitkykkguyobix3 = pZrnjysisppitkykkguyobix3;
    }

    private String zrnjysisppitkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNJYSISPPITKYKKGUYOBIX4)
    public String getZrnjysisppitkykkguyobix4() {
        return zrnjysisppitkykkguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjysisppitkykkguyobix4(String pZrnjysisppitkykkguyobix4) {
        zrnjysisppitkykkguyobix4 = pZrnjysisppitkykkguyobix4;
    }

    private String zrnjysisppitkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNJYSISPPITKYKKGUYOBIX5)
    public String getZrnjysisppitkykkguyobix5() {
        return zrnjysisppitkykkguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjysisppitkykkguyobix5(String pZrnjysisppitkykkguyobix5) {
        zrnjysisppitkykkguyobix5 = pZrnjysisppitkykkguyobix5;
    }

    private String zrntksttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTKSTTKYKKGUYBX1)
    public String getZrntksttkykkguybx1() {
        return zrntksttkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkykkguybx1(String pZrntksttkykkguybx1) {
        zrntksttkykkguybx1 = pZrntksttkykkguybx1;
    }

    private String zrntksttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTKSTTKYKKGUYBX2)
    public String getZrntksttkykkguybx2() {
        return zrntksttkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkykkguybx2(String pZrntksttkykkguybx2) {
        zrntksttkykkguybx2 = pZrntksttkykkguybx2;
    }

    private String zrntksttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTKSTTKYKKGUYBX3)
    public String getZrntksttkykkguybx3() {
        return zrntksttkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkykkguybx3(String pZrntksttkykkguybx3) {
        zrntksttkykkguybx3 = pZrntksttkykkguybx3;
    }

    private String zrntksttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTKSTTKYKKGUYBX4)
    public String getZrntksttkykkguybx4() {
        return zrntksttkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkykkguybx4(String pZrntksttkykkguybx4) {
        zrntksttkykkguybx4 = pZrntksttkykkguybx4;
    }

    private String zrntksttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNTKSTTKYKKGUYBX5)
    public String getZrntksttkykkguybx5() {
        return zrntksttkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkykkguybx5(String pZrntksttkykkguybx5) {
        zrntksttkykkguybx5 = pZrntksttkykkguybx5;
    }

    private String zrndi2tksttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2TKSTTKYKKGUYBX1)
    public String getZrndi2tksttkykkguybx1() {
        return zrndi2tksttkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkykkguybx1(String pZrndi2tksttkykkguybx1) {
        zrndi2tksttkykkguybx1 = pZrndi2tksttkykkguybx1;
    }

    private String zrndi2tksttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2TKSTTKYKKGUYBX2)
    public String getZrndi2tksttkykkguybx2() {
        return zrndi2tksttkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkykkguybx2(String pZrndi2tksttkykkguybx2) {
        zrndi2tksttkykkguybx2 = pZrndi2tksttkykkguybx2;
    }

    private String zrndi2tksttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2TKSTTKYKKGUYBX3)
    public String getZrndi2tksttkykkguybx3() {
        return zrndi2tksttkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkykkguybx3(String pZrndi2tksttkykkguybx3) {
        zrndi2tksttkykkguybx3 = pZrndi2tksttkykkguybx3;
    }

    private String zrndi2tksttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2TKSTTKYKKGUYBX4)
    public String getZrndi2tksttkykkguybx4() {
        return zrndi2tksttkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkykkguybx4(String pZrndi2tksttkykkguybx4) {
        zrndi2tksttkykkguybx4 = pZrndi2tksttkykkguybx4;
    }

    private String zrndi2tksttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2TKSTTKYKKGUYBX5)
    public String getZrndi2tksttkykkguybx5() {
        return zrndi2tksttkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkykkguybx5(String pZrndi2tksttkykkguybx5) {
        zrndi2tksttkykkguybx5 = pZrndi2tksttkykkguybx5;
    }

    private String zrnmnsttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMNSTTKYKKGUYBX1)
    public String getZrnmnsttkykkguybx1() {
        return zrnmnsttkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmnsttkykkguybx1(String pZrnmnsttkykkguybx1) {
        zrnmnsttkykkguybx1 = pZrnmnsttkykkguybx1;
    }

    private String zrnmnsttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMNSTTKYKKGUYBX2)
    public String getZrnmnsttkykkguybx2() {
        return zrnmnsttkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmnsttkykkguybx2(String pZrnmnsttkykkguybx2) {
        zrnmnsttkykkguybx2 = pZrnmnsttkykkguybx2;
    }

    private String zrnmnsttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMNSTTKYKKGUYBX3)
    public String getZrnmnsttkykkguybx3() {
        return zrnmnsttkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmnsttkykkguybx3(String pZrnmnsttkykkguybx3) {
        zrnmnsttkykkguybx3 = pZrnmnsttkykkguybx3;
    }

    private String zrnmnsttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMNSTTKYKKGUYBX4)
    public String getZrnmnsttkykkguybx4() {
        return zrnmnsttkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmnsttkykkguybx4(String pZrnmnsttkykkguybx4) {
        zrnmnsttkykkguybx4 = pZrnmnsttkykkguybx4;
    }

    private String zrnmnsttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNMNSTTKYKKGUYBX5)
    public String getZrnmnsttkykkguybx5() {
        return zrnmnsttkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmnsttkykkguybx5(String pZrnmnsttkykkguybx5) {
        zrnmnsttkykkguybx5 = pZrnmnsttkykkguybx5;
    }

    private String zrndi2mnsttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2MNSTTKYKKGUYBX1)
    public String getZrndi2mnsttkykkguybx1() {
        return zrndi2mnsttkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2mnsttkykkguybx1(String pZrndi2mnsttkykkguybx1) {
        zrndi2mnsttkykkguybx1 = pZrndi2mnsttkykkguybx1;
    }

    private String zrndi2mnsttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2MNSTTKYKKGUYBX2)
    public String getZrndi2mnsttkykkguybx2() {
        return zrndi2mnsttkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2mnsttkykkguybx2(String pZrndi2mnsttkykkguybx2) {
        zrndi2mnsttkykkguybx2 = pZrndi2mnsttkykkguybx2;
    }

    private String zrndi2mnsttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2MNSTTKYKKGUYBX3)
    public String getZrndi2mnsttkykkguybx3() {
        return zrndi2mnsttkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2mnsttkykkguybx3(String pZrndi2mnsttkykkguybx3) {
        zrndi2mnsttkykkguybx3 = pZrndi2mnsttkykkguybx3;
    }

    private String zrndi2mnsttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2MNSTTKYKKGUYBX4)
    public String getZrndi2mnsttkykkguybx4() {
        return zrndi2mnsttkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2mnsttkykkguybx4(String pZrndi2mnsttkykkguybx4) {
        zrndi2mnsttkykkguybx4 = pZrndi2mnsttkykkguybx4;
    }

    private String zrndi2mnsttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2MNSTTKYKKGUYBX5)
    public String getZrndi2mnsttkykkguybx5() {
        return zrndi2mnsttkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2mnsttkykkguybx5(String pZrndi2mnsttkykkguybx5) {
        zrndi2mnsttkykkguybx5 = pZrndi2mnsttkykkguybx5;
    }

    private String zrnsugusnsyutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSUGUSNSYUTKYKKGUYBX1)
    public String getZrnsugusnsyutkykkguybx1() {
        return zrnsugusnsyutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsugusnsyutkykkguybx1(String pZrnsugusnsyutkykkguybx1) {
        zrnsugusnsyutkykkguybx1 = pZrnsugusnsyutkykkguybx1;
    }

    private String zrnsugusnsyutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSUGUSNSYUTKYKKGUYBX2)
    public String getZrnsugusnsyutkykkguybx2() {
        return zrnsugusnsyutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsugusnsyutkykkguybx2(String pZrnsugusnsyutkykkguybx2) {
        zrnsugusnsyutkykkguybx2 = pZrnsugusnsyutkykkguybx2;
    }

    private String zrnsugusnsyutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSUGUSNSYUTKYKKGUYBX3)
    public String getZrnsugusnsyutkykkguybx3() {
        return zrnsugusnsyutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsugusnsyutkykkguybx3(String pZrnsugusnsyutkykkguybx3) {
        zrnsugusnsyutkykkguybx3 = pZrnsugusnsyutkykkguybx3;
    }

    private String zrnsugusnsyutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSUGUSNSYUTKYKKGUYBX4)
    public String getZrnsugusnsyutkykkguybx4() {
        return zrnsugusnsyutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsugusnsyutkykkguybx4(String pZrnsugusnsyutkykkguybx4) {
        zrnsugusnsyutkykkguybx4 = pZrnsugusnsyutkykkguybx4;
    }

    private String zrnsugusnsyutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSUGUSNSYUTKYKKGUYBX5)
    public String getZrnsugusnsyutkykkguybx5() {
        return zrnsugusnsyutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsugusnsyutkykkguybx5(String pZrnsugusnsyutkykkguybx5) {
        zrnsugusnsyutkykkguybx5 = pZrnsugusnsyutkykkguybx5;
    }

    private String zrnkaigonktkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKTKYKKGUYOBIX1)
    public String getZrnkaigonktkykkguyobix1() {
        return zrnkaigonktkykkguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonktkykkguyobix1(String pZrnkaigonktkykkguyobix1) {
        zrnkaigonktkykkguyobix1 = pZrnkaigonktkykkguyobix1;
    }

    private String zrnkaigonktkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKTKYKKGUYOBIX2)
    public String getZrnkaigonktkykkguyobix2() {
        return zrnkaigonktkykkguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonktkykkguyobix2(String pZrnkaigonktkykkguyobix2) {
        zrnkaigonktkykkguyobix2 = pZrnkaigonktkykkguyobix2;
    }

    private String zrnkaigonktkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKTKYKKGUYOBIX3)
    public String getZrnkaigonktkykkguyobix3() {
        return zrnkaigonktkykkguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonktkykkguyobix3(String pZrnkaigonktkykkguyobix3) {
        zrnkaigonktkykkguyobix3 = pZrnkaigonktkykkguyobix3;
    }

    private String zrnkaigonktkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKTKYKKGUYOBIX4)
    public String getZrnkaigonktkykkguyobix4() {
        return zrnkaigonktkykkguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonktkykkguyobix4(String pZrnkaigonktkykkguyobix4) {
        zrnkaigonktkykkguyobix4 = pZrnkaigonktkykkguyobix4;
    }

    private String zrnkaigonktkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNKAIGONKTKYKKGUYOBIX5)
    public String getZrnkaigonktkykkguyobix5() {
        return zrnkaigonktkykkguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonktkykkguyobix5(String pZrnkaigonktkykkguyobix5) {
        zrnkaigonktkykkguyobix5 = pZrnkaigonktkykkguyobix5;
    }

    private String zrnitjbrkignktkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNITJBRKIGNKTKYKKGUYBX1)
    public String getZrnitjbrkignktkykkguybx1() {
        return zrnitjbrkignktkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrkignktkykkguybx1(String pZrnitjbrkignktkykkguybx1) {
        zrnitjbrkignktkykkguybx1 = pZrnitjbrkignktkykkguybx1;
    }

    private String zrnitjbrkignktkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNITJBRKIGNKTKYKKGUYBX2)
    public String getZrnitjbrkignktkykkguybx2() {
        return zrnitjbrkignktkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrkignktkykkguybx2(String pZrnitjbrkignktkykkguybx2) {
        zrnitjbrkignktkykkguybx2 = pZrnitjbrkignktkykkguybx2;
    }

    private String zrnitjbrkignktkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNITJBRKIGNKTKYKKGUYBX3)
    public String getZrnitjbrkignktkykkguybx3() {
        return zrnitjbrkignktkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrkignktkykkguybx3(String pZrnitjbrkignktkykkguybx3) {
        zrnitjbrkignktkykkguybx3 = pZrnitjbrkignktkykkguybx3;
    }

    private String zrnitjbrkignktkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNITJBRKIGNKTKYKKGUYBX4)
    public String getZrnitjbrkignktkykkguybx4() {
        return zrnitjbrkignktkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrkignktkykkguybx4(String pZrnitjbrkignktkykkguybx4) {
        zrnitjbrkignktkykkguybx4 = pZrnitjbrkignktkykkguybx4;
    }

    private String zrnitjbrkignktkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNITJBRKIGNKTKYKKGUYBX5)
    public String getZrnitjbrkignktkykkguybx5() {
        return zrnitjbrkignktkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrkignktkykkguybx5(String pZrnitjbrkignktkykkguybx5) {
        zrnitjbrkignktkykkguybx5 = pZrnitjbrkignktkykkguybx5;
    }

    private String zrndi2syugitkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYUGITKYKKGUYBX1)
    public String getZrndi2syugitkykkguybx1() {
        return zrndi2syugitkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2syugitkykkguybx1(String pZrndi2syugitkykkguybx1) {
        zrndi2syugitkykkguybx1 = pZrndi2syugitkykkguybx1;
    }

    private String zrndi2syugitkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYUGITKYKKGUYBX2)
    public String getZrndi2syugitkykkguybx2() {
        return zrndi2syugitkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2syugitkykkguybx2(String pZrndi2syugitkykkguybx2) {
        zrndi2syugitkykkguybx2 = pZrndi2syugitkykkguybx2;
    }

    private String zrndi2syugitkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYUGITKYKKGUYBX3)
    public String getZrndi2syugitkykkguybx3() {
        return zrndi2syugitkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2syugitkykkguybx3(String pZrndi2syugitkykkguybx3) {
        zrndi2syugitkykkguybx3 = pZrndi2syugitkykkguybx3;
    }

    private String zrndi2syugitkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYUGITKYKKGUYBX4)
    public String getZrndi2syugitkykkguybx4() {
        return zrndi2syugitkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2syugitkykkguybx4(String pZrndi2syugitkykkguybx4) {
        zrndi2syugitkykkguybx4 = pZrndi2syugitkykkguybx4;
    }

    private String zrndi2syugitkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYUGITKYKKGUYBX5)
    public String getZrndi2syugitkykkguybx5() {
        return zrndi2syugitkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2syugitkykkguybx5(String pZrndi2syugitkykkguybx5) {
        zrndi2syugitkykkguybx5 = pZrndi2syugitkykkguybx5;
    }

    private String zrndi2sigiwrmstkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGIWRMSTKYKKGUYBX1)
    public String getZrndi2sigiwrmstkykkguybx1() {
        return zrndi2sigiwrmstkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sigiwrmstkykkguybx1(String pZrndi2sigiwrmstkykkguybx1) {
        zrndi2sigiwrmstkykkguybx1 = pZrndi2sigiwrmstkykkguybx1;
    }

    private String zrndi2sigiwrmstkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGIWRMSTKYKKGUYBX2)
    public String getZrndi2sigiwrmstkykkguybx2() {
        return zrndi2sigiwrmstkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sigiwrmstkykkguybx2(String pZrndi2sigiwrmstkykkguybx2) {
        zrndi2sigiwrmstkykkguybx2 = pZrndi2sigiwrmstkykkguybx2;
    }

    private String zrndi2sigiwrmstkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGIWRMSTKYKKGUYBX3)
    public String getZrndi2sigiwrmstkykkguybx3() {
        return zrndi2sigiwrmstkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sigiwrmstkykkguybx3(String pZrndi2sigiwrmstkykkguybx3) {
        zrndi2sigiwrmstkykkguybx3 = pZrndi2sigiwrmstkykkguybx3;
    }

    private String zrndi2sigiwrmstkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGIWRMSTKYKKGUYBX4)
    public String getZrndi2sigiwrmstkykkguybx4() {
        return zrndi2sigiwrmstkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sigiwrmstkykkguybx4(String pZrndi2sigiwrmstkykkguybx4) {
        zrndi2sigiwrmstkykkguybx4 = pZrndi2sigiwrmstkykkguybx4;
    }

    private String zrndi2sigiwrmstkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGIWRMSTKYKKGUYBX5)
    public String getZrndi2sigiwrmstkykkguybx5() {
        return zrndi2sigiwrmstkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sigiwrmstkykkguybx5(String pZrndi2sigiwrmstkykkguybx5) {
        zrndi2sigiwrmstkykkguybx5 = pZrndi2sigiwrmstkykkguybx5;
    }

    private String zrndi2siginyuintkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGINYUINTKYKKGUYBX1)
    public String getZrndi2siginyuintkykkguybx1() {
        return zrndi2siginyuintkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2siginyuintkykkguybx1(String pZrndi2siginyuintkykkguybx1) {
        zrndi2siginyuintkykkguybx1 = pZrndi2siginyuintkykkguybx1;
    }

    private String zrndi2siginyuintkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGINYUINTKYKKGUYBX2)
    public String getZrndi2siginyuintkykkguybx2() {
        return zrndi2siginyuintkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2siginyuintkykkguybx2(String pZrndi2siginyuintkykkguybx2) {
        zrndi2siginyuintkykkguybx2 = pZrndi2siginyuintkykkguybx2;
    }

    private String zrndi2siginyuintkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGINYUINTKYKKGUYBX3)
    public String getZrndi2siginyuintkykkguybx3() {
        return zrndi2siginyuintkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2siginyuintkykkguybx3(String pZrndi2siginyuintkykkguybx3) {
        zrndi2siginyuintkykkguybx3 = pZrndi2siginyuintkykkguybx3;
    }

    private String zrndi2siginyuintkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGINYUINTKYKKGUYBX4)
    public String getZrndi2siginyuintkykkguybx4() {
        return zrndi2siginyuintkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2siginyuintkykkguybx4(String pZrndi2siginyuintkykkguybx4) {
        zrndi2siginyuintkykkguybx4 = pZrndi2siginyuintkykkguybx4;
    }

    private String zrndi2siginyuintkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIGINYUINTKYKKGUYBX5)
    public String getZrndi2siginyuintkykkguybx5() {
        return zrndi2siginyuintkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2siginyuintkykkguybx5(String pZrndi2siginyuintkykkguybx5) {
        zrndi2siginyuintkykkguybx5 = pZrndi2siginyuintkykkguybx5;
    }

    private String zrndi2sppinyuintkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SPPINYUINTKYKKGUYBX1)
    public String getZrndi2sppinyuintkykkguybx1() {
        return zrndi2sppinyuintkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sppinyuintkykkguybx1(String pZrndi2sppinyuintkykkguybx1) {
        zrndi2sppinyuintkykkguybx1 = pZrndi2sppinyuintkykkguybx1;
    }

    private String zrndi2sppinyuintkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SPPINYUINTKYKKGUYBX2)
    public String getZrndi2sppinyuintkykkguybx2() {
        return zrndi2sppinyuintkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sppinyuintkykkguybx2(String pZrndi2sppinyuintkykkguybx2) {
        zrndi2sppinyuintkykkguybx2 = pZrndi2sppinyuintkykkguybx2;
    }

    private String zrndi2sppinyuintkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SPPINYUINTKYKKGUYBX3)
    public String getZrndi2sppinyuintkykkguybx3() {
        return zrndi2sppinyuintkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sppinyuintkykkguybx3(String pZrndi2sppinyuintkykkguybx3) {
        zrndi2sppinyuintkykkguybx3 = pZrndi2sppinyuintkykkguybx3;
    }

    private String zrndi2sppinyuintkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SPPINYUINTKYKKGUYBX4)
    public String getZrndi2sppinyuintkykkguybx4() {
        return zrndi2sppinyuintkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sppinyuintkykkguybx4(String pZrndi2sppinyuintkykkguybx4) {
        zrndi2sppinyuintkykkguybx4 = pZrndi2sppinyuintkykkguybx4;
    }

    private String zrndi2sppinyuintkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SPPINYUINTKYKKGUYBX5)
    public String getZrndi2sppinyuintkykkguybx5() {
        return zrndi2sppinyuintkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sppinyuintkykkguybx5(String pZrndi2sppinyuintkykkguybx5) {
        zrndi2sppinyuintkykkguybx5 = pZrndi2sppinyuintkykkguybx5;
    }

    private String zrndi2sijnbyutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIJNBYUTKYKKGUYBX1)
    public String getZrndi2sijnbyutkykkguybx1() {
        return zrndi2sijnbyutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sijnbyutkykkguybx1(String pZrndi2sijnbyutkykkguybx1) {
        zrndi2sijnbyutkykkguybx1 = pZrndi2sijnbyutkykkguybx1;
    }

    private String zrndi2sijnbyutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIJNBYUTKYKKGUYBX2)
    public String getZrndi2sijnbyutkykkguybx2() {
        return zrndi2sijnbyutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sijnbyutkykkguybx2(String pZrndi2sijnbyutkykkguybx2) {
        zrndi2sijnbyutkykkguybx2 = pZrndi2sijnbyutkykkguybx2;
    }

    private String zrndi2sijnbyutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIJNBYUTKYKKGUYBX3)
    public String getZrndi2sijnbyutkykkguybx3() {
        return zrndi2sijnbyutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sijnbyutkykkguybx3(String pZrndi2sijnbyutkykkguybx3) {
        zrndi2sijnbyutkykkguybx3 = pZrndi2sijnbyutkykkguybx3;
    }

    private String zrndi2sijnbyutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIJNBYUTKYKKGUYBX4)
    public String getZrndi2sijnbyutkykkguybx4() {
        return zrndi2sijnbyutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sijnbyutkykkguybx4(String pZrndi2sijnbyutkykkguybx4) {
        zrndi2sijnbyutkykkguybx4 = pZrndi2sijnbyutkykkguybx4;
    }

    private String zrndi2sijnbyutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SIJNBYUTKYKKGUYBX5)
    public String getZrndi2sijnbyutkykkguybx5() {
        return zrndi2sijnbyutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sijnbyutkykkguybx5(String pZrndi2sijnbyutkykkguybx5) {
        zrndi2sijnbyutkykkguybx5 = pZrndi2sijnbyutkykkguybx5;
    }

    private String zrndai2tuintkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDAI2TUINTKYKKGUYOBIX1)
    public String getZrndai2tuintkykkguyobix1() {
        return zrndai2tuintkykkguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tuintkykkguyobix1(String pZrndai2tuintkykkguyobix1) {
        zrndai2tuintkykkguyobix1 = pZrndai2tuintkykkguyobix1;
    }

    private String zrndai2tuintkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDAI2TUINTKYKKGUYOBIX2)
    public String getZrndai2tuintkykkguyobix2() {
        return zrndai2tuintkykkguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tuintkykkguyobix2(String pZrndai2tuintkykkguyobix2) {
        zrndai2tuintkykkguyobix2 = pZrndai2tuintkykkguyobix2;
    }

    private String zrndai2tuintkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDAI2TUINTKYKKGUYOBIX3)
    public String getZrndai2tuintkykkguyobix3() {
        return zrndai2tuintkykkguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tuintkykkguyobix3(String pZrndai2tuintkykkguyobix3) {
        zrndai2tuintkykkguyobix3 = pZrndai2tuintkykkguyobix3;
    }

    private String zrndai2tuintkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDAI2TUINTKYKKGUYOBIX4)
    public String getZrndai2tuintkykkguyobix4() {
        return zrndai2tuintkykkguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tuintkykkguyobix4(String pZrndai2tuintkykkguyobix4) {
        zrndai2tuintkykkguyobix4 = pZrndai2tuintkykkguyobix4;
    }

    private String zrndai2tuintkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDAI2TUINTKYKKGUYOBIX5)
    public String getZrndai2tuintkykkguyobix5() {
        return zrndai2tuintkykkguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tuintkykkguyobix5(String pZrndai2tuintkykkguyobix5) {
        zrndai2tuintkykkguyobix5 = pZrndai2tuintkykkguyobix5;
    }

    private String zrndi2jysisppitkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2JYSISPPITKYKKGUYBX1)
    public String getZrndi2jysisppitkykkguybx1() {
        return zrndi2jysisppitkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jysisppitkykkguybx1(String pZrndi2jysisppitkykkguybx1) {
        zrndi2jysisppitkykkguybx1 = pZrndi2jysisppitkykkguybx1;
    }

    private String zrndi2jysisppitkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2JYSISPPITKYKKGUYBX2)
    public String getZrndi2jysisppitkykkguybx2() {
        return zrndi2jysisppitkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jysisppitkykkguybx2(String pZrndi2jysisppitkykkguybx2) {
        zrndi2jysisppitkykkguybx2 = pZrndi2jysisppitkykkguybx2;
    }

    private String zrndi2jysisppitkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2JYSISPPITKYKKGUYBX3)
    public String getZrndi2jysisppitkykkguybx3() {
        return zrndi2jysisppitkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jysisppitkykkguybx3(String pZrndi2jysisppitkykkguybx3) {
        zrndi2jysisppitkykkguybx3 = pZrndi2jysisppitkykkguybx3;
    }

    private String zrndi2jysisppitkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2JYSISPPITKYKKGUYBX4)
    public String getZrndi2jysisppitkykkguybx4() {
        return zrndi2jysisppitkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jysisppitkykkguybx4(String pZrndi2jysisppitkykkguybx4) {
        zrndi2jysisppitkykkguybx4 = pZrndi2jysisppitkykkguybx4;
    }

    private String zrndi2jysisppitkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2JYSISPPITKYKKGUYBX5)
    public String getZrndi2jysisppitkykkguybx5() {
        return zrndi2jysisppitkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jysisppitkykkguybx5(String pZrndi2jysisppitkykkguybx5) {
        zrndi2jysisppitkykkguybx5 = pZrndi2jysisppitkykkguybx5;
    }

    private String zrndi2sugusnsyutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SUGUSNSYUTKYKKGUYBX1)
    public String getZrndi2sugusnsyutkykkguybx1() {
        return zrndi2sugusnsyutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sugusnsyutkykkguybx1(String pZrndi2sugusnsyutkykkguybx1) {
        zrndi2sugusnsyutkykkguybx1 = pZrndi2sugusnsyutkykkguybx1;
    }

    private String zrndi2sugusnsyutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SUGUSNSYUTKYKKGUYBX2)
    public String getZrndi2sugusnsyutkykkguybx2() {
        return zrndi2sugusnsyutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sugusnsyutkykkguybx2(String pZrndi2sugusnsyutkykkguybx2) {
        zrndi2sugusnsyutkykkguybx2 = pZrndi2sugusnsyutkykkguybx2;
    }

    private String zrndi2sugusnsyutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SUGUSNSYUTKYKKGUYBX3)
    public String getZrndi2sugusnsyutkykkguybx3() {
        return zrndi2sugusnsyutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sugusnsyutkykkguybx3(String pZrndi2sugusnsyutkykkguybx3) {
        zrndi2sugusnsyutkykkguybx3 = pZrndi2sugusnsyutkykkguybx3;
    }

    private String zrndi2sugusnsyutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SUGUSNSYUTKYKKGUYBX4)
    public String getZrndi2sugusnsyutkykkguybx4() {
        return zrndi2sugusnsyutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sugusnsyutkykkguybx4(String pZrndi2sugusnsyutkykkguybx4) {
        zrndi2sugusnsyutkykkguybx4 = pZrndi2sugusnsyutkykkguybx4;
    }

    private String zrndi2sugusnsyutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SUGUSNSYUTKYKKGUYBX5)
    public String getZrndi2sugusnsyutkykkguybx5() {
        return zrndi2sugusnsyutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sugusnsyutkykkguybx5(String pZrndi2sugusnsyutkykkguybx5) {
        zrndi2sugusnsyutkykkguybx5 = pZrndi2sugusnsyutkykkguybx5;
    }

    private String zrndi2sykkyuhtkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYKKYUHTKYKKGUYBX1)
    public String getZrndi2sykkyuhtkykkguybx1() {
        return zrndi2sykkyuhtkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sykkyuhtkykkguybx1(String pZrndi2sykkyuhtkykkguybx1) {
        zrndi2sykkyuhtkykkguybx1 = pZrndi2sykkyuhtkykkguybx1;
    }

    private String zrndi2sykkyuhtkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYKKYUHTKYKKGUYBX2)
    public String getZrndi2sykkyuhtkykkguybx2() {
        return zrndi2sykkyuhtkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sykkyuhtkykkguybx2(String pZrndi2sykkyuhtkykkguybx2) {
        zrndi2sykkyuhtkykkguybx2 = pZrndi2sykkyuhtkykkguybx2;
    }

    private String zrndi2sykkyuhtkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYKKYUHTKYKKGUYBX3)
    public String getZrndi2sykkyuhtkykkguybx3() {
        return zrndi2sykkyuhtkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sykkyuhtkykkguybx3(String pZrndi2sykkyuhtkykkguybx3) {
        zrndi2sykkyuhtkykkguybx3 = pZrndi2sykkyuhtkykkguybx3;
    }

    private String zrndi2sykkyuhtkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYKKYUHTKYKKGUYBX4)
    public String getZrndi2sykkyuhtkykkguybx4() {
        return zrndi2sykkyuhtkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sykkyuhtkykkguybx4(String pZrndi2sykkyuhtkykkguybx4) {
        zrndi2sykkyuhtkykkguybx4 = pZrndi2sykkyuhtkykkguybx4;
    }

    private String zrndi2sykkyuhtkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNDI2SYKKYUHTKYKKGUYBX5)
    public String getZrndi2sykkyuhtkykkguybx5() {
        return zrndi2sykkyuhtkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sykkyuhtkykkguybx5(String pZrndi2sykkyuhtkykkguybx5) {
        zrndi2sykkyuhtkykkguybx5 = pZrndi2sykkyuhtkykkguybx5;
    }

    private String zrnsetaitehknsyuruiyobi1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X1)
    public String getZrnsetaitehknsyuruiyobi1x1() {
        return zrnsetaitehknsyuruiyobi1x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x1(String pZrnsetaitehknsyuruiyobi1x1) {
        zrnsetaitehknsyuruiyobi1x1 = pZrnsetaitehknsyuruiyobi1x1;
    }

    private String zrnsetaitehknsyuruiyobi1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X2)
    public String getZrnsetaitehknsyuruiyobi1x2() {
        return zrnsetaitehknsyuruiyobi1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x2(String pZrnsetaitehknsyuruiyobi1x2) {
        zrnsetaitehknsyuruiyobi1x2 = pZrnsetaitehknsyuruiyobi1x2;
    }

    private String zrnsetaitehknsyuruiyobi1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X3)
    public String getZrnsetaitehknsyuruiyobi1x3() {
        return zrnsetaitehknsyuruiyobi1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x3(String pZrnsetaitehknsyuruiyobi1x3) {
        zrnsetaitehknsyuruiyobi1x3 = pZrnsetaitehknsyuruiyobi1x3;
    }

    private String zrnsetaitehknsyuruiyobi1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X4)
    public String getZrnsetaitehknsyuruiyobi1x4() {
        return zrnsetaitehknsyuruiyobi1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x4(String pZrnsetaitehknsyuruiyobi1x4) {
        zrnsetaitehknsyuruiyobi1x4 = pZrnsetaitehknsyuruiyobi1x4;
    }

    private String zrnsetaitehknsyuruiyobi1x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X5)
    public String getZrnsetaitehknsyuruiyobi1x5() {
        return zrnsetaitehknsyuruiyobi1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x5(String pZrnsetaitehknsyuruiyobi1x5) {
        zrnsetaitehknsyuruiyobi1x5 = pZrnsetaitehknsyuruiyobi1x5;
    }

    private String zrnsetaitehknsyuruiyobi1x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X6)
    public String getZrnsetaitehknsyuruiyobi1x6() {
        return zrnsetaitehknsyuruiyobi1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x6(String pZrnsetaitehknsyuruiyobi1x6) {
        zrnsetaitehknsyuruiyobi1x6 = pZrnsetaitehknsyuruiyobi1x6;
    }

    private String zrnsetaitehknsyuruiyobi1x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X7)
    public String getZrnsetaitehknsyuruiyobi1x7() {
        return zrnsetaitehknsyuruiyobi1x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x7(String pZrnsetaitehknsyuruiyobi1x7) {
        zrnsetaitehknsyuruiyobi1x7 = pZrnsetaitehknsyuruiyobi1x7;
    }

    private String zrnsetaitehknsyuruiyobi1x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X8)
    public String getZrnsetaitehknsyuruiyobi1x8() {
        return zrnsetaitehknsyuruiyobi1x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x8(String pZrnsetaitehknsyuruiyobi1x8) {
        zrnsetaitehknsyuruiyobi1x8 = pZrnsetaitehknsyuruiyobi1x8;
    }

    private String zrnsetaitehknsyuruiyobi1x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X9)
    public String getZrnsetaitehknsyuruiyobi1x9() {
        return zrnsetaitehknsyuruiyobi1x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x9(String pZrnsetaitehknsyuruiyobi1x9) {
        zrnsetaitehknsyuruiyobi1x9 = pZrnsetaitehknsyuruiyobi1x9;
    }

    private String zrnsetaitehknsyuruiyobi1x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X10)
    public String getZrnsetaitehknsyuruiyobi1x10() {
        return zrnsetaitehknsyuruiyobi1x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x10(String pZrnsetaitehknsyuruiyobi1x10) {
        zrnsetaitehknsyuruiyobi1x10 = pZrnsetaitehknsyuruiyobi1x10;
    }

    private String zrnsetaitehknsyuruiyobi1x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X11)
    public String getZrnsetaitehknsyuruiyobi1x11() {
        return zrnsetaitehknsyuruiyobi1x11;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x11(String pZrnsetaitehknsyuruiyobi1x11) {
        zrnsetaitehknsyuruiyobi1x11 = pZrnsetaitehknsyuruiyobi1x11;
    }

    private String zrnsetaitehknsyuruiyobi1x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X12)
    public String getZrnsetaitehknsyuruiyobi1x12() {
        return zrnsetaitehknsyuruiyobi1x12;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x12(String pZrnsetaitehknsyuruiyobi1x12) {
        zrnsetaitehknsyuruiyobi1x12 = pZrnsetaitehknsyuruiyobi1x12;
    }

    private String zrnsetaitehknsyuruiyobi1x13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X13)
    public String getZrnsetaitehknsyuruiyobi1x13() {
        return zrnsetaitehknsyuruiyobi1x13;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x13(String pZrnsetaitehknsyuruiyobi1x13) {
        zrnsetaitehknsyuruiyobi1x13 = pZrnsetaitehknsyuruiyobi1x13;
    }

    private String zrnsetaitehknsyuruiyobi1x14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X14)
    public String getZrnsetaitehknsyuruiyobi1x14() {
        return zrnsetaitehknsyuruiyobi1x14;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x14(String pZrnsetaitehknsyuruiyobi1x14) {
        zrnsetaitehknsyuruiyobi1x14 = pZrnsetaitehknsyuruiyobi1x14;
    }

    private String zrnsetaitehknsyuruiyobi1x15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI1X15)
    public String getZrnsetaitehknsyuruiyobi1x15() {
        return zrnsetaitehknsyuruiyobi1x15;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi1x15(String pZrnsetaitehknsyuruiyobi1x15) {
        zrnsetaitehknsyuruiyobi1x15 = pZrnsetaitehknsyuruiyobi1x15;
    }

    private String zrnsetaitehknsyuruiyobi2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X1)
    public String getZrnsetaitehknsyuruiyobi2x1() {
        return zrnsetaitehknsyuruiyobi2x1;
    }

    public void setZrnsetaitehknsyuruiyobi2x1(String pZrnsetaitehknsyuruiyobi2x1) {
        zrnsetaitehknsyuruiyobi2x1 = pZrnsetaitehknsyuruiyobi2x1;
    }

    private String zrnsetaitehknsyuruiyobi2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X2)
    public String getZrnsetaitehknsyuruiyobi2x2() {
        return zrnsetaitehknsyuruiyobi2x2;
    }

    public void setZrnsetaitehknsyuruiyobi2x2(String pZrnsetaitehknsyuruiyobi2x2) {
        zrnsetaitehknsyuruiyobi2x2 = pZrnsetaitehknsyuruiyobi2x2;
    }

    private String zrnsetaitehknsyuruiyobi2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X3)
    public String getZrnsetaitehknsyuruiyobi2x3() {
        return zrnsetaitehknsyuruiyobi2x3;
    }

    public void setZrnsetaitehknsyuruiyobi2x3(String pZrnsetaitehknsyuruiyobi2x3) {
        zrnsetaitehknsyuruiyobi2x3 = pZrnsetaitehknsyuruiyobi2x3;
    }

    private String zrnsetaitehknsyuruiyobi2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X4)
    public String getZrnsetaitehknsyuruiyobi2x4() {
        return zrnsetaitehknsyuruiyobi2x4;
    }

    public void setZrnsetaitehknsyuruiyobi2x4(String pZrnsetaitehknsyuruiyobi2x4) {
        zrnsetaitehknsyuruiyobi2x4 = pZrnsetaitehknsyuruiyobi2x4;
    }

    private String zrnsetaitehknsyuruiyobi2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X5)
    public String getZrnsetaitehknsyuruiyobi2x5() {
        return zrnsetaitehknsyuruiyobi2x5;
    }

    public void setZrnsetaitehknsyuruiyobi2x5(String pZrnsetaitehknsyuruiyobi2x5) {
        zrnsetaitehknsyuruiyobi2x5 = pZrnsetaitehknsyuruiyobi2x5;
    }

    private String zrnsetaitehknsyuruiyobi2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X6)
    public String getZrnsetaitehknsyuruiyobi2x6() {
        return zrnsetaitehknsyuruiyobi2x6;
    }

    public void setZrnsetaitehknsyuruiyobi2x6(String pZrnsetaitehknsyuruiyobi2x6) {
        zrnsetaitehknsyuruiyobi2x6 = pZrnsetaitehknsyuruiyobi2x6;
    }

    private String zrnsetaitehknsyuruiyobi2x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X7)
    public String getZrnsetaitehknsyuruiyobi2x7() {
        return zrnsetaitehknsyuruiyobi2x7;
    }

    public void setZrnsetaitehknsyuruiyobi2x7(String pZrnsetaitehknsyuruiyobi2x7) {
        zrnsetaitehknsyuruiyobi2x7 = pZrnsetaitehknsyuruiyobi2x7;
    }

    private String zrnsetaitehknsyuruiyobi2x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X8)
    public String getZrnsetaitehknsyuruiyobi2x8() {
        return zrnsetaitehknsyuruiyobi2x8;
    }

    public void setZrnsetaitehknsyuruiyobi2x8(String pZrnsetaitehknsyuruiyobi2x8) {
        zrnsetaitehknsyuruiyobi2x8 = pZrnsetaitehknsyuruiyobi2x8;
    }

    private String zrnsetaitehknsyuruiyobi2x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X9)
    public String getZrnsetaitehknsyuruiyobi2x9() {
        return zrnsetaitehknsyuruiyobi2x9;
    }

    public void setZrnsetaitehknsyuruiyobi2x9(String pZrnsetaitehknsyuruiyobi2x9) {
        zrnsetaitehknsyuruiyobi2x9 = pZrnsetaitehknsyuruiyobi2x9;
    }

    private String zrnsetaitehknsyuruiyobi2x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI2X10)
    public String getZrnsetaitehknsyuruiyobi2x10() {
        return zrnsetaitehknsyuruiyobi2x10;
    }

    public void setZrnsetaitehknsyuruiyobi2x10(String pZrnsetaitehknsyuruiyobi2x10) {
        zrnsetaitehknsyuruiyobi2x10 = pZrnsetaitehknsyuruiyobi2x10;
    }

    private String zrnsetaitehknsyuruiyobi3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X1)
    public String getZrnsetaitehknsyuruiyobi3x1() {
        return zrnsetaitehknsyuruiyobi3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x1(String pZrnsetaitehknsyuruiyobi3x1) {
        zrnsetaitehknsyuruiyobi3x1 = pZrnsetaitehknsyuruiyobi3x1;
    }

    private String zrnsetaitehknsyuruiyobi3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X2)
    public String getZrnsetaitehknsyuruiyobi3x2() {
        return zrnsetaitehknsyuruiyobi3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x2(String pZrnsetaitehknsyuruiyobi3x2) {
        zrnsetaitehknsyuruiyobi3x2 = pZrnsetaitehknsyuruiyobi3x2;
    }

    private String zrnsetaitehknsyuruiyobi3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X3)
    public String getZrnsetaitehknsyuruiyobi3x3() {
        return zrnsetaitehknsyuruiyobi3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x3(String pZrnsetaitehknsyuruiyobi3x3) {
        zrnsetaitehknsyuruiyobi3x3 = pZrnsetaitehknsyuruiyobi3x3;
    }

    private String zrnsetaitehknsyuruiyobi3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X4)
    public String getZrnsetaitehknsyuruiyobi3x4() {
        return zrnsetaitehknsyuruiyobi3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x4(String pZrnsetaitehknsyuruiyobi3x4) {
        zrnsetaitehknsyuruiyobi3x4 = pZrnsetaitehknsyuruiyobi3x4;
    }

    private String zrnsetaitehknsyuruiyobi3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X5)
    public String getZrnsetaitehknsyuruiyobi3x5() {
        return zrnsetaitehknsyuruiyobi3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x5(String pZrnsetaitehknsyuruiyobi3x5) {
        zrnsetaitehknsyuruiyobi3x5 = pZrnsetaitehknsyuruiyobi3x5;
    }

    private String zrnsetaitehknsyuruiyobi3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X6)
    public String getZrnsetaitehknsyuruiyobi3x6() {
        return zrnsetaitehknsyuruiyobi3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x6(String pZrnsetaitehknsyuruiyobi3x6) {
        zrnsetaitehknsyuruiyobi3x6 = pZrnsetaitehknsyuruiyobi3x6;
    }

    private String zrnsetaitehknsyuruiyobi3x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X7)
    public String getZrnsetaitehknsyuruiyobi3x7() {
        return zrnsetaitehknsyuruiyobi3x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x7(String pZrnsetaitehknsyuruiyobi3x7) {
        zrnsetaitehknsyuruiyobi3x7 = pZrnsetaitehknsyuruiyobi3x7;
    }

    private String zrnsetaitehknsyuruiyobi3x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X8)
    public String getZrnsetaitehknsyuruiyobi3x8() {
        return zrnsetaitehknsyuruiyobi3x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x8(String pZrnsetaitehknsyuruiyobi3x8) {
        zrnsetaitehknsyuruiyobi3x8 = pZrnsetaitehknsyuruiyobi3x8;
    }

    private String zrnsetaitehknsyuruiyobi3x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X9)
    public String getZrnsetaitehknsyuruiyobi3x9() {
        return zrnsetaitehknsyuruiyobi3x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x9(String pZrnsetaitehknsyuruiyobi3x9) {
        zrnsetaitehknsyuruiyobi3x9 = pZrnsetaitehknsyuruiyobi3x9;
    }

    private String zrnsetaitehknsyuruiyobi3x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu3Rn.ZRNSETAITEHKNSYURUIYOBI3X10)
    public String getZrnsetaitehknsyuruiyobi3x10() {
        return zrnsetaitehknsyuruiyobi3x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitehknsyuruiyobi3x10(String pZrnsetaitehknsyuruiyobi3x10) {
        zrnsetaitehknsyuruiyobi3x10 = pZrnsetaitehknsyuruiyobi3x10;
    }
}