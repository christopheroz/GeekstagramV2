var panels = document.querySelectorAll('.panel');
[].slice.call(panels).forEach(function(panel) {
    var randomNumber = Math.floor((Math.random() * 4) + 1);
    var panelFooter = panel.querySelector('.panel-footer');
    var className = 'test';
    switch(randomNumber) {
        case 1: className = 'panel-danger';
            break;
        case 2: className = 'panel-success';
            break;
        case 3: className = 'panel-info';
            break;
        case 4: className = 'panel-warning';
            break;
    }

    panel.classList.add(className);
    if (panelFooter !== null) {
        panelFooter.classList.add(className);
    }
});