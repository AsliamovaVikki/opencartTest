# Repository auto test tasks

## Test #0
- [ ] Go to the https://demo.opencart.com/
- [ ] Click on 'Brands' at the bottom of the page
- [ ] Check that following brands exists on page [Apple,Canon,Hewlett-Packard,HTC,Palm,Sony]
---
## Test #1
- [ ] Go to the https://demo.opencart.com/
- [ ] Click on 'My account' icon
- [ ] Click on 'Register' button
- [ ] Fill form with valid values
- [ ] Check that you was redirected to new page with title 'Welcome'
---
## Test #2
- [ ] Go to the https://demo.opencart.com/
- [ ] Hower over Desktops from top menu
- [ ] Click on Show All Desktops
- [ ] Check that value in Show dropdown is 10
- [ ] Check that value in Sort By is Default
- [ ] Check that 10 products display on page
- [ ] Select 25 from Show dropdown
- [ ] Check that 12 products now dispayed
- [ ] Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
---
## Test #3
- [ ] Go to the https://demo.opencart.com/
- [ ] Hower over Desktops from top menu
- [ ] Click on Show All Desktops
- [ ] Select 'Name (A - Z)' from Sort by dropdown
- [ ] Check that products were sorted correctly
- [ ] Select 'Price (Low > High)' from Sort by dropdown
- [ ] Check that products were sorted correctly
---
## Test #4
- [ ] Go to the https://demo.opencart.com/
- [ ] On the main page check that current currency is $ (change to $ id not)
- [ ] Click on the Iphone
- [ ] Check that price 123.20
- [ ] Change currency to euro
- [ ] Check that price 106.04
- [ ] Change currency to Pound Sterling
- [ ] Check that price 95.32
---
## Test #5
- [ ] Go to the https://demo.opencart.com/
- [ ] Click on the Cameras
- [ ] Check that 2 cameras exist on page
- [ ] Check that Canon EOS 5D has old price 122.00
- [ ] Check that Canon EOS 5D has new price 98.00
- [ ] Check that Nikon D300 has ex.rate 80.00
---
## Commit Types
- feat: a new feature.
- fix: a bug fix.
- chore: a routine task or maintenance (e.g., updating dependencies).
- refactor: code changes that neither fix a bug nor add a feature.
- perf: code changes that improve performance.
- test: adding or modifying tests.
- build: changes that affect the build system or external dependencies.
- ci: changes related to CI/CD pipelines and scripts.
- docs: documentation-only changes.
- style: code style changes (e.g., formatting, indentation, missing semicolons) that do not affect functionality.