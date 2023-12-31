CREATE VIEW ZT_SinninTouhyouRn AS SELECT
     zrnhokenkbn ,         /* （連携用）保険区分 */
     zrnkyknaiyoukbn ,         /* （連携用）契約内容区分 */
     zrnhokenkbnnys ,         /* （連携用）保険区分（名寄せ） */
     zrnsakuinmeinonys ,         /* （連携用）索引名番号（名寄せ） */
     zrnsyainnm ,         /* （連携用）社員名 */
     zrnkanjisyainnm ,         /* （連携用）漢字社員名 */
     zrnsyainseiymd ,         /* （連携用）社員生年月日 */
     zrntsinkihontikucd ,         /* （連携用）通信先基本地区コード */
     zrnkanjitsinkaiadr ,         /* （連携用）漢字通信先下位住所 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrntksyuannaikykkbn ,         /* （連携用）特殊案内契約区分 */
     zrnsouhuhunoukbn ,         /* （連携用）送付不能区分 */
     zrnnaimitureigaihyj ,         /* （連携用）内密例外表示 */
     zrnsyuukinsisya ,         /* （連携用）集金支社 */
     zrnsyuukintntusycd ,         /* （連携用）集金担当者個人コード */
     zrnokyakusamano ,         /* （連携用）お客様番号 */
     zrnnaibukojincd ,         /* （連携用）内部個人コード */
     zrnhokenkbnsyainno ,         /* （連携用）保険区分（社員ＮＯ） */
     zrnsakuinmeinosyainno ,         /* （連携用）索引名番号（社員ＮＯ） */
     zrnbsyym ,         /* （連携用）募集年月 */
     zrnprivacyhogoyouhyj ,         /* （連携用）プライバシー保護要表示 */
     zrnkaigaitokoukykhyj ,         /* （連携用）海外渡航契約表示 */
     zrnnaibukbn ,         /* （連携用）内部区分 */
     zrnkyktsnatkitkyktrkjtkbn ,         /* （連携用）契約通算扱特約登録状態区分 */
     zrnalcardhkkbn ,         /* （連携用）ＡＬカード発行区分 */
     zrnbsydrtenkbn ,         /* （連携用）募集代理店区分 */
     zrnvitkaiinno ,         /* （連携用）Ｖｉｔ会員番号 */
     zrnyobiv60           /* （連携用）予備項目Ｖ６０ */
FROM ZT_SinninTouhyouRn_Z;