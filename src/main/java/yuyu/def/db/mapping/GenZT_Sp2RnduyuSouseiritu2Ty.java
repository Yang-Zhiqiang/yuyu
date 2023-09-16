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
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu2Ty;

/**
 * ＳＰ２連動用総成立Fテーブル２（中） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu2Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu2Ty}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル２（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyktgysyrymd ztyktgysyrymd}</td><td>（中継用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu2Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgyfilerenno ztyktgyfilerenno}</td><td>（中継用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteidairininkbn ztysiteidairininkbn}</td><td>（中継用）指定代理人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkykdrkbn ztysrkykdrkbn}</td><td>（中継用）数理用契約者代理人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x3 ztyyobiv6x3}</td><td>（中継用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneedstkykarihyj ztylivingneedstkykarihyj}</td><td>（中継用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x12 ztyyobiv4x12}</td><td>（中継用）予備項目Ｖ４＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansupporttkykarihyj ztygansupporttkykarihyj}</td><td>（中継用）がんサポート特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x13 ztyyobiv4x13}</td><td>（中継用）予備項目Ｖ４＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakusyuruikigou ztytuuintokuyakusyuruikigou}</td><td>（中継用）通院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakukikan ztytuuintokuyakukikan}</td><td>（中継用）通院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuintkykphrkkkn ztytuintkykphrkkkn}</td><td>（中継用）通院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakunitigaku ztytuuintokuyakunitigaku}</td><td>（中継用）通院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakup ztytuuintokuyakup}</td><td>（中継用）通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakugatakbn ztytuuintokuyakugatakbn}</td><td>（中継用）通院特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuintkjyuryumshyutn ztytuintkjyuryumshyutn}</td><td>（中継用）通院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytuuintokujyoup ztytuuintokujyoup}</td><td>（中継用）通院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuuintokuteibuicdx1 ztytuuintokuteibuicdx1}</td><td>（中継用）通院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuinhutanpokikanx1 ztytuuinhutanpokikanx1}</td><td>（中継用）通院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuteibuicdx2 ztytuuintokuteibuicdx2}</td><td>（中継用）通院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuinhutanpokikanx2 ztytuuinhutanpokikanx2}</td><td>（中継用）通院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuintkykkgusdkbn ztytuintkykkgusdkbn}</td><td>（中継用）通院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuintkykpwrbkkbn ztytuintkykpwrbkkbn}</td><td>（中継用）通院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x4 ztyyobiv3x4}</td><td>（中継用）予備項目Ｖ３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tuintkyksyrikgu ztydi2tuintkyksyrikgu}</td><td>（中継用）第２通院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokuyakukikan ztydai2tuuintokuyakukikan}</td><td>（中継用）第２通院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuintkykphrkkkn ztydai2tuintkykphrkkkn}</td><td>（中継用）第２通院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokuyakuntgk ztydai2tuuintokuyakuntgk}</td><td>（中継用）第２通院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokuyakup ztydai2tuuintokuyakup}</td><td>（中継用）第２通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokuyakugatakbn ztydai2tuuintokuyakugatakbn}</td><td>（中継用）第２通院特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tuintkjyuryumshyutn ztydi2tuintkjyuryumshyutn}</td><td>（中継用）第２通院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokujyoup ztydai2tuuintokujyoup}</td><td>（中継用）第２通院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokuteibuicdx1 ztydai2tuuintokuteibuicdx1}</td><td>（中継用）第２通院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuuinhutanpokikanx1 ztydai2tuuinhutanpokikanx1}</td><td>（中継用）第２通院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuuintokuteibuicdx2 ztydai2tuuintokuteibuicdx2}</td><td>（中継用）第２通院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tuuinhutanpokikanx2 ztydai2tuuinhutanpokikanx2}</td><td>（中継用）第２通院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tuintkykkgusdkbn ztydi2tuintkykkgusdkbn}</td><td>（中継用）第２通院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tuintkykpwrbkkbn ztydi2tuintkykpwrbkkbn}</td><td>（中継用）第２通院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x5 ztyyobiv3x5}</td><td>（中継用）予備項目Ｖ３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangotokuyakusyuruikigou ztykangotokuyakusyuruikigou}</td><td>（中継用）看護特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangotokuyakukikan ztykangotokuyakukikan}</td><td>（中継用）看護特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangotkykphrkkkn ztykangotkykphrkkkn}</td><td>（中継用）看護特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangotokuyakunitigaku ztykangotokuyakunitigaku}</td><td>（中継用）看護特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykangotokuyakup ztykangotokuyakup}</td><td>（中継用）看護特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykangotokuyakugatakbn ztykangotokuyakugatakbn}</td><td>（中継用）看護特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykngtkjyuryumshyutn ztykngtkjyuryumshyutn}</td><td>（中継用）看護特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykangotokujyoup ztykangotokujyoup}</td><td>（中継用）看護特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykangotokuteibuicdx1 ztykangotokuteibuicdx1}</td><td>（中継用）看護特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangohutanpokikanx1 ztykangohutanpokikanx1}</td><td>（中継用）看護不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangotokuteibuicdx2 ztykangotokuteibuicdx2}</td><td>（中継用）看護特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangohutanpokikanx2 ztykangohutanpokikanx2}</td><td>（中継用）看護不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2kngtkyksyrikgu ztydi2kngtkyksyrikgu}</td><td>（中継用）第２看護特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokuyakukikan ztydai2kangotokuyakukikan}</td><td>（中継用）第２看護特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kngtkykphrkkkn ztydai2kngtkykphrkkkn}</td><td>（中継用）第２看護特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokuyakuntgk ztydai2kangotokuyakuntgk}</td><td>（中継用）第２看護特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokuyakup ztydai2kangotokuyakup}</td><td>（中継用）第２看護特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokuyakugatakbn ztydai2kangotokuyakugatakbn}</td><td>（中継用）第２看護特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2kngtkjyuryumshyutn ztydi2kngtkjyuryumshyutn}</td><td>（中継用）第２看護特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokujyoup ztydai2kangotokujyoup}</td><td>（中継用）第２看護特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokuteibuicdx1 ztydai2kangotokuteibuicdx1}</td><td>（中継用）第２看護特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kangohutanpokikanx1 ztydai2kangohutanpokikanx1}</td><td>（中継用）第２看護不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kangotokuteibuicdx2 ztydai2kangotokuteibuicdx2}</td><td>（中継用）第２看護特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kangohutanpokikanx2 ztydai2kangohutanpokikanx2}</td><td>（中継用）第２看護不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x2 ztyyobiv6x2}</td><td>（中継用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkyksyuruikgu ztyjysisppitkyksyuruikgu}</td><td>（中継用）女性疾病特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkkn ztyjysisppitkykkkn}</td><td>（中継用）女性疾病特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykphrkkkn ztyjysisppitkykphrkkkn}</td><td>（中継用）女性疾病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykntgk ztyjysisppitkykntgk}</td><td>（中継用）女性疾病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyjyoseisippeitokuyakup ztyjyoseisippeitokuyakup}</td><td>（中継用）女性疾病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkjyuryumshyutn ztyjysisppitkjyuryumshyutn}</td><td>（中継用）女性疾病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyjyoseisippeitokujyoup ztyjyoseisippeitokujyoup}</td><td>（中継用）女性疾病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjysisppitktbicdx1 ztyjysisppitktbicdx1}</td><td>（中継用）女性疾病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppihtnpkknx1 ztyjysisppihtnpkknx1}</td><td>（中継用）女性疾病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitktbicdx2 ztyjysisppitktbicdx2}</td><td>（中継用）女性疾病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppihtnpkknx2 ztyjysisppihtnpkknx2}</td><td>（中継用）女性疾病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkgusdkbn ztyjysisppitkykkgusdkbn}</td><td>（中継用）女性疾病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykpwrbkkbn ztyjysisppitkykpwrbkkbn}</td><td>（中継用）女性疾病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjysisppitkykkusnmnryoage ztyjysisppitkykkusnmnryoage}</td><td>（中継用）女性疾病特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x2 ztyyobiv2x2}</td><td>（中継用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkyksyrikgu ztydi2jysisppitkyksyrikgu}</td><td>（中継用）第２女性疾病特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkkn ztydi2jysisppitkykkkn}</td><td>（中継用）第２女性疾病特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykphrkkkn ztydi2jysisppitkykphrkkkn}</td><td>（中継用）第２女性疾病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykntgk ztydi2jysisppitkykntgk}</td><td>（中継用）第２女性疾病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykp ztydi2jysisppitkykp}</td><td>（中継用）第２女性疾病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkjyurymshytn ztydi2jysisppitkjyurymshytn}</td><td>（中継用）第２女性疾病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkjyup ztydi2jysisppitkjyup}</td><td>（中継用）第２女性疾病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitktbicdx1 ztydi2jysisppitktbicdx1}</td><td>（中継用）第２女性疾病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppihtnpkknx1 ztydi2jysisppihtnpkknx1}</td><td>（中継用）第２女性疾病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitktbicdx2 ztydi2jysisppitktbicdx2}</td><td>（中継用）第２女性疾病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppihtnpkknx2 ztydi2jysisppihtnpkknx2}</td><td>（中継用）第２女性疾病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykkgusdkbn ztydi2jysisppitkykkgusdkbn}</td><td>（中継用）第２女性疾病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jysisppitkykpwrbkkbn ztydi2jysisppitkykpwrbkkbn}</td><td>（中継用）第２女性疾病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x14 ztyyobiv4x14}</td><td>（中継用）予備項目Ｖ４＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywinninglifehyouji ztywinninglifehyouji}</td><td>（中継用）ウィニングライフ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystyouikusikinuktrininkbn ztystyouikusikinuktrininkbn}</td><td>（中継用）指定養育資金受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudthumeharaitkykarihyj ztyjyudthumeharaitkykarihyj}</td><td>（中継用）重度痴呆前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkenkouseikatupackhyj ztysinkenkouseikatupackhyj}</td><td>（中継用）新健康生活パック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakupwaribikikbn ztysyukeiyakupwaribikikbn}</td><td>（中継用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykyktnknyugukbn ztysykyktnknyugukbn}</td><td>（中継用）主契約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosjihonninkknnkbn ztymosjihonninkknnkbn}</td><td>（中継用）申込時本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenhonsuu ztykituenhonsuu}</td><td>（中継用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinmaetenkannensuukbn ztykousinmaetenkannensuukbn}</td><td>（中継用）更新前転換年数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankimaetenkannensuukbn ztymankimaetenkannensuukbn}</td><td>（中継用）満期前転換年数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikitenkanhyouji ztyseikitenkanhyouji}</td><td>（中継用）正規転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakutenkankykhyj ztygengakutenkankykhyj}</td><td>（中継用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x3 ztyyobiv2x3}</td><td>（中継用）予備項目Ｖ２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousin3nenmaetnknhyj ztykousin3nenmaetnknhyj}</td><td>（中継用）更新３年前転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydugktnknsntkhuhukbn ztydugktnknsntkhuhukbn}</td><td>（中継用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknsnstkbttrtkkbn ztytnknsnstkbttrtkkbn}</td><td>（中継用）転換診査特別取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiginyuintkykgkntgk ztyhtnknsiginyuintkykgkntgk}</td><td>（中継用）被転換災害入院特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiginyuintkykkykymd ztyhtnknsiginyuintkykkykymd}</td><td>（中継用）被転換災害入院特約契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiginyuintkyksnskbn ztyhtnknsiginyuintkyksnskbn}</td><td>（中継用）被転換災害入院特約診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsppinyuintkykgkntgk ztyhtnknsppinyuintkykgkntgk}</td><td>（中継用）被転換疾病入院特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknsppinyuintkykkykymd ztyhtnknsppinyuintkykkykymd}</td><td>（中継用）被転換疾病入院特約契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsppinyuintkyksnskbn ztyhtnknsppinyuintkyksnskbn}</td><td>（中継用）被転換疾病入院特約診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsijnbyutkykgukintgk ztyhtnknsijnbyutkykgukintgk}</td><td>（中継用）被転換成人病特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknsijnbyutkykkykymd ztyhtnknsijnbyutkykkykymd}</td><td>（中継用）被転換成人病特約契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsijnbyutkyksnskbn ztyhtnknsijnbyutkyksnskbn}</td><td>（中継用）被転換成人病特約診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjysisppitkykgkintgk ztyhtnknjysisppitkykgkintgk}</td><td>（中継用）被転換女性疾病特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknjysisppitkykkykymd ztyhtnknjysisppitkykkykymd}</td><td>（中継用）被転換女性疾病特約契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjysisppitkyksnskbn ztyhtnknjysisppitkyksnskbn}</td><td>（中継用）被転換女性疾病特約診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteizukipwarimasihyouji ztysiteizukipwarimasihyouji}</td><td>（中継用）指定月Ｐ割増表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim1 ztypwarimasisiteim1}</td><td>（中継用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim2 ztypwarimasisiteim2}</td><td>（中継用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteimsykykpbairitu ztysiteimsykykpbairitu}</td><td>（中継用）指定月主契約Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteizukisyukeiyakup ztysiteizukisyukeiyakup}</td><td>（中継用）指定月主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuujyoutukiharaikomip ztytuujyoutukiharaikomip}</td><td>（中継用）通常月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteizukiharaikomip ztysiteizukiharaikomip}</td><td>（中継用）指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruteikisiteizukip ztymaruteikisiteizukip}</td><td>（中継用）マル定指定月Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseizonmaruteisiteimp ztyseizonmaruteisiteimp}</td><td>（中継用）生存マル定指定月Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruteipsiteibairitu ztymaruteipsiteibairitu}</td><td>（中継用）マル定Ｐ指定倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmaruteipstbairitu ztyseizonmaruteipstbairitu}</td><td>（中継用）生存マル定Ｐ指定倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtisyuruikgu ztynkdtmrtisyuruikgu}</td><td>（中継用）年金建マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkindatemaruteikikan ztynenkindatemaruteikikan}</td><td>（中継用）年金建マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteiphrkkkn ztynkdatemaruteiphrkkkn}</td><td>（中継用）年金建マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteinenkinnengk ztynkdatemaruteinenkinnengk}</td><td>（中継用）年金建マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkindatemaruteis ztynenkindatemaruteis}</td><td>（中継用）年金建マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkindatemaruteip ztynenkindatemaruteip}</td><td>（中継用）年金建マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteimods ztynkdatemaruteimods}</td><td>（中継用）年金建マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtimodsskgnhyj ztynkdtmrtimodsskgnhyj}</td><td>（中継用）年金建マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteitkjyoukbn ztynkdatemaruteitkjyoukbn}</td><td>（中継用）年金建マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtitkjyouskgnkkn ztynkdtmrtitkjyouskgnkkn}</td><td>（中継用）年金建マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtitkjyouryumshytn ztynkdtmrtitkjyouryumshytn}</td><td>（中継用）年金建マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteitkjyoup ztynkdatemaruteitkjyoup}</td><td>（中継用）年金建マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkdtmrtisyuruikgux1 ztyhtnknnkdtmrtisyuruikgux1}</td><td>（中継用）被転換年金建マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkdtmrtisyuruikgux2 ztyhtnknnkdtmrtisyuruikgux2}</td><td>（中継用）被転換年金建マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkdtmrtisyuruikgux3 ztyhtnknnkdtmrtisyuruikgux3}</td><td>（中継用）被転換年金建マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkdtmrtisyuruikgux4 ztyhtnknnkdtmrtisyuruikgux4}</td><td>（中継用）被転換年金建マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkdtmrtisyuruikgux5 ztyhtnknnkdtmrtisyuruikgux5}</td><td>（中継用）被転換年金建マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkdtmrtisyuruikgux6 ztyhtnknnkdtmrtisyuruikgux6}</td><td>（中継用）被転換年金建マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteishrkkn ztynkdatemaruteishrkkn}</td><td>（中継用）年金建マル定支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuriyounkdtmrtipwrbkkbn ztysuriyounkdtmrtipwrbkkbn}</td><td>（中継用）数理用年金建マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatemaruteipwrbkkbn ztynkdatemaruteipwrbkkbn}</td><td>（中継用）年金建マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiteimhyjx1 ztyhtnknkyksiteimhyjx1}</td><td>（中継用）被転換契約指定月表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiteimhyjx2 ztyhtnknkyksiteimhyjx2}</td><td>（中継用）被転換契約指定月表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiteimhyjx3 ztyhtnknkyksiteimhyjx3}</td><td>（中継用）被転換契約指定月表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiteimhyjx4 ztyhtnknkyksiteimhyjx4}</td><td>（中継用）被転換契約指定月表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiteimhyjx5 ztyhtnknkyksiteimhyjx5}</td><td>（中継用）被転換契約指定月表示＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiteimhyjx6 ztyhtnknkyksiteimhyjx6}</td><td>（中継用）被転換契約指定月表示＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyohkreinyutkbttrtkhyj ztytyohkreinyutkbttrtkhyj}</td><td>（中継用）重複戻入特別取扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtinknengk ztykazokumrtinknengk}</td><td>（中継用）家族マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyalmyoukijyunym ztyalmyoukijyunym}</td><td>（中継用）ＡＬＭ用基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitesyono2 ztysetaitesyono2}</td><td>（中継用）セット相手証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehokensyuruikigou2 ztysetaitehokensyuruikigou2}</td><td>（中継用）セット相手保険種類記号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitemrtisyuruikgu2 ztysetaitemrtisyuruikgu2}</td><td>（中継用）セット相手マル定種類記号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitesiznmrtisyurui2 ztysetaitesiznmrtisyurui2}</td><td>（中継用）セット相手生存マル定種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitetignmrtisyurui2 ztysetaitetignmrtisyurui2}</td><td>（中継用）セット相手逓減マル定種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitekihonbubuns2 ztysetaitekihonbubuns2}</td><td>（中継用）セット相手基本部分Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetgukitnknitjbrkhns2 ztysetgukitnknitjbrkhns2}</td><td>（中継用）セット合計転換一時払基本Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesibous2 ztysetaitesibous2}</td><td>（中継用）セット相手死亡Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetgukitnknitjbrsbus2 ztysetgukitnknitjbrsbus2}</td><td>（中継用）セット合計転換一時払死亡Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesyuuseis2 ztysetaitesyuuseis2}</td><td>（中継用）セット相手修正Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaiteharaikomip2 ztysetaiteharaikomip2}</td><td>（中継用）セット相手払込Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesyukeiyakububunp2 ztysetaitesyukeiyakububunp2}</td><td>（中継用）セット相手主契約部分Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitgukikzkmrtis2 ztysetaitgukikzkmrtis2}</td><td>（中継用）セット相手合計家族マル定Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitetenkankykhyj2 ztysetaitetenkankykhyj2}</td><td>（中継用）セット相手転換契約表示２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitesiteimhrkp2 ztysetaitesiteimhrkp2}</td><td>（中継用）セット相手指定月払込Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesiteimsykykp2 ztysetaitesiteimsykykp2}</td><td>（中継用）セット相手指定月主契約Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitenkmrtisyurui2 ztysetaitenkmrtisyurui2}</td><td>（中継用）セット相手年金マル定種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehknkgusdkbn2 ztysetaitehknkgusdkbn2}</td><td>（中継用）セット相手保険記号世代区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydujmossitismodsyuguhyj ztydujmossitismodsyuguhyj}</td><td>（中継用）同時申込最低Ｓ修正Ｓ優遇表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrnsijhiyubrijdujmoskbn ztyrnsijhiyubrijdujmoskbn}</td><td>（中継用）連生時併用払時同時申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytktsppisykyktikknbbns ztytktsppisykyktikknbbns}</td><td>（中継用）特定疾病主契約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytksttkyksyuruikgu ztytksttkyksyuruikgu}</td><td>（中継用）特疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusitutokuyakukikan ztytokusitutokuyakukikan}</td><td>（中継用）特疾特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykphrkkkn ztytksttkykphrkkkn}</td><td>（中継用）特疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusitutokuyakus ztytokusitutokuyakus}</td><td>（中継用）特疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokusitutokuyakup ztytokusitutokuyakup}</td><td>（中継用）特疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokusitutokuyakusyuuseis ztytokusitutokuyakusyuuseis}</td><td>（中継用）特疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytksttkykmodssakugenhyj ztytksttkykmodssakugenhyj}</td><td>（中継用）特疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkyktkjyukbn ztytksttkyktkjyukbn}</td><td>（中継用）特疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkyktkjyuskgnkkn ztytksttkyktkjyuskgnkkn}</td><td>（中継用）特疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkyktkjyuryumshyutn ztytksttkyktkjyuryumshyutn}</td><td>（中継用）特疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytksttkyktkjyup ztytksttkyktkjyup}</td><td>（中継用）特疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytksttkyktikknbbns ztytksttkyktikknbbns}</td><td>（中継用）特疾特約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppitkykkgux1 ztyhtnkntktsppitkykkgux1}</td><td>（中継用）被転換特定疾病特約記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppitkykkgux2 ztyhtnkntktsppitkykkgux2}</td><td>（中継用）被転換特定疾病特約記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppitkykkgux3 ztyhtnkntktsppitkykkgux3}</td><td>（中継用）被転換特定疾病特約記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppitkykkgux4 ztyhtnkntktsppitkykkgux4}</td><td>（中継用）被転換特定疾病特約記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppitkykkgux5 ztyhtnkntktsppitkykkgux5}</td><td>（中継用）被転換特定疾病特約記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntktsppitkykkgux6 ztyhtnkntktsppitkykkgux6}</td><td>（中継用）被転換特定疾病特約記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryutksttkykpwrbkkbn ztysuryutksttkykpwrbkkbn}</td><td>（中継用）数理用特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykpwrbkkbn ztytksttkykpwrbkkbn}</td><td>（中継用）特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkyktnknyugukbn ztytksttkyktnknyugukbn}</td><td>（中継用）特疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksttkykkgusdkbn ztytksttkykkgusdkbn}</td><td>（中継用）特疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x8 ztyyobiv9x8}</td><td>（中継用）予備項目Ｖ９＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyksyrikgu ztydi2tksttkyksyrikgu}</td><td>（中継用）第２特疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tokusitutokuyakukkn ztydai2tokusitutokuyakukkn}</td><td>（中継用）第２特疾特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tksttkykphrkkkn ztydai2tksttkykphrkkkn}</td><td>（中継用）第２特疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tokusitutokuyakus ztydai2tokusitutokuyakus}</td><td>（中継用）第２特疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2tokusitutokuyakup ztydai2tokusitutokuyakup}</td><td>（中継用）第２特疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyksyuuseis ztydi2tksttkyksyuuseis}</td><td>（中継用）第２特疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykmodsskgnhyj ztydi2tksttkykmodsskgnhyj}</td><td>（中継用）第２特疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyktkjyukbn ztydi2tksttkyktkjyukbn}</td><td>（中継用）第２特疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyktkjyuskgnkkn ztydi2tksttkyktkjyuskgnkkn}</td><td>（中継用）第２特疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyktkjyurymshytn ztydi2tksttkyktkjyurymshytn}</td><td>（中継用）第２特疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyktkjyup ztydi2tksttkyktkjyup}</td><td>（中継用）第２特疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyktaikknbbns ztydi2tksttkyktaikknbbns}</td><td>（中継用）第２特疾特約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tktsppitkykkgux1 ztyhtnkndi2tktsppitkykkgux1}</td><td>（中継用）被転換第２特定疾病特約記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tktsppitkykkgux2 ztyhtnkndi2tktsppitkykkgux2}</td><td>（中継用）被転換第２特定疾病特約記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tktsppitkykkgux3 ztyhtnkndi2tktsppitkykkgux3}</td><td>（中継用）被転換第２特定疾病特約記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tktsppitkykkgux4 ztyhtnkndi2tktsppitkykkgux4}</td><td>（中継用）被転換第２特定疾病特約記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tktsppitkykkgux5 ztyhtnkndi2tktsppitkykkgux5}</td><td>（中継用）被転換第２特定疾病特約記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tktsppitkykkgux6 ztyhtnkndi2tktsppitkykkgux6}</td><td>（中継用）被転換第２特定疾病特約記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryudi2tksttkykpwrbkkbn ztysuryudi2tksttkykpwrbkkbn}</td><td>（中継用）数理用第２特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykpwrbkkbn ztydi2tksttkykpwrbkkbn}</td><td>（中継用）第２特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkyktnknyugukbn ztydi2tksttkyktnknyugukbn}</td><td>（中継用）第２特疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2tksttkykkgusdkbn ztydi2tksttkykkgusdkbn}</td><td>（中継用）第２特疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x9 ztyyobiv9x9}</td><td>（中継用）予備項目Ｖ９＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyksyuruikgu ztyjyuusitutkyksyuruikgu}</td><td>（中継用）重疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutokuyakukikan ztyjyuusitutokuyakukikan}</td><td>（中継用）重疾特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkykphrkkkn ztyjyuusitutkykphrkkkn}</td><td>（中継用）重疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutokuyakus ztyjyuusitutokuyakus}</td><td>（中継用）重疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutokuyakup ztyjyuusitutokuyakup}</td><td>（中継用）重疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutokuyakusyuuseis ztyjyuusitutokuyakusyuuseis}</td><td>（中継用）重疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkykmodsskgnhyj ztyjyuusitutkykmodsskgnhyj}</td><td>（中継用）重疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyktkjyukbn ztyjyuusitutkyktkjyukbn}</td><td>（中継用）重疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyktkjyuskgnkkn ztyjyuusitutkyktkjyuskgnkkn}</td><td>（中継用）重疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyusttkyktkjyuryumshyutn ztyjyusttkyktkjyuryumshyutn}</td><td>（中継用）重疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyktkjyup ztyjyuusitutkyktkjyup}</td><td>（中継用）重疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyktktbicdx1 ztyjyuusitutkyktktbicdx1}</td><td>（中継用）重疾特約特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkykhtnpkknx1 ztyjyuusitutkykhtnpkknx1}</td><td>（中継用）重疾特約不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyktktbicdx2 ztyjyuusitutkyktktbicdx2}</td><td>（中継用）重疾特約特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkykhtnpkknx2 ztyjyuusitutkykhtnpkknx2}</td><td>（中継用）重疾特約不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskkntkykkgux1 ztyhtnknmnsiskkntkykkgux1}</td><td>（中継用）被転換慢性疾患特約記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskkntkykkgux2 ztyhtnknmnsiskkntkykkgux2}</td><td>（中継用）被転換慢性疾患特約記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskkntkykkgux3 ztyhtnknmnsiskkntkykkgux3}</td><td>（中継用）被転換慢性疾患特約記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskkntkykkgux4 ztyhtnknmnsiskkntkykkgux4}</td><td>（中継用）被転換慢性疾患特約記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskkntkykkgux5 ztyhtnknmnsiskkntkykkgux5}</td><td>（中継用）被転換慢性疾患特約記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmnsiskkntkykkgux6 ztyhtnknmnsiskkntkykkgux6}</td><td>（中継用）被転換慢性疾患特約記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryujyusttkykpwrbkkbn ztysuryujyusttkykpwrbkkbn}</td><td>（中継用）数理用重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkykpwrbkkbn ztyjyuusitutkykpwrbkkbn}</td><td>（中継用）重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkyktnknyugukbn ztyjyuusitutkyktnknyugukbn}</td><td>（中継用）重疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuusitutkykkgusdkbn ztyjyuusitutkykkgusdkbn}</td><td>（中継用）重疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x3 ztyyobiv7x3}</td><td>（中継用）予備項目Ｖ７＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkyksyrikgu ztydi2jyuusitutkyksyrikgu}</td><td>（中継用）第２重疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkykkkn ztydi2jyuusitutkykkkn}</td><td>（中継用）第２重疾特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkykphrkkkn ztydi2jyuusitutkykphrkkkn}</td><td>（中継用）第２重疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2jyuusitutokuyakus ztydai2jyuusitutokuyakus}</td><td>（中継用）第２重疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2jyuusitutokuyakup ztydai2jyuusitutokuyakup}</td><td>（中継用）第２重疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkyksyuuseis ztydi2jyuusitutkyksyuuseis}</td><td>（中継用）第２重疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2jyusttkykmodsskgnhyj ztydi2jyusttkykmodsskgnhyj}</td><td>（中継用）第２重疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkyktkjyukbn ztydi2jyuusitutkyktkjyukbn}</td><td>（中継用）第２重疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyusttkyktkjyuskgnkkn ztydi2jyusttkyktkjyuskgnkkn}</td><td>（中継用）第２重疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyusttkyktkjyrymshytn ztydi2jyusttkyktkjyrymshytn}</td><td>（中継用）第２重疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkyktkjyup ztydi2jyuusitutkyktkjyup}</td><td>（中継用）第２重疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkyktktbicdx1 ztydi2jyuusitutkyktktbicdx1}</td><td>（中継用）第２重疾特約特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkykhtnpkknx1 ztydi2jyuusitutkykhtnpkknx1}</td><td>（中継用）第２重疾特約不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkyktktbicdx2 ztydi2jyuusitutkyktktbicdx2}</td><td>（中継用）第２重疾特約特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkykhtnpkknx2 ztydi2jyuusitutkykhtnpkknx2}</td><td>（中継用）第２重疾特約不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnsiskkntkykkgx1 ztyhtnkndi2mnsiskkntkykkgx1}</td><td>（中継用）被転換第２慢性疾患特約記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnsiskkntkykkgx2 ztyhtnkndi2mnsiskkntkykkgx2}</td><td>（中継用）被転換第２慢性疾患特約記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnsiskkntkykkgx3 ztyhtnkndi2mnsiskkntkykkgx3}</td><td>（中継用）被転換第２慢性疾患特約記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnsiskkntkykkgx4 ztyhtnkndi2mnsiskkntkykkgx4}</td><td>（中継用）被転換第２慢性疾患特約記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnsiskkntkykkgx5 ztyhtnkndi2mnsiskkntkykkgx5}</td><td>（中継用）被転換第２慢性疾患特約記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2mnsiskkntkykkgx6 ztyhtnkndi2mnsiskkntkykkgx6}</td><td>（中継用）被転換第２慢性疾患特約記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryud2jyusttkykpwrbkkbn ztysuryud2jyusttkykpwrbkkbn}</td><td>（中継用）数理用第２重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkykpwrbkkbn ztydi2jyuusitutkykpwrbkkbn}</td><td>（中継用）第２重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyusttkyktnknyugukbn ztydi2jyusttkyktnknyugukbn}</td><td>（中継用）第２重疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2jyuusitutkykkgusdkbn ztydi2jyuusitutkykkgusdkbn}</td><td>（中継用）第２重疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x4 ztyyobiv7x4}</td><td>（中継用）予備項目Ｖ７＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitousiharaikbn ztyhaitousiharaikbn}</td><td>（中継用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryusykykpwrbkkbn ztysuryusykykpwrbkkbn}</td><td>（中継用）数理用主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteisyuruikgu ztynkdatetokuteisyuruikgu}</td><td>（中継用）年金建トク定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkindatetokuteikikan ztynenkindatetokuteikikan}</td><td>（中継用）年金建トク定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteinkgk ztynkdatetokuteinkgk}</td><td>（中継用）年金建トク定年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkindatetokuteis ztynenkindatetokuteis}</td><td>（中継用）年金建トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkindatetokuteip ztynenkindatetokuteip}</td><td>（中継用）年金建トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteisdtpdtkbn ztynkdatetokuteisdtpdtkbn}</td><td>（中継用）年金建トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteimods ztynkdatetokuteimods}</td><td>（中継用）年金建トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteimodsskgnhyj ztynkdatetokuteimodsskgnhyj}</td><td>（中継用）年金建トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteishrkkn ztynkdatetokuteishrkkn}</td><td>（中継用）年金建トク定支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyutksytioukbn ztykykniyutksytioukbn}</td><td>（中継用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeika2nenmimantenkanhyj ztykeika2nenmimantenkanhyj}</td><td>（中継用）経過２年未満転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytukiyuhtnknkusnmennsukbn ztytukiyuhtnknkusnmennsukbn}</td><td>（中継用）統計用被転換更新前年数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdatetokuteikgusdkbn ztynkdatetokuteikgusdkbn}</td><td>（中継用）年金建トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkindatetokuteikatakbn ztynenkindatetokuteikatakbn}</td><td>（中継用）年金建トク定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x4 ztyyobiv2x4}</td><td>（中継用）予備項目Ｖ２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkyksyuruikgu ztysugusnsyutkyksyuruikgu}</td><td>（中継用）総合損傷特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkkn ztysugusnsyutkykkkn}</td><td>（中継用）総合損傷特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykphrkkkn ztysugusnsyutkykphrkkkn}</td><td>（中継用）総合損傷特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysougousonsyoutokuyakus ztysougousonsyoutokuyakus}</td><td>（中継用）総合損傷特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysougousonsyoutokuyakup ztysougousonsyoutokuyakup}</td><td>（中継用）総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkgusdkbn ztysugusnsyutkykkgusdkbn}</td><td>（中継用）総合損傷特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykpwrbkkbn ztysugusnsyutkykpwrbkkbn}</td><td>（中継用）総合損傷特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysugusnsyutkykkusnmnryage ztysugusnsyutkykkusnmnryage}</td><td>（中継用）総合損傷特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x5 ztyyobiv7x5}</td><td>（中継用）予備項目Ｖ７＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkyksyrikgu ztydi2sugusnsyutkyksyrikgu}</td><td>（中継用）第２総合損傷特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykkkn ztydi2sugusnsyutkykkkn}</td><td>（中継用）第２総合損傷特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykphrkkkn ztydi2sugusnsyutkykphrkkkn}</td><td>（中継用）第２総合損傷特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkyks ztydi2sugusnsyutkyks}</td><td>（中継用）第２総合損傷特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykp ztydi2sugusnsyutkykp}</td><td>（中継用）第２総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsytkykkgusdkbn ztydi2sugusnsytkykkgusdkbn}</td><td>（中継用）第２総合損傷特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sugusnsyutkykpwrbkkbn ztydi2sugusnsyutkykpwrbkkbn}</td><td>（中継用）第２総合損傷特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x10 ztyyobiv9x10}</td><td>（中継用）予備項目Ｖ９＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankeitaikbn ztytenkankeitaikbn}</td><td>（中継用）転換形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygukitnknitjbrtiknknengk ztygukitnknitjbrtiknknengk}</td><td>（中継用）合計転換一時払定期年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknsugusnsyutkyks ztygukihtnknsugusnsyutkyks}</td><td>（中継用）合計被転換総合損傷特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanitijibaraip ztytenkanitijibaraip}</td><td>（中継用）転換一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanpx1 ztygoukeinenbaraikansanpx1}</td><td>（中継用）合計年払換算Ｐ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx1 ztyhktgtikkikkknx1}</td><td>（中継用）引継定期経過期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkigmrsysyrikgux1 ztyhtnknkykkigmrsysyrikgux1}</td><td>（中継用）被転換契約介護マル終種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanpx2 ztygoukeinenbaraikansanpx2}</td><td>（中継用）合計年払換算Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx2 ztyhktgtikkikkknx2}</td><td>（中継用）引継定期経過期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkigmrsysyrikgux2 ztyhtnknkykkigmrsysyrikgux2}</td><td>（中継用）被転換契約介護マル終種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanpx3 ztygoukeinenbaraikansanpx3}</td><td>（中継用）合計年払換算Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx3 ztyhktgtikkikkknx3}</td><td>（中継用）引継定期経過期間＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkigmrsysyrikgux3 ztyhtnknkykkigmrsysyrikgux3}</td><td>（中継用）被転換契約介護マル終種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanpx4 ztygoukeinenbaraikansanpx4}</td><td>（中継用）合計年払換算Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx4 ztyhktgtikkikkknx4}</td><td>（中継用）引継定期経過期間＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkigmrsysyrikgux4 ztyhtnknkykkigmrsysyrikgux4}</td><td>（中継用）被転換契約介護マル終種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanpx5 ztygoukeinenbaraikansanpx5}</td><td>（中継用）合計年払換算Ｐ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx5 ztyhktgtikkikkknx5}</td><td>（中継用）引継定期経過期間＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkigmrsysyrikgux5 ztyhtnknkykkigmrsysyrikgux5}</td><td>（中継用）被転換契約介護マル終種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanpx6 ztygoukeinenbaraikansanpx6}</td><td>（中継用）合計年払換算Ｐ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx6 ztyhktgtikkikkknx6}</td><td>（中継用）引継定期経過期間＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkigmrsysyrikgux6 ztyhtnknkykkigmrsysyrikgux6}</td><td>（中継用）被転換契約介護マル終種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyniceonplanhyj ztyniceonplanhyj}</td><td>（中継用）ナイスオンプラン表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipryosyuymd ztysyokaipryosyuymd}</td><td>（中継用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyldownmaetenkannensuukbn ztyldownmaetenkannensuukbn}</td><td>（中継用）Ｌダウン前転換年数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyldownmaesaiteismitatuhyj ztyldownmaesaiteismitatuhyj}</td><td>（中継用）Ｌダウン前最低Ｓ未達表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntitikgtkbttrtkhyj ztydntitikgtkbttrtkhyj}</td><td>（中継用）団体定期後特別取扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreformkbn ztyreformkbn}</td><td>（中継用）リフォーム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikeiyakutyuuihyouji ztykikeiyakutyuuihyouji}</td><td>（中継用）既契約注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegcd ztykbnkeiriyousegcd}</td><td>（中継用）区分経理用ＳＥＧコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuuseiskiteitekiyoukbn ztysyuuseiskiteitekiyoukbn}</td><td>（中継用）修正Ｓ規程適用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkzkmrtimods ztygukihtnknkzkmrtimods}</td><td>（中継用）合計被転換家族マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknkijyntkyuhtnknsbus ztytnknkijyntkyuhtnknsbus}</td><td>（中継用）転換基準適用被転換死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysrjsnyusyouhinhyj ztysrjsnyusyouhinhyj}</td><td>（中継用）白地専用商品表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysirajikakuninzumihyouji ztysirajikakuninzumihyouji}</td><td>（中継用）白地確認済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrjsnyusyouhintknnhyj ztysrjsnyusyouhintknnhyj}</td><td>（中継用）白地専用商品特認表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsakbn ztysinsakbn}</td><td>（中継用）診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2sinsakbn ztydai2sinsakbn}</td><td>（中継用）第２診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2toukeiyousinsakbn ztydai2toukeiyousinsakbn}</td><td>（中継用）第２統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonkyuhknshrsiteimd ztyseizonkyuhknshrsiteimd}</td><td>（中継用）生存給付金支払指定月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5 ztyyoteiriritun5}</td><td>（中継用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysaiteihosyouriritu ztysaiteihosyouriritu}</td><td>（中継用）最低保障利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynkgnsritu ztynkgnsritu}</td><td>（中継用）年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyjigyounendomatuv ztyjigyounendomatuv}</td><td>（中継用）事業年度末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnkn5nnmeksnyumods ztygukihtnkn5nnmeksnyumods}</td><td>（中継用）合計被転換５年前加算用修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrenseiteikitksyusnksnhyj ztyrenseiteikitksyusnksnhyj}</td><td>（中継用）連生定期付終身加算表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp2x1 ztygoukeinenbaraikansanp2x1}</td><td>（中継用）合計年払換算Ｐ２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukinenbaraiknsnp2kbnx1 ztygukinenbaraiknsnp2kbnx1}</td><td>（中継用）合計年払換算Ｐ２区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn2x1 ztyhktgtikkikkkn2x1}</td><td>（中継用）引継定期経過期間２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp2x2 ztygoukeinenbaraikansanp2x2}</td><td>（中継用）合計年払換算Ｐ２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukinenbaraiknsnp2kbnx2 ztygukinenbaraiknsnp2kbnx2}</td><td>（中継用）合計年払換算Ｐ２区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn2x2 ztyhktgtikkikkkn2x2}</td><td>（中継用）引継定期経過期間２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp2x3 ztygoukeinenbaraikansanp2x3}</td><td>（中継用）合計年払換算Ｐ２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukinenbaraiknsnp2kbnx3 ztygukinenbaraiknsnp2kbnx3}</td><td>（中継用）合計年払換算Ｐ２区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn2x3 ztyhktgtikkikkkn2x3}</td><td>（中継用）引継定期経過期間２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp2x4 ztygoukeinenbaraikansanp2x4}</td><td>（中継用）合計年払換算Ｐ２＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukinenbaraiknsnp2kbnx4 ztygukinenbaraiknsnp2kbnx4}</td><td>（中継用）合計年払換算Ｐ２区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn2x4 ztyhktgtikkikkkn2x4}</td><td>（中継用）引継定期経過期間２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp2x5 ztygoukeinenbaraikansanp2x5}</td><td>（中継用）合計年払換算Ｐ２＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukinenbaraiknsnp2kbnx5 ztygukinenbaraiknsnp2kbnx5}</td><td>（中継用）合計年払換算Ｐ２区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn2x5 ztyhktgtikkikkkn2x5}</td><td>（中継用）引継定期経過期間２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp2x6 ztygoukeinenbaraikansanp2x6}</td><td>（中継用）合計年払換算Ｐ２＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukinenbaraiknsnp2kbnx6 ztygukinenbaraiknsnp2kbnx6}</td><td>（中継用）合計年払換算Ｐ２区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn2x6 ztyhktgtikkikkkn2x6}</td><td>（中継用）引継定期経過期間２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutituusantaisyous ztykokutituusantaisyous}</td><td>（中継用）告知通算対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokusyuyouroumankis ztytokusyuyouroumankis}</td><td>（中継用）特殊養老満期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtitnknyuuguukbn ztynkdtmrtitnknyuuguukbn}</td><td>（中継用）年金建マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikgusdkbn ztynkdtmrtikgusdkbn}</td><td>（中継用）年金建マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkindatemaruteikatakbn ztynenkindatemaruteikatakbn}</td><td>（中継用）年金建マル定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkdtmrtikusnmnryoage ztynkdtmrtikusnmnryoage}</td><td>（中継用）年金建マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtisyuruikgu ztykaigonkdtmrtisyuruikgu}</td><td>（中継用）介護年金建マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikkan ztykaigonkdtmrtikkan}</td><td>（中継用）介護年金建マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtiphrkkkn ztykaigonkdtmrtiphrkkkn}</td><td>（中継用）介護年金建マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtinnknnengk ztykaigonkdtmrtinnknnengk}</td><td>（中継用）介護年金建マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtis ztykaigonkdtmrtis}</td><td>（中継用）介護年金建マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtip ztykaigonkdtmrtip}</td><td>（中継用）介護年金建マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtimods ztykaigonkdtmrtimods}</td><td>（中継用）介護年金建マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtitkjyukbn ztykaigonkdtmrtitkjyukbn}</td><td>（中継用）介護年金建マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtitkjyskgnkkn ztykaigonkdtmrtitkjyskgnkkn}</td><td>（中継用）介護年金建マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrttkjyrymshytn ztykaigonkdtmrttkjyrymshytn}</td><td>（中継用）介護年金建マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtitkjyup ztykaigonkdtmrtitkjyup}</td><td>（中継用）介護年金建マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtsyrikgux1 ztyhtnknkaigonkmrtsyrikgux1}</td><td>（中継用）被転換介護年金マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtsyrikgux2 ztyhtnknkaigonkmrtsyrikgux2}</td><td>（中継用）被転換介護年金マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtsyrikgux3 ztyhtnknkaigonkmrtsyrikgux3}</td><td>（中継用）被転換介護年金マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtsyrikgux4 ztyhtnknkaigonkmrtsyrikgux4}</td><td>（中継用）被転換介護年金マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtsyrikgux5 ztyhtnknkaigonkmrtsyrikgux5}</td><td>（中継用）被転換介護年金マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtsyrikgux6 ztyhtnknkaigonkmrtsyrikgux6}</td><td>（中継用）被転換介護年金マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtishrkkn ztykaigonkdtmrtishrkkn}</td><td>（中継用）介護年金建マル定支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysurikaigonkmrtipwrbkkbn ztysurikaigonkmrtipwrbkkbn}</td><td>（中継用）数理介護年金マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtipwrbkkbn ztykaigonkdtmrtipwrbkkbn}</td><td>（中継用）介護年金建マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtitnknyugukbn ztykaigonkdtmrtitnknyugukbn}</td><td>（中継用）介護年金建マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtikgusdkbn ztykaigonkdtmrtikgusdkbn}</td><td>（中継用）介護年金建マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdtmrtiktkbn ztykaigonkdtmrtiktkbn}</td><td>（中継用）介護年金建マル定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykignkdtmrtikusnmnryoage ztykignkdtmrtikusnmnryoage}</td><td>（中継用）介護年金建マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktisyuruikgu ztykaigonkdttktisyuruikgu}</td><td>（中継用）介護年金建トク定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikkn ztykaigonkdttktikkn}</td><td>（中継用）介護年金建トク定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttkteinenkngk ztykaigonkdttkteinenkngk}</td><td>（中継用）介護年金建トク定年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonenkindatetokuteis ztykaigonenkindatetokuteis}</td><td>（中継用）介護年金建トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonenkindatetokuteip ztykaigonenkindatetokuteip}</td><td>（中継用）介護年金建トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktisdtpdtkbn ztykaigonkdttktisdtpdtkbn}</td><td>（中継用）介護年金建トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktimods ztykaigonkdttktimods}</td><td>（中継用）介護年金建トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktishrkkn ztykaigonkdttktishrkkn}</td><td>（中継用）介護年金建トク定支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktikgusdkbn ztykaigonkdttktikgusdkbn}</td><td>（中継用）介護年金建トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonkdttktiktkbn ztykaigonkdttktiktkbn}</td><td>（中継用）介護年金建トク定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykignkdttktikusnmnryoage ztykignkdttktikusnmnryoage}</td><td>（中継用）介護年金建トク定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x5 ztyyobiv2x5}</td><td>（中継用）予備項目Ｖ２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigenmrtisyuruikgu ztykaigoteigenmrtisyuruikgu}</td><td>（中継用）介護逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigenmaruteikikan ztykaigoteigenmaruteikikan}</td><td>（中継用）介護逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotignmrtiphrkkkn ztykaigotignmrtiphrkkkn}</td><td>（中継用）介護逓減マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigenmaruteis ztykaigoteigenmaruteis}</td><td>（中継用）介護逓減マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigoteigenmaruteip ztykaigoteigenmaruteip}</td><td>（中継用）介護逓減マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtimods ztykigtignmrtimods}</td><td>（中継用）介護逓減マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtitkjyukbn ztykigtignmrtitkjyukbn}</td><td>（中継用）介護逓減マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtitkjyuskgnkkn ztykigtignmrtitkjyuskgnkkn}</td><td>（中継用）介護逓減マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtitkjyurymshytn ztykigtignmrtitkjyurymshytn}</td><td>（中継用）介護逓減マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtitkjyup ztykigtignmrtitkjyup}</td><td>（中継用）介護逓減マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtsyrikgux1 ztyhtnknkigtignmrtsyrikgux1}</td><td>（中継用）被転換介護逓減マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtsyrikgux2 ztyhtnknkigtignmrtsyrikgux2}</td><td>（中継用）被転換介護逓減マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtsyrikgux3 ztyhtnknkigtignmrtsyrikgux3}</td><td>（中継用）被転換介護逓減マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtsyrikgux4 ztyhtnknkigtignmrtsyrikgux4}</td><td>（中継用）被転換介護逓減マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtsyrikgux5 ztyhtnknkigtignmrtsyrikgux5}</td><td>（中継用）被転換介護逓減マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtsyrikgux6 ztyhtnknkigtignmrtsyrikgux6}</td><td>（中継用）被転換介護逓減マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysurkigtignmrtipwrbkkbn ztysurkigtignmrtipwrbkkbn}</td><td>（中継用）数理介護逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtipwrbkkbn ztykigtignmrtipwrbkkbn}</td><td>（中継用）介護逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtitnknyugukbn ztykigtignmrtitnknyugukbn}</td><td>（中継用）介護逓減マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotignmrtikgusdkbn ztykaigotignmrtikgusdkbn}</td><td>（中継用）介護逓減マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtignmrtikusnmnryoage ztykigtignmrtikusnmnryoage}</td><td>（中継用）介護逓減マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x15 ztyyobiv4x15}</td><td>（中継用）予備項目Ｖ４＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigentktisyuruikgu ztykaigoteigentktisyuruikgu}</td><td>（中継用）介護逓減トク定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigentokuteikikan ztykaigoteigentokuteikikan}</td><td>（中継用）介護逓減トク定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigentokuteis ztykaigoteigentokuteis}</td><td>（中継用）介護逓減トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigoteigentokuteip ztykaigoteigentokuteip}</td><td>（中継用）介護逓減トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykigtigntktisdtpdtkbn ztykigtigntktisdtpdtkbn}</td><td>（中継用）介護逓減トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktimods ztykigtigntktimods}</td><td>（中継用）介護逓減トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigotigntktikgusdkbn ztykaigotigntktikgusdkbn}</td><td>（中継用）介護逓減トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigtigntktikusnmnryoage ztykigtigntktikusnmnryoage}</td><td>（中継用）介護逓減トク定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x6 ztyyobiv2x6}</td><td>（中継用）予備項目Ｖ２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhikitugikaimasis ztyhikitugikaimasis}</td><td>（中継用）引継買増Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkyhtisyukykumkbn ztycbkyhtisyukykumkbn}</td><td>（中継用）ＣＢ給付対象契約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytukiyucbkyhtisyus ztytukiyucbkyhtisyus}</td><td>（中継用）統計用ＣＢ給付対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbhanteituusans ztycbhanteituusans}</td><td>（中継用）ＣＢ判定通算Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytukiyusnkykcbhntis ztytukiyusnkykcbhntis}</td><td>（中継用）統計用新契約ＣＢ判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbstagekbn ztycbstagekbn}</td><td>（中継用）ＣＢステージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyoucbhanteituusans ztytoukeiyoucbhanteituusans}</td><td>（中継用）統計用ＣＢ判定通算Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbtuusankensuu ztycbtuusankensuu}</td><td>（中継用）ＣＢ通算件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtycbhanteitaisyoutsnkensuu ztycbhanteitaisyoutsnkensuu}</td><td>（中継用）ＣＢ判定対象通算件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteisx1 ztytyokuzentuusanhanteisx1}</td><td>（中継用）直前通算判定Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzenkyuuhutaisyousx1 ztytyokuzenkyuuhutaisyousx1}</td><td>（中継用）直前給付対象Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzencbgakux1 ztytyokuzencbgakux1}</td><td>（中継用）直前ＣＢ額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteisx1 ztytyokugotuusanhanteisx1}</td><td>（中継用）直後通算判定Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyousx1 ztytyokugokyuuhutaisyousx1}</td><td>（中継用）直後給付対象Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbgakux1 ztytyokugocbgakux1}</td><td>（中継用）直後ＣＢ額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteisx2 ztytyokuzentuusanhanteisx2}</td><td>（中継用）直前通算判定Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzenkyuuhutaisyousx2 ztytyokuzenkyuuhutaisyousx2}</td><td>（中継用）直前給付対象Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzencbgakux2 ztytyokuzencbgakux2}</td><td>（中継用）直前ＣＢ額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteisx2 ztytyokugotuusanhanteisx2}</td><td>（中継用）直後通算判定Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyousx2 ztytyokugokyuuhutaisyousx2}</td><td>（中継用）直後給付対象Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbgakux2 ztytyokugocbgakux2}</td><td>（中継用）直後ＣＢ額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x2 ztyyobiv12x2}</td><td>（中継用）予備項目Ｖ１２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteisx3 ztytyokuzentuusanhanteisx3}</td><td>（中継用）直前通算判定Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzenkyuuhutaisyousx3 ztytyokuzenkyuuhutaisyousx3}</td><td>（中継用）直前給付対象Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzencbgakux3 ztytyokuzencbgakux3}</td><td>（中継用）直前ＣＢ額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteisx3 ztytyokugotuusanhanteisx3}</td><td>（中継用）直後通算判定Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyousx3 ztytyokugokyuuhutaisyousx3}</td><td>（中継用）直後給付対象Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbgakux3 ztytyokugocbgakux3}</td><td>（中継用）直後ＣＢ額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x3 ztyyobiv12x3}</td><td>（中継用）予備項目Ｖ１２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteisx4 ztytyokuzentuusanhanteisx4}</td><td>（中継用）直前通算判定Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzenkyuuhutaisyousx4 ztytyokuzenkyuuhutaisyousx4}</td><td>（中継用）直前給付対象Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzencbgakux4 ztytyokuzencbgakux4}</td><td>（中継用）直前ＣＢ額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteisx4 ztytyokugotuusanhanteisx4}</td><td>（中継用）直後通算判定Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyousx4 ztytyokugokyuuhutaisyousx4}</td><td>（中継用）直後給付対象Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbgakux4 ztytyokugocbgakux4}</td><td>（中継用）直後ＣＢ額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x4 ztyyobiv12x4}</td><td>（中継用）予備項目Ｖ１２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteisx5 ztytyokuzentuusanhanteisx5}</td><td>（中継用）直前通算判定Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzenkyuuhutaisyousx5 ztytyokuzenkyuuhutaisyousx5}</td><td>（中継用）直前給付対象Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzencbgakux5 ztytyokuzencbgakux5}</td><td>（中継用）直前ＣＢ額＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteisx5 ztytyokugotuusanhanteisx5}</td><td>（中継用）直後通算判定Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyousx5 ztytyokugokyuuhutaisyousx5}</td><td>（中継用）直後給付対象Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbgakux5 ztytyokugocbgakux5}</td><td>（中継用）直後ＣＢ額＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x5 ztyyobiv12x5}</td><td>（中継用）予備項目Ｖ１２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteisx6 ztytyokuzentuusanhanteisx6}</td><td>（中継用）直前通算判定Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzenkyuuhutaisyousx6 ztytyokuzenkyuuhutaisyousx6}</td><td>（中継用）直前給付対象Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzencbgakux6 ztytyokuzencbgakux6}</td><td>（中継用）直前ＣＢ額＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteisx6 ztytyokugotuusanhanteisx6}</td><td>（中継用）直後通算判定Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyousx6 ztytyokugokyuuhutaisyousx6}</td><td>（中継用）直後給付対象Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbgakux6 ztytyokugocbgakux6}</td><td>（中継用）直後ＣＢ額＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x6 ztyyobiv12x6}</td><td>（中継用）予備項目Ｖ１２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikyksyonox1 ztycbkikyksyonox1}</td><td>（中継用）ＣＢ既契約証券番号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykhknsyruikbnx1 ztycbkikykhknsyruikbnx1}</td><td>（中継用）ＣＢ既契約保険種類区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikeiyakukeiyakuymdx1 ztycbkikeiyakukeiyakuymdx1}</td><td>（中継用）ＣＢ既契約契約年月日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykkyhtisyukbnx1 ztycbkikykkyhtisyukbnx1}</td><td>（中継用）ＣＢ既契約給付対象区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykhntitaisyoukbnx1 ztycbkikykhntitaisyoukbnx1}</td><td>（中継用）ＣＢ既契約判定対象区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikeiyakucbgakux1x1 ztykikeiyakucbgakux1x1}</td><td>（中継用）既契約ＣＢ額＿１＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykikeiyakucbgakux2x1 ztykikeiyakucbgakux2x1}</td><td>（中継用）既契約ＣＢ額＿２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkikykhanteitsnsx1x1 ztycbkikykhanteitsnsx1x1}</td><td>（中継用）ＣＢ既契約判定通算Ｓ＿１＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkikykhanteitsnsx2x1 ztycbkikykhanteitsnsx2x1}</td><td>（中継用）ＣＢ既契約判定通算Ｓ＿２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x7 ztyyobiv12x7}</td><td>（中継用）予備項目Ｖ１２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikyksyonox2 ztycbkikyksyonox2}</td><td>（中継用）ＣＢ既契約証券番号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykhknsyruikbnx2 ztycbkikykhknsyruikbnx2}</td><td>（中継用）ＣＢ既契約保険種類区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikeiyakukeiyakuymdx2 ztycbkikeiyakukeiyakuymdx2}</td><td>（中継用）ＣＢ既契約契約年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykkyhtisyukbnx2 ztycbkikykkyhtisyukbnx2}</td><td>（中継用）ＣＢ既契約給付対象区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykhntitaisyoukbnx2 ztycbkikykhntitaisyoukbnx2}</td><td>（中継用）ＣＢ既契約判定対象区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikeiyakucbgakux1x2 ztykikeiyakucbgakux1x2}</td><td>（中継用）既契約ＣＢ額＿１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykikeiyakucbgakux2x2 ztykikeiyakucbgakux2x2}</td><td>（中継用）既契約ＣＢ額＿２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkikykhanteitsnsx1x2 ztycbkikykhanteitsnsx1x2}</td><td>（中継用）ＣＢ既契約判定通算Ｓ＿１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkikykhanteitsnsx2x2 ztycbkikykhanteitsnsx2x2}</td><td>（中継用）ＣＢ既契約判定通算Ｓ＿２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x8 ztyyobiv12x8}</td><td>（中継用）予備項目Ｖ１２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikyksyonox3 ztycbkikyksyonox3}</td><td>（中継用）ＣＢ既契約証券番号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykhknsyruikbnx3 ztycbkikykhknsyruikbnx3}</td><td>（中継用）ＣＢ既契約保険種類区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikeiyakukeiyakuymdx3 ztycbkikeiyakukeiyakuymdx3}</td><td>（中継用）ＣＢ既契約契約年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykkyhtisyukbnx3 ztycbkikykkyhtisyukbnx3}</td><td>（中継用）ＣＢ既契約給付対象区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycbkikykhntitaisyoukbnx3 ztycbkikykhntitaisyoukbnx3}</td><td>（中継用）ＣＢ既契約判定対象区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikeiyakucbgakux1x3 ztykikeiyakucbgakux1x3}</td><td>（中継用）既契約ＣＢ額＿１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykikeiyakucbgakux2x3 ztykikeiyakucbgakux2x3}</td><td>（中継用）既契約ＣＢ額＿２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkikykhanteitsnsx1x3 ztycbkikykhanteitsnsx1x3}</td><td>（中継用）ＣＢ既契約判定通算Ｓ＿１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbkikykhanteitsnsx2x3 ztycbkikykhanteitsnsx2x3}</td><td>（中継用）ＣＢ既契約判定通算Ｓ＿２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x9 ztyyobiv12x9}</td><td>（中継用）予備項目Ｖ１２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikgusdkbnx1 ztyhtnknhknsyrikgusdkbnx1}</td><td>（中継用）被転換保険種類記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikgusdkbnx1 ztyhtnknmrtikgusdkbnx1}</td><td>（中継用）被転換マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikgusdkbnx1 ztyhtnknsiznmrtikgusdkbnx1}</td><td>（中継用）被転換生存マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikgusdkbnx1 ztyhtnkntignmrtikgusdkbnx1}</td><td>（中継用）被転換逓減マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikgusdkbnx1 ztyhtnknnkmrtikgusdkbnx1}</td><td>（中継用）被転換年金マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntkstkgusdkbnx1 ztyhtnkntkstkgusdkbnx1}</td><td>（中継用）被転換特疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkgusdkbnx1 ztyhtnkndi2tkstkgusdkbnx1}</td><td>（中継用）被転換第２特疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjyustkgusdkbnx1 ztyhtnknjyustkgusdkbnx1}</td><td>（中継用）被転換重疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2jysitkgusdkbnx1 ztyhtnkndi2jysitkgusdkbnx1}</td><td>（中継用）被転換第２重疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtisdkbnx1 ztyhtnknkaigonkmrtisdkbnx1}</td><td>（中継用）被転換介護年金マル定世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtisdkbnx1 ztyhtnknkigtignmrtisdkbnx1}</td><td>（中継用）被転換介護逓減マル定世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrsykgusdkbnx1 ztyhtnknkaigomrsykgusdkbnx1}</td><td>（中継用）被転換介護マル終記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobiv8x2 ztysuuriyouyobiv8x2}</td><td>（中継用）数理用予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikgusdkbnx2 ztyhtnknhknsyrikgusdkbnx2}</td><td>（中継用）被転換保険種類記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikgusdkbnx2 ztyhtnknmrtikgusdkbnx2}</td><td>（中継用）被転換マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikgusdkbnx2 ztyhtnknsiznmrtikgusdkbnx2}</td><td>（中継用）被転換生存マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikgusdkbnx2 ztyhtnkntignmrtikgusdkbnx2}</td><td>（中継用）被転換逓減マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikgusdkbnx2 ztyhtnknnkmrtikgusdkbnx2}</td><td>（中継用）被転換年金マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntkstkgusdkbnx2 ztyhtnkntkstkgusdkbnx2}</td><td>（中継用）被転換特疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkgusdkbnx2 ztyhtnkndi2tkstkgusdkbnx2}</td><td>（中継用）被転換第２特疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjyustkgusdkbnx2 ztyhtnknjyustkgusdkbnx2}</td><td>（中継用）被転換重疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2jysitkgusdkbnx2 ztyhtnkndi2jysitkgusdkbnx2}</td><td>（中継用）被転換第２重疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtisdkbnx2 ztyhtnknkaigonkmrtisdkbnx2}</td><td>（中継用）被転換介護年金マル定世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtisdkbnx2 ztyhtnknkigtignmrtisdkbnx2}</td><td>（中継用）被転換介護逓減マル定世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrsykgusdkbnx2 ztyhtnknkaigomrsykgusdkbnx2}</td><td>（中継用）被転換介護マル終記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x5 ztyyobiv8x5}</td><td>（中継用）予備項目Ｖ８＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikgusdkbnx3 ztyhtnknhknsyrikgusdkbnx3}</td><td>（中継用）被転換保険種類記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikgusdkbnx3 ztyhtnknmrtikgusdkbnx3}</td><td>（中継用）被転換マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikgusdkbnx3 ztyhtnknsiznmrtikgusdkbnx3}</td><td>（中継用）被転換生存マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikgusdkbnx3 ztyhtnkntignmrtikgusdkbnx3}</td><td>（中継用）被転換逓減マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikgusdkbnx3 ztyhtnknnkmrtikgusdkbnx3}</td><td>（中継用）被転換年金マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntkstkgusdkbnx3 ztyhtnkntkstkgusdkbnx3}</td><td>（中継用）被転換特疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkgusdkbnx3 ztyhtnkndi2tkstkgusdkbnx3}</td><td>（中継用）被転換第２特疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjyustkgusdkbnx3 ztyhtnknjyustkgusdkbnx3}</td><td>（中継用）被転換重疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2jysitkgusdkbnx3 ztyhtnkndi2jysitkgusdkbnx3}</td><td>（中継用）被転換第２重疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtisdkbnx3 ztyhtnknkaigonkmrtisdkbnx3}</td><td>（中継用）被転換介護年金マル定世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtisdkbnx3 ztyhtnknkigtignmrtisdkbnx3}</td><td>（中継用）被転換介護逓減マル定世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrsykgusdkbnx3 ztyhtnknkaigomrsykgusdkbnx3}</td><td>（中継用）被転換介護マル終記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x6 ztyyobiv8x6}</td><td>（中継用）予備項目Ｖ８＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikgusdkbnx4 ztyhtnknhknsyrikgusdkbnx4}</td><td>（中継用）被転換保険種類記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikgusdkbnx4 ztyhtnknmrtikgusdkbnx4}</td><td>（中継用）被転換マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikgusdkbnx4 ztyhtnknsiznmrtikgusdkbnx4}</td><td>（中継用）被転換生存マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikgusdkbnx4 ztyhtnkntignmrtikgusdkbnx4}</td><td>（中継用）被転換逓減マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikgusdkbnx4 ztyhtnknnkmrtikgusdkbnx4}</td><td>（中継用）被転換年金マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntkstkgusdkbnx4 ztyhtnkntkstkgusdkbnx4}</td><td>（中継用）被転換特疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkgusdkbnx4 ztyhtnkndi2tkstkgusdkbnx4}</td><td>（中継用）被転換第２特疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjyustkgusdkbnx4 ztyhtnknjyustkgusdkbnx4}</td><td>（中継用）被転換重疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2jysitkgusdkbnx4 ztyhtnkndi2jysitkgusdkbnx4}</td><td>（中継用）被転換第２重疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtisdkbnx4 ztyhtnknkaigonkmrtisdkbnx4}</td><td>（中継用）被転換介護年金マル定世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtisdkbnx4 ztyhtnknkigtignmrtisdkbnx4}</td><td>（中継用）被転換介護逓減マル定世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrsykgusdkbnx4 ztyhtnknkaigomrsykgusdkbnx4}</td><td>（中継用）被転換介護マル終記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x7 ztyyobiv8x7}</td><td>（中継用）予備項目Ｖ８＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikgusdkbnx5 ztyhtnknhknsyrikgusdkbnx5}</td><td>（中継用）被転換保険種類記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikgusdkbnx5 ztyhtnknmrtikgusdkbnx5}</td><td>（中継用）被転換マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikgusdkbnx5 ztyhtnknsiznmrtikgusdkbnx5}</td><td>（中継用）被転換生存マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikgusdkbnx5 ztyhtnkntignmrtikgusdkbnx5}</td><td>（中継用）被転換逓減マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikgusdkbnx5 ztyhtnknnkmrtikgusdkbnx5}</td><td>（中継用）被転換年金マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntkstkgusdkbnx5 ztyhtnkntkstkgusdkbnx5}</td><td>（中継用）被転換特疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkgusdkbnx5 ztyhtnkndi2tkstkgusdkbnx5}</td><td>（中継用）被転換第２特疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjyustkgusdkbnx5 ztyhtnknjyustkgusdkbnx5}</td><td>（中継用）被転換重疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2jysitkgusdkbnx5 ztyhtnkndi2jysitkgusdkbnx5}</td><td>（中継用）被転換第２重疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtisdkbnx5 ztyhtnknkaigonkmrtisdkbnx5}</td><td>（中継用）被転換介護年金マル定世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtisdkbnx5 ztyhtnknkigtignmrtisdkbnx5}</td><td>（中継用）被転換介護逓減マル定世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrsykgusdkbnx5 ztyhtnknkaigomrsykgusdkbnx5}</td><td>（中継用）被転換介護マル終記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x8 ztyyobiv8x8}</td><td>（中継用）予備項目Ｖ８＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknhknsyrikgusdkbnx6 ztyhtnknhknsyrikgusdkbnx6}</td><td>（中継用）被転換保険種類記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknmrtikgusdkbnx6 ztyhtnknmrtikgusdkbnx6}</td><td>（中継用）被転換マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiznmrtikgusdkbnx6 ztyhtnknsiznmrtikgusdkbnx6}</td><td>（中継用）被転換生存マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntignmrtikgusdkbnx6 ztyhtnkntignmrtikgusdkbnx6}</td><td>（中継用）被転換逓減マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknnkmrtikgusdkbnx6 ztyhtnknnkmrtikgusdkbnx6}</td><td>（中継用）被転換年金マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntkstkgusdkbnx6 ztyhtnkntkstkgusdkbnx6}</td><td>（中継用）被転換特疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2tkstkgusdkbnx6 ztyhtnkndi2tkstkgusdkbnx6}</td><td>（中継用）被転換第２特疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknjyustkgusdkbnx6 ztyhtnknjyustkgusdkbnx6}</td><td>（中継用）被転換重疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkndi2jysitkgusdkbnx6 ztyhtnkndi2jysitkgusdkbnx6}</td><td>（中継用）被転換第２重疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonkmrtisdkbnx6 ztyhtnknkaigonkmrtisdkbnx6}</td><td>（中継用）被転換介護年金マル定世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigtignmrtisdkbnx6 ztyhtnknkigtignmrtisdkbnx6}</td><td>（中継用）被転換介護逓減マル定世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrsykgusdkbnx6 ztyhtnknkaigomrsykgusdkbnx6}</td><td>（中継用）被転換介護マル終記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x9 ztyyobiv8x9}</td><td>（中継用）予備項目Ｖ８＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkyksyuruikgu ztykaigonktkyksyuruikgu}</td><td>（中継用）介護年金特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykkgusdkbn ztykaigonktkykkgusdkbn}</td><td>（中継用）介護年金特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonenkintokuyakukikan ztykaigonenkintokuyakukikan}</td><td>（中継用）介護年金特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykphrkkkn ztykaigonktkykphrkkkn}</td><td>（中継用）介護年金特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkyknkgk ztykaigonktkyknkgk}</td><td>（中継用）介護年金特約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonenkintokuyakus ztykaigonenkintokuyakus}</td><td>（中継用）介護年金特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonenkintokuyakup ztykaigonenkintokuyakup}</td><td>（中継用）介護年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykmods ztykaigonktkykmods}</td><td>（中継用）介護年金特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigonktkyknkshrkkn ztykaigonktkyknkshrkkn}</td><td>（中継用）介護年金特約年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgux1 ztyhtnknkaigonktkykkgux1}</td><td>（中継用）被転換介護年金特約記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgux2 ztyhtnknkaigonktkykkgux2}</td><td>（中継用）被転換介護年金特約記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgux3 ztyhtnknkaigonktkykkgux3}</td><td>（中継用）被転換介護年金特約記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgux4 ztyhtnknkaigonktkykkgux4}</td><td>（中継用）被転換介護年金特約記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgux5 ztyhtnknkaigonktkykkgux5}</td><td>（中継用）被転換介護年金特約記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkykkgux6 ztyhtnknkaigonktkykkgux6}</td><td>（中継用）被転換介護年金特約記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkyksdkbnx1 ztyhtnknkaigonktkyksdkbnx1}</td><td>（中継用）被転換介護年金特約世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkyksdkbnx2 ztyhtnknkaigonktkyksdkbnx2}</td><td>（中継用）被転換介護年金特約世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkyksdkbnx3 ztyhtnknkaigonktkyksdkbnx3}</td><td>（中継用）被転換介護年金特約世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkyksdkbnx4 ztyhtnknkaigonktkyksdkbnx4}</td><td>（中継用）被転換介護年金特約世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkyksdkbnx5 ztyhtnknkaigonktkyksdkbnx5}</td><td>（中継用）被転換介護年金特約世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigonktkyksdkbnx6 ztyhtnknkaigonktkyksdkbnx6}</td><td>（中継用）被転換介護年金特約世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysurikaigonktkykpwrbkkbn ztysurikaigonktkykpwrbkkbn}</td><td>（中継用）数理介護年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykpwrbkkbn ztykaigonktkykpwrbkkbn}</td><td>（中継用）介護年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkyktnknyugukbn ztykaigonktkyktnknyugukbn}</td><td>（中継用）介護年金特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv14 ztyyobiv14}</td><td>（中継用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkyksyrikgu ztyitjbrkignktkyksyrikgu}</td><td>（中継用）一時払介護年金特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkyksdkbn ztyitjbrkignktkyksdkbn}</td><td>（中継用）一時払介護年金特約世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykkkn ztyitjbrkignktkykkkn}</td><td>（中継用）一時払介護年金特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkyknnkngk ztyitjbrkignktkyknnkngk}</td><td>（中継用）一時払介護年金特約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkyks ztyitjbrkignktkyks}</td><td>（中継用）一時払介護年金特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykp ztyitjbrkignktkykp}</td><td>（中継用）一時払介護年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykspdtkbn ztyitjbrkignktkykspdtkbn}</td><td>（中継用）一時払介護年金特約ＳＰ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykmods ztyitjbrkignktkykmods}</td><td>（中継用）一時払介護年金特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitjbrkignktkykshrkkn ztyitjbrkignktkykshrkkn}</td><td>（中継用）一時払介護年金特約支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x10 ztyyobiv8x10}</td><td>（中継用）予備項目Ｖ８＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuinnissuugatakbn ztynyuuinnissuugatakbn}</td><td>（中継用）入院日数型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankeikanensuu ztytenkankeikanensuu}</td><td>（中継用）転換経過年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkyksyuruikgu ztysykkyuhtkyksyuruikgu}</td><td>（中継用）初期給付特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokikyuuhutokuyakukikan ztysyokikyuuhutokuyakukikan}</td><td>（中継用）初期給付特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokikyuuhutkykphrkkkn ztysyokikyuuhutkykphrkkkn}</td><td>（中継用）初期給付特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykntgk ztysykkyuhtkykntgk}</td><td>（中継用）初期給付特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyokikyuuhutokuyakup ztysyokikyuuhutokuyakup}</td><td>（中継用）初期給付特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykgtkbn ztysykkyuhtkykgtkbn}</td><td>（中継用）初期給付特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokikyuuhutkykkgusdkbn ztysyokikyuuhutkykkgusdkbn}</td><td>（中継用）初期給付特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkjyuryumshyutn ztysykkyuhtkjyuryumshyutn}</td><td>（中継用）初期給付特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyokikyuuhutokujyoup ztysyokikyuuhutokujyoup}</td><td>（中継用）初期給付特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtktbicdx1 ztysykkyuhtktbicdx1}</td><td>（中継用）初期給付特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhhtnpkknx1 ztysykkyuhhtnpkknx1}</td><td>（中継用）初期給付不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtktbicdx2 ztysykkyuhtktbicdx2}</td><td>（中継用）初期給付特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhhtnpkknx2 ztysykkyuhhtnpkknx2}</td><td>（中継用）初期給付不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykkyuhtkykpwrbkkbn ztysykkyuhtkykpwrbkkbn}</td><td>（中継用）初期給付特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x6 ztyyobiv3x6}</td><td>（中継用）予備項目Ｖ３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkyksyrikgu ztydi2sykkyuhtkyksyrikgu}</td><td>（中継用）第２初期給付特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkkn ztydi2sykkyuhtkykkkn}</td><td>（中継用）第２初期給付特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykphrkkkn ztydi2sykkyuhtkykphrkkkn}</td><td>（中継用）第２初期給付特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykntgk ztydi2sykkyuhtkykntgk}</td><td>（中継用）第２初期給付特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2syokikyuuhutokuyakup ztydai2syokikyuuhutokuyakup}</td><td>（中継用）第２初期給付特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykgtkbn ztydi2sykkyuhtkykgtkbn}</td><td>（中継用）第２初期給付特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykkgusdkbn ztydi2sykkyuhtkykkgusdkbn}</td><td>（中継用）第２初期給付特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkjyuryumshytn ztydi2sykkyuhtkjyuryumshytn}</td><td>（中継用）第２初期給付特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2syokikyuuhutokujyoup ztydai2syokikyuuhutokujyoup}</td><td>（中継用）第２初期給付特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtktbicdx1 ztydi2sykkyuhtktbicdx1}</td><td>（中継用）第２初期給付特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhhtnpkknx1 ztydi2sykkyuhhtnpkknx1}</td><td>（中継用）第２初期給付不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtktbicdx2 ztydi2sykkyuhtktbicdx2}</td><td>（中継用）第２初期給付特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhhtnpkknx2 ztydi2sykkyuhhtnpkknx2}</td><td>（中継用）第２初期給付不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sykkyuhtkykpwrbkkbn ztydi2sykkyuhtkykpwrbkkbn}</td><td>（中継用）第２初期給付特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x7 ztyyobiv3x7}</td><td>（中継用）予備項目Ｖ３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydfitijibaraip ztydfitijibaraip}</td><td>（中継用）ＤＦ一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydfgoukeitenkankakaku ztydfgoukeitenkankakaku}</td><td>（中継用）ＤＦ合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydfuktkjivbbntnknkakaku ztydfuktkjivbbntnknkakaku}</td><td>（中継用）ＤＦ受付時Ｖ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydfuktkjipbbntnknkakaku ztydfuktkjipbbntnknkakaku}</td><td>（中継用）ＤＦ受付時Ｐ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydftnkngvbbntnknkakaku ztydftnkngvbbntnknkakaku}</td><td>（中継用）ＤＦ転換後Ｖ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydftnkngpbbntnknkakaku ztydftnkngpbbntnknkakaku}</td><td>（中継用）ＤＦ転換後Ｐ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv18x2 ztyyobiv18x2}</td><td>（中継用）予備項目Ｖ１８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomrtisyuruikgu ztykaigomrtisyuruikgu}</td><td>（中継用）介護マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikigousdkbn ztykaigomaruteikigousdkbn}</td><td>（中継用）介護マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteikikan ztykaigomaruteikikan}</td><td>（中継用）介護マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteiphrkkkn ztykaigomaruteiphrkkkn}</td><td>（中継用）介護マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteis ztykaigomaruteis}</td><td>（中継用）介護マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteip ztykaigomaruteip}</td><td>（中継用）介護マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteisyuuseis ztykaigomaruteisyuuseis}</td><td>（中継用）介護マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteimodsskgnhyj ztykaigomaruteimodsskgnhyj}</td><td>（中継用）介護マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtitkjyukbn ztykigmrtitkjyukbn}</td><td>（中継用）介護マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtitkjyuskgnkkn ztykigmrtitkjyuskgnkkn}</td><td>（中継用）介護マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtitkjyuryumshyutn ztykigmrtitkjyuryumshyutn}</td><td>（中継用）介護マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykaigomaruteitokujyoup ztykaigomaruteitokujyoup}</td><td>（中継用）介護マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtisyrikgux1 ztyhtnknkigmrtisyrikgux1}</td><td>（中継用）被転換介護マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtisyrikgux2 ztyhtnknkigmrtisyrikgux2}</td><td>（中継用）被転換介護マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtisyrikgux3 ztyhtnknkigmrtisyrikgux3}</td><td>（中継用）被転換介護マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtisyrikgux4 ztyhtnknkigmrtisyrikgux4}</td><td>（中継用）被転換介護マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtisyrikgux5 ztyhtnknkigmrtisyrikgux5}</td><td>（中継用）被転換介護マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkigmrtisyrikgux6 ztyhtnknkigmrtisyrikgux6}</td><td>（中継用）被転換介護マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrtisdkbnx1 ztyhtnknkaigomrtisdkbnx1}</td><td>（中継用）被転換介護マル定世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrtisdkbnx2 ztyhtnknkaigomrtisdkbnx2}</td><td>（中継用）被転換介護マル定世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrtisdkbnx3 ztyhtnknkaigomrtisdkbnx3}</td><td>（中継用）被転換介護マル定世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrtisdkbnx4 ztyhtnknkaigomrtisdkbnx4}</td><td>（中継用）被転換介護マル定世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrtisdkbnx5 ztyhtnknkaigomrtisdkbnx5}</td><td>（中継用）被転換介護マル定世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkaigomrtisdkbnx6 ztyhtnknkaigomrtisdkbnx6}</td><td>（中継用）被転換介護マル定世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysurkigmrtipwrbkkbn ztysurkigmrtipwrbkkbn}</td><td>（中継用）数理介護マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtipwrbkkbn ztykigmrtipwrbkkbn}</td><td>（中継用）介護マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtitnknyugukbn ztykigmrtitnknyugukbn}</td><td>（中継用）介護マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtikusnmnryoage ztykigmrtikusnmnryoage}</td><td>（中継用）介護マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x7 ztyyobiv2x7}</td><td>（中継用）予備項目Ｖ２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteisyuruikigou ztykaigotokuteisyuruikigou}</td><td>（中継用）介護トク定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotktikgusdkbn ztykaigotktikgusdkbn}</td><td>（中継用）介護トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteikikan ztykaigotokuteikikan}</td><td>（中継用）介護トク定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteis ztykaigotokuteis}</td><td>（中継用）介護トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteip ztykaigotokuteip}</td><td>（中継用）介護トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykigtktisdtpdtkbn ztykigtktisdtpdtkbn}</td><td>（中継用）介護トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotokuteisyuuseis ztykaigotokuteisyuuseis}</td><td>（中継用）介護トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigotktimodsskgnhyj ztykaigotktimodsskgnhyj}</td><td>（中継用）介護トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigotktikusnmnryoage ztykaigotktikusnmnryoage}</td><td>（中継用）介護トク定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x11 ztyyobiv8x11}</td><td>（中継用）予備項目Ｖ８＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokuiryoutkyksyuruikgu ztykazokuiryoutkyksyuruikgu}</td><td>（中継用）家族医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokuiryoutokuyakukikan ztykazokuiryoutokuyakukikan}</td><td>（中継用）家族医療特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokuiryoutkykphrkkkn ztykazokuiryoutkykphrkkkn}</td><td>（中継用）家族医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykntgk ztykzkiryoutkykntgk}</td><td>（中継用）家族医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokuiryoutokuyakup ztykazokuiryoutokuyakup}</td><td>（中継用）家族医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutkykgtkbn ztykzkiryoutkykgtkbn}</td><td>（中継用）家族医療特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokuiryoutkykkgusdkbn ztykazokuiryoutkykkgusdkbn}</td><td>（中継用）家族医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutktbicdx1 ztykzkiryoutktbicdx1}</td><td>（中継用）家族医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryouhtnpkknx1 ztykzkiryouhtnpkknx1}</td><td>（中継用）家族医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryoutktbicdx2 ztykzkiryoutktbicdx2}</td><td>（中継用）家族医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkiryouhtnpkknx2 ztykzkiryouhtnpkknx2}</td><td>（中継用）家族医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x10 ztyyobiv12x10}</td><td>（中継用）予備項目Ｖ１２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu2Ty
 * @see     PKZT_Sp2RnduyuSouseiritu2Ty
 * @see     QZT_Sp2RnduyuSouseiritu2Ty
 * @see     GenQZT_Sp2RnduyuSouseiritu2Ty
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu2Ty.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu2Ty.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu2Ty extends AbstractExDBEntity<ZT_Sp2RnduyuSouseiritu2Ty, PKZT_Sp2RnduyuSouseiritu2Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu2Ty";
    public static final String ZTYKTGYSYRYMD            = "ztyktgysyrymd";
    public static final String ZTYKTGYSYONO             = "ztyktgysyono";
    public static final String ZTYKTGYFILERENNO         = "ztyktgyfilerenno";
    public static final String ZTYSITEIDAIRININKBN      = "ztysiteidairininkbn";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYSRKYKDRKBN            = "ztysrkykdrkbn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYYOBIV6X3              = "ztyyobiv6x3";
    public static final String ZTYLIVINGNEEDSTKYKARIHYJ = "ztylivingneedstkykarihyj";
    public static final String ZTYYOBIV4X12             = "ztyyobiv4x12";
    public static final String ZTYGANSUPPORTTKYKARIHYJ  = "ztygansupporttkykarihyj";
    public static final String ZTYYOBIV4X13             = "ztyyobiv4x13";
    public static final String ZTYTUUINTOKUYAKUSYURUIKIGOU = "ztytuuintokuyakusyuruikigou";
    public static final String ZTYTUUINTOKUYAKUKIKAN    = "ztytuuintokuyakukikan";
    public static final String ZTYTUINTKYKPHRKKKN       = "ztytuintkykphrkkkn";
    public static final String ZTYTUUINTOKUYAKUNITIGAKU = "ztytuuintokuyakunitigaku";
    public static final String ZTYTUUINTOKUYAKUP        = "ztytuuintokuyakup";
    public static final String ZTYTUUINTOKUYAKUGATAKBN  = "ztytuuintokuyakugatakbn";
    public static final String ZTYTUINTKJYURYUMSHYUTN   = "ztytuintkjyuryumshyutn";
    public static final String ZTYTUUINTOKUJYOUP        = "ztytuuintokujyoup";
    public static final String ZTYTUUINTOKUTEIBUICDX1   = "ztytuuintokuteibuicdx1";
    public static final String ZTYTUUINHUTANPOKIKANX1   = "ztytuuinhutanpokikanx1";
    public static final String ZTYTUUINTOKUTEIBUICDX2   = "ztytuuintokuteibuicdx2";
    public static final String ZTYTUUINHUTANPOKIKANX2   = "ztytuuinhutanpokikanx2";
    public static final String ZTYTUINTKYKKGUSDKBN      = "ztytuintkykkgusdkbn";
    public static final String ZTYTUINTKYKPWRBKKBN      = "ztytuintkykpwrbkkbn";
    public static final String ZTYYOBIV3X4              = "ztyyobiv3x4";
    public static final String ZTYDI2TUINTKYKSYRIKGU    = "ztydi2tuintkyksyrikgu";
    public static final String ZTYDAI2TUUINTOKUYAKUKIKAN = "ztydai2tuuintokuyakukikan";
    public static final String ZTYDAI2TUINTKYKPHRKKKN   = "ztydai2tuintkykphrkkkn";
    public static final String ZTYDAI2TUUINTOKUYAKUNTGK = "ztydai2tuuintokuyakuntgk";
    public static final String ZTYDAI2TUUINTOKUYAKUP    = "ztydai2tuuintokuyakup";
    public static final String ZTYDAI2TUUINTOKUYAKUGATAKBN = "ztydai2tuuintokuyakugatakbn";
    public static final String ZTYDI2TUINTKJYURYUMSHYUTN = "ztydi2tuintkjyuryumshyutn";
    public static final String ZTYDAI2TUUINTOKUJYOUP    = "ztydai2tuuintokujyoup";
    public static final String ZTYDAI2TUUINTOKUTEIBUICDX1 = "ztydai2tuuintokuteibuicdx1";
    public static final String ZTYDAI2TUUINHUTANPOKIKANX1 = "ztydai2tuuinhutanpokikanx1";
    public static final String ZTYDAI2TUUINTOKUTEIBUICDX2 = "ztydai2tuuintokuteibuicdx2";
    public static final String ZTYDAI2TUUINHUTANPOKIKANX2 = "ztydai2tuuinhutanpokikanx2";
    public static final String ZTYDI2TUINTKYKKGUSDKBN   = "ztydi2tuintkykkgusdkbn";
    public static final String ZTYDI2TUINTKYKPWRBKKBN   = "ztydi2tuintkykpwrbkkbn";
    public static final String ZTYYOBIV3X5              = "ztyyobiv3x5";
    public static final String ZTYKANGOTOKUYAKUSYURUIKIGOU = "ztykangotokuyakusyuruikigou";
    public static final String ZTYKANGOTOKUYAKUKIKAN    = "ztykangotokuyakukikan";
    public static final String ZTYKANGOTKYKPHRKKKN      = "ztykangotkykphrkkkn";
    public static final String ZTYKANGOTOKUYAKUNITIGAKU = "ztykangotokuyakunitigaku";
    public static final String ZTYKANGOTOKUYAKUP        = "ztykangotokuyakup";
    public static final String ZTYKANGOTOKUYAKUGATAKBN  = "ztykangotokuyakugatakbn";
    public static final String ZTYKNGTKJYURYUMSHYUTN    = "ztykngtkjyuryumshyutn";
    public static final String ZTYKANGOTOKUJYOUP        = "ztykangotokujyoup";
    public static final String ZTYKANGOTOKUTEIBUICDX1   = "ztykangotokuteibuicdx1";
    public static final String ZTYKANGOHUTANPOKIKANX1   = "ztykangohutanpokikanx1";
    public static final String ZTYKANGOTOKUTEIBUICDX2   = "ztykangotokuteibuicdx2";
    public static final String ZTYKANGOHUTANPOKIKANX2   = "ztykangohutanpokikanx2";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYDI2KNGTKYKSYRIKGU     = "ztydi2kngtkyksyrikgu";
    public static final String ZTYDAI2KANGOTOKUYAKUKIKAN = "ztydai2kangotokuyakukikan";
    public static final String ZTYDAI2KNGTKYKPHRKKKN    = "ztydai2kngtkykphrkkkn";
    public static final String ZTYDAI2KANGOTOKUYAKUNTGK = "ztydai2kangotokuyakuntgk";
    public static final String ZTYDAI2KANGOTOKUYAKUP    = "ztydai2kangotokuyakup";
    public static final String ZTYDAI2KANGOTOKUYAKUGATAKBN = "ztydai2kangotokuyakugatakbn";
    public static final String ZTYDI2KNGTKJYURYUMSHYUTN = "ztydi2kngtkjyuryumshyutn";
    public static final String ZTYDAI2KANGOTOKUJYOUP    = "ztydai2kangotokujyoup";
    public static final String ZTYDAI2KANGOTOKUTEIBUICDX1 = "ztydai2kangotokuteibuicdx1";
    public static final String ZTYDAI2KANGOHUTANPOKIKANX1 = "ztydai2kangohutanpokikanx1";
    public static final String ZTYDAI2KANGOTOKUTEIBUICDX2 = "ztydai2kangotokuteibuicdx2";
    public static final String ZTYDAI2KANGOHUTANPOKIKANX2 = "ztydai2kangohutanpokikanx2";
    public static final String ZTYYOBIV6X2              = "ztyyobiv6x2";
    public static final String ZTYJYSISPPITKYKSYURUIKGU = "ztyjysisppitkyksyuruikgu";
    public static final String ZTYJYSISPPITKYKKKN       = "ztyjysisppitkykkkn";
    public static final String ZTYJYSISPPITKYKPHRKKKN   = "ztyjysisppitkykphrkkkn";
    public static final String ZTYJYSISPPITKYKNTGK      = "ztyjysisppitkykntgk";
    public static final String ZTYJYOSEISIPPEITOKUYAKUP = "ztyjyoseisippeitokuyakup";
    public static final String ZTYJYSISPPITKJYURYUMSHYUTN = "ztyjysisppitkjyuryumshyutn";
    public static final String ZTYJYOSEISIPPEITOKUJYOUP = "ztyjyoseisippeitokujyoup";
    public static final String ZTYJYSISPPITKTBICDX1     = "ztyjysisppitktbicdx1";
    public static final String ZTYJYSISPPIHTNPKKNX1     = "ztyjysisppihtnpkknx1";
    public static final String ZTYJYSISPPITKTBICDX2     = "ztyjysisppitktbicdx2";
    public static final String ZTYJYSISPPIHTNPKKNX2     = "ztyjysisppihtnpkknx2";
    public static final String ZTYJYSISPPITKYKKGUSDKBN  = "ztyjysisppitkykkgusdkbn";
    public static final String ZTYJYSISPPITKYKPWRBKKBN  = "ztyjysisppitkykpwrbkkbn";
    public static final String ZTYJYSISPPITKYKKUSNMNRYOAGE = "ztyjysisppitkykkusnmnryoage";
    public static final String ZTYYOBIV2X2              = "ztyyobiv2x2";
    public static final String ZTYDI2JYSISPPITKYKSYRIKGU = "ztydi2jysisppitkyksyrikgu";
    public static final String ZTYDI2JYSISPPITKYKKKN    = "ztydi2jysisppitkykkkn";
    public static final String ZTYDI2JYSISPPITKYKPHRKKKN = "ztydi2jysisppitkykphrkkkn";
    public static final String ZTYDI2JYSISPPITKYKNTGK   = "ztydi2jysisppitkykntgk";
    public static final String ZTYDI2JYSISPPITKYKP      = "ztydi2jysisppitkykp";
    public static final String ZTYDI2JYSISPPITKJYURYMSHYTN = "ztydi2jysisppitkjyurymshytn";
    public static final String ZTYDI2JYSISPPITKJYUP     = "ztydi2jysisppitkjyup";
    public static final String ZTYDI2JYSISPPITKTBICDX1  = "ztydi2jysisppitktbicdx1";
    public static final String ZTYDI2JYSISPPIHTNPKKNX1  = "ztydi2jysisppihtnpkknx1";
    public static final String ZTYDI2JYSISPPITKTBICDX2  = "ztydi2jysisppitktbicdx2";
    public static final String ZTYDI2JYSISPPIHTNPKKNX2  = "ztydi2jysisppihtnpkknx2";
    public static final String ZTYDI2JYSISPPITKYKKGUSDKBN = "ztydi2jysisppitkykkgusdkbn";
    public static final String ZTYDI2JYSISPPITKYKPWRBKKBN = "ztydi2jysisppitkykpwrbkkbn";
    public static final String ZTYYOBIV4X14             = "ztyyobiv4x14";
    public static final String ZTYWINNINGLIFEHYOUJI     = "ztywinninglifehyouji";
    public static final String ZTYSTYOUIKUSIKINUKTRININKBN = "ztystyouikusikinuktrininkbn";
    public static final String ZTYJYUDTHUMEHARAITKYKARIHYJ = "ztyjyudthumeharaitkykarihyj";
    public static final String ZTYSINKENKOUSEIKATUPACKHYJ = "ztysinkenkouseikatupackhyj";
    public static final String ZTYSYUKEIYAKUPWARIBIKIKBN = "ztysyukeiyakupwaribikikbn";
    public static final String ZTYSYKYKTNKNYUGUKBN      = "ztysykyktnknyugukbn";
    public static final String ZTYMOSJIHONNINKKNNKBN    = "ztymosjihonninkknnkbn";
    public static final String ZTYKITUENHONSUU          = "ztykituenhonsuu";
    public static final String ZTYKOUSINMAETENKANNENSUUKBN = "ztykousinmaetenkannensuukbn";
    public static final String ZTYMANKIMAETENKANNENSUUKBN = "ztymankimaetenkannensuukbn";
    public static final String ZTYSEIKITENKANHYOUJI     = "ztyseikitenkanhyouji";
    public static final String ZTYGENGAKUTENKANKYKHYJ   = "ztygengakutenkankykhyj";
    public static final String ZTYYOBIV2X3              = "ztyyobiv2x3";
    public static final String ZTYKOUSIN3NENMAETNKNHYJ  = "ztykousin3nenmaetnknhyj";
    public static final String ZTYDUGKTNKNSNTKHUHUKBN   = "ztydugktnknsntkhuhukbn";
    public static final String ZTYTNKNSNSTKBTTRTKKBN    = "ztytnknsnstkbttrtkkbn";
    public static final String ZTYHTNKNSIGINYUINTKYKGKNTGK = "ztyhtnknsiginyuintkykgkntgk";
    public static final String ZTYHTNKNSIGINYUINTKYKKYKYMD = "ztyhtnknsiginyuintkykkykymd";
    public static final String ZTYHTNKNSIGINYUINTKYKSNSKBN = "ztyhtnknsiginyuintkyksnskbn";
    public static final String ZTYHTNKNSPPINYUINTKYKGKNTGK = "ztyhtnknsppinyuintkykgkntgk";
    public static final String ZTYHTNKNSPPINYUINTKYKKYKYMD = "ztyhtnknsppinyuintkykkykymd";
    public static final String ZTYHTNKNSPPINYUINTKYKSNSKBN = "ztyhtnknsppinyuintkyksnskbn";
    public static final String ZTYHTNKNSIJNBYUTKYKGUKINTGK = "ztyhtnknsijnbyutkykgukintgk";
    public static final String ZTYHTNKNSIJNBYUTKYKKYKYMD = "ztyhtnknsijnbyutkykkykymd";
    public static final String ZTYHTNKNSIJNBYUTKYKSNSKBN = "ztyhtnknsijnbyutkyksnskbn";
    public static final String ZTYHTNKNJYSISPPITKYKGKINTGK = "ztyhtnknjysisppitkykgkintgk";
    public static final String ZTYHTNKNJYSISPPITKYKKYKYMD = "ztyhtnknjysisppitkykkykymd";
    public static final String ZTYHTNKNJYSISPPITKYKSNSKBN = "ztyhtnknjysisppitkyksnskbn";
    public static final String ZTYSITEIZUKIPWARIMASIHYOUJI = "ztysiteizukipwarimasihyouji";
    public static final String ZTYPWARIMASISITEIM1      = "ztypwarimasisiteim1";
    public static final String ZTYPWARIMASISITEIM2      = "ztypwarimasisiteim2";
    public static final String ZTYSITEIMSYKYKPBAIRITU   = "ztysiteimsykykpbairitu";
    public static final String ZTYSITEIZUKISYUKEIYAKUP  = "ztysiteizukisyukeiyakup";
    public static final String ZTYTUUJYOUTUKIHARAIKOMIP = "ztytuujyoutukiharaikomip";
    public static final String ZTYSITEIZUKIHARAIKOMIP   = "ztysiteizukiharaikomip";
    public static final String ZTYMARUTEIKISITEIZUKIP   = "ztymaruteikisiteizukip";
    public static final String ZTYSEIZONMARUTEISITEIMP  = "ztyseizonmaruteisiteimp";
    public static final String ZTYMARUTEIPSITEIBAIRITU  = "ztymaruteipsiteibairitu";
    public static final String ZTYSEIZONMARUTEIPSTBAIRITU = "ztyseizonmaruteipstbairitu";
    public static final String ZTYNKDTMRTISYURUIKGU     = "ztynkdtmrtisyuruikgu";
    public static final String ZTYNENKINDATEMARUTEIKIKAN = "ztynenkindatemaruteikikan";
    public static final String ZTYNKDATEMARUTEIPHRKKKN  = "ztynkdatemaruteiphrkkkn";
    public static final String ZTYNKDATEMARUTEINENKINNENGK = "ztynkdatemaruteinenkinnengk";
    public static final String ZTYNENKINDATEMARUTEIS    = "ztynenkindatemaruteis";
    public static final String ZTYNENKINDATEMARUTEIP    = "ztynenkindatemaruteip";
    public static final String ZTYNKDATEMARUTEIMODS     = "ztynkdatemaruteimods";
    public static final String ZTYNKDTMRTIMODSSKGNHYJ   = "ztynkdtmrtimodsskgnhyj";
    public static final String ZTYNKDATEMARUTEITKJYOUKBN = "ztynkdatemaruteitkjyoukbn";
    public static final String ZTYNKDTMRTITKJYOUSKGNKKN = "ztynkdtmrtitkjyouskgnkkn";
    public static final String ZTYNKDTMRTITKJYOURYUMSHYTN = "ztynkdtmrtitkjyouryumshytn";
    public static final String ZTYNKDATEMARUTEITKJYOUP  = "ztynkdatemaruteitkjyoup";
    public static final String ZTYHTNKNNKDTMRTISYURUIKGUX1 = "ztyhtnknnkdtmrtisyuruikgux1";
    public static final String ZTYHTNKNNKDTMRTISYURUIKGUX2 = "ztyhtnknnkdtmrtisyuruikgux2";
    public static final String ZTYHTNKNNKDTMRTISYURUIKGUX3 = "ztyhtnknnkdtmrtisyuruikgux3";
    public static final String ZTYHTNKNNKDTMRTISYURUIKGUX4 = "ztyhtnknnkdtmrtisyuruikgux4";
    public static final String ZTYHTNKNNKDTMRTISYURUIKGUX5 = "ztyhtnknnkdtmrtisyuruikgux5";
    public static final String ZTYHTNKNNKDTMRTISYURUIKGUX6 = "ztyhtnknnkdtmrtisyuruikgux6";
    public static final String ZTYNKDATEMARUTEISHRKKN   = "ztynkdatemaruteishrkkn";
    public static final String ZTYSURIYOUNKDTMRTIPWRBKKBN = "ztysuriyounkdtmrtipwrbkkbn";
    public static final String ZTYNKDATEMARUTEIPWRBKKBN = "ztynkdatemaruteipwrbkkbn";
    public static final String ZTYHTNKNKYKSITEIMHYJX1   = "ztyhtnknkyksiteimhyjx1";
    public static final String ZTYHTNKNKYKSITEIMHYJX2   = "ztyhtnknkyksiteimhyjx2";
    public static final String ZTYHTNKNKYKSITEIMHYJX3   = "ztyhtnknkyksiteimhyjx3";
    public static final String ZTYHTNKNKYKSITEIMHYJX4   = "ztyhtnknkyksiteimhyjx4";
    public static final String ZTYHTNKNKYKSITEIMHYJX5   = "ztyhtnknkyksiteimhyjx5";
    public static final String ZTYHTNKNKYKSITEIMHYJX6   = "ztyhtnknkyksiteimhyjx6";
    public static final String ZTYTYOHKREINYUTKBTTRTKHYJ = "ztytyohkreinyutkbttrtkhyj";
    public static final String ZTYKAZOKUMRTINKNENGK     = "ztykazokumrtinknengk";
    public static final String ZTYALMYOUKIJYUNYM        = "ztyalmyoukijyunym";
    public static final String ZTYSETAITESYONO2         = "ztysetaitesyono2";
    public static final String ZTYSETAITEHOKENSYURUIKIGOU2 = "ztysetaitehokensyuruikigou2";
    public static final String ZTYSETAITEMRTISYURUIKGU2 = "ztysetaitemrtisyuruikgu2";
    public static final String ZTYSETAITESIZNMRTISYURUI2 = "ztysetaitesiznmrtisyurui2";
    public static final String ZTYSETAITETIGNMRTISYURUI2 = "ztysetaitetignmrtisyurui2";
    public static final String ZTYSETAITEKIHONBUBUNS2   = "ztysetaitekihonbubuns2";
    public static final String ZTYSETGUKITNKNITJBRKHNS2 = "ztysetgukitnknitjbrkhns2";
    public static final String ZTYSETAITESIBOUS2        = "ztysetaitesibous2";
    public static final String ZTYSETGUKITNKNITJBRSBUS2 = "ztysetgukitnknitjbrsbus2";
    public static final String ZTYSETAITESYUUSEIS2      = "ztysetaitesyuuseis2";
    public static final String ZTYSETAITEHARAIKOMIP2    = "ztysetaiteharaikomip2";
    public static final String ZTYSETAITESYUKEIYAKUBUBUNP2 = "ztysetaitesyukeiyakububunp2";
    public static final String ZTYSETAITGUKIKZKMRTIS2   = "ztysetaitgukikzkmrtis2";
    public static final String ZTYSETAITETENKANKYKHYJ2  = "ztysetaitetenkankykhyj2";
    public static final String ZTYSETAITESITEIMHRKP2    = "ztysetaitesiteimhrkp2";
    public static final String ZTYSETAITESITEIMSYKYKP2  = "ztysetaitesiteimsykykp2";
    public static final String ZTYSETAITENKMRTISYURUI2  = "ztysetaitenkmrtisyurui2";
    public static final String ZTYSETAITEHKNKGUSDKBN2   = "ztysetaitehknkgusdkbn2";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYDUJMOSSITISMODSYUGUHYJ = "ztydujmossitismodsyuguhyj";
    public static final String ZTYRNSIJHIYUBRIJDUJMOSKBN = "ztyrnsijhiyubrijdujmoskbn";
    public static final String ZTYTKTSPPISYKYKTIKKNBBNS = "ztytktsppisykyktikknbbns";
    public static final String ZTYTKSTTKYKSYURUIKGU     = "ztytksttkyksyuruikgu";
    public static final String ZTYTOKUSITUTOKUYAKUKIKAN = "ztytokusitutokuyakukikan";
    public static final String ZTYTKSTTKYKPHRKKKN       = "ztytksttkykphrkkkn";
    public static final String ZTYTOKUSITUTOKUYAKUS     = "ztytokusitutokuyakus";
    public static final String ZTYTOKUSITUTOKUYAKUP     = "ztytokusitutokuyakup";
    public static final String ZTYTOKUSITUTOKUYAKUSYUUSEIS = "ztytokusitutokuyakusyuuseis";
    public static final String ZTYTKSTTKYKMODSSAKUGENHYJ = "ztytksttkykmodssakugenhyj";
    public static final String ZTYTKSTTKYKTKJYUKBN      = "ztytksttkyktkjyukbn";
    public static final String ZTYTKSTTKYKTKJYUSKGNKKN  = "ztytksttkyktkjyuskgnkkn";
    public static final String ZTYTKSTTKYKTKJYURYUMSHYUTN = "ztytksttkyktkjyuryumshyutn";
    public static final String ZTYTKSTTKYKTKJYUP        = "ztytksttkyktkjyup";
    public static final String ZTYTKSTTKYKTIKKNBBNS     = "ztytksttkyktikknbbns";
    public static final String ZTYHTNKNTKTSPPITKYKKGUX1 = "ztyhtnkntktsppitkykkgux1";
    public static final String ZTYHTNKNTKTSPPITKYKKGUX2 = "ztyhtnkntktsppitkykkgux2";
    public static final String ZTYHTNKNTKTSPPITKYKKGUX3 = "ztyhtnkntktsppitkykkgux3";
    public static final String ZTYHTNKNTKTSPPITKYKKGUX4 = "ztyhtnkntktsppitkykkgux4";
    public static final String ZTYHTNKNTKTSPPITKYKKGUX5 = "ztyhtnkntktsppitkykkgux5";
    public static final String ZTYHTNKNTKTSPPITKYKKGUX6 = "ztyhtnkntktsppitkykkgux6";
    public static final String ZTYSURYUTKSTTKYKPWRBKKBN = "ztysuryutksttkykpwrbkkbn";
    public static final String ZTYTKSTTKYKPWRBKKBN      = "ztytksttkykpwrbkkbn";
    public static final String ZTYTKSTTKYKTNKNYUGUKBN   = "ztytksttkyktnknyugukbn";
    public static final String ZTYTKSTTKYKKGUSDKBN      = "ztytksttkykkgusdkbn";
    public static final String ZTYYOBIV9X8              = "ztyyobiv9x8";
    public static final String ZTYDI2TKSTTKYKSYRIKGU    = "ztydi2tksttkyksyrikgu";
    public static final String ZTYDAI2TOKUSITUTOKUYAKUKKN = "ztydai2tokusitutokuyakukkn";
    public static final String ZTYDAI2TKSTTKYKPHRKKKN   = "ztydai2tksttkykphrkkkn";
    public static final String ZTYDAI2TOKUSITUTOKUYAKUS = "ztydai2tokusitutokuyakus";
    public static final String ZTYDAI2TOKUSITUTOKUYAKUP = "ztydai2tokusitutokuyakup";
    public static final String ZTYDI2TKSTTKYKSYUUSEIS   = "ztydi2tksttkyksyuuseis";
    public static final String ZTYDI2TKSTTKYKMODSSKGNHYJ = "ztydi2tksttkykmodsskgnhyj";
    public static final String ZTYDI2TKSTTKYKTKJYUKBN   = "ztydi2tksttkyktkjyukbn";
    public static final String ZTYDI2TKSTTKYKTKJYUSKGNKKN = "ztydi2tksttkyktkjyuskgnkkn";
    public static final String ZTYDI2TKSTTKYKTKJYURYMSHYTN = "ztydi2tksttkyktkjyurymshytn";
    public static final String ZTYDI2TKSTTKYKTKJYUP     = "ztydi2tksttkyktkjyup";
    public static final String ZTYDI2TKSTTKYKTAIKKNBBNS = "ztydi2tksttkyktaikknbbns";
    public static final String ZTYHTNKNDI2TKTSPPITKYKKGUX1 = "ztyhtnkndi2tktsppitkykkgux1";
    public static final String ZTYHTNKNDI2TKTSPPITKYKKGUX2 = "ztyhtnkndi2tktsppitkykkgux2";
    public static final String ZTYHTNKNDI2TKTSPPITKYKKGUX3 = "ztyhtnkndi2tktsppitkykkgux3";
    public static final String ZTYHTNKNDI2TKTSPPITKYKKGUX4 = "ztyhtnkndi2tktsppitkykkgux4";
    public static final String ZTYHTNKNDI2TKTSPPITKYKKGUX5 = "ztyhtnkndi2tktsppitkykkgux5";
    public static final String ZTYHTNKNDI2TKTSPPITKYKKGUX6 = "ztyhtnkndi2tktsppitkykkgux6";
    public static final String ZTYSURYUDI2TKSTTKYKPWRBKKBN = "ztysuryudi2tksttkykpwrbkkbn";
    public static final String ZTYDI2TKSTTKYKPWRBKKBN   = "ztydi2tksttkykpwrbkkbn";
    public static final String ZTYDI2TKSTTKYKTNKNYUGUKBN = "ztydi2tksttkyktnknyugukbn";
    public static final String ZTYDI2TKSTTKYKKGUSDKBN   = "ztydi2tksttkykkgusdkbn";
    public static final String ZTYYOBIV9X9              = "ztyyobiv9x9";
    public static final String ZTYJYUUSITUTKYKSYURUIKGU = "ztyjyuusitutkyksyuruikgu";
    public static final String ZTYJYUUSITUTOKUYAKUKIKAN = "ztyjyuusitutokuyakukikan";
    public static final String ZTYJYUUSITUTKYKPHRKKKN   = "ztyjyuusitutkykphrkkkn";
    public static final String ZTYJYUUSITUTOKUYAKUS     = "ztyjyuusitutokuyakus";
    public static final String ZTYJYUUSITUTOKUYAKUP     = "ztyjyuusitutokuyakup";
    public static final String ZTYJYUUSITUTOKUYAKUSYUUSEIS = "ztyjyuusitutokuyakusyuuseis";
    public static final String ZTYJYUUSITUTKYKMODSSKGNHYJ = "ztyjyuusitutkykmodsskgnhyj";
    public static final String ZTYJYUUSITUTKYKTKJYUKBN  = "ztyjyuusitutkyktkjyukbn";
    public static final String ZTYJYUUSITUTKYKTKJYUSKGNKKN = "ztyjyuusitutkyktkjyuskgnkkn";
    public static final String ZTYJYUSTTKYKTKJYURYUMSHYUTN = "ztyjyusttkyktkjyuryumshyutn";
    public static final String ZTYJYUUSITUTKYKTKJYUP    = "ztyjyuusitutkyktkjyup";
    public static final String ZTYJYUUSITUTKYKTKTBICDX1 = "ztyjyuusitutkyktktbicdx1";
    public static final String ZTYJYUUSITUTKYKHTNPKKNX1 = "ztyjyuusitutkykhtnpkknx1";
    public static final String ZTYJYUUSITUTKYKTKTBICDX2 = "ztyjyuusitutkyktktbicdx2";
    public static final String ZTYJYUUSITUTKYKHTNPKKNX2 = "ztyjyuusitutkykhtnpkknx2";
    public static final String ZTYHTNKNMNSISKKNTKYKKGUX1 = "ztyhtnknmnsiskkntkykkgux1";
    public static final String ZTYHTNKNMNSISKKNTKYKKGUX2 = "ztyhtnknmnsiskkntkykkgux2";
    public static final String ZTYHTNKNMNSISKKNTKYKKGUX3 = "ztyhtnknmnsiskkntkykkgux3";
    public static final String ZTYHTNKNMNSISKKNTKYKKGUX4 = "ztyhtnknmnsiskkntkykkgux4";
    public static final String ZTYHTNKNMNSISKKNTKYKKGUX5 = "ztyhtnknmnsiskkntkykkgux5";
    public static final String ZTYHTNKNMNSISKKNTKYKKGUX6 = "ztyhtnknmnsiskkntkykkgux6";
    public static final String ZTYSURYUJYUSTTKYKPWRBKKBN = "ztysuryujyusttkykpwrbkkbn";
    public static final String ZTYJYUUSITUTKYKPWRBKKBN  = "ztyjyuusitutkykpwrbkkbn";
    public static final String ZTYJYUUSITUTKYKTNKNYUGUKBN = "ztyjyuusitutkyktnknyugukbn";
    public static final String ZTYJYUUSITUTKYKKGUSDKBN  = "ztyjyuusitutkykkgusdkbn";
    public static final String ZTYYOBIV7X3              = "ztyyobiv7x3";
    public static final String ZTYDI2JYUUSITUTKYKSYRIKGU = "ztydi2jyuusitutkyksyrikgu";
    public static final String ZTYDI2JYUUSITUTKYKKKN    = "ztydi2jyuusitutkykkkn";
    public static final String ZTYDI2JYUUSITUTKYKPHRKKKN = "ztydi2jyuusitutkykphrkkkn";
    public static final String ZTYDAI2JYUUSITUTOKUYAKUS = "ztydai2jyuusitutokuyakus";
    public static final String ZTYDAI2JYUUSITUTOKUYAKUP = "ztydai2jyuusitutokuyakup";
    public static final String ZTYDI2JYUUSITUTKYKSYUUSEIS = "ztydi2jyuusitutkyksyuuseis";
    public static final String ZTYDI2JYUSTTKYKMODSSKGNHYJ = "ztydi2jyusttkykmodsskgnhyj";
    public static final String ZTYDI2JYUUSITUTKYKTKJYUKBN = "ztydi2jyuusitutkyktkjyukbn";
    public static final String ZTYDI2JYUSTTKYKTKJYUSKGNKKN = "ztydi2jyusttkyktkjyuskgnkkn";
    public static final String ZTYDI2JYUSTTKYKTKJYRYMSHYTN = "ztydi2jyusttkyktkjyrymshytn";
    public static final String ZTYDI2JYUUSITUTKYKTKJYUP = "ztydi2jyuusitutkyktkjyup";
    public static final String ZTYDI2JYUUSITUTKYKTKTBICDX1 = "ztydi2jyuusitutkyktktbicdx1";
    public static final String ZTYDI2JYUUSITUTKYKHTNPKKNX1 = "ztydi2jyuusitutkykhtnpkknx1";
    public static final String ZTYDI2JYUUSITUTKYKTKTBICDX2 = "ztydi2jyuusitutkyktktbicdx2";
    public static final String ZTYDI2JYUUSITUTKYKHTNPKKNX2 = "ztydi2jyuusitutkykhtnpkknx2";
    public static final String ZTYHTNKNDI2MNSISKKNTKYKKGX1 = "ztyhtnkndi2mnsiskkntkykkgx1";
    public static final String ZTYHTNKNDI2MNSISKKNTKYKKGX2 = "ztyhtnkndi2mnsiskkntkykkgx2";
    public static final String ZTYHTNKNDI2MNSISKKNTKYKKGX3 = "ztyhtnkndi2mnsiskkntkykkgx3";
    public static final String ZTYHTNKNDI2MNSISKKNTKYKKGX4 = "ztyhtnkndi2mnsiskkntkykkgx4";
    public static final String ZTYHTNKNDI2MNSISKKNTKYKKGX5 = "ztyhtnkndi2mnsiskkntkykkgx5";
    public static final String ZTYHTNKNDI2MNSISKKNTKYKKGX6 = "ztyhtnkndi2mnsiskkntkykkgx6";
    public static final String ZTYSURYUD2JYUSTTKYKPWRBKKBN = "ztysuryud2jyusttkykpwrbkkbn";
    public static final String ZTYDI2JYUUSITUTKYKPWRBKKBN = "ztydi2jyuusitutkykpwrbkkbn";
    public static final String ZTYDI2JYUSTTKYKTNKNYUGUKBN = "ztydi2jyusttkyktnknyugukbn";
    public static final String ZTYDI2JYUUSITUTKYKKGUSDKBN = "ztydi2jyuusitutkykkgusdkbn";
    public static final String ZTYYOBIV7X4              = "ztyyobiv7x4";
    public static final String ZTYHAITOUSIHARAIKBN      = "ztyhaitousiharaikbn";
    public static final String ZTYSURYUSYKYKPWRBKKBN    = "ztysuryusykykpwrbkkbn";
    public static final String ZTYNKDATETOKUTEISYURUIKGU = "ztynkdatetokuteisyuruikgu";
    public static final String ZTYNENKINDATETOKUTEIKIKAN = "ztynenkindatetokuteikikan";
    public static final String ZTYNKDATETOKUTEINKGK     = "ztynkdatetokuteinkgk";
    public static final String ZTYNENKINDATETOKUTEIS    = "ztynenkindatetokuteis";
    public static final String ZTYNENKINDATETOKUTEIP    = "ztynenkindatetokuteip";
    public static final String ZTYNKDATETOKUTEISDTPDTKBN = "ztynkdatetokuteisdtpdtkbn";
    public static final String ZTYNKDATETOKUTEIMODS     = "ztynkdatetokuteimods";
    public static final String ZTYNKDATETOKUTEIMODSSKGNHYJ = "ztynkdatetokuteimodsskgnhyj";
    public static final String ZTYNKDATETOKUTEISHRKKN   = "ztynkdatetokuteishrkkn";
    public static final String ZTYKYKNIYUTKSYTIOUKBN    = "ztykykniyutksytioukbn";
    public static final String ZTYKEIKA2NENMIMANTENKANHYJ = "ztykeika2nenmimantenkanhyj";
    public static final String ZTYTUKIYUHTNKNKUSNMENNSUKBN = "ztytukiyuhtnknkusnmennsukbn";
    public static final String ZTYNKDATETOKUTEIKGUSDKBN = "ztynkdatetokuteikgusdkbn";
    public static final String ZTYNENKINDATETOKUTEIKATAKBN = "ztynenkindatetokuteikatakbn";
    public static final String ZTYYOBIV2X4              = "ztyyobiv2x4";
    public static final String ZTYSUGUSNSYUTKYKSYURUIKGU = "ztysugusnsyutkyksyuruikgu";
    public static final String ZTYSUGUSNSYUTKYKKKN      = "ztysugusnsyutkykkkn";
    public static final String ZTYSUGUSNSYUTKYKPHRKKKN  = "ztysugusnsyutkykphrkkkn";
    public static final String ZTYSOUGOUSONSYOUTOKUYAKUS = "ztysougousonsyoutokuyakus";
    public static final String ZTYSOUGOUSONSYOUTOKUYAKUP = "ztysougousonsyoutokuyakup";
    public static final String ZTYSUGUSNSYUTKYKKGUSDKBN = "ztysugusnsyutkykkgusdkbn";
    public static final String ZTYSUGUSNSYUTKYKPWRBKKBN = "ztysugusnsyutkykpwrbkkbn";
    public static final String ZTYSUGUSNSYUTKYKKUSNMNRYAGE = "ztysugusnsyutkykkusnmnryage";
    public static final String ZTYYOBIV7X5              = "ztyyobiv7x5";
    public static final String ZTYDI2SUGUSNSYUTKYKSYRIKGU = "ztydi2sugusnsyutkyksyrikgu";
    public static final String ZTYDI2SUGUSNSYUTKYKKKN   = "ztydi2sugusnsyutkykkkn";
    public static final String ZTYDI2SUGUSNSYUTKYKPHRKKKN = "ztydi2sugusnsyutkykphrkkkn";
    public static final String ZTYDI2SUGUSNSYUTKYKS     = "ztydi2sugusnsyutkyks";
    public static final String ZTYDI2SUGUSNSYUTKYKP     = "ztydi2sugusnsyutkykp";
    public static final String ZTYDI2SUGUSNSYTKYKKGUSDKBN = "ztydi2sugusnsytkykkgusdkbn";
    public static final String ZTYDI2SUGUSNSYUTKYKPWRBKKBN = "ztydi2sugusnsyutkykpwrbkkbn";
    public static final String ZTYYOBIV9X10             = "ztyyobiv9x10";
    public static final String ZTYTENKANKEITAIKBN       = "ztytenkankeitaikbn";
    public static final String ZTYGUKITNKNITJBRTIKNKNENGK = "ztygukitnknitjbrtiknknengk";
    public static final String ZTYGUKIHTNKNSUGUSNSYUTKYKS = "ztygukihtnknsugusnsyutkyks";
    public static final String ZTYTENKANITIJIBARAIP     = "ztytenkanitijibaraip";
    public static final String ZTYYOBIV24               = "ztyyobiv24";
    public static final String ZTYGOUKEINENBARAIKANSANPX1 = "ztygoukeinenbaraikansanpx1";
    public static final String ZTYHKTGTIKKIKKKNX1       = "ztyhktgtikkikkknx1";
    public static final String ZTYHTNKNKYKKIGMRSYSYRIKGUX1 = "ztyhtnknkykkigmrsysyrikgux1";
    public static final String ZTYGOUKEINENBARAIKANSANPX2 = "ztygoukeinenbaraikansanpx2";
    public static final String ZTYHKTGTIKKIKKKNX2       = "ztyhktgtikkikkknx2";
    public static final String ZTYHTNKNKYKKIGMRSYSYRIKGUX2 = "ztyhtnknkykkigmrsysyrikgux2";
    public static final String ZTYGOUKEINENBARAIKANSANPX3 = "ztygoukeinenbaraikansanpx3";
    public static final String ZTYHKTGTIKKIKKKNX3       = "ztyhktgtikkikkknx3";
    public static final String ZTYHTNKNKYKKIGMRSYSYRIKGUX3 = "ztyhtnknkykkigmrsysyrikgux3";
    public static final String ZTYGOUKEINENBARAIKANSANPX4 = "ztygoukeinenbaraikansanpx4";
    public static final String ZTYHKTGTIKKIKKKNX4       = "ztyhktgtikkikkknx4";
    public static final String ZTYHTNKNKYKKIGMRSYSYRIKGUX4 = "ztyhtnknkykkigmrsysyrikgux4";
    public static final String ZTYGOUKEINENBARAIKANSANPX5 = "ztygoukeinenbaraikansanpx5";
    public static final String ZTYHKTGTIKKIKKKNX5       = "ztyhktgtikkikkknx5";
    public static final String ZTYHTNKNKYKKIGMRSYSYRIKGUX5 = "ztyhtnknkykkigmrsysyrikgux5";
    public static final String ZTYGOUKEINENBARAIKANSANPX6 = "ztygoukeinenbaraikansanpx6";
    public static final String ZTYHKTGTIKKIKKKNX6       = "ztyhktgtikkikkknx6";
    public static final String ZTYHTNKNKYKKIGMRSYSYRIKGUX6 = "ztyhtnknkykkigmrsysyrikgux6";
    public static final String ZTYNICEONPLANHYJ         = "ztyniceonplanhyj";
    public static final String ZTYSYOKAIPRYOSYUYMD      = "ztysyokaipryosyuymd";
    public static final String ZTYLDOWNMAETENKANNENSUUKBN = "ztyldownmaetenkannensuukbn";
    public static final String ZTYLDOWNMAESAITEISMITATUHYJ = "ztyldownmaesaiteismitatuhyj";
    public static final String ZTYDNTITIKGTKBTTRTKHYJ   = "ztydntitikgtkbttrtkhyj";
    public static final String ZTYREFORMKBN             = "ztyreformkbn";
    public static final String ZTYKIKEIYAKUTYUUIHYOUJI  = "ztykikeiyakutyuuihyouji";
    public static final String ZTYKBNKEIRIYOUSEGCD      = "ztykbnkeiriyousegcd";
    public static final String ZTYSYUUSEISKITEITEKIYOUKBN = "ztysyuuseiskiteitekiyoukbn";
    public static final String ZTYGUKIHTNKNKZKMRTIMODS  = "ztygukihtnknkzkmrtimods";
    public static final String ZTYTNKNKIJYNTKYUHTNKNSBUS = "ztytnknkijyntkyuhtnknsbus";
    public static final String ZTYSRJSNYUSYOUHINHYJ     = "ztysrjsnyusyouhinhyj";
    public static final String ZTYSIRAJIKAKUNINZUMIHYOUJI = "ztysirajikakuninzumihyouji";
    public static final String ZTYSRJSNYUSYOUHINTKNNHYJ = "ztysrjsnyusyouhintknnhyj";
    public static final String ZTYSINSAKBN              = "ztysinsakbn";
    public static final String ZTYDAI2SINSAKBN          = "ztydai2sinsakbn";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYDAI2TOUKEIYOUSINSAKBN = "ztydai2toukeiyousinsakbn";
    public static final String ZTYSEIZONKYUHKNSHRSITEIMD = "ztyseizonkyuhknshrsiteimd";
    public static final String ZTYYOTEIRIRITUN5         = "ztyyoteiriritun5";
    public static final String ZTYSAITEIHOSYOURIRITU    = "ztysaiteihosyouriritu";
    public static final String ZTYNKGNSRITU             = "ztynkgnsritu";
    public static final String ZTYJIGYOUNENDOMATUV      = "ztyjigyounendomatuv";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYGUKIHTNKN5NNMEKSNYUMODS = "ztygukihtnkn5nnmeksnyumods";
    public static final String ZTYRENSEITEIKITKSYUSNKSNHYJ = "ztyrenseiteikitksyusnksnhyj";
    public static final String ZTYGOUKEINENBARAIKANSANP2X1 = "ztygoukeinenbaraikansanp2x1";
    public static final String ZTYGUKINENBARAIKNSNP2KBNX1 = "ztygukinenbaraiknsnp2kbnx1";
    public static final String ZTYHKTGTIKKIKKKN2X1      = "ztyhktgtikkikkkn2x1";
    public static final String ZTYGOUKEINENBARAIKANSANP2X2 = "ztygoukeinenbaraikansanp2x2";
    public static final String ZTYGUKINENBARAIKNSNP2KBNX2 = "ztygukinenbaraiknsnp2kbnx2";
    public static final String ZTYHKTGTIKKIKKKN2X2      = "ztyhktgtikkikkkn2x2";
    public static final String ZTYGOUKEINENBARAIKANSANP2X3 = "ztygoukeinenbaraikansanp2x3";
    public static final String ZTYGUKINENBARAIKNSNP2KBNX3 = "ztygukinenbaraiknsnp2kbnx3";
    public static final String ZTYHKTGTIKKIKKKN2X3      = "ztyhktgtikkikkkn2x3";
    public static final String ZTYGOUKEINENBARAIKANSANP2X4 = "ztygoukeinenbaraikansanp2x4";
    public static final String ZTYGUKINENBARAIKNSNP2KBNX4 = "ztygukinenbaraiknsnp2kbnx4";
    public static final String ZTYHKTGTIKKIKKKN2X4      = "ztyhktgtikkikkkn2x4";
    public static final String ZTYGOUKEINENBARAIKANSANP2X5 = "ztygoukeinenbaraikansanp2x5";
    public static final String ZTYGUKINENBARAIKNSNP2KBNX5 = "ztygukinenbaraiknsnp2kbnx5";
    public static final String ZTYHKTGTIKKIKKKN2X5      = "ztyhktgtikkikkkn2x5";
    public static final String ZTYGOUKEINENBARAIKANSANP2X6 = "ztygoukeinenbaraikansanp2x6";
    public static final String ZTYGUKINENBARAIKNSNP2KBNX6 = "ztygukinenbaraiknsnp2kbnx6";
    public static final String ZTYHKTGTIKKIKKKN2X6      = "ztyhktgtikkikkkn2x6";
    public static final String ZTYKOKUTITUUSANTAISYOUS  = "ztykokutituusantaisyous";
    public static final String ZTYTOKUSYUYOUROUMANKIS   = "ztytokusyuyouroumankis";
    public static final String ZTYNKDTMRTITNKNYUUGUUKBN = "ztynkdtmrtitnknyuuguukbn";
    public static final String ZTYNKDTMRTIKGUSDKBN      = "ztynkdtmrtikgusdkbn";
    public static final String ZTYNENKINDATEMARUTEIKATAKBN = "ztynenkindatemaruteikatakbn";
    public static final String ZTYNKDTMRTIKUSNMNRYOAGE  = "ztynkdtmrtikusnmnryoage";
    public static final String ZTYKAIGONKDTMRTISYURUIKGU = "ztykaigonkdtmrtisyuruikgu";
    public static final String ZTYKAIGONKDTMRTIKKAN     = "ztykaigonkdtmrtikkan";
    public static final String ZTYKAIGONKDTMRTIPHRKKKN  = "ztykaigonkdtmrtiphrkkkn";
    public static final String ZTYKAIGONKDTMRTINNKNNENGK = "ztykaigonkdtmrtinnknnengk";
    public static final String ZTYKAIGONKDTMRTIS        = "ztykaigonkdtmrtis";
    public static final String ZTYKAIGONKDTMRTIP        = "ztykaigonkdtmrtip";
    public static final String ZTYKAIGONKDTMRTIMODS     = "ztykaigonkdtmrtimods";
    public static final String ZTYKAIGONKDTMRTITKJYUKBN = "ztykaigonkdtmrtitkjyukbn";
    public static final String ZTYKAIGONKDTMRTITKJYSKGNKKN = "ztykaigonkdtmrtitkjyskgnkkn";
    public static final String ZTYKAIGONKDTMRTTKJYRYMSHYTN = "ztykaigonkdtmrttkjyrymshytn";
    public static final String ZTYKAIGONKDTMRTITKJYUP   = "ztykaigonkdtmrtitkjyup";
    public static final String ZTYHTNKNKAIGONKMRTSYRIKGUX1 = "ztyhtnknkaigonkmrtsyrikgux1";
    public static final String ZTYHTNKNKAIGONKMRTSYRIKGUX2 = "ztyhtnknkaigonkmrtsyrikgux2";
    public static final String ZTYHTNKNKAIGONKMRTSYRIKGUX3 = "ztyhtnknkaigonkmrtsyrikgux3";
    public static final String ZTYHTNKNKAIGONKMRTSYRIKGUX4 = "ztyhtnknkaigonkmrtsyrikgux4";
    public static final String ZTYHTNKNKAIGONKMRTSYRIKGUX5 = "ztyhtnknkaigonkmrtsyrikgux5";
    public static final String ZTYHTNKNKAIGONKMRTSYRIKGUX6 = "ztyhtnknkaigonkmrtsyrikgux6";
    public static final String ZTYKAIGONKDTMRTISHRKKN   = "ztykaigonkdtmrtishrkkn";
    public static final String ZTYSURIKAIGONKMRTIPWRBKKBN = "ztysurikaigonkmrtipwrbkkbn";
    public static final String ZTYKAIGONKDTMRTIPWRBKKBN = "ztykaigonkdtmrtipwrbkkbn";
    public static final String ZTYKAIGONKDTMRTITNKNYUGUKBN = "ztykaigonkdtmrtitnknyugukbn";
    public static final String ZTYKAIGONKDTMRTIKGUSDKBN = "ztykaigonkdtmrtikgusdkbn";
    public static final String ZTYKAIGONKDTMRTIKTKBN    = "ztykaigonkdtmrtiktkbn";
    public static final String ZTYKIGNKDTMRTIKUSNMNRYOAGE = "ztykignkdtmrtikusnmnryoage";
    public static final String ZTYKAIGONKDTTKTISYURUIKGU = "ztykaigonkdttktisyuruikgu";
    public static final String ZTYKAIGONKDTTKTIKKN      = "ztykaigonkdttktikkn";
    public static final String ZTYKAIGONKDTTKTEINENKNGK = "ztykaigonkdttkteinenkngk";
    public static final String ZTYKAIGONENKINDATETOKUTEIS = "ztykaigonenkindatetokuteis";
    public static final String ZTYKAIGONENKINDATETOKUTEIP = "ztykaigonenkindatetokuteip";
    public static final String ZTYKAIGONKDTTKTISDTPDTKBN = "ztykaigonkdttktisdtpdtkbn";
    public static final String ZTYKAIGONKDTTKTIMODS     = "ztykaigonkdttktimods";
    public static final String ZTYKAIGONKDTTKTISHRKKN   = "ztykaigonkdttktishrkkn";
    public static final String ZTYKAIGONKDTTKTIKGUSDKBN = "ztykaigonkdttktikgusdkbn";
    public static final String ZTYKAIGONKDTTKTIKTKBN    = "ztykaigonkdttktiktkbn";
    public static final String ZTYKIGNKDTTKTIKUSNMNRYOAGE = "ztykignkdttktikusnmnryoage";
    public static final String ZTYYOBIV2X5              = "ztyyobiv2x5";
    public static final String ZTYKAIGOTEIGENMRTISYURUIKGU = "ztykaigoteigenmrtisyuruikgu";
    public static final String ZTYKAIGOTEIGENMARUTEIKIKAN = "ztykaigoteigenmaruteikikan";
    public static final String ZTYKAIGOTIGNMRTIPHRKKKN  = "ztykaigotignmrtiphrkkkn";
    public static final String ZTYKAIGOTEIGENMARUTEIS   = "ztykaigoteigenmaruteis";
    public static final String ZTYKAIGOTEIGENMARUTEIP   = "ztykaigoteigenmaruteip";
    public static final String ZTYKIGTIGNMRTIMODS       = "ztykigtignmrtimods";
    public static final String ZTYKIGTIGNMRTITKJYUKBN   = "ztykigtignmrtitkjyukbn";
    public static final String ZTYKIGTIGNMRTITKJYUSKGNKKN = "ztykigtignmrtitkjyuskgnkkn";
    public static final String ZTYKIGTIGNMRTITKJYURYMSHYTN = "ztykigtignmrtitkjyurymshytn";
    public static final String ZTYKIGTIGNMRTITKJYUP     = "ztykigtignmrtitkjyup";
    public static final String ZTYHTNKNKIGTIGNMRTSYRIKGUX1 = "ztyhtnknkigtignmrtsyrikgux1";
    public static final String ZTYHTNKNKIGTIGNMRTSYRIKGUX2 = "ztyhtnknkigtignmrtsyrikgux2";
    public static final String ZTYHTNKNKIGTIGNMRTSYRIKGUX3 = "ztyhtnknkigtignmrtsyrikgux3";
    public static final String ZTYHTNKNKIGTIGNMRTSYRIKGUX4 = "ztyhtnknkigtignmrtsyrikgux4";
    public static final String ZTYHTNKNKIGTIGNMRTSYRIKGUX5 = "ztyhtnknkigtignmrtsyrikgux5";
    public static final String ZTYHTNKNKIGTIGNMRTSYRIKGUX6 = "ztyhtnknkigtignmrtsyrikgux6";
    public static final String ZTYSURKIGTIGNMRTIPWRBKKBN = "ztysurkigtignmrtipwrbkkbn";
    public static final String ZTYKIGTIGNMRTIPWRBKKBN   = "ztykigtignmrtipwrbkkbn";
    public static final String ZTYKIGTIGNMRTITNKNYUGUKBN = "ztykigtignmrtitnknyugukbn";
    public static final String ZTYKAIGOTIGNMRTIKGUSDKBN = "ztykaigotignmrtikgusdkbn";
    public static final String ZTYKIGTIGNMRTIKUSNMNRYOAGE = "ztykigtignmrtikusnmnryoage";
    public static final String ZTYYOBIV4X15             = "ztyyobiv4x15";
    public static final String ZTYKAIGOTEIGENTKTISYURUIKGU = "ztykaigoteigentktisyuruikgu";
    public static final String ZTYKAIGOTEIGENTOKUTEIKIKAN = "ztykaigoteigentokuteikikan";
    public static final String ZTYKAIGOTEIGENTOKUTEIS   = "ztykaigoteigentokuteis";
    public static final String ZTYKAIGOTEIGENTOKUTEIP   = "ztykaigoteigentokuteip";
    public static final String ZTYKIGTIGNTKTISDTPDTKBN  = "ztykigtigntktisdtpdtkbn";
    public static final String ZTYKIGTIGNTKTIMODS       = "ztykigtigntktimods";
    public static final String ZTYKAIGOTIGNTKTIKGUSDKBN = "ztykaigotigntktikgusdkbn";
    public static final String ZTYKIGTIGNTKTIKUSNMNRYOAGE = "ztykigtigntktikusnmnryoage";
    public static final String ZTYYOBIV2X6              = "ztyyobiv2x6";
    public static final String ZTYHIKITUGIKAIMASIS      = "ztyhikitugikaimasis";
    public static final String ZTYCBKYHTISYUKYKUMKBN    = "ztycbkyhtisyukykumkbn";
    public static final String ZTYTUKIYUCBKYHTISYUS     = "ztytukiyucbkyhtisyus";
    public static final String ZTYCBHANTEITUUSANS       = "ztycbhanteituusans";
    public static final String ZTYTUKIYUSNKYKCBHNTIS    = "ztytukiyusnkykcbhntis";
    public static final String ZTYCBSTAGEKBN            = "ztycbstagekbn";
    public static final String ZTYTOUKEIYOUCBHANTEITUUSANS = "ztytoukeiyoucbhanteituusans";
    public static final String ZTYCBTUUSANKENSUU        = "ztycbtuusankensuu";
    public static final String ZTYCBHANTEITAISYOUTSNKENSUU = "ztycbhanteitaisyoutsnkensuu";
    public static final String ZTYTYOKUZENTUUSANHANTEISX1 = "ztytyokuzentuusanhanteisx1";
    public static final String ZTYTYOKUZENKYUUHUTAISYOUSX1 = "ztytyokuzenkyuuhutaisyousx1";
    public static final String ZTYTYOKUZENCBGAKUX1      = "ztytyokuzencbgakux1";
    public static final String ZTYTYOKUGOTUUSANHANTEISX1 = "ztytyokugotuusanhanteisx1";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUSX1 = "ztytyokugokyuuhutaisyousx1";
    public static final String ZTYTYOKUGOCBGAKUX1       = "ztytyokugocbgakux1";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYTYOKUZENTUUSANHANTEISX2 = "ztytyokuzentuusanhanteisx2";
    public static final String ZTYTYOKUZENKYUUHUTAISYOUSX2 = "ztytyokuzenkyuuhutaisyousx2";
    public static final String ZTYTYOKUZENCBGAKUX2      = "ztytyokuzencbgakux2";
    public static final String ZTYTYOKUGOTUUSANHANTEISX2 = "ztytyokugotuusanhanteisx2";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUSX2 = "ztytyokugokyuuhutaisyousx2";
    public static final String ZTYTYOKUGOCBGAKUX2       = "ztytyokugocbgakux2";
    public static final String ZTYYOBIV12X2             = "ztyyobiv12x2";
    public static final String ZTYTYOKUZENTUUSANHANTEISX3 = "ztytyokuzentuusanhanteisx3";
    public static final String ZTYTYOKUZENKYUUHUTAISYOUSX3 = "ztytyokuzenkyuuhutaisyousx3";
    public static final String ZTYTYOKUZENCBGAKUX3      = "ztytyokuzencbgakux3";
    public static final String ZTYTYOKUGOTUUSANHANTEISX3 = "ztytyokugotuusanhanteisx3";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUSX3 = "ztytyokugokyuuhutaisyousx3";
    public static final String ZTYTYOKUGOCBGAKUX3       = "ztytyokugocbgakux3";
    public static final String ZTYYOBIV12X3             = "ztyyobiv12x3";
    public static final String ZTYTYOKUZENTUUSANHANTEISX4 = "ztytyokuzentuusanhanteisx4";
    public static final String ZTYTYOKUZENKYUUHUTAISYOUSX4 = "ztytyokuzenkyuuhutaisyousx4";
    public static final String ZTYTYOKUZENCBGAKUX4      = "ztytyokuzencbgakux4";
    public static final String ZTYTYOKUGOTUUSANHANTEISX4 = "ztytyokugotuusanhanteisx4";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUSX4 = "ztytyokugokyuuhutaisyousx4";
    public static final String ZTYTYOKUGOCBGAKUX4       = "ztytyokugocbgakux4";
    public static final String ZTYYOBIV12X4             = "ztyyobiv12x4";
    public static final String ZTYTYOKUZENTUUSANHANTEISX5 = "ztytyokuzentuusanhanteisx5";
    public static final String ZTYTYOKUZENKYUUHUTAISYOUSX5 = "ztytyokuzenkyuuhutaisyousx5";
    public static final String ZTYTYOKUZENCBGAKUX5      = "ztytyokuzencbgakux5";
    public static final String ZTYTYOKUGOTUUSANHANTEISX5 = "ztytyokugotuusanhanteisx5";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUSX5 = "ztytyokugokyuuhutaisyousx5";
    public static final String ZTYTYOKUGOCBGAKUX5       = "ztytyokugocbgakux5";
    public static final String ZTYYOBIV12X5             = "ztyyobiv12x5";
    public static final String ZTYTYOKUZENTUUSANHANTEISX6 = "ztytyokuzentuusanhanteisx6";
    public static final String ZTYTYOKUZENKYUUHUTAISYOUSX6 = "ztytyokuzenkyuuhutaisyousx6";
    public static final String ZTYTYOKUZENCBGAKUX6      = "ztytyokuzencbgakux6";
    public static final String ZTYTYOKUGOTUUSANHANTEISX6 = "ztytyokugotuusanhanteisx6";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUSX6 = "ztytyokugokyuuhutaisyousx6";
    public static final String ZTYTYOKUGOCBGAKUX6       = "ztytyokugocbgakux6";
    public static final String ZTYYOBIV12X6             = "ztyyobiv12x6";
    public static final String ZTYCBKIKYKSYONOX1        = "ztycbkikyksyonox1";
    public static final String ZTYCBKIKYKHKNSYRUIKBNX1  = "ztycbkikykhknsyruikbnx1";
    public static final String ZTYCBKIKEIYAKUKEIYAKUYMDX1 = "ztycbkikeiyakukeiyakuymdx1";
    public static final String ZTYCBKIKYKKYHTISYUKBNX1  = "ztycbkikykkyhtisyukbnx1";
    public static final String ZTYCBKIKYKHNTITAISYOUKBNX1 = "ztycbkikykhntitaisyoukbnx1";
    public static final String ZTYKIKEIYAKUCBGAKUX1X1   = "ztykikeiyakucbgakux1x1";
    public static final String ZTYKIKEIYAKUCBGAKUX2X1   = "ztykikeiyakucbgakux2x1";
    public static final String ZTYCBKIKYKHANTEITSNSX1X1 = "ztycbkikykhanteitsnsx1x1";
    public static final String ZTYCBKIKYKHANTEITSNSX2X1 = "ztycbkikykhanteitsnsx2x1";
    public static final String ZTYYOBIV12X7             = "ztyyobiv12x7";
    public static final String ZTYCBKIKYKSYONOX2        = "ztycbkikyksyonox2";
    public static final String ZTYCBKIKYKHKNSYRUIKBNX2  = "ztycbkikykhknsyruikbnx2";
    public static final String ZTYCBKIKEIYAKUKEIYAKUYMDX2 = "ztycbkikeiyakukeiyakuymdx2";
    public static final String ZTYCBKIKYKKYHTISYUKBNX2  = "ztycbkikykkyhtisyukbnx2";
    public static final String ZTYCBKIKYKHNTITAISYOUKBNX2 = "ztycbkikykhntitaisyoukbnx2";
    public static final String ZTYKIKEIYAKUCBGAKUX1X2   = "ztykikeiyakucbgakux1x2";
    public static final String ZTYKIKEIYAKUCBGAKUX2X2   = "ztykikeiyakucbgakux2x2";
    public static final String ZTYCBKIKYKHANTEITSNSX1X2 = "ztycbkikykhanteitsnsx1x2";
    public static final String ZTYCBKIKYKHANTEITSNSX2X2 = "ztycbkikykhanteitsnsx2x2";
    public static final String ZTYYOBIV12X8             = "ztyyobiv12x8";
    public static final String ZTYCBKIKYKSYONOX3        = "ztycbkikyksyonox3";
    public static final String ZTYCBKIKYKHKNSYRUIKBNX3  = "ztycbkikykhknsyruikbnx3";
    public static final String ZTYCBKIKEIYAKUKEIYAKUYMDX3 = "ztycbkikeiyakukeiyakuymdx3";
    public static final String ZTYCBKIKYKKYHTISYUKBNX3  = "ztycbkikykkyhtisyukbnx3";
    public static final String ZTYCBKIKYKHNTITAISYOUKBNX3 = "ztycbkikykhntitaisyoukbnx3";
    public static final String ZTYKIKEIYAKUCBGAKUX1X3   = "ztykikeiyakucbgakux1x3";
    public static final String ZTYKIKEIYAKUCBGAKUX2X3   = "ztykikeiyakucbgakux2x3";
    public static final String ZTYCBKIKYKHANTEITSNSX1X3 = "ztycbkikykhanteitsnsx1x3";
    public static final String ZTYCBKIKYKHANTEITSNSX2X3 = "ztycbkikykhanteitsnsx2x3";
    public static final String ZTYYOBIV12X9             = "ztyyobiv12x9";
    public static final String ZTYHTNKNHKNSYRIKGUSDKBNX1 = "ztyhtnknhknsyrikgusdkbnx1";
    public static final String ZTYHTNKNMRTIKGUSDKBNX1   = "ztyhtnknmrtikgusdkbnx1";
    public static final String ZTYHTNKNSIZNMRTIKGUSDKBNX1 = "ztyhtnknsiznmrtikgusdkbnx1";
    public static final String ZTYHTNKNTIGNMRTIKGUSDKBNX1 = "ztyhtnkntignmrtikgusdkbnx1";
    public static final String ZTYHTNKNNKMRTIKGUSDKBNX1 = "ztyhtnknnkmrtikgusdkbnx1";
    public static final String ZTYHTNKNTKSTKGUSDKBNX1   = "ztyhtnkntkstkgusdkbnx1";
    public static final String ZTYHTNKNDI2TKSTKGUSDKBNX1 = "ztyhtnkndi2tkstkgusdkbnx1";
    public static final String ZTYHTNKNJYUSTKGUSDKBNX1  = "ztyhtnknjyustkgusdkbnx1";
    public static final String ZTYHTNKNDI2JYSITKGUSDKBNX1 = "ztyhtnkndi2jysitkgusdkbnx1";
    public static final String ZTYHTNKNKAIGONKMRTISDKBNX1 = "ztyhtnknkaigonkmrtisdkbnx1";
    public static final String ZTYHTNKNKIGTIGNMRTISDKBNX1 = "ztyhtnknkigtignmrtisdkbnx1";
    public static final String ZTYHTNKNKAIGOMRSYKGUSDKBNX1 = "ztyhtnknkaigomrsykgusdkbnx1";
    public static final String ZTYSUURIYOUYOBIV8X2      = "ztysuuriyouyobiv8x2";
    public static final String ZTYHTNKNHKNSYRIKGUSDKBNX2 = "ztyhtnknhknsyrikgusdkbnx2";
    public static final String ZTYHTNKNMRTIKGUSDKBNX2   = "ztyhtnknmrtikgusdkbnx2";
    public static final String ZTYHTNKNSIZNMRTIKGUSDKBNX2 = "ztyhtnknsiznmrtikgusdkbnx2";
    public static final String ZTYHTNKNTIGNMRTIKGUSDKBNX2 = "ztyhtnkntignmrtikgusdkbnx2";
    public static final String ZTYHTNKNNKMRTIKGUSDKBNX2 = "ztyhtnknnkmrtikgusdkbnx2";
    public static final String ZTYHTNKNTKSTKGUSDKBNX2   = "ztyhtnkntkstkgusdkbnx2";
    public static final String ZTYHTNKNDI2TKSTKGUSDKBNX2 = "ztyhtnkndi2tkstkgusdkbnx2";
    public static final String ZTYHTNKNJYUSTKGUSDKBNX2  = "ztyhtnknjyustkgusdkbnx2";
    public static final String ZTYHTNKNDI2JYSITKGUSDKBNX2 = "ztyhtnkndi2jysitkgusdkbnx2";
    public static final String ZTYHTNKNKAIGONKMRTISDKBNX2 = "ztyhtnknkaigonkmrtisdkbnx2";
    public static final String ZTYHTNKNKIGTIGNMRTISDKBNX2 = "ztyhtnknkigtignmrtisdkbnx2";
    public static final String ZTYHTNKNKAIGOMRSYKGUSDKBNX2 = "ztyhtnknkaigomrsykgusdkbnx2";
    public static final String ZTYYOBIV8X5              = "ztyyobiv8x5";
    public static final String ZTYHTNKNHKNSYRIKGUSDKBNX3 = "ztyhtnknhknsyrikgusdkbnx3";
    public static final String ZTYHTNKNMRTIKGUSDKBNX3   = "ztyhtnknmrtikgusdkbnx3";
    public static final String ZTYHTNKNSIZNMRTIKGUSDKBNX3 = "ztyhtnknsiznmrtikgusdkbnx3";
    public static final String ZTYHTNKNTIGNMRTIKGUSDKBNX3 = "ztyhtnkntignmrtikgusdkbnx3";
    public static final String ZTYHTNKNNKMRTIKGUSDKBNX3 = "ztyhtnknnkmrtikgusdkbnx3";
    public static final String ZTYHTNKNTKSTKGUSDKBNX3   = "ztyhtnkntkstkgusdkbnx3";
    public static final String ZTYHTNKNDI2TKSTKGUSDKBNX3 = "ztyhtnkndi2tkstkgusdkbnx3";
    public static final String ZTYHTNKNJYUSTKGUSDKBNX3  = "ztyhtnknjyustkgusdkbnx3";
    public static final String ZTYHTNKNDI2JYSITKGUSDKBNX3 = "ztyhtnkndi2jysitkgusdkbnx3";
    public static final String ZTYHTNKNKAIGONKMRTISDKBNX3 = "ztyhtnknkaigonkmrtisdkbnx3";
    public static final String ZTYHTNKNKIGTIGNMRTISDKBNX3 = "ztyhtnknkigtignmrtisdkbnx3";
    public static final String ZTYHTNKNKAIGOMRSYKGUSDKBNX3 = "ztyhtnknkaigomrsykgusdkbnx3";
    public static final String ZTYYOBIV8X6              = "ztyyobiv8x6";
    public static final String ZTYHTNKNHKNSYRIKGUSDKBNX4 = "ztyhtnknhknsyrikgusdkbnx4";
    public static final String ZTYHTNKNMRTIKGUSDKBNX4   = "ztyhtnknmrtikgusdkbnx4";
    public static final String ZTYHTNKNSIZNMRTIKGUSDKBNX4 = "ztyhtnknsiznmrtikgusdkbnx4";
    public static final String ZTYHTNKNTIGNMRTIKGUSDKBNX4 = "ztyhtnkntignmrtikgusdkbnx4";
    public static final String ZTYHTNKNNKMRTIKGUSDKBNX4 = "ztyhtnknnkmrtikgusdkbnx4";
    public static final String ZTYHTNKNTKSTKGUSDKBNX4   = "ztyhtnkntkstkgusdkbnx4";
    public static final String ZTYHTNKNDI2TKSTKGUSDKBNX4 = "ztyhtnkndi2tkstkgusdkbnx4";
    public static final String ZTYHTNKNJYUSTKGUSDKBNX4  = "ztyhtnknjyustkgusdkbnx4";
    public static final String ZTYHTNKNDI2JYSITKGUSDKBNX4 = "ztyhtnkndi2jysitkgusdkbnx4";
    public static final String ZTYHTNKNKAIGONKMRTISDKBNX4 = "ztyhtnknkaigonkmrtisdkbnx4";
    public static final String ZTYHTNKNKIGTIGNMRTISDKBNX4 = "ztyhtnknkigtignmrtisdkbnx4";
    public static final String ZTYHTNKNKAIGOMRSYKGUSDKBNX4 = "ztyhtnknkaigomrsykgusdkbnx4";
    public static final String ZTYYOBIV8X7              = "ztyyobiv8x7";
    public static final String ZTYHTNKNHKNSYRIKGUSDKBNX5 = "ztyhtnknhknsyrikgusdkbnx5";
    public static final String ZTYHTNKNMRTIKGUSDKBNX5   = "ztyhtnknmrtikgusdkbnx5";
    public static final String ZTYHTNKNSIZNMRTIKGUSDKBNX5 = "ztyhtnknsiznmrtikgusdkbnx5";
    public static final String ZTYHTNKNTIGNMRTIKGUSDKBNX5 = "ztyhtnkntignmrtikgusdkbnx5";
    public static final String ZTYHTNKNNKMRTIKGUSDKBNX5 = "ztyhtnknnkmrtikgusdkbnx5";
    public static final String ZTYHTNKNTKSTKGUSDKBNX5   = "ztyhtnkntkstkgusdkbnx5";
    public static final String ZTYHTNKNDI2TKSTKGUSDKBNX5 = "ztyhtnkndi2tkstkgusdkbnx5";
    public static final String ZTYHTNKNJYUSTKGUSDKBNX5  = "ztyhtnknjyustkgusdkbnx5";
    public static final String ZTYHTNKNDI2JYSITKGUSDKBNX5 = "ztyhtnkndi2jysitkgusdkbnx5";
    public static final String ZTYHTNKNKAIGONKMRTISDKBNX5 = "ztyhtnknkaigonkmrtisdkbnx5";
    public static final String ZTYHTNKNKIGTIGNMRTISDKBNX5 = "ztyhtnknkigtignmrtisdkbnx5";
    public static final String ZTYHTNKNKAIGOMRSYKGUSDKBNX5 = "ztyhtnknkaigomrsykgusdkbnx5";
    public static final String ZTYYOBIV8X8              = "ztyyobiv8x8";
    public static final String ZTYHTNKNHKNSYRIKGUSDKBNX6 = "ztyhtnknhknsyrikgusdkbnx6";
    public static final String ZTYHTNKNMRTIKGUSDKBNX6   = "ztyhtnknmrtikgusdkbnx6";
    public static final String ZTYHTNKNSIZNMRTIKGUSDKBNX6 = "ztyhtnknsiznmrtikgusdkbnx6";
    public static final String ZTYHTNKNTIGNMRTIKGUSDKBNX6 = "ztyhtnkntignmrtikgusdkbnx6";
    public static final String ZTYHTNKNNKMRTIKGUSDKBNX6 = "ztyhtnknnkmrtikgusdkbnx6";
    public static final String ZTYHTNKNTKSTKGUSDKBNX6   = "ztyhtnkntkstkgusdkbnx6";
    public static final String ZTYHTNKNDI2TKSTKGUSDKBNX6 = "ztyhtnkndi2tkstkgusdkbnx6";
    public static final String ZTYHTNKNJYUSTKGUSDKBNX6  = "ztyhtnknjyustkgusdkbnx6";
    public static final String ZTYHTNKNDI2JYSITKGUSDKBNX6 = "ztyhtnkndi2jysitkgusdkbnx6";
    public static final String ZTYHTNKNKAIGONKMRTISDKBNX6 = "ztyhtnknkaigonkmrtisdkbnx6";
    public static final String ZTYHTNKNKIGTIGNMRTISDKBNX6 = "ztyhtnknkigtignmrtisdkbnx6";
    public static final String ZTYHTNKNKAIGOMRSYKGUSDKBNX6 = "ztyhtnknkaigomrsykgusdkbnx6";
    public static final String ZTYYOBIV8X9              = "ztyyobiv8x9";
    public static final String ZTYKAIGONKTKYKSYURUIKGU  = "ztykaigonktkyksyuruikgu";
    public static final String ZTYKAIGONKTKYKKGUSDKBN   = "ztykaigonktkykkgusdkbn";
    public static final String ZTYKAIGONENKINTOKUYAKUKIKAN = "ztykaigonenkintokuyakukikan";
    public static final String ZTYKAIGONKTKYKPHRKKKN    = "ztykaigonktkykphrkkkn";
    public static final String ZTYKAIGONKTKYKNKGK       = "ztykaigonktkyknkgk";
    public static final String ZTYKAIGONENKINTOKUYAKUS  = "ztykaigonenkintokuyakus";
    public static final String ZTYKAIGONENKINTOKUYAKUP  = "ztykaigonenkintokuyakup";
    public static final String ZTYKAIGONKTKYKMODS       = "ztykaigonktkykmods";
    public static final String ZTYKAIGONKTKYKNKSHRKKN   = "ztykaigonktkyknkshrkkn";
    public static final String ZTYHTNKNKAIGONKTKYKKGUX1 = "ztyhtnknkaigonktkykkgux1";
    public static final String ZTYHTNKNKAIGONKTKYKKGUX2 = "ztyhtnknkaigonktkykkgux2";
    public static final String ZTYHTNKNKAIGONKTKYKKGUX3 = "ztyhtnknkaigonktkykkgux3";
    public static final String ZTYHTNKNKAIGONKTKYKKGUX4 = "ztyhtnknkaigonktkykkgux4";
    public static final String ZTYHTNKNKAIGONKTKYKKGUX5 = "ztyhtnknkaigonktkykkgux5";
    public static final String ZTYHTNKNKAIGONKTKYKKGUX6 = "ztyhtnknkaigonktkykkgux6";
    public static final String ZTYHTNKNKAIGONKTKYKSDKBNX1 = "ztyhtnknkaigonktkyksdkbnx1";
    public static final String ZTYHTNKNKAIGONKTKYKSDKBNX2 = "ztyhtnknkaigonktkyksdkbnx2";
    public static final String ZTYHTNKNKAIGONKTKYKSDKBNX3 = "ztyhtnknkaigonktkyksdkbnx3";
    public static final String ZTYHTNKNKAIGONKTKYKSDKBNX4 = "ztyhtnknkaigonktkyksdkbnx4";
    public static final String ZTYHTNKNKAIGONKTKYKSDKBNX5 = "ztyhtnknkaigonktkyksdkbnx5";
    public static final String ZTYHTNKNKAIGONKTKYKSDKBNX6 = "ztyhtnknkaigonktkyksdkbnx6";
    public static final String ZTYSURIKAIGONKTKYKPWRBKKBN = "ztysurikaigonktkykpwrbkkbn";
    public static final String ZTYKAIGONKTKYKPWRBKKBN   = "ztykaigonktkykpwrbkkbn";
    public static final String ZTYKAIGONKTKYKTNKNYUGUKBN = "ztykaigonktkyktnknyugukbn";
    public static final String ZTYYOBIV14               = "ztyyobiv14";
    public static final String ZTYITJBRKIGNKTKYKSYRIKGU = "ztyitjbrkignktkyksyrikgu";
    public static final String ZTYITJBRKIGNKTKYKSDKBN   = "ztyitjbrkignktkyksdkbn";
    public static final String ZTYITJBRKIGNKTKYKKKN     = "ztyitjbrkignktkykkkn";
    public static final String ZTYITJBRKIGNKTKYKNNKNGK  = "ztyitjbrkignktkyknnkngk";
    public static final String ZTYITJBRKIGNKTKYKS       = "ztyitjbrkignktkyks";
    public static final String ZTYITJBRKIGNKTKYKP       = "ztyitjbrkignktkykp";
    public static final String ZTYITJBRKIGNKTKYKSPDTKBN = "ztyitjbrkignktkykspdtkbn";
    public static final String ZTYITJBRKIGNKTKYKMODS    = "ztyitjbrkignktkykmods";
    public static final String ZTYITJBRKIGNKTKYKSHRKKN  = "ztyitjbrkignktkykshrkkn";
    public static final String ZTYYOBIV8X10             = "ztyyobiv8x10";
    public static final String ZTYNYUUINNISSUUGATAKBN   = "ztynyuuinnissuugatakbn";
    public static final String ZTYTENKANKEIKANENSUU     = "ztytenkankeikanensuu";
    public static final String ZTYSYKKYUHTKYKSYURUIKGU  = "ztysykkyuhtkyksyuruikgu";
    public static final String ZTYSYOKIKYUUHUTOKUYAKUKIKAN = "ztysyokikyuuhutokuyakukikan";
    public static final String ZTYSYOKIKYUUHUTKYKPHRKKKN = "ztysyokikyuuhutkykphrkkkn";
    public static final String ZTYSYKKYUHTKYKNTGK       = "ztysykkyuhtkykntgk";
    public static final String ZTYSYOKIKYUUHUTOKUYAKUP  = "ztysyokikyuuhutokuyakup";
    public static final String ZTYSYKKYUHTKYKGTKBN      = "ztysykkyuhtkykgtkbn";
    public static final String ZTYSYOKIKYUUHUTKYKKGUSDKBN = "ztysyokikyuuhutkykkgusdkbn";
    public static final String ZTYSYKKYUHTKJYURYUMSHYUTN = "ztysykkyuhtkjyuryumshyutn";
    public static final String ZTYSYOKIKYUUHUTOKUJYOUP  = "ztysyokikyuuhutokujyoup";
    public static final String ZTYSYKKYUHTKTBICDX1      = "ztysykkyuhtktbicdx1";
    public static final String ZTYSYKKYUHHTNPKKNX1      = "ztysykkyuhhtnpkknx1";
    public static final String ZTYSYKKYUHTKTBICDX2      = "ztysykkyuhtktbicdx2";
    public static final String ZTYSYKKYUHHTNPKKNX2      = "ztysykkyuhhtnpkknx2";
    public static final String ZTYSYKKYUHTKYKPWRBKKBN   = "ztysykkyuhtkykpwrbkkbn";
    public static final String ZTYYOBIV3X6              = "ztyyobiv3x6";
    public static final String ZTYDI2SYKKYUHTKYKSYRIKGU = "ztydi2sykkyuhtkyksyrikgu";
    public static final String ZTYDI2SYKKYUHTKYKKKN     = "ztydi2sykkyuhtkykkkn";
    public static final String ZTYDI2SYKKYUHTKYKPHRKKKN = "ztydi2sykkyuhtkykphrkkkn";
    public static final String ZTYDI2SYKKYUHTKYKNTGK    = "ztydi2sykkyuhtkykntgk";
    public static final String ZTYDAI2SYOKIKYUUHUTOKUYAKUP = "ztydai2syokikyuuhutokuyakup";
    public static final String ZTYDI2SYKKYUHTKYKGTKBN   = "ztydi2sykkyuhtkykgtkbn";
    public static final String ZTYDI2SYKKYUHTKYKKGUSDKBN = "ztydi2sykkyuhtkykkgusdkbn";
    public static final String ZTYDI2SYKKYUHTKJYURYUMSHYTN = "ztydi2sykkyuhtkjyuryumshytn";
    public static final String ZTYDAI2SYOKIKYUUHUTOKUJYOUP = "ztydai2syokikyuuhutokujyoup";
    public static final String ZTYDI2SYKKYUHTKTBICDX1   = "ztydi2sykkyuhtktbicdx1";
    public static final String ZTYDI2SYKKYUHHTNPKKNX1   = "ztydi2sykkyuhhtnpkknx1";
    public static final String ZTYDI2SYKKYUHTKTBICDX2   = "ztydi2sykkyuhtktbicdx2";
    public static final String ZTYDI2SYKKYUHHTNPKKNX2   = "ztydi2sykkyuhhtnpkknx2";
    public static final String ZTYDI2SYKKYUHTKYKPWRBKKBN = "ztydi2sykkyuhtkykpwrbkkbn";
    public static final String ZTYYOBIV3X7              = "ztyyobiv3x7";
    public static final String ZTYDFITIJIBARAIP         = "ztydfitijibaraip";
    public static final String ZTYDFGOUKEITENKANKAKAKU  = "ztydfgoukeitenkankakaku";
    public static final String ZTYDFUKTKJIVBBNTNKNKAKAKU = "ztydfuktkjivbbntnknkakaku";
    public static final String ZTYDFUKTKJIPBBNTNKNKAKAKU = "ztydfuktkjipbbntnknkakaku";
    public static final String ZTYDFTNKNGVBBNTNKNKAKAKU = "ztydftnkngvbbntnknkakaku";
    public static final String ZTYDFTNKNGPBBNTNKNKAKAKU = "ztydftnkngpbbntnknkakaku";
    public static final String ZTYYOBIV18X2             = "ztyyobiv18x2";
    public static final String ZTYKAIGOMRTISYURUIKGU    = "ztykaigomrtisyuruikgu";
    public static final String ZTYKAIGOMARUTEIKIGOUSDKBN = "ztykaigomaruteikigousdkbn";
    public static final String ZTYKAIGOMARUTEIKIKAN     = "ztykaigomaruteikikan";
    public static final String ZTYKAIGOMARUTEIPHRKKKN   = "ztykaigomaruteiphrkkkn";
    public static final String ZTYKAIGOMARUTEIS         = "ztykaigomaruteis";
    public static final String ZTYKAIGOMARUTEIP         = "ztykaigomaruteip";
    public static final String ZTYKAIGOMARUTEISYUUSEIS  = "ztykaigomaruteisyuuseis";
    public static final String ZTYKAIGOMARUTEIMODSSKGNHYJ = "ztykaigomaruteimodsskgnhyj";
    public static final String ZTYKIGMRTITKJYUKBN       = "ztykigmrtitkjyukbn";
    public static final String ZTYKIGMRTITKJYUSKGNKKN   = "ztykigmrtitkjyuskgnkkn";
    public static final String ZTYKIGMRTITKJYURYUMSHYUTN = "ztykigmrtitkjyuryumshyutn";
    public static final String ZTYKAIGOMARUTEITOKUJYOUP = "ztykaigomaruteitokujyoup";
    public static final String ZTYHTNKNKIGMRTISYRIKGUX1 = "ztyhtnknkigmrtisyrikgux1";
    public static final String ZTYHTNKNKIGMRTISYRIKGUX2 = "ztyhtnknkigmrtisyrikgux2";
    public static final String ZTYHTNKNKIGMRTISYRIKGUX3 = "ztyhtnknkigmrtisyrikgux3";
    public static final String ZTYHTNKNKIGMRTISYRIKGUX4 = "ztyhtnknkigmrtisyrikgux4";
    public static final String ZTYHTNKNKIGMRTISYRIKGUX5 = "ztyhtnknkigmrtisyrikgux5";
    public static final String ZTYHTNKNKIGMRTISYRIKGUX6 = "ztyhtnknkigmrtisyrikgux6";
    public static final String ZTYHTNKNKAIGOMRTISDKBNX1 = "ztyhtnknkaigomrtisdkbnx1";
    public static final String ZTYHTNKNKAIGOMRTISDKBNX2 = "ztyhtnknkaigomrtisdkbnx2";
    public static final String ZTYHTNKNKAIGOMRTISDKBNX3 = "ztyhtnknkaigomrtisdkbnx3";
    public static final String ZTYHTNKNKAIGOMRTISDKBNX4 = "ztyhtnknkaigomrtisdkbnx4";
    public static final String ZTYHTNKNKAIGOMRTISDKBNX5 = "ztyhtnknkaigomrtisdkbnx5";
    public static final String ZTYHTNKNKAIGOMRTISDKBNX6 = "ztyhtnknkaigomrtisdkbnx6";
    public static final String ZTYSURKIGMRTIPWRBKKBN    = "ztysurkigmrtipwrbkkbn";
    public static final String ZTYKIGMRTIPWRBKKBN       = "ztykigmrtipwrbkkbn";
    public static final String ZTYKIGMRTITNKNYUGUKBN    = "ztykigmrtitnknyugukbn";
    public static final String ZTYKIGMRTIKUSNMNRYOAGE   = "ztykigmrtikusnmnryoage";
    public static final String ZTYYOBIV2X7              = "ztyyobiv2x7";
    public static final String ZTYKAIGOTOKUTEISYURUIKIGOU = "ztykaigotokuteisyuruikigou";
    public static final String ZTYKAIGOTKTIKGUSDKBN     = "ztykaigotktikgusdkbn";
    public static final String ZTYKAIGOTOKUTEIKIKAN     = "ztykaigotokuteikikan";
    public static final String ZTYKAIGOTOKUTEIS         = "ztykaigotokuteis";
    public static final String ZTYKAIGOTOKUTEIP         = "ztykaigotokuteip";
    public static final String ZTYKIGTKTISDTPDTKBN      = "ztykigtktisdtpdtkbn";
    public static final String ZTYKAIGOTOKUTEISYUUSEIS  = "ztykaigotokuteisyuuseis";
    public static final String ZTYKAIGOTKTIMODSSKGNHYJ  = "ztykaigotktimodsskgnhyj";
    public static final String ZTYKAIGOTKTIKUSNMNRYOAGE = "ztykaigotktikusnmnryoage";
    public static final String ZTYYOBIV8X11             = "ztyyobiv8x11";
    public static final String ZTYKAZOKUIRYOUTKYKSYURUIKGU = "ztykazokuiryoutkyksyuruikgu";
    public static final String ZTYKAZOKUIRYOUTOKUYAKUKIKAN = "ztykazokuiryoutokuyakukikan";
    public static final String ZTYKAZOKUIRYOUTKYKPHRKKKN = "ztykazokuiryoutkykphrkkkn";
    public static final String ZTYKZKIRYOUTKYKNTGK      = "ztykzkiryoutkykntgk";
    public static final String ZTYKAZOKUIRYOUTOKUYAKUP  = "ztykazokuiryoutokuyakup";
    public static final String ZTYKZKIRYOUTKYKGTKBN     = "ztykzkiryoutkykgtkbn";
    public static final String ZTYKAZOKUIRYOUTKYKKGUSDKBN = "ztykazokuiryoutkykkgusdkbn";
    public static final String ZTYKZKIRYOUTKTBICDX1     = "ztykzkiryoutktbicdx1";
    public static final String ZTYKZKIRYOUHTNPKKNX1     = "ztykzkiryouhtnpkknx1";
    public static final String ZTYKZKIRYOUTKTBICDX2     = "ztykzkiryoutktbicdx2";
    public static final String ZTYKZKIRYOUHTNPKKNX2     = "ztykzkiryouhtnpkknx2";
    public static final String ZTYYOBIV12X10            = "ztyyobiv12x10";

    private final PKZT_Sp2RnduyuSouseiritu2Ty primaryKey;

    public GenZT_Sp2RnduyuSouseiritu2Ty() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu2Ty();
    }

    public GenZT_Sp2RnduyuSouseiritu2Ty(String pZtyktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu2Ty(pZtyktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu2Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu2Ty> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu2Ty.class;
    }

    private String ztyktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKTGYSYRYMD)
    public String getZtyktgysyrymd() {
        return ztyktgysyrymd;
    }

    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        ztyktgysyrymd = pZtyktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKTGYSYONO)
    public String getZtyktgysyono() {
        return getPrimaryKey().getZtyktgysyono();
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        getPrimaryKey().setZtyktgysyono(pZtyktgysyono);
    }

    private String ztyktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKTGYFILERENNO)
    public String getZtyktgyfilerenno() {
        return ztyktgyfilerenno;
    }

    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        ztyktgyfilerenno = pZtyktgyfilerenno;
    }

    private String ztysiteidairininkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSITEIDAIRININKBN)
    public String getZtysiteidairininkbn() {
        return ztysiteidairininkbn;
    }

    public void setZtysiteidairininkbn(String pZtysiteidairininkbn) {
        ztysiteidairininkbn = pZtysiteidairininkbn;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztysrkykdrkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSRKYKDRKBN)
    public String getZtysrkykdrkbn() {
        return ztysrkykdrkbn;
    }

    public void setZtysrkykdrkbn(String pZtysrkykdrkbn) {
        ztysrkykdrkbn = pZtysrkykdrkbn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztyyobiv6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV6X3)
    public String getZtyyobiv6x3() {
        return ztyyobiv6x3;
    }

    public void setZtyyobiv6x3(String pZtyyobiv6x3) {
        ztyyobiv6x3 = pZtyyobiv6x3;
    }

    private String ztylivingneedstkykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYLIVINGNEEDSTKYKARIHYJ)
    public String getZtylivingneedstkykarihyj() {
        return ztylivingneedstkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedstkykarihyj(String pZtylivingneedstkykarihyj) {
        ztylivingneedstkykarihyj = pZtylivingneedstkykarihyj;
    }

    private String ztyyobiv4x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV4X12)
    public String getZtyyobiv4x12() {
        return ztyyobiv4x12;
    }

    public void setZtyyobiv4x12(String pZtyyobiv4x12) {
        ztyyobiv4x12 = pZtyyobiv4x12;
    }

    private String ztygansupporttkykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGANSUPPORTTKYKARIHYJ)
    public String getZtygansupporttkykarihyj() {
        return ztygansupporttkykarihyj;
    }

    public void setZtygansupporttkykarihyj(String pZtygansupporttkykarihyj) {
        ztygansupporttkykarihyj = pZtygansupporttkykarihyj;
    }

    private String ztyyobiv4x13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV4X13)
    public String getZtyyobiv4x13() {
        return ztyyobiv4x13;
    }

    public void setZtyyobiv4x13(String pZtyyobiv4x13) {
        ztyyobiv4x13 = pZtyyobiv4x13;
    }

    private String ztytuuintokuyakusyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUYAKUSYURUIKIGOU)
    public String getZtytuuintokuyakusyuruikigou() {
        return ztytuuintokuyakusyuruikigou;
    }

    public void setZtytuuintokuyakusyuruikigou(String pZtytuuintokuyakusyuruikigou) {
        ztytuuintokuyakusyuruikigou = pZtytuuintokuyakusyuruikigou;
    }

    private String ztytuuintokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUYAKUKIKAN)
    public String getZtytuuintokuyakukikan() {
        return ztytuuintokuyakukikan;
    }

    public void setZtytuuintokuyakukikan(String pZtytuuintokuyakukikan) {
        ztytuuintokuyakukikan = pZtytuuintokuyakukikan;
    }

    private String ztytuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUINTKYKPHRKKKN)
    public String getZtytuintkykphrkkkn() {
        return ztytuintkykphrkkkn;
    }

    public void setZtytuintkykphrkkkn(String pZtytuintkykphrkkkn) {
        ztytuintkykphrkkkn = pZtytuintkykphrkkkn;
    }

    private Integer ztytuuintokuyakunitigaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUYAKUNITIGAKU)
    public Integer getZtytuuintokuyakunitigaku() {
        return ztytuuintokuyakunitigaku;
    }

    public void setZtytuuintokuyakunitigaku(Integer pZtytuuintokuyakunitigaku) {
        ztytuuintokuyakunitigaku = pZtytuuintokuyakunitigaku;
    }

    private Long ztytuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUYAKUP)
    public Long getZtytuuintokuyakup() {
        return ztytuuintokuyakup;
    }

    public void setZtytuuintokuyakup(Long pZtytuuintokuyakup) {
        ztytuuintokuyakup = pZtytuuintokuyakup;
    }

    private String ztytuuintokuyakugatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUYAKUGATAKBN)
    public String getZtytuuintokuyakugatakbn() {
        return ztytuuintokuyakugatakbn;
    }

    public void setZtytuuintokuyakugatakbn(String pZtytuuintokuyakugatakbn) {
        ztytuuintokuyakugatakbn = pZtytuuintokuyakugatakbn;
    }

    private Integer ztytuintkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUINTKJYURYUMSHYUTN)
    public Integer getZtytuintkjyuryumshyutn() {
        return ztytuintkjyuryumshyutn;
    }

    public void setZtytuintkjyuryumshyutn(Integer pZtytuintkjyuryumshyutn) {
        ztytuintkjyuryumshyutn = pZtytuintkjyuryumshyutn;
    }

    private Long ztytuuintokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUJYOUP)
    public Long getZtytuuintokujyoup() {
        return ztytuuintokujyoup;
    }

    public void setZtytuuintokujyoup(Long pZtytuuintokujyoup) {
        ztytuuintokujyoup = pZtytuuintokujyoup;
    }

    private String ztytuuintokuteibuicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUTEIBUICDX1)
    public String getZtytuuintokuteibuicdx1() {
        return ztytuuintokuteibuicdx1;
    }

    public void setZtytuuintokuteibuicdx1(String pZtytuuintokuteibuicdx1) {
        ztytuuintokuteibuicdx1 = pZtytuuintokuteibuicdx1;
    }

    private String ztytuuinhutanpokikanx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINHUTANPOKIKANX1)
    public String getZtytuuinhutanpokikanx1() {
        return ztytuuinhutanpokikanx1;
    }

    public void setZtytuuinhutanpokikanx1(String pZtytuuinhutanpokikanx1) {
        ztytuuinhutanpokikanx1 = pZtytuuinhutanpokikanx1;
    }

    private String ztytuuintokuteibuicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINTOKUTEIBUICDX2)
    public String getZtytuuintokuteibuicdx2() {
        return ztytuuintokuteibuicdx2;
    }

    public void setZtytuuintokuteibuicdx2(String pZtytuuintokuteibuicdx2) {
        ztytuuintokuteibuicdx2 = pZtytuuintokuteibuicdx2;
    }

    private String ztytuuinhutanpokikanx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUINHUTANPOKIKANX2)
    public String getZtytuuinhutanpokikanx2() {
        return ztytuuinhutanpokikanx2;
    }

    public void setZtytuuinhutanpokikanx2(String pZtytuuinhutanpokikanx2) {
        ztytuuinhutanpokikanx2 = pZtytuuinhutanpokikanx2;
    }

    private String ztytuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUINTKYKKGUSDKBN)
    public String getZtytuintkykkgusdkbn() {
        return ztytuintkykkgusdkbn;
    }

    public void setZtytuintkykkgusdkbn(String pZtytuintkykkgusdkbn) {
        ztytuintkykkgusdkbn = pZtytuintkykkgusdkbn;
    }

    private String ztytuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUINTKYKPWRBKKBN)
    public String getZtytuintkykpwrbkkbn() {
        return ztytuintkykpwrbkkbn;
    }

    public void setZtytuintkykpwrbkkbn(String pZtytuintkykpwrbkkbn) {
        ztytuintkykpwrbkkbn = pZtytuintkykpwrbkkbn;
    }

    private String ztyyobiv3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV3X4)
    public String getZtyyobiv3x4() {
        return ztyyobiv3x4;
    }

    public void setZtyyobiv3x4(String pZtyyobiv3x4) {
        ztyyobiv3x4 = pZtyyobiv3x4;
    }

    private String ztydi2tuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TUINTKYKSYRIKGU)
    public String getZtydi2tuintkyksyrikgu() {
        return ztydi2tuintkyksyrikgu;
    }

    public void setZtydi2tuintkyksyrikgu(String pZtydi2tuintkyksyrikgu) {
        ztydi2tuintkyksyrikgu = pZtydi2tuintkyksyrikgu;
    }

    private String ztydai2tuuintokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUYAKUKIKAN)
    public String getZtydai2tuuintokuyakukikan() {
        return ztydai2tuuintokuyakukikan;
    }

    public void setZtydai2tuuintokuyakukikan(String pZtydai2tuuintokuyakukikan) {
        ztydai2tuuintokuyakukikan = pZtydai2tuuintokuyakukikan;
    }

    private String ztydai2tuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUINTKYKPHRKKKN)
    public String getZtydai2tuintkykphrkkkn() {
        return ztydai2tuintkykphrkkkn;
    }

    public void setZtydai2tuintkykphrkkkn(String pZtydai2tuintkykphrkkkn) {
        ztydai2tuintkykphrkkkn = pZtydai2tuintkykphrkkkn;
    }

    private Integer ztydai2tuuintokuyakuntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUYAKUNTGK)
    public Integer getZtydai2tuuintokuyakuntgk() {
        return ztydai2tuuintokuyakuntgk;
    }

    public void setZtydai2tuuintokuyakuntgk(Integer pZtydai2tuuintokuyakuntgk) {
        ztydai2tuuintokuyakuntgk = pZtydai2tuuintokuyakuntgk;
    }

    private Long ztydai2tuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUYAKUP)
    public Long getZtydai2tuuintokuyakup() {
        return ztydai2tuuintokuyakup;
    }

    public void setZtydai2tuuintokuyakup(Long pZtydai2tuuintokuyakup) {
        ztydai2tuuintokuyakup = pZtydai2tuuintokuyakup;
    }

    private String ztydai2tuuintokuyakugatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUYAKUGATAKBN)
    public String getZtydai2tuuintokuyakugatakbn() {
        return ztydai2tuuintokuyakugatakbn;
    }

    public void setZtydai2tuuintokuyakugatakbn(String pZtydai2tuuintokuyakugatakbn) {
        ztydai2tuuintokuyakugatakbn = pZtydai2tuuintokuyakugatakbn;
    }

    private Integer ztydi2tuintkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TUINTKJYURYUMSHYUTN)
    public Integer getZtydi2tuintkjyuryumshyutn() {
        return ztydi2tuintkjyuryumshyutn;
    }

    public void setZtydi2tuintkjyuryumshyutn(Integer pZtydi2tuintkjyuryumshyutn) {
        ztydi2tuintkjyuryumshyutn = pZtydi2tuintkjyuryumshyutn;
    }

    private Long ztydai2tuuintokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUJYOUP)
    public Long getZtydai2tuuintokujyoup() {
        return ztydai2tuuintokujyoup;
    }

    public void setZtydai2tuuintokujyoup(Long pZtydai2tuuintokujyoup) {
        ztydai2tuuintokujyoup = pZtydai2tuuintokujyoup;
    }

    private String ztydai2tuuintokuteibuicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUTEIBUICDX1)
    public String getZtydai2tuuintokuteibuicdx1() {
        return ztydai2tuuintokuteibuicdx1;
    }

    public void setZtydai2tuuintokuteibuicdx1(String pZtydai2tuuintokuteibuicdx1) {
        ztydai2tuuintokuteibuicdx1 = pZtydai2tuuintokuteibuicdx1;
    }

    private String ztydai2tuuinhutanpokikanx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINHUTANPOKIKANX1)
    public String getZtydai2tuuinhutanpokikanx1() {
        return ztydai2tuuinhutanpokikanx1;
    }

    public void setZtydai2tuuinhutanpokikanx1(String pZtydai2tuuinhutanpokikanx1) {
        ztydai2tuuinhutanpokikanx1 = pZtydai2tuuinhutanpokikanx1;
    }

    private String ztydai2tuuintokuteibuicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINTOKUTEIBUICDX2)
    public String getZtydai2tuuintokuteibuicdx2() {
        return ztydai2tuuintokuteibuicdx2;
    }

    public void setZtydai2tuuintokuteibuicdx2(String pZtydai2tuuintokuteibuicdx2) {
        ztydai2tuuintokuteibuicdx2 = pZtydai2tuuintokuteibuicdx2;
    }

    private String ztydai2tuuinhutanpokikanx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TUUINHUTANPOKIKANX2)
    public String getZtydai2tuuinhutanpokikanx2() {
        return ztydai2tuuinhutanpokikanx2;
    }

    public void setZtydai2tuuinhutanpokikanx2(String pZtydai2tuuinhutanpokikanx2) {
        ztydai2tuuinhutanpokikanx2 = pZtydai2tuuinhutanpokikanx2;
    }

    private String ztydi2tuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TUINTKYKKGUSDKBN)
    public String getZtydi2tuintkykkgusdkbn() {
        return ztydi2tuintkykkgusdkbn;
    }

    public void setZtydi2tuintkykkgusdkbn(String pZtydi2tuintkykkgusdkbn) {
        ztydi2tuintkykkgusdkbn = pZtydi2tuintkykkgusdkbn;
    }

    private String ztydi2tuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TUINTKYKPWRBKKBN)
    public String getZtydi2tuintkykpwrbkkbn() {
        return ztydi2tuintkykpwrbkkbn;
    }

    public void setZtydi2tuintkykpwrbkkbn(String pZtydi2tuintkykpwrbkkbn) {
        ztydi2tuintkykpwrbkkbn = pZtydi2tuintkykpwrbkkbn;
    }

    private String ztyyobiv3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV3X5)
    public String getZtyyobiv3x5() {
        return ztyyobiv3x5;
    }

    public void setZtyyobiv3x5(String pZtyyobiv3x5) {
        ztyyobiv3x5 = pZtyyobiv3x5;
    }

    private String ztykangotokuyakusyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUYAKUSYURUIKIGOU)
    public String getZtykangotokuyakusyuruikigou() {
        return ztykangotokuyakusyuruikigou;
    }

    public void setZtykangotokuyakusyuruikigou(String pZtykangotokuyakusyuruikigou) {
        ztykangotokuyakusyuruikigou = pZtykangotokuyakusyuruikigou;
    }

    private String ztykangotokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUYAKUKIKAN)
    public String getZtykangotokuyakukikan() {
        return ztykangotokuyakukikan;
    }

    public void setZtykangotokuyakukikan(String pZtykangotokuyakukikan) {
        ztykangotokuyakukikan = pZtykangotokuyakukikan;
    }

    private String ztykangotkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTKYKPHRKKKN)
    public String getZtykangotkykphrkkkn() {
        return ztykangotkykphrkkkn;
    }

    public void setZtykangotkykphrkkkn(String pZtykangotkykphrkkkn) {
        ztykangotkykphrkkkn = pZtykangotkykphrkkkn;
    }

    private Integer ztykangotokuyakunitigaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUYAKUNITIGAKU)
    public Integer getZtykangotokuyakunitigaku() {
        return ztykangotokuyakunitigaku;
    }

    public void setZtykangotokuyakunitigaku(Integer pZtykangotokuyakunitigaku) {
        ztykangotokuyakunitigaku = pZtykangotokuyakunitigaku;
    }

    private Long ztykangotokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUYAKUP)
    public Long getZtykangotokuyakup() {
        return ztykangotokuyakup;
    }

    public void setZtykangotokuyakup(Long pZtykangotokuyakup) {
        ztykangotokuyakup = pZtykangotokuyakup;
    }

    private String ztykangotokuyakugatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUYAKUGATAKBN)
    public String getZtykangotokuyakugatakbn() {
        return ztykangotokuyakugatakbn;
    }

    public void setZtykangotokuyakugatakbn(String pZtykangotokuyakugatakbn) {
        ztykangotokuyakugatakbn = pZtykangotokuyakugatakbn;
    }

    private Integer ztykngtkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKNGTKJYURYUMSHYUTN)
    public Integer getZtykngtkjyuryumshyutn() {
        return ztykngtkjyuryumshyutn;
    }

    public void setZtykngtkjyuryumshyutn(Integer pZtykngtkjyuryumshyutn) {
        ztykngtkjyuryumshyutn = pZtykngtkjyuryumshyutn;
    }

    private Long ztykangotokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUJYOUP)
    public Long getZtykangotokujyoup() {
        return ztykangotokujyoup;
    }

    public void setZtykangotokujyoup(Long pZtykangotokujyoup) {
        ztykangotokujyoup = pZtykangotokujyoup;
    }

    private String ztykangotokuteibuicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUTEIBUICDX1)
    public String getZtykangotokuteibuicdx1() {
        return ztykangotokuteibuicdx1;
    }

    public void setZtykangotokuteibuicdx1(String pZtykangotokuteibuicdx1) {
        ztykangotokuteibuicdx1 = pZtykangotokuteibuicdx1;
    }

    private String ztykangohutanpokikanx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOHUTANPOKIKANX1)
    public String getZtykangohutanpokikanx1() {
        return ztykangohutanpokikanx1;
    }

    public void setZtykangohutanpokikanx1(String pZtykangohutanpokikanx1) {
        ztykangohutanpokikanx1 = pZtykangohutanpokikanx1;
    }

    private String ztykangotokuteibuicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOTOKUTEIBUICDX2)
    public String getZtykangotokuteibuicdx2() {
        return ztykangotokuteibuicdx2;
    }

    public void setZtykangotokuteibuicdx2(String pZtykangotokuteibuicdx2) {
        ztykangotokuteibuicdx2 = pZtykangotokuteibuicdx2;
    }

    private String ztykangohutanpokikanx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKANGOHUTANPOKIKANX2)
    public String getZtykangohutanpokikanx2() {
        return ztykangohutanpokikanx2;
    }

    public void setZtykangohutanpokikanx2(String pZtykangohutanpokikanx2) {
        ztykangohutanpokikanx2 = pZtykangohutanpokikanx2;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztydi2kngtkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2KNGTKYKSYRIKGU)
    public String getZtydi2kngtkyksyrikgu() {
        return ztydi2kngtkyksyrikgu;
    }

    public void setZtydi2kngtkyksyrikgu(String pZtydi2kngtkyksyrikgu) {
        ztydi2kngtkyksyrikgu = pZtydi2kngtkyksyrikgu;
    }

    private String ztydai2kangotokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUYAKUKIKAN)
    public String getZtydai2kangotokuyakukikan() {
        return ztydai2kangotokuyakukikan;
    }

    public void setZtydai2kangotokuyakukikan(String pZtydai2kangotokuyakukikan) {
        ztydai2kangotokuyakukikan = pZtydai2kangotokuyakukikan;
    }

    private String ztydai2kngtkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KNGTKYKPHRKKKN)
    public String getZtydai2kngtkykphrkkkn() {
        return ztydai2kngtkykphrkkkn;
    }

    public void setZtydai2kngtkykphrkkkn(String pZtydai2kngtkykphrkkkn) {
        ztydai2kngtkykphrkkkn = pZtydai2kngtkykphrkkkn;
    }

    private Integer ztydai2kangotokuyakuntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUYAKUNTGK)
    public Integer getZtydai2kangotokuyakuntgk() {
        return ztydai2kangotokuyakuntgk;
    }

    public void setZtydai2kangotokuyakuntgk(Integer pZtydai2kangotokuyakuntgk) {
        ztydai2kangotokuyakuntgk = pZtydai2kangotokuyakuntgk;
    }

    private Long ztydai2kangotokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUYAKUP)
    public Long getZtydai2kangotokuyakup() {
        return ztydai2kangotokuyakup;
    }

    public void setZtydai2kangotokuyakup(Long pZtydai2kangotokuyakup) {
        ztydai2kangotokuyakup = pZtydai2kangotokuyakup;
    }

    private String ztydai2kangotokuyakugatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUYAKUGATAKBN)
    public String getZtydai2kangotokuyakugatakbn() {
        return ztydai2kangotokuyakugatakbn;
    }

    public void setZtydai2kangotokuyakugatakbn(String pZtydai2kangotokuyakugatakbn) {
        ztydai2kangotokuyakugatakbn = pZtydai2kangotokuyakugatakbn;
    }

    private Integer ztydi2kngtkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2KNGTKJYURYUMSHYUTN)
    public Integer getZtydi2kngtkjyuryumshyutn() {
        return ztydi2kngtkjyuryumshyutn;
    }

    public void setZtydi2kngtkjyuryumshyutn(Integer pZtydi2kngtkjyuryumshyutn) {
        ztydi2kngtkjyuryumshyutn = pZtydi2kngtkjyuryumshyutn;
    }

    private Long ztydai2kangotokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUJYOUP)
    public Long getZtydai2kangotokujyoup() {
        return ztydai2kangotokujyoup;
    }

    public void setZtydai2kangotokujyoup(Long pZtydai2kangotokujyoup) {
        ztydai2kangotokujyoup = pZtydai2kangotokujyoup;
    }

    private String ztydai2kangotokuteibuicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUTEIBUICDX1)
    public String getZtydai2kangotokuteibuicdx1() {
        return ztydai2kangotokuteibuicdx1;
    }

    public void setZtydai2kangotokuteibuicdx1(String pZtydai2kangotokuteibuicdx1) {
        ztydai2kangotokuteibuicdx1 = pZtydai2kangotokuteibuicdx1;
    }

    private String ztydai2kangohutanpokikanx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOHUTANPOKIKANX1)
    public String getZtydai2kangohutanpokikanx1() {
        return ztydai2kangohutanpokikanx1;
    }

    public void setZtydai2kangohutanpokikanx1(String pZtydai2kangohutanpokikanx1) {
        ztydai2kangohutanpokikanx1 = pZtydai2kangohutanpokikanx1;
    }

    private String ztydai2kangotokuteibuicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOTOKUTEIBUICDX2)
    public String getZtydai2kangotokuteibuicdx2() {
        return ztydai2kangotokuteibuicdx2;
    }

    public void setZtydai2kangotokuteibuicdx2(String pZtydai2kangotokuteibuicdx2) {
        ztydai2kangotokuteibuicdx2 = pZtydai2kangotokuteibuicdx2;
    }

    private String ztydai2kangohutanpokikanx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2KANGOHUTANPOKIKANX2)
    public String getZtydai2kangohutanpokikanx2() {
        return ztydai2kangohutanpokikanx2;
    }

    public void setZtydai2kangohutanpokikanx2(String pZtydai2kangohutanpokikanx2) {
        ztydai2kangohutanpokikanx2 = pZtydai2kangohutanpokikanx2;
    }

    private String ztyyobiv6x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV6X2)
    public String getZtyyobiv6x2() {
        return ztyyobiv6x2;
    }

    public void setZtyyobiv6x2(String pZtyyobiv6x2) {
        ztyyobiv6x2 = pZtyyobiv6x2;
    }

    private String ztyjysisppitkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKSYURUIKGU)
    public String getZtyjysisppitkyksyuruikgu() {
        return ztyjysisppitkyksyuruikgu;
    }

    public void setZtyjysisppitkyksyuruikgu(String pZtyjysisppitkyksyuruikgu) {
        ztyjysisppitkyksyuruikgu = pZtyjysisppitkyksyuruikgu;
    }

    private String ztyjysisppitkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKKKN)
    public String getZtyjysisppitkykkkn() {
        return ztyjysisppitkykkkn;
    }

    public void setZtyjysisppitkykkkn(String pZtyjysisppitkykkkn) {
        ztyjysisppitkykkkn = pZtyjysisppitkykkkn;
    }

    private String ztyjysisppitkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKPHRKKKN)
    public String getZtyjysisppitkykphrkkkn() {
        return ztyjysisppitkykphrkkkn;
    }

    public void setZtyjysisppitkykphrkkkn(String pZtyjysisppitkykphrkkkn) {
        ztyjysisppitkykphrkkkn = pZtyjysisppitkykphrkkkn;
    }

    private Integer ztyjysisppitkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKNTGK)
    public Integer getZtyjysisppitkykntgk() {
        return ztyjysisppitkykntgk;
    }

    public void setZtyjysisppitkykntgk(Integer pZtyjysisppitkykntgk) {
        ztyjysisppitkykntgk = pZtyjysisppitkykntgk;
    }

    private Long ztyjyoseisippeitokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYOSEISIPPEITOKUYAKUP)
    public Long getZtyjyoseisippeitokuyakup() {
        return ztyjyoseisippeitokuyakup;
    }

    public void setZtyjyoseisippeitokuyakup(Long pZtyjyoseisippeitokuyakup) {
        ztyjyoseisippeitokuyakup = pZtyjyoseisippeitokuyakup;
    }

    private Integer ztyjysisppitkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKJYURYUMSHYUTN)
    public Integer getZtyjysisppitkjyuryumshyutn() {
        return ztyjysisppitkjyuryumshyutn;
    }

    public void setZtyjysisppitkjyuryumshyutn(Integer pZtyjysisppitkjyuryumshyutn) {
        ztyjysisppitkjyuryumshyutn = pZtyjysisppitkjyuryumshyutn;
    }

    private Long ztyjyoseisippeitokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYOSEISIPPEITOKUJYOUP)
    public Long getZtyjyoseisippeitokujyoup() {
        return ztyjyoseisippeitokujyoup;
    }

    public void setZtyjyoseisippeitokujyoup(Long pZtyjyoseisippeitokujyoup) {
        ztyjyoseisippeitokujyoup = pZtyjyoseisippeitokujyoup;
    }

    private String ztyjysisppitktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKTBICDX1)
    public String getZtyjysisppitktbicdx1() {
        return ztyjysisppitktbicdx1;
    }

    public void setZtyjysisppitktbicdx1(String pZtyjysisppitktbicdx1) {
        ztyjysisppitktbicdx1 = pZtyjysisppitktbicdx1;
    }

    private String ztyjysisppihtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPIHTNPKKNX1)
    public String getZtyjysisppihtnpkknx1() {
        return ztyjysisppihtnpkknx1;
    }

    public void setZtyjysisppihtnpkknx1(String pZtyjysisppihtnpkknx1) {
        ztyjysisppihtnpkknx1 = pZtyjysisppihtnpkknx1;
    }

    private String ztyjysisppitktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKTBICDX2)
    public String getZtyjysisppitktbicdx2() {
        return ztyjysisppitktbicdx2;
    }

    public void setZtyjysisppitktbicdx2(String pZtyjysisppitktbicdx2) {
        ztyjysisppitktbicdx2 = pZtyjysisppitktbicdx2;
    }

    private String ztyjysisppihtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPIHTNPKKNX2)
    public String getZtyjysisppihtnpkknx2() {
        return ztyjysisppihtnpkknx2;
    }

    public void setZtyjysisppihtnpkknx2(String pZtyjysisppihtnpkknx2) {
        ztyjysisppihtnpkknx2 = pZtyjysisppihtnpkknx2;
    }

    private String ztyjysisppitkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKKGUSDKBN)
    public String getZtyjysisppitkykkgusdkbn() {
        return ztyjysisppitkykkgusdkbn;
    }

    public void setZtyjysisppitkykkgusdkbn(String pZtyjysisppitkykkgusdkbn) {
        ztyjysisppitkykkgusdkbn = pZtyjysisppitkykkgusdkbn;
    }

    private String ztyjysisppitkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKPWRBKKBN)
    public String getZtyjysisppitkykpwrbkkbn() {
        return ztyjysisppitkykpwrbkkbn;
    }

    public void setZtyjysisppitkykpwrbkkbn(String pZtyjysisppitkykpwrbkkbn) {
        ztyjysisppitkykpwrbkkbn = pZtyjysisppitkykpwrbkkbn;
    }

    private String ztyjysisppitkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYSISPPITKYKKUSNMNRYOAGE)
    public String getZtyjysisppitkykkusnmnryoage() {
        return ztyjysisppitkykkusnmnryoage;
    }

    public void setZtyjysisppitkykkusnmnryoage(String pZtyjysisppitkykkusnmnryoage) {
        ztyjysisppitkykkusnmnryoage = pZtyjysisppitkykkusnmnryoage;
    }

    private String ztyyobiv2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV2X2)
    public String getZtyyobiv2x2() {
        return ztyyobiv2x2;
    }

    public void setZtyyobiv2x2(String pZtyyobiv2x2) {
        ztyyobiv2x2 = pZtyyobiv2x2;
    }

    private String ztydi2jysisppitkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKSYRIKGU)
    public String getZtydi2jysisppitkyksyrikgu() {
        return ztydi2jysisppitkyksyrikgu;
    }

    public void setZtydi2jysisppitkyksyrikgu(String pZtydi2jysisppitkyksyrikgu) {
        ztydi2jysisppitkyksyrikgu = pZtydi2jysisppitkyksyrikgu;
    }

    private String ztydi2jysisppitkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKKKN)
    public String getZtydi2jysisppitkykkkn() {
        return ztydi2jysisppitkykkkn;
    }

    public void setZtydi2jysisppitkykkkn(String pZtydi2jysisppitkykkkn) {
        ztydi2jysisppitkykkkn = pZtydi2jysisppitkykkkn;
    }

    private String ztydi2jysisppitkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKPHRKKKN)
    public String getZtydi2jysisppitkykphrkkkn() {
        return ztydi2jysisppitkykphrkkkn;
    }

    public void setZtydi2jysisppitkykphrkkkn(String pZtydi2jysisppitkykphrkkkn) {
        ztydi2jysisppitkykphrkkkn = pZtydi2jysisppitkykphrkkkn;
    }

    private Integer ztydi2jysisppitkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKNTGK)
    public Integer getZtydi2jysisppitkykntgk() {
        return ztydi2jysisppitkykntgk;
    }

    public void setZtydi2jysisppitkykntgk(Integer pZtydi2jysisppitkykntgk) {
        ztydi2jysisppitkykntgk = pZtydi2jysisppitkykntgk;
    }

    private Long ztydi2jysisppitkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKP)
    public Long getZtydi2jysisppitkykp() {
        return ztydi2jysisppitkykp;
    }

    public void setZtydi2jysisppitkykp(Long pZtydi2jysisppitkykp) {
        ztydi2jysisppitkykp = pZtydi2jysisppitkykp;
    }

    private Integer ztydi2jysisppitkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKJYURYMSHYTN)
    public Integer getZtydi2jysisppitkjyurymshytn() {
        return ztydi2jysisppitkjyurymshytn;
    }

    public void setZtydi2jysisppitkjyurymshytn(Integer pZtydi2jysisppitkjyurymshytn) {
        ztydi2jysisppitkjyurymshytn = pZtydi2jysisppitkjyurymshytn;
    }

    private Long ztydi2jysisppitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKJYUP)
    public Long getZtydi2jysisppitkjyup() {
        return ztydi2jysisppitkjyup;
    }

    public void setZtydi2jysisppitkjyup(Long pZtydi2jysisppitkjyup) {
        ztydi2jysisppitkjyup = pZtydi2jysisppitkjyup;
    }

    private String ztydi2jysisppitktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKTBICDX1)
    public String getZtydi2jysisppitktbicdx1() {
        return ztydi2jysisppitktbicdx1;
    }

    public void setZtydi2jysisppitktbicdx1(String pZtydi2jysisppitktbicdx1) {
        ztydi2jysisppitktbicdx1 = pZtydi2jysisppitktbicdx1;
    }

    private String ztydi2jysisppihtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPIHTNPKKNX1)
    public String getZtydi2jysisppihtnpkknx1() {
        return ztydi2jysisppihtnpkknx1;
    }

    public void setZtydi2jysisppihtnpkknx1(String pZtydi2jysisppihtnpkknx1) {
        ztydi2jysisppihtnpkknx1 = pZtydi2jysisppihtnpkknx1;
    }

    private String ztydi2jysisppitktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKTBICDX2)
    public String getZtydi2jysisppitktbicdx2() {
        return ztydi2jysisppitktbicdx2;
    }

    public void setZtydi2jysisppitktbicdx2(String pZtydi2jysisppitktbicdx2) {
        ztydi2jysisppitktbicdx2 = pZtydi2jysisppitktbicdx2;
    }

    private String ztydi2jysisppihtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPIHTNPKKNX2)
    public String getZtydi2jysisppihtnpkknx2() {
        return ztydi2jysisppihtnpkknx2;
    }

    public void setZtydi2jysisppihtnpkknx2(String pZtydi2jysisppihtnpkknx2) {
        ztydi2jysisppihtnpkknx2 = pZtydi2jysisppihtnpkknx2;
    }

    private String ztydi2jysisppitkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKKGUSDKBN)
    public String getZtydi2jysisppitkykkgusdkbn() {
        return ztydi2jysisppitkykkgusdkbn;
    }

    public void setZtydi2jysisppitkykkgusdkbn(String pZtydi2jysisppitkykkgusdkbn) {
        ztydi2jysisppitkykkgusdkbn = pZtydi2jysisppitkykkgusdkbn;
    }

    private String ztydi2jysisppitkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYSISPPITKYKPWRBKKBN)
    public String getZtydi2jysisppitkykpwrbkkbn() {
        return ztydi2jysisppitkykpwrbkkbn;
    }

    public void setZtydi2jysisppitkykpwrbkkbn(String pZtydi2jysisppitkykpwrbkkbn) {
        ztydi2jysisppitkykpwrbkkbn = pZtydi2jysisppitkykpwrbkkbn;
    }

    private String ztyyobiv4x14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV4X14)
    public String getZtyyobiv4x14() {
        return ztyyobiv4x14;
    }

    public void setZtyyobiv4x14(String pZtyyobiv4x14) {
        ztyyobiv4x14 = pZtyyobiv4x14;
    }

    private String ztywinninglifehyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYWINNINGLIFEHYOUJI)
    public String getZtywinninglifehyouji() {
        return ztywinninglifehyouji;
    }

    public void setZtywinninglifehyouji(String pZtywinninglifehyouji) {
        ztywinninglifehyouji = pZtywinninglifehyouji;
    }

    private String ztystyouikusikinuktrininkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSTYOUIKUSIKINUKTRININKBN)
    public String getZtystyouikusikinuktrininkbn() {
        return ztystyouikusikinuktrininkbn;
    }

    public void setZtystyouikusikinuktrininkbn(String pZtystyouikusikinuktrininkbn) {
        ztystyouikusikinuktrininkbn = pZtystyouikusikinuktrininkbn;
    }

    private String ztyjyudthumeharaitkykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUDTHUMEHARAITKYKARIHYJ)
    public String getZtyjyudthumeharaitkykarihyj() {
        return ztyjyudthumeharaitkykarihyj;
    }

    public void setZtyjyudthumeharaitkykarihyj(String pZtyjyudthumeharaitkykarihyj) {
        ztyjyudthumeharaitkykarihyj = pZtyjyudthumeharaitkykarihyj;
    }

    private String ztysinkenkouseikatupackhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSINKENKOUSEIKATUPACKHYJ)
    public String getZtysinkenkouseikatupackhyj() {
        return ztysinkenkouseikatupackhyj;
    }

    public void setZtysinkenkouseikatupackhyj(String pZtysinkenkouseikatupackhyj) {
        ztysinkenkouseikatupackhyj = pZtysinkenkouseikatupackhyj;
    }

    private String ztysyukeiyakupwaribikikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYUKEIYAKUPWARIBIKIKBN)
    public String getZtysyukeiyakupwaribikikbn() {
        return ztysyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysyukeiyakupwaribikikbn(String pZtysyukeiyakupwaribikikbn) {
        ztysyukeiyakupwaribikikbn = pZtysyukeiyakupwaribikikbn;
    }

    private String ztysykyktnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKYKTNKNYUGUKBN)
    public String getZtysykyktnknyugukbn() {
        return ztysykyktnknyugukbn;
    }

    public void setZtysykyktnknyugukbn(String pZtysykyktnknyugukbn) {
        ztysykyktnknyugukbn = pZtysykyktnknyugukbn;
    }

    private String ztymosjihonninkknnkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYMOSJIHONNINKKNNKBN)
    public String getZtymosjihonninkknnkbn() {
        return ztymosjihonninkknnkbn;
    }

    public void setZtymosjihonninkknnkbn(String pZtymosjihonninkknnkbn) {
        ztymosjihonninkknnkbn = pZtymosjihonninkknnkbn;
    }

    private String ztykituenhonsuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKITUENHONSUU)
    public String getZtykituenhonsuu() {
        return ztykituenhonsuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykituenhonsuu(String pZtykituenhonsuu) {
        ztykituenhonsuu = pZtykituenhonsuu;
    }

    private String ztykousinmaetenkannensuukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKOUSINMAETENKANNENSUUKBN)
    public String getZtykousinmaetenkannensuukbn() {
        return ztykousinmaetenkannensuukbn;
    }

    public void setZtykousinmaetenkannensuukbn(String pZtykousinmaetenkannensuukbn) {
        ztykousinmaetenkannensuukbn = pZtykousinmaetenkannensuukbn;
    }

    private String ztymankimaetenkannensuukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYMANKIMAETENKANNENSUUKBN)
    public String getZtymankimaetenkannensuukbn() {
        return ztymankimaetenkannensuukbn;
    }

    public void setZtymankimaetenkannensuukbn(String pZtymankimaetenkannensuukbn) {
        ztymankimaetenkannensuukbn = pZtymankimaetenkannensuukbn;
    }

    private String ztyseikitenkanhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSEIKITENKANHYOUJI)
    public String getZtyseikitenkanhyouji() {
        return ztyseikitenkanhyouji;
    }

    public void setZtyseikitenkanhyouji(String pZtyseikitenkanhyouji) {
        ztyseikitenkanhyouji = pZtyseikitenkanhyouji;
    }

    private String ztygengakutenkankykhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGENGAKUTENKANKYKHYJ)
    public String getZtygengakutenkankykhyj() {
        return ztygengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygengakutenkankykhyj(String pZtygengakutenkankykhyj) {
        ztygengakutenkankykhyj = pZtygengakutenkankykhyj;
    }

    private String ztyyobiv2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV2X3)
    public String getZtyyobiv2x3() {
        return ztyyobiv2x3;
    }

    public void setZtyyobiv2x3(String pZtyyobiv2x3) {
        ztyyobiv2x3 = pZtyyobiv2x3;
    }

    private String ztykousin3nenmaetnknhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKOUSIN3NENMAETNKNHYJ)
    public String getZtykousin3nenmaetnknhyj() {
        return ztykousin3nenmaetnknhyj;
    }

    public void setZtykousin3nenmaetnknhyj(String pZtykousin3nenmaetnknhyj) {
        ztykousin3nenmaetnknhyj = pZtykousin3nenmaetnknhyj;
    }

    private String ztydugktnknsntkhuhukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDUGKTNKNSNTKHUHUKBN)
    public String getZtydugktnknsntkhuhukbn() {
        return ztydugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydugktnknsntkhuhukbn(String pZtydugktnknsntkhuhukbn) {
        ztydugktnknsntkhuhukbn = pZtydugktnknsntkhuhukbn;
    }

    private String ztytnknsnstkbttrtkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTNKNSNSTKBTTRTKKBN)
    public String getZtytnknsnstkbttrtkkbn() {
        return ztytnknsnstkbttrtkkbn;
    }

    public void setZtytnknsnstkbttrtkkbn(String pZtytnknsnstkbttrtkkbn) {
        ztytnknsnstkbttrtkkbn = pZtytnknsnstkbttrtkkbn;
    }

    private Long ztyhtnknsiginyuintkykgkntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIGINYUINTKYKGKNTGK)
    public Long getZtyhtnknsiginyuintkykgkntgk() {
        return ztyhtnknsiginyuintkykgkntgk;
    }

    public void setZtyhtnknsiginyuintkykgkntgk(Long pZtyhtnknsiginyuintkykgkntgk) {
        ztyhtnknsiginyuintkykgkntgk = pZtyhtnknsiginyuintkykgkntgk;
    }

    private String ztyhtnknsiginyuintkykkykymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIGINYUINTKYKKYKYMD)
    public String getZtyhtnknsiginyuintkykkykymd() {
        return ztyhtnknsiginyuintkykkykymd;
    }

    public void setZtyhtnknsiginyuintkykkykymd(String pZtyhtnknsiginyuintkykkykymd) {
        ztyhtnknsiginyuintkykkykymd = pZtyhtnknsiginyuintkykkykymd;
    }

    private String ztyhtnknsiginyuintkyksnskbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIGINYUINTKYKSNSKBN)
    public String getZtyhtnknsiginyuintkyksnskbn() {
        return ztyhtnknsiginyuintkyksnskbn;
    }

    public void setZtyhtnknsiginyuintkyksnskbn(String pZtyhtnknsiginyuintkyksnskbn) {
        ztyhtnknsiginyuintkyksnskbn = pZtyhtnknsiginyuintkyksnskbn;
    }

    private Long ztyhtnknsppinyuintkykgkntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSPPINYUINTKYKGKNTGK)
    public Long getZtyhtnknsppinyuintkykgkntgk() {
        return ztyhtnknsppinyuintkykgkntgk;
    }

    public void setZtyhtnknsppinyuintkykgkntgk(Long pZtyhtnknsppinyuintkykgkntgk) {
        ztyhtnknsppinyuintkykgkntgk = pZtyhtnknsppinyuintkykgkntgk;
    }

    private String ztyhtnknsppinyuintkykkykymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSPPINYUINTKYKKYKYMD)
    public String getZtyhtnknsppinyuintkykkykymd() {
        return ztyhtnknsppinyuintkykkykymd;
    }

    public void setZtyhtnknsppinyuintkykkykymd(String pZtyhtnknsppinyuintkykkykymd) {
        ztyhtnknsppinyuintkykkykymd = pZtyhtnknsppinyuintkykkykymd;
    }

    private String ztyhtnknsppinyuintkyksnskbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSPPINYUINTKYKSNSKBN)
    public String getZtyhtnknsppinyuintkyksnskbn() {
        return ztyhtnknsppinyuintkyksnskbn;
    }

    public void setZtyhtnknsppinyuintkyksnskbn(String pZtyhtnknsppinyuintkyksnskbn) {
        ztyhtnknsppinyuintkyksnskbn = pZtyhtnknsppinyuintkyksnskbn;
    }

    private Long ztyhtnknsijnbyutkykgukintgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIJNBYUTKYKGUKINTGK)
    public Long getZtyhtnknsijnbyutkykgukintgk() {
        return ztyhtnknsijnbyutkykgukintgk;
    }

    public void setZtyhtnknsijnbyutkykgukintgk(Long pZtyhtnknsijnbyutkykgukintgk) {
        ztyhtnknsijnbyutkykgukintgk = pZtyhtnknsijnbyutkykgukintgk;
    }

    private String ztyhtnknsijnbyutkykkykymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIJNBYUTKYKKYKYMD)
    public String getZtyhtnknsijnbyutkykkykymd() {
        return ztyhtnknsijnbyutkykkykymd;
    }

    public void setZtyhtnknsijnbyutkykkykymd(String pZtyhtnknsijnbyutkykkykymd) {
        ztyhtnknsijnbyutkykkykymd = pZtyhtnknsijnbyutkykkykymd;
    }

    private String ztyhtnknsijnbyutkyksnskbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIJNBYUTKYKSNSKBN)
    public String getZtyhtnknsijnbyutkyksnskbn() {
        return ztyhtnknsijnbyutkyksnskbn;
    }

    public void setZtyhtnknsijnbyutkyksnskbn(String pZtyhtnknsijnbyutkyksnskbn) {
        ztyhtnknsijnbyutkyksnskbn = pZtyhtnknsijnbyutkyksnskbn;
    }

    private Long ztyhtnknjysisppitkykgkintgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYSISPPITKYKGKINTGK)
    public Long getZtyhtnknjysisppitkykgkintgk() {
        return ztyhtnknjysisppitkykgkintgk;
    }

    public void setZtyhtnknjysisppitkykgkintgk(Long pZtyhtnknjysisppitkykgkintgk) {
        ztyhtnknjysisppitkykgkintgk = pZtyhtnknjysisppitkykgkintgk;
    }

    private String ztyhtnknjysisppitkykkykymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYSISPPITKYKKYKYMD)
    public String getZtyhtnknjysisppitkykkykymd() {
        return ztyhtnknjysisppitkykkykymd;
    }

    public void setZtyhtnknjysisppitkykkykymd(String pZtyhtnknjysisppitkykkykymd) {
        ztyhtnknjysisppitkykkykymd = pZtyhtnknjysisppitkykkykymd;
    }

    private String ztyhtnknjysisppitkyksnskbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYSISPPITKYKSNSKBN)
    public String getZtyhtnknjysisppitkyksnskbn() {
        return ztyhtnknjysisppitkyksnskbn;
    }

    public void setZtyhtnknjysisppitkyksnskbn(String pZtyhtnknjysisppitkyksnskbn) {
        ztyhtnknjysisppitkyksnskbn = pZtyhtnknjysisppitkyksnskbn;
    }

    private String ztysiteizukipwarimasihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSITEIZUKIPWARIMASIHYOUJI)
    public String getZtysiteizukipwarimasihyouji() {
        return ztysiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysiteizukipwarimasihyouji(String pZtysiteizukipwarimasihyouji) {
        ztysiteizukipwarimasihyouji = pZtysiteizukipwarimasihyouji;
    }

    private String ztypwarimasisiteim1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYPWARIMASISITEIM1)
    public String getZtypwarimasisiteim1() {
        return ztypwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim1(String pZtypwarimasisiteim1) {
        ztypwarimasisiteim1 = pZtypwarimasisiteim1;
    }

    private String ztypwarimasisiteim2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYPWARIMASISITEIM2)
    public String getZtypwarimasisiteim2() {
        return ztypwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim2(String pZtypwarimasisiteim2) {
        ztypwarimasisiteim2 = pZtypwarimasisiteim2;
    }

    private String ztysiteimsykykpbairitu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSITEIMSYKYKPBAIRITU)
    public String getZtysiteimsykykpbairitu() {
        return ztysiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysiteimsykykpbairitu(String pZtysiteimsykykpbairitu) {
        ztysiteimsykykpbairitu = pZtysiteimsykykpbairitu;
    }

    private Long ztysiteizukisyukeiyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSITEIZUKISYUKEIYAKUP)
    public Long getZtysiteizukisyukeiyakup() {
        return ztysiteizukisyukeiyakup;
    }

    public void setZtysiteizukisyukeiyakup(Long pZtysiteizukisyukeiyakup) {
        ztysiteizukisyukeiyakup = pZtysiteizukisyukeiyakup;
    }

    private Long ztytuujyoutukiharaikomip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUUJYOUTUKIHARAIKOMIP)
    public Long getZtytuujyoutukiharaikomip() {
        return ztytuujyoutukiharaikomip;
    }

    public void setZtytuujyoutukiharaikomip(Long pZtytuujyoutukiharaikomip) {
        ztytuujyoutukiharaikomip = pZtytuujyoutukiharaikomip;
    }

    private Long ztysiteizukiharaikomip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSITEIZUKIHARAIKOMIP)
    public Long getZtysiteizukiharaikomip() {
        return ztysiteizukiharaikomip;
    }

    public void setZtysiteizukiharaikomip(Long pZtysiteizukiharaikomip) {
        ztysiteizukiharaikomip = pZtysiteizukiharaikomip;
    }

    private Long ztymaruteikisiteizukip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYMARUTEIKISITEIZUKIP)
    public Long getZtymaruteikisiteizukip() {
        return ztymaruteikisiteizukip;
    }

    public void setZtymaruteikisiteizukip(Long pZtymaruteikisiteizukip) {
        ztymaruteikisiteizukip = pZtymaruteikisiteizukip;
    }

    private Long ztyseizonmaruteisiteimp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSEIZONMARUTEISITEIMP)
    public Long getZtyseizonmaruteisiteimp() {
        return ztyseizonmaruteisiteimp;
    }

    public void setZtyseizonmaruteisiteimp(Long pZtyseizonmaruteisiteimp) {
        ztyseizonmaruteisiteimp = pZtyseizonmaruteisiteimp;
    }

    private String ztymaruteipsiteibairitu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYMARUTEIPSITEIBAIRITU)
    public String getZtymaruteipsiteibairitu() {
        return ztymaruteipsiteibairitu;
    }

    public void setZtymaruteipsiteibairitu(String pZtymaruteipsiteibairitu) {
        ztymaruteipsiteibairitu = pZtymaruteipsiteibairitu;
    }

    private String ztyseizonmaruteipstbairitu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSEIZONMARUTEIPSTBAIRITU)
    public String getZtyseizonmaruteipstbairitu() {
        return ztyseizonmaruteipstbairitu;
    }

    public void setZtyseizonmaruteipstbairitu(String pZtyseizonmaruteipstbairitu) {
        ztyseizonmaruteipstbairitu = pZtyseizonmaruteipstbairitu;
    }

    private String ztynkdtmrtisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTISYURUIKGU)
    public String getZtynkdtmrtisyuruikgu() {
        return ztynkdtmrtisyuruikgu;
    }

    public void setZtynkdtmrtisyuruikgu(String pZtynkdtmrtisyuruikgu) {
        ztynkdtmrtisyuruikgu = pZtynkdtmrtisyuruikgu;
    }

    private String ztynenkindatemaruteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATEMARUTEIKIKAN)
    public String getZtynenkindatemaruteikikan() {
        return ztynenkindatemaruteikikan;
    }

    public void setZtynenkindatemaruteikikan(String pZtynenkindatemaruteikikan) {
        ztynenkindatemaruteikikan = pZtynenkindatemaruteikikan;
    }

    private String ztynkdatemaruteiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEIPHRKKKN)
    public String getZtynkdatemaruteiphrkkkn() {
        return ztynkdatemaruteiphrkkkn;
    }

    public void setZtynkdatemaruteiphrkkkn(String pZtynkdatemaruteiphrkkkn) {
        ztynkdatemaruteiphrkkkn = pZtynkdatemaruteiphrkkkn;
    }

    private Long ztynkdatemaruteinenkinnengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEINENKINNENGK)
    public Long getZtynkdatemaruteinenkinnengk() {
        return ztynkdatemaruteinenkinnengk;
    }

    public void setZtynkdatemaruteinenkinnengk(Long pZtynkdatemaruteinenkinnengk) {
        ztynkdatemaruteinenkinnengk = pZtynkdatemaruteinenkinnengk;
    }

    private Long ztynenkindatemaruteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATEMARUTEIS)
    public Long getZtynenkindatemaruteis() {
        return ztynenkindatemaruteis;
    }

    public void setZtynenkindatemaruteis(Long pZtynenkindatemaruteis) {
        ztynenkindatemaruteis = pZtynenkindatemaruteis;
    }

    private Long ztynenkindatemaruteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATEMARUTEIP)
    public Long getZtynenkindatemaruteip() {
        return ztynenkindatemaruteip;
    }

    public void setZtynenkindatemaruteip(Long pZtynenkindatemaruteip) {
        ztynenkindatemaruteip = pZtynenkindatemaruteip;
    }

    private Long ztynkdatemaruteimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEIMODS)
    public Long getZtynkdatemaruteimods() {
        return ztynkdatemaruteimods;
    }

    public void setZtynkdatemaruteimods(Long pZtynkdatemaruteimods) {
        ztynkdatemaruteimods = pZtynkdatemaruteimods;
    }

    private String ztynkdtmrtimodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTIMODSSKGNHYJ)
    public String getZtynkdtmrtimodsskgnhyj() {
        return ztynkdtmrtimodsskgnhyj;
    }

    public void setZtynkdtmrtimodsskgnhyj(String pZtynkdtmrtimodsskgnhyj) {
        ztynkdtmrtimodsskgnhyj = pZtynkdtmrtimodsskgnhyj;
    }

    private String ztynkdatemaruteitkjyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEITKJYOUKBN)
    public String getZtynkdatemaruteitkjyoukbn() {
        return ztynkdatemaruteitkjyoukbn;
    }

    public void setZtynkdatemaruteitkjyoukbn(String pZtynkdatemaruteitkjyoukbn) {
        ztynkdatemaruteitkjyoukbn = pZtynkdatemaruteitkjyoukbn;
    }

    private String ztynkdtmrtitkjyouskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTITKJYOUSKGNKKN)
    public String getZtynkdtmrtitkjyouskgnkkn() {
        return ztynkdtmrtitkjyouskgnkkn;
    }

    public void setZtynkdtmrtitkjyouskgnkkn(String pZtynkdtmrtitkjyouskgnkkn) {
        ztynkdtmrtitkjyouskgnkkn = pZtynkdtmrtitkjyouskgnkkn;
    }

    private Integer ztynkdtmrtitkjyouryumshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTITKJYOURYUMSHYTN)
    public Integer getZtynkdtmrtitkjyouryumshytn() {
        return ztynkdtmrtitkjyouryumshytn;
    }

    public void setZtynkdtmrtitkjyouryumshytn(Integer pZtynkdtmrtitkjyouryumshytn) {
        ztynkdtmrtitkjyouryumshytn = pZtynkdtmrtitkjyouryumshytn;
    }

    private Long ztynkdatemaruteitkjyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEITKJYOUP)
    public Long getZtynkdatemaruteitkjyoup() {
        return ztynkdatemaruteitkjyoup;
    }

    public void setZtynkdatemaruteitkjyoup(Long pZtynkdatemaruteitkjyoup) {
        ztynkdatemaruteitkjyoup = pZtynkdatemaruteitkjyoup;
    }

    private String ztyhtnknnkdtmrtisyuruikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKDTMRTISYURUIKGUX1)
    public String getZtyhtnknnkdtmrtisyuruikgux1() {
        return ztyhtnknnkdtmrtisyuruikgux1;
    }

    public void setZtyhtnknnkdtmrtisyuruikgux1(String pZtyhtnknnkdtmrtisyuruikgux1) {
        ztyhtnknnkdtmrtisyuruikgux1 = pZtyhtnknnkdtmrtisyuruikgux1;
    }

    private String ztyhtnknnkdtmrtisyuruikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKDTMRTISYURUIKGUX2)
    public String getZtyhtnknnkdtmrtisyuruikgux2() {
        return ztyhtnknnkdtmrtisyuruikgux2;
    }

    public void setZtyhtnknnkdtmrtisyuruikgux2(String pZtyhtnknnkdtmrtisyuruikgux2) {
        ztyhtnknnkdtmrtisyuruikgux2 = pZtyhtnknnkdtmrtisyuruikgux2;
    }

    private String ztyhtnknnkdtmrtisyuruikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKDTMRTISYURUIKGUX3)
    public String getZtyhtnknnkdtmrtisyuruikgux3() {
        return ztyhtnknnkdtmrtisyuruikgux3;
    }

    public void setZtyhtnknnkdtmrtisyuruikgux3(String pZtyhtnknnkdtmrtisyuruikgux3) {
        ztyhtnknnkdtmrtisyuruikgux3 = pZtyhtnknnkdtmrtisyuruikgux3;
    }

    private String ztyhtnknnkdtmrtisyuruikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKDTMRTISYURUIKGUX4)
    public String getZtyhtnknnkdtmrtisyuruikgux4() {
        return ztyhtnknnkdtmrtisyuruikgux4;
    }

    public void setZtyhtnknnkdtmrtisyuruikgux4(String pZtyhtnknnkdtmrtisyuruikgux4) {
        ztyhtnknnkdtmrtisyuruikgux4 = pZtyhtnknnkdtmrtisyuruikgux4;
    }

    private String ztyhtnknnkdtmrtisyuruikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKDTMRTISYURUIKGUX5)
    public String getZtyhtnknnkdtmrtisyuruikgux5() {
        return ztyhtnknnkdtmrtisyuruikgux5;
    }

    public void setZtyhtnknnkdtmrtisyuruikgux5(String pZtyhtnknnkdtmrtisyuruikgux5) {
        ztyhtnknnkdtmrtisyuruikgux5 = pZtyhtnknnkdtmrtisyuruikgux5;
    }

    private String ztyhtnknnkdtmrtisyuruikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKDTMRTISYURUIKGUX6)
    public String getZtyhtnknnkdtmrtisyuruikgux6() {
        return ztyhtnknnkdtmrtisyuruikgux6;
    }

    public void setZtyhtnknnkdtmrtisyuruikgux6(String pZtyhtnknnkdtmrtisyuruikgux6) {
        ztyhtnknnkdtmrtisyuruikgux6 = pZtyhtnknnkdtmrtisyuruikgux6;
    }

    private String ztynkdatemaruteishrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEISHRKKN)
    public String getZtynkdatemaruteishrkkn() {
        return ztynkdatemaruteishrkkn;
    }

    public void setZtynkdatemaruteishrkkn(String pZtynkdatemaruteishrkkn) {
        ztynkdatemaruteishrkkn = pZtynkdatemaruteishrkkn;
    }

    private String ztysuriyounkdtmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURIYOUNKDTMRTIPWRBKKBN)
    public String getZtysuriyounkdtmrtipwrbkkbn() {
        return ztysuriyounkdtmrtipwrbkkbn;
    }

    public void setZtysuriyounkdtmrtipwrbkkbn(String pZtysuriyounkdtmrtipwrbkkbn) {
        ztysuriyounkdtmrtipwrbkkbn = pZtysuriyounkdtmrtipwrbkkbn;
    }

    private String ztynkdatemaruteipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATEMARUTEIPWRBKKBN)
    public String getZtynkdatemaruteipwrbkkbn() {
        return ztynkdatemaruteipwrbkkbn;
    }

    public void setZtynkdatemaruteipwrbkkbn(String pZtynkdatemaruteipwrbkkbn) {
        ztynkdatemaruteipwrbkkbn = pZtynkdatemaruteipwrbkkbn;
    }

    private String ztyhtnknkyksiteimhyjx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKSITEIMHYJX1)
    public String getZtyhtnknkyksiteimhyjx1() {
        return ztyhtnknkyksiteimhyjx1;
    }

    public void setZtyhtnknkyksiteimhyjx1(String pZtyhtnknkyksiteimhyjx1) {
        ztyhtnknkyksiteimhyjx1 = pZtyhtnknkyksiteimhyjx1;
    }

    private String ztyhtnknkyksiteimhyjx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKSITEIMHYJX2)
    public String getZtyhtnknkyksiteimhyjx2() {
        return ztyhtnknkyksiteimhyjx2;
    }

    public void setZtyhtnknkyksiteimhyjx2(String pZtyhtnknkyksiteimhyjx2) {
        ztyhtnknkyksiteimhyjx2 = pZtyhtnknkyksiteimhyjx2;
    }

    private String ztyhtnknkyksiteimhyjx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKSITEIMHYJX3)
    public String getZtyhtnknkyksiteimhyjx3() {
        return ztyhtnknkyksiteimhyjx3;
    }

    public void setZtyhtnknkyksiteimhyjx3(String pZtyhtnknkyksiteimhyjx3) {
        ztyhtnknkyksiteimhyjx3 = pZtyhtnknkyksiteimhyjx3;
    }

    private String ztyhtnknkyksiteimhyjx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKSITEIMHYJX4)
    public String getZtyhtnknkyksiteimhyjx4() {
        return ztyhtnknkyksiteimhyjx4;
    }

    public void setZtyhtnknkyksiteimhyjx4(String pZtyhtnknkyksiteimhyjx4) {
        ztyhtnknkyksiteimhyjx4 = pZtyhtnknkyksiteimhyjx4;
    }

    private String ztyhtnknkyksiteimhyjx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKSITEIMHYJX5)
    public String getZtyhtnknkyksiteimhyjx5() {
        return ztyhtnknkyksiteimhyjx5;
    }

    public void setZtyhtnknkyksiteimhyjx5(String pZtyhtnknkyksiteimhyjx5) {
        ztyhtnknkyksiteimhyjx5 = pZtyhtnknkyksiteimhyjx5;
    }

    private String ztyhtnknkyksiteimhyjx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKSITEIMHYJX6)
    public String getZtyhtnknkyksiteimhyjx6() {
        return ztyhtnknkyksiteimhyjx6;
    }

    public void setZtyhtnknkyksiteimhyjx6(String pZtyhtnknkyksiteimhyjx6) {
        ztyhtnknkyksiteimhyjx6 = pZtyhtnknkyksiteimhyjx6;
    }

    private String ztytyohkreinyutkbttrtkhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOHKREINYUTKBTTRTKHYJ)
    public String getZtytyohkreinyutkbttrtkhyj() {
        return ztytyohkreinyutkbttrtkhyj;
    }

    public void setZtytyohkreinyutkbttrtkhyj(String pZtytyohkreinyutkbttrtkhyj) {
        ztytyohkreinyutkbttrtkhyj = pZtytyohkreinyutkbttrtkhyj;
    }

    private Long ztykazokumrtinknengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAZOKUMRTINKNENGK)
    public Long getZtykazokumrtinknengk() {
        return ztykazokumrtinknengk;
    }

    public void setZtykazokumrtinknengk(Long pZtykazokumrtinknengk) {
        ztykazokumrtinknengk = pZtykazokumrtinknengk;
    }

    private String ztyalmyoukijyunym;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYALMYOUKIJYUNYM)
    public String getZtyalmyoukijyunym() {
        return ztyalmyoukijyunym;
    }

    public void setZtyalmyoukijyunym(String pZtyalmyoukijyunym) {
        ztyalmyoukijyunym = pZtyalmyoukijyunym;
    }

    private String ztysetaitesyono2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESYONO2)
    public String getZtysetaitesyono2() {
        return ztysetaitesyono2;
    }

    public void setZtysetaitesyono2(String pZtysetaitesyono2) {
        ztysetaitesyono2 = pZtysetaitesyono2;
    }

    private String ztysetaitehokensyuruikigou2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITEHOKENSYURUIKIGOU2)
    public String getZtysetaitehokensyuruikigou2() {
        return ztysetaitehokensyuruikigou2;
    }

    public void setZtysetaitehokensyuruikigou2(String pZtysetaitehokensyuruikigou2) {
        ztysetaitehokensyuruikigou2 = pZtysetaitehokensyuruikigou2;
    }

    private String ztysetaitemrtisyuruikgu2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITEMRTISYURUIKGU2)
    public String getZtysetaitemrtisyuruikgu2() {
        return ztysetaitemrtisyuruikgu2;
    }

    public void setZtysetaitemrtisyuruikgu2(String pZtysetaitemrtisyuruikgu2) {
        ztysetaitemrtisyuruikgu2 = pZtysetaitemrtisyuruikgu2;
    }

    private String ztysetaitesiznmrtisyurui2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESIZNMRTISYURUI2)
    public String getZtysetaitesiznmrtisyurui2() {
        return ztysetaitesiznmrtisyurui2;
    }

    public void setZtysetaitesiznmrtisyurui2(String pZtysetaitesiznmrtisyurui2) {
        ztysetaitesiznmrtisyurui2 = pZtysetaitesiznmrtisyurui2;
    }

    private String ztysetaitetignmrtisyurui2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITETIGNMRTISYURUI2)
    public String getZtysetaitetignmrtisyurui2() {
        return ztysetaitetignmrtisyurui2;
    }

    public void setZtysetaitetignmrtisyurui2(String pZtysetaitetignmrtisyurui2) {
        ztysetaitetignmrtisyurui2 = pZtysetaitetignmrtisyurui2;
    }

    private Long ztysetaitekihonbubuns2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITEKIHONBUBUNS2)
    public Long getZtysetaitekihonbubuns2() {
        return ztysetaitekihonbubuns2;
    }

    public void setZtysetaitekihonbubuns2(Long pZtysetaitekihonbubuns2) {
        ztysetaitekihonbubuns2 = pZtysetaitekihonbubuns2;
    }

    private Long ztysetgukitnknitjbrkhns2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETGUKITNKNITJBRKHNS2)
    public Long getZtysetgukitnknitjbrkhns2() {
        return ztysetgukitnknitjbrkhns2;
    }

    public void setZtysetgukitnknitjbrkhns2(Long pZtysetgukitnknitjbrkhns2) {
        ztysetgukitnknitjbrkhns2 = pZtysetgukitnknitjbrkhns2;
    }

    private Long ztysetaitesibous2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESIBOUS2)
    public Long getZtysetaitesibous2() {
        return ztysetaitesibous2;
    }

    public void setZtysetaitesibous2(Long pZtysetaitesibous2) {
        ztysetaitesibous2 = pZtysetaitesibous2;
    }

    private Long ztysetgukitnknitjbrsbus2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETGUKITNKNITJBRSBUS2)
    public Long getZtysetgukitnknitjbrsbus2() {
        return ztysetgukitnknitjbrsbus2;
    }

    public void setZtysetgukitnknitjbrsbus2(Long pZtysetgukitnknitjbrsbus2) {
        ztysetgukitnknitjbrsbus2 = pZtysetgukitnknitjbrsbus2;
    }

    private Long ztysetaitesyuuseis2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESYUUSEIS2)
    public Long getZtysetaitesyuuseis2() {
        return ztysetaitesyuuseis2;
    }

    public void setZtysetaitesyuuseis2(Long pZtysetaitesyuuseis2) {
        ztysetaitesyuuseis2 = pZtysetaitesyuuseis2;
    }

    private Long ztysetaiteharaikomip2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITEHARAIKOMIP2)
    public Long getZtysetaiteharaikomip2() {
        return ztysetaiteharaikomip2;
    }

    public void setZtysetaiteharaikomip2(Long pZtysetaiteharaikomip2) {
        ztysetaiteharaikomip2 = pZtysetaiteharaikomip2;
    }

    private Long ztysetaitesyukeiyakububunp2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESYUKEIYAKUBUBUNP2)
    public Long getZtysetaitesyukeiyakububunp2() {
        return ztysetaitesyukeiyakububunp2;
    }

    public void setZtysetaitesyukeiyakububunp2(Long pZtysetaitesyukeiyakububunp2) {
        ztysetaitesyukeiyakububunp2 = pZtysetaitesyukeiyakububunp2;
    }

    private Long ztysetaitgukikzkmrtis2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITGUKIKZKMRTIS2)
    public Long getZtysetaitgukikzkmrtis2() {
        return ztysetaitgukikzkmrtis2;
    }

    public void setZtysetaitgukikzkmrtis2(Long pZtysetaitgukikzkmrtis2) {
        ztysetaitgukikzkmrtis2 = pZtysetaitgukikzkmrtis2;
    }

    private String ztysetaitetenkankykhyj2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITETENKANKYKHYJ2)
    public String getZtysetaitetenkankykhyj2() {
        return ztysetaitetenkankykhyj2;
    }

    public void setZtysetaitetenkankykhyj2(String pZtysetaitetenkankykhyj2) {
        ztysetaitetenkankykhyj2 = pZtysetaitetenkankykhyj2;
    }

    private Long ztysetaitesiteimhrkp2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESITEIMHRKP2)
    public Long getZtysetaitesiteimhrkp2() {
        return ztysetaitesiteimhrkp2;
    }

    public void setZtysetaitesiteimhrkp2(Long pZtysetaitesiteimhrkp2) {
        ztysetaitesiteimhrkp2 = pZtysetaitesiteimhrkp2;
    }

    private Long ztysetaitesiteimsykykp2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITESITEIMSYKYKP2)
    public Long getZtysetaitesiteimsykykp2() {
        return ztysetaitesiteimsykykp2;
    }

    public void setZtysetaitesiteimsykykp2(Long pZtysetaitesiteimsykykp2) {
        ztysetaitesiteimsykykp2 = pZtysetaitesiteimsykykp2;
    }

    private String ztysetaitenkmrtisyurui2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITENKMRTISYURUI2)
    public String getZtysetaitenkmrtisyurui2() {
        return ztysetaitenkmrtisyurui2;
    }

    public void setZtysetaitenkmrtisyurui2(String pZtysetaitenkmrtisyurui2) {
        ztysetaitenkmrtisyurui2 = pZtysetaitenkmrtisyurui2;
    }

    private String ztysetaitehknkgusdkbn2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSETAITEHKNKGUSDKBN2)
    public String getZtysetaitehknkgusdkbn2() {
        return ztysetaitehknkgusdkbn2;
    }

    public void setZtysetaitehknkgusdkbn2(String pZtysetaitehknkgusdkbn2) {
        ztysetaitehknkgusdkbn2 = pZtysetaitehknkgusdkbn2;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztydujmossitismodsyuguhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDUJMOSSITISMODSYUGUHYJ)
    public String getZtydujmossitismodsyuguhyj() {
        return ztydujmossitismodsyuguhyj;
    }

    public void setZtydujmossitismodsyuguhyj(String pZtydujmossitismodsyuguhyj) {
        ztydujmossitismodsyuguhyj = pZtydujmossitismodsyuguhyj;
    }

    private String ztyrnsijhiyubrijdujmoskbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYRNSIJHIYUBRIJDUJMOSKBN)
    public String getZtyrnsijhiyubrijdujmoskbn() {
        return ztyrnsijhiyubrijdujmoskbn;
    }

    public void setZtyrnsijhiyubrijdujmoskbn(String pZtyrnsijhiyubrijdujmoskbn) {
        ztyrnsijhiyubrijdujmoskbn = pZtyrnsijhiyubrijdujmoskbn;
    }

    private Long ztytktsppisykyktikknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKTSPPISYKYKTIKKNBBNS)
    public Long getZtytktsppisykyktikknbbns() {
        return ztytktsppisykyktikknbbns;
    }

    public void setZtytktsppisykyktikknbbns(Long pZtytktsppisykyktikknbbns) {
        ztytktsppisykyktikknbbns = pZtytktsppisykyktikknbbns;
    }

    private String ztytksttkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKSYURUIKGU)
    public String getZtytksttkyksyuruikgu() {
        return ztytksttkyksyuruikgu;
    }

    public void setZtytksttkyksyuruikgu(String pZtytksttkyksyuruikgu) {
        ztytksttkyksyuruikgu = pZtytksttkyksyuruikgu;
    }

    private String ztytokusitutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOKUSITUTOKUYAKUKIKAN)
    public String getZtytokusitutokuyakukikan() {
        return ztytokusitutokuyakukikan;
    }

    public void setZtytokusitutokuyakukikan(String pZtytokusitutokuyakukikan) {
        ztytokusitutokuyakukikan = pZtytokusitutokuyakukikan;
    }

    private String ztytksttkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKPHRKKKN)
    public String getZtytksttkykphrkkkn() {
        return ztytksttkykphrkkkn;
    }

    public void setZtytksttkykphrkkkn(String pZtytksttkykphrkkkn) {
        ztytksttkykphrkkkn = pZtytksttkykphrkkkn;
    }

    private Long ztytokusitutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOKUSITUTOKUYAKUS)
    public Long getZtytokusitutokuyakus() {
        return ztytokusitutokuyakus;
    }

    public void setZtytokusitutokuyakus(Long pZtytokusitutokuyakus) {
        ztytokusitutokuyakus = pZtytokusitutokuyakus;
    }

    private Long ztytokusitutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOKUSITUTOKUYAKUP)
    public Long getZtytokusitutokuyakup() {
        return ztytokusitutokuyakup;
    }

    public void setZtytokusitutokuyakup(Long pZtytokusitutokuyakup) {
        ztytokusitutokuyakup = pZtytokusitutokuyakup;
    }

    private Long ztytokusitutokuyakusyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOKUSITUTOKUYAKUSYUUSEIS)
    public Long getZtytokusitutokuyakusyuuseis() {
        return ztytokusitutokuyakusyuuseis;
    }

    public void setZtytokusitutokuyakusyuuseis(Long pZtytokusitutokuyakusyuuseis) {
        ztytokusitutokuyakusyuuseis = pZtytokusitutokuyakusyuuseis;
    }

    private String ztytksttkykmodssakugenhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKMODSSAKUGENHYJ)
    public String getZtytksttkykmodssakugenhyj() {
        return ztytksttkykmodssakugenhyj;
    }

    public void setZtytksttkykmodssakugenhyj(String pZtytksttkykmodssakugenhyj) {
        ztytksttkykmodssakugenhyj = pZtytksttkykmodssakugenhyj;
    }

    private String ztytksttkyktkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKTKJYUKBN)
    public String getZtytksttkyktkjyukbn() {
        return ztytksttkyktkjyukbn;
    }

    public void setZtytksttkyktkjyukbn(String pZtytksttkyktkjyukbn) {
        ztytksttkyktkjyukbn = pZtytksttkyktkjyukbn;
    }

    private String ztytksttkyktkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKTKJYUSKGNKKN)
    public String getZtytksttkyktkjyuskgnkkn() {
        return ztytksttkyktkjyuskgnkkn;
    }

    public void setZtytksttkyktkjyuskgnkkn(String pZtytksttkyktkjyuskgnkkn) {
        ztytksttkyktkjyuskgnkkn = pZtytksttkyktkjyuskgnkkn;
    }

    private Integer ztytksttkyktkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKTKJYURYUMSHYUTN)
    public Integer getZtytksttkyktkjyuryumshyutn() {
        return ztytksttkyktkjyuryumshyutn;
    }

    public void setZtytksttkyktkjyuryumshyutn(Integer pZtytksttkyktkjyuryumshyutn) {
        ztytksttkyktkjyuryumshyutn = pZtytksttkyktkjyuryumshyutn;
    }

    private Long ztytksttkyktkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKTKJYUP)
    public Long getZtytksttkyktkjyup() {
        return ztytksttkyktkjyup;
    }

    public void setZtytksttkyktkjyup(Long pZtytksttkyktkjyup) {
        ztytksttkyktkjyup = pZtytksttkyktkjyup;
    }

    private Long ztytksttkyktikknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKTIKKNBBNS)
    public Long getZtytksttkyktikknbbns() {
        return ztytksttkyktikknbbns;
    }

    public void setZtytksttkyktikknbbns(Long pZtytksttkyktikknbbns) {
        ztytksttkyktikknbbns = pZtytksttkyktikknbbns;
    }

    private String ztyhtnkntktsppitkykkgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKTSPPITKYKKGUX1)
    public String getZtyhtnkntktsppitkykkgux1() {
        return ztyhtnkntktsppitkykkgux1;
    }

    public void setZtyhtnkntktsppitkykkgux1(String pZtyhtnkntktsppitkykkgux1) {
        ztyhtnkntktsppitkykkgux1 = pZtyhtnkntktsppitkykkgux1;
    }

    private String ztyhtnkntktsppitkykkgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKTSPPITKYKKGUX2)
    public String getZtyhtnkntktsppitkykkgux2() {
        return ztyhtnkntktsppitkykkgux2;
    }

    public void setZtyhtnkntktsppitkykkgux2(String pZtyhtnkntktsppitkykkgux2) {
        ztyhtnkntktsppitkykkgux2 = pZtyhtnkntktsppitkykkgux2;
    }

    private String ztyhtnkntktsppitkykkgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKTSPPITKYKKGUX3)
    public String getZtyhtnkntktsppitkykkgux3() {
        return ztyhtnkntktsppitkykkgux3;
    }

    public void setZtyhtnkntktsppitkykkgux3(String pZtyhtnkntktsppitkykkgux3) {
        ztyhtnkntktsppitkykkgux3 = pZtyhtnkntktsppitkykkgux3;
    }

    private String ztyhtnkntktsppitkykkgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKTSPPITKYKKGUX4)
    public String getZtyhtnkntktsppitkykkgux4() {
        return ztyhtnkntktsppitkykkgux4;
    }

    public void setZtyhtnkntktsppitkykkgux4(String pZtyhtnkntktsppitkykkgux4) {
        ztyhtnkntktsppitkykkgux4 = pZtyhtnkntktsppitkykkgux4;
    }

    private String ztyhtnkntktsppitkykkgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKTSPPITKYKKGUX5)
    public String getZtyhtnkntktsppitkykkgux5() {
        return ztyhtnkntktsppitkykkgux5;
    }

    public void setZtyhtnkntktsppitkykkgux5(String pZtyhtnkntktsppitkykkgux5) {
        ztyhtnkntktsppitkykkgux5 = pZtyhtnkntktsppitkykkgux5;
    }

    private String ztyhtnkntktsppitkykkgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKTSPPITKYKKGUX6)
    public String getZtyhtnkntktsppitkykkgux6() {
        return ztyhtnkntktsppitkykkgux6;
    }

    public void setZtyhtnkntktsppitkykkgux6(String pZtyhtnkntktsppitkykkgux6) {
        ztyhtnkntktsppitkykkgux6 = pZtyhtnkntktsppitkykkgux6;
    }

    private String ztysuryutksttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURYUTKSTTKYKPWRBKKBN)
    public String getZtysuryutksttkykpwrbkkbn() {
        return ztysuryutksttkykpwrbkkbn;
    }

    public void setZtysuryutksttkykpwrbkkbn(String pZtysuryutksttkykpwrbkkbn) {
        ztysuryutksttkykpwrbkkbn = pZtysuryutksttkykpwrbkkbn;
    }

    private String ztytksttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKPWRBKKBN)
    public String getZtytksttkykpwrbkkbn() {
        return ztytksttkykpwrbkkbn;
    }

    public void setZtytksttkykpwrbkkbn(String pZtytksttkykpwrbkkbn) {
        ztytksttkykpwrbkkbn = pZtytksttkykpwrbkkbn;
    }

    private String ztytksttkyktnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKTNKNYUGUKBN)
    public String getZtytksttkyktnknyugukbn() {
        return ztytksttkyktnknyugukbn;
    }

    public void setZtytksttkyktnknyugukbn(String pZtytksttkyktnknyugukbn) {
        ztytksttkyktnknyugukbn = pZtytksttkyktnknyugukbn;
    }

    private String ztytksttkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTKSTTKYKKGUSDKBN)
    public String getZtytksttkykkgusdkbn() {
        return ztytksttkykkgusdkbn;
    }

    public void setZtytksttkykkgusdkbn(String pZtytksttkykkgusdkbn) {
        ztytksttkykkgusdkbn = pZtytksttkykkgusdkbn;
    }

    private String ztyyobiv9x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV9X8)
    public String getZtyyobiv9x8() {
        return ztyyobiv9x8;
    }

    public void setZtyyobiv9x8(String pZtyyobiv9x8) {
        ztyyobiv9x8 = pZtyyobiv9x8;
    }

    private String ztydi2tksttkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKSYRIKGU)
    public String getZtydi2tksttkyksyrikgu() {
        return ztydi2tksttkyksyrikgu;
    }

    public void setZtydi2tksttkyksyrikgu(String pZtydi2tksttkyksyrikgu) {
        ztydi2tksttkyksyrikgu = pZtydi2tksttkyksyrikgu;
    }

    private String ztydai2tokusitutokuyakukkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TOKUSITUTOKUYAKUKKN)
    public String getZtydai2tokusitutokuyakukkn() {
        return ztydai2tokusitutokuyakukkn;
    }

    public void setZtydai2tokusitutokuyakukkn(String pZtydai2tokusitutokuyakukkn) {
        ztydai2tokusitutokuyakukkn = pZtydai2tokusitutokuyakukkn;
    }

    private String ztydai2tksttkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TKSTTKYKPHRKKKN)
    public String getZtydai2tksttkykphrkkkn() {
        return ztydai2tksttkykphrkkkn;
    }

    public void setZtydai2tksttkykphrkkkn(String pZtydai2tksttkykphrkkkn) {
        ztydai2tksttkykphrkkkn = pZtydai2tksttkykphrkkkn;
    }

    private Long ztydai2tokusitutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TOKUSITUTOKUYAKUS)
    public Long getZtydai2tokusitutokuyakus() {
        return ztydai2tokusitutokuyakus;
    }

    public void setZtydai2tokusitutokuyakus(Long pZtydai2tokusitutokuyakus) {
        ztydai2tokusitutokuyakus = pZtydai2tokusitutokuyakus;
    }

    private Long ztydai2tokusitutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TOKUSITUTOKUYAKUP)
    public Long getZtydai2tokusitutokuyakup() {
        return ztydai2tokusitutokuyakup;
    }

    public void setZtydai2tokusitutokuyakup(Long pZtydai2tokusitutokuyakup) {
        ztydai2tokusitutokuyakup = pZtydai2tokusitutokuyakup;
    }

    private Long ztydi2tksttkyksyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKSYUUSEIS)
    public Long getZtydi2tksttkyksyuuseis() {
        return ztydi2tksttkyksyuuseis;
    }

    public void setZtydi2tksttkyksyuuseis(Long pZtydi2tksttkyksyuuseis) {
        ztydi2tksttkyksyuuseis = pZtydi2tksttkyksyuuseis;
    }

    private String ztydi2tksttkykmodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKMODSSKGNHYJ)
    public String getZtydi2tksttkykmodsskgnhyj() {
        return ztydi2tksttkykmodsskgnhyj;
    }

    public void setZtydi2tksttkykmodsskgnhyj(String pZtydi2tksttkykmodsskgnhyj) {
        ztydi2tksttkykmodsskgnhyj = pZtydi2tksttkykmodsskgnhyj;
    }

    private String ztydi2tksttkyktkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKTKJYUKBN)
    public String getZtydi2tksttkyktkjyukbn() {
        return ztydi2tksttkyktkjyukbn;
    }

    public void setZtydi2tksttkyktkjyukbn(String pZtydi2tksttkyktkjyukbn) {
        ztydi2tksttkyktkjyukbn = pZtydi2tksttkyktkjyukbn;
    }

    private String ztydi2tksttkyktkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKTKJYUSKGNKKN)
    public String getZtydi2tksttkyktkjyuskgnkkn() {
        return ztydi2tksttkyktkjyuskgnkkn;
    }

    public void setZtydi2tksttkyktkjyuskgnkkn(String pZtydi2tksttkyktkjyuskgnkkn) {
        ztydi2tksttkyktkjyuskgnkkn = pZtydi2tksttkyktkjyuskgnkkn;
    }

    private Integer ztydi2tksttkyktkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKTKJYURYMSHYTN)
    public Integer getZtydi2tksttkyktkjyurymshytn() {
        return ztydi2tksttkyktkjyurymshytn;
    }

    public void setZtydi2tksttkyktkjyurymshytn(Integer pZtydi2tksttkyktkjyurymshytn) {
        ztydi2tksttkyktkjyurymshytn = pZtydi2tksttkyktkjyurymshytn;
    }

    private Long ztydi2tksttkyktkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKTKJYUP)
    public Long getZtydi2tksttkyktkjyup() {
        return ztydi2tksttkyktkjyup;
    }

    public void setZtydi2tksttkyktkjyup(Long pZtydi2tksttkyktkjyup) {
        ztydi2tksttkyktkjyup = pZtydi2tksttkyktkjyup;
    }

    private Long ztydi2tksttkyktaikknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKTAIKKNBBNS)
    public Long getZtydi2tksttkyktaikknbbns() {
        return ztydi2tksttkyktaikknbbns;
    }

    public void setZtydi2tksttkyktaikknbbns(Long pZtydi2tksttkyktaikknbbns) {
        ztydi2tksttkyktaikknbbns = pZtydi2tksttkyktaikknbbns;
    }

    private String ztyhtnkndi2tktsppitkykkgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKTSPPITKYKKGUX1)
    public String getZtyhtnkndi2tktsppitkykkgux1() {
        return ztyhtnkndi2tktsppitkykkgux1;
    }

    public void setZtyhtnkndi2tktsppitkykkgux1(String pZtyhtnkndi2tktsppitkykkgux1) {
        ztyhtnkndi2tktsppitkykkgux1 = pZtyhtnkndi2tktsppitkykkgux1;
    }

    private String ztyhtnkndi2tktsppitkykkgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKTSPPITKYKKGUX2)
    public String getZtyhtnkndi2tktsppitkykkgux2() {
        return ztyhtnkndi2tktsppitkykkgux2;
    }

    public void setZtyhtnkndi2tktsppitkykkgux2(String pZtyhtnkndi2tktsppitkykkgux2) {
        ztyhtnkndi2tktsppitkykkgux2 = pZtyhtnkndi2tktsppitkykkgux2;
    }

    private String ztyhtnkndi2tktsppitkykkgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKTSPPITKYKKGUX3)
    public String getZtyhtnkndi2tktsppitkykkgux3() {
        return ztyhtnkndi2tktsppitkykkgux3;
    }

    public void setZtyhtnkndi2tktsppitkykkgux3(String pZtyhtnkndi2tktsppitkykkgux3) {
        ztyhtnkndi2tktsppitkykkgux3 = pZtyhtnkndi2tktsppitkykkgux3;
    }

    private String ztyhtnkndi2tktsppitkykkgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKTSPPITKYKKGUX4)
    public String getZtyhtnkndi2tktsppitkykkgux4() {
        return ztyhtnkndi2tktsppitkykkgux4;
    }

    public void setZtyhtnkndi2tktsppitkykkgux4(String pZtyhtnkndi2tktsppitkykkgux4) {
        ztyhtnkndi2tktsppitkykkgux4 = pZtyhtnkndi2tktsppitkykkgux4;
    }

    private String ztyhtnkndi2tktsppitkykkgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKTSPPITKYKKGUX5)
    public String getZtyhtnkndi2tktsppitkykkgux5() {
        return ztyhtnkndi2tktsppitkykkgux5;
    }

    public void setZtyhtnkndi2tktsppitkykkgux5(String pZtyhtnkndi2tktsppitkykkgux5) {
        ztyhtnkndi2tktsppitkykkgux5 = pZtyhtnkndi2tktsppitkykkgux5;
    }

    private String ztyhtnkndi2tktsppitkykkgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKTSPPITKYKKGUX6)
    public String getZtyhtnkndi2tktsppitkykkgux6() {
        return ztyhtnkndi2tktsppitkykkgux6;
    }

    public void setZtyhtnkndi2tktsppitkykkgux6(String pZtyhtnkndi2tktsppitkykkgux6) {
        ztyhtnkndi2tktsppitkykkgux6 = pZtyhtnkndi2tktsppitkykkgux6;
    }

    private String ztysuryudi2tksttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURYUDI2TKSTTKYKPWRBKKBN)
    public String getZtysuryudi2tksttkykpwrbkkbn() {
        return ztysuryudi2tksttkykpwrbkkbn;
    }

    public void setZtysuryudi2tksttkykpwrbkkbn(String pZtysuryudi2tksttkykpwrbkkbn) {
        ztysuryudi2tksttkykpwrbkkbn = pZtysuryudi2tksttkykpwrbkkbn;
    }

    private String ztydi2tksttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKPWRBKKBN)
    public String getZtydi2tksttkykpwrbkkbn() {
        return ztydi2tksttkykpwrbkkbn;
    }

    public void setZtydi2tksttkykpwrbkkbn(String pZtydi2tksttkykpwrbkkbn) {
        ztydi2tksttkykpwrbkkbn = pZtydi2tksttkykpwrbkkbn;
    }

    private String ztydi2tksttkyktnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKTNKNYUGUKBN)
    public String getZtydi2tksttkyktnknyugukbn() {
        return ztydi2tksttkyktnknyugukbn;
    }

    public void setZtydi2tksttkyktnknyugukbn(String pZtydi2tksttkyktnknyugukbn) {
        ztydi2tksttkyktnknyugukbn = pZtydi2tksttkyktnknyugukbn;
    }

    private String ztydi2tksttkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2TKSTTKYKKGUSDKBN)
    public String getZtydi2tksttkykkgusdkbn() {
        return ztydi2tksttkykkgusdkbn;
    }

    public void setZtydi2tksttkykkgusdkbn(String pZtydi2tksttkykkgusdkbn) {
        ztydi2tksttkykkgusdkbn = pZtydi2tksttkykkgusdkbn;
    }

    private String ztyyobiv9x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV9X9)
    public String getZtyyobiv9x9() {
        return ztyyobiv9x9;
    }

    public void setZtyyobiv9x9(String pZtyyobiv9x9) {
        ztyyobiv9x9 = pZtyyobiv9x9;
    }

    private String ztyjyuusitutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKSYURUIKGU)
    public String getZtyjyuusitutkyksyuruikgu() {
        return ztyjyuusitutkyksyuruikgu;
    }

    public void setZtyjyuusitutkyksyuruikgu(String pZtyjyuusitutkyksyuruikgu) {
        ztyjyuusitutkyksyuruikgu = pZtyjyuusitutkyksyuruikgu;
    }

    private String ztyjyuusitutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTOKUYAKUKIKAN)
    public String getZtyjyuusitutokuyakukikan() {
        return ztyjyuusitutokuyakukikan;
    }

    public void setZtyjyuusitutokuyakukikan(String pZtyjyuusitutokuyakukikan) {
        ztyjyuusitutokuyakukikan = pZtyjyuusitutokuyakukikan;
    }

    private String ztyjyuusitutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKPHRKKKN)
    public String getZtyjyuusitutkykphrkkkn() {
        return ztyjyuusitutkykphrkkkn;
    }

    public void setZtyjyuusitutkykphrkkkn(String pZtyjyuusitutkykphrkkkn) {
        ztyjyuusitutkykphrkkkn = pZtyjyuusitutkykphrkkkn;
    }

    private Long ztyjyuusitutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTOKUYAKUS)
    public Long getZtyjyuusitutokuyakus() {
        return ztyjyuusitutokuyakus;
    }

    public void setZtyjyuusitutokuyakus(Long pZtyjyuusitutokuyakus) {
        ztyjyuusitutokuyakus = pZtyjyuusitutokuyakus;
    }

    private Long ztyjyuusitutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTOKUYAKUP)
    public Long getZtyjyuusitutokuyakup() {
        return ztyjyuusitutokuyakup;
    }

    public void setZtyjyuusitutokuyakup(Long pZtyjyuusitutokuyakup) {
        ztyjyuusitutokuyakup = pZtyjyuusitutokuyakup;
    }

    private Long ztyjyuusitutokuyakusyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTOKUYAKUSYUUSEIS)
    public Long getZtyjyuusitutokuyakusyuuseis() {
        return ztyjyuusitutokuyakusyuuseis;
    }

    public void setZtyjyuusitutokuyakusyuuseis(Long pZtyjyuusitutokuyakusyuuseis) {
        ztyjyuusitutokuyakusyuuseis = pZtyjyuusitutokuyakusyuuseis;
    }

    private String ztyjyuusitutkykmodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKMODSSKGNHYJ)
    public String getZtyjyuusitutkykmodsskgnhyj() {
        return ztyjyuusitutkykmodsskgnhyj;
    }

    public void setZtyjyuusitutkykmodsskgnhyj(String pZtyjyuusitutkykmodsskgnhyj) {
        ztyjyuusitutkykmodsskgnhyj = pZtyjyuusitutkykmodsskgnhyj;
    }

    private String ztyjyuusitutkyktkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKTKJYUKBN)
    public String getZtyjyuusitutkyktkjyukbn() {
        return ztyjyuusitutkyktkjyukbn;
    }

    public void setZtyjyuusitutkyktkjyukbn(String pZtyjyuusitutkyktkjyukbn) {
        ztyjyuusitutkyktkjyukbn = pZtyjyuusitutkyktkjyukbn;
    }

    private String ztyjyuusitutkyktkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKTKJYUSKGNKKN)
    public String getZtyjyuusitutkyktkjyuskgnkkn() {
        return ztyjyuusitutkyktkjyuskgnkkn;
    }

    public void setZtyjyuusitutkyktkjyuskgnkkn(String pZtyjyuusitutkyktkjyuskgnkkn) {
        ztyjyuusitutkyktkjyuskgnkkn = pZtyjyuusitutkyktkjyuskgnkkn;
    }

    private Integer ztyjyusttkyktkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUSTTKYKTKJYURYUMSHYUTN)
    public Integer getZtyjyusttkyktkjyuryumshyutn() {
        return ztyjyusttkyktkjyuryumshyutn;
    }

    public void setZtyjyusttkyktkjyuryumshyutn(Integer pZtyjyusttkyktkjyuryumshyutn) {
        ztyjyusttkyktkjyuryumshyutn = pZtyjyusttkyktkjyuryumshyutn;
    }

    private Long ztyjyuusitutkyktkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKTKJYUP)
    public Long getZtyjyuusitutkyktkjyup() {
        return ztyjyuusitutkyktkjyup;
    }

    public void setZtyjyuusitutkyktkjyup(Long pZtyjyuusitutkyktkjyup) {
        ztyjyuusitutkyktkjyup = pZtyjyuusitutkyktkjyup;
    }

    private String ztyjyuusitutkyktktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKTKTBICDX1)
    public String getZtyjyuusitutkyktktbicdx1() {
        return ztyjyuusitutkyktktbicdx1;
    }

    public void setZtyjyuusitutkyktktbicdx1(String pZtyjyuusitutkyktktbicdx1) {
        ztyjyuusitutkyktktbicdx1 = pZtyjyuusitutkyktktbicdx1;
    }

    private String ztyjyuusitutkykhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKHTNPKKNX1)
    public String getZtyjyuusitutkykhtnpkknx1() {
        return ztyjyuusitutkykhtnpkknx1;
    }

    public void setZtyjyuusitutkykhtnpkknx1(String pZtyjyuusitutkykhtnpkknx1) {
        ztyjyuusitutkykhtnpkknx1 = pZtyjyuusitutkykhtnpkknx1;
    }

    private String ztyjyuusitutkyktktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKTKTBICDX2)
    public String getZtyjyuusitutkyktktbicdx2() {
        return ztyjyuusitutkyktktbicdx2;
    }

    public void setZtyjyuusitutkyktktbicdx2(String pZtyjyuusitutkyktktbicdx2) {
        ztyjyuusitutkyktktbicdx2 = pZtyjyuusitutkyktktbicdx2;
    }

    private String ztyjyuusitutkykhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKHTNPKKNX2)
    public String getZtyjyuusitutkykhtnpkknx2() {
        return ztyjyuusitutkykhtnpkknx2;
    }

    public void setZtyjyuusitutkykhtnpkknx2(String pZtyjyuusitutkykhtnpkknx2) {
        ztyjyuusitutkykhtnpkknx2 = pZtyjyuusitutkykhtnpkknx2;
    }

    private String ztyhtnknmnsiskkntkykkgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMNSISKKNTKYKKGUX1)
    public String getZtyhtnknmnsiskkntkykkgux1() {
        return ztyhtnknmnsiskkntkykkgux1;
    }

    public void setZtyhtnknmnsiskkntkykkgux1(String pZtyhtnknmnsiskkntkykkgux1) {
        ztyhtnknmnsiskkntkykkgux1 = pZtyhtnknmnsiskkntkykkgux1;
    }

    private String ztyhtnknmnsiskkntkykkgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMNSISKKNTKYKKGUX2)
    public String getZtyhtnknmnsiskkntkykkgux2() {
        return ztyhtnknmnsiskkntkykkgux2;
    }

    public void setZtyhtnknmnsiskkntkykkgux2(String pZtyhtnknmnsiskkntkykkgux2) {
        ztyhtnknmnsiskkntkykkgux2 = pZtyhtnknmnsiskkntkykkgux2;
    }

    private String ztyhtnknmnsiskkntkykkgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMNSISKKNTKYKKGUX3)
    public String getZtyhtnknmnsiskkntkykkgux3() {
        return ztyhtnknmnsiskkntkykkgux3;
    }

    public void setZtyhtnknmnsiskkntkykkgux3(String pZtyhtnknmnsiskkntkykkgux3) {
        ztyhtnknmnsiskkntkykkgux3 = pZtyhtnknmnsiskkntkykkgux3;
    }

    private String ztyhtnknmnsiskkntkykkgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMNSISKKNTKYKKGUX4)
    public String getZtyhtnknmnsiskkntkykkgux4() {
        return ztyhtnknmnsiskkntkykkgux4;
    }

    public void setZtyhtnknmnsiskkntkykkgux4(String pZtyhtnknmnsiskkntkykkgux4) {
        ztyhtnknmnsiskkntkykkgux4 = pZtyhtnknmnsiskkntkykkgux4;
    }

    private String ztyhtnknmnsiskkntkykkgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMNSISKKNTKYKKGUX5)
    public String getZtyhtnknmnsiskkntkykkgux5() {
        return ztyhtnknmnsiskkntkykkgux5;
    }

    public void setZtyhtnknmnsiskkntkykkgux5(String pZtyhtnknmnsiskkntkykkgux5) {
        ztyhtnknmnsiskkntkykkgux5 = pZtyhtnknmnsiskkntkykkgux5;
    }

    private String ztyhtnknmnsiskkntkykkgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMNSISKKNTKYKKGUX6)
    public String getZtyhtnknmnsiskkntkykkgux6() {
        return ztyhtnknmnsiskkntkykkgux6;
    }

    public void setZtyhtnknmnsiskkntkykkgux6(String pZtyhtnknmnsiskkntkykkgux6) {
        ztyhtnknmnsiskkntkykkgux6 = pZtyhtnknmnsiskkntkykkgux6;
    }

    private String ztysuryujyusttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURYUJYUSTTKYKPWRBKKBN)
    public String getZtysuryujyusttkykpwrbkkbn() {
        return ztysuryujyusttkykpwrbkkbn;
    }

    public void setZtysuryujyusttkykpwrbkkbn(String pZtysuryujyusttkykpwrbkkbn) {
        ztysuryujyusttkykpwrbkkbn = pZtysuryujyusttkykpwrbkkbn;
    }

    private String ztyjyuusitutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKPWRBKKBN)
    public String getZtyjyuusitutkykpwrbkkbn() {
        return ztyjyuusitutkykpwrbkkbn;
    }

    public void setZtyjyuusitutkykpwrbkkbn(String pZtyjyuusitutkykpwrbkkbn) {
        ztyjyuusitutkykpwrbkkbn = pZtyjyuusitutkykpwrbkkbn;
    }

    private String ztyjyuusitutkyktnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKTNKNYUGUKBN)
    public String getZtyjyuusitutkyktnknyugukbn() {
        return ztyjyuusitutkyktnknyugukbn;
    }

    public void setZtyjyuusitutkyktnknyugukbn(String pZtyjyuusitutkyktnknyugukbn) {
        ztyjyuusitutkyktnknyugukbn = pZtyjyuusitutkyktnknyugukbn;
    }

    private String ztyjyuusitutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJYUUSITUTKYKKGUSDKBN)
    public String getZtyjyuusitutkykkgusdkbn() {
        return ztyjyuusitutkykkgusdkbn;
    }

    public void setZtyjyuusitutkykkgusdkbn(String pZtyjyuusitutkykkgusdkbn) {
        ztyjyuusitutkykkgusdkbn = pZtyjyuusitutkykkgusdkbn;
    }

    private String ztyyobiv7x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV7X3)
    public String getZtyyobiv7x3() {
        return ztyyobiv7x3;
    }

    public void setZtyyobiv7x3(String pZtyyobiv7x3) {
        ztyyobiv7x3 = pZtyyobiv7x3;
    }

    private String ztydi2jyuusitutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKSYRIKGU)
    public String getZtydi2jyuusitutkyksyrikgu() {
        return ztydi2jyuusitutkyksyrikgu;
    }

    public void setZtydi2jyuusitutkyksyrikgu(String pZtydi2jyuusitutkyksyrikgu) {
        ztydi2jyuusitutkyksyrikgu = pZtydi2jyuusitutkyksyrikgu;
    }

    private String ztydi2jyuusitutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKKKN)
    public String getZtydi2jyuusitutkykkkn() {
        return ztydi2jyuusitutkykkkn;
    }

    public void setZtydi2jyuusitutkykkkn(String pZtydi2jyuusitutkykkkn) {
        ztydi2jyuusitutkykkkn = pZtydi2jyuusitutkykkkn;
    }

    private String ztydi2jyuusitutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKPHRKKKN)
    public String getZtydi2jyuusitutkykphrkkkn() {
        return ztydi2jyuusitutkykphrkkkn;
    }

    public void setZtydi2jyuusitutkykphrkkkn(String pZtydi2jyuusitutkykphrkkkn) {
        ztydi2jyuusitutkykphrkkkn = pZtydi2jyuusitutkykphrkkkn;
    }

    private Long ztydai2jyuusitutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2JYUUSITUTOKUYAKUS)
    public Long getZtydai2jyuusitutokuyakus() {
        return ztydai2jyuusitutokuyakus;
    }

    public void setZtydai2jyuusitutokuyakus(Long pZtydai2jyuusitutokuyakus) {
        ztydai2jyuusitutokuyakus = pZtydai2jyuusitutokuyakus;
    }

    private Long ztydai2jyuusitutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2JYUUSITUTOKUYAKUP)
    public Long getZtydai2jyuusitutokuyakup() {
        return ztydai2jyuusitutokuyakup;
    }

    public void setZtydai2jyuusitutokuyakup(Long pZtydai2jyuusitutokuyakup) {
        ztydai2jyuusitutokuyakup = pZtydai2jyuusitutokuyakup;
    }

    private Long ztydi2jyuusitutkyksyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKSYUUSEIS)
    public Long getZtydi2jyuusitutkyksyuuseis() {
        return ztydi2jyuusitutkyksyuuseis;
    }

    public void setZtydi2jyuusitutkyksyuuseis(Long pZtydi2jyuusitutkyksyuuseis) {
        ztydi2jyuusitutkyksyuuseis = pZtydi2jyuusitutkyksyuuseis;
    }

    private String ztydi2jyusttkykmodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUSTTKYKMODSSKGNHYJ)
    public String getZtydi2jyusttkykmodsskgnhyj() {
        return ztydi2jyusttkykmodsskgnhyj;
    }

    public void setZtydi2jyusttkykmodsskgnhyj(String pZtydi2jyusttkykmodsskgnhyj) {
        ztydi2jyusttkykmodsskgnhyj = pZtydi2jyusttkykmodsskgnhyj;
    }

    private String ztydi2jyuusitutkyktkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKTKJYUKBN)
    public String getZtydi2jyuusitutkyktkjyukbn() {
        return ztydi2jyuusitutkyktkjyukbn;
    }

    public void setZtydi2jyuusitutkyktkjyukbn(String pZtydi2jyuusitutkyktkjyukbn) {
        ztydi2jyuusitutkyktkjyukbn = pZtydi2jyuusitutkyktkjyukbn;
    }

    private String ztydi2jyusttkyktkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUSTTKYKTKJYUSKGNKKN)
    public String getZtydi2jyusttkyktkjyuskgnkkn() {
        return ztydi2jyusttkyktkjyuskgnkkn;
    }

    public void setZtydi2jyusttkyktkjyuskgnkkn(String pZtydi2jyusttkyktkjyuskgnkkn) {
        ztydi2jyusttkyktkjyuskgnkkn = pZtydi2jyusttkyktkjyuskgnkkn;
    }

    private Integer ztydi2jyusttkyktkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUSTTKYKTKJYRYMSHYTN)
    public Integer getZtydi2jyusttkyktkjyrymshytn() {
        return ztydi2jyusttkyktkjyrymshytn;
    }

    public void setZtydi2jyusttkyktkjyrymshytn(Integer pZtydi2jyusttkyktkjyrymshytn) {
        ztydi2jyusttkyktkjyrymshytn = pZtydi2jyusttkyktkjyrymshytn;
    }

    private Long ztydi2jyuusitutkyktkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKTKJYUP)
    public Long getZtydi2jyuusitutkyktkjyup() {
        return ztydi2jyuusitutkyktkjyup;
    }

    public void setZtydi2jyuusitutkyktkjyup(Long pZtydi2jyuusitutkyktkjyup) {
        ztydi2jyuusitutkyktkjyup = pZtydi2jyuusitutkyktkjyup;
    }

    private String ztydi2jyuusitutkyktktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKTKTBICDX1)
    public String getZtydi2jyuusitutkyktktbicdx1() {
        return ztydi2jyuusitutkyktktbicdx1;
    }

    public void setZtydi2jyuusitutkyktktbicdx1(String pZtydi2jyuusitutkyktktbicdx1) {
        ztydi2jyuusitutkyktktbicdx1 = pZtydi2jyuusitutkyktktbicdx1;
    }

    private String ztydi2jyuusitutkykhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKHTNPKKNX1)
    public String getZtydi2jyuusitutkykhtnpkknx1() {
        return ztydi2jyuusitutkykhtnpkknx1;
    }

    public void setZtydi2jyuusitutkykhtnpkknx1(String pZtydi2jyuusitutkykhtnpkknx1) {
        ztydi2jyuusitutkykhtnpkknx1 = pZtydi2jyuusitutkykhtnpkknx1;
    }

    private String ztydi2jyuusitutkyktktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKTKTBICDX2)
    public String getZtydi2jyuusitutkyktktbicdx2() {
        return ztydi2jyuusitutkyktktbicdx2;
    }

    public void setZtydi2jyuusitutkyktktbicdx2(String pZtydi2jyuusitutkyktktbicdx2) {
        ztydi2jyuusitutkyktktbicdx2 = pZtydi2jyuusitutkyktktbicdx2;
    }

    private String ztydi2jyuusitutkykhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKHTNPKKNX2)
    public String getZtydi2jyuusitutkykhtnpkknx2() {
        return ztydi2jyuusitutkykhtnpkknx2;
    }

    public void setZtydi2jyuusitutkykhtnpkknx2(String pZtydi2jyuusitutkykhtnpkknx2) {
        ztydi2jyuusitutkykhtnpkknx2 = pZtydi2jyuusitutkykhtnpkknx2;
    }

    private String ztyhtnkndi2mnsiskkntkykkgx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2MNSISKKNTKYKKGX1)
    public String getZtyhtnkndi2mnsiskkntkykkgx1() {
        return ztyhtnkndi2mnsiskkntkykkgx1;
    }

    public void setZtyhtnkndi2mnsiskkntkykkgx1(String pZtyhtnkndi2mnsiskkntkykkgx1) {
        ztyhtnkndi2mnsiskkntkykkgx1 = pZtyhtnkndi2mnsiskkntkykkgx1;
    }

    private String ztyhtnkndi2mnsiskkntkykkgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2MNSISKKNTKYKKGX2)
    public String getZtyhtnkndi2mnsiskkntkykkgx2() {
        return ztyhtnkndi2mnsiskkntkykkgx2;
    }

    public void setZtyhtnkndi2mnsiskkntkykkgx2(String pZtyhtnkndi2mnsiskkntkykkgx2) {
        ztyhtnkndi2mnsiskkntkykkgx2 = pZtyhtnkndi2mnsiskkntkykkgx2;
    }

    private String ztyhtnkndi2mnsiskkntkykkgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2MNSISKKNTKYKKGX3)
    public String getZtyhtnkndi2mnsiskkntkykkgx3() {
        return ztyhtnkndi2mnsiskkntkykkgx3;
    }

    public void setZtyhtnkndi2mnsiskkntkykkgx3(String pZtyhtnkndi2mnsiskkntkykkgx3) {
        ztyhtnkndi2mnsiskkntkykkgx3 = pZtyhtnkndi2mnsiskkntkykkgx3;
    }

    private String ztyhtnkndi2mnsiskkntkykkgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2MNSISKKNTKYKKGX4)
    public String getZtyhtnkndi2mnsiskkntkykkgx4() {
        return ztyhtnkndi2mnsiskkntkykkgx4;
    }

    public void setZtyhtnkndi2mnsiskkntkykkgx4(String pZtyhtnkndi2mnsiskkntkykkgx4) {
        ztyhtnkndi2mnsiskkntkykkgx4 = pZtyhtnkndi2mnsiskkntkykkgx4;
    }

    private String ztyhtnkndi2mnsiskkntkykkgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2MNSISKKNTKYKKGX5)
    public String getZtyhtnkndi2mnsiskkntkykkgx5() {
        return ztyhtnkndi2mnsiskkntkykkgx5;
    }

    public void setZtyhtnkndi2mnsiskkntkykkgx5(String pZtyhtnkndi2mnsiskkntkykkgx5) {
        ztyhtnkndi2mnsiskkntkykkgx5 = pZtyhtnkndi2mnsiskkntkykkgx5;
    }

    private String ztyhtnkndi2mnsiskkntkykkgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2MNSISKKNTKYKKGX6)
    public String getZtyhtnkndi2mnsiskkntkykkgx6() {
        return ztyhtnkndi2mnsiskkntkykkgx6;
    }

    public void setZtyhtnkndi2mnsiskkntkykkgx6(String pZtyhtnkndi2mnsiskkntkykkgx6) {
        ztyhtnkndi2mnsiskkntkykkgx6 = pZtyhtnkndi2mnsiskkntkykkgx6;
    }

    private String ztysuryud2jyusttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURYUD2JYUSTTKYKPWRBKKBN)
    public String getZtysuryud2jyusttkykpwrbkkbn() {
        return ztysuryud2jyusttkykpwrbkkbn;
    }

    public void setZtysuryud2jyusttkykpwrbkkbn(String pZtysuryud2jyusttkykpwrbkkbn) {
        ztysuryud2jyusttkykpwrbkkbn = pZtysuryud2jyusttkykpwrbkkbn;
    }

    private String ztydi2jyuusitutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKPWRBKKBN)
    public String getZtydi2jyuusitutkykpwrbkkbn() {
        return ztydi2jyuusitutkykpwrbkkbn;
    }

    public void setZtydi2jyuusitutkykpwrbkkbn(String pZtydi2jyuusitutkykpwrbkkbn) {
        ztydi2jyuusitutkykpwrbkkbn = pZtydi2jyuusitutkykpwrbkkbn;
    }

    private String ztydi2jyusttkyktnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUSTTKYKTNKNYUGUKBN)
    public String getZtydi2jyusttkyktnknyugukbn() {
        return ztydi2jyusttkyktnknyugukbn;
    }

    public void setZtydi2jyusttkyktnknyugukbn(String pZtydi2jyusttkyktnknyugukbn) {
        ztydi2jyusttkyktnknyugukbn = pZtydi2jyusttkyktnknyugukbn;
    }

    private String ztydi2jyuusitutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2JYUUSITUTKYKKGUSDKBN)
    public String getZtydi2jyuusitutkykkgusdkbn() {
        return ztydi2jyuusitutkykkgusdkbn;
    }

    public void setZtydi2jyuusitutkykkgusdkbn(String pZtydi2jyuusitutkykkgusdkbn) {
        ztydi2jyuusitutkykkgusdkbn = pZtydi2jyuusitutkykkgusdkbn;
    }

    private String ztyyobiv7x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV7X4)
    public String getZtyyobiv7x4() {
        return ztyyobiv7x4;
    }

    public void setZtyyobiv7x4(String pZtyyobiv7x4) {
        ztyyobiv7x4 = pZtyyobiv7x4;
    }

    private String ztyhaitousiharaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHAITOUSIHARAIKBN)
    public String getZtyhaitousiharaikbn() {
        return ztyhaitousiharaikbn;
    }

    public void setZtyhaitousiharaikbn(String pZtyhaitousiharaikbn) {
        ztyhaitousiharaikbn = pZtyhaitousiharaikbn;
    }

    private String ztysuryusykykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURYUSYKYKPWRBKKBN)
    public String getZtysuryusykykpwrbkkbn() {
        return ztysuryusykykpwrbkkbn;
    }

    public void setZtysuryusykykpwrbkkbn(String pZtysuryusykykpwrbkkbn) {
        ztysuryusykykpwrbkkbn = pZtysuryusykykpwrbkkbn;
    }

    private String ztynkdatetokuteisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEISYURUIKGU)
    public String getZtynkdatetokuteisyuruikgu() {
        return ztynkdatetokuteisyuruikgu;
    }

    public void setZtynkdatetokuteisyuruikgu(String pZtynkdatetokuteisyuruikgu) {
        ztynkdatetokuteisyuruikgu = pZtynkdatetokuteisyuruikgu;
    }

    private String ztynenkindatetokuteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATETOKUTEIKIKAN)
    public String getZtynenkindatetokuteikikan() {
        return ztynenkindatetokuteikikan;
    }

    public void setZtynenkindatetokuteikikan(String pZtynenkindatetokuteikikan) {
        ztynenkindatetokuteikikan = pZtynenkindatetokuteikikan;
    }

    private Long ztynkdatetokuteinkgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEINKGK)
    public Long getZtynkdatetokuteinkgk() {
        return ztynkdatetokuteinkgk;
    }

    public void setZtynkdatetokuteinkgk(Long pZtynkdatetokuteinkgk) {
        ztynkdatetokuteinkgk = pZtynkdatetokuteinkgk;
    }

    private Long ztynenkindatetokuteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATETOKUTEIS)
    public Long getZtynenkindatetokuteis() {
        return ztynenkindatetokuteis;
    }

    public void setZtynenkindatetokuteis(Long pZtynenkindatetokuteis) {
        ztynenkindatetokuteis = pZtynenkindatetokuteis;
    }

    private Long ztynenkindatetokuteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATETOKUTEIP)
    public Long getZtynenkindatetokuteip() {
        return ztynenkindatetokuteip;
    }

    public void setZtynenkindatetokuteip(Long pZtynenkindatetokuteip) {
        ztynenkindatetokuteip = pZtynenkindatetokuteip;
    }

    private String ztynkdatetokuteisdtpdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEISDTPDTKBN)
    public String getZtynkdatetokuteisdtpdtkbn() {
        return ztynkdatetokuteisdtpdtkbn;
    }

    public void setZtynkdatetokuteisdtpdtkbn(String pZtynkdatetokuteisdtpdtkbn) {
        ztynkdatetokuteisdtpdtkbn = pZtynkdatetokuteisdtpdtkbn;
    }

    private Long ztynkdatetokuteimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEIMODS)
    public Long getZtynkdatetokuteimods() {
        return ztynkdatetokuteimods;
    }

    public void setZtynkdatetokuteimods(Long pZtynkdatetokuteimods) {
        ztynkdatetokuteimods = pZtynkdatetokuteimods;
    }

    private String ztynkdatetokuteimodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEIMODSSKGNHYJ)
    public String getZtynkdatetokuteimodsskgnhyj() {
        return ztynkdatetokuteimodsskgnhyj;
    }

    public void setZtynkdatetokuteimodsskgnhyj(String pZtynkdatetokuteimodsskgnhyj) {
        ztynkdatetokuteimodsskgnhyj = pZtynkdatetokuteimodsskgnhyj;
    }

    private String ztynkdatetokuteishrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEISHRKKN)
    public String getZtynkdatetokuteishrkkn() {
        return ztynkdatetokuteishrkkn;
    }

    public void setZtynkdatetokuteishrkkn(String pZtynkdatetokuteishrkkn) {
        ztynkdatetokuteishrkkn = pZtynkdatetokuteishrkkn;
    }

    private String ztykykniyutksytioukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKYKNIYUTKSYTIOUKBN)
    public String getZtykykniyutksytioukbn() {
        return ztykykniyutksytioukbn;
    }

    public void setZtykykniyutksytioukbn(String pZtykykniyutksytioukbn) {
        ztykykniyutksytioukbn = pZtykykniyutksytioukbn;
    }

    private String ztykeika2nenmimantenkanhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKEIKA2NENMIMANTENKANHYJ)
    public String getZtykeika2nenmimantenkanhyj() {
        return ztykeika2nenmimantenkanhyj;
    }

    public void setZtykeika2nenmimantenkanhyj(String pZtykeika2nenmimantenkanhyj) {
        ztykeika2nenmimantenkanhyj = pZtykeika2nenmimantenkanhyj;
    }

    private String ztytukiyuhtnknkusnmennsukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUKIYUHTNKNKUSNMENNSUKBN)
    public String getZtytukiyuhtnknkusnmennsukbn() {
        return ztytukiyuhtnknkusnmennsukbn;
    }

    public void setZtytukiyuhtnknkusnmennsukbn(String pZtytukiyuhtnknkusnmennsukbn) {
        ztytukiyuhtnknkusnmennsukbn = pZtytukiyuhtnknkusnmennsukbn;
    }

    private String ztynkdatetokuteikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDATETOKUTEIKGUSDKBN)
    public String getZtynkdatetokuteikgusdkbn() {
        return ztynkdatetokuteikgusdkbn;
    }

    public void setZtynkdatetokuteikgusdkbn(String pZtynkdatetokuteikgusdkbn) {
        ztynkdatetokuteikgusdkbn = pZtynkdatetokuteikgusdkbn;
    }

    private String ztynenkindatetokuteikatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATETOKUTEIKATAKBN)
    public String getZtynenkindatetokuteikatakbn() {
        return ztynenkindatetokuteikatakbn;
    }

    public void setZtynenkindatetokuteikatakbn(String pZtynenkindatetokuteikatakbn) {
        ztynenkindatetokuteikatakbn = pZtynenkindatetokuteikatakbn;
    }

    private String ztyyobiv2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV2X4)
    public String getZtyyobiv2x4() {
        return ztyyobiv2x4;
    }

    public void setZtyyobiv2x4(String pZtyyobiv2x4) {
        ztyyobiv2x4 = pZtyyobiv2x4;
    }

    private String ztysugusnsyutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUGUSNSYUTKYKSYURUIKGU)
    public String getZtysugusnsyutkyksyuruikgu() {
        return ztysugusnsyutkyksyuruikgu;
    }

    public void setZtysugusnsyutkyksyuruikgu(String pZtysugusnsyutkyksyuruikgu) {
        ztysugusnsyutkyksyuruikgu = pZtysugusnsyutkyksyuruikgu;
    }

    private String ztysugusnsyutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUGUSNSYUTKYKKKN)
    public String getZtysugusnsyutkykkkn() {
        return ztysugusnsyutkykkkn;
    }

    public void setZtysugusnsyutkykkkn(String pZtysugusnsyutkykkkn) {
        ztysugusnsyutkykkkn = pZtysugusnsyutkykkkn;
    }

    private String ztysugusnsyutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUGUSNSYUTKYKPHRKKKN)
    public String getZtysugusnsyutkykphrkkkn() {
        return ztysugusnsyutkykphrkkkn;
    }

    public void setZtysugusnsyutkykphrkkkn(String pZtysugusnsyutkykphrkkkn) {
        ztysugusnsyutkykphrkkkn = pZtysugusnsyutkykphrkkkn;
    }

    private Long ztysougousonsyoutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSOUGOUSONSYOUTOKUYAKUS)
    public Long getZtysougousonsyoutokuyakus() {
        return ztysougousonsyoutokuyakus;
    }

    public void setZtysougousonsyoutokuyakus(Long pZtysougousonsyoutokuyakus) {
        ztysougousonsyoutokuyakus = pZtysougousonsyoutokuyakus;
    }

    private Long ztysougousonsyoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSOUGOUSONSYOUTOKUYAKUP)
    public Long getZtysougousonsyoutokuyakup() {
        return ztysougousonsyoutokuyakup;
    }

    public void setZtysougousonsyoutokuyakup(Long pZtysougousonsyoutokuyakup) {
        ztysougousonsyoutokuyakup = pZtysougousonsyoutokuyakup;
    }

    private String ztysugusnsyutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUGUSNSYUTKYKKGUSDKBN)
    public String getZtysugusnsyutkykkgusdkbn() {
        return ztysugusnsyutkykkgusdkbn;
    }

    public void setZtysugusnsyutkykkgusdkbn(String pZtysugusnsyutkykkgusdkbn) {
        ztysugusnsyutkykkgusdkbn = pZtysugusnsyutkykkgusdkbn;
    }

    private String ztysugusnsyutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUGUSNSYUTKYKPWRBKKBN)
    public String getZtysugusnsyutkykpwrbkkbn() {
        return ztysugusnsyutkykpwrbkkbn;
    }

    public void setZtysugusnsyutkykpwrbkkbn(String pZtysugusnsyutkykpwrbkkbn) {
        ztysugusnsyutkykpwrbkkbn = pZtysugusnsyutkykpwrbkkbn;
    }

    private String ztysugusnsyutkykkusnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUGUSNSYUTKYKKUSNMNRYAGE)
    public String getZtysugusnsyutkykkusnmnryage() {
        return ztysugusnsyutkykkusnmnryage;
    }

    public void setZtysugusnsyutkykkusnmnryage(String pZtysugusnsyutkykkusnmnryage) {
        ztysugusnsyutkykkusnmnryage = pZtysugusnsyutkykkusnmnryage;
    }

    private String ztyyobiv7x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV7X5)
    public String getZtyyobiv7x5() {
        return ztyyobiv7x5;
    }

    public void setZtyyobiv7x5(String pZtyyobiv7x5) {
        ztyyobiv7x5 = pZtyyobiv7x5;
    }

    private String ztydi2sugusnsyutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYUTKYKSYRIKGU)
    public String getZtydi2sugusnsyutkyksyrikgu() {
        return ztydi2sugusnsyutkyksyrikgu;
    }

    public void setZtydi2sugusnsyutkyksyrikgu(String pZtydi2sugusnsyutkyksyrikgu) {
        ztydi2sugusnsyutkyksyrikgu = pZtydi2sugusnsyutkyksyrikgu;
    }

    private String ztydi2sugusnsyutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYUTKYKKKN)
    public String getZtydi2sugusnsyutkykkkn() {
        return ztydi2sugusnsyutkykkkn;
    }

    public void setZtydi2sugusnsyutkykkkn(String pZtydi2sugusnsyutkykkkn) {
        ztydi2sugusnsyutkykkkn = pZtydi2sugusnsyutkykkkn;
    }

    private String ztydi2sugusnsyutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYUTKYKPHRKKKN)
    public String getZtydi2sugusnsyutkykphrkkkn() {
        return ztydi2sugusnsyutkykphrkkkn;
    }

    public void setZtydi2sugusnsyutkykphrkkkn(String pZtydi2sugusnsyutkykphrkkkn) {
        ztydi2sugusnsyutkykphrkkkn = pZtydi2sugusnsyutkykphrkkkn;
    }

    private Long ztydi2sugusnsyutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYUTKYKS)
    public Long getZtydi2sugusnsyutkyks() {
        return ztydi2sugusnsyutkyks;
    }

    public void setZtydi2sugusnsyutkyks(Long pZtydi2sugusnsyutkyks) {
        ztydi2sugusnsyutkyks = pZtydi2sugusnsyutkyks;
    }

    private Long ztydi2sugusnsyutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYUTKYKP)
    public Long getZtydi2sugusnsyutkykp() {
        return ztydi2sugusnsyutkykp;
    }

    public void setZtydi2sugusnsyutkykp(Long pZtydi2sugusnsyutkykp) {
        ztydi2sugusnsyutkykp = pZtydi2sugusnsyutkykp;
    }

    private String ztydi2sugusnsytkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYTKYKKGUSDKBN)
    public String getZtydi2sugusnsytkykkgusdkbn() {
        return ztydi2sugusnsytkykkgusdkbn;
    }

    public void setZtydi2sugusnsytkykkgusdkbn(String pZtydi2sugusnsytkykkgusdkbn) {
        ztydi2sugusnsytkykkgusdkbn = pZtydi2sugusnsytkykkgusdkbn;
    }

    private String ztydi2sugusnsyutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SUGUSNSYUTKYKPWRBKKBN)
    public String getZtydi2sugusnsyutkykpwrbkkbn() {
        return ztydi2sugusnsyutkykpwrbkkbn;
    }

    public void setZtydi2sugusnsyutkykpwrbkkbn(String pZtydi2sugusnsyutkykpwrbkkbn) {
        ztydi2sugusnsyutkykpwrbkkbn = pZtydi2sugusnsyutkykpwrbkkbn;
    }

    private String ztyyobiv9x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV9X10)
    public String getZtyyobiv9x10() {
        return ztyyobiv9x10;
    }

    public void setZtyyobiv9x10(String pZtyyobiv9x10) {
        ztyyobiv9x10 = pZtyyobiv9x10;
    }

    private String ztytenkankeitaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTENKANKEITAIKBN)
    public String getZtytenkankeitaikbn() {
        return ztytenkankeitaikbn;
    }

    public void setZtytenkankeitaikbn(String pZtytenkankeitaikbn) {
        ztytenkankeitaikbn = pZtytenkankeitaikbn;
    }

    private Long ztygukitnknitjbrtiknknengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKITNKNITJBRTIKNKNENGK)
    public Long getZtygukitnknitjbrtiknknengk() {
        return ztygukitnknitjbrtiknknengk;
    }

    public void setZtygukitnknitjbrtiknknengk(Long pZtygukitnknitjbrtiknknengk) {
        ztygukitnknitjbrtiknknengk = pZtygukitnknitjbrtiknknengk;
    }

    private Long ztygukihtnknsugusnsyutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKIHTNKNSUGUSNSYUTKYKS)
    public Long getZtygukihtnknsugusnsyutkyks() {
        return ztygukihtnknsugusnsyutkyks;
    }

    public void setZtygukihtnknsugusnsyutkyks(Long pZtygukihtnknsugusnsyutkyks) {
        ztygukihtnknsugusnsyutkyks = pZtygukihtnknsugusnsyutkyks;
    }

    private Long ztytenkanitijibaraip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTENKANITIJIBARAIP)
    public Long getZtytenkanitijibaraip() {
        return ztytenkanitijibaraip;
    }

    public void setZtytenkanitijibaraip(Long pZtytenkanitijibaraip) {
        ztytenkanitijibaraip = pZtytenkanitijibaraip;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }

    private Long ztygoukeinenbaraikansanpx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANPX1)
    public Long getZtygoukeinenbaraikansanpx1() {
        return ztygoukeinenbaraikansanpx1;
    }

    public void setZtygoukeinenbaraikansanpx1(Long pZtygoukeinenbaraikansanpx1) {
        ztygoukeinenbaraikansanpx1 = pZtygoukeinenbaraikansanpx1;
    }

    private String ztyhktgtikkikkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKNX1)
    public String getZtyhktgtikkikkknx1() {
        return ztyhktgtikkikkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx1(String pZtyhktgtikkikkknx1) {
        ztyhktgtikkikkknx1 = pZtyhktgtikkikkknx1;
    }

    private String ztyhtnknkykkigmrsysyrikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKKIGMRSYSYRIKGUX1)
    public String getZtyhtnknkykkigmrsysyrikgux1() {
        return ztyhtnknkykkigmrsysyrikgux1;
    }

    public void setZtyhtnknkykkigmrsysyrikgux1(String pZtyhtnknkykkigmrsysyrikgux1) {
        ztyhtnknkykkigmrsysyrikgux1 = pZtyhtnknkykkigmrsysyrikgux1;
    }

    private Long ztygoukeinenbaraikansanpx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANPX2)
    public Long getZtygoukeinenbaraikansanpx2() {
        return ztygoukeinenbaraikansanpx2;
    }

    public void setZtygoukeinenbaraikansanpx2(Long pZtygoukeinenbaraikansanpx2) {
        ztygoukeinenbaraikansanpx2 = pZtygoukeinenbaraikansanpx2;
    }

    private String ztyhktgtikkikkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKNX2)
    public String getZtyhktgtikkikkknx2() {
        return ztyhktgtikkikkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx2(String pZtyhktgtikkikkknx2) {
        ztyhktgtikkikkknx2 = pZtyhktgtikkikkknx2;
    }

    private String ztyhtnknkykkigmrsysyrikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKKIGMRSYSYRIKGUX2)
    public String getZtyhtnknkykkigmrsysyrikgux2() {
        return ztyhtnknkykkigmrsysyrikgux2;
    }

    public void setZtyhtnknkykkigmrsysyrikgux2(String pZtyhtnknkykkigmrsysyrikgux2) {
        ztyhtnknkykkigmrsysyrikgux2 = pZtyhtnknkykkigmrsysyrikgux2;
    }

    private Long ztygoukeinenbaraikansanpx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANPX3)
    public Long getZtygoukeinenbaraikansanpx3() {
        return ztygoukeinenbaraikansanpx3;
    }

    public void setZtygoukeinenbaraikansanpx3(Long pZtygoukeinenbaraikansanpx3) {
        ztygoukeinenbaraikansanpx3 = pZtygoukeinenbaraikansanpx3;
    }

    private String ztyhktgtikkikkknx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKNX3)
    public String getZtyhktgtikkikkknx3() {
        return ztyhktgtikkikkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx3(String pZtyhktgtikkikkknx3) {
        ztyhktgtikkikkknx3 = pZtyhktgtikkikkknx3;
    }

    private String ztyhtnknkykkigmrsysyrikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKKIGMRSYSYRIKGUX3)
    public String getZtyhtnknkykkigmrsysyrikgux3() {
        return ztyhtnknkykkigmrsysyrikgux3;
    }

    public void setZtyhtnknkykkigmrsysyrikgux3(String pZtyhtnknkykkigmrsysyrikgux3) {
        ztyhtnknkykkigmrsysyrikgux3 = pZtyhtnknkykkigmrsysyrikgux3;
    }

    private Long ztygoukeinenbaraikansanpx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANPX4)
    public Long getZtygoukeinenbaraikansanpx4() {
        return ztygoukeinenbaraikansanpx4;
    }

    public void setZtygoukeinenbaraikansanpx4(Long pZtygoukeinenbaraikansanpx4) {
        ztygoukeinenbaraikansanpx4 = pZtygoukeinenbaraikansanpx4;
    }

    private String ztyhktgtikkikkknx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKNX4)
    public String getZtyhktgtikkikkknx4() {
        return ztyhktgtikkikkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx4(String pZtyhktgtikkikkknx4) {
        ztyhktgtikkikkknx4 = pZtyhktgtikkikkknx4;
    }

    private String ztyhtnknkykkigmrsysyrikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKKIGMRSYSYRIKGUX4)
    public String getZtyhtnknkykkigmrsysyrikgux4() {
        return ztyhtnknkykkigmrsysyrikgux4;
    }

    public void setZtyhtnknkykkigmrsysyrikgux4(String pZtyhtnknkykkigmrsysyrikgux4) {
        ztyhtnknkykkigmrsysyrikgux4 = pZtyhtnknkykkigmrsysyrikgux4;
    }

    private Long ztygoukeinenbaraikansanpx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANPX5)
    public Long getZtygoukeinenbaraikansanpx5() {
        return ztygoukeinenbaraikansanpx5;
    }

    public void setZtygoukeinenbaraikansanpx5(Long pZtygoukeinenbaraikansanpx5) {
        ztygoukeinenbaraikansanpx5 = pZtygoukeinenbaraikansanpx5;
    }

    private String ztyhktgtikkikkknx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKNX5)
    public String getZtyhktgtikkikkknx5() {
        return ztyhktgtikkikkknx5;
    }

    public void setZtyhktgtikkikkknx5(String pZtyhktgtikkikkknx5) {
        ztyhktgtikkikkknx5 = pZtyhktgtikkikkknx5;
    }

    private String ztyhtnknkykkigmrsysyrikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKKIGMRSYSYRIKGUX5)
    public String getZtyhtnknkykkigmrsysyrikgux5() {
        return ztyhtnknkykkigmrsysyrikgux5;
    }

    public void setZtyhtnknkykkigmrsysyrikgux5(String pZtyhtnknkykkigmrsysyrikgux5) {
        ztyhtnknkykkigmrsysyrikgux5 = pZtyhtnknkykkigmrsysyrikgux5;
    }

    private Long ztygoukeinenbaraikansanpx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANPX6)
    public Long getZtygoukeinenbaraikansanpx6() {
        return ztygoukeinenbaraikansanpx6;
    }

    public void setZtygoukeinenbaraikansanpx6(Long pZtygoukeinenbaraikansanpx6) {
        ztygoukeinenbaraikansanpx6 = pZtygoukeinenbaraikansanpx6;
    }

    private String ztyhktgtikkikkknx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKNX6)
    public String getZtyhktgtikkikkknx6() {
        return ztyhktgtikkikkknx6;
    }

    public void setZtyhktgtikkikkknx6(String pZtyhktgtikkikkknx6) {
        ztyhktgtikkikkknx6 = pZtyhktgtikkikkknx6;
    }

    private String ztyhtnknkykkigmrsysyrikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKYKKIGMRSYSYRIKGUX6)
    public String getZtyhtnknkykkigmrsysyrikgux6() {
        return ztyhtnknkykkigmrsysyrikgux6;
    }

    public void setZtyhtnknkykkigmrsysyrikgux6(String pZtyhtnknkykkigmrsysyrikgux6) {
        ztyhtnknkykkigmrsysyrikgux6 = pZtyhtnknkykkigmrsysyrikgux6;
    }

    private String ztyniceonplanhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNICEONPLANHYJ)
    public String getZtyniceonplanhyj() {
        return ztyniceonplanhyj;
    }

    public void setZtyniceonplanhyj(String pZtyniceonplanhyj) {
        ztyniceonplanhyj = pZtyniceonplanhyj;
    }

    private String ztysyokaipryosyuymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYOKAIPRYOSYUYMD)
    public String getZtysyokaipryosyuymd() {
        return ztysyokaipryosyuymd;
    }

    public void setZtysyokaipryosyuymd(String pZtysyokaipryosyuymd) {
        ztysyokaipryosyuymd = pZtysyokaipryosyuymd;
    }

    private String ztyldownmaetenkannensuukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYLDOWNMAETENKANNENSUUKBN)
    public String getZtyldownmaetenkannensuukbn() {
        return ztyldownmaetenkannensuukbn;
    }

    public void setZtyldownmaetenkannensuukbn(String pZtyldownmaetenkannensuukbn) {
        ztyldownmaetenkannensuukbn = pZtyldownmaetenkannensuukbn;
    }

    private String ztyldownmaesaiteismitatuhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYLDOWNMAESAITEISMITATUHYJ)
    public String getZtyldownmaesaiteismitatuhyj() {
        return ztyldownmaesaiteismitatuhyj;
    }

    public void setZtyldownmaesaiteismitatuhyj(String pZtyldownmaesaiteismitatuhyj) {
        ztyldownmaesaiteismitatuhyj = pZtyldownmaesaiteismitatuhyj;
    }

    private String ztydntitikgtkbttrtkhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDNTITIKGTKBTTRTKHYJ)
    public String getZtydntitikgtkbttrtkhyj() {
        return ztydntitikgtkbttrtkhyj;
    }

    public void setZtydntitikgtkbttrtkhyj(String pZtydntitikgtkbttrtkhyj) {
        ztydntitikgtkbttrtkhyj = pZtydntitikgtkbttrtkhyj;
    }

    private String ztyreformkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYREFORMKBN)
    public String getZtyreformkbn() {
        return ztyreformkbn;
    }

    public void setZtyreformkbn(String pZtyreformkbn) {
        ztyreformkbn = pZtyreformkbn;
    }

    private String ztykikeiyakutyuuihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUTYUUIHYOUJI)
    public String getZtykikeiyakutyuuihyouji() {
        return ztykikeiyakutyuuihyouji;
    }

    public void setZtykikeiyakutyuuihyouji(String pZtykikeiyakutyuuihyouji) {
        ztykikeiyakutyuuihyouji = pZtykikeiyakutyuuihyouji;
    }

    private String ztykbnkeiriyousegcd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKBNKEIRIYOUSEGCD)
    public String getZtykbnkeiriyousegcd() {
        return ztykbnkeiriyousegcd;
    }

    public void setZtykbnkeiriyousegcd(String pZtykbnkeiriyousegcd) {
        ztykbnkeiriyousegcd = pZtykbnkeiriyousegcd;
    }

    private String ztysyuuseiskiteitekiyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYUUSEISKITEITEKIYOUKBN)
    public String getZtysyuuseiskiteitekiyoukbn() {
        return ztysyuuseiskiteitekiyoukbn;
    }

    public void setZtysyuuseiskiteitekiyoukbn(String pZtysyuuseiskiteitekiyoukbn) {
        ztysyuuseiskiteitekiyoukbn = pZtysyuuseiskiteitekiyoukbn;
    }

    private Long ztygukihtnknkzkmrtimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKIHTNKNKZKMRTIMODS)
    public Long getZtygukihtnknkzkmrtimods() {
        return ztygukihtnknkzkmrtimods;
    }

    public void setZtygukihtnknkzkmrtimods(Long pZtygukihtnknkzkmrtimods) {
        ztygukihtnknkzkmrtimods = pZtygukihtnknkzkmrtimods;
    }

    private Long ztytnknkijyntkyuhtnknsbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTNKNKIJYNTKYUHTNKNSBUS)
    public Long getZtytnknkijyntkyuhtnknsbus() {
        return ztytnknkijyntkyuhtnknsbus;
    }

    public void setZtytnknkijyntkyuhtnknsbus(Long pZtytnknkijyntkyuhtnknsbus) {
        ztytnknkijyntkyuhtnknsbus = pZtytnknkijyntkyuhtnknsbus;
    }

    private String ztysrjsnyusyouhinhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSRJSNYUSYOUHINHYJ)
    public String getZtysrjsnyusyouhinhyj() {
        return ztysrjsnyusyouhinhyj;
    }

    public void setZtysrjsnyusyouhinhyj(String pZtysrjsnyusyouhinhyj) {
        ztysrjsnyusyouhinhyj = pZtysrjsnyusyouhinhyj;
    }

    private String ztysirajikakuninzumihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSIRAJIKAKUNINZUMIHYOUJI)
    public String getZtysirajikakuninzumihyouji() {
        return ztysirajikakuninzumihyouji;
    }

    public void setZtysirajikakuninzumihyouji(String pZtysirajikakuninzumihyouji) {
        ztysirajikakuninzumihyouji = pZtysirajikakuninzumihyouji;
    }

    private String ztysrjsnyusyouhintknnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSRJSNYUSYOUHINTKNNHYJ)
    public String getZtysrjsnyusyouhintknnhyj() {
        return ztysrjsnyusyouhintknnhyj;
    }

    public void setZtysrjsnyusyouhintknnhyj(String pZtysrjsnyusyouhintknnhyj) {
        ztysrjsnyusyouhintknnhyj = pZtysrjsnyusyouhintknnhyj;
    }

    private String ztysinsakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSINSAKBN)
    public String getZtysinsakbn() {
        return ztysinsakbn;
    }

    public void setZtysinsakbn(String pZtysinsakbn) {
        ztysinsakbn = pZtysinsakbn;
    }

    private String ztydai2sinsakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2SINSAKBN)
    public String getZtydai2sinsakbn() {
        return ztydai2sinsakbn;
    }

    public void setZtydai2sinsakbn(String pZtydai2sinsakbn) {
        ztydai2sinsakbn = pZtydai2sinsakbn;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztydai2toukeiyousinsakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2TOUKEIYOUSINSAKBN)
    public String getZtydai2toukeiyousinsakbn() {
        return ztydai2toukeiyousinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2toukeiyousinsakbn(String pZtydai2toukeiyousinsakbn) {
        ztydai2toukeiyousinsakbn = pZtydai2toukeiyousinsakbn;
    }

    private String ztyseizonkyuhknshrsiteimd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSEIZONKYUHKNSHRSITEIMD)
    public String getZtyseizonkyuhknshrsiteimd() {
        return ztyseizonkyuhknshrsiteimd;
    }

    public void setZtyseizonkyuhknshrsiteimd(String pZtyseizonkyuhknshrsiteimd) {
        ztyseizonkyuhknshrsiteimd = pZtyseizonkyuhknshrsiteimd;
    }

    private BizNumber ztyyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOTEIRIRITUN5)
    public BizNumber getZtyyoteiriritun5() {
        return ztyyoteiriritun5;
    }

    public void setZtyyoteiriritun5(BizNumber pZtyyoteiriritun5) {
        ztyyoteiriritun5 = pZtyyoteiriritun5;
    }

    private BizNumber ztysaiteihosyouriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSAITEIHOSYOURIRITU)
    public BizNumber getZtysaiteihosyouriritu() {
        return ztysaiteihosyouriritu;
    }

    public void setZtysaiteihosyouriritu(BizNumber pZtysaiteihosyouriritu) {
        ztysaiteihosyouriritu = pZtysaiteihosyouriritu;
    }

    private BizNumber ztynkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKGNSRITU)
    public BizNumber getZtynkgnsritu() {
        return ztynkgnsritu;
    }

    public void setZtynkgnsritu(BizNumber pZtynkgnsritu) {
        ztynkgnsritu = pZtynkgnsritu;
    }

    private Long ztyjigyounendomatuv;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYJIGYOUNENDOMATUV)
    public Long getZtyjigyounendomatuv() {
        return ztyjigyounendomatuv;
    }

    public void setZtyjigyounendomatuv(Long pZtyjigyounendomatuv) {
        ztyjigyounendomatuv = pZtyjigyounendomatuv;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztygukihtnkn5nnmeksnyumods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKIHTNKN5NNMEKSNYUMODS)
    public Long getZtygukihtnkn5nnmeksnyumods() {
        return ztygukihtnkn5nnmeksnyumods;
    }

    public void setZtygukihtnkn5nnmeksnyumods(Long pZtygukihtnkn5nnmeksnyumods) {
        ztygukihtnkn5nnmeksnyumods = pZtygukihtnkn5nnmeksnyumods;
    }

    private String ztyrenseiteikitksyusnksnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYRENSEITEIKITKSYUSNKSNHYJ)
    public String getZtyrenseiteikitksyusnksnhyj() {
        return ztyrenseiteikitksyusnksnhyj;
    }

    public void setZtyrenseiteikitksyusnksnhyj(String pZtyrenseiteikitksyusnksnhyj) {
        ztyrenseiteikitksyusnksnhyj = pZtyrenseiteikitksyusnksnhyj;
    }

    private Long ztygoukeinenbaraikansanp2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANP2X1)
    public Long getZtygoukeinenbaraikansanp2x1() {
        return ztygoukeinenbaraikansanp2x1;
    }

    public void setZtygoukeinenbaraikansanp2x1(Long pZtygoukeinenbaraikansanp2x1) {
        ztygoukeinenbaraikansanp2x1 = pZtygoukeinenbaraikansanp2x1;
    }

    private String ztygukinenbaraiknsnp2kbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKINENBARAIKNSNP2KBNX1)
    public String getZtygukinenbaraiknsnp2kbnx1() {
        return ztygukinenbaraiknsnp2kbnx1;
    }

    public void setZtygukinenbaraiknsnp2kbnx1(String pZtygukinenbaraiknsnp2kbnx1) {
        ztygukinenbaraiknsnp2kbnx1 = pZtygukinenbaraiknsnp2kbnx1;
    }

    private String ztyhktgtikkikkkn2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKN2X1)
    public String getZtyhktgtikkikkkn2x1() {
        return ztyhktgtikkikkkn2x1;
    }

    public void setZtyhktgtikkikkkn2x1(String pZtyhktgtikkikkkn2x1) {
        ztyhktgtikkikkkn2x1 = pZtyhktgtikkikkkn2x1;
    }

    private Long ztygoukeinenbaraikansanp2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANP2X2)
    public Long getZtygoukeinenbaraikansanp2x2() {
        return ztygoukeinenbaraikansanp2x2;
    }

    public void setZtygoukeinenbaraikansanp2x2(Long pZtygoukeinenbaraikansanp2x2) {
        ztygoukeinenbaraikansanp2x2 = pZtygoukeinenbaraikansanp2x2;
    }

    private String ztygukinenbaraiknsnp2kbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKINENBARAIKNSNP2KBNX2)
    public String getZtygukinenbaraiknsnp2kbnx2() {
        return ztygukinenbaraiknsnp2kbnx2;
    }

    public void setZtygukinenbaraiknsnp2kbnx2(String pZtygukinenbaraiknsnp2kbnx2) {
        ztygukinenbaraiknsnp2kbnx2 = pZtygukinenbaraiknsnp2kbnx2;
    }

    private String ztyhktgtikkikkkn2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKN2X2)
    public String getZtyhktgtikkikkkn2x2() {
        return ztyhktgtikkikkkn2x2;
    }

    public void setZtyhktgtikkikkkn2x2(String pZtyhktgtikkikkkn2x2) {
        ztyhktgtikkikkkn2x2 = pZtyhktgtikkikkkn2x2;
    }

    private Long ztygoukeinenbaraikansanp2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANP2X3)
    public Long getZtygoukeinenbaraikansanp2x3() {
        return ztygoukeinenbaraikansanp2x3;
    }

    public void setZtygoukeinenbaraikansanp2x3(Long pZtygoukeinenbaraikansanp2x3) {
        ztygoukeinenbaraikansanp2x3 = pZtygoukeinenbaraikansanp2x3;
    }

    private String ztygukinenbaraiknsnp2kbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKINENBARAIKNSNP2KBNX3)
    public String getZtygukinenbaraiknsnp2kbnx3() {
        return ztygukinenbaraiknsnp2kbnx3;
    }

    public void setZtygukinenbaraiknsnp2kbnx3(String pZtygukinenbaraiknsnp2kbnx3) {
        ztygukinenbaraiknsnp2kbnx3 = pZtygukinenbaraiknsnp2kbnx3;
    }

    private String ztyhktgtikkikkkn2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKN2X3)
    public String getZtyhktgtikkikkkn2x3() {
        return ztyhktgtikkikkkn2x3;
    }

    public void setZtyhktgtikkikkkn2x3(String pZtyhktgtikkikkkn2x3) {
        ztyhktgtikkikkkn2x3 = pZtyhktgtikkikkkn2x3;
    }

    private Long ztygoukeinenbaraikansanp2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANP2X4)
    public Long getZtygoukeinenbaraikansanp2x4() {
        return ztygoukeinenbaraikansanp2x4;
    }

    public void setZtygoukeinenbaraikansanp2x4(Long pZtygoukeinenbaraikansanp2x4) {
        ztygoukeinenbaraikansanp2x4 = pZtygoukeinenbaraikansanp2x4;
    }

    private String ztygukinenbaraiknsnp2kbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKINENBARAIKNSNP2KBNX4)
    public String getZtygukinenbaraiknsnp2kbnx4() {
        return ztygukinenbaraiknsnp2kbnx4;
    }

    public void setZtygukinenbaraiknsnp2kbnx4(String pZtygukinenbaraiknsnp2kbnx4) {
        ztygukinenbaraiknsnp2kbnx4 = pZtygukinenbaraiknsnp2kbnx4;
    }

    private String ztyhktgtikkikkkn2x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKN2X4)
    public String getZtyhktgtikkikkkn2x4() {
        return ztyhktgtikkikkkn2x4;
    }

    public void setZtyhktgtikkikkkn2x4(String pZtyhktgtikkikkkn2x4) {
        ztyhktgtikkikkkn2x4 = pZtyhktgtikkikkkn2x4;
    }

    private Long ztygoukeinenbaraikansanp2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANP2X5)
    public Long getZtygoukeinenbaraikansanp2x5() {
        return ztygoukeinenbaraikansanp2x5;
    }

    public void setZtygoukeinenbaraikansanp2x5(Long pZtygoukeinenbaraikansanp2x5) {
        ztygoukeinenbaraikansanp2x5 = pZtygoukeinenbaraikansanp2x5;
    }

    private String ztygukinenbaraiknsnp2kbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKINENBARAIKNSNP2KBNX5)
    public String getZtygukinenbaraiknsnp2kbnx5() {
        return ztygukinenbaraiknsnp2kbnx5;
    }

    public void setZtygukinenbaraiknsnp2kbnx5(String pZtygukinenbaraiknsnp2kbnx5) {
        ztygukinenbaraiknsnp2kbnx5 = pZtygukinenbaraiknsnp2kbnx5;
    }

    private String ztyhktgtikkikkkn2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKN2X5)
    public String getZtyhktgtikkikkkn2x5() {
        return ztyhktgtikkikkkn2x5;
    }

    public void setZtyhktgtikkikkkn2x5(String pZtyhktgtikkikkkn2x5) {
        ztyhktgtikkikkkn2x5 = pZtyhktgtikkikkkn2x5;
    }

    private Long ztygoukeinenbaraikansanp2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGOUKEINENBARAIKANSANP2X6)
    public Long getZtygoukeinenbaraikansanp2x6() {
        return ztygoukeinenbaraikansanp2x6;
    }

    public void setZtygoukeinenbaraikansanp2x6(Long pZtygoukeinenbaraikansanp2x6) {
        ztygoukeinenbaraikansanp2x6 = pZtygoukeinenbaraikansanp2x6;
    }

    private String ztygukinenbaraiknsnp2kbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYGUKINENBARAIKNSNP2KBNX6)
    public String getZtygukinenbaraiknsnp2kbnx6() {
        return ztygukinenbaraiknsnp2kbnx6;
    }

    public void setZtygukinenbaraiknsnp2kbnx6(String pZtygukinenbaraiknsnp2kbnx6) {
        ztygukinenbaraiknsnp2kbnx6 = pZtygukinenbaraiknsnp2kbnx6;
    }

    private String ztyhktgtikkikkkn2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHKTGTIKKIKKKN2X6)
    public String getZtyhktgtikkikkkn2x6() {
        return ztyhktgtikkikkkn2x6;
    }

    public void setZtyhktgtikkikkkn2x6(String pZtyhktgtikkikkkn2x6) {
        ztyhktgtikkikkkn2x6 = pZtyhktgtikkikkkn2x6;
    }

    private Long ztykokutituusantaisyous;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKOKUTITUUSANTAISYOUS)
    public Long getZtykokutituusantaisyous() {
        return ztykokutituusantaisyous;
    }

    public void setZtykokutituusantaisyous(Long pZtykokutituusantaisyous) {
        ztykokutituusantaisyous = pZtykokutituusantaisyous;
    }

    private Long ztytokusyuyouroumankis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOKUSYUYOUROUMANKIS)
    public Long getZtytokusyuyouroumankis() {
        return ztytokusyuyouroumankis;
    }

    public void setZtytokusyuyouroumankis(Long pZtytokusyuyouroumankis) {
        ztytokusyuyouroumankis = pZtytokusyuyouroumankis;
    }

    private String ztynkdtmrtitnknyuuguukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTITNKNYUUGUUKBN)
    public String getZtynkdtmrtitnknyuuguukbn() {
        return ztynkdtmrtitnknyuuguukbn;
    }

    public void setZtynkdtmrtitnknyuuguukbn(String pZtynkdtmrtitnknyuuguukbn) {
        ztynkdtmrtitnknyuuguukbn = pZtynkdtmrtitnknyuuguukbn;
    }

    private String ztynkdtmrtikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTIKGUSDKBN)
    public String getZtynkdtmrtikgusdkbn() {
        return ztynkdtmrtikgusdkbn;
    }

    public void setZtynkdtmrtikgusdkbn(String pZtynkdtmrtikgusdkbn) {
        ztynkdtmrtikgusdkbn = pZtynkdtmrtikgusdkbn;
    }

    private String ztynenkindatemaruteikatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNENKINDATEMARUTEIKATAKBN)
    public String getZtynenkindatemaruteikatakbn() {
        return ztynenkindatemaruteikatakbn;
    }

    public void setZtynenkindatemaruteikatakbn(String pZtynenkindatemaruteikatakbn) {
        ztynenkindatemaruteikatakbn = pZtynenkindatemaruteikatakbn;
    }

    private String ztynkdtmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNKDTMRTIKUSNMNRYOAGE)
    public String getZtynkdtmrtikusnmnryoage() {
        return ztynkdtmrtikusnmnryoage;
    }

    public void setZtynkdtmrtikusnmnryoage(String pZtynkdtmrtikusnmnryoage) {
        ztynkdtmrtikusnmnryoage = pZtynkdtmrtikusnmnryoage;
    }

    private String ztykaigonkdtmrtisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTISYURUIKGU)
    public String getZtykaigonkdtmrtisyuruikgu() {
        return ztykaigonkdtmrtisyuruikgu;
    }

    public void setZtykaigonkdtmrtisyuruikgu(String pZtykaigonkdtmrtisyuruikgu) {
        ztykaigonkdtmrtisyuruikgu = pZtykaigonkdtmrtisyuruikgu;
    }

    private String ztykaigonkdtmrtikkan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIKKAN)
    public String getZtykaigonkdtmrtikkan() {
        return ztykaigonkdtmrtikkan;
    }

    public void setZtykaigonkdtmrtikkan(String pZtykaigonkdtmrtikkan) {
        ztykaigonkdtmrtikkan = pZtykaigonkdtmrtikkan;
    }

    private String ztykaigonkdtmrtiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIPHRKKKN)
    public String getZtykaigonkdtmrtiphrkkkn() {
        return ztykaigonkdtmrtiphrkkkn;
    }

    public void setZtykaigonkdtmrtiphrkkkn(String pZtykaigonkdtmrtiphrkkkn) {
        ztykaigonkdtmrtiphrkkkn = pZtykaigonkdtmrtiphrkkkn;
    }

    private Long ztykaigonkdtmrtinnknnengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTINNKNNENGK)
    public Long getZtykaigonkdtmrtinnknnengk() {
        return ztykaigonkdtmrtinnknnengk;
    }

    public void setZtykaigonkdtmrtinnknnengk(Long pZtykaigonkdtmrtinnknnengk) {
        ztykaigonkdtmrtinnknnengk = pZtykaigonkdtmrtinnknnengk;
    }

    private Long ztykaigonkdtmrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIS)
    public Long getZtykaigonkdtmrtis() {
        return ztykaigonkdtmrtis;
    }

    public void setZtykaigonkdtmrtis(Long pZtykaigonkdtmrtis) {
        ztykaigonkdtmrtis = pZtykaigonkdtmrtis;
    }

    private Long ztykaigonkdtmrtip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIP)
    public Long getZtykaigonkdtmrtip() {
        return ztykaigonkdtmrtip;
    }

    public void setZtykaigonkdtmrtip(Long pZtykaigonkdtmrtip) {
        ztykaigonkdtmrtip = pZtykaigonkdtmrtip;
    }

    private Long ztykaigonkdtmrtimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIMODS)
    public Long getZtykaigonkdtmrtimods() {
        return ztykaigonkdtmrtimods;
    }

    public void setZtykaigonkdtmrtimods(Long pZtykaigonkdtmrtimods) {
        ztykaigonkdtmrtimods = pZtykaigonkdtmrtimods;
    }

    private String ztykaigonkdtmrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTITKJYUKBN)
    public String getZtykaigonkdtmrtitkjyukbn() {
        return ztykaigonkdtmrtitkjyukbn;
    }

    public void setZtykaigonkdtmrtitkjyukbn(String pZtykaigonkdtmrtitkjyukbn) {
        ztykaigonkdtmrtitkjyukbn = pZtykaigonkdtmrtitkjyukbn;
    }

    private String ztykaigonkdtmrtitkjyskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTITKJYSKGNKKN)
    public String getZtykaigonkdtmrtitkjyskgnkkn() {
        return ztykaigonkdtmrtitkjyskgnkkn;
    }

    public void setZtykaigonkdtmrtitkjyskgnkkn(String pZtykaigonkdtmrtitkjyskgnkkn) {
        ztykaigonkdtmrtitkjyskgnkkn = pZtykaigonkdtmrtitkjyskgnkkn;
    }

    private Integer ztykaigonkdtmrttkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTTKJYRYMSHYTN)
    public Integer getZtykaigonkdtmrttkjyrymshytn() {
        return ztykaigonkdtmrttkjyrymshytn;
    }

    public void setZtykaigonkdtmrttkjyrymshytn(Integer pZtykaigonkdtmrttkjyrymshytn) {
        ztykaigonkdtmrttkjyrymshytn = pZtykaigonkdtmrttkjyrymshytn;
    }

    private Long ztykaigonkdtmrtitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTITKJYUP)
    public Long getZtykaigonkdtmrtitkjyup() {
        return ztykaigonkdtmrtitkjyup;
    }

    public void setZtykaigonkdtmrtitkjyup(Long pZtykaigonkdtmrtitkjyup) {
        ztykaigonkdtmrtitkjyup = pZtykaigonkdtmrtitkjyup;
    }

    private String ztyhtnknkaigonkmrtsyrikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTSYRIKGUX1)
    public String getZtyhtnknkaigonkmrtsyrikgux1() {
        return ztyhtnknkaigonkmrtsyrikgux1;
    }

    public void setZtyhtnknkaigonkmrtsyrikgux1(String pZtyhtnknkaigonkmrtsyrikgux1) {
        ztyhtnknkaigonkmrtsyrikgux1 = pZtyhtnknkaigonkmrtsyrikgux1;
    }

    private String ztyhtnknkaigonkmrtsyrikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTSYRIKGUX2)
    public String getZtyhtnknkaigonkmrtsyrikgux2() {
        return ztyhtnknkaigonkmrtsyrikgux2;
    }

    public void setZtyhtnknkaigonkmrtsyrikgux2(String pZtyhtnknkaigonkmrtsyrikgux2) {
        ztyhtnknkaigonkmrtsyrikgux2 = pZtyhtnknkaigonkmrtsyrikgux2;
    }

    private String ztyhtnknkaigonkmrtsyrikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTSYRIKGUX3)
    public String getZtyhtnknkaigonkmrtsyrikgux3() {
        return ztyhtnknkaigonkmrtsyrikgux3;
    }

    public void setZtyhtnknkaigonkmrtsyrikgux3(String pZtyhtnknkaigonkmrtsyrikgux3) {
        ztyhtnknkaigonkmrtsyrikgux3 = pZtyhtnknkaigonkmrtsyrikgux3;
    }

    private String ztyhtnknkaigonkmrtsyrikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTSYRIKGUX4)
    public String getZtyhtnknkaigonkmrtsyrikgux4() {
        return ztyhtnknkaigonkmrtsyrikgux4;
    }

    public void setZtyhtnknkaigonkmrtsyrikgux4(String pZtyhtnknkaigonkmrtsyrikgux4) {
        ztyhtnknkaigonkmrtsyrikgux4 = pZtyhtnknkaigonkmrtsyrikgux4;
    }

    private String ztyhtnknkaigonkmrtsyrikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTSYRIKGUX5)
    public String getZtyhtnknkaigonkmrtsyrikgux5() {
        return ztyhtnknkaigonkmrtsyrikgux5;
    }

    public void setZtyhtnknkaigonkmrtsyrikgux5(String pZtyhtnknkaigonkmrtsyrikgux5) {
        ztyhtnknkaigonkmrtsyrikgux5 = pZtyhtnknkaigonkmrtsyrikgux5;
    }

    private String ztyhtnknkaigonkmrtsyrikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTSYRIKGUX6)
    public String getZtyhtnknkaigonkmrtsyrikgux6() {
        return ztyhtnknkaigonkmrtsyrikgux6;
    }

    public void setZtyhtnknkaigonkmrtsyrikgux6(String pZtyhtnknkaigonkmrtsyrikgux6) {
        ztyhtnknkaigonkmrtsyrikgux6 = pZtyhtnknkaigonkmrtsyrikgux6;
    }

    private String ztykaigonkdtmrtishrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTISHRKKN)
    public String getZtykaigonkdtmrtishrkkn() {
        return ztykaigonkdtmrtishrkkn;
    }

    public void setZtykaigonkdtmrtishrkkn(String pZtykaigonkdtmrtishrkkn) {
        ztykaigonkdtmrtishrkkn = pZtykaigonkdtmrtishrkkn;
    }

    private String ztysurikaigonkmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURIKAIGONKMRTIPWRBKKBN)
    public String getZtysurikaigonkmrtipwrbkkbn() {
        return ztysurikaigonkmrtipwrbkkbn;
    }

    public void setZtysurikaigonkmrtipwrbkkbn(String pZtysurikaigonkmrtipwrbkkbn) {
        ztysurikaigonkmrtipwrbkkbn = pZtysurikaigonkmrtipwrbkkbn;
    }

    private String ztykaigonkdtmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIPWRBKKBN)
    public String getZtykaigonkdtmrtipwrbkkbn() {
        return ztykaigonkdtmrtipwrbkkbn;
    }

    public void setZtykaigonkdtmrtipwrbkkbn(String pZtykaigonkdtmrtipwrbkkbn) {
        ztykaigonkdtmrtipwrbkkbn = pZtykaigonkdtmrtipwrbkkbn;
    }

    private String ztykaigonkdtmrtitnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTITNKNYUGUKBN)
    public String getZtykaigonkdtmrtitnknyugukbn() {
        return ztykaigonkdtmrtitnknyugukbn;
    }

    public void setZtykaigonkdtmrtitnknyugukbn(String pZtykaigonkdtmrtitnknyugukbn) {
        ztykaigonkdtmrtitnknyugukbn = pZtykaigonkdtmrtitnknyugukbn;
    }

    private String ztykaigonkdtmrtikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIKGUSDKBN)
    public String getZtykaigonkdtmrtikgusdkbn() {
        return ztykaigonkdtmrtikgusdkbn;
    }

    public void setZtykaigonkdtmrtikgusdkbn(String pZtykaigonkdtmrtikgusdkbn) {
        ztykaigonkdtmrtikgusdkbn = pZtykaigonkdtmrtikgusdkbn;
    }

    private String ztykaigonkdtmrtiktkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTMRTIKTKBN)
    public String getZtykaigonkdtmrtiktkbn() {
        return ztykaigonkdtmrtiktkbn;
    }

    public void setZtykaigonkdtmrtiktkbn(String pZtykaigonkdtmrtiktkbn) {
        ztykaigonkdtmrtiktkbn = pZtykaigonkdtmrtiktkbn;
    }

    private String ztykignkdtmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGNKDTMRTIKUSNMNRYOAGE)
    public String getZtykignkdtmrtikusnmnryoage() {
        return ztykignkdtmrtikusnmnryoage;
    }

    public void setZtykignkdtmrtikusnmnryoage(String pZtykignkdtmrtikusnmnryoage) {
        ztykignkdtmrtikusnmnryoage = pZtykignkdtmrtikusnmnryoage;
    }

    private String ztykaigonkdttktisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTISYURUIKGU)
    public String getZtykaigonkdttktisyuruikgu() {
        return ztykaigonkdttktisyuruikgu;
    }

    public void setZtykaigonkdttktisyuruikgu(String pZtykaigonkdttktisyuruikgu) {
        ztykaigonkdttktisyuruikgu = pZtykaigonkdttktisyuruikgu;
    }

    private String ztykaigonkdttktikkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTIKKN)
    public String getZtykaigonkdttktikkn() {
        return ztykaigonkdttktikkn;
    }

    public void setZtykaigonkdttktikkn(String pZtykaigonkdttktikkn) {
        ztykaigonkdttktikkn = pZtykaigonkdttktikkn;
    }

    private Long ztykaigonkdttkteinenkngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTEINENKNGK)
    public Long getZtykaigonkdttkteinenkngk() {
        return ztykaigonkdttkteinenkngk;
    }

    public void setZtykaigonkdttkteinenkngk(Long pZtykaigonkdttkteinenkngk) {
        ztykaigonkdttkteinenkngk = pZtykaigonkdttkteinenkngk;
    }

    private Long ztykaigonenkindatetokuteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONENKINDATETOKUTEIS)
    public Long getZtykaigonenkindatetokuteis() {
        return ztykaigonenkindatetokuteis;
    }

    public void setZtykaigonenkindatetokuteis(Long pZtykaigonenkindatetokuteis) {
        ztykaigonenkindatetokuteis = pZtykaigonenkindatetokuteis;
    }

    private Long ztykaigonenkindatetokuteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONENKINDATETOKUTEIP)
    public Long getZtykaigonenkindatetokuteip() {
        return ztykaigonenkindatetokuteip;
    }

    public void setZtykaigonenkindatetokuteip(Long pZtykaigonenkindatetokuteip) {
        ztykaigonenkindatetokuteip = pZtykaigonenkindatetokuteip;
    }

    private String ztykaigonkdttktisdtpdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTISDTPDTKBN)
    public String getZtykaigonkdttktisdtpdtkbn() {
        return ztykaigonkdttktisdtpdtkbn;
    }

    public void setZtykaigonkdttktisdtpdtkbn(String pZtykaigonkdttktisdtpdtkbn) {
        ztykaigonkdttktisdtpdtkbn = pZtykaigonkdttktisdtpdtkbn;
    }

    private Long ztykaigonkdttktimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTIMODS)
    public Long getZtykaigonkdttktimods() {
        return ztykaigonkdttktimods;
    }

    public void setZtykaigonkdttktimods(Long pZtykaigonkdttktimods) {
        ztykaigonkdttktimods = pZtykaigonkdttktimods;
    }

    private String ztykaigonkdttktishrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTISHRKKN)
    public String getZtykaigonkdttktishrkkn() {
        return ztykaigonkdttktishrkkn;
    }

    public void setZtykaigonkdttktishrkkn(String pZtykaigonkdttktishrkkn) {
        ztykaigonkdttktishrkkn = pZtykaigonkdttktishrkkn;
    }

    private String ztykaigonkdttktikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTIKGUSDKBN)
    public String getZtykaigonkdttktikgusdkbn() {
        return ztykaigonkdttktikgusdkbn;
    }

    public void setZtykaigonkdttktikgusdkbn(String pZtykaigonkdttktikgusdkbn) {
        ztykaigonkdttktikgusdkbn = pZtykaigonkdttktikgusdkbn;
    }

    private String ztykaigonkdttktiktkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKDTTKTIKTKBN)
    public String getZtykaigonkdttktiktkbn() {
        return ztykaigonkdttktiktkbn;
    }

    public void setZtykaigonkdttktiktkbn(String pZtykaigonkdttktiktkbn) {
        ztykaigonkdttktiktkbn = pZtykaigonkdttktiktkbn;
    }

    private String ztykignkdttktikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGNKDTTKTIKUSNMNRYOAGE)
    public String getZtykignkdttktikusnmnryoage() {
        return ztykignkdttktikusnmnryoage;
    }

    public void setZtykignkdttktikusnmnryoage(String pZtykignkdttktikusnmnryoage) {
        ztykignkdttktikusnmnryoage = pZtykignkdttktikusnmnryoage;
    }

    private String ztyyobiv2x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV2X5)
    public String getZtyyobiv2x5() {
        return ztyyobiv2x5;
    }

    public void setZtyyobiv2x5(String pZtyyobiv2x5) {
        ztyyobiv2x5 = pZtyyobiv2x5;
    }

    private String ztykaigoteigenmrtisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENMRTISYURUIKGU)
    public String getZtykaigoteigenmrtisyuruikgu() {
        return ztykaigoteigenmrtisyuruikgu;
    }

    public void setZtykaigoteigenmrtisyuruikgu(String pZtykaigoteigenmrtisyuruikgu) {
        ztykaigoteigenmrtisyuruikgu = pZtykaigoteigenmrtisyuruikgu;
    }

    private String ztykaigoteigenmaruteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENMARUTEIKIKAN)
    public String getZtykaigoteigenmaruteikikan() {
        return ztykaigoteigenmaruteikikan;
    }

    public void setZtykaigoteigenmaruteikikan(String pZtykaigoteigenmaruteikikan) {
        ztykaigoteigenmaruteikikan = pZtykaigoteigenmaruteikikan;
    }

    private String ztykaigotignmrtiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTIGNMRTIPHRKKKN)
    public String getZtykaigotignmrtiphrkkkn() {
        return ztykaigotignmrtiphrkkkn;
    }

    public void setZtykaigotignmrtiphrkkkn(String pZtykaigotignmrtiphrkkkn) {
        ztykaigotignmrtiphrkkkn = pZtykaigotignmrtiphrkkkn;
    }

    private Long ztykaigoteigenmaruteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENMARUTEIS)
    public Long getZtykaigoteigenmaruteis() {
        return ztykaigoteigenmaruteis;
    }

    public void setZtykaigoteigenmaruteis(Long pZtykaigoteigenmaruteis) {
        ztykaigoteigenmaruteis = pZtykaigoteigenmaruteis;
    }

    private Long ztykaigoteigenmaruteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENMARUTEIP)
    public Long getZtykaigoteigenmaruteip() {
        return ztykaigoteigenmaruteip;
    }

    public void setZtykaigoteigenmaruteip(Long pZtykaigoteigenmaruteip) {
        ztykaigoteigenmaruteip = pZtykaigoteigenmaruteip;
    }

    private Long ztykigtignmrtimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTIMODS)
    public Long getZtykigtignmrtimods() {
        return ztykigtignmrtimods;
    }

    public void setZtykigtignmrtimods(Long pZtykigtignmrtimods) {
        ztykigtignmrtimods = pZtykigtignmrtimods;
    }

    private String ztykigtignmrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTITKJYUKBN)
    public String getZtykigtignmrtitkjyukbn() {
        return ztykigtignmrtitkjyukbn;
    }

    public void setZtykigtignmrtitkjyukbn(String pZtykigtignmrtitkjyukbn) {
        ztykigtignmrtitkjyukbn = pZtykigtignmrtitkjyukbn;
    }

    private String ztykigtignmrtitkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTITKJYUSKGNKKN)
    public String getZtykigtignmrtitkjyuskgnkkn() {
        return ztykigtignmrtitkjyuskgnkkn;
    }

    public void setZtykigtignmrtitkjyuskgnkkn(String pZtykigtignmrtitkjyuskgnkkn) {
        ztykigtignmrtitkjyuskgnkkn = pZtykigtignmrtitkjyuskgnkkn;
    }

    private Integer ztykigtignmrtitkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTITKJYURYMSHYTN)
    public Integer getZtykigtignmrtitkjyurymshytn() {
        return ztykigtignmrtitkjyurymshytn;
    }

    public void setZtykigtignmrtitkjyurymshytn(Integer pZtykigtignmrtitkjyurymshytn) {
        ztykigtignmrtitkjyurymshytn = pZtykigtignmrtitkjyurymshytn;
    }

    private Long ztykigtignmrtitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTITKJYUP)
    public Long getZtykigtignmrtitkjyup() {
        return ztykigtignmrtitkjyup;
    }

    public void setZtykigtignmrtitkjyup(Long pZtykigtignmrtitkjyup) {
        ztykigtignmrtitkjyup = pZtykigtignmrtitkjyup;
    }

    private String ztyhtnknkigtignmrtsyrikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTSYRIKGUX1)
    public String getZtyhtnknkigtignmrtsyrikgux1() {
        return ztyhtnknkigtignmrtsyrikgux1;
    }

    public void setZtyhtnknkigtignmrtsyrikgux1(String pZtyhtnknkigtignmrtsyrikgux1) {
        ztyhtnknkigtignmrtsyrikgux1 = pZtyhtnknkigtignmrtsyrikgux1;
    }

    private String ztyhtnknkigtignmrtsyrikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTSYRIKGUX2)
    public String getZtyhtnknkigtignmrtsyrikgux2() {
        return ztyhtnknkigtignmrtsyrikgux2;
    }

    public void setZtyhtnknkigtignmrtsyrikgux2(String pZtyhtnknkigtignmrtsyrikgux2) {
        ztyhtnknkigtignmrtsyrikgux2 = pZtyhtnknkigtignmrtsyrikgux2;
    }

    private String ztyhtnknkigtignmrtsyrikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTSYRIKGUX3)
    public String getZtyhtnknkigtignmrtsyrikgux3() {
        return ztyhtnknkigtignmrtsyrikgux3;
    }

    public void setZtyhtnknkigtignmrtsyrikgux3(String pZtyhtnknkigtignmrtsyrikgux3) {
        ztyhtnknkigtignmrtsyrikgux3 = pZtyhtnknkigtignmrtsyrikgux3;
    }

    private String ztyhtnknkigtignmrtsyrikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTSYRIKGUX4)
    public String getZtyhtnknkigtignmrtsyrikgux4() {
        return ztyhtnknkigtignmrtsyrikgux4;
    }

    public void setZtyhtnknkigtignmrtsyrikgux4(String pZtyhtnknkigtignmrtsyrikgux4) {
        ztyhtnknkigtignmrtsyrikgux4 = pZtyhtnknkigtignmrtsyrikgux4;
    }

    private String ztyhtnknkigtignmrtsyrikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTSYRIKGUX5)
    public String getZtyhtnknkigtignmrtsyrikgux5() {
        return ztyhtnknkigtignmrtsyrikgux5;
    }

    public void setZtyhtnknkigtignmrtsyrikgux5(String pZtyhtnknkigtignmrtsyrikgux5) {
        ztyhtnknkigtignmrtsyrikgux5 = pZtyhtnknkigtignmrtsyrikgux5;
    }

    private String ztyhtnknkigtignmrtsyrikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTSYRIKGUX6)
    public String getZtyhtnknkigtignmrtsyrikgux6() {
        return ztyhtnknkigtignmrtsyrikgux6;
    }

    public void setZtyhtnknkigtignmrtsyrikgux6(String pZtyhtnknkigtignmrtsyrikgux6) {
        ztyhtnknkigtignmrtsyrikgux6 = pZtyhtnknkigtignmrtsyrikgux6;
    }

    private String ztysurkigtignmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURKIGTIGNMRTIPWRBKKBN)
    public String getZtysurkigtignmrtipwrbkkbn() {
        return ztysurkigtignmrtipwrbkkbn;
    }

    public void setZtysurkigtignmrtipwrbkkbn(String pZtysurkigtignmrtipwrbkkbn) {
        ztysurkigtignmrtipwrbkkbn = pZtysurkigtignmrtipwrbkkbn;
    }

    private String ztykigtignmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTIPWRBKKBN)
    public String getZtykigtignmrtipwrbkkbn() {
        return ztykigtignmrtipwrbkkbn;
    }

    public void setZtykigtignmrtipwrbkkbn(String pZtykigtignmrtipwrbkkbn) {
        ztykigtignmrtipwrbkkbn = pZtykigtignmrtipwrbkkbn;
    }

    private String ztykigtignmrtitnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTITNKNYUGUKBN)
    public String getZtykigtignmrtitnknyugukbn() {
        return ztykigtignmrtitnknyugukbn;
    }

    public void setZtykigtignmrtitnknyugukbn(String pZtykigtignmrtitnknyugukbn) {
        ztykigtignmrtitnknyugukbn = pZtykigtignmrtitnknyugukbn;
    }

    private String ztykaigotignmrtikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTIGNMRTIKGUSDKBN)
    public String getZtykaigotignmrtikgusdkbn() {
        return ztykaigotignmrtikgusdkbn;
    }

    public void setZtykaigotignmrtikgusdkbn(String pZtykaigotignmrtikgusdkbn) {
        ztykaigotignmrtikgusdkbn = pZtykaigotignmrtikgusdkbn;
    }

    private String ztykigtignmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNMRTIKUSNMNRYOAGE)
    public String getZtykigtignmrtikusnmnryoage() {
        return ztykigtignmrtikusnmnryoage;
    }

    public void setZtykigtignmrtikusnmnryoage(String pZtykigtignmrtikusnmnryoage) {
        ztykigtignmrtikusnmnryoage = pZtykigtignmrtikusnmnryoage;
    }

    private String ztyyobiv4x15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV4X15)
    public String getZtyyobiv4x15() {
        return ztyyobiv4x15;
    }

    public void setZtyyobiv4x15(String pZtyyobiv4x15) {
        ztyyobiv4x15 = pZtyyobiv4x15;
    }

    private String ztykaigoteigentktisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENTKTISYURUIKGU)
    public String getZtykaigoteigentktisyuruikgu() {
        return ztykaigoteigentktisyuruikgu;
    }

    public void setZtykaigoteigentktisyuruikgu(String pZtykaigoteigentktisyuruikgu) {
        ztykaigoteigentktisyuruikgu = pZtykaigoteigentktisyuruikgu;
    }

    private String ztykaigoteigentokuteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENTOKUTEIKIKAN)
    public String getZtykaigoteigentokuteikikan() {
        return ztykaigoteigentokuteikikan;
    }

    public void setZtykaigoteigentokuteikikan(String pZtykaigoteigentokuteikikan) {
        ztykaigoteigentokuteikikan = pZtykaigoteigentokuteikikan;
    }

    private Long ztykaigoteigentokuteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENTOKUTEIS)
    public Long getZtykaigoteigentokuteis() {
        return ztykaigoteigentokuteis;
    }

    public void setZtykaigoteigentokuteis(Long pZtykaigoteigentokuteis) {
        ztykaigoteigentokuteis = pZtykaigoteigentokuteis;
    }

    private Long ztykaigoteigentokuteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTEIGENTOKUTEIP)
    public Long getZtykaigoteigentokuteip() {
        return ztykaigoteigentokuteip;
    }

    public void setZtykaigoteigentokuteip(Long pZtykaigoteigentokuteip) {
        ztykaigoteigentokuteip = pZtykaigoteigentokuteip;
    }

    private String ztykigtigntktisdtpdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNTKTISDTPDTKBN)
    public String getZtykigtigntktisdtpdtkbn() {
        return ztykigtigntktisdtpdtkbn;
    }

    public void setZtykigtigntktisdtpdtkbn(String pZtykigtigntktisdtpdtkbn) {
        ztykigtigntktisdtpdtkbn = pZtykigtigntktisdtpdtkbn;
    }

    private Long ztykigtigntktimods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNTKTIMODS)
    public Long getZtykigtigntktimods() {
        return ztykigtigntktimods;
    }

    public void setZtykigtigntktimods(Long pZtykigtigntktimods) {
        ztykigtigntktimods = pZtykigtigntktimods;
    }

    private String ztykaigotigntktikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTIGNTKTIKGUSDKBN)
    public String getZtykaigotigntktikgusdkbn() {
        return ztykaigotigntktikgusdkbn;
    }

    public void setZtykaigotigntktikgusdkbn(String pZtykaigotigntktikgusdkbn) {
        ztykaigotigntktikgusdkbn = pZtykaigotigntktikgusdkbn;
    }

    private String ztykigtigntktikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTIGNTKTIKUSNMNRYOAGE)
    public String getZtykigtigntktikusnmnryoage() {
        return ztykigtigntktikusnmnryoage;
    }

    public void setZtykigtigntktikusnmnryoage(String pZtykigtigntktikusnmnryoage) {
        ztykigtigntktikusnmnryoage = pZtykigtigntktikusnmnryoage;
    }

    private String ztyyobiv2x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV2X6)
    public String getZtyyobiv2x6() {
        return ztyyobiv2x6;
    }

    public void setZtyyobiv2x6(String pZtyyobiv2x6) {
        ztyyobiv2x6 = pZtyyobiv2x6;
    }

    private Long ztyhikitugikaimasis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHIKITUGIKAIMASIS)
    public Long getZtyhikitugikaimasis() {
        return ztyhikitugikaimasis;
    }

    public void setZtyhikitugikaimasis(Long pZtyhikitugikaimasis) {
        ztyhikitugikaimasis = pZtyhikitugikaimasis;
    }

    private String ztycbkyhtisyukykumkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKYHTISYUKYKUMKBN)
    public String getZtycbkyhtisyukykumkbn() {
        return ztycbkyhtisyukykumkbn;
    }

    public void setZtycbkyhtisyukykumkbn(String pZtycbkyhtisyukykumkbn) {
        ztycbkyhtisyukykumkbn = pZtycbkyhtisyukykumkbn;
    }

    private Long ztytukiyucbkyhtisyus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUKIYUCBKYHTISYUS)
    public Long getZtytukiyucbkyhtisyus() {
        return ztytukiyucbkyhtisyus;
    }

    public void setZtytukiyucbkyhtisyus(Long pZtytukiyucbkyhtisyus) {
        ztytukiyucbkyhtisyus = pZtytukiyucbkyhtisyus;
    }

    private Long ztycbhanteituusans;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBHANTEITUUSANS)
    public Long getZtycbhanteituusans() {
        return ztycbhanteituusans;
    }

    public void setZtycbhanteituusans(Long pZtycbhanteituusans) {
        ztycbhanteituusans = pZtycbhanteituusans;
    }

    private Long ztytukiyusnkykcbhntis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTUKIYUSNKYKCBHNTIS)
    public Long getZtytukiyusnkykcbhntis() {
        return ztytukiyusnkykcbhntis;
    }

    public void setZtytukiyusnkykcbhntis(Long pZtytukiyusnkykcbhntis) {
        ztytukiyusnkykcbhntis = pZtytukiyusnkykcbhntis;
    }

    private String ztycbstagekbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBSTAGEKBN)
    public String getZtycbstagekbn() {
        return ztycbstagekbn;
    }

    public void setZtycbstagekbn(String pZtycbstagekbn) {
        ztycbstagekbn = pZtycbstagekbn;
    }

    private Long ztytoukeiyoucbhanteituusans;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTOUKEIYOUCBHANTEITUUSANS)
    public Long getZtytoukeiyoucbhanteituusans() {
        return ztytoukeiyoucbhanteituusans;
    }

    public void setZtytoukeiyoucbhanteituusans(Long pZtytoukeiyoucbhanteituusans) {
        ztytoukeiyoucbhanteituusans = pZtytoukeiyoucbhanteituusans;
    }

    private Integer ztycbtuusankensuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBTUUSANKENSUU)
    public Integer getZtycbtuusankensuu() {
        return ztycbtuusankensuu;
    }

    public void setZtycbtuusankensuu(Integer pZtycbtuusankensuu) {
        ztycbtuusankensuu = pZtycbtuusankensuu;
    }

    private Integer ztycbhanteitaisyoutsnkensuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBHANTEITAISYOUTSNKENSUU)
    public Integer getZtycbhanteitaisyoutsnkensuu() {
        return ztycbhanteitaisyoutsnkensuu;
    }

    public void setZtycbhanteitaisyoutsnkensuu(Integer pZtycbhanteitaisyoutsnkensuu) {
        ztycbhanteitaisyoutsnkensuu = pZtycbhanteitaisyoutsnkensuu;
    }

    private Long ztytyokuzentuusanhanteisx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENTUUSANHANTEISX1)
    public Long getZtytyokuzentuusanhanteisx1() {
        return ztytyokuzentuusanhanteisx1;
    }

    public void setZtytyokuzentuusanhanteisx1(Long pZtytyokuzentuusanhanteisx1) {
        ztytyokuzentuusanhanteisx1 = pZtytyokuzentuusanhanteisx1;
    }

    private Long ztytyokuzenkyuuhutaisyousx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENKYUUHUTAISYOUSX1)
    public Long getZtytyokuzenkyuuhutaisyousx1() {
        return ztytyokuzenkyuuhutaisyousx1;
    }

    public void setZtytyokuzenkyuuhutaisyousx1(Long pZtytyokuzenkyuuhutaisyousx1) {
        ztytyokuzenkyuuhutaisyousx1 = pZtytyokuzenkyuuhutaisyousx1;
    }

    private Long ztytyokuzencbgakux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENCBGAKUX1)
    public Long getZtytyokuzencbgakux1() {
        return ztytyokuzencbgakux1;
    }

    public void setZtytyokuzencbgakux1(Long pZtytyokuzencbgakux1) {
        ztytyokuzencbgakux1 = pZtytyokuzencbgakux1;
    }

    private Long ztytyokugotuusanhanteisx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOTUUSANHANTEISX1)
    public Long getZtytyokugotuusanhanteisx1() {
        return ztytyokugotuusanhanteisx1;
    }

    public void setZtytyokugotuusanhanteisx1(Long pZtytyokugotuusanhanteisx1) {
        ztytyokugotuusanhanteisx1 = pZtytyokugotuusanhanteisx1;
    }

    private Long ztytyokugokyuuhutaisyousx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOKYUUHUTAISYOUSX1)
    public Long getZtytyokugokyuuhutaisyousx1() {
        return ztytyokugokyuuhutaisyousx1;
    }

    public void setZtytyokugokyuuhutaisyousx1(Long pZtytyokugokyuuhutaisyousx1) {
        ztytyokugokyuuhutaisyousx1 = pZtytyokugokyuuhutaisyousx1;
    }

    private Long ztytyokugocbgakux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOCBGAKUX1)
    public Long getZtytyokugocbgakux1() {
        return ztytyokugocbgakux1;
    }

    public void setZtytyokugocbgakux1(Long pZtytyokugocbgakux1) {
        ztytyokugocbgakux1 = pZtytyokugocbgakux1;
    }

    private String ztyyobiv12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private Long ztytyokuzentuusanhanteisx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENTUUSANHANTEISX2)
    public Long getZtytyokuzentuusanhanteisx2() {
        return ztytyokuzentuusanhanteisx2;
    }

    public void setZtytyokuzentuusanhanteisx2(Long pZtytyokuzentuusanhanteisx2) {
        ztytyokuzentuusanhanteisx2 = pZtytyokuzentuusanhanteisx2;
    }

    private Long ztytyokuzenkyuuhutaisyousx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENKYUUHUTAISYOUSX2)
    public Long getZtytyokuzenkyuuhutaisyousx2() {
        return ztytyokuzenkyuuhutaisyousx2;
    }

    public void setZtytyokuzenkyuuhutaisyousx2(Long pZtytyokuzenkyuuhutaisyousx2) {
        ztytyokuzenkyuuhutaisyousx2 = pZtytyokuzenkyuuhutaisyousx2;
    }

    private Long ztytyokuzencbgakux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENCBGAKUX2)
    public Long getZtytyokuzencbgakux2() {
        return ztytyokuzencbgakux2;
    }

    public void setZtytyokuzencbgakux2(Long pZtytyokuzencbgakux2) {
        ztytyokuzencbgakux2 = pZtytyokuzencbgakux2;
    }

    private Long ztytyokugotuusanhanteisx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOTUUSANHANTEISX2)
    public Long getZtytyokugotuusanhanteisx2() {
        return ztytyokugotuusanhanteisx2;
    }

    public void setZtytyokugotuusanhanteisx2(Long pZtytyokugotuusanhanteisx2) {
        ztytyokugotuusanhanteisx2 = pZtytyokugotuusanhanteisx2;
    }

    private Long ztytyokugokyuuhutaisyousx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOKYUUHUTAISYOUSX2)
    public Long getZtytyokugokyuuhutaisyousx2() {
        return ztytyokugokyuuhutaisyousx2;
    }

    public void setZtytyokugokyuuhutaisyousx2(Long pZtytyokugokyuuhutaisyousx2) {
        ztytyokugokyuuhutaisyousx2 = pZtytyokugokyuuhutaisyousx2;
    }

    private Long ztytyokugocbgakux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOCBGAKUX2)
    public Long getZtytyokugocbgakux2() {
        return ztytyokugocbgakux2;
    }

    public void setZtytyokugocbgakux2(Long pZtytyokugocbgakux2) {
        ztytyokugocbgakux2 = pZtytyokugocbgakux2;
    }

    private String ztyyobiv12x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X2)
    public String getZtyyobiv12x2() {
        return ztyyobiv12x2;
    }

    public void setZtyyobiv12x2(String pZtyyobiv12x2) {
        ztyyobiv12x2 = pZtyyobiv12x2;
    }

    private Long ztytyokuzentuusanhanteisx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENTUUSANHANTEISX3)
    public Long getZtytyokuzentuusanhanteisx3() {
        return ztytyokuzentuusanhanteisx3;
    }

    public void setZtytyokuzentuusanhanteisx3(Long pZtytyokuzentuusanhanteisx3) {
        ztytyokuzentuusanhanteisx3 = pZtytyokuzentuusanhanteisx3;
    }

    private Long ztytyokuzenkyuuhutaisyousx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENKYUUHUTAISYOUSX3)
    public Long getZtytyokuzenkyuuhutaisyousx3() {
        return ztytyokuzenkyuuhutaisyousx3;
    }

    public void setZtytyokuzenkyuuhutaisyousx3(Long pZtytyokuzenkyuuhutaisyousx3) {
        ztytyokuzenkyuuhutaisyousx3 = pZtytyokuzenkyuuhutaisyousx3;
    }

    private Long ztytyokuzencbgakux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENCBGAKUX3)
    public Long getZtytyokuzencbgakux3() {
        return ztytyokuzencbgakux3;
    }

    public void setZtytyokuzencbgakux3(Long pZtytyokuzencbgakux3) {
        ztytyokuzencbgakux3 = pZtytyokuzencbgakux3;
    }

    private Long ztytyokugotuusanhanteisx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOTUUSANHANTEISX3)
    public Long getZtytyokugotuusanhanteisx3() {
        return ztytyokugotuusanhanteisx3;
    }

    public void setZtytyokugotuusanhanteisx3(Long pZtytyokugotuusanhanteisx3) {
        ztytyokugotuusanhanteisx3 = pZtytyokugotuusanhanteisx3;
    }

    private Long ztytyokugokyuuhutaisyousx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOKYUUHUTAISYOUSX3)
    public Long getZtytyokugokyuuhutaisyousx3() {
        return ztytyokugokyuuhutaisyousx3;
    }

    public void setZtytyokugokyuuhutaisyousx3(Long pZtytyokugokyuuhutaisyousx3) {
        ztytyokugokyuuhutaisyousx3 = pZtytyokugokyuuhutaisyousx3;
    }

    private Long ztytyokugocbgakux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOCBGAKUX3)
    public Long getZtytyokugocbgakux3() {
        return ztytyokugocbgakux3;
    }

    public void setZtytyokugocbgakux3(Long pZtytyokugocbgakux3) {
        ztytyokugocbgakux3 = pZtytyokugocbgakux3;
    }

    private String ztyyobiv12x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X3)
    public String getZtyyobiv12x3() {
        return ztyyobiv12x3;
    }

    public void setZtyyobiv12x3(String pZtyyobiv12x3) {
        ztyyobiv12x3 = pZtyyobiv12x3;
    }

    private Long ztytyokuzentuusanhanteisx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENTUUSANHANTEISX4)
    public Long getZtytyokuzentuusanhanteisx4() {
        return ztytyokuzentuusanhanteisx4;
    }

    public void setZtytyokuzentuusanhanteisx4(Long pZtytyokuzentuusanhanteisx4) {
        ztytyokuzentuusanhanteisx4 = pZtytyokuzentuusanhanteisx4;
    }

    private Long ztytyokuzenkyuuhutaisyousx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENKYUUHUTAISYOUSX4)
    public Long getZtytyokuzenkyuuhutaisyousx4() {
        return ztytyokuzenkyuuhutaisyousx4;
    }

    public void setZtytyokuzenkyuuhutaisyousx4(Long pZtytyokuzenkyuuhutaisyousx4) {
        ztytyokuzenkyuuhutaisyousx4 = pZtytyokuzenkyuuhutaisyousx4;
    }

    private Long ztytyokuzencbgakux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENCBGAKUX4)
    public Long getZtytyokuzencbgakux4() {
        return ztytyokuzencbgakux4;
    }

    public void setZtytyokuzencbgakux4(Long pZtytyokuzencbgakux4) {
        ztytyokuzencbgakux4 = pZtytyokuzencbgakux4;
    }

    private Long ztytyokugotuusanhanteisx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOTUUSANHANTEISX4)
    public Long getZtytyokugotuusanhanteisx4() {
        return ztytyokugotuusanhanteisx4;
    }

    public void setZtytyokugotuusanhanteisx4(Long pZtytyokugotuusanhanteisx4) {
        ztytyokugotuusanhanteisx4 = pZtytyokugotuusanhanteisx4;
    }

    private Long ztytyokugokyuuhutaisyousx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOKYUUHUTAISYOUSX4)
    public Long getZtytyokugokyuuhutaisyousx4() {
        return ztytyokugokyuuhutaisyousx4;
    }

    public void setZtytyokugokyuuhutaisyousx4(Long pZtytyokugokyuuhutaisyousx4) {
        ztytyokugokyuuhutaisyousx4 = pZtytyokugokyuuhutaisyousx4;
    }

    private Long ztytyokugocbgakux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOCBGAKUX4)
    public Long getZtytyokugocbgakux4() {
        return ztytyokugocbgakux4;
    }

    public void setZtytyokugocbgakux4(Long pZtytyokugocbgakux4) {
        ztytyokugocbgakux4 = pZtytyokugocbgakux4;
    }

    private String ztyyobiv12x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X4)
    public String getZtyyobiv12x4() {
        return ztyyobiv12x4;
    }

    public void setZtyyobiv12x4(String pZtyyobiv12x4) {
        ztyyobiv12x4 = pZtyyobiv12x4;
    }

    private Long ztytyokuzentuusanhanteisx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENTUUSANHANTEISX5)
    public Long getZtytyokuzentuusanhanteisx5() {
        return ztytyokuzentuusanhanteisx5;
    }

    public void setZtytyokuzentuusanhanteisx5(Long pZtytyokuzentuusanhanteisx5) {
        ztytyokuzentuusanhanteisx5 = pZtytyokuzentuusanhanteisx5;
    }

    private Long ztytyokuzenkyuuhutaisyousx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENKYUUHUTAISYOUSX5)
    public Long getZtytyokuzenkyuuhutaisyousx5() {
        return ztytyokuzenkyuuhutaisyousx5;
    }

    public void setZtytyokuzenkyuuhutaisyousx5(Long pZtytyokuzenkyuuhutaisyousx5) {
        ztytyokuzenkyuuhutaisyousx5 = pZtytyokuzenkyuuhutaisyousx5;
    }

    private Long ztytyokuzencbgakux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENCBGAKUX5)
    public Long getZtytyokuzencbgakux5() {
        return ztytyokuzencbgakux5;
    }

    public void setZtytyokuzencbgakux5(Long pZtytyokuzencbgakux5) {
        ztytyokuzencbgakux5 = pZtytyokuzencbgakux5;
    }

    private Long ztytyokugotuusanhanteisx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOTUUSANHANTEISX5)
    public Long getZtytyokugotuusanhanteisx5() {
        return ztytyokugotuusanhanteisx5;
    }

    public void setZtytyokugotuusanhanteisx5(Long pZtytyokugotuusanhanteisx5) {
        ztytyokugotuusanhanteisx5 = pZtytyokugotuusanhanteisx5;
    }

    private Long ztytyokugokyuuhutaisyousx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOKYUUHUTAISYOUSX5)
    public Long getZtytyokugokyuuhutaisyousx5() {
        return ztytyokugokyuuhutaisyousx5;
    }

    public void setZtytyokugokyuuhutaisyousx5(Long pZtytyokugokyuuhutaisyousx5) {
        ztytyokugokyuuhutaisyousx5 = pZtytyokugokyuuhutaisyousx5;
    }

    private Long ztytyokugocbgakux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOCBGAKUX5)
    public Long getZtytyokugocbgakux5() {
        return ztytyokugocbgakux5;
    }

    public void setZtytyokugocbgakux5(Long pZtytyokugocbgakux5) {
        ztytyokugocbgakux5 = pZtytyokugocbgakux5;
    }

    private String ztyyobiv12x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X5)
    public String getZtyyobiv12x5() {
        return ztyyobiv12x5;
    }

    public void setZtyyobiv12x5(String pZtyyobiv12x5) {
        ztyyobiv12x5 = pZtyyobiv12x5;
    }

    private Long ztytyokuzentuusanhanteisx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENTUUSANHANTEISX6)
    public Long getZtytyokuzentuusanhanteisx6() {
        return ztytyokuzentuusanhanteisx6;
    }

    public void setZtytyokuzentuusanhanteisx6(Long pZtytyokuzentuusanhanteisx6) {
        ztytyokuzentuusanhanteisx6 = pZtytyokuzentuusanhanteisx6;
    }

    private Long ztytyokuzenkyuuhutaisyousx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENKYUUHUTAISYOUSX6)
    public Long getZtytyokuzenkyuuhutaisyousx6() {
        return ztytyokuzenkyuuhutaisyousx6;
    }

    public void setZtytyokuzenkyuuhutaisyousx6(Long pZtytyokuzenkyuuhutaisyousx6) {
        ztytyokuzenkyuuhutaisyousx6 = pZtytyokuzenkyuuhutaisyousx6;
    }

    private Long ztytyokuzencbgakux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUZENCBGAKUX6)
    public Long getZtytyokuzencbgakux6() {
        return ztytyokuzencbgakux6;
    }

    public void setZtytyokuzencbgakux6(Long pZtytyokuzencbgakux6) {
        ztytyokuzencbgakux6 = pZtytyokuzencbgakux6;
    }

    private Long ztytyokugotuusanhanteisx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOTUUSANHANTEISX6)
    public Long getZtytyokugotuusanhanteisx6() {
        return ztytyokugotuusanhanteisx6;
    }

    public void setZtytyokugotuusanhanteisx6(Long pZtytyokugotuusanhanteisx6) {
        ztytyokugotuusanhanteisx6 = pZtytyokugotuusanhanteisx6;
    }

    private Long ztytyokugokyuuhutaisyousx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOKYUUHUTAISYOUSX6)
    public Long getZtytyokugokyuuhutaisyousx6() {
        return ztytyokugokyuuhutaisyousx6;
    }

    public void setZtytyokugokyuuhutaisyousx6(Long pZtytyokugokyuuhutaisyousx6) {
        ztytyokugokyuuhutaisyousx6 = pZtytyokugokyuuhutaisyousx6;
    }

    private Long ztytyokugocbgakux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTYOKUGOCBGAKUX6)
    public Long getZtytyokugocbgakux6() {
        return ztytyokugocbgakux6;
    }

    public void setZtytyokugocbgakux6(Long pZtytyokugocbgakux6) {
        ztytyokugocbgakux6 = pZtytyokugocbgakux6;
    }

    private String ztyyobiv12x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X6)
    public String getZtyyobiv12x6() {
        return ztyyobiv12x6;
    }

    public void setZtyyobiv12x6(String pZtyyobiv12x6) {
        ztyyobiv12x6 = pZtyyobiv12x6;
    }

    private String ztycbkikyksyonox1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKSYONOX1)
    public String getZtycbkikyksyonox1() {
        return ztycbkikyksyonox1;
    }

    public void setZtycbkikyksyonox1(String pZtycbkikyksyonox1) {
        ztycbkikyksyonox1 = pZtycbkikyksyonox1;
    }

    private String ztycbkikykhknsyruikbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHKNSYRUIKBNX1)
    public String getZtycbkikykhknsyruikbnx1() {
        return ztycbkikykhknsyruikbnx1;
    }

    public void setZtycbkikykhknsyruikbnx1(String pZtycbkikykhknsyruikbnx1) {
        ztycbkikykhknsyruikbnx1 = pZtycbkikykhknsyruikbnx1;
    }

    private String ztycbkikeiyakukeiyakuymdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKEIYAKUKEIYAKUYMDX1)
    public String getZtycbkikeiyakukeiyakuymdx1() {
        return ztycbkikeiyakukeiyakuymdx1;
    }

    public void setZtycbkikeiyakukeiyakuymdx1(String pZtycbkikeiyakukeiyakuymdx1) {
        ztycbkikeiyakukeiyakuymdx1 = pZtycbkikeiyakukeiyakuymdx1;
    }

    private String ztycbkikykkyhtisyukbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKKYHTISYUKBNX1)
    public String getZtycbkikykkyhtisyukbnx1() {
        return ztycbkikykkyhtisyukbnx1;
    }

    public void setZtycbkikykkyhtisyukbnx1(String pZtycbkikykkyhtisyukbnx1) {
        ztycbkikykkyhtisyukbnx1 = pZtycbkikykkyhtisyukbnx1;
    }

    private String ztycbkikykhntitaisyoukbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHNTITAISYOUKBNX1)
    public String getZtycbkikykhntitaisyoukbnx1() {
        return ztycbkikykhntitaisyoukbnx1;
    }

    public void setZtycbkikykhntitaisyoukbnx1(String pZtycbkikykhntitaisyoukbnx1) {
        ztycbkikykhntitaisyoukbnx1 = pZtycbkikykhntitaisyoukbnx1;
    }

    private Long ztykikeiyakucbgakux1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUCBGAKUX1X1)
    public Long getZtykikeiyakucbgakux1x1() {
        return ztykikeiyakucbgakux1x1;
    }

    public void setZtykikeiyakucbgakux1x1(Long pZtykikeiyakucbgakux1x1) {
        ztykikeiyakucbgakux1x1 = pZtykikeiyakucbgakux1x1;
    }

    private Long ztykikeiyakucbgakux2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUCBGAKUX2X1)
    public Long getZtykikeiyakucbgakux2x1() {
        return ztykikeiyakucbgakux2x1;
    }

    public void setZtykikeiyakucbgakux2x1(Long pZtykikeiyakucbgakux2x1) {
        ztykikeiyakucbgakux2x1 = pZtykikeiyakucbgakux2x1;
    }

    private Long ztycbkikykhanteitsnsx1x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHANTEITSNSX1X1)
    public Long getZtycbkikykhanteitsnsx1x1() {
        return ztycbkikykhanteitsnsx1x1;
    }

    public void setZtycbkikykhanteitsnsx1x1(Long pZtycbkikykhanteitsnsx1x1) {
        ztycbkikykhanteitsnsx1x1 = pZtycbkikykhanteitsnsx1x1;
    }

    private Long ztycbkikykhanteitsnsx2x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHANTEITSNSX2X1)
    public Long getZtycbkikykhanteitsnsx2x1() {
        return ztycbkikykhanteitsnsx2x1;
    }

    public void setZtycbkikykhanteitsnsx2x1(Long pZtycbkikykhanteitsnsx2x1) {
        ztycbkikykhanteitsnsx2x1 = pZtycbkikykhanteitsnsx2x1;
    }

    private String ztyyobiv12x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X7)
    public String getZtyyobiv12x7() {
        return ztyyobiv12x7;
    }

    public void setZtyyobiv12x7(String pZtyyobiv12x7) {
        ztyyobiv12x7 = pZtyyobiv12x7;
    }

    private String ztycbkikyksyonox2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKSYONOX2)
    public String getZtycbkikyksyonox2() {
        return ztycbkikyksyonox2;
    }

    public void setZtycbkikyksyonox2(String pZtycbkikyksyonox2) {
        ztycbkikyksyonox2 = pZtycbkikyksyonox2;
    }

    private String ztycbkikykhknsyruikbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHKNSYRUIKBNX2)
    public String getZtycbkikykhknsyruikbnx2() {
        return ztycbkikykhknsyruikbnx2;
    }

    public void setZtycbkikykhknsyruikbnx2(String pZtycbkikykhknsyruikbnx2) {
        ztycbkikykhknsyruikbnx2 = pZtycbkikykhknsyruikbnx2;
    }

    private String ztycbkikeiyakukeiyakuymdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKEIYAKUKEIYAKUYMDX2)
    public String getZtycbkikeiyakukeiyakuymdx2() {
        return ztycbkikeiyakukeiyakuymdx2;
    }

    public void setZtycbkikeiyakukeiyakuymdx2(String pZtycbkikeiyakukeiyakuymdx2) {
        ztycbkikeiyakukeiyakuymdx2 = pZtycbkikeiyakukeiyakuymdx2;
    }

    private String ztycbkikykkyhtisyukbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKKYHTISYUKBNX2)
    public String getZtycbkikykkyhtisyukbnx2() {
        return ztycbkikykkyhtisyukbnx2;
    }

    public void setZtycbkikykkyhtisyukbnx2(String pZtycbkikykkyhtisyukbnx2) {
        ztycbkikykkyhtisyukbnx2 = pZtycbkikykkyhtisyukbnx2;
    }

    private String ztycbkikykhntitaisyoukbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHNTITAISYOUKBNX2)
    public String getZtycbkikykhntitaisyoukbnx2() {
        return ztycbkikykhntitaisyoukbnx2;
    }

    public void setZtycbkikykhntitaisyoukbnx2(String pZtycbkikykhntitaisyoukbnx2) {
        ztycbkikykhntitaisyoukbnx2 = pZtycbkikykhntitaisyoukbnx2;
    }

    private Long ztykikeiyakucbgakux1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUCBGAKUX1X2)
    public Long getZtykikeiyakucbgakux1x2() {
        return ztykikeiyakucbgakux1x2;
    }

    public void setZtykikeiyakucbgakux1x2(Long pZtykikeiyakucbgakux1x2) {
        ztykikeiyakucbgakux1x2 = pZtykikeiyakucbgakux1x2;
    }

    private Long ztykikeiyakucbgakux2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUCBGAKUX2X2)
    public Long getZtykikeiyakucbgakux2x2() {
        return ztykikeiyakucbgakux2x2;
    }

    public void setZtykikeiyakucbgakux2x2(Long pZtykikeiyakucbgakux2x2) {
        ztykikeiyakucbgakux2x2 = pZtykikeiyakucbgakux2x2;
    }

    private Long ztycbkikykhanteitsnsx1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHANTEITSNSX1X2)
    public Long getZtycbkikykhanteitsnsx1x2() {
        return ztycbkikykhanteitsnsx1x2;
    }

    public void setZtycbkikykhanteitsnsx1x2(Long pZtycbkikykhanteitsnsx1x2) {
        ztycbkikykhanteitsnsx1x2 = pZtycbkikykhanteitsnsx1x2;
    }

    private Long ztycbkikykhanteitsnsx2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHANTEITSNSX2X2)
    public Long getZtycbkikykhanteitsnsx2x2() {
        return ztycbkikykhanteitsnsx2x2;
    }

    public void setZtycbkikykhanteitsnsx2x2(Long pZtycbkikykhanteitsnsx2x2) {
        ztycbkikykhanteitsnsx2x2 = pZtycbkikykhanteitsnsx2x2;
    }

    private String ztyyobiv12x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X8)
    public String getZtyyobiv12x8() {
        return ztyyobiv12x8;
    }

    public void setZtyyobiv12x8(String pZtyyobiv12x8) {
        ztyyobiv12x8 = pZtyyobiv12x8;
    }

    private String ztycbkikyksyonox3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKSYONOX3)
    public String getZtycbkikyksyonox3() {
        return ztycbkikyksyonox3;
    }

    public void setZtycbkikyksyonox3(String pZtycbkikyksyonox3) {
        ztycbkikyksyonox3 = pZtycbkikyksyonox3;
    }

    private String ztycbkikykhknsyruikbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHKNSYRUIKBNX3)
    public String getZtycbkikykhknsyruikbnx3() {
        return ztycbkikykhknsyruikbnx3;
    }

    public void setZtycbkikykhknsyruikbnx3(String pZtycbkikykhknsyruikbnx3) {
        ztycbkikykhknsyruikbnx3 = pZtycbkikykhknsyruikbnx3;
    }

    private String ztycbkikeiyakukeiyakuymdx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKEIYAKUKEIYAKUYMDX3)
    public String getZtycbkikeiyakukeiyakuymdx3() {
        return ztycbkikeiyakukeiyakuymdx3;
    }

    public void setZtycbkikeiyakukeiyakuymdx3(String pZtycbkikeiyakukeiyakuymdx3) {
        ztycbkikeiyakukeiyakuymdx3 = pZtycbkikeiyakukeiyakuymdx3;
    }

    private String ztycbkikykkyhtisyukbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKKYHTISYUKBNX3)
    public String getZtycbkikykkyhtisyukbnx3() {
        return ztycbkikykkyhtisyukbnx3;
    }

    public void setZtycbkikykkyhtisyukbnx3(String pZtycbkikykkyhtisyukbnx3) {
        ztycbkikykkyhtisyukbnx3 = pZtycbkikykkyhtisyukbnx3;
    }

    private String ztycbkikykhntitaisyoukbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHNTITAISYOUKBNX3)
    public String getZtycbkikykhntitaisyoukbnx3() {
        return ztycbkikykhntitaisyoukbnx3;
    }

    public void setZtycbkikykhntitaisyoukbnx3(String pZtycbkikykhntitaisyoukbnx3) {
        ztycbkikykhntitaisyoukbnx3 = pZtycbkikykhntitaisyoukbnx3;
    }

    private Long ztykikeiyakucbgakux1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUCBGAKUX1X3)
    public Long getZtykikeiyakucbgakux1x3() {
        return ztykikeiyakucbgakux1x3;
    }

    public void setZtykikeiyakucbgakux1x3(Long pZtykikeiyakucbgakux1x3) {
        ztykikeiyakucbgakux1x3 = pZtykikeiyakucbgakux1x3;
    }

    private Long ztykikeiyakucbgakux2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIKEIYAKUCBGAKUX2X3)
    public Long getZtykikeiyakucbgakux2x3() {
        return ztykikeiyakucbgakux2x3;
    }

    public void setZtykikeiyakucbgakux2x3(Long pZtykikeiyakucbgakux2x3) {
        ztykikeiyakucbgakux2x3 = pZtykikeiyakucbgakux2x3;
    }

    private Long ztycbkikykhanteitsnsx1x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHANTEITSNSX1X3)
    public Long getZtycbkikykhanteitsnsx1x3() {
        return ztycbkikykhanteitsnsx1x3;
    }

    public void setZtycbkikykhanteitsnsx1x3(Long pZtycbkikykhanteitsnsx1x3) {
        ztycbkikykhanteitsnsx1x3 = pZtycbkikykhanteitsnsx1x3;
    }

    private Long ztycbkikykhanteitsnsx2x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYCBKIKYKHANTEITSNSX2X3)
    public Long getZtycbkikykhanteitsnsx2x3() {
        return ztycbkikykhanteitsnsx2x3;
    }

    public void setZtycbkikykhanteitsnsx2x3(Long pZtycbkikykhanteitsnsx2x3) {
        ztycbkikykhanteitsnsx2x3 = pZtycbkikykhanteitsnsx2x3;
    }

    private String ztyyobiv12x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X9)
    public String getZtyyobiv12x9() {
        return ztyyobiv12x9;
    }

    public void setZtyyobiv12x9(String pZtyyobiv12x9) {
        ztyyobiv12x9 = pZtyyobiv12x9;
    }

    private String ztyhtnknhknsyrikgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNHKNSYRIKGUSDKBNX1)
    public String getZtyhtnknhknsyrikgusdkbnx1() {
        return ztyhtnknhknsyrikgusdkbnx1;
    }

    public void setZtyhtnknhknsyrikgusdkbnx1(String pZtyhtnknhknsyrikgusdkbnx1) {
        ztyhtnknhknsyrikgusdkbnx1 = pZtyhtnknhknsyrikgusdkbnx1;
    }

    private String ztyhtnknmrtikgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMRTIKGUSDKBNX1)
    public String getZtyhtnknmrtikgusdkbnx1() {
        return ztyhtnknmrtikgusdkbnx1;
    }

    public void setZtyhtnknmrtikgusdkbnx1(String pZtyhtnknmrtikgusdkbnx1) {
        ztyhtnknmrtikgusdkbnx1 = pZtyhtnknmrtikgusdkbnx1;
    }

    private String ztyhtnknsiznmrtikgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIZNMRTIKGUSDKBNX1)
    public String getZtyhtnknsiznmrtikgusdkbnx1() {
        return ztyhtnknsiznmrtikgusdkbnx1;
    }

    public void setZtyhtnknsiznmrtikgusdkbnx1(String pZtyhtnknsiznmrtikgusdkbnx1) {
        ztyhtnknsiznmrtikgusdkbnx1 = pZtyhtnknsiznmrtikgusdkbnx1;
    }

    private String ztyhtnkntignmrtikgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTIGNMRTIKGUSDKBNX1)
    public String getZtyhtnkntignmrtikgusdkbnx1() {
        return ztyhtnkntignmrtikgusdkbnx1;
    }

    public void setZtyhtnkntignmrtikgusdkbnx1(String pZtyhtnkntignmrtikgusdkbnx1) {
        ztyhtnkntignmrtikgusdkbnx1 = pZtyhtnkntignmrtikgusdkbnx1;
    }

    private String ztyhtnknnkmrtikgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKMRTIKGUSDKBNX1)
    public String getZtyhtnknnkmrtikgusdkbnx1() {
        return ztyhtnknnkmrtikgusdkbnx1;
    }

    public void setZtyhtnknnkmrtikgusdkbnx1(String pZtyhtnknnkmrtikgusdkbnx1) {
        ztyhtnknnkmrtikgusdkbnx1 = pZtyhtnknnkmrtikgusdkbnx1;
    }

    private String ztyhtnkntkstkgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKSTKGUSDKBNX1)
    public String getZtyhtnkntkstkgusdkbnx1() {
        return ztyhtnkntkstkgusdkbnx1;
    }

    public void setZtyhtnkntkstkgusdkbnx1(String pZtyhtnkntkstkgusdkbnx1) {
        ztyhtnkntkstkgusdkbnx1 = pZtyhtnkntkstkgusdkbnx1;
    }

    private String ztyhtnkndi2tkstkgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKSTKGUSDKBNX1)
    public String getZtyhtnkndi2tkstkgusdkbnx1() {
        return ztyhtnkndi2tkstkgusdkbnx1;
    }

    public void setZtyhtnkndi2tkstkgusdkbnx1(String pZtyhtnkndi2tkstkgusdkbnx1) {
        ztyhtnkndi2tkstkgusdkbnx1 = pZtyhtnkndi2tkstkgusdkbnx1;
    }

    private String ztyhtnknjyustkgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYUSTKGUSDKBNX1)
    public String getZtyhtnknjyustkgusdkbnx1() {
        return ztyhtnknjyustkgusdkbnx1;
    }

    public void setZtyhtnknjyustkgusdkbnx1(String pZtyhtnknjyustkgusdkbnx1) {
        ztyhtnknjyustkgusdkbnx1 = pZtyhtnknjyustkgusdkbnx1;
    }

    private String ztyhtnkndi2jysitkgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2JYSITKGUSDKBNX1)
    public String getZtyhtnkndi2jysitkgusdkbnx1() {
        return ztyhtnkndi2jysitkgusdkbnx1;
    }

    public void setZtyhtnkndi2jysitkgusdkbnx1(String pZtyhtnkndi2jysitkgusdkbnx1) {
        ztyhtnkndi2jysitkgusdkbnx1 = pZtyhtnkndi2jysitkgusdkbnx1;
    }

    private String ztyhtnknkaigonkmrtisdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTISDKBNX1)
    public String getZtyhtnknkaigonkmrtisdkbnx1() {
        return ztyhtnknkaigonkmrtisdkbnx1;
    }

    public void setZtyhtnknkaigonkmrtisdkbnx1(String pZtyhtnknkaigonkmrtisdkbnx1) {
        ztyhtnknkaigonkmrtisdkbnx1 = pZtyhtnknkaigonkmrtisdkbnx1;
    }

    private String ztyhtnknkigtignmrtisdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTISDKBNX1)
    public String getZtyhtnknkigtignmrtisdkbnx1() {
        return ztyhtnknkigtignmrtisdkbnx1;
    }

    public void setZtyhtnknkigtignmrtisdkbnx1(String pZtyhtnknkigtignmrtisdkbnx1) {
        ztyhtnknkigtignmrtisdkbnx1 = pZtyhtnknkigtignmrtisdkbnx1;
    }

    private String ztyhtnknkaigomrsykgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRSYKGUSDKBNX1)
    public String getZtyhtnknkaigomrsykgusdkbnx1() {
        return ztyhtnknkaigomrsykgusdkbnx1;
    }

    public void setZtyhtnknkaigomrsykgusdkbnx1(String pZtyhtnknkaigomrsykgusdkbnx1) {
        ztyhtnknkaigomrsykgusdkbnx1 = pZtyhtnknkaigomrsykgusdkbnx1;
    }

    private String ztysuuriyouyobiv8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSUURIYOUYOBIV8X2)
    public String getZtysuuriyouyobiv8x2() {
        return ztysuuriyouyobiv8x2;
    }

    public void setZtysuuriyouyobiv8x2(String pZtysuuriyouyobiv8x2) {
        ztysuuriyouyobiv8x2 = pZtysuuriyouyobiv8x2;
    }

    private String ztyhtnknhknsyrikgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNHKNSYRIKGUSDKBNX2)
    public String getZtyhtnknhknsyrikgusdkbnx2() {
        return ztyhtnknhknsyrikgusdkbnx2;
    }

    public void setZtyhtnknhknsyrikgusdkbnx2(String pZtyhtnknhknsyrikgusdkbnx2) {
        ztyhtnknhknsyrikgusdkbnx2 = pZtyhtnknhknsyrikgusdkbnx2;
    }

    private String ztyhtnknmrtikgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMRTIKGUSDKBNX2)
    public String getZtyhtnknmrtikgusdkbnx2() {
        return ztyhtnknmrtikgusdkbnx2;
    }

    public void setZtyhtnknmrtikgusdkbnx2(String pZtyhtnknmrtikgusdkbnx2) {
        ztyhtnknmrtikgusdkbnx2 = pZtyhtnknmrtikgusdkbnx2;
    }

    private String ztyhtnknsiznmrtikgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIZNMRTIKGUSDKBNX2)
    public String getZtyhtnknsiznmrtikgusdkbnx2() {
        return ztyhtnknsiznmrtikgusdkbnx2;
    }

    public void setZtyhtnknsiznmrtikgusdkbnx2(String pZtyhtnknsiznmrtikgusdkbnx2) {
        ztyhtnknsiznmrtikgusdkbnx2 = pZtyhtnknsiznmrtikgusdkbnx2;
    }

    private String ztyhtnkntignmrtikgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTIGNMRTIKGUSDKBNX2)
    public String getZtyhtnkntignmrtikgusdkbnx2() {
        return ztyhtnkntignmrtikgusdkbnx2;
    }

    public void setZtyhtnkntignmrtikgusdkbnx2(String pZtyhtnkntignmrtikgusdkbnx2) {
        ztyhtnkntignmrtikgusdkbnx2 = pZtyhtnkntignmrtikgusdkbnx2;
    }

    private String ztyhtnknnkmrtikgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKMRTIKGUSDKBNX2)
    public String getZtyhtnknnkmrtikgusdkbnx2() {
        return ztyhtnknnkmrtikgusdkbnx2;
    }

    public void setZtyhtnknnkmrtikgusdkbnx2(String pZtyhtnknnkmrtikgusdkbnx2) {
        ztyhtnknnkmrtikgusdkbnx2 = pZtyhtnknnkmrtikgusdkbnx2;
    }

    private String ztyhtnkntkstkgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKSTKGUSDKBNX2)
    public String getZtyhtnkntkstkgusdkbnx2() {
        return ztyhtnkntkstkgusdkbnx2;
    }

    public void setZtyhtnkntkstkgusdkbnx2(String pZtyhtnkntkstkgusdkbnx2) {
        ztyhtnkntkstkgusdkbnx2 = pZtyhtnkntkstkgusdkbnx2;
    }

    private String ztyhtnkndi2tkstkgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKSTKGUSDKBNX2)
    public String getZtyhtnkndi2tkstkgusdkbnx2() {
        return ztyhtnkndi2tkstkgusdkbnx2;
    }

    public void setZtyhtnkndi2tkstkgusdkbnx2(String pZtyhtnkndi2tkstkgusdkbnx2) {
        ztyhtnkndi2tkstkgusdkbnx2 = pZtyhtnkndi2tkstkgusdkbnx2;
    }

    private String ztyhtnknjyustkgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYUSTKGUSDKBNX2)
    public String getZtyhtnknjyustkgusdkbnx2() {
        return ztyhtnknjyustkgusdkbnx2;
    }

    public void setZtyhtnknjyustkgusdkbnx2(String pZtyhtnknjyustkgusdkbnx2) {
        ztyhtnknjyustkgusdkbnx2 = pZtyhtnknjyustkgusdkbnx2;
    }

    private String ztyhtnkndi2jysitkgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2JYSITKGUSDKBNX2)
    public String getZtyhtnkndi2jysitkgusdkbnx2() {
        return ztyhtnkndi2jysitkgusdkbnx2;
    }

    public void setZtyhtnkndi2jysitkgusdkbnx2(String pZtyhtnkndi2jysitkgusdkbnx2) {
        ztyhtnkndi2jysitkgusdkbnx2 = pZtyhtnkndi2jysitkgusdkbnx2;
    }

    private String ztyhtnknkaigonkmrtisdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTISDKBNX2)
    public String getZtyhtnknkaigonkmrtisdkbnx2() {
        return ztyhtnknkaigonkmrtisdkbnx2;
    }

    public void setZtyhtnknkaigonkmrtisdkbnx2(String pZtyhtnknkaigonkmrtisdkbnx2) {
        ztyhtnknkaigonkmrtisdkbnx2 = pZtyhtnknkaigonkmrtisdkbnx2;
    }

    private String ztyhtnknkigtignmrtisdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTISDKBNX2)
    public String getZtyhtnknkigtignmrtisdkbnx2() {
        return ztyhtnknkigtignmrtisdkbnx2;
    }

    public void setZtyhtnknkigtignmrtisdkbnx2(String pZtyhtnknkigtignmrtisdkbnx2) {
        ztyhtnknkigtignmrtisdkbnx2 = pZtyhtnknkigtignmrtisdkbnx2;
    }

    private String ztyhtnknkaigomrsykgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRSYKGUSDKBNX2)
    public String getZtyhtnknkaigomrsykgusdkbnx2() {
        return ztyhtnknkaigomrsykgusdkbnx2;
    }

    public void setZtyhtnknkaigomrsykgusdkbnx2(String pZtyhtnknkaigomrsykgusdkbnx2) {
        ztyhtnknkaigomrsykgusdkbnx2 = pZtyhtnknkaigomrsykgusdkbnx2;
    }

    private String ztyyobiv8x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X5)
    public String getZtyyobiv8x5() {
        return ztyyobiv8x5;
    }

    public void setZtyyobiv8x5(String pZtyyobiv8x5) {
        ztyyobiv8x5 = pZtyyobiv8x5;
    }

    private String ztyhtnknhknsyrikgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNHKNSYRIKGUSDKBNX3)
    public String getZtyhtnknhknsyrikgusdkbnx3() {
        return ztyhtnknhknsyrikgusdkbnx3;
    }

    public void setZtyhtnknhknsyrikgusdkbnx3(String pZtyhtnknhknsyrikgusdkbnx3) {
        ztyhtnknhknsyrikgusdkbnx3 = pZtyhtnknhknsyrikgusdkbnx3;
    }

    private String ztyhtnknmrtikgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMRTIKGUSDKBNX3)
    public String getZtyhtnknmrtikgusdkbnx3() {
        return ztyhtnknmrtikgusdkbnx3;
    }

    public void setZtyhtnknmrtikgusdkbnx3(String pZtyhtnknmrtikgusdkbnx3) {
        ztyhtnknmrtikgusdkbnx3 = pZtyhtnknmrtikgusdkbnx3;
    }

    private String ztyhtnknsiznmrtikgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIZNMRTIKGUSDKBNX3)
    public String getZtyhtnknsiznmrtikgusdkbnx3() {
        return ztyhtnknsiznmrtikgusdkbnx3;
    }

    public void setZtyhtnknsiznmrtikgusdkbnx3(String pZtyhtnknsiznmrtikgusdkbnx3) {
        ztyhtnknsiznmrtikgusdkbnx3 = pZtyhtnknsiznmrtikgusdkbnx3;
    }

    private String ztyhtnkntignmrtikgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTIGNMRTIKGUSDKBNX3)
    public String getZtyhtnkntignmrtikgusdkbnx3() {
        return ztyhtnkntignmrtikgusdkbnx3;
    }

    public void setZtyhtnkntignmrtikgusdkbnx3(String pZtyhtnkntignmrtikgusdkbnx3) {
        ztyhtnkntignmrtikgusdkbnx3 = pZtyhtnkntignmrtikgusdkbnx3;
    }

    private String ztyhtnknnkmrtikgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKMRTIKGUSDKBNX3)
    public String getZtyhtnknnkmrtikgusdkbnx3() {
        return ztyhtnknnkmrtikgusdkbnx3;
    }

    public void setZtyhtnknnkmrtikgusdkbnx3(String pZtyhtnknnkmrtikgusdkbnx3) {
        ztyhtnknnkmrtikgusdkbnx3 = pZtyhtnknnkmrtikgusdkbnx3;
    }

    private String ztyhtnkntkstkgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKSTKGUSDKBNX3)
    public String getZtyhtnkntkstkgusdkbnx3() {
        return ztyhtnkntkstkgusdkbnx3;
    }

    public void setZtyhtnkntkstkgusdkbnx3(String pZtyhtnkntkstkgusdkbnx3) {
        ztyhtnkntkstkgusdkbnx3 = pZtyhtnkntkstkgusdkbnx3;
    }

    private String ztyhtnkndi2tkstkgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKSTKGUSDKBNX3)
    public String getZtyhtnkndi2tkstkgusdkbnx3() {
        return ztyhtnkndi2tkstkgusdkbnx3;
    }

    public void setZtyhtnkndi2tkstkgusdkbnx3(String pZtyhtnkndi2tkstkgusdkbnx3) {
        ztyhtnkndi2tkstkgusdkbnx3 = pZtyhtnkndi2tkstkgusdkbnx3;
    }

    private String ztyhtnknjyustkgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYUSTKGUSDKBNX3)
    public String getZtyhtnknjyustkgusdkbnx3() {
        return ztyhtnknjyustkgusdkbnx3;
    }

    public void setZtyhtnknjyustkgusdkbnx3(String pZtyhtnknjyustkgusdkbnx3) {
        ztyhtnknjyustkgusdkbnx3 = pZtyhtnknjyustkgusdkbnx3;
    }

    private String ztyhtnkndi2jysitkgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2JYSITKGUSDKBNX3)
    public String getZtyhtnkndi2jysitkgusdkbnx3() {
        return ztyhtnkndi2jysitkgusdkbnx3;
    }

    public void setZtyhtnkndi2jysitkgusdkbnx3(String pZtyhtnkndi2jysitkgusdkbnx3) {
        ztyhtnkndi2jysitkgusdkbnx3 = pZtyhtnkndi2jysitkgusdkbnx3;
    }

    private String ztyhtnknkaigonkmrtisdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTISDKBNX3)
    public String getZtyhtnknkaigonkmrtisdkbnx3() {
        return ztyhtnknkaigonkmrtisdkbnx3;
    }

    public void setZtyhtnknkaigonkmrtisdkbnx3(String pZtyhtnknkaigonkmrtisdkbnx3) {
        ztyhtnknkaigonkmrtisdkbnx3 = pZtyhtnknkaigonkmrtisdkbnx3;
    }

    private String ztyhtnknkigtignmrtisdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTISDKBNX3)
    public String getZtyhtnknkigtignmrtisdkbnx3() {
        return ztyhtnknkigtignmrtisdkbnx3;
    }

    public void setZtyhtnknkigtignmrtisdkbnx3(String pZtyhtnknkigtignmrtisdkbnx3) {
        ztyhtnknkigtignmrtisdkbnx3 = pZtyhtnknkigtignmrtisdkbnx3;
    }

    private String ztyhtnknkaigomrsykgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRSYKGUSDKBNX3)
    public String getZtyhtnknkaigomrsykgusdkbnx3() {
        return ztyhtnknkaigomrsykgusdkbnx3;
    }

    public void setZtyhtnknkaigomrsykgusdkbnx3(String pZtyhtnknkaigomrsykgusdkbnx3) {
        ztyhtnknkaigomrsykgusdkbnx3 = pZtyhtnknkaigomrsykgusdkbnx3;
    }

    private String ztyyobiv8x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X6)
    public String getZtyyobiv8x6() {
        return ztyyobiv8x6;
    }

    public void setZtyyobiv8x6(String pZtyyobiv8x6) {
        ztyyobiv8x6 = pZtyyobiv8x6;
    }

    private String ztyhtnknhknsyrikgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNHKNSYRIKGUSDKBNX4)
    public String getZtyhtnknhknsyrikgusdkbnx4() {
        return ztyhtnknhknsyrikgusdkbnx4;
    }

    public void setZtyhtnknhknsyrikgusdkbnx4(String pZtyhtnknhknsyrikgusdkbnx4) {
        ztyhtnknhknsyrikgusdkbnx4 = pZtyhtnknhknsyrikgusdkbnx4;
    }

    private String ztyhtnknmrtikgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMRTIKGUSDKBNX4)
    public String getZtyhtnknmrtikgusdkbnx4() {
        return ztyhtnknmrtikgusdkbnx4;
    }

    public void setZtyhtnknmrtikgusdkbnx4(String pZtyhtnknmrtikgusdkbnx4) {
        ztyhtnknmrtikgusdkbnx4 = pZtyhtnknmrtikgusdkbnx4;
    }

    private String ztyhtnknsiznmrtikgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIZNMRTIKGUSDKBNX4)
    public String getZtyhtnknsiznmrtikgusdkbnx4() {
        return ztyhtnknsiznmrtikgusdkbnx4;
    }

    public void setZtyhtnknsiznmrtikgusdkbnx4(String pZtyhtnknsiznmrtikgusdkbnx4) {
        ztyhtnknsiznmrtikgusdkbnx4 = pZtyhtnknsiznmrtikgusdkbnx4;
    }

    private String ztyhtnkntignmrtikgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTIGNMRTIKGUSDKBNX4)
    public String getZtyhtnkntignmrtikgusdkbnx4() {
        return ztyhtnkntignmrtikgusdkbnx4;
    }

    public void setZtyhtnkntignmrtikgusdkbnx4(String pZtyhtnkntignmrtikgusdkbnx4) {
        ztyhtnkntignmrtikgusdkbnx4 = pZtyhtnkntignmrtikgusdkbnx4;
    }

    private String ztyhtnknnkmrtikgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKMRTIKGUSDKBNX4)
    public String getZtyhtnknnkmrtikgusdkbnx4() {
        return ztyhtnknnkmrtikgusdkbnx4;
    }

    public void setZtyhtnknnkmrtikgusdkbnx4(String pZtyhtnknnkmrtikgusdkbnx4) {
        ztyhtnknnkmrtikgusdkbnx4 = pZtyhtnknnkmrtikgusdkbnx4;
    }

    private String ztyhtnkntkstkgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKSTKGUSDKBNX4)
    public String getZtyhtnkntkstkgusdkbnx4() {
        return ztyhtnkntkstkgusdkbnx4;
    }

    public void setZtyhtnkntkstkgusdkbnx4(String pZtyhtnkntkstkgusdkbnx4) {
        ztyhtnkntkstkgusdkbnx4 = pZtyhtnkntkstkgusdkbnx4;
    }

    private String ztyhtnkndi2tkstkgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKSTKGUSDKBNX4)
    public String getZtyhtnkndi2tkstkgusdkbnx4() {
        return ztyhtnkndi2tkstkgusdkbnx4;
    }

    public void setZtyhtnkndi2tkstkgusdkbnx4(String pZtyhtnkndi2tkstkgusdkbnx4) {
        ztyhtnkndi2tkstkgusdkbnx4 = pZtyhtnkndi2tkstkgusdkbnx4;
    }

    private String ztyhtnknjyustkgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYUSTKGUSDKBNX4)
    public String getZtyhtnknjyustkgusdkbnx4() {
        return ztyhtnknjyustkgusdkbnx4;
    }

    public void setZtyhtnknjyustkgusdkbnx4(String pZtyhtnknjyustkgusdkbnx4) {
        ztyhtnknjyustkgusdkbnx4 = pZtyhtnknjyustkgusdkbnx4;
    }

    private String ztyhtnkndi2jysitkgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2JYSITKGUSDKBNX4)
    public String getZtyhtnkndi2jysitkgusdkbnx4() {
        return ztyhtnkndi2jysitkgusdkbnx4;
    }

    public void setZtyhtnkndi2jysitkgusdkbnx4(String pZtyhtnkndi2jysitkgusdkbnx4) {
        ztyhtnkndi2jysitkgusdkbnx4 = pZtyhtnkndi2jysitkgusdkbnx4;
    }

    private String ztyhtnknkaigonkmrtisdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTISDKBNX4)
    public String getZtyhtnknkaigonkmrtisdkbnx4() {
        return ztyhtnknkaigonkmrtisdkbnx4;
    }

    public void setZtyhtnknkaigonkmrtisdkbnx4(String pZtyhtnknkaigonkmrtisdkbnx4) {
        ztyhtnknkaigonkmrtisdkbnx4 = pZtyhtnknkaigonkmrtisdkbnx4;
    }

    private String ztyhtnknkigtignmrtisdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTISDKBNX4)
    public String getZtyhtnknkigtignmrtisdkbnx4() {
        return ztyhtnknkigtignmrtisdkbnx4;
    }

    public void setZtyhtnknkigtignmrtisdkbnx4(String pZtyhtnknkigtignmrtisdkbnx4) {
        ztyhtnknkigtignmrtisdkbnx4 = pZtyhtnknkigtignmrtisdkbnx4;
    }

    private String ztyhtnknkaigomrsykgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRSYKGUSDKBNX4)
    public String getZtyhtnknkaigomrsykgusdkbnx4() {
        return ztyhtnknkaigomrsykgusdkbnx4;
    }

    public void setZtyhtnknkaigomrsykgusdkbnx4(String pZtyhtnknkaigomrsykgusdkbnx4) {
        ztyhtnknkaigomrsykgusdkbnx4 = pZtyhtnknkaigomrsykgusdkbnx4;
    }

    private String ztyyobiv8x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X7)
    public String getZtyyobiv8x7() {
        return ztyyobiv8x7;
    }

    public void setZtyyobiv8x7(String pZtyyobiv8x7) {
        ztyyobiv8x7 = pZtyyobiv8x7;
    }

    private String ztyhtnknhknsyrikgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNHKNSYRIKGUSDKBNX5)
    public String getZtyhtnknhknsyrikgusdkbnx5() {
        return ztyhtnknhknsyrikgusdkbnx5;
    }

    public void setZtyhtnknhknsyrikgusdkbnx5(String pZtyhtnknhknsyrikgusdkbnx5) {
        ztyhtnknhknsyrikgusdkbnx5 = pZtyhtnknhknsyrikgusdkbnx5;
    }

    private String ztyhtnknmrtikgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMRTIKGUSDKBNX5)
    public String getZtyhtnknmrtikgusdkbnx5() {
        return ztyhtnknmrtikgusdkbnx5;
    }

    public void setZtyhtnknmrtikgusdkbnx5(String pZtyhtnknmrtikgusdkbnx5) {
        ztyhtnknmrtikgusdkbnx5 = pZtyhtnknmrtikgusdkbnx5;
    }

    private String ztyhtnknsiznmrtikgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIZNMRTIKGUSDKBNX5)
    public String getZtyhtnknsiznmrtikgusdkbnx5() {
        return ztyhtnknsiznmrtikgusdkbnx5;
    }

    public void setZtyhtnknsiznmrtikgusdkbnx5(String pZtyhtnknsiznmrtikgusdkbnx5) {
        ztyhtnknsiznmrtikgusdkbnx5 = pZtyhtnknsiznmrtikgusdkbnx5;
    }

    private String ztyhtnkntignmrtikgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTIGNMRTIKGUSDKBNX5)
    public String getZtyhtnkntignmrtikgusdkbnx5() {
        return ztyhtnkntignmrtikgusdkbnx5;
    }

    public void setZtyhtnkntignmrtikgusdkbnx5(String pZtyhtnkntignmrtikgusdkbnx5) {
        ztyhtnkntignmrtikgusdkbnx5 = pZtyhtnkntignmrtikgusdkbnx5;
    }

    private String ztyhtnknnkmrtikgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKMRTIKGUSDKBNX5)
    public String getZtyhtnknnkmrtikgusdkbnx5() {
        return ztyhtnknnkmrtikgusdkbnx5;
    }

    public void setZtyhtnknnkmrtikgusdkbnx5(String pZtyhtnknnkmrtikgusdkbnx5) {
        ztyhtnknnkmrtikgusdkbnx5 = pZtyhtnknnkmrtikgusdkbnx5;
    }

    private String ztyhtnkntkstkgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKSTKGUSDKBNX5)
    public String getZtyhtnkntkstkgusdkbnx5() {
        return ztyhtnkntkstkgusdkbnx5;
    }

    public void setZtyhtnkntkstkgusdkbnx5(String pZtyhtnkntkstkgusdkbnx5) {
        ztyhtnkntkstkgusdkbnx5 = pZtyhtnkntkstkgusdkbnx5;
    }

    private String ztyhtnkndi2tkstkgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKSTKGUSDKBNX5)
    public String getZtyhtnkndi2tkstkgusdkbnx5() {
        return ztyhtnkndi2tkstkgusdkbnx5;
    }

    public void setZtyhtnkndi2tkstkgusdkbnx5(String pZtyhtnkndi2tkstkgusdkbnx5) {
        ztyhtnkndi2tkstkgusdkbnx5 = pZtyhtnkndi2tkstkgusdkbnx5;
    }

    private String ztyhtnknjyustkgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYUSTKGUSDKBNX5)
    public String getZtyhtnknjyustkgusdkbnx5() {
        return ztyhtnknjyustkgusdkbnx5;
    }

    public void setZtyhtnknjyustkgusdkbnx5(String pZtyhtnknjyustkgusdkbnx5) {
        ztyhtnknjyustkgusdkbnx5 = pZtyhtnknjyustkgusdkbnx5;
    }

    private String ztyhtnkndi2jysitkgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2JYSITKGUSDKBNX5)
    public String getZtyhtnkndi2jysitkgusdkbnx5() {
        return ztyhtnkndi2jysitkgusdkbnx5;
    }

    public void setZtyhtnkndi2jysitkgusdkbnx5(String pZtyhtnkndi2jysitkgusdkbnx5) {
        ztyhtnkndi2jysitkgusdkbnx5 = pZtyhtnkndi2jysitkgusdkbnx5;
    }

    private String ztyhtnknkaigonkmrtisdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTISDKBNX5)
    public String getZtyhtnknkaigonkmrtisdkbnx5() {
        return ztyhtnknkaigonkmrtisdkbnx5;
    }

    public void setZtyhtnknkaigonkmrtisdkbnx5(String pZtyhtnknkaigonkmrtisdkbnx5) {
        ztyhtnknkaigonkmrtisdkbnx5 = pZtyhtnknkaigonkmrtisdkbnx5;
    }

    private String ztyhtnknkigtignmrtisdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTISDKBNX5)
    public String getZtyhtnknkigtignmrtisdkbnx5() {
        return ztyhtnknkigtignmrtisdkbnx5;
    }

    public void setZtyhtnknkigtignmrtisdkbnx5(String pZtyhtnknkigtignmrtisdkbnx5) {
        ztyhtnknkigtignmrtisdkbnx5 = pZtyhtnknkigtignmrtisdkbnx5;
    }

    private String ztyhtnknkaigomrsykgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRSYKGUSDKBNX5)
    public String getZtyhtnknkaigomrsykgusdkbnx5() {
        return ztyhtnknkaigomrsykgusdkbnx5;
    }

    public void setZtyhtnknkaigomrsykgusdkbnx5(String pZtyhtnknkaigomrsykgusdkbnx5) {
        ztyhtnknkaigomrsykgusdkbnx5 = pZtyhtnknkaigomrsykgusdkbnx5;
    }

    private String ztyyobiv8x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X8)
    public String getZtyyobiv8x8() {
        return ztyyobiv8x8;
    }

    public void setZtyyobiv8x8(String pZtyyobiv8x8) {
        ztyyobiv8x8 = pZtyyobiv8x8;
    }

    private String ztyhtnknhknsyrikgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNHKNSYRIKGUSDKBNX6)
    public String getZtyhtnknhknsyrikgusdkbnx6() {
        return ztyhtnknhknsyrikgusdkbnx6;
    }

    public void setZtyhtnknhknsyrikgusdkbnx6(String pZtyhtnknhknsyrikgusdkbnx6) {
        ztyhtnknhknsyrikgusdkbnx6 = pZtyhtnknhknsyrikgusdkbnx6;
    }

    private String ztyhtnknmrtikgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNMRTIKGUSDKBNX6)
    public String getZtyhtnknmrtikgusdkbnx6() {
        return ztyhtnknmrtikgusdkbnx6;
    }

    public void setZtyhtnknmrtikgusdkbnx6(String pZtyhtnknmrtikgusdkbnx6) {
        ztyhtnknmrtikgusdkbnx6 = pZtyhtnknmrtikgusdkbnx6;
    }

    private String ztyhtnknsiznmrtikgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNSIZNMRTIKGUSDKBNX6)
    public String getZtyhtnknsiznmrtikgusdkbnx6() {
        return ztyhtnknsiznmrtikgusdkbnx6;
    }

    public void setZtyhtnknsiznmrtikgusdkbnx6(String pZtyhtnknsiznmrtikgusdkbnx6) {
        ztyhtnknsiznmrtikgusdkbnx6 = pZtyhtnknsiznmrtikgusdkbnx6;
    }

    private String ztyhtnkntignmrtikgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTIGNMRTIKGUSDKBNX6)
    public String getZtyhtnkntignmrtikgusdkbnx6() {
        return ztyhtnkntignmrtikgusdkbnx6;
    }

    public void setZtyhtnkntignmrtikgusdkbnx6(String pZtyhtnkntignmrtikgusdkbnx6) {
        ztyhtnkntignmrtikgusdkbnx6 = pZtyhtnkntignmrtikgusdkbnx6;
    }

    private String ztyhtnknnkmrtikgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNNKMRTIKGUSDKBNX6)
    public String getZtyhtnknnkmrtikgusdkbnx6() {
        return ztyhtnknnkmrtikgusdkbnx6;
    }

    public void setZtyhtnknnkmrtikgusdkbnx6(String pZtyhtnknnkmrtikgusdkbnx6) {
        ztyhtnknnkmrtikgusdkbnx6 = pZtyhtnknnkmrtikgusdkbnx6;
    }

    private String ztyhtnkntkstkgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNTKSTKGUSDKBNX6)
    public String getZtyhtnkntkstkgusdkbnx6() {
        return ztyhtnkntkstkgusdkbnx6;
    }

    public void setZtyhtnkntkstkgusdkbnx6(String pZtyhtnkntkstkgusdkbnx6) {
        ztyhtnkntkstkgusdkbnx6 = pZtyhtnkntkstkgusdkbnx6;
    }

    private String ztyhtnkndi2tkstkgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2TKSTKGUSDKBNX6)
    public String getZtyhtnkndi2tkstkgusdkbnx6() {
        return ztyhtnkndi2tkstkgusdkbnx6;
    }

    public void setZtyhtnkndi2tkstkgusdkbnx6(String pZtyhtnkndi2tkstkgusdkbnx6) {
        ztyhtnkndi2tkstkgusdkbnx6 = pZtyhtnkndi2tkstkgusdkbnx6;
    }

    private String ztyhtnknjyustkgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNJYUSTKGUSDKBNX6)
    public String getZtyhtnknjyustkgusdkbnx6() {
        return ztyhtnknjyustkgusdkbnx6;
    }

    public void setZtyhtnknjyustkgusdkbnx6(String pZtyhtnknjyustkgusdkbnx6) {
        ztyhtnknjyustkgusdkbnx6 = pZtyhtnknjyustkgusdkbnx6;
    }

    private String ztyhtnkndi2jysitkgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNDI2JYSITKGUSDKBNX6)
    public String getZtyhtnkndi2jysitkgusdkbnx6() {
        return ztyhtnkndi2jysitkgusdkbnx6;
    }

    public void setZtyhtnkndi2jysitkgusdkbnx6(String pZtyhtnkndi2jysitkgusdkbnx6) {
        ztyhtnkndi2jysitkgusdkbnx6 = pZtyhtnkndi2jysitkgusdkbnx6;
    }

    private String ztyhtnknkaigonkmrtisdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKMRTISDKBNX6)
    public String getZtyhtnknkaigonkmrtisdkbnx6() {
        return ztyhtnknkaigonkmrtisdkbnx6;
    }

    public void setZtyhtnknkaigonkmrtisdkbnx6(String pZtyhtnknkaigonkmrtisdkbnx6) {
        ztyhtnknkaigonkmrtisdkbnx6 = pZtyhtnknkaigonkmrtisdkbnx6;
    }

    private String ztyhtnknkigtignmrtisdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGTIGNMRTISDKBNX6)
    public String getZtyhtnknkigtignmrtisdkbnx6() {
        return ztyhtnknkigtignmrtisdkbnx6;
    }

    public void setZtyhtnknkigtignmrtisdkbnx6(String pZtyhtnknkigtignmrtisdkbnx6) {
        ztyhtnknkigtignmrtisdkbnx6 = pZtyhtnknkigtignmrtisdkbnx6;
    }

    private String ztyhtnknkaigomrsykgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRSYKGUSDKBNX6)
    public String getZtyhtnknkaigomrsykgusdkbnx6() {
        return ztyhtnknkaigomrsykgusdkbnx6;
    }

    public void setZtyhtnknkaigomrsykgusdkbnx6(String pZtyhtnknkaigomrsykgusdkbnx6) {
        ztyhtnknkaigomrsykgusdkbnx6 = pZtyhtnknkaigomrsykgusdkbnx6;
    }

    private String ztyyobiv8x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X9)
    public String getZtyyobiv8x9() {
        return ztyyobiv8x9;
    }

    public void setZtyyobiv8x9(String pZtyyobiv8x9) {
        ztyyobiv8x9 = pZtyyobiv8x9;
    }

    private String ztykaigonktkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKSYURUIKGU)
    public String getZtykaigonktkyksyuruikgu() {
        return ztykaigonktkyksyuruikgu;
    }

    public void setZtykaigonktkyksyuruikgu(String pZtykaigonktkyksyuruikgu) {
        ztykaigonktkyksyuruikgu = pZtykaigonktkyksyuruikgu;
    }

    private String ztykaigonktkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKKGUSDKBN)
    public String getZtykaigonktkykkgusdkbn() {
        return ztykaigonktkykkgusdkbn;
    }

    public void setZtykaigonktkykkgusdkbn(String pZtykaigonktkykkgusdkbn) {
        ztykaigonktkykkgusdkbn = pZtykaigonktkykkgusdkbn;
    }

    private String ztykaigonenkintokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONENKINTOKUYAKUKIKAN)
    public String getZtykaigonenkintokuyakukikan() {
        return ztykaigonenkintokuyakukikan;
    }

    public void setZtykaigonenkintokuyakukikan(String pZtykaigonenkintokuyakukikan) {
        ztykaigonenkintokuyakukikan = pZtykaigonenkintokuyakukikan;
    }

    private String ztykaigonktkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKPHRKKKN)
    public String getZtykaigonktkykphrkkkn() {
        return ztykaigonktkykphrkkkn;
    }

    public void setZtykaigonktkykphrkkkn(String pZtykaigonktkykphrkkkn) {
        ztykaigonktkykphrkkkn = pZtykaigonktkykphrkkkn;
    }

    private Long ztykaigonktkyknkgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKNKGK)
    public Long getZtykaigonktkyknkgk() {
        return ztykaigonktkyknkgk;
    }

    public void setZtykaigonktkyknkgk(Long pZtykaigonktkyknkgk) {
        ztykaigonktkyknkgk = pZtykaigonktkyknkgk;
    }

    private Long ztykaigonenkintokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONENKINTOKUYAKUS)
    public Long getZtykaigonenkintokuyakus() {
        return ztykaigonenkintokuyakus;
    }

    public void setZtykaigonenkintokuyakus(Long pZtykaigonenkintokuyakus) {
        ztykaigonenkintokuyakus = pZtykaigonenkintokuyakus;
    }

    private Long ztykaigonenkintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONENKINTOKUYAKUP)
    public Long getZtykaigonenkintokuyakup() {
        return ztykaigonenkintokuyakup;
    }

    public void setZtykaigonenkintokuyakup(Long pZtykaigonenkintokuyakup) {
        ztykaigonenkintokuyakup = pZtykaigonenkintokuyakup;
    }

    private Long ztykaigonktkykmods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKMODS)
    public Long getZtykaigonktkykmods() {
        return ztykaigonktkykmods;
    }

    public void setZtykaigonktkykmods(Long pZtykaigonktkykmods) {
        ztykaigonktkykmods = pZtykaigonktkykmods;
    }

    private String ztykaigonktkyknkshrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKNKSHRKKN)
    public String getZtykaigonktkyknkshrkkn() {
        return ztykaigonktkyknkshrkkn;
    }

    public void setZtykaigonktkyknkshrkkn(String pZtykaigonktkyknkshrkkn) {
        ztykaigonktkyknkshrkkn = pZtykaigonktkyknkshrkkn;
    }

    private String ztyhtnknkaigonktkykkgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKKGUX1)
    public String getZtyhtnknkaigonktkykkgux1() {
        return ztyhtnknkaigonktkykkgux1;
    }

    public void setZtyhtnknkaigonktkykkgux1(String pZtyhtnknkaigonktkykkgux1) {
        ztyhtnknkaigonktkykkgux1 = pZtyhtnknkaigonktkykkgux1;
    }

    private String ztyhtnknkaigonktkykkgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKKGUX2)
    public String getZtyhtnknkaigonktkykkgux2() {
        return ztyhtnknkaigonktkykkgux2;
    }

    public void setZtyhtnknkaigonktkykkgux2(String pZtyhtnknkaigonktkykkgux2) {
        ztyhtnknkaigonktkykkgux2 = pZtyhtnknkaigonktkykkgux2;
    }

    private String ztyhtnknkaigonktkykkgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKKGUX3)
    public String getZtyhtnknkaigonktkykkgux3() {
        return ztyhtnknkaigonktkykkgux3;
    }

    public void setZtyhtnknkaigonktkykkgux3(String pZtyhtnknkaigonktkykkgux3) {
        ztyhtnknkaigonktkykkgux3 = pZtyhtnknkaigonktkykkgux3;
    }

    private String ztyhtnknkaigonktkykkgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKKGUX4)
    public String getZtyhtnknkaigonktkykkgux4() {
        return ztyhtnknkaigonktkykkgux4;
    }

    public void setZtyhtnknkaigonktkykkgux4(String pZtyhtnknkaigonktkykkgux4) {
        ztyhtnknkaigonktkykkgux4 = pZtyhtnknkaigonktkykkgux4;
    }

    private String ztyhtnknkaigonktkykkgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKKGUX5)
    public String getZtyhtnknkaigonktkykkgux5() {
        return ztyhtnknkaigonktkykkgux5;
    }

    public void setZtyhtnknkaigonktkykkgux5(String pZtyhtnknkaigonktkykkgux5) {
        ztyhtnknkaigonktkykkgux5 = pZtyhtnknkaigonktkykkgux5;
    }

    private String ztyhtnknkaigonktkykkgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKKGUX6)
    public String getZtyhtnknkaigonktkykkgux6() {
        return ztyhtnknkaigonktkykkgux6;
    }

    public void setZtyhtnknkaigonktkykkgux6(String pZtyhtnknkaigonktkykkgux6) {
        ztyhtnknkaigonktkykkgux6 = pZtyhtnknkaigonktkykkgux6;
    }

    private String ztyhtnknkaigonktkyksdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKSDKBNX1)
    public String getZtyhtnknkaigonktkyksdkbnx1() {
        return ztyhtnknkaigonktkyksdkbnx1;
    }

    public void setZtyhtnknkaigonktkyksdkbnx1(String pZtyhtnknkaigonktkyksdkbnx1) {
        ztyhtnknkaigonktkyksdkbnx1 = pZtyhtnknkaigonktkyksdkbnx1;
    }

    private String ztyhtnknkaigonktkyksdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKSDKBNX2)
    public String getZtyhtnknkaigonktkyksdkbnx2() {
        return ztyhtnknkaigonktkyksdkbnx2;
    }

    public void setZtyhtnknkaigonktkyksdkbnx2(String pZtyhtnknkaigonktkyksdkbnx2) {
        ztyhtnknkaigonktkyksdkbnx2 = pZtyhtnknkaigonktkyksdkbnx2;
    }

    private String ztyhtnknkaigonktkyksdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKSDKBNX3)
    public String getZtyhtnknkaigonktkyksdkbnx3() {
        return ztyhtnknkaigonktkyksdkbnx3;
    }

    public void setZtyhtnknkaigonktkyksdkbnx3(String pZtyhtnknkaigonktkyksdkbnx3) {
        ztyhtnknkaigonktkyksdkbnx3 = pZtyhtnknkaigonktkyksdkbnx3;
    }

    private String ztyhtnknkaigonktkyksdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKSDKBNX4)
    public String getZtyhtnknkaigonktkyksdkbnx4() {
        return ztyhtnknkaigonktkyksdkbnx4;
    }

    public void setZtyhtnknkaigonktkyksdkbnx4(String pZtyhtnknkaigonktkyksdkbnx4) {
        ztyhtnknkaigonktkyksdkbnx4 = pZtyhtnknkaigonktkyksdkbnx4;
    }

    private String ztyhtnknkaigonktkyksdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKSDKBNX5)
    public String getZtyhtnknkaigonktkyksdkbnx5() {
        return ztyhtnknkaigonktkyksdkbnx5;
    }

    public void setZtyhtnknkaigonktkyksdkbnx5(String pZtyhtnknkaigonktkyksdkbnx5) {
        ztyhtnknkaigonktkyksdkbnx5 = pZtyhtnknkaigonktkyksdkbnx5;
    }

    private String ztyhtnknkaigonktkyksdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGONKTKYKSDKBNX6)
    public String getZtyhtnknkaigonktkyksdkbnx6() {
        return ztyhtnknkaigonktkyksdkbnx6;
    }

    public void setZtyhtnknkaigonktkyksdkbnx6(String pZtyhtnknkaigonktkyksdkbnx6) {
        ztyhtnknkaigonktkyksdkbnx6 = pZtyhtnknkaigonktkyksdkbnx6;
    }

    private String ztysurikaigonktkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURIKAIGONKTKYKPWRBKKBN)
    public String getZtysurikaigonktkykpwrbkkbn() {
        return ztysurikaigonktkykpwrbkkbn;
    }

    public void setZtysurikaigonktkykpwrbkkbn(String pZtysurikaigonktkykpwrbkkbn) {
        ztysurikaigonktkykpwrbkkbn = pZtysurikaigonktkykpwrbkkbn;
    }

    private String ztykaigonktkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKPWRBKKBN)
    public String getZtykaigonktkykpwrbkkbn() {
        return ztykaigonktkykpwrbkkbn;
    }

    public void setZtykaigonktkykpwrbkkbn(String pZtykaigonktkykpwrbkkbn) {
        ztykaigonktkykpwrbkkbn = pZtykaigonktkykpwrbkkbn;
    }

    private String ztykaigonktkyktnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGONKTKYKTNKNYUGUKBN)
    public String getZtykaigonktkyktnknyugukbn() {
        return ztykaigonktkyktnknyugukbn;
    }

    public void setZtykaigonktkyktnknyugukbn(String pZtykaigonktkyktnknyugukbn) {
        ztykaigonktkyktnknyugukbn = pZtykaigonktkyktnknyugukbn;
    }

    private String ztyyobiv14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }

    private String ztyitjbrkignktkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKSYRIKGU)
    public String getZtyitjbrkignktkyksyrikgu() {
        return ztyitjbrkignktkyksyrikgu;
    }

    public void setZtyitjbrkignktkyksyrikgu(String pZtyitjbrkignktkyksyrikgu) {
        ztyitjbrkignktkyksyrikgu = pZtyitjbrkignktkyksyrikgu;
    }

    private String ztyitjbrkignktkyksdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKSDKBN)
    public String getZtyitjbrkignktkyksdkbn() {
        return ztyitjbrkignktkyksdkbn;
    }

    public void setZtyitjbrkignktkyksdkbn(String pZtyitjbrkignktkyksdkbn) {
        ztyitjbrkignktkyksdkbn = pZtyitjbrkignktkyksdkbn;
    }

    private String ztyitjbrkignktkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKKKN)
    public String getZtyitjbrkignktkykkkn() {
        return ztyitjbrkignktkykkkn;
    }

    public void setZtyitjbrkignktkykkkn(String pZtyitjbrkignktkykkkn) {
        ztyitjbrkignktkykkkn = pZtyitjbrkignktkykkkn;
    }

    private Long ztyitjbrkignktkyknnkngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKNNKNGK)
    public Long getZtyitjbrkignktkyknnkngk() {
        return ztyitjbrkignktkyknnkngk;
    }

    public void setZtyitjbrkignktkyknnkngk(Long pZtyitjbrkignktkyknnkngk) {
        ztyitjbrkignktkyknnkngk = pZtyitjbrkignktkyknnkngk;
    }

    private Long ztyitjbrkignktkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKS)
    public Long getZtyitjbrkignktkyks() {
        return ztyitjbrkignktkyks;
    }

    public void setZtyitjbrkignktkyks(Long pZtyitjbrkignktkyks) {
        ztyitjbrkignktkyks = pZtyitjbrkignktkyks;
    }

    private Long ztyitjbrkignktkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKP)
    public Long getZtyitjbrkignktkykp() {
        return ztyitjbrkignktkykp;
    }

    public void setZtyitjbrkignktkykp(Long pZtyitjbrkignktkykp) {
        ztyitjbrkignktkykp = pZtyitjbrkignktkykp;
    }

    private String ztyitjbrkignktkykspdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKSPDTKBN)
    public String getZtyitjbrkignktkykspdtkbn() {
        return ztyitjbrkignktkykspdtkbn;
    }

    public void setZtyitjbrkignktkykspdtkbn(String pZtyitjbrkignktkykspdtkbn) {
        ztyitjbrkignktkykspdtkbn = pZtyitjbrkignktkykspdtkbn;
    }

    private Long ztyitjbrkignktkykmods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKMODS)
    public Long getZtyitjbrkignktkykmods() {
        return ztyitjbrkignktkykmods;
    }

    public void setZtyitjbrkignktkykmods(Long pZtyitjbrkignktkykmods) {
        ztyitjbrkignktkykmods = pZtyitjbrkignktkykmods;
    }

    private String ztyitjbrkignktkykshrkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYITJBRKIGNKTKYKSHRKKN)
    public String getZtyitjbrkignktkykshrkkn() {
        return ztyitjbrkignktkykshrkkn;
    }

    public void setZtyitjbrkignktkykshrkkn(String pZtyitjbrkignktkykshrkkn) {
        ztyitjbrkignktkykshrkkn = pZtyitjbrkignktkykshrkkn;
    }

    private String ztyyobiv8x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X10)
    public String getZtyyobiv8x10() {
        return ztyyobiv8x10;
    }

    public void setZtyyobiv8x10(String pZtyyobiv8x10) {
        ztyyobiv8x10 = pZtyyobiv8x10;
    }

    private String ztynyuuinnissuugatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYNYUUINNISSUUGATAKBN)
    public String getZtynyuuinnissuugatakbn() {
        return ztynyuuinnissuugatakbn;
    }

    public void setZtynyuuinnissuugatakbn(String pZtynyuuinnissuugatakbn) {
        ztynyuuinnissuugatakbn = pZtynyuuinnissuugatakbn;
    }

    private String ztytenkankeikanensuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYTENKANKEIKANENSUU)
    public String getZtytenkankeikanensuu() {
        return ztytenkankeikanensuu;
    }

    public void setZtytenkankeikanensuu(String pZtytenkankeikanensuu) {
        ztytenkankeikanensuu = pZtytenkankeikanensuu;
    }

    private String ztysykkyuhtkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKYKSYURUIKGU)
    public String getZtysykkyuhtkyksyuruikgu() {
        return ztysykkyuhtkyksyuruikgu;
    }

    public void setZtysykkyuhtkyksyuruikgu(String pZtysykkyuhtkyksyuruikgu) {
        ztysykkyuhtkyksyuruikgu = pZtysykkyuhtkyksyuruikgu;
    }

    private String ztysyokikyuuhutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYOKIKYUUHUTOKUYAKUKIKAN)
    public String getZtysyokikyuuhutokuyakukikan() {
        return ztysyokikyuuhutokuyakukikan;
    }

    public void setZtysyokikyuuhutokuyakukikan(String pZtysyokikyuuhutokuyakukikan) {
        ztysyokikyuuhutokuyakukikan = pZtysyokikyuuhutokuyakukikan;
    }

    private String ztysyokikyuuhutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYOKIKYUUHUTKYKPHRKKKN)
    public String getZtysyokikyuuhutkykphrkkkn() {
        return ztysyokikyuuhutkykphrkkkn;
    }

    public void setZtysyokikyuuhutkykphrkkkn(String pZtysyokikyuuhutkykphrkkkn) {
        ztysyokikyuuhutkykphrkkkn = pZtysyokikyuuhutkykphrkkkn;
    }

    private Integer ztysykkyuhtkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKYKNTGK)
    public Integer getZtysykkyuhtkykntgk() {
        return ztysykkyuhtkykntgk;
    }

    public void setZtysykkyuhtkykntgk(Integer pZtysykkyuhtkykntgk) {
        ztysykkyuhtkykntgk = pZtysykkyuhtkykntgk;
    }

    private Long ztysyokikyuuhutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYOKIKYUUHUTOKUYAKUP)
    public Long getZtysyokikyuuhutokuyakup() {
        return ztysyokikyuuhutokuyakup;
    }

    public void setZtysyokikyuuhutokuyakup(Long pZtysyokikyuuhutokuyakup) {
        ztysyokikyuuhutokuyakup = pZtysyokikyuuhutokuyakup;
    }

    private String ztysykkyuhtkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKYKGTKBN)
    public String getZtysykkyuhtkykgtkbn() {
        return ztysykkyuhtkykgtkbn;
    }

    public void setZtysykkyuhtkykgtkbn(String pZtysykkyuhtkykgtkbn) {
        ztysykkyuhtkykgtkbn = pZtysykkyuhtkykgtkbn;
    }

    private String ztysyokikyuuhutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYOKIKYUUHUTKYKKGUSDKBN)
    public String getZtysyokikyuuhutkykkgusdkbn() {
        return ztysyokikyuuhutkykkgusdkbn;
    }

    public void setZtysyokikyuuhutkykkgusdkbn(String pZtysyokikyuuhutkykkgusdkbn) {
        ztysyokikyuuhutkykkgusdkbn = pZtysyokikyuuhutkykkgusdkbn;
    }

    private Integer ztysykkyuhtkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKJYURYUMSHYUTN)
    public Integer getZtysykkyuhtkjyuryumshyutn() {
        return ztysykkyuhtkjyuryumshyutn;
    }

    public void setZtysykkyuhtkjyuryumshyutn(Integer pZtysykkyuhtkjyuryumshyutn) {
        ztysykkyuhtkjyuryumshyutn = pZtysykkyuhtkjyuryumshyutn;
    }

    private Long ztysyokikyuuhutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYOKIKYUUHUTOKUJYOUP)
    public Long getZtysyokikyuuhutokujyoup() {
        return ztysyokikyuuhutokujyoup;
    }

    public void setZtysyokikyuuhutokujyoup(Long pZtysyokikyuuhutokujyoup) {
        ztysyokikyuuhutokujyoup = pZtysyokikyuuhutokujyoup;
    }

    private String ztysykkyuhtktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKTBICDX1)
    public String getZtysykkyuhtktbicdx1() {
        return ztysykkyuhtktbicdx1;
    }

    public void setZtysykkyuhtktbicdx1(String pZtysykkyuhtktbicdx1) {
        ztysykkyuhtktbicdx1 = pZtysykkyuhtktbicdx1;
    }

    private String ztysykkyuhhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHHTNPKKNX1)
    public String getZtysykkyuhhtnpkknx1() {
        return ztysykkyuhhtnpkknx1;
    }

    public void setZtysykkyuhhtnpkknx1(String pZtysykkyuhhtnpkknx1) {
        ztysykkyuhhtnpkknx1 = pZtysykkyuhhtnpkknx1;
    }

    private String ztysykkyuhtktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKTBICDX2)
    public String getZtysykkyuhtktbicdx2() {
        return ztysykkyuhtktbicdx2;
    }

    public void setZtysykkyuhtktbicdx2(String pZtysykkyuhtktbicdx2) {
        ztysykkyuhtktbicdx2 = pZtysykkyuhtktbicdx2;
    }

    private String ztysykkyuhhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHHTNPKKNX2)
    public String getZtysykkyuhhtnpkknx2() {
        return ztysykkyuhhtnpkknx2;
    }

    public void setZtysykkyuhhtnpkknx2(String pZtysykkyuhhtnpkknx2) {
        ztysykkyuhhtnpkknx2 = pZtysykkyuhhtnpkknx2;
    }

    private String ztysykkyuhtkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSYKKYUHTKYKPWRBKKBN)
    public String getZtysykkyuhtkykpwrbkkbn() {
        return ztysykkyuhtkykpwrbkkbn;
    }

    public void setZtysykkyuhtkykpwrbkkbn(String pZtysykkyuhtkykpwrbkkbn) {
        ztysykkyuhtkykpwrbkkbn = pZtysykkyuhtkykpwrbkkbn;
    }

    private String ztyyobiv3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV3X6)
    public String getZtyyobiv3x6() {
        return ztyyobiv3x6;
    }

    public void setZtyyobiv3x6(String pZtyyobiv3x6) {
        ztyyobiv3x6 = pZtyyobiv3x6;
    }

    private String ztydi2sykkyuhtkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKSYRIKGU)
    public String getZtydi2sykkyuhtkyksyrikgu() {
        return ztydi2sykkyuhtkyksyrikgu;
    }

    public void setZtydi2sykkyuhtkyksyrikgu(String pZtydi2sykkyuhtkyksyrikgu) {
        ztydi2sykkyuhtkyksyrikgu = pZtydi2sykkyuhtkyksyrikgu;
    }

    private String ztydi2sykkyuhtkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKKKN)
    public String getZtydi2sykkyuhtkykkkn() {
        return ztydi2sykkyuhtkykkkn;
    }

    public void setZtydi2sykkyuhtkykkkn(String pZtydi2sykkyuhtkykkkn) {
        ztydi2sykkyuhtkykkkn = pZtydi2sykkyuhtkykkkn;
    }

    private String ztydi2sykkyuhtkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKPHRKKKN)
    public String getZtydi2sykkyuhtkykphrkkkn() {
        return ztydi2sykkyuhtkykphrkkkn;
    }

    public void setZtydi2sykkyuhtkykphrkkkn(String pZtydi2sykkyuhtkykphrkkkn) {
        ztydi2sykkyuhtkykphrkkkn = pZtydi2sykkyuhtkykphrkkkn;
    }

    private Integer ztydi2sykkyuhtkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKNTGK)
    public Integer getZtydi2sykkyuhtkykntgk() {
        return ztydi2sykkyuhtkykntgk;
    }

    public void setZtydi2sykkyuhtkykntgk(Integer pZtydi2sykkyuhtkykntgk) {
        ztydi2sykkyuhtkykntgk = pZtydi2sykkyuhtkykntgk;
    }

    private Long ztydai2syokikyuuhutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2SYOKIKYUUHUTOKUYAKUP)
    public Long getZtydai2syokikyuuhutokuyakup() {
        return ztydai2syokikyuuhutokuyakup;
    }

    public void setZtydai2syokikyuuhutokuyakup(Long pZtydai2syokikyuuhutokuyakup) {
        ztydai2syokikyuuhutokuyakup = pZtydai2syokikyuuhutokuyakup;
    }

    private String ztydi2sykkyuhtkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKGTKBN)
    public String getZtydi2sykkyuhtkykgtkbn() {
        return ztydi2sykkyuhtkykgtkbn;
    }

    public void setZtydi2sykkyuhtkykgtkbn(String pZtydi2sykkyuhtkykgtkbn) {
        ztydi2sykkyuhtkykgtkbn = pZtydi2sykkyuhtkykgtkbn;
    }

    private String ztydi2sykkyuhtkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKKGUSDKBN)
    public String getZtydi2sykkyuhtkykkgusdkbn() {
        return ztydi2sykkyuhtkykkgusdkbn;
    }

    public void setZtydi2sykkyuhtkykkgusdkbn(String pZtydi2sykkyuhtkykkgusdkbn) {
        ztydi2sykkyuhtkykkgusdkbn = pZtydi2sykkyuhtkykkgusdkbn;
    }

    private Integer ztydi2sykkyuhtkjyuryumshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKJYURYUMSHYTN)
    public Integer getZtydi2sykkyuhtkjyuryumshytn() {
        return ztydi2sykkyuhtkjyuryumshytn;
    }

    public void setZtydi2sykkyuhtkjyuryumshytn(Integer pZtydi2sykkyuhtkjyuryumshytn) {
        ztydi2sykkyuhtkjyuryumshytn = pZtydi2sykkyuhtkjyuryumshytn;
    }

    private Long ztydai2syokikyuuhutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDAI2SYOKIKYUUHUTOKUJYOUP)
    public Long getZtydai2syokikyuuhutokujyoup() {
        return ztydai2syokikyuuhutokujyoup;
    }

    public void setZtydai2syokikyuuhutokujyoup(Long pZtydai2syokikyuuhutokujyoup) {
        ztydai2syokikyuuhutokujyoup = pZtydai2syokikyuuhutokujyoup;
    }

    private String ztydi2sykkyuhtktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKTBICDX1)
    public String getZtydi2sykkyuhtktbicdx1() {
        return ztydi2sykkyuhtktbicdx1;
    }

    public void setZtydi2sykkyuhtktbicdx1(String pZtydi2sykkyuhtktbicdx1) {
        ztydi2sykkyuhtktbicdx1 = pZtydi2sykkyuhtktbicdx1;
    }

    private String ztydi2sykkyuhhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHHTNPKKNX1)
    public String getZtydi2sykkyuhhtnpkknx1() {
        return ztydi2sykkyuhhtnpkknx1;
    }

    public void setZtydi2sykkyuhhtnpkknx1(String pZtydi2sykkyuhhtnpkknx1) {
        ztydi2sykkyuhhtnpkknx1 = pZtydi2sykkyuhhtnpkknx1;
    }

    private String ztydi2sykkyuhtktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKTBICDX2)
    public String getZtydi2sykkyuhtktbicdx2() {
        return ztydi2sykkyuhtktbicdx2;
    }

    public void setZtydi2sykkyuhtktbicdx2(String pZtydi2sykkyuhtktbicdx2) {
        ztydi2sykkyuhtktbicdx2 = pZtydi2sykkyuhtktbicdx2;
    }

    private String ztydi2sykkyuhhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHHTNPKKNX2)
    public String getZtydi2sykkyuhhtnpkknx2() {
        return ztydi2sykkyuhhtnpkknx2;
    }

    public void setZtydi2sykkyuhhtnpkknx2(String pZtydi2sykkyuhhtnpkknx2) {
        ztydi2sykkyuhhtnpkknx2 = pZtydi2sykkyuhhtnpkknx2;
    }

    private String ztydi2sykkyuhtkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDI2SYKKYUHTKYKPWRBKKBN)
    public String getZtydi2sykkyuhtkykpwrbkkbn() {
        return ztydi2sykkyuhtkykpwrbkkbn;
    }

    public void setZtydi2sykkyuhtkykpwrbkkbn(String pZtydi2sykkyuhtkykpwrbkkbn) {
        ztydi2sykkyuhtkykpwrbkkbn = pZtydi2sykkyuhtkykpwrbkkbn;
    }

    private String ztyyobiv3x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV3X7)
    public String getZtyyobiv3x7() {
        return ztyyobiv3x7;
    }

    public void setZtyyobiv3x7(String pZtyyobiv3x7) {
        ztyyobiv3x7 = pZtyyobiv3x7;
    }

    private Long ztydfitijibaraip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDFITIJIBARAIP)
    public Long getZtydfitijibaraip() {
        return ztydfitijibaraip;
    }

    public void setZtydfitijibaraip(Long pZtydfitijibaraip) {
        ztydfitijibaraip = pZtydfitijibaraip;
    }

    private Long ztydfgoukeitenkankakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDFGOUKEITENKANKAKAKU)
    public Long getZtydfgoukeitenkankakaku() {
        return ztydfgoukeitenkankakaku;
    }

    public void setZtydfgoukeitenkankakaku(Long pZtydfgoukeitenkankakaku) {
        ztydfgoukeitenkankakaku = pZtydfgoukeitenkankakaku;
    }

    private Long ztydfuktkjivbbntnknkakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDFUKTKJIVBBNTNKNKAKAKU)
    public Long getZtydfuktkjivbbntnknkakaku() {
        return ztydfuktkjivbbntnknkakaku;
    }

    public void setZtydfuktkjivbbntnknkakaku(Long pZtydfuktkjivbbntnknkakaku) {
        ztydfuktkjivbbntnknkakaku = pZtydfuktkjivbbntnknkakaku;
    }

    private Long ztydfuktkjipbbntnknkakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDFUKTKJIPBBNTNKNKAKAKU)
    public Long getZtydfuktkjipbbntnknkakaku() {
        return ztydfuktkjipbbntnknkakaku;
    }

    public void setZtydfuktkjipbbntnknkakaku(Long pZtydfuktkjipbbntnknkakaku) {
        ztydfuktkjipbbntnknkakaku = pZtydfuktkjipbbntnknkakaku;
    }

    private Long ztydftnkngvbbntnknkakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDFTNKNGVBBNTNKNKAKAKU)
    public Long getZtydftnkngvbbntnknkakaku() {
        return ztydftnkngvbbntnknkakaku;
    }

    public void setZtydftnkngvbbntnknkakaku(Long pZtydftnkngvbbntnknkakaku) {
        ztydftnkngvbbntnknkakaku = pZtydftnkngvbbntnknkakaku;
    }

    private Long ztydftnkngpbbntnknkakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYDFTNKNGPBBNTNKNKAKAKU)
    public Long getZtydftnkngpbbntnknkakaku() {
        return ztydftnkngpbbntnknkakaku;
    }

    public void setZtydftnkngpbbntnknkakaku(Long pZtydftnkngpbbntnknkakaku) {
        ztydftnkngpbbntnknkakaku = pZtydftnkngpbbntnknkakaku;
    }

    private String ztyyobiv18x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV18X2)
    public String getZtyyobiv18x2() {
        return ztyyobiv18x2;
    }

    public void setZtyyobiv18x2(String pZtyyobiv18x2) {
        ztyyobiv18x2 = pZtyyobiv18x2;
    }

    private String ztykaigomrtisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMRTISYURUIKGU)
    public String getZtykaigomrtisyuruikgu() {
        return ztykaigomrtisyuruikgu;
    }

    public void setZtykaigomrtisyuruikgu(String pZtykaigomrtisyuruikgu) {
        ztykaigomrtisyuruikgu = pZtykaigomrtisyuruikgu;
    }

    private String ztykaigomaruteikigousdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEIKIGOUSDKBN)
    public String getZtykaigomaruteikigousdkbn() {
        return ztykaigomaruteikigousdkbn;
    }

    public void setZtykaigomaruteikigousdkbn(String pZtykaigomaruteikigousdkbn) {
        ztykaigomaruteikigousdkbn = pZtykaigomaruteikigousdkbn;
    }

    private String ztykaigomaruteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEIKIKAN)
    public String getZtykaigomaruteikikan() {
        return ztykaigomaruteikikan;
    }

    public void setZtykaigomaruteikikan(String pZtykaigomaruteikikan) {
        ztykaigomaruteikikan = pZtykaigomaruteikikan;
    }

    private String ztykaigomaruteiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEIPHRKKKN)
    public String getZtykaigomaruteiphrkkkn() {
        return ztykaigomaruteiphrkkkn;
    }

    public void setZtykaigomaruteiphrkkkn(String pZtykaigomaruteiphrkkkn) {
        ztykaigomaruteiphrkkkn = pZtykaigomaruteiphrkkkn;
    }

    private Long ztykaigomaruteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEIS)
    public Long getZtykaigomaruteis() {
        return ztykaigomaruteis;
    }

    public void setZtykaigomaruteis(Long pZtykaigomaruteis) {
        ztykaigomaruteis = pZtykaigomaruteis;
    }

    private Long ztykaigomaruteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEIP)
    public Long getZtykaigomaruteip() {
        return ztykaigomaruteip;
    }

    public void setZtykaigomaruteip(Long pZtykaigomaruteip) {
        ztykaigomaruteip = pZtykaigomaruteip;
    }

    private Long ztykaigomaruteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEISYUUSEIS)
    public Long getZtykaigomaruteisyuuseis() {
        return ztykaigomaruteisyuuseis;
    }

    public void setZtykaigomaruteisyuuseis(Long pZtykaigomaruteisyuuseis) {
        ztykaigomaruteisyuuseis = pZtykaigomaruteisyuuseis;
    }

    private String ztykaigomaruteimodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEIMODSSKGNHYJ)
    public String getZtykaigomaruteimodsskgnhyj() {
        return ztykaigomaruteimodsskgnhyj;
    }

    public void setZtykaigomaruteimodsskgnhyj(String pZtykaigomaruteimodsskgnhyj) {
        ztykaigomaruteimodsskgnhyj = pZtykaigomaruteimodsskgnhyj;
    }

    private String ztykigmrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGMRTITKJYUKBN)
    public String getZtykigmrtitkjyukbn() {
        return ztykigmrtitkjyukbn;
    }

    public void setZtykigmrtitkjyukbn(String pZtykigmrtitkjyukbn) {
        ztykigmrtitkjyukbn = pZtykigmrtitkjyukbn;
    }

    private String ztykigmrtitkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGMRTITKJYUSKGNKKN)
    public String getZtykigmrtitkjyuskgnkkn() {
        return ztykigmrtitkjyuskgnkkn;
    }

    public void setZtykigmrtitkjyuskgnkkn(String pZtykigmrtitkjyuskgnkkn) {
        ztykigmrtitkjyuskgnkkn = pZtykigmrtitkjyuskgnkkn;
    }

    private Integer ztykigmrtitkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGMRTITKJYURYUMSHYUTN)
    public Integer getZtykigmrtitkjyuryumshyutn() {
        return ztykigmrtitkjyuryumshyutn;
    }

    public void setZtykigmrtitkjyuryumshyutn(Integer pZtykigmrtitkjyuryumshyutn) {
        ztykigmrtitkjyuryumshyutn = pZtykigmrtitkjyuryumshyutn;
    }

    private Long ztykaigomaruteitokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOMARUTEITOKUJYOUP)
    public Long getZtykaigomaruteitokujyoup() {
        return ztykaigomaruteitokujyoup;
    }

    public void setZtykaigomaruteitokujyoup(Long pZtykaigomaruteitokujyoup) {
        ztykaigomaruteitokujyoup = pZtykaigomaruteitokujyoup;
    }

    private String ztyhtnknkigmrtisyrikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGMRTISYRIKGUX1)
    public String getZtyhtnknkigmrtisyrikgux1() {
        return ztyhtnknkigmrtisyrikgux1;
    }

    public void setZtyhtnknkigmrtisyrikgux1(String pZtyhtnknkigmrtisyrikgux1) {
        ztyhtnknkigmrtisyrikgux1 = pZtyhtnknkigmrtisyrikgux1;
    }

    private String ztyhtnknkigmrtisyrikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGMRTISYRIKGUX2)
    public String getZtyhtnknkigmrtisyrikgux2() {
        return ztyhtnknkigmrtisyrikgux2;
    }

    public void setZtyhtnknkigmrtisyrikgux2(String pZtyhtnknkigmrtisyrikgux2) {
        ztyhtnknkigmrtisyrikgux2 = pZtyhtnknkigmrtisyrikgux2;
    }

    private String ztyhtnknkigmrtisyrikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGMRTISYRIKGUX3)
    public String getZtyhtnknkigmrtisyrikgux3() {
        return ztyhtnknkigmrtisyrikgux3;
    }

    public void setZtyhtnknkigmrtisyrikgux3(String pZtyhtnknkigmrtisyrikgux3) {
        ztyhtnknkigmrtisyrikgux3 = pZtyhtnknkigmrtisyrikgux3;
    }

    private String ztyhtnknkigmrtisyrikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGMRTISYRIKGUX4)
    public String getZtyhtnknkigmrtisyrikgux4() {
        return ztyhtnknkigmrtisyrikgux4;
    }

    public void setZtyhtnknkigmrtisyrikgux4(String pZtyhtnknkigmrtisyrikgux4) {
        ztyhtnknkigmrtisyrikgux4 = pZtyhtnknkigmrtisyrikgux4;
    }

    private String ztyhtnknkigmrtisyrikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGMRTISYRIKGUX5)
    public String getZtyhtnknkigmrtisyrikgux5() {
        return ztyhtnknkigmrtisyrikgux5;
    }

    public void setZtyhtnknkigmrtisyrikgux5(String pZtyhtnknkigmrtisyrikgux5) {
        ztyhtnknkigmrtisyrikgux5 = pZtyhtnknkigmrtisyrikgux5;
    }

    private String ztyhtnknkigmrtisyrikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKIGMRTISYRIKGUX6)
    public String getZtyhtnknkigmrtisyrikgux6() {
        return ztyhtnknkigmrtisyrikgux6;
    }

    public void setZtyhtnknkigmrtisyrikgux6(String pZtyhtnknkigmrtisyrikgux6) {
        ztyhtnknkigmrtisyrikgux6 = pZtyhtnknkigmrtisyrikgux6;
    }

    private String ztyhtnknkaigomrtisdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRTISDKBNX1)
    public String getZtyhtnknkaigomrtisdkbnx1() {
        return ztyhtnknkaigomrtisdkbnx1;
    }

    public void setZtyhtnknkaigomrtisdkbnx1(String pZtyhtnknkaigomrtisdkbnx1) {
        ztyhtnknkaigomrtisdkbnx1 = pZtyhtnknkaigomrtisdkbnx1;
    }

    private String ztyhtnknkaigomrtisdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRTISDKBNX2)
    public String getZtyhtnknkaigomrtisdkbnx2() {
        return ztyhtnknkaigomrtisdkbnx2;
    }

    public void setZtyhtnknkaigomrtisdkbnx2(String pZtyhtnknkaigomrtisdkbnx2) {
        ztyhtnknkaigomrtisdkbnx2 = pZtyhtnknkaigomrtisdkbnx2;
    }

    private String ztyhtnknkaigomrtisdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRTISDKBNX3)
    public String getZtyhtnknkaigomrtisdkbnx3() {
        return ztyhtnknkaigomrtisdkbnx3;
    }

    public void setZtyhtnknkaigomrtisdkbnx3(String pZtyhtnknkaigomrtisdkbnx3) {
        ztyhtnknkaigomrtisdkbnx3 = pZtyhtnknkaigomrtisdkbnx3;
    }

    private String ztyhtnknkaigomrtisdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRTISDKBNX4)
    public String getZtyhtnknkaigomrtisdkbnx4() {
        return ztyhtnknkaigomrtisdkbnx4;
    }

    public void setZtyhtnknkaigomrtisdkbnx4(String pZtyhtnknkaigomrtisdkbnx4) {
        ztyhtnknkaigomrtisdkbnx4 = pZtyhtnknkaigomrtisdkbnx4;
    }

    private String ztyhtnknkaigomrtisdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRTISDKBNX5)
    public String getZtyhtnknkaigomrtisdkbnx5() {
        return ztyhtnknkaigomrtisdkbnx5;
    }

    public void setZtyhtnknkaigomrtisdkbnx5(String pZtyhtnknkaigomrtisdkbnx5) {
        ztyhtnknkaigomrtisdkbnx5 = pZtyhtnknkaigomrtisdkbnx5;
    }

    private String ztyhtnknkaigomrtisdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYHTNKNKAIGOMRTISDKBNX6)
    public String getZtyhtnknkaigomrtisdkbnx6() {
        return ztyhtnknkaigomrtisdkbnx6;
    }

    public void setZtyhtnknkaigomrtisdkbnx6(String pZtyhtnknkaigomrtisdkbnx6) {
        ztyhtnknkaigomrtisdkbnx6 = pZtyhtnknkaigomrtisdkbnx6;
    }

    private String ztysurkigmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYSURKIGMRTIPWRBKKBN)
    public String getZtysurkigmrtipwrbkkbn() {
        return ztysurkigmrtipwrbkkbn;
    }

    public void setZtysurkigmrtipwrbkkbn(String pZtysurkigmrtipwrbkkbn) {
        ztysurkigmrtipwrbkkbn = pZtysurkigmrtipwrbkkbn;
    }

    private String ztykigmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGMRTIPWRBKKBN)
    public String getZtykigmrtipwrbkkbn() {
        return ztykigmrtipwrbkkbn;
    }

    public void setZtykigmrtipwrbkkbn(String pZtykigmrtipwrbkkbn) {
        ztykigmrtipwrbkkbn = pZtykigmrtipwrbkkbn;
    }

    private String ztykigmrtitnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGMRTITNKNYUGUKBN)
    public String getZtykigmrtitnknyugukbn() {
        return ztykigmrtitnknyugukbn;
    }

    public void setZtykigmrtitnknyugukbn(String pZtykigmrtitnknyugukbn) {
        ztykigmrtitnknyugukbn = pZtykigmrtitnknyugukbn;
    }

    private String ztykigmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGMRTIKUSNMNRYOAGE)
    public String getZtykigmrtikusnmnryoage() {
        return ztykigmrtikusnmnryoage;
    }

    public void setZtykigmrtikusnmnryoage(String pZtykigmrtikusnmnryoage) {
        ztykigmrtikusnmnryoage = pZtykigmrtikusnmnryoage;
    }

    private String ztyyobiv2x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV2X7)
    public String getZtyyobiv2x7() {
        return ztyyobiv2x7;
    }

    public void setZtyyobiv2x7(String pZtyyobiv2x7) {
        ztyyobiv2x7 = pZtyyobiv2x7;
    }

    private String ztykaigotokuteisyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTOKUTEISYURUIKIGOU)
    public String getZtykaigotokuteisyuruikigou() {
        return ztykaigotokuteisyuruikigou;
    }

    public void setZtykaigotokuteisyuruikigou(String pZtykaigotokuteisyuruikigou) {
        ztykaigotokuteisyuruikigou = pZtykaigotokuteisyuruikigou;
    }

    private String ztykaigotktikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTKTIKGUSDKBN)
    public String getZtykaigotktikgusdkbn() {
        return ztykaigotktikgusdkbn;
    }

    public void setZtykaigotktikgusdkbn(String pZtykaigotktikgusdkbn) {
        ztykaigotktikgusdkbn = pZtykaigotktikgusdkbn;
    }

    private String ztykaigotokuteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTOKUTEIKIKAN)
    public String getZtykaigotokuteikikan() {
        return ztykaigotokuteikikan;
    }

    public void setZtykaigotokuteikikan(String pZtykaigotokuteikikan) {
        ztykaigotokuteikikan = pZtykaigotokuteikikan;
    }

    private Long ztykaigotokuteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTOKUTEIS)
    public Long getZtykaigotokuteis() {
        return ztykaigotokuteis;
    }

    public void setZtykaigotokuteis(Long pZtykaigotokuteis) {
        ztykaigotokuteis = pZtykaigotokuteis;
    }

    private Long ztykaigotokuteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTOKUTEIP)
    public Long getZtykaigotokuteip() {
        return ztykaigotokuteip;
    }

    public void setZtykaigotokuteip(Long pZtykaigotokuteip) {
        ztykaigotokuteip = pZtykaigotokuteip;
    }

    private String ztykigtktisdtpdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKIGTKTISDTPDTKBN)
    public String getZtykigtktisdtpdtkbn() {
        return ztykigtktisdtpdtkbn;
    }

    public void setZtykigtktisdtpdtkbn(String pZtykigtktisdtpdtkbn) {
        ztykigtktisdtpdtkbn = pZtykigtktisdtpdtkbn;
    }

    private Long ztykaigotokuteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTOKUTEISYUUSEIS)
    public Long getZtykaigotokuteisyuuseis() {
        return ztykaigotokuteisyuuseis;
    }

    public void setZtykaigotokuteisyuuseis(Long pZtykaigotokuteisyuuseis) {
        ztykaigotokuteisyuuseis = pZtykaigotokuteisyuuseis;
    }

    private String ztykaigotktimodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTKTIMODSSKGNHYJ)
    public String getZtykaigotktimodsskgnhyj() {
        return ztykaigotktimodsskgnhyj;
    }

    public void setZtykaigotktimodsskgnhyj(String pZtykaigotktimodsskgnhyj) {
        ztykaigotktimodsskgnhyj = pZtykaigotktimodsskgnhyj;
    }

    private String ztykaigotktikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAIGOTKTIKUSNMNRYOAGE)
    public String getZtykaigotktikusnmnryoage() {
        return ztykaigotktikusnmnryoage;
    }

    public void setZtykaigotktikusnmnryoage(String pZtykaigotktikusnmnryoage) {
        ztykaigotktikusnmnryoage = pZtykaigotktikusnmnryoage;
    }

    private String ztyyobiv8x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV8X11)
    public String getZtyyobiv8x11() {
        return ztyyobiv8x11;
    }

    public void setZtyyobiv8x11(String pZtyyobiv8x11) {
        ztyyobiv8x11 = pZtyyobiv8x11;
    }

    private String ztykazokuiryoutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAZOKUIRYOUTKYKSYURUIKGU)
    public String getZtykazokuiryoutkyksyuruikgu() {
        return ztykazokuiryoutkyksyuruikgu;
    }

    public void setZtykazokuiryoutkyksyuruikgu(String pZtykazokuiryoutkyksyuruikgu) {
        ztykazokuiryoutkyksyuruikgu = pZtykazokuiryoutkyksyuruikgu;
    }

    private String ztykazokuiryoutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAZOKUIRYOUTOKUYAKUKIKAN)
    public String getZtykazokuiryoutokuyakukikan() {
        return ztykazokuiryoutokuyakukikan;
    }

    public void setZtykazokuiryoutokuyakukikan(String pZtykazokuiryoutokuyakukikan) {
        ztykazokuiryoutokuyakukikan = pZtykazokuiryoutokuyakukikan;
    }

    private String ztykazokuiryoutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAZOKUIRYOUTKYKPHRKKKN)
    public String getZtykazokuiryoutkykphrkkkn() {
        return ztykazokuiryoutkykphrkkkn;
    }

    public void setZtykazokuiryoutkykphrkkkn(String pZtykazokuiryoutkykphrkkkn) {
        ztykazokuiryoutkykphrkkkn = pZtykazokuiryoutkykphrkkkn;
    }

    private Long ztykzkiryoutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKZKIRYOUTKYKNTGK)
    public Long getZtykzkiryoutkykntgk() {
        return ztykzkiryoutkykntgk;
    }

    public void setZtykzkiryoutkykntgk(Long pZtykzkiryoutkykntgk) {
        ztykzkiryoutkykntgk = pZtykzkiryoutkykntgk;
    }

    private Long ztykazokuiryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAZOKUIRYOUTOKUYAKUP)
    public Long getZtykazokuiryoutokuyakup() {
        return ztykazokuiryoutokuyakup;
    }

    public void setZtykazokuiryoutokuyakup(Long pZtykazokuiryoutokuyakup) {
        ztykazokuiryoutokuyakup = pZtykazokuiryoutokuyakup;
    }

    private String ztykzkiryoutkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKZKIRYOUTKYKGTKBN)
    public String getZtykzkiryoutkykgtkbn() {
        return ztykzkiryoutkykgtkbn;
    }

    public void setZtykzkiryoutkykgtkbn(String pZtykzkiryoutkykgtkbn) {
        ztykzkiryoutkykgtkbn = pZtykzkiryoutkykgtkbn;
    }

    private String ztykazokuiryoutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKAZOKUIRYOUTKYKKGUSDKBN)
    public String getZtykazokuiryoutkykkgusdkbn() {
        return ztykazokuiryoutkykkgusdkbn;
    }

    public void setZtykazokuiryoutkykkgusdkbn(String pZtykazokuiryoutkykkgusdkbn) {
        ztykazokuiryoutkykkgusdkbn = pZtykazokuiryoutkykkgusdkbn;
    }

    private String ztykzkiryoutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKZKIRYOUTKTBICDX1)
    public String getZtykzkiryoutktbicdx1() {
        return ztykzkiryoutktbicdx1;
    }

    public void setZtykzkiryoutktbicdx1(String pZtykzkiryoutktbicdx1) {
        ztykzkiryoutktbicdx1 = pZtykzkiryoutktbicdx1;
    }

    private String ztykzkiryouhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKZKIRYOUHTNPKKNX1)
    public String getZtykzkiryouhtnpkknx1() {
        return ztykzkiryouhtnpkknx1;
    }

    public void setZtykzkiryouhtnpkknx1(String pZtykzkiryouhtnpkknx1) {
        ztykzkiryouhtnpkknx1 = pZtykzkiryouhtnpkknx1;
    }

    private String ztykzkiryoutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKZKIRYOUTKTBICDX2)
    public String getZtykzkiryoutktbicdx2() {
        return ztykzkiryoutktbicdx2;
    }

    public void setZtykzkiryoutktbicdx2(String pZtykzkiryoutktbicdx2) {
        ztykzkiryoutktbicdx2 = pZtykzkiryoutktbicdx2;
    }

    private String ztykzkiryouhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYKZKIRYOUHTNPKKNX2)
    public String getZtykzkiryouhtnpkknx2() {
        return ztykzkiryouhtnpkknx2;
    }

    public void setZtykzkiryouhtnpkknx2(String pZtykzkiryouhtnpkknx2) {
        ztykzkiryouhtnpkknx2 = pZtykzkiryouhtnpkknx2;
    }

    private String ztyyobiv12x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu2Ty.ZTYYOBIV12X10)
    public String getZtyyobiv12x10() {
        return ztyyobiv12x10;
    }

    public void setZtyyobiv12x10(String pZtyyobiv12x10) {
        ztyyobiv12x10 = pZtyyobiv12x10;
    }
}