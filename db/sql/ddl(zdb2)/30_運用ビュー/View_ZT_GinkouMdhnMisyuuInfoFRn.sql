CREATE VIEW ZT_GinkouMdhnMisyuuInfoFRn AS SELECT
     zrnbsydrtencd ,         /* （連携用）募集代理店コード */
     zrnyobiv63 ,         /* （連携用）予備項目Ｖ６３ */
     zrndatakbn ,         /* （連携用）データ区分 */
     zrndatasakuseiymd ,         /* （連携用）データ作成日 */
     zrnhknkaisyacd ,         /* （連携用）保険会社コード */
     zrnhknsyuruicd ,         /* （連携用）保険種類コード */
     zrnsyonosyuban ,         /* （連携用）証券番号主番 */
     zrnsyonoedaban ,         /* （連携用）証券番号枝番 */
     zrnmisyuutatekaekbn ,         /* （連携用）未収立替区分 */
     zrnmisyuutatekaeym ,         /* （連携用）未収立替発生年月 */
     zrnmisyuukg ,         /* （連携用）未収金額 */
     zrnbnkaisuu ,         /* （連携用）分割回数 */
     zrnmisyuujiyuu ,         /* （連携用）未収事由 */
     zrnjikaidatakousinymd ,         /* （連携用）次回データ更新日 */
     zrnikkatubaraikbn ,         /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu ,         /* （連携用）一括払回数 */
     zrnyobiv28 ,         /* （連携用）予備項目Ｖ２８ */
     zrnkosyaareav40           /* （連携用）個社領域Ｖ４０ */
FROM ZT_GinkouMdhnMisyuuInfoFRn_Z;