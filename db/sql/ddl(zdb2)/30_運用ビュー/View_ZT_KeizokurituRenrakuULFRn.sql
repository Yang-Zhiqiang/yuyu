CREATE VIEW ZT_KeizokurituRenrakuULFRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnatukaikojincd ,         /* （連携用）扱者個人コード */
     zrnbsyym ,         /* （連携用）募集年月 */
     zrnsyukgu ,         /* （連携用）種類記号 */
     zrnhknkkn ,         /* （連携用）保険期間 */
     zrnphrkkikn ,         /* （連携用）Ｐ払込期間 */
     zrnsaimnkkykhyj ,         /* （連携用）才満期契約表示 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrntksyuannaikykkbn ,         /* （連携用）特殊案内契約区分 */
     zrnsyukinkbn ,         /* （連携用）集金区分 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnanniskcd ,         /* （連携用）案内先コード */
     zrnsyuukintantousosikicd ,         /* （連携用）集金担当組織コード */
     zrndnthrkkeirokbn ,         /* （連携用）団体払込経路区分 */
     zrnkhyuukousyoumetukbn ,         /* （連携用）（契約保全）有効消滅区分 */
     zrnkeikatukisuu ,         /* （連携用）経過月数 */
     zrnkeiyakukensuu ,         /* （連携用）契約件数 */
     zrnkihons ,         /* （連携用）基本Ｓ */
     zrnsyuuseis9keta ,         /* （連携用）修正Ｓ（９桁） */
     zrnhsys ,         /* （連携用）保障Ｓ */
     zrnatukaisosikicd ,         /* （連携用）扱者組織コード */
     zrnkyknm ,         /* （連携用）契約者名 */
     zrnkjkyknm ,         /* （連携用）漢字契約者名 */
     zrnhhknseikbn ,         /* （連携用）被保険者性別区分 */
     zrnhhknnen2keta ,         /* （連携用）被保険者年令（２桁） */
     zrnmarutokuhyj ,         /* （連携用）マル特表示 */
     zrntyohktyouseihyj ,         /* （連携用）重複調整表示 */
     zrngyoumujyouhyouji ,         /* （連携用）業務上表示 */
     zrnkydatkihyj ,         /* （連携用）共同扱表示 */
     zrntenkankaisuu ,         /* （連携用）転換回数 */
     zrnkzktatkibanhktgksnkbn ,         /* （連携用）継続手当用基盤引継加算区分 */
     zrnjidoukousinhyouji ,         /* （連携用）自動更新表示 */
     zrnskeijimrtiarihyj ,         /* （連携用）新契約時マル定有表示 */
     zrnskeijikzkmrtiarihyj ,         /* （連携用）新契約時家族マル定有表示 */
     zrnhukkatukeiiarihyj ,         /* （連携用）復活経緯有表示 */
     zrntyouhukutyouseiskeihyj ,         /* （連携用）重複調整新契約表示 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnphkbnmnoshyouji ,         /* （連携用）Ｐ不可分見直表示 */
     zrnkaigomarusyuuarihyj ,         /* （連携用）介護マル終有表示 */
     zrnheiyoubaraikeiyakukbn ,         /* （連携用）併用払契約区分 */
     zrnhngkjidouentyoukbn ,         /* （連携用）変額自動延長区分 */
     zrnhngkjidouentyoukikan ,         /* （連携用）変額自動延長期間 */
     zrndoujihuhomrtisyukigou ,         /* （連携用）同時付保マル定種類記号 */
     zrnyobiv1 ,         /* （連携用）予備項目Ｖ１ */
     zrnseizonmrtiarihyj ,         /* （連携用）生存マル定有表示 */
     zrnteigenmrtiarihyj ,         /* （連携用）逓減マル定有表示 */
     zrnjyunkensuu ,         /* （連携用）純件数 */
     zrnaltourokukeiyakuhyj ,         /* （連携用）ＡＬ登録契約表示 */
     zrnjikokykhyj ,         /* （連携用）自己契約表示 */
     zrnsynymrtiarihyj ,         /* （連携用）収入マル定有表示 */
     zrnkykniyutksytioukbn ,         /* （連携用）契約内容特殊対応区分 */
     zrnreguardmrtiarihyj ,         /* （連携用）リガードマル定有表示 */
     zrnreguardmrsyuarihyj ,         /* （連携用）リガードマル終有表示 */
     zrnvguardmrtiarihyj ,         /* （連携用）Ｖガードマル定有表示 */
     zrnkousintkykhyj ,         /* （連携用）更新特約表示 */
     zrnkousinkakuninnasihyj ,         /* （連携用）更新確認無表示 */
     zrnfollowhunouhyj ,         /* （連携用）フォロー不能表示 */
     zrnkaigosynymrtiarihyj ,         /* （連携用）介護収入マル定有表示 */
     zrnkaigoteigenmrtiarihyj ,         /* （連携用）介護逓減マル定有表示 */
     zrnsuperknkuseikatupackhyj ,         /* （連携用）スーパー健康生活パック表示 */
     zrnkaigonktkykarihyj ,         /* （連携用）介護年金特約有表示 */
     zrnkaigomrtiarihyj ,         /* （連携用）介護マル定有表示 */
     zrnkeiyakukbn ,         /* （連携用）契約区分 */
     zrnkeizokutyuuihyouji ,         /* （連携用）継続注意表示 */
     zrnkikeiyakutyuuihyouji ,         /* （連携用）既契約注意表示 */
     zrnbosyuunincd ,         /* （連携用）募集人コード */
     zrnhsyuikktminaosikaisu ,         /* （連携用）保障一括見直回数 */
     zrnkykjiqpackhyj ,         /* （連携用）契約時Ｑパック表示 */
     zrnbnkttnknkbn ,         /* （連携用）分割転換区分 */
     zrnmrtikousinkbn ,         /* （連携用）マル定更新区分 */
     zrnpmenkbnv1 ,         /* （連携用）Ｐ免区分Ｖ１ */
     zrnyouikunktkykarihyj ,         /* （連携用）養育年金特約有表示 */
     zrnsyoumetucd ,         /* （連携用）消滅コード */
     zrnseikatusyuunyuumrtis ,         /* （連携用）生活収入マル定Ｓ */
     zrnhitenkansyono1 ,         /* （連携用）被転換証券番号１ */
     zrnhitenkansyono2 ,         /* （連携用）被転換証券番号２ */
     zrnhitenkansyono3 ,         /* （連携用）被転換証券番号３ */
     zrnhitenkansyono4 ,         /* （連携用）被転換証券番号４ */
     zrnhitenkansyono5 ,         /* （連携用）被転換証券番号５ */
     zrnhitenkansyono6 ,         /* （連携用）被転換証券番号６ */
     zrnnenkansanp ,         /* （連携用）年換算Ｐ */
     zrndai3bunyanenkansanp ,         /* （連携用）第３分野年換算Ｐ */
     zrnkykym ,         /* （連携用）契約年月 */
     zrnsytikbn ,         /* （連携用）集定区分 */
     zrnfundbubunnenkansanp ,         /* （連携用）ファンド部分年換算Ｐ */
     zrnjikaipjyuutouym ,         /* （連携用）次回Ｐ充当年月 */
     zrnkzktatsyuuseis ,         /* （連携用）継続手当用修正Ｓ */
     zrnsiktsynymrtiarihyj ,         /* （連携用）生活収入マル定有表示 */
     zrnlivguardarihyj ,         /* （連携用）ＬＩＶガード有表示 */
     zrnlivguards ,         /* （連携用）ＬＩＶガードＳ */
     zrnknkuzusnzyrttekitkarihyj ,         /* （連携用）健康増進乗率適用特約有表示 */
     zrnbluekzjtkaisiymd ,         /* （連携用）Ｂｌｕｅ継続状態開始年月日　 */
     zrnknkuzusnzyrtstkbn ,         /* （連携用）健康増進乗率用ステータス区分 */
     zrntokuyakuno ,         /* （連携用）特約番号 */
     zrnvityugusttkyuhyj ,         /* （連携用）Ｖｉｔ優遇措置適用表示　 */
     zrnkykdrtkykarihyj ,         /* （連携用）契約者代理特約有表示 */
     zrnstdairiseikyuutkykarihyj ,         /* （連携用）指定代理請求特約有表示 */
     zrnkzktourokuservicearihyj ,         /* （連携用）家族登録サービス有表示 */
     zrnyendthnkymd8keta ,         /* （連携用）円建変更日（８桁） */
     zrnyobiv16 ,         /* （連携用）予備項目Ｖ１６ */
     zrnkhsyoumetujiyuu ,         /* （連携用）（契約保全）消滅事由 */
     zrnitijibaraipkyktuuka ,         /* （連携用）一時払Ｐ（契約通貨建） */
     zrnkawaseraten5 ,         /* （連携用）為替レートＮ５ */
     zrnnnknsnpssysyup ,         /* （連携用）年換算Ｐ算出用主契約Ｐ */
     zrnnknsnpssyhrkkskbn ,         /* （連携用）年換算Ｐ算出用払込回数区分 */
     zrnnnknsnpyennkgotmttrrt ,         /* （連携用）年換算Ｐ算出用円建年金変更後積立利率 */
     zrnnnknsnpyennkgonksjtmttkn ,         /* （連携用）年換算Ｐ算出用円建年金変更後年金開始時積立金 */
     zrnyobiv71           /* （連携用）予備項目Ｖ７１ */
FROM ZT_KeizokurituRenrakuULFRn_Z;