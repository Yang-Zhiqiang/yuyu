CREATE VIEW ZT_AcsAdrNmRn AS SELECT
     zrnkihontikucd ,         /* （連携用）基本地区コード */
     zrnkihontikucdsyoumetukbn ,         /* （連携用）基本地区コード消滅理由区分 */
     zrnkjadr ,         /* （連携用）漢字住所 */
     zrnkjtodouhukennmketasuu ,         /* （連携用）漢字都道府県名桁数 */
     zrnkjsikugunnmketasuu ,         /* （連携用）漢字市区郡名桁数 */
     zrnkjsikutyousonnmketasuu ,         /* （連携用）漢字市区町村名桁数 */
     zrnkjtyousonnmketasuu ,         /* （連携用）漢字町村名桁数 */
     zrnkjkyoutotuusyounmketasuu ,         /* （連携用）漢字京都市内通称町名桁数 */
     zrnkjadrketasuu ,         /* （連携用）漢字住所桁数 */
     zrnknadr ,         /* （連携用）カナ住所 */
     zrnkntodouhukennmketasuu ,         /* （連携用）カナ都道府県名桁数 */
     zrnknsikugunnmketasuu ,         /* （連携用）カナ市区郡名桁数 */
     zrnknsikutyousonnmketasuu ,         /* （連携用）カナ市区町村名桁数 */
     zrnkntyousonnmketasuu ,         /* （連携用）カナ町村名桁数 */
     zrnknkyoutotuusyounmketasuu ,         /* （連携用）カナ京都市内通称町名桁数 */
     zrnknadrketasuu ,         /* （連携用）カナ住所桁数 */
     zrntodouhukencd ,         /* （連携用）都道府県コード */
     zrngyouseikukakucd ,         /* （連携用）行政区画コード */
     zrnikoumaekihontikucd ,         /* （連携用）移行前基本地区コード */
     zrnnewynohyouji ,         /* （連携用）新郵便番号表示 */
     zrnyobiv14           /* （連携用）予備項目Ｖ１４ */
FROM ZT_AcsAdrNmRn_Z;