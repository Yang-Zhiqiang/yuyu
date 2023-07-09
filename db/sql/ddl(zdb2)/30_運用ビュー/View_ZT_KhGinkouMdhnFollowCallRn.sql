CREATE VIEW ZT_KhGinkouMdhnFollowCallRn AS SELECT
     zrnsyono ,         /* （連携用）証券番号 */
     zrnsyorikbn ,         /* （連携用）処理区分 */
     zrnannaip ,         /* （連携用）案内保険料 */
     zrnyobiv8 ,         /* （連携用）予備項目Ｖ８ */
     zrnminyuuym ,         /* （連携用）未入年月 */
     zrnskymd ,         /* （連携用）失効年月日 */
     zrnskhr ,         /* （連携用）失効時返戻金 */
     zrnttkekin ,         /* （連携用）今期立替金額 */
     zrnttkeganri ,         /* （連携用）立替元利金合計 */
     zrnttkersk ,         /* （連携用）立替利息 */
     zrnttkeriritu ,         /* （連携用）立替利率 */
     zrnttkejyuutouym ,         /* （連携用）立替充当年月 */
     zrnttkejyuutounen ,         /* （連携用）立替充当年数 */
     zrnttkejyuutoutuki ,         /* （連携用）立替充当月数 */
     zrnyobin11 ,         /* （連携用）予備項目Ｎ１１ */
     zrnyobiv8x2 ,         /* （連携用）予備項目Ｖ８＿２ */
     zrnyobiv29 ,         /* （連携用）予備項目Ｖ２９ */
     zrnkyksyaskinmeino ,         /* （連携用）契約者索引名番号 */
     zrnkyksyaseiymd ,         /* （連携用）契約者生年月日 */
     zrnkyknmhnykkbn ,         /* （連携用）契約者名翻訳結果区分 */
     zrnkjkyknm35keta ,         /* （連携用）漢字契約者名（３５桁） */
     zrnknkyksyamei ,         /* （連携用）カナ契約者名 */
     zrnhhknnmhnykkbn ,         /* （連携用）被保険者名翻訳結果区分 */
     zrnknjhhknmei ,         /* （連携用）漢字被保険者名 */
     zrnknhhknmei ,         /* （連携用）カナ被保険者名 */
     zrnhhknseikbn ,         /* （連携用）被保険者性別区分 */
     zrnhhknseiymd ,         /* （連携用）被保険者生年月日 */
     zrnkihontikucd ,         /* （連携用）基本地区コード */
     zrnkyksyaadr ,         /* （連携用）契約者住所 */
     zrntsintelno ,         /* （連携用）通信先電話番号 */
     zrnkykymd ,         /* （連携用）契約年月日 */
     zrnjikaipjyuutouym ,         /* （連携用）次回Ｐ充当年月 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnanniskcd ,         /* （連携用）案内先コード */
     zrnhknmeisyou15keta ,         /* （連携用）保険名称（１５桁） */
     zrnbsyujdrtencd1 ,         /* （連携用）募集時代理店コード１ */
     zrnbsyujbosyuucd1 ,         /* （連携用）募集時募集人コード１ */
     zrnbsyujdrtencd2 ,         /* （連携用）募集時代理店コード２ */
     zrnbsyujbosyuucd2 ,         /* （連携用）募集時募集人コード２ */
     zrnbsyujdrtencd3 ,         /* （連携用）募集時代理店コード３ */
     zrnbsyujbosyuucd3 ,         /* （連携用）募集時募集人コード３ */
     zrnbsyujdrtencd4 ,         /* （連携用）募集時代理店コード４ */
     zrnbsyujbosyuucd4 ,         /* （連携用）募集時募集人コード４ */
     zrnbsyujdrtencd5 ,         /* （連携用）募集時代理店コード５ */
     zrnbsyujbosyuucd5 ,         /* （連携用）募集時募集人コード５ */
     zrnsaisindrtencd ,         /* （連携用）最新代理店コード */
     zrnsaisinbosyuucd ,         /* （連携用）最新募集人コード */
     zrnkzhurikaebankcd ,         /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd ,         /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn ,         /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano ,         /* （連携用）口座振替口座番号 */
     zrnhnsyugkhmignnmei ,         /* （連携用）編集後口座振替名義人名 */
     zrnyobiv39           /* （連携用）予備項目Ｖ３９ */
FROM ZT_KhGinkouMdhnFollowCallRn_Z;