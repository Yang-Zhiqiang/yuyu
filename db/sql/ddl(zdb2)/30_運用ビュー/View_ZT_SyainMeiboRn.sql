CREATE VIEW ZT_SyainMeiboRn AS SELECT
     zrnhokenkbn ,         /* （連携用）保険区分 */
     zrnsyainmeibokbn ,         /* （連携用）社員名簿用区分 */
     zrnkyksyaskinmeino ,         /* （連携用）契約者索引名番号 */
     zrnsyainnm ,         /* （連携用）社員名 */
     zrnkanjisyainnm ,         /* （連携用）漢字社員名 */
     zrnsyainseiymd ,         /* （連携用）社員生年月日 */
     zrntsinkihontikucd ,         /* （連携用）通信先基本地区コード */
     zrnkanjitsinkaiadr ,         /* （連携用）漢字通信先下位住所 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrntksyuannaikykkbn ,         /* （連携用）特殊案内契約区分 */
     zrnsouhuhunoukbn ,         /* （連携用）送付不能区分 */
     zrnsyainmeibos ,         /* （連携用）社員名簿用Ｓ */
     zrnsyainmeibop ,         /* （連携用）社員名簿用Ｐ */
     zrnsyainmeibosyouyop ,         /* （連携用）社員名簿用賞与払Ｐ */
     zrnyofuritysytzumihyouji ,         /* （連携用）預振抽出済表示 */
     zrnnayosekihontikucd ,         /* （連携用）名寄せ用基本地区コード */
     zrnyobiv10           /* （連携用）予備項目Ｖ１０ */
FROM ZT_SyainMeiboRn_Z;