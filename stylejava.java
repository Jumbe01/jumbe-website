const tabsContainer = document.querySelector('.custom-tabs-accordion')
const tabsHeader = document.querySelectorAll('.custom-tabs-accordion-header')
const tabsBody = document.querySelector('.custom-tabs-accordion-body-container')
 
/**
    * Display Active Tab/Accordion Body
    * @param {string} tab = tab header element
    */
const TabsHeaderActive = function(tab){
    var _target = tab.dataset.target
            tabsContainer.querySelectorAll('.active').forEach( el =>{
                el.classList.remove('active')
            })
            tab.classList.add('active')
            tabsContainer.querySelectorAll('.custom-tabs-accordion-body').forEach(el=>{
                el.style.height = 0
            })
            tabsContainer.querySelector(`[data-tab="${_target}"]`).style.height = tabsContainer.querySelector(`[data-tab="${_target}"]`).scrollHeight + `px`
            tabsContainer.querySelector(`[data-tab="${_target}"]`).classList.add('active')
 
}
tabsHeader.forEach(tab => {
 
        /**
            * Tab/Accordion Header Click Event
            */
        tab.addEventListener('click', function(){
            TabsHeaderActive(tab)
        })
});
 
/**
    * Update Display Format to Tabs or Accordion
    */
const TabsAccordionFormat = function(){
    if(window.innerWidth <= 480){
        tabsBody.querySelectorAll('.custom-tabs-accordion-body').forEach(el=> {
            var dataTab = el.dataset.tab
            var cloneEl = el.cloneNode(true)
            tabsContainer.querySelector(`.custom-tabs-accordion-header[data-target="${dataTab}"]`).after(cloneEl)
            if(cloneEl.classList.contains('active') == true)
            cloneEl.style.height = 'auto';
            el.remove()
        })
    }else{
        document.querySelector('.custom-tabs-accordion-header-container').querySelectorAll('.custom-tabs-accordion-body').forEach(el=> {
            // var dataTab = el.dataset.tab
            var cloneEl = el.cloneNode(true)
            tabsBody.appendChild(cloneEl)
            if(cloneEl.classList.contains('active') == true)
            cloneEl.style.height = 'auto';
            el.remove()
        })
 
    }
}
TabsAccordionFormat()
 
/**
    * Event when the window screen is resized
    */
window.onresize = function(){
    TabsAccordionFormat()
}