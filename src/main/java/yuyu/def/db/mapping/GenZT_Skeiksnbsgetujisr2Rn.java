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
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル２（連） テーブルのマッピング情報クラスで、 {@link ZT_Skeiksnbsgetujisr2Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Skeiksnbsgetujisr2Rn}</td><td colspan="3">新契約決算ベース月次成立Ｆテーブル２（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnktgysyrymd zrnktgysyrymd}</td><td>（連携用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">{@link PKZT_Skeiksnbsgetujisr2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgyfilerenno zrnktgyfilerenno}</td><td>（連携用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteidairininkbn zrnsiteidairininkbn}</td><td>（連携用）指定代理人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrkykdrkbn zrnsrkykdrkbn}</td><td>（連携用）数理用契約者代理人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x3 zrnyobiv6x3}</td><td>（連携用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedstkykarihyj zrnlivingneedstkykarihyj}</td><td>（連携用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x12 zrnyobiv4x12}</td><td>（連携用）予備項目Ｖ４＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansupporttkykarihyj zrngansupporttkykarihyj}</td><td>（連携用）がんサポート特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x13 zrnyobiv4x13}</td><td>（連携用）予備項目Ｖ４＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakusyuruikigou zrntuuintokuyakusyuruikigou}</td><td>（連携用）通院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakukikan zrntuuintokuyakukikan}</td><td>（連携用）通院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuintkykphrkkkn zrntuintkykphrkkkn}</td><td>（連携用）通院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakunitigaku zrntuuintokuyakunitigaku}</td><td>（連携用）通院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakup zrntuuintokuyakup}</td><td>（連携用）通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakugatakbn zrntuuintokuyakugatakbn}</td><td>（連携用）通院特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuintkjyuryumshyutn zrntuintkjyuryumshyutn}</td><td>（連携用）通院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntuuintokujyoup zrntuuintokujyoup}</td><td>（連携用）通院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuuintokuteibuicdx1 zrntuuintokuteibuicdx1}</td><td>（連携用）通院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuinhutanpokikanx1 zrntuuinhutanpokikanx1}</td><td>（連携用）通院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuteibuicdx2 zrntuuintokuteibuicdx2}</td><td>（連携用）通院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuinhutanpokikanx2 zrntuuinhutanpokikanx2}</td><td>（連携用）通院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuintkykkgusdkbn zrntuintkykkgusdkbn}</td><td>（連携用）通院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuintkykpwrbkkbn zrntuintkykpwrbkkbn}</td><td>（連携用）通院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x4 zrnyobiv3x4}</td><td>（連携用）予備項目Ｖ３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tuintkyksyrikgu zrndi2tuintkyksyrikgu}</td><td>（連携用）第２通院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokuyakukikan zrndai2tuuintokuyakukikan}</td><td>（連携用）第２通院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuintkykphrkkkn zrndai2tuintkykphrkkkn}</td><td>（連携用）第２通院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokuyakuntgk zrndai2tuuintokuyakuntgk}</td><td>（連携用）第２通院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokuyakup zrndai2tuuintokuyakup}</td><td>（連携用）第２通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokuyakugatakbn zrndai2tuuintokuyakugatakbn}</td><td>（連携用）第２通院特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tuintkjyuryumshyutn zrndi2tuintkjyuryumshyutn}</td><td>（連携用）第２通院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokujyoup zrndai2tuuintokujyoup}</td><td>（連携用）第２通院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokuteibuicdx1 zrndai2tuuintokuteibuicdx1}</td><td>（連携用）第２通院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuuinhutanpokikanx1 zrndai2tuuinhutanpokikanx1}</td><td>（連携用）第２通院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuuintokuteibuicdx2 zrndai2tuuintokuteibuicdx2}</td><td>（連携用）第２通院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tuuinhutanpokikanx2 zrndai2tuuinhutanpokikanx2}</td><td>（連携用）第２通院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tuintkykkgusdkbn zrndi2tuintkykkgusdkbn}</td><td>（連携用）第２通院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tuintkykpwrbkkbn zrndi2tuintkykpwrbkkbn}</td><td>（連携用）第２通院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x5 zrnyobiv3x5}</td><td>（連携用）予備項目Ｖ３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangotokuyakusyuruikigou zrnkangotokuyakusyuruikigou}</td><td>（連携用）看護特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangotokuyakukikan zrnkangotokuyakukikan}</td><td>（連携用）看護特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangotkykphrkkkn zrnkangotkykphrkkkn}</td><td>（連携用）看護特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangotokuyakunitigaku zrnkangotokuyakunitigaku}</td><td>（連携用）看護特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkangotokuyakup zrnkangotokuyakup}</td><td>（連携用）看護特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkangotokuyakugatakbn zrnkangotokuyakugatakbn}</td><td>（連携用）看護特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkngtkjyuryumshyutn zrnkngtkjyuryumshyutn}</td><td>（連携用）看護特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkangotokujyoup zrnkangotokujyoup}</td><td>（連携用）看護特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkangotokuteibuicdx1 zrnkangotokuteibuicdx1}</td><td>（連携用）看護特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangohutanpokikanx1 zrnkangohutanpokikanx1}</td><td>（連携用）看護不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangotokuteibuicdx2 zrnkangotokuteibuicdx2}</td><td>（連携用）看護特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangohutanpokikanx2 zrnkangohutanpokikanx2}</td><td>（連携用）看護不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2kngtkyksyrikgu zrndi2kngtkyksyrikgu}</td><td>（連携用）第２看護特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokuyakukikan zrndai2kangotokuyakukikan}</td><td>（連携用）第２看護特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kngtkykphrkkkn zrndai2kngtkykphrkkkn}</td><td>（連携用）第２看護特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokuyakuntgk zrndai2kangotokuyakuntgk}</td><td>（連携用）第２看護特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokuyakup zrndai2kangotokuyakup}</td><td>（連携用）第２看護特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokuyakugatakbn zrndai2kangotokuyakugatakbn}</td><td>（連携用）第２看護特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2kngtkjyuryumshyutn zrndi2kngtkjyuryumshyutn}</td><td>（連携用）第２看護特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokujyoup zrndai2kangotokujyoup}</td><td>（連携用）第２看護特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokuteibuicdx1 zrndai2kangotokuteibuicdx1}</td><td>（連携用）第２看護特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kangohutanpokikanx1 zrndai2kangohutanpokikanx1}</td><td>（連携用）第２看護不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kangotokuteibuicdx2 zrndai2kangotokuteibuicdx2}</td><td>（連携用）第２看護特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kangohutanpokikanx2 zrndai2kangohutanpokikanx2}</td><td>（連携用）第２看護不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x2 zrnyobiv6x2}</td><td>（連携用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkyksyuruikgu zrnjysisppitkyksyuruikgu}</td><td>（連携用）女性疾病特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkkn zrnjysisppitkykkkn}</td><td>（連携用）女性疾病特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykphrkkkn zrnjysisppitkykphrkkkn}</td><td>（連携用）女性疾病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykntgk zrnjysisppitkykntgk}</td><td>（連携用）女性疾病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnjyoseisippeitokuyakup zrnjyoseisippeitokuyakup}</td><td>（連携用）女性疾病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkjyuryumshyutn zrnjysisppitkjyuryumshyutn}</td><td>（連携用）女性疾病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnjyoseisippeitokujyoup zrnjyoseisippeitokujyoup}</td><td>（連携用）女性疾病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjysisppitktbicdx1 zrnjysisppitktbicdx1}</td><td>（連携用）女性疾病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppihtnpkknx1 zrnjysisppihtnpkknx1}</td><td>（連携用）女性疾病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitktbicdx2 zrnjysisppitktbicdx2}</td><td>（連携用）女性疾病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppihtnpkknx2 zrnjysisppihtnpkknx2}</td><td>（連携用）女性疾病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkgusdkbn zrnjysisppitkykkgusdkbn}</td><td>（連携用）女性疾病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykpwrbkkbn zrnjysisppitkykpwrbkkbn}</td><td>（連携用）女性疾病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjysisppitkykkusnmnryoage zrnjysisppitkykkusnmnryoage}</td><td>（連携用）女性疾病特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x2 zrnyobiv2x2}</td><td>（連携用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkyksyrikgu zrndi2jysisppitkyksyrikgu}</td><td>（連携用）第２女性疾病特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkkn zrndi2jysisppitkykkkn}</td><td>（連携用）第２女性疾病特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykphrkkkn zrndi2jysisppitkykphrkkkn}</td><td>（連携用）第２女性疾病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykntgk zrndi2jysisppitkykntgk}</td><td>（連携用）第２女性疾病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykp zrndi2jysisppitkykp}</td><td>（連携用）第２女性疾病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkjyurymshytn zrndi2jysisppitkjyurymshytn}</td><td>（連携用）第２女性疾病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkjyup zrndi2jysisppitkjyup}</td><td>（連携用）第２女性疾病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitktbicdx1 zrndi2jysisppitktbicdx1}</td><td>（連携用）第２女性疾病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppihtnpkknx1 zrndi2jysisppihtnpkknx1}</td><td>（連携用）第２女性疾病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitktbicdx2 zrndi2jysisppitktbicdx2}</td><td>（連携用）第２女性疾病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppihtnpkknx2 zrndi2jysisppihtnpkknx2}</td><td>（連携用）第２女性疾病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykkgusdkbn zrndi2jysisppitkykkgusdkbn}</td><td>（連携用）第２女性疾病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jysisppitkykpwrbkkbn zrndi2jysisppitkykpwrbkkbn}</td><td>（連携用）第２女性疾病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x14 zrnyobiv4x14}</td><td>（連携用）予備項目Ｖ４＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwinninglifehyouji zrnwinninglifehyouji}</td><td>（連携用）ウィニングライフ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstyouikusikinuktrininkbn zrnstyouikusikinuktrininkbn}</td><td>（連携用）指定養育資金受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudthumeharaitkykarihyj zrnjyudthumeharaitkykarihyj}</td><td>（連携用）重度痴呆前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkenkouseikatupackhyj zrnsinkenkouseikatupackhyj}</td><td>（連携用）新健康生活パック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakupwaribikikbn zrnsyukeiyakupwaribikikbn}</td><td>（連携用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykyktnknyugukbn zrnsykyktnknyugukbn}</td><td>（連携用）主契約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosjihonninkknnkbn zrnmosjihonninkknnkbn}</td><td>（連携用）申込時本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenhonsuu zrnkituenhonsuu}</td><td>（連携用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinmaetenkannensuukbn zrnkousinmaetenkannensuukbn}</td><td>（連携用）更新前転換年数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankimaetenkannensuukbn zrnmankimaetenkannensuukbn}</td><td>（連携用）満期前転換年数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikitenkanhyouji zrnseikitenkanhyouji}</td><td>（連携用）正規転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakutenkankykhyj zrngengakutenkankykhyj}</td><td>（連携用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x3 zrnyobiv2x3}</td><td>（連携用）予備項目Ｖ２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousin3nenmaetnknhyj zrnkousin3nenmaetnknhyj}</td><td>（連携用）更新３年前転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndugktnknsntkhuhukbn zrndugktnknsntkhuhukbn}</td><td>（連携用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknsnstkbttrtkkbn zrntnknsnstkbttrtkkbn}</td><td>（連携用）転換診査特別取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiginyuintkykgkntgk zrnhtnknsiginyuintkykgkntgk}</td><td>（連携用）被転換災害入院特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiginyuintkykkykymd zrnhtnknsiginyuintkykkykymd}</td><td>（連携用）被転換災害入院特約契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiginyuintkyksnskbn zrnhtnknsiginyuintkyksnskbn}</td><td>（連携用）被転換災害入院特約診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsppinyuintkykgkntgk zrnhtnknsppinyuintkykgkntgk}</td><td>（連携用）被転換疾病入院特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknsppinyuintkykkykymd zrnhtnknsppinyuintkykkykymd}</td><td>（連携用）被転換疾病入院特約契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsppinyuintkyksnskbn zrnhtnknsppinyuintkyksnskbn}</td><td>（連携用）被転換疾病入院特約診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsijnbyutkykgukintgk zrnhtnknsijnbyutkykgukintgk}</td><td>（連携用）被転換成人病特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknsijnbyutkykkykymd zrnhtnknsijnbyutkykkykymd}</td><td>（連携用）被転換成人病特約契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsijnbyutkyksnskbn zrnhtnknsijnbyutkyksnskbn}</td><td>（連携用）被転換成人病特約診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjysisppitkykgkintgk zrnhtnknjysisppitkykgkintgk}</td><td>（連携用）被転換女性疾病特約合計日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknjysisppitkykkykymd zrnhtnknjysisppitkykkykymd}</td><td>（連携用）被転換女性疾病特約契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjysisppitkyksnskbn zrnhtnknjysisppitkyksnskbn}</td><td>（連携用）被転換女性疾病特約診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteizukipwarimasihyouji zrnsiteizukipwarimasihyouji}</td><td>（連携用）指定月Ｐ割増表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim1 zrnpwarimasisiteim1}</td><td>（連携用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim2 zrnpwarimasisiteim2}</td><td>（連携用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteimsykykpbairitu zrnsiteimsykykpbairitu}</td><td>（連携用）指定月主契約Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteizukisyukeiyakup zrnsiteizukisyukeiyakup}</td><td>（連携用）指定月主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuujyoutukiharaikomip zrntuujyoutukiharaikomip}</td><td>（連携用）通常月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteizukiharaikomip zrnsiteizukiharaikomip}</td><td>（連携用）指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruteikisiteizukip zrnmaruteikisiteizukip}</td><td>（連携用）マル定指定月Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseizonmaruteisiteimp zrnseizonmaruteisiteimp}</td><td>（連携用）生存マル定指定月Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruteipsiteibairitu zrnmaruteipsiteibairitu}</td><td>（連携用）マル定Ｐ指定倍率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmaruteipstbairitu zrnseizonmaruteipstbairitu}</td><td>（連携用）生存マル定Ｐ指定倍率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtisyuruikgu zrnnkdtmrtisyuruikgu}</td><td>（連携用）年金建マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkindatemaruteikikan zrnnenkindatemaruteikikan}</td><td>（連携用）年金建マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteiphrkkkn zrnnkdatemaruteiphrkkkn}</td><td>（連携用）年金建マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteinenkinnengk zrnnkdatemaruteinenkinnengk}</td><td>（連携用）年金建マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkindatemaruteis zrnnenkindatemaruteis}</td><td>（連携用）年金建マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkindatemaruteip zrnnenkindatemaruteip}</td><td>（連携用）年金建マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteimods zrnnkdatemaruteimods}</td><td>（連携用）年金建マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtimodsskgnhyj zrnnkdtmrtimodsskgnhyj}</td><td>（連携用）年金建マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteitkjyoukbn zrnnkdatemaruteitkjyoukbn}</td><td>（連携用）年金建マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtitkjyouskgnkkn zrnnkdtmrtitkjyouskgnkkn}</td><td>（連携用）年金建マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtitkjyouryumshytn zrnnkdtmrtitkjyouryumshytn}</td><td>（連携用）年金建マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteitkjyoup zrnnkdatemaruteitkjyoup}</td><td>（連携用）年金建マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkdtmrtisyuruikgux1 zrnhtnknnkdtmrtisyuruikgux1}</td><td>（連携用）被転換年金建マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkdtmrtisyuruikgux2 zrnhtnknnkdtmrtisyuruikgux2}</td><td>（連携用）被転換年金建マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkdtmrtisyuruikgux3 zrnhtnknnkdtmrtisyuruikgux3}</td><td>（連携用）被転換年金建マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkdtmrtisyuruikgux4 zrnhtnknnkdtmrtisyuruikgux4}</td><td>（連携用）被転換年金建マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkdtmrtisyuruikgux5 zrnhtnknnkdtmrtisyuruikgux5}</td><td>（連携用）被転換年金建マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkdtmrtisyuruikgux6 zrnhtnknnkdtmrtisyuruikgux6}</td><td>（連携用）被転換年金建マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteishrkkn zrnnkdatemaruteishrkkn}</td><td>（連携用）年金建マル定支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuriyounkdtmrtipwrbkkbn zrnsuriyounkdtmrtipwrbkkbn}</td><td>（連携用）数理用年金建マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatemaruteipwrbkkbn zrnnkdatemaruteipwrbkkbn}</td><td>（連携用）年金建マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiteimhyjx1 zrnhtnknkyksiteimhyjx1}</td><td>（連携用）被転換契約指定月表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiteimhyjx2 zrnhtnknkyksiteimhyjx2}</td><td>（連携用）被転換契約指定月表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiteimhyjx3 zrnhtnknkyksiteimhyjx3}</td><td>（連携用）被転換契約指定月表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiteimhyjx4 zrnhtnknkyksiteimhyjx4}</td><td>（連携用）被転換契約指定月表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiteimhyjx5 zrnhtnknkyksiteimhyjx5}</td><td>（連携用）被転換契約指定月表示＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiteimhyjx6 zrnhtnknkyksiteimhyjx6}</td><td>（連携用）被転換契約指定月表示＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyohkreinyutkbttrtkhyj zrntyohkreinyutkbttrtkhyj}</td><td>（連携用）重複戻入特別取扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtinknengk zrnkazokumrtinknengk}</td><td>（連携用）家族マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnalmyoukijyunym zrnalmyoukijyunym}</td><td>（連携用）ＡＬＭ用基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitesyono2 zrnsetaitesyono2}</td><td>（連携用）セット相手証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehokensyuruikigou2 zrnsetaitehokensyuruikigou2}</td><td>（連携用）セット相手保険種類記号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitemrtisyuruikgu2 zrnsetaitemrtisyuruikgu2}</td><td>（連携用）セット相手マル定種類記号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitesiznmrtisyurui2 zrnsetaitesiznmrtisyurui2}</td><td>（連携用）セット相手生存マル定種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitetignmrtisyurui2 zrnsetaitetignmrtisyurui2}</td><td>（連携用）セット相手逓減マル定種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitekihonbubuns2 zrnsetaitekihonbubuns2}</td><td>（連携用）セット相手基本部分Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetgukitnknitjbrkhns2 zrnsetgukitnknitjbrkhns2}</td><td>（連携用）セット合計転換一時払基本Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesibous2 zrnsetaitesibous2}</td><td>（連携用）セット相手死亡Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetgukitnknitjbrsbus2 zrnsetgukitnknitjbrsbus2}</td><td>（連携用）セット合計転換一時払死亡Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesyuuseis2 zrnsetaitesyuuseis2}</td><td>（連携用）セット相手修正Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaiteharaikomip2 zrnsetaiteharaikomip2}</td><td>（連携用）セット相手払込Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesyukeiyakububunp2 zrnsetaitesyukeiyakububunp2}</td><td>（連携用）セット相手主契約部分Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitgukikzkmrtis2 zrnsetaitgukikzkmrtis2}</td><td>（連携用）セット相手合計家族マル定Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitetenkankykhyj2 zrnsetaitetenkankykhyj2}</td><td>（連携用）セット相手転換契約表示２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitesiteimhrkp2 zrnsetaitesiteimhrkp2}</td><td>（連携用）セット相手指定月払込Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesiteimsykykp2 zrnsetaitesiteimsykykp2}</td><td>（連携用）セット相手指定月主契約Ｐ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitenkmrtisyurui2 zrnsetaitenkmrtisyurui2}</td><td>（連携用）セット相手年金マル定種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehknkgusdkbn2 zrnsetaitehknkgusdkbn2}</td><td>（連携用）セット相手保険記号世代区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndujmossitismodsyuguhyj zrndujmossitismodsyuguhyj}</td><td>（連携用）同時申込最低Ｓ修正Ｓ優遇表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrnsijhiyubrijdujmoskbn zrnrnsijhiyubrijdujmoskbn}</td><td>（連携用）連生時併用払時同時申込区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntktsppisykyktikknbbns zrntktsppisykyktikknbbns}</td><td>（連携用）特定疾病主契約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntksttkyksyuruikgu zrntksttkyksyuruikgu}</td><td>（連携用）特疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusitutokuyakukikan zrntokusitutokuyakukikan}</td><td>（連携用）特疾特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykphrkkkn zrntksttkykphrkkkn}</td><td>（連携用）特疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusitutokuyakus zrntokusitutokuyakus}</td><td>（連携用）特疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokusitutokuyakup zrntokusitutokuyakup}</td><td>（連携用）特疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokusitutokuyakusyuuseis zrntokusitutokuyakusyuuseis}</td><td>（連携用）特疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntksttkykmodssakugenhyj zrntksttkykmodssakugenhyj}</td><td>（連携用）特疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkyktkjyukbn zrntksttkyktkjyukbn}</td><td>（連携用）特疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkyktkjyuskgnkkn zrntksttkyktkjyuskgnkkn}</td><td>（連携用）特疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkyktkjyuryumshyutn zrntksttkyktkjyuryumshyutn}</td><td>（連携用）特疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntksttkyktkjyup zrntksttkyktkjyup}</td><td>（連携用）特疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntksttkyktikknbbns zrntksttkyktikknbbns}</td><td>（連携用）特疾特約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppitkykkgux1 zrnhtnkntktsppitkykkgux1}</td><td>（連携用）被転換特定疾病特約記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppitkykkgux2 zrnhtnkntktsppitkykkgux2}</td><td>（連携用）被転換特定疾病特約記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppitkykkgux3 zrnhtnkntktsppitkykkgux3}</td><td>（連携用）被転換特定疾病特約記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppitkykkgux4 zrnhtnkntktsppitkykkgux4}</td><td>（連携用）被転換特定疾病特約記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppitkykkgux5 zrnhtnkntktsppitkykkgux5}</td><td>（連携用）被転換特定疾病特約記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntktsppitkykkgux6 zrnhtnkntktsppitkykkgux6}</td><td>（連携用）被転換特定疾病特約記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryutksttkykpwrbkkbn zrnsuryutksttkykpwrbkkbn}</td><td>（連携用）数理用特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykpwrbkkbn zrntksttkykpwrbkkbn}</td><td>（連携用）特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkyktnknyugukbn zrntksttkyktnknyugukbn}</td><td>（連携用）特疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksttkykkgusdkbn zrntksttkykkgusdkbn}</td><td>（連携用）特疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x8 zrnyobiv9x8}</td><td>（連携用）予備項目Ｖ９＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyksyrikgu zrndi2tksttkyksyrikgu}</td><td>（連携用）第２特疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tokusitutokuyakukkn zrndai2tokusitutokuyakukkn}</td><td>（連携用）第２特疾特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tksttkykphrkkkn zrndai2tksttkykphrkkkn}</td><td>（連携用）第２特疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tokusitutokuyakus zrndai2tokusitutokuyakus}</td><td>（連携用）第２特疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2tokusitutokuyakup zrndai2tokusitutokuyakup}</td><td>（連携用）第２特疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyksyuuseis zrndi2tksttkyksyuuseis}</td><td>（連携用）第２特疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykmodsskgnhyj zrndi2tksttkykmodsskgnhyj}</td><td>（連携用）第２特疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyktkjyukbn zrndi2tksttkyktkjyukbn}</td><td>（連携用）第２特疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyktkjyuskgnkkn zrndi2tksttkyktkjyuskgnkkn}</td><td>（連携用）第２特疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyktkjyurymshytn zrndi2tksttkyktkjyurymshytn}</td><td>（連携用）第２特疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyktkjyup zrndi2tksttkyktkjyup}</td><td>（連携用）第２特疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyktaikknbbns zrndi2tksttkyktaikknbbns}</td><td>（連携用）第２特疾特約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tktsppitkykkgux1 zrnhtnkndi2tktsppitkykkgux1}</td><td>（連携用）被転換第２特定疾病特約記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tktsppitkykkgux2 zrnhtnkndi2tktsppitkykkgux2}</td><td>（連携用）被転換第２特定疾病特約記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tktsppitkykkgux3 zrnhtnkndi2tktsppitkykkgux3}</td><td>（連携用）被転換第２特定疾病特約記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tktsppitkykkgux4 zrnhtnkndi2tktsppitkykkgux4}</td><td>（連携用）被転換第２特定疾病特約記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tktsppitkykkgux5 zrnhtnkndi2tktsppitkykkgux5}</td><td>（連携用）被転換第２特定疾病特約記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tktsppitkykkgux6 zrnhtnkndi2tktsppitkykkgux6}</td><td>（連携用）被転換第２特定疾病特約記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryudi2tksttkykpwrbkkbn zrnsuryudi2tksttkykpwrbkkbn}</td><td>（連携用）数理用第２特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykpwrbkkbn zrndi2tksttkykpwrbkkbn}</td><td>（連携用）第２特疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkyktnknyugukbn zrndi2tksttkyktnknyugukbn}</td><td>（連携用）第２特疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2tksttkykkgusdkbn zrndi2tksttkykkgusdkbn}</td><td>（連携用）第２特疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x9 zrnyobiv9x9}</td><td>（連携用）予備項目Ｖ９＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyksyuruikgu zrnjyuusitutkyksyuruikgu}</td><td>（連携用）重疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutokuyakukikan zrnjyuusitutokuyakukikan}</td><td>（連携用）重疾特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkykphrkkkn zrnjyuusitutkykphrkkkn}</td><td>（連携用）重疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutokuyakus zrnjyuusitutokuyakus}</td><td>（連携用）重疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutokuyakup zrnjyuusitutokuyakup}</td><td>（連携用）重疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutokuyakusyuuseis zrnjyuusitutokuyakusyuuseis}</td><td>（連携用）重疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkykmodsskgnhyj zrnjyuusitutkykmodsskgnhyj}</td><td>（連携用）重疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyktkjyukbn zrnjyuusitutkyktkjyukbn}</td><td>（連携用）重疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyktkjyuskgnkkn zrnjyuusitutkyktkjyuskgnkkn}</td><td>（連携用）重疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyusttkyktkjyuryumshyutn zrnjyusttkyktkjyuryumshyutn}</td><td>（連携用）重疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyktkjyup zrnjyuusitutkyktkjyup}</td><td>（連携用）重疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyktktbicdx1 zrnjyuusitutkyktktbicdx1}</td><td>（連携用）重疾特約特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkykhtnpkknx1 zrnjyuusitutkykhtnpkknx1}</td><td>（連携用）重疾特約不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyktktbicdx2 zrnjyuusitutkyktktbicdx2}</td><td>（連携用）重疾特約特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkykhtnpkknx2 zrnjyuusitutkykhtnpkknx2}</td><td>（連携用）重疾特約不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskkntkykkgux1 zrnhtnknmnsiskkntkykkgux1}</td><td>（連携用）被転換慢性疾患特約記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskkntkykkgux2 zrnhtnknmnsiskkntkykkgux2}</td><td>（連携用）被転換慢性疾患特約記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskkntkykkgux3 zrnhtnknmnsiskkntkykkgux3}</td><td>（連携用）被転換慢性疾患特約記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskkntkykkgux4 zrnhtnknmnsiskkntkykkgux4}</td><td>（連携用）被転換慢性疾患特約記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskkntkykkgux5 zrnhtnknmnsiskkntkykkgux5}</td><td>（連携用）被転換慢性疾患特約記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmnsiskkntkykkgux6 zrnhtnknmnsiskkntkykkgux6}</td><td>（連携用）被転換慢性疾患特約記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryujyusttkykpwrbkkbn zrnsuryujyusttkykpwrbkkbn}</td><td>（連携用）数理用重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkykpwrbkkbn zrnjyuusitutkykpwrbkkbn}</td><td>（連携用）重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkyktnknyugukbn zrnjyuusitutkyktnknyugukbn}</td><td>（連携用）重疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuusitutkykkgusdkbn zrnjyuusitutkykkgusdkbn}</td><td>（連携用）重疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x3 zrnyobiv7x3}</td><td>（連携用）予備項目Ｖ７＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkyksyrikgu zrndi2jyuusitutkyksyrikgu}</td><td>（連携用）第２重疾特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkykkkn zrndi2jyuusitutkykkkn}</td><td>（連携用）第２重疾特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkykphrkkkn zrndi2jyuusitutkykphrkkkn}</td><td>（連携用）第２重疾特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2jyuusitutokuyakus zrndai2jyuusitutokuyakus}</td><td>（連携用）第２重疾特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2jyuusitutokuyakup zrndai2jyuusitutokuyakup}</td><td>（連携用）第２重疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkyksyuuseis zrndi2jyuusitutkyksyuuseis}</td><td>（連携用）第２重疾特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2jyusttkykmodsskgnhyj zrndi2jyusttkykmodsskgnhyj}</td><td>（連携用）第２重疾特約修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkyktkjyukbn zrndi2jyuusitutkyktkjyukbn}</td><td>（連携用）第２重疾特約特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyusttkyktkjyuskgnkkn zrndi2jyusttkyktkjyuskgnkkn}</td><td>（連携用）第２重疾特約特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyusttkyktkjyrymshytn zrndi2jyusttkyktkjyrymshytn}</td><td>（連携用）第２重疾特約特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkyktkjyup zrndi2jyuusitutkyktkjyup}</td><td>（連携用）第２重疾特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkyktktbicdx1 zrndi2jyuusitutkyktktbicdx1}</td><td>（連携用）第２重疾特約特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkykhtnpkknx1 zrndi2jyuusitutkykhtnpkknx1}</td><td>（連携用）第２重疾特約不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkyktktbicdx2 zrndi2jyuusitutkyktktbicdx2}</td><td>（連携用）第２重疾特約特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkykhtnpkknx2 zrndi2jyuusitutkykhtnpkknx2}</td><td>（連携用）第２重疾特約不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnsiskkntkykkgx1 zrnhtnkndi2mnsiskkntkykkgx1}</td><td>（連携用）被転換第２慢性疾患特約記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnsiskkntkykkgx2 zrnhtnkndi2mnsiskkntkykkgx2}</td><td>（連携用）被転換第２慢性疾患特約記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnsiskkntkykkgx3 zrnhtnkndi2mnsiskkntkykkgx3}</td><td>（連携用）被転換第２慢性疾患特約記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnsiskkntkykkgx4 zrnhtnkndi2mnsiskkntkykkgx4}</td><td>（連携用）被転換第２慢性疾患特約記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnsiskkntkykkgx5 zrnhtnkndi2mnsiskkntkykkgx5}</td><td>（連携用）被転換第２慢性疾患特約記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2mnsiskkntkykkgx6 zrnhtnkndi2mnsiskkntkykkgx6}</td><td>（連携用）被転換第２慢性疾患特約記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryud2jyusttkykpwrbkkbn zrnsuryud2jyusttkykpwrbkkbn}</td><td>（連携用）数理用第２重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkykpwrbkkbn zrndi2jyuusitutkykpwrbkkbn}</td><td>（連携用）第２重疾特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyusttkyktnknyugukbn zrndi2jyusttkyktnknyugukbn}</td><td>（連携用）第２重疾特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2jyuusitutkykkgusdkbn zrndi2jyuusitutkykkgusdkbn}</td><td>（連携用）第２重疾特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x4 zrnyobiv7x4}</td><td>（連携用）予備項目Ｖ７＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitousiharaikbn zrnhaitousiharaikbn}</td><td>（連携用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryusykykpwrbkkbn zrnsuryusykykpwrbkkbn}</td><td>（連携用）数理用主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteisyuruikgu zrnnkdatetokuteisyuruikgu}</td><td>（連携用）年金建トク定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkindatetokuteikikan zrnnenkindatetokuteikikan}</td><td>（連携用）年金建トク定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteinkgk zrnnkdatetokuteinkgk}</td><td>（連携用）年金建トク定年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkindatetokuteis zrnnenkindatetokuteis}</td><td>（連携用）年金建トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkindatetokuteip zrnnenkindatetokuteip}</td><td>（連携用）年金建トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteisdtpdtkbn zrnnkdatetokuteisdtpdtkbn}</td><td>（連携用）年金建トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteimods zrnnkdatetokuteimods}</td><td>（連携用）年金建トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteimodsskgnhyj zrnnkdatetokuteimodsskgnhyj}</td><td>（連携用）年金建トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteishrkkn zrnnkdatetokuteishrkkn}</td><td>（連携用）年金建トク定支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyutksytioukbn zrnkykniyutksytioukbn}</td><td>（連携用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeika2nenmimantenkanhyj zrnkeika2nenmimantenkanhyj}</td><td>（連携用）経過２年未満転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntukiyuhtnknkusnmennsukbn zrntukiyuhtnknkusnmennsukbn}</td><td>（連携用）統計用被転換更新前年数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdatetokuteikgusdkbn zrnnkdatetokuteikgusdkbn}</td><td>（連携用）年金建トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkindatetokuteikatakbn zrnnenkindatetokuteikatakbn}</td><td>（連携用）年金建トク定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x4 zrnyobiv2x4}</td><td>（連携用）予備項目Ｖ２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkyksyuruikgu zrnsugusnsyutkyksyuruikgu}</td><td>（連携用）総合損傷特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkkn zrnsugusnsyutkykkkn}</td><td>（連携用）総合損傷特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykphrkkkn zrnsugusnsyutkykphrkkkn}</td><td>（連携用）総合損傷特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsougousonsyoutokuyakus zrnsougousonsyoutokuyakus}</td><td>（連携用）総合損傷特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsougousonsyoutokuyakup zrnsougousonsyoutokuyakup}</td><td>（連携用）総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkgusdkbn zrnsugusnsyutkykkgusdkbn}</td><td>（連携用）総合損傷特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykpwrbkkbn zrnsugusnsyutkykpwrbkkbn}</td><td>（連携用）総合損傷特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsugusnsyutkykkusnmnryage zrnsugusnsyutkykkusnmnryage}</td><td>（連携用）総合損傷特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x5 zrnyobiv7x5}</td><td>（連携用）予備項目Ｖ７＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkyksyrikgu zrndi2sugusnsyutkyksyrikgu}</td><td>（連携用）第２総合損傷特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykkkn zrndi2sugusnsyutkykkkn}</td><td>（連携用）第２総合損傷特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykphrkkkn zrndi2sugusnsyutkykphrkkkn}</td><td>（連携用）第２総合損傷特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkyks zrndi2sugusnsyutkyks}</td><td>（連携用）第２総合損傷特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykp zrndi2sugusnsyutkykp}</td><td>（連携用）第２総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsytkykkgusdkbn zrndi2sugusnsytkykkgusdkbn}</td><td>（連携用）第２総合損傷特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sugusnsyutkykpwrbkkbn zrndi2sugusnsyutkykpwrbkkbn}</td><td>（連携用）第２総合損傷特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x10 zrnyobiv9x10}</td><td>（連携用）予備項目Ｖ９＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankeitaikbn zrntenkankeitaikbn}</td><td>（連携用）転換形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngukitnknitjbrtiknknengk zrngukitnknitjbrtiknknengk}</td><td>（連携用）合計転換一時払定期年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknsugusnsyutkyks zrngukihtnknsugusnsyutkyks}</td><td>（連携用）合計被転換総合損傷特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanitijibaraip zrntenkanitijibaraip}</td><td>（連携用）転換一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanpx1 zrngoukeinenbaraikansanpx1}</td><td>（連携用）合計年払換算Ｐ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx1 zrnhktgtikkikkknx1}</td><td>（連携用）引継定期経過期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkigmrsysyrikgux1 zrnhtnknkykkigmrsysyrikgux1}</td><td>（連携用）被転換契約介護マル終種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanpx2 zrngoukeinenbaraikansanpx2}</td><td>（連携用）合計年払換算Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx2 zrnhktgtikkikkknx2}</td><td>（連携用）引継定期経過期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkigmrsysyrikgux2 zrnhtnknkykkigmrsysyrikgux2}</td><td>（連携用）被転換契約介護マル終種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanpx3 zrngoukeinenbaraikansanpx3}</td><td>（連携用）合計年払換算Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx3 zrnhktgtikkikkknx3}</td><td>（連携用）引継定期経過期間＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkigmrsysyrikgux3 zrnhtnknkykkigmrsysyrikgux3}</td><td>（連携用）被転換契約介護マル終種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanpx4 zrngoukeinenbaraikansanpx4}</td><td>（連携用）合計年払換算Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx4 zrnhktgtikkikkknx4}</td><td>（連携用）引継定期経過期間＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkigmrsysyrikgux4 zrnhtnknkykkigmrsysyrikgux4}</td><td>（連携用）被転換契約介護マル終種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanpx5 zrngoukeinenbaraikansanpx5}</td><td>（連携用）合計年払換算Ｐ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx5 zrnhktgtikkikkknx5}</td><td>（連携用）引継定期経過期間＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkigmrsysyrikgux5 zrnhtnknkykkigmrsysyrikgux5}</td><td>（連携用）被転換契約介護マル終種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanpx6 zrngoukeinenbaraikansanpx6}</td><td>（連携用）合計年払換算Ｐ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx6 zrnhktgtikkikkknx6}</td><td>（連携用）引継定期経過期間＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkigmrsysyrikgux6 zrnhtnknkykkigmrsysyrikgux6}</td><td>（連携用）被転換契約介護マル終種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnniceonplanhyj zrnniceonplanhyj}</td><td>（連携用）ナイスオンプラン表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipryosyuymd zrnsyokaipryosyuymd}</td><td>（連携用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnldownmaetenkannensuukbn zrnldownmaetenkannensuukbn}</td><td>（連携用）Ｌダウン前転換年数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnldownmaesaiteismitatuhyj zrnldownmaesaiteismitatuhyj}</td><td>（連携用）Ｌダウン前最低Ｓ未達表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntitikgtkbttrtkhyj zrndntitikgtkbttrtkhyj}</td><td>（連携用）団体定期後特別取扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreformkbn zrnreformkbn}</td><td>（連携用）リフォーム区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakutyuuihyouji zrnkikeiyakutyuuihyouji}</td><td>（連携用）既契約注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegcd zrnkbnkeiriyousegcd}</td><td>（連携用）区分経理用ＳＥＧコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuuseiskiteitekiyoukbn zrnsyuuseiskiteitekiyoukbn}</td><td>（連携用）修正Ｓ規程適用区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkzkmrtimods zrngukihtnknkzkmrtimods}</td><td>（連携用）合計被転換家族マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknkijyntkyuhtnknsbus zrntnknkijyntkyuhtnknsbus}</td><td>（連携用）転換基準適用被転換死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsrjsnyusyouhinhyj zrnsrjsnyusyouhinhyj}</td><td>（連携用）白地専用商品表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsirajikakuninzumihyouji zrnsirajikakuninzumihyouji}</td><td>（連携用）白地確認済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrjsnyusyouhintknnhyj zrnsrjsnyusyouhintknnhyj}</td><td>（連携用）白地専用商品特認表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsakbn zrnsinsakbn}</td><td>（連携用）診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2sinsakbn zrndai2sinsakbn}</td><td>（連携用）第２診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2toukeiyousinsakbn zrndai2toukeiyousinsakbn}</td><td>（連携用）第２統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonkyuhknshrsiteimd zrnseizonkyuhknshrsiteimd}</td><td>（連携用）生存給付金支払指定月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5 zrnyoteiriritun5}</td><td>（連携用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsaiteihosyouriritu zrnsaiteihosyouriritu}</td><td>（連携用）最低保障利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnkgnsritu zrnnkgnsritu}</td><td>（連携用）年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnjigyounendomatuv zrnjigyounendomatuv}</td><td>（連携用）事業年度末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnkn5nnmeksnyumods zrngukihtnkn5nnmeksnyumods}</td><td>（連携用）合計被転換５年前加算用修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrenseiteikitksyusnksnhyj zrnrenseiteikitksyusnksnhyj}</td><td>（連携用）連生定期付終身加算表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp2x1 zrngoukeinenbaraikansanp2x1}</td><td>（連携用）合計年払換算Ｐ２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukinenbaraiknsnp2kbnx1 zrngukinenbaraiknsnp2kbnx1}</td><td>（連携用）合計年払換算Ｐ２区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn2x1 zrnhktgtikkikkkn2x1}</td><td>（連携用）引継定期経過期間２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp2x2 zrngoukeinenbaraikansanp2x2}</td><td>（連携用）合計年払換算Ｐ２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukinenbaraiknsnp2kbnx2 zrngukinenbaraiknsnp2kbnx2}</td><td>（連携用）合計年払換算Ｐ２区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn2x2 zrnhktgtikkikkkn2x2}</td><td>（連携用）引継定期経過期間２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp2x3 zrngoukeinenbaraikansanp2x3}</td><td>（連携用）合計年払換算Ｐ２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukinenbaraiknsnp2kbnx3 zrngukinenbaraiknsnp2kbnx3}</td><td>（連携用）合計年払換算Ｐ２区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn2x3 zrnhktgtikkikkkn2x3}</td><td>（連携用）引継定期経過期間２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp2x4 zrngoukeinenbaraikansanp2x4}</td><td>（連携用）合計年払換算Ｐ２＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukinenbaraiknsnp2kbnx4 zrngukinenbaraiknsnp2kbnx4}</td><td>（連携用）合計年払換算Ｐ２区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn2x4 zrnhktgtikkikkkn2x4}</td><td>（連携用）引継定期経過期間２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp2x5 zrngoukeinenbaraikansanp2x5}</td><td>（連携用）合計年払換算Ｐ２＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukinenbaraiknsnp2kbnx5 zrngukinenbaraiknsnp2kbnx5}</td><td>（連携用）合計年払換算Ｐ２区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn2x5 zrnhktgtikkikkkn2x5}</td><td>（連携用）引継定期経過期間２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp2x6 zrngoukeinenbaraikansanp2x6}</td><td>（連携用）合計年払換算Ｐ２＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukinenbaraiknsnp2kbnx6 zrngukinenbaraiknsnp2kbnx6}</td><td>（連携用）合計年払換算Ｐ２区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn2x6 zrnhktgtikkikkkn2x6}</td><td>（連携用）引継定期経過期間２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutituusantaisyous zrnkokutituusantaisyous}</td><td>（連携用）告知通算対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokusyuyouroumankis zrntokusyuyouroumankis}</td><td>（連携用）特殊養老満期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtitnknyuuguukbn zrnnkdtmrtitnknyuuguukbn}</td><td>（連携用）年金建マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikgusdkbn zrnnkdtmrtikgusdkbn}</td><td>（連携用）年金建マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkindatemaruteikatakbn zrnnenkindatemaruteikatakbn}</td><td>（連携用）年金建マル定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkdtmrtikusnmnryoage zrnnkdtmrtikusnmnryoage}</td><td>（連携用）年金建マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtisyuruikgu zrnkaigonkdtmrtisyuruikgu}</td><td>（連携用）介護年金建マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikkan zrnkaigonkdtmrtikkan}</td><td>（連携用）介護年金建マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtiphrkkkn zrnkaigonkdtmrtiphrkkkn}</td><td>（連携用）介護年金建マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtinnknnengk zrnkaigonkdtmrtinnknnengk}</td><td>（連携用）介護年金建マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtis zrnkaigonkdtmrtis}</td><td>（連携用）介護年金建マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtip zrnkaigonkdtmrtip}</td><td>（連携用）介護年金建マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtimods zrnkaigonkdtmrtimods}</td><td>（連携用）介護年金建マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtitkjyukbn zrnkaigonkdtmrtitkjyukbn}</td><td>（連携用）介護年金建マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtitkjyskgnkkn zrnkaigonkdtmrtitkjyskgnkkn}</td><td>（連携用）介護年金建マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrttkjyrymshytn zrnkaigonkdtmrttkjyrymshytn}</td><td>（連携用）介護年金建マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtitkjyup zrnkaigonkdtmrtitkjyup}</td><td>（連携用）介護年金建マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtsyrikgux1 zrnhtnknkaigonkmrtsyrikgux1}</td><td>（連携用）被転換介護年金マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtsyrikgux2 zrnhtnknkaigonkmrtsyrikgux2}</td><td>（連携用）被転換介護年金マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtsyrikgux3 zrnhtnknkaigonkmrtsyrikgux3}</td><td>（連携用）被転換介護年金マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtsyrikgux4 zrnhtnknkaigonkmrtsyrikgux4}</td><td>（連携用）被転換介護年金マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtsyrikgux5 zrnhtnknkaigonkmrtsyrikgux5}</td><td>（連携用）被転換介護年金マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtsyrikgux6 zrnhtnknkaigonkmrtsyrikgux6}</td><td>（連携用）被転換介護年金マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtishrkkn zrnkaigonkdtmrtishrkkn}</td><td>（連携用）介護年金建マル定支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsurikaigonkmrtipwrbkkbn zrnsurikaigonkmrtipwrbkkbn}</td><td>（連携用）数理介護年金マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtipwrbkkbn zrnkaigonkdtmrtipwrbkkbn}</td><td>（連携用）介護年金建マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtitnknyugukbn zrnkaigonkdtmrtitnknyugukbn}</td><td>（連携用）介護年金建マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtikgusdkbn zrnkaigonkdtmrtikgusdkbn}</td><td>（連携用）介護年金建マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdtmrtiktkbn zrnkaigonkdtmrtiktkbn}</td><td>（連携用）介護年金建マル定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkignkdtmrtikusnmnryoage zrnkignkdtmrtikusnmnryoage}</td><td>（連携用）介護年金建マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktisyuruikgu zrnkaigonkdttktisyuruikgu}</td><td>（連携用）介護年金建トク定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikkn zrnkaigonkdttktikkn}</td><td>（連携用）介護年金建トク定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttkteinenkngk zrnkaigonkdttkteinenkngk}</td><td>（連携用）介護年金建トク定年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonenkindatetokuteis zrnkaigonenkindatetokuteis}</td><td>（連携用）介護年金建トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonenkindatetokuteip zrnkaigonenkindatetokuteip}</td><td>（連携用）介護年金建トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktisdtpdtkbn zrnkaigonkdttktisdtpdtkbn}</td><td>（連携用）介護年金建トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktimods zrnkaigonkdttktimods}</td><td>（連携用）介護年金建トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktishrkkn zrnkaigonkdttktishrkkn}</td><td>（連携用）介護年金建トク定支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktikgusdkbn zrnkaigonkdttktikgusdkbn}</td><td>（連携用）介護年金建トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonkdttktiktkbn zrnkaigonkdttktiktkbn}</td><td>（連携用）介護年金建トク定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkignkdttktikusnmnryoage zrnkignkdttktikusnmnryoage}</td><td>（連携用）介護年金建トク定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x5 zrnyobiv2x5}</td><td>（連携用）予備項目Ｖ２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigenmrtisyuruikgu zrnkaigoteigenmrtisyuruikgu}</td><td>（連携用）介護逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigenmaruteikikan zrnkaigoteigenmaruteikikan}</td><td>（連携用）介護逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotignmrtiphrkkkn zrnkaigotignmrtiphrkkkn}</td><td>（連携用）介護逓減マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigenmaruteis zrnkaigoteigenmaruteis}</td><td>（連携用）介護逓減マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigenmaruteip zrnkaigoteigenmaruteip}</td><td>（連携用）介護逓減マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtimods zrnkigtignmrtimods}</td><td>（連携用）介護逓減マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtitkjyukbn zrnkigtignmrtitkjyukbn}</td><td>（連携用）介護逓減マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtitkjyuskgnkkn zrnkigtignmrtitkjyuskgnkkn}</td><td>（連携用）介護逓減マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtitkjyurymshytn zrnkigtignmrtitkjyurymshytn}</td><td>（連携用）介護逓減マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtitkjyup zrnkigtignmrtitkjyup}</td><td>（連携用）介護逓減マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtsyrikgux1 zrnhtnknkigtignmrtsyrikgux1}</td><td>（連携用）被転換介護逓減マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtsyrikgux2 zrnhtnknkigtignmrtsyrikgux2}</td><td>（連携用）被転換介護逓減マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtsyrikgux3 zrnhtnknkigtignmrtsyrikgux3}</td><td>（連携用）被転換介護逓減マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtsyrikgux4 zrnhtnknkigtignmrtsyrikgux4}</td><td>（連携用）被転換介護逓減マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtsyrikgux5 zrnhtnknkigtignmrtsyrikgux5}</td><td>（連携用）被転換介護逓減マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtsyrikgux6 zrnhtnknkigtignmrtsyrikgux6}</td><td>（連携用）被転換介護逓減マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsurkigtignmrtipwrbkkbn zrnsurkigtignmrtipwrbkkbn}</td><td>（連携用）数理介護逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtipwrbkkbn zrnkigtignmrtipwrbkkbn}</td><td>（連携用）介護逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtitnknyugukbn zrnkigtignmrtitnknyugukbn}</td><td>（連携用）介護逓減マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotignmrtikgusdkbn zrnkaigotignmrtikgusdkbn}</td><td>（連携用）介護逓減マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtignmrtikusnmnryoage zrnkigtignmrtikusnmnryoage}</td><td>（連携用）介護逓減マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x15 zrnyobiv4x15}</td><td>（連携用）予備項目Ｖ４＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigentktisyuruikgu zrnkaigoteigentktisyuruikgu}</td><td>（連携用）介護逓減トク定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigentokuteikikan zrnkaigoteigentokuteikikan}</td><td>（連携用）介護逓減トク定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigentokuteis zrnkaigoteigentokuteis}</td><td>（連携用）介護逓減トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigentokuteip zrnkaigoteigentokuteip}</td><td>（連携用）介護逓減トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktisdtpdtkbn zrnkigtigntktisdtpdtkbn}</td><td>（連携用）介護逓減トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktimods zrnkigtigntktimods}</td><td>（連携用）介護逓減トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigotigntktikgusdkbn zrnkaigotigntktikgusdkbn}</td><td>（連携用）介護逓減トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigtigntktikusnmnryoage zrnkigtigntktikusnmnryoage}</td><td>（連携用）介護逓減トク定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x6 zrnyobiv2x6}</td><td>（連携用）予備項目Ｖ２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhikitugikaimasis zrnhikitugikaimasis}</td><td>（連携用）引継買増Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkyhtisyukykumkbn zrncbkyhtisyukykumkbn}</td><td>（連携用）ＣＢ給付対象契約有無区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntukiyucbkyhtisyus zrntukiyucbkyhtisyus}</td><td>（連携用）統計用ＣＢ給付対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbhanteituusans zrncbhanteituusans}</td><td>（連携用）ＣＢ判定通算Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntukiyusnkykcbhntis zrntukiyusnkykcbhntis}</td><td>（連携用）統計用新契約ＣＢ判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbstagekbn zrncbstagekbn}</td><td>（連携用）ＣＢステージ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyoucbhanteituusans zrntoukeiyoucbhanteituusans}</td><td>（連携用）統計用ＣＢ判定通算Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbtuusankensuu zrncbtuusankensuu}</td><td>（連携用）ＣＢ通算件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrncbhanteitaisyoutsnkensuu zrncbhanteitaisyoutsnkensuu}</td><td>（連携用）ＣＢ判定対象通算件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteisx1 zrntyokuzentuusanhanteisx1}</td><td>（連携用）直前通算判定Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzenkyuuhutaisyousx1 zrntyokuzenkyuuhutaisyousx1}</td><td>（連携用）直前給付対象Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzencbgakux1 zrntyokuzencbgakux1}</td><td>（連携用）直前ＣＢ額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteisx1 zrntyokugotuusanhanteisx1}</td><td>（連携用）直後通算判定Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyousx1 zrntyokugokyuuhutaisyousx1}</td><td>（連携用）直後給付対象Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbgakux1 zrntyokugocbgakux1}</td><td>（連携用）直後ＣＢ額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteisx2 zrntyokuzentuusanhanteisx2}</td><td>（連携用）直前通算判定Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzenkyuuhutaisyousx2 zrntyokuzenkyuuhutaisyousx2}</td><td>（連携用）直前給付対象Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzencbgakux2 zrntyokuzencbgakux2}</td><td>（連携用）直前ＣＢ額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteisx2 zrntyokugotuusanhanteisx2}</td><td>（連携用）直後通算判定Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyousx2 zrntyokugokyuuhutaisyousx2}</td><td>（連携用）直後給付対象Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbgakux2 zrntyokugocbgakux2}</td><td>（連携用）直後ＣＢ額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x2 zrnyobiv12x2}</td><td>（連携用）予備項目Ｖ１２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteisx3 zrntyokuzentuusanhanteisx3}</td><td>（連携用）直前通算判定Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzenkyuuhutaisyousx3 zrntyokuzenkyuuhutaisyousx3}</td><td>（連携用）直前給付対象Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzencbgakux3 zrntyokuzencbgakux3}</td><td>（連携用）直前ＣＢ額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteisx3 zrntyokugotuusanhanteisx3}</td><td>（連携用）直後通算判定Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyousx3 zrntyokugokyuuhutaisyousx3}</td><td>（連携用）直後給付対象Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbgakux3 zrntyokugocbgakux3}</td><td>（連携用）直後ＣＢ額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x3 zrnyobiv12x3}</td><td>（連携用）予備項目Ｖ１２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteisx4 zrntyokuzentuusanhanteisx4}</td><td>（連携用）直前通算判定Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzenkyuuhutaisyousx4 zrntyokuzenkyuuhutaisyousx4}</td><td>（連携用）直前給付対象Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzencbgakux4 zrntyokuzencbgakux4}</td><td>（連携用）直前ＣＢ額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteisx4 zrntyokugotuusanhanteisx4}</td><td>（連携用）直後通算判定Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyousx4 zrntyokugokyuuhutaisyousx4}</td><td>（連携用）直後給付対象Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbgakux4 zrntyokugocbgakux4}</td><td>（連携用）直後ＣＢ額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x4 zrnyobiv12x4}</td><td>（連携用）予備項目Ｖ１２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteisx5 zrntyokuzentuusanhanteisx5}</td><td>（連携用）直前通算判定Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzenkyuuhutaisyousx5 zrntyokuzenkyuuhutaisyousx5}</td><td>（連携用）直前給付対象Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzencbgakux5 zrntyokuzencbgakux5}</td><td>（連携用）直前ＣＢ額＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteisx5 zrntyokugotuusanhanteisx5}</td><td>（連携用）直後通算判定Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyousx5 zrntyokugokyuuhutaisyousx5}</td><td>（連携用）直後給付対象Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbgakux5 zrntyokugocbgakux5}</td><td>（連携用）直後ＣＢ額＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x5 zrnyobiv12x5}</td><td>（連携用）予備項目Ｖ１２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteisx6 zrntyokuzentuusanhanteisx6}</td><td>（連携用）直前通算判定Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzenkyuuhutaisyousx6 zrntyokuzenkyuuhutaisyousx6}</td><td>（連携用）直前給付対象Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzencbgakux6 zrntyokuzencbgakux6}</td><td>（連携用）直前ＣＢ額＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteisx6 zrntyokugotuusanhanteisx6}</td><td>（連携用）直後通算判定Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyousx6 zrntyokugokyuuhutaisyousx6}</td><td>（連携用）直後給付対象Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbgakux6 zrntyokugocbgakux6}</td><td>（連携用）直後ＣＢ額＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x6 zrnyobiv12x6}</td><td>（連携用）予備項目Ｖ１２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikyksyonox1 zrncbkikyksyonox1}</td><td>（連携用）ＣＢ既契約証券番号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykhknsyruikbnx1 zrncbkikykhknsyruikbnx1}</td><td>（連携用）ＣＢ既契約保険種類区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikeiyakukeiyakuymdx1 zrncbkikeiyakukeiyakuymdx1}</td><td>（連携用）ＣＢ既契約契約年月日＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykkyhtisyukbnx1 zrncbkikykkyhtisyukbnx1}</td><td>（連携用）ＣＢ既契約給付対象区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykhntitaisyoukbnx1 zrncbkikykhntitaisyoukbnx1}</td><td>（連携用）ＣＢ既契約判定対象区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakucbgakux1x1 zrnkikeiyakucbgakux1x1}</td><td>（連携用）既契約ＣＢ額＿１＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakucbgakux2x1 zrnkikeiyakucbgakux2x1}</td><td>（連携用）既契約ＣＢ額＿２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkikykhanteitsnsx1x1 zrncbkikykhanteitsnsx1x1}</td><td>（連携用）ＣＢ既契約判定通算Ｓ＿１＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkikykhanteitsnsx2x1 zrncbkikykhanteitsnsx2x1}</td><td>（連携用）ＣＢ既契約判定通算Ｓ＿２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x7 zrnyobiv12x7}</td><td>（連携用）予備項目Ｖ１２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikyksyonox2 zrncbkikyksyonox2}</td><td>（連携用）ＣＢ既契約証券番号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykhknsyruikbnx2 zrncbkikykhknsyruikbnx2}</td><td>（連携用）ＣＢ既契約保険種類区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikeiyakukeiyakuymdx2 zrncbkikeiyakukeiyakuymdx2}</td><td>（連携用）ＣＢ既契約契約年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykkyhtisyukbnx2 zrncbkikykkyhtisyukbnx2}</td><td>（連携用）ＣＢ既契約給付対象区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykhntitaisyoukbnx2 zrncbkikykhntitaisyoukbnx2}</td><td>（連携用）ＣＢ既契約判定対象区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakucbgakux1x2 zrnkikeiyakucbgakux1x2}</td><td>（連携用）既契約ＣＢ額＿１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakucbgakux2x2 zrnkikeiyakucbgakux2x2}</td><td>（連携用）既契約ＣＢ額＿２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkikykhanteitsnsx1x2 zrncbkikykhanteitsnsx1x2}</td><td>（連携用）ＣＢ既契約判定通算Ｓ＿１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkikykhanteitsnsx2x2 zrncbkikykhanteitsnsx2x2}</td><td>（連携用）ＣＢ既契約判定通算Ｓ＿２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x8 zrnyobiv12x8}</td><td>（連携用）予備項目Ｖ１２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikyksyonox3 zrncbkikyksyonox3}</td><td>（連携用）ＣＢ既契約証券番号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykhknsyruikbnx3 zrncbkikykhknsyruikbnx3}</td><td>（連携用）ＣＢ既契約保険種類区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikeiyakukeiyakuymdx3 zrncbkikeiyakukeiyakuymdx3}</td><td>（連携用）ＣＢ既契約契約年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykkyhtisyukbnx3 zrncbkikykkyhtisyukbnx3}</td><td>（連携用）ＣＢ既契約給付対象区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncbkikykhntitaisyoukbnx3 zrncbkikykhntitaisyoukbnx3}</td><td>（連携用）ＣＢ既契約判定対象区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakucbgakux1x3 zrnkikeiyakucbgakux1x3}</td><td>（連携用）既契約ＣＢ額＿１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakucbgakux2x3 zrnkikeiyakucbgakux2x3}</td><td>（連携用）既契約ＣＢ額＿２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkikykhanteitsnsx1x3 zrncbkikykhanteitsnsx1x3}</td><td>（連携用）ＣＢ既契約判定通算Ｓ＿１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbkikykhanteitsnsx2x3 zrncbkikykhanteitsnsx2x3}</td><td>（連携用）ＣＢ既契約判定通算Ｓ＿２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x9 zrnyobiv12x9}</td><td>（連携用）予備項目Ｖ１２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikgusdkbnx1 zrnhtnknhknsyrikgusdkbnx1}</td><td>（連携用）被転換保険種類記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikgusdkbnx1 zrnhtnknmrtikgusdkbnx1}</td><td>（連携用）被転換マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikgusdkbnx1 zrnhtnknsiznmrtikgusdkbnx1}</td><td>（連携用）被転換生存マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikgusdkbnx1 zrnhtnkntignmrtikgusdkbnx1}</td><td>（連携用）被転換逓減マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikgusdkbnx1 zrnhtnknnkmrtikgusdkbnx1}</td><td>（連携用）被転換年金マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntkstkgusdkbnx1 zrnhtnkntkstkgusdkbnx1}</td><td>（連携用）被転換特疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkgusdkbnx1 zrnhtnkndi2tkstkgusdkbnx1}</td><td>（連携用）被転換第２特疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjyustkgusdkbnx1 zrnhtnknjyustkgusdkbnx1}</td><td>（連携用）被転換重疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2jysitkgusdkbnx1 zrnhtnkndi2jysitkgusdkbnx1}</td><td>（連携用）被転換第２重疾記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtisdkbnx1 zrnhtnknkaigonkmrtisdkbnx1}</td><td>（連携用）被転換介護年金マル定世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtisdkbnx1 zrnhtnknkigtignmrtisdkbnx1}</td><td>（連携用）被転換介護逓減マル定世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrsykgusdkbnx1 zrnhtnknkaigomrsykgusdkbnx1}</td><td>（連携用）被転換介護マル終記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobiv8x2 zrnsuuriyouyobiv8x2}</td><td>（連携用）数理用予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikgusdkbnx2 zrnhtnknhknsyrikgusdkbnx2}</td><td>（連携用）被転換保険種類記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikgusdkbnx2 zrnhtnknmrtikgusdkbnx2}</td><td>（連携用）被転換マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikgusdkbnx2 zrnhtnknsiznmrtikgusdkbnx2}</td><td>（連携用）被転換生存マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikgusdkbnx2 zrnhtnkntignmrtikgusdkbnx2}</td><td>（連携用）被転換逓減マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikgusdkbnx2 zrnhtnknnkmrtikgusdkbnx2}</td><td>（連携用）被転換年金マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntkstkgusdkbnx2 zrnhtnkntkstkgusdkbnx2}</td><td>（連携用）被転換特疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkgusdkbnx2 zrnhtnkndi2tkstkgusdkbnx2}</td><td>（連携用）被転換第２特疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjyustkgusdkbnx2 zrnhtnknjyustkgusdkbnx2}</td><td>（連携用）被転換重疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2jysitkgusdkbnx2 zrnhtnkndi2jysitkgusdkbnx2}</td><td>（連携用）被転換第２重疾記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtisdkbnx2 zrnhtnknkaigonkmrtisdkbnx2}</td><td>（連携用）被転換介護年金マル定世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtisdkbnx2 zrnhtnknkigtignmrtisdkbnx2}</td><td>（連携用）被転換介護逓減マル定世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrsykgusdkbnx2 zrnhtnknkaigomrsykgusdkbnx2}</td><td>（連携用）被転換介護マル終記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x5 zrnyobiv8x5}</td><td>（連携用）予備項目Ｖ８＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikgusdkbnx3 zrnhtnknhknsyrikgusdkbnx3}</td><td>（連携用）被転換保険種類記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikgusdkbnx3 zrnhtnknmrtikgusdkbnx3}</td><td>（連携用）被転換マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikgusdkbnx3 zrnhtnknsiznmrtikgusdkbnx3}</td><td>（連携用）被転換生存マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikgusdkbnx3 zrnhtnkntignmrtikgusdkbnx3}</td><td>（連携用）被転換逓減マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikgusdkbnx3 zrnhtnknnkmrtikgusdkbnx3}</td><td>（連携用）被転換年金マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntkstkgusdkbnx3 zrnhtnkntkstkgusdkbnx3}</td><td>（連携用）被転換特疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkgusdkbnx3 zrnhtnkndi2tkstkgusdkbnx3}</td><td>（連携用）被転換第２特疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjyustkgusdkbnx3 zrnhtnknjyustkgusdkbnx3}</td><td>（連携用）被転換重疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2jysitkgusdkbnx3 zrnhtnkndi2jysitkgusdkbnx3}</td><td>（連携用）被転換第２重疾記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtisdkbnx3 zrnhtnknkaigonkmrtisdkbnx3}</td><td>（連携用）被転換介護年金マル定世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtisdkbnx3 zrnhtnknkigtignmrtisdkbnx3}</td><td>（連携用）被転換介護逓減マル定世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrsykgusdkbnx3 zrnhtnknkaigomrsykgusdkbnx3}</td><td>（連携用）被転換介護マル終記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x6 zrnyobiv8x6}</td><td>（連携用）予備項目Ｖ８＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikgusdkbnx4 zrnhtnknhknsyrikgusdkbnx4}</td><td>（連携用）被転換保険種類記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikgusdkbnx4 zrnhtnknmrtikgusdkbnx4}</td><td>（連携用）被転換マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikgusdkbnx4 zrnhtnknsiznmrtikgusdkbnx4}</td><td>（連携用）被転換生存マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikgusdkbnx4 zrnhtnkntignmrtikgusdkbnx4}</td><td>（連携用）被転換逓減マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikgusdkbnx4 zrnhtnknnkmrtikgusdkbnx4}</td><td>（連携用）被転換年金マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntkstkgusdkbnx4 zrnhtnkntkstkgusdkbnx4}</td><td>（連携用）被転換特疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkgusdkbnx4 zrnhtnkndi2tkstkgusdkbnx4}</td><td>（連携用）被転換第２特疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjyustkgusdkbnx4 zrnhtnknjyustkgusdkbnx4}</td><td>（連携用）被転換重疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2jysitkgusdkbnx4 zrnhtnkndi2jysitkgusdkbnx4}</td><td>（連携用）被転換第２重疾記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtisdkbnx4 zrnhtnknkaigonkmrtisdkbnx4}</td><td>（連携用）被転換介護年金マル定世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtisdkbnx4 zrnhtnknkigtignmrtisdkbnx4}</td><td>（連携用）被転換介護逓減マル定世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrsykgusdkbnx4 zrnhtnknkaigomrsykgusdkbnx4}</td><td>（連携用）被転換介護マル終記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x7 zrnyobiv8x7}</td><td>（連携用）予備項目Ｖ８＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikgusdkbnx5 zrnhtnknhknsyrikgusdkbnx5}</td><td>（連携用）被転換保険種類記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikgusdkbnx5 zrnhtnknmrtikgusdkbnx5}</td><td>（連携用）被転換マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikgusdkbnx5 zrnhtnknsiznmrtikgusdkbnx5}</td><td>（連携用）被転換生存マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikgusdkbnx5 zrnhtnkntignmrtikgusdkbnx5}</td><td>（連携用）被転換逓減マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikgusdkbnx5 zrnhtnknnkmrtikgusdkbnx5}</td><td>（連携用）被転換年金マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntkstkgusdkbnx5 zrnhtnkntkstkgusdkbnx5}</td><td>（連携用）被転換特疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkgusdkbnx5 zrnhtnkndi2tkstkgusdkbnx5}</td><td>（連携用）被転換第２特疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjyustkgusdkbnx5 zrnhtnknjyustkgusdkbnx5}</td><td>（連携用）被転換重疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2jysitkgusdkbnx5 zrnhtnkndi2jysitkgusdkbnx5}</td><td>（連携用）被転換第２重疾記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtisdkbnx5 zrnhtnknkaigonkmrtisdkbnx5}</td><td>（連携用）被転換介護年金マル定世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtisdkbnx5 zrnhtnknkigtignmrtisdkbnx5}</td><td>（連携用）被転換介護逓減マル定世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrsykgusdkbnx5 zrnhtnknkaigomrsykgusdkbnx5}</td><td>（連携用）被転換介護マル終記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x8 zrnyobiv8x8}</td><td>（連携用）予備項目Ｖ８＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknhknsyrikgusdkbnx6 zrnhtnknhknsyrikgusdkbnx6}</td><td>（連携用）被転換保険種類記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknmrtikgusdkbnx6 zrnhtnknmrtikgusdkbnx6}</td><td>（連携用）被転換マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiznmrtikgusdkbnx6 zrnhtnknsiznmrtikgusdkbnx6}</td><td>（連携用）被転換生存マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntignmrtikgusdkbnx6 zrnhtnkntignmrtikgusdkbnx6}</td><td>（連携用）被転換逓減マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknnkmrtikgusdkbnx6 zrnhtnknnkmrtikgusdkbnx6}</td><td>（連携用）被転換年金マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntkstkgusdkbnx6 zrnhtnkntkstkgusdkbnx6}</td><td>（連携用）被転換特疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2tkstkgusdkbnx6 zrnhtnkndi2tkstkgusdkbnx6}</td><td>（連携用）被転換第２特疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknjyustkgusdkbnx6 zrnhtnknjyustkgusdkbnx6}</td><td>（連携用）被転換重疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkndi2jysitkgusdkbnx6 zrnhtnkndi2jysitkgusdkbnx6}</td><td>（連携用）被転換第２重疾記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonkmrtisdkbnx6 zrnhtnknkaigonkmrtisdkbnx6}</td><td>（連携用）被転換介護年金マル定世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigtignmrtisdkbnx6 zrnhtnknkigtignmrtisdkbnx6}</td><td>（連携用）被転換介護逓減マル定世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrsykgusdkbnx6 zrnhtnknkaigomrsykgusdkbnx6}</td><td>（連携用）被転換介護マル終記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x9 zrnyobiv8x9}</td><td>（連携用）予備項目Ｖ８＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkyksyuruikgu zrnkaigonktkyksyuruikgu}</td><td>（連携用）介護年金特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykkgusdkbn zrnkaigonktkykkgusdkbn}</td><td>（連携用）介護年金特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonenkintokuyakukikan zrnkaigonenkintokuyakukikan}</td><td>（連携用）介護年金特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykphrkkkn zrnkaigonktkykphrkkkn}</td><td>（連携用）介護年金特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkyknkgk zrnkaigonktkyknkgk}</td><td>（連携用）介護年金特約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonenkintokuyakus zrnkaigonenkintokuyakus}</td><td>（連携用）介護年金特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonenkintokuyakup zrnkaigonenkintokuyakup}</td><td>（連携用）介護年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykmods zrnkaigonktkykmods}</td><td>（連携用）介護年金特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkyknkshrkkn zrnkaigonktkyknkshrkkn}</td><td>（連携用）介護年金特約年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgux1 zrnhtnknkaigonktkykkgux1}</td><td>（連携用）被転換介護年金特約記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgux2 zrnhtnknkaigonktkykkgux2}</td><td>（連携用）被転換介護年金特約記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgux3 zrnhtnknkaigonktkykkgux3}</td><td>（連携用）被転換介護年金特約記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgux4 zrnhtnknkaigonktkykkgux4}</td><td>（連携用）被転換介護年金特約記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgux5 zrnhtnknkaigonktkykkgux5}</td><td>（連携用）被転換介護年金特約記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkykkgux6 zrnhtnknkaigonktkykkgux6}</td><td>（連携用）被転換介護年金特約記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkyksdkbnx1 zrnhtnknkaigonktkyksdkbnx1}</td><td>（連携用）被転換介護年金特約世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkyksdkbnx2 zrnhtnknkaigonktkyksdkbnx2}</td><td>（連携用）被転換介護年金特約世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkyksdkbnx3 zrnhtnknkaigonktkyksdkbnx3}</td><td>（連携用）被転換介護年金特約世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkyksdkbnx4 zrnhtnknkaigonktkyksdkbnx4}</td><td>（連携用）被転換介護年金特約世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkyksdkbnx5 zrnhtnknkaigonktkyksdkbnx5}</td><td>（連携用）被転換介護年金特約世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigonktkyksdkbnx6 zrnhtnknkaigonktkyksdkbnx6}</td><td>（連携用）被転換介護年金特約世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsurikaigonktkykpwrbkkbn zrnsurikaigonktkykpwrbkkbn}</td><td>（連携用）数理介護年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykpwrbkkbn zrnkaigonktkykpwrbkkbn}</td><td>（連携用）介護年金特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkyktnknyugukbn zrnkaigonktkyktnknyugukbn}</td><td>（連携用）介護年金特約転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkyksyrikgu zrnitjbrkignktkyksyrikgu}</td><td>（連携用）一時払介護年金特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkyksdkbn zrnitjbrkignktkyksdkbn}</td><td>（連携用）一時払介護年金特約世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykkkn zrnitjbrkignktkykkkn}</td><td>（連携用）一時払介護年金特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkyknnkngk zrnitjbrkignktkyknnkngk}</td><td>（連携用）一時払介護年金特約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkyks zrnitjbrkignktkyks}</td><td>（連携用）一時払介護年金特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykp zrnitjbrkignktkykp}</td><td>（連携用）一時払介護年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykspdtkbn zrnitjbrkignktkykspdtkbn}</td><td>（連携用）一時払介護年金特約ＳＰ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykmods zrnitjbrkignktkykmods}</td><td>（連携用）一時払介護年金特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitjbrkignktkykshrkkn zrnitjbrkignktkykshrkkn}</td><td>（連携用）一時払介護年金特約支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x10 zrnyobiv8x10}</td><td>（連携用）予備項目Ｖ８＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuinnissuugatakbn zrnnyuuinnissuugatakbn}</td><td>（連携用）入院日数型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankeikanensuu zrntenkankeikanensuu}</td><td>（連携用）転換経過年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkyksyuruikgu zrnsykkyuhtkyksyuruikgu}</td><td>（連携用）初期給付特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokikyuuhutokuyakukikan zrnsyokikyuuhutokuyakukikan}</td><td>（連携用）初期給付特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokikyuuhutkykphrkkkn zrnsyokikyuuhutkykphrkkkn}</td><td>（連携用）初期給付特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykntgk zrnsykkyuhtkykntgk}</td><td>（連携用）初期給付特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyokikyuuhutokuyakup zrnsyokikyuuhutokuyakup}</td><td>（連携用）初期給付特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykgtkbn zrnsykkyuhtkykgtkbn}</td><td>（連携用）初期給付特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokikyuuhutkykkgusdkbn zrnsyokikyuuhutkykkgusdkbn}</td><td>（連携用）初期給付特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkjyuryumshyutn zrnsykkyuhtkjyuryumshyutn}</td><td>（連携用）初期給付特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyokikyuuhutokujyoup zrnsyokikyuuhutokujyoup}</td><td>（連携用）初期給付特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtktbicdx1 zrnsykkyuhtktbicdx1}</td><td>（連携用）初期給付特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhhtnpkknx1 zrnsykkyuhhtnpkknx1}</td><td>（連携用）初期給付不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtktbicdx2 zrnsykkyuhtktbicdx2}</td><td>（連携用）初期給付特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhhtnpkknx2 zrnsykkyuhhtnpkknx2}</td><td>（連携用）初期給付不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykkyuhtkykpwrbkkbn zrnsykkyuhtkykpwrbkkbn}</td><td>（連携用）初期給付特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x6 zrnyobiv3x6}</td><td>（連携用）予備項目Ｖ３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkyksyrikgu zrndi2sykkyuhtkyksyrikgu}</td><td>（連携用）第２初期給付特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkkn zrndi2sykkyuhtkykkkn}</td><td>（連携用）第２初期給付特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykphrkkkn zrndi2sykkyuhtkykphrkkkn}</td><td>（連携用）第２初期給付特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykntgk zrndi2sykkyuhtkykntgk}</td><td>（連携用）第２初期給付特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2syokikyuuhutokuyakup zrndai2syokikyuuhutokuyakup}</td><td>（連携用）第２初期給付特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykgtkbn zrndi2sykkyuhtkykgtkbn}</td><td>（連携用）第２初期給付特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykkgusdkbn zrndi2sykkyuhtkykkgusdkbn}</td><td>（連携用）第２初期給付特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkjyuryumshytn zrndi2sykkyuhtkjyuryumshytn}</td><td>（連携用）第２初期給付特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2syokikyuuhutokujyoup zrndai2syokikyuuhutokujyoup}</td><td>（連携用）第２初期給付特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtktbicdx1 zrndi2sykkyuhtktbicdx1}</td><td>（連携用）第２初期給付特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhhtnpkknx1 zrndi2sykkyuhhtnpkknx1}</td><td>（連携用）第２初期給付不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtktbicdx2 zrndi2sykkyuhtktbicdx2}</td><td>（連携用）第２初期給付特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhhtnpkknx2 zrndi2sykkyuhhtnpkknx2}</td><td>（連携用）第２初期給付不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sykkyuhtkykpwrbkkbn zrndi2sykkyuhtkykpwrbkkbn}</td><td>（連携用）第２初期給付特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x7 zrnyobiv3x7}</td><td>（連携用）予備項目Ｖ３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndfitijibaraip zrndfitijibaraip}</td><td>（連携用）ＤＦ一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndfgoukeitenkankakaku zrndfgoukeitenkankakaku}</td><td>（連携用）ＤＦ合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndfuktkjivbbntnknkakaku zrndfuktkjivbbntnknkakaku}</td><td>（連携用）ＤＦ受付時Ｖ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndfuktkjipbbntnknkakaku zrndfuktkjipbbntnknkakaku}</td><td>（連携用）ＤＦ受付時Ｐ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndftnkngvbbntnknkakaku zrndftnkngvbbntnknkakaku}</td><td>（連携用）ＤＦ転換後Ｖ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndftnkngpbbntnknkakaku zrndftnkngpbbntnknkakaku}</td><td>（連携用）ＤＦ転換後Ｐ部分転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv18x2 zrnyobiv18x2}</td><td>（連携用）予備項目Ｖ１８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomrtisyuruikgu zrnkaigomrtisyuruikgu}</td><td>（連携用）介護マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikigousdkbn zrnkaigomaruteikigousdkbn}</td><td>（連携用）介護マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteikikan zrnkaigomaruteikikan}</td><td>（連携用）介護マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteiphrkkkn zrnkaigomaruteiphrkkkn}</td><td>（連携用）介護マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteis zrnkaigomaruteis}</td><td>（連携用）介護マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteip zrnkaigomaruteip}</td><td>（連携用）介護マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteisyuuseis zrnkaigomaruteisyuuseis}</td><td>（連携用）介護マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteimodsskgnhyj zrnkaigomaruteimodsskgnhyj}</td><td>（連携用）介護マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtitkjyukbn zrnkigmrtitkjyukbn}</td><td>（連携用）介護マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtitkjyuskgnkkn zrnkigmrtitkjyuskgnkkn}</td><td>（連携用）介護マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtitkjyuryumshyutn zrnkigmrtitkjyuryumshyutn}</td><td>（連携用）介護マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkaigomaruteitokujyoup zrnkaigomaruteitokujyoup}</td><td>（連携用）介護マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtisyrikgux1 zrnhtnknkigmrtisyrikgux1}</td><td>（連携用）被転換介護マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtisyrikgux2 zrnhtnknkigmrtisyrikgux2}</td><td>（連携用）被転換介護マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtisyrikgux3 zrnhtnknkigmrtisyrikgux3}</td><td>（連携用）被転換介護マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtisyrikgux4 zrnhtnknkigmrtisyrikgux4}</td><td>（連携用）被転換介護マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtisyrikgux5 zrnhtnknkigmrtisyrikgux5}</td><td>（連携用）被転換介護マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkigmrtisyrikgux6 zrnhtnknkigmrtisyrikgux6}</td><td>（連携用）被転換介護マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrtisdkbnx1 zrnhtnknkaigomrtisdkbnx1}</td><td>（連携用）被転換介護マル定世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrtisdkbnx2 zrnhtnknkaigomrtisdkbnx2}</td><td>（連携用）被転換介護マル定世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrtisdkbnx3 zrnhtnknkaigomrtisdkbnx3}</td><td>（連携用）被転換介護マル定世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrtisdkbnx4 zrnhtnknkaigomrtisdkbnx4}</td><td>（連携用）被転換介護マル定世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrtisdkbnx5 zrnhtnknkaigomrtisdkbnx5}</td><td>（連携用）被転換介護マル定世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkaigomrtisdkbnx6 zrnhtnknkaigomrtisdkbnx6}</td><td>（連携用）被転換介護マル定世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsurkigmrtipwrbkkbn zrnsurkigmrtipwrbkkbn}</td><td>（連携用）数理介護マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtipwrbkkbn zrnkigmrtipwrbkkbn}</td><td>（連携用）介護マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtitnknyugukbn zrnkigmrtitnknyugukbn}</td><td>（連携用）介護マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtikusnmnryoage zrnkigmrtikusnmnryoage}</td><td>（連携用）介護マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x7 zrnyobiv2x7}</td><td>（連携用）予備項目Ｖ２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteisyuruikigou zrnkaigotokuteisyuruikigou}</td><td>（連携用）介護トク定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotktikgusdkbn zrnkaigotktikgusdkbn}</td><td>（連携用）介護トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteikikan zrnkaigotokuteikikan}</td><td>（連携用）介護トク定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteis zrnkaigotokuteis}</td><td>（連携用）介護トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteip zrnkaigotokuteip}</td><td>（連携用）介護トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkigtktisdtpdtkbn zrnkigtktisdtpdtkbn}</td><td>（連携用）介護トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotokuteisyuuseis zrnkaigotokuteisyuuseis}</td><td>（連携用）介護トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigotktimodsskgnhyj zrnkaigotktimodsskgnhyj}</td><td>（連携用）介護トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigotktikusnmnryoage zrnkaigotktikusnmnryoage}</td><td>（連携用）介護トク定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x11 zrnyobiv8x11}</td><td>（連携用）予備項目Ｖ８＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokuiryoutkyksyuruikgu zrnkazokuiryoutkyksyuruikgu}</td><td>（連携用）家族医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokuiryoutokuyakukikan zrnkazokuiryoutokuyakukikan}</td><td>（連携用）家族医療特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokuiryoutkykphrkkkn zrnkazokuiryoutkykphrkkkn}</td><td>（連携用）家族医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykntgk zrnkzkiryoutkykntgk}</td><td>（連携用）家族医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokuiryoutokuyakup zrnkazokuiryoutokuyakup}</td><td>（連携用）家族医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutkykgtkbn zrnkzkiryoutkykgtkbn}</td><td>（連携用）家族医療特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokuiryoutkykkgusdkbn zrnkazokuiryoutkykkgusdkbn}</td><td>（連携用）家族医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutktbicdx1 zrnkzkiryoutktbicdx1}</td><td>（連携用）家族医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryouhtnpkknx1 zrnkzkiryouhtnpkknx1}</td><td>（連携用）家族医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryoutktbicdx2 zrnkzkiryoutktbicdx2}</td><td>（連携用）家族医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkiryouhtnpkknx2 zrnkzkiryouhtnpkknx2}</td><td>（連携用）家族医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x10 zrnyobiv12x10}</td><td>（連携用）予備項目Ｖ１２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Skeiksnbsgetujisr2Rn
 * @see     PKZT_Skeiksnbsgetujisr2Rn
 * @see     QZT_Skeiksnbsgetujisr2Rn
 * @see     GenQZT_Skeiksnbsgetujisr2Rn
 */
@MappedSuperclass
@Table(name=GenZT_Skeiksnbsgetujisr2Rn.TABLE_NAME)
@IdClass(value=PKZT_Skeiksnbsgetujisr2Rn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Skeiksnbsgetujisr2Rn extends AbstractExDBEntityForZDB<ZT_Skeiksnbsgetujisr2Rn, PKZT_Skeiksnbsgetujisr2Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Skeiksnbsgetujisr2Rn";
    public static final String ZRNKTGYSYRYMD            = "zrnktgysyrymd";
    public static final String ZRNKTGYSYONO             = "zrnktgysyono";
    public static final String ZRNKTGYFILERENNO         = "zrnktgyfilerenno";
    public static final String ZRNSITEIDAIRININKBN      = "zrnsiteidairininkbn";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNSRKYKDRKBN            = "zrnsrkykdrkbn";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNYOBIV6X3              = "zrnyobiv6x3";
    public static final String ZRNLIVINGNEEDSTKYKARIHYJ = "zrnlivingneedstkykarihyj";
    public static final String ZRNYOBIV4X12             = "zrnyobiv4x12";
    public static final String ZRNGANSUPPORTTKYKARIHYJ  = "zrngansupporttkykarihyj";
    public static final String ZRNYOBIV4X13             = "zrnyobiv4x13";
    public static final String ZRNTUUINTOKUYAKUSYURUIKIGOU = "zrntuuintokuyakusyuruikigou";
    public static final String ZRNTUUINTOKUYAKUKIKAN    = "zrntuuintokuyakukikan";
    public static final String ZRNTUINTKYKPHRKKKN       = "zrntuintkykphrkkkn";
    public static final String ZRNTUUINTOKUYAKUNITIGAKU = "zrntuuintokuyakunitigaku";
    public static final String ZRNTUUINTOKUYAKUP        = "zrntuuintokuyakup";
    public static final String ZRNTUUINTOKUYAKUGATAKBN  = "zrntuuintokuyakugatakbn";
    public static final String ZRNTUINTKJYURYUMSHYUTN   = "zrntuintkjyuryumshyutn";
    public static final String ZRNTUUINTOKUJYOUP        = "zrntuuintokujyoup";
    public static final String ZRNTUUINTOKUTEIBUICDX1   = "zrntuuintokuteibuicdx1";
    public static final String ZRNTUUINHUTANPOKIKANX1   = "zrntuuinhutanpokikanx1";
    public static final String ZRNTUUINTOKUTEIBUICDX2   = "zrntuuintokuteibuicdx2";
    public static final String ZRNTUUINHUTANPOKIKANX2   = "zrntuuinhutanpokikanx2";
    public static final String ZRNTUINTKYKKGUSDKBN      = "zrntuintkykkgusdkbn";
    public static final String ZRNTUINTKYKPWRBKKBN      = "zrntuintkykpwrbkkbn";
    public static final String ZRNYOBIV3X4              = "zrnyobiv3x4";
    public static final String ZRNDI2TUINTKYKSYRIKGU    = "zrndi2tuintkyksyrikgu";
    public static final String ZRNDAI2TUUINTOKUYAKUKIKAN = "zrndai2tuuintokuyakukikan";
    public static final String ZRNDAI2TUINTKYKPHRKKKN   = "zrndai2tuintkykphrkkkn";
    public static final String ZRNDAI2TUUINTOKUYAKUNTGK = "zrndai2tuuintokuyakuntgk";
    public static final String ZRNDAI2TUUINTOKUYAKUP    = "zrndai2tuuintokuyakup";
    public static final String ZRNDAI2TUUINTOKUYAKUGATAKBN = "zrndai2tuuintokuyakugatakbn";
    public static final String ZRNDI2TUINTKJYURYUMSHYUTN = "zrndi2tuintkjyuryumshyutn";
    public static final String ZRNDAI2TUUINTOKUJYOUP    = "zrndai2tuuintokujyoup";
    public static final String ZRNDAI2TUUINTOKUTEIBUICDX1 = "zrndai2tuuintokuteibuicdx1";
    public static final String ZRNDAI2TUUINHUTANPOKIKANX1 = "zrndai2tuuinhutanpokikanx1";
    public static final String ZRNDAI2TUUINTOKUTEIBUICDX2 = "zrndai2tuuintokuteibuicdx2";
    public static final String ZRNDAI2TUUINHUTANPOKIKANX2 = "zrndai2tuuinhutanpokikanx2";
    public static final String ZRNDI2TUINTKYKKGUSDKBN   = "zrndi2tuintkykkgusdkbn";
    public static final String ZRNDI2TUINTKYKPWRBKKBN   = "zrndi2tuintkykpwrbkkbn";
    public static final String ZRNYOBIV3X5              = "zrnyobiv3x5";
    public static final String ZRNKANGOTOKUYAKUSYURUIKIGOU = "zrnkangotokuyakusyuruikigou";
    public static final String ZRNKANGOTOKUYAKUKIKAN    = "zrnkangotokuyakukikan";
    public static final String ZRNKANGOTKYKPHRKKKN      = "zrnkangotkykphrkkkn";
    public static final String ZRNKANGOTOKUYAKUNITIGAKU = "zrnkangotokuyakunitigaku";
    public static final String ZRNKANGOTOKUYAKUP        = "zrnkangotokuyakup";
    public static final String ZRNKANGOTOKUYAKUGATAKBN  = "zrnkangotokuyakugatakbn";
    public static final String ZRNKNGTKJYURYUMSHYUTN    = "zrnkngtkjyuryumshyutn";
    public static final String ZRNKANGOTOKUJYOUP        = "zrnkangotokujyoup";
    public static final String ZRNKANGOTOKUTEIBUICDX1   = "zrnkangotokuteibuicdx1";
    public static final String ZRNKANGOHUTANPOKIKANX1   = "zrnkangohutanpokikanx1";
    public static final String ZRNKANGOTOKUTEIBUICDX2   = "zrnkangotokuteibuicdx2";
    public static final String ZRNKANGOHUTANPOKIKANX2   = "zrnkangohutanpokikanx2";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNDI2KNGTKYKSYRIKGU     = "zrndi2kngtkyksyrikgu";
    public static final String ZRNDAI2KANGOTOKUYAKUKIKAN = "zrndai2kangotokuyakukikan";
    public static final String ZRNDAI2KNGTKYKPHRKKKN    = "zrndai2kngtkykphrkkkn";
    public static final String ZRNDAI2KANGOTOKUYAKUNTGK = "zrndai2kangotokuyakuntgk";
    public static final String ZRNDAI2KANGOTOKUYAKUP    = "zrndai2kangotokuyakup";
    public static final String ZRNDAI2KANGOTOKUYAKUGATAKBN = "zrndai2kangotokuyakugatakbn";
    public static final String ZRNDI2KNGTKJYURYUMSHYUTN = "zrndi2kngtkjyuryumshyutn";
    public static final String ZRNDAI2KANGOTOKUJYOUP    = "zrndai2kangotokujyoup";
    public static final String ZRNDAI2KANGOTOKUTEIBUICDX1 = "zrndai2kangotokuteibuicdx1";
    public static final String ZRNDAI2KANGOHUTANPOKIKANX1 = "zrndai2kangohutanpokikanx1";
    public static final String ZRNDAI2KANGOTOKUTEIBUICDX2 = "zrndai2kangotokuteibuicdx2";
    public static final String ZRNDAI2KANGOHUTANPOKIKANX2 = "zrndai2kangohutanpokikanx2";
    public static final String ZRNYOBIV6X2              = "zrnyobiv6x2";
    public static final String ZRNJYSISPPITKYKSYURUIKGU = "zrnjysisppitkyksyuruikgu";
    public static final String ZRNJYSISPPITKYKKKN       = "zrnjysisppitkykkkn";
    public static final String ZRNJYSISPPITKYKPHRKKKN   = "zrnjysisppitkykphrkkkn";
    public static final String ZRNJYSISPPITKYKNTGK      = "zrnjysisppitkykntgk";
    public static final String ZRNJYOSEISIPPEITOKUYAKUP = "zrnjyoseisippeitokuyakup";
    public static final String ZRNJYSISPPITKJYURYUMSHYUTN = "zrnjysisppitkjyuryumshyutn";
    public static final String ZRNJYOSEISIPPEITOKUJYOUP = "zrnjyoseisippeitokujyoup";
    public static final String ZRNJYSISPPITKTBICDX1     = "zrnjysisppitktbicdx1";
    public static final String ZRNJYSISPPIHTNPKKNX1     = "zrnjysisppihtnpkknx1";
    public static final String ZRNJYSISPPITKTBICDX2     = "zrnjysisppitktbicdx2";
    public static final String ZRNJYSISPPIHTNPKKNX2     = "zrnjysisppihtnpkknx2";
    public static final String ZRNJYSISPPITKYKKGUSDKBN  = "zrnjysisppitkykkgusdkbn";
    public static final String ZRNJYSISPPITKYKPWRBKKBN  = "zrnjysisppitkykpwrbkkbn";
    public static final String ZRNJYSISPPITKYKKUSNMNRYOAGE = "zrnjysisppitkykkusnmnryoage";
    public static final String ZRNYOBIV2X2              = "zrnyobiv2x2";
    public static final String ZRNDI2JYSISPPITKYKSYRIKGU = "zrndi2jysisppitkyksyrikgu";
    public static final String ZRNDI2JYSISPPITKYKKKN    = "zrndi2jysisppitkykkkn";
    public static final String ZRNDI2JYSISPPITKYKPHRKKKN = "zrndi2jysisppitkykphrkkkn";
    public static final String ZRNDI2JYSISPPITKYKNTGK   = "zrndi2jysisppitkykntgk";
    public static final String ZRNDI2JYSISPPITKYKP      = "zrndi2jysisppitkykp";
    public static final String ZRNDI2JYSISPPITKJYURYMSHYTN = "zrndi2jysisppitkjyurymshytn";
    public static final String ZRNDI2JYSISPPITKJYUP     = "zrndi2jysisppitkjyup";
    public static final String ZRNDI2JYSISPPITKTBICDX1  = "zrndi2jysisppitktbicdx1";
    public static final String ZRNDI2JYSISPPIHTNPKKNX1  = "zrndi2jysisppihtnpkknx1";
    public static final String ZRNDI2JYSISPPITKTBICDX2  = "zrndi2jysisppitktbicdx2";
    public static final String ZRNDI2JYSISPPIHTNPKKNX2  = "zrndi2jysisppihtnpkknx2";
    public static final String ZRNDI2JYSISPPITKYKKGUSDKBN = "zrndi2jysisppitkykkgusdkbn";
    public static final String ZRNDI2JYSISPPITKYKPWRBKKBN = "zrndi2jysisppitkykpwrbkkbn";
    public static final String ZRNYOBIV4X14             = "zrnyobiv4x14";
    public static final String ZRNWINNINGLIFEHYOUJI     = "zrnwinninglifehyouji";
    public static final String ZRNSTYOUIKUSIKINUKTRININKBN = "zrnstyouikusikinuktrininkbn";
    public static final String ZRNJYUDTHUMEHARAITKYKARIHYJ = "zrnjyudthumeharaitkykarihyj";
    public static final String ZRNSINKENKOUSEIKATUPACKHYJ = "zrnsinkenkouseikatupackhyj";
    public static final String ZRNSYUKEIYAKUPWARIBIKIKBN = "zrnsyukeiyakupwaribikikbn";
    public static final String ZRNSYKYKTNKNYUGUKBN      = "zrnsykyktnknyugukbn";
    public static final String ZRNMOSJIHONNINKKNNKBN    = "zrnmosjihonninkknnkbn";
    public static final String ZRNKITUENHONSUU          = "zrnkituenhonsuu";
    public static final String ZRNKOUSINMAETENKANNENSUUKBN = "zrnkousinmaetenkannensuukbn";
    public static final String ZRNMANKIMAETENKANNENSUUKBN = "zrnmankimaetenkannensuukbn";
    public static final String ZRNSEIKITENKANHYOUJI     = "zrnseikitenkanhyouji";
    public static final String ZRNGENGAKUTENKANKYKHYJ   = "zrngengakutenkankykhyj";
    public static final String ZRNYOBIV2X3              = "zrnyobiv2x3";
    public static final String ZRNKOUSIN3NENMAETNKNHYJ  = "zrnkousin3nenmaetnknhyj";
    public static final String ZRNDUGKTNKNSNTKHUHUKBN   = "zrndugktnknsntkhuhukbn";
    public static final String ZRNTNKNSNSTKBTTRTKKBN    = "zrntnknsnstkbttrtkkbn";
    public static final String ZRNHTNKNSIGINYUINTKYKGKNTGK = "zrnhtnknsiginyuintkykgkntgk";
    public static final String ZRNHTNKNSIGINYUINTKYKKYKYMD = "zrnhtnknsiginyuintkykkykymd";
    public static final String ZRNHTNKNSIGINYUINTKYKSNSKBN = "zrnhtnknsiginyuintkyksnskbn";
    public static final String ZRNHTNKNSPPINYUINTKYKGKNTGK = "zrnhtnknsppinyuintkykgkntgk";
    public static final String ZRNHTNKNSPPINYUINTKYKKYKYMD = "zrnhtnknsppinyuintkykkykymd";
    public static final String ZRNHTNKNSPPINYUINTKYKSNSKBN = "zrnhtnknsppinyuintkyksnskbn";
    public static final String ZRNHTNKNSIJNBYUTKYKGUKINTGK = "zrnhtnknsijnbyutkykgukintgk";
    public static final String ZRNHTNKNSIJNBYUTKYKKYKYMD = "zrnhtnknsijnbyutkykkykymd";
    public static final String ZRNHTNKNSIJNBYUTKYKSNSKBN = "zrnhtnknsijnbyutkyksnskbn";
    public static final String ZRNHTNKNJYSISPPITKYKGKINTGK = "zrnhtnknjysisppitkykgkintgk";
    public static final String ZRNHTNKNJYSISPPITKYKKYKYMD = "zrnhtnknjysisppitkykkykymd";
    public static final String ZRNHTNKNJYSISPPITKYKSNSKBN = "zrnhtnknjysisppitkyksnskbn";
    public static final String ZRNSITEIZUKIPWARIMASIHYOUJI = "zrnsiteizukipwarimasihyouji";
    public static final String ZRNPWARIMASISITEIM1      = "zrnpwarimasisiteim1";
    public static final String ZRNPWARIMASISITEIM2      = "zrnpwarimasisiteim2";
    public static final String ZRNSITEIMSYKYKPBAIRITU   = "zrnsiteimsykykpbairitu";
    public static final String ZRNSITEIZUKISYUKEIYAKUP  = "zrnsiteizukisyukeiyakup";
    public static final String ZRNTUUJYOUTUKIHARAIKOMIP = "zrntuujyoutukiharaikomip";
    public static final String ZRNSITEIZUKIHARAIKOMIP   = "zrnsiteizukiharaikomip";
    public static final String ZRNMARUTEIKISITEIZUKIP   = "zrnmaruteikisiteizukip";
    public static final String ZRNSEIZONMARUTEISITEIMP  = "zrnseizonmaruteisiteimp";
    public static final String ZRNMARUTEIPSITEIBAIRITU  = "zrnmaruteipsiteibairitu";
    public static final String ZRNSEIZONMARUTEIPSTBAIRITU = "zrnseizonmaruteipstbairitu";
    public static final String ZRNNKDTMRTISYURUIKGU     = "zrnnkdtmrtisyuruikgu";
    public static final String ZRNNENKINDATEMARUTEIKIKAN = "zrnnenkindatemaruteikikan";
    public static final String ZRNNKDATEMARUTEIPHRKKKN  = "zrnnkdatemaruteiphrkkkn";
    public static final String ZRNNKDATEMARUTEINENKINNENGK = "zrnnkdatemaruteinenkinnengk";
    public static final String ZRNNENKINDATEMARUTEIS    = "zrnnenkindatemaruteis";
    public static final String ZRNNENKINDATEMARUTEIP    = "zrnnenkindatemaruteip";
    public static final String ZRNNKDATEMARUTEIMODS     = "zrnnkdatemaruteimods";
    public static final String ZRNNKDTMRTIMODSSKGNHYJ   = "zrnnkdtmrtimodsskgnhyj";
    public static final String ZRNNKDATEMARUTEITKJYOUKBN = "zrnnkdatemaruteitkjyoukbn";
    public static final String ZRNNKDTMRTITKJYOUSKGNKKN = "zrnnkdtmrtitkjyouskgnkkn";
    public static final String ZRNNKDTMRTITKJYOURYUMSHYTN = "zrnnkdtmrtitkjyouryumshytn";
    public static final String ZRNNKDATEMARUTEITKJYOUP  = "zrnnkdatemaruteitkjyoup";
    public static final String ZRNHTNKNNKDTMRTISYURUIKGUX1 = "zrnhtnknnkdtmrtisyuruikgux1";
    public static final String ZRNHTNKNNKDTMRTISYURUIKGUX2 = "zrnhtnknnkdtmrtisyuruikgux2";
    public static final String ZRNHTNKNNKDTMRTISYURUIKGUX3 = "zrnhtnknnkdtmrtisyuruikgux3";
    public static final String ZRNHTNKNNKDTMRTISYURUIKGUX4 = "zrnhtnknnkdtmrtisyuruikgux4";
    public static final String ZRNHTNKNNKDTMRTISYURUIKGUX5 = "zrnhtnknnkdtmrtisyuruikgux5";
    public static final String ZRNHTNKNNKDTMRTISYURUIKGUX6 = "zrnhtnknnkdtmrtisyuruikgux6";
    public static final String ZRNNKDATEMARUTEISHRKKN   = "zrnnkdatemaruteishrkkn";
    public static final String ZRNSURIYOUNKDTMRTIPWRBKKBN = "zrnsuriyounkdtmrtipwrbkkbn";
    public static final String ZRNNKDATEMARUTEIPWRBKKBN = "zrnnkdatemaruteipwrbkkbn";
    public static final String ZRNHTNKNKYKSITEIMHYJX1   = "zrnhtnknkyksiteimhyjx1";
    public static final String ZRNHTNKNKYKSITEIMHYJX2   = "zrnhtnknkyksiteimhyjx2";
    public static final String ZRNHTNKNKYKSITEIMHYJX3   = "zrnhtnknkyksiteimhyjx3";
    public static final String ZRNHTNKNKYKSITEIMHYJX4   = "zrnhtnknkyksiteimhyjx4";
    public static final String ZRNHTNKNKYKSITEIMHYJX5   = "zrnhtnknkyksiteimhyjx5";
    public static final String ZRNHTNKNKYKSITEIMHYJX6   = "zrnhtnknkyksiteimhyjx6";
    public static final String ZRNTYOHKREINYUTKBTTRTKHYJ = "zrntyohkreinyutkbttrtkhyj";
    public static final String ZRNKAZOKUMRTINKNENGK     = "zrnkazokumrtinknengk";
    public static final String ZRNALMYOUKIJYUNYM        = "zrnalmyoukijyunym";
    public static final String ZRNSETAITESYONO2         = "zrnsetaitesyono2";
    public static final String ZRNSETAITEHOKENSYURUIKIGOU2 = "zrnsetaitehokensyuruikigou2";
    public static final String ZRNSETAITEMRTISYURUIKGU2 = "zrnsetaitemrtisyuruikgu2";
    public static final String ZRNSETAITESIZNMRTISYURUI2 = "zrnsetaitesiznmrtisyurui2";
    public static final String ZRNSETAITETIGNMRTISYURUI2 = "zrnsetaitetignmrtisyurui2";
    public static final String ZRNSETAITEKIHONBUBUNS2   = "zrnsetaitekihonbubuns2";
    public static final String ZRNSETGUKITNKNITJBRKHNS2 = "zrnsetgukitnknitjbrkhns2";
    public static final String ZRNSETAITESIBOUS2        = "zrnsetaitesibous2";
    public static final String ZRNSETGUKITNKNITJBRSBUS2 = "zrnsetgukitnknitjbrsbus2";
    public static final String ZRNSETAITESYUUSEIS2      = "zrnsetaitesyuuseis2";
    public static final String ZRNSETAITEHARAIKOMIP2    = "zrnsetaiteharaikomip2";
    public static final String ZRNSETAITESYUKEIYAKUBUBUNP2 = "zrnsetaitesyukeiyakububunp2";
    public static final String ZRNSETAITGUKIKZKMRTIS2   = "zrnsetaitgukikzkmrtis2";
    public static final String ZRNSETAITETENKANKYKHYJ2  = "zrnsetaitetenkankykhyj2";
    public static final String ZRNSETAITESITEIMHRKP2    = "zrnsetaitesiteimhrkp2";
    public static final String ZRNSETAITESITEIMSYKYKP2  = "zrnsetaitesiteimsykykp2";
    public static final String ZRNSETAITENKMRTISYURUI2  = "zrnsetaitenkmrtisyurui2";
    public static final String ZRNSETAITEHKNKGUSDKBN2   = "zrnsetaitehknkgusdkbn2";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNDUJMOSSITISMODSYUGUHYJ = "zrndujmossitismodsyuguhyj";
    public static final String ZRNRNSIJHIYUBRIJDUJMOSKBN = "zrnrnsijhiyubrijdujmoskbn";
    public static final String ZRNTKTSPPISYKYKTIKKNBBNS = "zrntktsppisykyktikknbbns";
    public static final String ZRNTKSTTKYKSYURUIKGU     = "zrntksttkyksyuruikgu";
    public static final String ZRNTOKUSITUTOKUYAKUKIKAN = "zrntokusitutokuyakukikan";
    public static final String ZRNTKSTTKYKPHRKKKN       = "zrntksttkykphrkkkn";
    public static final String ZRNTOKUSITUTOKUYAKUS     = "zrntokusitutokuyakus";
    public static final String ZRNTOKUSITUTOKUYAKUP     = "zrntokusitutokuyakup";
    public static final String ZRNTOKUSITUTOKUYAKUSYUUSEIS = "zrntokusitutokuyakusyuuseis";
    public static final String ZRNTKSTTKYKMODSSAKUGENHYJ = "zrntksttkykmodssakugenhyj";
    public static final String ZRNTKSTTKYKTKJYUKBN      = "zrntksttkyktkjyukbn";
    public static final String ZRNTKSTTKYKTKJYUSKGNKKN  = "zrntksttkyktkjyuskgnkkn";
    public static final String ZRNTKSTTKYKTKJYURYUMSHYUTN = "zrntksttkyktkjyuryumshyutn";
    public static final String ZRNTKSTTKYKTKJYUP        = "zrntksttkyktkjyup";
    public static final String ZRNTKSTTKYKTIKKNBBNS     = "zrntksttkyktikknbbns";
    public static final String ZRNHTNKNTKTSPPITKYKKGUX1 = "zrnhtnkntktsppitkykkgux1";
    public static final String ZRNHTNKNTKTSPPITKYKKGUX2 = "zrnhtnkntktsppitkykkgux2";
    public static final String ZRNHTNKNTKTSPPITKYKKGUX3 = "zrnhtnkntktsppitkykkgux3";
    public static final String ZRNHTNKNTKTSPPITKYKKGUX4 = "zrnhtnkntktsppitkykkgux4";
    public static final String ZRNHTNKNTKTSPPITKYKKGUX5 = "zrnhtnkntktsppitkykkgux5";
    public static final String ZRNHTNKNTKTSPPITKYKKGUX6 = "zrnhtnkntktsppitkykkgux6";
    public static final String ZRNSURYUTKSTTKYKPWRBKKBN = "zrnsuryutksttkykpwrbkkbn";
    public static final String ZRNTKSTTKYKPWRBKKBN      = "zrntksttkykpwrbkkbn";
    public static final String ZRNTKSTTKYKTNKNYUGUKBN   = "zrntksttkyktnknyugukbn";
    public static final String ZRNTKSTTKYKKGUSDKBN      = "zrntksttkykkgusdkbn";
    public static final String ZRNYOBIV9X8              = "zrnyobiv9x8";
    public static final String ZRNDI2TKSTTKYKSYRIKGU    = "zrndi2tksttkyksyrikgu";
    public static final String ZRNDAI2TOKUSITUTOKUYAKUKKN = "zrndai2tokusitutokuyakukkn";
    public static final String ZRNDAI2TKSTTKYKPHRKKKN   = "zrndai2tksttkykphrkkkn";
    public static final String ZRNDAI2TOKUSITUTOKUYAKUS = "zrndai2tokusitutokuyakus";
    public static final String ZRNDAI2TOKUSITUTOKUYAKUP = "zrndai2tokusitutokuyakup";
    public static final String ZRNDI2TKSTTKYKSYUUSEIS   = "zrndi2tksttkyksyuuseis";
    public static final String ZRNDI2TKSTTKYKMODSSKGNHYJ = "zrndi2tksttkykmodsskgnhyj";
    public static final String ZRNDI2TKSTTKYKTKJYUKBN   = "zrndi2tksttkyktkjyukbn";
    public static final String ZRNDI2TKSTTKYKTKJYUSKGNKKN = "zrndi2tksttkyktkjyuskgnkkn";
    public static final String ZRNDI2TKSTTKYKTKJYURYMSHYTN = "zrndi2tksttkyktkjyurymshytn";
    public static final String ZRNDI2TKSTTKYKTKJYUP     = "zrndi2tksttkyktkjyup";
    public static final String ZRNDI2TKSTTKYKTAIKKNBBNS = "zrndi2tksttkyktaikknbbns";
    public static final String ZRNHTNKNDI2TKTSPPITKYKKGUX1 = "zrnhtnkndi2tktsppitkykkgux1";
    public static final String ZRNHTNKNDI2TKTSPPITKYKKGUX2 = "zrnhtnkndi2tktsppitkykkgux2";
    public static final String ZRNHTNKNDI2TKTSPPITKYKKGUX3 = "zrnhtnkndi2tktsppitkykkgux3";
    public static final String ZRNHTNKNDI2TKTSPPITKYKKGUX4 = "zrnhtnkndi2tktsppitkykkgux4";
    public static final String ZRNHTNKNDI2TKTSPPITKYKKGUX5 = "zrnhtnkndi2tktsppitkykkgux5";
    public static final String ZRNHTNKNDI2TKTSPPITKYKKGUX6 = "zrnhtnkndi2tktsppitkykkgux6";
    public static final String ZRNSURYUDI2TKSTTKYKPWRBKKBN = "zrnsuryudi2tksttkykpwrbkkbn";
    public static final String ZRNDI2TKSTTKYKPWRBKKBN   = "zrndi2tksttkykpwrbkkbn";
    public static final String ZRNDI2TKSTTKYKTNKNYUGUKBN = "zrndi2tksttkyktnknyugukbn";
    public static final String ZRNDI2TKSTTKYKKGUSDKBN   = "zrndi2tksttkykkgusdkbn";
    public static final String ZRNYOBIV9X9              = "zrnyobiv9x9";
    public static final String ZRNJYUUSITUTKYKSYURUIKGU = "zrnjyuusitutkyksyuruikgu";
    public static final String ZRNJYUUSITUTOKUYAKUKIKAN = "zrnjyuusitutokuyakukikan";
    public static final String ZRNJYUUSITUTKYKPHRKKKN   = "zrnjyuusitutkykphrkkkn";
    public static final String ZRNJYUUSITUTOKUYAKUS     = "zrnjyuusitutokuyakus";
    public static final String ZRNJYUUSITUTOKUYAKUP     = "zrnjyuusitutokuyakup";
    public static final String ZRNJYUUSITUTOKUYAKUSYUUSEIS = "zrnjyuusitutokuyakusyuuseis";
    public static final String ZRNJYUUSITUTKYKMODSSKGNHYJ = "zrnjyuusitutkykmodsskgnhyj";
    public static final String ZRNJYUUSITUTKYKTKJYUKBN  = "zrnjyuusitutkyktkjyukbn";
    public static final String ZRNJYUUSITUTKYKTKJYUSKGNKKN = "zrnjyuusitutkyktkjyuskgnkkn";
    public static final String ZRNJYUSTTKYKTKJYURYUMSHYUTN = "zrnjyusttkyktkjyuryumshyutn";
    public static final String ZRNJYUUSITUTKYKTKJYUP    = "zrnjyuusitutkyktkjyup";
    public static final String ZRNJYUUSITUTKYKTKTBICDX1 = "zrnjyuusitutkyktktbicdx1";
    public static final String ZRNJYUUSITUTKYKHTNPKKNX1 = "zrnjyuusitutkykhtnpkknx1";
    public static final String ZRNJYUUSITUTKYKTKTBICDX2 = "zrnjyuusitutkyktktbicdx2";
    public static final String ZRNJYUUSITUTKYKHTNPKKNX2 = "zrnjyuusitutkykhtnpkknx2";
    public static final String ZRNHTNKNMNSISKKNTKYKKGUX1 = "zrnhtnknmnsiskkntkykkgux1";
    public static final String ZRNHTNKNMNSISKKNTKYKKGUX2 = "zrnhtnknmnsiskkntkykkgux2";
    public static final String ZRNHTNKNMNSISKKNTKYKKGUX3 = "zrnhtnknmnsiskkntkykkgux3";
    public static final String ZRNHTNKNMNSISKKNTKYKKGUX4 = "zrnhtnknmnsiskkntkykkgux4";
    public static final String ZRNHTNKNMNSISKKNTKYKKGUX5 = "zrnhtnknmnsiskkntkykkgux5";
    public static final String ZRNHTNKNMNSISKKNTKYKKGUX6 = "zrnhtnknmnsiskkntkykkgux6";
    public static final String ZRNSURYUJYUSTTKYKPWRBKKBN = "zrnsuryujyusttkykpwrbkkbn";
    public static final String ZRNJYUUSITUTKYKPWRBKKBN  = "zrnjyuusitutkykpwrbkkbn";
    public static final String ZRNJYUUSITUTKYKTNKNYUGUKBN = "zrnjyuusitutkyktnknyugukbn";
    public static final String ZRNJYUUSITUTKYKKGUSDKBN  = "zrnjyuusitutkykkgusdkbn";
    public static final String ZRNYOBIV7X3              = "zrnyobiv7x3";
    public static final String ZRNDI2JYUUSITUTKYKSYRIKGU = "zrndi2jyuusitutkyksyrikgu";
    public static final String ZRNDI2JYUUSITUTKYKKKN    = "zrndi2jyuusitutkykkkn";
    public static final String ZRNDI2JYUUSITUTKYKPHRKKKN = "zrndi2jyuusitutkykphrkkkn";
    public static final String ZRNDAI2JYUUSITUTOKUYAKUS = "zrndai2jyuusitutokuyakus";
    public static final String ZRNDAI2JYUUSITUTOKUYAKUP = "zrndai2jyuusitutokuyakup";
    public static final String ZRNDI2JYUUSITUTKYKSYUUSEIS = "zrndi2jyuusitutkyksyuuseis";
    public static final String ZRNDI2JYUSTTKYKMODSSKGNHYJ = "zrndi2jyusttkykmodsskgnhyj";
    public static final String ZRNDI2JYUUSITUTKYKTKJYUKBN = "zrndi2jyuusitutkyktkjyukbn";
    public static final String ZRNDI2JYUSTTKYKTKJYUSKGNKKN = "zrndi2jyusttkyktkjyuskgnkkn";
    public static final String ZRNDI2JYUSTTKYKTKJYRYMSHYTN = "zrndi2jyusttkyktkjyrymshytn";
    public static final String ZRNDI2JYUUSITUTKYKTKJYUP = "zrndi2jyuusitutkyktkjyup";
    public static final String ZRNDI2JYUUSITUTKYKTKTBICDX1 = "zrndi2jyuusitutkyktktbicdx1";
    public static final String ZRNDI2JYUUSITUTKYKHTNPKKNX1 = "zrndi2jyuusitutkykhtnpkknx1";
    public static final String ZRNDI2JYUUSITUTKYKTKTBICDX2 = "zrndi2jyuusitutkyktktbicdx2";
    public static final String ZRNDI2JYUUSITUTKYKHTNPKKNX2 = "zrndi2jyuusitutkykhtnpkknx2";
    public static final String ZRNHTNKNDI2MNSISKKNTKYKKGX1 = "zrnhtnkndi2mnsiskkntkykkgx1";
    public static final String ZRNHTNKNDI2MNSISKKNTKYKKGX2 = "zrnhtnkndi2mnsiskkntkykkgx2";
    public static final String ZRNHTNKNDI2MNSISKKNTKYKKGX3 = "zrnhtnkndi2mnsiskkntkykkgx3";
    public static final String ZRNHTNKNDI2MNSISKKNTKYKKGX4 = "zrnhtnkndi2mnsiskkntkykkgx4";
    public static final String ZRNHTNKNDI2MNSISKKNTKYKKGX5 = "zrnhtnkndi2mnsiskkntkykkgx5";
    public static final String ZRNHTNKNDI2MNSISKKNTKYKKGX6 = "zrnhtnkndi2mnsiskkntkykkgx6";
    public static final String ZRNSURYUD2JYUSTTKYKPWRBKKBN = "zrnsuryud2jyusttkykpwrbkkbn";
    public static final String ZRNDI2JYUUSITUTKYKPWRBKKBN = "zrndi2jyuusitutkykpwrbkkbn";
    public static final String ZRNDI2JYUSTTKYKTNKNYUGUKBN = "zrndi2jyusttkyktnknyugukbn";
    public static final String ZRNDI2JYUUSITUTKYKKGUSDKBN = "zrndi2jyuusitutkykkgusdkbn";
    public static final String ZRNYOBIV7X4              = "zrnyobiv7x4";
    public static final String ZRNHAITOUSIHARAIKBN      = "zrnhaitousiharaikbn";
    public static final String ZRNSURYUSYKYKPWRBKKBN    = "zrnsuryusykykpwrbkkbn";
    public static final String ZRNNKDATETOKUTEISYURUIKGU = "zrnnkdatetokuteisyuruikgu";
    public static final String ZRNNENKINDATETOKUTEIKIKAN = "zrnnenkindatetokuteikikan";
    public static final String ZRNNKDATETOKUTEINKGK     = "zrnnkdatetokuteinkgk";
    public static final String ZRNNENKINDATETOKUTEIS    = "zrnnenkindatetokuteis";
    public static final String ZRNNENKINDATETOKUTEIP    = "zrnnenkindatetokuteip";
    public static final String ZRNNKDATETOKUTEISDTPDTKBN = "zrnnkdatetokuteisdtpdtkbn";
    public static final String ZRNNKDATETOKUTEIMODS     = "zrnnkdatetokuteimods";
    public static final String ZRNNKDATETOKUTEIMODSSKGNHYJ = "zrnnkdatetokuteimodsskgnhyj";
    public static final String ZRNNKDATETOKUTEISHRKKN   = "zrnnkdatetokuteishrkkn";
    public static final String ZRNKYKNIYUTKSYTIOUKBN    = "zrnkykniyutksytioukbn";
    public static final String ZRNKEIKA2NENMIMANTENKANHYJ = "zrnkeika2nenmimantenkanhyj";
    public static final String ZRNTUKIYUHTNKNKUSNMENNSUKBN = "zrntukiyuhtnknkusnmennsukbn";
    public static final String ZRNNKDATETOKUTEIKGUSDKBN = "zrnnkdatetokuteikgusdkbn";
    public static final String ZRNNENKINDATETOKUTEIKATAKBN = "zrnnenkindatetokuteikatakbn";
    public static final String ZRNYOBIV2X4              = "zrnyobiv2x4";
    public static final String ZRNSUGUSNSYUTKYKSYURUIKGU = "zrnsugusnsyutkyksyuruikgu";
    public static final String ZRNSUGUSNSYUTKYKKKN      = "zrnsugusnsyutkykkkn";
    public static final String ZRNSUGUSNSYUTKYKPHRKKKN  = "zrnsugusnsyutkykphrkkkn";
    public static final String ZRNSOUGOUSONSYOUTOKUYAKUS = "zrnsougousonsyoutokuyakus";
    public static final String ZRNSOUGOUSONSYOUTOKUYAKUP = "zrnsougousonsyoutokuyakup";
    public static final String ZRNSUGUSNSYUTKYKKGUSDKBN = "zrnsugusnsyutkykkgusdkbn";
    public static final String ZRNSUGUSNSYUTKYKPWRBKKBN = "zrnsugusnsyutkykpwrbkkbn";
    public static final String ZRNSUGUSNSYUTKYKKUSNMNRYAGE = "zrnsugusnsyutkykkusnmnryage";
    public static final String ZRNYOBIV7X5              = "zrnyobiv7x5";
    public static final String ZRNDI2SUGUSNSYUTKYKSYRIKGU = "zrndi2sugusnsyutkyksyrikgu";
    public static final String ZRNDI2SUGUSNSYUTKYKKKN   = "zrndi2sugusnsyutkykkkn";
    public static final String ZRNDI2SUGUSNSYUTKYKPHRKKKN = "zrndi2sugusnsyutkykphrkkkn";
    public static final String ZRNDI2SUGUSNSYUTKYKS     = "zrndi2sugusnsyutkyks";
    public static final String ZRNDI2SUGUSNSYUTKYKP     = "zrndi2sugusnsyutkykp";
    public static final String ZRNDI2SUGUSNSYTKYKKGUSDKBN = "zrndi2sugusnsytkykkgusdkbn";
    public static final String ZRNDI2SUGUSNSYUTKYKPWRBKKBN = "zrndi2sugusnsyutkykpwrbkkbn";
    public static final String ZRNYOBIV9X10             = "zrnyobiv9x10";
    public static final String ZRNTENKANKEITAIKBN       = "zrntenkankeitaikbn";
    public static final String ZRNGUKITNKNITJBRTIKNKNENGK = "zrngukitnknitjbrtiknknengk";
    public static final String ZRNGUKIHTNKNSUGUSNSYUTKYKS = "zrngukihtnknsugusnsyutkyks";
    public static final String ZRNTENKANITIJIBARAIP     = "zrntenkanitijibaraip";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNGOUKEINENBARAIKANSANPX1 = "zrngoukeinenbaraikansanpx1";
    public static final String ZRNHKTGTIKKIKKKNX1       = "zrnhktgtikkikkknx1";
    public static final String ZRNHTNKNKYKKIGMRSYSYRIKGUX1 = "zrnhtnknkykkigmrsysyrikgux1";
    public static final String ZRNGOUKEINENBARAIKANSANPX2 = "zrngoukeinenbaraikansanpx2";
    public static final String ZRNHKTGTIKKIKKKNX2       = "zrnhktgtikkikkknx2";
    public static final String ZRNHTNKNKYKKIGMRSYSYRIKGUX2 = "zrnhtnknkykkigmrsysyrikgux2";
    public static final String ZRNGOUKEINENBARAIKANSANPX3 = "zrngoukeinenbaraikansanpx3";
    public static final String ZRNHKTGTIKKIKKKNX3       = "zrnhktgtikkikkknx3";
    public static final String ZRNHTNKNKYKKIGMRSYSYRIKGUX3 = "zrnhtnknkykkigmrsysyrikgux3";
    public static final String ZRNGOUKEINENBARAIKANSANPX4 = "zrngoukeinenbaraikansanpx4";
    public static final String ZRNHKTGTIKKIKKKNX4       = "zrnhktgtikkikkknx4";
    public static final String ZRNHTNKNKYKKIGMRSYSYRIKGUX4 = "zrnhtnknkykkigmrsysyrikgux4";
    public static final String ZRNGOUKEINENBARAIKANSANPX5 = "zrngoukeinenbaraikansanpx5";
    public static final String ZRNHKTGTIKKIKKKNX5       = "zrnhktgtikkikkknx5";
    public static final String ZRNHTNKNKYKKIGMRSYSYRIKGUX5 = "zrnhtnknkykkigmrsysyrikgux5";
    public static final String ZRNGOUKEINENBARAIKANSANPX6 = "zrngoukeinenbaraikansanpx6";
    public static final String ZRNHKTGTIKKIKKKNX6       = "zrnhktgtikkikkknx6";
    public static final String ZRNHTNKNKYKKIGMRSYSYRIKGUX6 = "zrnhtnknkykkigmrsysyrikgux6";
    public static final String ZRNNICEONPLANHYJ         = "zrnniceonplanhyj";
    public static final String ZRNSYOKAIPRYOSYUYMD      = "zrnsyokaipryosyuymd";
    public static final String ZRNLDOWNMAETENKANNENSUUKBN = "zrnldownmaetenkannensuukbn";
    public static final String ZRNLDOWNMAESAITEISMITATUHYJ = "zrnldownmaesaiteismitatuhyj";
    public static final String ZRNDNTITIKGTKBTTRTKHYJ   = "zrndntitikgtkbttrtkhyj";
    public static final String ZRNREFORMKBN             = "zrnreformkbn";
    public static final String ZRNKIKEIYAKUTYUUIHYOUJI  = "zrnkikeiyakutyuuihyouji";
    public static final String ZRNKBNKEIRIYOUSEGCD      = "zrnkbnkeiriyousegcd";
    public static final String ZRNSYUUSEISKITEITEKIYOUKBN = "zrnsyuuseiskiteitekiyoukbn";
    public static final String ZRNGUKIHTNKNKZKMRTIMODS  = "zrngukihtnknkzkmrtimods";
    public static final String ZRNTNKNKIJYNTKYUHTNKNSBUS = "zrntnknkijyntkyuhtnknsbus";
    public static final String ZRNSRJSNYUSYOUHINHYJ     = "zrnsrjsnyusyouhinhyj";
    public static final String ZRNSIRAJIKAKUNINZUMIHYOUJI = "zrnsirajikakuninzumihyouji";
    public static final String ZRNSRJSNYUSYOUHINTKNNHYJ = "zrnsrjsnyusyouhintknnhyj";
    public static final String ZRNSINSAKBN              = "zrnsinsakbn";
    public static final String ZRNDAI2SINSAKBN          = "zrndai2sinsakbn";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNDAI2TOUKEIYOUSINSAKBN = "zrndai2toukeiyousinsakbn";
    public static final String ZRNSEIZONKYUHKNSHRSITEIMD = "zrnseizonkyuhknshrsiteimd";
    public static final String ZRNYOTEIRIRITUN5         = "zrnyoteiriritun5";
    public static final String ZRNSAITEIHOSYOURIRITU    = "zrnsaiteihosyouriritu";
    public static final String ZRNNKGNSRITU             = "zrnnkgnsritu";
    public static final String ZRNJIGYOUNENDOMATUV      = "zrnjigyounendomatuv";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNGUKIHTNKN5NNMEKSNYUMODS = "zrngukihtnkn5nnmeksnyumods";
    public static final String ZRNRENSEITEIKITKSYUSNKSNHYJ = "zrnrenseiteikitksyusnksnhyj";
    public static final String ZRNGOUKEINENBARAIKANSANP2X1 = "zrngoukeinenbaraikansanp2x1";
    public static final String ZRNGUKINENBARAIKNSNP2KBNX1 = "zrngukinenbaraiknsnp2kbnx1";
    public static final String ZRNHKTGTIKKIKKKN2X1      = "zrnhktgtikkikkkn2x1";
    public static final String ZRNGOUKEINENBARAIKANSANP2X2 = "zrngoukeinenbaraikansanp2x2";
    public static final String ZRNGUKINENBARAIKNSNP2KBNX2 = "zrngukinenbaraiknsnp2kbnx2";
    public static final String ZRNHKTGTIKKIKKKN2X2      = "zrnhktgtikkikkkn2x2";
    public static final String ZRNGOUKEINENBARAIKANSANP2X3 = "zrngoukeinenbaraikansanp2x3";
    public static final String ZRNGUKINENBARAIKNSNP2KBNX3 = "zrngukinenbaraiknsnp2kbnx3";
    public static final String ZRNHKTGTIKKIKKKN2X3      = "zrnhktgtikkikkkn2x3";
    public static final String ZRNGOUKEINENBARAIKANSANP2X4 = "zrngoukeinenbaraikansanp2x4";
    public static final String ZRNGUKINENBARAIKNSNP2KBNX4 = "zrngukinenbaraiknsnp2kbnx4";
    public static final String ZRNHKTGTIKKIKKKN2X4      = "zrnhktgtikkikkkn2x4";
    public static final String ZRNGOUKEINENBARAIKANSANP2X5 = "zrngoukeinenbaraikansanp2x5";
    public static final String ZRNGUKINENBARAIKNSNP2KBNX5 = "zrngukinenbaraiknsnp2kbnx5";
    public static final String ZRNHKTGTIKKIKKKN2X5      = "zrnhktgtikkikkkn2x5";
    public static final String ZRNGOUKEINENBARAIKANSANP2X6 = "zrngoukeinenbaraikansanp2x6";
    public static final String ZRNGUKINENBARAIKNSNP2KBNX6 = "zrngukinenbaraiknsnp2kbnx6";
    public static final String ZRNHKTGTIKKIKKKN2X6      = "zrnhktgtikkikkkn2x6";
    public static final String ZRNKOKUTITUUSANTAISYOUS  = "zrnkokutituusantaisyous";
    public static final String ZRNTOKUSYUYOUROUMANKIS   = "zrntokusyuyouroumankis";
    public static final String ZRNNKDTMRTITNKNYUUGUUKBN = "zrnnkdtmrtitnknyuuguukbn";
    public static final String ZRNNKDTMRTIKGUSDKBN      = "zrnnkdtmrtikgusdkbn";
    public static final String ZRNNENKINDATEMARUTEIKATAKBN = "zrnnenkindatemaruteikatakbn";
    public static final String ZRNNKDTMRTIKUSNMNRYOAGE  = "zrnnkdtmrtikusnmnryoage";
    public static final String ZRNKAIGONKDTMRTISYURUIKGU = "zrnkaigonkdtmrtisyuruikgu";
    public static final String ZRNKAIGONKDTMRTIKKAN     = "zrnkaigonkdtmrtikkan";
    public static final String ZRNKAIGONKDTMRTIPHRKKKN  = "zrnkaigonkdtmrtiphrkkkn";
    public static final String ZRNKAIGONKDTMRTINNKNNENGK = "zrnkaigonkdtmrtinnknnengk";
    public static final String ZRNKAIGONKDTMRTIS        = "zrnkaigonkdtmrtis";
    public static final String ZRNKAIGONKDTMRTIP        = "zrnkaigonkdtmrtip";
    public static final String ZRNKAIGONKDTMRTIMODS     = "zrnkaigonkdtmrtimods";
    public static final String ZRNKAIGONKDTMRTITKJYUKBN = "zrnkaigonkdtmrtitkjyukbn";
    public static final String ZRNKAIGONKDTMRTITKJYSKGNKKN = "zrnkaigonkdtmrtitkjyskgnkkn";
    public static final String ZRNKAIGONKDTMRTTKJYRYMSHYTN = "zrnkaigonkdtmrttkjyrymshytn";
    public static final String ZRNKAIGONKDTMRTITKJYUP   = "zrnkaigonkdtmrtitkjyup";
    public static final String ZRNHTNKNKAIGONKMRTSYRIKGUX1 = "zrnhtnknkaigonkmrtsyrikgux1";
    public static final String ZRNHTNKNKAIGONKMRTSYRIKGUX2 = "zrnhtnknkaigonkmrtsyrikgux2";
    public static final String ZRNHTNKNKAIGONKMRTSYRIKGUX3 = "zrnhtnknkaigonkmrtsyrikgux3";
    public static final String ZRNHTNKNKAIGONKMRTSYRIKGUX4 = "zrnhtnknkaigonkmrtsyrikgux4";
    public static final String ZRNHTNKNKAIGONKMRTSYRIKGUX5 = "zrnhtnknkaigonkmrtsyrikgux5";
    public static final String ZRNHTNKNKAIGONKMRTSYRIKGUX6 = "zrnhtnknkaigonkmrtsyrikgux6";
    public static final String ZRNKAIGONKDTMRTISHRKKN   = "zrnkaigonkdtmrtishrkkn";
    public static final String ZRNSURIKAIGONKMRTIPWRBKKBN = "zrnsurikaigonkmrtipwrbkkbn";
    public static final String ZRNKAIGONKDTMRTIPWRBKKBN = "zrnkaigonkdtmrtipwrbkkbn";
    public static final String ZRNKAIGONKDTMRTITNKNYUGUKBN = "zrnkaigonkdtmrtitnknyugukbn";
    public static final String ZRNKAIGONKDTMRTIKGUSDKBN = "zrnkaigonkdtmrtikgusdkbn";
    public static final String ZRNKAIGONKDTMRTIKTKBN    = "zrnkaigonkdtmrtiktkbn";
    public static final String ZRNKIGNKDTMRTIKUSNMNRYOAGE = "zrnkignkdtmrtikusnmnryoage";
    public static final String ZRNKAIGONKDTTKTISYURUIKGU = "zrnkaigonkdttktisyuruikgu";
    public static final String ZRNKAIGONKDTTKTIKKN      = "zrnkaigonkdttktikkn";
    public static final String ZRNKAIGONKDTTKTEINENKNGK = "zrnkaigonkdttkteinenkngk";
    public static final String ZRNKAIGONENKINDATETOKUTEIS = "zrnkaigonenkindatetokuteis";
    public static final String ZRNKAIGONENKINDATETOKUTEIP = "zrnkaigonenkindatetokuteip";
    public static final String ZRNKAIGONKDTTKTISDTPDTKBN = "zrnkaigonkdttktisdtpdtkbn";
    public static final String ZRNKAIGONKDTTKTIMODS     = "zrnkaigonkdttktimods";
    public static final String ZRNKAIGONKDTTKTISHRKKN   = "zrnkaigonkdttktishrkkn";
    public static final String ZRNKAIGONKDTTKTIKGUSDKBN = "zrnkaigonkdttktikgusdkbn";
    public static final String ZRNKAIGONKDTTKTIKTKBN    = "zrnkaigonkdttktiktkbn";
    public static final String ZRNKIGNKDTTKTIKUSNMNRYOAGE = "zrnkignkdttktikusnmnryoage";
    public static final String ZRNYOBIV2X5              = "zrnyobiv2x5";
    public static final String ZRNKAIGOTEIGENMRTISYURUIKGU = "zrnkaigoteigenmrtisyuruikgu";
    public static final String ZRNKAIGOTEIGENMARUTEIKIKAN = "zrnkaigoteigenmaruteikikan";
    public static final String ZRNKAIGOTIGNMRTIPHRKKKN  = "zrnkaigotignmrtiphrkkkn";
    public static final String ZRNKAIGOTEIGENMARUTEIS   = "zrnkaigoteigenmaruteis";
    public static final String ZRNKAIGOTEIGENMARUTEIP   = "zrnkaigoteigenmaruteip";
    public static final String ZRNKIGTIGNMRTIMODS       = "zrnkigtignmrtimods";
    public static final String ZRNKIGTIGNMRTITKJYUKBN   = "zrnkigtignmrtitkjyukbn";
    public static final String ZRNKIGTIGNMRTITKJYUSKGNKKN = "zrnkigtignmrtitkjyuskgnkkn";
    public static final String ZRNKIGTIGNMRTITKJYURYMSHYTN = "zrnkigtignmrtitkjyurymshytn";
    public static final String ZRNKIGTIGNMRTITKJYUP     = "zrnkigtignmrtitkjyup";
    public static final String ZRNHTNKNKIGTIGNMRTSYRIKGUX1 = "zrnhtnknkigtignmrtsyrikgux1";
    public static final String ZRNHTNKNKIGTIGNMRTSYRIKGUX2 = "zrnhtnknkigtignmrtsyrikgux2";
    public static final String ZRNHTNKNKIGTIGNMRTSYRIKGUX3 = "zrnhtnknkigtignmrtsyrikgux3";
    public static final String ZRNHTNKNKIGTIGNMRTSYRIKGUX4 = "zrnhtnknkigtignmrtsyrikgux4";
    public static final String ZRNHTNKNKIGTIGNMRTSYRIKGUX5 = "zrnhtnknkigtignmrtsyrikgux5";
    public static final String ZRNHTNKNKIGTIGNMRTSYRIKGUX6 = "zrnhtnknkigtignmrtsyrikgux6";
    public static final String ZRNSURKIGTIGNMRTIPWRBKKBN = "zrnsurkigtignmrtipwrbkkbn";
    public static final String ZRNKIGTIGNMRTIPWRBKKBN   = "zrnkigtignmrtipwrbkkbn";
    public static final String ZRNKIGTIGNMRTITNKNYUGUKBN = "zrnkigtignmrtitnknyugukbn";
    public static final String ZRNKAIGOTIGNMRTIKGUSDKBN = "zrnkaigotignmrtikgusdkbn";
    public static final String ZRNKIGTIGNMRTIKUSNMNRYOAGE = "zrnkigtignmrtikusnmnryoage";
    public static final String ZRNYOBIV4X15             = "zrnyobiv4x15";
    public static final String ZRNKAIGOTEIGENTKTISYURUIKGU = "zrnkaigoteigentktisyuruikgu";
    public static final String ZRNKAIGOTEIGENTOKUTEIKIKAN = "zrnkaigoteigentokuteikikan";
    public static final String ZRNKAIGOTEIGENTOKUTEIS   = "zrnkaigoteigentokuteis";
    public static final String ZRNKAIGOTEIGENTOKUTEIP   = "zrnkaigoteigentokuteip";
    public static final String ZRNKIGTIGNTKTISDTPDTKBN  = "zrnkigtigntktisdtpdtkbn";
    public static final String ZRNKIGTIGNTKTIMODS       = "zrnkigtigntktimods";
    public static final String ZRNKAIGOTIGNTKTIKGUSDKBN = "zrnkaigotigntktikgusdkbn";
    public static final String ZRNKIGTIGNTKTIKUSNMNRYOAGE = "zrnkigtigntktikusnmnryoage";
    public static final String ZRNYOBIV2X6              = "zrnyobiv2x6";
    public static final String ZRNHIKITUGIKAIMASIS      = "zrnhikitugikaimasis";
    public static final String ZRNCBKYHTISYUKYKUMKBN    = "zrncbkyhtisyukykumkbn";
    public static final String ZRNTUKIYUCBKYHTISYUS     = "zrntukiyucbkyhtisyus";
    public static final String ZRNCBHANTEITUUSANS       = "zrncbhanteituusans";
    public static final String ZRNTUKIYUSNKYKCBHNTIS    = "zrntukiyusnkykcbhntis";
    public static final String ZRNCBSTAGEKBN            = "zrncbstagekbn";
    public static final String ZRNTOUKEIYOUCBHANTEITUUSANS = "zrntoukeiyoucbhanteituusans";
    public static final String ZRNCBTUUSANKENSUU        = "zrncbtuusankensuu";
    public static final String ZRNCBHANTEITAISYOUTSNKENSUU = "zrncbhanteitaisyoutsnkensuu";
    public static final String ZRNTYOKUZENTUUSANHANTEISX1 = "zrntyokuzentuusanhanteisx1";
    public static final String ZRNTYOKUZENKYUUHUTAISYOUSX1 = "zrntyokuzenkyuuhutaisyousx1";
    public static final String ZRNTYOKUZENCBGAKUX1      = "zrntyokuzencbgakux1";
    public static final String ZRNTYOKUGOTUUSANHANTEISX1 = "zrntyokugotuusanhanteisx1";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUSX1 = "zrntyokugokyuuhutaisyousx1";
    public static final String ZRNTYOKUGOCBGAKUX1       = "zrntyokugocbgakux1";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNTYOKUZENTUUSANHANTEISX2 = "zrntyokuzentuusanhanteisx2";
    public static final String ZRNTYOKUZENKYUUHUTAISYOUSX2 = "zrntyokuzenkyuuhutaisyousx2";
    public static final String ZRNTYOKUZENCBGAKUX2      = "zrntyokuzencbgakux2";
    public static final String ZRNTYOKUGOTUUSANHANTEISX2 = "zrntyokugotuusanhanteisx2";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUSX2 = "zrntyokugokyuuhutaisyousx2";
    public static final String ZRNTYOKUGOCBGAKUX2       = "zrntyokugocbgakux2";
    public static final String ZRNYOBIV12X2             = "zrnyobiv12x2";
    public static final String ZRNTYOKUZENTUUSANHANTEISX3 = "zrntyokuzentuusanhanteisx3";
    public static final String ZRNTYOKUZENKYUUHUTAISYOUSX3 = "zrntyokuzenkyuuhutaisyousx3";
    public static final String ZRNTYOKUZENCBGAKUX3      = "zrntyokuzencbgakux3";
    public static final String ZRNTYOKUGOTUUSANHANTEISX3 = "zrntyokugotuusanhanteisx3";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUSX3 = "zrntyokugokyuuhutaisyousx3";
    public static final String ZRNTYOKUGOCBGAKUX3       = "zrntyokugocbgakux3";
    public static final String ZRNYOBIV12X3             = "zrnyobiv12x3";
    public static final String ZRNTYOKUZENTUUSANHANTEISX4 = "zrntyokuzentuusanhanteisx4";
    public static final String ZRNTYOKUZENKYUUHUTAISYOUSX4 = "zrntyokuzenkyuuhutaisyousx4";
    public static final String ZRNTYOKUZENCBGAKUX4      = "zrntyokuzencbgakux4";
    public static final String ZRNTYOKUGOTUUSANHANTEISX4 = "zrntyokugotuusanhanteisx4";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUSX4 = "zrntyokugokyuuhutaisyousx4";
    public static final String ZRNTYOKUGOCBGAKUX4       = "zrntyokugocbgakux4";
    public static final String ZRNYOBIV12X4             = "zrnyobiv12x4";
    public static final String ZRNTYOKUZENTUUSANHANTEISX5 = "zrntyokuzentuusanhanteisx5";
    public static final String ZRNTYOKUZENKYUUHUTAISYOUSX5 = "zrntyokuzenkyuuhutaisyousx5";
    public static final String ZRNTYOKUZENCBGAKUX5      = "zrntyokuzencbgakux5";
    public static final String ZRNTYOKUGOTUUSANHANTEISX5 = "zrntyokugotuusanhanteisx5";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUSX5 = "zrntyokugokyuuhutaisyousx5";
    public static final String ZRNTYOKUGOCBGAKUX5       = "zrntyokugocbgakux5";
    public static final String ZRNYOBIV12X5             = "zrnyobiv12x5";
    public static final String ZRNTYOKUZENTUUSANHANTEISX6 = "zrntyokuzentuusanhanteisx6";
    public static final String ZRNTYOKUZENKYUUHUTAISYOUSX6 = "zrntyokuzenkyuuhutaisyousx6";
    public static final String ZRNTYOKUZENCBGAKUX6      = "zrntyokuzencbgakux6";
    public static final String ZRNTYOKUGOTUUSANHANTEISX6 = "zrntyokugotuusanhanteisx6";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUSX6 = "zrntyokugokyuuhutaisyousx6";
    public static final String ZRNTYOKUGOCBGAKUX6       = "zrntyokugocbgakux6";
    public static final String ZRNYOBIV12X6             = "zrnyobiv12x6";
    public static final String ZRNCBKIKYKSYONOX1        = "zrncbkikyksyonox1";
    public static final String ZRNCBKIKYKHKNSYRUIKBNX1  = "zrncbkikykhknsyruikbnx1";
    public static final String ZRNCBKIKEIYAKUKEIYAKUYMDX1 = "zrncbkikeiyakukeiyakuymdx1";
    public static final String ZRNCBKIKYKKYHTISYUKBNX1  = "zrncbkikykkyhtisyukbnx1";
    public static final String ZRNCBKIKYKHNTITAISYOUKBNX1 = "zrncbkikykhntitaisyoukbnx1";
    public static final String ZRNKIKEIYAKUCBGAKUX1X1   = "zrnkikeiyakucbgakux1x1";
    public static final String ZRNKIKEIYAKUCBGAKUX2X1   = "zrnkikeiyakucbgakux2x1";
    public static final String ZRNCBKIKYKHANTEITSNSX1X1 = "zrncbkikykhanteitsnsx1x1";
    public static final String ZRNCBKIKYKHANTEITSNSX2X1 = "zrncbkikykhanteitsnsx2x1";
    public static final String ZRNYOBIV12X7             = "zrnyobiv12x7";
    public static final String ZRNCBKIKYKSYONOX2        = "zrncbkikyksyonox2";
    public static final String ZRNCBKIKYKHKNSYRUIKBNX2  = "zrncbkikykhknsyruikbnx2";
    public static final String ZRNCBKIKEIYAKUKEIYAKUYMDX2 = "zrncbkikeiyakukeiyakuymdx2";
    public static final String ZRNCBKIKYKKYHTISYUKBNX2  = "zrncbkikykkyhtisyukbnx2";
    public static final String ZRNCBKIKYKHNTITAISYOUKBNX2 = "zrncbkikykhntitaisyoukbnx2";
    public static final String ZRNKIKEIYAKUCBGAKUX1X2   = "zrnkikeiyakucbgakux1x2";
    public static final String ZRNKIKEIYAKUCBGAKUX2X2   = "zrnkikeiyakucbgakux2x2";
    public static final String ZRNCBKIKYKHANTEITSNSX1X2 = "zrncbkikykhanteitsnsx1x2";
    public static final String ZRNCBKIKYKHANTEITSNSX2X2 = "zrncbkikykhanteitsnsx2x2";
    public static final String ZRNYOBIV12X8             = "zrnyobiv12x8";
    public static final String ZRNCBKIKYKSYONOX3        = "zrncbkikyksyonox3";
    public static final String ZRNCBKIKYKHKNSYRUIKBNX3  = "zrncbkikykhknsyruikbnx3";
    public static final String ZRNCBKIKEIYAKUKEIYAKUYMDX3 = "zrncbkikeiyakukeiyakuymdx3";
    public static final String ZRNCBKIKYKKYHTISYUKBNX3  = "zrncbkikykkyhtisyukbnx3";
    public static final String ZRNCBKIKYKHNTITAISYOUKBNX3 = "zrncbkikykhntitaisyoukbnx3";
    public static final String ZRNKIKEIYAKUCBGAKUX1X3   = "zrnkikeiyakucbgakux1x3";
    public static final String ZRNKIKEIYAKUCBGAKUX2X3   = "zrnkikeiyakucbgakux2x3";
    public static final String ZRNCBKIKYKHANTEITSNSX1X3 = "zrncbkikykhanteitsnsx1x3";
    public static final String ZRNCBKIKYKHANTEITSNSX2X3 = "zrncbkikykhanteitsnsx2x3";
    public static final String ZRNYOBIV12X9             = "zrnyobiv12x9";
    public static final String ZRNHTNKNHKNSYRIKGUSDKBNX1 = "zrnhtnknhknsyrikgusdkbnx1";
    public static final String ZRNHTNKNMRTIKGUSDKBNX1   = "zrnhtnknmrtikgusdkbnx1";
    public static final String ZRNHTNKNSIZNMRTIKGUSDKBNX1 = "zrnhtnknsiznmrtikgusdkbnx1";
    public static final String ZRNHTNKNTIGNMRTIKGUSDKBNX1 = "zrnhtnkntignmrtikgusdkbnx1";
    public static final String ZRNHTNKNNKMRTIKGUSDKBNX1 = "zrnhtnknnkmrtikgusdkbnx1";
    public static final String ZRNHTNKNTKSTKGUSDKBNX1   = "zrnhtnkntkstkgusdkbnx1";
    public static final String ZRNHTNKNDI2TKSTKGUSDKBNX1 = "zrnhtnkndi2tkstkgusdkbnx1";
    public static final String ZRNHTNKNJYUSTKGUSDKBNX1  = "zrnhtnknjyustkgusdkbnx1";
    public static final String ZRNHTNKNDI2JYSITKGUSDKBNX1 = "zrnhtnkndi2jysitkgusdkbnx1";
    public static final String ZRNHTNKNKAIGONKMRTISDKBNX1 = "zrnhtnknkaigonkmrtisdkbnx1";
    public static final String ZRNHTNKNKIGTIGNMRTISDKBNX1 = "zrnhtnknkigtignmrtisdkbnx1";
    public static final String ZRNHTNKNKAIGOMRSYKGUSDKBNX1 = "zrnhtnknkaigomrsykgusdkbnx1";
    public static final String ZRNSUURIYOUYOBIV8X2      = "zrnsuuriyouyobiv8x2";
    public static final String ZRNHTNKNHKNSYRIKGUSDKBNX2 = "zrnhtnknhknsyrikgusdkbnx2";
    public static final String ZRNHTNKNMRTIKGUSDKBNX2   = "zrnhtnknmrtikgusdkbnx2";
    public static final String ZRNHTNKNSIZNMRTIKGUSDKBNX2 = "zrnhtnknsiznmrtikgusdkbnx2";
    public static final String ZRNHTNKNTIGNMRTIKGUSDKBNX2 = "zrnhtnkntignmrtikgusdkbnx2";
    public static final String ZRNHTNKNNKMRTIKGUSDKBNX2 = "zrnhtnknnkmrtikgusdkbnx2";
    public static final String ZRNHTNKNTKSTKGUSDKBNX2   = "zrnhtnkntkstkgusdkbnx2";
    public static final String ZRNHTNKNDI2TKSTKGUSDKBNX2 = "zrnhtnkndi2tkstkgusdkbnx2";
    public static final String ZRNHTNKNJYUSTKGUSDKBNX2  = "zrnhtnknjyustkgusdkbnx2";
    public static final String ZRNHTNKNDI2JYSITKGUSDKBNX2 = "zrnhtnkndi2jysitkgusdkbnx2";
    public static final String ZRNHTNKNKAIGONKMRTISDKBNX2 = "zrnhtnknkaigonkmrtisdkbnx2";
    public static final String ZRNHTNKNKIGTIGNMRTISDKBNX2 = "zrnhtnknkigtignmrtisdkbnx2";
    public static final String ZRNHTNKNKAIGOMRSYKGUSDKBNX2 = "zrnhtnknkaigomrsykgusdkbnx2";
    public static final String ZRNYOBIV8X5              = "zrnyobiv8x5";
    public static final String ZRNHTNKNHKNSYRIKGUSDKBNX3 = "zrnhtnknhknsyrikgusdkbnx3";
    public static final String ZRNHTNKNMRTIKGUSDKBNX3   = "zrnhtnknmrtikgusdkbnx3";
    public static final String ZRNHTNKNSIZNMRTIKGUSDKBNX3 = "zrnhtnknsiznmrtikgusdkbnx3";
    public static final String ZRNHTNKNTIGNMRTIKGUSDKBNX3 = "zrnhtnkntignmrtikgusdkbnx3";
    public static final String ZRNHTNKNNKMRTIKGUSDKBNX3 = "zrnhtnknnkmrtikgusdkbnx3";
    public static final String ZRNHTNKNTKSTKGUSDKBNX3   = "zrnhtnkntkstkgusdkbnx3";
    public static final String ZRNHTNKNDI2TKSTKGUSDKBNX3 = "zrnhtnkndi2tkstkgusdkbnx3";
    public static final String ZRNHTNKNJYUSTKGUSDKBNX3  = "zrnhtnknjyustkgusdkbnx3";
    public static final String ZRNHTNKNDI2JYSITKGUSDKBNX3 = "zrnhtnkndi2jysitkgusdkbnx3";
    public static final String ZRNHTNKNKAIGONKMRTISDKBNX3 = "zrnhtnknkaigonkmrtisdkbnx3";
    public static final String ZRNHTNKNKIGTIGNMRTISDKBNX3 = "zrnhtnknkigtignmrtisdkbnx3";
    public static final String ZRNHTNKNKAIGOMRSYKGUSDKBNX3 = "zrnhtnknkaigomrsykgusdkbnx3";
    public static final String ZRNYOBIV8X6              = "zrnyobiv8x6";
    public static final String ZRNHTNKNHKNSYRIKGUSDKBNX4 = "zrnhtnknhknsyrikgusdkbnx4";
    public static final String ZRNHTNKNMRTIKGUSDKBNX4   = "zrnhtnknmrtikgusdkbnx4";
    public static final String ZRNHTNKNSIZNMRTIKGUSDKBNX4 = "zrnhtnknsiznmrtikgusdkbnx4";
    public static final String ZRNHTNKNTIGNMRTIKGUSDKBNX4 = "zrnhtnkntignmrtikgusdkbnx4";
    public static final String ZRNHTNKNNKMRTIKGUSDKBNX4 = "zrnhtnknnkmrtikgusdkbnx4";
    public static final String ZRNHTNKNTKSTKGUSDKBNX4   = "zrnhtnkntkstkgusdkbnx4";
    public static final String ZRNHTNKNDI2TKSTKGUSDKBNX4 = "zrnhtnkndi2tkstkgusdkbnx4";
    public static final String ZRNHTNKNJYUSTKGUSDKBNX4  = "zrnhtnknjyustkgusdkbnx4";
    public static final String ZRNHTNKNDI2JYSITKGUSDKBNX4 = "zrnhtnkndi2jysitkgusdkbnx4";
    public static final String ZRNHTNKNKAIGONKMRTISDKBNX4 = "zrnhtnknkaigonkmrtisdkbnx4";
    public static final String ZRNHTNKNKIGTIGNMRTISDKBNX4 = "zrnhtnknkigtignmrtisdkbnx4";
    public static final String ZRNHTNKNKAIGOMRSYKGUSDKBNX4 = "zrnhtnknkaigomrsykgusdkbnx4";
    public static final String ZRNYOBIV8X7              = "zrnyobiv8x7";
    public static final String ZRNHTNKNHKNSYRIKGUSDKBNX5 = "zrnhtnknhknsyrikgusdkbnx5";
    public static final String ZRNHTNKNMRTIKGUSDKBNX5   = "zrnhtnknmrtikgusdkbnx5";
    public static final String ZRNHTNKNSIZNMRTIKGUSDKBNX5 = "zrnhtnknsiznmrtikgusdkbnx5";
    public static final String ZRNHTNKNTIGNMRTIKGUSDKBNX5 = "zrnhtnkntignmrtikgusdkbnx5";
    public static final String ZRNHTNKNNKMRTIKGUSDKBNX5 = "zrnhtnknnkmrtikgusdkbnx5";
    public static final String ZRNHTNKNTKSTKGUSDKBNX5   = "zrnhtnkntkstkgusdkbnx5";
    public static final String ZRNHTNKNDI2TKSTKGUSDKBNX5 = "zrnhtnkndi2tkstkgusdkbnx5";
    public static final String ZRNHTNKNJYUSTKGUSDKBNX5  = "zrnhtnknjyustkgusdkbnx5";
    public static final String ZRNHTNKNDI2JYSITKGUSDKBNX5 = "zrnhtnkndi2jysitkgusdkbnx5";
    public static final String ZRNHTNKNKAIGONKMRTISDKBNX5 = "zrnhtnknkaigonkmrtisdkbnx5";
    public static final String ZRNHTNKNKIGTIGNMRTISDKBNX5 = "zrnhtnknkigtignmrtisdkbnx5";
    public static final String ZRNHTNKNKAIGOMRSYKGUSDKBNX5 = "zrnhtnknkaigomrsykgusdkbnx5";
    public static final String ZRNYOBIV8X8              = "zrnyobiv8x8";
    public static final String ZRNHTNKNHKNSYRIKGUSDKBNX6 = "zrnhtnknhknsyrikgusdkbnx6";
    public static final String ZRNHTNKNMRTIKGUSDKBNX6   = "zrnhtnknmrtikgusdkbnx6";
    public static final String ZRNHTNKNSIZNMRTIKGUSDKBNX6 = "zrnhtnknsiznmrtikgusdkbnx6";
    public static final String ZRNHTNKNTIGNMRTIKGUSDKBNX6 = "zrnhtnkntignmrtikgusdkbnx6";
    public static final String ZRNHTNKNNKMRTIKGUSDKBNX6 = "zrnhtnknnkmrtikgusdkbnx6";
    public static final String ZRNHTNKNTKSTKGUSDKBNX6   = "zrnhtnkntkstkgusdkbnx6";
    public static final String ZRNHTNKNDI2TKSTKGUSDKBNX6 = "zrnhtnkndi2tkstkgusdkbnx6";
    public static final String ZRNHTNKNJYUSTKGUSDKBNX6  = "zrnhtnknjyustkgusdkbnx6";
    public static final String ZRNHTNKNDI2JYSITKGUSDKBNX6 = "zrnhtnkndi2jysitkgusdkbnx6";
    public static final String ZRNHTNKNKAIGONKMRTISDKBNX6 = "zrnhtnknkaigonkmrtisdkbnx6";
    public static final String ZRNHTNKNKIGTIGNMRTISDKBNX6 = "zrnhtnknkigtignmrtisdkbnx6";
    public static final String ZRNHTNKNKAIGOMRSYKGUSDKBNX6 = "zrnhtnknkaigomrsykgusdkbnx6";
    public static final String ZRNYOBIV8X9              = "zrnyobiv8x9";
    public static final String ZRNKAIGONKTKYKSYURUIKGU  = "zrnkaigonktkyksyuruikgu";
    public static final String ZRNKAIGONKTKYKKGUSDKBN   = "zrnkaigonktkykkgusdkbn";
    public static final String ZRNKAIGONENKINTOKUYAKUKIKAN = "zrnkaigonenkintokuyakukikan";
    public static final String ZRNKAIGONKTKYKPHRKKKN    = "zrnkaigonktkykphrkkkn";
    public static final String ZRNKAIGONKTKYKNKGK       = "zrnkaigonktkyknkgk";
    public static final String ZRNKAIGONENKINTOKUYAKUS  = "zrnkaigonenkintokuyakus";
    public static final String ZRNKAIGONENKINTOKUYAKUP  = "zrnkaigonenkintokuyakup";
    public static final String ZRNKAIGONKTKYKMODS       = "zrnkaigonktkykmods";
    public static final String ZRNKAIGONKTKYKNKSHRKKN   = "zrnkaigonktkyknkshrkkn";
    public static final String ZRNHTNKNKAIGONKTKYKKGUX1 = "zrnhtnknkaigonktkykkgux1";
    public static final String ZRNHTNKNKAIGONKTKYKKGUX2 = "zrnhtnknkaigonktkykkgux2";
    public static final String ZRNHTNKNKAIGONKTKYKKGUX3 = "zrnhtnknkaigonktkykkgux3";
    public static final String ZRNHTNKNKAIGONKTKYKKGUX4 = "zrnhtnknkaigonktkykkgux4";
    public static final String ZRNHTNKNKAIGONKTKYKKGUX5 = "zrnhtnknkaigonktkykkgux5";
    public static final String ZRNHTNKNKAIGONKTKYKKGUX6 = "zrnhtnknkaigonktkykkgux6";
    public static final String ZRNHTNKNKAIGONKTKYKSDKBNX1 = "zrnhtnknkaigonktkyksdkbnx1";
    public static final String ZRNHTNKNKAIGONKTKYKSDKBNX2 = "zrnhtnknkaigonktkyksdkbnx2";
    public static final String ZRNHTNKNKAIGONKTKYKSDKBNX3 = "zrnhtnknkaigonktkyksdkbnx3";
    public static final String ZRNHTNKNKAIGONKTKYKSDKBNX4 = "zrnhtnknkaigonktkyksdkbnx4";
    public static final String ZRNHTNKNKAIGONKTKYKSDKBNX5 = "zrnhtnknkaigonktkyksdkbnx5";
    public static final String ZRNHTNKNKAIGONKTKYKSDKBNX6 = "zrnhtnknkaigonktkyksdkbnx6";
    public static final String ZRNSURIKAIGONKTKYKPWRBKKBN = "zrnsurikaigonktkykpwrbkkbn";
    public static final String ZRNKAIGONKTKYKPWRBKKBN   = "zrnkaigonktkykpwrbkkbn";
    public static final String ZRNKAIGONKTKYKTNKNYUGUKBN = "zrnkaigonktkyktnknyugukbn";
    public static final String ZRNYOBIV14               = "zrnyobiv14";
    public static final String ZRNITJBRKIGNKTKYKSYRIKGU = "zrnitjbrkignktkyksyrikgu";
    public static final String ZRNITJBRKIGNKTKYKSDKBN   = "zrnitjbrkignktkyksdkbn";
    public static final String ZRNITJBRKIGNKTKYKKKN     = "zrnitjbrkignktkykkkn";
    public static final String ZRNITJBRKIGNKTKYKNNKNGK  = "zrnitjbrkignktkyknnkngk";
    public static final String ZRNITJBRKIGNKTKYKS       = "zrnitjbrkignktkyks";
    public static final String ZRNITJBRKIGNKTKYKP       = "zrnitjbrkignktkykp";
    public static final String ZRNITJBRKIGNKTKYKSPDTKBN = "zrnitjbrkignktkykspdtkbn";
    public static final String ZRNITJBRKIGNKTKYKMODS    = "zrnitjbrkignktkykmods";
    public static final String ZRNITJBRKIGNKTKYKSHRKKN  = "zrnitjbrkignktkykshrkkn";
    public static final String ZRNYOBIV8X10             = "zrnyobiv8x10";
    public static final String ZRNNYUUINNISSUUGATAKBN   = "zrnnyuuinnissuugatakbn";
    public static final String ZRNTENKANKEIKANENSUU     = "zrntenkankeikanensuu";
    public static final String ZRNSYKKYUHTKYKSYURUIKGU  = "zrnsykkyuhtkyksyuruikgu";
    public static final String ZRNSYOKIKYUUHUTOKUYAKUKIKAN = "zrnsyokikyuuhutokuyakukikan";
    public static final String ZRNSYOKIKYUUHUTKYKPHRKKKN = "zrnsyokikyuuhutkykphrkkkn";
    public static final String ZRNSYKKYUHTKYKNTGK       = "zrnsykkyuhtkykntgk";
    public static final String ZRNSYOKIKYUUHUTOKUYAKUP  = "zrnsyokikyuuhutokuyakup";
    public static final String ZRNSYKKYUHTKYKGTKBN      = "zrnsykkyuhtkykgtkbn";
    public static final String ZRNSYOKIKYUUHUTKYKKGUSDKBN = "zrnsyokikyuuhutkykkgusdkbn";
    public static final String ZRNSYKKYUHTKJYURYUMSHYUTN = "zrnsykkyuhtkjyuryumshyutn";
    public static final String ZRNSYOKIKYUUHUTOKUJYOUP  = "zrnsyokikyuuhutokujyoup";
    public static final String ZRNSYKKYUHTKTBICDX1      = "zrnsykkyuhtktbicdx1";
    public static final String ZRNSYKKYUHHTNPKKNX1      = "zrnsykkyuhhtnpkknx1";
    public static final String ZRNSYKKYUHTKTBICDX2      = "zrnsykkyuhtktbicdx2";
    public static final String ZRNSYKKYUHHTNPKKNX2      = "zrnsykkyuhhtnpkknx2";
    public static final String ZRNSYKKYUHTKYKPWRBKKBN   = "zrnsykkyuhtkykpwrbkkbn";
    public static final String ZRNYOBIV3X6              = "zrnyobiv3x6";
    public static final String ZRNDI2SYKKYUHTKYKSYRIKGU = "zrndi2sykkyuhtkyksyrikgu";
    public static final String ZRNDI2SYKKYUHTKYKKKN     = "zrndi2sykkyuhtkykkkn";
    public static final String ZRNDI2SYKKYUHTKYKPHRKKKN = "zrndi2sykkyuhtkykphrkkkn";
    public static final String ZRNDI2SYKKYUHTKYKNTGK    = "zrndi2sykkyuhtkykntgk";
    public static final String ZRNDAI2SYOKIKYUUHUTOKUYAKUP = "zrndai2syokikyuuhutokuyakup";
    public static final String ZRNDI2SYKKYUHTKYKGTKBN   = "zrndi2sykkyuhtkykgtkbn";
    public static final String ZRNDI2SYKKYUHTKYKKGUSDKBN = "zrndi2sykkyuhtkykkgusdkbn";
    public static final String ZRNDI2SYKKYUHTKJYURYUMSHYTN = "zrndi2sykkyuhtkjyuryumshytn";
    public static final String ZRNDAI2SYOKIKYUUHUTOKUJYOUP = "zrndai2syokikyuuhutokujyoup";
    public static final String ZRNDI2SYKKYUHTKTBICDX1   = "zrndi2sykkyuhtktbicdx1";
    public static final String ZRNDI2SYKKYUHHTNPKKNX1   = "zrndi2sykkyuhhtnpkknx1";
    public static final String ZRNDI2SYKKYUHTKTBICDX2   = "zrndi2sykkyuhtktbicdx2";
    public static final String ZRNDI2SYKKYUHHTNPKKNX2   = "zrndi2sykkyuhhtnpkknx2";
    public static final String ZRNDI2SYKKYUHTKYKPWRBKKBN = "zrndi2sykkyuhtkykpwrbkkbn";
    public static final String ZRNYOBIV3X7              = "zrnyobiv3x7";
    public static final String ZRNDFITIJIBARAIP         = "zrndfitijibaraip";
    public static final String ZRNDFGOUKEITENKANKAKAKU  = "zrndfgoukeitenkankakaku";
    public static final String ZRNDFUKTKJIVBBNTNKNKAKAKU = "zrndfuktkjivbbntnknkakaku";
    public static final String ZRNDFUKTKJIPBBNTNKNKAKAKU = "zrndfuktkjipbbntnknkakaku";
    public static final String ZRNDFTNKNGVBBNTNKNKAKAKU = "zrndftnkngvbbntnknkakaku";
    public static final String ZRNDFTNKNGPBBNTNKNKAKAKU = "zrndftnkngpbbntnknkakaku";
    public static final String ZRNYOBIV18X2             = "zrnyobiv18x2";
    public static final String ZRNKAIGOMRTISYURUIKGU    = "zrnkaigomrtisyuruikgu";
    public static final String ZRNKAIGOMARUTEIKIGOUSDKBN = "zrnkaigomaruteikigousdkbn";
    public static final String ZRNKAIGOMARUTEIKIKAN     = "zrnkaigomaruteikikan";
    public static final String ZRNKAIGOMARUTEIPHRKKKN   = "zrnkaigomaruteiphrkkkn";
    public static final String ZRNKAIGOMARUTEIS         = "zrnkaigomaruteis";
    public static final String ZRNKAIGOMARUTEIP         = "zrnkaigomaruteip";
    public static final String ZRNKAIGOMARUTEISYUUSEIS  = "zrnkaigomaruteisyuuseis";
    public static final String ZRNKAIGOMARUTEIMODSSKGNHYJ = "zrnkaigomaruteimodsskgnhyj";
    public static final String ZRNKIGMRTITKJYUKBN       = "zrnkigmrtitkjyukbn";
    public static final String ZRNKIGMRTITKJYUSKGNKKN   = "zrnkigmrtitkjyuskgnkkn";
    public static final String ZRNKIGMRTITKJYURYUMSHYUTN = "zrnkigmrtitkjyuryumshyutn";
    public static final String ZRNKAIGOMARUTEITOKUJYOUP = "zrnkaigomaruteitokujyoup";
    public static final String ZRNHTNKNKIGMRTISYRIKGUX1 = "zrnhtnknkigmrtisyrikgux1";
    public static final String ZRNHTNKNKIGMRTISYRIKGUX2 = "zrnhtnknkigmrtisyrikgux2";
    public static final String ZRNHTNKNKIGMRTISYRIKGUX3 = "zrnhtnknkigmrtisyrikgux3";
    public static final String ZRNHTNKNKIGMRTISYRIKGUX4 = "zrnhtnknkigmrtisyrikgux4";
    public static final String ZRNHTNKNKIGMRTISYRIKGUX5 = "zrnhtnknkigmrtisyrikgux5";
    public static final String ZRNHTNKNKIGMRTISYRIKGUX6 = "zrnhtnknkigmrtisyrikgux6";
    public static final String ZRNHTNKNKAIGOMRTISDKBNX1 = "zrnhtnknkaigomrtisdkbnx1";
    public static final String ZRNHTNKNKAIGOMRTISDKBNX2 = "zrnhtnknkaigomrtisdkbnx2";
    public static final String ZRNHTNKNKAIGOMRTISDKBNX3 = "zrnhtnknkaigomrtisdkbnx3";
    public static final String ZRNHTNKNKAIGOMRTISDKBNX4 = "zrnhtnknkaigomrtisdkbnx4";
    public static final String ZRNHTNKNKAIGOMRTISDKBNX5 = "zrnhtnknkaigomrtisdkbnx5";
    public static final String ZRNHTNKNKAIGOMRTISDKBNX6 = "zrnhtnknkaigomrtisdkbnx6";
    public static final String ZRNSURKIGMRTIPWRBKKBN    = "zrnsurkigmrtipwrbkkbn";
    public static final String ZRNKIGMRTIPWRBKKBN       = "zrnkigmrtipwrbkkbn";
    public static final String ZRNKIGMRTITNKNYUGUKBN    = "zrnkigmrtitnknyugukbn";
    public static final String ZRNKIGMRTIKUSNMNRYOAGE   = "zrnkigmrtikusnmnryoage";
    public static final String ZRNYOBIV2X7              = "zrnyobiv2x7";
    public static final String ZRNKAIGOTOKUTEISYURUIKIGOU = "zrnkaigotokuteisyuruikigou";
    public static final String ZRNKAIGOTKTIKGUSDKBN     = "zrnkaigotktikgusdkbn";
    public static final String ZRNKAIGOTOKUTEIKIKAN     = "zrnkaigotokuteikikan";
    public static final String ZRNKAIGOTOKUTEIS         = "zrnkaigotokuteis";
    public static final String ZRNKAIGOTOKUTEIP         = "zrnkaigotokuteip";
    public static final String ZRNKIGTKTISDTPDTKBN      = "zrnkigtktisdtpdtkbn";
    public static final String ZRNKAIGOTOKUTEISYUUSEIS  = "zrnkaigotokuteisyuuseis";
    public static final String ZRNKAIGOTKTIMODSSKGNHYJ  = "zrnkaigotktimodsskgnhyj";
    public static final String ZRNKAIGOTKTIKUSNMNRYOAGE = "zrnkaigotktikusnmnryoage";
    public static final String ZRNYOBIV8X11             = "zrnyobiv8x11";
    public static final String ZRNKAZOKUIRYOUTKYKSYURUIKGU = "zrnkazokuiryoutkyksyuruikgu";
    public static final String ZRNKAZOKUIRYOUTOKUYAKUKIKAN = "zrnkazokuiryoutokuyakukikan";
    public static final String ZRNKAZOKUIRYOUTKYKPHRKKKN = "zrnkazokuiryoutkykphrkkkn";
    public static final String ZRNKZKIRYOUTKYKNTGK      = "zrnkzkiryoutkykntgk";
    public static final String ZRNKAZOKUIRYOUTOKUYAKUP  = "zrnkazokuiryoutokuyakup";
    public static final String ZRNKZKIRYOUTKYKGTKBN     = "zrnkzkiryoutkykgtkbn";
    public static final String ZRNKAZOKUIRYOUTKYKKGUSDKBN = "zrnkazokuiryoutkykkgusdkbn";
    public static final String ZRNKZKIRYOUTKTBICDX1     = "zrnkzkiryoutktbicdx1";
    public static final String ZRNKZKIRYOUHTNPKKNX1     = "zrnkzkiryouhtnpkknx1";
    public static final String ZRNKZKIRYOUTKTBICDX2     = "zrnkzkiryoutktbicdx2";
    public static final String ZRNKZKIRYOUHTNPKKNX2     = "zrnkzkiryouhtnpkknx2";
    public static final String ZRNYOBIV12X10            = "zrnyobiv12x10";

    private final PKZT_Skeiksnbsgetujisr2Rn primaryKey;

    public GenZT_Skeiksnbsgetujisr2Rn() {
        primaryKey = new PKZT_Skeiksnbsgetujisr2Rn();
    }

    public GenZT_Skeiksnbsgetujisr2Rn(String pZrnktgysyono) {
        primaryKey = new PKZT_Skeiksnbsgetujisr2Rn(pZrnktgysyono);
    }

    @Transient
    @Override
    public PKZT_Skeiksnbsgetujisr2Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Skeiksnbsgetujisr2Rn> getMetaClass() {
        return QZT_Skeiksnbsgetujisr2Rn.class;
    }

    private String zrnktgysyrymd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKTGYSYRYMD)
    public String getZrnktgysyrymd() {
        return zrnktgysyrymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnktgysyrymd(String pZrnktgysyrymd) {
        zrnktgysyrymd = pZrnktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKTGYSYONO)
    public String getZrnktgysyono() {
        return getPrimaryKey().getZrnktgysyono();
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnktgysyono(String pZrnktgysyono) {
        getPrimaryKey().setZrnktgysyono(pZrnktgysyono);
    }

    private String zrnktgyfilerenno;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKTGYFILERENNO)
    public String getZrnktgyfilerenno() {
        return zrnktgyfilerenno;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnktgyfilerenno(String pZrnktgyfilerenno) {
        zrnktgyfilerenno = pZrnktgyfilerenno;
    }

    private String zrnsiteidairininkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSITEIDAIRININKBN)
    public String getZrnsiteidairininkbn() {
        return zrnsiteidairininkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiteidairininkbn(String pZrnsiteidairininkbn) {
        zrnsiteidairininkbn = pZrnsiteidairininkbn;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnsrkykdrkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSRKYKDRKBN)
    public String getZrnsrkykdrkbn() {
        return zrnsrkykdrkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsrkykdrkbn(String pZrnsrkykdrkbn) {
        zrnsrkykdrkbn = pZrnsrkykdrkbn;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnyobiv6x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV6X3)
    public String getZrnyobiv6x3() {
        return zrnyobiv6x3;
    }

    public void setZrnyobiv6x3(String pZrnyobiv6x3) {
        zrnyobiv6x3 = pZrnyobiv6x3;
    }

    private String zrnlivingneedstkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNLIVINGNEEDSTKYKARIHYJ)
    public String getZrnlivingneedstkykarihyj() {
        return zrnlivingneedstkykarihyj;
    }

    public void setZrnlivingneedstkykarihyj(String pZrnlivingneedstkykarihyj) {
        zrnlivingneedstkykarihyj = pZrnlivingneedstkykarihyj;
    }

    private String zrnyobiv4x12;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV4X12)
    public String getZrnyobiv4x12() {
        return zrnyobiv4x12;
    }

    public void setZrnyobiv4x12(String pZrnyobiv4x12) {
        zrnyobiv4x12 = pZrnyobiv4x12;
    }

    private String zrngansupporttkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGANSUPPORTTKYKARIHYJ)
    public String getZrngansupporttkykarihyj() {
        return zrngansupporttkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansupporttkykarihyj(String pZrngansupporttkykarihyj) {
        zrngansupporttkykarihyj = pZrngansupporttkykarihyj;
    }

    private String zrnyobiv4x13;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV4X13)
    public String getZrnyobiv4x13() {
        return zrnyobiv4x13;
    }

    public void setZrnyobiv4x13(String pZrnyobiv4x13) {
        zrnyobiv4x13 = pZrnyobiv4x13;
    }

    private String zrntuuintokuyakusyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUYAKUSYURUIKIGOU)
    public String getZrntuuintokuyakusyuruikigou() {
        return zrntuuintokuyakusyuruikigou;
    }

    public void setZrntuuintokuyakusyuruikigou(String pZrntuuintokuyakusyuruikigou) {
        zrntuuintokuyakusyuruikigou = pZrntuuintokuyakusyuruikigou;
    }

    private String zrntuuintokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUYAKUKIKAN)
    public String getZrntuuintokuyakukikan() {
        return zrntuuintokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuuintokuyakukikan(String pZrntuuintokuyakukikan) {
        zrntuuintokuyakukikan = pZrntuuintokuyakukikan;
    }

    private String zrntuintkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUINTKYKPHRKKKN)
    public String getZrntuintkykphrkkkn() {
        return zrntuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuintkykphrkkkn(String pZrntuintkykphrkkkn) {
        zrntuintkykphrkkkn = pZrntuintkykphrkkkn;
    }

    private Integer zrntuuintokuyakunitigaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUYAKUNITIGAKU)
    public Integer getZrntuuintokuyakunitigaku() {
        return zrntuuintokuyakunitigaku;
    }

    public void setZrntuuintokuyakunitigaku(Integer pZrntuuintokuyakunitigaku) {
        zrntuuintokuyakunitigaku = pZrntuuintokuyakunitigaku;
    }

    private Long zrntuuintokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUYAKUP)
    public Long getZrntuuintokuyakup() {
        return zrntuuintokuyakup;
    }

    public void setZrntuuintokuyakup(Long pZrntuuintokuyakup) {
        zrntuuintokuyakup = pZrntuuintokuyakup;
    }

    private String zrntuuintokuyakugatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUYAKUGATAKBN)
    public String getZrntuuintokuyakugatakbn() {
        return zrntuuintokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuintokuyakugatakbn(String pZrntuuintokuyakugatakbn) {
        zrntuuintokuyakugatakbn = pZrntuuintokuyakugatakbn;
    }

    private Integer zrntuintkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUINTKJYURYUMSHYUTN)
    public Integer getZrntuintkjyuryumshyutn() {
        return zrntuintkjyuryumshyutn;
    }

    public void setZrntuintkjyuryumshyutn(Integer pZrntuintkjyuryumshyutn) {
        zrntuintkjyuryumshyutn = pZrntuintkjyuryumshyutn;
    }

    private Long zrntuuintokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUJYOUP)
    public Long getZrntuuintokujyoup() {
        return zrntuuintokujyoup;
    }

    public void setZrntuuintokujyoup(Long pZrntuuintokujyoup) {
        zrntuuintokujyoup = pZrntuuintokujyoup;
    }

    private String zrntuuintokuteibuicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUTEIBUICDX1)
    public String getZrntuuintokuteibuicdx1() {
        return zrntuuintokuteibuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuuintokuteibuicdx1(String pZrntuuintokuteibuicdx1) {
        zrntuuintokuteibuicdx1 = pZrntuuintokuteibuicdx1;
    }

    private String zrntuuinhutanpokikanx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINHUTANPOKIKANX1)
    public String getZrntuuinhutanpokikanx1() {
        return zrntuuinhutanpokikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuuinhutanpokikanx1(String pZrntuuinhutanpokikanx1) {
        zrntuuinhutanpokikanx1 = pZrntuuinhutanpokikanx1;
    }

    private String zrntuuintokuteibuicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINTOKUTEIBUICDX2)
    public String getZrntuuintokuteibuicdx2() {
        return zrntuuintokuteibuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuuintokuteibuicdx2(String pZrntuuintokuteibuicdx2) {
        zrntuuintokuteibuicdx2 = pZrntuuintokuteibuicdx2;
    }

    private String zrntuuinhutanpokikanx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUINHUTANPOKIKANX2)
    public String getZrntuuinhutanpokikanx2() {
        return zrntuuinhutanpokikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuuinhutanpokikanx2(String pZrntuuinhutanpokikanx2) {
        zrntuuinhutanpokikanx2 = pZrntuuinhutanpokikanx2;
    }

    private String zrntuintkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUINTKYKKGUSDKBN)
    public String getZrntuintkykkgusdkbn() {
        return zrntuintkykkgusdkbn;
    }

    public void setZrntuintkykkgusdkbn(String pZrntuintkykkgusdkbn) {
        zrntuintkykkgusdkbn = pZrntuintkykkgusdkbn;
    }

    private String zrntuintkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUINTKYKPWRBKKBN)
    public String getZrntuintkykpwrbkkbn() {
        return zrntuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntuintkykpwrbkkbn(String pZrntuintkykpwrbkkbn) {
        zrntuintkykpwrbkkbn = pZrntuintkykpwrbkkbn;
    }

    private String zrnyobiv3x4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV3X4)
    public String getZrnyobiv3x4() {
        return zrnyobiv3x4;
    }

    public void setZrnyobiv3x4(String pZrnyobiv3x4) {
        zrnyobiv3x4 = pZrnyobiv3x4;
    }

    private String zrndi2tuintkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TUINTKYKSYRIKGU)
    public String getZrndi2tuintkyksyrikgu() {
        return zrndi2tuintkyksyrikgu;
    }

    public void setZrndi2tuintkyksyrikgu(String pZrndi2tuintkyksyrikgu) {
        zrndi2tuintkyksyrikgu = pZrndi2tuintkyksyrikgu;
    }

    private String zrndai2tuuintokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUYAKUKIKAN)
    public String getZrndai2tuuintokuyakukikan() {
        return zrndai2tuuintokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tuuintokuyakukikan(String pZrndai2tuuintokuyakukikan) {
        zrndai2tuuintokuyakukikan = pZrndai2tuuintokuyakukikan;
    }

    private String zrndai2tuintkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUINTKYKPHRKKKN)
    public String getZrndai2tuintkykphrkkkn() {
        return zrndai2tuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tuintkykphrkkkn(String pZrndai2tuintkykphrkkkn) {
        zrndai2tuintkykphrkkkn = pZrndai2tuintkykphrkkkn;
    }

    private Integer zrndai2tuuintokuyakuntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUYAKUNTGK)
    public Integer getZrndai2tuuintokuyakuntgk() {
        return zrndai2tuuintokuyakuntgk;
    }

    public void setZrndai2tuuintokuyakuntgk(Integer pZrndai2tuuintokuyakuntgk) {
        zrndai2tuuintokuyakuntgk = pZrndai2tuuintokuyakuntgk;
    }

    private Long zrndai2tuuintokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUYAKUP)
    public Long getZrndai2tuuintokuyakup() {
        return zrndai2tuuintokuyakup;
    }

    public void setZrndai2tuuintokuyakup(Long pZrndai2tuuintokuyakup) {
        zrndai2tuuintokuyakup = pZrndai2tuuintokuyakup;
    }

    private String zrndai2tuuintokuyakugatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUYAKUGATAKBN)
    public String getZrndai2tuuintokuyakugatakbn() {
        return zrndai2tuuintokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tuuintokuyakugatakbn(String pZrndai2tuuintokuyakugatakbn) {
        zrndai2tuuintokuyakugatakbn = pZrndai2tuuintokuyakugatakbn;
    }

    private Integer zrndi2tuintkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TUINTKJYURYUMSHYUTN)
    public Integer getZrndi2tuintkjyuryumshyutn() {
        return zrndi2tuintkjyuryumshyutn;
    }

    public void setZrndi2tuintkjyuryumshyutn(Integer pZrndi2tuintkjyuryumshyutn) {
        zrndi2tuintkjyuryumshyutn = pZrndi2tuintkjyuryumshyutn;
    }

    private Long zrndai2tuuintokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUJYOUP)
    public Long getZrndai2tuuintokujyoup() {
        return zrndai2tuuintokujyoup;
    }

    public void setZrndai2tuuintokujyoup(Long pZrndai2tuuintokujyoup) {
        zrndai2tuuintokujyoup = pZrndai2tuuintokujyoup;
    }

    private String zrndai2tuuintokuteibuicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUTEIBUICDX1)
    public String getZrndai2tuuintokuteibuicdx1() {
        return zrndai2tuuintokuteibuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tuuintokuteibuicdx1(String pZrndai2tuuintokuteibuicdx1) {
        zrndai2tuuintokuteibuicdx1 = pZrndai2tuuintokuteibuicdx1;
    }

    private String zrndai2tuuinhutanpokikanx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINHUTANPOKIKANX1)
    public String getZrndai2tuuinhutanpokikanx1() {
        return zrndai2tuuinhutanpokikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tuuinhutanpokikanx1(String pZrndai2tuuinhutanpokikanx1) {
        zrndai2tuuinhutanpokikanx1 = pZrndai2tuuinhutanpokikanx1;
    }

    private String zrndai2tuuintokuteibuicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINTOKUTEIBUICDX2)
    public String getZrndai2tuuintokuteibuicdx2() {
        return zrndai2tuuintokuteibuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tuuintokuteibuicdx2(String pZrndai2tuuintokuteibuicdx2) {
        zrndai2tuuintokuteibuicdx2 = pZrndai2tuuintokuteibuicdx2;
    }

    private String zrndai2tuuinhutanpokikanx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TUUINHUTANPOKIKANX2)
    public String getZrndai2tuuinhutanpokikanx2() {
        return zrndai2tuuinhutanpokikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tuuinhutanpokikanx2(String pZrndai2tuuinhutanpokikanx2) {
        zrndai2tuuinhutanpokikanx2 = pZrndai2tuuinhutanpokikanx2;
    }

    private String zrndi2tuintkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TUINTKYKKGUSDKBN)
    public String getZrndi2tuintkykkgusdkbn() {
        return zrndi2tuintkykkgusdkbn;
    }

    public void setZrndi2tuintkykkgusdkbn(String pZrndi2tuintkykkgusdkbn) {
        zrndi2tuintkykkgusdkbn = pZrndi2tuintkykkgusdkbn;
    }

    private String zrndi2tuintkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TUINTKYKPWRBKKBN)
    public String getZrndi2tuintkykpwrbkkbn() {
        return zrndi2tuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2tuintkykpwrbkkbn(String pZrndi2tuintkykpwrbkkbn) {
        zrndi2tuintkykpwrbkkbn = pZrndi2tuintkykpwrbkkbn;
    }

    private String zrnyobiv3x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV3X5)
    public String getZrnyobiv3x5() {
        return zrnyobiv3x5;
    }

    public void setZrnyobiv3x5(String pZrnyobiv3x5) {
        zrnyobiv3x5 = pZrnyobiv3x5;
    }

    private String zrnkangotokuyakusyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUYAKUSYURUIKIGOU)
    public String getZrnkangotokuyakusyuruikigou() {
        return zrnkangotokuyakusyuruikigou;
    }

    public void setZrnkangotokuyakusyuruikigou(String pZrnkangotokuyakusyuruikigou) {
        zrnkangotokuyakusyuruikigou = pZrnkangotokuyakusyuruikigou;
    }

    private String zrnkangotokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUYAKUKIKAN)
    public String getZrnkangotokuyakukikan() {
        return zrnkangotokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkangotokuyakukikan(String pZrnkangotokuyakukikan) {
        zrnkangotokuyakukikan = pZrnkangotokuyakukikan;
    }

    private String zrnkangotkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTKYKPHRKKKN)
    public String getZrnkangotkykphrkkkn() {
        return zrnkangotkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkangotkykphrkkkn(String pZrnkangotkykphrkkkn) {
        zrnkangotkykphrkkkn = pZrnkangotkykphrkkkn;
    }

    private Integer zrnkangotokuyakunitigaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUYAKUNITIGAKU)
    public Integer getZrnkangotokuyakunitigaku() {
        return zrnkangotokuyakunitigaku;
    }

    public void setZrnkangotokuyakunitigaku(Integer pZrnkangotokuyakunitigaku) {
        zrnkangotokuyakunitigaku = pZrnkangotokuyakunitigaku;
    }

    private Long zrnkangotokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUYAKUP)
    public Long getZrnkangotokuyakup() {
        return zrnkangotokuyakup;
    }

    public void setZrnkangotokuyakup(Long pZrnkangotokuyakup) {
        zrnkangotokuyakup = pZrnkangotokuyakup;
    }

    private String zrnkangotokuyakugatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUYAKUGATAKBN)
    public String getZrnkangotokuyakugatakbn() {
        return zrnkangotokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkangotokuyakugatakbn(String pZrnkangotokuyakugatakbn) {
        zrnkangotokuyakugatakbn = pZrnkangotokuyakugatakbn;
    }

    private Integer zrnkngtkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKNGTKJYURYUMSHYUTN)
    public Integer getZrnkngtkjyuryumshyutn() {
        return zrnkngtkjyuryumshyutn;
    }

    public void setZrnkngtkjyuryumshyutn(Integer pZrnkngtkjyuryumshyutn) {
        zrnkngtkjyuryumshyutn = pZrnkngtkjyuryumshyutn;
    }

    private Long zrnkangotokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUJYOUP)
    public Long getZrnkangotokujyoup() {
        return zrnkangotokujyoup;
    }

    public void setZrnkangotokujyoup(Long pZrnkangotokujyoup) {
        zrnkangotokujyoup = pZrnkangotokujyoup;
    }

    private String zrnkangotokuteibuicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUTEIBUICDX1)
    public String getZrnkangotokuteibuicdx1() {
        return zrnkangotokuteibuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkangotokuteibuicdx1(String pZrnkangotokuteibuicdx1) {
        zrnkangotokuteibuicdx1 = pZrnkangotokuteibuicdx1;
    }

    private String zrnkangohutanpokikanx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOHUTANPOKIKANX1)
    public String getZrnkangohutanpokikanx1() {
        return zrnkangohutanpokikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkangohutanpokikanx1(String pZrnkangohutanpokikanx1) {
        zrnkangohutanpokikanx1 = pZrnkangohutanpokikanx1;
    }

    private String zrnkangotokuteibuicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOTOKUTEIBUICDX2)
    public String getZrnkangotokuteibuicdx2() {
        return zrnkangotokuteibuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkangotokuteibuicdx2(String pZrnkangotokuteibuicdx2) {
        zrnkangotokuteibuicdx2 = pZrnkangotokuteibuicdx2;
    }

    private String zrnkangohutanpokikanx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKANGOHUTANPOKIKANX2)
    public String getZrnkangohutanpokikanx2() {
        return zrnkangohutanpokikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkangohutanpokikanx2(String pZrnkangohutanpokikanx2) {
        zrnkangohutanpokikanx2 = pZrnkangohutanpokikanx2;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrndi2kngtkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2KNGTKYKSYRIKGU)
    public String getZrndi2kngtkyksyrikgu() {
        return zrndi2kngtkyksyrikgu;
    }

    public void setZrndi2kngtkyksyrikgu(String pZrndi2kngtkyksyrikgu) {
        zrndi2kngtkyksyrikgu = pZrndi2kngtkyksyrikgu;
    }

    private String zrndai2kangotokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUYAKUKIKAN)
    public String getZrndai2kangotokuyakukikan() {
        return zrndai2kangotokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2kangotokuyakukikan(String pZrndai2kangotokuyakukikan) {
        zrndai2kangotokuyakukikan = pZrndai2kangotokuyakukikan;
    }

    private String zrndai2kngtkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KNGTKYKPHRKKKN)
    public String getZrndai2kngtkykphrkkkn() {
        return zrndai2kngtkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2kngtkykphrkkkn(String pZrndai2kngtkykphrkkkn) {
        zrndai2kngtkykphrkkkn = pZrndai2kngtkykphrkkkn;
    }

    private Integer zrndai2kangotokuyakuntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUYAKUNTGK)
    public Integer getZrndai2kangotokuyakuntgk() {
        return zrndai2kangotokuyakuntgk;
    }

    public void setZrndai2kangotokuyakuntgk(Integer pZrndai2kangotokuyakuntgk) {
        zrndai2kangotokuyakuntgk = pZrndai2kangotokuyakuntgk;
    }

    private Long zrndai2kangotokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUYAKUP)
    public Long getZrndai2kangotokuyakup() {
        return zrndai2kangotokuyakup;
    }

    public void setZrndai2kangotokuyakup(Long pZrndai2kangotokuyakup) {
        zrndai2kangotokuyakup = pZrndai2kangotokuyakup;
    }

    private String zrndai2kangotokuyakugatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUYAKUGATAKBN)
    public String getZrndai2kangotokuyakugatakbn() {
        return zrndai2kangotokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2kangotokuyakugatakbn(String pZrndai2kangotokuyakugatakbn) {
        zrndai2kangotokuyakugatakbn = pZrndai2kangotokuyakugatakbn;
    }

    private Integer zrndi2kngtkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2KNGTKJYURYUMSHYUTN)
    public Integer getZrndi2kngtkjyuryumshyutn() {
        return zrndi2kngtkjyuryumshyutn;
    }

    public void setZrndi2kngtkjyuryumshyutn(Integer pZrndi2kngtkjyuryumshyutn) {
        zrndi2kngtkjyuryumshyutn = pZrndi2kngtkjyuryumshyutn;
    }

    private Long zrndai2kangotokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUJYOUP)
    public Long getZrndai2kangotokujyoup() {
        return zrndai2kangotokujyoup;
    }

    public void setZrndai2kangotokujyoup(Long pZrndai2kangotokujyoup) {
        zrndai2kangotokujyoup = pZrndai2kangotokujyoup;
    }

    private String zrndai2kangotokuteibuicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUTEIBUICDX1)
    public String getZrndai2kangotokuteibuicdx1() {
        return zrndai2kangotokuteibuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2kangotokuteibuicdx1(String pZrndai2kangotokuteibuicdx1) {
        zrndai2kangotokuteibuicdx1 = pZrndai2kangotokuteibuicdx1;
    }

    private String zrndai2kangohutanpokikanx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOHUTANPOKIKANX1)
    public String getZrndai2kangohutanpokikanx1() {
        return zrndai2kangohutanpokikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2kangohutanpokikanx1(String pZrndai2kangohutanpokikanx1) {
        zrndai2kangohutanpokikanx1 = pZrndai2kangohutanpokikanx1;
    }

    private String zrndai2kangotokuteibuicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOTOKUTEIBUICDX2)
    public String getZrndai2kangotokuteibuicdx2() {
        return zrndai2kangotokuteibuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2kangotokuteibuicdx2(String pZrndai2kangotokuteibuicdx2) {
        zrndai2kangotokuteibuicdx2 = pZrndai2kangotokuteibuicdx2;
    }

    private String zrndai2kangohutanpokikanx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2KANGOHUTANPOKIKANX2)
    public String getZrndai2kangohutanpokikanx2() {
        return zrndai2kangohutanpokikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2kangohutanpokikanx2(String pZrndai2kangohutanpokikanx2) {
        zrndai2kangohutanpokikanx2 = pZrndai2kangohutanpokikanx2;
    }

    private String zrnyobiv6x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV6X2)
    public String getZrnyobiv6x2() {
        return zrnyobiv6x2;
    }

    public void setZrnyobiv6x2(String pZrnyobiv6x2) {
        zrnyobiv6x2 = pZrnyobiv6x2;
    }

    private String zrnjysisppitkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKSYURUIKGU)
    public String getZrnjysisppitkyksyuruikgu() {
        return zrnjysisppitkyksyuruikgu;
    }

    public void setZrnjysisppitkyksyuruikgu(String pZrnjysisppitkyksyuruikgu) {
        zrnjysisppitkyksyuruikgu = pZrnjysisppitkyksyuruikgu;
    }

    private String zrnjysisppitkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKKKN)
    public String getZrnjysisppitkykkkn() {
        return zrnjysisppitkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppitkykkkn(String pZrnjysisppitkykkkn) {
        zrnjysisppitkykkkn = pZrnjysisppitkykkkn;
    }

    private String zrnjysisppitkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKPHRKKKN)
    public String getZrnjysisppitkykphrkkkn() {
        return zrnjysisppitkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppitkykphrkkkn(String pZrnjysisppitkykphrkkkn) {
        zrnjysisppitkykphrkkkn = pZrnjysisppitkykphrkkkn;
    }

    private Integer zrnjysisppitkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKNTGK)
    public Integer getZrnjysisppitkykntgk() {
        return zrnjysisppitkykntgk;
    }

    public void setZrnjysisppitkykntgk(Integer pZrnjysisppitkykntgk) {
        zrnjysisppitkykntgk = pZrnjysisppitkykntgk;
    }

    private Long zrnjyoseisippeitokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYOSEISIPPEITOKUYAKUP)
    public Long getZrnjyoseisippeitokuyakup() {
        return zrnjyoseisippeitokuyakup;
    }

    public void setZrnjyoseisippeitokuyakup(Long pZrnjyoseisippeitokuyakup) {
        zrnjyoseisippeitokuyakup = pZrnjyoseisippeitokuyakup;
    }

    private Integer zrnjysisppitkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKJYURYUMSHYUTN)
    public Integer getZrnjysisppitkjyuryumshyutn() {
        return zrnjysisppitkjyuryumshyutn;
    }

    public void setZrnjysisppitkjyuryumshyutn(Integer pZrnjysisppitkjyuryumshyutn) {
        zrnjysisppitkjyuryumshyutn = pZrnjysisppitkjyuryumshyutn;
    }

    private Long zrnjyoseisippeitokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYOSEISIPPEITOKUJYOUP)
    public Long getZrnjyoseisippeitokujyoup() {
        return zrnjyoseisippeitokujyoup;
    }

    public void setZrnjyoseisippeitokujyoup(Long pZrnjyoseisippeitokujyoup) {
        zrnjyoseisippeitokujyoup = pZrnjyoseisippeitokujyoup;
    }

    private String zrnjysisppitktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKTBICDX1)
    public String getZrnjysisppitktbicdx1() {
        return zrnjysisppitktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppitktbicdx1(String pZrnjysisppitktbicdx1) {
        zrnjysisppitktbicdx1 = pZrnjysisppitktbicdx1;
    }

    private String zrnjysisppihtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPIHTNPKKNX1)
    public String getZrnjysisppihtnpkknx1() {
        return zrnjysisppihtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppihtnpkknx1(String pZrnjysisppihtnpkknx1) {
        zrnjysisppihtnpkknx1 = pZrnjysisppihtnpkknx1;
    }

    private String zrnjysisppitktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKTBICDX2)
    public String getZrnjysisppitktbicdx2() {
        return zrnjysisppitktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppitktbicdx2(String pZrnjysisppitktbicdx2) {
        zrnjysisppitktbicdx2 = pZrnjysisppitktbicdx2;
    }

    private String zrnjysisppihtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPIHTNPKKNX2)
    public String getZrnjysisppihtnpkknx2() {
        return zrnjysisppihtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppihtnpkknx2(String pZrnjysisppihtnpkknx2) {
        zrnjysisppihtnpkknx2 = pZrnjysisppihtnpkknx2;
    }

    private String zrnjysisppitkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKKGUSDKBN)
    public String getZrnjysisppitkykkgusdkbn() {
        return zrnjysisppitkykkgusdkbn;
    }

    public void setZrnjysisppitkykkgusdkbn(String pZrnjysisppitkykkgusdkbn) {
        zrnjysisppitkykkgusdkbn = pZrnjysisppitkykkgusdkbn;
    }

    private String zrnjysisppitkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKPWRBKKBN)
    public String getZrnjysisppitkykpwrbkkbn() {
        return zrnjysisppitkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppitkykpwrbkkbn(String pZrnjysisppitkykpwrbkkbn) {
        zrnjysisppitkykpwrbkkbn = pZrnjysisppitkykpwrbkkbn;
    }

    private String zrnjysisppitkykkusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYSISPPITKYKKUSNMNRYOAGE)
    public String getZrnjysisppitkykkusnmnryoage() {
        return zrnjysisppitkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjysisppitkykkusnmnryoage(String pZrnjysisppitkykkusnmnryoage) {
        zrnjysisppitkykkusnmnryoage = pZrnjysisppitkykkusnmnryoage;
    }

    private String zrnyobiv2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV2X2)
    public String getZrnyobiv2x2() {
        return zrnyobiv2x2;
    }

    public void setZrnyobiv2x2(String pZrnyobiv2x2) {
        zrnyobiv2x2 = pZrnyobiv2x2;
    }

    private String zrndi2jysisppitkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKSYRIKGU)
    public String getZrndi2jysisppitkyksyrikgu() {
        return zrndi2jysisppitkyksyrikgu;
    }

    public void setZrndi2jysisppitkyksyrikgu(String pZrndi2jysisppitkyksyrikgu) {
        zrndi2jysisppitkyksyrikgu = pZrndi2jysisppitkyksyrikgu;
    }

    private String zrndi2jysisppitkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKKKN)
    public String getZrndi2jysisppitkykkkn() {
        return zrndi2jysisppitkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppitkykkkn(String pZrndi2jysisppitkykkkn) {
        zrndi2jysisppitkykkkn = pZrndi2jysisppitkykkkn;
    }

    private String zrndi2jysisppitkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKPHRKKKN)
    public String getZrndi2jysisppitkykphrkkkn() {
        return zrndi2jysisppitkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppitkykphrkkkn(String pZrndi2jysisppitkykphrkkkn) {
        zrndi2jysisppitkykphrkkkn = pZrndi2jysisppitkykphrkkkn;
    }

    private Integer zrndi2jysisppitkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKNTGK)
    public Integer getZrndi2jysisppitkykntgk() {
        return zrndi2jysisppitkykntgk;
    }

    public void setZrndi2jysisppitkykntgk(Integer pZrndi2jysisppitkykntgk) {
        zrndi2jysisppitkykntgk = pZrndi2jysisppitkykntgk;
    }

    private Long zrndi2jysisppitkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKP)
    public Long getZrndi2jysisppitkykp() {
        return zrndi2jysisppitkykp;
    }

    public void setZrndi2jysisppitkykp(Long pZrndi2jysisppitkykp) {
        zrndi2jysisppitkykp = pZrndi2jysisppitkykp;
    }

    private Integer zrndi2jysisppitkjyurymshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKJYURYMSHYTN)
    public Integer getZrndi2jysisppitkjyurymshytn() {
        return zrndi2jysisppitkjyurymshytn;
    }

    public void setZrndi2jysisppitkjyurymshytn(Integer pZrndi2jysisppitkjyurymshytn) {
        zrndi2jysisppitkjyurymshytn = pZrndi2jysisppitkjyurymshytn;
    }

    private Long zrndi2jysisppitkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKJYUP)
    public Long getZrndi2jysisppitkjyup() {
        return zrndi2jysisppitkjyup;
    }

    public void setZrndi2jysisppitkjyup(Long pZrndi2jysisppitkjyup) {
        zrndi2jysisppitkjyup = pZrndi2jysisppitkjyup;
    }

    private String zrndi2jysisppitktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKTBICDX1)
    public String getZrndi2jysisppitktbicdx1() {
        return zrndi2jysisppitktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppitktbicdx1(String pZrndi2jysisppitktbicdx1) {
        zrndi2jysisppitktbicdx1 = pZrndi2jysisppitktbicdx1;
    }

    private String zrndi2jysisppihtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPIHTNPKKNX1)
    public String getZrndi2jysisppihtnpkknx1() {
        return zrndi2jysisppihtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppihtnpkknx1(String pZrndi2jysisppihtnpkknx1) {
        zrndi2jysisppihtnpkknx1 = pZrndi2jysisppihtnpkknx1;
    }

    private String zrndi2jysisppitktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKTBICDX2)
    public String getZrndi2jysisppitktbicdx2() {
        return zrndi2jysisppitktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppitktbicdx2(String pZrndi2jysisppitktbicdx2) {
        zrndi2jysisppitktbicdx2 = pZrndi2jysisppitktbicdx2;
    }

    private String zrndi2jysisppihtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPIHTNPKKNX2)
    public String getZrndi2jysisppihtnpkknx2() {
        return zrndi2jysisppihtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppihtnpkknx2(String pZrndi2jysisppihtnpkknx2) {
        zrndi2jysisppihtnpkknx2 = pZrndi2jysisppihtnpkknx2;
    }

    private String zrndi2jysisppitkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKKGUSDKBN)
    public String getZrndi2jysisppitkykkgusdkbn() {
        return zrndi2jysisppitkykkgusdkbn;
    }

    public void setZrndi2jysisppitkykkgusdkbn(String pZrndi2jysisppitkykkgusdkbn) {
        zrndi2jysisppitkykkgusdkbn = pZrndi2jysisppitkykkgusdkbn;
    }

    private String zrndi2jysisppitkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYSISPPITKYKPWRBKKBN)
    public String getZrndi2jysisppitkykpwrbkkbn() {
        return zrndi2jysisppitkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jysisppitkykpwrbkkbn(String pZrndi2jysisppitkykpwrbkkbn) {
        zrndi2jysisppitkykpwrbkkbn = pZrndi2jysisppitkykpwrbkkbn;
    }

    private String zrnyobiv4x14;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV4X14)
    public String getZrnyobiv4x14() {
        return zrnyobiv4x14;
    }

    public void setZrnyobiv4x14(String pZrnyobiv4x14) {
        zrnyobiv4x14 = pZrnyobiv4x14;
    }

    private String zrnwinninglifehyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNWINNINGLIFEHYOUJI)
    public String getZrnwinninglifehyouji() {
        return zrnwinninglifehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnwinninglifehyouji(String pZrnwinninglifehyouji) {
        zrnwinninglifehyouji = pZrnwinninglifehyouji;
    }

    private String zrnstyouikusikinuktrininkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSTYOUIKUSIKINUKTRININKBN)
    public String getZrnstyouikusikinuktrininkbn() {
        return zrnstyouikusikinuktrininkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnstyouikusikinuktrininkbn(String pZrnstyouikusikinuktrininkbn) {
        zrnstyouikusikinuktrininkbn = pZrnstyouikusikinuktrininkbn;
    }

    private String zrnjyudthumeharaitkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUDTHUMEHARAITKYKARIHYJ)
    public String getZrnjyudthumeharaitkykarihyj() {
        return zrnjyudthumeharaitkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyudthumeharaitkykarihyj(String pZrnjyudthumeharaitkykarihyj) {
        zrnjyudthumeharaitkykarihyj = pZrnjyudthumeharaitkykarihyj;
    }

    private String zrnsinkenkouseikatupackhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSINKENKOUSEIKATUPACKHYJ)
    public String getZrnsinkenkouseikatupackhyj() {
        return zrnsinkenkouseikatupackhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinkenkouseikatupackhyj(String pZrnsinkenkouseikatupackhyj) {
        zrnsinkenkouseikatupackhyj = pZrnsinkenkouseikatupackhyj;
    }

    private String zrnsyukeiyakupwaribikikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYUKEIYAKUPWARIBIKIKBN)
    public String getZrnsyukeiyakupwaribikikbn() {
        return zrnsyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyukeiyakupwaribikikbn(String pZrnsyukeiyakupwaribikikbn) {
        zrnsyukeiyakupwaribikikbn = pZrnsyukeiyakupwaribikikbn;
    }

    private String zrnsykyktnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKYKTNKNYUGUKBN)
    public String getZrnsykyktnknyugukbn() {
        return zrnsykyktnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsykyktnknyugukbn(String pZrnsykyktnknyugukbn) {
        zrnsykyktnknyugukbn = pZrnsykyktnknyugukbn;
    }

    private String zrnmosjihonninkknnkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNMOSJIHONNINKKNNKBN)
    public String getZrnmosjihonninkknnkbn() {
        return zrnmosjihonninkknnkbn;
    }

    public void setZrnmosjihonninkknnkbn(String pZrnmosjihonninkknnkbn) {
        zrnmosjihonninkknnkbn = pZrnmosjihonninkknnkbn;
    }

    private String zrnkituenhonsuu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKITUENHONSUU)
    public String getZrnkituenhonsuu() {
        return zrnkituenhonsuu;
    }

    public void setZrnkituenhonsuu(String pZrnkituenhonsuu) {
        zrnkituenhonsuu = pZrnkituenhonsuu;
    }

    private String zrnkousinmaetenkannensuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKOUSINMAETENKANNENSUUKBN)
    public String getZrnkousinmaetenkannensuukbn() {
        return zrnkousinmaetenkannensuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinmaetenkannensuukbn(String pZrnkousinmaetenkannensuukbn) {
        zrnkousinmaetenkannensuukbn = pZrnkousinmaetenkannensuukbn;
    }

    private String zrnmankimaetenkannensuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNMANKIMAETENKANNENSUUKBN)
    public String getZrnmankimaetenkannensuukbn() {
        return zrnmankimaetenkannensuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmankimaetenkannensuukbn(String pZrnmankimaetenkannensuukbn) {
        zrnmankimaetenkannensuukbn = pZrnmankimaetenkannensuukbn;
    }

    private String zrnseikitenkanhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSEIKITENKANHYOUJI)
    public String getZrnseikitenkanhyouji() {
        return zrnseikitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnseikitenkanhyouji(String pZrnseikitenkanhyouji) {
        zrnseikitenkanhyouji = pZrnseikitenkanhyouji;
    }

    private String zrngengakutenkankykhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGENGAKUTENKANKYKHYJ)
    public String getZrngengakutenkankykhyj() {
        return zrngengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngengakutenkankykhyj(String pZrngengakutenkankykhyj) {
        zrngengakutenkankykhyj = pZrngengakutenkankykhyj;
    }

    private String zrnyobiv2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV2X3)
    public String getZrnyobiv2x3() {
        return zrnyobiv2x3;
    }

    public void setZrnyobiv2x3(String pZrnyobiv2x3) {
        zrnyobiv2x3 = pZrnyobiv2x3;
    }

    private String zrnkousin3nenmaetnknhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKOUSIN3NENMAETNKNHYJ)
    public String getZrnkousin3nenmaetnknhyj() {
        return zrnkousin3nenmaetnknhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousin3nenmaetnknhyj(String pZrnkousin3nenmaetnknhyj) {
        zrnkousin3nenmaetnknhyj = pZrnkousin3nenmaetnknhyj;
    }

    private String zrndugktnknsntkhuhukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDUGKTNKNSNTKHUHUKBN)
    public String getZrndugktnknsntkhuhukbn() {
        return zrndugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndugktnknsntkhuhukbn(String pZrndugktnknsntkhuhukbn) {
        zrndugktnknsntkhuhukbn = pZrndugktnknsntkhuhukbn;
    }

    private String zrntnknsnstkbttrtkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTNKNSNSTKBTTRTKKBN)
    public String getZrntnknsnstkbttrtkkbn() {
        return zrntnknsnstkbttrtkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknsnstkbttrtkkbn(String pZrntnknsnstkbttrtkkbn) {
        zrntnknsnstkbttrtkkbn = pZrntnknsnstkbttrtkkbn;
    }

    private Long zrnhtnknsiginyuintkykgkntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIGINYUINTKYKGKNTGK)
    public Long getZrnhtnknsiginyuintkykgkntgk() {
        return zrnhtnknsiginyuintkykgkntgk;
    }

    public void setZrnhtnknsiginyuintkykgkntgk(Long pZrnhtnknsiginyuintkykgkntgk) {
        zrnhtnknsiginyuintkykgkntgk = pZrnhtnknsiginyuintkykgkntgk;
    }

    private String zrnhtnknsiginyuintkykkykymd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIGINYUINTKYKKYKYMD)
    public String getZrnhtnknsiginyuintkykkykymd() {
        return zrnhtnknsiginyuintkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknsiginyuintkykkykymd(String pZrnhtnknsiginyuintkykkykymd) {
        zrnhtnknsiginyuintkykkykymd = pZrnhtnknsiginyuintkykkykymd;
    }

    private String zrnhtnknsiginyuintkyksnskbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIGINYUINTKYKSNSKBN)
    public String getZrnhtnknsiginyuintkyksnskbn() {
        return zrnhtnknsiginyuintkyksnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiginyuintkyksnskbn(String pZrnhtnknsiginyuintkyksnskbn) {
        zrnhtnknsiginyuintkyksnskbn = pZrnhtnknsiginyuintkyksnskbn;
    }

    private Long zrnhtnknsppinyuintkykgkntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSPPINYUINTKYKGKNTGK)
    public Long getZrnhtnknsppinyuintkykgkntgk() {
        return zrnhtnknsppinyuintkykgkntgk;
    }

    public void setZrnhtnknsppinyuintkykgkntgk(Long pZrnhtnknsppinyuintkykgkntgk) {
        zrnhtnknsppinyuintkykgkntgk = pZrnhtnknsppinyuintkykgkntgk;
    }

    private String zrnhtnknsppinyuintkykkykymd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSPPINYUINTKYKKYKYMD)
    public String getZrnhtnknsppinyuintkykkykymd() {
        return zrnhtnknsppinyuintkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknsppinyuintkykkykymd(String pZrnhtnknsppinyuintkykkykymd) {
        zrnhtnknsppinyuintkykkykymd = pZrnhtnknsppinyuintkykkykymd;
    }

    private String zrnhtnknsppinyuintkyksnskbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSPPINYUINTKYKSNSKBN)
    public String getZrnhtnknsppinyuintkyksnskbn() {
        return zrnhtnknsppinyuintkyksnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsppinyuintkyksnskbn(String pZrnhtnknsppinyuintkyksnskbn) {
        zrnhtnknsppinyuintkyksnskbn = pZrnhtnknsppinyuintkyksnskbn;
    }

    private Long zrnhtnknsijnbyutkykgukintgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIJNBYUTKYKGUKINTGK)
    public Long getZrnhtnknsijnbyutkykgukintgk() {
        return zrnhtnknsijnbyutkykgukintgk;
    }

    public void setZrnhtnknsijnbyutkykgukintgk(Long pZrnhtnknsijnbyutkykgukintgk) {
        zrnhtnknsijnbyutkykgukintgk = pZrnhtnknsijnbyutkykgukintgk;
    }

    private String zrnhtnknsijnbyutkykkykymd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIJNBYUTKYKKYKYMD)
    public String getZrnhtnknsijnbyutkykkykymd() {
        return zrnhtnknsijnbyutkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknsijnbyutkykkykymd(String pZrnhtnknsijnbyutkykkykymd) {
        zrnhtnknsijnbyutkykkykymd = pZrnhtnknsijnbyutkykkykymd;
    }

    private String zrnhtnknsijnbyutkyksnskbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIJNBYUTKYKSNSKBN)
    public String getZrnhtnknsijnbyutkyksnskbn() {
        return zrnhtnknsijnbyutkyksnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsijnbyutkyksnskbn(String pZrnhtnknsijnbyutkyksnskbn) {
        zrnhtnknsijnbyutkyksnskbn = pZrnhtnknsijnbyutkyksnskbn;
    }

    private Long zrnhtnknjysisppitkykgkintgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYSISPPITKYKGKINTGK)
    public Long getZrnhtnknjysisppitkykgkintgk() {
        return zrnhtnknjysisppitkykgkintgk;
    }

    public void setZrnhtnknjysisppitkykgkintgk(Long pZrnhtnknjysisppitkykgkintgk) {
        zrnhtnknjysisppitkykgkintgk = pZrnhtnknjysisppitkykgkintgk;
    }

    private String zrnhtnknjysisppitkykkykymd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYSISPPITKYKKYKYMD)
    public String getZrnhtnknjysisppitkykkykymd() {
        return zrnhtnknjysisppitkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknjysisppitkykkykymd(String pZrnhtnknjysisppitkykkykymd) {
        zrnhtnknjysisppitkykkykymd = pZrnhtnknjysisppitkykkykymd;
    }

    private String zrnhtnknjysisppitkyksnskbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYSISPPITKYKSNSKBN)
    public String getZrnhtnknjysisppitkyksnskbn() {
        return zrnhtnknjysisppitkyksnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknjysisppitkyksnskbn(String pZrnhtnknjysisppitkyksnskbn) {
        zrnhtnknjysisppitkyksnskbn = pZrnhtnknjysisppitkyksnskbn;
    }

    private String zrnsiteizukipwarimasihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSITEIZUKIPWARIMASIHYOUJI)
    public String getZrnsiteizukipwarimasihyouji() {
        return zrnsiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiteizukipwarimasihyouji(String pZrnsiteizukipwarimasihyouji) {
        zrnsiteizukipwarimasihyouji = pZrnsiteizukipwarimasihyouji;
    }

    private String zrnpwarimasisiteim1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNPWARIMASISITEIM1)
    public String getZrnpwarimasisiteim1() {
        return zrnpwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim1(String pZrnpwarimasisiteim1) {
        zrnpwarimasisiteim1 = pZrnpwarimasisiteim1;
    }

    private String zrnpwarimasisiteim2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNPWARIMASISITEIM2)
    public String getZrnpwarimasisiteim2() {
        return zrnpwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim2(String pZrnpwarimasisiteim2) {
        zrnpwarimasisiteim2 = pZrnpwarimasisiteim2;
    }

    private String zrnsiteimsykykpbairitu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSITEIMSYKYKPBAIRITU)
    public String getZrnsiteimsykykpbairitu() {
        return zrnsiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiteimsykykpbairitu(String pZrnsiteimsykykpbairitu) {
        zrnsiteimsykykpbairitu = pZrnsiteimsykykpbairitu;
    }

    private Long zrnsiteizukisyukeiyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSITEIZUKISYUKEIYAKUP)
    public Long getZrnsiteizukisyukeiyakup() {
        return zrnsiteizukisyukeiyakup;
    }

    public void setZrnsiteizukisyukeiyakup(Long pZrnsiteizukisyukeiyakup) {
        zrnsiteizukisyukeiyakup = pZrnsiteizukisyukeiyakup;
    }

    private Long zrntuujyoutukiharaikomip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUUJYOUTUKIHARAIKOMIP)
    public Long getZrntuujyoutukiharaikomip() {
        return zrntuujyoutukiharaikomip;
    }

    public void setZrntuujyoutukiharaikomip(Long pZrntuujyoutukiharaikomip) {
        zrntuujyoutukiharaikomip = pZrntuujyoutukiharaikomip;
    }

    private Long zrnsiteizukiharaikomip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSITEIZUKIHARAIKOMIP)
    public Long getZrnsiteizukiharaikomip() {
        return zrnsiteizukiharaikomip;
    }

    public void setZrnsiteizukiharaikomip(Long pZrnsiteizukiharaikomip) {
        zrnsiteizukiharaikomip = pZrnsiteizukiharaikomip;
    }

    private Long zrnmaruteikisiteizukip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNMARUTEIKISITEIZUKIP)
    public Long getZrnmaruteikisiteizukip() {
        return zrnmaruteikisiteizukip;
    }

    public void setZrnmaruteikisiteizukip(Long pZrnmaruteikisiteizukip) {
        zrnmaruteikisiteizukip = pZrnmaruteikisiteizukip;
    }

    private Long zrnseizonmaruteisiteimp;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSEIZONMARUTEISITEIMP)
    public Long getZrnseizonmaruteisiteimp() {
        return zrnseizonmaruteisiteimp;
    }

    public void setZrnseizonmaruteisiteimp(Long pZrnseizonmaruteisiteimp) {
        zrnseizonmaruteisiteimp = pZrnseizonmaruteisiteimp;
    }

    private String zrnmaruteipsiteibairitu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNMARUTEIPSITEIBAIRITU)
    public String getZrnmaruteipsiteibairitu() {
        return zrnmaruteipsiteibairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmaruteipsiteibairitu(String pZrnmaruteipsiteibairitu) {
        zrnmaruteipsiteibairitu = pZrnmaruteipsiteibairitu;
    }

    private String zrnseizonmaruteipstbairitu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSEIZONMARUTEIPSTBAIRITU)
    public String getZrnseizonmaruteipstbairitu() {
        return zrnseizonmaruteipstbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseizonmaruteipstbairitu(String pZrnseizonmaruteipstbairitu) {
        zrnseizonmaruteipstbairitu = pZrnseizonmaruteipstbairitu;
    }

    private String zrnnkdtmrtisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTISYURUIKGU)
    public String getZrnnkdtmrtisyuruikgu() {
        return zrnnkdtmrtisyuruikgu;
    }

    public void setZrnnkdtmrtisyuruikgu(String pZrnnkdtmrtisyuruikgu) {
        zrnnkdtmrtisyuruikgu = pZrnnkdtmrtisyuruikgu;
    }

    private String zrnnenkindatemaruteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATEMARUTEIKIKAN)
    public String getZrnnenkindatemaruteikikan() {
        return zrnnenkindatemaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnenkindatemaruteikikan(String pZrnnenkindatemaruteikikan) {
        zrnnenkindatemaruteikikan = pZrnnenkindatemaruteikikan;
    }

    private String zrnnkdatemaruteiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEIPHRKKKN)
    public String getZrnnkdatemaruteiphrkkkn() {
        return zrnnkdatemaruteiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdatemaruteiphrkkkn(String pZrnnkdatemaruteiphrkkkn) {
        zrnnkdatemaruteiphrkkkn = pZrnnkdatemaruteiphrkkkn;
    }

    private Long zrnnkdatemaruteinenkinnengk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEINENKINNENGK)
    public Long getZrnnkdatemaruteinenkinnengk() {
        return zrnnkdatemaruteinenkinnengk;
    }

    public void setZrnnkdatemaruteinenkinnengk(Long pZrnnkdatemaruteinenkinnengk) {
        zrnnkdatemaruteinenkinnengk = pZrnnkdatemaruteinenkinnengk;
    }

    private Long zrnnenkindatemaruteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATEMARUTEIS)
    public Long getZrnnenkindatemaruteis() {
        return zrnnenkindatemaruteis;
    }

    public void setZrnnenkindatemaruteis(Long pZrnnenkindatemaruteis) {
        zrnnenkindatemaruteis = pZrnnenkindatemaruteis;
    }

    private Long zrnnenkindatemaruteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATEMARUTEIP)
    public Long getZrnnenkindatemaruteip() {
        return zrnnenkindatemaruteip;
    }

    public void setZrnnenkindatemaruteip(Long pZrnnenkindatemaruteip) {
        zrnnenkindatemaruteip = pZrnnenkindatemaruteip;
    }

    private Long zrnnkdatemaruteimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEIMODS)
    public Long getZrnnkdatemaruteimods() {
        return zrnnkdatemaruteimods;
    }

    public void setZrnnkdatemaruteimods(Long pZrnnkdatemaruteimods) {
        zrnnkdatemaruteimods = pZrnnkdatemaruteimods;
    }

    private String zrnnkdtmrtimodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTIMODSSKGNHYJ)
    public String getZrnnkdtmrtimodsskgnhyj() {
        return zrnnkdtmrtimodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdtmrtimodsskgnhyj(String pZrnnkdtmrtimodsskgnhyj) {
        zrnnkdtmrtimodsskgnhyj = pZrnnkdtmrtimodsskgnhyj;
    }

    private String zrnnkdatemaruteitkjyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEITKJYOUKBN)
    public String getZrnnkdatemaruteitkjyoukbn() {
        return zrnnkdatemaruteitkjyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatemaruteitkjyoukbn(String pZrnnkdatemaruteitkjyoukbn) {
        zrnnkdatemaruteitkjyoukbn = pZrnnkdatemaruteitkjyoukbn;
    }

    private String zrnnkdtmrtitkjyouskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTITKJYOUSKGNKKN)
    public String getZrnnkdtmrtitkjyouskgnkkn() {
        return zrnnkdtmrtitkjyouskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdtmrtitkjyouskgnkkn(String pZrnnkdtmrtitkjyouskgnkkn) {
        zrnnkdtmrtitkjyouskgnkkn = pZrnnkdtmrtitkjyouskgnkkn;
    }

    private Integer zrnnkdtmrtitkjyouryumshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTITKJYOURYUMSHYTN)
    public Integer getZrnnkdtmrtitkjyouryumshytn() {
        return zrnnkdtmrtitkjyouryumshytn;
    }

    public void setZrnnkdtmrtitkjyouryumshytn(Integer pZrnnkdtmrtitkjyouryumshytn) {
        zrnnkdtmrtitkjyouryumshytn = pZrnnkdtmrtitkjyouryumshytn;
    }

    private Long zrnnkdatemaruteitkjyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEITKJYOUP)
    public Long getZrnnkdatemaruteitkjyoup() {
        return zrnnkdatemaruteitkjyoup;
    }

    public void setZrnnkdatemaruteitkjyoup(Long pZrnnkdatemaruteitkjyoup) {
        zrnnkdatemaruteitkjyoup = pZrnnkdatemaruteitkjyoup;
    }

    private String zrnhtnknnkdtmrtisyuruikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKDTMRTISYURUIKGUX1)
    public String getZrnhtnknnkdtmrtisyuruikgux1() {
        return zrnhtnknnkdtmrtisyuruikgux1;
    }

    public void setZrnhtnknnkdtmrtisyuruikgux1(String pZrnhtnknnkdtmrtisyuruikgux1) {
        zrnhtnknnkdtmrtisyuruikgux1 = pZrnhtnknnkdtmrtisyuruikgux1;
    }

    private String zrnhtnknnkdtmrtisyuruikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKDTMRTISYURUIKGUX2)
    public String getZrnhtnknnkdtmrtisyuruikgux2() {
        return zrnhtnknnkdtmrtisyuruikgux2;
    }

    public void setZrnhtnknnkdtmrtisyuruikgux2(String pZrnhtnknnkdtmrtisyuruikgux2) {
        zrnhtnknnkdtmrtisyuruikgux2 = pZrnhtnknnkdtmrtisyuruikgux2;
    }

    private String zrnhtnknnkdtmrtisyuruikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKDTMRTISYURUIKGUX3)
    public String getZrnhtnknnkdtmrtisyuruikgux3() {
        return zrnhtnknnkdtmrtisyuruikgux3;
    }

    public void setZrnhtnknnkdtmrtisyuruikgux3(String pZrnhtnknnkdtmrtisyuruikgux3) {
        zrnhtnknnkdtmrtisyuruikgux3 = pZrnhtnknnkdtmrtisyuruikgux3;
    }

    private String zrnhtnknnkdtmrtisyuruikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKDTMRTISYURUIKGUX4)
    public String getZrnhtnknnkdtmrtisyuruikgux4() {
        return zrnhtnknnkdtmrtisyuruikgux4;
    }

    public void setZrnhtnknnkdtmrtisyuruikgux4(String pZrnhtnknnkdtmrtisyuruikgux4) {
        zrnhtnknnkdtmrtisyuruikgux4 = pZrnhtnknnkdtmrtisyuruikgux4;
    }

    private String zrnhtnknnkdtmrtisyuruikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKDTMRTISYURUIKGUX5)
    public String getZrnhtnknnkdtmrtisyuruikgux5() {
        return zrnhtnknnkdtmrtisyuruikgux5;
    }

    public void setZrnhtnknnkdtmrtisyuruikgux5(String pZrnhtnknnkdtmrtisyuruikgux5) {
        zrnhtnknnkdtmrtisyuruikgux5 = pZrnhtnknnkdtmrtisyuruikgux5;
    }

    private String zrnhtnknnkdtmrtisyuruikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKDTMRTISYURUIKGUX6)
    public String getZrnhtnknnkdtmrtisyuruikgux6() {
        return zrnhtnknnkdtmrtisyuruikgux6;
    }

    public void setZrnhtnknnkdtmrtisyuruikgux6(String pZrnhtnknnkdtmrtisyuruikgux6) {
        zrnhtnknnkdtmrtisyuruikgux6 = pZrnhtnknnkdtmrtisyuruikgux6;
    }

    private String zrnnkdatemaruteishrkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEISHRKKN)
    public String getZrnnkdatemaruteishrkkn() {
        return zrnnkdatemaruteishrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdatemaruteishrkkn(String pZrnnkdatemaruteishrkkn) {
        zrnnkdatemaruteishrkkn = pZrnnkdatemaruteishrkkn;
    }

    private String zrnsuriyounkdtmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURIYOUNKDTMRTIPWRBKKBN)
    public String getZrnsuriyounkdtmrtipwrbkkbn() {
        return zrnsuriyounkdtmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuriyounkdtmrtipwrbkkbn(String pZrnsuriyounkdtmrtipwrbkkbn) {
        zrnsuriyounkdtmrtipwrbkkbn = pZrnsuriyounkdtmrtipwrbkkbn;
    }

    private String zrnnkdatemaruteipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATEMARUTEIPWRBKKBN)
    public String getZrnnkdatemaruteipwrbkkbn() {
        return zrnnkdatemaruteipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdatemaruteipwrbkkbn(String pZrnnkdatemaruteipwrbkkbn) {
        zrnnkdatemaruteipwrbkkbn = pZrnnkdatemaruteipwrbkkbn;
    }

    private String zrnhtnknkyksiteimhyjx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKSITEIMHYJX1)
    public String getZrnhtnknkyksiteimhyjx1() {
        return zrnhtnknkyksiteimhyjx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkyksiteimhyjx1(String pZrnhtnknkyksiteimhyjx1) {
        zrnhtnknkyksiteimhyjx1 = pZrnhtnknkyksiteimhyjx1;
    }

    private String zrnhtnknkyksiteimhyjx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKSITEIMHYJX2)
    public String getZrnhtnknkyksiteimhyjx2() {
        return zrnhtnknkyksiteimhyjx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkyksiteimhyjx2(String pZrnhtnknkyksiteimhyjx2) {
        zrnhtnknkyksiteimhyjx2 = pZrnhtnknkyksiteimhyjx2;
    }

    private String zrnhtnknkyksiteimhyjx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKSITEIMHYJX3)
    public String getZrnhtnknkyksiteimhyjx3() {
        return zrnhtnknkyksiteimhyjx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkyksiteimhyjx3(String pZrnhtnknkyksiteimhyjx3) {
        zrnhtnknkyksiteimhyjx3 = pZrnhtnknkyksiteimhyjx3;
    }

    private String zrnhtnknkyksiteimhyjx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKSITEIMHYJX4)
    public String getZrnhtnknkyksiteimhyjx4() {
        return zrnhtnknkyksiteimhyjx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkyksiteimhyjx4(String pZrnhtnknkyksiteimhyjx4) {
        zrnhtnknkyksiteimhyjx4 = pZrnhtnknkyksiteimhyjx4;
    }

    private String zrnhtnknkyksiteimhyjx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKSITEIMHYJX5)
    public String getZrnhtnknkyksiteimhyjx5() {
        return zrnhtnknkyksiteimhyjx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkyksiteimhyjx5(String pZrnhtnknkyksiteimhyjx5) {
        zrnhtnknkyksiteimhyjx5 = pZrnhtnknkyksiteimhyjx5;
    }

    private String zrnhtnknkyksiteimhyjx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKSITEIMHYJX6)
    public String getZrnhtnknkyksiteimhyjx6() {
        return zrnhtnknkyksiteimhyjx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkyksiteimhyjx6(String pZrnhtnknkyksiteimhyjx6) {
        zrnhtnknkyksiteimhyjx6 = pZrnhtnknkyksiteimhyjx6;
    }

    private String zrntyohkreinyutkbttrtkhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOHKREINYUTKBTTRTKHYJ)
    public String getZrntyohkreinyutkbttrtkhyj() {
        return zrntyohkreinyutkbttrtkhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntyohkreinyutkbttrtkhyj(String pZrntyohkreinyutkbttrtkhyj) {
        zrntyohkreinyutkbttrtkhyj = pZrntyohkreinyutkbttrtkhyj;
    }

    private Long zrnkazokumrtinknengk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAZOKUMRTINKNENGK)
    public Long getZrnkazokumrtinknengk() {
        return zrnkazokumrtinknengk;
    }

    public void setZrnkazokumrtinknengk(Long pZrnkazokumrtinknengk) {
        zrnkazokumrtinknengk = pZrnkazokumrtinknengk;
    }

    private String zrnalmyoukijyunym;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNALMYOUKIJYUNYM)
    public String getZrnalmyoukijyunym() {
        return zrnalmyoukijyunym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnalmyoukijyunym(String pZrnalmyoukijyunym) {
        zrnalmyoukijyunym = pZrnalmyoukijyunym;
    }

    private String zrnsetaitesyono2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESYONO2)
    public String getZrnsetaitesyono2() {
        return zrnsetaitesyono2;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnsetaitesyono2(String pZrnsetaitesyono2) {
        zrnsetaitesyono2 = pZrnsetaitesyono2;
    }

    private String zrnsetaitehokensyuruikigou2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITEHOKENSYURUIKIGOU2)
    public String getZrnsetaitehokensyuruikigou2() {
        return zrnsetaitehokensyuruikigou2;
    }

    public void setZrnsetaitehokensyuruikigou2(String pZrnsetaitehokensyuruikigou2) {
        zrnsetaitehokensyuruikigou2 = pZrnsetaitehokensyuruikigou2;
    }

    private String zrnsetaitemrtisyuruikgu2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITEMRTISYURUIKGU2)
    public String getZrnsetaitemrtisyuruikgu2() {
        return zrnsetaitemrtisyuruikgu2;
    }

    public void setZrnsetaitemrtisyuruikgu2(String pZrnsetaitemrtisyuruikgu2) {
        zrnsetaitemrtisyuruikgu2 = pZrnsetaitemrtisyuruikgu2;
    }

    private String zrnsetaitesiznmrtisyurui2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESIZNMRTISYURUI2)
    public String getZrnsetaitesiznmrtisyurui2() {
        return zrnsetaitesiznmrtisyurui2;
    }

    public void setZrnsetaitesiznmrtisyurui2(String pZrnsetaitesiznmrtisyurui2) {
        zrnsetaitesiznmrtisyurui2 = pZrnsetaitesiznmrtisyurui2;
    }

    private String zrnsetaitetignmrtisyurui2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITETIGNMRTISYURUI2)
    public String getZrnsetaitetignmrtisyurui2() {
        return zrnsetaitetignmrtisyurui2;
    }

    public void setZrnsetaitetignmrtisyurui2(String pZrnsetaitetignmrtisyurui2) {
        zrnsetaitetignmrtisyurui2 = pZrnsetaitetignmrtisyurui2;
    }

    private Long zrnsetaitekihonbubuns2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITEKIHONBUBUNS2)
    public Long getZrnsetaitekihonbubuns2() {
        return zrnsetaitekihonbubuns2;
    }

    public void setZrnsetaitekihonbubuns2(Long pZrnsetaitekihonbubuns2) {
        zrnsetaitekihonbubuns2 = pZrnsetaitekihonbubuns2;
    }

    private Long zrnsetgukitnknitjbrkhns2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETGUKITNKNITJBRKHNS2)
    public Long getZrnsetgukitnknitjbrkhns2() {
        return zrnsetgukitnknitjbrkhns2;
    }

    public void setZrnsetgukitnknitjbrkhns2(Long pZrnsetgukitnknitjbrkhns2) {
        zrnsetgukitnknitjbrkhns2 = pZrnsetgukitnknitjbrkhns2;
    }

    private Long zrnsetaitesibous2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESIBOUS2)
    public Long getZrnsetaitesibous2() {
        return zrnsetaitesibous2;
    }

    public void setZrnsetaitesibous2(Long pZrnsetaitesibous2) {
        zrnsetaitesibous2 = pZrnsetaitesibous2;
    }

    private Long zrnsetgukitnknitjbrsbus2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETGUKITNKNITJBRSBUS2)
    public Long getZrnsetgukitnknitjbrsbus2() {
        return zrnsetgukitnknitjbrsbus2;
    }

    public void setZrnsetgukitnknitjbrsbus2(Long pZrnsetgukitnknitjbrsbus2) {
        zrnsetgukitnknitjbrsbus2 = pZrnsetgukitnknitjbrsbus2;
    }

    private Long zrnsetaitesyuuseis2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESYUUSEIS2)
    public Long getZrnsetaitesyuuseis2() {
        return zrnsetaitesyuuseis2;
    }

    public void setZrnsetaitesyuuseis2(Long pZrnsetaitesyuuseis2) {
        zrnsetaitesyuuseis2 = pZrnsetaitesyuuseis2;
    }

    private Long zrnsetaiteharaikomip2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITEHARAIKOMIP2)
    public Long getZrnsetaiteharaikomip2() {
        return zrnsetaiteharaikomip2;
    }

    public void setZrnsetaiteharaikomip2(Long pZrnsetaiteharaikomip2) {
        zrnsetaiteharaikomip2 = pZrnsetaiteharaikomip2;
    }

    private Long zrnsetaitesyukeiyakububunp2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESYUKEIYAKUBUBUNP2)
    public Long getZrnsetaitesyukeiyakububunp2() {
        return zrnsetaitesyukeiyakububunp2;
    }

    public void setZrnsetaitesyukeiyakububunp2(Long pZrnsetaitesyukeiyakububunp2) {
        zrnsetaitesyukeiyakububunp2 = pZrnsetaitesyukeiyakububunp2;
    }

    private Long zrnsetaitgukikzkmrtis2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITGUKIKZKMRTIS2)
    public Long getZrnsetaitgukikzkmrtis2() {
        return zrnsetaitgukikzkmrtis2;
    }

    public void setZrnsetaitgukikzkmrtis2(Long pZrnsetaitgukikzkmrtis2) {
        zrnsetaitgukikzkmrtis2 = pZrnsetaitgukikzkmrtis2;
    }

    private String zrnsetaitetenkankykhyj2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITETENKANKYKHYJ2)
    public String getZrnsetaitetenkankykhyj2() {
        return zrnsetaitetenkankykhyj2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitetenkankykhyj2(String pZrnsetaitetenkankykhyj2) {
        zrnsetaitetenkankykhyj2 = pZrnsetaitetenkankykhyj2;
    }

    private Long zrnsetaitesiteimhrkp2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESITEIMHRKP2)
    public Long getZrnsetaitesiteimhrkp2() {
        return zrnsetaitesiteimhrkp2;
    }

    public void setZrnsetaitesiteimhrkp2(Long pZrnsetaitesiteimhrkp2) {
        zrnsetaitesiteimhrkp2 = pZrnsetaitesiteimhrkp2;
    }

    private Long zrnsetaitesiteimsykykp2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITESITEIMSYKYKP2)
    public Long getZrnsetaitesiteimsykykp2() {
        return zrnsetaitesiteimsykykp2;
    }

    public void setZrnsetaitesiteimsykykp2(Long pZrnsetaitesiteimsykykp2) {
        zrnsetaitesiteimsykykp2 = pZrnsetaitesiteimsykykp2;
    }

    private String zrnsetaitenkmrtisyurui2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITENKMRTISYURUI2)
    public String getZrnsetaitenkmrtisyurui2() {
        return zrnsetaitenkmrtisyurui2;
    }

    public void setZrnsetaitenkmrtisyurui2(String pZrnsetaitenkmrtisyurui2) {
        zrnsetaitenkmrtisyurui2 = pZrnsetaitenkmrtisyurui2;
    }

    private String zrnsetaitehknkgusdkbn2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSETAITEHKNKGUSDKBN2)
    public String getZrnsetaitehknkgusdkbn2() {
        return zrnsetaitehknkgusdkbn2;
    }

    public void setZrnsetaitehknkgusdkbn2(String pZrnsetaitehknkgusdkbn2) {
        zrnsetaitehknkgusdkbn2 = pZrnsetaitehknkgusdkbn2;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrndujmossitismodsyuguhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDUJMOSSITISMODSYUGUHYJ)
    public String getZrndujmossitismodsyuguhyj() {
        return zrndujmossitismodsyuguhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndujmossitismodsyuguhyj(String pZrndujmossitismodsyuguhyj) {
        zrndujmossitismodsyuguhyj = pZrndujmossitismodsyuguhyj;
    }

    private String zrnrnsijhiyubrijdujmoskbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNRNSIJHIYUBRIJDUJMOSKBN)
    public String getZrnrnsijhiyubrijdujmoskbn() {
        return zrnrnsijhiyubrijdujmoskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrnsijhiyubrijdujmoskbn(String pZrnrnsijhiyubrijdujmoskbn) {
        zrnrnsijhiyubrijdujmoskbn = pZrnrnsijhiyubrijdujmoskbn;
    }

    private Long zrntktsppisykyktikknbbns;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKTSPPISYKYKTIKKNBBNS)
    public Long getZrntktsppisykyktikknbbns() {
        return zrntktsppisykyktikknbbns;
    }

    public void setZrntktsppisykyktikknbbns(Long pZrntktsppisykyktikknbbns) {
        zrntktsppisykyktikknbbns = pZrntktsppisykyktikknbbns;
    }

    private String zrntksttkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKSYURUIKGU)
    public String getZrntksttkyksyuruikgu() {
        return zrntksttkyksyuruikgu;
    }

    public void setZrntksttkyksyuruikgu(String pZrntksttkyksyuruikgu) {
        zrntksttkyksyuruikgu = pZrntksttkyksyuruikgu;
    }

    private String zrntokusitutokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOKUSITUTOKUYAKUKIKAN)
    public String getZrntokusitutokuyakukikan() {
        return zrntokusitutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokusitutokuyakukikan(String pZrntokusitutokuyakukikan) {
        zrntokusitutokuyakukikan = pZrntokusitutokuyakukikan;
    }

    private String zrntksttkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKPHRKKKN)
    public String getZrntksttkykphrkkkn() {
        return zrntksttkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntksttkykphrkkkn(String pZrntksttkykphrkkkn) {
        zrntksttkykphrkkkn = pZrntksttkykphrkkkn;
    }

    private Long zrntokusitutokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOKUSITUTOKUYAKUS)
    public Long getZrntokusitutokuyakus() {
        return zrntokusitutokuyakus;
    }

    public void setZrntokusitutokuyakus(Long pZrntokusitutokuyakus) {
        zrntokusitutokuyakus = pZrntokusitutokuyakus;
    }

    private Long zrntokusitutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOKUSITUTOKUYAKUP)
    public Long getZrntokusitutokuyakup() {
        return zrntokusitutokuyakup;
    }

    public void setZrntokusitutokuyakup(Long pZrntokusitutokuyakup) {
        zrntokusitutokuyakup = pZrntokusitutokuyakup;
    }

    private Long zrntokusitutokuyakusyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOKUSITUTOKUYAKUSYUUSEIS)
    public Long getZrntokusitutokuyakusyuuseis() {
        return zrntokusitutokuyakusyuuseis;
    }

    public void setZrntokusitutokuyakusyuuseis(Long pZrntokusitutokuyakusyuuseis) {
        zrntokusitutokuyakusyuuseis = pZrntokusitutokuyakusyuuseis;
    }

    private String zrntksttkykmodssakugenhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKMODSSAKUGENHYJ)
    public String getZrntksttkykmodssakugenhyj() {
        return zrntksttkykmodssakugenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkykmodssakugenhyj(String pZrntksttkykmodssakugenhyj) {
        zrntksttkykmodssakugenhyj = pZrntksttkykmodssakugenhyj;
    }

    private String zrntksttkyktkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKTKJYUKBN)
    public String getZrntksttkyktkjyukbn() {
        return zrntksttkyktkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntksttkyktkjyukbn(String pZrntksttkyktkjyukbn) {
        zrntksttkyktkjyukbn = pZrntksttkyktkjyukbn;
    }

    private String zrntksttkyktkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKTKJYUSKGNKKN)
    public String getZrntksttkyktkjyuskgnkkn() {
        return zrntksttkyktkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntksttkyktkjyuskgnkkn(String pZrntksttkyktkjyuskgnkkn) {
        zrntksttkyktkjyuskgnkkn = pZrntksttkyktkjyuskgnkkn;
    }

    private Integer zrntksttkyktkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKTKJYURYUMSHYUTN)
    public Integer getZrntksttkyktkjyuryumshyutn() {
        return zrntksttkyktkjyuryumshyutn;
    }

    public void setZrntksttkyktkjyuryumshyutn(Integer pZrntksttkyktkjyuryumshyutn) {
        zrntksttkyktkjyuryumshyutn = pZrntksttkyktkjyuryumshyutn;
    }

    private Long zrntksttkyktkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKTKJYUP)
    public Long getZrntksttkyktkjyup() {
        return zrntksttkyktkjyup;
    }

    public void setZrntksttkyktkjyup(Long pZrntksttkyktkjyup) {
        zrntksttkyktkjyup = pZrntksttkyktkjyup;
    }

    private Long zrntksttkyktikknbbns;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKTIKKNBBNS)
    public Long getZrntksttkyktikknbbns() {
        return zrntksttkyktikknbbns;
    }

    public void setZrntksttkyktikknbbns(Long pZrntksttkyktikknbbns) {
        zrntksttkyktikknbbns = pZrntksttkyktikknbbns;
    }

    private String zrnhtnkntktsppitkykkgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKTSPPITKYKKGUX1)
    public String getZrnhtnkntktsppitkykkgux1() {
        return zrnhtnkntktsppitkykkgux1;
    }

    public void setZrnhtnkntktsppitkykkgux1(String pZrnhtnkntktsppitkykkgux1) {
        zrnhtnkntktsppitkykkgux1 = pZrnhtnkntktsppitkykkgux1;
    }

    private String zrnhtnkntktsppitkykkgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKTSPPITKYKKGUX2)
    public String getZrnhtnkntktsppitkykkgux2() {
        return zrnhtnkntktsppitkykkgux2;
    }

    public void setZrnhtnkntktsppitkykkgux2(String pZrnhtnkntktsppitkykkgux2) {
        zrnhtnkntktsppitkykkgux2 = pZrnhtnkntktsppitkykkgux2;
    }

    private String zrnhtnkntktsppitkykkgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKTSPPITKYKKGUX3)
    public String getZrnhtnkntktsppitkykkgux3() {
        return zrnhtnkntktsppitkykkgux3;
    }

    public void setZrnhtnkntktsppitkykkgux3(String pZrnhtnkntktsppitkykkgux3) {
        zrnhtnkntktsppitkykkgux3 = pZrnhtnkntktsppitkykkgux3;
    }

    private String zrnhtnkntktsppitkykkgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKTSPPITKYKKGUX4)
    public String getZrnhtnkntktsppitkykkgux4() {
        return zrnhtnkntktsppitkykkgux4;
    }

    public void setZrnhtnkntktsppitkykkgux4(String pZrnhtnkntktsppitkykkgux4) {
        zrnhtnkntktsppitkykkgux4 = pZrnhtnkntktsppitkykkgux4;
    }

    private String zrnhtnkntktsppitkykkgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKTSPPITKYKKGUX5)
    public String getZrnhtnkntktsppitkykkgux5() {
        return zrnhtnkntktsppitkykkgux5;
    }

    public void setZrnhtnkntktsppitkykkgux5(String pZrnhtnkntktsppitkykkgux5) {
        zrnhtnkntktsppitkykkgux5 = pZrnhtnkntktsppitkykkgux5;
    }

    private String zrnhtnkntktsppitkykkgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKTSPPITKYKKGUX6)
    public String getZrnhtnkntktsppitkykkgux6() {
        return zrnhtnkntktsppitkykkgux6;
    }

    public void setZrnhtnkntktsppitkykkgux6(String pZrnhtnkntktsppitkykkgux6) {
        zrnhtnkntktsppitkykkgux6 = pZrnhtnkntktsppitkykkgux6;
    }

    private String zrnsuryutksttkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURYUTKSTTKYKPWRBKKBN)
    public String getZrnsuryutksttkykpwrbkkbn() {
        return zrnsuryutksttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryutksttkykpwrbkkbn(String pZrnsuryutksttkykpwrbkkbn) {
        zrnsuryutksttkykpwrbkkbn = pZrnsuryutksttkykpwrbkkbn;
    }

    private String zrntksttkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKPWRBKKBN)
    public String getZrntksttkykpwrbkkbn() {
        return zrntksttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntksttkykpwrbkkbn(String pZrntksttkykpwrbkkbn) {
        zrntksttkykpwrbkkbn = pZrntksttkykpwrbkkbn;
    }

    private String zrntksttkyktnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKTNKNYUGUKBN)
    public String getZrntksttkyktnknyugukbn() {
        return zrntksttkyktnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntksttkyktnknyugukbn(String pZrntksttkyktnknyugukbn) {
        zrntksttkyktnknyugukbn = pZrntksttkyktnknyugukbn;
    }

    private String zrntksttkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTKSTTKYKKGUSDKBN)
    public String getZrntksttkykkgusdkbn() {
        return zrntksttkykkgusdkbn;
    }

    public void setZrntksttkykkgusdkbn(String pZrntksttkykkgusdkbn) {
        zrntksttkykkgusdkbn = pZrntksttkykkgusdkbn;
    }

    private String zrnyobiv9x8;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV9X8)
    public String getZrnyobiv9x8() {
        return zrnyobiv9x8;
    }

    public void setZrnyobiv9x8(String pZrnyobiv9x8) {
        zrnyobiv9x8 = pZrnyobiv9x8;
    }

    private String zrndi2tksttkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKSYRIKGU)
    public String getZrndi2tksttkyksyrikgu() {
        return zrndi2tksttkyksyrikgu;
    }

    public void setZrndi2tksttkyksyrikgu(String pZrndi2tksttkyksyrikgu) {
        zrndi2tksttkyksyrikgu = pZrndi2tksttkyksyrikgu;
    }

    private String zrndai2tokusitutokuyakukkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TOKUSITUTOKUYAKUKKN)
    public String getZrndai2tokusitutokuyakukkn() {
        return zrndai2tokusitutokuyakukkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tokusitutokuyakukkn(String pZrndai2tokusitutokuyakukkn) {
        zrndai2tokusitutokuyakukkn = pZrndai2tokusitutokuyakukkn;
    }

    private String zrndai2tksttkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TKSTTKYKPHRKKKN)
    public String getZrndai2tksttkykphrkkkn() {
        return zrndai2tksttkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2tksttkykphrkkkn(String pZrndai2tksttkykphrkkkn) {
        zrndai2tksttkykphrkkkn = pZrndai2tksttkykphrkkkn;
    }

    private Long zrndai2tokusitutokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TOKUSITUTOKUYAKUS)
    public Long getZrndai2tokusitutokuyakus() {
        return zrndai2tokusitutokuyakus;
    }

    public void setZrndai2tokusitutokuyakus(Long pZrndai2tokusitutokuyakus) {
        zrndai2tokusitutokuyakus = pZrndai2tokusitutokuyakus;
    }

    private Long zrndai2tokusitutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TOKUSITUTOKUYAKUP)
    public Long getZrndai2tokusitutokuyakup() {
        return zrndai2tokusitutokuyakup;
    }

    public void setZrndai2tokusitutokuyakup(Long pZrndai2tokusitutokuyakup) {
        zrndai2tokusitutokuyakup = pZrndai2tokusitutokuyakup;
    }

    private Long zrndi2tksttkyksyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKSYUUSEIS)
    public Long getZrndi2tksttkyksyuuseis() {
        return zrndi2tksttkyksyuuseis;
    }

    public void setZrndi2tksttkyksyuuseis(Long pZrndi2tksttkyksyuuseis) {
        zrndi2tksttkyksyuuseis = pZrndi2tksttkyksyuuseis;
    }

    private String zrndi2tksttkykmodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKMODSSKGNHYJ)
    public String getZrndi2tksttkykmodsskgnhyj() {
        return zrndi2tksttkykmodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkykmodsskgnhyj(String pZrndi2tksttkykmodsskgnhyj) {
        zrndi2tksttkykmodsskgnhyj = pZrndi2tksttkykmodsskgnhyj;
    }

    private String zrndi2tksttkyktkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKTKJYUKBN)
    public String getZrndi2tksttkyktkjyukbn() {
        return zrndi2tksttkyktkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2tksttkyktkjyukbn(String pZrndi2tksttkyktkjyukbn) {
        zrndi2tksttkyktkjyukbn = pZrndi2tksttkyktkjyukbn;
    }

    private String zrndi2tksttkyktkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKTKJYUSKGNKKN)
    public String getZrndi2tksttkyktkjyuskgnkkn() {
        return zrndi2tksttkyktkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2tksttkyktkjyuskgnkkn(String pZrndi2tksttkyktkjyuskgnkkn) {
        zrndi2tksttkyktkjyuskgnkkn = pZrndi2tksttkyktkjyuskgnkkn;
    }

    private Integer zrndi2tksttkyktkjyurymshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKTKJYURYMSHYTN)
    public Integer getZrndi2tksttkyktkjyurymshytn() {
        return zrndi2tksttkyktkjyurymshytn;
    }

    public void setZrndi2tksttkyktkjyurymshytn(Integer pZrndi2tksttkyktkjyurymshytn) {
        zrndi2tksttkyktkjyurymshytn = pZrndi2tksttkyktkjyurymshytn;
    }

    private Long zrndi2tksttkyktkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKTKJYUP)
    public Long getZrndi2tksttkyktkjyup() {
        return zrndi2tksttkyktkjyup;
    }

    public void setZrndi2tksttkyktkjyup(Long pZrndi2tksttkyktkjyup) {
        zrndi2tksttkyktkjyup = pZrndi2tksttkyktkjyup;
    }

    private Long zrndi2tksttkyktaikknbbns;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKTAIKKNBBNS)
    public Long getZrndi2tksttkyktaikknbbns() {
        return zrndi2tksttkyktaikknbbns;
    }

    public void setZrndi2tksttkyktaikknbbns(Long pZrndi2tksttkyktaikknbbns) {
        zrndi2tksttkyktaikknbbns = pZrndi2tksttkyktaikknbbns;
    }

    private String zrnhtnkndi2tktsppitkykkgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKTSPPITKYKKGUX1)
    public String getZrnhtnkndi2tktsppitkykkgux1() {
        return zrnhtnkndi2tktsppitkykkgux1;
    }

    public void setZrnhtnkndi2tktsppitkykkgux1(String pZrnhtnkndi2tktsppitkykkgux1) {
        zrnhtnkndi2tktsppitkykkgux1 = pZrnhtnkndi2tktsppitkykkgux1;
    }

    private String zrnhtnkndi2tktsppitkykkgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKTSPPITKYKKGUX2)
    public String getZrnhtnkndi2tktsppitkykkgux2() {
        return zrnhtnkndi2tktsppitkykkgux2;
    }

    public void setZrnhtnkndi2tktsppitkykkgux2(String pZrnhtnkndi2tktsppitkykkgux2) {
        zrnhtnkndi2tktsppitkykkgux2 = pZrnhtnkndi2tktsppitkykkgux2;
    }

    private String zrnhtnkndi2tktsppitkykkgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKTSPPITKYKKGUX3)
    public String getZrnhtnkndi2tktsppitkykkgux3() {
        return zrnhtnkndi2tktsppitkykkgux3;
    }

    public void setZrnhtnkndi2tktsppitkykkgux3(String pZrnhtnkndi2tktsppitkykkgux3) {
        zrnhtnkndi2tktsppitkykkgux3 = pZrnhtnkndi2tktsppitkykkgux3;
    }

    private String zrnhtnkndi2tktsppitkykkgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKTSPPITKYKKGUX4)
    public String getZrnhtnkndi2tktsppitkykkgux4() {
        return zrnhtnkndi2tktsppitkykkgux4;
    }

    public void setZrnhtnkndi2tktsppitkykkgux4(String pZrnhtnkndi2tktsppitkykkgux4) {
        zrnhtnkndi2tktsppitkykkgux4 = pZrnhtnkndi2tktsppitkykkgux4;
    }

    private String zrnhtnkndi2tktsppitkykkgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKTSPPITKYKKGUX5)
    public String getZrnhtnkndi2tktsppitkykkgux5() {
        return zrnhtnkndi2tktsppitkykkgux5;
    }

    public void setZrnhtnkndi2tktsppitkykkgux5(String pZrnhtnkndi2tktsppitkykkgux5) {
        zrnhtnkndi2tktsppitkykkgux5 = pZrnhtnkndi2tktsppitkykkgux5;
    }

    private String zrnhtnkndi2tktsppitkykkgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKTSPPITKYKKGUX6)
    public String getZrnhtnkndi2tktsppitkykkgux6() {
        return zrnhtnkndi2tktsppitkykkgux6;
    }

    public void setZrnhtnkndi2tktsppitkykkgux6(String pZrnhtnkndi2tktsppitkykkgux6) {
        zrnhtnkndi2tktsppitkykkgux6 = pZrnhtnkndi2tktsppitkykkgux6;
    }

    private String zrnsuryudi2tksttkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURYUDI2TKSTTKYKPWRBKKBN)
    public String getZrnsuryudi2tksttkykpwrbkkbn() {
        return zrnsuryudi2tksttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryudi2tksttkykpwrbkkbn(String pZrnsuryudi2tksttkykpwrbkkbn) {
        zrnsuryudi2tksttkykpwrbkkbn = pZrnsuryudi2tksttkykpwrbkkbn;
    }

    private String zrndi2tksttkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKPWRBKKBN)
    public String getZrndi2tksttkykpwrbkkbn() {
        return zrndi2tksttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2tksttkykpwrbkkbn(String pZrndi2tksttkykpwrbkkbn) {
        zrndi2tksttkykpwrbkkbn = pZrndi2tksttkykpwrbkkbn;
    }

    private String zrndi2tksttkyktnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKTNKNYUGUKBN)
    public String getZrndi2tksttkyktnknyugukbn() {
        return zrndi2tksttkyktnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2tksttkyktnknyugukbn(String pZrndi2tksttkyktnknyugukbn) {
        zrndi2tksttkyktnknyugukbn = pZrndi2tksttkyktnknyugukbn;
    }

    private String zrndi2tksttkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2TKSTTKYKKGUSDKBN)
    public String getZrndi2tksttkykkgusdkbn() {
        return zrndi2tksttkykkgusdkbn;
    }

    public void setZrndi2tksttkykkgusdkbn(String pZrndi2tksttkykkgusdkbn) {
        zrndi2tksttkykkgusdkbn = pZrndi2tksttkykkgusdkbn;
    }

    private String zrnyobiv9x9;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV9X9)
    public String getZrnyobiv9x9() {
        return zrnyobiv9x9;
    }

    public void setZrnyobiv9x9(String pZrnyobiv9x9) {
        zrnyobiv9x9 = pZrnyobiv9x9;
    }

    private String zrnjyuusitutkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKSYURUIKGU)
    public String getZrnjyuusitutkyksyuruikgu() {
        return zrnjyuusitutkyksyuruikgu;
    }

    public void setZrnjyuusitutkyksyuruikgu(String pZrnjyuusitutkyksyuruikgu) {
        zrnjyuusitutkyksyuruikgu = pZrnjyuusitutkyksyuruikgu;
    }

    private String zrnjyuusitutokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTOKUYAKUKIKAN)
    public String getZrnjyuusitutokuyakukikan() {
        return zrnjyuusitutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutokuyakukikan(String pZrnjyuusitutokuyakukikan) {
        zrnjyuusitutokuyakukikan = pZrnjyuusitutokuyakukikan;
    }

    private String zrnjyuusitutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKPHRKKKN)
    public String getZrnjyuusitutkykphrkkkn() {
        return zrnjyuusitutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkykphrkkkn(String pZrnjyuusitutkykphrkkkn) {
        zrnjyuusitutkykphrkkkn = pZrnjyuusitutkykphrkkkn;
    }

    private Long zrnjyuusitutokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTOKUYAKUS)
    public Long getZrnjyuusitutokuyakus() {
        return zrnjyuusitutokuyakus;
    }

    public void setZrnjyuusitutokuyakus(Long pZrnjyuusitutokuyakus) {
        zrnjyuusitutokuyakus = pZrnjyuusitutokuyakus;
    }

    private Long zrnjyuusitutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTOKUYAKUP)
    public Long getZrnjyuusitutokuyakup() {
        return zrnjyuusitutokuyakup;
    }

    public void setZrnjyuusitutokuyakup(Long pZrnjyuusitutokuyakup) {
        zrnjyuusitutokuyakup = pZrnjyuusitutokuyakup;
    }

    private Long zrnjyuusitutokuyakusyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTOKUYAKUSYUUSEIS)
    public Long getZrnjyuusitutokuyakusyuuseis() {
        return zrnjyuusitutokuyakusyuuseis;
    }

    public void setZrnjyuusitutokuyakusyuuseis(Long pZrnjyuusitutokuyakusyuuseis) {
        zrnjyuusitutokuyakusyuuseis = pZrnjyuusitutokuyakusyuuseis;
    }

    private String zrnjyuusitutkykmodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKMODSSKGNHYJ)
    public String getZrnjyuusitutkykmodsskgnhyj() {
        return zrnjyuusitutkykmodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyuusitutkykmodsskgnhyj(String pZrnjyuusitutkykmodsskgnhyj) {
        zrnjyuusitutkykmodsskgnhyj = pZrnjyuusitutkykmodsskgnhyj;
    }

    private String zrnjyuusitutkyktkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKTKJYUKBN)
    public String getZrnjyuusitutkyktkjyukbn() {
        return zrnjyuusitutkyktkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyuusitutkyktkjyukbn(String pZrnjyuusitutkyktkjyukbn) {
        zrnjyuusitutkyktkjyukbn = pZrnjyuusitutkyktkjyukbn;
    }

    private String zrnjyuusitutkyktkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKTKJYUSKGNKKN)
    public String getZrnjyuusitutkyktkjyuskgnkkn() {
        return zrnjyuusitutkyktkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkyktkjyuskgnkkn(String pZrnjyuusitutkyktkjyuskgnkkn) {
        zrnjyuusitutkyktkjyuskgnkkn = pZrnjyuusitutkyktkjyuskgnkkn;
    }

    private Integer zrnjyusttkyktkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUSTTKYKTKJYURYUMSHYUTN)
    public Integer getZrnjyusttkyktkjyuryumshyutn() {
        return zrnjyusttkyktkjyuryumshyutn;
    }

    public void setZrnjyusttkyktkjyuryumshyutn(Integer pZrnjyusttkyktkjyuryumshyutn) {
        zrnjyusttkyktkjyuryumshyutn = pZrnjyusttkyktkjyuryumshyutn;
    }

    private Long zrnjyuusitutkyktkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKTKJYUP)
    public Long getZrnjyuusitutkyktkjyup() {
        return zrnjyuusitutkyktkjyup;
    }

    public void setZrnjyuusitutkyktkjyup(Long pZrnjyuusitutkyktkjyup) {
        zrnjyuusitutkyktkjyup = pZrnjyuusitutkyktkjyup;
    }

    private String zrnjyuusitutkyktktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKTKTBICDX1)
    public String getZrnjyuusitutkyktktbicdx1() {
        return zrnjyuusitutkyktktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkyktktbicdx1(String pZrnjyuusitutkyktktbicdx1) {
        zrnjyuusitutkyktktbicdx1 = pZrnjyuusitutkyktktbicdx1;
    }

    private String zrnjyuusitutkykhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKHTNPKKNX1)
    public String getZrnjyuusitutkykhtnpkknx1() {
        return zrnjyuusitutkykhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkykhtnpkknx1(String pZrnjyuusitutkykhtnpkknx1) {
        zrnjyuusitutkykhtnpkknx1 = pZrnjyuusitutkykhtnpkknx1;
    }

    private String zrnjyuusitutkyktktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKTKTBICDX2)
    public String getZrnjyuusitutkyktktbicdx2() {
        return zrnjyuusitutkyktktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkyktktbicdx2(String pZrnjyuusitutkyktktbicdx2) {
        zrnjyuusitutkyktktbicdx2 = pZrnjyuusitutkyktktbicdx2;
    }

    private String zrnjyuusitutkykhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKHTNPKKNX2)
    public String getZrnjyuusitutkykhtnpkknx2() {
        return zrnjyuusitutkykhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkykhtnpkknx2(String pZrnjyuusitutkykhtnpkknx2) {
        zrnjyuusitutkykhtnpkknx2 = pZrnjyuusitutkykhtnpkknx2;
    }

    private String zrnhtnknmnsiskkntkykkgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMNSISKKNTKYKKGUX1)
    public String getZrnhtnknmnsiskkntkykkgux1() {
        return zrnhtnknmnsiskkntkykkgux1;
    }

    public void setZrnhtnknmnsiskkntkykkgux1(String pZrnhtnknmnsiskkntkykkgux1) {
        zrnhtnknmnsiskkntkykkgux1 = pZrnhtnknmnsiskkntkykkgux1;
    }

    private String zrnhtnknmnsiskkntkykkgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMNSISKKNTKYKKGUX2)
    public String getZrnhtnknmnsiskkntkykkgux2() {
        return zrnhtnknmnsiskkntkykkgux2;
    }

    public void setZrnhtnknmnsiskkntkykkgux2(String pZrnhtnknmnsiskkntkykkgux2) {
        zrnhtnknmnsiskkntkykkgux2 = pZrnhtnknmnsiskkntkykkgux2;
    }

    private String zrnhtnknmnsiskkntkykkgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMNSISKKNTKYKKGUX3)
    public String getZrnhtnknmnsiskkntkykkgux3() {
        return zrnhtnknmnsiskkntkykkgux3;
    }

    public void setZrnhtnknmnsiskkntkykkgux3(String pZrnhtnknmnsiskkntkykkgux3) {
        zrnhtnknmnsiskkntkykkgux3 = pZrnhtnknmnsiskkntkykkgux3;
    }

    private String zrnhtnknmnsiskkntkykkgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMNSISKKNTKYKKGUX4)
    public String getZrnhtnknmnsiskkntkykkgux4() {
        return zrnhtnknmnsiskkntkykkgux4;
    }

    public void setZrnhtnknmnsiskkntkykkgux4(String pZrnhtnknmnsiskkntkykkgux4) {
        zrnhtnknmnsiskkntkykkgux4 = pZrnhtnknmnsiskkntkykkgux4;
    }

    private String zrnhtnknmnsiskkntkykkgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMNSISKKNTKYKKGUX5)
    public String getZrnhtnknmnsiskkntkykkgux5() {
        return zrnhtnknmnsiskkntkykkgux5;
    }

    public void setZrnhtnknmnsiskkntkykkgux5(String pZrnhtnknmnsiskkntkykkgux5) {
        zrnhtnknmnsiskkntkykkgux5 = pZrnhtnknmnsiskkntkykkgux5;
    }

    private String zrnhtnknmnsiskkntkykkgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMNSISKKNTKYKKGUX6)
    public String getZrnhtnknmnsiskkntkykkgux6() {
        return zrnhtnknmnsiskkntkykkgux6;
    }

    public void setZrnhtnknmnsiskkntkykkgux6(String pZrnhtnknmnsiskkntkykkgux6) {
        zrnhtnknmnsiskkntkykkgux6 = pZrnhtnknmnsiskkntkykkgux6;
    }

    private String zrnsuryujyusttkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURYUJYUSTTKYKPWRBKKBN)
    public String getZrnsuryujyusttkykpwrbkkbn() {
        return zrnsuryujyusttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryujyusttkykpwrbkkbn(String pZrnsuryujyusttkykpwrbkkbn) {
        zrnsuryujyusttkykpwrbkkbn = pZrnsuryujyusttkykpwrbkkbn;
    }

    private String zrnjyuusitutkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKPWRBKKBN)
    public String getZrnjyuusitutkykpwrbkkbn() {
        return zrnjyuusitutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkykpwrbkkbn(String pZrnjyuusitutkykpwrbkkbn) {
        zrnjyuusitutkykpwrbkkbn = pZrnjyuusitutkykpwrbkkbn;
    }

    private String zrnjyuusitutkyktnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKTNKNYUGUKBN)
    public String getZrnjyuusitutkyktnknyugukbn() {
        return zrnjyuusitutkyktnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuusitutkyktnknyugukbn(String pZrnjyuusitutkyktnknyugukbn) {
        zrnjyuusitutkyktnknyugukbn = pZrnjyuusitutkyktnknyugukbn;
    }

    private String zrnjyuusitutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJYUUSITUTKYKKGUSDKBN)
    public String getZrnjyuusitutkykkgusdkbn() {
        return zrnjyuusitutkykkgusdkbn;
    }

    public void setZrnjyuusitutkykkgusdkbn(String pZrnjyuusitutkykkgusdkbn) {
        zrnjyuusitutkykkgusdkbn = pZrnjyuusitutkykkgusdkbn;
    }

    private String zrnyobiv7x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV7X3)
    public String getZrnyobiv7x3() {
        return zrnyobiv7x3;
    }

    public void setZrnyobiv7x3(String pZrnyobiv7x3) {
        zrnyobiv7x3 = pZrnyobiv7x3;
    }

    private String zrndi2jyuusitutkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKSYRIKGU)
    public String getZrndi2jyuusitutkyksyrikgu() {
        return zrndi2jyuusitutkyksyrikgu;
    }

    public void setZrndi2jyuusitutkyksyrikgu(String pZrndi2jyuusitutkyksyrikgu) {
        zrndi2jyuusitutkyksyrikgu = pZrndi2jyuusitutkyksyrikgu;
    }

    private String zrndi2jyuusitutkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKKKN)
    public String getZrndi2jyuusitutkykkkn() {
        return zrndi2jyuusitutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkykkkn(String pZrndi2jyuusitutkykkkn) {
        zrndi2jyuusitutkykkkn = pZrndi2jyuusitutkykkkn;
    }

    private String zrndi2jyuusitutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKPHRKKKN)
    public String getZrndi2jyuusitutkykphrkkkn() {
        return zrndi2jyuusitutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkykphrkkkn(String pZrndi2jyuusitutkykphrkkkn) {
        zrndi2jyuusitutkykphrkkkn = pZrndi2jyuusitutkykphrkkkn;
    }

    private Long zrndai2jyuusitutokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2JYUUSITUTOKUYAKUS)
    public Long getZrndai2jyuusitutokuyakus() {
        return zrndai2jyuusitutokuyakus;
    }

    public void setZrndai2jyuusitutokuyakus(Long pZrndai2jyuusitutokuyakus) {
        zrndai2jyuusitutokuyakus = pZrndai2jyuusitutokuyakus;
    }

    private Long zrndai2jyuusitutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2JYUUSITUTOKUYAKUP)
    public Long getZrndai2jyuusitutokuyakup() {
        return zrndai2jyuusitutokuyakup;
    }

    public void setZrndai2jyuusitutokuyakup(Long pZrndai2jyuusitutokuyakup) {
        zrndai2jyuusitutokuyakup = pZrndai2jyuusitutokuyakup;
    }

    private Long zrndi2jyuusitutkyksyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKSYUUSEIS)
    public Long getZrndi2jyuusitutkyksyuuseis() {
        return zrndi2jyuusitutkyksyuuseis;
    }

    public void setZrndi2jyuusitutkyksyuuseis(Long pZrndi2jyuusitutkyksyuuseis) {
        zrndi2jyuusitutkyksyuuseis = pZrndi2jyuusitutkyksyuuseis;
    }

    private String zrndi2jyusttkykmodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUSTTKYKMODSSKGNHYJ)
    public String getZrndi2jyusttkykmodsskgnhyj() {
        return zrndi2jyusttkykmodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jyusttkykmodsskgnhyj(String pZrndi2jyusttkykmodsskgnhyj) {
        zrndi2jyusttkykmodsskgnhyj = pZrndi2jyusttkykmodsskgnhyj;
    }

    private String zrndi2jyuusitutkyktkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKTKJYUKBN)
    public String getZrndi2jyuusitutkyktkjyukbn() {
        return zrndi2jyuusitutkyktkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2jyuusitutkyktkjyukbn(String pZrndi2jyuusitutkyktkjyukbn) {
        zrndi2jyuusitutkyktkjyukbn = pZrndi2jyuusitutkyktkjyukbn;
    }

    private String zrndi2jyusttkyktkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUSTTKYKTKJYUSKGNKKN)
    public String getZrndi2jyusttkyktkjyuskgnkkn() {
        return zrndi2jyusttkyktkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyusttkyktkjyuskgnkkn(String pZrndi2jyusttkyktkjyuskgnkkn) {
        zrndi2jyusttkyktkjyuskgnkkn = pZrndi2jyusttkyktkjyuskgnkkn;
    }

    private Integer zrndi2jyusttkyktkjyrymshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUSTTKYKTKJYRYMSHYTN)
    public Integer getZrndi2jyusttkyktkjyrymshytn() {
        return zrndi2jyusttkyktkjyrymshytn;
    }

    public void setZrndi2jyusttkyktkjyrymshytn(Integer pZrndi2jyusttkyktkjyrymshytn) {
        zrndi2jyusttkyktkjyrymshytn = pZrndi2jyusttkyktkjyrymshytn;
    }

    private Long zrndi2jyuusitutkyktkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKTKJYUP)
    public Long getZrndi2jyuusitutkyktkjyup() {
        return zrndi2jyuusitutkyktkjyup;
    }

    public void setZrndi2jyuusitutkyktkjyup(Long pZrndi2jyuusitutkyktkjyup) {
        zrndi2jyuusitutkyktkjyup = pZrndi2jyuusitutkyktkjyup;
    }

    private String zrndi2jyuusitutkyktktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKTKTBICDX1)
    public String getZrndi2jyuusitutkyktktbicdx1() {
        return zrndi2jyuusitutkyktktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkyktktbicdx1(String pZrndi2jyuusitutkyktktbicdx1) {
        zrndi2jyuusitutkyktktbicdx1 = pZrndi2jyuusitutkyktktbicdx1;
    }

    private String zrndi2jyuusitutkykhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKHTNPKKNX1)
    public String getZrndi2jyuusitutkykhtnpkknx1() {
        return zrndi2jyuusitutkykhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkykhtnpkknx1(String pZrndi2jyuusitutkykhtnpkknx1) {
        zrndi2jyuusitutkykhtnpkknx1 = pZrndi2jyuusitutkykhtnpkknx1;
    }

    private String zrndi2jyuusitutkyktktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKTKTBICDX2)
    public String getZrndi2jyuusitutkyktktbicdx2() {
        return zrndi2jyuusitutkyktktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkyktktbicdx2(String pZrndi2jyuusitutkyktktbicdx2) {
        zrndi2jyuusitutkyktktbicdx2 = pZrndi2jyuusitutkyktktbicdx2;
    }

    private String zrndi2jyuusitutkykhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKHTNPKKNX2)
    public String getZrndi2jyuusitutkykhtnpkknx2() {
        return zrndi2jyuusitutkykhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkykhtnpkknx2(String pZrndi2jyuusitutkykhtnpkknx2) {
        zrndi2jyuusitutkykhtnpkknx2 = pZrndi2jyuusitutkykhtnpkknx2;
    }

    private String zrnhtnkndi2mnsiskkntkykkgx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2MNSISKKNTKYKKGX1)
    public String getZrnhtnkndi2mnsiskkntkykkgx1() {
        return zrnhtnkndi2mnsiskkntkykkgx1;
    }

    public void setZrnhtnkndi2mnsiskkntkykkgx1(String pZrnhtnkndi2mnsiskkntkykkgx1) {
        zrnhtnkndi2mnsiskkntkykkgx1 = pZrnhtnkndi2mnsiskkntkykkgx1;
    }

    private String zrnhtnkndi2mnsiskkntkykkgx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2MNSISKKNTKYKKGX2)
    public String getZrnhtnkndi2mnsiskkntkykkgx2() {
        return zrnhtnkndi2mnsiskkntkykkgx2;
    }

    public void setZrnhtnkndi2mnsiskkntkykkgx2(String pZrnhtnkndi2mnsiskkntkykkgx2) {
        zrnhtnkndi2mnsiskkntkykkgx2 = pZrnhtnkndi2mnsiskkntkykkgx2;
    }

    private String zrnhtnkndi2mnsiskkntkykkgx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2MNSISKKNTKYKKGX3)
    public String getZrnhtnkndi2mnsiskkntkykkgx3() {
        return zrnhtnkndi2mnsiskkntkykkgx3;
    }

    public void setZrnhtnkndi2mnsiskkntkykkgx3(String pZrnhtnkndi2mnsiskkntkykkgx3) {
        zrnhtnkndi2mnsiskkntkykkgx3 = pZrnhtnkndi2mnsiskkntkykkgx3;
    }

    private String zrnhtnkndi2mnsiskkntkykkgx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2MNSISKKNTKYKKGX4)
    public String getZrnhtnkndi2mnsiskkntkykkgx4() {
        return zrnhtnkndi2mnsiskkntkykkgx4;
    }

    public void setZrnhtnkndi2mnsiskkntkykkgx4(String pZrnhtnkndi2mnsiskkntkykkgx4) {
        zrnhtnkndi2mnsiskkntkykkgx4 = pZrnhtnkndi2mnsiskkntkykkgx4;
    }

    private String zrnhtnkndi2mnsiskkntkykkgx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2MNSISKKNTKYKKGX5)
    public String getZrnhtnkndi2mnsiskkntkykkgx5() {
        return zrnhtnkndi2mnsiskkntkykkgx5;
    }

    public void setZrnhtnkndi2mnsiskkntkykkgx5(String pZrnhtnkndi2mnsiskkntkykkgx5) {
        zrnhtnkndi2mnsiskkntkykkgx5 = pZrnhtnkndi2mnsiskkntkykkgx5;
    }

    private String zrnhtnkndi2mnsiskkntkykkgx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2MNSISKKNTKYKKGX6)
    public String getZrnhtnkndi2mnsiskkntkykkgx6() {
        return zrnhtnkndi2mnsiskkntkykkgx6;
    }

    public void setZrnhtnkndi2mnsiskkntkykkgx6(String pZrnhtnkndi2mnsiskkntkykkgx6) {
        zrnhtnkndi2mnsiskkntkykkgx6 = pZrnhtnkndi2mnsiskkntkykkgx6;
    }

    private String zrnsuryud2jyusttkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURYUD2JYUSTTKYKPWRBKKBN)
    public String getZrnsuryud2jyusttkykpwrbkkbn() {
        return zrnsuryud2jyusttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryud2jyusttkykpwrbkkbn(String pZrnsuryud2jyusttkykpwrbkkbn) {
        zrnsuryud2jyusttkykpwrbkkbn = pZrnsuryud2jyusttkykpwrbkkbn;
    }

    private String zrndi2jyuusitutkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKPWRBKKBN)
    public String getZrndi2jyuusitutkykpwrbkkbn() {
        return zrndi2jyuusitutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyuusitutkykpwrbkkbn(String pZrndi2jyuusitutkykpwrbkkbn) {
        zrndi2jyuusitutkykpwrbkkbn = pZrndi2jyuusitutkykpwrbkkbn;
    }

    private String zrndi2jyusttkyktnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUSTTKYKTNKNYUGUKBN)
    public String getZrndi2jyusttkyktnknyugukbn() {
        return zrndi2jyusttkyktnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2jyusttkyktnknyugukbn(String pZrndi2jyusttkyktnknyugukbn) {
        zrndi2jyusttkyktnknyugukbn = pZrndi2jyusttkyktnknyugukbn;
    }

    private String zrndi2jyuusitutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2JYUUSITUTKYKKGUSDKBN)
    public String getZrndi2jyuusitutkykkgusdkbn() {
        return zrndi2jyuusitutkykkgusdkbn;
    }

    public void setZrndi2jyuusitutkykkgusdkbn(String pZrndi2jyuusitutkykkgusdkbn) {
        zrndi2jyuusitutkykkgusdkbn = pZrndi2jyuusitutkykkgusdkbn;
    }

    private String zrnyobiv7x4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV7X4)
    public String getZrnyobiv7x4() {
        return zrnyobiv7x4;
    }

    public void setZrnyobiv7x4(String pZrnyobiv7x4) {
        zrnyobiv7x4 = pZrnyobiv7x4;
    }

    private String zrnhaitousiharaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHAITOUSIHARAIKBN)
    public String getZrnhaitousiharaikbn() {
        return zrnhaitousiharaikbn;
    }

    public void setZrnhaitousiharaikbn(String pZrnhaitousiharaikbn) {
        zrnhaitousiharaikbn = pZrnhaitousiharaikbn;
    }

    private String zrnsuryusykykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURYUSYKYKPWRBKKBN)
    public String getZrnsuryusykykpwrbkkbn() {
        return zrnsuryusykykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryusykykpwrbkkbn(String pZrnsuryusykykpwrbkkbn) {
        zrnsuryusykykpwrbkkbn = pZrnsuryusykykpwrbkkbn;
    }

    private String zrnnkdatetokuteisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEISYURUIKGU)
    public String getZrnnkdatetokuteisyuruikgu() {
        return zrnnkdatetokuteisyuruikgu;
    }

    public void setZrnnkdatetokuteisyuruikgu(String pZrnnkdatetokuteisyuruikgu) {
        zrnnkdatetokuteisyuruikgu = pZrnnkdatetokuteisyuruikgu;
    }

    private String zrnnenkindatetokuteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATETOKUTEIKIKAN)
    public String getZrnnenkindatetokuteikikan() {
        return zrnnenkindatetokuteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnenkindatetokuteikikan(String pZrnnenkindatetokuteikikan) {
        zrnnenkindatetokuteikikan = pZrnnenkindatetokuteikikan;
    }

    private Long zrnnkdatetokuteinkgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEINKGK)
    public Long getZrnnkdatetokuteinkgk() {
        return zrnnkdatetokuteinkgk;
    }

    public void setZrnnkdatetokuteinkgk(Long pZrnnkdatetokuteinkgk) {
        zrnnkdatetokuteinkgk = pZrnnkdatetokuteinkgk;
    }

    private Long zrnnenkindatetokuteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATETOKUTEIS)
    public Long getZrnnenkindatetokuteis() {
        return zrnnenkindatetokuteis;
    }

    public void setZrnnenkindatetokuteis(Long pZrnnenkindatetokuteis) {
        zrnnenkindatetokuteis = pZrnnenkindatetokuteis;
    }

    private Long zrnnenkindatetokuteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATETOKUTEIP)
    public Long getZrnnenkindatetokuteip() {
        return zrnnenkindatetokuteip;
    }

    public void setZrnnenkindatetokuteip(Long pZrnnenkindatetokuteip) {
        zrnnenkindatetokuteip = pZrnnenkindatetokuteip;
    }

    private String zrnnkdatetokuteisdtpdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEISDTPDTKBN)
    public String getZrnnkdatetokuteisdtpdtkbn() {
        return zrnnkdatetokuteisdtpdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteisdtpdtkbn(String pZrnnkdatetokuteisdtpdtkbn) {
        zrnnkdatetokuteisdtpdtkbn = pZrnnkdatetokuteisdtpdtkbn;
    }

    private Long zrnnkdatetokuteimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEIMODS)
    public Long getZrnnkdatetokuteimods() {
        return zrnnkdatetokuteimods;
    }

    public void setZrnnkdatetokuteimods(Long pZrnnkdatetokuteimods) {
        zrnnkdatetokuteimods = pZrnnkdatetokuteimods;
    }

    private String zrnnkdatetokuteimodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEIMODSSKGNHYJ)
    public String getZrnnkdatetokuteimodsskgnhyj() {
        return zrnnkdatetokuteimodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkdatetokuteimodsskgnhyj(String pZrnnkdatetokuteimodsskgnhyj) {
        zrnnkdatetokuteimodsskgnhyj = pZrnnkdatetokuteimodsskgnhyj;
    }

    private String zrnnkdatetokuteishrkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEISHRKKN)
    public String getZrnnkdatetokuteishrkkn() {
        return zrnnkdatetokuteishrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdatetokuteishrkkn(String pZrnnkdatetokuteishrkkn) {
        zrnnkdatetokuteishrkkn = pZrnnkdatetokuteishrkkn;
    }

    private String zrnkykniyutksytioukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKYKNIYUTKSYTIOUKBN)
    public String getZrnkykniyutksytioukbn() {
        return zrnkykniyutksytioukbn;
    }

    public void setZrnkykniyutksytioukbn(String pZrnkykniyutksytioukbn) {
        zrnkykniyutksytioukbn = pZrnkykniyutksytioukbn;
    }

    private String zrnkeika2nenmimantenkanhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKEIKA2NENMIMANTENKANHYJ)
    public String getZrnkeika2nenmimantenkanhyj() {
        return zrnkeika2nenmimantenkanhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeika2nenmimantenkanhyj(String pZrnkeika2nenmimantenkanhyj) {
        zrnkeika2nenmimantenkanhyj = pZrnkeika2nenmimantenkanhyj;
    }

    private String zrntukiyuhtnknkusnmennsukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUKIYUHTNKNKUSNMENNSUKBN)
    public String getZrntukiyuhtnknkusnmennsukbn() {
        return zrntukiyuhtnknkusnmennsukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntukiyuhtnknkusnmennsukbn(String pZrntukiyuhtnknkusnmennsukbn) {
        zrntukiyuhtnknkusnmennsukbn = pZrntukiyuhtnknkusnmennsukbn;
    }

    private String zrnnkdatetokuteikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDATETOKUTEIKGUSDKBN)
    public String getZrnnkdatetokuteikgusdkbn() {
        return zrnnkdatetokuteikgusdkbn;
    }

    public void setZrnnkdatetokuteikgusdkbn(String pZrnnkdatetokuteikgusdkbn) {
        zrnnkdatetokuteikgusdkbn = pZrnnkdatetokuteikgusdkbn;
    }

    private String zrnnenkindatetokuteikatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATETOKUTEIKATAKBN)
    public String getZrnnenkindatetokuteikatakbn() {
        return zrnnenkindatetokuteikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkindatetokuteikatakbn(String pZrnnenkindatetokuteikatakbn) {
        zrnnenkindatetokuteikatakbn = pZrnnenkindatetokuteikatakbn;
    }

    private String zrnyobiv2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV2X4)
    public String getZrnyobiv2x4() {
        return zrnyobiv2x4;
    }

    public void setZrnyobiv2x4(String pZrnyobiv2x4) {
        zrnyobiv2x4 = pZrnyobiv2x4;
    }

    private String zrnsugusnsyutkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUGUSNSYUTKYKSYURUIKGU)
    public String getZrnsugusnsyutkyksyuruikgu() {
        return zrnsugusnsyutkyksyuruikgu;
    }

    public void setZrnsugusnsyutkyksyuruikgu(String pZrnsugusnsyutkyksyuruikgu) {
        zrnsugusnsyutkyksyuruikgu = pZrnsugusnsyutkyksyuruikgu;
    }

    private String zrnsugusnsyutkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUGUSNSYUTKYKKKN)
    public String getZrnsugusnsyutkykkkn() {
        return zrnsugusnsyutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsugusnsyutkykkkn(String pZrnsugusnsyutkykkkn) {
        zrnsugusnsyutkykkkn = pZrnsugusnsyutkykkkn;
    }

    private String zrnsugusnsyutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUGUSNSYUTKYKPHRKKKN)
    public String getZrnsugusnsyutkykphrkkkn() {
        return zrnsugusnsyutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsugusnsyutkykphrkkkn(String pZrnsugusnsyutkykphrkkkn) {
        zrnsugusnsyutkykphrkkkn = pZrnsugusnsyutkykphrkkkn;
    }

    private Long zrnsougousonsyoutokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSOUGOUSONSYOUTOKUYAKUS)
    public Long getZrnsougousonsyoutokuyakus() {
        return zrnsougousonsyoutokuyakus;
    }

    public void setZrnsougousonsyoutokuyakus(Long pZrnsougousonsyoutokuyakus) {
        zrnsougousonsyoutokuyakus = pZrnsougousonsyoutokuyakus;
    }

    private Long zrnsougousonsyoutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSOUGOUSONSYOUTOKUYAKUP)
    public Long getZrnsougousonsyoutokuyakup() {
        return zrnsougousonsyoutokuyakup;
    }

    public void setZrnsougousonsyoutokuyakup(Long pZrnsougousonsyoutokuyakup) {
        zrnsougousonsyoutokuyakup = pZrnsougousonsyoutokuyakup;
    }

    private String zrnsugusnsyutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUGUSNSYUTKYKKGUSDKBN)
    public String getZrnsugusnsyutkykkgusdkbn() {
        return zrnsugusnsyutkykkgusdkbn;
    }

    public void setZrnsugusnsyutkykkgusdkbn(String pZrnsugusnsyutkykkgusdkbn) {
        zrnsugusnsyutkykkgusdkbn = pZrnsugusnsyutkykkgusdkbn;
    }

    private String zrnsugusnsyutkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUGUSNSYUTKYKPWRBKKBN)
    public String getZrnsugusnsyutkykpwrbkkbn() {
        return zrnsugusnsyutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsugusnsyutkykpwrbkkbn(String pZrnsugusnsyutkykpwrbkkbn) {
        zrnsugusnsyutkykpwrbkkbn = pZrnsugusnsyutkykpwrbkkbn;
    }

    private String zrnsugusnsyutkykkusnmnryage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUGUSNSYUTKYKKUSNMNRYAGE)
    public String getZrnsugusnsyutkykkusnmnryage() {
        return zrnsugusnsyutkykkusnmnryage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsugusnsyutkykkusnmnryage(String pZrnsugusnsyutkykkusnmnryage) {
        zrnsugusnsyutkykkusnmnryage = pZrnsugusnsyutkykkusnmnryage;
    }

    private String zrnyobiv7x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV7X5)
    public String getZrnyobiv7x5() {
        return zrnyobiv7x5;
    }

    public void setZrnyobiv7x5(String pZrnyobiv7x5) {
        zrnyobiv7x5 = pZrnyobiv7x5;
    }

    private String zrndi2sugusnsyutkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYUTKYKSYRIKGU)
    public String getZrndi2sugusnsyutkyksyrikgu() {
        return zrndi2sugusnsyutkyksyrikgu;
    }

    public void setZrndi2sugusnsyutkyksyrikgu(String pZrndi2sugusnsyutkyksyrikgu) {
        zrndi2sugusnsyutkyksyrikgu = pZrndi2sugusnsyutkyksyrikgu;
    }

    private String zrndi2sugusnsyutkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYUTKYKKKN)
    public String getZrndi2sugusnsyutkykkkn() {
        return zrndi2sugusnsyutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sugusnsyutkykkkn(String pZrndi2sugusnsyutkykkkn) {
        zrndi2sugusnsyutkykkkn = pZrndi2sugusnsyutkykkkn;
    }

    private String zrndi2sugusnsyutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYUTKYKPHRKKKN)
    public String getZrndi2sugusnsyutkykphrkkkn() {
        return zrndi2sugusnsyutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sugusnsyutkykphrkkkn(String pZrndi2sugusnsyutkykphrkkkn) {
        zrndi2sugusnsyutkykphrkkkn = pZrndi2sugusnsyutkykphrkkkn;
    }

    private Long zrndi2sugusnsyutkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYUTKYKS)
    public Long getZrndi2sugusnsyutkyks() {
        return zrndi2sugusnsyutkyks;
    }

    public void setZrndi2sugusnsyutkyks(Long pZrndi2sugusnsyutkyks) {
        zrndi2sugusnsyutkyks = pZrndi2sugusnsyutkyks;
    }

    private Long zrndi2sugusnsyutkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYUTKYKP)
    public Long getZrndi2sugusnsyutkykp() {
        return zrndi2sugusnsyutkykp;
    }

    public void setZrndi2sugusnsyutkykp(Long pZrndi2sugusnsyutkykp) {
        zrndi2sugusnsyutkykp = pZrndi2sugusnsyutkykp;
    }

    private String zrndi2sugusnsytkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYTKYKKGUSDKBN)
    public String getZrndi2sugusnsytkykkgusdkbn() {
        return zrndi2sugusnsytkykkgusdkbn;
    }

    public void setZrndi2sugusnsytkykkgusdkbn(String pZrndi2sugusnsytkykkgusdkbn) {
        zrndi2sugusnsytkykkgusdkbn = pZrndi2sugusnsytkykkgusdkbn;
    }

    private String zrndi2sugusnsyutkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SUGUSNSYUTKYKPWRBKKBN)
    public String getZrndi2sugusnsyutkykpwrbkkbn() {
        return zrndi2sugusnsyutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sugusnsyutkykpwrbkkbn(String pZrndi2sugusnsyutkykpwrbkkbn) {
        zrndi2sugusnsyutkykpwrbkkbn = pZrndi2sugusnsyutkykpwrbkkbn;
    }

    private String zrnyobiv9x10;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV9X10)
    public String getZrnyobiv9x10() {
        return zrnyobiv9x10;
    }

    public void setZrnyobiv9x10(String pZrnyobiv9x10) {
        zrnyobiv9x10 = pZrnyobiv9x10;
    }

    private String zrntenkankeitaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTENKANKEITAIKBN)
    public String getZrntenkankeitaikbn() {
        return zrntenkankeitaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkankeitaikbn(String pZrntenkankeitaikbn) {
        zrntenkankeitaikbn = pZrntenkankeitaikbn;
    }

    private Long zrngukitnknitjbrtiknknengk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKITNKNITJBRTIKNKNENGK)
    public Long getZrngukitnknitjbrtiknknengk() {
        return zrngukitnknitjbrtiknknengk;
    }

    public void setZrngukitnknitjbrtiknknengk(Long pZrngukitnknitjbrtiknknengk) {
        zrngukitnknitjbrtiknknengk = pZrngukitnknitjbrtiknknengk;
    }

    private Long zrngukihtnknsugusnsyutkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKIHTNKNSUGUSNSYUTKYKS)
    public Long getZrngukihtnknsugusnsyutkyks() {
        return zrngukihtnknsugusnsyutkyks;
    }

    public void setZrngukihtnknsugusnsyutkyks(Long pZrngukihtnknsugusnsyutkyks) {
        zrngukihtnknsugusnsyutkyks = pZrngukihtnknsugusnsyutkyks;
    }

    private Long zrntenkanitijibaraip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTENKANITIJIBARAIP)
    public Long getZrntenkanitijibaraip() {
        return zrntenkanitijibaraip;
    }

    public void setZrntenkanitijibaraip(Long pZrntenkanitijibaraip) {
        zrntenkanitijibaraip = pZrntenkanitijibaraip;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private Long zrngoukeinenbaraikansanpx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANPX1)
    public Long getZrngoukeinenbaraikansanpx1() {
        return zrngoukeinenbaraikansanpx1;
    }

    public void setZrngoukeinenbaraikansanpx1(Long pZrngoukeinenbaraikansanpx1) {
        zrngoukeinenbaraikansanpx1 = pZrngoukeinenbaraikansanpx1;
    }

    private String zrnhktgtikkikkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKNX1)
    public String getZrnhktgtikkikkknx1() {
        return zrnhktgtikkikkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx1(String pZrnhktgtikkikkknx1) {
        zrnhktgtikkikkknx1 = pZrnhktgtikkikkknx1;
    }

    private String zrnhtnknkykkigmrsysyrikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKKIGMRSYSYRIKGUX1)
    public String getZrnhtnknkykkigmrsysyrikgux1() {
        return zrnhtnknkykkigmrsysyrikgux1;
    }

    public void setZrnhtnknkykkigmrsysyrikgux1(String pZrnhtnknkykkigmrsysyrikgux1) {
        zrnhtnknkykkigmrsysyrikgux1 = pZrnhtnknkykkigmrsysyrikgux1;
    }

    private Long zrngoukeinenbaraikansanpx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANPX2)
    public Long getZrngoukeinenbaraikansanpx2() {
        return zrngoukeinenbaraikansanpx2;
    }

    public void setZrngoukeinenbaraikansanpx2(Long pZrngoukeinenbaraikansanpx2) {
        zrngoukeinenbaraikansanpx2 = pZrngoukeinenbaraikansanpx2;
    }

    private String zrnhktgtikkikkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKNX2)
    public String getZrnhktgtikkikkknx2() {
        return zrnhktgtikkikkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx2(String pZrnhktgtikkikkknx2) {
        zrnhktgtikkikkknx2 = pZrnhktgtikkikkknx2;
    }

    private String zrnhtnknkykkigmrsysyrikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKKIGMRSYSYRIKGUX2)
    public String getZrnhtnknkykkigmrsysyrikgux2() {
        return zrnhtnknkykkigmrsysyrikgux2;
    }

    public void setZrnhtnknkykkigmrsysyrikgux2(String pZrnhtnknkykkigmrsysyrikgux2) {
        zrnhtnknkykkigmrsysyrikgux2 = pZrnhtnknkykkigmrsysyrikgux2;
    }

    private Long zrngoukeinenbaraikansanpx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANPX3)
    public Long getZrngoukeinenbaraikansanpx3() {
        return zrngoukeinenbaraikansanpx3;
    }

    public void setZrngoukeinenbaraikansanpx3(Long pZrngoukeinenbaraikansanpx3) {
        zrngoukeinenbaraikansanpx3 = pZrngoukeinenbaraikansanpx3;
    }

    private String zrnhktgtikkikkknx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKNX3)
    public String getZrnhktgtikkikkknx3() {
        return zrnhktgtikkikkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx3(String pZrnhktgtikkikkknx3) {
        zrnhktgtikkikkknx3 = pZrnhktgtikkikkknx3;
    }

    private String zrnhtnknkykkigmrsysyrikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKKIGMRSYSYRIKGUX3)
    public String getZrnhtnknkykkigmrsysyrikgux3() {
        return zrnhtnknkykkigmrsysyrikgux3;
    }

    public void setZrnhtnknkykkigmrsysyrikgux3(String pZrnhtnknkykkigmrsysyrikgux3) {
        zrnhtnknkykkigmrsysyrikgux3 = pZrnhtnknkykkigmrsysyrikgux3;
    }

    private Long zrngoukeinenbaraikansanpx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANPX4)
    public Long getZrngoukeinenbaraikansanpx4() {
        return zrngoukeinenbaraikansanpx4;
    }

    public void setZrngoukeinenbaraikansanpx4(Long pZrngoukeinenbaraikansanpx4) {
        zrngoukeinenbaraikansanpx4 = pZrngoukeinenbaraikansanpx4;
    }

    private String zrnhktgtikkikkknx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKNX4)
    public String getZrnhktgtikkikkknx4() {
        return zrnhktgtikkikkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx4(String pZrnhktgtikkikkknx4) {
        zrnhktgtikkikkknx4 = pZrnhktgtikkikkknx4;
    }

    private String zrnhtnknkykkigmrsysyrikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKKIGMRSYSYRIKGUX4)
    public String getZrnhtnknkykkigmrsysyrikgux4() {
        return zrnhtnknkykkigmrsysyrikgux4;
    }

    public void setZrnhtnknkykkigmrsysyrikgux4(String pZrnhtnknkykkigmrsysyrikgux4) {
        zrnhtnknkykkigmrsysyrikgux4 = pZrnhtnknkykkigmrsysyrikgux4;
    }

    private Long zrngoukeinenbaraikansanpx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANPX5)
    public Long getZrngoukeinenbaraikansanpx5() {
        return zrngoukeinenbaraikansanpx5;
    }

    public void setZrngoukeinenbaraikansanpx5(Long pZrngoukeinenbaraikansanpx5) {
        zrngoukeinenbaraikansanpx5 = pZrngoukeinenbaraikansanpx5;
    }

    private String zrnhktgtikkikkknx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKNX5)
    public String getZrnhktgtikkikkknx5() {
        return zrnhktgtikkikkknx5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx5(String pZrnhktgtikkikkknx5) {
        zrnhktgtikkikkknx5 = pZrnhktgtikkikkknx5;
    }

    private String zrnhtnknkykkigmrsysyrikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKKIGMRSYSYRIKGUX5)
    public String getZrnhtnknkykkigmrsysyrikgux5() {
        return zrnhtnknkykkigmrsysyrikgux5;
    }

    public void setZrnhtnknkykkigmrsysyrikgux5(String pZrnhtnknkykkigmrsysyrikgux5) {
        zrnhtnknkykkigmrsysyrikgux5 = pZrnhtnknkykkigmrsysyrikgux5;
    }

    private Long zrngoukeinenbaraikansanpx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANPX6)
    public Long getZrngoukeinenbaraikansanpx6() {
        return zrngoukeinenbaraikansanpx6;
    }

    public void setZrngoukeinenbaraikansanpx6(Long pZrngoukeinenbaraikansanpx6) {
        zrngoukeinenbaraikansanpx6 = pZrngoukeinenbaraikansanpx6;
    }

    private String zrnhktgtikkikkknx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKNX6)
    public String getZrnhktgtikkikkknx6() {
        return zrnhktgtikkikkknx6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx6(String pZrnhktgtikkikkknx6) {
        zrnhktgtikkikkknx6 = pZrnhktgtikkikkknx6;
    }

    private String zrnhtnknkykkigmrsysyrikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKYKKIGMRSYSYRIKGUX6)
    public String getZrnhtnknkykkigmrsysyrikgux6() {
        return zrnhtnknkykkigmrsysyrikgux6;
    }

    public void setZrnhtnknkykkigmrsysyrikgux6(String pZrnhtnknkykkigmrsysyrikgux6) {
        zrnhtnknkykkigmrsysyrikgux6 = pZrnhtnknkykkigmrsysyrikgux6;
    }

    private String zrnniceonplanhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNICEONPLANHYJ)
    public String getZrnniceonplanhyj() {
        return zrnniceonplanhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnniceonplanhyj(String pZrnniceonplanhyj) {
        zrnniceonplanhyj = pZrnniceonplanhyj;
    }

    private String zrnsyokaipryosyuymd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYOKAIPRYOSYUYMD)
    public String getZrnsyokaipryosyuymd() {
        return zrnsyokaipryosyuymd;
    }

    public void setZrnsyokaipryosyuymd(String pZrnsyokaipryosyuymd) {
        zrnsyokaipryosyuymd = pZrnsyokaipryosyuymd;
    }

    private String zrnldownmaetenkannensuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNLDOWNMAETENKANNENSUUKBN)
    public String getZrnldownmaetenkannensuukbn() {
        return zrnldownmaetenkannensuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnldownmaetenkannensuukbn(String pZrnldownmaetenkannensuukbn) {
        zrnldownmaetenkannensuukbn = pZrnldownmaetenkannensuukbn;
    }

    private String zrnldownmaesaiteismitatuhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNLDOWNMAESAITEISMITATUHYJ)
    public String getZrnldownmaesaiteismitatuhyj() {
        return zrnldownmaesaiteismitatuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnldownmaesaiteismitatuhyj(String pZrnldownmaesaiteismitatuhyj) {
        zrnldownmaesaiteismitatuhyj = pZrnldownmaesaiteismitatuhyj;
    }

    private String zrndntitikgtkbttrtkhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDNTITIKGTKBTTRTKHYJ)
    public String getZrndntitikgtkbttrtkhyj() {
        return zrndntitikgtkbttrtkhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndntitikgtkbttrtkhyj(String pZrndntitikgtkbttrtkhyj) {
        zrndntitikgtkbttrtkhyj = pZrndntitikgtkbttrtkhyj;
    }

    private String zrnreformkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNREFORMKBN)
    public String getZrnreformkbn() {
        return zrnreformkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnreformkbn(String pZrnreformkbn) {
        zrnreformkbn = pZrnreformkbn;
    }

    private String zrnkikeiyakutyuuihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUTYUUIHYOUJI)
    public String getZrnkikeiyakutyuuihyouji() {
        return zrnkikeiyakutyuuihyouji;
    }

    public void setZrnkikeiyakutyuuihyouji(String pZrnkikeiyakutyuuihyouji) {
        zrnkikeiyakutyuuihyouji = pZrnkikeiyakutyuuihyouji;
    }

    private String zrnkbnkeiriyousegcd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKBNKEIRIYOUSEGCD)
    public String getZrnkbnkeiriyousegcd() {
        return zrnkbnkeiriyousegcd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkbnkeiriyousegcd(String pZrnkbnkeiriyousegcd) {
        zrnkbnkeiriyousegcd = pZrnkbnkeiriyousegcd;
    }

    private String zrnsyuuseiskiteitekiyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYUUSEISKITEITEKIYOUKBN)
    public String getZrnsyuuseiskiteitekiyoukbn() {
        return zrnsyuuseiskiteitekiyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuuseiskiteitekiyoukbn(String pZrnsyuuseiskiteitekiyoukbn) {
        zrnsyuuseiskiteitekiyoukbn = pZrnsyuuseiskiteitekiyoukbn;
    }

    private Long zrngukihtnknkzkmrtimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKIHTNKNKZKMRTIMODS)
    public Long getZrngukihtnknkzkmrtimods() {
        return zrngukihtnknkzkmrtimods;
    }

    public void setZrngukihtnknkzkmrtimods(Long pZrngukihtnknkzkmrtimods) {
        zrngukihtnknkzkmrtimods = pZrngukihtnknkzkmrtimods;
    }

    private Long zrntnknkijyntkyuhtnknsbus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTNKNKIJYNTKYUHTNKNSBUS)
    public Long getZrntnknkijyntkyuhtnknsbus() {
        return zrntnknkijyntkyuhtnknsbus;
    }

    public void setZrntnknkijyntkyuhtnknsbus(Long pZrntnknkijyntkyuhtnknsbus) {
        zrntnknkijyntkyuhtnknsbus = pZrntnknkijyntkyuhtnknsbus;
    }

    private String zrnsrjsnyusyouhinhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSRJSNYUSYOUHINHYJ)
    public String getZrnsrjsnyusyouhinhyj() {
        return zrnsrjsnyusyouhinhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsrjsnyusyouhinhyj(String pZrnsrjsnyusyouhinhyj) {
        zrnsrjsnyusyouhinhyj = pZrnsrjsnyusyouhinhyj;
    }

    private String zrnsirajikakuninzumihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSIRAJIKAKUNINZUMIHYOUJI)
    public String getZrnsirajikakuninzumihyouji() {
        return zrnsirajikakuninzumihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsirajikakuninzumihyouji(String pZrnsirajikakuninzumihyouji) {
        zrnsirajikakuninzumihyouji = pZrnsirajikakuninzumihyouji;
    }

    private String zrnsrjsnyusyouhintknnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSRJSNYUSYOUHINTKNNHYJ)
    public String getZrnsrjsnyusyouhintknnhyj() {
        return zrnsrjsnyusyouhintknnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsrjsnyusyouhintknnhyj(String pZrnsrjsnyusyouhintknnhyj) {
        zrnsrjsnyusyouhintknnhyj = pZrnsrjsnyusyouhintknnhyj;
    }

    private String zrnsinsakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSINSAKBN)
    public String getZrnsinsakbn() {
        return zrnsinsakbn;
    }

    public void setZrnsinsakbn(String pZrnsinsakbn) {
        zrnsinsakbn = pZrnsinsakbn;
    }

    private String zrndai2sinsakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2SINSAKBN)
    public String getZrndai2sinsakbn() {
        return zrndai2sinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2sinsakbn(String pZrndai2sinsakbn) {
        zrndai2sinsakbn = pZrndai2sinsakbn;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrndai2toukeiyousinsakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2TOUKEIYOUSINSAKBN)
    public String getZrndai2toukeiyousinsakbn() {
        return zrndai2toukeiyousinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2toukeiyousinsakbn(String pZrndai2toukeiyousinsakbn) {
        zrndai2toukeiyousinsakbn = pZrndai2toukeiyousinsakbn;
    }

    private String zrnseizonkyuhknshrsiteimd;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSEIZONKYUHKNSHRSITEIMD)
    public String getZrnseizonkyuhknshrsiteimd() {
        return zrnseizonkyuhknshrsiteimd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnseizonkyuhknshrsiteimd(String pZrnseizonkyuhknshrsiteimd) {
        zrnseizonkyuhknshrsiteimd = pZrnseizonkyuhknshrsiteimd;
    }

    private BizNumber zrnyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOTEIRIRITUN5)
    public BizNumber getZrnyoteiriritun5() {
        return zrnyoteiriritun5;
    }

    public void setZrnyoteiriritun5(BizNumber pZrnyoteiriritun5) {
        zrnyoteiriritun5 = pZrnyoteiriritun5;
    }

    private BizNumber zrnsaiteihosyouriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSAITEIHOSYOURIRITU)
    public BizNumber getZrnsaiteihosyouriritu() {
        return zrnsaiteihosyouriritu;
    }

    public void setZrnsaiteihosyouriritu(BizNumber pZrnsaiteihosyouriritu) {
        zrnsaiteihosyouriritu = pZrnsaiteihosyouriritu;
    }

    private BizNumber zrnnkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKGNSRITU)
    public BizNumber getZrnnkgnsritu() {
        return zrnnkgnsritu;
    }

    public void setZrnnkgnsritu(BizNumber pZrnnkgnsritu) {
        zrnnkgnsritu = pZrnnkgnsritu;
    }

    private Long zrnjigyounendomatuv;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNJIGYOUNENDOMATUV)
    public Long getZrnjigyounendomatuv() {
        return zrnjigyounendomatuv;
    }

    public void setZrnjigyounendomatuv(Long pZrnjigyounendomatuv) {
        zrnjigyounendomatuv = pZrnjigyounendomatuv;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrngukihtnkn5nnmeksnyumods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKIHTNKN5NNMEKSNYUMODS)
    public Long getZrngukihtnkn5nnmeksnyumods() {
        return zrngukihtnkn5nnmeksnyumods;
    }

    public void setZrngukihtnkn5nnmeksnyumods(Long pZrngukihtnkn5nnmeksnyumods) {
        zrngukihtnkn5nnmeksnyumods = pZrngukihtnkn5nnmeksnyumods;
    }

    private String zrnrenseiteikitksyusnksnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNRENSEITEIKITKSYUSNKSNHYJ)
    public String getZrnrenseiteikitksyusnksnhyj() {
        return zrnrenseiteikitksyusnksnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrenseiteikitksyusnksnhyj(String pZrnrenseiteikitksyusnksnhyj) {
        zrnrenseiteikitksyusnksnhyj = pZrnrenseiteikitksyusnksnhyj;
    }

    private Long zrngoukeinenbaraikansanp2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANP2X1)
    public Long getZrngoukeinenbaraikansanp2x1() {
        return zrngoukeinenbaraikansanp2x1;
    }

    public void setZrngoukeinenbaraikansanp2x1(Long pZrngoukeinenbaraikansanp2x1) {
        zrngoukeinenbaraikansanp2x1 = pZrngoukeinenbaraikansanp2x1;
    }

    private String zrngukinenbaraiknsnp2kbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKINENBARAIKNSNP2KBNX1)
    public String getZrngukinenbaraiknsnp2kbnx1() {
        return zrngukinenbaraiknsnp2kbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngukinenbaraiknsnp2kbnx1(String pZrngukinenbaraiknsnp2kbnx1) {
        zrngukinenbaraiknsnp2kbnx1 = pZrngukinenbaraiknsnp2kbnx1;
    }

    private String zrnhktgtikkikkkn2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKN2X1)
    public String getZrnhktgtikkikkkn2x1() {
        return zrnhktgtikkikkkn2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn2x1(String pZrnhktgtikkikkkn2x1) {
        zrnhktgtikkikkkn2x1 = pZrnhktgtikkikkkn2x1;
    }

    private Long zrngoukeinenbaraikansanp2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANP2X2)
    public Long getZrngoukeinenbaraikansanp2x2() {
        return zrngoukeinenbaraikansanp2x2;
    }

    public void setZrngoukeinenbaraikansanp2x2(Long pZrngoukeinenbaraikansanp2x2) {
        zrngoukeinenbaraikansanp2x2 = pZrngoukeinenbaraikansanp2x2;
    }

    private String zrngukinenbaraiknsnp2kbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKINENBARAIKNSNP2KBNX2)
    public String getZrngukinenbaraiknsnp2kbnx2() {
        return zrngukinenbaraiknsnp2kbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngukinenbaraiknsnp2kbnx2(String pZrngukinenbaraiknsnp2kbnx2) {
        zrngukinenbaraiknsnp2kbnx2 = pZrngukinenbaraiknsnp2kbnx2;
    }

    private String zrnhktgtikkikkkn2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKN2X2)
    public String getZrnhktgtikkikkkn2x2() {
        return zrnhktgtikkikkkn2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn2x2(String pZrnhktgtikkikkkn2x2) {
        zrnhktgtikkikkkn2x2 = pZrnhktgtikkikkkn2x2;
    }

    private Long zrngoukeinenbaraikansanp2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANP2X3)
    public Long getZrngoukeinenbaraikansanp2x3() {
        return zrngoukeinenbaraikansanp2x3;
    }

    public void setZrngoukeinenbaraikansanp2x3(Long pZrngoukeinenbaraikansanp2x3) {
        zrngoukeinenbaraikansanp2x3 = pZrngoukeinenbaraikansanp2x3;
    }

    private String zrngukinenbaraiknsnp2kbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKINENBARAIKNSNP2KBNX3)
    public String getZrngukinenbaraiknsnp2kbnx3() {
        return zrngukinenbaraiknsnp2kbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngukinenbaraiknsnp2kbnx3(String pZrngukinenbaraiknsnp2kbnx3) {
        zrngukinenbaraiknsnp2kbnx3 = pZrngukinenbaraiknsnp2kbnx3;
    }

    private String zrnhktgtikkikkkn2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKN2X3)
    public String getZrnhktgtikkikkkn2x3() {
        return zrnhktgtikkikkkn2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn2x3(String pZrnhktgtikkikkkn2x3) {
        zrnhktgtikkikkkn2x3 = pZrnhktgtikkikkkn2x3;
    }

    private Long zrngoukeinenbaraikansanp2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANP2X4)
    public Long getZrngoukeinenbaraikansanp2x4() {
        return zrngoukeinenbaraikansanp2x4;
    }

    public void setZrngoukeinenbaraikansanp2x4(Long pZrngoukeinenbaraikansanp2x4) {
        zrngoukeinenbaraikansanp2x4 = pZrngoukeinenbaraikansanp2x4;
    }

    private String zrngukinenbaraiknsnp2kbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKINENBARAIKNSNP2KBNX4)
    public String getZrngukinenbaraiknsnp2kbnx4() {
        return zrngukinenbaraiknsnp2kbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngukinenbaraiknsnp2kbnx4(String pZrngukinenbaraiknsnp2kbnx4) {
        zrngukinenbaraiknsnp2kbnx4 = pZrngukinenbaraiknsnp2kbnx4;
    }

    private String zrnhktgtikkikkkn2x4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKN2X4)
    public String getZrnhktgtikkikkkn2x4() {
        return zrnhktgtikkikkkn2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn2x4(String pZrnhktgtikkikkkn2x4) {
        zrnhktgtikkikkkn2x4 = pZrnhktgtikkikkkn2x4;
    }

    private Long zrngoukeinenbaraikansanp2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANP2X5)
    public Long getZrngoukeinenbaraikansanp2x5() {
        return zrngoukeinenbaraikansanp2x5;
    }

    public void setZrngoukeinenbaraikansanp2x5(Long pZrngoukeinenbaraikansanp2x5) {
        zrngoukeinenbaraikansanp2x5 = pZrngoukeinenbaraikansanp2x5;
    }

    private String zrngukinenbaraiknsnp2kbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKINENBARAIKNSNP2KBNX5)
    public String getZrngukinenbaraiknsnp2kbnx5() {
        return zrngukinenbaraiknsnp2kbnx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngukinenbaraiknsnp2kbnx5(String pZrngukinenbaraiknsnp2kbnx5) {
        zrngukinenbaraiknsnp2kbnx5 = pZrngukinenbaraiknsnp2kbnx5;
    }

    private String zrnhktgtikkikkkn2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKN2X5)
    public String getZrnhktgtikkikkkn2x5() {
        return zrnhktgtikkikkkn2x5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn2x5(String pZrnhktgtikkikkkn2x5) {
        zrnhktgtikkikkkn2x5 = pZrnhktgtikkikkkn2x5;
    }

    private Long zrngoukeinenbaraikansanp2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGOUKEINENBARAIKANSANP2X6)
    public Long getZrngoukeinenbaraikansanp2x6() {
        return zrngoukeinenbaraikansanp2x6;
    }

    public void setZrngoukeinenbaraikansanp2x6(Long pZrngoukeinenbaraikansanp2x6) {
        zrngoukeinenbaraikansanp2x6 = pZrngoukeinenbaraikansanp2x6;
    }

    private String zrngukinenbaraiknsnp2kbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNGUKINENBARAIKNSNP2KBNX6)
    public String getZrngukinenbaraiknsnp2kbnx6() {
        return zrngukinenbaraiknsnp2kbnx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngukinenbaraiknsnp2kbnx6(String pZrngukinenbaraiknsnp2kbnx6) {
        zrngukinenbaraiknsnp2kbnx6 = pZrngukinenbaraiknsnp2kbnx6;
    }

    private String zrnhktgtikkikkkn2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHKTGTIKKIKKKN2X6)
    public String getZrnhktgtikkikkkn2x6() {
        return zrnhktgtikkikkkn2x6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn2x6(String pZrnhktgtikkikkkn2x6) {
        zrnhktgtikkikkkn2x6 = pZrnhktgtikkikkkn2x6;
    }

    private Long zrnkokutituusantaisyous;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKOKUTITUUSANTAISYOUS)
    public Long getZrnkokutituusantaisyous() {
        return zrnkokutituusantaisyous;
    }

    public void setZrnkokutituusantaisyous(Long pZrnkokutituusantaisyous) {
        zrnkokutituusantaisyous = pZrnkokutituusantaisyous;
    }

    private Long zrntokusyuyouroumankis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOKUSYUYOUROUMANKIS)
    public Long getZrntokusyuyouroumankis() {
        return zrntokusyuyouroumankis;
    }

    public void setZrntokusyuyouroumankis(Long pZrntokusyuyouroumankis) {
        zrntokusyuyouroumankis = pZrntokusyuyouroumankis;
    }

    private String zrnnkdtmrtitnknyuuguukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTITNKNYUUGUUKBN)
    public String getZrnnkdtmrtitnknyuuguukbn() {
        return zrnnkdtmrtitnknyuuguukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdtmrtitnknyuuguukbn(String pZrnnkdtmrtitnknyuuguukbn) {
        zrnnkdtmrtitnknyuuguukbn = pZrnnkdtmrtitnknyuuguukbn;
    }

    private String zrnnkdtmrtikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTIKGUSDKBN)
    public String getZrnnkdtmrtikgusdkbn() {
        return zrnnkdtmrtikgusdkbn;
    }

    public void setZrnnkdtmrtikgusdkbn(String pZrnnkdtmrtikgusdkbn) {
        zrnnkdtmrtikgusdkbn = pZrnnkdtmrtikgusdkbn;
    }

    private String zrnnenkindatemaruteikatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNENKINDATEMARUTEIKATAKBN)
    public String getZrnnenkindatemaruteikatakbn() {
        return zrnnenkindatemaruteikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkindatemaruteikatakbn(String pZrnnenkindatemaruteikatakbn) {
        zrnnenkindatemaruteikatakbn = pZrnnenkindatemaruteikatakbn;
    }

    private String zrnnkdtmrtikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNKDTMRTIKUSNMNRYOAGE)
    public String getZrnnkdtmrtikusnmnryoage() {
        return zrnnkdtmrtikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkdtmrtikusnmnryoage(String pZrnnkdtmrtikusnmnryoage) {
        zrnnkdtmrtikusnmnryoage = pZrnnkdtmrtikusnmnryoage;
    }

    private String zrnkaigonkdtmrtisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTISYURUIKGU)
    public String getZrnkaigonkdtmrtisyuruikgu() {
        return zrnkaigonkdtmrtisyuruikgu;
    }

    public void setZrnkaigonkdtmrtisyuruikgu(String pZrnkaigonkdtmrtisyuruikgu) {
        zrnkaigonkdtmrtisyuruikgu = pZrnkaigonkdtmrtisyuruikgu;
    }

    private String zrnkaigonkdtmrtikkan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIKKAN)
    public String getZrnkaigonkdtmrtikkan() {
        return zrnkaigonkdtmrtikkan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdtmrtikkan(String pZrnkaigonkdtmrtikkan) {
        zrnkaigonkdtmrtikkan = pZrnkaigonkdtmrtikkan;
    }

    private String zrnkaigonkdtmrtiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIPHRKKKN)
    public String getZrnkaigonkdtmrtiphrkkkn() {
        return zrnkaigonkdtmrtiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdtmrtiphrkkkn(String pZrnkaigonkdtmrtiphrkkkn) {
        zrnkaigonkdtmrtiphrkkkn = pZrnkaigonkdtmrtiphrkkkn;
    }

    private Long zrnkaigonkdtmrtinnknnengk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTINNKNNENGK)
    public Long getZrnkaigonkdtmrtinnknnengk() {
        return zrnkaigonkdtmrtinnknnengk;
    }

    public void setZrnkaigonkdtmrtinnknnengk(Long pZrnkaigonkdtmrtinnknnengk) {
        zrnkaigonkdtmrtinnknnengk = pZrnkaigonkdtmrtinnknnengk;
    }

    private Long zrnkaigonkdtmrtis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIS)
    public Long getZrnkaigonkdtmrtis() {
        return zrnkaigonkdtmrtis;
    }

    public void setZrnkaigonkdtmrtis(Long pZrnkaigonkdtmrtis) {
        zrnkaigonkdtmrtis = pZrnkaigonkdtmrtis;
    }

    private Long zrnkaigonkdtmrtip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIP)
    public Long getZrnkaigonkdtmrtip() {
        return zrnkaigonkdtmrtip;
    }

    public void setZrnkaigonkdtmrtip(Long pZrnkaigonkdtmrtip) {
        zrnkaigonkdtmrtip = pZrnkaigonkdtmrtip;
    }

    private Long zrnkaigonkdtmrtimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIMODS)
    public Long getZrnkaigonkdtmrtimods() {
        return zrnkaigonkdtmrtimods;
    }

    public void setZrnkaigonkdtmrtimods(Long pZrnkaigonkdtmrtimods) {
        zrnkaigonkdtmrtimods = pZrnkaigonkdtmrtimods;
    }

    private String zrnkaigonkdtmrtitkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTITKJYUKBN)
    public String getZrnkaigonkdtmrtitkjyukbn() {
        return zrnkaigonkdtmrtitkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtitkjyukbn(String pZrnkaigonkdtmrtitkjyukbn) {
        zrnkaigonkdtmrtitkjyukbn = pZrnkaigonkdtmrtitkjyukbn;
    }

    private String zrnkaigonkdtmrtitkjyskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTITKJYSKGNKKN)
    public String getZrnkaigonkdtmrtitkjyskgnkkn() {
        return zrnkaigonkdtmrtitkjyskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdtmrtitkjyskgnkkn(String pZrnkaigonkdtmrtitkjyskgnkkn) {
        zrnkaigonkdtmrtitkjyskgnkkn = pZrnkaigonkdtmrtitkjyskgnkkn;
    }

    private Integer zrnkaigonkdtmrttkjyrymshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTTKJYRYMSHYTN)
    public Integer getZrnkaigonkdtmrttkjyrymshytn() {
        return zrnkaigonkdtmrttkjyrymshytn;
    }

    public void setZrnkaigonkdtmrttkjyrymshytn(Integer pZrnkaigonkdtmrttkjyrymshytn) {
        zrnkaigonkdtmrttkjyrymshytn = pZrnkaigonkdtmrttkjyrymshytn;
    }

    private Long zrnkaigonkdtmrtitkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTITKJYUP)
    public Long getZrnkaigonkdtmrtitkjyup() {
        return zrnkaigonkdtmrtitkjyup;
    }

    public void setZrnkaigonkdtmrtitkjyup(Long pZrnkaigonkdtmrtitkjyup) {
        zrnkaigonkdtmrtitkjyup = pZrnkaigonkdtmrtitkjyup;
    }

    private String zrnhtnknkaigonkmrtsyrikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTSYRIKGUX1)
    public String getZrnhtnknkaigonkmrtsyrikgux1() {
        return zrnhtnknkaigonkmrtsyrikgux1;
    }

    public void setZrnhtnknkaigonkmrtsyrikgux1(String pZrnhtnknkaigonkmrtsyrikgux1) {
        zrnhtnknkaigonkmrtsyrikgux1 = pZrnhtnknkaigonkmrtsyrikgux1;
    }

    private String zrnhtnknkaigonkmrtsyrikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTSYRIKGUX2)
    public String getZrnhtnknkaigonkmrtsyrikgux2() {
        return zrnhtnknkaigonkmrtsyrikgux2;
    }

    public void setZrnhtnknkaigonkmrtsyrikgux2(String pZrnhtnknkaigonkmrtsyrikgux2) {
        zrnhtnknkaigonkmrtsyrikgux2 = pZrnhtnknkaigonkmrtsyrikgux2;
    }

    private String zrnhtnknkaigonkmrtsyrikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTSYRIKGUX3)
    public String getZrnhtnknkaigonkmrtsyrikgux3() {
        return zrnhtnknkaigonkmrtsyrikgux3;
    }

    public void setZrnhtnknkaigonkmrtsyrikgux3(String pZrnhtnknkaigonkmrtsyrikgux3) {
        zrnhtnknkaigonkmrtsyrikgux3 = pZrnhtnknkaigonkmrtsyrikgux3;
    }

    private String zrnhtnknkaigonkmrtsyrikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTSYRIKGUX4)
    public String getZrnhtnknkaigonkmrtsyrikgux4() {
        return zrnhtnknkaigonkmrtsyrikgux4;
    }

    public void setZrnhtnknkaigonkmrtsyrikgux4(String pZrnhtnknkaigonkmrtsyrikgux4) {
        zrnhtnknkaigonkmrtsyrikgux4 = pZrnhtnknkaigonkmrtsyrikgux4;
    }

    private String zrnhtnknkaigonkmrtsyrikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTSYRIKGUX5)
    public String getZrnhtnknkaigonkmrtsyrikgux5() {
        return zrnhtnknkaigonkmrtsyrikgux5;
    }

    public void setZrnhtnknkaigonkmrtsyrikgux5(String pZrnhtnknkaigonkmrtsyrikgux5) {
        zrnhtnknkaigonkmrtsyrikgux5 = pZrnhtnknkaigonkmrtsyrikgux5;
    }

    private String zrnhtnknkaigonkmrtsyrikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTSYRIKGUX6)
    public String getZrnhtnknkaigonkmrtsyrikgux6() {
        return zrnhtnknkaigonkmrtsyrikgux6;
    }

    public void setZrnhtnknkaigonkmrtsyrikgux6(String pZrnhtnknkaigonkmrtsyrikgux6) {
        zrnhtnknkaigonkmrtsyrikgux6 = pZrnhtnknkaigonkmrtsyrikgux6;
    }

    private String zrnkaigonkdtmrtishrkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTISHRKKN)
    public String getZrnkaigonkdtmrtishrkkn() {
        return zrnkaigonkdtmrtishrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdtmrtishrkkn(String pZrnkaigonkdtmrtishrkkn) {
        zrnkaigonkdtmrtishrkkn = pZrnkaigonkdtmrtishrkkn;
    }

    private String zrnsurikaigonkmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURIKAIGONKMRTIPWRBKKBN)
    public String getZrnsurikaigonkmrtipwrbkkbn() {
        return zrnsurikaigonkmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsurikaigonkmrtipwrbkkbn(String pZrnsurikaigonkmrtipwrbkkbn) {
        zrnsurikaigonkmrtipwrbkkbn = pZrnsurikaigonkmrtipwrbkkbn;
    }

    private String zrnkaigonkdtmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIPWRBKKBN)
    public String getZrnkaigonkdtmrtipwrbkkbn() {
        return zrnkaigonkdtmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdtmrtipwrbkkbn(String pZrnkaigonkdtmrtipwrbkkbn) {
        zrnkaigonkdtmrtipwrbkkbn = pZrnkaigonkdtmrtipwrbkkbn;
    }

    private String zrnkaigonkdtmrtitnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTITNKNYUGUKBN)
    public String getZrnkaigonkdtmrtitnknyugukbn() {
        return zrnkaigonkdtmrtitnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdtmrtitnknyugukbn(String pZrnkaigonkdtmrtitnknyugukbn) {
        zrnkaigonkdtmrtitnknyugukbn = pZrnkaigonkdtmrtitnknyugukbn;
    }

    private String zrnkaigonkdtmrtikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIKGUSDKBN)
    public String getZrnkaigonkdtmrtikgusdkbn() {
        return zrnkaigonkdtmrtikgusdkbn;
    }

    public void setZrnkaigonkdtmrtikgusdkbn(String pZrnkaigonkdtmrtikgusdkbn) {
        zrnkaigonkdtmrtikgusdkbn = pZrnkaigonkdtmrtikgusdkbn;
    }

    private String zrnkaigonkdtmrtiktkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTMRTIKTKBN)
    public String getZrnkaigonkdtmrtiktkbn() {
        return zrnkaigonkdtmrtiktkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdtmrtiktkbn(String pZrnkaigonkdtmrtiktkbn) {
        zrnkaigonkdtmrtiktkbn = pZrnkaigonkdtmrtiktkbn;
    }

    private String zrnkignkdtmrtikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGNKDTMRTIKUSNMNRYOAGE)
    public String getZrnkignkdtmrtikusnmnryoage() {
        return zrnkignkdtmrtikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkignkdtmrtikusnmnryoage(String pZrnkignkdtmrtikusnmnryoage) {
        zrnkignkdtmrtikusnmnryoage = pZrnkignkdtmrtikusnmnryoage;
    }

    private String zrnkaigonkdttktisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTISYURUIKGU)
    public String getZrnkaigonkdttktisyuruikgu() {
        return zrnkaigonkdttktisyuruikgu;
    }

    public void setZrnkaigonkdttktisyuruikgu(String pZrnkaigonkdttktisyuruikgu) {
        zrnkaigonkdttktisyuruikgu = pZrnkaigonkdttktisyuruikgu;
    }

    private String zrnkaigonkdttktikkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTIKKN)
    public String getZrnkaigonkdttktikkn() {
        return zrnkaigonkdttktikkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdttktikkn(String pZrnkaigonkdttktikkn) {
        zrnkaigonkdttktikkn = pZrnkaigonkdttktikkn;
    }

    private Long zrnkaigonkdttkteinenkngk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTEINENKNGK)
    public Long getZrnkaigonkdttkteinenkngk() {
        return zrnkaigonkdttkteinenkngk;
    }

    public void setZrnkaigonkdttkteinenkngk(Long pZrnkaigonkdttkteinenkngk) {
        zrnkaigonkdttkteinenkngk = pZrnkaigonkdttkteinenkngk;
    }

    private Long zrnkaigonenkindatetokuteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONENKINDATETOKUTEIS)
    public Long getZrnkaigonenkindatetokuteis() {
        return zrnkaigonenkindatetokuteis;
    }

    public void setZrnkaigonenkindatetokuteis(Long pZrnkaigonenkindatetokuteis) {
        zrnkaigonenkindatetokuteis = pZrnkaigonenkindatetokuteis;
    }

    private Long zrnkaigonenkindatetokuteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONENKINDATETOKUTEIP)
    public Long getZrnkaigonenkindatetokuteip() {
        return zrnkaigonenkindatetokuteip;
    }

    public void setZrnkaigonenkindatetokuteip(Long pZrnkaigonenkindatetokuteip) {
        zrnkaigonenkindatetokuteip = pZrnkaigonenkindatetokuteip;
    }

    private String zrnkaigonkdttktisdtpdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTISDTPDTKBN)
    public String getZrnkaigonkdttktisdtpdtkbn() {
        return zrnkaigonkdttktisdtpdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktisdtpdtkbn(String pZrnkaigonkdttktisdtpdtkbn) {
        zrnkaigonkdttktisdtpdtkbn = pZrnkaigonkdttktisdtpdtkbn;
    }

    private Long zrnkaigonkdttktimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTIMODS)
    public Long getZrnkaigonkdttktimods() {
        return zrnkaigonkdttktimods;
    }

    public void setZrnkaigonkdttktimods(Long pZrnkaigonkdttktimods) {
        zrnkaigonkdttktimods = pZrnkaigonkdttktimods;
    }

    private String zrnkaigonkdttktishrkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTISHRKKN)
    public String getZrnkaigonkdttktishrkkn() {
        return zrnkaigonkdttktishrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonkdttktishrkkn(String pZrnkaigonkdttktishrkkn) {
        zrnkaigonkdttktishrkkn = pZrnkaigonkdttktishrkkn;
    }

    private String zrnkaigonkdttktikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTIKGUSDKBN)
    public String getZrnkaigonkdttktikgusdkbn() {
        return zrnkaigonkdttktikgusdkbn;
    }

    public void setZrnkaigonkdttktikgusdkbn(String pZrnkaigonkdttktikgusdkbn) {
        zrnkaigonkdttktikgusdkbn = pZrnkaigonkdttktikgusdkbn;
    }

    private String zrnkaigonkdttktiktkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKDTTKTIKTKBN)
    public String getZrnkaigonkdttktiktkbn() {
        return zrnkaigonkdttktiktkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigonkdttktiktkbn(String pZrnkaigonkdttktiktkbn) {
        zrnkaigonkdttktiktkbn = pZrnkaigonkdttktiktkbn;
    }

    private String zrnkignkdttktikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGNKDTTKTIKUSNMNRYOAGE)
    public String getZrnkignkdttktikusnmnryoage() {
        return zrnkignkdttktikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkignkdttktikusnmnryoage(String pZrnkignkdttktikusnmnryoage) {
        zrnkignkdttktikusnmnryoage = pZrnkignkdttktikusnmnryoage;
    }

    private String zrnyobiv2x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV2X5)
    public String getZrnyobiv2x5() {
        return zrnyobiv2x5;
    }

    public void setZrnyobiv2x5(String pZrnyobiv2x5) {
        zrnyobiv2x5 = pZrnyobiv2x5;
    }

    private String zrnkaigoteigenmrtisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENMRTISYURUIKGU)
    public String getZrnkaigoteigenmrtisyuruikgu() {
        return zrnkaigoteigenmrtisyuruikgu;
    }

    public void setZrnkaigoteigenmrtisyuruikgu(String pZrnkaigoteigenmrtisyuruikgu) {
        zrnkaigoteigenmrtisyuruikgu = pZrnkaigoteigenmrtisyuruikgu;
    }

    private String zrnkaigoteigenmaruteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENMARUTEIKIKAN)
    public String getZrnkaigoteigenmaruteikikan() {
        return zrnkaigoteigenmaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigoteigenmaruteikikan(String pZrnkaigoteigenmaruteikikan) {
        zrnkaigoteigenmaruteikikan = pZrnkaigoteigenmaruteikikan;
    }

    private String zrnkaigotignmrtiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTIGNMRTIPHRKKKN)
    public String getZrnkaigotignmrtiphrkkkn() {
        return zrnkaigotignmrtiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigotignmrtiphrkkkn(String pZrnkaigotignmrtiphrkkkn) {
        zrnkaigotignmrtiphrkkkn = pZrnkaigotignmrtiphrkkkn;
    }

    private Long zrnkaigoteigenmaruteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENMARUTEIS)
    public Long getZrnkaigoteigenmaruteis() {
        return zrnkaigoteigenmaruteis;
    }

    public void setZrnkaigoteigenmaruteis(Long pZrnkaigoteigenmaruteis) {
        zrnkaigoteigenmaruteis = pZrnkaigoteigenmaruteis;
    }

    private Long zrnkaigoteigenmaruteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENMARUTEIP)
    public Long getZrnkaigoteigenmaruteip() {
        return zrnkaigoteigenmaruteip;
    }

    public void setZrnkaigoteigenmaruteip(Long pZrnkaigoteigenmaruteip) {
        zrnkaigoteigenmaruteip = pZrnkaigoteigenmaruteip;
    }

    private Long zrnkigtignmrtimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTIMODS)
    public Long getZrnkigtignmrtimods() {
        return zrnkigtignmrtimods;
    }

    public void setZrnkigtignmrtimods(Long pZrnkigtignmrtimods) {
        zrnkigtignmrtimods = pZrnkigtignmrtimods;
    }

    private String zrnkigtignmrtitkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTITKJYUKBN)
    public String getZrnkigtignmrtitkjyukbn() {
        return zrnkigtignmrtitkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtignmrtitkjyukbn(String pZrnkigtignmrtitkjyukbn) {
        zrnkigtignmrtitkjyukbn = pZrnkigtignmrtitkjyukbn;
    }

    private String zrnkigtignmrtitkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTITKJYUSKGNKKN)
    public String getZrnkigtignmrtitkjyuskgnkkn() {
        return zrnkigtignmrtitkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigtignmrtitkjyuskgnkkn(String pZrnkigtignmrtitkjyuskgnkkn) {
        zrnkigtignmrtitkjyuskgnkkn = pZrnkigtignmrtitkjyuskgnkkn;
    }

    private Integer zrnkigtignmrtitkjyurymshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTITKJYURYMSHYTN)
    public Integer getZrnkigtignmrtitkjyurymshytn() {
        return zrnkigtignmrtitkjyurymshytn;
    }

    public void setZrnkigtignmrtitkjyurymshytn(Integer pZrnkigtignmrtitkjyurymshytn) {
        zrnkigtignmrtitkjyurymshytn = pZrnkigtignmrtitkjyurymshytn;
    }

    private Long zrnkigtignmrtitkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTITKJYUP)
    public Long getZrnkigtignmrtitkjyup() {
        return zrnkigtignmrtitkjyup;
    }

    public void setZrnkigtignmrtitkjyup(Long pZrnkigtignmrtitkjyup) {
        zrnkigtignmrtitkjyup = pZrnkigtignmrtitkjyup;
    }

    private String zrnhtnknkigtignmrtsyrikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTSYRIKGUX1)
    public String getZrnhtnknkigtignmrtsyrikgux1() {
        return zrnhtnknkigtignmrtsyrikgux1;
    }

    public void setZrnhtnknkigtignmrtsyrikgux1(String pZrnhtnknkigtignmrtsyrikgux1) {
        zrnhtnknkigtignmrtsyrikgux1 = pZrnhtnknkigtignmrtsyrikgux1;
    }

    private String zrnhtnknkigtignmrtsyrikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTSYRIKGUX2)
    public String getZrnhtnknkigtignmrtsyrikgux2() {
        return zrnhtnknkigtignmrtsyrikgux2;
    }

    public void setZrnhtnknkigtignmrtsyrikgux2(String pZrnhtnknkigtignmrtsyrikgux2) {
        zrnhtnknkigtignmrtsyrikgux2 = pZrnhtnknkigtignmrtsyrikgux2;
    }

    private String zrnhtnknkigtignmrtsyrikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTSYRIKGUX3)
    public String getZrnhtnknkigtignmrtsyrikgux3() {
        return zrnhtnknkigtignmrtsyrikgux3;
    }

    public void setZrnhtnknkigtignmrtsyrikgux3(String pZrnhtnknkigtignmrtsyrikgux3) {
        zrnhtnknkigtignmrtsyrikgux3 = pZrnhtnknkigtignmrtsyrikgux3;
    }

    private String zrnhtnknkigtignmrtsyrikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTSYRIKGUX4)
    public String getZrnhtnknkigtignmrtsyrikgux4() {
        return zrnhtnknkigtignmrtsyrikgux4;
    }

    public void setZrnhtnknkigtignmrtsyrikgux4(String pZrnhtnknkigtignmrtsyrikgux4) {
        zrnhtnknkigtignmrtsyrikgux4 = pZrnhtnknkigtignmrtsyrikgux4;
    }

    private String zrnhtnknkigtignmrtsyrikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTSYRIKGUX5)
    public String getZrnhtnknkigtignmrtsyrikgux5() {
        return zrnhtnknkigtignmrtsyrikgux5;
    }

    public void setZrnhtnknkigtignmrtsyrikgux5(String pZrnhtnknkigtignmrtsyrikgux5) {
        zrnhtnknkigtignmrtsyrikgux5 = pZrnhtnknkigtignmrtsyrikgux5;
    }

    private String zrnhtnknkigtignmrtsyrikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTSYRIKGUX6)
    public String getZrnhtnknkigtignmrtsyrikgux6() {
        return zrnhtnknkigtignmrtsyrikgux6;
    }

    public void setZrnhtnknkigtignmrtsyrikgux6(String pZrnhtnknkigtignmrtsyrikgux6) {
        zrnhtnknkigtignmrtsyrikgux6 = pZrnhtnknkigtignmrtsyrikgux6;
    }

    private String zrnsurkigtignmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURKIGTIGNMRTIPWRBKKBN)
    public String getZrnsurkigtignmrtipwrbkkbn() {
        return zrnsurkigtignmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsurkigtignmrtipwrbkkbn(String pZrnsurkigtignmrtipwrbkkbn) {
        zrnsurkigtignmrtipwrbkkbn = pZrnsurkigtignmrtipwrbkkbn;
    }

    private String zrnkigtignmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTIPWRBKKBN)
    public String getZrnkigtignmrtipwrbkkbn() {
        return zrnkigtignmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigtignmrtipwrbkkbn(String pZrnkigtignmrtipwrbkkbn) {
        zrnkigtignmrtipwrbkkbn = pZrnkigtignmrtipwrbkkbn;
    }

    private String zrnkigtignmrtitnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTITNKNYUGUKBN)
    public String getZrnkigtignmrtitnknyugukbn() {
        return zrnkigtignmrtitnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigtignmrtitnknyugukbn(String pZrnkigtignmrtitnknyugukbn) {
        zrnkigtignmrtitnknyugukbn = pZrnkigtignmrtitnknyugukbn;
    }

    private String zrnkaigotignmrtikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTIGNMRTIKGUSDKBN)
    public String getZrnkaigotignmrtikgusdkbn() {
        return zrnkaigotignmrtikgusdkbn;
    }

    public void setZrnkaigotignmrtikgusdkbn(String pZrnkaigotignmrtikgusdkbn) {
        zrnkaigotignmrtikgusdkbn = pZrnkaigotignmrtikgusdkbn;
    }

    private String zrnkigtignmrtikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNMRTIKUSNMNRYOAGE)
    public String getZrnkigtignmrtikusnmnryoage() {
        return zrnkigtignmrtikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigtignmrtikusnmnryoage(String pZrnkigtignmrtikusnmnryoage) {
        zrnkigtignmrtikusnmnryoage = pZrnkigtignmrtikusnmnryoage;
    }

    private String zrnyobiv4x15;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV4X15)
    public String getZrnyobiv4x15() {
        return zrnyobiv4x15;
    }

    public void setZrnyobiv4x15(String pZrnyobiv4x15) {
        zrnyobiv4x15 = pZrnyobiv4x15;
    }

    private String zrnkaigoteigentktisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENTKTISYURUIKGU)
    public String getZrnkaigoteigentktisyuruikgu() {
        return zrnkaigoteigentktisyuruikgu;
    }

    public void setZrnkaigoteigentktisyuruikgu(String pZrnkaigoteigentktisyuruikgu) {
        zrnkaigoteigentktisyuruikgu = pZrnkaigoteigentktisyuruikgu;
    }

    private String zrnkaigoteigentokuteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENTOKUTEIKIKAN)
    public String getZrnkaigoteigentokuteikikan() {
        return zrnkaigoteigentokuteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigoteigentokuteikikan(String pZrnkaigoteigentokuteikikan) {
        zrnkaigoteigentokuteikikan = pZrnkaigoteigentokuteikikan;
    }

    private Long zrnkaigoteigentokuteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENTOKUTEIS)
    public Long getZrnkaigoteigentokuteis() {
        return zrnkaigoteigentokuteis;
    }

    public void setZrnkaigoteigentokuteis(Long pZrnkaigoteigentokuteis) {
        zrnkaigoteigentokuteis = pZrnkaigoteigentokuteis;
    }

    private Long zrnkaigoteigentokuteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTEIGENTOKUTEIP)
    public Long getZrnkaigoteigentokuteip() {
        return zrnkaigoteigentokuteip;
    }

    public void setZrnkaigoteigentokuteip(Long pZrnkaigoteigentokuteip) {
        zrnkaigoteigentokuteip = pZrnkaigoteigentokuteip;
    }

    private String zrnkigtigntktisdtpdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNTKTISDTPDTKBN)
    public String getZrnkigtigntktisdtpdtkbn() {
        return zrnkigtigntktisdtpdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtigntktisdtpdtkbn(String pZrnkigtigntktisdtpdtkbn) {
        zrnkigtigntktisdtpdtkbn = pZrnkigtigntktisdtpdtkbn;
    }

    private Long zrnkigtigntktimods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNTKTIMODS)
    public Long getZrnkigtigntktimods() {
        return zrnkigtigntktimods;
    }

    public void setZrnkigtigntktimods(Long pZrnkigtigntktimods) {
        zrnkigtigntktimods = pZrnkigtigntktimods;
    }

    private String zrnkaigotigntktikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTIGNTKTIKGUSDKBN)
    public String getZrnkaigotigntktikgusdkbn() {
        return zrnkaigotigntktikgusdkbn;
    }

    public void setZrnkaigotigntktikgusdkbn(String pZrnkaigotigntktikgusdkbn) {
        zrnkaigotigntktikgusdkbn = pZrnkaigotigntktikgusdkbn;
    }

    private String zrnkigtigntktikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTIGNTKTIKUSNMNRYOAGE)
    public String getZrnkigtigntktikusnmnryoage() {
        return zrnkigtigntktikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigtigntktikusnmnryoage(String pZrnkigtigntktikusnmnryoage) {
        zrnkigtigntktikusnmnryoage = pZrnkigtigntktikusnmnryoage;
    }

    private String zrnyobiv2x6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV2X6)
    public String getZrnyobiv2x6() {
        return zrnyobiv2x6;
    }

    public void setZrnyobiv2x6(String pZrnyobiv2x6) {
        zrnyobiv2x6 = pZrnyobiv2x6;
    }

    private Long zrnhikitugikaimasis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHIKITUGIKAIMASIS)
    public Long getZrnhikitugikaimasis() {
        return zrnhikitugikaimasis;
    }

    public void setZrnhikitugikaimasis(Long pZrnhikitugikaimasis) {
        zrnhikitugikaimasis = pZrnhikitugikaimasis;
    }

    private String zrncbkyhtisyukykumkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKYHTISYUKYKUMKBN)
    public String getZrncbkyhtisyukykumkbn() {
        return zrncbkyhtisyukykumkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrncbkyhtisyukykumkbn(String pZrncbkyhtisyukykumkbn) {
        zrncbkyhtisyukykumkbn = pZrncbkyhtisyukykumkbn;
    }

    private Long zrntukiyucbkyhtisyus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUKIYUCBKYHTISYUS)
    public Long getZrntukiyucbkyhtisyus() {
        return zrntukiyucbkyhtisyus;
    }

    public void setZrntukiyucbkyhtisyus(Long pZrntukiyucbkyhtisyus) {
        zrntukiyucbkyhtisyus = pZrntukiyucbkyhtisyus;
    }

    private Long zrncbhanteituusans;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBHANTEITUUSANS)
    public Long getZrncbhanteituusans() {
        return zrncbhanteituusans;
    }

    public void setZrncbhanteituusans(Long pZrncbhanteituusans) {
        zrncbhanteituusans = pZrncbhanteituusans;
    }

    private Long zrntukiyusnkykcbhntis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTUKIYUSNKYKCBHNTIS)
    public Long getZrntukiyusnkykcbhntis() {
        return zrntukiyusnkykcbhntis;
    }

    public void setZrntukiyusnkykcbhntis(Long pZrntukiyusnkykcbhntis) {
        zrntukiyusnkykcbhntis = pZrntukiyusnkykcbhntis;
    }

    private String zrncbstagekbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBSTAGEKBN)
    public String getZrncbstagekbn() {
        return zrncbstagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbstagekbn(String pZrncbstagekbn) {
        zrncbstagekbn = pZrncbstagekbn;
    }

    private Long zrntoukeiyoucbhanteituusans;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTOUKEIYOUCBHANTEITUUSANS)
    public Long getZrntoukeiyoucbhanteituusans() {
        return zrntoukeiyoucbhanteituusans;
    }

    public void setZrntoukeiyoucbhanteituusans(Long pZrntoukeiyoucbhanteituusans) {
        zrntoukeiyoucbhanteituusans = pZrntoukeiyoucbhanteituusans;
    }

    private Integer zrncbtuusankensuu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBTUUSANKENSUU)
    public Integer getZrncbtuusankensuu() {
        return zrncbtuusankensuu;
    }

    public void setZrncbtuusankensuu(Integer pZrncbtuusankensuu) {
        zrncbtuusankensuu = pZrncbtuusankensuu;
    }

    private Integer zrncbhanteitaisyoutsnkensuu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBHANTEITAISYOUTSNKENSUU)
    public Integer getZrncbhanteitaisyoutsnkensuu() {
        return zrncbhanteitaisyoutsnkensuu;
    }

    public void setZrncbhanteitaisyoutsnkensuu(Integer pZrncbhanteitaisyoutsnkensuu) {
        zrncbhanteitaisyoutsnkensuu = pZrncbhanteitaisyoutsnkensuu;
    }

    private Long zrntyokuzentuusanhanteisx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENTUUSANHANTEISX1)
    public Long getZrntyokuzentuusanhanteisx1() {
        return zrntyokuzentuusanhanteisx1;
    }

    public void setZrntyokuzentuusanhanteisx1(Long pZrntyokuzentuusanhanteisx1) {
        zrntyokuzentuusanhanteisx1 = pZrntyokuzentuusanhanteisx1;
    }

    private Long zrntyokuzenkyuuhutaisyousx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENKYUUHUTAISYOUSX1)
    public Long getZrntyokuzenkyuuhutaisyousx1() {
        return zrntyokuzenkyuuhutaisyousx1;
    }

    public void setZrntyokuzenkyuuhutaisyousx1(Long pZrntyokuzenkyuuhutaisyousx1) {
        zrntyokuzenkyuuhutaisyousx1 = pZrntyokuzenkyuuhutaisyousx1;
    }

    private Long zrntyokuzencbgakux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENCBGAKUX1)
    public Long getZrntyokuzencbgakux1() {
        return zrntyokuzencbgakux1;
    }

    public void setZrntyokuzencbgakux1(Long pZrntyokuzencbgakux1) {
        zrntyokuzencbgakux1 = pZrntyokuzencbgakux1;
    }

    private Long zrntyokugotuusanhanteisx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOTUUSANHANTEISX1)
    public Long getZrntyokugotuusanhanteisx1() {
        return zrntyokugotuusanhanteisx1;
    }

    public void setZrntyokugotuusanhanteisx1(Long pZrntyokugotuusanhanteisx1) {
        zrntyokugotuusanhanteisx1 = pZrntyokugotuusanhanteisx1;
    }

    private Long zrntyokugokyuuhutaisyousx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOKYUUHUTAISYOUSX1)
    public Long getZrntyokugokyuuhutaisyousx1() {
        return zrntyokugokyuuhutaisyousx1;
    }

    public void setZrntyokugokyuuhutaisyousx1(Long pZrntyokugokyuuhutaisyousx1) {
        zrntyokugokyuuhutaisyousx1 = pZrntyokugokyuuhutaisyousx1;
    }

    private Long zrntyokugocbgakux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOCBGAKUX1)
    public Long getZrntyokugocbgakux1() {
        return zrntyokugocbgakux1;
    }

    public void setZrntyokugocbgakux1(Long pZrntyokugocbgakux1) {
        zrntyokugocbgakux1 = pZrntyokugocbgakux1;
    }

    private String zrnyobiv12;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private Long zrntyokuzentuusanhanteisx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENTUUSANHANTEISX2)
    public Long getZrntyokuzentuusanhanteisx2() {
        return zrntyokuzentuusanhanteisx2;
    }

    public void setZrntyokuzentuusanhanteisx2(Long pZrntyokuzentuusanhanteisx2) {
        zrntyokuzentuusanhanteisx2 = pZrntyokuzentuusanhanteisx2;
    }

    private Long zrntyokuzenkyuuhutaisyousx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENKYUUHUTAISYOUSX2)
    public Long getZrntyokuzenkyuuhutaisyousx2() {
        return zrntyokuzenkyuuhutaisyousx2;
    }

    public void setZrntyokuzenkyuuhutaisyousx2(Long pZrntyokuzenkyuuhutaisyousx2) {
        zrntyokuzenkyuuhutaisyousx2 = pZrntyokuzenkyuuhutaisyousx2;
    }

    private Long zrntyokuzencbgakux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENCBGAKUX2)
    public Long getZrntyokuzencbgakux2() {
        return zrntyokuzencbgakux2;
    }

    public void setZrntyokuzencbgakux2(Long pZrntyokuzencbgakux2) {
        zrntyokuzencbgakux2 = pZrntyokuzencbgakux2;
    }

    private Long zrntyokugotuusanhanteisx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOTUUSANHANTEISX2)
    public Long getZrntyokugotuusanhanteisx2() {
        return zrntyokugotuusanhanteisx2;
    }

    public void setZrntyokugotuusanhanteisx2(Long pZrntyokugotuusanhanteisx2) {
        zrntyokugotuusanhanteisx2 = pZrntyokugotuusanhanteisx2;
    }

    private Long zrntyokugokyuuhutaisyousx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOKYUUHUTAISYOUSX2)
    public Long getZrntyokugokyuuhutaisyousx2() {
        return zrntyokugokyuuhutaisyousx2;
    }

    public void setZrntyokugokyuuhutaisyousx2(Long pZrntyokugokyuuhutaisyousx2) {
        zrntyokugokyuuhutaisyousx2 = pZrntyokugokyuuhutaisyousx2;
    }

    private Long zrntyokugocbgakux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOCBGAKUX2)
    public Long getZrntyokugocbgakux2() {
        return zrntyokugocbgakux2;
    }

    public void setZrntyokugocbgakux2(Long pZrntyokugocbgakux2) {
        zrntyokugocbgakux2 = pZrntyokugocbgakux2;
    }

    private String zrnyobiv12x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X2)
    public String getZrnyobiv12x2() {
        return zrnyobiv12x2;
    }

    public void setZrnyobiv12x2(String pZrnyobiv12x2) {
        zrnyobiv12x2 = pZrnyobiv12x2;
    }

    private Long zrntyokuzentuusanhanteisx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENTUUSANHANTEISX3)
    public Long getZrntyokuzentuusanhanteisx3() {
        return zrntyokuzentuusanhanteisx3;
    }

    public void setZrntyokuzentuusanhanteisx3(Long pZrntyokuzentuusanhanteisx3) {
        zrntyokuzentuusanhanteisx3 = pZrntyokuzentuusanhanteisx3;
    }

    private Long zrntyokuzenkyuuhutaisyousx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENKYUUHUTAISYOUSX3)
    public Long getZrntyokuzenkyuuhutaisyousx3() {
        return zrntyokuzenkyuuhutaisyousx3;
    }

    public void setZrntyokuzenkyuuhutaisyousx3(Long pZrntyokuzenkyuuhutaisyousx3) {
        zrntyokuzenkyuuhutaisyousx3 = pZrntyokuzenkyuuhutaisyousx3;
    }

    private Long zrntyokuzencbgakux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENCBGAKUX3)
    public Long getZrntyokuzencbgakux3() {
        return zrntyokuzencbgakux3;
    }

    public void setZrntyokuzencbgakux3(Long pZrntyokuzencbgakux3) {
        zrntyokuzencbgakux3 = pZrntyokuzencbgakux3;
    }

    private Long zrntyokugotuusanhanteisx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOTUUSANHANTEISX3)
    public Long getZrntyokugotuusanhanteisx3() {
        return zrntyokugotuusanhanteisx3;
    }

    public void setZrntyokugotuusanhanteisx3(Long pZrntyokugotuusanhanteisx3) {
        zrntyokugotuusanhanteisx3 = pZrntyokugotuusanhanteisx3;
    }

    private Long zrntyokugokyuuhutaisyousx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOKYUUHUTAISYOUSX3)
    public Long getZrntyokugokyuuhutaisyousx3() {
        return zrntyokugokyuuhutaisyousx3;
    }

    public void setZrntyokugokyuuhutaisyousx3(Long pZrntyokugokyuuhutaisyousx3) {
        zrntyokugokyuuhutaisyousx3 = pZrntyokugokyuuhutaisyousx3;
    }

    private Long zrntyokugocbgakux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOCBGAKUX3)
    public Long getZrntyokugocbgakux3() {
        return zrntyokugocbgakux3;
    }

    public void setZrntyokugocbgakux3(Long pZrntyokugocbgakux3) {
        zrntyokugocbgakux3 = pZrntyokugocbgakux3;
    }

    private String zrnyobiv12x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X3)
    public String getZrnyobiv12x3() {
        return zrnyobiv12x3;
    }

    public void setZrnyobiv12x3(String pZrnyobiv12x3) {
        zrnyobiv12x3 = pZrnyobiv12x3;
    }

    private Long zrntyokuzentuusanhanteisx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENTUUSANHANTEISX4)
    public Long getZrntyokuzentuusanhanteisx4() {
        return zrntyokuzentuusanhanteisx4;
    }

    public void setZrntyokuzentuusanhanteisx4(Long pZrntyokuzentuusanhanteisx4) {
        zrntyokuzentuusanhanteisx4 = pZrntyokuzentuusanhanteisx4;
    }

    private Long zrntyokuzenkyuuhutaisyousx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENKYUUHUTAISYOUSX4)
    public Long getZrntyokuzenkyuuhutaisyousx4() {
        return zrntyokuzenkyuuhutaisyousx4;
    }

    public void setZrntyokuzenkyuuhutaisyousx4(Long pZrntyokuzenkyuuhutaisyousx4) {
        zrntyokuzenkyuuhutaisyousx4 = pZrntyokuzenkyuuhutaisyousx4;
    }

    private Long zrntyokuzencbgakux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENCBGAKUX4)
    public Long getZrntyokuzencbgakux4() {
        return zrntyokuzencbgakux4;
    }

    public void setZrntyokuzencbgakux4(Long pZrntyokuzencbgakux4) {
        zrntyokuzencbgakux4 = pZrntyokuzencbgakux4;
    }

    private Long zrntyokugotuusanhanteisx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOTUUSANHANTEISX4)
    public Long getZrntyokugotuusanhanteisx4() {
        return zrntyokugotuusanhanteisx4;
    }

    public void setZrntyokugotuusanhanteisx4(Long pZrntyokugotuusanhanteisx4) {
        zrntyokugotuusanhanteisx4 = pZrntyokugotuusanhanteisx4;
    }

    private Long zrntyokugokyuuhutaisyousx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOKYUUHUTAISYOUSX4)
    public Long getZrntyokugokyuuhutaisyousx4() {
        return zrntyokugokyuuhutaisyousx4;
    }

    public void setZrntyokugokyuuhutaisyousx4(Long pZrntyokugokyuuhutaisyousx4) {
        zrntyokugokyuuhutaisyousx4 = pZrntyokugokyuuhutaisyousx4;
    }

    private Long zrntyokugocbgakux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOCBGAKUX4)
    public Long getZrntyokugocbgakux4() {
        return zrntyokugocbgakux4;
    }

    public void setZrntyokugocbgakux4(Long pZrntyokugocbgakux4) {
        zrntyokugocbgakux4 = pZrntyokugocbgakux4;
    }

    private String zrnyobiv12x4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X4)
    public String getZrnyobiv12x4() {
        return zrnyobiv12x4;
    }

    public void setZrnyobiv12x4(String pZrnyobiv12x4) {
        zrnyobiv12x4 = pZrnyobiv12x4;
    }

    private Long zrntyokuzentuusanhanteisx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENTUUSANHANTEISX5)
    public Long getZrntyokuzentuusanhanteisx5() {
        return zrntyokuzentuusanhanteisx5;
    }

    public void setZrntyokuzentuusanhanteisx5(Long pZrntyokuzentuusanhanteisx5) {
        zrntyokuzentuusanhanteisx5 = pZrntyokuzentuusanhanteisx5;
    }

    private Long zrntyokuzenkyuuhutaisyousx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENKYUUHUTAISYOUSX5)
    public Long getZrntyokuzenkyuuhutaisyousx5() {
        return zrntyokuzenkyuuhutaisyousx5;
    }

    public void setZrntyokuzenkyuuhutaisyousx5(Long pZrntyokuzenkyuuhutaisyousx5) {
        zrntyokuzenkyuuhutaisyousx5 = pZrntyokuzenkyuuhutaisyousx5;
    }

    private Long zrntyokuzencbgakux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENCBGAKUX5)
    public Long getZrntyokuzencbgakux5() {
        return zrntyokuzencbgakux5;
    }

    public void setZrntyokuzencbgakux5(Long pZrntyokuzencbgakux5) {
        zrntyokuzencbgakux5 = pZrntyokuzencbgakux5;
    }

    private Long zrntyokugotuusanhanteisx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOTUUSANHANTEISX5)
    public Long getZrntyokugotuusanhanteisx5() {
        return zrntyokugotuusanhanteisx5;
    }

    public void setZrntyokugotuusanhanteisx5(Long pZrntyokugotuusanhanteisx5) {
        zrntyokugotuusanhanteisx5 = pZrntyokugotuusanhanteisx5;
    }

    private Long zrntyokugokyuuhutaisyousx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOKYUUHUTAISYOUSX5)
    public Long getZrntyokugokyuuhutaisyousx5() {
        return zrntyokugokyuuhutaisyousx5;
    }

    public void setZrntyokugokyuuhutaisyousx5(Long pZrntyokugokyuuhutaisyousx5) {
        zrntyokugokyuuhutaisyousx5 = pZrntyokugokyuuhutaisyousx5;
    }

    private Long zrntyokugocbgakux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOCBGAKUX5)
    public Long getZrntyokugocbgakux5() {
        return zrntyokugocbgakux5;
    }

    public void setZrntyokugocbgakux5(Long pZrntyokugocbgakux5) {
        zrntyokugocbgakux5 = pZrntyokugocbgakux5;
    }

    private String zrnyobiv12x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X5)
    public String getZrnyobiv12x5() {
        return zrnyobiv12x5;
    }

    public void setZrnyobiv12x5(String pZrnyobiv12x5) {
        zrnyobiv12x5 = pZrnyobiv12x5;
    }

    private Long zrntyokuzentuusanhanteisx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENTUUSANHANTEISX6)
    public Long getZrntyokuzentuusanhanteisx6() {
        return zrntyokuzentuusanhanteisx6;
    }

    public void setZrntyokuzentuusanhanteisx6(Long pZrntyokuzentuusanhanteisx6) {
        zrntyokuzentuusanhanteisx6 = pZrntyokuzentuusanhanteisx6;
    }

    private Long zrntyokuzenkyuuhutaisyousx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENKYUUHUTAISYOUSX6)
    public Long getZrntyokuzenkyuuhutaisyousx6() {
        return zrntyokuzenkyuuhutaisyousx6;
    }

    public void setZrntyokuzenkyuuhutaisyousx6(Long pZrntyokuzenkyuuhutaisyousx6) {
        zrntyokuzenkyuuhutaisyousx6 = pZrntyokuzenkyuuhutaisyousx6;
    }

    private Long zrntyokuzencbgakux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUZENCBGAKUX6)
    public Long getZrntyokuzencbgakux6() {
        return zrntyokuzencbgakux6;
    }

    public void setZrntyokuzencbgakux6(Long pZrntyokuzencbgakux6) {
        zrntyokuzencbgakux6 = pZrntyokuzencbgakux6;
    }

    private Long zrntyokugotuusanhanteisx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOTUUSANHANTEISX6)
    public Long getZrntyokugotuusanhanteisx6() {
        return zrntyokugotuusanhanteisx6;
    }

    public void setZrntyokugotuusanhanteisx6(Long pZrntyokugotuusanhanteisx6) {
        zrntyokugotuusanhanteisx6 = pZrntyokugotuusanhanteisx6;
    }

    private Long zrntyokugokyuuhutaisyousx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOKYUUHUTAISYOUSX6)
    public Long getZrntyokugokyuuhutaisyousx6() {
        return zrntyokugokyuuhutaisyousx6;
    }

    public void setZrntyokugokyuuhutaisyousx6(Long pZrntyokugokyuuhutaisyousx6) {
        zrntyokugokyuuhutaisyousx6 = pZrntyokugokyuuhutaisyousx6;
    }

    private Long zrntyokugocbgakux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTYOKUGOCBGAKUX6)
    public Long getZrntyokugocbgakux6() {
        return zrntyokugocbgakux6;
    }

    public void setZrntyokugocbgakux6(Long pZrntyokugocbgakux6) {
        zrntyokugocbgakux6 = pZrntyokugocbgakux6;
    }

    private String zrnyobiv12x6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X6)
    public String getZrnyobiv12x6() {
        return zrnyobiv12x6;
    }

    public void setZrnyobiv12x6(String pZrnyobiv12x6) {
        zrnyobiv12x6 = pZrnyobiv12x6;
    }

    private String zrncbkikyksyonox1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKSYONOX1)
    public String getZrncbkikyksyonox1() {
        return zrncbkikyksyonox1;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrncbkikyksyonox1(String pZrncbkikyksyonox1) {
        zrncbkikyksyonox1 = pZrncbkikyksyonox1;
    }

    private String zrncbkikykhknsyruikbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHKNSYRUIKBNX1)
    public String getZrncbkikykhknsyruikbnx1() {
        return zrncbkikykhknsyruikbnx1;
    }

    public void setZrncbkikykhknsyruikbnx1(String pZrncbkikykhknsyruikbnx1) {
        zrncbkikykhknsyruikbnx1 = pZrncbkikykhknsyruikbnx1;
    }

    private String zrncbkikeiyakukeiyakuymdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKEIYAKUKEIYAKUYMDX1)
    public String getZrncbkikeiyakukeiyakuymdx1() {
        return zrncbkikeiyakukeiyakuymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrncbkikeiyakukeiyakuymdx1(String pZrncbkikeiyakukeiyakuymdx1) {
        zrncbkikeiyakukeiyakuymdx1 = pZrncbkikeiyakukeiyakuymdx1;
    }

    private String zrncbkikykkyhtisyukbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKKYHTISYUKBNX1)
    public String getZrncbkikykkyhtisyukbnx1() {
        return zrncbkikykkyhtisyukbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbkikykkyhtisyukbnx1(String pZrncbkikykkyhtisyukbnx1) {
        zrncbkikykkyhtisyukbnx1 = pZrncbkikykkyhtisyukbnx1;
    }

    private String zrncbkikykhntitaisyoukbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHNTITAISYOUKBNX1)
    public String getZrncbkikykhntitaisyoukbnx1() {
        return zrncbkikykhntitaisyoukbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbkikykhntitaisyoukbnx1(String pZrncbkikykhntitaisyoukbnx1) {
        zrncbkikykhntitaisyoukbnx1 = pZrncbkikykhntitaisyoukbnx1;
    }

    private Long zrnkikeiyakucbgakux1x1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUCBGAKUX1X1)
    public Long getZrnkikeiyakucbgakux1x1() {
        return zrnkikeiyakucbgakux1x1;
    }

    public void setZrnkikeiyakucbgakux1x1(Long pZrnkikeiyakucbgakux1x1) {
        zrnkikeiyakucbgakux1x1 = pZrnkikeiyakucbgakux1x1;
    }

    private Long zrnkikeiyakucbgakux2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUCBGAKUX2X1)
    public Long getZrnkikeiyakucbgakux2x1() {
        return zrnkikeiyakucbgakux2x1;
    }

    public void setZrnkikeiyakucbgakux2x1(Long pZrnkikeiyakucbgakux2x1) {
        zrnkikeiyakucbgakux2x1 = pZrnkikeiyakucbgakux2x1;
    }

    private Long zrncbkikykhanteitsnsx1x1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHANTEITSNSX1X1)
    public Long getZrncbkikykhanteitsnsx1x1() {
        return zrncbkikykhanteitsnsx1x1;
    }

    public void setZrncbkikykhanteitsnsx1x1(Long pZrncbkikykhanteitsnsx1x1) {
        zrncbkikykhanteitsnsx1x1 = pZrncbkikykhanteitsnsx1x1;
    }

    private Long zrncbkikykhanteitsnsx2x1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHANTEITSNSX2X1)
    public Long getZrncbkikykhanteitsnsx2x1() {
        return zrncbkikykhanteitsnsx2x1;
    }

    public void setZrncbkikykhanteitsnsx2x1(Long pZrncbkikykhanteitsnsx2x1) {
        zrncbkikykhanteitsnsx2x1 = pZrncbkikykhanteitsnsx2x1;
    }

    private String zrnyobiv12x7;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X7)
    public String getZrnyobiv12x7() {
        return zrnyobiv12x7;
    }

    public void setZrnyobiv12x7(String pZrnyobiv12x7) {
        zrnyobiv12x7 = pZrnyobiv12x7;
    }

    private String zrncbkikyksyonox2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKSYONOX2)
    public String getZrncbkikyksyonox2() {
        return zrncbkikyksyonox2;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrncbkikyksyonox2(String pZrncbkikyksyonox2) {
        zrncbkikyksyonox2 = pZrncbkikyksyonox2;
    }

    private String zrncbkikykhknsyruikbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHKNSYRUIKBNX2)
    public String getZrncbkikykhknsyruikbnx2() {
        return zrncbkikykhknsyruikbnx2;
    }

    public void setZrncbkikykhknsyruikbnx2(String pZrncbkikykhknsyruikbnx2) {
        zrncbkikykhknsyruikbnx2 = pZrncbkikykhknsyruikbnx2;
    }

    private String zrncbkikeiyakukeiyakuymdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKEIYAKUKEIYAKUYMDX2)
    public String getZrncbkikeiyakukeiyakuymdx2() {
        return zrncbkikeiyakukeiyakuymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrncbkikeiyakukeiyakuymdx2(String pZrncbkikeiyakukeiyakuymdx2) {
        zrncbkikeiyakukeiyakuymdx2 = pZrncbkikeiyakukeiyakuymdx2;
    }

    private String zrncbkikykkyhtisyukbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKKYHTISYUKBNX2)
    public String getZrncbkikykkyhtisyukbnx2() {
        return zrncbkikykkyhtisyukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbkikykkyhtisyukbnx2(String pZrncbkikykkyhtisyukbnx2) {
        zrncbkikykkyhtisyukbnx2 = pZrncbkikykkyhtisyukbnx2;
    }

    private String zrncbkikykhntitaisyoukbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHNTITAISYOUKBNX2)
    public String getZrncbkikykhntitaisyoukbnx2() {
        return zrncbkikykhntitaisyoukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbkikykhntitaisyoukbnx2(String pZrncbkikykhntitaisyoukbnx2) {
        zrncbkikykhntitaisyoukbnx2 = pZrncbkikykhntitaisyoukbnx2;
    }

    private Long zrnkikeiyakucbgakux1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUCBGAKUX1X2)
    public Long getZrnkikeiyakucbgakux1x2() {
        return zrnkikeiyakucbgakux1x2;
    }

    public void setZrnkikeiyakucbgakux1x2(Long pZrnkikeiyakucbgakux1x2) {
        zrnkikeiyakucbgakux1x2 = pZrnkikeiyakucbgakux1x2;
    }

    private Long zrnkikeiyakucbgakux2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUCBGAKUX2X2)
    public Long getZrnkikeiyakucbgakux2x2() {
        return zrnkikeiyakucbgakux2x2;
    }

    public void setZrnkikeiyakucbgakux2x2(Long pZrnkikeiyakucbgakux2x2) {
        zrnkikeiyakucbgakux2x2 = pZrnkikeiyakucbgakux2x2;
    }

    private Long zrncbkikykhanteitsnsx1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHANTEITSNSX1X2)
    public Long getZrncbkikykhanteitsnsx1x2() {
        return zrncbkikykhanteitsnsx1x2;
    }

    public void setZrncbkikykhanteitsnsx1x2(Long pZrncbkikykhanteitsnsx1x2) {
        zrncbkikykhanteitsnsx1x2 = pZrncbkikykhanteitsnsx1x2;
    }

    private Long zrncbkikykhanteitsnsx2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHANTEITSNSX2X2)
    public Long getZrncbkikykhanteitsnsx2x2() {
        return zrncbkikykhanteitsnsx2x2;
    }

    public void setZrncbkikykhanteitsnsx2x2(Long pZrncbkikykhanteitsnsx2x2) {
        zrncbkikykhanteitsnsx2x2 = pZrncbkikykhanteitsnsx2x2;
    }

    private String zrnyobiv12x8;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X8)
    public String getZrnyobiv12x8() {
        return zrnyobiv12x8;
    }

    public void setZrnyobiv12x8(String pZrnyobiv12x8) {
        zrnyobiv12x8 = pZrnyobiv12x8;
    }

    private String zrncbkikyksyonox3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKSYONOX3)
    public String getZrncbkikyksyonox3() {
        return zrncbkikyksyonox3;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrncbkikyksyonox3(String pZrncbkikyksyonox3) {
        zrncbkikyksyonox3 = pZrncbkikyksyonox3;
    }

    private String zrncbkikykhknsyruikbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHKNSYRUIKBNX3)
    public String getZrncbkikykhknsyruikbnx3() {
        return zrncbkikykhknsyruikbnx3;
    }

    public void setZrncbkikykhknsyruikbnx3(String pZrncbkikykhknsyruikbnx3) {
        zrncbkikykhknsyruikbnx3 = pZrncbkikykhknsyruikbnx3;
    }

    private String zrncbkikeiyakukeiyakuymdx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKEIYAKUKEIYAKUYMDX3)
    public String getZrncbkikeiyakukeiyakuymdx3() {
        return zrncbkikeiyakukeiyakuymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrncbkikeiyakukeiyakuymdx3(String pZrncbkikeiyakukeiyakuymdx3) {
        zrncbkikeiyakukeiyakuymdx3 = pZrncbkikeiyakukeiyakuymdx3;
    }

    private String zrncbkikykkyhtisyukbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKKYHTISYUKBNX3)
    public String getZrncbkikykkyhtisyukbnx3() {
        return zrncbkikykkyhtisyukbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbkikykkyhtisyukbnx3(String pZrncbkikykkyhtisyukbnx3) {
        zrncbkikykkyhtisyukbnx3 = pZrncbkikykkyhtisyukbnx3;
    }

    private String zrncbkikykhntitaisyoukbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHNTITAISYOUKBNX3)
    public String getZrncbkikykhntitaisyoukbnx3() {
        return zrncbkikykhntitaisyoukbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncbkikykhntitaisyoukbnx3(String pZrncbkikykhntitaisyoukbnx3) {
        zrncbkikykhntitaisyoukbnx3 = pZrncbkikykhntitaisyoukbnx3;
    }

    private Long zrnkikeiyakucbgakux1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUCBGAKUX1X3)
    public Long getZrnkikeiyakucbgakux1x3() {
        return zrnkikeiyakucbgakux1x3;
    }

    public void setZrnkikeiyakucbgakux1x3(Long pZrnkikeiyakucbgakux1x3) {
        zrnkikeiyakucbgakux1x3 = pZrnkikeiyakucbgakux1x3;
    }

    private Long zrnkikeiyakucbgakux2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIKEIYAKUCBGAKUX2X3)
    public Long getZrnkikeiyakucbgakux2x3() {
        return zrnkikeiyakucbgakux2x3;
    }

    public void setZrnkikeiyakucbgakux2x3(Long pZrnkikeiyakucbgakux2x3) {
        zrnkikeiyakucbgakux2x3 = pZrnkikeiyakucbgakux2x3;
    }

    private Long zrncbkikykhanteitsnsx1x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHANTEITSNSX1X3)
    public Long getZrncbkikykhanteitsnsx1x3() {
        return zrncbkikykhanteitsnsx1x3;
    }

    public void setZrncbkikykhanteitsnsx1x3(Long pZrncbkikykhanteitsnsx1x3) {
        zrncbkikykhanteitsnsx1x3 = pZrncbkikykhanteitsnsx1x3;
    }

    private Long zrncbkikykhanteitsnsx2x3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNCBKIKYKHANTEITSNSX2X3)
    public Long getZrncbkikykhanteitsnsx2x3() {
        return zrncbkikykhanteitsnsx2x3;
    }

    public void setZrncbkikykhanteitsnsx2x3(Long pZrncbkikykhanteitsnsx2x3) {
        zrncbkikykhanteitsnsx2x3 = pZrncbkikykhanteitsnsx2x3;
    }

    private String zrnyobiv12x9;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X9)
    public String getZrnyobiv12x9() {
        return zrnyobiv12x9;
    }

    public void setZrnyobiv12x9(String pZrnyobiv12x9) {
        zrnyobiv12x9 = pZrnyobiv12x9;
    }

    private String zrnhtnknhknsyrikgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNHKNSYRIKGUSDKBNX1)
    public String getZrnhtnknhknsyrikgusdkbnx1() {
        return zrnhtnknhknsyrikgusdkbnx1;
    }

    public void setZrnhtnknhknsyrikgusdkbnx1(String pZrnhtnknhknsyrikgusdkbnx1) {
        zrnhtnknhknsyrikgusdkbnx1 = pZrnhtnknhknsyrikgusdkbnx1;
    }

    private String zrnhtnknmrtikgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMRTIKGUSDKBNX1)
    public String getZrnhtnknmrtikgusdkbnx1() {
        return zrnhtnknmrtikgusdkbnx1;
    }

    public void setZrnhtnknmrtikgusdkbnx1(String pZrnhtnknmrtikgusdkbnx1) {
        zrnhtnknmrtikgusdkbnx1 = pZrnhtnknmrtikgusdkbnx1;
    }

    private String zrnhtnknsiznmrtikgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIZNMRTIKGUSDKBNX1)
    public String getZrnhtnknsiznmrtikgusdkbnx1() {
        return zrnhtnknsiznmrtikgusdkbnx1;
    }

    public void setZrnhtnknsiznmrtikgusdkbnx1(String pZrnhtnknsiznmrtikgusdkbnx1) {
        zrnhtnknsiznmrtikgusdkbnx1 = pZrnhtnknsiznmrtikgusdkbnx1;
    }

    private String zrnhtnkntignmrtikgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTIGNMRTIKGUSDKBNX1)
    public String getZrnhtnkntignmrtikgusdkbnx1() {
        return zrnhtnkntignmrtikgusdkbnx1;
    }

    public void setZrnhtnkntignmrtikgusdkbnx1(String pZrnhtnkntignmrtikgusdkbnx1) {
        zrnhtnkntignmrtikgusdkbnx1 = pZrnhtnkntignmrtikgusdkbnx1;
    }

    private String zrnhtnknnkmrtikgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKMRTIKGUSDKBNX1)
    public String getZrnhtnknnkmrtikgusdkbnx1() {
        return zrnhtnknnkmrtikgusdkbnx1;
    }

    public void setZrnhtnknnkmrtikgusdkbnx1(String pZrnhtnknnkmrtikgusdkbnx1) {
        zrnhtnknnkmrtikgusdkbnx1 = pZrnhtnknnkmrtikgusdkbnx1;
    }

    private String zrnhtnkntkstkgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKSTKGUSDKBNX1)
    public String getZrnhtnkntkstkgusdkbnx1() {
        return zrnhtnkntkstkgusdkbnx1;
    }

    public void setZrnhtnkntkstkgusdkbnx1(String pZrnhtnkntkstkgusdkbnx1) {
        zrnhtnkntkstkgusdkbnx1 = pZrnhtnkntkstkgusdkbnx1;
    }

    private String zrnhtnkndi2tkstkgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKSTKGUSDKBNX1)
    public String getZrnhtnkndi2tkstkgusdkbnx1() {
        return zrnhtnkndi2tkstkgusdkbnx1;
    }

    public void setZrnhtnkndi2tkstkgusdkbnx1(String pZrnhtnkndi2tkstkgusdkbnx1) {
        zrnhtnkndi2tkstkgusdkbnx1 = pZrnhtnkndi2tkstkgusdkbnx1;
    }

    private String zrnhtnknjyustkgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYUSTKGUSDKBNX1)
    public String getZrnhtnknjyustkgusdkbnx1() {
        return zrnhtnknjyustkgusdkbnx1;
    }

    public void setZrnhtnknjyustkgusdkbnx1(String pZrnhtnknjyustkgusdkbnx1) {
        zrnhtnknjyustkgusdkbnx1 = pZrnhtnknjyustkgusdkbnx1;
    }

    private String zrnhtnkndi2jysitkgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2JYSITKGUSDKBNX1)
    public String getZrnhtnkndi2jysitkgusdkbnx1() {
        return zrnhtnkndi2jysitkgusdkbnx1;
    }

    public void setZrnhtnkndi2jysitkgusdkbnx1(String pZrnhtnkndi2jysitkgusdkbnx1) {
        zrnhtnkndi2jysitkgusdkbnx1 = pZrnhtnkndi2jysitkgusdkbnx1;
    }

    private String zrnhtnknkaigonkmrtisdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTISDKBNX1)
    public String getZrnhtnknkaigonkmrtisdkbnx1() {
        return zrnhtnknkaigonkmrtisdkbnx1;
    }

    public void setZrnhtnknkaigonkmrtisdkbnx1(String pZrnhtnknkaigonkmrtisdkbnx1) {
        zrnhtnknkaigonkmrtisdkbnx1 = pZrnhtnknkaigonkmrtisdkbnx1;
    }

    private String zrnhtnknkigtignmrtisdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTISDKBNX1)
    public String getZrnhtnknkigtignmrtisdkbnx1() {
        return zrnhtnknkigtignmrtisdkbnx1;
    }

    public void setZrnhtnknkigtignmrtisdkbnx1(String pZrnhtnknkigtignmrtisdkbnx1) {
        zrnhtnknkigtignmrtisdkbnx1 = pZrnhtnknkigtignmrtisdkbnx1;
    }

    private String zrnhtnknkaigomrsykgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRSYKGUSDKBNX1)
    public String getZrnhtnknkaigomrsykgusdkbnx1() {
        return zrnhtnknkaigomrsykgusdkbnx1;
    }

    public void setZrnhtnknkaigomrsykgusdkbnx1(String pZrnhtnknkaigomrsykgusdkbnx1) {
        zrnhtnknkaigomrsykgusdkbnx1 = pZrnhtnknkaigomrsykgusdkbnx1;
    }

    private String zrnsuuriyouyobiv8x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSUURIYOUYOBIV8X2)
    public String getZrnsuuriyouyobiv8x2() {
        return zrnsuuriyouyobiv8x2;
    }

    public void setZrnsuuriyouyobiv8x2(String pZrnsuuriyouyobiv8x2) {
        zrnsuuriyouyobiv8x2 = pZrnsuuriyouyobiv8x2;
    }

    private String zrnhtnknhknsyrikgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNHKNSYRIKGUSDKBNX2)
    public String getZrnhtnknhknsyrikgusdkbnx2() {
        return zrnhtnknhknsyrikgusdkbnx2;
    }

    public void setZrnhtnknhknsyrikgusdkbnx2(String pZrnhtnknhknsyrikgusdkbnx2) {
        zrnhtnknhknsyrikgusdkbnx2 = pZrnhtnknhknsyrikgusdkbnx2;
    }

    private String zrnhtnknmrtikgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMRTIKGUSDKBNX2)
    public String getZrnhtnknmrtikgusdkbnx2() {
        return zrnhtnknmrtikgusdkbnx2;
    }

    public void setZrnhtnknmrtikgusdkbnx2(String pZrnhtnknmrtikgusdkbnx2) {
        zrnhtnknmrtikgusdkbnx2 = pZrnhtnknmrtikgusdkbnx2;
    }

    private String zrnhtnknsiznmrtikgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIZNMRTIKGUSDKBNX2)
    public String getZrnhtnknsiznmrtikgusdkbnx2() {
        return zrnhtnknsiznmrtikgusdkbnx2;
    }

    public void setZrnhtnknsiznmrtikgusdkbnx2(String pZrnhtnknsiznmrtikgusdkbnx2) {
        zrnhtnknsiznmrtikgusdkbnx2 = pZrnhtnknsiznmrtikgusdkbnx2;
    }

    private String zrnhtnkntignmrtikgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTIGNMRTIKGUSDKBNX2)
    public String getZrnhtnkntignmrtikgusdkbnx2() {
        return zrnhtnkntignmrtikgusdkbnx2;
    }

    public void setZrnhtnkntignmrtikgusdkbnx2(String pZrnhtnkntignmrtikgusdkbnx2) {
        zrnhtnkntignmrtikgusdkbnx2 = pZrnhtnkntignmrtikgusdkbnx2;
    }

    private String zrnhtnknnkmrtikgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKMRTIKGUSDKBNX2)
    public String getZrnhtnknnkmrtikgusdkbnx2() {
        return zrnhtnknnkmrtikgusdkbnx2;
    }

    public void setZrnhtnknnkmrtikgusdkbnx2(String pZrnhtnknnkmrtikgusdkbnx2) {
        zrnhtnknnkmrtikgusdkbnx2 = pZrnhtnknnkmrtikgusdkbnx2;
    }

    private String zrnhtnkntkstkgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKSTKGUSDKBNX2)
    public String getZrnhtnkntkstkgusdkbnx2() {
        return zrnhtnkntkstkgusdkbnx2;
    }

    public void setZrnhtnkntkstkgusdkbnx2(String pZrnhtnkntkstkgusdkbnx2) {
        zrnhtnkntkstkgusdkbnx2 = pZrnhtnkntkstkgusdkbnx2;
    }

    private String zrnhtnkndi2tkstkgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKSTKGUSDKBNX2)
    public String getZrnhtnkndi2tkstkgusdkbnx2() {
        return zrnhtnkndi2tkstkgusdkbnx2;
    }

    public void setZrnhtnkndi2tkstkgusdkbnx2(String pZrnhtnkndi2tkstkgusdkbnx2) {
        zrnhtnkndi2tkstkgusdkbnx2 = pZrnhtnkndi2tkstkgusdkbnx2;
    }

    private String zrnhtnknjyustkgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYUSTKGUSDKBNX2)
    public String getZrnhtnknjyustkgusdkbnx2() {
        return zrnhtnknjyustkgusdkbnx2;
    }

    public void setZrnhtnknjyustkgusdkbnx2(String pZrnhtnknjyustkgusdkbnx2) {
        zrnhtnknjyustkgusdkbnx2 = pZrnhtnknjyustkgusdkbnx2;
    }

    private String zrnhtnkndi2jysitkgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2JYSITKGUSDKBNX2)
    public String getZrnhtnkndi2jysitkgusdkbnx2() {
        return zrnhtnkndi2jysitkgusdkbnx2;
    }

    public void setZrnhtnkndi2jysitkgusdkbnx2(String pZrnhtnkndi2jysitkgusdkbnx2) {
        zrnhtnkndi2jysitkgusdkbnx2 = pZrnhtnkndi2jysitkgusdkbnx2;
    }

    private String zrnhtnknkaigonkmrtisdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTISDKBNX2)
    public String getZrnhtnknkaigonkmrtisdkbnx2() {
        return zrnhtnknkaigonkmrtisdkbnx2;
    }

    public void setZrnhtnknkaigonkmrtisdkbnx2(String pZrnhtnknkaigonkmrtisdkbnx2) {
        zrnhtnknkaigonkmrtisdkbnx2 = pZrnhtnknkaigonkmrtisdkbnx2;
    }

    private String zrnhtnknkigtignmrtisdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTISDKBNX2)
    public String getZrnhtnknkigtignmrtisdkbnx2() {
        return zrnhtnknkigtignmrtisdkbnx2;
    }

    public void setZrnhtnknkigtignmrtisdkbnx2(String pZrnhtnknkigtignmrtisdkbnx2) {
        zrnhtnknkigtignmrtisdkbnx2 = pZrnhtnknkigtignmrtisdkbnx2;
    }

    private String zrnhtnknkaigomrsykgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRSYKGUSDKBNX2)
    public String getZrnhtnknkaigomrsykgusdkbnx2() {
        return zrnhtnknkaigomrsykgusdkbnx2;
    }

    public void setZrnhtnknkaigomrsykgusdkbnx2(String pZrnhtnknkaigomrsykgusdkbnx2) {
        zrnhtnknkaigomrsykgusdkbnx2 = pZrnhtnknkaigomrsykgusdkbnx2;
    }

    private String zrnyobiv8x5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X5)
    public String getZrnyobiv8x5() {
        return zrnyobiv8x5;
    }

    public void setZrnyobiv8x5(String pZrnyobiv8x5) {
        zrnyobiv8x5 = pZrnyobiv8x5;
    }

    private String zrnhtnknhknsyrikgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNHKNSYRIKGUSDKBNX3)
    public String getZrnhtnknhknsyrikgusdkbnx3() {
        return zrnhtnknhknsyrikgusdkbnx3;
    }

    public void setZrnhtnknhknsyrikgusdkbnx3(String pZrnhtnknhknsyrikgusdkbnx3) {
        zrnhtnknhknsyrikgusdkbnx3 = pZrnhtnknhknsyrikgusdkbnx3;
    }

    private String zrnhtnknmrtikgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMRTIKGUSDKBNX3)
    public String getZrnhtnknmrtikgusdkbnx3() {
        return zrnhtnknmrtikgusdkbnx3;
    }

    public void setZrnhtnknmrtikgusdkbnx3(String pZrnhtnknmrtikgusdkbnx3) {
        zrnhtnknmrtikgusdkbnx3 = pZrnhtnknmrtikgusdkbnx3;
    }

    private String zrnhtnknsiznmrtikgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIZNMRTIKGUSDKBNX3)
    public String getZrnhtnknsiznmrtikgusdkbnx3() {
        return zrnhtnknsiznmrtikgusdkbnx3;
    }

    public void setZrnhtnknsiznmrtikgusdkbnx3(String pZrnhtnknsiznmrtikgusdkbnx3) {
        zrnhtnknsiznmrtikgusdkbnx3 = pZrnhtnknsiznmrtikgusdkbnx3;
    }

    private String zrnhtnkntignmrtikgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTIGNMRTIKGUSDKBNX3)
    public String getZrnhtnkntignmrtikgusdkbnx3() {
        return zrnhtnkntignmrtikgusdkbnx3;
    }

    public void setZrnhtnkntignmrtikgusdkbnx3(String pZrnhtnkntignmrtikgusdkbnx3) {
        zrnhtnkntignmrtikgusdkbnx3 = pZrnhtnkntignmrtikgusdkbnx3;
    }

    private String zrnhtnknnkmrtikgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKMRTIKGUSDKBNX3)
    public String getZrnhtnknnkmrtikgusdkbnx3() {
        return zrnhtnknnkmrtikgusdkbnx3;
    }

    public void setZrnhtnknnkmrtikgusdkbnx3(String pZrnhtnknnkmrtikgusdkbnx3) {
        zrnhtnknnkmrtikgusdkbnx3 = pZrnhtnknnkmrtikgusdkbnx3;
    }

    private String zrnhtnkntkstkgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKSTKGUSDKBNX3)
    public String getZrnhtnkntkstkgusdkbnx3() {
        return zrnhtnkntkstkgusdkbnx3;
    }

    public void setZrnhtnkntkstkgusdkbnx3(String pZrnhtnkntkstkgusdkbnx3) {
        zrnhtnkntkstkgusdkbnx3 = pZrnhtnkntkstkgusdkbnx3;
    }

    private String zrnhtnkndi2tkstkgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKSTKGUSDKBNX3)
    public String getZrnhtnkndi2tkstkgusdkbnx3() {
        return zrnhtnkndi2tkstkgusdkbnx3;
    }

    public void setZrnhtnkndi2tkstkgusdkbnx3(String pZrnhtnkndi2tkstkgusdkbnx3) {
        zrnhtnkndi2tkstkgusdkbnx3 = pZrnhtnkndi2tkstkgusdkbnx3;
    }

    private String zrnhtnknjyustkgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYUSTKGUSDKBNX3)
    public String getZrnhtnknjyustkgusdkbnx3() {
        return zrnhtnknjyustkgusdkbnx3;
    }

    public void setZrnhtnknjyustkgusdkbnx3(String pZrnhtnknjyustkgusdkbnx3) {
        zrnhtnknjyustkgusdkbnx3 = pZrnhtnknjyustkgusdkbnx3;
    }

    private String zrnhtnkndi2jysitkgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2JYSITKGUSDKBNX3)
    public String getZrnhtnkndi2jysitkgusdkbnx3() {
        return zrnhtnkndi2jysitkgusdkbnx3;
    }

    public void setZrnhtnkndi2jysitkgusdkbnx3(String pZrnhtnkndi2jysitkgusdkbnx3) {
        zrnhtnkndi2jysitkgusdkbnx3 = pZrnhtnkndi2jysitkgusdkbnx3;
    }

    private String zrnhtnknkaigonkmrtisdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTISDKBNX3)
    public String getZrnhtnknkaigonkmrtisdkbnx3() {
        return zrnhtnknkaigonkmrtisdkbnx3;
    }

    public void setZrnhtnknkaigonkmrtisdkbnx3(String pZrnhtnknkaigonkmrtisdkbnx3) {
        zrnhtnknkaigonkmrtisdkbnx3 = pZrnhtnknkaigonkmrtisdkbnx3;
    }

    private String zrnhtnknkigtignmrtisdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTISDKBNX3)
    public String getZrnhtnknkigtignmrtisdkbnx3() {
        return zrnhtnknkigtignmrtisdkbnx3;
    }

    public void setZrnhtnknkigtignmrtisdkbnx3(String pZrnhtnknkigtignmrtisdkbnx3) {
        zrnhtnknkigtignmrtisdkbnx3 = pZrnhtnknkigtignmrtisdkbnx3;
    }

    private String zrnhtnknkaigomrsykgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRSYKGUSDKBNX3)
    public String getZrnhtnknkaigomrsykgusdkbnx3() {
        return zrnhtnknkaigomrsykgusdkbnx3;
    }

    public void setZrnhtnknkaigomrsykgusdkbnx3(String pZrnhtnknkaigomrsykgusdkbnx3) {
        zrnhtnknkaigomrsykgusdkbnx3 = pZrnhtnknkaigomrsykgusdkbnx3;
    }

    private String zrnyobiv8x6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X6)
    public String getZrnyobiv8x6() {
        return zrnyobiv8x6;
    }

    public void setZrnyobiv8x6(String pZrnyobiv8x6) {
        zrnyobiv8x6 = pZrnyobiv8x6;
    }

    private String zrnhtnknhknsyrikgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNHKNSYRIKGUSDKBNX4)
    public String getZrnhtnknhknsyrikgusdkbnx4() {
        return zrnhtnknhknsyrikgusdkbnx4;
    }

    public void setZrnhtnknhknsyrikgusdkbnx4(String pZrnhtnknhknsyrikgusdkbnx4) {
        zrnhtnknhknsyrikgusdkbnx4 = pZrnhtnknhknsyrikgusdkbnx4;
    }

    private String zrnhtnknmrtikgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMRTIKGUSDKBNX4)
    public String getZrnhtnknmrtikgusdkbnx4() {
        return zrnhtnknmrtikgusdkbnx4;
    }

    public void setZrnhtnknmrtikgusdkbnx4(String pZrnhtnknmrtikgusdkbnx4) {
        zrnhtnknmrtikgusdkbnx4 = pZrnhtnknmrtikgusdkbnx4;
    }

    private String zrnhtnknsiznmrtikgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIZNMRTIKGUSDKBNX4)
    public String getZrnhtnknsiznmrtikgusdkbnx4() {
        return zrnhtnknsiznmrtikgusdkbnx4;
    }

    public void setZrnhtnknsiznmrtikgusdkbnx4(String pZrnhtnknsiznmrtikgusdkbnx4) {
        zrnhtnknsiznmrtikgusdkbnx4 = pZrnhtnknsiznmrtikgusdkbnx4;
    }

    private String zrnhtnkntignmrtikgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTIGNMRTIKGUSDKBNX4)
    public String getZrnhtnkntignmrtikgusdkbnx4() {
        return zrnhtnkntignmrtikgusdkbnx4;
    }

    public void setZrnhtnkntignmrtikgusdkbnx4(String pZrnhtnkntignmrtikgusdkbnx4) {
        zrnhtnkntignmrtikgusdkbnx4 = pZrnhtnkntignmrtikgusdkbnx4;
    }

    private String zrnhtnknnkmrtikgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKMRTIKGUSDKBNX4)
    public String getZrnhtnknnkmrtikgusdkbnx4() {
        return zrnhtnknnkmrtikgusdkbnx4;
    }

    public void setZrnhtnknnkmrtikgusdkbnx4(String pZrnhtnknnkmrtikgusdkbnx4) {
        zrnhtnknnkmrtikgusdkbnx4 = pZrnhtnknnkmrtikgusdkbnx4;
    }

    private String zrnhtnkntkstkgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKSTKGUSDKBNX4)
    public String getZrnhtnkntkstkgusdkbnx4() {
        return zrnhtnkntkstkgusdkbnx4;
    }

    public void setZrnhtnkntkstkgusdkbnx4(String pZrnhtnkntkstkgusdkbnx4) {
        zrnhtnkntkstkgusdkbnx4 = pZrnhtnkntkstkgusdkbnx4;
    }

    private String zrnhtnkndi2tkstkgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKSTKGUSDKBNX4)
    public String getZrnhtnkndi2tkstkgusdkbnx4() {
        return zrnhtnkndi2tkstkgusdkbnx4;
    }

    public void setZrnhtnkndi2tkstkgusdkbnx4(String pZrnhtnkndi2tkstkgusdkbnx4) {
        zrnhtnkndi2tkstkgusdkbnx4 = pZrnhtnkndi2tkstkgusdkbnx4;
    }

    private String zrnhtnknjyustkgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYUSTKGUSDKBNX4)
    public String getZrnhtnknjyustkgusdkbnx4() {
        return zrnhtnknjyustkgusdkbnx4;
    }

    public void setZrnhtnknjyustkgusdkbnx4(String pZrnhtnknjyustkgusdkbnx4) {
        zrnhtnknjyustkgusdkbnx4 = pZrnhtnknjyustkgusdkbnx4;
    }

    private String zrnhtnkndi2jysitkgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2JYSITKGUSDKBNX4)
    public String getZrnhtnkndi2jysitkgusdkbnx4() {
        return zrnhtnkndi2jysitkgusdkbnx4;
    }

    public void setZrnhtnkndi2jysitkgusdkbnx4(String pZrnhtnkndi2jysitkgusdkbnx4) {
        zrnhtnkndi2jysitkgusdkbnx4 = pZrnhtnkndi2jysitkgusdkbnx4;
    }

    private String zrnhtnknkaigonkmrtisdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTISDKBNX4)
    public String getZrnhtnknkaigonkmrtisdkbnx4() {
        return zrnhtnknkaigonkmrtisdkbnx4;
    }

    public void setZrnhtnknkaigonkmrtisdkbnx4(String pZrnhtnknkaigonkmrtisdkbnx4) {
        zrnhtnknkaigonkmrtisdkbnx4 = pZrnhtnknkaigonkmrtisdkbnx4;
    }

    private String zrnhtnknkigtignmrtisdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTISDKBNX4)
    public String getZrnhtnknkigtignmrtisdkbnx4() {
        return zrnhtnknkigtignmrtisdkbnx4;
    }

    public void setZrnhtnknkigtignmrtisdkbnx4(String pZrnhtnknkigtignmrtisdkbnx4) {
        zrnhtnknkigtignmrtisdkbnx4 = pZrnhtnknkigtignmrtisdkbnx4;
    }

    private String zrnhtnknkaigomrsykgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRSYKGUSDKBNX4)
    public String getZrnhtnknkaigomrsykgusdkbnx4() {
        return zrnhtnknkaigomrsykgusdkbnx4;
    }

    public void setZrnhtnknkaigomrsykgusdkbnx4(String pZrnhtnknkaigomrsykgusdkbnx4) {
        zrnhtnknkaigomrsykgusdkbnx4 = pZrnhtnknkaigomrsykgusdkbnx4;
    }

    private String zrnyobiv8x7;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X7)
    public String getZrnyobiv8x7() {
        return zrnyobiv8x7;
    }

    public void setZrnyobiv8x7(String pZrnyobiv8x7) {
        zrnyobiv8x7 = pZrnyobiv8x7;
    }

    private String zrnhtnknhknsyrikgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNHKNSYRIKGUSDKBNX5)
    public String getZrnhtnknhknsyrikgusdkbnx5() {
        return zrnhtnknhknsyrikgusdkbnx5;
    }

    public void setZrnhtnknhknsyrikgusdkbnx5(String pZrnhtnknhknsyrikgusdkbnx5) {
        zrnhtnknhknsyrikgusdkbnx5 = pZrnhtnknhknsyrikgusdkbnx5;
    }

    private String zrnhtnknmrtikgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMRTIKGUSDKBNX5)
    public String getZrnhtnknmrtikgusdkbnx5() {
        return zrnhtnknmrtikgusdkbnx5;
    }

    public void setZrnhtnknmrtikgusdkbnx5(String pZrnhtnknmrtikgusdkbnx5) {
        zrnhtnknmrtikgusdkbnx5 = pZrnhtnknmrtikgusdkbnx5;
    }

    private String zrnhtnknsiznmrtikgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIZNMRTIKGUSDKBNX5)
    public String getZrnhtnknsiznmrtikgusdkbnx5() {
        return zrnhtnknsiznmrtikgusdkbnx5;
    }

    public void setZrnhtnknsiznmrtikgusdkbnx5(String pZrnhtnknsiznmrtikgusdkbnx5) {
        zrnhtnknsiznmrtikgusdkbnx5 = pZrnhtnknsiznmrtikgusdkbnx5;
    }

    private String zrnhtnkntignmrtikgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTIGNMRTIKGUSDKBNX5)
    public String getZrnhtnkntignmrtikgusdkbnx5() {
        return zrnhtnkntignmrtikgusdkbnx5;
    }

    public void setZrnhtnkntignmrtikgusdkbnx5(String pZrnhtnkntignmrtikgusdkbnx5) {
        zrnhtnkntignmrtikgusdkbnx5 = pZrnhtnkntignmrtikgusdkbnx5;
    }

    private String zrnhtnknnkmrtikgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKMRTIKGUSDKBNX5)
    public String getZrnhtnknnkmrtikgusdkbnx5() {
        return zrnhtnknnkmrtikgusdkbnx5;
    }

    public void setZrnhtnknnkmrtikgusdkbnx5(String pZrnhtnknnkmrtikgusdkbnx5) {
        zrnhtnknnkmrtikgusdkbnx5 = pZrnhtnknnkmrtikgusdkbnx5;
    }

    private String zrnhtnkntkstkgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKSTKGUSDKBNX5)
    public String getZrnhtnkntkstkgusdkbnx5() {
        return zrnhtnkntkstkgusdkbnx5;
    }

    public void setZrnhtnkntkstkgusdkbnx5(String pZrnhtnkntkstkgusdkbnx5) {
        zrnhtnkntkstkgusdkbnx5 = pZrnhtnkntkstkgusdkbnx5;
    }

    private String zrnhtnkndi2tkstkgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKSTKGUSDKBNX5)
    public String getZrnhtnkndi2tkstkgusdkbnx5() {
        return zrnhtnkndi2tkstkgusdkbnx5;
    }

    public void setZrnhtnkndi2tkstkgusdkbnx5(String pZrnhtnkndi2tkstkgusdkbnx5) {
        zrnhtnkndi2tkstkgusdkbnx5 = pZrnhtnkndi2tkstkgusdkbnx5;
    }

    private String zrnhtnknjyustkgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYUSTKGUSDKBNX5)
    public String getZrnhtnknjyustkgusdkbnx5() {
        return zrnhtnknjyustkgusdkbnx5;
    }

    public void setZrnhtnknjyustkgusdkbnx5(String pZrnhtnknjyustkgusdkbnx5) {
        zrnhtnknjyustkgusdkbnx5 = pZrnhtnknjyustkgusdkbnx5;
    }

    private String zrnhtnkndi2jysitkgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2JYSITKGUSDKBNX5)
    public String getZrnhtnkndi2jysitkgusdkbnx5() {
        return zrnhtnkndi2jysitkgusdkbnx5;
    }

    public void setZrnhtnkndi2jysitkgusdkbnx5(String pZrnhtnkndi2jysitkgusdkbnx5) {
        zrnhtnkndi2jysitkgusdkbnx5 = pZrnhtnkndi2jysitkgusdkbnx5;
    }

    private String zrnhtnknkaigonkmrtisdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTISDKBNX5)
    public String getZrnhtnknkaigonkmrtisdkbnx5() {
        return zrnhtnknkaigonkmrtisdkbnx5;
    }

    public void setZrnhtnknkaigonkmrtisdkbnx5(String pZrnhtnknkaigonkmrtisdkbnx5) {
        zrnhtnknkaigonkmrtisdkbnx5 = pZrnhtnknkaigonkmrtisdkbnx5;
    }

    private String zrnhtnknkigtignmrtisdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTISDKBNX5)
    public String getZrnhtnknkigtignmrtisdkbnx5() {
        return zrnhtnknkigtignmrtisdkbnx5;
    }

    public void setZrnhtnknkigtignmrtisdkbnx5(String pZrnhtnknkigtignmrtisdkbnx5) {
        zrnhtnknkigtignmrtisdkbnx5 = pZrnhtnknkigtignmrtisdkbnx5;
    }

    private String zrnhtnknkaigomrsykgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRSYKGUSDKBNX5)
    public String getZrnhtnknkaigomrsykgusdkbnx5() {
        return zrnhtnknkaigomrsykgusdkbnx5;
    }

    public void setZrnhtnknkaigomrsykgusdkbnx5(String pZrnhtnknkaigomrsykgusdkbnx5) {
        zrnhtnknkaigomrsykgusdkbnx5 = pZrnhtnknkaigomrsykgusdkbnx5;
    }

    private String zrnyobiv8x8;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X8)
    public String getZrnyobiv8x8() {
        return zrnyobiv8x8;
    }

    public void setZrnyobiv8x8(String pZrnyobiv8x8) {
        zrnyobiv8x8 = pZrnyobiv8x8;
    }

    private String zrnhtnknhknsyrikgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNHKNSYRIKGUSDKBNX6)
    public String getZrnhtnknhknsyrikgusdkbnx6() {
        return zrnhtnknhknsyrikgusdkbnx6;
    }

    public void setZrnhtnknhknsyrikgusdkbnx6(String pZrnhtnknhknsyrikgusdkbnx6) {
        zrnhtnknhknsyrikgusdkbnx6 = pZrnhtnknhknsyrikgusdkbnx6;
    }

    private String zrnhtnknmrtikgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNMRTIKGUSDKBNX6)
    public String getZrnhtnknmrtikgusdkbnx6() {
        return zrnhtnknmrtikgusdkbnx6;
    }

    public void setZrnhtnknmrtikgusdkbnx6(String pZrnhtnknmrtikgusdkbnx6) {
        zrnhtnknmrtikgusdkbnx6 = pZrnhtnknmrtikgusdkbnx6;
    }

    private String zrnhtnknsiznmrtikgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNSIZNMRTIKGUSDKBNX6)
    public String getZrnhtnknsiznmrtikgusdkbnx6() {
        return zrnhtnknsiznmrtikgusdkbnx6;
    }

    public void setZrnhtnknsiznmrtikgusdkbnx6(String pZrnhtnknsiznmrtikgusdkbnx6) {
        zrnhtnknsiznmrtikgusdkbnx6 = pZrnhtnknsiznmrtikgusdkbnx6;
    }

    private String zrnhtnkntignmrtikgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTIGNMRTIKGUSDKBNX6)
    public String getZrnhtnkntignmrtikgusdkbnx6() {
        return zrnhtnkntignmrtikgusdkbnx6;
    }

    public void setZrnhtnkntignmrtikgusdkbnx6(String pZrnhtnkntignmrtikgusdkbnx6) {
        zrnhtnkntignmrtikgusdkbnx6 = pZrnhtnkntignmrtikgusdkbnx6;
    }

    private String zrnhtnknnkmrtikgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNNKMRTIKGUSDKBNX6)
    public String getZrnhtnknnkmrtikgusdkbnx6() {
        return zrnhtnknnkmrtikgusdkbnx6;
    }

    public void setZrnhtnknnkmrtikgusdkbnx6(String pZrnhtnknnkmrtikgusdkbnx6) {
        zrnhtnknnkmrtikgusdkbnx6 = pZrnhtnknnkmrtikgusdkbnx6;
    }

    private String zrnhtnkntkstkgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNTKSTKGUSDKBNX6)
    public String getZrnhtnkntkstkgusdkbnx6() {
        return zrnhtnkntkstkgusdkbnx6;
    }

    public void setZrnhtnkntkstkgusdkbnx6(String pZrnhtnkntkstkgusdkbnx6) {
        zrnhtnkntkstkgusdkbnx6 = pZrnhtnkntkstkgusdkbnx6;
    }

    private String zrnhtnkndi2tkstkgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2TKSTKGUSDKBNX6)
    public String getZrnhtnkndi2tkstkgusdkbnx6() {
        return zrnhtnkndi2tkstkgusdkbnx6;
    }

    public void setZrnhtnkndi2tkstkgusdkbnx6(String pZrnhtnkndi2tkstkgusdkbnx6) {
        zrnhtnkndi2tkstkgusdkbnx6 = pZrnhtnkndi2tkstkgusdkbnx6;
    }

    private String zrnhtnknjyustkgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNJYUSTKGUSDKBNX6)
    public String getZrnhtnknjyustkgusdkbnx6() {
        return zrnhtnknjyustkgusdkbnx6;
    }

    public void setZrnhtnknjyustkgusdkbnx6(String pZrnhtnknjyustkgusdkbnx6) {
        zrnhtnknjyustkgusdkbnx6 = pZrnhtnknjyustkgusdkbnx6;
    }

    private String zrnhtnkndi2jysitkgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNDI2JYSITKGUSDKBNX6)
    public String getZrnhtnkndi2jysitkgusdkbnx6() {
        return zrnhtnkndi2jysitkgusdkbnx6;
    }

    public void setZrnhtnkndi2jysitkgusdkbnx6(String pZrnhtnkndi2jysitkgusdkbnx6) {
        zrnhtnkndi2jysitkgusdkbnx6 = pZrnhtnkndi2jysitkgusdkbnx6;
    }

    private String zrnhtnknkaigonkmrtisdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKMRTISDKBNX6)
    public String getZrnhtnknkaigonkmrtisdkbnx6() {
        return zrnhtnknkaigonkmrtisdkbnx6;
    }

    public void setZrnhtnknkaigonkmrtisdkbnx6(String pZrnhtnknkaigonkmrtisdkbnx6) {
        zrnhtnknkaigonkmrtisdkbnx6 = pZrnhtnknkaigonkmrtisdkbnx6;
    }

    private String zrnhtnknkigtignmrtisdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGTIGNMRTISDKBNX6)
    public String getZrnhtnknkigtignmrtisdkbnx6() {
        return zrnhtnknkigtignmrtisdkbnx6;
    }

    public void setZrnhtnknkigtignmrtisdkbnx6(String pZrnhtnknkigtignmrtisdkbnx6) {
        zrnhtnknkigtignmrtisdkbnx6 = pZrnhtnknkigtignmrtisdkbnx6;
    }

    private String zrnhtnknkaigomrsykgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRSYKGUSDKBNX6)
    public String getZrnhtnknkaigomrsykgusdkbnx6() {
        return zrnhtnknkaigomrsykgusdkbnx6;
    }

    public void setZrnhtnknkaigomrsykgusdkbnx6(String pZrnhtnknkaigomrsykgusdkbnx6) {
        zrnhtnknkaigomrsykgusdkbnx6 = pZrnhtnknkaigomrsykgusdkbnx6;
    }

    private String zrnyobiv8x9;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X9)
    public String getZrnyobiv8x9() {
        return zrnyobiv8x9;
    }

    public void setZrnyobiv8x9(String pZrnyobiv8x9) {
        zrnyobiv8x9 = pZrnyobiv8x9;
    }

    private String zrnkaigonktkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKSYURUIKGU)
    public String getZrnkaigonktkyksyuruikgu() {
        return zrnkaigonktkyksyuruikgu;
    }

    public void setZrnkaigonktkyksyuruikgu(String pZrnkaigonktkyksyuruikgu) {
        zrnkaigonktkyksyuruikgu = pZrnkaigonktkyksyuruikgu;
    }

    private String zrnkaigonktkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKKGUSDKBN)
    public String getZrnkaigonktkykkgusdkbn() {
        return zrnkaigonktkykkgusdkbn;
    }

    public void setZrnkaigonktkykkgusdkbn(String pZrnkaigonktkykkgusdkbn) {
        zrnkaigonktkykkgusdkbn = pZrnkaigonktkykkgusdkbn;
    }

    private String zrnkaigonenkintokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONENKINTOKUYAKUKIKAN)
    public String getZrnkaigonenkintokuyakukikan() {
        return zrnkaigonenkintokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonenkintokuyakukikan(String pZrnkaigonenkintokuyakukikan) {
        zrnkaigonenkintokuyakukikan = pZrnkaigonenkintokuyakukikan;
    }

    private String zrnkaigonktkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKPHRKKKN)
    public String getZrnkaigonktkykphrkkkn() {
        return zrnkaigonktkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonktkykphrkkkn(String pZrnkaigonktkykphrkkkn) {
        zrnkaigonktkykphrkkkn = pZrnkaigonktkykphrkkkn;
    }

    private Long zrnkaigonktkyknkgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKNKGK)
    public Long getZrnkaigonktkyknkgk() {
        return zrnkaigonktkyknkgk;
    }

    public void setZrnkaigonktkyknkgk(Long pZrnkaigonktkyknkgk) {
        zrnkaigonktkyknkgk = pZrnkaigonktkyknkgk;
    }

    private Long zrnkaigonenkintokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONENKINTOKUYAKUS)
    public Long getZrnkaigonenkintokuyakus() {
        return zrnkaigonenkintokuyakus;
    }

    public void setZrnkaigonenkintokuyakus(Long pZrnkaigonenkintokuyakus) {
        zrnkaigonenkintokuyakus = pZrnkaigonenkintokuyakus;
    }

    private Long zrnkaigonenkintokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONENKINTOKUYAKUP)
    public Long getZrnkaigonenkintokuyakup() {
        return zrnkaigonenkintokuyakup;
    }

    public void setZrnkaigonenkintokuyakup(Long pZrnkaigonenkintokuyakup) {
        zrnkaigonenkintokuyakup = pZrnkaigonenkintokuyakup;
    }

    private Long zrnkaigonktkykmods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKMODS)
    public Long getZrnkaigonktkykmods() {
        return zrnkaigonktkykmods;
    }

    public void setZrnkaigonktkykmods(Long pZrnkaigonktkykmods) {
        zrnkaigonktkykmods = pZrnkaigonktkykmods;
    }

    private String zrnkaigonktkyknkshrkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKNKSHRKKN)
    public String getZrnkaigonktkyknkshrkkn() {
        return zrnkaigonktkyknkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonktkyknkshrkkn(String pZrnkaigonktkyknkshrkkn) {
        zrnkaigonktkyknkshrkkn = pZrnkaigonktkyknkshrkkn;
    }

    private String zrnhtnknkaigonktkykkgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKKGUX1)
    public String getZrnhtnknkaigonktkykkgux1() {
        return zrnhtnknkaigonktkykkgux1;
    }

    public void setZrnhtnknkaigonktkykkgux1(String pZrnhtnknkaigonktkykkgux1) {
        zrnhtnknkaigonktkykkgux1 = pZrnhtnknkaigonktkykkgux1;
    }

    private String zrnhtnknkaigonktkykkgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKKGUX2)
    public String getZrnhtnknkaigonktkykkgux2() {
        return zrnhtnknkaigonktkykkgux2;
    }

    public void setZrnhtnknkaigonktkykkgux2(String pZrnhtnknkaigonktkykkgux2) {
        zrnhtnknkaigonktkykkgux2 = pZrnhtnknkaigonktkykkgux2;
    }

    private String zrnhtnknkaigonktkykkgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKKGUX3)
    public String getZrnhtnknkaigonktkykkgux3() {
        return zrnhtnknkaigonktkykkgux3;
    }

    public void setZrnhtnknkaigonktkykkgux3(String pZrnhtnknkaigonktkykkgux3) {
        zrnhtnknkaigonktkykkgux3 = pZrnhtnknkaigonktkykkgux3;
    }

    private String zrnhtnknkaigonktkykkgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKKGUX4)
    public String getZrnhtnknkaigonktkykkgux4() {
        return zrnhtnknkaigonktkykkgux4;
    }

    public void setZrnhtnknkaigonktkykkgux4(String pZrnhtnknkaigonktkykkgux4) {
        zrnhtnknkaigonktkykkgux4 = pZrnhtnknkaigonktkykkgux4;
    }

    private String zrnhtnknkaigonktkykkgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKKGUX5)
    public String getZrnhtnknkaigonktkykkgux5() {
        return zrnhtnknkaigonktkykkgux5;
    }

    public void setZrnhtnknkaigonktkykkgux5(String pZrnhtnknkaigonktkykkgux5) {
        zrnhtnknkaigonktkykkgux5 = pZrnhtnknkaigonktkykkgux5;
    }

    private String zrnhtnknkaigonktkykkgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKKGUX6)
    public String getZrnhtnknkaigonktkykkgux6() {
        return zrnhtnknkaigonktkykkgux6;
    }

    public void setZrnhtnknkaigonktkykkgux6(String pZrnhtnknkaigonktkykkgux6) {
        zrnhtnknkaigonktkykkgux6 = pZrnhtnknkaigonktkykkgux6;
    }

    private String zrnhtnknkaigonktkyksdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKSDKBNX1)
    public String getZrnhtnknkaigonktkyksdkbnx1() {
        return zrnhtnknkaigonktkyksdkbnx1;
    }

    public void setZrnhtnknkaigonktkyksdkbnx1(String pZrnhtnknkaigonktkyksdkbnx1) {
        zrnhtnknkaigonktkyksdkbnx1 = pZrnhtnknkaigonktkyksdkbnx1;
    }

    private String zrnhtnknkaigonktkyksdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKSDKBNX2)
    public String getZrnhtnknkaigonktkyksdkbnx2() {
        return zrnhtnknkaigonktkyksdkbnx2;
    }

    public void setZrnhtnknkaigonktkyksdkbnx2(String pZrnhtnknkaigonktkyksdkbnx2) {
        zrnhtnknkaigonktkyksdkbnx2 = pZrnhtnknkaigonktkyksdkbnx2;
    }

    private String zrnhtnknkaigonktkyksdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKSDKBNX3)
    public String getZrnhtnknkaigonktkyksdkbnx3() {
        return zrnhtnknkaigonktkyksdkbnx3;
    }

    public void setZrnhtnknkaigonktkyksdkbnx3(String pZrnhtnknkaigonktkyksdkbnx3) {
        zrnhtnknkaigonktkyksdkbnx3 = pZrnhtnknkaigonktkyksdkbnx3;
    }

    private String zrnhtnknkaigonktkyksdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKSDKBNX4)
    public String getZrnhtnknkaigonktkyksdkbnx4() {
        return zrnhtnknkaigonktkyksdkbnx4;
    }

    public void setZrnhtnknkaigonktkyksdkbnx4(String pZrnhtnknkaigonktkyksdkbnx4) {
        zrnhtnknkaigonktkyksdkbnx4 = pZrnhtnknkaigonktkyksdkbnx4;
    }

    private String zrnhtnknkaigonktkyksdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKSDKBNX5)
    public String getZrnhtnknkaigonktkyksdkbnx5() {
        return zrnhtnknkaigonktkyksdkbnx5;
    }

    public void setZrnhtnknkaigonktkyksdkbnx5(String pZrnhtnknkaigonktkyksdkbnx5) {
        zrnhtnknkaigonktkyksdkbnx5 = pZrnhtnknkaigonktkyksdkbnx5;
    }

    private String zrnhtnknkaigonktkyksdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGONKTKYKSDKBNX6)
    public String getZrnhtnknkaigonktkyksdkbnx6() {
        return zrnhtnknkaigonktkyksdkbnx6;
    }

    public void setZrnhtnknkaigonktkyksdkbnx6(String pZrnhtnknkaigonktkyksdkbnx6) {
        zrnhtnknkaigonktkyksdkbnx6 = pZrnhtnknkaigonktkyksdkbnx6;
    }

    private String zrnsurikaigonktkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURIKAIGONKTKYKPWRBKKBN)
    public String getZrnsurikaigonktkykpwrbkkbn() {
        return zrnsurikaigonktkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsurikaigonktkykpwrbkkbn(String pZrnsurikaigonktkykpwrbkkbn) {
        zrnsurikaigonktkykpwrbkkbn = pZrnsurikaigonktkykpwrbkkbn;
    }

    private String zrnkaigonktkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKPWRBKKBN)
    public String getZrnkaigonktkykpwrbkkbn() {
        return zrnkaigonktkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonktkykpwrbkkbn(String pZrnkaigonktkykpwrbkkbn) {
        zrnkaigonktkykpwrbkkbn = pZrnkaigonktkykpwrbkkbn;
    }

    private String zrnkaigonktkyktnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGONKTKYKTNKNYUGUKBN)
    public String getZrnkaigonktkyktnknyugukbn() {
        return zrnkaigonktkyktnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigonktkyktnknyugukbn(String pZrnkaigonktkyktnknyugukbn) {
        zrnkaigonktkyktnknyugukbn = pZrnkaigonktkyktnknyugukbn;
    }

    private String zrnyobiv14;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }

    private String zrnitjbrkignktkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKSYRIKGU)
    public String getZrnitjbrkignktkyksyrikgu() {
        return zrnitjbrkignktkyksyrikgu;
    }

    public void setZrnitjbrkignktkyksyrikgu(String pZrnitjbrkignktkyksyrikgu) {
        zrnitjbrkignktkyksyrikgu = pZrnitjbrkignktkyksyrikgu;
    }

    private String zrnitjbrkignktkyksdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKSDKBN)
    public String getZrnitjbrkignktkyksdkbn() {
        return zrnitjbrkignktkyksdkbn;
    }

    public void setZrnitjbrkignktkyksdkbn(String pZrnitjbrkignktkyksdkbn) {
        zrnitjbrkignktkyksdkbn = pZrnitjbrkignktkyksdkbn;
    }

    private String zrnitjbrkignktkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKKKN)
    public String getZrnitjbrkignktkykkkn() {
        return zrnitjbrkignktkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnitjbrkignktkykkkn(String pZrnitjbrkignktkykkkn) {
        zrnitjbrkignktkykkkn = pZrnitjbrkignktkykkkn;
    }

    private Long zrnitjbrkignktkyknnkngk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKNNKNGK)
    public Long getZrnitjbrkignktkyknnkngk() {
        return zrnitjbrkignktkyknnkngk;
    }

    public void setZrnitjbrkignktkyknnkngk(Long pZrnitjbrkignktkyknnkngk) {
        zrnitjbrkignktkyknnkngk = pZrnitjbrkignktkyknnkngk;
    }

    private Long zrnitjbrkignktkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKS)
    public Long getZrnitjbrkignktkyks() {
        return zrnitjbrkignktkyks;
    }

    public void setZrnitjbrkignktkyks(Long pZrnitjbrkignktkyks) {
        zrnitjbrkignktkyks = pZrnitjbrkignktkyks;
    }

    private Long zrnitjbrkignktkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKP)
    public Long getZrnitjbrkignktkykp() {
        return zrnitjbrkignktkykp;
    }

    public void setZrnitjbrkignktkykp(Long pZrnitjbrkignktkykp) {
        zrnitjbrkignktkykp = pZrnitjbrkignktkykp;
    }

    private String zrnitjbrkignktkykspdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKSPDTKBN)
    public String getZrnitjbrkignktkykspdtkbn() {
        return zrnitjbrkignktkykspdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrkignktkykspdtkbn(String pZrnitjbrkignktkykspdtkbn) {
        zrnitjbrkignktkykspdtkbn = pZrnitjbrkignktkykspdtkbn;
    }

    private Long zrnitjbrkignktkykmods;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKMODS)
    public Long getZrnitjbrkignktkykmods() {
        return zrnitjbrkignktkykmods;
    }

    public void setZrnitjbrkignktkykmods(Long pZrnitjbrkignktkykmods) {
        zrnitjbrkignktkykmods = pZrnitjbrkignktkykmods;
    }

    private String zrnitjbrkignktkykshrkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNITJBRKIGNKTKYKSHRKKN)
    public String getZrnitjbrkignktkykshrkkn() {
        return zrnitjbrkignktkykshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnitjbrkignktkykshrkkn(String pZrnitjbrkignktkykshrkkn) {
        zrnitjbrkignktkykshrkkn = pZrnitjbrkignktkykshrkkn;
    }

    private String zrnyobiv8x10;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X10)
    public String getZrnyobiv8x10() {
        return zrnyobiv8x10;
    }

    public void setZrnyobiv8x10(String pZrnyobiv8x10) {
        zrnyobiv8x10 = pZrnyobiv8x10;
    }

    private String zrnnyuuinnissuugatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNNYUUINNISSUUGATAKBN)
    public String getZrnnyuuinnissuugatakbn() {
        return zrnnyuuinnissuugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuuinnissuugatakbn(String pZrnnyuuinnissuugatakbn) {
        zrnnyuuinnissuugatakbn = pZrnnyuuinnissuugatakbn;
    }

    private String zrntenkankeikanensuu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNTENKANKEIKANENSUU)
    public String getZrntenkankeikanensuu() {
        return zrntenkankeikanensuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntenkankeikanensuu(String pZrntenkankeikanensuu) {
        zrntenkankeikanensuu = pZrntenkankeikanensuu;
    }

    private String zrnsykkyuhtkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKYKSYURUIKGU)
    public String getZrnsykkyuhtkyksyuruikgu() {
        return zrnsykkyuhtkyksyuruikgu;
    }

    public void setZrnsykkyuhtkyksyuruikgu(String pZrnsykkyuhtkyksyuruikgu) {
        zrnsykkyuhtkyksyuruikgu = pZrnsykkyuhtkyksyuruikgu;
    }

    private String zrnsyokikyuuhutokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYOKIKYUUHUTOKUYAKUKIKAN)
    public String getZrnsyokikyuuhutokuyakukikan() {
        return zrnsyokikyuuhutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyokikyuuhutokuyakukikan(String pZrnsyokikyuuhutokuyakukikan) {
        zrnsyokikyuuhutokuyakukikan = pZrnsyokikyuuhutokuyakukikan;
    }

    private String zrnsyokikyuuhutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYOKIKYUUHUTKYKPHRKKKN)
    public String getZrnsyokikyuuhutkykphrkkkn() {
        return zrnsyokikyuuhutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyokikyuuhutkykphrkkkn(String pZrnsyokikyuuhutkykphrkkkn) {
        zrnsyokikyuuhutkykphrkkkn = pZrnsyokikyuuhutkykphrkkkn;
    }

    private Integer zrnsykkyuhtkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKYKNTGK)
    public Integer getZrnsykkyuhtkykntgk() {
        return zrnsykkyuhtkykntgk;
    }

    public void setZrnsykkyuhtkykntgk(Integer pZrnsykkyuhtkykntgk) {
        zrnsykkyuhtkykntgk = pZrnsykkyuhtkykntgk;
    }

    private Long zrnsyokikyuuhutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYOKIKYUUHUTOKUYAKUP)
    public Long getZrnsyokikyuuhutokuyakup() {
        return zrnsyokikyuuhutokuyakup;
    }

    public void setZrnsyokikyuuhutokuyakup(Long pZrnsyokikyuuhutokuyakup) {
        zrnsyokikyuuhutokuyakup = pZrnsyokikyuuhutokuyakup;
    }

    private String zrnsykkyuhtkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKYKGTKBN)
    public String getZrnsykkyuhtkykgtkbn() {
        return zrnsykkyuhtkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykkyuhtkykgtkbn(String pZrnsykkyuhtkykgtkbn) {
        zrnsykkyuhtkykgtkbn = pZrnsykkyuhtkykgtkbn;
    }

    private String zrnsyokikyuuhutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYOKIKYUUHUTKYKKGUSDKBN)
    public String getZrnsyokikyuuhutkykkgusdkbn() {
        return zrnsyokikyuuhutkykkgusdkbn;
    }

    public void setZrnsyokikyuuhutkykkgusdkbn(String pZrnsyokikyuuhutkykkgusdkbn) {
        zrnsyokikyuuhutkykkgusdkbn = pZrnsyokikyuuhutkykkgusdkbn;
    }

    private Integer zrnsykkyuhtkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKJYURYUMSHYUTN)
    public Integer getZrnsykkyuhtkjyuryumshyutn() {
        return zrnsykkyuhtkjyuryumshyutn;
    }

    public void setZrnsykkyuhtkjyuryumshyutn(Integer pZrnsykkyuhtkjyuryumshyutn) {
        zrnsykkyuhtkjyuryumshyutn = pZrnsykkyuhtkjyuryumshyutn;
    }

    private Long zrnsyokikyuuhutokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYOKIKYUUHUTOKUJYOUP)
    public Long getZrnsyokikyuuhutokujyoup() {
        return zrnsyokikyuuhutokujyoup;
    }

    public void setZrnsyokikyuuhutokujyoup(Long pZrnsyokikyuuhutokujyoup) {
        zrnsyokikyuuhutokujyoup = pZrnsyokikyuuhutokujyoup;
    }

    private String zrnsykkyuhtktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKTBICDX1)
    public String getZrnsykkyuhtktbicdx1() {
        return zrnsykkyuhtktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsykkyuhtktbicdx1(String pZrnsykkyuhtktbicdx1) {
        zrnsykkyuhtktbicdx1 = pZrnsykkyuhtktbicdx1;
    }

    private String zrnsykkyuhhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHHTNPKKNX1)
    public String getZrnsykkyuhhtnpkknx1() {
        return zrnsykkyuhhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsykkyuhhtnpkknx1(String pZrnsykkyuhhtnpkknx1) {
        zrnsykkyuhhtnpkknx1 = pZrnsykkyuhhtnpkknx1;
    }

    private String zrnsykkyuhtktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKTBICDX2)
    public String getZrnsykkyuhtktbicdx2() {
        return zrnsykkyuhtktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsykkyuhtktbicdx2(String pZrnsykkyuhtktbicdx2) {
        zrnsykkyuhtktbicdx2 = pZrnsykkyuhtktbicdx2;
    }

    private String zrnsykkyuhhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHHTNPKKNX2)
    public String getZrnsykkyuhhtnpkknx2() {
        return zrnsykkyuhhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsykkyuhhtnpkknx2(String pZrnsykkyuhhtnpkknx2) {
        zrnsykkyuhhtnpkknx2 = pZrnsykkyuhhtnpkknx2;
    }

    private String zrnsykkyuhtkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSYKKYUHTKYKPWRBKKBN)
    public String getZrnsykkyuhtkykpwrbkkbn() {
        return zrnsykkyuhtkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsykkyuhtkykpwrbkkbn(String pZrnsykkyuhtkykpwrbkkbn) {
        zrnsykkyuhtkykpwrbkkbn = pZrnsykkyuhtkykpwrbkkbn;
    }

    private String zrnyobiv3x6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV3X6)
    public String getZrnyobiv3x6() {
        return zrnyobiv3x6;
    }

    public void setZrnyobiv3x6(String pZrnyobiv3x6) {
        zrnyobiv3x6 = pZrnyobiv3x6;
    }

    private String zrndi2sykkyuhtkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKSYRIKGU)
    public String getZrndi2sykkyuhtkyksyrikgu() {
        return zrndi2sykkyuhtkyksyrikgu;
    }

    public void setZrndi2sykkyuhtkyksyrikgu(String pZrndi2sykkyuhtkyksyrikgu) {
        zrndi2sykkyuhtkyksyrikgu = pZrndi2sykkyuhtkyksyrikgu;
    }

    private String zrndi2sykkyuhtkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKKKN)
    public String getZrndi2sykkyuhtkykkkn() {
        return zrndi2sykkyuhtkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhtkykkkn(String pZrndi2sykkyuhtkykkkn) {
        zrndi2sykkyuhtkykkkn = pZrndi2sykkyuhtkykkkn;
    }

    private String zrndi2sykkyuhtkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKPHRKKKN)
    public String getZrndi2sykkyuhtkykphrkkkn() {
        return zrndi2sykkyuhtkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhtkykphrkkkn(String pZrndi2sykkyuhtkykphrkkkn) {
        zrndi2sykkyuhtkykphrkkkn = pZrndi2sykkyuhtkykphrkkkn;
    }

    private Integer zrndi2sykkyuhtkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKNTGK)
    public Integer getZrndi2sykkyuhtkykntgk() {
        return zrndi2sykkyuhtkykntgk;
    }

    public void setZrndi2sykkyuhtkykntgk(Integer pZrndi2sykkyuhtkykntgk) {
        zrndi2sykkyuhtkykntgk = pZrndi2sykkyuhtkykntgk;
    }

    private Long zrndai2syokikyuuhutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2SYOKIKYUUHUTOKUYAKUP)
    public Long getZrndai2syokikyuuhutokuyakup() {
        return zrndai2syokikyuuhutokuyakup;
    }

    public void setZrndai2syokikyuuhutokuyakup(Long pZrndai2syokikyuuhutokuyakup) {
        zrndai2syokikyuuhutokuyakup = pZrndai2syokikyuuhutokuyakup;
    }

    private String zrndi2sykkyuhtkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKGTKBN)
    public String getZrndi2sykkyuhtkykgtkbn() {
        return zrndi2sykkyuhtkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sykkyuhtkykgtkbn(String pZrndi2sykkyuhtkykgtkbn) {
        zrndi2sykkyuhtkykgtkbn = pZrndi2sykkyuhtkykgtkbn;
    }

    private String zrndi2sykkyuhtkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKKGUSDKBN)
    public String getZrndi2sykkyuhtkykkgusdkbn() {
        return zrndi2sykkyuhtkykkgusdkbn;
    }

    public void setZrndi2sykkyuhtkykkgusdkbn(String pZrndi2sykkyuhtkykkgusdkbn) {
        zrndi2sykkyuhtkykkgusdkbn = pZrndi2sykkyuhtkykkgusdkbn;
    }

    private Integer zrndi2sykkyuhtkjyuryumshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKJYURYUMSHYTN)
    public Integer getZrndi2sykkyuhtkjyuryumshytn() {
        return zrndi2sykkyuhtkjyuryumshytn;
    }

    public void setZrndi2sykkyuhtkjyuryumshytn(Integer pZrndi2sykkyuhtkjyuryumshytn) {
        zrndi2sykkyuhtkjyuryumshytn = pZrndi2sykkyuhtkjyuryumshytn;
    }

    private Long zrndai2syokikyuuhutokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDAI2SYOKIKYUUHUTOKUJYOUP)
    public Long getZrndai2syokikyuuhutokujyoup() {
        return zrndai2syokikyuuhutokujyoup;
    }

    public void setZrndai2syokikyuuhutokujyoup(Long pZrndai2syokikyuuhutokujyoup) {
        zrndai2syokikyuuhutokujyoup = pZrndai2syokikyuuhutokujyoup;
    }

    private String zrndi2sykkyuhtktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKTBICDX1)
    public String getZrndi2sykkyuhtktbicdx1() {
        return zrndi2sykkyuhtktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhtktbicdx1(String pZrndi2sykkyuhtktbicdx1) {
        zrndi2sykkyuhtktbicdx1 = pZrndi2sykkyuhtktbicdx1;
    }

    private String zrndi2sykkyuhhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHHTNPKKNX1)
    public String getZrndi2sykkyuhhtnpkknx1() {
        return zrndi2sykkyuhhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhhtnpkknx1(String pZrndi2sykkyuhhtnpkknx1) {
        zrndi2sykkyuhhtnpkknx1 = pZrndi2sykkyuhhtnpkknx1;
    }

    private String zrndi2sykkyuhtktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKTBICDX2)
    public String getZrndi2sykkyuhtktbicdx2() {
        return zrndi2sykkyuhtktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhtktbicdx2(String pZrndi2sykkyuhtktbicdx2) {
        zrndi2sykkyuhtktbicdx2 = pZrndi2sykkyuhtktbicdx2;
    }

    private String zrndi2sykkyuhhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHHTNPKKNX2)
    public String getZrndi2sykkyuhhtnpkknx2() {
        return zrndi2sykkyuhhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhhtnpkknx2(String pZrndi2sykkyuhhtnpkknx2) {
        zrndi2sykkyuhhtnpkknx2 = pZrndi2sykkyuhhtnpkknx2;
    }

    private String zrndi2sykkyuhtkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDI2SYKKYUHTKYKPWRBKKBN)
    public String getZrndi2sykkyuhtkykpwrbkkbn() {
        return zrndi2sykkyuhtkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sykkyuhtkykpwrbkkbn(String pZrndi2sykkyuhtkykpwrbkkbn) {
        zrndi2sykkyuhtkykpwrbkkbn = pZrndi2sykkyuhtkykpwrbkkbn;
    }

    private String zrnyobiv3x7;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV3X7)
    public String getZrnyobiv3x7() {
        return zrnyobiv3x7;
    }

    public void setZrnyobiv3x7(String pZrnyobiv3x7) {
        zrnyobiv3x7 = pZrnyobiv3x7;
    }

    private Long zrndfitijibaraip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDFITIJIBARAIP)
    public Long getZrndfitijibaraip() {
        return zrndfitijibaraip;
    }

    public void setZrndfitijibaraip(Long pZrndfitijibaraip) {
        zrndfitijibaraip = pZrndfitijibaraip;
    }

    private Long zrndfgoukeitenkankakaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDFGOUKEITENKANKAKAKU)
    public Long getZrndfgoukeitenkankakaku() {
        return zrndfgoukeitenkankakaku;
    }

    public void setZrndfgoukeitenkankakaku(Long pZrndfgoukeitenkankakaku) {
        zrndfgoukeitenkankakaku = pZrndfgoukeitenkankakaku;
    }

    private Long zrndfuktkjivbbntnknkakaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDFUKTKJIVBBNTNKNKAKAKU)
    public Long getZrndfuktkjivbbntnknkakaku() {
        return zrndfuktkjivbbntnknkakaku;
    }

    public void setZrndfuktkjivbbntnknkakaku(Long pZrndfuktkjivbbntnknkakaku) {
        zrndfuktkjivbbntnknkakaku = pZrndfuktkjivbbntnknkakaku;
    }

    private Long zrndfuktkjipbbntnknkakaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDFUKTKJIPBBNTNKNKAKAKU)
    public Long getZrndfuktkjipbbntnknkakaku() {
        return zrndfuktkjipbbntnknkakaku;
    }

    public void setZrndfuktkjipbbntnknkakaku(Long pZrndfuktkjipbbntnknkakaku) {
        zrndfuktkjipbbntnknkakaku = pZrndfuktkjipbbntnknkakaku;
    }

    private Long zrndftnkngvbbntnknkakaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDFTNKNGVBBNTNKNKAKAKU)
    public Long getZrndftnkngvbbntnknkakaku() {
        return zrndftnkngvbbntnknkakaku;
    }

    public void setZrndftnkngvbbntnknkakaku(Long pZrndftnkngvbbntnknkakaku) {
        zrndftnkngvbbntnknkakaku = pZrndftnkngvbbntnknkakaku;
    }

    private Long zrndftnkngpbbntnknkakaku;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNDFTNKNGPBBNTNKNKAKAKU)
    public Long getZrndftnkngpbbntnknkakaku() {
        return zrndftnkngpbbntnknkakaku;
    }

    public void setZrndftnkngpbbntnknkakaku(Long pZrndftnkngpbbntnknkakaku) {
        zrndftnkngpbbntnknkakaku = pZrndftnkngpbbntnknkakaku;
    }

    private String zrnyobiv18x2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV18X2)
    public String getZrnyobiv18x2() {
        return zrnyobiv18x2;
    }

    public void setZrnyobiv18x2(String pZrnyobiv18x2) {
        zrnyobiv18x2 = pZrnyobiv18x2;
    }

    private String zrnkaigomrtisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMRTISYURUIKGU)
    public String getZrnkaigomrtisyuruikgu() {
        return zrnkaigomrtisyuruikgu;
    }

    public void setZrnkaigomrtisyuruikgu(String pZrnkaigomrtisyuruikgu) {
        zrnkaigomrtisyuruikgu = pZrnkaigomrtisyuruikgu;
    }

    private String zrnkaigomaruteikigousdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEIKIGOUSDKBN)
    public String getZrnkaigomaruteikigousdkbn() {
        return zrnkaigomaruteikigousdkbn;
    }

    public void setZrnkaigomaruteikigousdkbn(String pZrnkaigomaruteikigousdkbn) {
        zrnkaigomaruteikigousdkbn = pZrnkaigomaruteikigousdkbn;
    }

    private String zrnkaigomaruteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEIKIKAN)
    public String getZrnkaigomaruteikikan() {
        return zrnkaigomaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigomaruteikikan(String pZrnkaigomaruteikikan) {
        zrnkaigomaruteikikan = pZrnkaigomaruteikikan;
    }

    private String zrnkaigomaruteiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEIPHRKKKN)
    public String getZrnkaigomaruteiphrkkkn() {
        return zrnkaigomaruteiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigomaruteiphrkkkn(String pZrnkaigomaruteiphrkkkn) {
        zrnkaigomaruteiphrkkkn = pZrnkaigomaruteiphrkkkn;
    }

    private Long zrnkaigomaruteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEIS)
    public Long getZrnkaigomaruteis() {
        return zrnkaigomaruteis;
    }

    public void setZrnkaigomaruteis(Long pZrnkaigomaruteis) {
        zrnkaigomaruteis = pZrnkaigomaruteis;
    }

    private Long zrnkaigomaruteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEIP)
    public Long getZrnkaigomaruteip() {
        return zrnkaigomaruteip;
    }

    public void setZrnkaigomaruteip(Long pZrnkaigomaruteip) {
        zrnkaigomaruteip = pZrnkaigomaruteip;
    }

    private Long zrnkaigomaruteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEISYUUSEIS)
    public Long getZrnkaigomaruteisyuuseis() {
        return zrnkaigomaruteisyuuseis;
    }

    public void setZrnkaigomaruteisyuuseis(Long pZrnkaigomaruteisyuuseis) {
        zrnkaigomaruteisyuuseis = pZrnkaigomaruteisyuuseis;
    }

    private String zrnkaigomaruteimodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEIMODSSKGNHYJ)
    public String getZrnkaigomaruteimodsskgnhyj() {
        return zrnkaigomaruteimodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaruteimodsskgnhyj(String pZrnkaigomaruteimodsskgnhyj) {
        zrnkaigomaruteimodsskgnhyj = pZrnkaigomaruteimodsskgnhyj;
    }

    private String zrnkigmrtitkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGMRTITKJYUKBN)
    public String getZrnkigmrtitkjyukbn() {
        return zrnkigmrtitkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigmrtitkjyukbn(String pZrnkigmrtitkjyukbn) {
        zrnkigmrtitkjyukbn = pZrnkigmrtitkjyukbn;
    }

    private String zrnkigmrtitkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGMRTITKJYUSKGNKKN)
    public String getZrnkigmrtitkjyuskgnkkn() {
        return zrnkigmrtitkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigmrtitkjyuskgnkkn(String pZrnkigmrtitkjyuskgnkkn) {
        zrnkigmrtitkjyuskgnkkn = pZrnkigmrtitkjyuskgnkkn;
    }

    private Integer zrnkigmrtitkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGMRTITKJYURYUMSHYUTN)
    public Integer getZrnkigmrtitkjyuryumshyutn() {
        return zrnkigmrtitkjyuryumshyutn;
    }

    public void setZrnkigmrtitkjyuryumshyutn(Integer pZrnkigmrtitkjyuryumshyutn) {
        zrnkigmrtitkjyuryumshyutn = pZrnkigmrtitkjyuryumshyutn;
    }

    private Long zrnkaigomaruteitokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOMARUTEITOKUJYOUP)
    public Long getZrnkaigomaruteitokujyoup() {
        return zrnkaigomaruteitokujyoup;
    }

    public void setZrnkaigomaruteitokujyoup(Long pZrnkaigomaruteitokujyoup) {
        zrnkaigomaruteitokujyoup = pZrnkaigomaruteitokujyoup;
    }

    private String zrnhtnknkigmrtisyrikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGMRTISYRIKGUX1)
    public String getZrnhtnknkigmrtisyrikgux1() {
        return zrnhtnknkigmrtisyrikgux1;
    }

    public void setZrnhtnknkigmrtisyrikgux1(String pZrnhtnknkigmrtisyrikgux1) {
        zrnhtnknkigmrtisyrikgux1 = pZrnhtnknkigmrtisyrikgux1;
    }

    private String zrnhtnknkigmrtisyrikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGMRTISYRIKGUX2)
    public String getZrnhtnknkigmrtisyrikgux2() {
        return zrnhtnknkigmrtisyrikgux2;
    }

    public void setZrnhtnknkigmrtisyrikgux2(String pZrnhtnknkigmrtisyrikgux2) {
        zrnhtnknkigmrtisyrikgux2 = pZrnhtnknkigmrtisyrikgux2;
    }

    private String zrnhtnknkigmrtisyrikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGMRTISYRIKGUX3)
    public String getZrnhtnknkigmrtisyrikgux3() {
        return zrnhtnknkigmrtisyrikgux3;
    }

    public void setZrnhtnknkigmrtisyrikgux3(String pZrnhtnknkigmrtisyrikgux3) {
        zrnhtnknkigmrtisyrikgux3 = pZrnhtnknkigmrtisyrikgux3;
    }

    private String zrnhtnknkigmrtisyrikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGMRTISYRIKGUX4)
    public String getZrnhtnknkigmrtisyrikgux4() {
        return zrnhtnknkigmrtisyrikgux4;
    }

    public void setZrnhtnknkigmrtisyrikgux4(String pZrnhtnknkigmrtisyrikgux4) {
        zrnhtnknkigmrtisyrikgux4 = pZrnhtnknkigmrtisyrikgux4;
    }

    private String zrnhtnknkigmrtisyrikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGMRTISYRIKGUX5)
    public String getZrnhtnknkigmrtisyrikgux5() {
        return zrnhtnknkigmrtisyrikgux5;
    }

    public void setZrnhtnknkigmrtisyrikgux5(String pZrnhtnknkigmrtisyrikgux5) {
        zrnhtnknkigmrtisyrikgux5 = pZrnhtnknkigmrtisyrikgux5;
    }

    private String zrnhtnknkigmrtisyrikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKIGMRTISYRIKGUX6)
    public String getZrnhtnknkigmrtisyrikgux6() {
        return zrnhtnknkigmrtisyrikgux6;
    }

    public void setZrnhtnknkigmrtisyrikgux6(String pZrnhtnknkigmrtisyrikgux6) {
        zrnhtnknkigmrtisyrikgux6 = pZrnhtnknkigmrtisyrikgux6;
    }

    private String zrnhtnknkaigomrtisdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRTISDKBNX1)
    public String getZrnhtnknkaigomrtisdkbnx1() {
        return zrnhtnknkaigomrtisdkbnx1;
    }

    public void setZrnhtnknkaigomrtisdkbnx1(String pZrnhtnknkaigomrtisdkbnx1) {
        zrnhtnknkaigomrtisdkbnx1 = pZrnhtnknkaigomrtisdkbnx1;
    }

    private String zrnhtnknkaigomrtisdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRTISDKBNX2)
    public String getZrnhtnknkaigomrtisdkbnx2() {
        return zrnhtnknkaigomrtisdkbnx2;
    }

    public void setZrnhtnknkaigomrtisdkbnx2(String pZrnhtnknkaigomrtisdkbnx2) {
        zrnhtnknkaigomrtisdkbnx2 = pZrnhtnknkaigomrtisdkbnx2;
    }

    private String zrnhtnknkaigomrtisdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRTISDKBNX3)
    public String getZrnhtnknkaigomrtisdkbnx3() {
        return zrnhtnknkaigomrtisdkbnx3;
    }

    public void setZrnhtnknkaigomrtisdkbnx3(String pZrnhtnknkaigomrtisdkbnx3) {
        zrnhtnknkaigomrtisdkbnx3 = pZrnhtnknkaigomrtisdkbnx3;
    }

    private String zrnhtnknkaigomrtisdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRTISDKBNX4)
    public String getZrnhtnknkaigomrtisdkbnx4() {
        return zrnhtnknkaigomrtisdkbnx4;
    }

    public void setZrnhtnknkaigomrtisdkbnx4(String pZrnhtnknkaigomrtisdkbnx4) {
        zrnhtnknkaigomrtisdkbnx4 = pZrnhtnknkaigomrtisdkbnx4;
    }

    private String zrnhtnknkaigomrtisdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRTISDKBNX5)
    public String getZrnhtnknkaigomrtisdkbnx5() {
        return zrnhtnknkaigomrtisdkbnx5;
    }

    public void setZrnhtnknkaigomrtisdkbnx5(String pZrnhtnknkaigomrtisdkbnx5) {
        zrnhtnknkaigomrtisdkbnx5 = pZrnhtnknkaigomrtisdkbnx5;
    }

    private String zrnhtnknkaigomrtisdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNHTNKNKAIGOMRTISDKBNX6)
    public String getZrnhtnknkaigomrtisdkbnx6() {
        return zrnhtnknkaigomrtisdkbnx6;
    }

    public void setZrnhtnknkaigomrtisdkbnx6(String pZrnhtnknkaigomrtisdkbnx6) {
        zrnhtnknkaigomrtisdkbnx6 = pZrnhtnknkaigomrtisdkbnx6;
    }

    private String zrnsurkigmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNSURKIGMRTIPWRBKKBN)
    public String getZrnsurkigmrtipwrbkkbn() {
        return zrnsurkigmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsurkigmrtipwrbkkbn(String pZrnsurkigmrtipwrbkkbn) {
        zrnsurkigmrtipwrbkkbn = pZrnsurkigmrtipwrbkkbn;
    }

    private String zrnkigmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGMRTIPWRBKKBN)
    public String getZrnkigmrtipwrbkkbn() {
        return zrnkigmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigmrtipwrbkkbn(String pZrnkigmrtipwrbkkbn) {
        zrnkigmrtipwrbkkbn = pZrnkigmrtipwrbkkbn;
    }

    private String zrnkigmrtitnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGMRTITNKNYUGUKBN)
    public String getZrnkigmrtitnknyugukbn() {
        return zrnkigmrtitnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigmrtitnknyugukbn(String pZrnkigmrtitnknyugukbn) {
        zrnkigmrtitnknyugukbn = pZrnkigmrtitnknyugukbn;
    }

    private String zrnkigmrtikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGMRTIKUSNMNRYOAGE)
    public String getZrnkigmrtikusnmnryoage() {
        return zrnkigmrtikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkigmrtikusnmnryoage(String pZrnkigmrtikusnmnryoage) {
        zrnkigmrtikusnmnryoage = pZrnkigmrtikusnmnryoage;
    }

    private String zrnyobiv2x7;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV2X7)
    public String getZrnyobiv2x7() {
        return zrnyobiv2x7;
    }

    public void setZrnyobiv2x7(String pZrnyobiv2x7) {
        zrnyobiv2x7 = pZrnyobiv2x7;
    }

    private String zrnkaigotokuteisyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTOKUTEISYURUIKIGOU)
    public String getZrnkaigotokuteisyuruikigou() {
        return zrnkaigotokuteisyuruikigou;
    }

    public void setZrnkaigotokuteisyuruikigou(String pZrnkaigotokuteisyuruikigou) {
        zrnkaigotokuteisyuruikigou = pZrnkaigotokuteisyuruikigou;
    }

    private String zrnkaigotktikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTKTIKGUSDKBN)
    public String getZrnkaigotktikgusdkbn() {
        return zrnkaigotktikgusdkbn;
    }

    public void setZrnkaigotktikgusdkbn(String pZrnkaigotktikgusdkbn) {
        zrnkaigotktikgusdkbn = pZrnkaigotktikgusdkbn;
    }

    private String zrnkaigotokuteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTOKUTEIKIKAN)
    public String getZrnkaigotokuteikikan() {
        return zrnkaigotokuteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigotokuteikikan(String pZrnkaigotokuteikikan) {
        zrnkaigotokuteikikan = pZrnkaigotokuteikikan;
    }

    private Long zrnkaigotokuteis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTOKUTEIS)
    public Long getZrnkaigotokuteis() {
        return zrnkaigotokuteis;
    }

    public void setZrnkaigotokuteis(Long pZrnkaigotokuteis) {
        zrnkaigotokuteis = pZrnkaigotokuteis;
    }

    private Long zrnkaigotokuteip;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTOKUTEIP)
    public Long getZrnkaigotokuteip() {
        return zrnkaigotokuteip;
    }

    public void setZrnkaigotokuteip(Long pZrnkaigotokuteip) {
        zrnkaigotokuteip = pZrnkaigotokuteip;
    }

    private String zrnkigtktisdtpdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKIGTKTISDTPDTKBN)
    public String getZrnkigtktisdtpdtkbn() {
        return zrnkigtktisdtpdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigtktisdtpdtkbn(String pZrnkigtktisdtpdtkbn) {
        zrnkigtktisdtpdtkbn = pZrnkigtktisdtpdtkbn;
    }

    private Long zrnkaigotokuteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTOKUTEISYUUSEIS)
    public Long getZrnkaigotokuteisyuuseis() {
        return zrnkaigotokuteisyuuseis;
    }

    public void setZrnkaigotokuteisyuuseis(Long pZrnkaigotokuteisyuuseis) {
        zrnkaigotokuteisyuuseis = pZrnkaigotokuteisyuuseis;
    }

    private String zrnkaigotktimodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTKTIMODSSKGNHYJ)
    public String getZrnkaigotktimodsskgnhyj() {
        return zrnkaigotktimodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigotktimodsskgnhyj(String pZrnkaigotktimodsskgnhyj) {
        zrnkaigotktimodsskgnhyj = pZrnkaigotktimodsskgnhyj;
    }

    private String zrnkaigotktikusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAIGOTKTIKUSNMNRYOAGE)
    public String getZrnkaigotktikusnmnryoage() {
        return zrnkaigotktikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaigotktikusnmnryoage(String pZrnkaigotktikusnmnryoage) {
        zrnkaigotktikusnmnryoage = pZrnkaigotktikusnmnryoage;
    }

    private String zrnyobiv8x11;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV8X11)
    public String getZrnyobiv8x11() {
        return zrnyobiv8x11;
    }

    public void setZrnyobiv8x11(String pZrnyobiv8x11) {
        zrnyobiv8x11 = pZrnyobiv8x11;
    }

    private String zrnkazokuiryoutkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAZOKUIRYOUTKYKSYURUIKGU)
    public String getZrnkazokuiryoutkyksyuruikgu() {
        return zrnkazokuiryoutkyksyuruikgu;
    }

    public void setZrnkazokuiryoutkyksyuruikgu(String pZrnkazokuiryoutkyksyuruikgu) {
        zrnkazokuiryoutkyksyuruikgu = pZrnkazokuiryoutkyksyuruikgu;
    }

    private String zrnkazokuiryoutokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAZOKUIRYOUTOKUYAKUKIKAN)
    public String getZrnkazokuiryoutokuyakukikan() {
        return zrnkazokuiryoutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokuiryoutokuyakukikan(String pZrnkazokuiryoutokuyakukikan) {
        zrnkazokuiryoutokuyakukikan = pZrnkazokuiryoutokuyakukikan;
    }

    private String zrnkazokuiryoutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAZOKUIRYOUTKYKPHRKKKN)
    public String getZrnkazokuiryoutkykphrkkkn() {
        return zrnkazokuiryoutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokuiryoutkykphrkkkn(String pZrnkazokuiryoutkykphrkkkn) {
        zrnkazokuiryoutkykphrkkkn = pZrnkazokuiryoutkykphrkkkn;
    }

    private Long zrnkzkiryoutkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKZKIRYOUTKYKNTGK)
    public Long getZrnkzkiryoutkykntgk() {
        return zrnkzkiryoutkykntgk;
    }

    public void setZrnkzkiryoutkykntgk(Long pZrnkzkiryoutkykntgk) {
        zrnkzkiryoutkykntgk = pZrnkzkiryoutkykntgk;
    }

    private Long zrnkazokuiryoutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAZOKUIRYOUTOKUYAKUP)
    public Long getZrnkazokuiryoutokuyakup() {
        return zrnkazokuiryoutokuyakup;
    }

    public void setZrnkazokuiryoutokuyakup(Long pZrnkazokuiryoutokuyakup) {
        zrnkazokuiryoutokuyakup = pZrnkazokuiryoutokuyakup;
    }

    private String zrnkzkiryoutkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKZKIRYOUTKYKGTKBN)
    public String getZrnkzkiryoutkykgtkbn() {
        return zrnkzkiryoutkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkiryoutkykgtkbn(String pZrnkzkiryoutkykgtkbn) {
        zrnkzkiryoutkykgtkbn = pZrnkzkiryoutkykgtkbn;
    }

    private String zrnkazokuiryoutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKAZOKUIRYOUTKYKKGUSDKBN)
    public String getZrnkazokuiryoutkykkgusdkbn() {
        return zrnkazokuiryoutkykkgusdkbn;
    }

    public void setZrnkazokuiryoutkykkgusdkbn(String pZrnkazokuiryoutkykkgusdkbn) {
        zrnkazokuiryoutkykkgusdkbn = pZrnkazokuiryoutkykkgusdkbn;
    }

    private String zrnkzkiryoutktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKZKIRYOUTKTBICDX1)
    public String getZrnkzkiryoutktbicdx1() {
        return zrnkzkiryoutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkiryoutktbicdx1(String pZrnkzkiryoutktbicdx1) {
        zrnkzkiryoutktbicdx1 = pZrnkzkiryoutktbicdx1;
    }

    private String zrnkzkiryouhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKZKIRYOUHTNPKKNX1)
    public String getZrnkzkiryouhtnpkknx1() {
        return zrnkzkiryouhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkiryouhtnpkknx1(String pZrnkzkiryouhtnpkknx1) {
        zrnkzkiryouhtnpkknx1 = pZrnkzkiryouhtnpkknx1;
    }

    private String zrnkzkiryoutktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKZKIRYOUTKTBICDX2)
    public String getZrnkzkiryoutktbicdx2() {
        return zrnkzkiryoutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkiryoutktbicdx2(String pZrnkzkiryoutktbicdx2) {
        zrnkzkiryoutktbicdx2 = pZrnkzkiryoutktbicdx2;
    }

    private String zrnkzkiryouhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNKZKIRYOUHTNPKKNX2)
    public String getZrnkzkiryouhtnpkknx2() {
        return zrnkzkiryouhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkiryouhtnpkknx2(String pZrnkzkiryouhtnpkknx2) {
        zrnkzkiryouhtnpkknx2 = pZrnkzkiryouhtnpkknx2;
    }

    private String zrnyobiv12x10;

    @Column(name=GenZT_Skeiksnbsgetujisr2Rn.ZRNYOBIV12X10)
    public String getZrnyobiv12x10() {
        return zrnyobiv12x10;
    }

    public void setZrnyobiv12x10(String pZrnyobiv12x10) {
        zrnyobiv12x10 = pZrnyobiv12x10;
    }
}