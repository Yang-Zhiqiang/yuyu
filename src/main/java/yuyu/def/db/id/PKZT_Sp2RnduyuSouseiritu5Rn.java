package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.mapping.GenZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu5Rn;

/**
 * ＳＰ２連動用総成立Fテーブル５（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu5Rn}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル５（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnktgysyrymd</td><td>（連携用）結合用処理日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnktgyfilerenno</td><td>（連携用）結合用ファイル連番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaisyabosyuudirtncd</td><td>（連携用）Ａ扱者募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatukaisyabosyuudirtncd</td><td>（連携用）Ｂ扱者募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukeitaikbn</td><td>（連携用）募集形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkessankeijyouym</td><td>（連携用）決算計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnkntmttsyusnhknarihyj</td><td>（連携用）被転換積立終身保険有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokubetuhosyoukikan</td><td>（連携用）特別保障期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoukeinenbaraikansanp3x1</td><td>（連携用）合計年払換算Ｐ３＿１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhktgtikkikkkn3x1</td><td>（連携用）引継定期経過期間３＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkappadhktgkujygkx1</td><td>（連携用）カッパーＤ引継控除額＿１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeinenbaraikansanp3x2</td><td>（連携用）合計年払換算Ｐ３＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhktgtikkikkkn3x2</td><td>（連携用）引継定期経過期間３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkappadhktgkujygkx2</td><td>（連携用）カッパーＤ引継控除額＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeinenbaraikansanp3x3</td><td>（連携用）合計年払換算Ｐ３＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhktgtikkikkkn3x3</td><td>（連携用）引継定期経過期間３＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkappadhktgkujygkx3</td><td>（連携用）カッパーＤ引継控除額＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeinenbaraikansanp3x4</td><td>（連携用）合計年払換算Ｐ３＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhktgtikkikkkn3x4</td><td>（連携用）引継定期経過期間３＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkappadhktgkujygkx4</td><td>（連携用）カッパーＤ引継控除額＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeinenbaraikansanp3x5</td><td>（連携用）合計年払換算Ｐ３＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhktgtikkikkkn3x5</td><td>（連携用）引継定期経過期間３＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkappadhktgkujygkx5</td><td>（連携用）カッパーＤ引継控除額＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeinenbaraikansanp3x6</td><td>（連携用）合計年払換算Ｐ３＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhktgtikkikkkn3x6</td><td>（連携用）引継定期経過期間３＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkappadhktgkujygkx6</td><td>（連携用）カッパーＤ引継控除額＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhutihnnnkknnzmkyksyono</td><td>（連携用）法定本人確認済契約証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosnyuuryokuymd</td><td>（連携用）申込入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyosakuseiymd</td><td>（連携用）申込書作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2kokutiymd</td><td>（連携用）第２告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuuryousyouryakukbn</td><td>（連携用）充領省略区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkyksyuruikgu</td><td>（連携用）先進医療特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsensiniryoutokuyakukikan</td><td>（連携用）先進医療特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsensiniryoutkykphrkkkn</td><td>（連携用）先進医療特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsensiniryoutokuyakus</td><td>（連携用）先進医療特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsensiniryoutokuyakup</td><td>（連携用）先進医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsensiniryoutkykkgusdkbn</td><td>（連携用）先進医療特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykkguybx1</td><td>（連携用）先進医療特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykkguybx2</td><td>（連携用）先進医療特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykkguybx3</td><td>（連携用）先進医療特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykkguybx4</td><td>（連携用）先進医療特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykkguybx5</td><td>（連携用）先進医療特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykpwrbkkbn</td><td>（連携用）先進医療特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutktbicdx1</td><td>（連携用）先進医療特定部位コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryuhtnpkknx1</td><td>（連携用）先進医療不担保期間＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutktbicdx2</td><td>（連携用）先進医療特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryuhtnpkknx2</td><td>（連携用）先進医療不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsnsniryutkykkusnmnryoage</td><td>（連携用）先進医療特約更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv4x17</td><td>（連携用）予備項目Ｖ４＿１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkyksyrikgu</td><td>（連携用）第２先進医療特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykkkn</td><td>（連携用）第２先進医療特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2snsniryutkykphrkkkn</td><td>（連携用）第２先進医療特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2sensiniryoutokuyakus</td><td>（連携用）第２先進医療特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndai2sensiniryoutokuyakup</td><td>（連携用）第２先進医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndi2snsniryutkykkgusdkbn</td><td>（連携用）第２先進医療特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykkguybx1</td><td>（連携用）第２先進医療特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykkguybx2</td><td>（連携用）第２先進医療特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykkguybx3</td><td>（連携用）第２先進医療特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykkguybx4</td><td>（連携用）第２先進医療特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykkguybx5</td><td>（連携用）第２先進医療特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutkykpwrbkkbn</td><td>（連携用）第２先進医療特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutktbicdx1</td><td>（連携用）第２先進医療特定部位コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryuhtnpkknx1</td><td>（連携用）第２先進医療不担保期間＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryutktbicdx2</td><td>（連携用）第２先進医療特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2snsniryuhtnpkknx2</td><td>（連携用）第２先進医療不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6x3</td><td>（連携用）予備項目Ｖ６＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnentysihyj</td><td>（連携用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaagetyouseihyj</td><td>（連携用）契約者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnentysihyj</td><td>（連携用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhsyumnosjdftmttzndk</td><td>（連携用）保障見直時ＤＦ積立残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnyuinhsyujyjttkyksyrikgu</td><td>（連携用）入院保障充実特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyujttkykkkn</td><td>（連携用）入院保障充実特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyinhsyjyjttkykphrkkkn</td><td>（連携用）入院保障充実特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyujttkyks</td><td>（連携用）入院保障充実特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnyuinhsyujyujttkykp</td><td>（連携用）入院保障充実特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnyinhsyjyjttkjyrymshytn</td><td>（連携用）入院保障充実特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnnyuinhsyujyujttkyktkjyup</td><td>（連携用）入院保障充実特約特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnyuinhsyujyujttktbicdx1</td><td>（連携用）入院保障充実特定部位コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyujthtnpkknx1</td><td>（連携用）入院保障充実不担保期間＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyujttktbicdx2</td><td>（連携用）入院保障充実特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyujthtnpkknx2</td><td>（連携用）入院保障充実不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyinhsyjyjttkykkgusdkbn</td><td>（連携用）入院保障充実特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyinhsyjyjttkykpwrbkkbn</td><td>（連携用）入院保障充実特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyjttkykkguybx1</td><td>（連携用）入院保障充実特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyjttkykkguybx2</td><td>（連携用）入院保障充実特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyjttkykkguybx3</td><td>（連携用）入院保障充実特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyjttkykkguybx4</td><td>（連携用）入院保障充実特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuinhsyujyjttkykkguybx5</td><td>（連携用）入院保障充実特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyinhsyjyjtkykksnmnryage</td><td>（連携用）入院保障充実特約更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv5x4</td><td>（連携用）予備項目Ｖ５＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyjyjttkyksyrikg</td><td>（連携用）第２入院保障充実特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyujyujttkykkkn</td><td>（連携用）第２入院保障充実特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyujyjtphrkkkn</td><td>（連携用）第２入院保障充実Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyujyujttkyks</td><td>（連携用）第２入院保障充実特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndi2nyuinhsyujyujttkykp</td><td>（連携用）第２入院保障充実特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndi2nyhsyjyjttkjyrymshytn</td><td>（連携用）第２入院保障充実特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndi2nyuinhsyujyujttkjyup</td><td>（連携用）第２入院保障充実特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndi2nyuinhsyutktbicdx1</td><td>（連携用）第２入院保障特定部位コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyuhtnpkknx1</td><td>（連携用）第２入院保障不担保期間＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyutktbicdx2</td><td>（連携用）第２入院保障特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyuhtnpkknx2</td><td>（連携用）第２入院保障不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyujyjtkgusdkbn</td><td>（連携用）第２入院保障充実記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyuinhsyujyjtpwrbkkbn</td><td>（連携用）第２入院保障充実Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyjyjttkykkgybx1</td><td>（連携用）第２入院保障充実特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyjyjttkykkgybx2</td><td>（連携用）第２入院保障充実特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyjyjttkykkgybx3</td><td>（連携用）第２入院保障充実特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyjyjttkykkgybx4</td><td>（連携用）第２入院保障充実特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2nyinhsyjyjttkykkgybx5</td><td>（連携用）第２入院保障充実特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv7x6</td><td>（連携用）予備項目Ｖ７＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x4</td><td>（連携用）予備項目Ｖ１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwnasitnknkakakujyutukbn</td><td>（連携用）Ｗなし転換価格充当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoukeiwnasitenkankakaku</td><td>（連携用）合計Ｗなし転換価格</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngukiwnstnknitjbrnknengk</td><td>（連携用）合計Ｗなし転換一時払年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngukiwnasitnknitjbrtiks</td><td>（連携用）合計Ｗなし転換一時払定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv9x11</td><td>（連携用）予備項目Ｖ９＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkyksyuruikgu</td><td>（連携用）総合医療特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsougouiryoutokuyakukikan</td><td>（連携用）総合医療特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykphrkkkn</td><td>（連携用）総合医療特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykntgk</td><td>（連携用）総合医療特約日額</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsougouiryoutokuyakup</td><td>（連携用）総合医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsuguiryutkjyuryumshyutn</td><td>（連携用）総合医療特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsougouiryoutokujyoup</td><td>（連携用）総合医療特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsuguiryutktbicdx1</td><td>（連携用）総合医療特定部位コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryuhtnpkknx1</td><td>（連携用）総合医療不担保期間＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutktbicdx2</td><td>（連携用）総合医療特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryuhtnpkknx2</td><td>（連携用）総合医療不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkgusdkbn</td><td>（連携用）総合医療特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykpwrbkkbn</td><td>（連携用）総合医療特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkguybx1</td><td>（連携用）総合医療特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkguybx2</td><td>（連携用）総合医療特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkguybx3</td><td>（連携用）総合医療特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkguybx4</td><td>（連携用）総合医療特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkguybx5</td><td>（連携用）総合医療特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuguiryutkykkusnmnryoage</td><td>（連携用）総合医療特約更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv7x7</td><td>（連携用）予備項目Ｖ７＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkyksyrikgu</td><td>（連携用）第２総合医療特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkkn</td><td>（連携用）第２総合医療特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykphrkkkn</td><td>（連携用）第２総合医療特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykntgk</td><td>（連携用）第２総合医療特約日額</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndai2sougouiryoutokuyakup</td><td>（連携用）第２総合医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndi2suguiryutkjyurymshytn</td><td>（連携用）第２総合医療特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndai2sougouiryoutokujyoup</td><td>（連携用）第２総合医療特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndi2suguiryutktbicdx1</td><td>（連携用）第２総合医療特定部位コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryuhtnpkknx1</td><td>（連携用）第２総合医療不担保期間＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutktbicdx2</td><td>（連携用）第２総合医療特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryuhtnpkknx2</td><td>（連携用）第２総合医療不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkgusdkbn</td><td>（連携用）第２総合医療特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykpwrbkkbn</td><td>（連携用）第２総合医療特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkguybx1</td><td>（連携用）第２総合医療特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkguybx2</td><td>（連携用）第２総合医療特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkguybx3</td><td>（連携用）第２総合医療特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkguybx4</td><td>（連携用）第２総合医療特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2suguiryutkykkguybx5</td><td>（連携用）第２総合医療特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9x12</td><td>（連携用）予備項目Ｖ９＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2gannyuintkyksyrikgu</td><td>（連携用）第２がん入院特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2gannyuintkykkkn</td><td>（連携用）第２がん入院特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2gannyuintkykphrkkkn</td><td>（連携用）第２がん入院特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2gannyuintkykntgk</td><td>（連携用）第２がん入院特約日額</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndai2gannyuuintokuyakup</td><td>（連携用）第２がん入院特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndai2gannyuintkykkgusdkbn</td><td>（連携用）第２がん入院特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2gannyuintkykkguyobix1</td><td>（連携用）第２がん入院特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2gannyuintkykkguyobix2</td><td>（連携用）第２がん入院特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2gannyuintkykkguyobix3</td><td>（連携用）第２がん入院特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2gannyuintkykkguyobix4</td><td>（連携用）第２がん入院特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2gannyuintkykkguyobix5</td><td>（連携用）第２がん入院特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2gannyuintkykpwrbkkbn</td><td>（連携用）第２がん入院特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6x4</td><td>（連携用）予備項目Ｖ６＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngukihtnknsuguirytkykntgk</td><td>（連携用）合計被転換総合医療特約日額</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnhijynbrimarusyuusyrikgu</td><td>（連携用）平準払マル終種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimrsyukgusdkbn</td><td>（連携用）平準払マル終記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuukguybx1</td><td>（連携用）平準払マル終記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuukguybx2</td><td>（連携用）平準払マル終記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuukguybx3</td><td>（連携用）平準払マル終記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuukguybx4</td><td>（連携用）平準払マル終記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuukguybx5</td><td>（連携用）平準払マル終記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuukkn</td><td>（連携用）平準払マル終期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimrsyphrkkkn</td><td>（連携用）平準払マル終Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuutkyks</td><td>（連携用）平準払マル終特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhijynbrimarusyuutkykp</td><td>（連携用）平準払マル終特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhijynbrimrsypwrbkkbn</td><td>（連携用）平準払マル終Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimarusyuumods</td><td>（連携用）平準払マル終修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhijynbrimarusyuutkjyukbn</td><td>（連携用）平準払マル終特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrimrsytkjyuskgnkkn</td><td>（連携用）平準払マル終特条削減期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhijynbrmrsytkjyurymshytn</td><td>（連携用）平準払マル終特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnhijynbrimarusyuutkjyup</td><td>（連携用）平準払マル終特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhijynbrmrsytnknygryrtkbn</td><td>（連携用）平準払マル終転換優遇料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv4x18</td><td>（連携用）予備項目Ｖ４＿１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuteijyoutaihushrhyj</td><td>（連携用）特定状態不支払表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosjikaigos</td><td>（連携用）申込時介護Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmosjidi2hknkknsyuusns</td><td>（連携用）申込時第２保険期間終身Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngansndntkyksyrikgu</td><td>（連携用）がん診断特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykkgusdkbn</td><td>（連携用）がん診断特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykkguybx1</td><td>（連携用）がん診断特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykkguybx2</td><td>（連携用）がん診断特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykkguybx3</td><td>（連携用）がん診断特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykkguybx4</td><td>（連携用）がん診断特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykkguybx5</td><td>（連携用）がん診断特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansindantokuyakukikan</td><td>（連携用）がん診断特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkykphrkkkn</td><td>（連携用）がん診断特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansindantokuyakus</td><td>（連携用）がん診断特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngansindantokuyakup</td><td>（連携用）がん診断特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngansndntkykpwrbkkbn</td><td>（連携用）がん診断特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngansndntkyktaikknbbns</td><td>（連携用）がん診断特約待期間部分Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnjyouhinaiganmtkknbbns</td><td>（連携用）上皮内がん待期間部分Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngnsndntkykkusnmnryoage</td><td>（連携用）がん診断特約更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x5</td><td>（連携用）予備項目Ｖ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkyksyrikgu</td><td>（連携用）がん薬物治療特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkgusdkbn</td><td>（連携用）がん薬物治療特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkguybx1</td><td>（連携用）がん薬物治療特約記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkguybx2</td><td>（連携用）がん薬物治療特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkguybx3</td><td>（連携用）がん薬物治療特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkguybx4</td><td>（連携用）がん薬物治療特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkguybx5</td><td>（連携用）がん薬物治療特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykkkn</td><td>（連携用）がん薬物治療特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkykphrkkkn</td><td>（連携用）がん薬物治療特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnganykbttryutkyks</td><td>（連携用）がん薬物治療特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnganykbttryutkykp</td><td>（連携用）がん薬物治療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnganykbttryutkykpwrbkkbn</td><td>（連携用）がん薬物治療特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngnykbttryutkykksnmnryage</td><td>（連携用）がん薬物治療特約更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv12x11</td><td>（連携用）予備項目Ｖ１２＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngukihtnkngansndntkyks</td><td>（連携用）合計被転換がん診断特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngukihtnknganykbttrytkyks</td><td>（連携用）合計被転換がん薬物治療特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsinkeiyakujiyoteiriritu</td><td>（連携用）新契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkousinmanryouage</td><td>（連携用）更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseizonmrtikusnmnryoage</td><td>（連携用）生存マル定更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteigenmrtikusnmnryoage</td><td>（連携用）逓減マル定更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtisyri</td><td>（連携用）生活収入マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtikgusdikbn</td><td>（連携用）生活収入マル定記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtikguyobi</td><td>（連携用）生活収入マル定記号予備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtikguyobix2</td><td>（連携用）生活収入マル定記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtikguyobix3</td><td>（連携用）生活収入マル定記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtikguyobix4</td><td>（連携用）生活収入マル定記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtikguyobix5</td><td>（連携用）生活収入マル定記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtiktkbn</td><td>（連携用）生活収入マル定型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtisyugiktkbn</td><td>（連携用）生活収入マル定障害給付型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseikatusyuunyuumrtikkn</td><td>（連携用）生活収入マル定期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtiphrikmkbn</td><td>（連携用）生活収入マル定Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtishrikkn</td><td>（連携用）生活収入マル定支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsynyumrtitnknwrbkkbn</td><td>（連携用）生活収入マル定転換割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrsiktsyunyumrtipwrbkkbn</td><td>（連携用）数理生活収入マル定Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtipwrbkkbn</td><td>（連携用）生活収入マル定Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtiksnmnryunn</td><td>（連携用）生活収入マル定更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyunyumrtinnknnngk</td><td>（連携用）生活収入マル定年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseikatusyuunyuumrtis</td><td>（連携用）生活収入マル定Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyunyumrtiitjknks</td><td>（連携用）生活収入マル定一時金化Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseikatusyuunyuumrtip</td><td>（連携用）生活収入マル定Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyunyumrtisyuuseis</td><td>（連携用）生活収入マル定修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyunyumrtitkjyukbn</td><td>（連携用）生活収入マル定特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsynymrtitkjyrymshytn</td><td>（連携用）生活収入マル定特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsiktsyunyumrtitkjyup</td><td>（連携用）生活収入マル定特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkyksyrikgu</td><td>（連携用）生活習慣病特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkgsdikbn</td><td>（連携用）生活習慣病特約記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkguybi</td><td>（連携用）生活習慣病特約記号予備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkguybix2</td><td>（連携用）生活習慣病特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkguybix3</td><td>（連携用）生活習慣病特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkguybix4</td><td>（連携用）生活習慣病特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkguybix5</td><td>（連携用）生活習慣病特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykkkn</td><td>（連携用）生活習慣病特約期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykphrkmkkn</td><td>（連携用）生活習慣病特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyknbytyktnknwrbkkbn</td><td>（連携用）生活習慣病特約転換割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrsiktsyuknbyutkpwrbkkbn</td><td>（連携用）数理生活習慣病特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykpwrbkkbn</td><td>（連携用）生活習慣病特約Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyknbytkykkusnmnrynn</td><td>（連携用）生活習慣病特約更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkyks</td><td>（連携用）生活習慣病特約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkykp</td><td>（連携用）生活習慣病特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkyktikknars</td><td>（連携用）生活習慣病特約待期間有Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkyksyusis</td><td>（連携用）生活習慣病特約修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkjyukbn</td><td>（連携用）生活習慣病特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkjyrymshytn</td><td>（連携用）生活習慣病特条料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsiktsyuknbyutkjyup</td><td>（連携用）生活習慣病特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsyuknbyutktibicd</td><td>（連携用）生活習慣病特定部位コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyuhtnpkkn</td><td>（連携用）生活習慣病不担保期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyutktibicdx2</td><td>（連携用）生活習慣病特定部位コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsyuknbyuhtnpkknx2</td><td>（連携用）生活習慣病不担保期間＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv19</td><td>（連携用）予備項目Ｖ１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtisyrkg</td><td>（連携用）被転換生活収入マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynykgusdikbn</td><td>（連携用）被転換生活収入記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgyb</td><td>（連携用）被転換生活収入マル定記号予備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx2</td><td>（連携用）被転換生活収入マル定記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx3</td><td>（連携用）被転換生活収入マル定記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx4</td><td>（連携用）被転換生活収入マル定記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx5</td><td>（連携用）被転換生活収入マル定記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytksyrkg</td><td>（連携用）被転換生活習慣病特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbykgsdkbn</td><td>（連携用）被転換生活習慣病記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgyb</td><td>（連携用）被転換生活習慣病特約記号予備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx2</td><td>（連携用）被転換生活習慣病特約記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx3</td><td>（連携用）被転換生活習慣病特約記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx4</td><td>（連携用）被転換生活習慣病特約記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx5</td><td>（連携用）被転換生活習慣病特約記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24</td><td>（連携用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtisyrkgx2</td><td>（連携用）被転換生活収入マル定種類記号＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynykgusdikbnx2</td><td>（連携用）被転換生活収入記号世代区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx6</td><td>（連携用）被転換生活収入マル定記号予備＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx7</td><td>（連携用）被転換生活収入マル定記号予備＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx8</td><td>（連携用）被転換生活収入マル定記号予備＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx9</td><td>（連携用）被転換生活収入マル定記号予備＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx10</td><td>（連携用）被転換生活収入マル定記号予備＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytksyrkgx2</td><td>（連携用）被転換生活習慣病特約種類記号＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbykgsdkbnx2</td><td>（連携用）被転換生活習慣病記号世代区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx6</td><td>（連携用）被転換生活習慣病特約記号予備＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx7</td><td>（連携用）被転換生活習慣病特約記号予備＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx8</td><td>（連携用）被転換生活習慣病特約記号予備＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx9</td><td>（連携用）被転換生活習慣病特約記号予備＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx10</td><td>（連携用）被転換生活習慣病特約記号予備＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24x2</td><td>（連携用）予備項目Ｖ２４＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtisyrkgx3</td><td>（連携用）被転換生活収入マル定種類記号＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynykgusdikbnx3</td><td>（連携用）被転換生活収入記号世代区分＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx11</td><td>（連携用）被転換生活収入マル定記号予備＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx12</td><td>（連携用）被転換生活収入マル定記号予備＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx13</td><td>（連携用）被転換生活収入マル定記号予備＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx14</td><td>（連携用）被転換生活収入マル定記号予備＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx15</td><td>（連携用）被転換生活収入マル定記号予備＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytksyrkgx3</td><td>（連携用）被転換生活習慣病特約種類記号＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbykgsdkbnx3</td><td>（連携用）被転換生活習慣病記号世代区分＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx11</td><td>（連携用）被転換生活習慣病特約記号予備＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx12</td><td>（連携用）被転換生活習慣病特約記号予備＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx13</td><td>（連携用）被転換生活習慣病特約記号予備＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx14</td><td>（連携用）被転換生活習慣病特約記号予備＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx15</td><td>（連携用）被転換生活習慣病特約記号予備＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24x3</td><td>（連携用）予備項目Ｖ２４＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtisyrkgx4</td><td>（連携用）被転換生活収入マル定種類記号＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynykgusdikbnx4</td><td>（連携用）被転換生活収入記号世代区分＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx16</td><td>（連携用）被転換生活収入マル定記号予備＿１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx17</td><td>（連携用）被転換生活収入マル定記号予備＿１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx18</td><td>（連携用）被転換生活収入マル定記号予備＿１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx19</td><td>（連携用）被転換生活収入マル定記号予備＿１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx20</td><td>（連携用）被転換生活収入マル定記号予備＿２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytksyrkgx4</td><td>（連携用）被転換生活習慣病特約種類記号＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbykgsdkbnx4</td><td>（連携用）被転換生活習慣病記号世代区分＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx16</td><td>（連携用）被転換生活習慣病特約記号予備＿１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx17</td><td>（連携用）被転換生活習慣病特約記号予備＿１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx18</td><td>（連携用）被転換生活習慣病特約記号予備＿１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx19</td><td>（連携用）被転換生活習慣病特約記号予備＿１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx20</td><td>（連携用）被転換生活習慣病特約記号予備＿２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24x4</td><td>（連携用）予備項目Ｖ２４＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtisyrkgx5</td><td>（連携用）被転換生活収入マル定種類記号＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynykgusdikbnx5</td><td>（連携用）被転換生活収入記号世代区分＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx21</td><td>（連携用）被転換生活収入マル定記号予備＿２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx22</td><td>（連携用）被転換生活収入マル定記号予備＿２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx23</td><td>（連携用）被転換生活収入マル定記号予備＿２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx24</td><td>（連携用）被転換生活収入マル定記号予備＿２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx25</td><td>（連携用）被転換生活収入マル定記号予備＿２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytksyrkgx5</td><td>（連携用）被転換生活習慣病特約種類記号＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbykgsdkbnx5</td><td>（連携用）被転換生活習慣病記号世代区分＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx21</td><td>（連携用）被転換生活習慣病特約記号予備＿２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx22</td><td>（連携用）被転換生活習慣病特約記号予備＿２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx23</td><td>（連携用）被転換生活習慣病特約記号予備＿２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx24</td><td>（連携用）被転換生活習慣病特約記号予備＿２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx25</td><td>（連携用）被転換生活習慣病特約記号予備＿２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24x5</td><td>（連携用）予備項目Ｖ２４＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtisyrkgx6</td><td>（連携用）被転換生活収入マル定種類記号＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynykgusdikbnx6</td><td>（連携用）被転換生活収入記号世代区分＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx26</td><td>（連携用）被転換生活収入マル定記号予備＿２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx27</td><td>（連携用）被転換生活収入マル定記号予備＿２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx28</td><td>（連携用）被転換生活収入マル定記号予備＿２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx29</td><td>（連携用）被転換生活収入マル定記号予備＿２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsynymrtikgybx30</td><td>（連携用）被転換生活収入マル定記号予備＿３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytksyrkgx6</td><td>（連携用）被転換生活習慣病特約種類記号＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbykgsdkbnx6</td><td>（連携用）被転換生活習慣病記号世代区分＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx26</td><td>（連携用）被転換生活習慣病特約記号予備＿２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx27</td><td>（連携用）被転換生活習慣病特約記号予備＿２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx28</td><td>（連携用）被転換生活習慣病特約記号予備＿２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx29</td><td>（連携用）被転換生活習慣病特約記号予備＿２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknsiktsyknbytkkgybx30</td><td>（連携用）被転換生活習慣病特約記号予備＿３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24x6</td><td>（連携用）予備項目Ｖ２４＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakuhrmkhritu</td><td>（連携用）解約返戻金目標率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntumitatekinitenmkhyurt</td><td>（連携用）積立金移転目標率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobiv250</td><td>（連携用）予備項目Ｖ２５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv248</td><td>（連携用）予備項目Ｖ２４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu5Rn
 * @see     GenZT_Sp2RnduyuSouseiritu5Rn
 * @see     QZT_Sp2RnduyuSouseiritu5Rn
 * @see     GenQZT_Sp2RnduyuSouseiritu5Rn
 */
public class PKZT_Sp2RnduyuSouseiritu5Rn extends AbstractExDBPrimaryKey<ZT_Sp2RnduyuSouseiritu5Rn, PKZT_Sp2RnduyuSouseiritu5Rn> {

    private static final long serialVersionUID = 1L;

    public PKZT_Sp2RnduyuSouseiritu5Rn() {
    }

    public PKZT_Sp2RnduyuSouseiritu5Rn(String pZrnktgysyono) {
        zrnktgysyono = pZrnktgysyono;
    }

    @Transient
    @Override
    public Class<ZT_Sp2RnduyuSouseiritu5Rn> getEntityClass() {
        return ZT_Sp2RnduyuSouseiritu5Rn.class;
    }

    private String zrnktgysyono;

    public String getZrnktgysyono() {
        return zrnktgysyono;
    }

    public void setZrnktgysyono(String pZrnktgysyono) {
        zrnktgysyono = pZrnktgysyono;
    }

}