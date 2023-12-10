**ER WIP ATM!!**

## Info
Dette er min egne wiki-side. Den bruker rammeverket Astro, med temaet [Astro Design System](https://github.com/jordienr/astro-design-system), til å generere en statisk side.

Grunnen til at jeg valgte Astro var fordi jeg ville ha en nettside som kunne holde på masse markdown-filer, og unngå bruk av databaser, samt. at jeg har i det siste begynt å skrive om nettsiden min til Astro så hvorfor ikke gjøre det samme med wikien. I disse markdown-filene vil da all wiki-informasjonen stå.

Jeg ville også at nettsiden skulle oppdateres hver gang jeg oppdaterer repoet så derfor har jeg lagt inn Github Actions også for at den skal bygge denne siden.

## Hvordan sette opp lokalt
```
git clone https://github.com/SindreKjelsrud/sidskipedia.git
git submodule update --init --recursive
```

For å kjøre den må du skrive `yarn dev`. Dette er det samme som livereload, hvor nettsiden på din lokale server oppdaterer seg umiddelbart etter en endring i filene.

## Misc.
### Useful links
- [Astro Design System](https://github.com/jordienr/astro-design-system) template was made by **[@jordienr](https://twitter.com/jordienr)** for personal and commercial use.
