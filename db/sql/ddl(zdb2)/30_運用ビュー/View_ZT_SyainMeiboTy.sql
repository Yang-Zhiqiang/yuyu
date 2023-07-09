CREATE VIEW ZT_SyainMeiboTy AS SELECT
     ztyhokenkbn ,         /* （中継用）保険区分 */
     ztysyainmeibokbn ,         /* （中継用）社員名簿用区分 */
     ztykyksyaskinmeino ,         /* （中継用）契約者索引名番号 */
     ztysyainnm ,         /* （中継用）社員名 */
     ztykanjisyainnm ,         /* （中継用）漢字社員名 */
     ztysyainseiymd ,         /* （中継用）社員生年月日 */
     ztytsinkihontikucd ,         /* （中継用）通信先基本地区コード */
     ztykanjitsinkaiadr ,         /* （中継用）漢字通信先下位住所 */
     ztysyono ,         /* （中継用）証券番号 */
     ztyhknsyukigou ,         /* （中継用）保険種類記号 */
     ztyannaifuyouriyuukbn ,         /* （中継用）案内不要理由区分 */
     ztyhrkkaisuukbn ,         /* （中継用）払込回数区分 */
     ztyhrkkeirokbn ,         /* （中継用）払込経路区分 */
     ztytksyuannaikykkbn ,         /* （中継用）特殊案内契約区分 */
     ztysouhuhunoukbn ,         /* （中継用）送付不能区分 */
     ztysyainmeibos ,         /* （中継用）社員名簿用Ｓ */
     ztysyainmeibop ,         /* （中継用）社員名簿用Ｐ */
     ztysyainmeibosyouyop ,         /* （中継用）社員名簿用賞与払Ｐ */
     ztyyofuritysytzumihyouji ,         /* （中継用）預振抽出済表示 */
     ztynayosekihontikucd ,         /* （中継用）名寄せ用基本地区コード */
     ztyyobiv10 ,         /* （中継用）予備項目Ｖ１０ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SyainMeiboTy_Z;