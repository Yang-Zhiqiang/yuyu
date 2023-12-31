CREATE VIEW ZT_KhGinkouMdhnFollowCallTy AS SELECT
     ztysyono ,         /* （中継用）証券番号 */
     ztysyorikbn ,         /* （中継用）処理区分 */
     ztyannaip ,         /* （中継用）案内保険料 */
     ztyyobiv8 ,         /* （中継用）予備項目Ｖ８ */
     ztyminyuuym ,         /* （中継用）未入年月 */
     ztyskymd ,         /* （中継用）失効年月日 */
     ztyskhr ,         /* （中継用）失効時返戻金 */
     ztyttkekin ,         /* （中継用）今期立替金額 */
     ztyttkeganri ,         /* （中継用）立替元利金合計 */
     ztyttkersk ,         /* （中継用）立替利息 */
     ztyttkeriritu ,         /* （中継用）立替利率 */
     ztyttkejyuutouym ,         /* （中継用）立替充当年月 */
     ztyttkejyuutounen ,         /* （中継用）立替充当年数 */
     ztyttkejyuutoutuki ,         /* （中継用）立替充当月数 */
     ztyyobin11 ,         /* （中継用）予備項目Ｎ１１ */
     ztyyobiv8x2 ,         /* （中継用）予備項目Ｖ８＿２ */
     ztyyobiv29 ,         /* （中継用）予備項目Ｖ２９ */
     ztykyksyaskinmeino ,         /* （中継用）契約者索引名番号 */
     ztykyksyaseiymd ,         /* （中継用）契約者生年月日 */
     ztykyknmhnykkbn ,         /* （中継用）契約者名翻訳結果区分 */
     ztykjkyknm35keta ,         /* （中継用）漢字契約者名（３５桁） */
     ztyknkyksyamei ,         /* （中継用）カナ契約者名 */
     ztyhhknnmhnykkbn ,         /* （中継用）被保険者名翻訳結果区分 */
     ztyknjhhknmei ,         /* （中継用）漢字被保険者名 */
     ztyknhhknmei ,         /* （中継用）カナ被保険者名 */
     ztyhhknseikbn ,         /* （中継用）被保険者性別区分 */
     ztyhhknseiymd ,         /* （中継用）被保険者生年月日 */
     ztykihontikucd ,         /* （中継用）基本地区コード */
     ztykyksyaadr ,         /* （中継用）契約者住所 */
     ztytsintelno ,         /* （中継用）通信先電話番号 */
     ztykykymd ,         /* （中継用）契約年月日 */
     ztyjikaipjyuutouym ,         /* （中継用）次回Ｐ充当年月 */
     ztyhrkkeirokbn ,         /* （中継用）払込経路区分 */
     ztyhrkkaisuukbn ,         /* （中継用）払込回数区分 */
     ztyanniskcd ,         /* （中継用）案内先コード */
     ztyhknmeisyou15keta ,         /* （中継用）保険名称（１５桁） */
     ztybsyujdrtencd1 ,         /* （中継用）募集時代理店コード１ */
     ztybsyujbosyuucd1 ,         /* （中継用）募集時募集人コード１ */
     ztybsyujdrtencd2 ,         /* （中継用）募集時代理店コード２ */
     ztybsyujbosyuucd2 ,         /* （中継用）募集時募集人コード２ */
     ztybsyujdrtencd3 ,         /* （中継用）募集時代理店コード３ */
     ztybsyujbosyuucd3 ,         /* （中継用）募集時募集人コード３ */
     ztybsyujdrtencd4 ,         /* （中継用）募集時代理店コード４ */
     ztybsyujbosyuucd4 ,         /* （中継用）募集時募集人コード４ */
     ztybsyujdrtencd5 ,         /* （中継用）募集時代理店コード５ */
     ztybsyujbosyuucd5 ,         /* （中継用）募集時募集人コード５ */
     ztysaisindrtencd ,         /* （中継用）最新代理店コード */
     ztysaisinbosyuucd ,         /* （中継用）最新募集人コード */
     ztykzhurikaebankcd ,         /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd ,         /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn ,         /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano ,         /* （中継用）口座振替口座番号 */
     ztyhnsyugkhmignnmei ,         /* （中継用）編集後口座振替名義人名 */
     ztyyobiv39 ,         /* （中継用）予備項目Ｖ３９ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_KhGinkouMdhnFollowCallTy_Z;