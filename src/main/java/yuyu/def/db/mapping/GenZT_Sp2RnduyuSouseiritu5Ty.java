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
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu5Ty;

/**
 * ＳＰ２連動用総成立Fテーブル５（中） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu5Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu5Ty}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル５（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyktgysyrymd ztyktgysyrymd}</td><td>（中継用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu5Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgyfilerenno ztyktgyfilerenno}</td><td>（中継用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyabosyuudirtncd ztyaatukaisyabosyuudirtncd}</td><td>（中継用）Ａ扱者募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaisyabosyuudirtncd ztybatukaisyabosyuudirtncd}</td><td>（中継用）Ｂ扱者募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykessankeijyouym ztykessankeijyouym}</td><td>（中継用）決算計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkntmttsyusnhknarihyj ztyhtnkntmttsyusnhknarihyj}</td><td>（中継用）被転換積立終身保険有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetuhosyoukikan ztytokubetuhosyoukikan}</td><td>（中継用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp3x1 ztygoukeinenbaraikansanp3x1}</td><td>（中継用）合計年払換算Ｐ３＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x1 ztyhktgtikkikkkn3x1}</td><td>（中継用）引継定期経過期間３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx1 ztykappadhktgkujygkx1}</td><td>（中継用）カッパーＤ引継控除額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp3x2 ztygoukeinenbaraikansanp3x2}</td><td>（中継用）合計年払換算Ｐ３＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x2 ztyhktgtikkikkkn3x2}</td><td>（中継用）引継定期経過期間３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx2 ztykappadhktgkujygkx2}</td><td>（中継用）カッパーＤ引継控除額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp3x3 ztygoukeinenbaraikansanp3x3}</td><td>（中継用）合計年払換算Ｐ３＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x3 ztyhktgtikkikkkn3x3}</td><td>（中継用）引継定期経過期間３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx3 ztykappadhktgkujygkx3}</td><td>（中継用）カッパーＤ引継控除額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp3x4 ztygoukeinenbaraikansanp3x4}</td><td>（中継用）合計年払換算Ｐ３＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x4 ztyhktgtikkikkkn3x4}</td><td>（中継用）引継定期経過期間３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx4 ztykappadhktgkujygkx4}</td><td>（中継用）カッパーＤ引継控除額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp3x5 ztygoukeinenbaraikansanp3x5}</td><td>（中継用）合計年払換算Ｐ３＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x5 ztyhktgtikkikkkn3x5}</td><td>（中継用）引継定期経過期間３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx5 ztykappadhktgkujygkx5}</td><td>（中継用）カッパーＤ引継控除額＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp3x6 ztygoukeinenbaraikansanp3x6}</td><td>（中継用）合計年払換算Ｐ３＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x6 ztyhktgtikkikkkn3x6}</td><td>（中継用）引継定期経過期間３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx6 ztykappadhktgkujygkx6}</td><td>（中継用）カッパーＤ引継控除額＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhutihnnnkknnzmkyksyono ztyhutihnnnkknnzmkyksyono}</td><td>（中継用）法定本人確認済契約証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosnyuuryokuymd ztymosnyuuryokuymd}</td><td>（中継用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyosakuseiymd ztymossyosakuseiymd}</td><td>（中継用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kokutiymd ztydai2kokutiymd}</td><td>（中継用）第２告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuuryousyouryakukbn ztyjyuuryousyouryakukbn}</td><td>（中継用）充領省略区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkyksyuruikgu ztysnsniryutkyksyuruikgu}</td><td>（中継用）先進医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysensiniryoutokuyakukikan ztysensiniryoutokuyakukikan}</td><td>（中継用）先進医療特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysensiniryoutkykphrkkkn ztysensiniryoutkykphrkkkn}</td><td>（中継用）先進医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysensiniryoutokuyakus ztysensiniryoutokuyakus}</td><td>（中継用）先進医療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysensiniryoutokuyakup ztysensiniryoutokuyakup}</td><td>（中継用）先進医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysensiniryoutkykkgusdkbn ztysensiniryoutkykkgusdkbn}</td><td>（中継用）先進医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykkguybx1 ztysnsniryutkykkguybx1}</td><td>（中継用）先進医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykkguybx2 ztysnsniryutkykkguybx2}</td><td>（中継用）先進医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykkguybx3 ztysnsniryutkykkguybx3}</td><td>（中継用）先進医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykkguybx4 ztysnsniryutkykkguybx4}</td><td>（中継用）先進医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykkguybx5 ztysnsniryutkykkguybx5}</td><td>（中継用）先進医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykpwrbkkbn ztysnsniryutkykpwrbkkbn}</td><td>（中継用）先進医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutktbicdx1 ztysnsniryutktbicdx1}</td><td>（中継用）先進医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryuhtnpkknx1 ztysnsniryuhtnpkknx1}</td><td>（中継用）先進医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutktbicdx2 ztysnsniryutktbicdx2}</td><td>（中継用）先進医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryuhtnpkknx2 ztysnsniryuhtnpkknx2}</td><td>（中継用）先進医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsniryutkykkusnmnryoage ztysnsniryutkykkusnmnryoage}</td><td>（中継用）先進医療特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x17 ztyyobiv4x17}</td><td>（中継用）予備項目Ｖ４＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkyksyrikgu ztydi2snsniryutkyksyrikgu}</td><td>（中継用）第２先進医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkkn ztydi2snsniryutkykkkn}</td><td>（中継用）第２先進医療特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2snsniryutkykphrkkkn ztydai2snsniryutkykphrkkkn}</td><td>（中継用）第２先進医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2sensiniryoutokuyakus ztydai2sensiniryoutokuyakus}</td><td>（中継用）第２先進医療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2sensiniryoutokuyakup ztydai2sensiniryoutokuyakup}</td><td>（中継用）第２先進医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkgusdkbn ztydi2snsniryutkykkgusdkbn}</td><td>（中継用）第２先進医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkguybx1 ztydi2snsniryutkykkguybx1}</td><td>（中継用）第２先進医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkguybx2 ztydi2snsniryutkykkguybx2}</td><td>（中継用）第２先進医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkguybx3 ztydi2snsniryutkykkguybx3}</td><td>（中継用）第２先進医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkguybx4 ztydi2snsniryutkykkguybx4}</td><td>（中継用）第２先進医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykkguybx5 ztydi2snsniryutkykkguybx5}</td><td>（中継用）第２先進医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutkykpwrbkkbn ztydi2snsniryutkykpwrbkkbn}</td><td>（中継用）第２先進医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutktbicdx1 ztydi2snsniryutktbicdx1}</td><td>（中継用）第２先進医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryuhtnpkknx1 ztydi2snsniryuhtnpkknx1}</td><td>（中継用）第２先進医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryutktbicdx2 ztydi2snsniryutktbicdx2}</td><td>（中継用）第２先進医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2snsniryuhtnpkknx2 ztydi2snsniryuhtnpkknx2}</td><td>（中継用）第２先進医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x3 ztyyobiv6x3}</td><td>（中継用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaagetyouseihyj ztykyksyaagetyouseihyj}</td><td>（中継用）契約者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnentysihyj ztydai2hhknnentysihyj}</td><td>（中継用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhsyumnosjdftmttzndk ztyhsyumnosjdftmttzndk}</td><td>（中継用）保障見直時ＤＦ積立残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyjttkyksyrikgu ztynyuinhsyujyjttkyksyrikgu}</td><td>（中継用）入院保障充実特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujttkykkkn ztynyuinhsyujyujttkykkkn}</td><td>（中継用）入院保障充実特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyinhsyjyjttkykphrkkkn ztynyinhsyjyjttkykphrkkkn}</td><td>（中継用）入院保障充実特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujttkyks ztynyuinhsyujyujttkyks}</td><td>（中継用）入院保障充実特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujttkykp ztynyuinhsyujyujttkykp}</td><td>（中継用）入院保障充実特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynyinhsyjyjttkjyrymshytn ztynyinhsyjyjttkjyrymshytn}</td><td>（中継用）入院保障充実特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujttkyktkjyup ztynyuinhsyujyujttkyktkjyup}</td><td>（中継用）入院保障充実特約特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujttktbicdx1 ztynyuinhsyujyujttktbicdx1}</td><td>（中継用）入院保障充実特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujthtnpkknx1 ztynyuinhsyujyujthtnpkknx1}</td><td>（中継用）入院保障充実不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujttktbicdx2 ztynyuinhsyujyujttktbicdx2}</td><td>（中継用）入院保障充実特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyujthtnpkknx2 ztynyuinhsyujyujthtnpkknx2}</td><td>（中継用）入院保障充実不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyinhsyjyjttkykkgusdkbn ztynyinhsyjyjttkykkgusdkbn}</td><td>（中継用）入院保障充実特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyinhsyjyjttkykpwrbkkbn ztynyinhsyjyjttkykpwrbkkbn}</td><td>（中継用）入院保障充実特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyjttkykkguybx1 ztynyuinhsyujyjttkykkguybx1}</td><td>（中継用）入院保障充実特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyjttkykkguybx2 ztynyuinhsyujyjttkykkguybx2}</td><td>（中継用）入院保障充実特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyjttkykkguybx3 ztynyuinhsyujyjttkykkguybx3}</td><td>（中継用）入院保障充実特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyjttkykkguybx4 ztynyuinhsyujyjttkykkguybx4}</td><td>（中継用）入院保障充実特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuinhsyujyjttkykkguybx5 ztynyuinhsyujyjttkykkguybx5}</td><td>（中継用）入院保障充実特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyinhsyjyjtkykksnmnryage ztynyinhsyjyjtkykksnmnryage}</td><td>（中継用）入院保障充実特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5x4 ztyyobiv5x4}</td><td>（中継用）予備項目Ｖ５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyjyjttkyksyrikg ztydi2nyinhsyjyjttkyksyrikg}</td><td>（中継用）第２入院保障充実特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyujyujttkykkkn ztydi2nyuinhsyujyujttkykkkn}</td><td>（中継用）第２入院保障充実特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyujyjtphrkkkn ztydi2nyuinhsyujyjtphrkkkn}</td><td>（中継用）第２入院保障充実Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyujyujttkyks ztydi2nyuinhsyujyujttkyks}</td><td>（中継用）第２入院保障充実特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyujyujttkykp ztydi2nyuinhsyujyujttkykp}</td><td>（中継用）第２入院保障充実特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2nyhsyjyjttkjyrymshytn ztydi2nyhsyjyjttkjyrymshytn}</td><td>（中継用）第２入院保障充実特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyujyujttkjyup ztydi2nyuinhsyujyujttkjyup}</td><td>（中継用）第２入院保障充実特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyutktbicdx1 ztydi2nyuinhsyutktbicdx1}</td><td>（中継用）第２入院保障特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyuhtnpkknx1 ztydi2nyuinhsyuhtnpkknx1}</td><td>（中継用）第２入院保障不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyutktbicdx2 ztydi2nyuinhsyutktbicdx2}</td><td>（中継用）第２入院保障特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyuhtnpkknx2 ztydi2nyuinhsyuhtnpkknx2}</td><td>（中継用）第２入院保障不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyujyjtkgusdkbn ztydi2nyinhsyujyjtkgusdkbn}</td><td>（中継用）第２入院保障充実記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyuinhsyujyjtpwrbkkbn ztydi2nyuinhsyujyjtpwrbkkbn}</td><td>（中継用）第２入院保障充実Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyjyjttkykkgybx1 ztydi2nyinhsyjyjttkykkgybx1}</td><td>（中継用）第２入院保障充実特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyjyjttkykkgybx2 ztydi2nyinhsyjyjttkykkgybx2}</td><td>（中継用）第２入院保障充実特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyjyjttkykkgybx3 ztydi2nyinhsyjyjttkykkgybx3}</td><td>（中継用）第２入院保障充実特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyjyjttkykkgybx4 ztydi2nyinhsyjyjttkykkgybx4}</td><td>（中継用）第２入院保障充実特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2nyinhsyjyjttkykkgybx5 ztydi2nyinhsyjyjttkykkgybx5}</td><td>（中継用）第２入院保障充実特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x6 ztyyobiv7x6}</td><td>（中継用）予備項目Ｖ７＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x4 ztyyobiv1x4}</td><td>（中継用）予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywnasitnknkakakujyutukbn ztywnasitnknkakakujyutukbn}</td><td>（中継用）Ｗなし転換価格充当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeiwnasitenkankakaku ztygoukeiwnasitenkankakaku}</td><td>（中継用）合計Ｗなし転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukiwnstnknitjbrnknengk ztygukiwnstnknitjbrnknengk}</td><td>（中継用）合計Ｗなし転換一時払年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukiwnasitnknitjbrtiks ztygukiwnasitnknitjbrtiks}</td><td>（中継用）合計Ｗなし転換一時払定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x11 ztyyobiv9x11}</td><td>（中継用）予備項目Ｖ９＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkyksyuruikgu ztysuguiryutkyksyuruikgu}</td><td>（中継用）総合医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysougouiryoutokuyakukikan ztysougouiryoutokuyakukikan}</td><td>（中継用）総合医療特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykphrkkkn ztysuguiryutkykphrkkkn}</td><td>（中継用）総合医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykntgk ztysuguiryutkykntgk}</td><td>（中継用）総合医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysougouiryoutokuyakup ztysougouiryoutokuyakup}</td><td>（中継用）総合医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkjyuryumshyutn ztysuguiryutkjyuryumshyutn}</td><td>（中継用）総合医療特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysougouiryoutokujyoup ztysougouiryoutokujyoup}</td><td>（中継用）総合医療特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuguiryutktbicdx1 ztysuguiryutktbicdx1}</td><td>（中継用）総合医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryuhtnpkknx1 ztysuguiryuhtnpkknx1}</td><td>（中継用）総合医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutktbicdx2 ztysuguiryutktbicdx2}</td><td>（中継用）総合医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryuhtnpkknx2 ztysuguiryuhtnpkknx2}</td><td>（中継用）総合医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkgusdkbn ztysuguiryutkykkgusdkbn}</td><td>（中継用）総合医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykpwrbkkbn ztysuguiryutkykpwrbkkbn}</td><td>（中継用）総合医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkguybx1 ztysuguiryutkykkguybx1}</td><td>（中継用）総合医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkguybx2 ztysuguiryutkykkguybx2}</td><td>（中継用）総合医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkguybx3 ztysuguiryutkykkguybx3}</td><td>（中継用）総合医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkguybx4 ztysuguiryutkykkguybx4}</td><td>（中継用）総合医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkguybx5 ztysuguiryutkykkguybx5}</td><td>（中継用）総合医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuguiryutkykkusnmnryoage ztysuguiryutkykkusnmnryoage}</td><td>（中継用）総合医療特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x7 ztyyobiv7x7}</td><td>（中継用）予備項目Ｖ７＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkyksyrikgu ztydi2suguiryutkyksyrikgu}</td><td>（中継用）第２総合医療特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkkn ztydi2suguiryutkykkkn}</td><td>（中継用）第２総合医療特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykphrkkkn ztydi2suguiryutkykphrkkkn}</td><td>（中継用）第２総合医療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykntgk ztydi2suguiryutkykntgk}</td><td>（中継用）第２総合医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2sougouiryoutokuyakup ztydai2sougouiryoutokuyakup}</td><td>（中継用）第２総合医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkjyurymshytn ztydi2suguiryutkjyurymshytn}</td><td>（中継用）第２総合医療特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2sougouiryoutokujyoup ztydai2sougouiryoutokujyoup}</td><td>（中継用）第２総合医療特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutktbicdx1 ztydi2suguiryutktbicdx1}</td><td>（中継用）第２総合医療特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryuhtnpkknx1 ztydi2suguiryuhtnpkknx1}</td><td>（中継用）第２総合医療不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutktbicdx2 ztydi2suguiryutktbicdx2}</td><td>（中継用）第２総合医療特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryuhtnpkknx2 ztydi2suguiryuhtnpkknx2}</td><td>（中継用）第２総合医療不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkgusdkbn ztydi2suguiryutkykkgusdkbn}</td><td>（中継用）第２総合医療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykpwrbkkbn ztydi2suguiryutkykpwrbkkbn}</td><td>（中継用）第２総合医療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkguybx1 ztydi2suguiryutkykkguybx1}</td><td>（中継用）第２総合医療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkguybx2 ztydi2suguiryutkykkguybx2}</td><td>（中継用）第２総合医療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkguybx3 ztydi2suguiryutkykkguybx3}</td><td>（中継用）第２総合医療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkguybx4 ztydi2suguiryutkykkguybx4}</td><td>（中継用）第２総合医療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2suguiryutkykkguybx5 ztydi2suguiryutkykkguybx5}</td><td>（中継用）第２総合医療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x12 ztyyobiv9x12}</td><td>（中継用）予備項目Ｖ９＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuintkyksyrikgu ztydai2gannyuintkyksyrikgu}</td><td>（中継用）第２がん入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuintkykkkn ztydai2gannyuintkykkkn}</td><td>（中継用）第２がん入院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuintkykphrkkkn ztydai2gannyuintkykphrkkkn}</td><td>（中継用）第２がん入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuintkykntgk ztydai2gannyuintkykntgk}</td><td>（中継用）第２がん入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuuintokuyakup ztydai2gannyuuintokuyakup}</td><td>（中継用）第２がん入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuintkykkgusdkbn ztydai2gannyuintkykkgusdkbn}</td><td>（中継用）第２がん入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2gannyuintkykkguyobix1 ztydi2gannyuintkykkguyobix1}</td><td>（中継用）第２がん入院特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2gannyuintkykkguyobix2 ztydi2gannyuintkykkguyobix2}</td><td>（中継用）第２がん入院特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2gannyuintkykkguyobix3 ztydi2gannyuintkykkguyobix3}</td><td>（中継用）第２がん入院特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2gannyuintkykkguyobix4 ztydi2gannyuintkykkguyobix4}</td><td>（中継用）第２がん入院特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2gannyuintkykkguyobix5 ztydi2gannyuintkykkguyobix5}</td><td>（中継用）第２がん入院特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2gannyuintkykpwrbkkbn ztydai2gannyuintkykpwrbkkbn}</td><td>（中継用）第２がん入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x4 ztyyobiv6x4}</td><td>（中継用）予備項目Ｖ６＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygukihtnknsuguirytkykntgk ztygukihtnknsuguirytkykntgk}</td><td>（中継用）合計被転換総合医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuusyrikgu ztyhijynbrimarusyuusyrikgu}</td><td>（中継用）平準払マル終種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimrsyukgusdkbn ztyhijynbrimrsyukgusdkbn}</td><td>（中継用）平準払マル終記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuukguybx1 ztyhijynbrimarusyuukguybx1}</td><td>（中継用）平準払マル終記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuukguybx2 ztyhijynbrimarusyuukguybx2}</td><td>（中継用）平準払マル終記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuukguybx3 ztyhijynbrimarusyuukguybx3}</td><td>（中継用）平準払マル終記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuukguybx4 ztyhijynbrimarusyuukguybx4}</td><td>（中継用）平準払マル終記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuukguybx5 ztyhijynbrimarusyuukguybx5}</td><td>（中継用）平準払マル終記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuukkn ztyhijynbrimarusyuukkn}</td><td>（中継用）平準払マル終期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimrsyphrkkkn ztyhijynbrimrsyphrkkkn}</td><td>（中継用）平準払マル終Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuutkyks ztyhijynbrimarusyuutkyks}</td><td>（中継用）平準払マル終特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuutkykp ztyhijynbrimarusyuutkykp}</td><td>（中継用）平準払マル終特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimrsypwrbkkbn ztyhijynbrimrsypwrbkkbn}</td><td>（中継用）平準払マル終Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuumods ztyhijynbrimarusyuumods}</td><td>（中継用）平準払マル終修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuutkjyukbn ztyhijynbrimarusyuutkjyukbn}</td><td>（中継用）平準払マル終特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimrsytkjyuskgnkkn ztyhijynbrimrsytkjyuskgnkkn}</td><td>（中継用）平準払マル終特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhijynbrmrsytkjyurymshytn ztyhijynbrmrsytkjyurymshytn}</td><td>（中継用）平準払マル終特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhijynbrimarusyuutkjyup ztyhijynbrimarusyuutkjyup}</td><td>（中継用）平準払マル終特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhijynbrmrsytnknygryrtkbn ztyhijynbrmrsytnknygryrtkbn}</td><td>（中継用）平準払マル終転換優遇料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x18 ztyyobiv4x18}</td><td>（中継用）予備項目Ｖ４＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyoutaihushrhyj ztytokuteijyoutaihushrhyj}</td><td>（中継用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosjikaigos ztymosjikaigos}</td><td>（中継用）申込時介護Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymosjidi2hknkknsyuusns ztymosjidi2hknkknsyuusns}</td><td>（中継用）申込時第２保険期間終身Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygansndntkyksyrikgu ztygansndntkyksyrikgu}</td><td>（中継用）がん診断特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykkgusdkbn ztygansndntkykkgusdkbn}</td><td>（中継用）がん診断特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykkguybx1 ztygansndntkykkguybx1}</td><td>（中継用）がん診断特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykkguybx2 ztygansndntkykkguybx2}</td><td>（中継用）がん診断特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykkguybx3 ztygansndntkykkguybx3}</td><td>（中継用）がん診断特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykkguybx4 ztygansndntkykkguybx4}</td><td>（中継用）がん診断特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykkguybx5 ztygansndntkykkguybx5}</td><td>（中継用）がん診断特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansindantokuyakukikan ztygansindantokuyakukikan}</td><td>（中継用）がん診断特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkykphrkkkn ztygansndntkykphrkkkn}</td><td>（中継用）がん診断特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansindantokuyakus ztygansindantokuyakus}</td><td>（中継用）がん診断特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygansindantokuyakup ztygansindantokuyakup}</td><td>（中継用）がん診断特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygansndntkykpwrbkkbn ztygansndntkykpwrbkkbn}</td><td>（中継用）がん診断特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansndntkyktaikknbbns ztygansndntkyktaikknbbns}</td><td>（中継用）がん診断特約待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyouhinaiganmtkknbbns ztyjyouhinaiganmtkknbbns}</td><td>（中継用）上皮内がん待期間部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygnsndntkykkusnmnryoage ztygnsndntkykkusnmnryoage}</td><td>（中継用）がん診断特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x5 ztyyobiv10x5}</td><td>（中継用）予備項目Ｖ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkyksyrikgu ztyganykbttryutkyksyrikgu}</td><td>（中継用）がん薬物治療特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkgusdkbn ztyganykbttryutkykkgusdkbn}</td><td>（中継用）がん薬物治療特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkguybx1 ztyganykbttryutkykkguybx1}</td><td>（中継用）がん薬物治療特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkguybx2 ztyganykbttryutkykkguybx2}</td><td>（中継用）がん薬物治療特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkguybx3 ztyganykbttryutkykkguybx3}</td><td>（中継用）がん薬物治療特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkguybx4 ztyganykbttryutkykkguybx4}</td><td>（中継用）がん薬物治療特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkguybx5 ztyganykbttryutkykkguybx5}</td><td>（中継用）がん薬物治療特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykkkn ztyganykbttryutkykkkn}</td><td>（中継用）がん薬物治療特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykphrkkkn ztyganykbttryutkykphrkkkn}</td><td>（中継用）がん薬物治療特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkyks ztyganykbttryutkyks}</td><td>（中継用）がん薬物治療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykp ztyganykbttryutkykp}</td><td>（中継用）がん薬物治療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyganykbttryutkykpwrbkkbn ztyganykbttryutkykpwrbkkbn}</td><td>（中継用）がん薬物治療特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnykbttryutkykksnmnryage ztygnykbttryutkykksnmnryage}</td><td>（中継用）がん薬物治療特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x11 ztyyobiv12x11}</td><td>（中継用）予備項目Ｖ１２＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygukihtnkngansndntkyks ztygukihtnkngansndntkyks}</td><td>（中継用）合計被転換がん診断特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknganykbttrytkyks ztygukihtnknganykbttrytkyks}</td><td>（中継用）合計被転換がん薬物治療特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujiyoteiriritu ztysinkeiyakujiyoteiriritu}</td><td>（中継用）新契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykousinmanryouage ztykousinmanryouage}</td><td>（中継用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtikusnmnryoage ztyseizonmrtikusnmnryoage}</td><td>（中継用）生存マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtikusnmnryoage ztyteigenmrtikusnmnryoage}</td><td>（中継用）逓減マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtisyri ztysiktsyunyumrtisyri}</td><td>（中継用）生活収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtikgusdikbn ztysiktsyunyumrtikgusdikbn}</td><td>（中継用）生活収入マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtikguyobi ztysiktsyunyumrtikguyobi}</td><td>（中継用）生活収入マル定記号予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtikguyobix2 ztysiktsyunyumrtikguyobix2}</td><td>（中継用）生活収入マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtikguyobix3 ztysiktsyunyumrtikguyobix3}</td><td>（中継用）生活収入マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtikguyobix4 ztysiktsyunyumrtikguyobix4}</td><td>（中継用）生活収入マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtikguyobix5 ztysiktsyunyumrtikguyobix5}</td><td>（中継用）生活収入マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtiktkbn ztysiktsyunyumrtiktkbn}</td><td>（中継用）生活収入マル定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtisyugiktkbn ztysiktsyunyumrtisyugiktkbn}</td><td>（中継用）生活収入マル定障害給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikatusyuunyuumrtikkn ztyseikatusyuunyuumrtikkn}</td><td>（中継用）生活収入マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtiphrikmkbn ztysiktsyunyumrtiphrikmkbn}</td><td>（中継用）生活収入マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtishrikkn ztysiktsyunyumrtishrikkn}</td><td>（中継用）生活収入マル定支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsynyumrtitnknwrbkkbn ztysiktsynyumrtitnknwrbkkbn}</td><td>（中継用）生活収入マル定転換割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrsiktsyunyumrtipwrbkkbn ztysrsiktsyunyumrtipwrbkkbn}</td><td>（中継用）数理生活収入マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtipwrbkkbn ztysiktsyunyumrtipwrbkkbn}</td><td>（中継用）生活収入マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtiksnmnryunn ztysiktsyunyumrtiksnmnryunn}</td><td>（中継用）生活収入マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtinnknnngk ztysiktsyunyumrtinnknnngk}</td><td>（中継用）生活収入マル定年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseikatusyuunyuumrtis ztyseikatusyuunyuumrtis}</td><td>（中継用）生活収入マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtiitjknks ztysiktsyunyumrtiitjknks}</td><td>（中継用）生活収入マル定一時金化Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseikatusyuunyuumrtip ztyseikatusyuunyuumrtip}</td><td>（中継用）生活収入マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtisyuuseis ztysiktsyunyumrtisyuuseis}</td><td>（中継用）生活収入マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtitkjyukbn ztysiktsyunyumrtitkjyukbn}</td><td>（中継用）生活収入マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsynymrtitkjyrymshytn ztysiktsynymrtitkjyrymshytn}</td><td>（中継用）生活収入マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysiktsyunyumrtitkjyup ztysiktsyunyumrtitkjyup}</td><td>（中継用）生活収入マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkyksyrikgu ztysiktsyuknbyutkyksyrikgu}</td><td>（中継用）生活習慣病特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkgsdikbn ztysiktsyuknbyutkykkgsdikbn}</td><td>（中継用）生活習慣病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkguybi ztysiktsyuknbyutkykkguybi}</td><td>（中継用）生活習慣病特約記号予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkguybix2 ztysiktsyuknbyutkykkguybix2}</td><td>（中継用）生活習慣病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkguybix3 ztysiktsyuknbyutkykkguybix3}</td><td>（中継用）生活習慣病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkguybix4 ztysiktsyuknbyutkykkguybix4}</td><td>（中継用）生活習慣病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkguybix5 ztysiktsyuknbyutkykkguybix5}</td><td>（中継用）生活習慣病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykkkn ztysiktsyuknbyutkykkkn}</td><td>（中継用）生活習慣病特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykphrkmkkn ztysiktsyuknbyutkykphrkmkkn}</td><td>（中継用）生活習慣病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyknbytyktnknwrbkkbn ztysiktsyknbytyktnknwrbkkbn}</td><td>（中継用）生活習慣病特約転換割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrsiktsyuknbyutkpwrbkkbn ztysrsiktsyuknbyutkpwrbkkbn}</td><td>（中継用）数理生活習慣病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykpwrbkkbn ztysiktsyuknbyutkykpwrbkkbn}</td><td>（中継用）生活習慣病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyknbytkykkusnmnrynn ztysiktsyknbytkykkusnmnrynn}</td><td>（中継用）生活習慣病特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkyks ztysiktsyuknbyutkyks}</td><td>（中継用）生活習慣病特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkykp ztysiktsyuknbyutkykp}</td><td>（中継用）生活習慣病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkyktikknars ztysiktsyuknbyutkyktikknars}</td><td>（中継用）生活習慣病特約待期間有Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkyksyusis ztysiktsyuknbyutkyksyusis}</td><td>（中継用）生活習慣病特約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkjyukbn ztysiktsyuknbyutkjyukbn}</td><td>（中継用）生活習慣病特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkjyrymshytn ztysiktsyuknbyutkjyrymshytn}</td><td>（中継用）生活習慣病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutkjyup ztysiktsyuknbyutkjyup}</td><td>（中継用）生活習慣病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutktibicd ztysiktsyuknbyutktibicd}</td><td>（中継用）生活習慣病特定部位コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyuhtnpkkn ztysiktsyuknbyuhtnpkkn}</td><td>（中継用）生活習慣病不担保期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyutktibicdx2 ztysiktsyuknbyutktibicdx2}</td><td>（中継用）生活習慣病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyuhtnpkknx2 ztysiktsyuknbyuhtnpkknx2}</td><td>（中継用）生活習慣病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv19 ztyyobiv19}</td><td>（中継用）予備項目Ｖ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtisyrkg ztyhtnknsiktsynymrtisyrkg}</td><td>（中継用）被転換生活収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynykgusdikbn ztyhtnknsiktsynykgusdikbn}</td><td>（中継用）被転換生活収入記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgyb ztyhtnknsiktsynymrtikgyb}</td><td>（中継用）被転換生活収入マル定記号予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx2 ztyhtnknsiktsynymrtikgybx2}</td><td>（中継用）被転換生活収入マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx3 ztyhtnknsiktsynymrtikgybx3}</td><td>（中継用）被転換生活収入マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx4 ztyhtnknsiktsynymrtikgybx4}</td><td>（中継用）被転換生活収入マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx5 ztyhtnknsiktsynymrtikgybx5}</td><td>（中継用）被転換生活収入マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytksyrkg ztyhtnknsiktsyknbytksyrkg}</td><td>（中継用）被転換生活習慣病特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbykgsdkbn ztyhtnknsiktsyknbykgsdkbn}</td><td>（中継用）被転換生活習慣病記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgyb ztyhtnknsiktsyknbytkkgyb}</td><td>（中継用）被転換生活習慣病特約記号予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx2 ztyhtnknsiktsyknbytkkgybx2}</td><td>（中継用）被転換生活習慣病特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx3 ztyhtnknsiktsyknbytkkgybx3}</td><td>（中継用）被転換生活習慣病特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx4 ztyhtnknsiktsyknbytkkgybx4}</td><td>（中継用）被転換生活習慣病特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx5 ztyhtnknsiktsyknbytkkgybx5}</td><td>（中継用）被転換生活習慣病特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtisyrkgx2 ztyhtnknsiktsynymrtisyrkgx2}</td><td>（中継用）被転換生活収入マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynykgusdikbnx2 ztyhtnknsiktsynykgusdikbnx2}</td><td>（中継用）被転換生活収入記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx6 ztyhtnknsiktsynymrtikgybx6}</td><td>（中継用）被転換生活収入マル定記号予備＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx7 ztyhtnknsiktsynymrtikgybx7}</td><td>（中継用）被転換生活収入マル定記号予備＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx8 ztyhtnknsiktsynymrtikgybx8}</td><td>（中継用）被転換生活収入マル定記号予備＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx9 ztyhtnknsiktsynymrtikgybx9}</td><td>（中継用）被転換生活収入マル定記号予備＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx10 ztyhtnknsiktsynymrtikgybx10}</td><td>（中継用）被転換生活収入マル定記号予備＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytksyrkgx2 ztyhtnknsiktsyknbytksyrkgx2}</td><td>（中継用）被転換生活習慣病特約種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbykgsdkbnx2 ztyhtnknsiktsyknbykgsdkbnx2}</td><td>（中継用）被転換生活習慣病記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx6 ztyhtnknsiktsyknbytkkgybx6}</td><td>（中継用）被転換生活習慣病特約記号予備＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx7 ztyhtnknsiktsyknbytkkgybx7}</td><td>（中継用）被転換生活習慣病特約記号予備＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx8 ztyhtnknsiktsyknbytkkgybx8}</td><td>（中継用）被転換生活習慣病特約記号予備＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx9 ztyhtnknsiktsyknbytkkgybx9}</td><td>（中継用）被転換生活習慣病特約記号予備＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx10 ztyhtnknsiktsyknbytkkgybx10}</td><td>（中継用）被転換生活習慣病特約記号予備＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24x2 ztyyobiv24x2}</td><td>（中継用）予備項目Ｖ２４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtisyrkgx3 ztyhtnknsiktsynymrtisyrkgx3}</td><td>（中継用）被転換生活収入マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynykgusdikbnx3 ztyhtnknsiktsynykgusdikbnx3}</td><td>（中継用）被転換生活収入記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx11 ztyhtnknsiktsynymrtikgybx11}</td><td>（中継用）被転換生活収入マル定記号予備＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx12 ztyhtnknsiktsynymrtikgybx12}</td><td>（中継用）被転換生活収入マル定記号予備＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx13 ztyhtnknsiktsynymrtikgybx13}</td><td>（中継用）被転換生活収入マル定記号予備＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx14 ztyhtnknsiktsynymrtikgybx14}</td><td>（中継用）被転換生活収入マル定記号予備＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx15 ztyhtnknsiktsynymrtikgybx15}</td><td>（中継用）被転換生活収入マル定記号予備＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytksyrkgx3 ztyhtnknsiktsyknbytksyrkgx3}</td><td>（中継用）被転換生活習慣病特約種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbykgsdkbnx3 ztyhtnknsiktsyknbykgsdkbnx3}</td><td>（中継用）被転換生活習慣病記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx11 ztyhtnknsiktsyknbytkkgybx11}</td><td>（中継用）被転換生活習慣病特約記号予備＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx12 ztyhtnknsiktsyknbytkkgybx12}</td><td>（中継用）被転換生活習慣病特約記号予備＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx13 ztyhtnknsiktsyknbytkkgybx13}</td><td>（中継用）被転換生活習慣病特約記号予備＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx14 ztyhtnknsiktsyknbytkkgybx14}</td><td>（中継用）被転換生活習慣病特約記号予備＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx15 ztyhtnknsiktsyknbytkkgybx15}</td><td>（中継用）被転換生活習慣病特約記号予備＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24x3 ztyyobiv24x3}</td><td>（中継用）予備項目Ｖ２４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtisyrkgx4 ztyhtnknsiktsynymrtisyrkgx4}</td><td>（中継用）被転換生活収入マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynykgusdikbnx4 ztyhtnknsiktsynykgusdikbnx4}</td><td>（中継用）被転換生活収入記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx16 ztyhtnknsiktsynymrtikgybx16}</td><td>（中継用）被転換生活収入マル定記号予備＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx17 ztyhtnknsiktsynymrtikgybx17}</td><td>（中継用）被転換生活収入マル定記号予備＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx18 ztyhtnknsiktsynymrtikgybx18}</td><td>（中継用）被転換生活収入マル定記号予備＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx19 ztyhtnknsiktsynymrtikgybx19}</td><td>（中継用）被転換生活収入マル定記号予備＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx20 ztyhtnknsiktsynymrtikgybx20}</td><td>（中継用）被転換生活収入マル定記号予備＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytksyrkgx4 ztyhtnknsiktsyknbytksyrkgx4}</td><td>（中継用）被転換生活習慣病特約種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbykgsdkbnx4 ztyhtnknsiktsyknbykgsdkbnx4}</td><td>（中継用）被転換生活習慣病記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx16 ztyhtnknsiktsyknbytkkgybx16}</td><td>（中継用）被転換生活習慣病特約記号予備＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx17 ztyhtnknsiktsyknbytkkgybx17}</td><td>（中継用）被転換生活習慣病特約記号予備＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx18 ztyhtnknsiktsyknbytkkgybx18}</td><td>（中継用）被転換生活習慣病特約記号予備＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx19 ztyhtnknsiktsyknbytkkgybx19}</td><td>（中継用）被転換生活習慣病特約記号予備＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx20 ztyhtnknsiktsyknbytkkgybx20}</td><td>（中継用）被転換生活習慣病特約記号予備＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24x4 ztyyobiv24x4}</td><td>（中継用）予備項目Ｖ２４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtisyrkgx5 ztyhtnknsiktsynymrtisyrkgx5}</td><td>（中継用）被転換生活収入マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynykgusdikbnx5 ztyhtnknsiktsynykgusdikbnx5}</td><td>（中継用）被転換生活収入記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx21 ztyhtnknsiktsynymrtikgybx21}</td><td>（中継用）被転換生活収入マル定記号予備＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx22 ztyhtnknsiktsynymrtikgybx22}</td><td>（中継用）被転換生活収入マル定記号予備＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx23 ztyhtnknsiktsynymrtikgybx23}</td><td>（中継用）被転換生活収入マル定記号予備＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx24 ztyhtnknsiktsynymrtikgybx24}</td><td>（中継用）被転換生活収入マル定記号予備＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx25 ztyhtnknsiktsynymrtikgybx25}</td><td>（中継用）被転換生活収入マル定記号予備＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytksyrkgx5 ztyhtnknsiktsyknbytksyrkgx5}</td><td>（中継用）被転換生活習慣病特約種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbykgsdkbnx5 ztyhtnknsiktsyknbykgsdkbnx5}</td><td>（中継用）被転換生活習慣病記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx21 ztyhtnknsiktsyknbytkkgybx21}</td><td>（中継用）被転換生活習慣病特約記号予備＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx22 ztyhtnknsiktsyknbytkkgybx22}</td><td>（中継用）被転換生活習慣病特約記号予備＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx23 ztyhtnknsiktsyknbytkkgybx23}</td><td>（中継用）被転換生活習慣病特約記号予備＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx24 ztyhtnknsiktsyknbytkkgybx24}</td><td>（中継用）被転換生活習慣病特約記号予備＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx25 ztyhtnknsiktsyknbytkkgybx25}</td><td>（中継用）被転換生活習慣病特約記号予備＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24x5 ztyyobiv24x5}</td><td>（中継用）予備項目Ｖ２４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtisyrkgx6 ztyhtnknsiktsynymrtisyrkgx6}</td><td>（中継用）被転換生活収入マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynykgusdikbnx6 ztyhtnknsiktsynykgusdikbnx6}</td><td>（中継用）被転換生活収入記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx26 ztyhtnknsiktsynymrtikgybx26}</td><td>（中継用）被転換生活収入マル定記号予備＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx27 ztyhtnknsiktsynymrtikgybx27}</td><td>（中継用）被転換生活収入マル定記号予備＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx28 ztyhtnknsiktsynymrtikgybx28}</td><td>（中継用）被転換生活収入マル定記号予備＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx29 ztyhtnknsiktsynymrtikgybx29}</td><td>（中継用）被転換生活収入マル定記号予備＿２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsynymrtikgybx30 ztyhtnknsiktsynymrtikgybx30}</td><td>（中継用）被転換生活収入マル定記号予備＿３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytksyrkgx6 ztyhtnknsiktsyknbytksyrkgx6}</td><td>（中継用）被転換生活習慣病特約種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbykgsdkbnx6 ztyhtnknsiktsyknbykgsdkbnx6}</td><td>（中継用）被転換生活習慣病記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx26 ztyhtnknsiktsyknbytkkgybx26}</td><td>（中継用）被転換生活習慣病特約記号予備＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx27 ztyhtnknsiktsyknbytkkgybx27}</td><td>（中継用）被転換生活習慣病特約記号予備＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx28 ztyhtnknsiktsyknbytkkgybx28}</td><td>（中継用）被転換生活習慣病特約記号予備＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx29 ztyhtnknsiktsyknbytkkgybx29}</td><td>（中継用）被転換生活習慣病特約記号予備＿２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknsiktsyknbytkkgybx30 ztyhtnknsiktsyknbytkkgybx30}</td><td>（中継用）被転換生活習慣病特約記号予備＿３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24x6 ztyyobiv24x6}</td><td>（中継用）予備項目Ｖ２４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrmkhritu ztykaiyakuhrmkhritu}</td><td>（中継用）解約返戻金目標率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitatekinitenmkhyurt ztytumitatekinitenmkhyurt}</td><td>（中継用）積立金移転目標率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv250 ztyyobiv250}</td><td>（中継用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv248 ztyyobiv248}</td><td>（中継用）予備項目Ｖ２４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu5Ty
 * @see     PKZT_Sp2RnduyuSouseiritu5Ty
 * @see     QZT_Sp2RnduyuSouseiritu5Ty
 * @see     GenQZT_Sp2RnduyuSouseiritu5Ty
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu5Ty.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu5Ty.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu5Ty extends AbstractExDBEntity<ZT_Sp2RnduyuSouseiritu5Ty, PKZT_Sp2RnduyuSouseiritu5Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu5Ty";
    public static final String ZTYKTGYSYRYMD            = "ztyktgysyrymd";
    public static final String ZTYKTGYSYONO             = "ztyktgysyono";
    public static final String ZTYKTGYFILERENNO         = "ztyktgyfilerenno";
    public static final String ZTYAATUKAISYABOSYUUDIRTNCD = "ztyaatukaisyabosyuudirtncd";
    public static final String ZTYBATUKAISYABOSYUUDIRTNCD = "ztybatukaisyabosyuudirtncd";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYKESSANKEIJYOUYM       = "ztykessankeijyouym";
    public static final String ZTYHTNKNTMTTSYUSNHKNARIHYJ = "ztyhtnkntmttsyusnhknarihyj";
    public static final String ZTYTOKUBETUHOSYOUKIKAN   = "ztytokubetuhosyoukikan";
    public static final String ZTYGOUKEINENBARAIKANSANP3X1 = "ztygoukeinenbaraikansanp3x1";
    public static final String ZTYHKTGTIKKIKKKN3X1      = "ztyhktgtikkikkkn3x1";
    public static final String ZTYKAPPADHKTGKUJYGKX1    = "ztykappadhktgkujygkx1";
    public static final String ZTYGOUKEINENBARAIKANSANP3X2 = "ztygoukeinenbaraikansanp3x2";
    public static final String ZTYHKTGTIKKIKKKN3X2      = "ztyhktgtikkikkkn3x2";
    public static final String ZTYKAPPADHKTGKUJYGKX2    = "ztykappadhktgkujygkx2";
    public static final String ZTYGOUKEINENBARAIKANSANP3X3 = "ztygoukeinenbaraikansanp3x3";
    public static final String ZTYHKTGTIKKIKKKN3X3      = "ztyhktgtikkikkkn3x3";
    public static final String ZTYKAPPADHKTGKUJYGKX3    = "ztykappadhktgkujygkx3";
    public static final String ZTYGOUKEINENBARAIKANSANP3X4 = "ztygoukeinenbaraikansanp3x4";
    public static final String ZTYHKTGTIKKIKKKN3X4      = "ztyhktgtikkikkkn3x4";
    public static final String ZTYKAPPADHKTGKUJYGKX4    = "ztykappadhktgkujygkx4";
    public static final String ZTYGOUKEINENBARAIKANSANP3X5 = "ztygoukeinenbaraikansanp3x5";
    public static final String ZTYHKTGTIKKIKKKN3X5      = "ztyhktgtikkikkkn3x5";
    public static final String ZTYKAPPADHKTGKUJYGKX5    = "ztykappadhktgkujygkx5";
    public static final String ZTYGOUKEINENBARAIKANSANP3X6 = "ztygoukeinenbaraikansanp3x6";
    public static final String ZTYHKTGTIKKIKKKN3X6      = "ztyhktgtikkikkkn3x6";
    public static final String ZTYKAPPADHKTGKUJYGKX6    = "ztykappadhktgkujygkx6";
    public static final String ZTYHUTIHNNNKKNNZMKYKSYONO = "ztyhutihnnnkknnzmkyksyono";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYMOSNYUURYOKUYMD       = "ztymosnyuuryokuymd";
    public static final String ZTYMOSSYOSAKUSEIYMD      = "ztymossyosakuseiymd";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYDAI2KOKUTIYMD         = "ztydai2kokutiymd";
    public static final String ZTYJYUURYOUSYOURYAKUKBN  = "ztyjyuuryousyouryakukbn";
    public static final String ZTYSNSNIRYUTKYKSYURUIKGU = "ztysnsniryutkyksyuruikgu";
    public static final String ZTYSENSINIRYOUTOKUYAKUKIKAN = "ztysensiniryoutokuyakukikan";
    public static final String ZTYSENSINIRYOUTKYKPHRKKKN = "ztysensiniryoutkykphrkkkn";
    public static final String ZTYSENSINIRYOUTOKUYAKUS  = "ztysensiniryoutokuyakus";
    public static final String ZTYSENSINIRYOUTOKUYAKUP  = "ztysensiniryoutokuyakup";
    public static final String ZTYSENSINIRYOUTKYKKGUSDKBN = "ztysensiniryoutkykkgusdkbn";
    public static final String ZTYSNSNIRYUTKYKKGUYBX1   = "ztysnsniryutkykkguybx1";
    public static final String ZTYSNSNIRYUTKYKKGUYBX2   = "ztysnsniryutkykkguybx2";
    public static final String ZTYSNSNIRYUTKYKKGUYBX3   = "ztysnsniryutkykkguybx3";
    public static final String ZTYSNSNIRYUTKYKKGUYBX4   = "ztysnsniryutkykkguybx4";
    public static final String ZTYSNSNIRYUTKYKKGUYBX5   = "ztysnsniryutkykkguybx5";
    public static final String ZTYSNSNIRYUTKYKPWRBKKBN  = "ztysnsniryutkykpwrbkkbn";
    public static final String ZTYSNSNIRYUTKTBICDX1     = "ztysnsniryutktbicdx1";
    public static final String ZTYSNSNIRYUHTNPKKNX1     = "ztysnsniryuhtnpkknx1";
    public static final String ZTYSNSNIRYUTKTBICDX2     = "ztysnsniryutktbicdx2";
    public static final String ZTYSNSNIRYUHTNPKKNX2     = "ztysnsniryuhtnpkknx2";
    public static final String ZTYSNSNIRYUTKYKKUSNMNRYOAGE = "ztysnsniryutkykkusnmnryoage";
    public static final String ZTYYOBIV4X17             = "ztyyobiv4x17";
    public static final String ZTYDI2SNSNIRYUTKYKSYRIKGU = "ztydi2snsniryutkyksyrikgu";
    public static final String ZTYDI2SNSNIRYUTKYKKKN    = "ztydi2snsniryutkykkkn";
    public static final String ZTYDAI2SNSNIRYUTKYKPHRKKKN = "ztydai2snsniryutkykphrkkkn";
    public static final String ZTYDAI2SENSINIRYOUTOKUYAKUS = "ztydai2sensiniryoutokuyakus";
    public static final String ZTYDAI2SENSINIRYOUTOKUYAKUP = "ztydai2sensiniryoutokuyakup";
    public static final String ZTYDI2SNSNIRYUTKYKKGUSDKBN = "ztydi2snsniryutkykkgusdkbn";
    public static final String ZTYDI2SNSNIRYUTKYKKGUYBX1 = "ztydi2snsniryutkykkguybx1";
    public static final String ZTYDI2SNSNIRYUTKYKKGUYBX2 = "ztydi2snsniryutkykkguybx2";
    public static final String ZTYDI2SNSNIRYUTKYKKGUYBX3 = "ztydi2snsniryutkykkguybx3";
    public static final String ZTYDI2SNSNIRYUTKYKKGUYBX4 = "ztydi2snsniryutkykkguybx4";
    public static final String ZTYDI2SNSNIRYUTKYKKGUYBX5 = "ztydi2snsniryutkykkguybx5";
    public static final String ZTYDI2SNSNIRYUTKYKPWRBKKBN = "ztydi2snsniryutkykpwrbkkbn";
    public static final String ZTYDI2SNSNIRYUTKTBICDX1  = "ztydi2snsniryutktbicdx1";
    public static final String ZTYDI2SNSNIRYUHTNPKKNX1  = "ztydi2snsniryuhtnpkknx1";
    public static final String ZTYDI2SNSNIRYUTKTBICDX2  = "ztydi2snsniryutktbicdx2";
    public static final String ZTYDI2SNSNIRYUHTNPKKNX2  = "ztydi2snsniryuhtnpkknx2";
    public static final String ZTYYOBIV6X3              = "ztyyobiv6x3";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYKYKSYAAGETYOUSEIHYJ   = "ztykyksyaagetyouseihyj";
    public static final String ZTYDAI2HHKNNENTYSIHYJ    = "ztydai2hhknnentysihyj";
    public static final String ZTYHSYUMNOSJDFTMTTZNDK   = "ztyhsyumnosjdftmttzndk";
    public static final String ZTYNYUINHSYUJYJTTKYKSYRIKGU = "ztynyuinhsyujyjttkyksyrikgu";
    public static final String ZTYNYUINHSYUJYUJTTKYKKKN = "ztynyuinhsyujyujttkykkkn";
    public static final String ZTYNYINHSYJYJTTKYKPHRKKKN = "ztynyinhsyjyjttkykphrkkkn";
    public static final String ZTYNYUINHSYUJYUJTTKYKS   = "ztynyuinhsyujyujttkyks";
    public static final String ZTYNYUINHSYUJYUJTTKYKP   = "ztynyuinhsyujyujttkykp";
    public static final String ZTYNYINHSYJYJTTKJYRYMSHYTN = "ztynyinhsyjyjttkjyrymshytn";
    public static final String ZTYNYUINHSYUJYUJTTKYKTKJYUP = "ztynyuinhsyujyujttkyktkjyup";
    public static final String ZTYNYUINHSYUJYUJTTKTBICDX1 = "ztynyuinhsyujyujttktbicdx1";
    public static final String ZTYNYUINHSYUJYUJTHTNPKKNX1 = "ztynyuinhsyujyujthtnpkknx1";
    public static final String ZTYNYUINHSYUJYUJTTKTBICDX2 = "ztynyuinhsyujyujttktbicdx2";
    public static final String ZTYNYUINHSYUJYUJTHTNPKKNX2 = "ztynyuinhsyujyujthtnpkknx2";
    public static final String ZTYNYINHSYJYJTTKYKKGUSDKBN = "ztynyinhsyjyjttkykkgusdkbn";
    public static final String ZTYNYINHSYJYJTTKYKPWRBKKBN = "ztynyinhsyjyjttkykpwrbkkbn";
    public static final String ZTYNYUINHSYUJYJTTKYKKGUYBX1 = "ztynyuinhsyujyjttkykkguybx1";
    public static final String ZTYNYUINHSYUJYJTTKYKKGUYBX2 = "ztynyuinhsyujyjttkykkguybx2";
    public static final String ZTYNYUINHSYUJYJTTKYKKGUYBX3 = "ztynyuinhsyujyjttkykkguybx3";
    public static final String ZTYNYUINHSYUJYJTTKYKKGUYBX4 = "ztynyuinhsyujyjttkykkguybx4";
    public static final String ZTYNYUINHSYUJYJTTKYKKGUYBX5 = "ztynyuinhsyujyjttkykkguybx5";
    public static final String ZTYNYINHSYJYJTKYKKSNMNRYAGE = "ztynyinhsyjyjtkykksnmnryage";
    public static final String ZTYYOBIV5X4              = "ztyyobiv5x4";
    public static final String ZTYDI2NYINHSYJYJTTKYKSYRIKG = "ztydi2nyinhsyjyjttkyksyrikg";
    public static final String ZTYDI2NYUINHSYUJYUJTTKYKKKN = "ztydi2nyuinhsyujyujttkykkkn";
    public static final String ZTYDI2NYUINHSYUJYJTPHRKKKN = "ztydi2nyuinhsyujyjtphrkkkn";
    public static final String ZTYDI2NYUINHSYUJYUJTTKYKS = "ztydi2nyuinhsyujyujttkyks";
    public static final String ZTYDI2NYUINHSYUJYUJTTKYKP = "ztydi2nyuinhsyujyujttkykp";
    public static final String ZTYDI2NYHSYJYJTTKJYRYMSHYTN = "ztydi2nyhsyjyjttkjyrymshytn";
    public static final String ZTYDI2NYUINHSYUJYUJTTKJYUP = "ztydi2nyuinhsyujyujttkjyup";
    public static final String ZTYDI2NYUINHSYUTKTBICDX1 = "ztydi2nyuinhsyutktbicdx1";
    public static final String ZTYDI2NYUINHSYUHTNPKKNX1 = "ztydi2nyuinhsyuhtnpkknx1";
    public static final String ZTYDI2NYUINHSYUTKTBICDX2 = "ztydi2nyuinhsyutktbicdx2";
    public static final String ZTYDI2NYUINHSYUHTNPKKNX2 = "ztydi2nyuinhsyuhtnpkknx2";
    public static final String ZTYDI2NYINHSYUJYJTKGUSDKBN = "ztydi2nyinhsyujyjtkgusdkbn";
    public static final String ZTYDI2NYUINHSYUJYJTPWRBKKBN = "ztydi2nyuinhsyujyjtpwrbkkbn";
    public static final String ZTYDI2NYINHSYJYJTTKYKKGYBX1 = "ztydi2nyinhsyjyjttkykkgybx1";
    public static final String ZTYDI2NYINHSYJYJTTKYKKGYBX2 = "ztydi2nyinhsyjyjttkykkgybx2";
    public static final String ZTYDI2NYINHSYJYJTTKYKKGYBX3 = "ztydi2nyinhsyjyjttkykkgybx3";
    public static final String ZTYDI2NYINHSYJYJTTKYKKGYBX4 = "ztydi2nyinhsyjyjttkykkgybx4";
    public static final String ZTYDI2NYINHSYJYJTTKYKKGYBX5 = "ztydi2nyinhsyjyjttkykkgybx5";
    public static final String ZTYYOBIV7X6              = "ztyyobiv7x6";
    public static final String ZTYYOBIV1X4              = "ztyyobiv1x4";
    public static final String ZTYWNASITNKNKAKAKUJYUTUKBN = "ztywnasitnknkakakujyutukbn";
    public static final String ZTYGOUKEIWNASITENKANKAKAKU = "ztygoukeiwnasitenkankakaku";
    public static final String ZTYGUKIWNSTNKNITJBRNKNENGK = "ztygukiwnstnknitjbrnknengk";
    public static final String ZTYGUKIWNASITNKNITJBRTIKS = "ztygukiwnasitnknitjbrtiks";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIV9X11             = "ztyyobiv9x11";
    public static final String ZTYSUGUIRYUTKYKSYURUIKGU = "ztysuguiryutkyksyuruikgu";
    public static final String ZTYSOUGOUIRYOUTOKUYAKUKIKAN = "ztysougouiryoutokuyakukikan";
    public static final String ZTYSUGUIRYUTKYKPHRKKKN   = "ztysuguiryutkykphrkkkn";
    public static final String ZTYSUGUIRYUTKYKNTGK      = "ztysuguiryutkykntgk";
    public static final String ZTYSOUGOUIRYOUTOKUYAKUP  = "ztysougouiryoutokuyakup";
    public static final String ZTYSUGUIRYUTKJYURYUMSHYUTN = "ztysuguiryutkjyuryumshyutn";
    public static final String ZTYSOUGOUIRYOUTOKUJYOUP  = "ztysougouiryoutokujyoup";
    public static final String ZTYSUGUIRYUTKTBICDX1     = "ztysuguiryutktbicdx1";
    public static final String ZTYSUGUIRYUHTNPKKNX1     = "ztysuguiryuhtnpkknx1";
    public static final String ZTYSUGUIRYUTKTBICDX2     = "ztysuguiryutktbicdx2";
    public static final String ZTYSUGUIRYUHTNPKKNX2     = "ztysuguiryuhtnpkknx2";
    public static final String ZTYSUGUIRYUTKYKKGUSDKBN  = "ztysuguiryutkykkgusdkbn";
    public static final String ZTYSUGUIRYUTKYKPWRBKKBN  = "ztysuguiryutkykpwrbkkbn";
    public static final String ZTYSUGUIRYUTKYKKGUYBX1   = "ztysuguiryutkykkguybx1";
    public static final String ZTYSUGUIRYUTKYKKGUYBX2   = "ztysuguiryutkykkguybx2";
    public static final String ZTYSUGUIRYUTKYKKGUYBX3   = "ztysuguiryutkykkguybx3";
    public static final String ZTYSUGUIRYUTKYKKGUYBX4   = "ztysuguiryutkykkguybx4";
    public static final String ZTYSUGUIRYUTKYKKGUYBX5   = "ztysuguiryutkykkguybx5";
    public static final String ZTYSUGUIRYUTKYKKUSNMNRYOAGE = "ztysuguiryutkykkusnmnryoage";
    public static final String ZTYYOBIV7X7              = "ztyyobiv7x7";
    public static final String ZTYDI2SUGUIRYUTKYKSYRIKGU = "ztydi2suguiryutkyksyrikgu";
    public static final String ZTYDI2SUGUIRYUTKYKKKN    = "ztydi2suguiryutkykkkn";
    public static final String ZTYDI2SUGUIRYUTKYKPHRKKKN = "ztydi2suguiryutkykphrkkkn";
    public static final String ZTYDI2SUGUIRYUTKYKNTGK   = "ztydi2suguiryutkykntgk";
    public static final String ZTYDAI2SOUGOUIRYOUTOKUYAKUP = "ztydai2sougouiryoutokuyakup";
    public static final String ZTYDI2SUGUIRYUTKJYURYMSHYTN = "ztydi2suguiryutkjyurymshytn";
    public static final String ZTYDAI2SOUGOUIRYOUTOKUJYOUP = "ztydai2sougouiryoutokujyoup";
    public static final String ZTYDI2SUGUIRYUTKTBICDX1  = "ztydi2suguiryutktbicdx1";
    public static final String ZTYDI2SUGUIRYUHTNPKKNX1  = "ztydi2suguiryuhtnpkknx1";
    public static final String ZTYDI2SUGUIRYUTKTBICDX2  = "ztydi2suguiryutktbicdx2";
    public static final String ZTYDI2SUGUIRYUHTNPKKNX2  = "ztydi2suguiryuhtnpkknx2";
    public static final String ZTYDI2SUGUIRYUTKYKKGUSDKBN = "ztydi2suguiryutkykkgusdkbn";
    public static final String ZTYDI2SUGUIRYUTKYKPWRBKKBN = "ztydi2suguiryutkykpwrbkkbn";
    public static final String ZTYDI2SUGUIRYUTKYKKGUYBX1 = "ztydi2suguiryutkykkguybx1";
    public static final String ZTYDI2SUGUIRYUTKYKKGUYBX2 = "ztydi2suguiryutkykkguybx2";
    public static final String ZTYDI2SUGUIRYUTKYKKGUYBX3 = "ztydi2suguiryutkykkguybx3";
    public static final String ZTYDI2SUGUIRYUTKYKKGUYBX4 = "ztydi2suguiryutkykkguybx4";
    public static final String ZTYDI2SUGUIRYUTKYKKGUYBX5 = "ztydi2suguiryutkykkguybx5";
    public static final String ZTYYOBIV9X12             = "ztyyobiv9x12";
    public static final String ZTYDAI2GANNYUINTKYKSYRIKGU = "ztydai2gannyuintkyksyrikgu";
    public static final String ZTYDAI2GANNYUINTKYKKKN   = "ztydai2gannyuintkykkkn";
    public static final String ZTYDAI2GANNYUINTKYKPHRKKKN = "ztydai2gannyuintkykphrkkkn";
    public static final String ZTYDAI2GANNYUINTKYKNTGK  = "ztydai2gannyuintkykntgk";
    public static final String ZTYDAI2GANNYUUINTOKUYAKUP = "ztydai2gannyuuintokuyakup";
    public static final String ZTYDAI2GANNYUINTKYKKGUSDKBN = "ztydai2gannyuintkykkgusdkbn";
    public static final String ZTYDI2GANNYUINTKYKKGUYOBIX1 = "ztydi2gannyuintkykkguyobix1";
    public static final String ZTYDI2GANNYUINTKYKKGUYOBIX2 = "ztydi2gannyuintkykkguyobix2";
    public static final String ZTYDI2GANNYUINTKYKKGUYOBIX3 = "ztydi2gannyuintkykkguyobix3";
    public static final String ZTYDI2GANNYUINTKYKKGUYOBIX4 = "ztydi2gannyuintkykkguyobix4";
    public static final String ZTYDI2GANNYUINTKYKKGUYOBIX5 = "ztydi2gannyuintkykkguyobix5";
    public static final String ZTYDAI2GANNYUINTKYKPWRBKKBN = "ztydai2gannyuintkykpwrbkkbn";
    public static final String ZTYYOBIV6X4              = "ztyyobiv6x4";
    public static final String ZTYGUKIHTNKNSUGUIRYTKYKNTGK = "ztygukihtnknsuguirytkykntgk";
    public static final String ZTYHIJYNBRIMARUSYUUSYRIKGU = "ztyhijynbrimarusyuusyrikgu";
    public static final String ZTYHIJYNBRIMRSYUKGUSDKBN = "ztyhijynbrimrsyukgusdkbn";
    public static final String ZTYHIJYNBRIMARUSYUUKGUYBX1 = "ztyhijynbrimarusyuukguybx1";
    public static final String ZTYHIJYNBRIMARUSYUUKGUYBX2 = "ztyhijynbrimarusyuukguybx2";
    public static final String ZTYHIJYNBRIMARUSYUUKGUYBX3 = "ztyhijynbrimarusyuukguybx3";
    public static final String ZTYHIJYNBRIMARUSYUUKGUYBX4 = "ztyhijynbrimarusyuukguybx4";
    public static final String ZTYHIJYNBRIMARUSYUUKGUYBX5 = "ztyhijynbrimarusyuukguybx5";
    public static final String ZTYHIJYNBRIMARUSYUUKKN   = "ztyhijynbrimarusyuukkn";
    public static final String ZTYHIJYNBRIMRSYPHRKKKN   = "ztyhijynbrimrsyphrkkkn";
    public static final String ZTYHIJYNBRIMARUSYUUTKYKS = "ztyhijynbrimarusyuutkyks";
    public static final String ZTYHIJYNBRIMARUSYUUTKYKP = "ztyhijynbrimarusyuutkykp";
    public static final String ZTYHIJYNBRIMRSYPWRBKKBN  = "ztyhijynbrimrsypwrbkkbn";
    public static final String ZTYHIJYNBRIMARUSYUUMODS  = "ztyhijynbrimarusyuumods";
    public static final String ZTYHIJYNBRIMARUSYUUTKJYUKBN = "ztyhijynbrimarusyuutkjyukbn";
    public static final String ZTYHIJYNBRIMRSYTKJYUSKGNKKN = "ztyhijynbrimrsytkjyuskgnkkn";
    public static final String ZTYHIJYNBRMRSYTKJYURYMSHYTN = "ztyhijynbrmrsytkjyurymshytn";
    public static final String ZTYHIJYNBRIMARUSYUUTKJYUP = "ztyhijynbrimarusyuutkjyup";
    public static final String ZTYHIJYNBRMRSYTNKNYGRYRTKBN = "ztyhijynbrmrsytnknygryrtkbn";
    public static final String ZTYYOBIV4X18             = "ztyyobiv4x18";
    public static final String ZTYTOKUTEIJYOUTAIHUSHRHYJ = "ztytokuteijyoutaihushrhyj";
    public static final String ZTYMOSJIKAIGOS           = "ztymosjikaigos";
    public static final String ZTYMOSJIDI2HKNKKNSYUUSNS = "ztymosjidi2hknkknsyuusns";
    public static final String ZTYGANSNDNTKYKSYRIKGU    = "ztygansndntkyksyrikgu";
    public static final String ZTYGANSNDNTKYKKGUSDKBN   = "ztygansndntkykkgusdkbn";
    public static final String ZTYGANSNDNTKYKKGUYBX1    = "ztygansndntkykkguybx1";
    public static final String ZTYGANSNDNTKYKKGUYBX2    = "ztygansndntkykkguybx2";
    public static final String ZTYGANSNDNTKYKKGUYBX3    = "ztygansndntkykkguybx3";
    public static final String ZTYGANSNDNTKYKKGUYBX4    = "ztygansndntkykkguybx4";
    public static final String ZTYGANSNDNTKYKKGUYBX5    = "ztygansndntkykkguybx5";
    public static final String ZTYGANSINDANTOKUYAKUKIKAN = "ztygansindantokuyakukikan";
    public static final String ZTYGANSNDNTKYKPHRKKKN    = "ztygansndntkykphrkkkn";
    public static final String ZTYGANSINDANTOKUYAKUS    = "ztygansindantokuyakus";
    public static final String ZTYGANSINDANTOKUYAKUP    = "ztygansindantokuyakup";
    public static final String ZTYGANSNDNTKYKPWRBKKBN   = "ztygansndntkykpwrbkkbn";
    public static final String ZTYGANSNDNTKYKTAIKKNBBNS = "ztygansndntkyktaikknbbns";
    public static final String ZTYJYOUHINAIGANMTKKNBBNS = "ztyjyouhinaiganmtkknbbns";
    public static final String ZTYGNSNDNTKYKKUSNMNRYOAGE = "ztygnsndntkykkusnmnryoage";
    public static final String ZTYYOBIV10X5             = "ztyyobiv10x5";
    public static final String ZTYGANYKBTTRYUTKYKSYRIKGU = "ztyganykbttryutkyksyrikgu";
    public static final String ZTYGANYKBTTRYUTKYKKGUSDKBN = "ztyganykbttryutkykkgusdkbn";
    public static final String ZTYGANYKBTTRYUTKYKKGUYBX1 = "ztyganykbttryutkykkguybx1";
    public static final String ZTYGANYKBTTRYUTKYKKGUYBX2 = "ztyganykbttryutkykkguybx2";
    public static final String ZTYGANYKBTTRYUTKYKKGUYBX3 = "ztyganykbttryutkykkguybx3";
    public static final String ZTYGANYKBTTRYUTKYKKGUYBX4 = "ztyganykbttryutkykkguybx4";
    public static final String ZTYGANYKBTTRYUTKYKKGUYBX5 = "ztyganykbttryutkykkguybx5";
    public static final String ZTYGANYKBTTRYUTKYKKKN    = "ztyganykbttryutkykkkn";
    public static final String ZTYGANYKBTTRYUTKYKPHRKKKN = "ztyganykbttryutkykphrkkkn";
    public static final String ZTYGANYKBTTRYUTKYKS      = "ztyganykbttryutkyks";
    public static final String ZTYGANYKBTTRYUTKYKP      = "ztyganykbttryutkykp";
    public static final String ZTYGANYKBTTRYUTKYKPWRBKKBN = "ztyganykbttryutkykpwrbkkbn";
    public static final String ZTYGNYKBTTRYUTKYKKSNMNRYAGE = "ztygnykbttryutkykksnmnryage";
    public static final String ZTYYOBIV12X11            = "ztyyobiv12x11";
    public static final String ZTYGUKIHTNKNGANSNDNTKYKS = "ztygukihtnkngansndntkyks";
    public static final String ZTYGUKIHTNKNGANYKBTTRYTKYKS = "ztygukihtnknganykbttrytkyks";
    public static final String ZTYSINKEIYAKUJIYOTEIRIRITU = "ztysinkeiyakujiyoteiriritu";
    public static final String ZTYKOUSINMANRYOUAGE      = "ztykousinmanryouage";
    public static final String ZTYSEIZONMRTIKUSNMNRYOAGE = "ztyseizonmrtikusnmnryoage";
    public static final String ZTYTEIGENMRTIKUSNMNRYOAGE = "ztyteigenmrtikusnmnryoage";
    public static final String ZTYSIKTSYUNYUMRTISYRI    = "ztysiktsyunyumrtisyri";
    public static final String ZTYSIKTSYUNYUMRTIKGUSDIKBN = "ztysiktsyunyumrtikgusdikbn";
    public static final String ZTYSIKTSYUNYUMRTIKGUYOBI = "ztysiktsyunyumrtikguyobi";
    public static final String ZTYSIKTSYUNYUMRTIKGUYOBIX2 = "ztysiktsyunyumrtikguyobix2";
    public static final String ZTYSIKTSYUNYUMRTIKGUYOBIX3 = "ztysiktsyunyumrtikguyobix3";
    public static final String ZTYSIKTSYUNYUMRTIKGUYOBIX4 = "ztysiktsyunyumrtikguyobix4";
    public static final String ZTYSIKTSYUNYUMRTIKGUYOBIX5 = "ztysiktsyunyumrtikguyobix5";
    public static final String ZTYSIKTSYUNYUMRTIKTKBN   = "ztysiktsyunyumrtiktkbn";
    public static final String ZTYSIKTSYUNYUMRTISYUGIKTKBN = "ztysiktsyunyumrtisyugiktkbn";
    public static final String ZTYSEIKATUSYUUNYUUMRTIKKN = "ztyseikatusyuunyuumrtikkn";
    public static final String ZTYSIKTSYUNYUMRTIPHRIKMKBN = "ztysiktsyunyumrtiphrikmkbn";
    public static final String ZTYSIKTSYUNYUMRTISHRIKKN = "ztysiktsyunyumrtishrikkn";
    public static final String ZTYSIKTSYNYUMRTITNKNWRBKKBN = "ztysiktsynyumrtitnknwrbkkbn";
    public static final String ZTYSRSIKTSYUNYUMRTIPWRBKKBN = "ztysrsiktsyunyumrtipwrbkkbn";
    public static final String ZTYSIKTSYUNYUMRTIPWRBKKBN = "ztysiktsyunyumrtipwrbkkbn";
    public static final String ZTYSIKTSYUNYUMRTIKSNMNRYUNN = "ztysiktsyunyumrtiksnmnryunn";
    public static final String ZTYSIKTSYUNYUMRTINNKNNNGK = "ztysiktsyunyumrtinnknnngk";
    public static final String ZTYSEIKATUSYUUNYUUMRTIS  = "ztyseikatusyuunyuumrtis";
    public static final String ZTYSIKTSYUNYUMRTIITJKNKS = "ztysiktsyunyumrtiitjknks";
    public static final String ZTYSEIKATUSYUUNYUUMRTIP  = "ztyseikatusyuunyuumrtip";
    public static final String ZTYSIKTSYUNYUMRTISYUUSEIS = "ztysiktsyunyumrtisyuuseis";
    public static final String ZTYSIKTSYUNYUMRTITKJYUKBN = "ztysiktsyunyumrtitkjyukbn";
    public static final String ZTYSIKTSYNYMRTITKJYRYMSHYTN = "ztysiktsynymrtitkjyrymshytn";
    public static final String ZTYSIKTSYUNYUMRTITKJYUP  = "ztysiktsyunyumrtitkjyup";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYSIKTSYUKNBYUTKYKSYRIKGU = "ztysiktsyuknbyutkyksyrikgu";
    public static final String ZTYSIKTSYUKNBYUTKYKKGSDIKBN = "ztysiktsyuknbyutkykkgsdikbn";
    public static final String ZTYSIKTSYUKNBYUTKYKKGUYBI = "ztysiktsyuknbyutkykkguybi";
    public static final String ZTYSIKTSYUKNBYUTKYKKGUYBIX2 = "ztysiktsyuknbyutkykkguybix2";
    public static final String ZTYSIKTSYUKNBYUTKYKKGUYBIX3 = "ztysiktsyuknbyutkykkguybix3";
    public static final String ZTYSIKTSYUKNBYUTKYKKGUYBIX4 = "ztysiktsyuknbyutkykkguybix4";
    public static final String ZTYSIKTSYUKNBYUTKYKKGUYBIX5 = "ztysiktsyuknbyutkykkguybix5";
    public static final String ZTYSIKTSYUKNBYUTKYKKKN   = "ztysiktsyuknbyutkykkkn";
    public static final String ZTYSIKTSYUKNBYUTKYKPHRKMKKN = "ztysiktsyuknbyutkykphrkmkkn";
    public static final String ZTYSIKTSYKNBYTYKTNKNWRBKKBN = "ztysiktsyknbytyktnknwrbkkbn";
    public static final String ZTYSRSIKTSYUKNBYUTKPWRBKKBN = "ztysrsiktsyuknbyutkpwrbkkbn";
    public static final String ZTYSIKTSYUKNBYUTKYKPWRBKKBN = "ztysiktsyuknbyutkykpwrbkkbn";
    public static final String ZTYSIKTSYKNBYTKYKKUSNMNRYNN = "ztysiktsyknbytkykkusnmnrynn";
    public static final String ZTYSIKTSYUKNBYUTKYKS     = "ztysiktsyuknbyutkyks";
    public static final String ZTYSIKTSYUKNBYUTKYKP     = "ztysiktsyuknbyutkykp";
    public static final String ZTYSIKTSYUKNBYUTKYKTIKKNARS = "ztysiktsyuknbyutkyktikknars";
    public static final String ZTYSIKTSYUKNBYUTKYKSYUSIS = "ztysiktsyuknbyutkyksyusis";
    public static final String ZTYSIKTSYUKNBYUTKJYUKBN  = "ztysiktsyuknbyutkjyukbn";
    public static final String ZTYSIKTSYUKNBYUTKJYRYMSHYTN = "ztysiktsyuknbyutkjyrymshytn";
    public static final String ZTYSIKTSYUKNBYUTKJYUP    = "ztysiktsyuknbyutkjyup";
    public static final String ZTYSIKTSYUKNBYUTKTIBICD  = "ztysiktsyuknbyutktibicd";
    public static final String ZTYSIKTSYUKNBYUHTNPKKN   = "ztysiktsyuknbyuhtnpkkn";
    public static final String ZTYSIKTSYUKNBYUTKTIBICDX2 = "ztysiktsyuknbyutktibicdx2";
    public static final String ZTYSIKTSYUKNBYUHTNPKKNX2 = "ztysiktsyuknbyuhtnpkknx2";
    public static final String ZTYYOBIV19               = "ztyyobiv19";
    public static final String ZTYHTNKNSIKTSYNYMRTISYRKG = "ztyhtnknsiktsynymrtisyrkg";
    public static final String ZTYHTNKNSIKTSYNYKGUSDIKBN = "ztyhtnknsiktsynykgusdikbn";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYB = "ztyhtnknsiktsynymrtikgyb";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX2 = "ztyhtnknsiktsynymrtikgybx2";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX3 = "ztyhtnknsiktsynymrtikgybx3";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX4 = "ztyhtnknsiktsynymrtikgybx4";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX5 = "ztyhtnknsiktsynymrtikgybx5";
    public static final String ZTYHTNKNSIKTSYKNBYTKSYRKG = "ztyhtnknsiktsyknbytksyrkg";
    public static final String ZTYHTNKNSIKTSYKNBYKGSDKBN = "ztyhtnknsiktsyknbykgsdkbn";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYB = "ztyhtnknsiktsyknbytkkgyb";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX2 = "ztyhtnknsiktsyknbytkkgybx2";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX3 = "ztyhtnknsiktsyknbytkkgybx3";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX4 = "ztyhtnknsiktsyknbytkkgybx4";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX5 = "ztyhtnknsiktsyknbytkkgybx5";
    public static final String ZTYYOBIV24               = "ztyyobiv24";
    public static final String ZTYHTNKNSIKTSYNYMRTISYRKGX2 = "ztyhtnknsiktsynymrtisyrkgx2";
    public static final String ZTYHTNKNSIKTSYNYKGUSDIKBNX2 = "ztyhtnknsiktsynykgusdikbnx2";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX6 = "ztyhtnknsiktsynymrtikgybx6";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX7 = "ztyhtnknsiktsynymrtikgybx7";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX8 = "ztyhtnknsiktsynymrtikgybx8";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX9 = "ztyhtnknsiktsynymrtikgybx9";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX10 = "ztyhtnknsiktsynymrtikgybx10";
    public static final String ZTYHTNKNSIKTSYKNBYTKSYRKGX2 = "ztyhtnknsiktsyknbytksyrkgx2";
    public static final String ZTYHTNKNSIKTSYKNBYKGSDKBNX2 = "ztyhtnknsiktsyknbykgsdkbnx2";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX6 = "ztyhtnknsiktsyknbytkkgybx6";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX7 = "ztyhtnknsiktsyknbytkkgybx7";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX8 = "ztyhtnknsiktsyknbytkkgybx8";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX9 = "ztyhtnknsiktsyknbytkkgybx9";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX10 = "ztyhtnknsiktsyknbytkkgybx10";
    public static final String ZTYYOBIV24X2             = "ztyyobiv24x2";
    public static final String ZTYHTNKNSIKTSYNYMRTISYRKGX3 = "ztyhtnknsiktsynymrtisyrkgx3";
    public static final String ZTYHTNKNSIKTSYNYKGUSDIKBNX3 = "ztyhtnknsiktsynykgusdikbnx3";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX11 = "ztyhtnknsiktsynymrtikgybx11";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX12 = "ztyhtnknsiktsynymrtikgybx12";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX13 = "ztyhtnknsiktsynymrtikgybx13";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX14 = "ztyhtnknsiktsynymrtikgybx14";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX15 = "ztyhtnknsiktsynymrtikgybx15";
    public static final String ZTYHTNKNSIKTSYKNBYTKSYRKGX3 = "ztyhtnknsiktsyknbytksyrkgx3";
    public static final String ZTYHTNKNSIKTSYKNBYKGSDKBNX3 = "ztyhtnknsiktsyknbykgsdkbnx3";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX11 = "ztyhtnknsiktsyknbytkkgybx11";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX12 = "ztyhtnknsiktsyknbytkkgybx12";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX13 = "ztyhtnknsiktsyknbytkkgybx13";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX14 = "ztyhtnknsiktsyknbytkkgybx14";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX15 = "ztyhtnknsiktsyknbytkkgybx15";
    public static final String ZTYYOBIV24X3             = "ztyyobiv24x3";
    public static final String ZTYHTNKNSIKTSYNYMRTISYRKGX4 = "ztyhtnknsiktsynymrtisyrkgx4";
    public static final String ZTYHTNKNSIKTSYNYKGUSDIKBNX4 = "ztyhtnknsiktsynykgusdikbnx4";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX16 = "ztyhtnknsiktsynymrtikgybx16";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX17 = "ztyhtnknsiktsynymrtikgybx17";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX18 = "ztyhtnknsiktsynymrtikgybx18";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX19 = "ztyhtnknsiktsynymrtikgybx19";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX20 = "ztyhtnknsiktsynymrtikgybx20";
    public static final String ZTYHTNKNSIKTSYKNBYTKSYRKGX4 = "ztyhtnknsiktsyknbytksyrkgx4";
    public static final String ZTYHTNKNSIKTSYKNBYKGSDKBNX4 = "ztyhtnknsiktsyknbykgsdkbnx4";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX16 = "ztyhtnknsiktsyknbytkkgybx16";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX17 = "ztyhtnknsiktsyknbytkkgybx17";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX18 = "ztyhtnknsiktsyknbytkkgybx18";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX19 = "ztyhtnknsiktsyknbytkkgybx19";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX20 = "ztyhtnknsiktsyknbytkkgybx20";
    public static final String ZTYYOBIV24X4             = "ztyyobiv24x4";
    public static final String ZTYHTNKNSIKTSYNYMRTISYRKGX5 = "ztyhtnknsiktsynymrtisyrkgx5";
    public static final String ZTYHTNKNSIKTSYNYKGUSDIKBNX5 = "ztyhtnknsiktsynykgusdikbnx5";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX21 = "ztyhtnknsiktsynymrtikgybx21";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX22 = "ztyhtnknsiktsynymrtikgybx22";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX23 = "ztyhtnknsiktsynymrtikgybx23";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX24 = "ztyhtnknsiktsynymrtikgybx24";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX25 = "ztyhtnknsiktsynymrtikgybx25";
    public static final String ZTYHTNKNSIKTSYKNBYTKSYRKGX5 = "ztyhtnknsiktsyknbytksyrkgx5";
    public static final String ZTYHTNKNSIKTSYKNBYKGSDKBNX5 = "ztyhtnknsiktsyknbykgsdkbnx5";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX21 = "ztyhtnknsiktsyknbytkkgybx21";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX22 = "ztyhtnknsiktsyknbytkkgybx22";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX23 = "ztyhtnknsiktsyknbytkkgybx23";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX24 = "ztyhtnknsiktsyknbytkkgybx24";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX25 = "ztyhtnknsiktsyknbytkkgybx25";
    public static final String ZTYYOBIV24X5             = "ztyyobiv24x5";
    public static final String ZTYHTNKNSIKTSYNYMRTISYRKGX6 = "ztyhtnknsiktsynymrtisyrkgx6";
    public static final String ZTYHTNKNSIKTSYNYKGUSDIKBNX6 = "ztyhtnknsiktsynykgusdikbnx6";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX26 = "ztyhtnknsiktsynymrtikgybx26";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX27 = "ztyhtnknsiktsynymrtikgybx27";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX28 = "ztyhtnknsiktsynymrtikgybx28";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX29 = "ztyhtnknsiktsynymrtikgybx29";
    public static final String ZTYHTNKNSIKTSYNYMRTIKGYBX30 = "ztyhtnknsiktsynymrtikgybx30";
    public static final String ZTYHTNKNSIKTSYKNBYTKSYRKGX6 = "ztyhtnknsiktsyknbytksyrkgx6";
    public static final String ZTYHTNKNSIKTSYKNBYKGSDKBNX6 = "ztyhtnknsiktsyknbykgsdkbnx6";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX26 = "ztyhtnknsiktsyknbytkkgybx26";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX27 = "ztyhtnknsiktsyknbytkkgybx27";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX28 = "ztyhtnknsiktsyknbytkkgybx28";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX29 = "ztyhtnknsiktsyknbytkkgybx29";
    public static final String ZTYHTNKNSIKTSYKNBYTKKGYBX30 = "ztyhtnknsiktsyknbytkkgybx30";
    public static final String ZTYYOBIV24X6             = "ztyyobiv24x6";
    public static final String ZTYKAIYAKUHRMKHRITU      = "ztykaiyakuhrmkhritu";
    public static final String ZTYTUMITATEKINITENMKHYURT = "ztytumitatekinitenmkhyurt";
    public static final String ZTYYOBIV250              = "ztyyobiv250";
    public static final String ZTYYOBIV248              = "ztyyobiv248";

    private final PKZT_Sp2RnduyuSouseiritu5Ty primaryKey;

    public GenZT_Sp2RnduyuSouseiritu5Ty() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu5Ty();
    }

    public GenZT_Sp2RnduyuSouseiritu5Ty(String pZtyktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu5Ty(pZtyktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu5Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu5Ty> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu5Ty.class;
    }

    private String ztyktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKTGYSYRYMD)
    public String getZtyktgysyrymd() {
        return ztyktgysyrymd;
    }

    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        ztyktgysyrymd = pZtyktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKTGYSYONO)
    public String getZtyktgysyono() {
        return getPrimaryKey().getZtyktgysyono();
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        getPrimaryKey().setZtyktgysyono(pZtyktgysyono);
    }

    private String ztyktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKTGYFILERENNO)
    public String getZtyktgyfilerenno() {
        return ztyktgyfilerenno;
    }

    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        ztyktgyfilerenno = pZtyktgyfilerenno;
    }

    private String ztyaatukaisyabosyuudirtncd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYAATUKAISYABOSYUUDIRTNCD)
    public String getZtyaatukaisyabosyuudirtncd() {
        return ztyaatukaisyabosyuudirtncd;
    }

    public void setZtyaatukaisyabosyuudirtncd(String pZtyaatukaisyabosyuudirtncd) {
        ztyaatukaisyabosyuudirtncd = pZtyaatukaisyabosyuudirtncd;
    }

    private String ztybatukaisyabosyuudirtncd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYBATUKAISYABOSYUUDIRTNCD)
    public String getZtybatukaisyabosyuudirtncd() {
        return ztybatukaisyabosyuudirtncd;
    }

    public void setZtybatukaisyabosyuudirtncd(String pZtybatukaisyabosyuudirtncd) {
        ztybatukaisyabosyuudirtncd = pZtybatukaisyabosyuudirtncd;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztykessankeijyouym;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKESSANKEIJYOUYM)
    public String getZtykessankeijyouym() {
        return ztykessankeijyouym;
    }

    public void setZtykessankeijyouym(String pZtykessankeijyouym) {
        ztykessankeijyouym = pZtykessankeijyouym;
    }

    private String ztyhtnkntmttsyusnhknarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNTMTTSYUSNHKNARIHYJ)
    public String getZtyhtnkntmttsyusnhknarihyj() {
        return ztyhtnkntmttsyusnhknarihyj;
    }

    public void setZtyhtnkntmttsyusnhknarihyj(String pZtyhtnkntmttsyusnhknarihyj) {
        ztyhtnkntmttsyusnhknarihyj = pZtyhtnkntmttsyusnhknarihyj;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private Long ztygoukeinenbaraikansanp3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEINENBARAIKANSANP3X1)
    public Long getZtygoukeinenbaraikansanp3x1() {
        return ztygoukeinenbaraikansanp3x1;
    }

    public void setZtygoukeinenbaraikansanp3x1(Long pZtygoukeinenbaraikansanp3x1) {
        ztygoukeinenbaraikansanp3x1 = pZtygoukeinenbaraikansanp3x1;
    }

    private String ztyhktgtikkikkkn3x1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHKTGTIKKIKKKN3X1)
    public String getZtyhktgtikkikkkn3x1() {
        return ztyhktgtikkikkkn3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x1(String pZtyhktgtikkikkkn3x1) {
        ztyhktgtikkikkkn3x1 = pZtyhktgtikkikkkn3x1;
    }

    private Long ztykappadhktgkujygkx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAPPADHKTGKUJYGKX1)
    public Long getZtykappadhktgkujygkx1() {
        return ztykappadhktgkujygkx1;
    }

    public void setZtykappadhktgkujygkx1(Long pZtykappadhktgkujygkx1) {
        ztykappadhktgkujygkx1 = pZtykappadhktgkujygkx1;
    }

    private Long ztygoukeinenbaraikansanp3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEINENBARAIKANSANP3X2)
    public Long getZtygoukeinenbaraikansanp3x2() {
        return ztygoukeinenbaraikansanp3x2;
    }

    public void setZtygoukeinenbaraikansanp3x2(Long pZtygoukeinenbaraikansanp3x2) {
        ztygoukeinenbaraikansanp3x2 = pZtygoukeinenbaraikansanp3x2;
    }

    private String ztyhktgtikkikkkn3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHKTGTIKKIKKKN3X2)
    public String getZtyhktgtikkikkkn3x2() {
        return ztyhktgtikkikkkn3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x2(String pZtyhktgtikkikkkn3x2) {
        ztyhktgtikkikkkn3x2 = pZtyhktgtikkikkkn3x2;
    }

    private Long ztykappadhktgkujygkx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAPPADHKTGKUJYGKX2)
    public Long getZtykappadhktgkujygkx2() {
        return ztykappadhktgkujygkx2;
    }

    public void setZtykappadhktgkujygkx2(Long pZtykappadhktgkujygkx2) {
        ztykappadhktgkujygkx2 = pZtykappadhktgkujygkx2;
    }

    private Long ztygoukeinenbaraikansanp3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEINENBARAIKANSANP3X3)
    public Long getZtygoukeinenbaraikansanp3x3() {
        return ztygoukeinenbaraikansanp3x3;
    }

    public void setZtygoukeinenbaraikansanp3x3(Long pZtygoukeinenbaraikansanp3x3) {
        ztygoukeinenbaraikansanp3x3 = pZtygoukeinenbaraikansanp3x3;
    }

    private String ztyhktgtikkikkkn3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHKTGTIKKIKKKN3X3)
    public String getZtyhktgtikkikkkn3x3() {
        return ztyhktgtikkikkkn3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x3(String pZtyhktgtikkikkkn3x3) {
        ztyhktgtikkikkkn3x3 = pZtyhktgtikkikkkn3x3;
    }

    private Long ztykappadhktgkujygkx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAPPADHKTGKUJYGKX3)
    public Long getZtykappadhktgkujygkx3() {
        return ztykappadhktgkujygkx3;
    }

    public void setZtykappadhktgkujygkx3(Long pZtykappadhktgkujygkx3) {
        ztykappadhktgkujygkx3 = pZtykappadhktgkujygkx3;
    }

    private Long ztygoukeinenbaraikansanp3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEINENBARAIKANSANP3X4)
    public Long getZtygoukeinenbaraikansanp3x4() {
        return ztygoukeinenbaraikansanp3x4;
    }

    public void setZtygoukeinenbaraikansanp3x4(Long pZtygoukeinenbaraikansanp3x4) {
        ztygoukeinenbaraikansanp3x4 = pZtygoukeinenbaraikansanp3x4;
    }

    private String ztyhktgtikkikkkn3x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHKTGTIKKIKKKN3X4)
    public String getZtyhktgtikkikkkn3x4() {
        return ztyhktgtikkikkkn3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x4(String pZtyhktgtikkikkkn3x4) {
        ztyhktgtikkikkkn3x4 = pZtyhktgtikkikkkn3x4;
    }

    private Long ztykappadhktgkujygkx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAPPADHKTGKUJYGKX4)
    public Long getZtykappadhktgkujygkx4() {
        return ztykappadhktgkujygkx4;
    }

    public void setZtykappadhktgkujygkx4(Long pZtykappadhktgkujygkx4) {
        ztykappadhktgkujygkx4 = pZtykappadhktgkujygkx4;
    }

    private Long ztygoukeinenbaraikansanp3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEINENBARAIKANSANP3X5)
    public Long getZtygoukeinenbaraikansanp3x5() {
        return ztygoukeinenbaraikansanp3x5;
    }

    public void setZtygoukeinenbaraikansanp3x5(Long pZtygoukeinenbaraikansanp3x5) {
        ztygoukeinenbaraikansanp3x5 = pZtygoukeinenbaraikansanp3x5;
    }

    private String ztyhktgtikkikkkn3x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHKTGTIKKIKKKN3X5)
    public String getZtyhktgtikkikkkn3x5() {
        return ztyhktgtikkikkkn3x5;
    }

    public void setZtyhktgtikkikkkn3x5(String pZtyhktgtikkikkkn3x5) {
        ztyhktgtikkikkkn3x5 = pZtyhktgtikkikkkn3x5;
    }

    private Long ztykappadhktgkujygkx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAPPADHKTGKUJYGKX5)
    public Long getZtykappadhktgkujygkx5() {
        return ztykappadhktgkujygkx5;
    }

    public void setZtykappadhktgkujygkx5(Long pZtykappadhktgkujygkx5) {
        ztykappadhktgkujygkx5 = pZtykappadhktgkujygkx5;
    }

    private Long ztygoukeinenbaraikansanp3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEINENBARAIKANSANP3X6)
    public Long getZtygoukeinenbaraikansanp3x6() {
        return ztygoukeinenbaraikansanp3x6;
    }

    public void setZtygoukeinenbaraikansanp3x6(Long pZtygoukeinenbaraikansanp3x6) {
        ztygoukeinenbaraikansanp3x6 = pZtygoukeinenbaraikansanp3x6;
    }

    private String ztyhktgtikkikkkn3x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHKTGTIKKIKKKN3X6)
    public String getZtyhktgtikkikkkn3x6() {
        return ztyhktgtikkikkkn3x6;
    }

    public void setZtyhktgtikkikkkn3x6(String pZtyhktgtikkikkkn3x6) {
        ztyhktgtikkikkkn3x6 = pZtyhktgtikkikkkn3x6;
    }

    private Long ztykappadhktgkujygkx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAPPADHKTGKUJYGKX6)
    public Long getZtykappadhktgkujygkx6() {
        return ztykappadhktgkujygkx6;
    }

    public void setZtykappadhktgkujygkx6(Long pZtykappadhktgkujygkx6) {
        ztykappadhktgkujygkx6 = pZtykappadhktgkujygkx6;
    }

    private String ztyhutihnnnkknnzmkyksyono;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHUTIHNNNKKNNZMKYKSYONO)
    public String getZtyhutihnnnkknnzmkyksyono() {
        return ztyhutihnnnkknnzmkyksyono;
    }

    public void setZtyhutihnnnkknnzmkyksyono(String pZtyhutihnnnkknnzmkyksyono) {
        ztyhutihnnnkknnzmkyksyono = pZtyhutihnnnkknnzmkyksyono;
    }

    private String ztymusymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztymosnyuuryokuymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYMOSNYUURYOKUYMD)
    public String getZtymosnyuuryokuymd() {
        return ztymosnyuuryokuymd;
    }

    public void setZtymosnyuuryokuymd(String pZtymosnyuuryokuymd) {
        ztymosnyuuryokuymd = pZtymosnyuuryokuymd;
    }

    private String ztymossyosakuseiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYMOSSYOSAKUSEIYMD)
    public String getZtymossyosakuseiymd() {
        return ztymossyosakuseiymd;
    }

    public void setZtymossyosakuseiymd(String pZtymossyosakuseiymd) {
        ztymossyosakuseiymd = pZtymossyosakuseiymd;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztydai2kokutiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2KOKUTIYMD)
    public String getZtydai2kokutiymd() {
        return ztydai2kokutiymd;
    }

    public void setZtydai2kokutiymd(String pZtydai2kokutiymd) {
        ztydai2kokutiymd = pZtydai2kokutiymd;
    }

    private String ztyjyuuryousyouryakukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYJYUURYOUSYOURYAKUKBN)
    public String getZtyjyuuryousyouryakukbn() {
        return ztyjyuuryousyouryakukbn;
    }

    public void setZtyjyuuryousyouryakukbn(String pZtyjyuuryousyouryakukbn) {
        ztyjyuuryousyouryakukbn = pZtyjyuuryousyouryakukbn;
    }

    private String ztysnsniryutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKSYURUIKGU)
    public String getZtysnsniryutkyksyuruikgu() {
        return ztysnsniryutkyksyuruikgu;
    }

    public void setZtysnsniryutkyksyuruikgu(String pZtysnsniryutkyksyuruikgu) {
        ztysnsniryutkyksyuruikgu = pZtysnsniryutkyksyuruikgu;
    }

    private String ztysensiniryoutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSENSINIRYOUTOKUYAKUKIKAN)
    public String getZtysensiniryoutokuyakukikan() {
        return ztysensiniryoutokuyakukikan;
    }

    public void setZtysensiniryoutokuyakukikan(String pZtysensiniryoutokuyakukikan) {
        ztysensiniryoutokuyakukikan = pZtysensiniryoutokuyakukikan;
    }

    private String ztysensiniryoutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSENSINIRYOUTKYKPHRKKKN)
    public String getZtysensiniryoutkykphrkkkn() {
        return ztysensiniryoutkykphrkkkn;
    }

    public void setZtysensiniryoutkykphrkkkn(String pZtysensiniryoutkykphrkkkn) {
        ztysensiniryoutkykphrkkkn = pZtysensiniryoutkykphrkkkn;
    }

    private Long ztysensiniryoutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSENSINIRYOUTOKUYAKUS)
    public Long getZtysensiniryoutokuyakus() {
        return ztysensiniryoutokuyakus;
    }

    public void setZtysensiniryoutokuyakus(Long pZtysensiniryoutokuyakus) {
        ztysensiniryoutokuyakus = pZtysensiniryoutokuyakus;
    }

    private Long ztysensiniryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSENSINIRYOUTOKUYAKUP)
    public Long getZtysensiniryoutokuyakup() {
        return ztysensiniryoutokuyakup;
    }

    public void setZtysensiniryoutokuyakup(Long pZtysensiniryoutokuyakup) {
        ztysensiniryoutokuyakup = pZtysensiniryoutokuyakup;
    }

    private String ztysensiniryoutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSENSINIRYOUTKYKKGUSDKBN)
    public String getZtysensiniryoutkykkgusdkbn() {
        return ztysensiniryoutkykkgusdkbn;
    }

    public void setZtysensiniryoutkykkgusdkbn(String pZtysensiniryoutkykkgusdkbn) {
        ztysensiniryoutkykkgusdkbn = pZtysensiniryoutkykkgusdkbn;
    }

    private String ztysnsniryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKKGUYBX1)
    public String getZtysnsniryutkykkguybx1() {
        return ztysnsniryutkykkguybx1;
    }

    public void setZtysnsniryutkykkguybx1(String pZtysnsniryutkykkguybx1) {
        ztysnsniryutkykkguybx1 = pZtysnsniryutkykkguybx1;
    }

    private String ztysnsniryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKKGUYBX2)
    public String getZtysnsniryutkykkguybx2() {
        return ztysnsniryutkykkguybx2;
    }

    public void setZtysnsniryutkykkguybx2(String pZtysnsniryutkykkguybx2) {
        ztysnsniryutkykkguybx2 = pZtysnsniryutkykkguybx2;
    }

    private String ztysnsniryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKKGUYBX3)
    public String getZtysnsniryutkykkguybx3() {
        return ztysnsniryutkykkguybx3;
    }

    public void setZtysnsniryutkykkguybx3(String pZtysnsniryutkykkguybx3) {
        ztysnsniryutkykkguybx3 = pZtysnsniryutkykkguybx3;
    }

    private String ztysnsniryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKKGUYBX4)
    public String getZtysnsniryutkykkguybx4() {
        return ztysnsniryutkykkguybx4;
    }

    public void setZtysnsniryutkykkguybx4(String pZtysnsniryutkykkguybx4) {
        ztysnsniryutkykkguybx4 = pZtysnsniryutkykkguybx4;
    }

    private String ztysnsniryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKKGUYBX5)
    public String getZtysnsniryutkykkguybx5() {
        return ztysnsniryutkykkguybx5;
    }

    public void setZtysnsniryutkykkguybx5(String pZtysnsniryutkykkguybx5) {
        ztysnsniryutkykkguybx5 = pZtysnsniryutkykkguybx5;
    }

    private String ztysnsniryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKPWRBKKBN)
    public String getZtysnsniryutkykpwrbkkbn() {
        return ztysnsniryutkykpwrbkkbn;
    }

    public void setZtysnsniryutkykpwrbkkbn(String pZtysnsniryutkykpwrbkkbn) {
        ztysnsniryutkykpwrbkkbn = pZtysnsniryutkykpwrbkkbn;
    }

    private String ztysnsniryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKTBICDX1)
    public String getZtysnsniryutktbicdx1() {
        return ztysnsniryutktbicdx1;
    }

    public void setZtysnsniryutktbicdx1(String pZtysnsniryutktbicdx1) {
        ztysnsniryutktbicdx1 = pZtysnsniryutktbicdx1;
    }

    private String ztysnsniryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUHTNPKKNX1)
    public String getZtysnsniryuhtnpkknx1() {
        return ztysnsniryuhtnpkknx1;
    }

    public void setZtysnsniryuhtnpkknx1(String pZtysnsniryuhtnpkknx1) {
        ztysnsniryuhtnpkknx1 = pZtysnsniryuhtnpkknx1;
    }

    private String ztysnsniryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKTBICDX2)
    public String getZtysnsniryutktbicdx2() {
        return ztysnsniryutktbicdx2;
    }

    public void setZtysnsniryutktbicdx2(String pZtysnsniryutktbicdx2) {
        ztysnsniryutktbicdx2 = pZtysnsniryutktbicdx2;
    }

    private String ztysnsniryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUHTNPKKNX2)
    public String getZtysnsniryuhtnpkknx2() {
        return ztysnsniryuhtnpkknx2;
    }

    public void setZtysnsniryuhtnpkknx2(String pZtysnsniryuhtnpkknx2) {
        ztysnsniryuhtnpkknx2 = pZtysnsniryuhtnpkknx2;
    }

    private String ztysnsniryutkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSNSNIRYUTKYKKUSNMNRYOAGE)
    public String getZtysnsniryutkykkusnmnryoage() {
        return ztysnsniryutkykkusnmnryoage;
    }

    public void setZtysnsniryutkykkusnmnryoage(String pZtysnsniryutkykkusnmnryoage) {
        ztysnsniryutkykkusnmnryoage = pZtysnsniryutkykkusnmnryoage;
    }

    private String ztyyobiv4x17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV4X17)
    public String getZtyyobiv4x17() {
        return ztyyobiv4x17;
    }

    public void setZtyyobiv4x17(String pZtyyobiv4x17) {
        ztyyobiv4x17 = pZtyyobiv4x17;
    }

    private String ztydi2snsniryutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKSYRIKGU)
    public String getZtydi2snsniryutkyksyrikgu() {
        return ztydi2snsniryutkyksyrikgu;
    }

    public void setZtydi2snsniryutkyksyrikgu(String pZtydi2snsniryutkyksyrikgu) {
        ztydi2snsniryutkyksyrikgu = pZtydi2snsniryutkyksyrikgu;
    }

    private String ztydi2snsniryutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKKN)
    public String getZtydi2snsniryutkykkkn() {
        return ztydi2snsniryutkykkkn;
    }

    public void setZtydi2snsniryutkykkkn(String pZtydi2snsniryutkykkkn) {
        ztydi2snsniryutkykkkn = pZtydi2snsniryutkykkkn;
    }

    private String ztydai2snsniryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2SNSNIRYUTKYKPHRKKKN)
    public String getZtydai2snsniryutkykphrkkkn() {
        return ztydai2snsniryutkykphrkkkn;
    }

    public void setZtydai2snsniryutkykphrkkkn(String pZtydai2snsniryutkykphrkkkn) {
        ztydai2snsniryutkykphrkkkn = pZtydai2snsniryutkykphrkkkn;
    }

    private Long ztydai2sensiniryoutokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2SENSINIRYOUTOKUYAKUS)
    public Long getZtydai2sensiniryoutokuyakus() {
        return ztydai2sensiniryoutokuyakus;
    }

    public void setZtydai2sensiniryoutokuyakus(Long pZtydai2sensiniryoutokuyakus) {
        ztydai2sensiniryoutokuyakus = pZtydai2sensiniryoutokuyakus;
    }

    private Long ztydai2sensiniryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2SENSINIRYOUTOKUYAKUP)
    public Long getZtydai2sensiniryoutokuyakup() {
        return ztydai2sensiniryoutokuyakup;
    }

    public void setZtydai2sensiniryoutokuyakup(Long pZtydai2sensiniryoutokuyakup) {
        ztydai2sensiniryoutokuyakup = pZtydai2sensiniryoutokuyakup;
    }

    private String ztydi2snsniryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKGUSDKBN)
    public String getZtydi2snsniryutkykkgusdkbn() {
        return ztydi2snsniryutkykkgusdkbn;
    }

    public void setZtydi2snsniryutkykkgusdkbn(String pZtydi2snsniryutkykkgusdkbn) {
        ztydi2snsniryutkykkgusdkbn = pZtydi2snsniryutkykkgusdkbn;
    }

    private String ztydi2snsniryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKGUYBX1)
    public String getZtydi2snsniryutkykkguybx1() {
        return ztydi2snsniryutkykkguybx1;
    }

    public void setZtydi2snsniryutkykkguybx1(String pZtydi2snsniryutkykkguybx1) {
        ztydi2snsniryutkykkguybx1 = pZtydi2snsniryutkykkguybx1;
    }

    private String ztydi2snsniryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKGUYBX2)
    public String getZtydi2snsniryutkykkguybx2() {
        return ztydi2snsniryutkykkguybx2;
    }

    public void setZtydi2snsniryutkykkguybx2(String pZtydi2snsniryutkykkguybx2) {
        ztydi2snsniryutkykkguybx2 = pZtydi2snsniryutkykkguybx2;
    }

    private String ztydi2snsniryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKGUYBX3)
    public String getZtydi2snsniryutkykkguybx3() {
        return ztydi2snsniryutkykkguybx3;
    }

    public void setZtydi2snsniryutkykkguybx3(String pZtydi2snsniryutkykkguybx3) {
        ztydi2snsniryutkykkguybx3 = pZtydi2snsniryutkykkguybx3;
    }

    private String ztydi2snsniryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKGUYBX4)
    public String getZtydi2snsniryutkykkguybx4() {
        return ztydi2snsniryutkykkguybx4;
    }

    public void setZtydi2snsniryutkykkguybx4(String pZtydi2snsniryutkykkguybx4) {
        ztydi2snsniryutkykkguybx4 = pZtydi2snsniryutkykkguybx4;
    }

    private String ztydi2snsniryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKKGUYBX5)
    public String getZtydi2snsniryutkykkguybx5() {
        return ztydi2snsniryutkykkguybx5;
    }

    public void setZtydi2snsniryutkykkguybx5(String pZtydi2snsniryutkykkguybx5) {
        ztydi2snsniryutkykkguybx5 = pZtydi2snsniryutkykkguybx5;
    }

    private String ztydi2snsniryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKYKPWRBKKBN)
    public String getZtydi2snsniryutkykpwrbkkbn() {
        return ztydi2snsniryutkykpwrbkkbn;
    }

    public void setZtydi2snsniryutkykpwrbkkbn(String pZtydi2snsniryutkykpwrbkkbn) {
        ztydi2snsniryutkykpwrbkkbn = pZtydi2snsniryutkykpwrbkkbn;
    }

    private String ztydi2snsniryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKTBICDX1)
    public String getZtydi2snsniryutktbicdx1() {
        return ztydi2snsniryutktbicdx1;
    }

    public void setZtydi2snsniryutktbicdx1(String pZtydi2snsniryutktbicdx1) {
        ztydi2snsniryutktbicdx1 = pZtydi2snsniryutktbicdx1;
    }

    private String ztydi2snsniryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUHTNPKKNX1)
    public String getZtydi2snsniryuhtnpkknx1() {
        return ztydi2snsniryuhtnpkknx1;
    }

    public void setZtydi2snsniryuhtnpkknx1(String pZtydi2snsniryuhtnpkknx1) {
        ztydi2snsniryuhtnpkknx1 = pZtydi2snsniryuhtnpkknx1;
    }

    private String ztydi2snsniryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUTKTBICDX2)
    public String getZtydi2snsniryutktbicdx2() {
        return ztydi2snsniryutktbicdx2;
    }

    public void setZtydi2snsniryutktbicdx2(String pZtydi2snsniryutktbicdx2) {
        ztydi2snsniryutktbicdx2 = pZtydi2snsniryutktbicdx2;
    }

    private String ztydi2snsniryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SNSNIRYUHTNPKKNX2)
    public String getZtydi2snsniryuhtnpkknx2() {
        return ztydi2snsniryuhtnpkknx2;
    }

    public void setZtydi2snsniryuhtnpkknx2(String pZtydi2snsniryuhtnpkknx2) {
        ztydi2snsniryuhtnpkknx2 = pZtydi2snsniryuhtnpkknx2;
    }

    private String ztyyobiv6x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV6X3)
    public String getZtyyobiv6x3() {
        return ztyyobiv6x3;
    }

    public void setZtyyobiv6x3(String pZtyyobiv6x3) {
        ztyyobiv6x3 = pZtyyobiv6x3;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztykyksyaagetyouseihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKYKSYAAGETYOUSEIHYJ)
    public String getZtykyksyaagetyouseihyj() {
        return ztykyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyaagetyouseihyj(String pZtykyksyaagetyouseihyj) {
        ztykyksyaagetyouseihyj = pZtykyksyaagetyouseihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private Long ztyhsyumnosjdftmttzndk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHSYUMNOSJDFTMTTZNDK)
    public Long getZtyhsyumnosjdftmttzndk() {
        return ztyhsyumnosjdftmttzndk;
    }

    public void setZtyhsyumnosjdftmttzndk(Long pZtyhsyumnosjdftmttzndk) {
        ztyhsyumnosjdftmttzndk = pZtyhsyumnosjdftmttzndk;
    }

    private String ztynyuinhsyujyjttkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYJTTKYKSYRIKGU)
    public String getZtynyuinhsyujyjttkyksyrikgu() {
        return ztynyuinhsyujyjttkyksyrikgu;
    }

    public void setZtynyuinhsyujyjttkyksyrikgu(String pZtynyuinhsyujyjttkyksyrikgu) {
        ztynyuinhsyujyjttkyksyrikgu = pZtynyuinhsyujyjttkyksyrikgu;
    }

    private String ztynyuinhsyujyujttkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTTKYKKKN)
    public String getZtynyuinhsyujyujttkykkkn() {
        return ztynyuinhsyujyujttkykkkn;
    }

    public void setZtynyuinhsyujyujttkykkkn(String pZtynyuinhsyujyujttkykkkn) {
        ztynyuinhsyujyujttkykkkn = pZtynyuinhsyujyujttkykkkn;
    }

    private String ztynyinhsyjyjttkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYINHSYJYJTTKYKPHRKKKN)
    public String getZtynyinhsyjyjttkykphrkkkn() {
        return ztynyinhsyjyjttkykphrkkkn;
    }

    public void setZtynyinhsyjyjttkykphrkkkn(String pZtynyinhsyjyjttkykphrkkkn) {
        ztynyinhsyjyjttkykphrkkkn = pZtynyinhsyjyjttkykphrkkkn;
    }

    private Long ztynyuinhsyujyujttkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTTKYKS)
    public Long getZtynyuinhsyujyujttkyks() {
        return ztynyuinhsyujyujttkyks;
    }

    public void setZtynyuinhsyujyujttkyks(Long pZtynyuinhsyujyujttkyks) {
        ztynyuinhsyujyujttkyks = pZtynyuinhsyujyujttkyks;
    }

    private Long ztynyuinhsyujyujttkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTTKYKP)
    public Long getZtynyuinhsyujyujttkykp() {
        return ztynyuinhsyujyujttkykp;
    }

    public void setZtynyuinhsyujyujttkykp(Long pZtynyuinhsyujyujttkykp) {
        ztynyuinhsyujyujttkykp = pZtynyuinhsyujyujttkykp;
    }

    private Integer ztynyinhsyjyjttkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYINHSYJYJTTKJYRYMSHYTN)
    public Integer getZtynyinhsyjyjttkjyrymshytn() {
        return ztynyinhsyjyjttkjyrymshytn;
    }

    public void setZtynyinhsyjyjttkjyrymshytn(Integer pZtynyinhsyjyjttkjyrymshytn) {
        ztynyinhsyjyjttkjyrymshytn = pZtynyinhsyjyjttkjyrymshytn;
    }

    private Long ztynyuinhsyujyujttkyktkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTTKYKTKJYUP)
    public Long getZtynyuinhsyujyujttkyktkjyup() {
        return ztynyuinhsyujyujttkyktkjyup;
    }

    public void setZtynyuinhsyujyujttkyktkjyup(Long pZtynyuinhsyujyujttkyktkjyup) {
        ztynyuinhsyujyujttkyktkjyup = pZtynyuinhsyujyujttkyktkjyup;
    }

    private String ztynyuinhsyujyujttktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTTKTBICDX1)
    public String getZtynyuinhsyujyujttktbicdx1() {
        return ztynyuinhsyujyujttktbicdx1;
    }

    public void setZtynyuinhsyujyujttktbicdx1(String pZtynyuinhsyujyujttktbicdx1) {
        ztynyuinhsyujyujttktbicdx1 = pZtynyuinhsyujyujttktbicdx1;
    }

    private String ztynyuinhsyujyujthtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTHTNPKKNX1)
    public String getZtynyuinhsyujyujthtnpkknx1() {
        return ztynyuinhsyujyujthtnpkknx1;
    }

    public void setZtynyuinhsyujyujthtnpkknx1(String pZtynyuinhsyujyujthtnpkknx1) {
        ztynyuinhsyujyujthtnpkknx1 = pZtynyuinhsyujyujthtnpkknx1;
    }

    private String ztynyuinhsyujyujttktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTTKTBICDX2)
    public String getZtynyuinhsyujyujttktbicdx2() {
        return ztynyuinhsyujyujttktbicdx2;
    }

    public void setZtynyuinhsyujyujttktbicdx2(String pZtynyuinhsyujyujttktbicdx2) {
        ztynyuinhsyujyujttktbicdx2 = pZtynyuinhsyujyujttktbicdx2;
    }

    private String ztynyuinhsyujyujthtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYUJTHTNPKKNX2)
    public String getZtynyuinhsyujyujthtnpkknx2() {
        return ztynyuinhsyujyujthtnpkknx2;
    }

    public void setZtynyuinhsyujyujthtnpkknx2(String pZtynyuinhsyujyujthtnpkknx2) {
        ztynyuinhsyujyujthtnpkknx2 = pZtynyuinhsyujyujthtnpkknx2;
    }

    private String ztynyinhsyjyjttkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYINHSYJYJTTKYKKGUSDKBN)
    public String getZtynyinhsyjyjttkykkgusdkbn() {
        return ztynyinhsyjyjttkykkgusdkbn;
    }

    public void setZtynyinhsyjyjttkykkgusdkbn(String pZtynyinhsyjyjttkykkgusdkbn) {
        ztynyinhsyjyjttkykkgusdkbn = pZtynyinhsyjyjttkykkgusdkbn;
    }

    private String ztynyinhsyjyjttkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYINHSYJYJTTKYKPWRBKKBN)
    public String getZtynyinhsyjyjttkykpwrbkkbn() {
        return ztynyinhsyjyjttkykpwrbkkbn;
    }

    public void setZtynyinhsyjyjttkykpwrbkkbn(String pZtynyinhsyjyjttkykpwrbkkbn) {
        ztynyinhsyjyjttkykpwrbkkbn = pZtynyinhsyjyjttkykpwrbkkbn;
    }

    private String ztynyuinhsyujyjttkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYJTTKYKKGUYBX1)
    public String getZtynyuinhsyujyjttkykkguybx1() {
        return ztynyuinhsyujyjttkykkguybx1;
    }

    public void setZtynyuinhsyujyjttkykkguybx1(String pZtynyuinhsyujyjttkykkguybx1) {
        ztynyuinhsyujyjttkykkguybx1 = pZtynyuinhsyujyjttkykkguybx1;
    }

    private String ztynyuinhsyujyjttkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYJTTKYKKGUYBX2)
    public String getZtynyuinhsyujyjttkykkguybx2() {
        return ztynyuinhsyujyjttkykkguybx2;
    }

    public void setZtynyuinhsyujyjttkykkguybx2(String pZtynyuinhsyujyjttkykkguybx2) {
        ztynyuinhsyujyjttkykkguybx2 = pZtynyuinhsyujyjttkykkguybx2;
    }

    private String ztynyuinhsyujyjttkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYJTTKYKKGUYBX3)
    public String getZtynyuinhsyujyjttkykkguybx3() {
        return ztynyuinhsyujyjttkykkguybx3;
    }

    public void setZtynyuinhsyujyjttkykkguybx3(String pZtynyuinhsyujyjttkykkguybx3) {
        ztynyuinhsyujyjttkykkguybx3 = pZtynyuinhsyujyjttkykkguybx3;
    }

    private String ztynyuinhsyujyjttkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYJTTKYKKGUYBX4)
    public String getZtynyuinhsyujyjttkykkguybx4() {
        return ztynyuinhsyujyjttkykkguybx4;
    }

    public void setZtynyuinhsyujyjttkykkguybx4(String pZtynyuinhsyujyjttkykkguybx4) {
        ztynyuinhsyujyjttkykkguybx4 = pZtynyuinhsyujyjttkykkguybx4;
    }

    private String ztynyuinhsyujyjttkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYUINHSYUJYJTTKYKKGUYBX5)
    public String getZtynyuinhsyujyjttkykkguybx5() {
        return ztynyuinhsyujyjttkykkguybx5;
    }

    public void setZtynyuinhsyujyjttkykkguybx5(String pZtynyuinhsyujyjttkykkguybx5) {
        ztynyuinhsyujyjttkykkguybx5 = pZtynyuinhsyujyjttkykkguybx5;
    }

    private String ztynyinhsyjyjtkykksnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYNYINHSYJYJTKYKKSNMNRYAGE)
    public String getZtynyinhsyjyjtkykksnmnryage() {
        return ztynyinhsyjyjtkykksnmnryage;
    }

    public void setZtynyinhsyjyjtkykksnmnryage(String pZtynyinhsyjyjtkykksnmnryage) {
        ztynyinhsyjyjtkykksnmnryage = pZtynyinhsyjyjtkykksnmnryage;
    }

    private String ztyyobiv5x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV5X4)
    public String getZtyyobiv5x4() {
        return ztyyobiv5x4;
    }

    public void setZtyyobiv5x4(String pZtyyobiv5x4) {
        ztyyobiv5x4 = pZtyyobiv5x4;
    }

    private String ztydi2nyinhsyjyjttkyksyrikg;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYJYJTTKYKSYRIKG)
    public String getZtydi2nyinhsyjyjttkyksyrikg() {
        return ztydi2nyinhsyjyjttkyksyrikg;
    }

    public void setZtydi2nyinhsyjyjttkyksyrikg(String pZtydi2nyinhsyjyjttkyksyrikg) {
        ztydi2nyinhsyjyjttkyksyrikg = pZtydi2nyinhsyjyjttkyksyrikg;
    }

    private String ztydi2nyuinhsyujyujttkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUJYUJTTKYKKKN)
    public String getZtydi2nyuinhsyujyujttkykkkn() {
        return ztydi2nyuinhsyujyujttkykkkn;
    }

    public void setZtydi2nyuinhsyujyujttkykkkn(String pZtydi2nyuinhsyujyujttkykkkn) {
        ztydi2nyuinhsyujyujttkykkkn = pZtydi2nyuinhsyujyujttkykkkn;
    }

    private String ztydi2nyuinhsyujyjtphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUJYJTPHRKKKN)
    public String getZtydi2nyuinhsyujyjtphrkkkn() {
        return ztydi2nyuinhsyujyjtphrkkkn;
    }

    public void setZtydi2nyuinhsyujyjtphrkkkn(String pZtydi2nyuinhsyujyjtphrkkkn) {
        ztydi2nyuinhsyujyjtphrkkkn = pZtydi2nyuinhsyujyjtphrkkkn;
    }

    private Long ztydi2nyuinhsyujyujttkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUJYUJTTKYKS)
    public Long getZtydi2nyuinhsyujyujttkyks() {
        return ztydi2nyuinhsyujyujttkyks;
    }

    public void setZtydi2nyuinhsyujyujttkyks(Long pZtydi2nyuinhsyujyujttkyks) {
        ztydi2nyuinhsyujyujttkyks = pZtydi2nyuinhsyujyujttkyks;
    }

    private Long ztydi2nyuinhsyujyujttkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUJYUJTTKYKP)
    public Long getZtydi2nyuinhsyujyujttkykp() {
        return ztydi2nyuinhsyujyujttkykp;
    }

    public void setZtydi2nyuinhsyujyujttkykp(Long pZtydi2nyuinhsyujyujttkykp) {
        ztydi2nyuinhsyujyujttkykp = pZtydi2nyuinhsyujyujttkykp;
    }

    private Integer ztydi2nyhsyjyjttkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYHSYJYJTTKJYRYMSHYTN)
    public Integer getZtydi2nyhsyjyjttkjyrymshytn() {
        return ztydi2nyhsyjyjttkjyrymshytn;
    }

    public void setZtydi2nyhsyjyjttkjyrymshytn(Integer pZtydi2nyhsyjyjttkjyrymshytn) {
        ztydi2nyhsyjyjttkjyrymshytn = pZtydi2nyhsyjyjttkjyrymshytn;
    }

    private Long ztydi2nyuinhsyujyujttkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUJYUJTTKJYUP)
    public Long getZtydi2nyuinhsyujyujttkjyup() {
        return ztydi2nyuinhsyujyujttkjyup;
    }

    public void setZtydi2nyuinhsyujyujttkjyup(Long pZtydi2nyuinhsyujyujttkjyup) {
        ztydi2nyuinhsyujyujttkjyup = pZtydi2nyuinhsyujyujttkjyup;
    }

    private String ztydi2nyuinhsyutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUTKTBICDX1)
    public String getZtydi2nyuinhsyutktbicdx1() {
        return ztydi2nyuinhsyutktbicdx1;
    }

    public void setZtydi2nyuinhsyutktbicdx1(String pZtydi2nyuinhsyutktbicdx1) {
        ztydi2nyuinhsyutktbicdx1 = pZtydi2nyuinhsyutktbicdx1;
    }

    private String ztydi2nyuinhsyuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUHTNPKKNX1)
    public String getZtydi2nyuinhsyuhtnpkknx1() {
        return ztydi2nyuinhsyuhtnpkknx1;
    }

    public void setZtydi2nyuinhsyuhtnpkknx1(String pZtydi2nyuinhsyuhtnpkknx1) {
        ztydi2nyuinhsyuhtnpkknx1 = pZtydi2nyuinhsyuhtnpkknx1;
    }

    private String ztydi2nyuinhsyutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUTKTBICDX2)
    public String getZtydi2nyuinhsyutktbicdx2() {
        return ztydi2nyuinhsyutktbicdx2;
    }

    public void setZtydi2nyuinhsyutktbicdx2(String pZtydi2nyuinhsyutktbicdx2) {
        ztydi2nyuinhsyutktbicdx2 = pZtydi2nyuinhsyutktbicdx2;
    }

    private String ztydi2nyuinhsyuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUHTNPKKNX2)
    public String getZtydi2nyuinhsyuhtnpkknx2() {
        return ztydi2nyuinhsyuhtnpkknx2;
    }

    public void setZtydi2nyuinhsyuhtnpkknx2(String pZtydi2nyuinhsyuhtnpkknx2) {
        ztydi2nyuinhsyuhtnpkknx2 = pZtydi2nyuinhsyuhtnpkknx2;
    }

    private String ztydi2nyinhsyujyjtkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYUJYJTKGUSDKBN)
    public String getZtydi2nyinhsyujyjtkgusdkbn() {
        return ztydi2nyinhsyujyjtkgusdkbn;
    }

    public void setZtydi2nyinhsyujyjtkgusdkbn(String pZtydi2nyinhsyujyjtkgusdkbn) {
        ztydi2nyinhsyujyjtkgusdkbn = pZtydi2nyinhsyujyjtkgusdkbn;
    }

    private String ztydi2nyuinhsyujyjtpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYUINHSYUJYJTPWRBKKBN)
    public String getZtydi2nyuinhsyujyjtpwrbkkbn() {
        return ztydi2nyuinhsyujyjtpwrbkkbn;
    }

    public void setZtydi2nyuinhsyujyjtpwrbkkbn(String pZtydi2nyuinhsyujyjtpwrbkkbn) {
        ztydi2nyuinhsyujyjtpwrbkkbn = pZtydi2nyuinhsyujyjtpwrbkkbn;
    }

    private String ztydi2nyinhsyjyjttkykkgybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYJYJTTKYKKGYBX1)
    public String getZtydi2nyinhsyjyjttkykkgybx1() {
        return ztydi2nyinhsyjyjttkykkgybx1;
    }

    public void setZtydi2nyinhsyjyjttkykkgybx1(String pZtydi2nyinhsyjyjttkykkgybx1) {
        ztydi2nyinhsyjyjttkykkgybx1 = pZtydi2nyinhsyjyjttkykkgybx1;
    }

    private String ztydi2nyinhsyjyjttkykkgybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYJYJTTKYKKGYBX2)
    public String getZtydi2nyinhsyjyjttkykkgybx2() {
        return ztydi2nyinhsyjyjttkykkgybx2;
    }

    public void setZtydi2nyinhsyjyjttkykkgybx2(String pZtydi2nyinhsyjyjttkykkgybx2) {
        ztydi2nyinhsyjyjttkykkgybx2 = pZtydi2nyinhsyjyjttkykkgybx2;
    }

    private String ztydi2nyinhsyjyjttkykkgybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYJYJTTKYKKGYBX3)
    public String getZtydi2nyinhsyjyjttkykkgybx3() {
        return ztydi2nyinhsyjyjttkykkgybx3;
    }

    public void setZtydi2nyinhsyjyjttkykkgybx3(String pZtydi2nyinhsyjyjttkykkgybx3) {
        ztydi2nyinhsyjyjttkykkgybx3 = pZtydi2nyinhsyjyjttkykkgybx3;
    }

    private String ztydi2nyinhsyjyjttkykkgybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYJYJTTKYKKGYBX4)
    public String getZtydi2nyinhsyjyjttkykkgybx4() {
        return ztydi2nyinhsyjyjttkykkgybx4;
    }

    public void setZtydi2nyinhsyjyjttkykkgybx4(String pZtydi2nyinhsyjyjttkykkgybx4) {
        ztydi2nyinhsyjyjttkykkgybx4 = pZtydi2nyinhsyjyjttkykkgybx4;
    }

    private String ztydi2nyinhsyjyjttkykkgybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2NYINHSYJYJTTKYKKGYBX5)
    public String getZtydi2nyinhsyjyjttkykkgybx5() {
        return ztydi2nyinhsyjyjttkykkgybx5;
    }

    public void setZtydi2nyinhsyjyjttkykkgybx5(String pZtydi2nyinhsyjyjttkykkgybx5) {
        ztydi2nyinhsyjyjttkykkgybx5 = pZtydi2nyinhsyjyjttkykkgybx5;
    }

    private String ztyyobiv7x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV7X6)
    public String getZtyyobiv7x6() {
        return ztyyobiv7x6;
    }

    public void setZtyyobiv7x6(String pZtyyobiv7x6) {
        ztyyobiv7x6 = pZtyyobiv7x6;
    }

    private String ztyyobiv1x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV1X4)
    public String getZtyyobiv1x4() {
        return ztyyobiv1x4;
    }

    public void setZtyyobiv1x4(String pZtyyobiv1x4) {
        ztyyobiv1x4 = pZtyyobiv1x4;
    }

    private String ztywnasitnknkakakujyutukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYWNASITNKNKAKAKUJYUTUKBN)
    public String getZtywnasitnknkakakujyutukbn() {
        return ztywnasitnknkakakujyutukbn;
    }

    public void setZtywnasitnknkakakujyutukbn(String pZtywnasitnknkakakujyutukbn) {
        ztywnasitnknkakakujyutukbn = pZtywnasitnknkakakujyutukbn;
    }

    private Long ztygoukeiwnasitenkankakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGOUKEIWNASITENKANKAKAKU)
    public Long getZtygoukeiwnasitenkankakaku() {
        return ztygoukeiwnasitenkankakaku;
    }

    public void setZtygoukeiwnasitenkankakaku(Long pZtygoukeiwnasitenkankakaku) {
        ztygoukeiwnasitenkankakaku = pZtygoukeiwnasitenkankakaku;
    }

    private Long ztygukiwnstnknitjbrnknengk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGUKIWNSTNKNITJBRNKNENGK)
    public Long getZtygukiwnstnknitjbrnknengk() {
        return ztygukiwnstnknitjbrnknengk;
    }

    public void setZtygukiwnstnknitjbrnknengk(Long pZtygukiwnstnknitjbrnknengk) {
        ztygukiwnstnknitjbrnknengk = pZtygukiwnstnknitjbrnknengk;
    }

    private Long ztygukiwnasitnknitjbrtiks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGUKIWNASITNKNITJBRTIKS)
    public Long getZtygukiwnasitnknitjbrtiks() {
        return ztygukiwnasitnknitjbrtiks;
    }

    public void setZtygukiwnasitnknitjbrtiks(Long pZtygukiwnasitnknitjbrtiks) {
        ztygukiwnasitnknitjbrtiks = pZtygukiwnasitnknitjbrtiks;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private String ztyyobiv9x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV9X11)
    public String getZtyyobiv9x11() {
        return ztyyobiv9x11;
    }

    public void setZtyyobiv9x11(String pZtyyobiv9x11) {
        ztyyobiv9x11 = pZtyyobiv9x11;
    }

    private String ztysuguiryutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKSYURUIKGU)
    public String getZtysuguiryutkyksyuruikgu() {
        return ztysuguiryutkyksyuruikgu;
    }

    public void setZtysuguiryutkyksyuruikgu(String pZtysuguiryutkyksyuruikgu) {
        ztysuguiryutkyksyuruikgu = pZtysuguiryutkyksyuruikgu;
    }

    private String ztysougouiryoutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSOUGOUIRYOUTOKUYAKUKIKAN)
    public String getZtysougouiryoutokuyakukikan() {
        return ztysougouiryoutokuyakukikan;
    }

    public void setZtysougouiryoutokuyakukikan(String pZtysougouiryoutokuyakukikan) {
        ztysougouiryoutokuyakukikan = pZtysougouiryoutokuyakukikan;
    }

    private String ztysuguiryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKPHRKKKN)
    public String getZtysuguiryutkykphrkkkn() {
        return ztysuguiryutkykphrkkkn;
    }

    public void setZtysuguiryutkykphrkkkn(String pZtysuguiryutkykphrkkkn) {
        ztysuguiryutkykphrkkkn = pZtysuguiryutkykphrkkkn;
    }

    private Integer ztysuguiryutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKNTGK)
    public Integer getZtysuguiryutkykntgk() {
        return ztysuguiryutkykntgk;
    }

    public void setZtysuguiryutkykntgk(Integer pZtysuguiryutkykntgk) {
        ztysuguiryutkykntgk = pZtysuguiryutkykntgk;
    }

    private Long ztysougouiryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSOUGOUIRYOUTOKUYAKUP)
    public Long getZtysougouiryoutokuyakup() {
        return ztysougouiryoutokuyakup;
    }

    public void setZtysougouiryoutokuyakup(Long pZtysougouiryoutokuyakup) {
        ztysougouiryoutokuyakup = pZtysougouiryoutokuyakup;
    }

    private Integer ztysuguiryutkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKJYURYUMSHYUTN)
    public Integer getZtysuguiryutkjyuryumshyutn() {
        return ztysuguiryutkjyuryumshyutn;
    }

    public void setZtysuguiryutkjyuryumshyutn(Integer pZtysuguiryutkjyuryumshyutn) {
        ztysuguiryutkjyuryumshyutn = pZtysuguiryutkjyuryumshyutn;
    }

    private Long ztysougouiryoutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSOUGOUIRYOUTOKUJYOUP)
    public Long getZtysougouiryoutokujyoup() {
        return ztysougouiryoutokujyoup;
    }

    public void setZtysougouiryoutokujyoup(Long pZtysougouiryoutokujyoup) {
        ztysougouiryoutokujyoup = pZtysougouiryoutokujyoup;
    }

    private String ztysuguiryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKTBICDX1)
    public String getZtysuguiryutktbicdx1() {
        return ztysuguiryutktbicdx1;
    }

    public void setZtysuguiryutktbicdx1(String pZtysuguiryutktbicdx1) {
        ztysuguiryutktbicdx1 = pZtysuguiryutktbicdx1;
    }

    private String ztysuguiryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUHTNPKKNX1)
    public String getZtysuguiryuhtnpkknx1() {
        return ztysuguiryuhtnpkknx1;
    }

    public void setZtysuguiryuhtnpkknx1(String pZtysuguiryuhtnpkknx1) {
        ztysuguiryuhtnpkknx1 = pZtysuguiryuhtnpkknx1;
    }

    private String ztysuguiryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKTBICDX2)
    public String getZtysuguiryutktbicdx2() {
        return ztysuguiryutktbicdx2;
    }

    public void setZtysuguiryutktbicdx2(String pZtysuguiryutktbicdx2) {
        ztysuguiryutktbicdx2 = pZtysuguiryutktbicdx2;
    }

    private String ztysuguiryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUHTNPKKNX2)
    public String getZtysuguiryuhtnpkknx2() {
        return ztysuguiryuhtnpkknx2;
    }

    public void setZtysuguiryuhtnpkknx2(String pZtysuguiryuhtnpkknx2) {
        ztysuguiryuhtnpkknx2 = pZtysuguiryuhtnpkknx2;
    }

    private String ztysuguiryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKGUSDKBN)
    public String getZtysuguiryutkykkgusdkbn() {
        return ztysuguiryutkykkgusdkbn;
    }

    public void setZtysuguiryutkykkgusdkbn(String pZtysuguiryutkykkgusdkbn) {
        ztysuguiryutkykkgusdkbn = pZtysuguiryutkykkgusdkbn;
    }

    private String ztysuguiryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKPWRBKKBN)
    public String getZtysuguiryutkykpwrbkkbn() {
        return ztysuguiryutkykpwrbkkbn;
    }

    public void setZtysuguiryutkykpwrbkkbn(String pZtysuguiryutkykpwrbkkbn) {
        ztysuguiryutkykpwrbkkbn = pZtysuguiryutkykpwrbkkbn;
    }

    private String ztysuguiryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKGUYBX1)
    public String getZtysuguiryutkykkguybx1() {
        return ztysuguiryutkykkguybx1;
    }

    public void setZtysuguiryutkykkguybx1(String pZtysuguiryutkykkguybx1) {
        ztysuguiryutkykkguybx1 = pZtysuguiryutkykkguybx1;
    }

    private String ztysuguiryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKGUYBX2)
    public String getZtysuguiryutkykkguybx2() {
        return ztysuguiryutkykkguybx2;
    }

    public void setZtysuguiryutkykkguybx2(String pZtysuguiryutkykkguybx2) {
        ztysuguiryutkykkguybx2 = pZtysuguiryutkykkguybx2;
    }

    private String ztysuguiryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKGUYBX3)
    public String getZtysuguiryutkykkguybx3() {
        return ztysuguiryutkykkguybx3;
    }

    public void setZtysuguiryutkykkguybx3(String pZtysuguiryutkykkguybx3) {
        ztysuguiryutkykkguybx3 = pZtysuguiryutkykkguybx3;
    }

    private String ztysuguiryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKGUYBX4)
    public String getZtysuguiryutkykkguybx4() {
        return ztysuguiryutkykkguybx4;
    }

    public void setZtysuguiryutkykkguybx4(String pZtysuguiryutkykkguybx4) {
        ztysuguiryutkykkguybx4 = pZtysuguiryutkykkguybx4;
    }

    private String ztysuguiryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKGUYBX5)
    public String getZtysuguiryutkykkguybx5() {
        return ztysuguiryutkykkguybx5;
    }

    public void setZtysuguiryutkykkguybx5(String pZtysuguiryutkykkguybx5) {
        ztysuguiryutkykkguybx5 = pZtysuguiryutkykkguybx5;
    }

    private String ztysuguiryutkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSUGUIRYUTKYKKUSNMNRYOAGE)
    public String getZtysuguiryutkykkusnmnryoage() {
        return ztysuguiryutkykkusnmnryoage;
    }

    public void setZtysuguiryutkykkusnmnryoage(String pZtysuguiryutkykkusnmnryoage) {
        ztysuguiryutkykkusnmnryoage = pZtysuguiryutkykkusnmnryoage;
    }

    private String ztyyobiv7x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV7X7)
    public String getZtyyobiv7x7() {
        return ztyyobiv7x7;
    }

    public void setZtyyobiv7x7(String pZtyyobiv7x7) {
        ztyyobiv7x7 = pZtyyobiv7x7;
    }

    private String ztydi2suguiryutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKSYRIKGU)
    public String getZtydi2suguiryutkyksyrikgu() {
        return ztydi2suguiryutkyksyrikgu;
    }

    public void setZtydi2suguiryutkyksyrikgu(String pZtydi2suguiryutkyksyrikgu) {
        ztydi2suguiryutkyksyrikgu = pZtydi2suguiryutkyksyrikgu;
    }

    private String ztydi2suguiryutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKKN)
    public String getZtydi2suguiryutkykkkn() {
        return ztydi2suguiryutkykkkn;
    }

    public void setZtydi2suguiryutkykkkn(String pZtydi2suguiryutkykkkn) {
        ztydi2suguiryutkykkkn = pZtydi2suguiryutkykkkn;
    }

    private String ztydi2suguiryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKPHRKKKN)
    public String getZtydi2suguiryutkykphrkkkn() {
        return ztydi2suguiryutkykphrkkkn;
    }

    public void setZtydi2suguiryutkykphrkkkn(String pZtydi2suguiryutkykphrkkkn) {
        ztydi2suguiryutkykphrkkkn = pZtydi2suguiryutkykphrkkkn;
    }

    private Integer ztydi2suguiryutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKNTGK)
    public Integer getZtydi2suguiryutkykntgk() {
        return ztydi2suguiryutkykntgk;
    }

    public void setZtydi2suguiryutkykntgk(Integer pZtydi2suguiryutkykntgk) {
        ztydi2suguiryutkykntgk = pZtydi2suguiryutkykntgk;
    }

    private Long ztydai2sougouiryoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2SOUGOUIRYOUTOKUYAKUP)
    public Long getZtydai2sougouiryoutokuyakup() {
        return ztydai2sougouiryoutokuyakup;
    }

    public void setZtydai2sougouiryoutokuyakup(Long pZtydai2sougouiryoutokuyakup) {
        ztydai2sougouiryoutokuyakup = pZtydai2sougouiryoutokuyakup;
    }

    private Integer ztydi2suguiryutkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKJYURYMSHYTN)
    public Integer getZtydi2suguiryutkjyurymshytn() {
        return ztydi2suguiryutkjyurymshytn;
    }

    public void setZtydi2suguiryutkjyurymshytn(Integer pZtydi2suguiryutkjyurymshytn) {
        ztydi2suguiryutkjyurymshytn = pZtydi2suguiryutkjyurymshytn;
    }

    private Long ztydai2sougouiryoutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2SOUGOUIRYOUTOKUJYOUP)
    public Long getZtydai2sougouiryoutokujyoup() {
        return ztydai2sougouiryoutokujyoup;
    }

    public void setZtydai2sougouiryoutokujyoup(Long pZtydai2sougouiryoutokujyoup) {
        ztydai2sougouiryoutokujyoup = pZtydai2sougouiryoutokujyoup;
    }

    private String ztydi2suguiryutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKTBICDX1)
    public String getZtydi2suguiryutktbicdx1() {
        return ztydi2suguiryutktbicdx1;
    }

    public void setZtydi2suguiryutktbicdx1(String pZtydi2suguiryutktbicdx1) {
        ztydi2suguiryutktbicdx1 = pZtydi2suguiryutktbicdx1;
    }

    private String ztydi2suguiryuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUHTNPKKNX1)
    public String getZtydi2suguiryuhtnpkknx1() {
        return ztydi2suguiryuhtnpkknx1;
    }

    public void setZtydi2suguiryuhtnpkknx1(String pZtydi2suguiryuhtnpkknx1) {
        ztydi2suguiryuhtnpkknx1 = pZtydi2suguiryuhtnpkknx1;
    }

    private String ztydi2suguiryutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKTBICDX2)
    public String getZtydi2suguiryutktbicdx2() {
        return ztydi2suguiryutktbicdx2;
    }

    public void setZtydi2suguiryutktbicdx2(String pZtydi2suguiryutktbicdx2) {
        ztydi2suguiryutktbicdx2 = pZtydi2suguiryutktbicdx2;
    }

    private String ztydi2suguiryuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUHTNPKKNX2)
    public String getZtydi2suguiryuhtnpkknx2() {
        return ztydi2suguiryuhtnpkknx2;
    }

    public void setZtydi2suguiryuhtnpkknx2(String pZtydi2suguiryuhtnpkknx2) {
        ztydi2suguiryuhtnpkknx2 = pZtydi2suguiryuhtnpkknx2;
    }

    private String ztydi2suguiryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKGUSDKBN)
    public String getZtydi2suguiryutkykkgusdkbn() {
        return ztydi2suguiryutkykkgusdkbn;
    }

    public void setZtydi2suguiryutkykkgusdkbn(String pZtydi2suguiryutkykkgusdkbn) {
        ztydi2suguiryutkykkgusdkbn = pZtydi2suguiryutkykkgusdkbn;
    }

    private String ztydi2suguiryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKPWRBKKBN)
    public String getZtydi2suguiryutkykpwrbkkbn() {
        return ztydi2suguiryutkykpwrbkkbn;
    }

    public void setZtydi2suguiryutkykpwrbkkbn(String pZtydi2suguiryutkykpwrbkkbn) {
        ztydi2suguiryutkykpwrbkkbn = pZtydi2suguiryutkykpwrbkkbn;
    }

    private String ztydi2suguiryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKGUYBX1)
    public String getZtydi2suguiryutkykkguybx1() {
        return ztydi2suguiryutkykkguybx1;
    }

    public void setZtydi2suguiryutkykkguybx1(String pZtydi2suguiryutkykkguybx1) {
        ztydi2suguiryutkykkguybx1 = pZtydi2suguiryutkykkguybx1;
    }

    private String ztydi2suguiryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKGUYBX2)
    public String getZtydi2suguiryutkykkguybx2() {
        return ztydi2suguiryutkykkguybx2;
    }

    public void setZtydi2suguiryutkykkguybx2(String pZtydi2suguiryutkykkguybx2) {
        ztydi2suguiryutkykkguybx2 = pZtydi2suguiryutkykkguybx2;
    }

    private String ztydi2suguiryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKGUYBX3)
    public String getZtydi2suguiryutkykkguybx3() {
        return ztydi2suguiryutkykkguybx3;
    }

    public void setZtydi2suguiryutkykkguybx3(String pZtydi2suguiryutkykkguybx3) {
        ztydi2suguiryutkykkguybx3 = pZtydi2suguiryutkykkguybx3;
    }

    private String ztydi2suguiryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKGUYBX4)
    public String getZtydi2suguiryutkykkguybx4() {
        return ztydi2suguiryutkykkguybx4;
    }

    public void setZtydi2suguiryutkykkguybx4(String pZtydi2suguiryutkykkguybx4) {
        ztydi2suguiryutkykkguybx4 = pZtydi2suguiryutkykkguybx4;
    }

    private String ztydi2suguiryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2SUGUIRYUTKYKKGUYBX5)
    public String getZtydi2suguiryutkykkguybx5() {
        return ztydi2suguiryutkykkguybx5;
    }

    public void setZtydi2suguiryutkykkguybx5(String pZtydi2suguiryutkykkguybx5) {
        ztydi2suguiryutkykkguybx5 = pZtydi2suguiryutkykkguybx5;
    }

    private String ztyyobiv9x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV9X12)
    public String getZtyyobiv9x12() {
        return ztyyobiv9x12;
    }

    public void setZtyyobiv9x12(String pZtyyobiv9x12) {
        ztyyobiv9x12 = pZtyyobiv9x12;
    }

    private String ztydai2gannyuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUINTKYKSYRIKGU)
    public String getZtydai2gannyuintkyksyrikgu() {
        return ztydai2gannyuintkyksyrikgu;
    }

    public void setZtydai2gannyuintkyksyrikgu(String pZtydai2gannyuintkyksyrikgu) {
        ztydai2gannyuintkyksyrikgu = pZtydai2gannyuintkyksyrikgu;
    }

    private String ztydai2gannyuintkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUINTKYKKKN)
    public String getZtydai2gannyuintkykkkn() {
        return ztydai2gannyuintkykkkn;
    }

    public void setZtydai2gannyuintkykkkn(String pZtydai2gannyuintkykkkn) {
        ztydai2gannyuintkykkkn = pZtydai2gannyuintkykkkn;
    }

    private String ztydai2gannyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUINTKYKPHRKKKN)
    public String getZtydai2gannyuintkykphrkkkn() {
        return ztydai2gannyuintkykphrkkkn;
    }

    public void setZtydai2gannyuintkykphrkkkn(String pZtydai2gannyuintkykphrkkkn) {
        ztydai2gannyuintkykphrkkkn = pZtydai2gannyuintkykphrkkkn;
    }

    private Integer ztydai2gannyuintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUINTKYKNTGK)
    public Integer getZtydai2gannyuintkykntgk() {
        return ztydai2gannyuintkykntgk;
    }

    public void setZtydai2gannyuintkykntgk(Integer pZtydai2gannyuintkykntgk) {
        ztydai2gannyuintkykntgk = pZtydai2gannyuintkykntgk;
    }

    private Long ztydai2gannyuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUUINTOKUYAKUP)
    public Long getZtydai2gannyuuintokuyakup() {
        return ztydai2gannyuuintokuyakup;
    }

    public void setZtydai2gannyuuintokuyakup(Long pZtydai2gannyuuintokuyakup) {
        ztydai2gannyuuintokuyakup = pZtydai2gannyuuintokuyakup;
    }

    private String ztydai2gannyuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUINTKYKKGUSDKBN)
    public String getZtydai2gannyuintkykkgusdkbn() {
        return ztydai2gannyuintkykkgusdkbn;
    }

    public void setZtydai2gannyuintkykkgusdkbn(String pZtydai2gannyuintkykkgusdkbn) {
        ztydai2gannyuintkykkgusdkbn = pZtydai2gannyuintkykkgusdkbn;
    }

    private String ztydi2gannyuintkykkguyobix1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2GANNYUINTKYKKGUYOBIX1)
    public String getZtydi2gannyuintkykkguyobix1() {
        return ztydi2gannyuintkykkguyobix1;
    }

    public void setZtydi2gannyuintkykkguyobix1(String pZtydi2gannyuintkykkguyobix1) {
        ztydi2gannyuintkykkguyobix1 = pZtydi2gannyuintkykkguyobix1;
    }

    private String ztydi2gannyuintkykkguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2GANNYUINTKYKKGUYOBIX2)
    public String getZtydi2gannyuintkykkguyobix2() {
        return ztydi2gannyuintkykkguyobix2;
    }

    public void setZtydi2gannyuintkykkguyobix2(String pZtydi2gannyuintkykkguyobix2) {
        ztydi2gannyuintkykkguyobix2 = pZtydi2gannyuintkykkguyobix2;
    }

    private String ztydi2gannyuintkykkguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2GANNYUINTKYKKGUYOBIX3)
    public String getZtydi2gannyuintkykkguyobix3() {
        return ztydi2gannyuintkykkguyobix3;
    }

    public void setZtydi2gannyuintkykkguyobix3(String pZtydi2gannyuintkykkguyobix3) {
        ztydi2gannyuintkykkguyobix3 = pZtydi2gannyuintkykkguyobix3;
    }

    private String ztydi2gannyuintkykkguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2GANNYUINTKYKKGUYOBIX4)
    public String getZtydi2gannyuintkykkguyobix4() {
        return ztydi2gannyuintkykkguyobix4;
    }

    public void setZtydi2gannyuintkykkguyobix4(String pZtydi2gannyuintkykkguyobix4) {
        ztydi2gannyuintkykkguyobix4 = pZtydi2gannyuintkykkguyobix4;
    }

    private String ztydi2gannyuintkykkguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDI2GANNYUINTKYKKGUYOBIX5)
    public String getZtydi2gannyuintkykkguyobix5() {
        return ztydi2gannyuintkykkguyobix5;
    }

    public void setZtydi2gannyuintkykkguyobix5(String pZtydi2gannyuintkykkguyobix5) {
        ztydi2gannyuintkykkguyobix5 = pZtydi2gannyuintkykkguyobix5;
    }

    private String ztydai2gannyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYDAI2GANNYUINTKYKPWRBKKBN)
    public String getZtydai2gannyuintkykpwrbkkbn() {
        return ztydai2gannyuintkykpwrbkkbn;
    }

    public void setZtydai2gannyuintkykpwrbkkbn(String pZtydai2gannyuintkykpwrbkkbn) {
        ztydai2gannyuintkykpwrbkkbn = pZtydai2gannyuintkykpwrbkkbn;
    }

    private String ztyyobiv6x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV6X4)
    public String getZtyyobiv6x4() {
        return ztyyobiv6x4;
    }

    public void setZtyyobiv6x4(String pZtyyobiv6x4) {
        ztyyobiv6x4 = pZtyyobiv6x4;
    }

    private Integer ztygukihtnknsuguirytkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGUKIHTNKNSUGUIRYTKYKNTGK)
    public Integer getZtygukihtnknsuguirytkykntgk() {
        return ztygukihtnknsuguirytkykntgk;
    }

    public void setZtygukihtnknsuguirytkykntgk(Integer pZtygukihtnknsuguirytkykntgk) {
        ztygukihtnknsuguirytkykntgk = pZtygukihtnknsuguirytkykntgk;
    }

    private String ztyhijynbrimarusyuusyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUSYRIKGU)
    public String getZtyhijynbrimarusyuusyrikgu() {
        return ztyhijynbrimarusyuusyrikgu;
    }

    public void setZtyhijynbrimarusyuusyrikgu(String pZtyhijynbrimarusyuusyrikgu) {
        ztyhijynbrimarusyuusyrikgu = pZtyhijynbrimarusyuusyrikgu;
    }

    private String ztyhijynbrimrsyukgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMRSYUKGUSDKBN)
    public String getZtyhijynbrimrsyukgusdkbn() {
        return ztyhijynbrimrsyukgusdkbn;
    }

    public void setZtyhijynbrimrsyukgusdkbn(String pZtyhijynbrimrsyukgusdkbn) {
        ztyhijynbrimrsyukgusdkbn = pZtyhijynbrimrsyukgusdkbn;
    }

    private String ztyhijynbrimarusyuukguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUKGUYBX1)
    public String getZtyhijynbrimarusyuukguybx1() {
        return ztyhijynbrimarusyuukguybx1;
    }

    public void setZtyhijynbrimarusyuukguybx1(String pZtyhijynbrimarusyuukguybx1) {
        ztyhijynbrimarusyuukguybx1 = pZtyhijynbrimarusyuukguybx1;
    }

    private String ztyhijynbrimarusyuukguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUKGUYBX2)
    public String getZtyhijynbrimarusyuukguybx2() {
        return ztyhijynbrimarusyuukguybx2;
    }

    public void setZtyhijynbrimarusyuukguybx2(String pZtyhijynbrimarusyuukguybx2) {
        ztyhijynbrimarusyuukguybx2 = pZtyhijynbrimarusyuukguybx2;
    }

    private String ztyhijynbrimarusyuukguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUKGUYBX3)
    public String getZtyhijynbrimarusyuukguybx3() {
        return ztyhijynbrimarusyuukguybx3;
    }

    public void setZtyhijynbrimarusyuukguybx3(String pZtyhijynbrimarusyuukguybx3) {
        ztyhijynbrimarusyuukguybx3 = pZtyhijynbrimarusyuukguybx3;
    }

    private String ztyhijynbrimarusyuukguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUKGUYBX4)
    public String getZtyhijynbrimarusyuukguybx4() {
        return ztyhijynbrimarusyuukguybx4;
    }

    public void setZtyhijynbrimarusyuukguybx4(String pZtyhijynbrimarusyuukguybx4) {
        ztyhijynbrimarusyuukguybx4 = pZtyhijynbrimarusyuukguybx4;
    }

    private String ztyhijynbrimarusyuukguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUKGUYBX5)
    public String getZtyhijynbrimarusyuukguybx5() {
        return ztyhijynbrimarusyuukguybx5;
    }

    public void setZtyhijynbrimarusyuukguybx5(String pZtyhijynbrimarusyuukguybx5) {
        ztyhijynbrimarusyuukguybx5 = pZtyhijynbrimarusyuukguybx5;
    }

    private String ztyhijynbrimarusyuukkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUKKN)
    public String getZtyhijynbrimarusyuukkn() {
        return ztyhijynbrimarusyuukkn;
    }

    public void setZtyhijynbrimarusyuukkn(String pZtyhijynbrimarusyuukkn) {
        ztyhijynbrimarusyuukkn = pZtyhijynbrimarusyuukkn;
    }

    private String ztyhijynbrimrsyphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMRSYPHRKKKN)
    public String getZtyhijynbrimrsyphrkkkn() {
        return ztyhijynbrimrsyphrkkkn;
    }

    public void setZtyhijynbrimrsyphrkkkn(String pZtyhijynbrimrsyphrkkkn) {
        ztyhijynbrimrsyphrkkkn = pZtyhijynbrimrsyphrkkkn;
    }

    private Long ztyhijynbrimarusyuutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUTKYKS)
    public Long getZtyhijynbrimarusyuutkyks() {
        return ztyhijynbrimarusyuutkyks;
    }

    public void setZtyhijynbrimarusyuutkyks(Long pZtyhijynbrimarusyuutkyks) {
        ztyhijynbrimarusyuutkyks = pZtyhijynbrimarusyuutkyks;
    }

    private Long ztyhijynbrimarusyuutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUTKYKP)
    public Long getZtyhijynbrimarusyuutkykp() {
        return ztyhijynbrimarusyuutkykp;
    }

    public void setZtyhijynbrimarusyuutkykp(Long pZtyhijynbrimarusyuutkykp) {
        ztyhijynbrimarusyuutkykp = pZtyhijynbrimarusyuutkykp;
    }

    private String ztyhijynbrimrsypwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMRSYPWRBKKBN)
    public String getZtyhijynbrimrsypwrbkkbn() {
        return ztyhijynbrimrsypwrbkkbn;
    }

    public void setZtyhijynbrimrsypwrbkkbn(String pZtyhijynbrimrsypwrbkkbn) {
        ztyhijynbrimrsypwrbkkbn = pZtyhijynbrimrsypwrbkkbn;
    }

    private Long ztyhijynbrimarusyuumods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUMODS)
    public Long getZtyhijynbrimarusyuumods() {
        return ztyhijynbrimarusyuumods;
    }

    public void setZtyhijynbrimarusyuumods(Long pZtyhijynbrimarusyuumods) {
        ztyhijynbrimarusyuumods = pZtyhijynbrimarusyuumods;
    }

    private String ztyhijynbrimarusyuutkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUTKJYUKBN)
    public String getZtyhijynbrimarusyuutkjyukbn() {
        return ztyhijynbrimarusyuutkjyukbn;
    }

    public void setZtyhijynbrimarusyuutkjyukbn(String pZtyhijynbrimarusyuutkjyukbn) {
        ztyhijynbrimarusyuutkjyukbn = pZtyhijynbrimarusyuutkjyukbn;
    }

    private String ztyhijynbrimrsytkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMRSYTKJYUSKGNKKN)
    public String getZtyhijynbrimrsytkjyuskgnkkn() {
        return ztyhijynbrimrsytkjyuskgnkkn;
    }

    public void setZtyhijynbrimrsytkjyuskgnkkn(String pZtyhijynbrimrsytkjyuskgnkkn) {
        ztyhijynbrimrsytkjyuskgnkkn = pZtyhijynbrimrsytkjyuskgnkkn;
    }

    private Integer ztyhijynbrmrsytkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRMRSYTKJYURYMSHYTN)
    public Integer getZtyhijynbrmrsytkjyurymshytn() {
        return ztyhijynbrmrsytkjyurymshytn;
    }

    public void setZtyhijynbrmrsytkjyurymshytn(Integer pZtyhijynbrmrsytkjyurymshytn) {
        ztyhijynbrmrsytkjyurymshytn = pZtyhijynbrmrsytkjyurymshytn;
    }

    private Long ztyhijynbrimarusyuutkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRIMARUSYUUTKJYUP)
    public Long getZtyhijynbrimarusyuutkjyup() {
        return ztyhijynbrimarusyuutkjyup;
    }

    public void setZtyhijynbrimarusyuutkjyup(Long pZtyhijynbrimarusyuutkjyup) {
        ztyhijynbrimarusyuutkjyup = pZtyhijynbrimarusyuutkjyup;
    }

    private String ztyhijynbrmrsytnknygryrtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHIJYNBRMRSYTNKNYGRYRTKBN)
    public String getZtyhijynbrmrsytnknygryrtkbn() {
        return ztyhijynbrmrsytnknygryrtkbn;
    }

    public void setZtyhijynbrmrsytnknygryrtkbn(String pZtyhijynbrmrsytnknygryrtkbn) {
        ztyhijynbrmrsytnknygryrtkbn = pZtyhijynbrmrsytnknygryrtkbn;
    }

    private String ztyyobiv4x18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV4X18)
    public String getZtyyobiv4x18() {
        return ztyyobiv4x18;
    }

    public void setZtyyobiv4x18(String pZtyyobiv4x18) {
        ztyyobiv4x18 = pZtyyobiv4x18;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private Long ztymosjikaigos;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYMOSJIKAIGOS)
    public Long getZtymosjikaigos() {
        return ztymosjikaigos;
    }

    public void setZtymosjikaigos(Long pZtymosjikaigos) {
        ztymosjikaigos = pZtymosjikaigos;
    }

    private Long ztymosjidi2hknkknsyuusns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYMOSJIDI2HKNKKNSYUUSNS)
    public Long getZtymosjidi2hknkknsyuusns() {
        return ztymosjidi2hknkknsyuusns;
    }

    public void setZtymosjidi2hknkknsyuusns(Long pZtymosjidi2hknkknsyuusns) {
        ztymosjidi2hknkknsyuusns = pZtymosjidi2hknkknsyuusns;
    }

    private String ztygansndntkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKSYRIKGU)
    public String getZtygansndntkyksyrikgu() {
        return ztygansndntkyksyrikgu;
    }

    public void setZtygansndntkyksyrikgu(String pZtygansndntkyksyrikgu) {
        ztygansndntkyksyrikgu = pZtygansndntkyksyrikgu;
    }

    private String ztygansndntkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKKGUSDKBN)
    public String getZtygansndntkykkgusdkbn() {
        return ztygansndntkykkgusdkbn;
    }

    public void setZtygansndntkykkgusdkbn(String pZtygansndntkykkgusdkbn) {
        ztygansndntkykkgusdkbn = pZtygansndntkykkgusdkbn;
    }

    private String ztygansndntkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKKGUYBX1)
    public String getZtygansndntkykkguybx1() {
        return ztygansndntkykkguybx1;
    }

    public void setZtygansndntkykkguybx1(String pZtygansndntkykkguybx1) {
        ztygansndntkykkguybx1 = pZtygansndntkykkguybx1;
    }

    private String ztygansndntkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKKGUYBX2)
    public String getZtygansndntkykkguybx2() {
        return ztygansndntkykkguybx2;
    }

    public void setZtygansndntkykkguybx2(String pZtygansndntkykkguybx2) {
        ztygansndntkykkguybx2 = pZtygansndntkykkguybx2;
    }

    private String ztygansndntkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKKGUYBX3)
    public String getZtygansndntkykkguybx3() {
        return ztygansndntkykkguybx3;
    }

    public void setZtygansndntkykkguybx3(String pZtygansndntkykkguybx3) {
        ztygansndntkykkguybx3 = pZtygansndntkykkguybx3;
    }

    private String ztygansndntkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKKGUYBX4)
    public String getZtygansndntkykkguybx4() {
        return ztygansndntkykkguybx4;
    }

    public void setZtygansndntkykkguybx4(String pZtygansndntkykkguybx4) {
        ztygansndntkykkguybx4 = pZtygansndntkykkguybx4;
    }

    private String ztygansndntkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKKGUYBX5)
    public String getZtygansndntkykkguybx5() {
        return ztygansndntkykkguybx5;
    }

    public void setZtygansndntkykkguybx5(String pZtygansndntkykkguybx5) {
        ztygansndntkykkguybx5 = pZtygansndntkykkguybx5;
    }

    private String ztygansindantokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSINDANTOKUYAKUKIKAN)
    public String getZtygansindantokuyakukikan() {
        return ztygansindantokuyakukikan;
    }

    public void setZtygansindantokuyakukikan(String pZtygansindantokuyakukikan) {
        ztygansindantokuyakukikan = pZtygansindantokuyakukikan;
    }

    private String ztygansndntkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKPHRKKKN)
    public String getZtygansndntkykphrkkkn() {
        return ztygansndntkykphrkkkn;
    }

    public void setZtygansndntkykphrkkkn(String pZtygansndntkykphrkkkn) {
        ztygansndntkykphrkkkn = pZtygansndntkykphrkkkn;
    }

    private Long ztygansindantokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSINDANTOKUYAKUS)
    public Long getZtygansindantokuyakus() {
        return ztygansindantokuyakus;
    }

    public void setZtygansindantokuyakus(Long pZtygansindantokuyakus) {
        ztygansindantokuyakus = pZtygansindantokuyakus;
    }

    private Long ztygansindantokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSINDANTOKUYAKUP)
    public Long getZtygansindantokuyakup() {
        return ztygansindantokuyakup;
    }

    public void setZtygansindantokuyakup(Long pZtygansindantokuyakup) {
        ztygansindantokuyakup = pZtygansindantokuyakup;
    }

    private String ztygansndntkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKPWRBKKBN)
    public String getZtygansndntkykpwrbkkbn() {
        return ztygansndntkykpwrbkkbn;
    }

    public void setZtygansndntkykpwrbkkbn(String pZtygansndntkykpwrbkkbn) {
        ztygansndntkykpwrbkkbn = pZtygansndntkykpwrbkkbn;
    }

    private Long ztygansndntkyktaikknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANSNDNTKYKTAIKKNBBNS)
    public Long getZtygansndntkyktaikknbbns() {
        return ztygansndntkyktaikknbbns;
    }

    public void setZtygansndntkyktaikknbbns(Long pZtygansndntkyktaikknbbns) {
        ztygansndntkyktaikknbbns = pZtygansndntkyktaikknbbns;
    }

    private Long ztyjyouhinaiganmtkknbbns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYJYOUHINAIGANMTKKNBBNS)
    public Long getZtyjyouhinaiganmtkknbbns() {
        return ztyjyouhinaiganmtkknbbns;
    }

    public void setZtyjyouhinaiganmtkknbbns(Long pZtyjyouhinaiganmtkknbbns) {
        ztyjyouhinaiganmtkknbbns = pZtyjyouhinaiganmtkknbbns;
    }

    private String ztygnsndntkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGNSNDNTKYKKUSNMNRYOAGE)
    public String getZtygnsndntkykkusnmnryoage() {
        return ztygnsndntkykkusnmnryoage;
    }

    public void setZtygnsndntkykkusnmnryoage(String pZtygnsndntkykkusnmnryoage) {
        ztygnsndntkykkusnmnryoage = pZtygnsndntkykkusnmnryoage;
    }

    private String ztyyobiv10x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV10X5)
    public String getZtyyobiv10x5() {
        return ztyyobiv10x5;
    }

    public void setZtyyobiv10x5(String pZtyyobiv10x5) {
        ztyyobiv10x5 = pZtyyobiv10x5;
    }

    private String ztyganykbttryutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKSYRIKGU)
    public String getZtyganykbttryutkyksyrikgu() {
        return ztyganykbttryutkyksyrikgu;
    }

    public void setZtyganykbttryutkyksyrikgu(String pZtyganykbttryutkyksyrikgu) {
        ztyganykbttryutkyksyrikgu = pZtyganykbttryutkyksyrikgu;
    }

    private String ztyganykbttryutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKGUSDKBN)
    public String getZtyganykbttryutkykkgusdkbn() {
        return ztyganykbttryutkykkgusdkbn;
    }

    public void setZtyganykbttryutkykkgusdkbn(String pZtyganykbttryutkykkgusdkbn) {
        ztyganykbttryutkykkgusdkbn = pZtyganykbttryutkykkgusdkbn;
    }

    private String ztyganykbttryutkykkguybx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKGUYBX1)
    public String getZtyganykbttryutkykkguybx1() {
        return ztyganykbttryutkykkguybx1;
    }

    public void setZtyganykbttryutkykkguybx1(String pZtyganykbttryutkykkguybx1) {
        ztyganykbttryutkykkguybx1 = pZtyganykbttryutkykkguybx1;
    }

    private String ztyganykbttryutkykkguybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKGUYBX2)
    public String getZtyganykbttryutkykkguybx2() {
        return ztyganykbttryutkykkguybx2;
    }

    public void setZtyganykbttryutkykkguybx2(String pZtyganykbttryutkykkguybx2) {
        ztyganykbttryutkykkguybx2 = pZtyganykbttryutkykkguybx2;
    }

    private String ztyganykbttryutkykkguybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKGUYBX3)
    public String getZtyganykbttryutkykkguybx3() {
        return ztyganykbttryutkykkguybx3;
    }

    public void setZtyganykbttryutkykkguybx3(String pZtyganykbttryutkykkguybx3) {
        ztyganykbttryutkykkguybx3 = pZtyganykbttryutkykkguybx3;
    }

    private String ztyganykbttryutkykkguybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKGUYBX4)
    public String getZtyganykbttryutkykkguybx4() {
        return ztyganykbttryutkykkguybx4;
    }

    public void setZtyganykbttryutkykkguybx4(String pZtyganykbttryutkykkguybx4) {
        ztyganykbttryutkykkguybx4 = pZtyganykbttryutkykkguybx4;
    }

    private String ztyganykbttryutkykkguybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKGUYBX5)
    public String getZtyganykbttryutkykkguybx5() {
        return ztyganykbttryutkykkguybx5;
    }

    public void setZtyganykbttryutkykkguybx5(String pZtyganykbttryutkykkguybx5) {
        ztyganykbttryutkykkguybx5 = pZtyganykbttryutkykkguybx5;
    }

    private String ztyganykbttryutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKKKN)
    public String getZtyganykbttryutkykkkn() {
        return ztyganykbttryutkykkkn;
    }

    public void setZtyganykbttryutkykkkn(String pZtyganykbttryutkykkkn) {
        ztyganykbttryutkykkkn = pZtyganykbttryutkykkkn;
    }

    private String ztyganykbttryutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKPHRKKKN)
    public String getZtyganykbttryutkykphrkkkn() {
        return ztyganykbttryutkykphrkkkn;
    }

    public void setZtyganykbttryutkykphrkkkn(String pZtyganykbttryutkykphrkkkn) {
        ztyganykbttryutkykphrkkkn = pZtyganykbttryutkykphrkkkn;
    }

    private Long ztyganykbttryutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKS)
    public Long getZtyganykbttryutkyks() {
        return ztyganykbttryutkyks;
    }

    public void setZtyganykbttryutkyks(Long pZtyganykbttryutkyks) {
        ztyganykbttryutkyks = pZtyganykbttryutkyks;
    }

    private Long ztyganykbttryutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKP)
    public Long getZtyganykbttryutkykp() {
        return ztyganykbttryutkykp;
    }

    public void setZtyganykbttryutkykp(Long pZtyganykbttryutkykp) {
        ztyganykbttryutkykp = pZtyganykbttryutkykp;
    }

    private String ztyganykbttryutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGANYKBTTRYUTKYKPWRBKKBN)
    public String getZtyganykbttryutkykpwrbkkbn() {
        return ztyganykbttryutkykpwrbkkbn;
    }

    public void setZtyganykbttryutkykpwrbkkbn(String pZtyganykbttryutkykpwrbkkbn) {
        ztyganykbttryutkykpwrbkkbn = pZtyganykbttryutkykpwrbkkbn;
    }

    private String ztygnykbttryutkykksnmnryage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGNYKBTTRYUTKYKKSNMNRYAGE)
    public String getZtygnykbttryutkykksnmnryage() {
        return ztygnykbttryutkykksnmnryage;
    }

    public void setZtygnykbttryutkykksnmnryage(String pZtygnykbttryutkykksnmnryage) {
        ztygnykbttryutkykksnmnryage = pZtygnykbttryutkykksnmnryage;
    }

    private String ztyyobiv12x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV12X11)
    public String getZtyyobiv12x11() {
        return ztyyobiv12x11;
    }

    public void setZtyyobiv12x11(String pZtyyobiv12x11) {
        ztyyobiv12x11 = pZtyyobiv12x11;
    }

    private Long ztygukihtnkngansndntkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGUKIHTNKNGANSNDNTKYKS)
    public Long getZtygukihtnkngansndntkyks() {
        return ztygukihtnkngansndntkyks;
    }

    public void setZtygukihtnkngansndntkyks(Long pZtygukihtnkngansndntkyks) {
        ztygukihtnkngansndntkyks = pZtygukihtnkngansndntkyks;
    }

    private Long ztygukihtnknganykbttrytkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYGUKIHTNKNGANYKBTTRYTKYKS)
    public Long getZtygukihtnknganykbttrytkyks() {
        return ztygukihtnknganykbttrytkyks;
    }

    public void setZtygukihtnknganykbttrytkyks(Long pZtygukihtnknganykbttrytkyks) {
        ztygukihtnknganykbttrytkyks = pZtygukihtnknganykbttrytkyks;
    }

    private BizNumber ztysinkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSINKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtysinkeiyakujiyoteiriritu() {
        return ztysinkeiyakujiyoteiriritu;
    }

    public void setZtysinkeiyakujiyoteiriritu(BizNumber pZtysinkeiyakujiyoteiriritu) {
        ztysinkeiyakujiyoteiriritu = pZtysinkeiyakujiyoteiriritu;
    }

    private String ztykousinmanryouage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKOUSINMANRYOUAGE)
    public String getZtykousinmanryouage() {
        return ztykousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykousinmanryouage(String pZtykousinmanryouage) {
        ztykousinmanryouage = pZtykousinmanryouage;
    }

    private String ztyseizonmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSEIZONMRTIKUSNMNRYOAGE)
    public String getZtyseizonmrtikusnmnryoage() {
        return ztyseizonmrtikusnmnryoage;
    }

    public void setZtyseizonmrtikusnmnryoage(String pZtyseizonmrtikusnmnryoage) {
        ztyseizonmrtikusnmnryoage = pZtyseizonmrtikusnmnryoage;
    }

    private String ztyteigenmrtikusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYTEIGENMRTIKUSNMNRYOAGE)
    public String getZtyteigenmrtikusnmnryoage() {
        return ztyteigenmrtikusnmnryoage;
    }

    public void setZtyteigenmrtikusnmnryoage(String pZtyteigenmrtikusnmnryoage) {
        ztyteigenmrtikusnmnryoage = pZtyteigenmrtikusnmnryoage;
    }

    private String ztysiktsyunyumrtisyri;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTISYRI)
    public String getZtysiktsyunyumrtisyri() {
        return ztysiktsyunyumrtisyri;
    }

    public void setZtysiktsyunyumrtisyri(String pZtysiktsyunyumrtisyri) {
        ztysiktsyunyumrtisyri = pZtysiktsyunyumrtisyri;
    }

    private String ztysiktsyunyumrtikgusdikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKGUSDIKBN)
    public String getZtysiktsyunyumrtikgusdikbn() {
        return ztysiktsyunyumrtikgusdikbn;
    }

    public void setZtysiktsyunyumrtikgusdikbn(String pZtysiktsyunyumrtikgusdikbn) {
        ztysiktsyunyumrtikgusdikbn = pZtysiktsyunyumrtikgusdikbn;
    }

    private String ztysiktsyunyumrtikguyobi;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKGUYOBI)
    public String getZtysiktsyunyumrtikguyobi() {
        return ztysiktsyunyumrtikguyobi;
    }

    public void setZtysiktsyunyumrtikguyobi(String pZtysiktsyunyumrtikguyobi) {
        ztysiktsyunyumrtikguyobi = pZtysiktsyunyumrtikguyobi;
    }

    private String ztysiktsyunyumrtikguyobix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKGUYOBIX2)
    public String getZtysiktsyunyumrtikguyobix2() {
        return ztysiktsyunyumrtikguyobix2;
    }

    public void setZtysiktsyunyumrtikguyobix2(String pZtysiktsyunyumrtikguyobix2) {
        ztysiktsyunyumrtikguyobix2 = pZtysiktsyunyumrtikguyobix2;
    }

    private String ztysiktsyunyumrtikguyobix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKGUYOBIX3)
    public String getZtysiktsyunyumrtikguyobix3() {
        return ztysiktsyunyumrtikguyobix3;
    }

    public void setZtysiktsyunyumrtikguyobix3(String pZtysiktsyunyumrtikguyobix3) {
        ztysiktsyunyumrtikguyobix3 = pZtysiktsyunyumrtikguyobix3;
    }

    private String ztysiktsyunyumrtikguyobix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKGUYOBIX4)
    public String getZtysiktsyunyumrtikguyobix4() {
        return ztysiktsyunyumrtikguyobix4;
    }

    public void setZtysiktsyunyumrtikguyobix4(String pZtysiktsyunyumrtikguyobix4) {
        ztysiktsyunyumrtikguyobix4 = pZtysiktsyunyumrtikguyobix4;
    }

    private String ztysiktsyunyumrtikguyobix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKGUYOBIX5)
    public String getZtysiktsyunyumrtikguyobix5() {
        return ztysiktsyunyumrtikguyobix5;
    }

    public void setZtysiktsyunyumrtikguyobix5(String pZtysiktsyunyumrtikguyobix5) {
        ztysiktsyunyumrtikguyobix5 = pZtysiktsyunyumrtikguyobix5;
    }

    private String ztysiktsyunyumrtiktkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKTKBN)
    public String getZtysiktsyunyumrtiktkbn() {
        return ztysiktsyunyumrtiktkbn;
    }

    public void setZtysiktsyunyumrtiktkbn(String pZtysiktsyunyumrtiktkbn) {
        ztysiktsyunyumrtiktkbn = pZtysiktsyunyumrtiktkbn;
    }

    private String ztysiktsyunyumrtisyugiktkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTISYUGIKTKBN)
    public String getZtysiktsyunyumrtisyugiktkbn() {
        return ztysiktsyunyumrtisyugiktkbn;
    }

    public void setZtysiktsyunyumrtisyugiktkbn(String pZtysiktsyunyumrtisyugiktkbn) {
        ztysiktsyunyumrtisyugiktkbn = pZtysiktsyunyumrtisyugiktkbn;
    }

    private String ztyseikatusyuunyuumrtikkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSEIKATUSYUUNYUUMRTIKKN)
    public String getZtyseikatusyuunyuumrtikkn() {
        return ztyseikatusyuunyuumrtikkn;
    }

    public void setZtyseikatusyuunyuumrtikkn(String pZtyseikatusyuunyuumrtikkn) {
        ztyseikatusyuunyuumrtikkn = pZtyseikatusyuunyuumrtikkn;
    }

    private String ztysiktsyunyumrtiphrikmkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIPHRIKMKBN)
    public String getZtysiktsyunyumrtiphrikmkbn() {
        return ztysiktsyunyumrtiphrikmkbn;
    }

    public void setZtysiktsyunyumrtiphrikmkbn(String pZtysiktsyunyumrtiphrikmkbn) {
        ztysiktsyunyumrtiphrikmkbn = pZtysiktsyunyumrtiphrikmkbn;
    }

    private String ztysiktsyunyumrtishrikkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTISHRIKKN)
    public String getZtysiktsyunyumrtishrikkn() {
        return ztysiktsyunyumrtishrikkn;
    }

    public void setZtysiktsyunyumrtishrikkn(String pZtysiktsyunyumrtishrikkn) {
        ztysiktsyunyumrtishrikkn = pZtysiktsyunyumrtishrikkn;
    }

    private String ztysiktsynyumrtitnknwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYNYUMRTITNKNWRBKKBN)
    public String getZtysiktsynyumrtitnknwrbkkbn() {
        return ztysiktsynyumrtitnknwrbkkbn;
    }

    public void setZtysiktsynyumrtitnknwrbkkbn(String pZtysiktsynyumrtitnknwrbkkbn) {
        ztysiktsynyumrtitnknwrbkkbn = pZtysiktsynyumrtitnknwrbkkbn;
    }

    private String ztysrsiktsyunyumrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSRSIKTSYUNYUMRTIPWRBKKBN)
    public String getZtysrsiktsyunyumrtipwrbkkbn() {
        return ztysrsiktsyunyumrtipwrbkkbn;
    }

    public void setZtysrsiktsyunyumrtipwrbkkbn(String pZtysrsiktsyunyumrtipwrbkkbn) {
        ztysrsiktsyunyumrtipwrbkkbn = pZtysrsiktsyunyumrtipwrbkkbn;
    }

    private String ztysiktsyunyumrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIPWRBKKBN)
    public String getZtysiktsyunyumrtipwrbkkbn() {
        return ztysiktsyunyumrtipwrbkkbn;
    }

    public void setZtysiktsyunyumrtipwrbkkbn(String pZtysiktsyunyumrtipwrbkkbn) {
        ztysiktsyunyumrtipwrbkkbn = pZtysiktsyunyumrtipwrbkkbn;
    }

    private String ztysiktsyunyumrtiksnmnryunn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIKSNMNRYUNN)
    public String getZtysiktsyunyumrtiksnmnryunn() {
        return ztysiktsyunyumrtiksnmnryunn;
    }

    public void setZtysiktsyunyumrtiksnmnryunn(String pZtysiktsyunyumrtiksnmnryunn) {
        ztysiktsyunyumrtiksnmnryunn = pZtysiktsyunyumrtiksnmnryunn;
    }

    private Long ztysiktsyunyumrtinnknnngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTINNKNNNGK)
    public Long getZtysiktsyunyumrtinnknnngk() {
        return ztysiktsyunyumrtinnknnngk;
    }

    public void setZtysiktsyunyumrtinnknnngk(Long pZtysiktsyunyumrtinnknnngk) {
        ztysiktsyunyumrtinnknnngk = pZtysiktsyunyumrtinnknnngk;
    }

    private Long ztyseikatusyuunyuumrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSEIKATUSYUUNYUUMRTIS)
    public Long getZtyseikatusyuunyuumrtis() {
        return ztyseikatusyuunyuumrtis;
    }

    public void setZtyseikatusyuunyuumrtis(Long pZtyseikatusyuunyuumrtis) {
        ztyseikatusyuunyuumrtis = pZtyseikatusyuunyuumrtis;
    }

    private Long ztysiktsyunyumrtiitjknks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTIITJKNKS)
    public Long getZtysiktsyunyumrtiitjknks() {
        return ztysiktsyunyumrtiitjknks;
    }

    public void setZtysiktsyunyumrtiitjknks(Long pZtysiktsyunyumrtiitjknks) {
        ztysiktsyunyumrtiitjknks = pZtysiktsyunyumrtiitjknks;
    }

    private Long ztyseikatusyuunyuumrtip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSEIKATUSYUUNYUUMRTIP)
    public Long getZtyseikatusyuunyuumrtip() {
        return ztyseikatusyuunyuumrtip;
    }

    public void setZtyseikatusyuunyuumrtip(Long pZtyseikatusyuunyuumrtip) {
        ztyseikatusyuunyuumrtip = pZtyseikatusyuunyuumrtip;
    }

    private Long ztysiktsyunyumrtisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTISYUUSEIS)
    public Long getZtysiktsyunyumrtisyuuseis() {
        return ztysiktsyunyumrtisyuuseis;
    }

    public void setZtysiktsyunyumrtisyuuseis(Long pZtysiktsyunyumrtisyuuseis) {
        ztysiktsyunyumrtisyuuseis = pZtysiktsyunyumrtisyuuseis;
    }

    private String ztysiktsyunyumrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTITKJYUKBN)
    public String getZtysiktsyunyumrtitkjyukbn() {
        return ztysiktsyunyumrtitkjyukbn;
    }

    public void setZtysiktsyunyumrtitkjyukbn(String pZtysiktsyunyumrtitkjyukbn) {
        ztysiktsyunyumrtitkjyukbn = pZtysiktsyunyumrtitkjyukbn;
    }

    private Integer ztysiktsynymrtitkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYNYMRTITKJYRYMSHYTN)
    public Integer getZtysiktsynymrtitkjyrymshytn() {
        return ztysiktsynymrtitkjyrymshytn;
    }

    public void setZtysiktsynymrtitkjyrymshytn(Integer pZtysiktsynymrtitkjyrymshytn) {
        ztysiktsynymrtitkjyrymshytn = pZtysiktsynymrtitkjyrymshytn;
    }

    private Long ztysiktsyunyumrtitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUNYUMRTITKJYUP)
    public Long getZtysiktsyunyumrtitkjyup() {
        return ztysiktsyunyumrtitkjyup;
    }

    public void setZtysiktsyunyumrtitkjyup(Long pZtysiktsyunyumrtitkjyup) {
        ztysiktsyunyumrtitkjyup = pZtysiktsyunyumrtitkjyup;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztysiktsyuknbyutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKSYRIKGU)
    public String getZtysiktsyuknbyutkyksyrikgu() {
        return ztysiktsyuknbyutkyksyrikgu;
    }

    public void setZtysiktsyuknbyutkyksyrikgu(String pZtysiktsyuknbyutkyksyrikgu) {
        ztysiktsyuknbyutkyksyrikgu = pZtysiktsyuknbyutkyksyrikgu;
    }

    private String ztysiktsyuknbyutkykkgsdikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKGSDIKBN)
    public String getZtysiktsyuknbyutkykkgsdikbn() {
        return ztysiktsyuknbyutkykkgsdikbn;
    }

    public void setZtysiktsyuknbyutkykkgsdikbn(String pZtysiktsyuknbyutkykkgsdikbn) {
        ztysiktsyuknbyutkykkgsdikbn = pZtysiktsyuknbyutkykkgsdikbn;
    }

    private String ztysiktsyuknbyutkykkguybi;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKGUYBI)
    public String getZtysiktsyuknbyutkykkguybi() {
        return ztysiktsyuknbyutkykkguybi;
    }

    public void setZtysiktsyuknbyutkykkguybi(String pZtysiktsyuknbyutkykkguybi) {
        ztysiktsyuknbyutkykkguybi = pZtysiktsyuknbyutkykkguybi;
    }

    private String ztysiktsyuknbyutkykkguybix2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKGUYBIX2)
    public String getZtysiktsyuknbyutkykkguybix2() {
        return ztysiktsyuknbyutkykkguybix2;
    }

    public void setZtysiktsyuknbyutkykkguybix2(String pZtysiktsyuknbyutkykkguybix2) {
        ztysiktsyuknbyutkykkguybix2 = pZtysiktsyuknbyutkykkguybix2;
    }

    private String ztysiktsyuknbyutkykkguybix3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKGUYBIX3)
    public String getZtysiktsyuknbyutkykkguybix3() {
        return ztysiktsyuknbyutkykkguybix3;
    }

    public void setZtysiktsyuknbyutkykkguybix3(String pZtysiktsyuknbyutkykkguybix3) {
        ztysiktsyuknbyutkykkguybix3 = pZtysiktsyuknbyutkykkguybix3;
    }

    private String ztysiktsyuknbyutkykkguybix4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKGUYBIX4)
    public String getZtysiktsyuknbyutkykkguybix4() {
        return ztysiktsyuknbyutkykkguybix4;
    }

    public void setZtysiktsyuknbyutkykkguybix4(String pZtysiktsyuknbyutkykkguybix4) {
        ztysiktsyuknbyutkykkguybix4 = pZtysiktsyuknbyutkykkguybix4;
    }

    private String ztysiktsyuknbyutkykkguybix5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKGUYBIX5)
    public String getZtysiktsyuknbyutkykkguybix5() {
        return ztysiktsyuknbyutkykkguybix5;
    }

    public void setZtysiktsyuknbyutkykkguybix5(String pZtysiktsyuknbyutkykkguybix5) {
        ztysiktsyuknbyutkykkguybix5 = pZtysiktsyuknbyutkykkguybix5;
    }

    private String ztysiktsyuknbyutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKKKN)
    public String getZtysiktsyuknbyutkykkkn() {
        return ztysiktsyuknbyutkykkkn;
    }

    public void setZtysiktsyuknbyutkykkkn(String pZtysiktsyuknbyutkykkkn) {
        ztysiktsyuknbyutkykkkn = pZtysiktsyuknbyutkykkkn;
    }

    private String ztysiktsyuknbyutkykphrkmkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKPHRKMKKN)
    public String getZtysiktsyuknbyutkykphrkmkkn() {
        return ztysiktsyuknbyutkykphrkmkkn;
    }

    public void setZtysiktsyuknbyutkykphrkmkkn(String pZtysiktsyuknbyutkykphrkmkkn) {
        ztysiktsyuknbyutkykphrkmkkn = pZtysiktsyuknbyutkykphrkmkkn;
    }

    private String ztysiktsyknbytyktnknwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYKNBYTYKTNKNWRBKKBN)
    public String getZtysiktsyknbytyktnknwrbkkbn() {
        return ztysiktsyknbytyktnknwrbkkbn;
    }

    public void setZtysiktsyknbytyktnknwrbkkbn(String pZtysiktsyknbytyktnknwrbkkbn) {
        ztysiktsyknbytyktnknwrbkkbn = pZtysiktsyknbytyktnknwrbkkbn;
    }

    private String ztysrsiktsyuknbyutkpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSRSIKTSYUKNBYUTKPWRBKKBN)
    public String getZtysrsiktsyuknbyutkpwrbkkbn() {
        return ztysrsiktsyuknbyutkpwrbkkbn;
    }

    public void setZtysrsiktsyuknbyutkpwrbkkbn(String pZtysrsiktsyuknbyutkpwrbkkbn) {
        ztysrsiktsyuknbyutkpwrbkkbn = pZtysrsiktsyuknbyutkpwrbkkbn;
    }

    private String ztysiktsyuknbyutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKPWRBKKBN)
    public String getZtysiktsyuknbyutkykpwrbkkbn() {
        return ztysiktsyuknbyutkykpwrbkkbn;
    }

    public void setZtysiktsyuknbyutkykpwrbkkbn(String pZtysiktsyuknbyutkykpwrbkkbn) {
        ztysiktsyuknbyutkykpwrbkkbn = pZtysiktsyuknbyutkykpwrbkkbn;
    }

    private String ztysiktsyknbytkykkusnmnrynn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYKNBYTKYKKUSNMNRYNN)
    public String getZtysiktsyknbytkykkusnmnrynn() {
        return ztysiktsyknbytkykkusnmnrynn;
    }

    public void setZtysiktsyknbytkykkusnmnrynn(String pZtysiktsyknbytkykkusnmnrynn) {
        ztysiktsyknbytkykkusnmnrynn = pZtysiktsyknbytkykkusnmnrynn;
    }

    private Long ztysiktsyuknbyutkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKS)
    public Long getZtysiktsyuknbyutkyks() {
        return ztysiktsyuknbyutkyks;
    }

    public void setZtysiktsyuknbyutkyks(Long pZtysiktsyuknbyutkyks) {
        ztysiktsyuknbyutkyks = pZtysiktsyuknbyutkyks;
    }

    private Long ztysiktsyuknbyutkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKP)
    public Long getZtysiktsyuknbyutkykp() {
        return ztysiktsyuknbyutkykp;
    }

    public void setZtysiktsyuknbyutkykp(Long pZtysiktsyuknbyutkykp) {
        ztysiktsyuknbyutkykp = pZtysiktsyuknbyutkykp;
    }

    private Long ztysiktsyuknbyutkyktikknars;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKTIKKNARS)
    public Long getZtysiktsyuknbyutkyktikknars() {
        return ztysiktsyuknbyutkyktikknars;
    }

    public void setZtysiktsyuknbyutkyktikknars(Long pZtysiktsyuknbyutkyktikknars) {
        ztysiktsyuknbyutkyktikknars = pZtysiktsyuknbyutkyktikknars;
    }

    private Long ztysiktsyuknbyutkyksyusis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKYKSYUSIS)
    public Long getZtysiktsyuknbyutkyksyusis() {
        return ztysiktsyuknbyutkyksyusis;
    }

    public void setZtysiktsyuknbyutkyksyusis(Long pZtysiktsyuknbyutkyksyusis) {
        ztysiktsyuknbyutkyksyusis = pZtysiktsyuknbyutkyksyusis;
    }

    private String ztysiktsyuknbyutkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKJYUKBN)
    public String getZtysiktsyuknbyutkjyukbn() {
        return ztysiktsyuknbyutkjyukbn;
    }

    public void setZtysiktsyuknbyutkjyukbn(String pZtysiktsyuknbyutkjyukbn) {
        ztysiktsyuknbyutkjyukbn = pZtysiktsyuknbyutkjyukbn;
    }

    private Integer ztysiktsyuknbyutkjyrymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKJYRYMSHYTN)
    public Integer getZtysiktsyuknbyutkjyrymshytn() {
        return ztysiktsyuknbyutkjyrymshytn;
    }

    public void setZtysiktsyuknbyutkjyrymshytn(Integer pZtysiktsyuknbyutkjyrymshytn) {
        ztysiktsyuknbyutkjyrymshytn = pZtysiktsyuknbyutkjyrymshytn;
    }

    private Long ztysiktsyuknbyutkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKJYUP)
    public Long getZtysiktsyuknbyutkjyup() {
        return ztysiktsyuknbyutkjyup;
    }

    public void setZtysiktsyuknbyutkjyup(Long pZtysiktsyuknbyutkjyup) {
        ztysiktsyuknbyutkjyup = pZtysiktsyuknbyutkjyup;
    }

    private String ztysiktsyuknbyutktibicd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKTIBICD)
    public String getZtysiktsyuknbyutktibicd() {
        return ztysiktsyuknbyutktibicd;
    }

    public void setZtysiktsyuknbyutktibicd(String pZtysiktsyuknbyutktibicd) {
        ztysiktsyuknbyutktibicd = pZtysiktsyuknbyutktibicd;
    }

    private String ztysiktsyuknbyuhtnpkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUHTNPKKN)
    public String getZtysiktsyuknbyuhtnpkkn() {
        return ztysiktsyuknbyuhtnpkkn;
    }

    public void setZtysiktsyuknbyuhtnpkkn(String pZtysiktsyuknbyuhtnpkkn) {
        ztysiktsyuknbyuhtnpkkn = pZtysiktsyuknbyuhtnpkkn;
    }

    private String ztysiktsyuknbyutktibicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUTKTIBICDX2)
    public String getZtysiktsyuknbyutktibicdx2() {
        return ztysiktsyuknbyutktibicdx2;
    }

    public void setZtysiktsyuknbyutktibicdx2(String pZtysiktsyuknbyutktibicdx2) {
        ztysiktsyuknbyutktibicdx2 = pZtysiktsyuknbyutktibicdx2;
    }

    private String ztysiktsyuknbyuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYSIKTSYUKNBYUHTNPKKNX2)
    public String getZtysiktsyuknbyuhtnpkknx2() {
        return ztysiktsyuknbyuhtnpkknx2;
    }

    public void setZtysiktsyuknbyuhtnpkknx2(String pZtysiktsyuknbyuhtnpkknx2) {
        ztysiktsyuknbyuhtnpkknx2 = pZtysiktsyuknbyuhtnpkknx2;
    }

    private String ztyyobiv19;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV19)
    public String getZtyyobiv19() {
        return ztyyobiv19;
    }

    public void setZtyyobiv19(String pZtyyobiv19) {
        ztyyobiv19 = pZtyyobiv19;
    }

    private String ztyhtnknsiktsynymrtisyrkg;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTISYRKG)
    public String getZtyhtnknsiktsynymrtisyrkg() {
        return ztyhtnknsiktsynymrtisyrkg;
    }

    public void setZtyhtnknsiktsynymrtisyrkg(String pZtyhtnknsiktsynymrtisyrkg) {
        ztyhtnknsiktsynymrtisyrkg = pZtyhtnknsiktsynymrtisyrkg;
    }

    private String ztyhtnknsiktsynykgusdikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYKGUSDIKBN)
    public String getZtyhtnknsiktsynykgusdikbn() {
        return ztyhtnknsiktsynykgusdikbn;
    }

    public void setZtyhtnknsiktsynykgusdikbn(String pZtyhtnknsiktsynykgusdikbn) {
        ztyhtnknsiktsynykgusdikbn = pZtyhtnknsiktsynykgusdikbn;
    }

    private String ztyhtnknsiktsynymrtikgyb;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYB)
    public String getZtyhtnknsiktsynymrtikgyb() {
        return ztyhtnknsiktsynymrtikgyb;
    }

    public void setZtyhtnknsiktsynymrtikgyb(String pZtyhtnknsiktsynymrtikgyb) {
        ztyhtnknsiktsynymrtikgyb = pZtyhtnknsiktsynymrtikgyb;
    }

    private String ztyhtnknsiktsynymrtikgybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX2)
    public String getZtyhtnknsiktsynymrtikgybx2() {
        return ztyhtnknsiktsynymrtikgybx2;
    }

    public void setZtyhtnknsiktsynymrtikgybx2(String pZtyhtnknsiktsynymrtikgybx2) {
        ztyhtnknsiktsynymrtikgybx2 = pZtyhtnknsiktsynymrtikgybx2;
    }

    private String ztyhtnknsiktsynymrtikgybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX3)
    public String getZtyhtnknsiktsynymrtikgybx3() {
        return ztyhtnknsiktsynymrtikgybx3;
    }

    public void setZtyhtnknsiktsynymrtikgybx3(String pZtyhtnknsiktsynymrtikgybx3) {
        ztyhtnknsiktsynymrtikgybx3 = pZtyhtnknsiktsynymrtikgybx3;
    }

    private String ztyhtnknsiktsynymrtikgybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX4)
    public String getZtyhtnknsiktsynymrtikgybx4() {
        return ztyhtnknsiktsynymrtikgybx4;
    }

    public void setZtyhtnknsiktsynymrtikgybx4(String pZtyhtnknsiktsynymrtikgybx4) {
        ztyhtnknsiktsynymrtikgybx4 = pZtyhtnknsiktsynymrtikgybx4;
    }

    private String ztyhtnknsiktsynymrtikgybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX5)
    public String getZtyhtnknsiktsynymrtikgybx5() {
        return ztyhtnknsiktsynymrtikgybx5;
    }

    public void setZtyhtnknsiktsynymrtikgybx5(String pZtyhtnknsiktsynymrtikgybx5) {
        ztyhtnknsiktsynymrtikgybx5 = pZtyhtnknsiktsynymrtikgybx5;
    }

    private String ztyhtnknsiktsyknbytksyrkg;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKSYRKG)
    public String getZtyhtnknsiktsyknbytksyrkg() {
        return ztyhtnknsiktsyknbytksyrkg;
    }

    public void setZtyhtnknsiktsyknbytksyrkg(String pZtyhtnknsiktsyknbytksyrkg) {
        ztyhtnknsiktsyknbytksyrkg = pZtyhtnknsiktsyknbytksyrkg;
    }

    private String ztyhtnknsiktsyknbykgsdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYKGSDKBN)
    public String getZtyhtnknsiktsyknbykgsdkbn() {
        return ztyhtnknsiktsyknbykgsdkbn;
    }

    public void setZtyhtnknsiktsyknbykgsdkbn(String pZtyhtnknsiktsyknbykgsdkbn) {
        ztyhtnknsiktsyknbykgsdkbn = pZtyhtnknsiktsyknbykgsdkbn;
    }

    private String ztyhtnknsiktsyknbytkkgyb;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYB)
    public String getZtyhtnknsiktsyknbytkkgyb() {
        return ztyhtnknsiktsyknbytkkgyb;
    }

    public void setZtyhtnknsiktsyknbytkkgyb(String pZtyhtnknsiktsyknbytkkgyb) {
        ztyhtnknsiktsyknbytkkgyb = pZtyhtnknsiktsyknbytkkgyb;
    }

    private String ztyhtnknsiktsyknbytkkgybx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX2)
    public String getZtyhtnknsiktsyknbytkkgybx2() {
        return ztyhtnknsiktsyknbytkkgybx2;
    }

    public void setZtyhtnknsiktsyknbytkkgybx2(String pZtyhtnknsiktsyknbytkkgybx2) {
        ztyhtnknsiktsyknbytkkgybx2 = pZtyhtnknsiktsyknbytkkgybx2;
    }

    private String ztyhtnknsiktsyknbytkkgybx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX3)
    public String getZtyhtnknsiktsyknbytkkgybx3() {
        return ztyhtnknsiktsyknbytkkgybx3;
    }

    public void setZtyhtnknsiktsyknbytkkgybx3(String pZtyhtnknsiktsyknbytkkgybx3) {
        ztyhtnknsiktsyknbytkkgybx3 = pZtyhtnknsiktsyknbytkkgybx3;
    }

    private String ztyhtnknsiktsyknbytkkgybx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX4)
    public String getZtyhtnknsiktsyknbytkkgybx4() {
        return ztyhtnknsiktsyknbytkkgybx4;
    }

    public void setZtyhtnknsiktsyknbytkkgybx4(String pZtyhtnknsiktsyknbytkkgybx4) {
        ztyhtnknsiktsyknbytkkgybx4 = pZtyhtnknsiktsyknbytkkgybx4;
    }

    private String ztyhtnknsiktsyknbytkkgybx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX5)
    public String getZtyhtnknsiktsyknbytkkgybx5() {
        return ztyhtnknsiktsyknbytkkgybx5;
    }

    public void setZtyhtnknsiktsyknbytkkgybx5(String pZtyhtnknsiktsyknbytkkgybx5) {
        ztyhtnknsiktsyknbytkkgybx5 = pZtyhtnknsiktsyknbytkkgybx5;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }

    private String ztyhtnknsiktsynymrtisyrkgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTISYRKGX2)
    public String getZtyhtnknsiktsynymrtisyrkgx2() {
        return ztyhtnknsiktsynymrtisyrkgx2;
    }

    public void setZtyhtnknsiktsynymrtisyrkgx2(String pZtyhtnknsiktsynymrtisyrkgx2) {
        ztyhtnknsiktsynymrtisyrkgx2 = pZtyhtnknsiktsynymrtisyrkgx2;
    }

    private String ztyhtnknsiktsynykgusdikbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYKGUSDIKBNX2)
    public String getZtyhtnknsiktsynykgusdikbnx2() {
        return ztyhtnknsiktsynykgusdikbnx2;
    }

    public void setZtyhtnknsiktsynykgusdikbnx2(String pZtyhtnknsiktsynykgusdikbnx2) {
        ztyhtnknsiktsynykgusdikbnx2 = pZtyhtnknsiktsynykgusdikbnx2;
    }

    private String ztyhtnknsiktsynymrtikgybx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX6)
    public String getZtyhtnknsiktsynymrtikgybx6() {
        return ztyhtnknsiktsynymrtikgybx6;
    }

    public void setZtyhtnknsiktsynymrtikgybx6(String pZtyhtnknsiktsynymrtikgybx6) {
        ztyhtnknsiktsynymrtikgybx6 = pZtyhtnknsiktsynymrtikgybx6;
    }

    private String ztyhtnknsiktsynymrtikgybx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX7)
    public String getZtyhtnknsiktsynymrtikgybx7() {
        return ztyhtnknsiktsynymrtikgybx7;
    }

    public void setZtyhtnknsiktsynymrtikgybx7(String pZtyhtnknsiktsynymrtikgybx7) {
        ztyhtnknsiktsynymrtikgybx7 = pZtyhtnknsiktsynymrtikgybx7;
    }

    private String ztyhtnknsiktsynymrtikgybx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX8)
    public String getZtyhtnknsiktsynymrtikgybx8() {
        return ztyhtnknsiktsynymrtikgybx8;
    }

    public void setZtyhtnknsiktsynymrtikgybx8(String pZtyhtnknsiktsynymrtikgybx8) {
        ztyhtnknsiktsynymrtikgybx8 = pZtyhtnknsiktsynymrtikgybx8;
    }

    private String ztyhtnknsiktsynymrtikgybx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX9)
    public String getZtyhtnknsiktsynymrtikgybx9() {
        return ztyhtnknsiktsynymrtikgybx9;
    }

    public void setZtyhtnknsiktsynymrtikgybx9(String pZtyhtnknsiktsynymrtikgybx9) {
        ztyhtnknsiktsynymrtikgybx9 = pZtyhtnknsiktsynymrtikgybx9;
    }

    private String ztyhtnknsiktsynymrtikgybx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX10)
    public String getZtyhtnknsiktsynymrtikgybx10() {
        return ztyhtnknsiktsynymrtikgybx10;
    }

    public void setZtyhtnknsiktsynymrtikgybx10(String pZtyhtnknsiktsynymrtikgybx10) {
        ztyhtnknsiktsynymrtikgybx10 = pZtyhtnknsiktsynymrtikgybx10;
    }

    private String ztyhtnknsiktsyknbytksyrkgx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKSYRKGX2)
    public String getZtyhtnknsiktsyknbytksyrkgx2() {
        return ztyhtnknsiktsyknbytksyrkgx2;
    }

    public void setZtyhtnknsiktsyknbytksyrkgx2(String pZtyhtnknsiktsyknbytksyrkgx2) {
        ztyhtnknsiktsyknbytksyrkgx2 = pZtyhtnknsiktsyknbytksyrkgx2;
    }

    private String ztyhtnknsiktsyknbykgsdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYKGSDKBNX2)
    public String getZtyhtnknsiktsyknbykgsdkbnx2() {
        return ztyhtnknsiktsyknbykgsdkbnx2;
    }

    public void setZtyhtnknsiktsyknbykgsdkbnx2(String pZtyhtnknsiktsyknbykgsdkbnx2) {
        ztyhtnknsiktsyknbykgsdkbnx2 = pZtyhtnknsiktsyknbykgsdkbnx2;
    }

    private String ztyhtnknsiktsyknbytkkgybx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX6)
    public String getZtyhtnknsiktsyknbytkkgybx6() {
        return ztyhtnknsiktsyknbytkkgybx6;
    }

    public void setZtyhtnknsiktsyknbytkkgybx6(String pZtyhtnknsiktsyknbytkkgybx6) {
        ztyhtnknsiktsyknbytkkgybx6 = pZtyhtnknsiktsyknbytkkgybx6;
    }

    private String ztyhtnknsiktsyknbytkkgybx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX7)
    public String getZtyhtnknsiktsyknbytkkgybx7() {
        return ztyhtnknsiktsyknbytkkgybx7;
    }

    public void setZtyhtnknsiktsyknbytkkgybx7(String pZtyhtnknsiktsyknbytkkgybx7) {
        ztyhtnknsiktsyknbytkkgybx7 = pZtyhtnknsiktsyknbytkkgybx7;
    }

    private String ztyhtnknsiktsyknbytkkgybx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX8)
    public String getZtyhtnknsiktsyknbytkkgybx8() {
        return ztyhtnknsiktsyknbytkkgybx8;
    }

    public void setZtyhtnknsiktsyknbytkkgybx8(String pZtyhtnknsiktsyknbytkkgybx8) {
        ztyhtnknsiktsyknbytkkgybx8 = pZtyhtnknsiktsyknbytkkgybx8;
    }

    private String ztyhtnknsiktsyknbytkkgybx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX9)
    public String getZtyhtnknsiktsyknbytkkgybx9() {
        return ztyhtnknsiktsyknbytkkgybx9;
    }

    public void setZtyhtnknsiktsyknbytkkgybx9(String pZtyhtnknsiktsyknbytkkgybx9) {
        ztyhtnknsiktsyknbytkkgybx9 = pZtyhtnknsiktsyknbytkkgybx9;
    }

    private String ztyhtnknsiktsyknbytkkgybx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX10)
    public String getZtyhtnknsiktsyknbytkkgybx10() {
        return ztyhtnknsiktsyknbytkkgybx10;
    }

    public void setZtyhtnknsiktsyknbytkkgybx10(String pZtyhtnknsiktsyknbytkkgybx10) {
        ztyhtnknsiktsyknbytkkgybx10 = pZtyhtnknsiktsyknbytkkgybx10;
    }

    private String ztyyobiv24x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV24X2)
    public String getZtyyobiv24x2() {
        return ztyyobiv24x2;
    }

    public void setZtyyobiv24x2(String pZtyyobiv24x2) {
        ztyyobiv24x2 = pZtyyobiv24x2;
    }

    private String ztyhtnknsiktsynymrtisyrkgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTISYRKGX3)
    public String getZtyhtnknsiktsynymrtisyrkgx3() {
        return ztyhtnknsiktsynymrtisyrkgx3;
    }

    public void setZtyhtnknsiktsynymrtisyrkgx3(String pZtyhtnknsiktsynymrtisyrkgx3) {
        ztyhtnknsiktsynymrtisyrkgx3 = pZtyhtnknsiktsynymrtisyrkgx3;
    }

    private String ztyhtnknsiktsynykgusdikbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYKGUSDIKBNX3)
    public String getZtyhtnknsiktsynykgusdikbnx3() {
        return ztyhtnknsiktsynykgusdikbnx3;
    }

    public void setZtyhtnknsiktsynykgusdikbnx3(String pZtyhtnknsiktsynykgusdikbnx3) {
        ztyhtnknsiktsynykgusdikbnx3 = pZtyhtnknsiktsynykgusdikbnx3;
    }

    private String ztyhtnknsiktsynymrtikgybx11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX11)
    public String getZtyhtnknsiktsynymrtikgybx11() {
        return ztyhtnknsiktsynymrtikgybx11;
    }

    public void setZtyhtnknsiktsynymrtikgybx11(String pZtyhtnknsiktsynymrtikgybx11) {
        ztyhtnknsiktsynymrtikgybx11 = pZtyhtnknsiktsynymrtikgybx11;
    }

    private String ztyhtnknsiktsynymrtikgybx12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX12)
    public String getZtyhtnknsiktsynymrtikgybx12() {
        return ztyhtnknsiktsynymrtikgybx12;
    }

    public void setZtyhtnknsiktsynymrtikgybx12(String pZtyhtnknsiktsynymrtikgybx12) {
        ztyhtnknsiktsynymrtikgybx12 = pZtyhtnknsiktsynymrtikgybx12;
    }

    private String ztyhtnknsiktsynymrtikgybx13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX13)
    public String getZtyhtnknsiktsynymrtikgybx13() {
        return ztyhtnknsiktsynymrtikgybx13;
    }

    public void setZtyhtnknsiktsynymrtikgybx13(String pZtyhtnknsiktsynymrtikgybx13) {
        ztyhtnknsiktsynymrtikgybx13 = pZtyhtnknsiktsynymrtikgybx13;
    }

    private String ztyhtnknsiktsynymrtikgybx14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX14)
    public String getZtyhtnknsiktsynymrtikgybx14() {
        return ztyhtnknsiktsynymrtikgybx14;
    }

    public void setZtyhtnknsiktsynymrtikgybx14(String pZtyhtnknsiktsynymrtikgybx14) {
        ztyhtnknsiktsynymrtikgybx14 = pZtyhtnknsiktsynymrtikgybx14;
    }

    private String ztyhtnknsiktsynymrtikgybx15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX15)
    public String getZtyhtnknsiktsynymrtikgybx15() {
        return ztyhtnknsiktsynymrtikgybx15;
    }

    public void setZtyhtnknsiktsynymrtikgybx15(String pZtyhtnknsiktsynymrtikgybx15) {
        ztyhtnknsiktsynymrtikgybx15 = pZtyhtnknsiktsynymrtikgybx15;
    }

    private String ztyhtnknsiktsyknbytksyrkgx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKSYRKGX3)
    public String getZtyhtnknsiktsyknbytksyrkgx3() {
        return ztyhtnknsiktsyknbytksyrkgx3;
    }

    public void setZtyhtnknsiktsyknbytksyrkgx3(String pZtyhtnknsiktsyknbytksyrkgx3) {
        ztyhtnknsiktsyknbytksyrkgx3 = pZtyhtnknsiktsyknbytksyrkgx3;
    }

    private String ztyhtnknsiktsyknbykgsdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYKGSDKBNX3)
    public String getZtyhtnknsiktsyknbykgsdkbnx3() {
        return ztyhtnknsiktsyknbykgsdkbnx3;
    }

    public void setZtyhtnknsiktsyknbykgsdkbnx3(String pZtyhtnknsiktsyknbykgsdkbnx3) {
        ztyhtnknsiktsyknbykgsdkbnx3 = pZtyhtnknsiktsyknbykgsdkbnx3;
    }

    private String ztyhtnknsiktsyknbytkkgybx11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX11)
    public String getZtyhtnknsiktsyknbytkkgybx11() {
        return ztyhtnknsiktsyknbytkkgybx11;
    }

    public void setZtyhtnknsiktsyknbytkkgybx11(String pZtyhtnknsiktsyknbytkkgybx11) {
        ztyhtnknsiktsyknbytkkgybx11 = pZtyhtnknsiktsyknbytkkgybx11;
    }

    private String ztyhtnknsiktsyknbytkkgybx12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX12)
    public String getZtyhtnknsiktsyknbytkkgybx12() {
        return ztyhtnknsiktsyknbytkkgybx12;
    }

    public void setZtyhtnknsiktsyknbytkkgybx12(String pZtyhtnknsiktsyknbytkkgybx12) {
        ztyhtnknsiktsyknbytkkgybx12 = pZtyhtnknsiktsyknbytkkgybx12;
    }

    private String ztyhtnknsiktsyknbytkkgybx13;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX13)
    public String getZtyhtnknsiktsyknbytkkgybx13() {
        return ztyhtnknsiktsyknbytkkgybx13;
    }

    public void setZtyhtnknsiktsyknbytkkgybx13(String pZtyhtnknsiktsyknbytkkgybx13) {
        ztyhtnknsiktsyknbytkkgybx13 = pZtyhtnknsiktsyknbytkkgybx13;
    }

    private String ztyhtnknsiktsyknbytkkgybx14;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX14)
    public String getZtyhtnknsiktsyknbytkkgybx14() {
        return ztyhtnknsiktsyknbytkkgybx14;
    }

    public void setZtyhtnknsiktsyknbytkkgybx14(String pZtyhtnknsiktsyknbytkkgybx14) {
        ztyhtnknsiktsyknbytkkgybx14 = pZtyhtnknsiktsyknbytkkgybx14;
    }

    private String ztyhtnknsiktsyknbytkkgybx15;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX15)
    public String getZtyhtnknsiktsyknbytkkgybx15() {
        return ztyhtnknsiktsyknbytkkgybx15;
    }

    public void setZtyhtnknsiktsyknbytkkgybx15(String pZtyhtnknsiktsyknbytkkgybx15) {
        ztyhtnknsiktsyknbytkkgybx15 = pZtyhtnknsiktsyknbytkkgybx15;
    }

    private String ztyyobiv24x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV24X3)
    public String getZtyyobiv24x3() {
        return ztyyobiv24x3;
    }

    public void setZtyyobiv24x3(String pZtyyobiv24x3) {
        ztyyobiv24x3 = pZtyyobiv24x3;
    }

    private String ztyhtnknsiktsynymrtisyrkgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTISYRKGX4)
    public String getZtyhtnknsiktsynymrtisyrkgx4() {
        return ztyhtnknsiktsynymrtisyrkgx4;
    }

    public void setZtyhtnknsiktsynymrtisyrkgx4(String pZtyhtnknsiktsynymrtisyrkgx4) {
        ztyhtnknsiktsynymrtisyrkgx4 = pZtyhtnknsiktsynymrtisyrkgx4;
    }

    private String ztyhtnknsiktsynykgusdikbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYKGUSDIKBNX4)
    public String getZtyhtnknsiktsynykgusdikbnx4() {
        return ztyhtnknsiktsynykgusdikbnx4;
    }

    public void setZtyhtnknsiktsynykgusdikbnx4(String pZtyhtnknsiktsynykgusdikbnx4) {
        ztyhtnknsiktsynykgusdikbnx4 = pZtyhtnknsiktsynykgusdikbnx4;
    }

    private String ztyhtnknsiktsynymrtikgybx16;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX16)
    public String getZtyhtnknsiktsynymrtikgybx16() {
        return ztyhtnknsiktsynymrtikgybx16;
    }

    public void setZtyhtnknsiktsynymrtikgybx16(String pZtyhtnknsiktsynymrtikgybx16) {
        ztyhtnknsiktsynymrtikgybx16 = pZtyhtnknsiktsynymrtikgybx16;
    }

    private String ztyhtnknsiktsynymrtikgybx17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX17)
    public String getZtyhtnknsiktsynymrtikgybx17() {
        return ztyhtnknsiktsynymrtikgybx17;
    }

    public void setZtyhtnknsiktsynymrtikgybx17(String pZtyhtnknsiktsynymrtikgybx17) {
        ztyhtnknsiktsynymrtikgybx17 = pZtyhtnknsiktsynymrtikgybx17;
    }

    private String ztyhtnknsiktsynymrtikgybx18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX18)
    public String getZtyhtnknsiktsynymrtikgybx18() {
        return ztyhtnknsiktsynymrtikgybx18;
    }

    public void setZtyhtnknsiktsynymrtikgybx18(String pZtyhtnknsiktsynymrtikgybx18) {
        ztyhtnknsiktsynymrtikgybx18 = pZtyhtnknsiktsynymrtikgybx18;
    }

    private String ztyhtnknsiktsynymrtikgybx19;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX19)
    public String getZtyhtnknsiktsynymrtikgybx19() {
        return ztyhtnknsiktsynymrtikgybx19;
    }

    public void setZtyhtnknsiktsynymrtikgybx19(String pZtyhtnknsiktsynymrtikgybx19) {
        ztyhtnknsiktsynymrtikgybx19 = pZtyhtnknsiktsynymrtikgybx19;
    }

    private String ztyhtnknsiktsynymrtikgybx20;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX20)
    public String getZtyhtnknsiktsynymrtikgybx20() {
        return ztyhtnknsiktsynymrtikgybx20;
    }

    public void setZtyhtnknsiktsynymrtikgybx20(String pZtyhtnknsiktsynymrtikgybx20) {
        ztyhtnknsiktsynymrtikgybx20 = pZtyhtnknsiktsynymrtikgybx20;
    }

    private String ztyhtnknsiktsyknbytksyrkgx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKSYRKGX4)
    public String getZtyhtnknsiktsyknbytksyrkgx4() {
        return ztyhtnknsiktsyknbytksyrkgx4;
    }

    public void setZtyhtnknsiktsyknbytksyrkgx4(String pZtyhtnknsiktsyknbytksyrkgx4) {
        ztyhtnknsiktsyknbytksyrkgx4 = pZtyhtnknsiktsyknbytksyrkgx4;
    }

    private String ztyhtnknsiktsyknbykgsdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYKGSDKBNX4)
    public String getZtyhtnknsiktsyknbykgsdkbnx4() {
        return ztyhtnknsiktsyknbykgsdkbnx4;
    }

    public void setZtyhtnknsiktsyknbykgsdkbnx4(String pZtyhtnknsiktsyknbykgsdkbnx4) {
        ztyhtnknsiktsyknbykgsdkbnx4 = pZtyhtnknsiktsyknbykgsdkbnx4;
    }

    private String ztyhtnknsiktsyknbytkkgybx16;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX16)
    public String getZtyhtnknsiktsyknbytkkgybx16() {
        return ztyhtnknsiktsyknbytkkgybx16;
    }

    public void setZtyhtnknsiktsyknbytkkgybx16(String pZtyhtnknsiktsyknbytkkgybx16) {
        ztyhtnknsiktsyknbytkkgybx16 = pZtyhtnknsiktsyknbytkkgybx16;
    }

    private String ztyhtnknsiktsyknbytkkgybx17;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX17)
    public String getZtyhtnknsiktsyknbytkkgybx17() {
        return ztyhtnknsiktsyknbytkkgybx17;
    }

    public void setZtyhtnknsiktsyknbytkkgybx17(String pZtyhtnknsiktsyknbytkkgybx17) {
        ztyhtnknsiktsyknbytkkgybx17 = pZtyhtnknsiktsyknbytkkgybx17;
    }

    private String ztyhtnknsiktsyknbytkkgybx18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX18)
    public String getZtyhtnknsiktsyknbytkkgybx18() {
        return ztyhtnknsiktsyknbytkkgybx18;
    }

    public void setZtyhtnknsiktsyknbytkkgybx18(String pZtyhtnknsiktsyknbytkkgybx18) {
        ztyhtnknsiktsyknbytkkgybx18 = pZtyhtnknsiktsyknbytkkgybx18;
    }

    private String ztyhtnknsiktsyknbytkkgybx19;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX19)
    public String getZtyhtnknsiktsyknbytkkgybx19() {
        return ztyhtnknsiktsyknbytkkgybx19;
    }

    public void setZtyhtnknsiktsyknbytkkgybx19(String pZtyhtnknsiktsyknbytkkgybx19) {
        ztyhtnknsiktsyknbytkkgybx19 = pZtyhtnknsiktsyknbytkkgybx19;
    }

    private String ztyhtnknsiktsyknbytkkgybx20;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX20)
    public String getZtyhtnknsiktsyknbytkkgybx20() {
        return ztyhtnknsiktsyknbytkkgybx20;
    }

    public void setZtyhtnknsiktsyknbytkkgybx20(String pZtyhtnknsiktsyknbytkkgybx20) {
        ztyhtnknsiktsyknbytkkgybx20 = pZtyhtnknsiktsyknbytkkgybx20;
    }

    private String ztyyobiv24x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV24X4)
    public String getZtyyobiv24x4() {
        return ztyyobiv24x4;
    }

    public void setZtyyobiv24x4(String pZtyyobiv24x4) {
        ztyyobiv24x4 = pZtyyobiv24x4;
    }

    private String ztyhtnknsiktsynymrtisyrkgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTISYRKGX5)
    public String getZtyhtnknsiktsynymrtisyrkgx5() {
        return ztyhtnknsiktsynymrtisyrkgx5;
    }

    public void setZtyhtnknsiktsynymrtisyrkgx5(String pZtyhtnknsiktsynymrtisyrkgx5) {
        ztyhtnknsiktsynymrtisyrkgx5 = pZtyhtnknsiktsynymrtisyrkgx5;
    }

    private String ztyhtnknsiktsynykgusdikbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYKGUSDIKBNX5)
    public String getZtyhtnknsiktsynykgusdikbnx5() {
        return ztyhtnknsiktsynykgusdikbnx5;
    }

    public void setZtyhtnknsiktsynykgusdikbnx5(String pZtyhtnknsiktsynykgusdikbnx5) {
        ztyhtnknsiktsynykgusdikbnx5 = pZtyhtnknsiktsynykgusdikbnx5;
    }

    private String ztyhtnknsiktsynymrtikgybx21;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX21)
    public String getZtyhtnknsiktsynymrtikgybx21() {
        return ztyhtnknsiktsynymrtikgybx21;
    }

    public void setZtyhtnknsiktsynymrtikgybx21(String pZtyhtnknsiktsynymrtikgybx21) {
        ztyhtnknsiktsynymrtikgybx21 = pZtyhtnknsiktsynymrtikgybx21;
    }

    private String ztyhtnknsiktsynymrtikgybx22;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX22)
    public String getZtyhtnknsiktsynymrtikgybx22() {
        return ztyhtnknsiktsynymrtikgybx22;
    }

    public void setZtyhtnknsiktsynymrtikgybx22(String pZtyhtnknsiktsynymrtikgybx22) {
        ztyhtnknsiktsynymrtikgybx22 = pZtyhtnknsiktsynymrtikgybx22;
    }

    private String ztyhtnknsiktsynymrtikgybx23;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX23)
    public String getZtyhtnknsiktsynymrtikgybx23() {
        return ztyhtnknsiktsynymrtikgybx23;
    }

    public void setZtyhtnknsiktsynymrtikgybx23(String pZtyhtnknsiktsynymrtikgybx23) {
        ztyhtnknsiktsynymrtikgybx23 = pZtyhtnknsiktsynymrtikgybx23;
    }

    private String ztyhtnknsiktsynymrtikgybx24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX24)
    public String getZtyhtnknsiktsynymrtikgybx24() {
        return ztyhtnknsiktsynymrtikgybx24;
    }

    public void setZtyhtnknsiktsynymrtikgybx24(String pZtyhtnknsiktsynymrtikgybx24) {
        ztyhtnknsiktsynymrtikgybx24 = pZtyhtnknsiktsynymrtikgybx24;
    }

    private String ztyhtnknsiktsynymrtikgybx25;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX25)
    public String getZtyhtnknsiktsynymrtikgybx25() {
        return ztyhtnknsiktsynymrtikgybx25;
    }

    public void setZtyhtnknsiktsynymrtikgybx25(String pZtyhtnknsiktsynymrtikgybx25) {
        ztyhtnknsiktsynymrtikgybx25 = pZtyhtnknsiktsynymrtikgybx25;
    }

    private String ztyhtnknsiktsyknbytksyrkgx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKSYRKGX5)
    public String getZtyhtnknsiktsyknbytksyrkgx5() {
        return ztyhtnknsiktsyknbytksyrkgx5;
    }

    public void setZtyhtnknsiktsyknbytksyrkgx5(String pZtyhtnknsiktsyknbytksyrkgx5) {
        ztyhtnknsiktsyknbytksyrkgx5 = pZtyhtnknsiktsyknbytksyrkgx5;
    }

    private String ztyhtnknsiktsyknbykgsdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYKGSDKBNX5)
    public String getZtyhtnknsiktsyknbykgsdkbnx5() {
        return ztyhtnknsiktsyknbykgsdkbnx5;
    }

    public void setZtyhtnknsiktsyknbykgsdkbnx5(String pZtyhtnknsiktsyknbykgsdkbnx5) {
        ztyhtnknsiktsyknbykgsdkbnx5 = pZtyhtnknsiktsyknbykgsdkbnx5;
    }

    private String ztyhtnknsiktsyknbytkkgybx21;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX21)
    public String getZtyhtnknsiktsyknbytkkgybx21() {
        return ztyhtnknsiktsyknbytkkgybx21;
    }

    public void setZtyhtnknsiktsyknbytkkgybx21(String pZtyhtnknsiktsyknbytkkgybx21) {
        ztyhtnknsiktsyknbytkkgybx21 = pZtyhtnknsiktsyknbytkkgybx21;
    }

    private String ztyhtnknsiktsyknbytkkgybx22;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX22)
    public String getZtyhtnknsiktsyknbytkkgybx22() {
        return ztyhtnknsiktsyknbytkkgybx22;
    }

    public void setZtyhtnknsiktsyknbytkkgybx22(String pZtyhtnknsiktsyknbytkkgybx22) {
        ztyhtnknsiktsyknbytkkgybx22 = pZtyhtnknsiktsyknbytkkgybx22;
    }

    private String ztyhtnknsiktsyknbytkkgybx23;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX23)
    public String getZtyhtnknsiktsyknbytkkgybx23() {
        return ztyhtnknsiktsyknbytkkgybx23;
    }

    public void setZtyhtnknsiktsyknbytkkgybx23(String pZtyhtnknsiktsyknbytkkgybx23) {
        ztyhtnknsiktsyknbytkkgybx23 = pZtyhtnknsiktsyknbytkkgybx23;
    }

    private String ztyhtnknsiktsyknbytkkgybx24;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX24)
    public String getZtyhtnknsiktsyknbytkkgybx24() {
        return ztyhtnknsiktsyknbytkkgybx24;
    }

    public void setZtyhtnknsiktsyknbytkkgybx24(String pZtyhtnknsiktsyknbytkkgybx24) {
        ztyhtnknsiktsyknbytkkgybx24 = pZtyhtnknsiktsyknbytkkgybx24;
    }

    private String ztyhtnknsiktsyknbytkkgybx25;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX25)
    public String getZtyhtnknsiktsyknbytkkgybx25() {
        return ztyhtnknsiktsyknbytkkgybx25;
    }

    public void setZtyhtnknsiktsyknbytkkgybx25(String pZtyhtnknsiktsyknbytkkgybx25) {
        ztyhtnknsiktsyknbytkkgybx25 = pZtyhtnknsiktsyknbytkkgybx25;
    }

    private String ztyyobiv24x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV24X5)
    public String getZtyyobiv24x5() {
        return ztyyobiv24x5;
    }

    public void setZtyyobiv24x5(String pZtyyobiv24x5) {
        ztyyobiv24x5 = pZtyyobiv24x5;
    }

    private String ztyhtnknsiktsynymrtisyrkgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTISYRKGX6)
    public String getZtyhtnknsiktsynymrtisyrkgx6() {
        return ztyhtnknsiktsynymrtisyrkgx6;
    }

    public void setZtyhtnknsiktsynymrtisyrkgx6(String pZtyhtnknsiktsynymrtisyrkgx6) {
        ztyhtnknsiktsynymrtisyrkgx6 = pZtyhtnknsiktsynymrtisyrkgx6;
    }

    private String ztyhtnknsiktsynykgusdikbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYKGUSDIKBNX6)
    public String getZtyhtnknsiktsynykgusdikbnx6() {
        return ztyhtnknsiktsynykgusdikbnx6;
    }

    public void setZtyhtnknsiktsynykgusdikbnx6(String pZtyhtnknsiktsynykgusdikbnx6) {
        ztyhtnknsiktsynykgusdikbnx6 = pZtyhtnknsiktsynykgusdikbnx6;
    }

    private String ztyhtnknsiktsynymrtikgybx26;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX26)
    public String getZtyhtnknsiktsynymrtikgybx26() {
        return ztyhtnknsiktsynymrtikgybx26;
    }

    public void setZtyhtnknsiktsynymrtikgybx26(String pZtyhtnknsiktsynymrtikgybx26) {
        ztyhtnknsiktsynymrtikgybx26 = pZtyhtnknsiktsynymrtikgybx26;
    }

    private String ztyhtnknsiktsynymrtikgybx27;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX27)
    public String getZtyhtnknsiktsynymrtikgybx27() {
        return ztyhtnknsiktsynymrtikgybx27;
    }

    public void setZtyhtnknsiktsynymrtikgybx27(String pZtyhtnknsiktsynymrtikgybx27) {
        ztyhtnknsiktsynymrtikgybx27 = pZtyhtnknsiktsynymrtikgybx27;
    }

    private String ztyhtnknsiktsynymrtikgybx28;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX28)
    public String getZtyhtnknsiktsynymrtikgybx28() {
        return ztyhtnknsiktsynymrtikgybx28;
    }

    public void setZtyhtnknsiktsynymrtikgybx28(String pZtyhtnknsiktsynymrtikgybx28) {
        ztyhtnknsiktsynymrtikgybx28 = pZtyhtnknsiktsynymrtikgybx28;
    }

    private String ztyhtnknsiktsynymrtikgybx29;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX29)
    public String getZtyhtnknsiktsynymrtikgybx29() {
        return ztyhtnknsiktsynymrtikgybx29;
    }

    public void setZtyhtnknsiktsynymrtikgybx29(String pZtyhtnknsiktsynymrtikgybx29) {
        ztyhtnknsiktsynymrtikgybx29 = pZtyhtnknsiktsynymrtikgybx29;
    }

    private String ztyhtnknsiktsynymrtikgybx30;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYNYMRTIKGYBX30)
    public String getZtyhtnknsiktsynymrtikgybx30() {
        return ztyhtnknsiktsynymrtikgybx30;
    }

    public void setZtyhtnknsiktsynymrtikgybx30(String pZtyhtnknsiktsynymrtikgybx30) {
        ztyhtnknsiktsynymrtikgybx30 = pZtyhtnknsiktsynymrtikgybx30;
    }

    private String ztyhtnknsiktsyknbytksyrkgx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKSYRKGX6)
    public String getZtyhtnknsiktsyknbytksyrkgx6() {
        return ztyhtnknsiktsyknbytksyrkgx6;
    }

    public void setZtyhtnknsiktsyknbytksyrkgx6(String pZtyhtnknsiktsyknbytksyrkgx6) {
        ztyhtnknsiktsyknbytksyrkgx6 = pZtyhtnknsiktsyknbytksyrkgx6;
    }

    private String ztyhtnknsiktsyknbykgsdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYKGSDKBNX6)
    public String getZtyhtnknsiktsyknbykgsdkbnx6() {
        return ztyhtnknsiktsyknbykgsdkbnx6;
    }

    public void setZtyhtnknsiktsyknbykgsdkbnx6(String pZtyhtnknsiktsyknbykgsdkbnx6) {
        ztyhtnknsiktsyknbykgsdkbnx6 = pZtyhtnknsiktsyknbykgsdkbnx6;
    }

    private String ztyhtnknsiktsyknbytkkgybx26;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX26)
    public String getZtyhtnknsiktsyknbytkkgybx26() {
        return ztyhtnknsiktsyknbytkkgybx26;
    }

    public void setZtyhtnknsiktsyknbytkkgybx26(String pZtyhtnknsiktsyknbytkkgybx26) {
        ztyhtnknsiktsyknbytkkgybx26 = pZtyhtnknsiktsyknbytkkgybx26;
    }

    private String ztyhtnknsiktsyknbytkkgybx27;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX27)
    public String getZtyhtnknsiktsyknbytkkgybx27() {
        return ztyhtnknsiktsyknbytkkgybx27;
    }

    public void setZtyhtnknsiktsyknbytkkgybx27(String pZtyhtnknsiktsyknbytkkgybx27) {
        ztyhtnknsiktsyknbytkkgybx27 = pZtyhtnknsiktsyknbytkkgybx27;
    }

    private String ztyhtnknsiktsyknbytkkgybx28;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX28)
    public String getZtyhtnknsiktsyknbytkkgybx28() {
        return ztyhtnknsiktsyknbytkkgybx28;
    }

    public void setZtyhtnknsiktsyknbytkkgybx28(String pZtyhtnknsiktsyknbytkkgybx28) {
        ztyhtnknsiktsyknbytkkgybx28 = pZtyhtnknsiktsyknbytkkgybx28;
    }

    private String ztyhtnknsiktsyknbytkkgybx29;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX29)
    public String getZtyhtnknsiktsyknbytkkgybx29() {
        return ztyhtnknsiktsyknbytkkgybx29;
    }

    public void setZtyhtnknsiktsyknbytkkgybx29(String pZtyhtnknsiktsyknbytkkgybx29) {
        ztyhtnknsiktsyknbytkkgybx29 = pZtyhtnknsiktsyknbytkkgybx29;
    }

    private String ztyhtnknsiktsyknbytkkgybx30;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYHTNKNSIKTSYKNBYTKKGYBX30)
    public String getZtyhtnknsiktsyknbytkkgybx30() {
        return ztyhtnknsiktsyknbytkkgybx30;
    }

    public void setZtyhtnknsiktsyknbytkkgybx30(String pZtyhtnknsiktsyknbytkkgybx30) {
        ztyhtnknsiktsyknbytkkgybx30 = pZtyhtnknsiktsyknbytkkgybx30;
    }

    private String ztyyobiv24x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV24X6)
    public String getZtyyobiv24x6() {
        return ztyyobiv24x6;
    }

    public void setZtyyobiv24x6(String pZtyyobiv24x6) {
        ztyyobiv24x6 = pZtyyobiv24x6;
    }

    private BizNumber ztykaiyakuhrmkhritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYKAIYAKUHRMKHRITU)
    public BizNumber getZtykaiyakuhrmkhritu() {
        return ztykaiyakuhrmkhritu;
    }

    public void setZtykaiyakuhrmkhritu(BizNumber pZtykaiyakuhrmkhritu) {
        ztykaiyakuhrmkhritu = pZtykaiyakuhrmkhritu;
    }

    private BizNumber ztytumitatekinitenmkhyurt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYTUMITATEKINITENMKHYURT)
    public BizNumber getZtytumitatekinitenmkhyurt() {
        return ztytumitatekinitenmkhyurt;
    }

    public void setZtytumitatekinitenmkhyurt(BizNumber pZtytumitatekinitenmkhyurt) {
        ztytumitatekinitenmkhyurt = pZtytumitatekinitenmkhyurt;
    }

    private String ztyyobiv250;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV250)
    public String getZtyyobiv250() {
        return ztyyobiv250;
    }

    public void setZtyyobiv250(String pZtyyobiv250) {
        ztyyobiv250 = pZtyyobiv250;
    }

    private String ztyyobiv248;

    @Column(name=GenZT_Sp2RnduyuSouseiritu5Ty.ZTYYOBIV248)
    public String getZtyyobiv248() {
        return ztyyobiv248;
    }

    public void setZtyyobiv248(String pZtyyobiv248) {
        ztyyobiv248 = pZtyyobiv248;
    }
}