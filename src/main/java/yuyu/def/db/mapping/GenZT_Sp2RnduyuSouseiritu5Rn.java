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
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu5Rn;

/**
 * ＳＰ２連動用総成立Fテーブル５（連） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu5Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu5Rn}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル５（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnktgysyrymd zrnktgysyrymd}</td><td>（連携用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu5Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgyfilerenno zrnktgyfilerenno}</td><td>（連携用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyabosyuudirtncd zrnaatukaisyabosyuudirtncd}</td><td>（連携用）Ａ扱者募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaisyabosyuudirtncd zrnbatukaisyabosyuudirtncd}</td><td>（連携用）Ｂ扱者募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessankeijyouym zrnkessankeijyouym}</td><td>（連携用）決算計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkntmttsyusnhknarihyj zrnhtnkntmttsyusnhknarihyj}</td><td>（連携用）被転換積立終身保険有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetuhosyoukikan zrntokubetuhosyoukikan}</td><td>（連携用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp3x1 zrngoukeinenbaraikansanp3x1}</td><td>（連携用）合計年払換算Ｐ３＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x1 zrnhktgtikkikkkn3x1}</td><td>（連携用）引継定期経過期間３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx1 zrnkappadhktgkujygkx1}</td><td>（連携用）カッパーＤ引継控除額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp3x2 zrngoukeinenbaraikansanp3x2}</td><td>（連携用）合計年払換算Ｐ３＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x2 zrnhktgtikkikkkn3x2}</td><td>（連携用）引継定期経過期間３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx2 zrnkappadhktgkujygkx2}</td><td>（連携用）カッパーＤ引継控除額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp3x3 zrngoukeinenbaraikansanp3x3}</td><td>（連携用）合計年払換算Ｐ３＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x3 zrnhktgtikkikkkn3x3}</td><td>（連携用）引継定期経過期間３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx3 zrnkappadhktgkujygkx3}</td><td>（連携用）カッパーＤ引継控除額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp3x4 zrngoukeinenbaraikansanp3x4}</td><td>（連携用）合計年払換算Ｐ３＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x4 zrnhktgtikkikkkn3x4}</td><td>（連携用）引継定期経過期間３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx4 zrnkappadhktgkujygkx4}</td><td>（連携用）カッパーＤ引継控除額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp3x5 zrngoukeinenbaraikansanp3x5}</td><td>（連携用）合計年払換算Ｐ３＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x5 zrnhktgtikkikkkn3x5}</td><td>（連携用）引継定期経過期間３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx5 zrnkappadhktgkujygkx5}</td><td>（連携用）カッパーＤ引継控除額＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp3x6 zrngoukeinenbaraikansanp3x6}</td><td>（連携用）合計年払換算Ｐ３＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x6 zrnhktgtikkikkkn3x6}</td><td>（連携用）引継定期経過期間３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx6 zrnkappadhktgkujygkx6}</td><td>（連携用）カッパーＤ引継控除額＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhutihnnnkknnzmkyksyono zrnhutihnnnkknnzmkyksyono}</td><td>（連携用）法定本人確認済契約証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosnyuuryokuymd zrnmosnyuuryokuymd}</td><td>（連携用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyosakuseiymd zrnmossyosakuseiymd}</td><td>（連携用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kokutiymd zrndai2kokutiymd}</td><td>（連携用）第２告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuuryousyouryakukbn zrnjyuuryousyouryakukbn}</td><td>（連携用）充領省略区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkyksyuruikgu zrnsnsniryutkyksyuruikgu}</td><td>（連携用）先進医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsensiniryoutokuyakukikan zrnsensiniryoutokuyakukikan}</td><td>（連携用）先進医療特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsensiniryoutkykphrkkkn zrnsensiniryoutkykphrkkkn}</td><td>（連携用）先進医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsensiniryoutokuyakus zrnsensiniryoutokuyakus}</td><td>（連携用）先進医療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsensiniryoutokuyakup zrnsensiniryoutokuyakup}</td><td>（連携用）先進医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsensiniryoutkykkgusdkbn zrnsensiniryoutkykkgusdkbn}</td><td>（連携用）先進医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykkguybx1 zrnsnsniryutkykkguybx1}</td><td>（連携用）先進医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykkguybx2 zrnsnsniryutkykkguybx2}</td><td>（連携用）先進医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykkguybx3 zrnsnsniryutkykkguybx3}</td><td>（連携用）先進医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykkguybx4 zrnsnsniryutkykkguybx4}</td><td>（連携用）先進医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykkguybx5 zrnsnsniryutkykkguybx5}</td><td>（連携用）先進医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykpwrbkkbn zrnsnsniryutkykpwrbkkbn}</td><td>（連携用）先進医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutktbicdx1 zrnsnsniryutktbicdx1}</td><td>（連携用）先進医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryuhtnpkknx1 zrnsnsniryuhtnpkknx1}</td><td>（連携用）先進医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutktbicdx2 zrnsnsniryutktbicdx2}</td><td>（連携用）先進医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryuhtnpkknx2 zrnsnsniryuhtnpkknx2}</td><td>（連携用）先進医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsniryutkykkusnmnryoage zrnsnsniryutkykkusnmnryoage}</td><td>（連携用）先進医療特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x17 zrnyobiv4x17}</td><td>（連携用）予備項目Ｖ４＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkyksyrikgu zrndi2snsniryutkyksyrikgu}</td><td>（連携用）第２先進医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkkn zrndi2snsniryutkykkkn}</td><td>（連携用）第２先進医療特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2snsniryutkykphrkkkn zrndai2snsniryutkykphrkkkn}</td><td>（連携用）第２先進医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2sensiniryoutokuyakus zrndai2sensiniryoutokuyakus}</td><td>（連携用）第２先進医療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2sensiniryoutokuyakup zrndai2sensiniryoutokuyakup}</td><td>（連携用）第２先進医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkgusdkbn zrndi2snsniryutkykkgusdkbn}</td><td>（連携用）第２先進医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkguybx1 zrndi2snsniryutkykkguybx1}</td><td>（連携用）第２先進医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkguybx2 zrndi2snsniryutkykkguybx2}</td><td>（連携用）第２先進医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkguybx3 zrndi2snsniryutkykkguybx3}</td><td>（連携用）第２先進医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkguybx4 zrndi2snsniryutkykkguybx4}</td><td>（連携用）第２先進医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykkguybx5 zrndi2snsniryutkykkguybx5}</td><td>（連携用）第２先進医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutkykpwrbkkbn zrndi2snsniryutkykpwrbkkbn}</td><td>（連携用）第２先進医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutktbicdx1 zrndi2snsniryutktbicdx1}</td><td>（連携用）第２先進医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryuhtnpkknx1 zrndi2snsniryuhtnpkknx1}</td><td>（連携用）第２先進医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryutktbicdx2 zrndi2snsniryutktbicdx2}</td><td>（連携用）第２先進医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2snsniryuhtnpkknx2 zrndi2snsniryuhtnpkknx2}</td><td>（連携用）第２先進医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x3 zrnyobiv6x3}</td><td>（連携用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaagetyouseihyj zrnkyksyaagetyouseihyj}</td><td>（連携用）契約者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhsyumnosjdftmttzndk zrnhsyumnosjdftmttzndk}</td><td>（連携用）保障見直時ＤＦ積立残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyjttkyksyrikgu zrnnyuinhsyujyjttkyksyrikgu}</td><td>（連携用）入院保障充実特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujttkykkkn zrnnyuinhsyujyujttkykkkn}</td><td>（連携用）入院保障充実特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyinhsyjyjttkykphrkkkn zrnnyinhsyjyjttkykphrkkkn}</td><td>（連携用）入院保障充実特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujttkyks zrnnyuinhsyujyujttkyks}</td><td>（連携用）入院保障充実特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujttkykp zrnnyuinhsyujyujttkykp}</td><td>（連携用）入院保障充実特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnyinhsyjyjttkjyrymshytn zrnnyinhsyjyjttkjyrymshytn}</td><td>（連携用）入院保障充実特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujttkyktkjyup zrnnyuinhsyujyujttkyktkjyup}</td><td>（連携用）入院保障充実特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujttktbicdx1 zrnnyuinhsyujyujttktbicdx1}</td><td>（連携用）入院保障充実特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujthtnpkknx1 zrnnyuinhsyujyujthtnpkknx1}</td><td>（連携用）入院保障充実不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujttktbicdx2 zrnnyuinhsyujyujttktbicdx2}</td><td>（連携用）入院保障充実特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyujthtnpkknx2 zrnnyuinhsyujyujthtnpkknx2}</td><td>（連携用）入院保障充実不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyinhsyjyjttkykkgusdkbn zrnnyinhsyjyjttkykkgusdkbn}</td><td>（連携用）入院保障充実特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyinhsyjyjttkykpwrbkkbn zrnnyinhsyjyjttkykpwrbkkbn}</td><td>（連携用）入院保障充実特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyjttkykkguybx1 zrnnyuinhsyujyjttkykkguybx1}</td><td>（連携用）入院保障充実特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyjttkykkguybx2 zrnnyuinhsyujyjttkykkguybx2}</td><td>（連携用）入院保障充実特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyjttkykkguybx3 zrnnyuinhsyujyjttkykkguybx3}</td><td>（連携用）入院保障充実特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyjttkykkguybx4 zrnnyuinhsyujyjttkykkguybx4}</td><td>（連携用）入院保障充実特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuinhsyujyjttkykkguybx5 zrnnyuinhsyujyjttkykkguybx5}</td><td>（連携用）入院保障充実特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyinhsyjyjtkykksnmnryage zrnnyinhsyjyjtkykksnmnryage}</td><td>（連携用）入院保障充実特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5x4 zrnyobiv5x4}</td><td>（連携用）予備項目Ｖ５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyjyjttkyksyrikg zrndi2nyinhsyjyjttkyksyrikg}</td><td>（連携用）第２入院保障充実特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyujyujttkykkkn zrndi2nyuinhsyujyujttkykkkn}</td><td>（連携用）第２入院保障充実特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyujyjtphrkkkn zrndi2nyuinhsyujyjtphrkkkn}</td><td>（連携用）第２入院保障充実Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyujyujttkyks zrndi2nyuinhsyujyujttkyks}</td><td>（連携用）第２入院保障充実特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyujyujttkykp zrndi2nyuinhsyujyujttkykp}</td><td>（連携用）第２入院保障充実特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2nyhsyjyjttkjyrymshytn zrndi2nyhsyjyjttkjyrymshytn}</td><td>（連携用）第２入院保障充実特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyujyujttkjyup zrndi2nyuinhsyujyujttkjyup}</td><td>（連携用）第２入院保障充実特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyutktbicdx1 zrndi2nyuinhsyutktbicdx1}</td><td>（連携用）第２入院保障特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyuhtnpkknx1 zrndi2nyuinhsyuhtnpkknx1}</td><td>（連携用）第２入院保障不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyutktbicdx2 zrndi2nyuinhsyutktbicdx2}</td><td>（連携用）第２入院保障特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyuhtnpkknx2 zrndi2nyuinhsyuhtnpkknx2}</td><td>（連携用）第２入院保障不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyujyjtkgusdkbn zrndi2nyinhsyujyjtkgusdkbn}</td><td>（連携用）第２入院保障充実記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyuinhsyujyjtpwrbkkbn zrndi2nyuinhsyujyjtpwrbkkbn}</td><td>（連携用）第２入院保障充実Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyjyjttkykkgybx1 zrndi2nyinhsyjyjttkykkgybx1}</td><td>（連携用）第２入院保障充実特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyjyjttkykkgybx2 zrndi2nyinhsyjyjttkykkgybx2}</td><td>（連携用）第２入院保障充実特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyjyjttkykkgybx3 zrndi2nyinhsyjyjttkykkgybx3}</td><td>（連携用）第２入院保障充実特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyjyjttkykkgybx4 zrndi2nyinhsyjyjttkykkgybx4}</td><td>（連携用）第２入院保障充実特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2nyinhsyjyjttkykkgybx5 zrndi2nyinhsyjyjttkykkgybx5}</td><td>（連携用）第２入院保障充実特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x6 zrnyobiv7x6}</td><td>（連携用）予備項目Ｖ７＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x4 zrnyobiv1x4}</td><td>（連携用）予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwnasitnknkakakujyutukbn zrnwnasitnknkakakujyutukbn}</td><td>（連携用）Ｗなし転換価格充当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeiwnasitenkankakaku zrngoukeiwnasitenkankakaku}</td><td>（連携用）合計Ｗなし転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukiwnstnknitjbrnknengk zrngukiwnstnknitjbrnknengk}</td><td>（連携用）合計Ｗなし転換一時払年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukiwnasitnknitjbrtiks zrngukiwnasitnknitjbrtiks}</td><td>（連携用）合計Ｗなし転換一時払定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x11 zrnyobiv9x11}</td><td>（連携用）予備項目Ｖ９＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkyksyuruikgu zrnsuguiryutkyksyuruikgu}</td><td>（連携用）総合医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsougouiryoutokuyakukikan zrnsougouiryoutokuyakukikan}</td><td>（連携用）総合医療特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykphrkkkn zrnsuguiryutkykphrkkkn}</td><td>（連携用）総合医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykntgk zrnsuguiryutkykntgk}</td><td>（連携用）総合医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsougouiryoutokuyakup zrnsougouiryoutokuyakup}</td><td>（連携用）総合医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkjyuryumshyutn zrnsuguiryutkjyuryumshyutn}</td><td>（連携用）総合医療特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsougouiryoutokujyoup zrnsougouiryoutokujyoup}</td><td>（連携用）総合医療特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutktbicdx1 zrnsuguiryutktbicdx1}</td><td>（連携用）総合医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryuhtnpkknx1 zrnsuguiryuhtnpkknx1}</td><td>（連携用）総合医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutktbicdx2 zrnsuguiryutktbicdx2}</td><td>（連携用）総合医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryuhtnpkknx2 zrnsuguiryuhtnpkknx2}</td><td>（連携用）総合医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkgusdkbn zrnsuguiryutkykkgusdkbn}</td><td>（連携用）総合医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykpwrbkkbn zrnsuguiryutkykpwrbkkbn}</td><td>（連携用）総合医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkguybx1 zrnsuguiryutkykkguybx1}</td><td>（連携用）総合医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkguybx2 zrnsuguiryutkykkguybx2}</td><td>（連携用）総合医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkguybx3 zrnsuguiryutkykkguybx3}</td><td>（連携用）総合医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkguybx4 zrnsuguiryutkykkguybx4}</td><td>（連携用）総合医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkguybx5 zrnsuguiryutkykkguybx5}</td><td>（連携用）総合医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuguiryutkykkusnmnryoage zrnsuguiryutkykkusnmnryoage}</td><td>（連携用）総合医療特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x7 zrnyobiv7x7}</td><td>（連携用）予備項目Ｖ７＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkyksyrikgu zrndi2suguiryutkyksyrikgu}</td><td>（連携用）第２総合医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkkn zrndi2suguiryutkykkkn}</td><td>（連携用）第２総合医療特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykphrkkkn zrndi2suguiryutkykphrkkkn}</td><td>（連携用）第２総合医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykntgk zrndi2suguiryutkykntgk}</td><td>（連携用）第２総合医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2sougouiryoutokuyakup zrndai2sougouiryoutokuyakup}</td><td>（連携用）第２総合医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkjyurymshytn zrndi2suguiryutkjyurymshytn}</td><td>（連携用）第２総合医療特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2sougouiryoutokujyoup zrndai2sougouiryoutokujyoup}</td><td>（連携用）第２総合医療特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutktbicdx1 zrndi2suguiryutktbicdx1}</td><td>（連携用）第２総合医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryuhtnpkknx1 zrndi2suguiryuhtnpkknx1}</td><td>（連携用）第２総合医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutktbicdx2 zrndi2suguiryutktbicdx2}</td><td>（連携用）第２総合医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryuhtnpkknx2 zrndi2suguiryuhtnpkknx2}</td><td>（連携用）第２総合医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkgusdkbn zrndi2suguiryutkykkgusdkbn}</td><td>（連携用）第２総合医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykpwrbkkbn zrndi2suguiryutkykpwrbkkbn}</td><td>（連携用）第２総合医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkguybx1 zrndi2suguiryutkykkguybx1}</td><td>（連携用）第２総合医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkguybx2 zrndi2suguiryutkykkguybx2}</td><td>（連携用）第２総合医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkguybx3 zrndi2suguiryutkykkguybx3}</td><td>（連携用）第２総合医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkguybx4 zrndi2suguiryutkykkguybx4}</td><td>（連携用）第２総合医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2suguiryutkykkguybx5 zrndi2suguiryutkykkguybx5}</td><td>（連携用）第２総合医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x12 zrnyobiv9x12}</td><td>（連携用）予備項目Ｖ９＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuintkyksyrikgu zrndai2gannyuintkyksyrikgu}</td><td>（連携用）第２がん入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuintkykkkn zrndai2gannyuintkykkkn}</td><td>（連携用）第２がん入院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuintkykphrkkkn zrndai2gannyuintkykphrkkkn}</td><td>（連携用）第２がん入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuintkykntgk zrndai2gannyuintkykntgk}</td><td>（連携用）第２がん入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuuintokuyakup zrndai2gannyuuintokuyakup}</td><td>（連携用）第２がん入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuintkykkgusdkbn zrndai2gannyuintkykkgusdkbn}</td><td>（連携用）第２がん入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2gannyuintkykkguyobix1 zrndi2gannyuintkykkguyobix1}</td><td>（連携用）第２がん入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2gannyuintkykkguyobix2 zrndi2gannyuintkykkguyobix2}</td><td>（連携用）第２がん入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2gannyuintkykkguyobix3 zrndi2gannyuintkykkguyobix3}</td><td>（連携用）第２がん入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2gannyuintkykkguyobix4 zrndi2gannyuintkykkguyobix4}</td><td>（連携用）第２がん入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2gannyuintkykkguyobix5 zrndi2gannyuintkykkguyobix5}</td><td>（連携用）第２がん入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2gannyuintkykpwrbkkbn zrndai2gannyuintkykpwrbkkbn}</td><td>（連携用）第２がん入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x4 zrnyobiv6x4}</td><td>（連携用）予備項目Ｖ６＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngukihtnknsuguirytkykntgk zrngukihtnknsuguirytkykntgk}</td><td>（連携用）合計被転換総合医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuusyrikgu zrnhijynbrimarusyuusyrikgu}</td><td>（連携用）平準払マル終種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimrsyukgusdkbn zrnhijynbrimrsyukgusdkbn}</td><td>（連携用）平準払マル終記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuukguybx1 zrnhijynbrimarusyuukguybx1}</td><td>（連携用）平準払マル終記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuukguybx2 zrnhijynbrimarusyuukguybx2}</td><td>（連携用）平準払マル終記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuukguybx3 zrnhijynbrimarusyuukguybx3}</td><td>（連携用）平準払マル終記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuukguybx4 zrnhijynbrimarusyuukguybx4}</td><td>（連携用）平準払マル終記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuukguybx5 zrnhijynbrimarusyuukguybx5}</td><td>（連携用）平準払マル終記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuukkn zrnhijynbrimarusyuukkn}</td><td>（連携用）平準払マル終期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimrsyphrkkkn zrnhijynbrimrsyphrkkkn}</td><td>（連携用）平準払マル終Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuutkyks zrnhijynbrimarusyuutkyks}</td><td>（連携用）平準払マル終特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuutkykp zrnhijynbrimarusyuutkykp}</td><td>（連携用）平準払マル終特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimrsypwrbkkbn zrnhijynbrimrsypwrbkkbn}</td><td>（連携用）平準払マル終Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuumods zrnhijynbrimarusyuumods}</td><td>（連携用）平準払マル終修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuutkjyukbn zrnhijynbrimarusyuutkjyukbn}</td><td>（連携用）平準払マル終特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimrsytkjyuskgnkkn zrnhijynbrimrsytkjyuskgnkkn}</td><td>（連携用）平準払マル終特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhijynbrmrsytkjyurymshytn zrnhijynbrmrsytkjyurymshytn}</td><td>（連携用）平準払マル終特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhijynbrimarusyuutkjyup zrnhijynbrimarusyuutkjyup}</td><td>（連携用）平準払マル終特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhijynbrmrsytnknygryrtkbn zrnhijynbrmrsytnknygryrtkbn}</td><td>（連携用）平準払マル終転換優遇料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x18 zrnyobiv4x18}</td><td>（連携用）予備項目Ｖ４＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyoutaihushrhyj zrntokuteijyoutaihushrhyj}</td><td>（連携用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosjikaigos zrnmosjikaigos}</td><td>（連携用）申込時介護Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmosjidi2hknkknsyuusns zrnmosjidi2hknkknsyuusns}</td><td>（連携用）申込時第２保険期間終身Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngansndntkyksyrikgu zrngansndntkyksyrikgu}</td><td>（連携用）がん診断特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykkgusdkbn zrngansndntkykkgusdkbn}</td><td>（連携用）がん診断特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykkguybx1 zrngansndntkykkguybx1}</td><td>（連携用）がん診断特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykkguybx2 zrngansndntkykkguybx2}</td><td>（連携用）がん診断特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykkguybx3 zrngansndntkykkguybx3}</td><td>（連携用）がん診断特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykkguybx4 zrngansndntkykkguybx4}</td><td>（連携用）がん診断特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykkguybx5 zrngansndntkykkguybx5}</td><td>（連携用）がん診断特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansindantokuyakukikan zrngansindantokuyakukikan}</td><td>（連携用）がん診断特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkykphrkkkn zrngansndntkykphrkkkn}</td><td>（連携用）がん診断特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansindantokuyakus zrngansindantokuyakus}</td><td>（連携用）がん診断特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngansindantokuyakup zrngansindantokuyakup}</td><td>（連携用）がん診断特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngansndntkykpwrbkkbn zrngansndntkykpwrbkkbn}</td><td>（連携用）がん診断特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansndntkyktaikknbbns zrngansndntkyktaikknbbns}</td><td>（連携用）がん診断特約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyouhinaiganmtkknbbns zrnjyouhinaiganmtkknbbns}</td><td>（連携用）上皮内がん待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngnsndntkykkusnmnryoage zrngnsndntkykkusnmnryoage}</td><td>（連携用）がん診断特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x5 zrnyobiv10x5}</td><td>（連携用）予備項目Ｖ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkyksyrikgu zrnganykbttryutkyksyrikgu}</td><td>（連携用）がん薬物治療特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkgusdkbn zrnganykbttryutkykkgusdkbn}</td><td>（連携用）がん薬物治療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkguybx1 zrnganykbttryutkykkguybx1}</td><td>（連携用）がん薬物治療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkguybx2 zrnganykbttryutkykkguybx2}</td><td>（連携用）がん薬物治療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkguybx3 zrnganykbttryutkykkguybx3}</td><td>（連携用）がん薬物治療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkguybx4 zrnganykbttryutkykkguybx4}</td><td>（連携用）がん薬物治療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkguybx5 zrnganykbttryutkykkguybx5}</td><td>（連携用）がん薬物治療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykkkn zrnganykbttryutkykkkn}</td><td>（連携用）がん薬物治療特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykphrkkkn zrnganykbttryutkykphrkkkn}</td><td>（連携用）がん薬物治療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkyks zrnganykbttryutkyks}</td><td>（連携用）がん薬物治療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykp zrnganykbttryutkykp}</td><td>（連携用）がん薬物治療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnganykbttryutkykpwrbkkbn zrnganykbttryutkykpwrbkkbn}</td><td>（連携用）がん薬物治療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnykbttryutkykksnmnryage zrngnykbttryutkykksnmnryage}</td><td>（連携用）がん薬物治療特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x11 zrnyobiv12x11}</td><td>（連携用）予備項目Ｖ１２＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngukihtnkngansndntkyks zrngukihtnkngansndntkyks}</td><td>（連携用）合計被転換がん診断特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknganykbttrytkyks zrngukihtnknganykbttrytkyks}</td><td>（連携用）合計被転換がん薬物治療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujiyoteiriritu zrnsinkeiyakujiyoteiriritu}</td><td>（連携用）新契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkousinmanryouage zrnkousinmanryouage}</td><td>（連携用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtikusnmnryoage zrnseizonmrtikusnmnryoage}</td><td>（連携用）生存マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtikusnmnryoage zrnteigenmrtikusnmnryoage}</td><td>（連携用）逓減マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtisyri zrnsiktsyunyumrtisyri}</td><td>（連携用）生活収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtikgusdikbn zrnsiktsyunyumrtikgusdikbn}</td><td>（連携用）生活収入マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtikguyobi zrnsiktsyunyumrtikguyobi}</td><td>（連携用）生活収入マル定記号予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtikguyobix2 zrnsiktsyunyumrtikguyobix2}</td><td>（連携用）生活収入マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtikguyobix3 zrnsiktsyunyumrtikguyobix3}</td><td>（連携用）生活収入マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtikguyobix4 zrnsiktsyunyumrtikguyobix4}</td><td>（連携用）生活収入マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtikguyobix5 zrnsiktsyunyumrtikguyobix5}</td><td>（連携用）生活収入マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtiktkbn zrnsiktsyunyumrtiktkbn}</td><td>（連携用）生活収入マル定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtisyugiktkbn zrnsiktsyunyumrtisyugiktkbn}</td><td>（連携用）生活収入マル定障害給付型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikatusyuunyuumrtikkn zrnseikatusyuunyuumrtikkn}</td><td>（連携用）生活収入マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtiphrikmkbn zrnsiktsyunyumrtiphrikmkbn}</td><td>（連携用）生活収入マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtishrikkn zrnsiktsyunyumrtishrikkn}</td><td>（連携用）生活収入マル定支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsynyumrtitnknwrbkkbn zrnsiktsynyumrtitnknwrbkkbn}</td><td>（連携用）生活収入マル定転換割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrsiktsyunyumrtipwrbkkbn zrnsrsiktsyunyumrtipwrbkkbn}</td><td>（連携用）数理生活収入マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtipwrbkkbn zrnsiktsyunyumrtipwrbkkbn}</td><td>（連携用）生活収入マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtiksnmnryunn zrnsiktsyunyumrtiksnmnryunn}</td><td>（連携用）生活収入マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtinnknnngk zrnsiktsyunyumrtinnknnngk}</td><td>（連携用）生活収入マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseikatusyuunyuumrtis zrnseikatusyuunyuumrtis}</td><td>（連携用）生活収入マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtiitjknks zrnsiktsyunyumrtiitjknks}</td><td>（連携用）生活収入マル定一時金化Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseikatusyuunyuumrtip zrnseikatusyuunyuumrtip}</td><td>（連携用）生活収入マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtisyuuseis zrnsiktsyunyumrtisyuuseis}</td><td>（連携用）生活収入マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtitkjyukbn zrnsiktsyunyumrtitkjyukbn}</td><td>（連携用）生活収入マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsynymrtitkjyrymshytn zrnsiktsynymrtitkjyrymshytn}</td><td>（連携用）生活収入マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsiktsyunyumrtitkjyup zrnsiktsyunyumrtitkjyup}</td><td>（連携用）生活収入マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkyksyrikgu zrnsiktsyuknbyutkyksyrikgu}</td><td>（連携用）生活習慣病特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkgsdikbn zrnsiktsyuknbyutkykkgsdikbn}</td><td>（連携用）生活習慣病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkguybi zrnsiktsyuknbyutkykkguybi}</td><td>（連携用）生活習慣病特約記号予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkguybix2 zrnsiktsyuknbyutkykkguybix2}</td><td>（連携用）生活習慣病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkguybix3 zrnsiktsyuknbyutkykkguybix3}</td><td>（連携用）生活習慣病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkguybix4 zrnsiktsyuknbyutkykkguybix4}</td><td>（連携用）生活習慣病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkguybix5 zrnsiktsyuknbyutkykkguybix5}</td><td>（連携用）生活習慣病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykkkn zrnsiktsyuknbyutkykkkn}</td><td>（連携用）生活習慣病特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykphrkmkkn zrnsiktsyuknbyutkykphrkmkkn}</td><td>（連携用）生活習慣病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyknbytyktnknwrbkkbn zrnsiktsyknbytyktnknwrbkkbn}</td><td>（連携用）生活習慣病特約転換割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrsiktsyuknbyutkpwrbkkbn zrnsrsiktsyuknbyutkpwrbkkbn}</td><td>（連携用）数理生活習慣病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykpwrbkkbn zrnsiktsyuknbyutkykpwrbkkbn}</td><td>（連携用）生活習慣病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyknbytkykkusnmnrynn zrnsiktsyknbytkykkusnmnrynn}</td><td>（連携用）生活習慣病特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkyks zrnsiktsyuknbyutkyks}</td><td>（連携用）生活習慣病特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkykp zrnsiktsyuknbyutkykp}</td><td>（連携用）生活習慣病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkyktikknars zrnsiktsyuknbyutkyktikknars}</td><td>（連携用）生活習慣病特約待期間有Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkyksyusis zrnsiktsyuknbyutkyksyusis}</td><td>（連携用）生活習慣病特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkjyukbn zrnsiktsyuknbyutkjyukbn}</td><td>（連携用）生活習慣病特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkjyrymshytn zrnsiktsyuknbyutkjyrymshytn}</td><td>（連携用）生活習慣病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutkjyup zrnsiktsyuknbyutkjyup}</td><td>（連携用）生活習慣病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutktibicd zrnsiktsyuknbyutktibicd}</td><td>（連携用）生活習慣病特定部位コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyuhtnpkkn zrnsiktsyuknbyuhtnpkkn}</td><td>（連携用）生活習慣病不担保期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyutktibicdx2 zrnsiktsyuknbyutktibicdx2}</td><td>（連携用）生活習慣病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyuhtnpkknx2 zrnsiktsyuknbyuhtnpkknx2}</td><td>（連携用）生活習慣病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv19 zrnyobiv19}</td><td>（連携用）予備項目Ｖ１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtisyrkg zrnhtnknsiktsynymrtisyrkg}</td><td>（連携用）被転換生活収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynykgusdikbn zrnhtnknsiktsynykgusdikbn}</td><td>（連携用）被転換生活収入記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgyb zrnhtnknsiktsynymrtikgyb}</td><td>（連携用）被転換生活収入マル定記号予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx2 zrnhtnknsiktsynymrtikgybx2}</td><td>（連携用）被転換生活収入マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx3 zrnhtnknsiktsynymrtikgybx3}</td><td>（連携用）被転換生活収入マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx4 zrnhtnknsiktsynymrtikgybx4}</td><td>（連携用）被転換生活収入マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx5 zrnhtnknsiktsynymrtikgybx5}</td><td>（連携用）被転換生活収入マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytksyrkg zrnhtnknsiktsyknbytksyrkg}</td><td>（連携用）被転換生活習慣病特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbykgsdkbn zrnhtnknsiktsyknbykgsdkbn}</td><td>（連携用）被転換生活習慣病記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgyb zrnhtnknsiktsyknbytkkgyb}</td><td>（連携用）被転換生活習慣病特約記号予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx2 zrnhtnknsiktsyknbytkkgybx2}</td><td>（連携用）被転換生活習慣病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx3 zrnhtnknsiktsyknbytkkgybx3}</td><td>（連携用）被転換生活習慣病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx4 zrnhtnknsiktsyknbytkkgybx4}</td><td>（連携用）被転換生活習慣病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx5 zrnhtnknsiktsyknbytkkgybx5}</td><td>（連携用）被転換生活習慣病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtisyrkgx2 zrnhtnknsiktsynymrtisyrkgx2}</td><td>（連携用）被転換生活収入マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynykgusdikbnx2 zrnhtnknsiktsynykgusdikbnx2}</td><td>（連携用）被転換生活収入記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx6 zrnhtnknsiktsynymrtikgybx6}</td><td>（連携用）被転換生活収入マル定記号予備＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx7 zrnhtnknsiktsynymrtikgybx7}</td><td>（連携用）被転換生活収入マル定記号予備＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx8 zrnhtnknsiktsynymrtikgybx8}</td><td>（連携用）被転換生活収入マル定記号予備＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx9 zrnhtnknsiktsynymrtikgybx9}</td><td>（連携用）被転換生活収入マル定記号予備＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx10 zrnhtnknsiktsynymrtikgybx10}</td><td>（連携用）被転換生活収入マル定記号予備＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytksyrkgx2 zrnhtnknsiktsyknbytksyrkgx2}</td><td>（連携用）被転換生活習慣病特約種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbykgsdkbnx2 zrnhtnknsiktsyknbykgsdkbnx2}</td><td>（連携用）被転換生活習慣病記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx6 zrnhtnknsiktsyknbytkkgybx6}</td><td>（連携用）被転換生活習慣病特約記号予備＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx7 zrnhtnknsiktsyknbytkkgybx7}</td><td>（連携用）被転換生活習慣病特約記号予備＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx8 zrnhtnknsiktsyknbytkkgybx8}</td><td>（連携用）被転換生活習慣病特約記号予備＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx9 zrnhtnknsiktsyknbytkkgybx9}</td><td>（連携用）被転換生活習慣病特約記号予備＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx10 zrnhtnknsiktsyknbytkkgybx10}</td><td>（連携用）被転換生活習慣病特約記号予備＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24x2 zrnyobiv24x2}</td><td>（連携用）予備項目Ｖ２４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtisyrkgx3 zrnhtnknsiktsynymrtisyrkgx3}</td><td>（連携用）被転換生活収入マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynykgusdikbnx3 zrnhtnknsiktsynykgusdikbnx3}</td><td>（連携用）被転換生活収入記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx11 zrnhtnknsiktsynymrtikgybx11}</td><td>（連携用）被転換生活収入マル定記号予備＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx12 zrnhtnknsiktsynymrtikgybx12}</td><td>（連携用）被転換生活収入マル定記号予備＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx13 zrnhtnknsiktsynymrtikgybx13}</td><td>（連携用）被転換生活収入マル定記号予備＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx14 zrnhtnknsiktsynymrtikgybx14}</td><td>（連携用）被転換生活収入マル定記号予備＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx15 zrnhtnknsiktsynymrtikgybx15}</td><td>（連携用）被転換生活収入マル定記号予備＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytksyrkgx3 zrnhtnknsiktsyknbytksyrkgx3}</td><td>（連携用）被転換生活習慣病特約種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbykgsdkbnx3 zrnhtnknsiktsyknbykgsdkbnx3}</td><td>（連携用）被転換生活習慣病記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx11 zrnhtnknsiktsyknbytkkgybx11}</td><td>（連携用）被転換生活習慣病特約記号予備＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx12 zrnhtnknsiktsyknbytkkgybx12}</td><td>（連携用）被転換生活習慣病特約記号予備＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx13 zrnhtnknsiktsyknbytkkgybx13}</td><td>（連携用）被転換生活習慣病特約記号予備＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx14 zrnhtnknsiktsyknbytkkgybx14}</td><td>（連携用）被転換生活習慣病特約記号予備＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx15 zrnhtnknsiktsyknbytkkgybx15}</td><td>（連携用）被転換生活習慣病特約記号予備＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24x3 zrnyobiv24x3}</td><td>（連携用）予備項目Ｖ２４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtisyrkgx4 zrnhtnknsiktsynymrtisyrkgx4}</td><td>（連携用）被転換生活収入マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynykgusdikbnx4 zrnhtnknsiktsynykgusdikbnx4}</td><td>（連携用）被転換生活収入記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx16 zrnhtnknsiktsynymrtikgybx16}</td><td>（連携用）被転換生活収入マル定記号予備＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx17 zrnhtnknsiktsynymrtikgybx17}</td><td>（連携用）被転換生活収入マル定記号予備＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx18 zrnhtnknsiktsynymrtikgybx18}</td><td>（連携用）被転換生活収入マル定記号予備＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx19 zrnhtnknsiktsynymrtikgybx19}</td><td>（連携用）被転換生活収入マル定記号予備＿１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx20 zrnhtnknsiktsynymrtikgybx20}</td><td>（連携用）被転換生活収入マル定記号予備＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytksyrkgx4 zrnhtnknsiktsyknbytksyrkgx4}</td><td>（連携用）被転換生活習慣病特約種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbykgsdkbnx4 zrnhtnknsiktsyknbykgsdkbnx4}</td><td>（連携用）被転換生活習慣病記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx16 zrnhtnknsiktsyknbytkkgybx16}</td><td>（連携用）被転換生活習慣病特約記号予備＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx17 zrnhtnknsiktsyknbytkkgybx17}</td><td>（連携用）被転換生活習慣病特約記号予備＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx18 zrnhtnknsiktsyknbytkkgybx18}</td><td>（連携用）被転換生活習慣病特約記号予備＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx19 zrnhtnknsiktsyknbytkkgybx19}</td><td>（連携用）被転換生活習慣病特約記号予備＿１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx20 zrnhtnknsiktsyknbytkkgybx20}</td><td>（連携用）被転換生活習慣病特約記号予備＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24x4 zrnyobiv24x4}</td><td>（連携用）予備項目Ｖ２４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtisyrkgx5 zrnhtnknsiktsynymrtisyrkgx5}</td><td>（連携用）被転換生活収入マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynykgusdikbnx5 zrnhtnknsiktsynykgusdikbnx5}</td><td>（連携用）被転換生活収入記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx21 zrnhtnknsiktsynymrtikgybx21}</td><td>（連携用）被転換生活収入マル定記号予備＿２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx22 zrnhtnknsiktsynymrtikgybx22}</td><td>（連携用）被転換生活収入マル定記号予備＿２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx23 zrnhtnknsiktsynymrtikgybx23}</td><td>（連携用）被転換生活収入マル定記号予備＿２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx24 zrnhtnknsiktsynymrtikgybx24}</td><td>（連携用）被転換生活収入マル定記号予備＿２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx25 zrnhtnknsiktsynymrtikgybx25}</td><td>（連携用）被転換生活収入マル定記号予備＿２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytksyrkgx5 zrnhtnknsiktsyknbytksyrkgx5}</td><td>（連携用）被転換生活習慣病特約種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbykgsdkbnx5 zrnhtnknsiktsyknbykgsdkbnx5}</td><td>（連携用）被転換生活習慣病記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx21 zrnhtnknsiktsyknbytkkgybx21}</td><td>（連携用）被転換生活習慣病特約記号予備＿２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx22 zrnhtnknsiktsyknbytkkgybx22}</td><td>（連携用）被転換生活習慣病特約記号予備＿２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx23 zrnhtnknsiktsyknbytkkgybx23}</td><td>（連携用）被転換生活習慣病特約記号予備＿２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx24 zrnhtnknsiktsyknbytkkgybx24}</td><td>（連携用）被転換生活習慣病特約記号予備＿２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx25 zrnhtnknsiktsyknbytkkgybx25}</td><td>（連携用）被転換生活習慣病特約記号予備＿２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24x5 zrnyobiv24x5}</td><td>（連携用）予備項目Ｖ２４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtisyrkgx6 zrnhtnknsiktsynymrtisyrkgx6}</td><td>（連携用）被転換生活収入マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynykgusdikbnx6 zrnhtnknsiktsynykgusdikbnx6}</td><td>（連携用）被転換生活収入記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx26 zrnhtnknsiktsynymrtikgybx26}</td><td>（連携用）被転換生活収入マル定記号予備＿２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx27 zrnhtnknsiktsynymrtikgybx27}</td><td>（連携用）被転換生活収入マル定記号予備＿２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx28 zrnhtnknsiktsynymrtikgybx28}</td><td>（連携用）被転換生活収入マル定記号予備＿２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx29 zrnhtnknsiktsynymrtikgybx29}</td><td>（連携用）被転換生活収入マル定記号予備＿２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsynymrtikgybx30 zrnhtnknsiktsynymrtikgybx30}</td><td>（連携用）被転換生活収入マル定記号予備＿３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytksyrkgx6 zrnhtnknsiktsyknbytksyrkgx6}</td><td>（連携用）被転換生活習慣病特約種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbykgsdkbnx6 zrnhtnknsiktsyknbykgsdkbnx6}</td><td>（連携用）被転換生活習慣病記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx26 zrnhtnknsiktsyknbytkkgybx26}</td><td>（連携用）被転換生活習慣病特約記号予備＿２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx27 zrnhtnknsiktsyknbytkkgybx27}</td><td>（連携用）被転換生活習慣病特約記号予備＿２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx28 zrnhtnknsiktsyknbytkkgybx28}</td><td>（連携用）被転換生活習慣病特約記号予備＿２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx29 zrnhtnknsiktsyknbytkkgybx29}</td><td>（連携用）被転換生活習慣病特約記号予備＿２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknsiktsyknbytkkgybx30 zrnhtnknsiktsyknbytkkgybx30}</td><td>（連携用）被転換生活習慣病特約記号予備＿３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24x6 zrnyobiv24x6}</td><td>（連携用）予備項目Ｖ２４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrmkhritu zrnkaiyakuhrmkhritu}</td><td>（連携用）解約返戻金目標率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitatekinitenmkhyurt zrntumitatekinitenmkhyurt}</td><td>（連携用）積立金移転目標率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv250 zrnyobiv250}</td><td>（連携用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv248 zrnyobiv248}</td><td>（連携用）予備項目Ｖ２４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu5Rn
 * @see     PKZT_Sp2RnduyuSouseiritu5Rn
 * @see     QZT_Sp2RnduyuSouseiritu5Rn
 * @see     GenQZT_Sp2RnduyuSouseiritu5Rn
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu5Rn.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu5Rn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu5Rn extends AbstractExDBEntityForZDB<ZT_Sp2RnduyuSouseiritu5Rn, PKZT_Sp2RnduyuSouseiritu5Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu5Rn";
    public static final String ZRNKTGYSYRYMD            = "zrnktgysyrymd";
    public static final String ZRNKTGYSYONO             = "zrnktgysyono";
    public static final String ZRNKTGYFILERENNO         = "zrnktgyfilerenno";
    public static final String ZRNAATUKAISYABOSYUUDIRTNCD = "zrnaatukaisyabosyuudirtncd";
    public static final String ZRNBATUKAISYABOSYUUDIRTNCD = "zrnbatukaisyabosyuudirtncd";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNKESSANKEIJYOUYM       = "zrnkessankeijyouym";
    public static final String ZRNHTNKNTMTTSYUSNHKNARIHYJ = "zrnhtnkntmttsyusnhknarihyj";
    public static final String ZRNTOKUBETUHOSYOUKIKAN   = "zrntokubetuhosyoukikan";
    public static final String ZRNGOUKEINENBARAIKANSANP3X1 = "zrngoukeinenbaraikansanp3x1";
    public static final String ZRNHKTGTIKKIKKKN3X1      = "zrnhktgtikkikkkn3x1";
    public static final String ZRNKAPPADHKTGKUJYGKX1    = "zrnkappadhktgkujygkx1";
    public static final String ZRNGOUKEINENBARAIKANSANP3X2 = "zrngoukeinenbaraikansanp3x2";
    public static final String ZRNHKTGTIKKIKKKN3X2      = "zrnhktgtikkikkkn3x2";
    public static final String ZRNKAPPADHKTGKUJYGKX2    = "zrnkappadhktgkujygkx2";
    public static final String ZRNGOUKEINENBARAIKANSANP3X3 = "zrngoukeinenbaraikansanp3x3";
    public static final String ZRNHKTGTIKKIKKKN3X3      = "zrnhktgtikkikkkn3x3";
    public static final String ZRNKAPPADHKTGKUJYGKX3    = "zrnkappadhktgkujygkx3";
    public static final String ZRNGOUKEINENBARAIKANSANP3X4 = "zrngoukeinenbaraikansanp3x4";
    public static final String ZRNHKTGTIKKIKKKN3X4      = "zrnhktgtikkikkkn3x4";
    public static final String ZRNKAPPADHKTGKUJYGKX4    = "zrnkappadhktgkujygkx4";
    public static final String ZRNGOUKEINENBARAIKANSANP3X5 = "zrngoukeinenbaraikansanp3x5";
    public static final String ZRNHKTGTIKKIKKKN3X5      = "zrnhktgtikkikkkn3x5";
    public static final String ZRNKAPPADHKTGKUJYGKX5    = "zrnkappadhktgkujygkx5";
    public static final String ZRNGOUKEINENBARAIKANSANP3X6 = "zrngoukeinenbaraikansanp3x6";
    public static final String ZRNHKTGTIKKIKKKN3X6      = "zrnhktgtikkikkkn3x6";
    public static final String ZRNKAPPADHKTGKUJYGKX6    = "zrnkappadhktgkujygkx6";
    public static final String ZRNHUTIHNNNKKNNZMKYKSYONO = "zrnhutihnnnkknnzmkyksyono";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNMOSNYUURYOKUYMD       = "zrnmosnyuuryokuymd";
    public static final String ZRNMOSSYOSAKUSEIYMD      = "zrnmossyosakuseiymd";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNDAI2KOKUTIYMD         = "zrndai2kokutiymd";
    public static final String ZRNJYUURYOUSYOURYAKUKBN  = "zrnjyuuryousyouryakukbn";
    public static final String ZRNSNSNIRYUTKYKSYURUIKGU = "zrnsnsniryutkyksyuruikgu";
    public static final String ZRNSENSINIRYOUTOKUYAKUKIKAN = "zrnsensiniryoutokuyakukikan";
    public static final String ZRNSENSINIRYOUTKYKPHRKKKN = "zrnsensiniryoutkykphrkkkn";
    public static final String ZRNSENSINIRYOUTOKUYAKUS  = "zrnsensiniryoutokuyakus";
    public static final String ZRNSENSINIRYOUTOKUYAKUP  = "zrnsensiniryoutokuyakup";
    public static final String ZRNSENSINIRYOUTKYKKGUSDKBN = "zrnsensiniryoutkykkgusdkbn";
    public static final String ZRNSNSNIRYUTKYKKGUYBX1   = "zrnsnsniryutkykkguybx1";
    public static final String ZRNSNSNIRYUTKYKKGUYBX2   = "zrnsnsniryutkykkguybx2";
    public static final String ZRNSNSNIRYUTKYKKGUYBX3   = "zrnsnsniryutkykkguybx3";
    public static final String ZRNSNSNIRYUTKYKKGUYBX4   = "zrnsnsniryutkykkguybx4";
    public static final String ZRNSNSNIRYUTKYKKGUYBX5   = "zrnsnsniryutkykkguybx5";
    public static final String ZRNSNSNIRYUTKYKPWRBKKBN  = "zrnsnsniryutkykpwrbkkbn";
    public static final String ZRNSNSNIRYUTKTBICDX1     = "zrnsnsniryutktbicdx1";
    public static final String ZRNSNSNIRYUHTNPKKNX1     = "zrnsnsniryuhtnpkknx1";
    public static final String ZRNSNSNIRYUTKTBICDX2     = "zrnsnsniryutktbicdx2";
    public static final String ZRNSNSNIRYUHTNPKKNX2     = "zrnsnsniryuhtnpkknx2";
    public static final String ZRNSNSNIRYUTKYKKUSNMNRYOAGE = "zrnsnsniryutkykkusnmnryoage";
    public static final String ZRNYOBIV4X17             = "zrnyobiv4x17";
    public static final String ZRNDI2SNSNIRYUTKYKSYRIKGU = "zrndi2snsniryutkyksyrikgu";
    public static final String ZRNDI2SNSNIRYUTKYKKKN    = "zrndi2snsniryutkykkkn";
    public static final String ZRNDAI2SNSNIRYUTKYKPHRKKKN = "zrndai2snsniryutkykphrkkkn";
    public static final String ZRNDAI2SENSINIRYOUTOKUYAKUS = "zrndai2sensiniryoutokuyakus";
    public static final String ZRNDAI2SENSINIRYOUTOKUYAKUP = "zrndai2sensiniryoutokuyakup";
    public static final String ZRNDI2SNSNIRYUTKYKKGUSDKBN = "zrndi2snsniryutkykkgusdkbn";
    public static final String ZRNDI2SNSNIRYUTKYKKGUYBX1 = "zrndi2snsniryutkykkguybx1";
    public static final String ZRNDI2SNSNIRYUTKYKKGUYBX2 = "zrndi2snsniryutkykkguybx2";
    public static final String ZRNDI2SNSNIRYUTKYKKGUYBX3 = "zrndi2snsniryutkykkguybx3";
    public static final String ZRNDI2SNSNIRYUTKYKKGUYBX4 = "zrndi2snsniryutkykkguybx4";
    public static final String ZRNDI2SNSNIRYUTKYKKGUYBX5 = "zrndi2snsniryutkykkguybx5";
    public static final String ZRNDI2SNSNIRYUTKYKPWRBKKBN = "zrndi2snsniryutkykpwrbkkbn";
    public static final String ZRNDI2SNSNIRYUTKTBICDX1  = "zrndi2snsniryutktbicdx1";
    public static final String ZRNDI2SNSNIRYUHTNPKKNX1  = "zrndi2snsniryuhtnpkknx1";
    public static final String ZRNDI2SNSNIRYUTKTBICDX2  = "zrndi2snsniryutktbicdx2";
    public static final String ZRNDI2SNSNIRYUHTNPKKNX2  = "zrndi2snsniryuhtnpkknx2";
    public static final String ZRNYOBIV6X3              = "zrnyobiv6x3";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNKYKSYAAGETYOUSEIHYJ   = "zrnkyksyaagetyouseihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNHSYUMNOSJDFTMTTZNDK   = "zrnhsyumnosjdftmttzndk";
    public static final String ZRNNYUINHSYUJYJTTKYKSYRIKGU = "zrnnyuinhsyujyjttkyksyrikgu";
    public static final String ZRNNYUINHSYUJYUJTTKYKKKN = "zrnnyuinhsyujyujttkykkkn";
    public static final String ZRNNYINHSYJYJTTKYKPHRKKKN = "zrnnyinhsyjyjttkykphrkkkn";
    public static final String ZRNNYUINHSYUJYUJTTKYKS   = "zrnnyuinhsyujyujttkyks";
    public static final String ZRNNYUINHSYUJYUJTTKYKP   = "zrnnyuinhsyujyujttkykp";
    public static final String ZRNNYINHSYJYJTTKJYRYMSHYTN = "zrnnyinhsyjyjttkjyrymshytn";
    public static final String ZRNNYUINHSYUJYUJTTKYKTKJYUP = "zrnnyuinhsyujyujttkyktkjyup";
    public static final String ZRNNYUINHSYUJYUJTTKTBICDX1 = "zrnnyuinhsyujyujttktbicdx1";
    public static final String ZRNNYUINHSYUJYUJTHTNPKKNX1 = "zrnnyuinhsyujyujthtnpkknx1";
    public static final String ZRNNYUINHSYUJYUJTTKTBICDX2 = "zrnnyuinhsyujyujttktbicdx2";
    public static final String ZRNNYUINHSYUJYUJTHTNPKKNX2 = "zrnnyuinhsyujyujthtnpkknx2";
    public static final String ZRNNYINHSYJYJTTKYKKGUSDKBN = "zrnnyinhsyjyjttkykkgusdkbn";
    public static final String ZRNNYINHSYJYJTTKYKPWRBKKBN = "zrnnyinhsyjyjttkykpwrbkkbn";
    public static final String ZRNNYUINHSYUJYJTTKYKKGUYBX1 = "zrnnyuinhsyujyjttkykkguybx1";
    public static final String ZRNNYUINHSYUJYJTTKYKKGUYBX2 = "zrnnyuinhsyujyjttkykkguybx2";
    public static final String ZRNNYUINHSYUJYJTTKYKKGUYBX3 = "zrnnyuinhsyujyjttkykkguybx3";
    public static final String ZRNNYUINHSYUJYJTTKYKKGUYBX4 = "zrnnyuinhsyujyjttkykkguybx4";
    public static final String ZRNNYUINHSYUJYJTTKYKKGUYBX5 = "zrnnyuinhsyujyjttkykkguybx5";
    public static final String ZRNNYINHSYJYJTKYKKSNMNRYAGE = "zrnnyinhsyjyjtkykksnmnryage";
    public static final String ZRNYOBIV5X4              = "zrnyobiv5x4";
    public static final String ZRNDI2NYINHSYJYJTTKYKSYRIKG = "zrndi2nyinhsyjyjttkyksyrikg";
    public static final String ZRNDI2NYUINHSYUJYUJTTKYKKKN = "zrndi2nyuinhsyujyujttkykkkn";
    public static final String ZRNDI2NYUINHSYUJYJTPHRKKKN = "zrndi2nyuinhsyujyjtphrkkkn";
    public static final String ZRNDI2NYUINHSYUJYUJTTKYKS = "zrndi2nyuinhsyujyujttkyks";
    public static final String ZRNDI2NYUINHSYUJYUJTTKYKP = "zrndi2nyuinhsyujyujttkykp";
    public static final String ZRNDI2NYHSYJYJTTKJYRYMSHYTN = "zrndi2nyhsyjyjttkjyrymshytn";
    public static final String ZRNDI2NYUINHSYUJYUJTTKJYUP = "zrndi2nyuinhsyujyujttkjyup";
    public static final String ZRNDI2NYUINHSYUTKTBICDX1 = "zrndi2nyuinhsyutktbicdx1";
    public static final String ZRNDI2NYUINHSYUHTNPKKNX1 = "zrndi2nyuinhsyuhtnpkknx1";
    public static final String ZRNDI2NYUINHSYUTKTBICDX2 = "zrndi2nyuinhsyutktbicdx2";
    public static final String ZRNDI2NYUINHSYUHTNPKKNX2 = "zrndi2nyuinhsyuhtnpkknx2";
    public static final String ZRNDI2NYINHSYUJYJTKGUSDKBN = "zrndi2nyinhsyujyjtkgusdkbn";
    public static final String ZRNDI2NYUINHSYUJYJTPWRBKKBN = "zrndi2nyuinhsyujyjtpwrbkkbn";
    public static final String ZRNDI2NYINHSYJYJTTKYKKGYBX1 = "zrndi2nyinhsyjyjttkykkgybx1";
    public static final String ZRNDI2NYINHSYJYJTTKYKKGYBX2 = "zrndi2nyinhsyjyjttkykkgybx2";
    public static final String ZRNDI2NYINHSYJYJTTKYKKGYBX3 = "zrndi2nyinhsyjyjttkykkgybx3";
    public static final String ZRNDI2NYINHSYJYJTTKYKKGYBX4 = "zrndi2nyinhsyjyjttkykkgybx4";
    public static final String ZRNDI2NYINHSYJYJTTKYKKGYBX5 = "zrndi2nyinhsyjyjttkykkgybx5";
    public static final String ZRNYOBIV7X6              = "zrnyobiv7x6";
    public static final String ZRNYOBIV1X4              = "zrnyobiv1x4";
    public static final String ZRNWNASITNKNKAKAKUJYUTUKBN = "zrnwnasitnknkakakujyutukbn";
    public static final String ZRNGOUKEIWNASITENKANKAKAKU = "zrngoukeiwnasitenkankakaku";
    public static final String ZRNGUKIWNSTNKNITJBRNKNENGK = "zrngukiwnstnknitjbrnknengk";
    public static final String ZRNGUKIWNASITNKNITJBRTIKS = "zrngukiwnasitnknitjbrtiks";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIV9X11             = "zrnyobiv9x11";
    public static final String ZRNSUGUIRYUTKYKSYURUIKGU = "zrnsuguiryutkyksyuruikgu";
    public static final String ZRNSOUGOUIRYOUTOKUYAKUKIKAN = "zrnsougouiryoutokuyakukikan";
    public static final String ZRNSUGUIRYUTKYKPHRKKKN   = "zrnsuguiryutkykphrkkkn";
    public static final String ZRNSUGUIRYUTKYKNTGK      = "zrnsuguiryutkykntgk";
    public static final String ZRNSOUGOUIRYOUTOKUYAKUP  = "zrnsougouiryoutokuyakup";
    public static final String ZRNSUGUIRYUTKJYURYUMSHYUTN = "zrnsuguiryutkjyuryumshyutn";
    public static final String ZRNSOUGOUIRYOUTOKUJYOUP  = "zrnsougouiryoutokujyoup";
    public static final String ZRNSUGUIRYUTKTBICDX1     = "zrnsuguiryutktbicdx1";
    public static final String ZRNSUGUIRYUHTNPKKNX1     = "zrnsuguiryuhtnpkknx1";
    public static final String ZRNSUGUIRYUTKTBICDX2     = "zrnsuguiryutktbicdx2";
    public static final String ZRNSUGUIRYUHTNPKKNX2     = "zrnsuguiryuhtnpkknx2";
    public static final String ZRNSUGUIRYUTKYKKGUSDKBN  = "zrnsuguiryutkykkgusdkbn";
    public static final String ZRNSUGUIRYUTKYKPWRBKKBN  = "zrnsuguiryutkykpwrbkkbn";
    public static final String ZRNSUGUIRYUTKYKKGUYBX1   = "zrnsuguiryutkykkguybx1";
    public static final String ZRNSUGUIRYUTKYKKGUYBX2   = "zrnsuguiryutkykkguybx2";
    public static final String ZRNSUGUIRYUTKYKKGUYBX3   = "zrnsuguiryutkykkguybx3";
    public static final String ZRNSUGUIRYUTKYKKGUYBX4   = "zrnsuguiryutkykkguybx4";
    public static final String ZRNSUGUIRYUTKYKKGUYBX5   = "zrnsuguiryutkykkguybx5";
    public static final String ZRNSUGUIRYUTKYKKUSNMNRYOAGE = "zrnsuguiryutkykkusnmnryoage";
    public static final String ZRNYOBIV7X7              = "zrnyobiv7x7";
    public static final String ZRNDI2SUGUIRYUTKYKSYRIKGU = "zrndi2suguiryutkyksyrikgu";
    public static final String ZRNDI2SUGUIRYUTKYKKKN    = "zrndi2suguiryutkykkkn";
    public static final String ZRNDI2SUGUIRYUTKYKPHRKKKN = "zrndi2suguiryutkykphrkkkn";
    public static final String ZRNDI2SUGUIRYUTKYKNTGK   = "zrndi2suguiryutkykntgk";
    public static final String ZRNDAI2SOUGOUIRYOUTOKUYAKUP = "zrndai2sougouiryoutokuyakup";
    public static final String ZRNDI2SUGUIRYUTKJYURYMSHYTN = "zrndi2suguiryutkjyurymshytn";
    public static final String ZRNDAI2SOUGOUIRYOUTOKUJYOUP = "zrndai2sougouiryoutokujyoup";
    public static final String ZRNDI2SUGUIRYUTKTBICDX1  = "zrndi2suguiryutktbicdx1";
    public static final String ZRNDI2SUGUIRYUHTNPKKNX1  = "zrndi2suguiryuhtnpkknx1";
    public static final String ZRNDI2SUGUIRYUTKTBICDX2  = "zrndi2suguiryutktbicdx2";
    public static final String ZRNDI2SUGUIRYUHTNPKKNX2  = "zrndi2suguiryuhtnpkknx2";
    public static final String ZRNDI2SUGUIRYUTKYKKGUSDKBN = "zrndi2suguiryutkykkgusdkbn";
    public static final String ZRNDI2SUGUIRYUTKYKPWRBKKBN = "zrndi2suguiryutkykpwrbkkbn";
    public static final String ZRNDI2SUGUIRYUTKYKKGUYBX1 = "zrndi2suguiryutkykkguybx1";
    public static final String ZRNDI2SUGUIRYUTKYKKGUYBX2 = "zrndi2suguiryutkykkguybx2";
    public static final String ZRNDI2SUGUIRYUTKYKKGUYBX3 = "zrndi2suguiryutkykkguybx3";
    public static final String ZRNDI2SUGUIRYUTKYKKGUYBX4 = "zrndi2suguiryutkykkguybx4";
    public static final String ZRNDI2SUGUIRYUTKYKKGUYBX5 = "zrndi2suguiryutkykkguybx5";
    public static final String ZRNYOBIV9X12             = "zrnyobiv9x12";
    public static final String ZRNDAI2GANNYUINTKYKSYRIKGU = "zrndai2gannyuintkyksyrikgu";
    public static final String ZRNDAI2GANNYUINTKYKKKN   = "zrndai2gannyuintkykkkn";
    public static final String ZRNDAI2GANNYUINTKYKPHRKKKN = "zrndai2gannyuintkykphrkkkn";
    public static final String ZRNDAI2GANNYUINTKYKNTGK  = "zrndai2gannyuintkykntgk";
    public static final String ZRNDAI2GANNYUUINTOKUYAKUP = "zrndai2gannyuuintokuyakup";
    public static final String ZRNDAI2GANNYUINTKYKKGUSDKBN = "zrndai2gannyuintkykkgusdkbn";
    public static final String ZRNDI2GANNYUINTKYKKGUYOBIX1 = "zrndi2gannyuintkykkguyobix1";
    public static final String ZRNDI2GANNYUINTKYKKGUYOBIX2 = "zrndi2gannyuintkykkguyobix2";
    public static final String ZRNDI2GANNYUINTKYKKGUYOBIX3 = "zrndi2gannyuintkykkguyobix3";
    public static final String ZRNDI2GANNYUINTKYKKGUYOBIX4 = "zrndi2gannyuintkykkguyobix4";
    public static final String ZRNDI2GANNYUINTKYKKGUYOBIX5 = "zrndi2gannyuintkykkguyobix5";
    public static final String ZRNDAI2GANNYUINTKYKPWRBKKBN = "zrndai2gannyuintkykpwrbkkbn";
    public static final String ZRNYOBIV6X4              = "zrnyobiv6x4";
    public static final String ZRNGUKIHTNKNSUGUIRYTKYKNTGK = "zrngukihtnknsuguirytkykntgk";
    public static final String ZRNHIJYNBRIMARUSYUUSYRIKGU = "zrnhijynbrimarusyuusyrikgu";
    public static final String ZRNHIJYNBRIMRSYUKGUSDKBN = "zrnhijynbrimrsyukgusdkbn";
    public static final String ZRNHIJYNBRIMARUSYUUKGUYBX1 = "zrnhijynbrimarusyuukguybx1";
    public static final String ZRNHIJYNBRIMARUSYUUKGUYBX2 = "zrnhijynbrimarusyuukguybx2";
    public static final String ZRNHIJYNBRIMARUSYUUKGUYBX3 = "zrnhijynbrimarusyuukguybx3";
    public static final String ZRNHIJYNBRIMARUSYUUKGUYBX4 = "zrnhijynbrimarusyuukguybx4";
    public static final String ZRNHIJYNBRIMARUSYUUKGUYBX5 = "zrnhijynbrimarusyuukguybx5";
    public static final String ZRNHIJYNBRIMARUSYUUKKN   = "zrnhijynbrimarusyuukkn";
    public static final String ZRNHIJYNBRIMRSYPHRKKKN   = "zrnhijynbrimrsyphrkkkn";
    public static final String ZRNHIJYNBRIMARUSYUUTKYKS = "zrnhijynbrimarusyuutkyks";
    public static final String ZRNHIJYNBRIMARUSYUUTKYKP = "zrnhijynbrimarusyuutkykp";
    public static final String ZRNHIJYNBRIMRSYPWRBKKBN  = "zrnhijynbrimrsypwrbkkbn";
    public static final String ZRNHIJYNBRIMARUSYUUMODS  = "zrnhijynbrimarusyuumods";
    public static final String ZRNHIJYNBRIMARUSYUUTKJYUKBN = "zrnhijynbrimarusyuutkjyukbn";
    public static final String ZRNHIJYNBRIMRSYTKJYUSKGNKKN = "zrnhijynbrimrsytkjyuskgnkkn";
    public static final String ZRNHIJYNBRMRSYTKJYURYMSHYTN = "zrnhijynbrmrsytkjyurymshytn";
    public static final String ZRNHIJYNBRIMARUSYUUTKJYUP = "zrnhijynbrimarusyuutkjyup";
    public static final String ZRNHIJYNBRMRSYTNKNYGRYRTKBN = "zrnhijynbrmrsytnknygryrtkbn";
    public static final String ZRNYOBIV4X18             = "zrnyobiv4x18";
    public static final String ZRNTOKUTEIJYOUTAIHUSHRHYJ = "zrntokuteijyoutaihushrhyj";
    public static final String ZRNMOSJIKAIGOS           = "zrnmosjikaigos";
    public static final String ZRNMOSJIDI2HKNKKNSYUUSNS = "zrnmosjidi2hknkknsyuusns";
    public static final String ZRNGANSNDNTKYKSYRIKGU    = "zrngansndntkyksyrikgu";
    public static final String ZRNGANSNDNTKYKKGUSDKBN   = "zrngansndntkykkgusdkbn";
    public static final String ZRNGANSNDNTKYKKGUYBX1    = "zrngansndntkykkguybx1";
    public static final String ZRNGANSNDNTKYKKGUYBX2    = "zrngansndntkykkguybx2";
    public static final String ZRNGANSNDNTKYKKGUYBX3    = "zrngansndntkykkguybx3";
    public static final String ZRNGANSNDNTKYKKGUYBX4    = "zrngansndntkykkguybx4";
    public static final String ZRNGANSNDNTKYKKGUYBX5    = "zrngansndntkykkguybx5";
    public static final String ZRNGANSINDANTOKUYAKUKIKAN = "zrngansindantokuyakukikan";
    public static final String ZRNGANSNDNTKYKPHRKKKN    = "zrngansndntkykphrkkkn";
    public static final String ZRNGANSINDANTOKUYAKUS    = "zrngansindantokuyakus";
    public static final String ZRNGANSINDANTOKUYAKUP    = "zrngansindantokuyakup";
    public static final String ZRNGANSNDNTKYKPWRBKKBN   = "zrngansndntkykpwrbkkbn";
    public static final String ZRNGANSNDNTKYKTAIKKNBBNS = "zrngansndntkyktaikknbbns";
    public static final String ZRNJYOUHINAIGANMTKKNBBNS = "zrnjyouhinaiganmtkknbbns";
    public static final String ZRNGNSNDNTKYKKUSNMNRYOAGE = "zrngnsndntkykkusnmnryoage";
    public static final String ZRNYOBIV10X5             = "zrnyobiv10x5";
    public static final String ZRNGANYKBTTRYUTKYKSYRIKGU = "zrnganykbttryutkyksyrikgu";
    public static final String ZRNGANYKBTTRYUTKYKKGUSDKBN = "zrnganykbttryutkykkgusdkbn";
    public static final String ZRNGANYKBTTRYUTKYKKGUYBX1 = "zrnganykbttryutkykkguybx1";
    public static final String ZRNGANYKBTTRYUTKYKKGUYBX2 = "zrnganykbttryutkykkguybx2";
    public static final String ZRNGANYKBTTRYUTKYKKGUYBX3 = "zrnganykbttryutkykkguybx3";
    public static final String ZRNGANYKBTTRYUTKYKKGUYBX4 = "zrnganykbttryutkykkguybx4";
    public static final String ZRNGANYKBTTRYUTKYKKGUYBX5 = "zrnganykbttryutkykkguybx5";
    public static final String ZRNGANYKBTTRYUTKYKKKN    = "zrnganykbttryutkykkkn";
    public static final String ZRNGANYKBTTRYUTKYKPHRKKKN = "zrnganykbttryutkykphrkkkn";
    public static final String ZRNGANYKBTTRYUTKYKS      = "zrnganykbttryutkyks";
    public static final String ZRNGANYKBTTRYUTKYKP      = "zrnganykbttryutkykp";
    public static final String ZRNGANYKBTTRYUTKYKPWRBKKBN = "zrnganykbttryutkykpwrbkkbn";
    public static final String ZRNGNYKBTTRYUTKYKKSNMNRYAGE = "zrngnykbttryutkykksnmnryage";
    public static final String ZRNYOBIV12X11            = "zrnyobiv12x11";
    public static final String ZRNGUKIHTNKNGANSNDNTKYKS = "zrngukihtnkngansndntkyks";
    public static final String ZRNGUKIHTNKNGANYKBTTRYTKYKS = "zrngukihtnknganykbttrytkyks";
    public static final String ZRNSINKEIYAKUJIYOTEIRIRITU = "zrnsinkeiyakujiyoteiriritu";
    public static final String ZRNKOUSINMANRYOUAGE      = "zrnkousinmanryouage";
    public static final String ZRNSEIZONMRTIKUSNMNRYOAGE = "zrnseizonmrtikusnmnryoage";
    public static final String ZRNTEIGENMRTIKUSNMNRYOAGE = "zrnteigenmrtikusnmnryoage";
    public static final String ZRNSIKTSYUNYUMRTISYRI    = "zrnsiktsyunyumrtisyri";
    public static final String ZRNSIKTSYUNYUMRTIKGUSDIKBN = "zrnsiktsyunyumrtikgusdikbn";
    public static final String ZRNSIKTSYUNYUMRTIKGUYOBI = "zrnsiktsyunyumrtikguyobi";
    public static final String ZRNSIKTSYUNYUMRTIKGUYOBIX2 = "zrnsiktsyunyumrtikguyobix2";
    public static final String ZRNSIKTSYUNYUMRTIKGUYOBIX3 = "zrnsiktsyunyumrtikguyobix3";
    public static final String ZRNSIKTSYUNYUMRTIKGUYOBIX4 = "zrnsiktsyunyumrtikguyobix4";
    public static final String ZRNSIKTSYUNYUMRTIKGUYOBIX5 = "zrnsiktsyunyumrtikguyobix5";
    public static final String ZRNSIKTSYUNYUMRTIKTKBN   = "zrnsiktsyunyumrtiktkbn";
    public static final String ZRNSIKTSYUNYUMRTISYUGIKTKBN = "zrnsiktsyunyumrtisyugiktkbn";
    public static final String ZRNSEIKATUSYUUNYUUMRTIKKN = "zrnseikatusyuunyuumrtikkn";
    public static final String ZRNSIKTSYUNYUMRTIPHRIKMKBN = "zrnsiktsyunyumrtiphrikmkbn";
    public static final String ZRNSIKTSYUNYUMRTISHRIKKN = "zrnsiktsyunyumrtishrikkn";
    public static final String ZRNSIKTSYNYUMRTITNKNWRBKKBN = "zrnsiktsynyumrtitnknwrbkkbn";
    public static final String ZRNSRSIKTSYUNYUMRTIPWRBKKBN = "zrnsrsiktsyunyumrtipwrbkkbn";
    public static final String ZRNSIKTSYUNYUMRTIPWRBKKBN = "zrnsiktsyunyumrtipwrbkkbn";
    public static final String ZRNSIKTSYUNYUMRTIKSNMNRYUNN = "zrnsiktsyunyumrtiksnmnryunn";
    public static final String ZRNSIKTSYUNYUMRTINNKNNNGK = "zrnsiktsyunyumrtinnknnngk";
    public static final String ZRNSEIKATUSYUUNYUUMRTIS  = "zrnseikatusyuunyuumrtis";
    public static final String ZRNSIKTSYUNYUMRTIITJKNKS = "zrnsiktsyunyumrtiitjknks";
    public static final String ZRNSEIKATUSYUUNYUUMRTIP  = "zrnseikatusyuunyuumrtip";
    public static final String ZRNSIKTSYUNYUMRTISYUUSEIS = "zrnsiktsyunyumrtisyuuseis";
    public static final String ZRNSIKTSYUNYUMRTITKJYUKBN = "zrnsiktsyunyumrtitkjyukbn";
    public static final String ZRNSIKTSYNYMRTITKJYRYMSHYTN = "zrnsiktsynymrtitkjyrymshytn";
    public static final String ZRNSIKTSYUNYUMRTITKJYUP  = "zrnsiktsyunyumrtitkjyup";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNSIKTSYUKNBYUTKYKSYRIKGU = "zrnsiktsyuknbyutkyksyrikgu";
    public static final String ZRNSIKTSYUKNBYUTKYKKGSDIKBN = "zrnsiktsyuknbyutkykkgsdikbn";
    public static final String ZRNSIKTSYUKNBYUTKYKKGUYBI = "zrnsiktsyuknbyutkykkguybi";
    public static final String ZRNSIKTSYUKNBYUTKYKKGUYBIX2 = "zrnsiktsyuknbyutkykkguybix2";
    public static final String ZRNSIKTSYUKNBYUTKYKKGUYBIX3 = "zrnsiktsyuknbyutkykkguybix3";
    public static final String ZRNSIKTSYUKNBYUTKYKKGUYBIX4 = "zrnsiktsyuknbyutkykkguybix4";
    public static final String ZRNSIKTSYUKNBYUTKYKKGUYBIX5 = "zrnsiktsyuknbyutkykkguybix5";
    public static final String ZRNSIKTSYUKNBYUTKYKKKN   = "zrnsiktsyuknbyutkykkkn";
    public static final String ZRNSIKTSYUKNBYUTKYKPHRKMKKN = "zrnsiktsyuknbyutkykphrkmkkn";
    public static final String ZRNSIKTSYKNBYTYKTNKNWRBKKBN = "zrnsiktsyknbytyktnknwrbkkbn";
    public static final String ZRNSRSIKTSYUKNBYUTKPWRBKKBN = "zrnsrsiktsyuknbyutkpwrbkkbn";
    public static final String ZRNSIKTSYUKNBYUTKYKPWRBKKBN = "zrnsiktsyuknbyutkykpwrbkkbn";
    public static final String ZRNSIKTSYKNBYTKYKKUSNMNRYNN = "zrnsiktsyknbytkykkusnmnrynn";
    public static final String ZRNSIKTSYUKNBYUTKYKS     = "zrnsiktsyuknbyutkyks";
    public static final String ZRNSIKTSYUKNBYUTKYKP     = "zrnsiktsyuknbyutkykp";
    public static final String ZRNSIKTSYUKNBYUTKYKTIKKNARS = "zrnsiktsyuknbyutkyktikknars";
    public static final String ZRNSIKTSYUKNBYUTKYKSYUSIS = "zrnsiktsyuknbyutkyksyusis";
    public static final String ZRNSIKTSYUKNBYUTKJYUKBN  = "zrnsiktsyuknbyutkjyukbn";
    public static final String ZRNSIKTSYUKNBYUTKJYRYMSHYTN = "zrnsiktsyuknbyutkjyrymshytn";
    public static final String ZRNSIKTSYUKNBYUTKJYUP    = "zrnsiktsyuknbyutkjyup";
    public static final String ZRNSIKTSYUKNBYUTKTIBICD  = "zrnsiktsyuknbyutktibicd";
    public static final String ZRNSIKTSYUKNBYUHTNPKKN   = "zrnsiktsyuknbyuhtnpkkn";
    public static final String ZRNSIKTSYUKNBYUTKTIBICDX2 = "zrnsiktsyuknbyutktibicdx2";
    public static final String ZRNSIKTSYUKNBYUHTNPKKNX2 = "zrnsiktsyuknbyuhtnpkknx2";
    public static final String ZRNYOBIV19               = "zrnyobiv19";
    public static final String ZRNHTNKNSIKTSYNYMRTISYRKG = "zrnhtnknsiktsynymrtisyrkg";
    public static final String ZRNHTNKNSIKTSYNYKGUSDIKBN = "zrnhtnknsiktsynykgusdikbn";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYB = "zrnhtnknsiktsynymrtikgyb";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX2 = "zrnhtnknsiktsynymrtikgybx2";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX3 = "zrnhtnknsiktsynymrtikgybx3";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX4 = "zrnhtnknsiktsynymrtikgybx4";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX5 = "zrnhtnknsiktsynymrtikgybx5";
    public static final String ZRNHTNKNSIKTSYKNBYTKSYRKG = "zrnhtnknsiktsyknbytksyrkg";
    public static final String ZRNHTNKNSIKTSYKNBYKGSDKBN = "zrnhtnknsiktsyknbykgsdkbn";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYB = "zrnhtnknsiktsyknbytkkgyb";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX2 = "zrnhtnknsiktsyknbytkkgybx2";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX3 = "zrnhtnknsiktsyknbytkkgybx3";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX4 = "zrnhtnknsiktsyknbytkkgybx4";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX5 = "zrnhtnknsiktsyknbytkkgybx5";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNHTNKNSIKTSYNYMRTISYRKGX2 = "zrnhtnknsiktsynymrtisyrkgx2";
    public static final String ZRNHTNKNSIKTSYNYKGUSDIKBNX2 = "zrnhtnknsiktsynykgusdikbnx2";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX6 = "zrnhtnknsiktsynymrtikgybx6";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX7 = "zrnhtnknsiktsynymrtikgybx7";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX8 = "zrnhtnknsiktsynymrtikgybx8";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX9 = "zrnhtnknsiktsynymrtikgybx9";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX10 = "zrnhtnknsiktsynymrtikgybx10";
    public static final String ZRNHTNKNSIKTSYKNBYTKSYRKGX2 = "zrnhtnknsiktsyknbytksyrkgx2";
    public static final String ZRNHTNKNSIKTSYKNBYKGSDKBNX2 = "zrnhtnknsiktsyknbykgsdkbnx2";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX6 = "zrnhtnknsiktsyknbytkkgybx6";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX7 = "zrnhtnknsiktsyknbytkkgybx7";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX8 = "zrnhtnknsiktsyknbytkkgybx8";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX9 = "zrnhtnknsiktsyknbytkkgybx9";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX10 = "zrnhtnknsiktsyknbytkkgybx10";
    public static final String ZRNYOBIV24X2             = "zrnyobiv24x2";
    public static final String ZRNHTNKNSIKTSYNYMRTISYRKGX3 = "zrnhtnknsiktsynymrtisyrkgx3";
    public static final String ZRNHTNKNSIKTSYNYKGUSDIKBNX3 = "zrnhtnknsiktsynykgusdikbnx3";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX11 = "zrnhtnknsiktsynymrtikgybx11";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX12 = "zrnhtnknsiktsynymrtikgybx12";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX13 = "zrnhtnknsiktsynymrtikgybx13";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX14 = "zrnhtnknsiktsynymrtikgybx14";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX15 = "zrnhtnknsiktsynymrtikgybx15";
    public static final String ZRNHTNKNSIKTSYKNBYTKSYRKGX3 = "zrnhtnknsiktsyknbytksyrkgx3";
    public static final String ZRNHTNKNSIKTSYKNBYKGSDKBNX3 = "zrnhtnknsiktsyknbykgsdkbnx3";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX11 = "zrnhtnknsiktsyknbytkkgybx11";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX12 = "zrnhtnknsiktsyknbytkkgybx12";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX13 = "zrnhtnknsiktsyknbytkkgybx13";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX14 = "zrnhtnknsiktsyknbytkkgybx14";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX15 = "zrnhtnknsiktsyknbytkkgybx15";
    public static final String ZRNYOBIV24X3             = "zrnyobiv24x3";
    public static final String ZRNHTNKNSIKTSYNYMRTISYRKGX4 = "zrnhtnknsiktsynymrtisyrkgx4";
    public static final String ZRNHTNKNSIKTSYNYKGUSDIKBNX4 = "zrnhtnknsiktsynykgusdikbnx4";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX16 = "zrnhtnknsiktsynymrtikgybx16";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX17 = "zrnhtnknsiktsynymrtikgybx17";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX18 = "zrnhtnknsiktsynymrtikgybx18";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX19 = "zrnhtnknsiktsynymrtikgybx19";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX20 = "zrnhtnknsiktsynymrtikgybx20";
    public static final String ZRNHTNKNSIKTSYKNBYTKSYRKGX4 = "zrnhtnknsiktsyknbytksyrkgx4";
    public static final String ZRNHTNKNSIKTSYKNBYKGSDKBNX4 = "zrnhtnknsiktsyknbykgsdkbnx4";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX16 = "zrnhtnknsiktsyknbytkkgybx16";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX17 = "zrnhtnknsiktsyknbytkkgybx17";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX18 = "zrnhtnknsiktsyknbytkkgybx18";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX19 = "zrnhtnknsiktsyknbytkkgybx19";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX20 = "zrnhtnknsiktsyknbytkkgybx20";
    public static final String ZRNYOBIV24X4             = "zrnyobiv24x4";
    public static final String ZRNHTNKNSIKTSYNYMRTISYRKGX5 = "zrnhtnknsiktsynymrtisyrkgx5";
    public static final String ZRNHTNKNSIKTSYNYKGUSDIKBNX5 = "zrnhtnknsiktsynykgusdikbnx5";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX21 = "zrnhtnknsiktsynymrtikgybx21";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX22 = "zrnhtnknsiktsynymrtikgybx22";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX23 = "zrnhtnknsiktsynymrtikgybx23";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX24 = "zrnhtnknsiktsynymrtikgybx24";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX25 = "zrnhtnknsiktsynymrtikgybx25";
    public static final String ZRNHTNKNSIKTSYKNBYTKSYRKGX5 = "zrnhtnknsiktsyknbytksyrkgx5";
    public static final String ZRNHTNKNSIKTSYKNBYKGSDKBNX5 = "zrnhtnknsiktsyknbykgsdkbnx5";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX21 = "zrnhtnknsiktsyknbytkkgybx21";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX22 = "zrnhtnknsiktsyknbytkkgybx22";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX23 = "zrnhtnknsiktsyknbytkkgybx23";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX24 = "zrnhtnknsiktsyknbytkkgybx24";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX25 = "zrnhtnknsiktsyknbytkkgybx25";
    public static final String ZRNYOBIV24X5             = "zrnyobiv24x5";
    public static final String ZRNHTNKNSIKTSYNYMRTISYRKGX6 = "zrnhtnknsiktsynymrtisyrkgx6";
    public static final String ZRNHTNKNSIKTSYNYKGUSDIKBNX6 = "zrnhtnknsiktsynykgusdikbnx6";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX26 = "zrnhtnknsiktsynymrtikgybx26";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX27 = "zrnhtnknsiktsynymrtikgybx27";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX28 = "zrnhtnknsiktsynymrtikgybx28";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX29 = "zrnhtnknsiktsynymrtikgybx29";
    public static final String ZRNHTNKNSIKTSYNYMRTIKGYBX30 = "zrnhtnknsiktsynymrtikgybx30";
    public static final String ZRNHTNKNSIKTSYKNBYTKSYRKGX6 = "zrnhtnknsiktsyknbytksyrkgx6";
    public static final String ZRNHTNKNSIKTSYKNBYKGSDKBNX6 = "zrnhtnknsiktsyknbykgsdkbnx6";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX26 = "zrnhtnknsiktsyknbytkkgybx26";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX27 = "zrnhtnknsiktsyknbytkkgybx27";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX28 = "zrnhtnknsiktsyknbytkkgybx28";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX29 = "zrnhtnknsiktsyknbytkkgybx29";
    public static final String ZRNHTNKNSIKTSYKNBYTKKGYBX30 = "zrnhtnknsiktsyknbytkkgybx30";
    public static final String ZRNYOBIV24X6             = "zrnyobiv24x6";
    public static final String ZRNKAIYAKUHRMKHRITU      = "zrnkaiyakuhrmkhritu";
    public static final String ZRNTUMITATEKINITENMKHYURT = "zrntumitatekinitenmkhyurt";
    public static final String ZRNYOBIV250              = "zrnyobiv250";
    public static final String ZRNYOBIV248              = "zrnyobiv248";

    private final PKZT_Sp2RnduyuSouseiritu5Rn primaryKey;

    public GenZT_Sp2RnduyuSouseiritu5Rn() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu5Rn();
    }

    public GenZT_Sp2RnduyuSouseiritu5Rn(String pZrnktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu5Rn(pZrnktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu5Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu5Rn> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu5Rn.class;
    }

    private String zrnktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKTGYSYRYMD)
    public String getZrnktgysyrymd() {
        return zrnktgysyrymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnktgysyrymd(String pZrnktgysyrymd) {
        zrnktgysyrymd = pZrnktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKTGYSYONO)
    public String getZrnktgysyono() {
        return getPrimaryKey().getZrnktgysyono();
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnktgysyono(String pZrnktgysyono) {
        getPrimaryKey().setZrnktgysyono(pZrnktgysyono);
    }

    private String zrnktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKTGYFILERENNO)
    public String getZrnktgyfilerenno() {
        return zrnktgyfilerenno;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnktgyfilerenno(String pZrnktgyfilerenno) {
        zrnktgyfilerenno = pZrnktgyfilerenno;
    }

    private String zrnaatukaisyabosyuudirtncd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNAATUKAISYABOSYUUDIRTNCD)
    public String getZrnaatukaisyabosyuudirtncd() {
        return zrnaatukaisyabosyuudirtncd;
    }

    public void setZrnaatukaisyabosyuudirtncd(String pZrnaatukaisyabosyuudirtncd) {
        zrnaatukaisyabosyuudirtncd = pZrnaatukaisyabosyuudirtncd;
    }

    private String zrnbatukaisyabosyuudirtncd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNBATUKAISYABOSYUUDIRTNCD)
    public String getZrnbatukaisyabosyuudirtncd() {
        return zrnbatukaisyabosyuudirtncd;
    }

    public void setZrnbatukaisyabosyuudirtncd(String pZrnbatukaisyabosyuudirtncd) {
        zrnbatukaisyabosyuudirtncd = pZrnbatukaisyabosyuudirtncd;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnkessankeijyouym;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKESSANKEIJYOUYM)
    public String getZrnkessankeijyouym() {
        return zrnkessankeijyouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnkessankeijyouym(String pZrnkessankeijyouym) {
        zrnkessankeijyouym = pZrnkessankeijyouym;
    }

    private String zrnhtnkntmttsyusnhknarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNTMTTSYUSNHKNARIHYJ)
    public String getZrnhtnkntmttsyusnhknarihyj() {
        return zrnhtnkntmttsyusnhknarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnkntmttsyusnhknarihyj(String pZrnhtnkntmttsyusnhknarihyj) {
        zrnhtnkntmttsyusnhknarihyj = pZrnhtnkntmttsyusnhknarihyj;
    }

    private String zrntokubetuhosyoukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNTOKUBETUHOSYOUKIKAN)
    public String getZrntokubetuhosyoukikan() {
        return zrntokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokubetuhosyoukikan(String pZrntokubetuhosyoukikan) {
        zrntokubetuhosyoukikan = pZrntokubetuhosyoukikan;
    }

    private Long zrngoukeinenbaraikansanp3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEINENBARAIKANSANP3X1)
    public Long getZrngoukeinenbaraikansanp3x1() {
        return zrngoukeinenbaraikansanp3x1;
    }

    public void setZrngoukeinenbaraikansanp3x1(Long pZrngoukeinenbaraikansanp3x1) {
        zrngoukeinenbaraikansanp3x1 = pZrngoukeinenbaraikansanp3x1;
    }

    private String zrnhktgtikkikkkn3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHKTGTIKKIKKKN3X1)
    public String getZrnhktgtikkikkkn3x1() {
        return zrnhktgtikkikkkn3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x1(String pZrnhktgtikkikkkn3x1) {
        zrnhktgtikkikkkn3x1 = pZrnhktgtikkikkkn3x1;
    }

    private Long zrnkappadhktgkujygkx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAPPADHKTGKUJYGKX1)
    public Long getZrnkappadhktgkujygkx1() {
        return zrnkappadhktgkujygkx1;
    }

    public void setZrnkappadhktgkujygkx1(Long pZrnkappadhktgkujygkx1) {
        zrnkappadhktgkujygkx1 = pZrnkappadhktgkujygkx1;
    }

    private Long zrngoukeinenbaraikansanp3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEINENBARAIKANSANP3X2)
    public Long getZrngoukeinenbaraikansanp3x2() {
        return zrngoukeinenbaraikansanp3x2;
    }

    public void setZrngoukeinenbaraikansanp3x2(Long pZrngoukeinenbaraikansanp3x2) {
        zrngoukeinenbaraikansanp3x2 = pZrngoukeinenbaraikansanp3x2;
    }

    private String zrnhktgtikkikkkn3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHKTGTIKKIKKKN3X2)
    public String getZrnhktgtikkikkkn3x2() {
        return zrnhktgtikkikkkn3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x2(String pZrnhktgtikkikkkn3x2) {
        zrnhktgtikkikkkn3x2 = pZrnhktgtikkikkkn3x2;
    }

    private Long zrnkappadhktgkujygkx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAPPADHKTGKUJYGKX2)
    public Long getZrnkappadhktgkujygkx2() {
        return zrnkappadhktgkujygkx2;
    }

    public void setZrnkappadhktgkujygkx2(Long pZrnkappadhktgkujygkx2) {
        zrnkappadhktgkujygkx2 = pZrnkappadhktgkujygkx2;
    }

    private Long zrngoukeinenbaraikansanp3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEINENBARAIKANSANP3X3)
    public Long getZrngoukeinenbaraikansanp3x3() {
        return zrngoukeinenbaraikansanp3x3;
    }

    public void setZrngoukeinenbaraikansanp3x3(Long pZrngoukeinenbaraikansanp3x3) {
        zrngoukeinenbaraikansanp3x3 = pZrngoukeinenbaraikansanp3x3;
    }

    private String zrnhktgtikkikkkn3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHKTGTIKKIKKKN3X3)
    public String getZrnhktgtikkikkkn3x3() {
        return zrnhktgtikkikkkn3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x3(String pZrnhktgtikkikkkn3x3) {
        zrnhktgtikkikkkn3x3 = pZrnhktgtikkikkkn3x3;
    }

    private Long zrnkappadhktgkujygkx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAPPADHKTGKUJYGKX3)
    public Long getZrnkappadhktgkujygkx3() {
        return zrnkappadhktgkujygkx3;
    }

    public void setZrnkappadhktgkujygkx3(Long pZrnkappadhktgkujygkx3) {
        zrnkappadhktgkujygkx3 = pZrnkappadhktgkujygkx3;
    }

    private Long zrngoukeinenbaraikansanp3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEINENBARAIKANSANP3X4)
    public Long getZrngoukeinenbaraikansanp3x4() {
        return zrngoukeinenbaraikansanp3x4;
    }

    public void setZrngoukeinenbaraikansanp3x4(Long pZrngoukeinenbaraikansanp3x4) {
        zrngoukeinenbaraikansanp3x4 = pZrngoukeinenbaraikansanp3x4;
    }

    private String zrnhktgtikkikkkn3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHKTGTIKKIKKKN3X4)
    public String getZrnhktgtikkikkkn3x4() {
        return zrnhktgtikkikkkn3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x4(String pZrnhktgtikkikkkn3x4) {
        zrnhktgtikkikkkn3x4 = pZrnhktgtikkikkkn3x4;
    }

    private Long zrnkappadhktgkujygkx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAPPADHKTGKUJYGKX4)
    public Long getZrnkappadhktgkujygkx4() {
        return zrnkappadhktgkujygkx4;
    }

    public void setZrnkappadhktgkujygkx4(Long pZrnkappadhktgkujygkx4) {
        zrnkappadhktgkujygkx4 = pZrnkappadhktgkujygkx4;
    }

    private Long zrngoukeinenbaraikansanp3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEINENBARAIKANSANP3X5)
    public Long getZrngoukeinenbaraikansanp3x5() {
        return zrngoukeinenbaraikansanp3x5;
    }

    public void setZrngoukeinenbaraikansanp3x5(Long pZrngoukeinenbaraikansanp3x5) {
        zrngoukeinenbaraikansanp3x5 = pZrngoukeinenbaraikansanp3x5;
    }

    private String zrnhktgtikkikkkn3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHKTGTIKKIKKKN3X5)
    public String getZrnhktgtikkikkkn3x5() {
        return zrnhktgtikkikkkn3x5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x5(String pZrnhktgtikkikkkn3x5) {
        zrnhktgtikkikkkn3x5 = pZrnhktgtikkikkkn3x5;
    }

    private Long zrnkappadhktgkujygkx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAPPADHKTGKUJYGKX5)
    public Long getZrnkappadhktgkujygkx5() {
        return zrnkappadhktgkujygkx5;
    }

    public void setZrnkappadhktgkujygkx5(Long pZrnkappadhktgkujygkx5) {
        zrnkappadhktgkujygkx5 = pZrnkappadhktgkujygkx5;
    }

    private Long zrngoukeinenbaraikansanp3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEINENBARAIKANSANP3X6)
    public Long getZrngoukeinenbaraikansanp3x6() {
        return zrngoukeinenbaraikansanp3x6;
    }

    public void setZrngoukeinenbaraikansanp3x6(Long pZrngoukeinenbaraikansanp3x6) {
        zrngoukeinenbaraikansanp3x6 = pZrngoukeinenbaraikansanp3x6;
    }

    private String zrnhktgtikkikkkn3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHKTGTIKKIKKKN3X6)
    public String getZrnhktgtikkikkkn3x6() {
        return zrnhktgtikkikkkn3x6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x6(String pZrnhktgtikkikkkn3x6) {
        zrnhktgtikkikkkn3x6 = pZrnhktgtikkikkkn3x6;
    }

    private Long zrnkappadhktgkujygkx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAPPADHKTGKUJYGKX6)
    public Long getZrnkappadhktgkujygkx6() {
        return zrnkappadhktgkujygkx6;
    }

    public void setZrnkappadhktgkujygkx6(Long pZrnkappadhktgkujygkx6) {
        zrnkappadhktgkujygkx6 = pZrnkappadhktgkujygkx6;
    }

    private String zrnhutihnnnkknnzmkyksyono;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHUTIHNNNKKNNZMKYKSYONO)
    public String getZrnhutihnnnkknnzmkyksyono() {
        return zrnhutihnnnkknnzmkyksyono;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhutihnnnkknnzmkyksyono(String pZrnhutihnnnkknnzmkyksyono) {
        zrnhutihnnnkknnzmkyksyono = pZrnhutihnnnkknnzmkyksyono;
    }

    private String zrnmusymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnmosnyuuryokuymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNMOSNYUURYOKUYMD)
    public String getZrnmosnyuuryokuymd() {
        return zrnmosnyuuryokuymd;
    }

    public void setZrnmosnyuuryokuymd(String pZrnmosnyuuryokuymd) {
        zrnmosnyuuryokuymd = pZrnmosnyuuryokuymd;
    }

    private String zrnmossyosakuseiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNMOSSYOSAKUSEIYMD)
    public String getZrnmossyosakuseiymd() {
        return zrnmossyosakuseiymd;
    }

    public void setZrnmossyosakuseiymd(String pZrnmossyosakuseiymd) {
        zrnmossyosakuseiymd = pZrnmossyosakuseiymd;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrndai2kokutiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2KOKUTIYMD)
    public String getZrndai2kokutiymd() {
        return zrndai2kokutiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndai2kokutiymd(String pZrndai2kokutiymd) {
        zrndai2kokutiymd = pZrndai2kokutiymd;
    }

    private String zrnjyuuryousyouryakukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNJYUURYOUSYOURYAKUKBN)
    public String getZrnjyuuryousyouryakukbn() {
        return zrnjyuuryousyouryakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuuryousyouryakukbn(String pZrnjyuuryousyouryakukbn) {
        zrnjyuuryousyouryakukbn = pZrnjyuuryousyouryakukbn;
    }

    private String zrnsnsniryutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKSYURUIKGU)
    public String getZrnsnsniryutkyksyuruikgu() {
        return zrnsnsniryutkyksyuruikgu;
    }

    public void setZrnsnsniryutkyksyuruikgu(String pZrnsnsniryutkyksyuruikgu) {
        zrnsnsniryutkyksyuruikgu = pZrnsnsniryutkyksyuruikgu;
    }

    private String zrnsensiniryoutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSENSINIRYOUTOKUYAKUKIKAN)
    public String getZrnsensiniryoutokuyakukikan() {
        return zrnsensiniryoutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsensiniryoutokuyakukikan(String pZrnsensiniryoutokuyakukikan) {
        zrnsensiniryoutokuyakukikan = pZrnsensiniryoutokuyakukikan;
    }

    private String zrnsensiniryoutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSENSINIRYOUTKYKPHRKKKN)
    public String getZrnsensiniryoutkykphrkkkn() {
        return zrnsensiniryoutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsensiniryoutkykphrkkkn(String pZrnsensiniryoutkykphrkkkn) {
        zrnsensiniryoutkykphrkkkn = pZrnsensiniryoutkykphrkkkn;
    }

    private Long zrnsensiniryoutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSENSINIRYOUTOKUYAKUS)
    public Long getZrnsensiniryoutokuyakus() {
        return zrnsensiniryoutokuyakus;
    }

    public void setZrnsensiniryoutokuyakus(Long pZrnsensiniryoutokuyakus) {
        zrnsensiniryoutokuyakus = pZrnsensiniryoutokuyakus;
    }

    private Long zrnsensiniryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSENSINIRYOUTOKUYAKUP)
    public Long getZrnsensiniryoutokuyakup() {
        return zrnsensiniryoutokuyakup;
    }

    public void setZrnsensiniryoutokuyakup(Long pZrnsensiniryoutokuyakup) {
        zrnsensiniryoutokuyakup = pZrnsensiniryoutokuyakup;
    }

    private String zrnsensiniryoutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSENSINIRYOUTKYKKGUSDKBN)
    public String getZrnsensiniryoutkykkgusdkbn() {
        return zrnsensiniryoutkykkgusdkbn;
    }

    public void setZrnsensiniryoutkykkgusdkbn(String pZrnsensiniryoutkykkgusdkbn) {
        zrnsensiniryoutkykkgusdkbn = pZrnsensiniryoutkykkgusdkbn;
    }

    private String zrnsnsniryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKKGUYBX1)
    public String getZrnsnsniryutkykkguybx1() {
        return zrnsnsniryutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnsniryutkykkguybx1(String pZrnsnsniryutkykkguybx1) {
        zrnsnsniryutkykkguybx1 = pZrnsnsniryutkykkguybx1;
    }

    private String zrnsnsniryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKKGUYBX2)
    public String getZrnsnsniryutkykkguybx2() {
        return zrnsnsniryutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnsniryutkykkguybx2(String pZrnsnsniryutkykkguybx2) {
        zrnsnsniryutkykkguybx2 = pZrnsnsniryutkykkguybx2;
    }

    private String zrnsnsniryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKKGUYBX3)
    public String getZrnsnsniryutkykkguybx3() {
        return zrnsnsniryutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnsniryutkykkguybx3(String pZrnsnsniryutkykkguybx3) {
        zrnsnsniryutkykkguybx3 = pZrnsnsniryutkykkguybx3;
    }

    private String zrnsnsniryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKKGUYBX4)
    public String getZrnsnsniryutkykkguybx4() {
        return zrnsnsniryutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnsniryutkykkguybx4(String pZrnsnsniryutkykkguybx4) {
        zrnsnsniryutkykkguybx4 = pZrnsnsniryutkykkguybx4;
    }

    private String zrnsnsniryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKKGUYBX5)
    public String getZrnsnsniryutkykkguybx5() {
        return zrnsnsniryutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnsniryutkykkguybx5(String pZrnsnsniryutkykkguybx5) {
        zrnsnsniryutkykkguybx5 = pZrnsnsniryutkykkguybx5;
    }

    private String zrnsnsniryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKPWRBKKBN)
    public String getZrnsnsniryutkykpwrbkkbn() {
        return zrnsnsniryutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnsniryutkykpwrbkkbn(String pZrnsnsniryutkykpwrbkkbn) {
        zrnsnsniryutkykpwrbkkbn = pZrnsnsniryutkykpwrbkkbn;
    }

    private String zrnsnsniryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKTBICDX1)
    public String getZrnsnsniryutktbicdx1() {
        return zrnsnsniryutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnsniryutktbicdx1(String pZrnsnsniryutktbicdx1) {
        zrnsnsniryutktbicdx1 = pZrnsnsniryutktbicdx1;
    }

    private String zrnsnsniryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUHTNPKKNX1)
    public String getZrnsnsniryuhtnpkknx1() {
        return zrnsnsniryuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnsniryuhtnpkknx1(String pZrnsnsniryuhtnpkknx1) {
        zrnsnsniryuhtnpkknx1 = pZrnsnsniryuhtnpkknx1;
    }

    private String zrnsnsniryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKTBICDX2)
    public String getZrnsnsniryutktbicdx2() {
        return zrnsnsniryutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnsniryutktbicdx2(String pZrnsnsniryutktbicdx2) {
        zrnsnsniryutktbicdx2 = pZrnsnsniryutktbicdx2;
    }

    private String zrnsnsniryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUHTNPKKNX2)
    public String getZrnsnsniryuhtnpkknx2() {
        return zrnsnsniryuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnsniryuhtnpkknx2(String pZrnsnsniryuhtnpkknx2) {
        zrnsnsniryuhtnpkknx2 = pZrnsnsniryuhtnpkknx2;
    }

    private String zrnsnsniryutkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSNSNIRYUTKYKKUSNMNRYOAGE)
    public String getZrnsnsniryutkykkusnmnryoage() {
        return zrnsnsniryutkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnsniryutkykkusnmnryoage(String pZrnsnsniryutkykkusnmnryoage) {
        zrnsnsniryutkykkusnmnryoage = pZrnsnsniryutkykkusnmnryoage;
    }

    private String zrnyobiv4x17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV4X17)
    public String getZrnyobiv4x17() {
        return zrnyobiv4x17;
    }

    public void setZrnyobiv4x17(String pZrnyobiv4x17) {
        zrnyobiv4x17 = pZrnyobiv4x17;
    }

    private String zrndi2snsniryutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKSYRIKGU)
    public String getZrndi2snsniryutkyksyrikgu() {
        return zrndi2snsniryutkyksyrikgu;
    }

    public void setZrndi2snsniryutkyksyrikgu(String pZrndi2snsniryutkyksyrikgu) {
        zrndi2snsniryutkyksyrikgu = pZrndi2snsniryutkyksyrikgu;
    }

    private String zrndi2snsniryutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKKN)
    public String getZrndi2snsniryutkykkkn() {
        return zrndi2snsniryutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2snsniryutkykkkn(String pZrndi2snsniryutkykkkn) {
        zrndi2snsniryutkykkkn = pZrndi2snsniryutkykkkn;
    }

    private String zrndai2snsniryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2SNSNIRYUTKYKPHRKKKN)
    public String getZrndai2snsniryutkykphrkkkn() {
        return zrndai2snsniryutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2snsniryutkykphrkkkn(String pZrndai2snsniryutkykphrkkkn) {
        zrndai2snsniryutkykphrkkkn = pZrndai2snsniryutkykphrkkkn;
    }

    private Long zrndai2sensiniryoutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2SENSINIRYOUTOKUYAKUS)
    public Long getZrndai2sensiniryoutokuyakus() {
        return zrndai2sensiniryoutokuyakus;
    }

    public void setZrndai2sensiniryoutokuyakus(Long pZrndai2sensiniryoutokuyakus) {
        zrndai2sensiniryoutokuyakus = pZrndai2sensiniryoutokuyakus;
    }

    private Long zrndai2sensiniryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2SENSINIRYOUTOKUYAKUP)
    public Long getZrndai2sensiniryoutokuyakup() {
        return zrndai2sensiniryoutokuyakup;
    }

    public void setZrndai2sensiniryoutokuyakup(Long pZrndai2sensiniryoutokuyakup) {
        zrndai2sensiniryoutokuyakup = pZrndai2sensiniryoutokuyakup;
    }

    private String zrndi2snsniryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKGUSDKBN)
    public String getZrndi2snsniryutkykkgusdkbn() {
        return zrndi2snsniryutkykkgusdkbn;
    }

    public void setZrndi2snsniryutkykkgusdkbn(String pZrndi2snsniryutkykkgusdkbn) {
        zrndi2snsniryutkykkgusdkbn = pZrndi2snsniryutkykkgusdkbn;
    }

    private String zrndi2snsniryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKGUYBX1)
    public String getZrndi2snsniryutkykkguybx1() {
        return zrndi2snsniryutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2snsniryutkykkguybx1(String pZrndi2snsniryutkykkguybx1) {
        zrndi2snsniryutkykkguybx1 = pZrndi2snsniryutkykkguybx1;
    }

    private String zrndi2snsniryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKGUYBX2)
    public String getZrndi2snsniryutkykkguybx2() {
        return zrndi2snsniryutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2snsniryutkykkguybx2(String pZrndi2snsniryutkykkguybx2) {
        zrndi2snsniryutkykkguybx2 = pZrndi2snsniryutkykkguybx2;
    }

    private String zrndi2snsniryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKGUYBX3)
    public String getZrndi2snsniryutkykkguybx3() {
        return zrndi2snsniryutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2snsniryutkykkguybx3(String pZrndi2snsniryutkykkguybx3) {
        zrndi2snsniryutkykkguybx3 = pZrndi2snsniryutkykkguybx3;
    }

    private String zrndi2snsniryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKGUYBX4)
    public String getZrndi2snsniryutkykkguybx4() {
        return zrndi2snsniryutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2snsniryutkykkguybx4(String pZrndi2snsniryutkykkguybx4) {
        zrndi2snsniryutkykkguybx4 = pZrndi2snsniryutkykkguybx4;
    }

    private String zrndi2snsniryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKKGUYBX5)
    public String getZrndi2snsniryutkykkguybx5() {
        return zrndi2snsniryutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2snsniryutkykkguybx5(String pZrndi2snsniryutkykkguybx5) {
        zrndi2snsniryutkykkguybx5 = pZrndi2snsniryutkykkguybx5;
    }

    private String zrndi2snsniryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKYKPWRBKKBN)
    public String getZrndi2snsniryutkykpwrbkkbn() {
        return zrndi2snsniryutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2snsniryutkykpwrbkkbn(String pZrndi2snsniryutkykpwrbkkbn) {
        zrndi2snsniryutkykpwrbkkbn = pZrndi2snsniryutkykpwrbkkbn;
    }

    private String zrndi2snsniryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKTBICDX1)
    public String getZrndi2snsniryutktbicdx1() {
        return zrndi2snsniryutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2snsniryutktbicdx1(String pZrndi2snsniryutktbicdx1) {
        zrndi2snsniryutktbicdx1 = pZrndi2snsniryutktbicdx1;
    }

    private String zrndi2snsniryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUHTNPKKNX1)
    public String getZrndi2snsniryuhtnpkknx1() {
        return zrndi2snsniryuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2snsniryuhtnpkknx1(String pZrndi2snsniryuhtnpkknx1) {
        zrndi2snsniryuhtnpkknx1 = pZrndi2snsniryuhtnpkknx1;
    }

    private String zrndi2snsniryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUTKTBICDX2)
    public String getZrndi2snsniryutktbicdx2() {
        return zrndi2snsniryutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2snsniryutktbicdx2(String pZrndi2snsniryutktbicdx2) {
        zrndi2snsniryutktbicdx2 = pZrndi2snsniryutktbicdx2;
    }

    private String zrndi2snsniryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SNSNIRYUHTNPKKNX2)
    public String getZrndi2snsniryuhtnpkknx2() {
        return zrndi2snsniryuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2snsniryuhtnpkknx2(String pZrndi2snsniryuhtnpkknx2) {
        zrndi2snsniryuhtnpkknx2 = pZrndi2snsniryuhtnpkknx2;
    }

    private String zrnyobiv6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV6X3)
    public String getZrnyobiv6x3() {
        return zrnyobiv6x3;
    }

    public void setZrnyobiv6x3(String pZrnyobiv6x3) {
        zrnyobiv6x3 = pZrnyobiv6x3;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrnkyksyaagetyouseihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKYKSYAAGETYOUSEIHYJ)
    public String getZrnkyksyaagetyouseihyj() {
        return zrnkyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyksyaagetyouseihyj(String pZrnkyksyaagetyouseihyj) {
        zrnkyksyaagetyouseihyj = pZrnkyksyaagetyouseihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private Long zrnhsyumnosjdftmttzndk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHSYUMNOSJDFTMTTZNDK)
    public Long getZrnhsyumnosjdftmttzndk() {
        return zrnhsyumnosjdftmttzndk;
    }

    public void setZrnhsyumnosjdftmttzndk(Long pZrnhsyumnosjdftmttzndk) {
        zrnhsyumnosjdftmttzndk = pZrnhsyumnosjdftmttzndk;
    }

    private String zrnnyuinhsyujyjttkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYJTTKYKSYRIKGU)
    public String getZrnnyuinhsyujyjttkyksyrikgu() {
        return zrnnyuinhsyujyjttkyksyrikgu;
    }

    public void setZrnnyuinhsyujyjttkyksyrikgu(String pZrnnyuinhsyujyjttkyksyrikgu) {
        zrnnyuinhsyujyjttkyksyrikgu = pZrnnyuinhsyujyjttkyksyrikgu;
    }

    private String zrnnyuinhsyujyujttkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTTKYKKKN)
    public String getZrnnyuinhsyujyujttkykkkn() {
        return zrnnyuinhsyujyujttkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyuinhsyujyujttkykkkn(String pZrnnyuinhsyujyujttkykkkn) {
        zrnnyuinhsyujyujttkykkkn = pZrnnyuinhsyujyujttkykkkn;
    }

    private String zrnnyinhsyjyjttkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYINHSYJYJTTKYKPHRKKKN)
    public String getZrnnyinhsyjyjttkykphrkkkn() {
        return zrnnyinhsyjyjttkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyinhsyjyjttkykphrkkkn(String pZrnnyinhsyjyjttkykphrkkkn) {
        zrnnyinhsyjyjttkykphrkkkn = pZrnnyinhsyjyjttkykphrkkkn;
    }

    private Long zrnnyuinhsyujyujttkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTTKYKS)
    public Long getZrnnyuinhsyujyujttkyks() {
        return zrnnyuinhsyujyujttkyks;
    }

    public void setZrnnyuinhsyujyujttkyks(Long pZrnnyuinhsyujyujttkyks) {
        zrnnyuinhsyujyujttkyks = pZrnnyuinhsyujyujttkyks;
    }

    private Long zrnnyuinhsyujyujttkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTTKYKP)
    public Long getZrnnyuinhsyujyujttkykp() {
        return zrnnyuinhsyujyujttkykp;
    }

    public void setZrnnyuinhsyujyujttkykp(Long pZrnnyuinhsyujyujttkykp) {
        zrnnyuinhsyujyujttkykp = pZrnnyuinhsyujyujttkykp;
    }

    private Integer zrnnyinhsyjyjttkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYINHSYJYJTTKJYRYMSHYTN)
    public Integer getZrnnyinhsyjyjttkjyrymshytn() {
        return zrnnyinhsyjyjttkjyrymshytn;
    }

    public void setZrnnyinhsyjyjttkjyrymshytn(Integer pZrnnyinhsyjyjttkjyrymshytn) {
        zrnnyinhsyjyjttkjyrymshytn = pZrnnyinhsyjyjttkjyrymshytn;
    }

    private Long zrnnyuinhsyujyujttkyktkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTTKYKTKJYUP)
    public Long getZrnnyuinhsyujyujttkyktkjyup() {
        return zrnnyuinhsyujyujttkyktkjyup;
    }

    public void setZrnnyuinhsyujyujttkyktkjyup(Long pZrnnyuinhsyujyujttkyktkjyup) {
        zrnnyuinhsyujyujttkyktkjyup = pZrnnyuinhsyujyujttkyktkjyup;
    }

    private String zrnnyuinhsyujyujttktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTTKTBICDX1)
    public String getZrnnyuinhsyujyujttktbicdx1() {
        return zrnnyuinhsyujyujttktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyuinhsyujyujttktbicdx1(String pZrnnyuinhsyujyujttktbicdx1) {
        zrnnyuinhsyujyujttktbicdx1 = pZrnnyuinhsyujyujttktbicdx1;
    }

    private String zrnnyuinhsyujyujthtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTHTNPKKNX1)
    public String getZrnnyuinhsyujyujthtnpkknx1() {
        return zrnnyuinhsyujyujthtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyuinhsyujyujthtnpkknx1(String pZrnnyuinhsyujyujthtnpkknx1) {
        zrnnyuinhsyujyujthtnpkknx1 = pZrnnyuinhsyujyujthtnpkknx1;
    }

    private String zrnnyuinhsyujyujttktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTTKTBICDX2)
    public String getZrnnyuinhsyujyujttktbicdx2() {
        return zrnnyuinhsyujyujttktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyuinhsyujyujttktbicdx2(String pZrnnyuinhsyujyujttktbicdx2) {
        zrnnyuinhsyujyujttktbicdx2 = pZrnnyuinhsyujyujttktbicdx2;
    }

    private String zrnnyuinhsyujyujthtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYUJTHTNPKKNX2)
    public String getZrnnyuinhsyujyujthtnpkknx2() {
        return zrnnyuinhsyujyujthtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyuinhsyujyujthtnpkknx2(String pZrnnyuinhsyujyujthtnpkknx2) {
        zrnnyuinhsyujyujthtnpkknx2 = pZrnnyuinhsyujyujthtnpkknx2;
    }

    private String zrnnyinhsyjyjttkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYINHSYJYJTTKYKKGUSDKBN)
    public String getZrnnyinhsyjyjttkykkgusdkbn() {
        return zrnnyinhsyjyjttkykkgusdkbn;
    }

    public void setZrnnyinhsyjyjttkykkgusdkbn(String pZrnnyinhsyjyjttkykkgusdkbn) {
        zrnnyinhsyjyjttkykkgusdkbn = pZrnnyinhsyjyjttkykkgusdkbn;
    }

    private String zrnnyinhsyjyjttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYINHSYJYJTTKYKPWRBKKBN)
    public String getZrnnyinhsyjyjttkykpwrbkkbn() {
        return zrnnyinhsyjyjttkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyinhsyjyjttkykpwrbkkbn(String pZrnnyinhsyjyjttkykpwrbkkbn) {
        zrnnyinhsyjyjttkykpwrbkkbn = pZrnnyinhsyjyjttkykpwrbkkbn;
    }

    private String zrnnyuinhsyujyjttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYJTTKYKKGUYBX1)
    public String getZrnnyuinhsyujyjttkykkguybx1() {
        return zrnnyuinhsyujyjttkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuinhsyujyjttkykkguybx1(String pZrnnyuinhsyujyjttkykkguybx1) {
        zrnnyuinhsyujyjttkykkguybx1 = pZrnnyuinhsyujyjttkykkguybx1;
    }

    private String zrnnyuinhsyujyjttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYJTTKYKKGUYBX2)
    public String getZrnnyuinhsyujyjttkykkguybx2() {
        return zrnnyuinhsyujyjttkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuinhsyujyjttkykkguybx2(String pZrnnyuinhsyujyjttkykkguybx2) {
        zrnnyuinhsyujyjttkykkguybx2 = pZrnnyuinhsyujyjttkykkguybx2;
    }

    private String zrnnyuinhsyujyjttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYJTTKYKKGUYBX3)
    public String getZrnnyuinhsyujyjttkykkguybx3() {
        return zrnnyuinhsyujyjttkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuinhsyujyjttkykkguybx3(String pZrnnyuinhsyujyjttkykkguybx3) {
        zrnnyuinhsyujyjttkykkguybx3 = pZrnnyuinhsyujyjttkykkguybx3;
    }

    private String zrnnyuinhsyujyjttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYJTTKYKKGUYBX4)
    public String getZrnnyuinhsyujyjttkykkguybx4() {
        return zrnnyuinhsyujyjttkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuinhsyujyjttkykkguybx4(String pZrnnyuinhsyujyjttkykkguybx4) {
        zrnnyuinhsyujyjttkykkguybx4 = pZrnnyuinhsyujyjttkykkguybx4;
    }

    private String zrnnyuinhsyujyjttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYUINHSYUJYJTTKYKKGUYBX5)
    public String getZrnnyuinhsyujyjttkykkguybx5() {
        return zrnnyuinhsyujyjttkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuinhsyujyjttkykkguybx5(String pZrnnyuinhsyujyjttkykkguybx5) {
        zrnnyuinhsyujyjttkykkguybx5 = pZrnnyuinhsyujyjttkykkguybx5;
    }

    private String zrnnyinhsyjyjtkykksnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNNYINHSYJYJTKYKKSNMNRYAGE)
    public String getZrnnyinhsyjyjtkykksnmnryage() {
        return zrnnyinhsyjyjtkykksnmnryage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnyinhsyjyjtkykksnmnryage(String pZrnnyinhsyjyjtkykksnmnryage) {
        zrnnyinhsyjyjtkykksnmnryage = pZrnnyinhsyjyjtkykksnmnryage;
    }

    private String zrnyobiv5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV5X4)
    public String getZrnyobiv5x4() {
        return zrnyobiv5x4;
    }

    public void setZrnyobiv5x4(String pZrnyobiv5x4) {
        zrnyobiv5x4 = pZrnyobiv5x4;
    }

    private String zrndi2nyinhsyjyjttkyksyrikg;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYJYJTTKYKSYRIKG)
    public String getZrndi2nyinhsyjyjttkyksyrikg() {
        return zrndi2nyinhsyjyjttkyksyrikg;
    }

    public void setZrndi2nyinhsyjyjttkyksyrikg(String pZrndi2nyinhsyjyjttkyksyrikg) {
        zrndi2nyinhsyjyjttkyksyrikg = pZrndi2nyinhsyjyjttkyksyrikg;
    }

    private String zrndi2nyuinhsyujyujttkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUJYUJTTKYKKKN)
    public String getZrndi2nyuinhsyujyujttkykkkn() {
        return zrndi2nyuinhsyujyujttkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyujyujttkykkkn(String pZrndi2nyuinhsyujyujttkykkkn) {
        zrndi2nyuinhsyujyujttkykkkn = pZrndi2nyuinhsyujyujttkykkkn;
    }

    private String zrndi2nyuinhsyujyjtphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUJYJTPHRKKKN)
    public String getZrndi2nyuinhsyujyjtphrkkkn() {
        return zrndi2nyuinhsyujyjtphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyujyjtphrkkkn(String pZrndi2nyuinhsyujyjtphrkkkn) {
        zrndi2nyuinhsyujyjtphrkkkn = pZrndi2nyuinhsyujyjtphrkkkn;
    }

    private Long zrndi2nyuinhsyujyujttkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUJYUJTTKYKS)
    public Long getZrndi2nyuinhsyujyujttkyks() {
        return zrndi2nyuinhsyujyujttkyks;
    }

    public void setZrndi2nyuinhsyujyujttkyks(Long pZrndi2nyuinhsyujyujttkyks) {
        zrndi2nyuinhsyujyujttkyks = pZrndi2nyuinhsyujyujttkyks;
    }

    private Long zrndi2nyuinhsyujyujttkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUJYUJTTKYKP)
    public Long getZrndi2nyuinhsyujyujttkykp() {
        return zrndi2nyuinhsyujyujttkykp;
    }

    public void setZrndi2nyuinhsyujyujttkykp(Long pZrndi2nyuinhsyujyujttkykp) {
        zrndi2nyuinhsyujyujttkykp = pZrndi2nyuinhsyujyujttkykp;
    }

    private Integer zrndi2nyhsyjyjttkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYHSYJYJTTKJYRYMSHYTN)
    public Integer getZrndi2nyhsyjyjttkjyrymshytn() {
        return zrndi2nyhsyjyjttkjyrymshytn;
    }

    public void setZrndi2nyhsyjyjttkjyrymshytn(Integer pZrndi2nyhsyjyjttkjyrymshytn) {
        zrndi2nyhsyjyjttkjyrymshytn = pZrndi2nyhsyjyjttkjyrymshytn;
    }

    private Long zrndi2nyuinhsyujyujttkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUJYUJTTKJYUP)
    public Long getZrndi2nyuinhsyujyujttkjyup() {
        return zrndi2nyuinhsyujyujttkjyup;
    }

    public void setZrndi2nyuinhsyujyujttkjyup(Long pZrndi2nyuinhsyujyujttkjyup) {
        zrndi2nyuinhsyujyujttkjyup = pZrndi2nyuinhsyujyujttkjyup;
    }

    private String zrndi2nyuinhsyutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUTKTBICDX1)
    public String getZrndi2nyuinhsyutktbicdx1() {
        return zrndi2nyuinhsyutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyutktbicdx1(String pZrndi2nyuinhsyutktbicdx1) {
        zrndi2nyuinhsyutktbicdx1 = pZrndi2nyuinhsyutktbicdx1;
    }

    private String zrndi2nyuinhsyuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUHTNPKKNX1)
    public String getZrndi2nyuinhsyuhtnpkknx1() {
        return zrndi2nyuinhsyuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyuhtnpkknx1(String pZrndi2nyuinhsyuhtnpkknx1) {
        zrndi2nyuinhsyuhtnpkknx1 = pZrndi2nyuinhsyuhtnpkknx1;
    }

    private String zrndi2nyuinhsyutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUTKTBICDX2)
    public String getZrndi2nyuinhsyutktbicdx2() {
        return zrndi2nyuinhsyutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyutktbicdx2(String pZrndi2nyuinhsyutktbicdx2) {
        zrndi2nyuinhsyutktbicdx2 = pZrndi2nyuinhsyutktbicdx2;
    }

    private String zrndi2nyuinhsyuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUHTNPKKNX2)
    public String getZrndi2nyuinhsyuhtnpkknx2() {
        return zrndi2nyuinhsyuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyuhtnpkknx2(String pZrndi2nyuinhsyuhtnpkknx2) {
        zrndi2nyuinhsyuhtnpkknx2 = pZrndi2nyuinhsyuhtnpkknx2;
    }

    private String zrndi2nyinhsyujyjtkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYUJYJTKGUSDKBN)
    public String getZrndi2nyinhsyujyjtkgusdkbn() {
        return zrndi2nyinhsyujyjtkgusdkbn;
    }

    public void setZrndi2nyinhsyujyjtkgusdkbn(String pZrndi2nyinhsyujyjtkgusdkbn) {
        zrndi2nyinhsyujyjtkgusdkbn = pZrndi2nyinhsyujyjtkgusdkbn;
    }

    private String zrndi2nyuinhsyujyjtpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYUINHSYUJYJTPWRBKKBN)
    public String getZrndi2nyuinhsyujyjtpwrbkkbn() {
        return zrndi2nyuinhsyujyjtpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2nyuinhsyujyjtpwrbkkbn(String pZrndi2nyuinhsyujyjtpwrbkkbn) {
        zrndi2nyuinhsyujyjtpwrbkkbn = pZrndi2nyuinhsyujyjtpwrbkkbn;
    }

    private String zrndi2nyinhsyjyjttkykkgybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYJYJTTKYKKGYBX1)
    public String getZrndi2nyinhsyjyjttkykkgybx1() {
        return zrndi2nyinhsyjyjttkykkgybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2nyinhsyjyjttkykkgybx1(String pZrndi2nyinhsyjyjttkykkgybx1) {
        zrndi2nyinhsyjyjttkykkgybx1 = pZrndi2nyinhsyjyjttkykkgybx1;
    }

    private String zrndi2nyinhsyjyjttkykkgybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYJYJTTKYKKGYBX2)
    public String getZrndi2nyinhsyjyjttkykkgybx2() {
        return zrndi2nyinhsyjyjttkykkgybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2nyinhsyjyjttkykkgybx2(String pZrndi2nyinhsyjyjttkykkgybx2) {
        zrndi2nyinhsyjyjttkykkgybx2 = pZrndi2nyinhsyjyjttkykkgybx2;
    }

    private String zrndi2nyinhsyjyjttkykkgybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYJYJTTKYKKGYBX3)
    public String getZrndi2nyinhsyjyjttkykkgybx3() {
        return zrndi2nyinhsyjyjttkykkgybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2nyinhsyjyjttkykkgybx3(String pZrndi2nyinhsyjyjttkykkgybx3) {
        zrndi2nyinhsyjyjttkykkgybx3 = pZrndi2nyinhsyjyjttkykkgybx3;
    }

    private String zrndi2nyinhsyjyjttkykkgybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYJYJTTKYKKGYBX4)
    public String getZrndi2nyinhsyjyjttkykkgybx4() {
        return zrndi2nyinhsyjyjttkykkgybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2nyinhsyjyjttkykkgybx4(String pZrndi2nyinhsyjyjttkykkgybx4) {
        zrndi2nyinhsyjyjttkykkgybx4 = pZrndi2nyinhsyjyjttkykkgybx4;
    }

    private String zrndi2nyinhsyjyjttkykkgybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2NYINHSYJYJTTKYKKGYBX5)
    public String getZrndi2nyinhsyjyjttkykkgybx5() {
        return zrndi2nyinhsyjyjttkykkgybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2nyinhsyjyjttkykkgybx5(String pZrndi2nyinhsyjyjttkykkgybx5) {
        zrndi2nyinhsyjyjttkykkgybx5 = pZrndi2nyinhsyjyjttkykkgybx5;
    }

    private String zrnyobiv7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV7X6)
    public String getZrnyobiv7x6() {
        return zrnyobiv7x6;
    }

    public void setZrnyobiv7x6(String pZrnyobiv7x6) {
        zrnyobiv7x6 = pZrnyobiv7x6;
    }

    private String zrnyobiv1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV1X4)
    public String getZrnyobiv1x4() {
        return zrnyobiv1x4;
    }

    public void setZrnyobiv1x4(String pZrnyobiv1x4) {
        zrnyobiv1x4 = pZrnyobiv1x4;
    }

    private String zrnwnasitnknkakakujyutukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNWNASITNKNKAKAKUJYUTUKBN)
    public String getZrnwnasitnknkakakujyutukbn() {
        return zrnwnasitnknkakakujyutukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnwnasitnknkakakujyutukbn(String pZrnwnasitnknkakakujyutukbn) {
        zrnwnasitnknkakakujyutukbn = pZrnwnasitnknkakakujyutukbn;
    }

    private Long zrngoukeiwnasitenkankakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGOUKEIWNASITENKANKAKAKU)
    public Long getZrngoukeiwnasitenkankakaku() {
        return zrngoukeiwnasitenkankakaku;
    }

    public void setZrngoukeiwnasitenkankakaku(Long pZrngoukeiwnasitenkankakaku) {
        zrngoukeiwnasitenkankakaku = pZrngoukeiwnasitenkankakaku;
    }

    private Long zrngukiwnstnknitjbrnknengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGUKIWNSTNKNITJBRNKNENGK)
    public Long getZrngukiwnstnknitjbrnknengk() {
        return zrngukiwnstnknitjbrnknengk;
    }

    public void setZrngukiwnstnknitjbrnknengk(Long pZrngukiwnstnknitjbrnknengk) {
        zrngukiwnstnknitjbrnknengk = pZrngukiwnstnknitjbrnknengk;
    }

    private Long zrngukiwnasitnknitjbrtiks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGUKIWNASITNKNITJBRTIKS)
    public Long getZrngukiwnasitnknitjbrtiks() {
        return zrngukiwnasitnknitjbrtiks;
    }

    public void setZrngukiwnasitnknitjbrtiks(Long pZrngukiwnasitnknitjbrtiks) {
        zrngukiwnasitnknitjbrtiks = pZrngukiwnasitnknitjbrtiks;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private String zrnyobiv9x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV9X11)
    public String getZrnyobiv9x11() {
        return zrnyobiv9x11;
    }

    public void setZrnyobiv9x11(String pZrnyobiv9x11) {
        zrnyobiv9x11 = pZrnyobiv9x11;
    }

    private String zrnsuguiryutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKSYURUIKGU)
    public String getZrnsuguiryutkyksyuruikgu() {
        return zrnsuguiryutkyksyuruikgu;
    }

    public void setZrnsuguiryutkyksyuruikgu(String pZrnsuguiryutkyksyuruikgu) {
        zrnsuguiryutkyksyuruikgu = pZrnsuguiryutkyksyuruikgu;
    }

    private String zrnsougouiryoutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSOUGOUIRYOUTOKUYAKUKIKAN)
    public String getZrnsougouiryoutokuyakukikan() {
        return zrnsougouiryoutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsougouiryoutokuyakukikan(String pZrnsougouiryoutokuyakukikan) {
        zrnsougouiryoutokuyakukikan = pZrnsougouiryoutokuyakukikan;
    }

    private String zrnsuguiryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKPHRKKKN)
    public String getZrnsuguiryutkykphrkkkn() {
        return zrnsuguiryutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryutkykphrkkkn(String pZrnsuguiryutkykphrkkkn) {
        zrnsuguiryutkykphrkkkn = pZrnsuguiryutkykphrkkkn;
    }

    private Integer zrnsuguiryutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKNTGK)
    public Integer getZrnsuguiryutkykntgk() {
        return zrnsuguiryutkykntgk;
    }

    public void setZrnsuguiryutkykntgk(Integer pZrnsuguiryutkykntgk) {
        zrnsuguiryutkykntgk = pZrnsuguiryutkykntgk;
    }

    private Long zrnsougouiryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSOUGOUIRYOUTOKUYAKUP)
    public Long getZrnsougouiryoutokuyakup() {
        return zrnsougouiryoutokuyakup;
    }

    public void setZrnsougouiryoutokuyakup(Long pZrnsougouiryoutokuyakup) {
        zrnsougouiryoutokuyakup = pZrnsougouiryoutokuyakup;
    }

    private Integer zrnsuguiryutkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKJYURYUMSHYUTN)
    public Integer getZrnsuguiryutkjyuryumshyutn() {
        return zrnsuguiryutkjyuryumshyutn;
    }

    public void setZrnsuguiryutkjyuryumshyutn(Integer pZrnsuguiryutkjyuryumshyutn) {
        zrnsuguiryutkjyuryumshyutn = pZrnsuguiryutkjyuryumshyutn;
    }

    private Long zrnsougouiryoutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSOUGOUIRYOUTOKUJYOUP)
    public Long getZrnsougouiryoutokujyoup() {
        return zrnsougouiryoutokujyoup;
    }

    public void setZrnsougouiryoutokujyoup(Long pZrnsougouiryoutokujyoup) {
        zrnsougouiryoutokujyoup = pZrnsougouiryoutokujyoup;
    }

    private String zrnsuguiryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKTBICDX1)
    public String getZrnsuguiryutktbicdx1() {
        return zrnsuguiryutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryutktbicdx1(String pZrnsuguiryutktbicdx1) {
        zrnsuguiryutktbicdx1 = pZrnsuguiryutktbicdx1;
    }

    private String zrnsuguiryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUHTNPKKNX1)
    public String getZrnsuguiryuhtnpkknx1() {
        return zrnsuguiryuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryuhtnpkknx1(String pZrnsuguiryuhtnpkknx1) {
        zrnsuguiryuhtnpkknx1 = pZrnsuguiryuhtnpkknx1;
    }

    private String zrnsuguiryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKTBICDX2)
    public String getZrnsuguiryutktbicdx2() {
        return zrnsuguiryutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryutktbicdx2(String pZrnsuguiryutktbicdx2) {
        zrnsuguiryutktbicdx2 = pZrnsuguiryutktbicdx2;
    }

    private String zrnsuguiryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUHTNPKKNX2)
    public String getZrnsuguiryuhtnpkknx2() {
        return zrnsuguiryuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryuhtnpkknx2(String pZrnsuguiryuhtnpkknx2) {
        zrnsuguiryuhtnpkknx2 = pZrnsuguiryuhtnpkknx2;
    }

    private String zrnsuguiryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKGUSDKBN)
    public String getZrnsuguiryutkykkgusdkbn() {
        return zrnsuguiryutkykkgusdkbn;
    }

    public void setZrnsuguiryutkykkgusdkbn(String pZrnsuguiryutkykkgusdkbn) {
        zrnsuguiryutkykkgusdkbn = pZrnsuguiryutkykkgusdkbn;
    }

    private String zrnsuguiryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKPWRBKKBN)
    public String getZrnsuguiryutkykpwrbkkbn() {
        return zrnsuguiryutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryutkykpwrbkkbn(String pZrnsuguiryutkykpwrbkkbn) {
        zrnsuguiryutkykpwrbkkbn = pZrnsuguiryutkykpwrbkkbn;
    }

    private String zrnsuguiryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKGUYBX1)
    public String getZrnsuguiryutkykkguybx1() {
        return zrnsuguiryutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuguiryutkykkguybx1(String pZrnsuguiryutkykkguybx1) {
        zrnsuguiryutkykkguybx1 = pZrnsuguiryutkykkguybx1;
    }

    private String zrnsuguiryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKGUYBX2)
    public String getZrnsuguiryutkykkguybx2() {
        return zrnsuguiryutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuguiryutkykkguybx2(String pZrnsuguiryutkykkguybx2) {
        zrnsuguiryutkykkguybx2 = pZrnsuguiryutkykkguybx2;
    }

    private String zrnsuguiryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKGUYBX3)
    public String getZrnsuguiryutkykkguybx3() {
        return zrnsuguiryutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuguiryutkykkguybx3(String pZrnsuguiryutkykkguybx3) {
        zrnsuguiryutkykkguybx3 = pZrnsuguiryutkykkguybx3;
    }

    private String zrnsuguiryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKGUYBX4)
    public String getZrnsuguiryutkykkguybx4() {
        return zrnsuguiryutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuguiryutkykkguybx4(String pZrnsuguiryutkykkguybx4) {
        zrnsuguiryutkykkguybx4 = pZrnsuguiryutkykkguybx4;
    }

    private String zrnsuguiryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKGUYBX5)
    public String getZrnsuguiryutkykkguybx5() {
        return zrnsuguiryutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuguiryutkykkguybx5(String pZrnsuguiryutkykkguybx5) {
        zrnsuguiryutkykkguybx5 = pZrnsuguiryutkykkguybx5;
    }

    private String zrnsuguiryutkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSUGUIRYUTKYKKUSNMNRYOAGE)
    public String getZrnsuguiryutkykkusnmnryoage() {
        return zrnsuguiryutkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuguiryutkykkusnmnryoage(String pZrnsuguiryutkykkusnmnryoage) {
        zrnsuguiryutkykkusnmnryoage = pZrnsuguiryutkykkusnmnryoage;
    }

    private String zrnyobiv7x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV7X7)
    public String getZrnyobiv7x7() {
        return zrnyobiv7x7;
    }

    public void setZrnyobiv7x7(String pZrnyobiv7x7) {
        zrnyobiv7x7 = pZrnyobiv7x7;
    }

    private String zrndi2suguiryutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKSYRIKGU)
    public String getZrndi2suguiryutkyksyrikgu() {
        return zrndi2suguiryutkyksyrikgu;
    }

    public void setZrndi2suguiryutkyksyrikgu(String pZrndi2suguiryutkyksyrikgu) {
        zrndi2suguiryutkyksyrikgu = pZrndi2suguiryutkyksyrikgu;
    }

    private String zrndi2suguiryutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKKN)
    public String getZrndi2suguiryutkykkkn() {
        return zrndi2suguiryutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryutkykkkn(String pZrndi2suguiryutkykkkn) {
        zrndi2suguiryutkykkkn = pZrndi2suguiryutkykkkn;
    }

    private String zrndi2suguiryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKPHRKKKN)
    public String getZrndi2suguiryutkykphrkkkn() {
        return zrndi2suguiryutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryutkykphrkkkn(String pZrndi2suguiryutkykphrkkkn) {
        zrndi2suguiryutkykphrkkkn = pZrndi2suguiryutkykphrkkkn;
    }

    private Integer zrndi2suguiryutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKNTGK)
    public Integer getZrndi2suguiryutkykntgk() {
        return zrndi2suguiryutkykntgk;
    }

    public void setZrndi2suguiryutkykntgk(Integer pZrndi2suguiryutkykntgk) {
        zrndi2suguiryutkykntgk = pZrndi2suguiryutkykntgk;
    }

    private Long zrndai2sougouiryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2SOUGOUIRYOUTOKUYAKUP)
    public Long getZrndai2sougouiryoutokuyakup() {
        return zrndai2sougouiryoutokuyakup;
    }

    public void setZrndai2sougouiryoutokuyakup(Long pZrndai2sougouiryoutokuyakup) {
        zrndai2sougouiryoutokuyakup = pZrndai2sougouiryoutokuyakup;
    }

    private Integer zrndi2suguiryutkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKJYURYMSHYTN)
    public Integer getZrndi2suguiryutkjyurymshytn() {
        return zrndi2suguiryutkjyurymshytn;
    }

    public void setZrndi2suguiryutkjyurymshytn(Integer pZrndi2suguiryutkjyurymshytn) {
        zrndi2suguiryutkjyurymshytn = pZrndi2suguiryutkjyurymshytn;
    }

    private Long zrndai2sougouiryoutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2SOUGOUIRYOUTOKUJYOUP)
    public Long getZrndai2sougouiryoutokujyoup() {
        return zrndai2sougouiryoutokujyoup;
    }

    public void setZrndai2sougouiryoutokujyoup(Long pZrndai2sougouiryoutokujyoup) {
        zrndai2sougouiryoutokujyoup = pZrndai2sougouiryoutokujyoup;
    }

    private String zrndi2suguiryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKTBICDX1)
    public String getZrndi2suguiryutktbicdx1() {
        return zrndi2suguiryutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryutktbicdx1(String pZrndi2suguiryutktbicdx1) {
        zrndi2suguiryutktbicdx1 = pZrndi2suguiryutktbicdx1;
    }

    private String zrndi2suguiryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUHTNPKKNX1)
    public String getZrndi2suguiryuhtnpkknx1() {
        return zrndi2suguiryuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryuhtnpkknx1(String pZrndi2suguiryuhtnpkknx1) {
        zrndi2suguiryuhtnpkknx1 = pZrndi2suguiryuhtnpkknx1;
    }

    private String zrndi2suguiryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKTBICDX2)
    public String getZrndi2suguiryutktbicdx2() {
        return zrndi2suguiryutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryutktbicdx2(String pZrndi2suguiryutktbicdx2) {
        zrndi2suguiryutktbicdx2 = pZrndi2suguiryutktbicdx2;
    }

    private String zrndi2suguiryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUHTNPKKNX2)
    public String getZrndi2suguiryuhtnpkknx2() {
        return zrndi2suguiryuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryuhtnpkknx2(String pZrndi2suguiryuhtnpkknx2) {
        zrndi2suguiryuhtnpkknx2 = pZrndi2suguiryuhtnpkknx2;
    }

    private String zrndi2suguiryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKGUSDKBN)
    public String getZrndi2suguiryutkykkgusdkbn() {
        return zrndi2suguiryutkykkgusdkbn;
    }

    public void setZrndi2suguiryutkykkgusdkbn(String pZrndi2suguiryutkykkgusdkbn) {
        zrndi2suguiryutkykkgusdkbn = pZrndi2suguiryutkykkgusdkbn;
    }

    private String zrndi2suguiryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKPWRBKKBN)
    public String getZrndi2suguiryutkykpwrbkkbn() {
        return zrndi2suguiryutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2suguiryutkykpwrbkkbn(String pZrndi2suguiryutkykpwrbkkbn) {
        zrndi2suguiryutkykpwrbkkbn = pZrndi2suguiryutkykpwrbkkbn;
    }

    private String zrndi2suguiryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKGUYBX1)
    public String getZrndi2suguiryutkykkguybx1() {
        return zrndi2suguiryutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2suguiryutkykkguybx1(String pZrndi2suguiryutkykkguybx1) {
        zrndi2suguiryutkykkguybx1 = pZrndi2suguiryutkykkguybx1;
    }

    private String zrndi2suguiryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKGUYBX2)
    public String getZrndi2suguiryutkykkguybx2() {
        return zrndi2suguiryutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2suguiryutkykkguybx2(String pZrndi2suguiryutkykkguybx2) {
        zrndi2suguiryutkykkguybx2 = pZrndi2suguiryutkykkguybx2;
    }

    private String zrndi2suguiryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKGUYBX3)
    public String getZrndi2suguiryutkykkguybx3() {
        return zrndi2suguiryutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2suguiryutkykkguybx3(String pZrndi2suguiryutkykkguybx3) {
        zrndi2suguiryutkykkguybx3 = pZrndi2suguiryutkykkguybx3;
    }

    private String zrndi2suguiryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKGUYBX4)
    public String getZrndi2suguiryutkykkguybx4() {
        return zrndi2suguiryutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2suguiryutkykkguybx4(String pZrndi2suguiryutkykkguybx4) {
        zrndi2suguiryutkykkguybx4 = pZrndi2suguiryutkykkguybx4;
    }

    private String zrndi2suguiryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2SUGUIRYUTKYKKGUYBX5)
    public String getZrndi2suguiryutkykkguybx5() {
        return zrndi2suguiryutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2suguiryutkykkguybx5(String pZrndi2suguiryutkykkguybx5) {
        zrndi2suguiryutkykkguybx5 = pZrndi2suguiryutkykkguybx5;
    }

    private String zrnyobiv9x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV9X12)
    public String getZrnyobiv9x12() {
        return zrnyobiv9x12;
    }

    public void setZrnyobiv9x12(String pZrnyobiv9x12) {
        zrnyobiv9x12 = pZrnyobiv9x12;
    }

    private String zrndai2gannyuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUINTKYKSYRIKGU)
    public String getZrndai2gannyuintkyksyrikgu() {
        return zrndai2gannyuintkyksyrikgu;
    }

    public void setZrndai2gannyuintkyksyrikgu(String pZrndai2gannyuintkyksyrikgu) {
        zrndai2gannyuintkyksyrikgu = pZrndai2gannyuintkyksyrikgu;
    }

    private String zrndai2gannyuintkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUINTKYKKKN)
    public String getZrndai2gannyuintkykkkn() {
        return zrndai2gannyuintkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2gannyuintkykkkn(String pZrndai2gannyuintkykkkn) {
        zrndai2gannyuintkykkkn = pZrndai2gannyuintkykkkn;
    }

    private String zrndai2gannyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUINTKYKPHRKKKN)
    public String getZrndai2gannyuintkykphrkkkn() {
        return zrndai2gannyuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2gannyuintkykphrkkkn(String pZrndai2gannyuintkykphrkkkn) {
        zrndai2gannyuintkykphrkkkn = pZrndai2gannyuintkykphrkkkn;
    }

    private Integer zrndai2gannyuintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUINTKYKNTGK)
    public Integer getZrndai2gannyuintkykntgk() {
        return zrndai2gannyuintkykntgk;
    }

    public void setZrndai2gannyuintkykntgk(Integer pZrndai2gannyuintkykntgk) {
        zrndai2gannyuintkykntgk = pZrndai2gannyuintkykntgk;
    }

    private Long zrndai2gannyuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUUINTOKUYAKUP)
    public Long getZrndai2gannyuuintokuyakup() {
        return zrndai2gannyuuintokuyakup;
    }

    public void setZrndai2gannyuuintokuyakup(Long pZrndai2gannyuuintokuyakup) {
        zrndai2gannyuuintokuyakup = pZrndai2gannyuuintokuyakup;
    }

    private String zrndai2gannyuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUINTKYKKGUSDKBN)
    public String getZrndai2gannyuintkykkgusdkbn() {
        return zrndai2gannyuintkykkgusdkbn;
    }

    public void setZrndai2gannyuintkykkgusdkbn(String pZrndai2gannyuintkykkgusdkbn) {
        zrndai2gannyuintkykkgusdkbn = pZrndai2gannyuintkykkgusdkbn;
    }

    private String zrndi2gannyuintkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2GANNYUINTKYKKGUYOBIX1)
    public String getZrndi2gannyuintkykkguyobix1() {
        return zrndi2gannyuintkykkguyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2gannyuintkykkguyobix1(String pZrndi2gannyuintkykkguyobix1) {
        zrndi2gannyuintkykkguyobix1 = pZrndi2gannyuintkykkguyobix1;
    }

    private String zrndi2gannyuintkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2GANNYUINTKYKKGUYOBIX2)
    public String getZrndi2gannyuintkykkguyobix2() {
        return zrndi2gannyuintkykkguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2gannyuintkykkguyobix2(String pZrndi2gannyuintkykkguyobix2) {
        zrndi2gannyuintkykkguyobix2 = pZrndi2gannyuintkykkguyobix2;
    }

    private String zrndi2gannyuintkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2GANNYUINTKYKKGUYOBIX3)
    public String getZrndi2gannyuintkykkguyobix3() {
        return zrndi2gannyuintkykkguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2gannyuintkykkguyobix3(String pZrndi2gannyuintkykkguyobix3) {
        zrndi2gannyuintkykkguyobix3 = pZrndi2gannyuintkykkguyobix3;
    }

    private String zrndi2gannyuintkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2GANNYUINTKYKKGUYOBIX4)
    public String getZrndi2gannyuintkykkguyobix4() {
        return zrndi2gannyuintkykkguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2gannyuintkykkguyobix4(String pZrndi2gannyuintkykkguyobix4) {
        zrndi2gannyuintkykkguyobix4 = pZrndi2gannyuintkykkguyobix4;
    }

    private String zrndi2gannyuintkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDI2GANNYUINTKYKKGUYOBIX5)
    public String getZrndi2gannyuintkykkguyobix5() {
        return zrndi2gannyuintkykkguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2gannyuintkykkguyobix5(String pZrndi2gannyuintkykkguyobix5) {
        zrndi2gannyuintkykkguyobix5 = pZrndi2gannyuintkykkguyobix5;
    }

    private String zrndai2gannyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNDAI2GANNYUINTKYKPWRBKKBN)
    public String getZrndai2gannyuintkykpwrbkkbn() {
        return zrndai2gannyuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2gannyuintkykpwrbkkbn(String pZrndai2gannyuintkykpwrbkkbn) {
        zrndai2gannyuintkykpwrbkkbn = pZrndai2gannyuintkykpwrbkkbn;
    }

    private String zrnyobiv6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV6X4)
    public String getZrnyobiv6x4() {
        return zrnyobiv6x4;
    }

    public void setZrnyobiv6x4(String pZrnyobiv6x4) {
        zrnyobiv6x4 = pZrnyobiv6x4;
    }

    private Integer zrngukihtnknsuguirytkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGUKIHTNKNSUGUIRYTKYKNTGK)
    public Integer getZrngukihtnknsuguirytkykntgk() {
        return zrngukihtnknsuguirytkykntgk;
    }

    public void setZrngukihtnknsuguirytkykntgk(Integer pZrngukihtnknsuguirytkykntgk) {
        zrngukihtnknsuguirytkykntgk = pZrngukihtnknsuguirytkykntgk;
    }

    private String zrnhijynbrimarusyuusyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUSYRIKGU)
    public String getZrnhijynbrimarusyuusyrikgu() {
        return zrnhijynbrimarusyuusyrikgu;
    }

    public void setZrnhijynbrimarusyuusyrikgu(String pZrnhijynbrimarusyuusyrikgu) {
        zrnhijynbrimarusyuusyrikgu = pZrnhijynbrimarusyuusyrikgu;
    }

    private String zrnhijynbrimrsyukgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMRSYUKGUSDKBN)
    public String getZrnhijynbrimrsyukgusdkbn() {
        return zrnhijynbrimrsyukgusdkbn;
    }

    public void setZrnhijynbrimrsyukgusdkbn(String pZrnhijynbrimrsyukgusdkbn) {
        zrnhijynbrimrsyukgusdkbn = pZrnhijynbrimrsyukgusdkbn;
    }

    private String zrnhijynbrimarusyuukguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUKGUYBX1)
    public String getZrnhijynbrimarusyuukguybx1() {
        return zrnhijynbrimarusyuukguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhijynbrimarusyuukguybx1(String pZrnhijynbrimarusyuukguybx1) {
        zrnhijynbrimarusyuukguybx1 = pZrnhijynbrimarusyuukguybx1;
    }

    private String zrnhijynbrimarusyuukguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUKGUYBX2)
    public String getZrnhijynbrimarusyuukguybx2() {
        return zrnhijynbrimarusyuukguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhijynbrimarusyuukguybx2(String pZrnhijynbrimarusyuukguybx2) {
        zrnhijynbrimarusyuukguybx2 = pZrnhijynbrimarusyuukguybx2;
    }

    private String zrnhijynbrimarusyuukguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUKGUYBX3)
    public String getZrnhijynbrimarusyuukguybx3() {
        return zrnhijynbrimarusyuukguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhijynbrimarusyuukguybx3(String pZrnhijynbrimarusyuukguybx3) {
        zrnhijynbrimarusyuukguybx3 = pZrnhijynbrimarusyuukguybx3;
    }

    private String zrnhijynbrimarusyuukguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUKGUYBX4)
    public String getZrnhijynbrimarusyuukguybx4() {
        return zrnhijynbrimarusyuukguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhijynbrimarusyuukguybx4(String pZrnhijynbrimarusyuukguybx4) {
        zrnhijynbrimarusyuukguybx4 = pZrnhijynbrimarusyuukguybx4;
    }

    private String zrnhijynbrimarusyuukguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUKGUYBX5)
    public String getZrnhijynbrimarusyuukguybx5() {
        return zrnhijynbrimarusyuukguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhijynbrimarusyuukguybx5(String pZrnhijynbrimarusyuukguybx5) {
        zrnhijynbrimarusyuukguybx5 = pZrnhijynbrimarusyuukguybx5;
    }

    private String zrnhijynbrimarusyuukkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUKKN)
    public String getZrnhijynbrimarusyuukkn() {
        return zrnhijynbrimarusyuukkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhijynbrimarusyuukkn(String pZrnhijynbrimarusyuukkn) {
        zrnhijynbrimarusyuukkn = pZrnhijynbrimarusyuukkn;
    }

    private String zrnhijynbrimrsyphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMRSYPHRKKKN)
    public String getZrnhijynbrimrsyphrkkkn() {
        return zrnhijynbrimrsyphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhijynbrimrsyphrkkkn(String pZrnhijynbrimrsyphrkkkn) {
        zrnhijynbrimrsyphrkkkn = pZrnhijynbrimrsyphrkkkn;
    }

    private Long zrnhijynbrimarusyuutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUTKYKS)
    public Long getZrnhijynbrimarusyuutkyks() {
        return zrnhijynbrimarusyuutkyks;
    }

    public void setZrnhijynbrimarusyuutkyks(Long pZrnhijynbrimarusyuutkyks) {
        zrnhijynbrimarusyuutkyks = pZrnhijynbrimarusyuutkyks;
    }

    private Long zrnhijynbrimarusyuutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUTKYKP)
    public Long getZrnhijynbrimarusyuutkykp() {
        return zrnhijynbrimarusyuutkykp;
    }

    public void setZrnhijynbrimarusyuutkykp(Long pZrnhijynbrimarusyuutkykp) {
        zrnhijynbrimarusyuutkykp = pZrnhijynbrimarusyuutkykp;
    }

    private String zrnhijynbrimrsypwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMRSYPWRBKKBN)
    public String getZrnhijynbrimrsypwrbkkbn() {
        return zrnhijynbrimrsypwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhijynbrimrsypwrbkkbn(String pZrnhijynbrimrsypwrbkkbn) {
        zrnhijynbrimrsypwrbkkbn = pZrnhijynbrimrsypwrbkkbn;
    }

    private Long zrnhijynbrimarusyuumods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUMODS)
    public Long getZrnhijynbrimarusyuumods() {
        return zrnhijynbrimarusyuumods;
    }

    public void setZrnhijynbrimarusyuumods(Long pZrnhijynbrimarusyuumods) {
        zrnhijynbrimarusyuumods = pZrnhijynbrimarusyuumods;
    }

    private String zrnhijynbrimarusyuutkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUTKJYUKBN)
    public String getZrnhijynbrimarusyuutkjyukbn() {
        return zrnhijynbrimarusyuutkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhijynbrimarusyuutkjyukbn(String pZrnhijynbrimarusyuutkjyukbn) {
        zrnhijynbrimarusyuutkjyukbn = pZrnhijynbrimarusyuutkjyukbn;
    }

    private String zrnhijynbrimrsytkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMRSYTKJYUSKGNKKN)
    public String getZrnhijynbrimrsytkjyuskgnkkn() {
        return zrnhijynbrimrsytkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhijynbrimrsytkjyuskgnkkn(String pZrnhijynbrimrsytkjyuskgnkkn) {
        zrnhijynbrimrsytkjyuskgnkkn = pZrnhijynbrimrsytkjyuskgnkkn;
    }

    private Integer zrnhijynbrmrsytkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRMRSYTKJYURYMSHYTN)
    public Integer getZrnhijynbrmrsytkjyurymshytn() {
        return zrnhijynbrmrsytkjyurymshytn;
    }

    public void setZrnhijynbrmrsytkjyurymshytn(Integer pZrnhijynbrmrsytkjyurymshytn) {
        zrnhijynbrmrsytkjyurymshytn = pZrnhijynbrmrsytkjyurymshytn;
    }

    private Long zrnhijynbrimarusyuutkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRIMARUSYUUTKJYUP)
    public Long getZrnhijynbrimarusyuutkjyup() {
        return zrnhijynbrimarusyuutkjyup;
    }

    public void setZrnhijynbrimarusyuutkjyup(Long pZrnhijynbrimarusyuutkjyup) {
        zrnhijynbrimarusyuutkjyup = pZrnhijynbrimarusyuutkjyup;
    }

    private String zrnhijynbrmrsytnknygryrtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHIJYNBRMRSYTNKNYGRYRTKBN)
    public String getZrnhijynbrmrsytnknygryrtkbn() {
        return zrnhijynbrmrsytnknygryrtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhijynbrmrsytnknygryrtkbn(String pZrnhijynbrmrsytnknygryrtkbn) {
        zrnhijynbrmrsytnknygryrtkbn = pZrnhijynbrmrsytnknygryrtkbn;
    }

    private String zrnyobiv4x18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV4X18)
    public String getZrnyobiv4x18() {
        return zrnyobiv4x18;
    }

    public void setZrnyobiv4x18(String pZrnyobiv4x18) {
        zrnyobiv4x18 = pZrnyobiv4x18;
    }

    private String zrntokuteijyoutaihushrhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZrntokuteijyoutaihushrhyj() {
        return zrntokuteijyoutaihushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyoutaihushrhyj(String pZrntokuteijyoutaihushrhyj) {
        zrntokuteijyoutaihushrhyj = pZrntokuteijyoutaihushrhyj;
    }

    private Long zrnmosjikaigos;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNMOSJIKAIGOS)
    public Long getZrnmosjikaigos() {
        return zrnmosjikaigos;
    }

    public void setZrnmosjikaigos(Long pZrnmosjikaigos) {
        zrnmosjikaigos = pZrnmosjikaigos;
    }

    private Long zrnmosjidi2hknkknsyuusns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNMOSJIDI2HKNKKNSYUUSNS)
    public Long getZrnmosjidi2hknkknsyuusns() {
        return zrnmosjidi2hknkknsyuusns;
    }

    public void setZrnmosjidi2hknkknsyuusns(Long pZrnmosjidi2hknkknsyuusns) {
        zrnmosjidi2hknkknsyuusns = pZrnmosjidi2hknkknsyuusns;
    }

    private String zrngansndntkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKSYRIKGU)
    public String getZrngansndntkyksyrikgu() {
        return zrngansndntkyksyrikgu;
    }

    public void setZrngansndntkyksyrikgu(String pZrngansndntkyksyrikgu) {
        zrngansndntkyksyrikgu = pZrngansndntkyksyrikgu;
    }

    private String zrngansndntkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKKGUSDKBN)
    public String getZrngansndntkykkgusdkbn() {
        return zrngansndntkykkgusdkbn;
    }

    public void setZrngansndntkykkgusdkbn(String pZrngansndntkykkgusdkbn) {
        zrngansndntkykkgusdkbn = pZrngansndntkykkgusdkbn;
    }

    private String zrngansndntkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKKGUYBX1)
    public String getZrngansndntkykkguybx1() {
        return zrngansndntkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansndntkykkguybx1(String pZrngansndntkykkguybx1) {
        zrngansndntkykkguybx1 = pZrngansndntkykkguybx1;
    }

    private String zrngansndntkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKKGUYBX2)
    public String getZrngansndntkykkguybx2() {
        return zrngansndntkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansndntkykkguybx2(String pZrngansndntkykkguybx2) {
        zrngansndntkykkguybx2 = pZrngansndntkykkguybx2;
    }

    private String zrngansndntkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKKGUYBX3)
    public String getZrngansndntkykkguybx3() {
        return zrngansndntkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansndntkykkguybx3(String pZrngansndntkykkguybx3) {
        zrngansndntkykkguybx3 = pZrngansndntkykkguybx3;
    }

    private String zrngansndntkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKKGUYBX4)
    public String getZrngansndntkykkguybx4() {
        return zrngansndntkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansndntkykkguybx4(String pZrngansndntkykkguybx4) {
        zrngansndntkykkguybx4 = pZrngansndntkykkguybx4;
    }

    private String zrngansndntkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKKGUYBX5)
    public String getZrngansndntkykkguybx5() {
        return zrngansndntkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansndntkykkguybx5(String pZrngansndntkykkguybx5) {
        zrngansndntkykkguybx5 = pZrngansndntkykkguybx5;
    }

    private String zrngansindantokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSINDANTOKUYAKUKIKAN)
    public String getZrngansindantokuyakukikan() {
        return zrngansindantokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngansindantokuyakukikan(String pZrngansindantokuyakukikan) {
        zrngansindantokuyakukikan = pZrngansindantokuyakukikan;
    }

    private String zrngansndntkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKPHRKKKN)
    public String getZrngansndntkykphrkkkn() {
        return zrngansndntkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngansndntkykphrkkkn(String pZrngansndntkykphrkkkn) {
        zrngansndntkykphrkkkn = pZrngansndntkykphrkkkn;
    }

    private Long zrngansindantokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSINDANTOKUYAKUS)
    public Long getZrngansindantokuyakus() {
        return zrngansindantokuyakus;
    }

    public void setZrngansindantokuyakus(Long pZrngansindantokuyakus) {
        zrngansindantokuyakus = pZrngansindantokuyakus;
    }

    private Long zrngansindantokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSINDANTOKUYAKUP)
    public Long getZrngansindantokuyakup() {
        return zrngansindantokuyakup;
    }

    public void setZrngansindantokuyakup(Long pZrngansindantokuyakup) {
        zrngansindantokuyakup = pZrngansindantokuyakup;
    }

    private String zrngansndntkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKPWRBKKBN)
    public String getZrngansndntkykpwrbkkbn() {
        return zrngansndntkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngansndntkykpwrbkkbn(String pZrngansndntkykpwrbkkbn) {
        zrngansndntkykpwrbkkbn = pZrngansndntkykpwrbkkbn;
    }

    private Long zrngansndntkyktaikknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANSNDNTKYKTAIKKNBBNS)
    public Long getZrngansndntkyktaikknbbns() {
        return zrngansndntkyktaikknbbns;
    }

    public void setZrngansndntkyktaikknbbns(Long pZrngansndntkyktaikknbbns) {
        zrngansndntkyktaikknbbns = pZrngansndntkyktaikknbbns;
    }

    private Long zrnjyouhinaiganmtkknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNJYOUHINAIGANMTKKNBBNS)
    public Long getZrnjyouhinaiganmtkknbbns() {
        return zrnjyouhinaiganmtkknbbns;
    }

    public void setZrnjyouhinaiganmtkknbbns(Long pZrnjyouhinaiganmtkknbbns) {
        zrnjyouhinaiganmtkknbbns = pZrnjyouhinaiganmtkknbbns;
    }

    private String zrngnsndntkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGNSNDNTKYKKUSNMNRYOAGE)
    public String getZrngnsndntkykkusnmnryoage() {
        return zrngnsndntkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngnsndntkykkusnmnryoage(String pZrngnsndntkykkusnmnryoage) {
        zrngnsndntkykkusnmnryoage = pZrngnsndntkykkusnmnryoage;
    }

    private String zrnyobiv10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV10X5)
    public String getZrnyobiv10x5() {
        return zrnyobiv10x5;
    }

    public void setZrnyobiv10x5(String pZrnyobiv10x5) {
        zrnyobiv10x5 = pZrnyobiv10x5;
    }

    private String zrnganykbttryutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKSYRIKGU)
    public String getZrnganykbttryutkyksyrikgu() {
        return zrnganykbttryutkyksyrikgu;
    }

    public void setZrnganykbttryutkyksyrikgu(String pZrnganykbttryutkyksyrikgu) {
        zrnganykbttryutkyksyrikgu = pZrnganykbttryutkyksyrikgu;
    }

    private String zrnganykbttryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKGUSDKBN)
    public String getZrnganykbttryutkykkgusdkbn() {
        return zrnganykbttryutkykkgusdkbn;
    }

    public void setZrnganykbttryutkykkgusdkbn(String pZrnganykbttryutkykkgusdkbn) {
        zrnganykbttryutkykkgusdkbn = pZrnganykbttryutkykkgusdkbn;
    }

    private String zrnganykbttryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKGUYBX1)
    public String getZrnganykbttryutkykkguybx1() {
        return zrnganykbttryutkykkguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganykbttryutkykkguybx1(String pZrnganykbttryutkykkguybx1) {
        zrnganykbttryutkykkguybx1 = pZrnganykbttryutkykkguybx1;
    }

    private String zrnganykbttryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKGUYBX2)
    public String getZrnganykbttryutkykkguybx2() {
        return zrnganykbttryutkykkguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganykbttryutkykkguybx2(String pZrnganykbttryutkykkguybx2) {
        zrnganykbttryutkykkguybx2 = pZrnganykbttryutkykkguybx2;
    }

    private String zrnganykbttryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKGUYBX3)
    public String getZrnganykbttryutkykkguybx3() {
        return zrnganykbttryutkykkguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganykbttryutkykkguybx3(String pZrnganykbttryutkykkguybx3) {
        zrnganykbttryutkykkguybx3 = pZrnganykbttryutkykkguybx3;
    }

    private String zrnganykbttryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKGUYBX4)
    public String getZrnganykbttryutkykkguybx4() {
        return zrnganykbttryutkykkguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganykbttryutkykkguybx4(String pZrnganykbttryutkykkguybx4) {
        zrnganykbttryutkykkguybx4 = pZrnganykbttryutkykkguybx4;
    }

    private String zrnganykbttryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKGUYBX5)
    public String getZrnganykbttryutkykkguybx5() {
        return zrnganykbttryutkykkguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganykbttryutkykkguybx5(String pZrnganykbttryutkykkguybx5) {
        zrnganykbttryutkykkguybx5 = pZrnganykbttryutkykkguybx5;
    }

    private String zrnganykbttryutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKKKN)
    public String getZrnganykbttryutkykkkn() {
        return zrnganykbttryutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnganykbttryutkykkkn(String pZrnganykbttryutkykkkn) {
        zrnganykbttryutkykkkn = pZrnganykbttryutkykkkn;
    }

    private String zrnganykbttryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKPHRKKKN)
    public String getZrnganykbttryutkykphrkkkn() {
        return zrnganykbttryutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnganykbttryutkykphrkkkn(String pZrnganykbttryutkykphrkkkn) {
        zrnganykbttryutkykphrkkkn = pZrnganykbttryutkykphrkkkn;
    }

    private Long zrnganykbttryutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKS)
    public Long getZrnganykbttryutkyks() {
        return zrnganykbttryutkyks;
    }

    public void setZrnganykbttryutkyks(Long pZrnganykbttryutkyks) {
        zrnganykbttryutkyks = pZrnganykbttryutkyks;
    }

    private Long zrnganykbttryutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKP)
    public Long getZrnganykbttryutkykp() {
        return zrnganykbttryutkykp;
    }

    public void setZrnganykbttryutkykp(Long pZrnganykbttryutkykp) {
        zrnganykbttryutkykp = pZrnganykbttryutkykp;
    }

    private String zrnganykbttryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGANYKBTTRYUTKYKPWRBKKBN)
    public String getZrnganykbttryutkykpwrbkkbn() {
        return zrnganykbttryutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnganykbttryutkykpwrbkkbn(String pZrnganykbttryutkykpwrbkkbn) {
        zrnganykbttryutkykpwrbkkbn = pZrnganykbttryutkykpwrbkkbn;
    }

    private String zrngnykbttryutkykksnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGNYKBTTRYUTKYKKSNMNRYAGE)
    public String getZrngnykbttryutkykksnmnryage() {
        return zrngnykbttryutkykksnmnryage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngnykbttryutkykksnmnryage(String pZrngnykbttryutkykksnmnryage) {
        zrngnykbttryutkykksnmnryage = pZrngnykbttryutkykksnmnryage;
    }

    private String zrnyobiv12x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV12X11)
    public String getZrnyobiv12x11() {
        return zrnyobiv12x11;
    }

    public void setZrnyobiv12x11(String pZrnyobiv12x11) {
        zrnyobiv12x11 = pZrnyobiv12x11;
    }

    private Long zrngukihtnkngansndntkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGUKIHTNKNGANSNDNTKYKS)
    public Long getZrngukihtnkngansndntkyks() {
        return zrngukihtnkngansndntkyks;
    }

    public void setZrngukihtnkngansndntkyks(Long pZrngukihtnkngansndntkyks) {
        zrngukihtnkngansndntkyks = pZrngukihtnkngansndntkyks;
    }

    private Long zrngukihtnknganykbttrytkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNGUKIHTNKNGANYKBTTRYTKYKS)
    public Long getZrngukihtnknganykbttrytkyks() {
        return zrngukihtnknganykbttrytkyks;
    }

    public void setZrngukihtnknganykbttrytkyks(Long pZrngukihtnknganykbttrytkyks) {
        zrngukihtnknganykbttrytkyks = pZrngukihtnknganykbttrytkyks;
    }

    private BizNumber zrnsinkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSINKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnsinkeiyakujiyoteiriritu() {
        return zrnsinkeiyakujiyoteiriritu;
    }

    public void setZrnsinkeiyakujiyoteiriritu(BizNumber pZrnsinkeiyakujiyoteiriritu) {
        zrnsinkeiyakujiyoteiriritu = pZrnsinkeiyakujiyoteiriritu;
    }

    private String zrnkousinmanryouage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKOUSINMANRYOUAGE)
    public String getZrnkousinmanryouage() {
        return zrnkousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkousinmanryouage(String pZrnkousinmanryouage) {
        zrnkousinmanryouage = pZrnkousinmanryouage;
    }

    private String zrnseizonmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSEIZONMRTIKUSNMNRYOAGE)
    public String getZrnseizonmrtikusnmnryoage() {
        return zrnseizonmrtikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseizonmrtikusnmnryoage(String pZrnseizonmrtikusnmnryoage) {
        zrnseizonmrtikusnmnryoage = pZrnseizonmrtikusnmnryoage;
    }

    private String zrnteigenmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNTEIGENMRTIKUSNMNRYOAGE)
    public String getZrnteigenmrtikusnmnryoage() {
        return zrnteigenmrtikusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteigenmrtikusnmnryoage(String pZrnteigenmrtikusnmnryoage) {
        zrnteigenmrtikusnmnryoage = pZrnteigenmrtikusnmnryoage;
    }

    private String zrnsiktsyunyumrtisyri;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTISYRI)
    public String getZrnsiktsyunyumrtisyri() {
        return zrnsiktsyunyumrtisyri;
    }

    public void setZrnsiktsyunyumrtisyri(String pZrnsiktsyunyumrtisyri) {
        zrnsiktsyunyumrtisyri = pZrnsiktsyunyumrtisyri;
    }

    private String zrnsiktsyunyumrtikgusdikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKGUSDIKBN)
    public String getZrnsiktsyunyumrtikgusdikbn() {
        return zrnsiktsyunyumrtikgusdikbn;
    }

    public void setZrnsiktsyunyumrtikgusdikbn(String pZrnsiktsyunyumrtikgusdikbn) {
        zrnsiktsyunyumrtikgusdikbn = pZrnsiktsyunyumrtikgusdikbn;
    }

    private String zrnsiktsyunyumrtikguyobi;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKGUYOBI)
    public String getZrnsiktsyunyumrtikguyobi() {
        return zrnsiktsyunyumrtikguyobi;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtikguyobi(String pZrnsiktsyunyumrtikguyobi) {
        zrnsiktsyunyumrtikguyobi = pZrnsiktsyunyumrtikguyobi;
    }

    private String zrnsiktsyunyumrtikguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKGUYOBIX2)
    public String getZrnsiktsyunyumrtikguyobix2() {
        return zrnsiktsyunyumrtikguyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtikguyobix2(String pZrnsiktsyunyumrtikguyobix2) {
        zrnsiktsyunyumrtikguyobix2 = pZrnsiktsyunyumrtikguyobix2;
    }

    private String zrnsiktsyunyumrtikguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKGUYOBIX3)
    public String getZrnsiktsyunyumrtikguyobix3() {
        return zrnsiktsyunyumrtikguyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtikguyobix3(String pZrnsiktsyunyumrtikguyobix3) {
        zrnsiktsyunyumrtikguyobix3 = pZrnsiktsyunyumrtikguyobix3;
    }

    private String zrnsiktsyunyumrtikguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKGUYOBIX4)
    public String getZrnsiktsyunyumrtikguyobix4() {
        return zrnsiktsyunyumrtikguyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtikguyobix4(String pZrnsiktsyunyumrtikguyobix4) {
        zrnsiktsyunyumrtikguyobix4 = pZrnsiktsyunyumrtikguyobix4;
    }

    private String zrnsiktsyunyumrtikguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKGUYOBIX5)
    public String getZrnsiktsyunyumrtikguyobix5() {
        return zrnsiktsyunyumrtikguyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtikguyobix5(String pZrnsiktsyunyumrtikguyobix5) {
        zrnsiktsyunyumrtikguyobix5 = pZrnsiktsyunyumrtikguyobix5;
    }

    private String zrnsiktsyunyumrtiktkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKTKBN)
    public String getZrnsiktsyunyumrtiktkbn() {
        return zrnsiktsyunyumrtiktkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtiktkbn(String pZrnsiktsyunyumrtiktkbn) {
        zrnsiktsyunyumrtiktkbn = pZrnsiktsyunyumrtiktkbn;
    }

    private String zrnsiktsyunyumrtisyugiktkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTISYUGIKTKBN)
    public String getZrnsiktsyunyumrtisyugiktkbn() {
        return zrnsiktsyunyumrtisyugiktkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtisyugiktkbn(String pZrnsiktsyunyumrtisyugiktkbn) {
        zrnsiktsyunyumrtisyugiktkbn = pZrnsiktsyunyumrtisyugiktkbn;
    }

    private String zrnseikatusyuunyuumrtikkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSEIKATUSYUUNYUUMRTIKKN)
    public String getZrnseikatusyuunyuumrtikkn() {
        return zrnseikatusyuunyuumrtikkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseikatusyuunyuumrtikkn(String pZrnseikatusyuunyuumrtikkn) {
        zrnseikatusyuunyuumrtikkn = pZrnseikatusyuunyuumrtikkn;
    }

    private String zrnsiktsyunyumrtiphrikmkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIPHRIKMKBN)
    public String getZrnsiktsyunyumrtiphrikmkbn() {
        return zrnsiktsyunyumrtiphrikmkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyunyumrtiphrikmkbn(String pZrnsiktsyunyumrtiphrikmkbn) {
        zrnsiktsyunyumrtiphrikmkbn = pZrnsiktsyunyumrtiphrikmkbn;
    }

    private String zrnsiktsyunyumrtishrikkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTISHRIKKN)
    public String getZrnsiktsyunyumrtishrikkn() {
        return zrnsiktsyunyumrtishrikkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyunyumrtishrikkn(String pZrnsiktsyunyumrtishrikkn) {
        zrnsiktsyunyumrtishrikkn = pZrnsiktsyunyumrtishrikkn;
    }

    private String zrnsiktsynyumrtitnknwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYNYUMRTITNKNWRBKKBN)
    public String getZrnsiktsynyumrtitnknwrbkkbn() {
        return zrnsiktsynyumrtitnknwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsynyumrtitnknwrbkkbn(String pZrnsiktsynyumrtitnknwrbkkbn) {
        zrnsiktsynyumrtitnknwrbkkbn = pZrnsiktsynyumrtitnknwrbkkbn;
    }

    private String zrnsrsiktsyunyumrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSRSIKTSYUNYUMRTIPWRBKKBN)
    public String getZrnsrsiktsyunyumrtipwrbkkbn() {
        return zrnsrsiktsyunyumrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsrsiktsyunyumrtipwrbkkbn(String pZrnsrsiktsyunyumrtipwrbkkbn) {
        zrnsrsiktsyunyumrtipwrbkkbn = pZrnsrsiktsyunyumrtipwrbkkbn;
    }

    private String zrnsiktsyunyumrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIPWRBKKBN)
    public String getZrnsiktsyunyumrtipwrbkkbn() {
        return zrnsiktsyunyumrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyunyumrtipwrbkkbn(String pZrnsiktsyunyumrtipwrbkkbn) {
        zrnsiktsyunyumrtipwrbkkbn = pZrnsiktsyunyumrtipwrbkkbn;
    }

    private String zrnsiktsyunyumrtiksnmnryunn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIKSNMNRYUNN)
    public String getZrnsiktsyunyumrtiksnmnryunn() {
        return zrnsiktsyunyumrtiksnmnryunn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyunyumrtiksnmnryunn(String pZrnsiktsyunyumrtiksnmnryunn) {
        zrnsiktsyunyumrtiksnmnryunn = pZrnsiktsyunyumrtiksnmnryunn;
    }

    private Long zrnsiktsyunyumrtinnknnngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTINNKNNNGK)
    public Long getZrnsiktsyunyumrtinnknnngk() {
        return zrnsiktsyunyumrtinnknnngk;
    }

    public void setZrnsiktsyunyumrtinnknnngk(Long pZrnsiktsyunyumrtinnknnngk) {
        zrnsiktsyunyumrtinnknnngk = pZrnsiktsyunyumrtinnknnngk;
    }

    private Long zrnseikatusyuunyuumrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSEIKATUSYUUNYUUMRTIS)
    public Long getZrnseikatusyuunyuumrtis() {
        return zrnseikatusyuunyuumrtis;
    }

    public void setZrnseikatusyuunyuumrtis(Long pZrnseikatusyuunyuumrtis) {
        zrnseikatusyuunyuumrtis = pZrnseikatusyuunyuumrtis;
    }

    private Long zrnsiktsyunyumrtiitjknks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTIITJKNKS)
    public Long getZrnsiktsyunyumrtiitjknks() {
        return zrnsiktsyunyumrtiitjknks;
    }

    public void setZrnsiktsyunyumrtiitjknks(Long pZrnsiktsyunyumrtiitjknks) {
        zrnsiktsyunyumrtiitjknks = pZrnsiktsyunyumrtiitjknks;
    }

    private Long zrnseikatusyuunyuumrtip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSEIKATUSYUUNYUUMRTIP)
    public Long getZrnseikatusyuunyuumrtip() {
        return zrnseikatusyuunyuumrtip;
    }

    public void setZrnseikatusyuunyuumrtip(Long pZrnseikatusyuunyuumrtip) {
        zrnseikatusyuunyuumrtip = pZrnseikatusyuunyuumrtip;
    }

    private Long zrnsiktsyunyumrtisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTISYUUSEIS)
    public Long getZrnsiktsyunyumrtisyuuseis() {
        return zrnsiktsyunyumrtisyuuseis;
    }

    public void setZrnsiktsyunyumrtisyuuseis(Long pZrnsiktsyunyumrtisyuuseis) {
        zrnsiktsyunyumrtisyuuseis = pZrnsiktsyunyumrtisyuuseis;
    }

    private String zrnsiktsyunyumrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTITKJYUKBN)
    public String getZrnsiktsyunyumrtitkjyukbn() {
        return zrnsiktsyunyumrtitkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyunyumrtitkjyukbn(String pZrnsiktsyunyumrtitkjyukbn) {
        zrnsiktsyunyumrtitkjyukbn = pZrnsiktsyunyumrtitkjyukbn;
    }

    private Integer zrnsiktsynymrtitkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYNYMRTITKJYRYMSHYTN)
    public Integer getZrnsiktsynymrtitkjyrymshytn() {
        return zrnsiktsynymrtitkjyrymshytn;
    }

    public void setZrnsiktsynymrtitkjyrymshytn(Integer pZrnsiktsynymrtitkjyrymshytn) {
        zrnsiktsynymrtitkjyrymshytn = pZrnsiktsynymrtitkjyrymshytn;
    }

    private Long zrnsiktsyunyumrtitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUNYUMRTITKJYUP)
    public Long getZrnsiktsyunyumrtitkjyup() {
        return zrnsiktsyunyumrtitkjyup;
    }

    public void setZrnsiktsyunyumrtitkjyup(Long pZrnsiktsyunyumrtitkjyup) {
        zrnsiktsyunyumrtitkjyup = pZrnsiktsyunyumrtitkjyup;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnsiktsyuknbyutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKSYRIKGU)
    public String getZrnsiktsyuknbyutkyksyrikgu() {
        return zrnsiktsyuknbyutkyksyrikgu;
    }

    public void setZrnsiktsyuknbyutkyksyrikgu(String pZrnsiktsyuknbyutkyksyrikgu) {
        zrnsiktsyuknbyutkyksyrikgu = pZrnsiktsyuknbyutkyksyrikgu;
    }

    private String zrnsiktsyuknbyutkykkgsdikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKGSDIKBN)
    public String getZrnsiktsyuknbyutkykkgsdikbn() {
        return zrnsiktsyuknbyutkykkgsdikbn;
    }

    public void setZrnsiktsyuknbyutkykkgsdikbn(String pZrnsiktsyuknbyutkykkgsdikbn) {
        zrnsiktsyuknbyutkykkgsdikbn = pZrnsiktsyuknbyutkykkgsdikbn;
    }

    private String zrnsiktsyuknbyutkykkguybi;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKGUYBI)
    public String getZrnsiktsyuknbyutkykkguybi() {
        return zrnsiktsyuknbyutkykkguybi;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyutkykkguybi(String pZrnsiktsyuknbyutkykkguybi) {
        zrnsiktsyuknbyutkykkguybi = pZrnsiktsyuknbyutkykkguybi;
    }

    private String zrnsiktsyuknbyutkykkguybix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKGUYBIX2)
    public String getZrnsiktsyuknbyutkykkguybix2() {
        return zrnsiktsyuknbyutkykkguybix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyutkykkguybix2(String pZrnsiktsyuknbyutkykkguybix2) {
        zrnsiktsyuknbyutkykkguybix2 = pZrnsiktsyuknbyutkykkguybix2;
    }

    private String zrnsiktsyuknbyutkykkguybix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKGUYBIX3)
    public String getZrnsiktsyuknbyutkykkguybix3() {
        return zrnsiktsyuknbyutkykkguybix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyutkykkguybix3(String pZrnsiktsyuknbyutkykkguybix3) {
        zrnsiktsyuknbyutkykkguybix3 = pZrnsiktsyuknbyutkykkguybix3;
    }

    private String zrnsiktsyuknbyutkykkguybix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKGUYBIX4)
    public String getZrnsiktsyuknbyutkykkguybix4() {
        return zrnsiktsyuknbyutkykkguybix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyutkykkguybix4(String pZrnsiktsyuknbyutkykkguybix4) {
        zrnsiktsyuknbyutkykkguybix4 = pZrnsiktsyuknbyutkykkguybix4;
    }

    private String zrnsiktsyuknbyutkykkguybix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKGUYBIX5)
    public String getZrnsiktsyuknbyutkykkguybix5() {
        return zrnsiktsyuknbyutkykkguybix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyutkykkguybix5(String pZrnsiktsyuknbyutkykkguybix5) {
        zrnsiktsyuknbyutkykkguybix5 = pZrnsiktsyuknbyutkykkguybix5;
    }

    private String zrnsiktsyuknbyutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKKKN)
    public String getZrnsiktsyuknbyutkykkkn() {
        return zrnsiktsyuknbyutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyutkykkkn(String pZrnsiktsyuknbyutkykkkn) {
        zrnsiktsyuknbyutkykkkn = pZrnsiktsyuknbyutkykkkn;
    }

    private String zrnsiktsyuknbyutkykphrkmkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKPHRKMKKN)
    public String getZrnsiktsyuknbyutkykphrkmkkn() {
        return zrnsiktsyuknbyutkykphrkmkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyutkykphrkmkkn(String pZrnsiktsyuknbyutkykphrkmkkn) {
        zrnsiktsyuknbyutkykphrkmkkn = pZrnsiktsyuknbyutkykphrkmkkn;
    }

    private String zrnsiktsyknbytyktnknwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYKNBYTYKTNKNWRBKKBN)
    public String getZrnsiktsyknbytyktnknwrbkkbn() {
        return zrnsiktsyknbytyktnknwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyknbytyktnknwrbkkbn(String pZrnsiktsyknbytyktnknwrbkkbn) {
        zrnsiktsyknbytyktnknwrbkkbn = pZrnsiktsyknbytyktnknwrbkkbn;
    }

    private String zrnsrsiktsyuknbyutkpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSRSIKTSYUKNBYUTKPWRBKKBN)
    public String getZrnsrsiktsyuknbyutkpwrbkkbn() {
        return zrnsrsiktsyuknbyutkpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsrsiktsyuknbyutkpwrbkkbn(String pZrnsrsiktsyuknbyutkpwrbkkbn) {
        zrnsrsiktsyuknbyutkpwrbkkbn = pZrnsrsiktsyuknbyutkpwrbkkbn;
    }

    private String zrnsiktsyuknbyutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKPWRBKKBN)
    public String getZrnsiktsyuknbyutkykpwrbkkbn() {
        return zrnsiktsyuknbyutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyutkykpwrbkkbn(String pZrnsiktsyuknbyutkykpwrbkkbn) {
        zrnsiktsyuknbyutkykpwrbkkbn = pZrnsiktsyuknbyutkykpwrbkkbn;
    }

    private String zrnsiktsyknbytkykkusnmnrynn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYKNBYTKYKKUSNMNRYNN)
    public String getZrnsiktsyknbytkykkusnmnrynn() {
        return zrnsiktsyknbytkykkusnmnrynn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyknbytkykkusnmnrynn(String pZrnsiktsyknbytkykkusnmnrynn) {
        zrnsiktsyknbytkykkusnmnrynn = pZrnsiktsyknbytkykkusnmnrynn;
    }

    private Long zrnsiktsyuknbyutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKS)
    public Long getZrnsiktsyuknbyutkyks() {
        return zrnsiktsyuknbyutkyks;
    }

    public void setZrnsiktsyuknbyutkyks(Long pZrnsiktsyuknbyutkyks) {
        zrnsiktsyuknbyutkyks = pZrnsiktsyuknbyutkyks;
    }

    private Long zrnsiktsyuknbyutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKP)
    public Long getZrnsiktsyuknbyutkykp() {
        return zrnsiktsyuknbyutkykp;
    }

    public void setZrnsiktsyuknbyutkykp(Long pZrnsiktsyuknbyutkykp) {
        zrnsiktsyuknbyutkykp = pZrnsiktsyuknbyutkykp;
    }

    private Long zrnsiktsyuknbyutkyktikknars;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKTIKKNARS)
    public Long getZrnsiktsyuknbyutkyktikknars() {
        return zrnsiktsyuknbyutkyktikknars;
    }

    public void setZrnsiktsyuknbyutkyktikknars(Long pZrnsiktsyuknbyutkyktikknars) {
        zrnsiktsyuknbyutkyktikknars = pZrnsiktsyuknbyutkyktikknars;
    }

    private Long zrnsiktsyuknbyutkyksyusis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKYKSYUSIS)
    public Long getZrnsiktsyuknbyutkyksyusis() {
        return zrnsiktsyuknbyutkyksyusis;
    }

    public void setZrnsiktsyuknbyutkyksyusis(Long pZrnsiktsyuknbyutkyksyusis) {
        zrnsiktsyuknbyutkyksyusis = pZrnsiktsyuknbyutkyksyusis;
    }

    private String zrnsiktsyuknbyutkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKJYUKBN)
    public String getZrnsiktsyuknbyutkjyukbn() {
        return zrnsiktsyuknbyutkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyutkjyukbn(String pZrnsiktsyuknbyutkjyukbn) {
        zrnsiktsyuknbyutkjyukbn = pZrnsiktsyuknbyutkjyukbn;
    }

    private Integer zrnsiktsyuknbyutkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKJYRYMSHYTN)
    public Integer getZrnsiktsyuknbyutkjyrymshytn() {
        return zrnsiktsyuknbyutkjyrymshytn;
    }

    public void setZrnsiktsyuknbyutkjyrymshytn(Integer pZrnsiktsyuknbyutkjyrymshytn) {
        zrnsiktsyuknbyutkjyrymshytn = pZrnsiktsyuknbyutkjyrymshytn;
    }

    private Long zrnsiktsyuknbyutkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKJYUP)
    public Long getZrnsiktsyuknbyutkjyup() {
        return zrnsiktsyuknbyutkjyup;
    }

    public void setZrnsiktsyuknbyutkjyup(Long pZrnsiktsyuknbyutkjyup) {
        zrnsiktsyuknbyutkjyup = pZrnsiktsyuknbyutkjyup;
    }

    private String zrnsiktsyuknbyutktibicd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKTIBICD)
    public String getZrnsiktsyuknbyutktibicd() {
        return zrnsiktsyuknbyutktibicd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyutktibicd(String pZrnsiktsyuknbyutktibicd) {
        zrnsiktsyuknbyutktibicd = pZrnsiktsyuknbyutktibicd;
    }

    private String zrnsiktsyuknbyuhtnpkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUHTNPKKN)
    public String getZrnsiktsyuknbyuhtnpkkn() {
        return zrnsiktsyuknbyuhtnpkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyuhtnpkkn(String pZrnsiktsyuknbyuhtnpkkn) {
        zrnsiktsyuknbyuhtnpkkn = pZrnsiktsyuknbyuhtnpkkn;
    }

    private String zrnsiktsyuknbyutktibicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUTKTIBICDX2)
    public String getZrnsiktsyuknbyutktibicdx2() {
        return zrnsiktsyuknbyutktibicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyutktibicdx2(String pZrnsiktsyuknbyutktibicdx2) {
        zrnsiktsyuknbyutktibicdx2 = pZrnsiktsyuknbyutktibicdx2;
    }

    private String zrnsiktsyuknbyuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNSIKTSYUKNBYUHTNPKKNX2)
    public String getZrnsiktsyuknbyuhtnpkknx2() {
        return zrnsiktsyuknbyuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiktsyuknbyuhtnpkknx2(String pZrnsiktsyuknbyuhtnpkknx2) {
        zrnsiktsyuknbyuhtnpkknx2 = pZrnsiktsyuknbyuhtnpkknx2;
    }

    private String zrnyobiv19;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV19)
    public String getZrnyobiv19() {
        return zrnyobiv19;
    }

    public void setZrnyobiv19(String pZrnyobiv19) {
        zrnyobiv19 = pZrnyobiv19;
    }

    private String zrnhtnknsiktsynymrtisyrkg;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTISYRKG)
    public String getZrnhtnknsiktsynymrtisyrkg() {
        return zrnhtnknsiktsynymrtisyrkg;
    }

    public void setZrnhtnknsiktsynymrtisyrkg(String pZrnhtnknsiktsynymrtisyrkg) {
        zrnhtnknsiktsynymrtisyrkg = pZrnhtnknsiktsynymrtisyrkg;
    }

    private String zrnhtnknsiktsynykgusdikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYKGUSDIKBN)
    public String getZrnhtnknsiktsynykgusdikbn() {
        return zrnhtnknsiktsynykgusdikbn;
    }

    public void setZrnhtnknsiktsynykgusdikbn(String pZrnhtnknsiktsynykgusdikbn) {
        zrnhtnknsiktsynykgusdikbn = pZrnhtnknsiktsynykgusdikbn;
    }

    private String zrnhtnknsiktsynymrtikgyb;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYB)
    public String getZrnhtnknsiktsynymrtikgyb() {
        return zrnhtnknsiktsynymrtikgyb;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgyb(String pZrnhtnknsiktsynymrtikgyb) {
        zrnhtnknsiktsynymrtikgyb = pZrnhtnknsiktsynymrtikgyb;
    }

    private String zrnhtnknsiktsynymrtikgybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX2)
    public String getZrnhtnknsiktsynymrtikgybx2() {
        return zrnhtnknsiktsynymrtikgybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx2(String pZrnhtnknsiktsynymrtikgybx2) {
        zrnhtnknsiktsynymrtikgybx2 = pZrnhtnknsiktsynymrtikgybx2;
    }

    private String zrnhtnknsiktsynymrtikgybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX3)
    public String getZrnhtnknsiktsynymrtikgybx3() {
        return zrnhtnknsiktsynymrtikgybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx3(String pZrnhtnknsiktsynymrtikgybx3) {
        zrnhtnknsiktsynymrtikgybx3 = pZrnhtnknsiktsynymrtikgybx3;
    }

    private String zrnhtnknsiktsynymrtikgybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX4)
    public String getZrnhtnknsiktsynymrtikgybx4() {
        return zrnhtnknsiktsynymrtikgybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx4(String pZrnhtnknsiktsynymrtikgybx4) {
        zrnhtnknsiktsynymrtikgybx4 = pZrnhtnknsiktsynymrtikgybx4;
    }

    private String zrnhtnknsiktsynymrtikgybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX5)
    public String getZrnhtnknsiktsynymrtikgybx5() {
        return zrnhtnknsiktsynymrtikgybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx5(String pZrnhtnknsiktsynymrtikgybx5) {
        zrnhtnknsiktsynymrtikgybx5 = pZrnhtnknsiktsynymrtikgybx5;
    }

    private String zrnhtnknsiktsyknbytksyrkg;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKSYRKG)
    public String getZrnhtnknsiktsyknbytksyrkg() {
        return zrnhtnknsiktsyknbytksyrkg;
    }

    public void setZrnhtnknsiktsyknbytksyrkg(String pZrnhtnknsiktsyknbytksyrkg) {
        zrnhtnknsiktsyknbytksyrkg = pZrnhtnknsiktsyknbytksyrkg;
    }

    private String zrnhtnknsiktsyknbykgsdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYKGSDKBN)
    public String getZrnhtnknsiktsyknbykgsdkbn() {
        return zrnhtnknsiktsyknbykgsdkbn;
    }

    public void setZrnhtnknsiktsyknbykgsdkbn(String pZrnhtnknsiktsyknbykgsdkbn) {
        zrnhtnknsiktsyknbykgsdkbn = pZrnhtnknsiktsyknbykgsdkbn;
    }

    private String zrnhtnknsiktsyknbytkkgyb;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYB)
    public String getZrnhtnknsiktsyknbytkkgyb() {
        return zrnhtnknsiktsyknbytkkgyb;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgyb(String pZrnhtnknsiktsyknbytkkgyb) {
        zrnhtnknsiktsyknbytkkgyb = pZrnhtnknsiktsyknbytkkgyb;
    }

    private String zrnhtnknsiktsyknbytkkgybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX2)
    public String getZrnhtnknsiktsyknbytkkgybx2() {
        return zrnhtnknsiktsyknbytkkgybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx2(String pZrnhtnknsiktsyknbytkkgybx2) {
        zrnhtnknsiktsyknbytkkgybx2 = pZrnhtnknsiktsyknbytkkgybx2;
    }

    private String zrnhtnknsiktsyknbytkkgybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX3)
    public String getZrnhtnknsiktsyknbytkkgybx3() {
        return zrnhtnknsiktsyknbytkkgybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx3(String pZrnhtnknsiktsyknbytkkgybx3) {
        zrnhtnknsiktsyknbytkkgybx3 = pZrnhtnknsiktsyknbytkkgybx3;
    }

    private String zrnhtnknsiktsyknbytkkgybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX4)
    public String getZrnhtnknsiktsyknbytkkgybx4() {
        return zrnhtnknsiktsyknbytkkgybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx4(String pZrnhtnknsiktsyknbytkkgybx4) {
        zrnhtnknsiktsyknbytkkgybx4 = pZrnhtnknsiktsyknbytkkgybx4;
    }

    private String zrnhtnknsiktsyknbytkkgybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX5)
    public String getZrnhtnknsiktsyknbytkkgybx5() {
        return zrnhtnknsiktsyknbytkkgybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx5(String pZrnhtnknsiktsyknbytkkgybx5) {
        zrnhtnknsiktsyknbytkkgybx5 = pZrnhtnknsiktsyknbytkkgybx5;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private String zrnhtnknsiktsynymrtisyrkgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTISYRKGX2)
    public String getZrnhtnknsiktsynymrtisyrkgx2() {
        return zrnhtnknsiktsynymrtisyrkgx2;
    }

    public void setZrnhtnknsiktsynymrtisyrkgx2(String pZrnhtnknsiktsynymrtisyrkgx2) {
        zrnhtnknsiktsynymrtisyrkgx2 = pZrnhtnknsiktsynymrtisyrkgx2;
    }

    private String zrnhtnknsiktsynykgusdikbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYKGUSDIKBNX2)
    public String getZrnhtnknsiktsynykgusdikbnx2() {
        return zrnhtnknsiktsynykgusdikbnx2;
    }

    public void setZrnhtnknsiktsynykgusdikbnx2(String pZrnhtnknsiktsynykgusdikbnx2) {
        zrnhtnknsiktsynykgusdikbnx2 = pZrnhtnknsiktsynykgusdikbnx2;
    }

    private String zrnhtnknsiktsynymrtikgybx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX6)
    public String getZrnhtnknsiktsynymrtikgybx6() {
        return zrnhtnknsiktsynymrtikgybx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx6(String pZrnhtnknsiktsynymrtikgybx6) {
        zrnhtnknsiktsynymrtikgybx6 = pZrnhtnknsiktsynymrtikgybx6;
    }

    private String zrnhtnknsiktsynymrtikgybx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX7)
    public String getZrnhtnknsiktsynymrtikgybx7() {
        return zrnhtnknsiktsynymrtikgybx7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx7(String pZrnhtnknsiktsynymrtikgybx7) {
        zrnhtnknsiktsynymrtikgybx7 = pZrnhtnknsiktsynymrtikgybx7;
    }

    private String zrnhtnknsiktsynymrtikgybx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX8)
    public String getZrnhtnknsiktsynymrtikgybx8() {
        return zrnhtnknsiktsynymrtikgybx8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx8(String pZrnhtnknsiktsynymrtikgybx8) {
        zrnhtnknsiktsynymrtikgybx8 = pZrnhtnknsiktsynymrtikgybx8;
    }

    private String zrnhtnknsiktsynymrtikgybx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX9)
    public String getZrnhtnknsiktsynymrtikgybx9() {
        return zrnhtnknsiktsynymrtikgybx9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx9(String pZrnhtnknsiktsynymrtikgybx9) {
        zrnhtnknsiktsynymrtikgybx9 = pZrnhtnknsiktsynymrtikgybx9;
    }

    private String zrnhtnknsiktsynymrtikgybx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX10)
    public String getZrnhtnknsiktsynymrtikgybx10() {
        return zrnhtnknsiktsynymrtikgybx10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx10(String pZrnhtnknsiktsynymrtikgybx10) {
        zrnhtnknsiktsynymrtikgybx10 = pZrnhtnknsiktsynymrtikgybx10;
    }

    private String zrnhtnknsiktsyknbytksyrkgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKSYRKGX2)
    public String getZrnhtnknsiktsyknbytksyrkgx2() {
        return zrnhtnknsiktsyknbytksyrkgx2;
    }

    public void setZrnhtnknsiktsyknbytksyrkgx2(String pZrnhtnknsiktsyknbytksyrkgx2) {
        zrnhtnknsiktsyknbytksyrkgx2 = pZrnhtnknsiktsyknbytksyrkgx2;
    }

    private String zrnhtnknsiktsyknbykgsdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYKGSDKBNX2)
    public String getZrnhtnknsiktsyknbykgsdkbnx2() {
        return zrnhtnknsiktsyknbykgsdkbnx2;
    }

    public void setZrnhtnknsiktsyknbykgsdkbnx2(String pZrnhtnknsiktsyknbykgsdkbnx2) {
        zrnhtnknsiktsyknbykgsdkbnx2 = pZrnhtnknsiktsyknbykgsdkbnx2;
    }

    private String zrnhtnknsiktsyknbytkkgybx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX6)
    public String getZrnhtnknsiktsyknbytkkgybx6() {
        return zrnhtnknsiktsyknbytkkgybx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx6(String pZrnhtnknsiktsyknbytkkgybx6) {
        zrnhtnknsiktsyknbytkkgybx6 = pZrnhtnknsiktsyknbytkkgybx6;
    }

    private String zrnhtnknsiktsyknbytkkgybx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX7)
    public String getZrnhtnknsiktsyknbytkkgybx7() {
        return zrnhtnknsiktsyknbytkkgybx7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx7(String pZrnhtnknsiktsyknbytkkgybx7) {
        zrnhtnknsiktsyknbytkkgybx7 = pZrnhtnknsiktsyknbytkkgybx7;
    }

    private String zrnhtnknsiktsyknbytkkgybx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX8)
    public String getZrnhtnknsiktsyknbytkkgybx8() {
        return zrnhtnknsiktsyknbytkkgybx8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx8(String pZrnhtnknsiktsyknbytkkgybx8) {
        zrnhtnknsiktsyknbytkkgybx8 = pZrnhtnknsiktsyknbytkkgybx8;
    }

    private String zrnhtnknsiktsyknbytkkgybx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX9)
    public String getZrnhtnknsiktsyknbytkkgybx9() {
        return zrnhtnknsiktsyknbytkkgybx9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx9(String pZrnhtnknsiktsyknbytkkgybx9) {
        zrnhtnknsiktsyknbytkkgybx9 = pZrnhtnknsiktsyknbytkkgybx9;
    }

    private String zrnhtnknsiktsyknbytkkgybx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX10)
    public String getZrnhtnknsiktsyknbytkkgybx10() {
        return zrnhtnknsiktsyknbytkkgybx10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx10(String pZrnhtnknsiktsyknbytkkgybx10) {
        zrnhtnknsiktsyknbytkkgybx10 = pZrnhtnknsiktsyknbytkkgybx10;
    }

    private String zrnyobiv24x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV24X2)
    public String getZrnyobiv24x2() {
        return zrnyobiv24x2;
    }

    public void setZrnyobiv24x2(String pZrnyobiv24x2) {
        zrnyobiv24x2 = pZrnyobiv24x2;
    }

    private String zrnhtnknsiktsynymrtisyrkgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTISYRKGX3)
    public String getZrnhtnknsiktsynymrtisyrkgx3() {
        return zrnhtnknsiktsynymrtisyrkgx3;
    }

    public void setZrnhtnknsiktsynymrtisyrkgx3(String pZrnhtnknsiktsynymrtisyrkgx3) {
        zrnhtnknsiktsynymrtisyrkgx3 = pZrnhtnknsiktsynymrtisyrkgx3;
    }

    private String zrnhtnknsiktsynykgusdikbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYKGUSDIKBNX3)
    public String getZrnhtnknsiktsynykgusdikbnx3() {
        return zrnhtnknsiktsynykgusdikbnx3;
    }

    public void setZrnhtnknsiktsynykgusdikbnx3(String pZrnhtnknsiktsynykgusdikbnx3) {
        zrnhtnknsiktsynykgusdikbnx3 = pZrnhtnknsiktsynykgusdikbnx3;
    }

    private String zrnhtnknsiktsynymrtikgybx11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX11)
    public String getZrnhtnknsiktsynymrtikgybx11() {
        return zrnhtnknsiktsynymrtikgybx11;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx11(String pZrnhtnknsiktsynymrtikgybx11) {
        zrnhtnknsiktsynymrtikgybx11 = pZrnhtnknsiktsynymrtikgybx11;
    }

    private String zrnhtnknsiktsynymrtikgybx12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX12)
    public String getZrnhtnknsiktsynymrtikgybx12() {
        return zrnhtnknsiktsynymrtikgybx12;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx12(String pZrnhtnknsiktsynymrtikgybx12) {
        zrnhtnknsiktsynymrtikgybx12 = pZrnhtnknsiktsynymrtikgybx12;
    }

    private String zrnhtnknsiktsynymrtikgybx13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX13)
    public String getZrnhtnknsiktsynymrtikgybx13() {
        return zrnhtnknsiktsynymrtikgybx13;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx13(String pZrnhtnknsiktsynymrtikgybx13) {
        zrnhtnknsiktsynymrtikgybx13 = pZrnhtnknsiktsynymrtikgybx13;
    }

    private String zrnhtnknsiktsynymrtikgybx14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX14)
    public String getZrnhtnknsiktsynymrtikgybx14() {
        return zrnhtnknsiktsynymrtikgybx14;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx14(String pZrnhtnknsiktsynymrtikgybx14) {
        zrnhtnknsiktsynymrtikgybx14 = pZrnhtnknsiktsynymrtikgybx14;
    }

    private String zrnhtnknsiktsynymrtikgybx15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX15)
    public String getZrnhtnknsiktsynymrtikgybx15() {
        return zrnhtnknsiktsynymrtikgybx15;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx15(String pZrnhtnknsiktsynymrtikgybx15) {
        zrnhtnknsiktsynymrtikgybx15 = pZrnhtnknsiktsynymrtikgybx15;
    }

    private String zrnhtnknsiktsyknbytksyrkgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKSYRKGX3)
    public String getZrnhtnknsiktsyknbytksyrkgx3() {
        return zrnhtnknsiktsyknbytksyrkgx3;
    }

    public void setZrnhtnknsiktsyknbytksyrkgx3(String pZrnhtnknsiktsyknbytksyrkgx3) {
        zrnhtnknsiktsyknbytksyrkgx3 = pZrnhtnknsiktsyknbytksyrkgx3;
    }

    private String zrnhtnknsiktsyknbykgsdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYKGSDKBNX3)
    public String getZrnhtnknsiktsyknbykgsdkbnx3() {
        return zrnhtnknsiktsyknbykgsdkbnx3;
    }

    public void setZrnhtnknsiktsyknbykgsdkbnx3(String pZrnhtnknsiktsyknbykgsdkbnx3) {
        zrnhtnknsiktsyknbykgsdkbnx3 = pZrnhtnknsiktsyknbykgsdkbnx3;
    }

    private String zrnhtnknsiktsyknbytkkgybx11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX11)
    public String getZrnhtnknsiktsyknbytkkgybx11() {
        return zrnhtnknsiktsyknbytkkgybx11;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx11(String pZrnhtnknsiktsyknbytkkgybx11) {
        zrnhtnknsiktsyknbytkkgybx11 = pZrnhtnknsiktsyknbytkkgybx11;
    }

    private String zrnhtnknsiktsyknbytkkgybx12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX12)
    public String getZrnhtnknsiktsyknbytkkgybx12() {
        return zrnhtnknsiktsyknbytkkgybx12;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx12(String pZrnhtnknsiktsyknbytkkgybx12) {
        zrnhtnknsiktsyknbytkkgybx12 = pZrnhtnknsiktsyknbytkkgybx12;
    }

    private String zrnhtnknsiktsyknbytkkgybx13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX13)
    public String getZrnhtnknsiktsyknbytkkgybx13() {
        return zrnhtnknsiktsyknbytkkgybx13;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx13(String pZrnhtnknsiktsyknbytkkgybx13) {
        zrnhtnknsiktsyknbytkkgybx13 = pZrnhtnknsiktsyknbytkkgybx13;
    }

    private String zrnhtnknsiktsyknbytkkgybx14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX14)
    public String getZrnhtnknsiktsyknbytkkgybx14() {
        return zrnhtnknsiktsyknbytkkgybx14;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx14(String pZrnhtnknsiktsyknbytkkgybx14) {
        zrnhtnknsiktsyknbytkkgybx14 = pZrnhtnknsiktsyknbytkkgybx14;
    }

    private String zrnhtnknsiktsyknbytkkgybx15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX15)
    public String getZrnhtnknsiktsyknbytkkgybx15() {
        return zrnhtnknsiktsyknbytkkgybx15;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx15(String pZrnhtnknsiktsyknbytkkgybx15) {
        zrnhtnknsiktsyknbytkkgybx15 = pZrnhtnknsiktsyknbytkkgybx15;
    }

    private String zrnyobiv24x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV24X3)
    public String getZrnyobiv24x3() {
        return zrnyobiv24x3;
    }

    public void setZrnyobiv24x3(String pZrnyobiv24x3) {
        zrnyobiv24x3 = pZrnyobiv24x3;
    }

    private String zrnhtnknsiktsynymrtisyrkgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTISYRKGX4)
    public String getZrnhtnknsiktsynymrtisyrkgx4() {
        return zrnhtnknsiktsynymrtisyrkgx4;
    }

    public void setZrnhtnknsiktsynymrtisyrkgx4(String pZrnhtnknsiktsynymrtisyrkgx4) {
        zrnhtnknsiktsynymrtisyrkgx4 = pZrnhtnknsiktsynymrtisyrkgx4;
    }

    private String zrnhtnknsiktsynykgusdikbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYKGUSDIKBNX4)
    public String getZrnhtnknsiktsynykgusdikbnx4() {
        return zrnhtnknsiktsynykgusdikbnx4;
    }

    public void setZrnhtnknsiktsynykgusdikbnx4(String pZrnhtnknsiktsynykgusdikbnx4) {
        zrnhtnknsiktsynykgusdikbnx4 = pZrnhtnknsiktsynykgusdikbnx4;
    }

    private String zrnhtnknsiktsynymrtikgybx16;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX16)
    public String getZrnhtnknsiktsynymrtikgybx16() {
        return zrnhtnknsiktsynymrtikgybx16;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx16(String pZrnhtnknsiktsynymrtikgybx16) {
        zrnhtnknsiktsynymrtikgybx16 = pZrnhtnknsiktsynymrtikgybx16;
    }

    private String zrnhtnknsiktsynymrtikgybx17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX17)
    public String getZrnhtnknsiktsynymrtikgybx17() {
        return zrnhtnknsiktsynymrtikgybx17;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx17(String pZrnhtnknsiktsynymrtikgybx17) {
        zrnhtnknsiktsynymrtikgybx17 = pZrnhtnknsiktsynymrtikgybx17;
    }

    private String zrnhtnknsiktsynymrtikgybx18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX18)
    public String getZrnhtnknsiktsynymrtikgybx18() {
        return zrnhtnknsiktsynymrtikgybx18;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx18(String pZrnhtnknsiktsynymrtikgybx18) {
        zrnhtnknsiktsynymrtikgybx18 = pZrnhtnknsiktsynymrtikgybx18;
    }

    private String zrnhtnknsiktsynymrtikgybx19;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX19)
    public String getZrnhtnknsiktsynymrtikgybx19() {
        return zrnhtnknsiktsynymrtikgybx19;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx19(String pZrnhtnknsiktsynymrtikgybx19) {
        zrnhtnknsiktsynymrtikgybx19 = pZrnhtnknsiktsynymrtikgybx19;
    }

    private String zrnhtnknsiktsynymrtikgybx20;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX20)
    public String getZrnhtnknsiktsynymrtikgybx20() {
        return zrnhtnknsiktsynymrtikgybx20;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx20(String pZrnhtnknsiktsynymrtikgybx20) {
        zrnhtnknsiktsynymrtikgybx20 = pZrnhtnknsiktsynymrtikgybx20;
    }

    private String zrnhtnknsiktsyknbytksyrkgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKSYRKGX4)
    public String getZrnhtnknsiktsyknbytksyrkgx4() {
        return zrnhtnknsiktsyknbytksyrkgx4;
    }

    public void setZrnhtnknsiktsyknbytksyrkgx4(String pZrnhtnknsiktsyknbytksyrkgx4) {
        zrnhtnknsiktsyknbytksyrkgx4 = pZrnhtnknsiktsyknbytksyrkgx4;
    }

    private String zrnhtnknsiktsyknbykgsdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYKGSDKBNX4)
    public String getZrnhtnknsiktsyknbykgsdkbnx4() {
        return zrnhtnknsiktsyknbykgsdkbnx4;
    }

    public void setZrnhtnknsiktsyknbykgsdkbnx4(String pZrnhtnknsiktsyknbykgsdkbnx4) {
        zrnhtnknsiktsyknbykgsdkbnx4 = pZrnhtnknsiktsyknbykgsdkbnx4;
    }

    private String zrnhtnknsiktsyknbytkkgybx16;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX16)
    public String getZrnhtnknsiktsyknbytkkgybx16() {
        return zrnhtnknsiktsyknbytkkgybx16;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx16(String pZrnhtnknsiktsyknbytkkgybx16) {
        zrnhtnknsiktsyknbytkkgybx16 = pZrnhtnknsiktsyknbytkkgybx16;
    }

    private String zrnhtnknsiktsyknbytkkgybx17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX17)
    public String getZrnhtnknsiktsyknbytkkgybx17() {
        return zrnhtnknsiktsyknbytkkgybx17;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx17(String pZrnhtnknsiktsyknbytkkgybx17) {
        zrnhtnknsiktsyknbytkkgybx17 = pZrnhtnknsiktsyknbytkkgybx17;
    }

    private String zrnhtnknsiktsyknbytkkgybx18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX18)
    public String getZrnhtnknsiktsyknbytkkgybx18() {
        return zrnhtnknsiktsyknbytkkgybx18;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx18(String pZrnhtnknsiktsyknbytkkgybx18) {
        zrnhtnknsiktsyknbytkkgybx18 = pZrnhtnknsiktsyknbytkkgybx18;
    }

    private String zrnhtnknsiktsyknbytkkgybx19;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX19)
    public String getZrnhtnknsiktsyknbytkkgybx19() {
        return zrnhtnknsiktsyknbytkkgybx19;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx19(String pZrnhtnknsiktsyknbytkkgybx19) {
        zrnhtnknsiktsyknbytkkgybx19 = pZrnhtnknsiktsyknbytkkgybx19;
    }

    private String zrnhtnknsiktsyknbytkkgybx20;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX20)
    public String getZrnhtnknsiktsyknbytkkgybx20() {
        return zrnhtnknsiktsyknbytkkgybx20;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx20(String pZrnhtnknsiktsyknbytkkgybx20) {
        zrnhtnknsiktsyknbytkkgybx20 = pZrnhtnknsiktsyknbytkkgybx20;
    }

    private String zrnyobiv24x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV24X4)
    public String getZrnyobiv24x4() {
        return zrnyobiv24x4;
    }

    public void setZrnyobiv24x4(String pZrnyobiv24x4) {
        zrnyobiv24x4 = pZrnyobiv24x4;
    }

    private String zrnhtnknsiktsynymrtisyrkgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTISYRKGX5)
    public String getZrnhtnknsiktsynymrtisyrkgx5() {
        return zrnhtnknsiktsynymrtisyrkgx5;
    }

    public void setZrnhtnknsiktsynymrtisyrkgx5(String pZrnhtnknsiktsynymrtisyrkgx5) {
        zrnhtnknsiktsynymrtisyrkgx5 = pZrnhtnknsiktsynymrtisyrkgx5;
    }

    private String zrnhtnknsiktsynykgusdikbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYKGUSDIKBNX5)
    public String getZrnhtnknsiktsynykgusdikbnx5() {
        return zrnhtnknsiktsynykgusdikbnx5;
    }

    public void setZrnhtnknsiktsynykgusdikbnx5(String pZrnhtnknsiktsynykgusdikbnx5) {
        zrnhtnknsiktsynykgusdikbnx5 = pZrnhtnknsiktsynykgusdikbnx5;
    }

    private String zrnhtnknsiktsynymrtikgybx21;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX21)
    public String getZrnhtnknsiktsynymrtikgybx21() {
        return zrnhtnknsiktsynymrtikgybx21;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx21(String pZrnhtnknsiktsynymrtikgybx21) {
        zrnhtnknsiktsynymrtikgybx21 = pZrnhtnknsiktsynymrtikgybx21;
    }

    private String zrnhtnknsiktsynymrtikgybx22;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX22)
    public String getZrnhtnknsiktsynymrtikgybx22() {
        return zrnhtnknsiktsynymrtikgybx22;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx22(String pZrnhtnknsiktsynymrtikgybx22) {
        zrnhtnknsiktsynymrtikgybx22 = pZrnhtnknsiktsynymrtikgybx22;
    }

    private String zrnhtnknsiktsynymrtikgybx23;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX23)
    public String getZrnhtnknsiktsynymrtikgybx23() {
        return zrnhtnknsiktsynymrtikgybx23;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx23(String pZrnhtnknsiktsynymrtikgybx23) {
        zrnhtnknsiktsynymrtikgybx23 = pZrnhtnknsiktsynymrtikgybx23;
    }

    private String zrnhtnknsiktsynymrtikgybx24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX24)
    public String getZrnhtnknsiktsynymrtikgybx24() {
        return zrnhtnknsiktsynymrtikgybx24;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx24(String pZrnhtnknsiktsynymrtikgybx24) {
        zrnhtnknsiktsynymrtikgybx24 = pZrnhtnknsiktsynymrtikgybx24;
    }

    private String zrnhtnknsiktsynymrtikgybx25;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX25)
    public String getZrnhtnknsiktsynymrtikgybx25() {
        return zrnhtnknsiktsynymrtikgybx25;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx25(String pZrnhtnknsiktsynymrtikgybx25) {
        zrnhtnknsiktsynymrtikgybx25 = pZrnhtnknsiktsynymrtikgybx25;
    }

    private String zrnhtnknsiktsyknbytksyrkgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKSYRKGX5)
    public String getZrnhtnknsiktsyknbytksyrkgx5() {
        return zrnhtnknsiktsyknbytksyrkgx5;
    }

    public void setZrnhtnknsiktsyknbytksyrkgx5(String pZrnhtnknsiktsyknbytksyrkgx5) {
        zrnhtnknsiktsyknbytksyrkgx5 = pZrnhtnknsiktsyknbytksyrkgx5;
    }

    private String zrnhtnknsiktsyknbykgsdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYKGSDKBNX5)
    public String getZrnhtnknsiktsyknbykgsdkbnx5() {
        return zrnhtnknsiktsyknbykgsdkbnx5;
    }

    public void setZrnhtnknsiktsyknbykgsdkbnx5(String pZrnhtnknsiktsyknbykgsdkbnx5) {
        zrnhtnknsiktsyknbykgsdkbnx5 = pZrnhtnknsiktsyknbykgsdkbnx5;
    }

    private String zrnhtnknsiktsyknbytkkgybx21;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX21)
    public String getZrnhtnknsiktsyknbytkkgybx21() {
        return zrnhtnknsiktsyknbytkkgybx21;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx21(String pZrnhtnknsiktsyknbytkkgybx21) {
        zrnhtnknsiktsyknbytkkgybx21 = pZrnhtnknsiktsyknbytkkgybx21;
    }

    private String zrnhtnknsiktsyknbytkkgybx22;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX22)
    public String getZrnhtnknsiktsyknbytkkgybx22() {
        return zrnhtnknsiktsyknbytkkgybx22;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx22(String pZrnhtnknsiktsyknbytkkgybx22) {
        zrnhtnknsiktsyknbytkkgybx22 = pZrnhtnknsiktsyknbytkkgybx22;
    }

    private String zrnhtnknsiktsyknbytkkgybx23;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX23)
    public String getZrnhtnknsiktsyknbytkkgybx23() {
        return zrnhtnknsiktsyknbytkkgybx23;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx23(String pZrnhtnknsiktsyknbytkkgybx23) {
        zrnhtnknsiktsyknbytkkgybx23 = pZrnhtnknsiktsyknbytkkgybx23;
    }

    private String zrnhtnknsiktsyknbytkkgybx24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX24)
    public String getZrnhtnknsiktsyknbytkkgybx24() {
        return zrnhtnknsiktsyknbytkkgybx24;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx24(String pZrnhtnknsiktsyknbytkkgybx24) {
        zrnhtnknsiktsyknbytkkgybx24 = pZrnhtnknsiktsyknbytkkgybx24;
    }

    private String zrnhtnknsiktsyknbytkkgybx25;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX25)
    public String getZrnhtnknsiktsyknbytkkgybx25() {
        return zrnhtnknsiktsyknbytkkgybx25;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx25(String pZrnhtnknsiktsyknbytkkgybx25) {
        zrnhtnknsiktsyknbytkkgybx25 = pZrnhtnknsiktsyknbytkkgybx25;
    }

    private String zrnyobiv24x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV24X5)
    public String getZrnyobiv24x5() {
        return zrnyobiv24x5;
    }

    public void setZrnyobiv24x5(String pZrnyobiv24x5) {
        zrnyobiv24x5 = pZrnyobiv24x5;
    }

    private String zrnhtnknsiktsynymrtisyrkgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTISYRKGX6)
    public String getZrnhtnknsiktsynymrtisyrkgx6() {
        return zrnhtnknsiktsynymrtisyrkgx6;
    }

    public void setZrnhtnknsiktsynymrtisyrkgx6(String pZrnhtnknsiktsynymrtisyrkgx6) {
        zrnhtnknsiktsynymrtisyrkgx6 = pZrnhtnknsiktsynymrtisyrkgx6;
    }

    private String zrnhtnknsiktsynykgusdikbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYKGUSDIKBNX6)
    public String getZrnhtnknsiktsynykgusdikbnx6() {
        return zrnhtnknsiktsynykgusdikbnx6;
    }

    public void setZrnhtnknsiktsynykgusdikbnx6(String pZrnhtnknsiktsynykgusdikbnx6) {
        zrnhtnknsiktsynykgusdikbnx6 = pZrnhtnknsiktsynykgusdikbnx6;
    }

    private String zrnhtnknsiktsynymrtikgybx26;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX26)
    public String getZrnhtnknsiktsynymrtikgybx26() {
        return zrnhtnknsiktsynymrtikgybx26;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx26(String pZrnhtnknsiktsynymrtikgybx26) {
        zrnhtnknsiktsynymrtikgybx26 = pZrnhtnknsiktsynymrtikgybx26;
    }

    private String zrnhtnknsiktsynymrtikgybx27;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX27)
    public String getZrnhtnknsiktsynymrtikgybx27() {
        return zrnhtnknsiktsynymrtikgybx27;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx27(String pZrnhtnknsiktsynymrtikgybx27) {
        zrnhtnknsiktsynymrtikgybx27 = pZrnhtnknsiktsynymrtikgybx27;
    }

    private String zrnhtnknsiktsynymrtikgybx28;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX28)
    public String getZrnhtnknsiktsynymrtikgybx28() {
        return zrnhtnknsiktsynymrtikgybx28;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx28(String pZrnhtnknsiktsynymrtikgybx28) {
        zrnhtnknsiktsynymrtikgybx28 = pZrnhtnknsiktsynymrtikgybx28;
    }

    private String zrnhtnknsiktsynymrtikgybx29;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX29)
    public String getZrnhtnknsiktsynymrtikgybx29() {
        return zrnhtnknsiktsynymrtikgybx29;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx29(String pZrnhtnknsiktsynymrtikgybx29) {
        zrnhtnknsiktsynymrtikgybx29 = pZrnhtnknsiktsynymrtikgybx29;
    }

    private String zrnhtnknsiktsynymrtikgybx30;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYNYMRTIKGYBX30)
    public String getZrnhtnknsiktsynymrtikgybx30() {
        return zrnhtnknsiktsynymrtikgybx30;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsynymrtikgybx30(String pZrnhtnknsiktsynymrtikgybx30) {
        zrnhtnknsiktsynymrtikgybx30 = pZrnhtnknsiktsynymrtikgybx30;
    }

    private String zrnhtnknsiktsyknbytksyrkgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKSYRKGX6)
    public String getZrnhtnknsiktsyknbytksyrkgx6() {
        return zrnhtnknsiktsyknbytksyrkgx6;
    }

    public void setZrnhtnknsiktsyknbytksyrkgx6(String pZrnhtnknsiktsyknbytksyrkgx6) {
        zrnhtnknsiktsyknbytksyrkgx6 = pZrnhtnknsiktsyknbytksyrkgx6;
    }

    private String zrnhtnknsiktsyknbykgsdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYKGSDKBNX6)
    public String getZrnhtnknsiktsyknbykgsdkbnx6() {
        return zrnhtnknsiktsyknbykgsdkbnx6;
    }

    public void setZrnhtnknsiktsyknbykgsdkbnx6(String pZrnhtnknsiktsyknbykgsdkbnx6) {
        zrnhtnknsiktsyknbykgsdkbnx6 = pZrnhtnknsiktsyknbykgsdkbnx6;
    }

    private String zrnhtnknsiktsyknbytkkgybx26;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX26)
    public String getZrnhtnknsiktsyknbytkkgybx26() {
        return zrnhtnknsiktsyknbytkkgybx26;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx26(String pZrnhtnknsiktsyknbytkkgybx26) {
        zrnhtnknsiktsyknbytkkgybx26 = pZrnhtnknsiktsyknbytkkgybx26;
    }

    private String zrnhtnknsiktsyknbytkkgybx27;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX27)
    public String getZrnhtnknsiktsyknbytkkgybx27() {
        return zrnhtnknsiktsyknbytkkgybx27;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx27(String pZrnhtnknsiktsyknbytkkgybx27) {
        zrnhtnknsiktsyknbytkkgybx27 = pZrnhtnknsiktsyknbytkkgybx27;
    }

    private String zrnhtnknsiktsyknbytkkgybx28;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX28)
    public String getZrnhtnknsiktsyknbytkkgybx28() {
        return zrnhtnknsiktsyknbytkkgybx28;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx28(String pZrnhtnknsiktsyknbytkkgybx28) {
        zrnhtnknsiktsyknbytkkgybx28 = pZrnhtnknsiktsyknbytkkgybx28;
    }

    private String zrnhtnknsiktsyknbytkkgybx29;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX29)
    public String getZrnhtnknsiktsyknbytkkgybx29() {
        return zrnhtnknsiktsyknbytkkgybx29;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx29(String pZrnhtnknsiktsyknbytkkgybx29) {
        zrnhtnknsiktsyknbytkkgybx29 = pZrnhtnknsiktsyknbytkkgybx29;
    }

    private String zrnhtnknsiktsyknbytkkgybx30;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNHTNKNSIKTSYKNBYTKKGYBX30)
    public String getZrnhtnknsiktsyknbytkkgybx30() {
        return zrnhtnknsiktsyknbytkkgybx30;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknsiktsyknbytkkgybx30(String pZrnhtnknsiktsyknbytkkgybx30) {
        zrnhtnknsiktsyknbytkkgybx30 = pZrnhtnknsiktsyknbytkkgybx30;
    }

    private String zrnyobiv24x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV24X6)
    public String getZrnyobiv24x6() {
        return zrnyobiv24x6;
    }

    public void setZrnyobiv24x6(String pZrnyobiv24x6) {
        zrnyobiv24x6 = pZrnyobiv24x6;
    }

    private BizNumber zrnkaiyakuhrmkhritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNKAIYAKUHRMKHRITU)
    public BizNumber getZrnkaiyakuhrmkhritu() {
        return zrnkaiyakuhrmkhritu;
    }

    public void setZrnkaiyakuhrmkhritu(BizNumber pZrnkaiyakuhrmkhritu) {
        zrnkaiyakuhrmkhritu = pZrnkaiyakuhrmkhritu;
    }

    private BizNumber zrntumitatekinitenmkhyurt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNTUMITATEKINITENMKHYURT)
    public BizNumber getZrntumitatekinitenmkhyurt() {
        return zrntumitatekinitenmkhyurt;
    }

    public void setZrntumitatekinitenmkhyurt(BizNumber pZrntumitatekinitenmkhyurt) {
        zrntumitatekinitenmkhyurt = pZrntumitatekinitenmkhyurt;
    }

    private String zrnyobiv250;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV250)
    public String getZrnyobiv250() {
        return zrnyobiv250;
    }

    public void setZrnyobiv250(String pZrnyobiv250) {
        zrnyobiv250 = pZrnyobiv250;
    }

    private String zrnyobiv248;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Rn.ZRNYOBIV248)
    public String getZrnyobiv248() {
        return zrnyobiv248;
    }

    public void setZrnyobiv248(String pZrnyobiv248) {
        zrnyobiv248 = pZrnyobiv248;
    }
}